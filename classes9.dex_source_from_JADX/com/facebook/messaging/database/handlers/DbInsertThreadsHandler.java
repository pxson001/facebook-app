package com.facebook.messaging.database.handlers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.database.sqlite.SqlCaseExpression.SqlCaseExpressionBuilder;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.database.sqlite.SqlListExpression;
import com.facebook.database.sqlite.SqlUpdateExpression;
import com.facebook.database.sqlite.SqlUpdateExpression.SqlUpdateExpressionBuilder;
import com.facebook.database.sqlite.SqlWhenThenExpression.SqlWhenThenExpressionBuilder;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.StitchOperationType;
import com.facebook.messaging.cache.ThreadSummaryStitching;
import com.facebook.messaging.chatheads.ipc.ChatHeadsMuteStateManager;
import com.facebook.messaging.database.serialization.DbAppAttributionSerialization;
import com.facebook.messaging.database.serialization.DbAttachmentSerialization;
import com.facebook.messaging.database.serialization.DbDraftSerialization;
import com.facebook.messaging.database.serialization.DbMediaResourceSerialization;
import com.facebook.messaging.database.serialization.DbMessageClientTagsSerialization;
import com.facebook.messaging.database.serialization.DbMessageCustomizationSerialization;
import com.facebook.messaging.database.serialization.DbMessageMetadataSerialization;
import com.facebook.messaging.database.serialization.DbMessagePlatformMetadataSerialization;
import com.facebook.messaging.database.serialization.DbParticipantsSerialization;
import com.facebook.messaging.database.serialization.DbPaymentRequestDataSerialization;
import com.facebook.messaging.database.serialization.DbPaymentTransactionDataSerialization;
import com.facebook.messaging.database.serialization.DbSentShareAttachmentSerialization;
import com.facebook.messaging.database.serialization.DbSharesSerialization;
import com.facebook.messaging.database.serialization.DbThreadGameDataSerialization;
import com.facebook.messaging.database.serialization.DbThreadRtcCallInfoSerialization;
import com.facebook.messaging.database.threads.DbFolders;
import com.facebook.messaging.database.threads.DbMessageCache;
import com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil;
import com.facebook.messaging.database.threads.DbThreadEventRemindersUtil;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil.ParticipantType;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart.FoldersTable.Columns;
import com.facebook.messaging.media.download.MediaDownloadManager;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.AdProperties;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.EventReminderProperties;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.MessagesCollectionMerger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.prefs.notifications.GlobalNotificationPrefsSyncUtil;
import com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil;
import com.facebook.messaging.service.model.AddPinnedThreadParams;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.service.model.DeliveredReceiptParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.facebook.messaging.service.model.UnpinThreadParams;
import com.facebook.messaging.service.model.UpdateFolderCountsParams;
import com.facebook.messaging.service.model.UpdatePinnedThreadsParams;
import com.facebook.messaging.xma.XMASerialization;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mechanism_messenger_ride_service_button */
public class DbInsertThreadsHandler {
    private static volatile DbInsertThreadsHandler f10350J;
    private static final Class<?> f10351a = DbInsertThreadsHandler.class;
    private final MessageUtil f10352A;
    private final AbstractFbErrorReporter f10353B;
    private final Provider<Boolean> f10354C;
    private final MediaDownloadManager f10355D;
    private final Clock f10356E;
    private final DbAppAttributionSerialization f10357F;
    private final XMASerialization f10358G;
    private final ChatHeadsMuteStateManager f10359H;
    private final FbSharedPreferences f10360I;
    private final Provider<ThreadsDatabaseSupplier> f10361b;
    private final Provider<DbThreadsPropertyUtil> f10362c;
    private final DbFetchThreadHandler f10363d;
    private final DbFetchThreadsHandler f10364e;
    private final DbInsertThreadUsersHandler f10365f;
    private final DbParticipantsSerialization f10366g;
    private final DbAttachmentSerialization f10367h;
    private final DbSharesSerialization f10368i;
    private final DbSentShareAttachmentSerialization f10369j;
    private final DbMessageClientTagsSerialization f10370k;
    private final DbMessageCustomizationSerialization f10371l;
    private final Lazy<DbMessageMetadataSerialization> f10372m;
    private final Lazy<DbMessagePlatformMetadataSerialization> f10373n;
    private final DbMediaResourceSerialization f10374o;
    private final DbDraftSerialization f10375p;
    private final DbPaymentTransactionDataSerialization f10376q;
    private final DbPaymentRequestDataSerialization f10377r;
    private final DbThreadGameDataSerialization f10378s;
    private final DbThreadRtcCallInfoSerialization f10379t;
    private final FbObjectMapper f10380u;
    private final MessagesCollectionMerger f10381v;
    private final Provider<UserKey> f10382w;
    private final ThreadSummaryStitching f10383x;
    private final Provider<ThreadNotificationPrefsSyncUtil> f10384y;
    private final GlobalNotificationPrefsSyncUtil f10385z;

    /* compiled from: mechanism_messenger_ride_service_button */
    public enum MarkThreadReadResult {
        THREAD_MARKED_READ,
        THREAD_NOT_MARKED_READ,
        THREAD_NOT_FOUND
    }

    public static com.facebook.messaging.database.handlers.DbInsertThreadsHandler m10941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10350J;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbInsertThreadsHandler.class;
        monitor-enter(r1);
        r0 = f10350J;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10969b(r0);	 Catch:{ all -> 0x0035 }
        f10350J = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10350J;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbInsertThreadsHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbInsertThreadsHandler");
    }

    private static DbInsertThreadsHandler m10969b(InjectorLike injectorLike) {
        return new DbInsertThreadsHandler(IdBasedProvider.a(injectorLike, 7815), IdBasedProvider.a(injectorLike, 7808), DbFetchThreadHandler.a(injectorLike), DbFetchThreadsHandler.m10920a(injectorLike), DbInsertThreadUsersHandler.m10937a(injectorLike), DbParticipantsSerialization.a(injectorLike), DbAttachmentSerialization.a(injectorLike), DbSharesSerialization.a(injectorLike), DbSentShareAttachmentSerialization.a(injectorLike), DbMessageClientTagsSerialization.a(injectorLike), DbMessageCustomizationSerialization.a(injectorLike), IdBasedLazy.a(injectorLike, 7800), IdBasedLazy.a(injectorLike, 7801), DbMediaResourceSerialization.a(injectorLike), DbDraftSerialization.a(injectorLike), DbPaymentTransactionDataSerialization.a(injectorLike), DbPaymentRequestDataSerialization.a(injectorLike), DbThreadGameDataSerialization.a(injectorLike), DbThreadRtcCallInfoSerialization.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), MessagesCollectionMerger.a(injectorLike), IdBasedProvider.a(injectorLike, 3598), ThreadSummaryStitching.m10173a(injectorLike), IdBasedProvider.a(injectorLike, 8302), GlobalNotificationPrefsSyncUtil.m16387a(injectorLike), MessageUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), MediaDownloadManager.m12170a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DbAppAttributionSerialization.a(injectorLike), XMASerialization.a(injectorLike), ChatHeadsMuteStateManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public final void m11007a(DeliveredReceiptParams deliveredReceiptParams) {
        UserKey userKey = deliveredReceiptParams.f17038b;
        String str = deliveredReceiptParams.f17039c;
        m10959a(deliveredReceiptParams.f17037a, userKey, false, deliveredReceiptParams.f17040d, str, deliveredReceiptParams.f17041e);
    }

    @Inject
    DbInsertThreadsHandler(Provider<ThreadsDatabaseSupplier> provider, Provider<DbThreadsPropertyUtil> provider2, DbFetchThreadHandler dbFetchThreadHandler, DbFetchThreadsHandler dbFetchThreadsHandler, DbInsertThreadUsersHandler dbInsertThreadUsersHandler, DbParticipantsSerialization dbParticipantsSerialization, DbAttachmentSerialization dbAttachmentSerialization, DbSharesSerialization dbSharesSerialization, DbSentShareAttachmentSerialization dbSentShareAttachmentSerialization, DbMessageClientTagsSerialization dbMessageClientTagsSerialization, DbMessageCustomizationSerialization dbMessageCustomizationSerialization, Lazy<DbMessageMetadataSerialization> lazy, Lazy<DbMessagePlatformMetadataSerialization> lazy2, DbMediaResourceSerialization dbMediaResourceSerialization, DbDraftSerialization dbDraftSerialization, DbPaymentTransactionDataSerialization dbPaymentTransactionDataSerialization, DbPaymentRequestDataSerialization dbPaymentRequestDataSerialization, DbThreadGameDataSerialization dbThreadGameDataSerialization, DbThreadRtcCallInfoSerialization dbThreadRtcCallInfoSerialization, FbObjectMapper fbObjectMapper, MessagesCollectionMerger messagesCollectionMerger, Provider<UserKey> provider3, ThreadSummaryStitching threadSummaryStitching, Provider<ThreadNotificationPrefsSyncUtil> provider4, GlobalNotificationPrefsSyncUtil globalNotificationPrefsSyncUtil, MessageUtil messageUtil, FbErrorReporter fbErrorReporter, Provider<Boolean> provider5, MediaDownloadManager mediaDownloadManager, Clock clock, DbAppAttributionSerialization dbAppAttributionSerialization, XMASerialization xMASerialization, ChatHeadsMuteStateManager chatHeadsMuteStateManager, FbSharedPreferences fbSharedPreferences) {
        this.f10361b = provider;
        this.f10362c = provider2;
        this.f10363d = dbFetchThreadHandler;
        this.f10364e = dbFetchThreadsHandler;
        this.f10365f = dbInsertThreadUsersHandler;
        this.f10366g = dbParticipantsSerialization;
        this.f10367h = dbAttachmentSerialization;
        this.f10368i = dbSharesSerialization;
        this.f10369j = dbSentShareAttachmentSerialization;
        this.f10370k = dbMessageClientTagsSerialization;
        this.f10371l = dbMessageCustomizationSerialization;
        this.f10372m = lazy;
        this.f10373n = lazy2;
        this.f10374o = dbMediaResourceSerialization;
        this.f10375p = dbDraftSerialization;
        this.f10376q = dbPaymentTransactionDataSerialization;
        this.f10377r = dbPaymentRequestDataSerialization;
        this.f10378s = dbThreadGameDataSerialization;
        this.f10379t = dbThreadRtcCallInfoSerialization;
        this.f10380u = fbObjectMapper;
        this.f10381v = messagesCollectionMerger;
        this.f10382w = provider3;
        this.f10383x = threadSummaryStitching;
        this.f10384y = provider4;
        this.f10385z = globalNotificationPrefsSyncUtil;
        this.f10352A = messageUtil;
        this.f10353B = fbErrorReporter;
        this.f10354C = provider5;
        this.f10355D = mediaDownloadManager;
        this.f10356E = clock;
        this.f10357F = dbAppAttributionSerialization;
        this.f10358G = xMASerialization;
        this.f10359H = chatHeadsMuteStateManager;
        this.f10360I = fbSharedPreferences;
    }

    public final void m11011a(FetchThreadListResult fetchThreadListResult) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, -338352473);
        try {
            DbThreadsPropertyUtil dbThreadsPropertyUtil = (DbThreadsPropertyUtil) this.f10362c.get();
            a.delete("folders", null, null);
            a.delete("pinned_threads", null, null);
            dbThreadsPropertyUtil.a(DbThreadProperties.f10469b, 0);
            dbThreadsPropertyUtil.a(DbThreadProperties.f10470c, 0);
            a.delete("threads", null, null);
            Expression a2 = SqlExpression.a("msg_type", new String[]{Integer.toString(MessageType.PENDING_SEND.dbKeyValue), Integer.toString(MessageType.FAILED_SEND.dbKeyValue)});
            Builder builder = ImmutableList.builder();
            ImmutableList b = fetchThreadListResult.f17133c.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                builder.c(((ThreadSummary) b.get(i)).a.g());
            }
            Expression a3 = SqlExpression.a("thread_key", builder.b());
            a3 = SqlExpression.a(SqlExpression.a(new Expression[]{a2, a3}));
            a.delete("messages", a3.a(), a3.b());
            m11025b(fetchThreadListResult);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1116880085);
        }
    }

    public final void m11025b(FetchThreadListResult fetchThreadListResult) {
        int i = 0;
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, -1813067337);
        try {
            long j = fetchThreadListResult.f17142l;
            FolderName folderName = fetchThreadListResult.f17132b;
            DbThreadsPropertyUtil dbThreadsPropertyUtil = (DbThreadsPropertyUtil) this.f10362c.get();
            dbThreadsPropertyUtil.b(DbThreadProperties.m11128a(folderName), j);
            dbThreadsPropertyUtil.b(DbThreadProperties.m11129b(folderName), fetchThreadListResult.f17140j);
            dbThreadsPropertyUtil.b(DbThreadProperties.m11130c(folderName), false);
            if (fetchThreadListResult.f17139i) {
                ThreadKey a2;
                ImmutableList immutableList = fetchThreadListResult.f17135e;
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a2 = this.f10363d.a((String) immutableList.get(i2));
                    if (a2 != null) {
                        m10973b(a2);
                    }
                }
                ImmutableList immutableList2 = fetchThreadListResult.f17136f;
                int size2 = immutableList2.size();
                while (i < size2) {
                    a2 = this.f10363d.a((String) immutableList2.get(i));
                    if (a2 != null) {
                        m10953a(folderName, a2);
                    }
                    i++;
                }
            } else {
                m10951a(folderName);
            }
            m10952a(folderName, fetchThreadListResult.f17137g);
            m10954a(folderName, fetchThreadListResult.f17133c);
            ThreadsCollection threadsCollection = fetchThreadListResult.f17133c;
            if (fetchThreadListResult.f17139i) {
                m10981c(threadsCollection.b(), j);
            } else {
                m10978b(threadsCollection.b(), j);
            }
            this.f10365f.m10939a(fetchThreadListResult.f17134d);
            if (fetchThreadListResult.f17138h != null) {
                this.f10360I.edit().a(MessagingPrefKeys.av, fetchThreadListResult.f17138h.a()).commit();
                this.f10385z.m16392b();
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -1578762488);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 2124472708);
        }
    }

    public final void m11016a(SearchThreadNameAndParticipantsResult searchThreadNameAndParticipantsResult, long j) {
        ((DbThreadsPropertyUtil) this.f10362c.get()).b(DbThreadProperties.f10471d, j);
        m10978b(searchThreadNameAndParticipantsResult.f17294a.c, j);
        this.f10365f.m10939a((List) searchThreadNameAndParticipantsResult.f17295b);
    }

    public final void m11021a(ImmutableList<ThreadSummary> immutableList, long j) {
        m10978b((ImmutableList) immutableList, j);
    }

    public final void m11010a(FetchPinnedThreadsResult fetchPinnedThreadsResult, long j) {
        Object obj;
        if (fetchPinnedThreadsResult.f17102d && fetchPinnedThreadsResult.f17101c.isEmpty()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            DbThreadsPropertyUtil dbThreadsPropertyUtil = (DbThreadsPropertyUtil) this.f10362c.get();
            dbThreadsPropertyUtil.b(DbThreadProperties.f10469b, fetchPinnedThreadsResult.f17103e);
            dbThreadsPropertyUtil.b(DbThreadProperties.f10470c, fetchPinnedThreadsResult.f17100b);
            Builder builder = ImmutableList.builder();
            ImmutableList immutableList = fetchPinnedThreadsResult.f17101c;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(((ThreadSummary) immutableList.get(i)).a);
            }
            m10964a(builder.b());
            m10978b(fetchPinnedThreadsResult.f17101c, j);
        }
    }

    private void m10978b(ImmutableList<ThreadSummary> immutableList, long j) {
        m10962a((ImmutableList) immutableList, j, false);
    }

    private void m10981c(ImmutableList<ThreadSummary> immutableList, long j) {
        m10962a((ImmutableList) immutableList, j, true);
    }

    private void m10962a(ImmutableList<ThreadSummary> immutableList, long j, boolean z) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, 1219617547);
        try {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
                m10961a(threadSummary, j);
                if (z) {
                    FetchThreadResult a2 = this.f10363d.a(threadSummary.a, 0);
                    if (a2.f17179b.l) {
                        if (threadSummary.e > a2.f17180c.e) {
                            m10980c(threadSummary.a);
                        }
                    }
                }
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1939028697);
        }
    }

    final void m11009a(FetchMoreThreadsResult fetchMoreThreadsResult) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, -197303054);
        try {
            long j = fetchMoreThreadsResult.f17093e;
            ThreadsCollection threadsCollection = fetchMoreThreadsResult.f17091c;
            m10954a(fetchMoreThreadsResult.f17090b, fetchMoreThreadsResult.f17091c);
            ImmutableList b = threadsCollection.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                m10961a((ThreadSummary) b.get(i), j);
            }
            if (fetchMoreThreadsResult.f17092d != null) {
                this.f10365f.m10939a(fetchMoreThreadsResult.f17092d);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -1243451680);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 1987121971);
        }
    }

    public final ThreadSummary m10989a(ThreadKey threadKey, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thread_key", threadKey.g());
        contentValues.put("name", str);
        ((ThreadsDatabaseSupplier) this.f10361b.get()).a().update("threads", contentValues, "thread_key=?", new String[]{threadKey.g()});
        return this.f10363d.a(threadKey, 0).f17180c;
    }

    public final ThreadSummary m10990a(ThreadKey threadKey, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thread_key", threadKey.g());
        contentValues.put("pic_hash", str);
        contentValues.put("pic", str2);
        ((ThreadsDatabaseSupplier) this.f10361b.get()).a().update("threads", contentValues, "thread_key=?", new String[]{threadKey.g()});
        return this.f10363d.a(threadKey, 0).f17180c;
    }

    public final ThreadSummary m10994a(ThreadSummary threadSummary, List<ThreadParticipant> list, List<User> list2) {
        this.f10365f.m10939a((List) list2);
        List<ThreadParticipant> a = Lists.a(threadSummary.h.size());
        List a2 = Lists.a(threadSummary.i.size());
        a.addAll(threadSummary.h);
        a2.addAll(threadSummary.i);
        Set a3 = Sets.a();
        for (ThreadParticipant b : a) {
            a3.add(b.b());
        }
        for (ThreadParticipant b2 : list) {
            ImmutableList immutableList = threadSummary.i;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (threadParticipant.b().equals(b2.b())) {
                    a2.remove(threadParticipant);
                }
            }
            if (!a3.contains(b2.b())) {
                a.add(b2);
            }
        }
        m10965a((List) a, a2, threadSummary.a);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    public final ThreadSummary m10993a(ThreadSummary threadSummary, UserKey userKey) {
        List a = Lists.a();
        List a2 = Lists.a();
        a2.addAll(threadSummary.i);
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.b().equals(userKey)) {
                a2.add(threadParticipant);
            } else {
                a.add(threadParticipant);
            }
        }
        m10965a(a, a2, threadSummary.a);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    public final ThreadSummary m10995a(ThreadSummary threadSummary, Set<UserKey> set) {
        m10965a(m10950a(threadSummary.h, (Set) set, true), m10950a(threadSummary.i, (Set) set, true), threadSummary.a);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    public final ThreadSummary m11023b(ThreadSummary threadSummary, Set<UserKey> set) {
        m10965a(m10950a(threadSummary.h, (Set) set, false), m10950a(threadSummary.i, (Set) set, false), threadSummary.a);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    private static List<ThreadParticipant> m10950a(List<ThreadParticipant> list, Set<UserKey> set, boolean z) {
        List<ThreadParticipant> arrayList = new ArrayList();
        for (ThreadParticipant threadParticipant : list) {
            if (set.contains(threadParticipant.b())) {
                ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
                threadParticipantBuilder.a(threadParticipant);
                threadParticipantBuilder.e = z;
                arrayList.add(threadParticipantBuilder.f());
            } else {
                arrayList.add(threadParticipant);
            }
        }
        return arrayList;
    }

    private void m10965a(List<ThreadParticipant> list, List<ThreadParticipant> list2, ThreadKey threadKey) {
        DbThreadParticipantsUtil.m11122a(((ThreadsDatabaseSupplier) this.f10361b.get()).a(), threadKey, (List) list, ParticipantType.PARTICIPANT);
        DbThreadParticipantsUtil.m11122a(((ThreadsDatabaseSupplier) this.f10361b.get()).a(), threadKey, (List) list2, ParticipantType.FORMER_PARTICIPANT);
    }

    public final void m11014a(FetchThreadResult fetchThreadResult, FetchThreadResult fetchThreadResult2) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, -1504873489);
        ThreadSummary threadSummary = fetchThreadResult2.f17180c;
        try {
            ThreadKey threadKey = threadSummary.a;
            if (!(fetchThreadResult == null || !fetchThreadResult.f17179b.l || fetchThreadResult2.f17181d == null || this.f10381v.c(fetchThreadResult2.f17181d, fetchThreadResult.f17181d))) {
                a.delete("messages", "thread_key=?", new String[]{threadKey.g()});
            }
            threadSummary = ThreadSummary.newBuilder().a(threadSummary).i(threadSummary.c).f(true).V();
            m10960a(threadSummary);
            m10961a(threadSummary, fetchThreadResult2.f17183f);
            if (fetchThreadResult2.f17181d != null) {
                long j;
                m10948a(fetchThreadResult2.f17181d);
                ImmutableList b = fetchThreadResult2.f17181d.b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    Message message = (Message) b.get(i);
                    if (m10984e(message)) {
                        j = message.c;
                        break;
                    }
                }
                j = -1;
                if (j != -1) {
                    m10974b(threadKey, j);
                }
            }
            if (fetchThreadResult2.f17182e != null) {
                this.f10365f.m10939a(fetchThreadResult2.f17182e);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -613495220);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 1366801644);
        }
    }

    public final void m11012a(FetchThreadResult fetchThreadResult) {
        FetchThreadResult a = this.f10363d.a(fetchThreadResult.f17180c.a, 3);
        if (!a.f17179b.l) {
            a = null;
        }
        m11014a(a, fetchThreadResult);
    }

    public final NewMessageResult m10998a(NewMessageResult newMessageResult, long j) {
        return m10999a(newMessageResult, j, true);
    }

    public final NewMessageResult m10999a(NewMessageResult newMessageResult, long j, boolean z) {
        TracerDetour.a("DbInsertThreadsHandler.handleNewMessageResult", -2074892369);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(a, 1604987459);
            try {
                Message c = newMessageResult.m17162c();
                if (c == null) {
                    SQLiteDetour.b(a, 1604987459);
                    return newMessageResult;
                }
                ThreadKey threadKey = c.b;
                Message b = this.f10363d.b(c.a);
                if (b == null && MessageUtil.O(c)) {
                    b = this.f10363d.c(c.n);
                }
                if (!(c.d != 0 || b == null || b.d == 0)) {
                    c = Message.newBuilder().a(c).b(b.d).R();
                }
                if (c.q != ChannelSource.C2DM || b == null) {
                    if ((MessageUtil.c(c) || !c.o) && newMessageResult.m17163d() != null) {
                        m10948a(newMessageResult.m17163d());
                    } else if (m10943a(c, z) == null) {
                        m10956a(c, j, newMessageResult.b());
                    }
                    if (m10984e(c)) {
                        m10974b(threadKey, c.c);
                    } else {
                        newMessageResult.m17162c();
                        this.f10355D.m12179a(ImmutableList.of(c));
                    }
                    newMessageResult = m10947a(threadKey, newMessageResult);
                    if (newMessageResult.m17162c() == null && !m10984e(c)) {
                        this.f10353B.a("handleNewMessageResult_null_message", "refetchMostRecentMessages returned null new message");
                    }
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, 809553721);
                    TracerDetour.a(640470075);
                    return newMessageResult;
                }
                SQLiteDetour.b(a, -1328375308);
                TracerDetour.a(2038891737);
                return null;
            } finally {
                SQLiteDetour.b(a, -705275420);
            }
        } finally {
            TracerDetour.a(1238038241);
        }
    }

    public final Message m10987a(Message message, long j) {
        Throwable th;
        TracerDetour.a("DbInsertThreadsHandler.handleSentMessage", -1207042996);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            Message c = this.f10363d.c(message.n);
            if (c == null) {
                this.f10353B.a("delta_sent_message_handling_error", "Received DeltaSentMessage for message that is not in the db with expected offlineThreadingId. Expected offlineThreadingId " + message.n);
                TracerDetour.a(-1468728425);
                return message;
            } else if (c.o) {
                if (message.d == 0 && c.d != 0) {
                    message = Message.newBuilder().a(message).b(c.d).R();
                }
                SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
                try {
                    SQLiteDetour.a(a, 284922063);
                    Message a2 = m10942a(message, c);
                    m10963a(c.a);
                    m10983d(a2);
                    m10956a(a2, j, this.f10356E.a());
                    m10974b(a2.b, a2.c);
                    a.setTransactionSuccessful();
                    if (a != null) {
                        try {
                            SQLiteDetour.b(a, 117808528);
                        } catch (Throwable th2) {
                            TracerDetour.a(1017858961);
                        }
                    }
                    TracerDetour.a(-1043056412);
                    return a2;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = a;
                    if (sQLiteDatabase != null) {
                        SQLiteDetour.b(sQLiteDatabase, 1987661225);
                    }
                    throw th;
                }
            } else {
                this.f10353B.a("delta_sent_message_handling_error", "Received DeltaSentMessage for message previously marked as authoritative");
                TracerDetour.a(1631040060);
                return message;
            }
        } catch (Throwable th4) {
            th = th4;
            if (sQLiteDatabase != null) {
                SQLiteDetour.b(sQLiteDatabase, 1987661225);
            }
            throw th;
        }
    }

    private NewMessageResult m10947a(ThreadKey threadKey, NewMessageResult newMessageResult) {
        TracerDetour.a("DbInsertThreadsHandler.refetchMostRecentMessages", -1080037942);
        try {
            Message c = newMessageResult.m17162c();
            MessagesCollection messagesCollection = this.f10363d.a(threadKey, c.c, -1, 100).f17072c;
            Message b = this.f10363d.b(c.a);
            if (b == null) {
                b = this.f10363d.c(c.n);
            }
            NewMessageResult newMessageResult2 = new NewMessageResult(newMessageResult.a(), b, messagesCollection, this.f10363d.a(threadKey, 0).f17180c, newMessageResult.b());
            return newMessageResult2;
        } finally {
            int i = -37763240;
            TracerDetour.a(-37763240);
        }
    }

    private void m10956a(Message message, long j, long j2) {
        FetchThreadResult a = this.f10363d.a(message.b, 1);
        if (a.f17180c != null) {
            ThreadSummary a2 = this.f10383x.m10183a(a.f17180c, message, a.f17181d, j, StitchOperationType.MESSAGE_ADDED);
            m10960a(a2);
            m10961a(a2, j2);
        }
    }

    public final void m11000a(Message message) {
        TracerDetour.a("DbInsertThreadsHandler.handleInsertLocalAdminMessage", 569758571);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(a, -694641523);
            try {
                m10979c(message);
                m10956a(message, -1, message.c);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, r0);
            } finally {
                SQLiteDetour.b(a, 868931207);
            }
        } finally {
            TracerDetour.a(326458523);
        }
    }

    final void m11024b(Message message) {
        TracerDetour.a("DbInsertThreadsHandler.handleInsertPendingOrFailedSentMessage", -1745591145);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(a, -1033483136);
            try {
                int a2 = ThreadSummaryStitching.m10179a(message, this.f10363d.c(message.n));
                if (a2 == 0) {
                    SQLiteDetour.b(a, a2);
                    return;
                }
                m10979c(message);
                FetchThreadResult a3 = this.f10363d.a(message.b, 1);
                if (a3.f17180c != null) {
                    ThreadSummary a4 = this.f10383x.m10182a(a3.f17180c, message, -1, StitchOperationType.MESSAGE_ADDED);
                    m10960a(a4);
                    m10961a(a4, a3.f17183f);
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 2095410258);
                TracerDetour.a(526124260);
            } finally {
                SQLiteDetour.b(a, -1056744765);
            }
        } finally {
            TracerDetour.a(1607244926);
        }
    }

    public final void m11002a(ThreadKey threadKey, MessageDraft messageDraft) {
        TracerDetour.a("DbInsertThreadsHandler.handleUpdateDraft", -1640679154);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("draft", this.f10375p.a(messageDraft));
            a.update("threads", contentValues, "thread_key=?", new String[]{threadKey.g()});
        } finally {
            TracerDetour.a(534982978);
        }
    }

    final void m11013a(FetchThreadResult fetchThreadResult, FetchMoreMessagesResult fetchMoreMessagesResult) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, 1905310862);
        try {
            if (this.f10381v.c(fetchThreadResult.f17181d, fetchMoreMessagesResult.f17072c)) {
                m10948a(fetchMoreMessagesResult.f17072c);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 1809711243);
                return;
            }
            SQLiteDetour.b(a, 361452367);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -1778705123);
        }
    }

    final void m11008a(FetchMoreMessagesResult fetchMoreMessagesResult, FetchMoreMessagesResult fetchMoreMessagesResult2) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, 1352141954);
        if (fetchMoreMessagesResult != null) {
            try {
                if (fetchMoreMessagesResult.f17071b.l && !this.f10381v.c(fetchMoreMessagesResult.f17072c, fetchMoreMessagesResult2.f17072c)) {
                    SQLiteDetour.b(a, 1444338878);
                    return;
                }
            } catch (Throwable e) {
                BLog.a(f10351a, "SQLException", e);
                throw e;
            } catch (Throwable th) {
                SQLiteDetour.b(a, -974523383);
            }
        }
        m10948a(fetchMoreMessagesResult2.f17072c);
        a.setTransactionSuccessful();
        SQLiteDetour.b(a, 1674023590);
    }

    public final boolean m11022a(FolderName folderName, long j) {
        FolderCounts b = this.f10364e.m10935b(folderName);
        if (b == null) {
            return false;
        }
        m10952a(folderName, new FolderCounts(b.b, b.c, j, b.e));
        return true;
    }

    public final FolderCounts m10986a(UpdateFolderCountsParams updateFolderCountsParams) {
        FolderCounts folderCounts;
        FolderCounts b = this.f10364e.m10935b(updateFolderCountsParams.f17336a);
        if (b == null) {
            folderCounts = new FolderCounts(updateFolderCountsParams.f17337b, updateFolderCountsParams.f17338c, 0, -1);
        } else {
            folderCounts = new FolderCounts(updateFolderCountsParams.f17337b, updateFolderCountsParams.f17338c, b.d, b.e);
        }
        m10952a(updateFolderCountsParams.f17336a, folderCounts);
        return folderCounts;
    }

    private void m10952a(FolderName folderName, FolderCounts folderCounts) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("folder", folderName.dbName);
        contentValues.put("unread_count", Integer.valueOf(folderCounts.b));
        contentValues.put("unseen_count", Integer.valueOf(folderCounts.c));
        contentValues.put("last_seen_time", Long.valueOf(folderCounts.d));
        contentValues.put("last_action_id", Long.valueOf(folderCounts.e));
        SQLiteDetour.a(1072708416);
        a.replaceOrThrow("folder_counts", null, contentValues);
        SQLiteDetour.a(-1367538575);
    }

    public final void m11015a(MarkThreadsParams markThreadsParams) {
        int i = 0;
        if (!markThreadsParams.f17217c.isEmpty()) {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(a, -1739348640);
            try {
                Mark mark = markThreadsParams.f17215a;
                MarkThreadFields markThreadFields;
                if (mark == Mark.ARCHIVED || mark == Mark.SPAM) {
                    ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
                    ImmutableList immutableList = markThreadsParams.f17217c;
                    int size = immutableList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        markThreadFields = (MarkThreadFields) immutableList.get(i2);
                        if (markThreadFields.f17205b) {
                            Object obj = markThreadFields.f17209f;
                            if (obj == null) {
                                obj = FolderName.INBOX;
                            }
                            builder.a(obj, markThreadFields.f17204a);
                        }
                    }
                    ImmutableListMultimap a2 = builder.a();
                    Iterator it = a2.e().iterator();
                    while (it.hasNext()) {
                        FolderName folderName = (FolderName) it.next();
                        m10955a(folderName, a2.e(folderName));
                    }
                } else if (mark == Mark.READ) {
                    ImmutableList immutableList2 = markThreadsParams.f17217c;
                    int size2 = immutableList2.size();
                    while (i < size2) {
                        markThreadFields = (MarkThreadFields) immutableList2.get(i);
                        if (markThreadFields.f17205b) {
                            this.f10359H.b(markThreadFields.f17204a);
                        }
                        i++;
                    }
                    if (markThreadsParams.f17217c.size() == 1) {
                        m10975b((MarkThreadFields) markThreadsParams.f17217c.get(0));
                    } else {
                        m10976b(markThreadsParams);
                    }
                }
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, 917073729);
            } catch (Throwable e) {
                BLog.a(f10351a, "SQLException", e);
                throw e;
            } catch (Throwable th) {
                SQLiteDetour.b(a, 978780685);
            }
        }
    }

    private void m10976b(MarkThreadsParams markThreadsParams) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        Builder builder = new Builder();
        SqlCaseExpressionBuilder sqlCaseExpressionBuilder = new SqlCaseExpressionBuilder();
        sqlCaseExpressionBuilder.a = "last_read_timestamp_ms";
        SqlCaseExpressionBuilder sqlCaseExpressionBuilder2 = sqlCaseExpressionBuilder;
        sqlCaseExpressionBuilder = new SqlCaseExpressionBuilder();
        sqlCaseExpressionBuilder.a = "unread_message_count";
        SqlCaseExpressionBuilder sqlCaseExpressionBuilder3 = sqlCaseExpressionBuilder;
        SqlCaseExpressionBuilder sqlCaseExpressionBuilder4 = null;
        ImmutableList immutableList = markThreadsParams.f17217c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MarkThreadFields markThreadFields = (MarkThreadFields) immutableList.get(i);
            Expression a2 = SqlExpression.a("thread_key", markThreadFields.f17204a.g());
            long j = markThreadFields.f17205b ? markThreadFields.f17208e : 0;
            SqlWhenThenExpressionBuilder sqlWhenThenExpressionBuilder = new SqlWhenThenExpressionBuilder();
            sqlWhenThenExpressionBuilder.a = a2;
            sqlWhenThenExpressionBuilder = sqlWhenThenExpressionBuilder;
            sqlWhenThenExpressionBuilder.b = Long.toString(j);
            sqlCaseExpressionBuilder2.a(sqlWhenThenExpressionBuilder.a());
            j = markThreadFields.f17205b ? 0 : 1;
            sqlWhenThenExpressionBuilder = new SqlWhenThenExpressionBuilder();
            sqlWhenThenExpressionBuilder.a = a2;
            sqlWhenThenExpressionBuilder = sqlWhenThenExpressionBuilder;
            sqlWhenThenExpressionBuilder.b = Long.toString(j);
            sqlCaseExpressionBuilder3.a(sqlWhenThenExpressionBuilder.a());
            if (markThreadFields.f17207d != -1) {
                if (sqlCaseExpressionBuilder4 == null) {
                    sqlCaseExpressionBuilder4 = new SqlCaseExpressionBuilder();
                    sqlCaseExpressionBuilder4.a = "sequence_id";
                    sqlCaseExpressionBuilder4 = sqlCaseExpressionBuilder4;
                }
                String l = Long.toString(markThreadFields.f17207d);
                SqlWhenThenExpressionBuilder sqlWhenThenExpressionBuilder2 = new SqlWhenThenExpressionBuilder();
                sqlWhenThenExpressionBuilder2.a = a2;
                sqlWhenThenExpressionBuilder2 = sqlWhenThenExpressionBuilder2;
                sqlWhenThenExpressionBuilder2.b = l;
                sqlCaseExpressionBuilder4.a(sqlWhenThenExpressionBuilder2.a());
            }
            builder.c(markThreadFields.f17204a.g());
        }
        SqlListExpression sqlListExpression = new SqlListExpression();
        sqlListExpression.a(sqlCaseExpressionBuilder2.a());
        sqlListExpression.a(sqlCaseExpressionBuilder3.a());
        if (sqlCaseExpressionBuilder4 != null) {
            sqlListExpression.a(sqlCaseExpressionBuilder4.a());
        }
        Expression a3 = SqlExpression.a("thread_key", builder.b());
        SqlUpdateExpressionBuilder sqlUpdateExpressionBuilder = new SqlUpdateExpressionBuilder();
        sqlUpdateExpressionBuilder.a = "threads";
        sqlUpdateExpressionBuilder = sqlUpdateExpressionBuilder;
        sqlUpdateExpressionBuilder.b = sqlListExpression;
        SqlUpdateExpressionBuilder sqlUpdateExpressionBuilder2 = sqlUpdateExpressionBuilder;
        sqlUpdateExpressionBuilder2.c = a3;
        SqlUpdateExpression a4 = sqlUpdateExpressionBuilder2.a();
        a.rawQuery(a4.a(), a4.b());
    }

    private void m10975b(MarkThreadFields markThreadFields) {
        long j = 0;
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        ContentValues contentValues = new ContentValues();
        long j2 = markThreadFields.f17205b ? markThreadFields.f17208e : 0;
        if (!markThreadFields.f17205b) {
            j = 1;
        }
        contentValues.put("last_read_timestamp_ms", Long.valueOf(j2));
        contentValues.put("unread_message_count", Long.valueOf(j));
        if (markThreadFields.f17207d != -1) {
            contentValues.put("sequence_id", Long.valueOf(markThreadFields.f17207d));
        }
        a.update("threads", contentValues, "thread_key=?", new String[]{markThreadFields.f17204a.g()});
    }

    public final MarkThreadReadResult m10985a(MarkThreadFields markThreadFields) {
        ThreadSummary threadSummary = this.f10363d.a(markThreadFields.f17204a, 0).f17180c;
        if (threadSummary == null) {
            return MarkThreadReadResult.THREAD_NOT_FOUND;
        }
        if (markThreadFields.f17208e < threadSummary.k) {
            return MarkThreadReadResult.THREAD_NOT_MARKED_READ;
        }
        MarkThreadReadResult markThreadReadResult = (markThreadFields.f17205b && threadSummary.f()) ? MarkThreadReadResult.THREAD_MARKED_READ : MarkThreadReadResult.THREAD_NOT_MARKED_READ;
        MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
        markThreadsParamsBuilder.f17212a = Mark.READ;
        m11015a(markThreadsParamsBuilder.m17153a(markThreadFields).m17154a());
        return markThreadReadResult;
    }

    public final void m11003a(ThreadKey threadKey, UserKey userKey, long j, long j2) {
        m10959a(threadKey, userKey, true, j, null, j2);
    }

    @Nullable
    public final ThreadSummary m10988a(ThreadKey threadKey, ImmutableMap<UserKey, Long> immutableMap) {
        return m10945a(threadKey, immutableMap, false, null, -1);
    }

    private void m10959a(ThreadKey threadKey, UserKey userKey, boolean z, long j, @Nullable String str, long j2) {
        m10945a(threadKey, ImmutableBiMap.b(userKey, Long.valueOf(j)), z, str, j2);
    }

    @Nullable
    private ThreadSummary m10945a(ThreadKey threadKey, ImmutableMap<UserKey, Long> immutableMap, boolean z, @Nullable String str, long j) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        FetchThreadResult a2 = this.f10363d.a(threadKey, 0);
        if (!a2.f17179b.l) {
            return null;
        }
        Object obj = null;
        List a3 = Lists.a();
        ImmutableList immutableList = a2.f17180c.h;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            Object obj2;
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            Long l = (Long) immutableMap.get(threadParticipant.b());
            if (l == null || (!z && threadParticipant.d >= l.longValue())) {
                a3.add(threadParticipant);
                obj2 = obj;
            } else {
                a3.add(m10944a(threadParticipant, z, l.longValue()));
                obj2 = 1;
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            return null;
        }
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.a(a2.f17180c).a(a3);
        DbThreadParticipantsUtil.m11122a(((ThreadsDatabaseSupplier) this.f10361b.get()).a(), threadKey, a3, ParticipantType.PARTICIPANT);
        if (j > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sequence_id", Long.valueOf(j));
            newBuilder.d(j);
            a.update("threads", contentValues, "thread_key=?", new String[]{threadKey.g()});
        }
        return newBuilder.V();
    }

    private static ThreadParticipant m10944a(ThreadParticipant threadParticipant, boolean z, long j) {
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a(threadParticipant);
        if (z) {
            threadParticipantBuilder.b = j;
        } else {
            threadParticipantBuilder.d = j;
        }
        return threadParticipantBuilder.f();
    }

    public final void m11001a(ThreadKey threadKey) {
        ImmutableList immutableList;
        if (threadKey == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(threadKey);
        }
        m11020a(immutableList);
    }

    public final void m11020a(ImmutableList<ThreadKey> immutableList) {
        m10977b((ImmutableList) immutableList);
    }

    public final DeleteMessagesResult m10997a(DeleteMessagesParams deleteMessagesParams, long j) {
        Message b = this.f10363d.b((String) deleteMessagesParams.f17026b.iterator().next());
        if (b == null) {
            return DeleteMessagesResult.f17028a;
        }
        boolean z;
        ThreadKey threadKey = b.b;
        Map c = Maps.c();
        Set a = Sets.a();
        m10967a(deleteMessagesParams.f17026b, c, a);
        m10966a(deleteMessagesParams.f17026b);
        m10958a(threadKey, j);
        FetchMoreMessagesResult a2 = this.f10363d.a(threadKey, -1, -1, 1);
        if (a2.f17072c == null || !a2.f17072c.f()) {
            z = false;
        } else {
            m11001a(threadKey);
            z = true;
        }
        return new DeleteMessagesResult(this.f10363d.a(threadKey, 0).f17180c, threadKey, deleteMessagesParams.f17026b, c, a, z);
    }

    private void m10958a(ThreadKey threadKey, long j) {
        FetchThreadResult a = this.f10363d.a(threadKey, 1);
        Message c = a.f17181d.c();
        if (a.f17180c != null && c != null) {
            ThreadSummary a2 = this.f10383x.m10182a(a.f17180c, c, j, StitchOperationType.MESSAGE_DELETED);
            m10960a(a2);
            m10961a(a2, a.f17183f);
        }
    }

    private void m10951a(FolderName folderName) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, 1750133944);
        try {
            a.delete("folders", "folder=?", new String[]{folderName.dbName});
            m10972b(folderName);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 1691435106);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -1705354425);
        }
    }

    private void m10972b(FolderName folderName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_fetch_action_id", Integer.valueOf(-1));
        ((ThreadsDatabaseSupplier) this.f10361b.get()).a().update("threads", contentValues, "folder=?", new String[]{folderName.dbName});
    }

    private void m10953a(FolderName folderName, ThreadKey threadKey) {
        m10955a(folderName, ImmutableList.of(threadKey));
    }

    private void m10955a(FolderName folderName, List<ThreadKey> list) {
        if (!list.isEmpty()) {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            ConjunctionExpression a2 = SqlExpression.a(new Expression[]{SqlExpression.a(Columns.f10681a.d, folderName.dbName), SqlExpression.a(Columns.f10682b.d, list)});
            a.delete("folders", a2.a(), a2.b());
        }
    }

    private void m10973b(ThreadKey threadKey) {
        ImmutableList immutableList;
        if (threadKey == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(threadKey);
        }
        m10977b(immutableList);
    }

    private void m10977b(ImmutableList<ThreadKey> immutableList) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        SQLiteDetour.a(a, -2100337442);
        try {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadKey threadKey = (ThreadKey) immutableList.get(i);
                a.delete("folders", "thread_key=?", new String[]{threadKey.g()});
                a.delete("pinned_threads", "thread_key=?", new String[]{threadKey.g()});
                a.delete("threads", "thread_key=?", new String[]{threadKey.g()});
                a.delete("messages", "thread_key=?", new String[]{threadKey.g()});
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -1906419732);
        } catch (Throwable e) {
            BLog.a(f10351a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 705705402);
        }
    }

    private void m10980c(ThreadKey threadKey) {
        ((ThreadsDatabaseSupplier) this.f10361b.get()).a().delete("messages", "thread_key=?", new String[]{threadKey.g()});
    }

    private void m10966a(Set<String> set) {
        if (!set.isEmpty()) {
            DbMessageCache dbMessageCache = (DbMessageCache) this.f10363d.h.get();
            for (String remove : set) {
                dbMessageCache.f10441a.remove(remove);
            }
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            Expression a2 = SqlExpression.a("msg_id", set);
            a.delete("messages", a2.a(), a2.b());
        }
    }

    private void m10963a(String str) {
        m10966a(ImmutableSet.of(str));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10974b(com.facebook.messaging.model.threadkey.ThreadKey r13, long r14) {
        /*
        r12 = this;
        r10 = 1;
        r0 = r12.f10361b;
        r0 = r0.get();
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;
        r0 = r0.a();
        r1 = -1080320289; // 0xffffffffbf9b9edf float:-1.2157859 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0, r1);
        r4 = com.facebook.database.sqlite.SqlExpression.a();	 Catch:{ all -> 0x0076 }
        r1 = "thread_key";
        r2 = r13.g();	 Catch:{ all -> 0x0076 }
        r1 = com.facebook.database.sqlite.SqlExpression.a(r1, r2);	 Catch:{ all -> 0x0076 }
        r4.a(r1);	 Catch:{ all -> 0x0076 }
        r1 = "msg_type";
        r2 = com.facebook.messaging.model.messages.MessageType.PENDING_SEND;	 Catch:{ all -> 0x0076 }
        r2 = r2.dbKeyValue;	 Catch:{ all -> 0x0076 }
        r2 = java.lang.Integer.toString(r2);	 Catch:{ all -> 0x0076 }
        r1 = com.facebook.database.sqlite.SqlExpression.a(r1, r2);	 Catch:{ all -> 0x0076 }
        r4.a(r1);	 Catch:{ all -> 0x0076 }
        r8 = com.google.common.collect.Maps.d();	 Catch:{ all -> 0x0076 }
        r1 = "messages";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x0076 }
        r3 = 0;
        r5 = "msg_id";
        r2[r3] = r5;	 Catch:{ all -> 0x0076 }
        r3 = 1;
        r5 = "timestamp_ms";
        r2[r3] = r5;	 Catch:{ all -> 0x0076 }
        r3 = r4.a();	 Catch:{ all -> 0x0076 }
        r4 = r4.b();	 Catch:{ all -> 0x0076 }
        r5 = 0;
        r6 = 0;
        r7 = "timestamp_ms";
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0076 }
    L_0x0059:
        r1 = r2.moveToNext();	 Catch:{ all -> 0x0071 }
        if (r1 == 0) goto L_0x007e;
    L_0x005f:
        r1 = 0;
        r1 = r2.getString(r1);	 Catch:{ all -> 0x0071 }
        r3 = 1;
        r4 = r2.getLong(r3);	 Catch:{ all -> 0x0071 }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0071 }
        r8.put(r1, r3);	 Catch:{ all -> 0x0071 }
        goto L_0x0059;
    L_0x0071:
        r1 = move-exception;
        r2.close();	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x0076:
        r1 = move-exception;
        r2 = 600368357; // 0x23c8e4e5 float:2.1780984E-17 double:2.9662138E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r2);
        throw r1;
    L_0x007e:
        r2.close();	 Catch:{  }
        r1 = r8.isEmpty();	 Catch:{  }
        if (r1 != 0) goto L_0x00de;
    L_0x0087:
        r2 = r14 + r10;
        r1 = r8.entrySet();	 Catch:{  }
        r6 = r1.iterator();	 Catch:{  }
        r4 = r2;
    L_0x0092:
        r1 = r6.hasNext();	 Catch:{  }
        if (r1 == 0) goto L_0x00de;
    L_0x0098:
        r1 = r6.next();	 Catch:{  }
        r1 = (java.util.Map.Entry) r1;	 Catch:{  }
        r2 = r1.getValue();	 Catch:{  }
        r2 = (java.lang.Long) r2;	 Catch:{  }
        r2 = r2.longValue();	 Catch:{  }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x00d1;
    L_0x00ac:
        r2 = new android.content.ContentValues;	 Catch:{  }
        r2.<init>();	 Catch:{  }
        r3 = "timestamp_ms";
        r7 = java.lang.Long.valueOf(r4);	 Catch:{  }
        r2.put(r3, r7);	 Catch:{  }
        r3 = "messages";
        r7 = "msg_id=?";
        r8 = 1;
        r8 = new java.lang.String[r8];	 Catch:{  }
        r9 = 0;
        r1 = r1.getKey();	 Catch:{  }
        r1 = (java.lang.String) r1;	 Catch:{  }
        r8[r9] = r1;	 Catch:{  }
        r0.update(r3, r2, r7, r8);	 Catch:{  }
        r2 = r4 + r10;
        r4 = r2;
        goto L_0x0092;
    L_0x00d1:
        r1 = r1.getValue();	 Catch:{  }
        r1 = (java.lang.Long) r1;	 Catch:{  }
        r2 = r1.longValue();	 Catch:{  }
        r2 = r2 + r10;
        r4 = r2;
        goto L_0x0092;
    L_0x00de:
        r0.setTransactionSuccessful();	 Catch:{  }
        r1 = -308051923; // 0xffffffffeda3802d float:-6.3251265E27 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbInsertThreadsHandler.b(com.facebook.messaging.model.threadkey.ThreadKey, long):void");
    }

    private void m10954a(FolderName folderName, ThreadsCollection threadsCollection) {
        SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
        ImmutableList immutableList = threadsCollection.c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContentValues a2 = m10940a(folderName, (ThreadSummary) immutableList.get(i));
            SQLiteDetour.a(-1646791577);
            a.replaceOrThrow("folders", "", a2);
            SQLiteDetour.a(-835943581);
        }
        if (threadsCollection.d) {
            a2 = new ContentValues();
            a2.put("folder", folderName.dbName);
            a2.put("thread_key", DbFolders.m11102a(folderName));
            a2.put("timestamp_ms", Integer.valueOf(0));
            SQLiteDetour.a(497544122);
            a.replaceOrThrow("folders", "", a2);
            SQLiteDetour.a(-455454731);
        }
    }

    private void m10960a(ThreadSummary threadSummary) {
        TracerDetour.a("DbInsertThreadsHandler.updateThreadInFolderTable", 1438726182);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            FolderName folderName = threadSummary.A;
            ContentValues a2 = m10940a(folderName, threadSummary);
            if (threadSummary.k >= this.f10364e.m10928a(folderName)) {
                SQLiteDetour.a(-519081631);
                a.replaceOrThrow("folders", "", a2);
                SQLiteDetour.a(-656978864);
            } else {
                a.delete("folders", "thread_key=?", new String[]{threadSummary.a.g()});
            }
            TracerDetour.a(1321756014);
        } catch (Throwable th) {
            TracerDetour.a(-100448279);
        }
    }

    private static ContentValues m10940a(FolderName folderName, ThreadSummary threadSummary) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("folder", folderName.dbName);
        contentValues.put("thread_key", threadSummary.a.g());
        contentValues.put("timestamp_ms", Long.valueOf(threadSummary.k));
        return contentValues;
    }

    public final void m11005a(ThreadSummary threadSummary, NotificationSetting notificationSetting, long j) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.C = notificationSetting;
        m10961a(a.V(), j);
    }

    public final ThreadSummary m10991a(ThreadSummary threadSummary, ThreadRtcCallInfoData threadRtcCallInfoData, long j) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.Q = threadRtcCallInfoData;
        m10961a(a.V(), j);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    public final ThreadSummary m10992a(ThreadSummary threadSummary, GroupType groupType, @Nullable Uri uri, long j) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.N = groupType;
        a = a;
        a.H = uri;
        m10961a(a.V(), j);
        return this.f10363d.a(threadSummary.a, 0).f17180c;
    }

    public final ThreadSummary m10996a(ThreadSummary threadSummary, boolean z, long j) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.O = z;
        ThreadSummary V = a.V();
        m10961a(V, j);
        return this.f10363d.a(V.a, 0).f17180c;
    }

    public final void m11004a(ThreadSummary threadSummary, TriState triState, long j) {
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.T = triState;
        m10961a(a.V(), j);
    }

    private void m10961a(ThreadSummary threadSummary, long j) {
        TracerDetour.a("DbInsertThreadsHandler.updateThreadsTable", 508604585);
        try {
            ThreadSummary b = m10970b(threadSummary);
            ContentValues contentValues = new ContentValues();
            contentValues.put("thread_key", b.a.g());
            contentValues.put("legacy_thread_id", b.b);
            contentValues.put("action_id", Long.valueOf(b.c));
            contentValues.put("sequence_id", Long.valueOf(b.d));
            contentValues.put("refetch_action_id", Long.valueOf(b.e));
            contentValues.put("last_visible_action_id", Long.valueOf(b.f));
            if (b.a()) {
                contentValues.put("name", b.g);
            }
            if (b.b()) {
                contentValues.put("pic_hash", b.s);
            }
            if (b.c()) {
                contentValues.put("pic", b.t.toString());
            }
            contentValues.put("senders", this.f10366g.a(b.o));
            contentValues.put("snippet", b.p);
            contentValues.put("snippet_sender", this.f10366g.a(b.r));
            contentValues.put("admin_snippet", b.q);
            contentValues.put("timestamp_ms", Long.valueOf(b.k));
            contentValues.put("last_read_timestamp_ms", Long.valueOf(b.l));
            contentValues.put("approx_total_message_count", Long.valueOf(b.m));
            contentValues.put("unread_message_count", Long.valueOf(b.n));
            contentValues.put("last_fetch_time_ms", Long.valueOf(j));
            contentValues.put("has_missed_call", Boolean.valueOf(b.y));
            contentValues.put("can_reply_to", Boolean.valueOf(b.u));
            contentValues.put("cannot_reply_reason", b.v.toString());
            contentValues.put("is_subscribed", Boolean.valueOf(b.w));
            contentValues.put("folder", b.A.dbName);
            contentValues.put("draft", this.f10375p.a(b.B));
            contentValues.put("mute_until", Long.valueOf(b.C.a()));
            ThreadCustomization threadCustomization = b.D;
            contentValues.put("me_bubble_color", Integer.valueOf(threadCustomization.c));
            contentValues.put("other_bubble_color", Integer.valueOf(threadCustomization.d));
            contentValues.put("wallpaper_color", Integer.valueOf(threadCustomization.b));
            contentValues.put("custom_like_emoji", threadCustomization.f);
            String a = threadCustomization.g.a();
            if (a == null) {
                contentValues.putNull("custom_nicknames");
            } else {
                contentValues.put("custom_nicknames", a);
            }
            contentValues.put("last_fetch_action_id", Long.valueOf(b.F));
            contentValues.put("initial_fetch_complete", Boolean.valueOf(b.G));
            contentValues.put("outgoing_message_lifetime", Integer.valueOf(b.H));
            if (b.d()) {
                contentValues.put("invite_uri", b.I.toString());
            }
            contentValues.put("is_last_message_sponsored", Boolean.valueOf(b.K));
            contentValues.put("group_chat_rank", Float.valueOf(b.M));
            contentValues.put("game_data", DbThreadGameDataSerialization.a(b.N));
            contentValues.put("group_type", b.P.dbValue);
            contentValues.put("requires_approval", Boolean.valueOf(b.Q));
            contentValues.put("rtc_call_info", DbThreadRtcCallInfoSerialization.a(b.E));
            if (b.O != null) {
                contentValues.put("last_message_commerce_message_type", b.O);
            }
            contentValues.put("is_thread_queue_enabled", Integer.valueOf(b.T.getDbValue()));
            SQLiteDatabase a2 = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(-307607592);
            a2.replaceOrThrow("threads", "", contentValues);
            SQLiteDetour.a(-54941089);
            ThreadKey threadKey = b.a;
            DbThreadParticipantsUtil.m11122a(a2, threadKey, b.h, ParticipantType.PARTICIPANT);
            DbThreadParticipantsUtil.m11122a(a2, threadKey, b.i, ParticipantType.FORMER_PARTICIPANT);
            DbThreadParticipantsUtil.m11122a(a2, threadKey, b.j, ParticipantType.BOT);
            DbThreadParticipantsUtil.m11121a(a2, threadKey, b.R);
            DbThreadEventRemindersUtil.m11116a(a2, threadKey, b.J);
            DbThreadEventReminderMembersUtil.m11111a(a2, b.J);
            ((ThreadNotificationPrefsSyncUtil) this.f10384y.get()).m16429a(b);
        } finally {
            TracerDetour.a(-359639585);
        }
    }

    private ThreadSummary m10970b(ThreadSummary threadSummary) {
        FetchThreadResult a = this.f10363d.a(threadSummary.a, 0);
        if (!a.f17179b.l) {
            return threadSummary;
        }
        ThreadSummary threadSummary2 = a.f17180c;
        ThreadSummary a2 = m10946a(m10971b(threadSummary, threadSummary2), threadSummary2);
        if (((Boolean) this.f10354C.get()).booleanValue() && a2.d == -1) {
            long a3 = ((DbThreadsPropertyUtil) this.f10362c.get()).a(DbThreadProperties.f10477j, -1);
            ThreadSummaryBuilder a4 = ThreadSummary.newBuilder().a(a2);
            a4.d = a3;
            threadSummary2 = a4.V();
        } else {
            threadSummary2 = a2;
        }
        return threadSummary2;
    }

    private static ThreadSummary m10946a(ThreadSummary threadSummary, ThreadSummary threadSummary2) {
        MessageDraft messageDraft = threadSummary2.B;
        if (messageDraft == null) {
            return threadSummary;
        }
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.B = messageDraft;
        return a.V();
    }

    private static ThreadSummary m10971b(ThreadSummary threadSummary, ThreadSummary threadSummary2) {
        Map a = Maps.a(threadSummary2.h.size());
        ImmutableList immutableList = threadSummary2.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            a.put(threadParticipant.b(), threadParticipant);
        }
        ThreadSummaryBuilder a2 = ThreadSummary.newBuilder().a(threadSummary);
        List b = Lists.b(a2.h.size());
        for (ThreadParticipant threadParticipant2 : a2.h) {
            ThreadParticipant threadParticipant3 = (ThreadParticipant) a.get(threadParticipant2.b());
            if (threadParticipant3 == null) {
                b.add(threadParticipant2);
            } else {
                ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
                threadParticipantBuilder.a(threadParticipant2);
                if (threadParticipantBuilder.b() < threadParticipant3.b) {
                    threadParticipantBuilder.b = threadParticipant3.b;
                }
                if (threadParticipant3.c != null && threadParticipantBuilder.c == null) {
                    threadParticipantBuilder.c = threadParticipant3.c;
                }
                b.add(threadParticipantBuilder.f());
            }
        }
        a2.h = b;
        return a2.V();
    }

    @Nullable
    @VisibleForTesting
    private Message m10979c(Message message) {
        return m10943a(message, true);
    }

    @Nullable
    @VisibleForTesting
    private Message m10943a(Message message, boolean z) {
        ImmutableList a = m10949a(new MessagesCollection(message.b, ImmutableList.of(message), false), z);
        return a.isEmpty() ? null : (Message) a.get(0);
    }

    private ImmutableList<Message> m10948a(MessagesCollection messagesCollection) {
        return m10949a(messagesCollection, true);
    }

    private ImmutableList<Message> m10949a(MessagesCollection messagesCollection, boolean z) {
        TracerDetour.a("DbInsertThreadsHandler.updateMessagesTable", 264375282);
        try {
            SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
            SQLiteDetour.a(a, 2079095980);
            int it;
            try {
                int i;
                Message message;
                Collection a2 = Sets.a();
                Collection a3 = Sets.a();
                ImmutableList b = messagesCollection.b();
                int size = b.size();
                for (i = 0; i < size; i++) {
                    message = (Message) b.get(i);
                    a2.add(message.a);
                    if (message.n != null) {
                        a3.add(message.n);
                    }
                }
                Map a4 = this.f10363d.a(a2, a3);
                Map c = Maps.c();
                for (Message message2 : a4.values()) {
                    if (message2.n != null) {
                        c.put(message2.n, message2);
                    }
                }
                Set a5 = Sets.a();
                List a6 = Lists.a();
                Builder builder = ImmutableList.builder();
                ImmutableList b2 = messagesCollection.b();
                int size2 = b2.size();
                for (i = 0; i < size2; i++) {
                    message2 = (Message) b2.get(i);
                    Message message3 = (Message) a4.get(message2.a);
                    if (message3 == null) {
                        message3 = (Message) c.get(message2.n);
                    }
                    if (message3 == null) {
                        a6.add(message2);
                    } else if (m10968a(message2, message3, z)) {
                        String str = message3.a;
                        a5.add(message3.a);
                        a6.add(m10942a(message2, message3));
                    } else {
                        builder.c(message2);
                    }
                }
                if (messagesCollection.e()) {
                    a6.add(m10982d(messagesCollection.a()));
                }
                m10966a(a5);
                it = a6.iterator();
                while (it.hasNext()) {
                    m10983d((Message) it.next());
                }
                a.setTransactionSuccessful();
                ImmutableList<Message> b3 = builder.b();
                SQLiteDetour.b(a, it);
                return b3;
            } finally {
                it = 1163525434;
                SQLiteDetour.b(a, 1163525434);
            }
        } finally {
            TracerDetour.a(1579058700);
        }
    }

    private static boolean m10968a(Message message, Message message2, boolean z) {
        if (message2.o) {
            return true;
        }
        if (message.o || !z) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10967a(java.util.Set<java.lang.String> r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Set<java.lang.String> r11) {
        /*
        r8 = this;
        r0 = "DbInsertThreadsHandler.getOfflineThreadingIdsForMessageIds";
        r1 = 145765501; // 0x8b0347d float:1.0604955E-33 double:7.20177264E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = "msg_id";
        r4 = com.facebook.database.sqlite.SqlExpression.a(r0, r9);	 Catch:{ all -> 0x008a }
        r0 = r8.f10361b;	 Catch:{ all -> 0x008a }
        r0 = r0.get();	 Catch:{ all -> 0x008a }
        r0 = (com.facebook.messaging.database.threads.ThreadsDatabaseSupplier) r0;	 Catch:{ all -> 0x008a }
        r0 = r0.a();	 Catch:{ all -> 0x008a }
        r1 = "messages";
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x008a }
        r3 = 0;
        r5 = "msg_id";
        r2[r3] = r5;	 Catch:{ all -> 0x008a }
        r3 = 1;
        r5 = "offline_threading_id";
        r2[r3] = r5;	 Catch:{ all -> 0x008a }
        r3 = 2;
        r5 = "pending_send_media_attachment";
        r2[r3] = r5;	 Catch:{ all -> 0x008a }
        r3 = r4.a();	 Catch:{ all -> 0x008a }
        r4 = r4.b();	 Catch:{ all -> 0x008a }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x008a }
    L_0x003d:
        r0 = r1.moveToNext();	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x0092;
    L_0x0043:
        r0 = 1;
        r0 = r1.isNull(r0);	 Catch:{ all -> 0x0085 }
        if (r0 != 0) goto L_0x0057;
    L_0x004a:
        r0 = 0;
        r0 = r1.getString(r0);	 Catch:{ all -> 0x0085 }
        r2 = 1;
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0085 }
        r10.put(r0, r2);	 Catch:{ all -> 0x0085 }
    L_0x0057:
        r0 = 2;
        r0 = r1.isNull(r0);	 Catch:{ all -> 0x0085 }
        if (r0 != 0) goto L_0x003d;
    L_0x005e:
        r0 = r8.f10374o;	 Catch:{ all -> 0x0085 }
        r2 = 2;
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0085 }
        r0 = r0.a(r2);	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x003d;
    L_0x006b:
        r2 = r0.iterator();	 Catch:{ all -> 0x0085 }
    L_0x006f:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x003d;
    L_0x0075:
        r0 = r2.next();	 Catch:{ all -> 0x0085 }
        r0 = (com.facebook.ui.media.attachments.MediaResource) r0;	 Catch:{ all -> 0x0085 }
        r3 = r0.u;	 Catch:{ all -> 0x0085 }
        if (r3 == 0) goto L_0x006f;
    L_0x007f:
        r0 = r0.u;	 Catch:{ all -> 0x0085 }
        r11.add(r0);	 Catch:{ all -> 0x0085 }
        goto L_0x006f;
    L_0x0085:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x008a:
        r0 = move-exception;
        r1 = 1294854596; // 0x4d2de9c4 float:1.82361152E8 double:6.39743172E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x0092:
        r1.close();	 Catch:{  }
        r0 = -1470311174; // 0xffffffffa85cd4fa float:-1.2258635E-14 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbInsertThreadsHandler.a(java.util.Set, java.util.Map, java.util.Set):void");
    }

    private static Message m10942a(Message message, Message message2) {
        MessageBuilder a = Message.newBuilder().a(message);
        if (message.t.isEmpty() && !message2.t.isEmpty()) {
            a.r = message2.t;
        }
        if (message.u == null && message2.u != null) {
            a.s = message2.u;
        }
        if (message.d == 0 && message2.d != 0) {
            a.d = message2.d;
        }
        if (message.f == null && message2.f != null) {
            a.f = message2.f;
        }
        if (message2.k != null && message.k == null) {
            a.k = message2.k;
        }
        if (message.v == null && message2.v != null) {
            a.a(message2.v);
        }
        if (message.B == null && message2.B != null) {
            a.B = message2.B;
        }
        if (message.C == null && message2.C != null) {
            a.C = message2.C;
        }
        if (message.H == null && message2.H != null) {
            a.H = message2.H;
        }
        if (message.E == null && message2.E != null) {
            a.E = message2.E;
        }
        if (message.F == null && message2.F != null) {
            a.F = message2.F;
        }
        if (message.J == null && message2.J != null) {
            a.J = message2.J;
        }
        if (message.r == SendChannel.UNKNOWN) {
            a.a(message2.r);
        }
        return a.R();
    }

    @VisibleForTesting
    private void m10983d(Message message) {
        TracerDetour.a("DbInsertThreadsHandler.updateMessagesTableInternal", 1677787663);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msg_id", message.a);
            contentValues.put("thread_key", message.b.g());
            contentValues.put("action_id", Long.valueOf(message.g));
            contentValues.put("text", message.f);
            contentValues.put("sender", this.f10366g.a(message.e));
            contentValues.put("is_not_forwardable", Boolean.valueOf(message.h));
            contentValues.put("timestamp_ms", Long.valueOf(message.c));
            contentValues.put("msg_type", Integer.valueOf(message.l.dbKeyValue));
            contentValues.put("affected_users", this.f10366g.a(message.m));
            contentValues.put("attachments", this.f10367h.a(message.i));
            contentValues.put("shares", this.f10368i.a(message.j));
            contentValues.put("sticker_id", message.k);
            contentValues.put("client_tags", DbMessageClientTagsSerialization.a(message.v));
            contentValues.put("offline_threading_id", message.n);
            contentValues.put("source", message.p);
            contentValues.put("channel_source", message.q.name());
            contentValues.put("send_channel", message.r.name());
            contentValues.put("is_non_authoritative", Boolean.valueOf(message.o));
            if (MessageUtil.e(message)) {
                contentValues.put("pending_send_media_attachment", this.f10374o.a(message.t));
            }
            if (message.d != 0) {
                contentValues.put("timestamp_sent_ms", Long.valueOf(message.d));
            }
            contentValues.put("sent_share_attachment", this.f10369j.a(message.u));
            contentValues.put("send_error", message.w.b.serializedString);
            contentValues.put("send_error_number", Integer.valueOf(message.w.d));
            contentValues.put("send_error_message", message.w.c);
            contentValues.put("send_error_timestamp_ms", Long.valueOf(message.w.e));
            contentValues.put("send_error_error_url", message.w.f);
            contentValues.put("publicity", message.s.a());
            if (message.A != null) {
                contentValues.put("send_queue_type", message.A.b.serializedValue);
            }
            contentValues.put("payment_transaction", DbPaymentTransactionDataSerialization.a(message.B));
            contentValues.put("payment_request", DbPaymentRequestDataSerialization.a(message.C));
            contentValues.put("has_unavailable_attachment", Boolean.valueOf(message.D));
            contentValues.put("app_attribution", DbAppAttributionSerialization.a(message.E));
            contentValues.put("content_app_attribution", DbAppAttributionSerialization.a(message.F));
            contentValues.put("xma", this.f10358G.a(message.G));
            GenericAdminMessageInfo genericAdminMessageInfo = message.I;
            if (genericAdminMessageInfo != null) {
                contentValues.put("admin_text_type", Integer.valueOf(genericAdminMessageInfo.a()));
                if (genericAdminMessageInfo.z() != 0) {
                    contentValues.put("admin_text_theme_color", Integer.valueOf(genericAdminMessageInfo.z()));
                }
                if (genericAdminMessageInfo.A() != null) {
                    contentValues.put("admin_text_thread_icon_emoji", genericAdminMessageInfo.A());
                }
                if (genericAdminMessageInfo.B() != null) {
                    contentValues.put("admin_text_nickname", genericAdminMessageInfo.B());
                }
                if (genericAdminMessageInfo.C() != null) {
                    contentValues.put("admin_text_target_id", genericAdminMessageInfo.C());
                }
                if (genericAdminMessageInfo.g()) {
                    contentValues.put("admin_text_thread_message_lifetime", Integer.valueOf(genericAdminMessageInfo.D()));
                }
                ImmutableList E = genericAdminMessageInfo.E();
                if (E != null) {
                    contentValues.put("admin_text_thread_journey_color_choices", JSONUtil.b(E).toString());
                }
                E = genericAdminMessageInfo.F();
                if (E != null) {
                    contentValues.put("admin_text_thread_journey_emoji_choices", JSONUtil.b(E).toString());
                }
                E = genericAdminMessageInfo.G();
                if (E != null) {
                    try {
                        contentValues.put("admin_text_thread_journey_nickname_choices", this.f10380u.a(E));
                    } catch (JsonProcessingException e) {
                        throw new IllegalArgumentException("Nickname choices were not serializable.");
                    }
                }
                E = genericAdminMessageInfo.H();
                if (E != null) {
                    try {
                        contentValues.put("admin_text_thread_journey_bot_choices", this.f10380u.a(E));
                    } catch (JsonProcessingException e2) {
                        throw new IllegalArgumentException("Event Reminder properties were not serializable.", e2);
                    } catch (JsonProcessingException e22) {
                        throw new IllegalArgumentException("Ad properties were not serializable.", e22);
                    } catch (JsonProcessingException e3) {
                        throw new IllegalArgumentException("Bot choices were not serializable.");
                    }
                }
                if (genericAdminMessageInfo.I() != null) {
                    contentValues.put("admin_text_thread_rtc_event", genericAdminMessageInfo.I());
                }
                if (genericAdminMessageInfo.J() != null) {
                    contentValues.put("admin_text_thread_rtc_server_info_data", genericAdminMessageInfo.J());
                }
                contentValues.put("admin_text_thread_rtc_is_video_call", Boolean.valueOf(genericAdminMessageInfo.K()));
                if (genericAdminMessageInfo.L() != null) {
                    contentValues.put("admin_text_thread_ride_provider_name", genericAdminMessageInfo.L());
                }
                AdProperties P = genericAdminMessageInfo.P();
                if (P != null) {
                    contentValues.put("admin_text_thread_ad_properties", this.f10380u.a(P));
                }
                if (genericAdminMessageInfo.M() != null) {
                    ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                    objectNode.a("game_type", genericAdminMessageInfo.M());
                    objectNode.a("score", genericAdminMessageInfo.N());
                    objectNode.a("is_new_high_score", genericAdminMessageInfo.O());
                    contentValues.put("admin_text_game_score_data", objectNode.toString());
                }
                EventReminderProperties Q = genericAdminMessageInfo.Q();
                if (Q != null) {
                    contentValues.put("admin_text_thread_event_reminder_properties", this.f10380u.a(Q));
                }
                if (genericAdminMessageInfo.R() != null) {
                    contentValues.put("admin_text_joinable_event_type", genericAdminMessageInfo.R().toDbValue());
                }
            }
            if (message.J != null) {
                contentValues.put("message_lifetime", message.J);
            }
            contentValues.put("is_sponsored", Boolean.valueOf(message.M));
            if (message.N != null) {
                contentValues.put("commerce_message_type", message.N);
            }
            contentValues.put("customizations", DbMessageCustomizationSerialization.a(message.O));
            this.f10372m.get();
            contentValues.put("metadata_at_text_ranges", DbMessageMetadataSerialization.m11084a(message.P));
            this.f10373n.get();
            contentValues.put("platform_metadata", DbMessagePlatformMetadataSerialization.m11086a(message.Q));
            SQLiteDetour.a(213339747);
            ((ThreadsDatabaseSupplier) this.f10361b.get()).a().replaceOrThrow("messages", "", contentValues);
            SQLiteDetour.a(-622341700);
        } finally {
            TracerDetour.a(765358879);
        }
    }

    private static Message m10982d(ThreadKey threadKey) {
        MessageBuilder a = Message.newBuilder().a(threadKey.g());
        a.b = threadKey;
        a = a;
        a.l = MessageType.BEFORE_FIRST_SENTINEL;
        a = a;
        a.c = 0;
        return a.R();
    }

    private boolean m10984e(Message message) {
        UserKey userKey = (UserKey) this.f10382w.get();
        return userKey != null && Objects.equal(userKey, message.e.b);
    }

    public final void m11018a(UpdatePinnedThreadsParams updatePinnedThreadsParams) {
        m10964a(updatePinnedThreadsParams.f17343a);
    }

    public final void m11006a(AddPinnedThreadParams addPinnedThreadParams) {
        FetchPinnedThreadsResult a = this.f10364e.m10930a();
        List a2 = Lists.a(a.f17101c.size() + 1);
        ImmutableList immutableList = a.f17101c;
        int size = immutableList.size();
        Object obj = null;
        for (int i = 0; i < size; i++) {
            ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
            if (!threadSummary.a.equals(addPinnedThreadParams.f17013a)) {
                obj = 1;
            }
            a2.add(threadSummary.a);
        }
        if (obj == null) {
            if (addPinnedThreadParams.f17013a != null) {
                a2.add(addPinnedThreadParams.f17013a);
            }
            m10964a(a2);
        }
    }

    public final void m11017a(UnpinThreadParams unpinThreadParams) {
        FetchPinnedThreadsResult a = this.f10364e.m10930a();
        List a2 = Lists.a();
        ImmutableList immutableList = a.f17101c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
            if (!unpinThreadParams.f17335a.equals(threadSummary.a)) {
                a2.add(threadSummary.a);
            }
        }
        if (a2.size() != a.f17101c.size()) {
            m10964a(a2);
        }
    }

    private void m10964a(List<ThreadKey> list) {
        if (!list.isEmpty()) {
            TracerDetour.a("DbInsertThreadsHandler.setPinnedThreadIdsInDb", -261624510);
            try {
                SQLiteDatabase a = ((ThreadsDatabaseSupplier) this.f10361b.get()).a();
                SQLiteDetour.a(a, -35783089);
                try {
                    a.delete("pinned_threads", null, null);
                    for (int i = 0; i < list.size(); i++) {
                        m10957a((ThreadKey) list.get(i), i);
                    }
                    a.setTransactionSuccessful();
                    SQLiteDetour.b(a, 163763770);
                } catch (Throwable e) {
                    BLog.a(f10351a, "SQLException", e);
                    throw e;
                } catch (Throwable th) {
                    SQLiteDetour.b(a, 411901555);
                }
            } finally {
                TracerDetour.a(-1804216745);
            }
        }
    }

    private void m10957a(ThreadKey threadKey, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thread_key", threadKey.g());
        contentValues.put("display_order", Integer.valueOf(i));
        SQLiteDetour.a(1744472227);
        ((ThreadsDatabaseSupplier) this.f10361b.get()).a().replaceOrThrow("pinned_threads", "", contentValues);
        SQLiteDetour.a(-953684608);
    }

    public final void m11019a(User user) {
        this.f10365f.m10939a(ImmutableList.of(user));
    }
}
