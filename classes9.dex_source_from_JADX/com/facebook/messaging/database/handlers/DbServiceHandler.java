package com.facebook.messaging.database.handlers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.results.DataFetchDisposition.DataSource;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.threads.FetchThreadLogger.FetchLocation;
import com.facebook.messaging.analytics.threads.FetchThreadTracer;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.database.threads.DbThreadEventReminderMembersUtil;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.database.threads.ThreadEventReminderMembersIterator;
import com.facebook.messaging.database.threads.ThreadEventReminderMembersIterator.Result;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.deliveryreceipt.DefaultSendDeliveryReceiptManager;
import com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptManager;
import com.facebook.messaging.media.download.MediaDownloadManager;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.MessagesCollectionMerger;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadDeliveryReceipts;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.service.base.ForwardingBlueServiceHandlerFilter;
import com.facebook.messaging.service.model.AddMontageViewerParams;
import com.facebook.messaging.service.model.AddPinnedThreadParams;
import com.facebook.messaging.service.model.CreateLocalAdminMessageParams;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.EditUsernameResult;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsParams;
import com.facebook.messaging.service.model.FetchDeliveryReceiptsResult;
import com.facebook.messaging.service.model.FetchEventRemindersMembersParams;
import com.facebook.messaging.service.model.FetchEventRemindersMembersResult;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledParams;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledResult;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadHandlerChange;
import com.facebook.messaging.service.model.FetchThreadHandlerChange.ChangeReason;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsParams;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.MarkFolderSeenResult;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.ReadReceiptParams;
import com.facebook.messaging.service.model.ReceiptResult;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.messaging.service.model.RemoveMontageViewerParams;
import com.facebook.messaging.service.model.SaveDraftParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.service.model.SetSettingsParams;
import com.facebook.messaging.service.model.UnpinThreadParams;
import com.facebook.messaging.service.model.UpdateFolderCountsParams;
import com.facebook.messaging.service.model.UpdateFolderCountsResult;
import com.facebook.messaging.service.model.UpdateMessageSendErrorParams;
import com.facebook.messaging.service.model.UpdatePinnedThreadsParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: me_color */
public class DbServiceHandler extends ForwardingBlueServiceHandlerFilter {
    private static final Class<?> f10396a = DbServiceHandler.class;
    private static final Object f10397u = new Object();
    private final DbFetchThreadsHandler f10398b;
    private final DbThreadsPropertyUtil f10399c;
    private final Provider<ThreadsDatabaseSupplier> f10400d;
    private final ViewerContextManager f10401e;
    private final Provider<Boolean> f10402f;
    private final Clock f10403g;
    private final MessagesBroadcaster f10404h;
    private final MessagingPerformanceLogger f10405i;
    private final DebugOverlayController f10406j;
    private final FbSharedPreferences f10407k;
    private final Provider<User> f10408l;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DbSendHandler> f10409m = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DbFetchThreadHandler> f10410n = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DbInsertThreadsHandler> f10411o = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SendDeliveryReceiptManager> f10412p = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThreadParticipantUtils> f10413q = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaDownloadManager> f10414r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FetchThreadTracer> f10415s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessagesCollectionMerger> f10416t = UltralightRuntime.b;

    /* compiled from: me_color */
    /* synthetic */ class C11871 {
        static final /* synthetic */ int[] f10395a = new int[DataFreshnessParam.values().length];

        static {
            try {
                f10395a[DataFreshnessParam.STALE_DATA_OKAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10395a[DataFreshnessParam.DO_NOT_CHECK_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10395a[DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10395a[DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static DbServiceHandler m11050b(InjectorLike injectorLike) {
        DbServiceHandler dbServiceHandler = new DbServiceHandler(DbFetchThreadsHandler.m10920a(injectorLike), DbThreadsPropertyUtil.m11132a(injectorLike), IdBasedProvider.a(injectorLike, 7815), ViewerContextManagerProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 4075), (Clock) SystemClockMethodAutoProvider.a(injectorLike), MessagesBroadcaster.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), DebugOverlayController.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
        dbServiceHandler.m11044a(IdBasedSingletonScopeProvider.b(injectorLike, 7798), IdBasedSingletonScopeProvider.b(injectorLike, 2597), IdBasedSingletonScopeProvider.b(injectorLike, 7797), IdBasedLazy.a(injectorLike, 7821), IdBasedLazy.a(injectorLike, 7706), IdBasedLazy.a(injectorLike, 7908), IdBasedSingletonScopeProvider.b(injectorLike, 7520), IdBasedSingletonScopeProvider.b(injectorLike, 7973));
        return dbServiceHandler;
    }

    private void m11044a(com.facebook.inject.Lazy<DbSendHandler> lazy, com.facebook.inject.Lazy<DbFetchThreadHandler> lazy2, com.facebook.inject.Lazy<DbInsertThreadsHandler> lazy3, com.facebook.inject.Lazy<SendDeliveryReceiptManager> lazy4, com.facebook.inject.Lazy<ThreadParticipantUtils> lazy5, com.facebook.inject.Lazy<MediaDownloadManager> lazy6, com.facebook.inject.Lazy<FetchThreadTracer> lazy7, com.facebook.inject.Lazy<MessagesCollectionMerger> lazy8) {
        this.f10409m = lazy;
        this.f10410n = lazy2;
        this.f10411o = lazy3;
        this.f10412p = lazy4;
        this.f10413q = lazy5;
        this.f10414r = lazy6;
        this.f10415s = lazy7;
        this.f10416t = lazy8;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.database.handlers.DbServiceHandler m11040a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10397u;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11050b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10397u;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.database.handlers.DbServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.database.handlers.DbServiceHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10397u;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.database.handlers.DbServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbServiceHandler");
    }

    protected final OperationResult mo339C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbSendHandler) this.f10409m.get()).m11036a((UpdateMessageSendErrorParams) operationParams.c.getParcelable("updatedMessageSendErrorParams"));
        return OperationResult.a;
    }

    protected final OperationResult mo344H(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbInsertThreadsHandler) this.f10411o.get()).m11000a(((CreateLocalAdminMessageParams) operationParams.c.getParcelable("createLocalAdminMessageParams")).f17022a);
        return OperationResult.a;
    }

    protected final OperationResult mo347K(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a(new UpdateFolderCountsResult(((DbInsertThreadsHandler) this.f10411o.get()).m10986a((UpdateFolderCountsParams) operationParams.c.getParcelable("updateFolderCountsParams"))));
    }

    protected final OperationResult mo352P(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchIsThreadQueueEnabledParams fetchIsThreadQueueEnabledParams = (FetchIsThreadQueueEnabledParams) operationParams.c.getParcelable(FetchIsThreadQueueEnabledParams.f17060a);
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult a2 = ((DbFetchThreadHandler) this.f10410n.get()).a(fetchIsThreadQueueEnabledParams.f17061b, 0);
        if (a2.f17180c != null) {
            FetchIsThreadQueueEnabledResult fetchIsThreadQueueEnabledResult = (FetchIsThreadQueueEnabledResult) a.k();
            Preconditions.checkNotNull(fetchIsThreadQueueEnabledResult);
            ((DbInsertThreadsHandler) this.f10411o.get()).m11004a(a2.f17180c, TriState.valueOf(fetchIsThreadQueueEnabledResult.f17062a), this.f10403g.a());
        }
        return a;
    }

    protected final OperationResult mo358e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadKeyByParticipantsParams fetchThreadKeyByParticipantsParams = (FetchThreadKeyByParticipantsParams) operationParams.c.getParcelable("fetch_thread_with_participants_key");
        ThreadSummary b = fetchThreadKeyByParticipantsParams.m17104b(this.f10398b.m10932a(fetchThreadKeyByParticipantsParams.f17114b));
        return OperationResult.a(new FetchThreadKeyByParticipantsResult(b == null ? null : b.a));
    }

    protected final OperationResult mo364k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbInsertThreadsHandler) this.f10411o.get()).m11015a((MarkThreadsParams) operationParams.c.getParcelable("markThreadsParams"));
        return blueServiceHandler.a(operationParams);
    }

    protected final OperationResult mo366m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        DeleteThreadsParams deleteThreadsParams = (DeleteThreadsParams) operationParams.c.getParcelable("deleteThreadsParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        ((DbInsertThreadsHandler) this.f10411o.get()).m11020a(deleteThreadsParams.f17036a);
        return a;
    }

    protected final OperationResult mo368o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        DeleteMessagesParams deleteMessagesParams = (DeleteMessagesParams) operationParams.c.getParcelable("deleteMessagesParams");
        Builder builder = ImmutableSet.builder();
        if (deleteMessagesParams.f17027c == ServerParam.MUST_UPDATE_SERVER) {
            Iterator it = deleteMessagesParams.f17026b.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("mid.")) {
                    builder.c(str);
                }
            }
        }
        ImmutableSet b = builder.b();
        if (!b.isEmpty()) {
            Parcelable deleteMessagesParams2 = new DeleteMessagesParams(b, ServerParam.MUST_UPDATE_SERVER, deleteMessagesParams.f17025a);
            Bundle bundle = new Bundle();
            bundle.putParcelable("deleteMessagesParams", deleteMessagesParams2);
            blueServiceHandler.a(new OperationParams("delete_messages", bundle));
        }
        return OperationResult.a(((DbInsertThreadsHandler) this.f10411o.get()).m10997a(deleteMessagesParams, -1));
    }

    protected final OperationResult mo370q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FolderName fromDbName = FolderName.fromDbName(operationParams.c.getString("folderName"));
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a == null || !a.b) {
            return a;
        }
        long a2 = this.f10403g.a();
        ((DbInsertThreadsHandler) this.f10411o.get()).m11022a(fromDbName, a2);
        return OperationResult.a(new MarkFolderSeenResult(fromDbName, a2));
    }

    protected final OperationResult mo371r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        SaveDraftParams saveDraftParams = (SaveDraftParams) operationParams.c.getParcelable("saveDraftParams");
        ((DbInsertThreadsHandler) this.f10411o.get()).m11002a(saveDraftParams.f17281a, saveDraftParams.f17282b);
        return OperationResult.a;
    }

    protected final OperationResult mo374u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ReadReceiptParams readReceiptParams = (ReadReceiptParams) operationParams.c.getParcelable("readReceiptParams");
        ((DbInsertThreadsHandler) this.f10411o.get()).m11003a(readReceiptParams.f17266a.a, readReceiptParams.f17267b, readReceiptParams.f17268c, 0);
        FetchThreadResult a = ((DbFetchThreadHandler) this.f10410n.get()).a(readReceiptParams.f17266a.a, 0);
        return OperationResult.a(new ReceiptResult(a.f17179b, a.f17180c, a.f17183f));
    }

    protected final OperationResult mo377x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbInsertThreadsHandler) this.f10411o.get()).m11018a((UpdatePinnedThreadsParams) operationParams.c.getParcelable("updatePinnedThreadsParams"));
        OperationResult a = blueServiceHandler.a(operationParams);
        ((DbInsertThreadsHandler) this.f10411o.get()).m11010a((FetchPinnedThreadsResult) a.k(), this.f10403g.a());
        return a;
    }

    protected final OperationResult mo378y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbInsertThreadsHandler) this.f10411o.get()).m11006a((AddPinnedThreadParams) operationParams.c.getParcelable("addPinnedThreadParams"));
        OperationResult a = blueServiceHandler.a(operationParams);
        ((DbInsertThreadsHandler) this.f10411o.get()).m11010a((FetchPinnedThreadsResult) a.k(), this.f10403g.a());
        return a;
    }

    protected final OperationResult mo379z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbInsertThreadsHandler) this.f10411o.get()).m11017a((UnpinThreadParams) operationParams.c.getParcelable("unpinThreadParams"));
        OperationResult a = blueServiceHandler.a(operationParams);
        ((DbInsertThreadsHandler) this.f10411o.get()).m11010a((FetchPinnedThreadsResult) a.k(), this.f10403g.a());
        return a;
    }

    @Inject
    DbServiceHandler(DbFetchThreadsHandler dbFetchThreadsHandler, DbThreadsPropertyUtil dbThreadsPropertyUtil, Provider<ThreadsDatabaseSupplier> provider, ViewerContextManager viewerContextManager, Provider<Boolean> provider2, Clock clock, MessagesBroadcaster messagesBroadcaster, MessagingPerformanceLogger messagingPerformanceLogger, DebugOverlayController debugOverlayController, FbSharedPreferences fbSharedPreferences, Provider<User> provider3) {
        super("DbServiceHandler");
        this.f10398b = dbFetchThreadsHandler;
        this.f10399c = dbThreadsPropertyUtil;
        this.f10400d = provider;
        this.f10401e = viewerContextManager;
        this.f10402f = provider2;
        this.f10403g = clock;
        this.f10404h = messagesBroadcaster;
        this.f10405i = messagingPerformanceLogger;
        this.f10406j = debugOverlayController;
        this.f10407k = fbSharedPreferences;
        this.f10408l = provider3;
    }

    protected final OperationResult mo361h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadResult fetchThreadResult;
        try {
            OperationResult a;
            ((DbSendHandler) this.f10409m.get()).m11033a();
            SendMessageByRecipientsParams sendMessageByRecipientsParams = (SendMessageByRecipientsParams) operationParams.b().getParcelable("createThreadParams");
            Message a2 = sendMessageByRecipientsParams.m17178a();
            if (sendMessageByRecipientsParams.m17179d() && a2 != null && a2.s == Publicity.b) {
                a = m11039a(a2);
            } else {
                a = blueServiceHandler.a(operationParams);
            }
            fetchThreadResult = (FetchThreadResult) a.k();
            if (fetchThreadResult != null) {
                ((DbInsertThreadsHandler) this.f10411o.get()).m11012a(fetchThreadResult);
            }
            return a;
        } catch (Throwable e) {
            Throwable th = e;
            Message message = th.failedMessage;
            if (message.b != null && message.b.a == Type.ONE_TO_ONE) {
                fetchThreadResult = ((DbFetchThreadHandler) this.f10410n.get()).a(message.b, 1);
                if (!(fetchThreadResult == null || fetchThreadResult.f17180c == null || fetchThreadResult.f17180c.a == null)) {
                    message = Message.newBuilder().a(message).a(fetchThreadResult.f17180c.a).R();
                    if (message.w.b.shouldNotBeRetried) {
                        this.f10404h.b(message);
                    } else {
                        this.f10404h.a(message);
                    }
                    ((DbSendHandler) this.f10409m.get()).m11038c(message);
                    throw new SendMessageException(th, message);
                }
            }
            throw th;
        }
    }

    protected final OperationResult mo360g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbSendHandler) this.f10409m.get()).m11033a();
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a.b("fetchPinnedThreadsResult");
        ((DbInsertThreadsHandler) this.f10411o.get()).m11012a((FetchThreadResult) a.h());
        ((DbInsertThreadsHandler) this.f10411o.get()).m11010a(fetchPinnedThreadsResult, this.f10403g.a());
        return a;
    }

    protected final OperationResult mo359f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        if (fetchThreadResult != null) {
            ((DbInsertThreadsHandler) this.f10411o.get()).m11012a(fetchThreadResult);
        }
        return a;
    }

    protected final OperationResult mo375v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Preconditions.checkArgument(((SearchThreadNameAndParticipantsParams) operationParams.b().getParcelable("searchThreadNameAndParticipantsParam")).m17167c());
        if (this.f10399c.a(DbThreadProperties.f10471d, 0) > 0) {
            return OperationResult.a();
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        SearchThreadNameAndParticipantsResult searchThreadNameAndParticipantsResult = (SearchThreadNameAndParticipantsResult) a.k();
        TracerDetour.a("DbServiceHandler.handleFetchSuggestedGroups#insertData", 1335830178);
        try {
            ((DbInsertThreadsHandler) this.f10411o.get()).m11016a(searchThreadNameAndParticipantsResult, this.f10403g.a());
            this.f10404h.d();
            return OperationResult.a(a);
        } finally {
            TracerDetour.a(1588235170);
        }
    }

    protected final OperationResult mo355b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        boolean z = true;
        String a = operationParams.a();
        Bundle b = operationParams.b();
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) b.getParcelable("fetchThreadListParams");
        this.f10406j.a(MessagesDebugOverlaySettingsTags.f10825b, "fetchThreadList (DSH).");
        int i = b.getInt("logger_instance_key");
        this.f10405i.b(i);
        DataFreshnessParam a2 = fetchThreadListParams.m17106a();
        TracerDetour.a("DbServiceHandler.handleFetchThreadList", 2097853903);
        try {
            FetchThreadListResult a3 = this.f10398b.m10931a(fetchThreadListParams);
            OperationResult a4;
            if (!((Boolean) this.f10402f.get()).booleanValue() || fetchThreadListParams.m17107b().isMessageRequestFolders() || fetchThreadListParams.m17107b().isSpamOrArchivedFolder()) {
                if (m11047a(a2, a3.f17131a)) {
                    a4 = OperationResult.a(a3);
                } else {
                    long j = a3.f17140j;
                    if (j <= 0) {
                        z = false;
                    }
                    FetchThreadListParamsBuilder a5 = FetchThreadListParams.newBuilder().m17115a(fetchThreadListParams).m17112a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).m17114a(fetchThreadListParams.m17107b());
                    if (!z) {
                        j = -1;
                    }
                    Parcelable h = a5.m17111a(j).m17113a(fetchThreadListParams.m17110g()).m17116h();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fetchThreadListParams", h);
                    OperationResult a6 = blueServiceHandler.a(new OperationParams(a, bundle));
                    FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) a6.k();
                    TracerDetour.a("DbServiceHandler.handleFetchThreadList#insertData", 1997096298);
                    try {
                        ((DbInsertThreadsHandler) this.f10411o.get()).m11025b(fetchThreadListResult);
                        this.f10405i.d(i);
                        TracerDetour.a(590660981);
                        if (z) {
                            a4 = OperationResult.a(FetchThreadListResult.newBuilder().m17124a(this.f10398b.m10931a(fetchThreadListParams)).m17122a(fetchThreadListResult.f17138h).m17129m());
                        } else {
                            a4 = a6;
                        }
                    } catch (Throwable th) {
                        TracerDetour.a(-1046230196);
                    }
                }
                TracerDetour.a(472396345);
                return a4;
            }
            if (this.f10399c.a(DbThreadProperties.f10476i) != null) {
                z = false;
            }
            FetchThreadListResult m = FetchThreadListResult.newBuilder().m17124a(a3).m17119a(DataFetchDisposition.newBuilder().a(DataSource.LOCAL_DISK_CACHE).a(TriState.YES).b(TriState.NO).e(TriState.valueOf(z)).f(TriState.NO).h()).m17118a(this.f10403g.a()).m17129m();
            this.f10405i.b(i);
            a4 = OperationResult.a(m);
            return a4;
        } finally {
            TracerDetour.a(-1042263870);
        }
    }

    protected final OperationResult mo356c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f10406j.a(MessagesDebugOverlaySettingsTags.f10825b, "fetchMoreThreads (DSH).");
        FetchMoreThreadsParams fetchMoreThreadsParams = (FetchMoreThreadsParams) operationParams.c.getParcelable("fetchMoreThreadsParams");
        FetchMoreThreadsResult a = this.f10398b.m10929a(fetchMoreThreadsParams);
        if (a.f17091c.d || a.f17091c.e() == fetchMoreThreadsParams.f17087e) {
            return OperationResult.a(a);
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        ((DbInsertThreadsHandler) this.f10411o.get()).m11009a((FetchMoreThreadsResult) a2.k());
        return a2;
    }

    protected final OperationResult mo357d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((DbSendHandler) this.f10409m.get()).m11033a();
        Bundle b = operationParams.b();
        CallerContext f = operationParams.f();
        int i = b.getInt("logger_instance_key");
        this.f10405i.j(i);
        FetchThreadParams fetchThreadParams = (FetchThreadParams) b.getParcelable("fetchThreadParams");
        this.f10406j.a(MessagesDebugOverlaySettingsTags.f10825b, "fetchThread (DSH). " + fetchThreadParams.m17130a().a());
        DataFreshnessParam b2 = fetchThreadParams.m17131b();
        int f2 = fetchThreadParams.m17133f();
        ThreadCriteria a = fetchThreadParams.m17130a();
        TracerDetour.a("DbServiceHandler.handleFetchThread", 406675370);
        try {
            long a2 = SystemClock.b().a();
            FetchThreadResult a3 = ((DbFetchThreadHandler) this.f10410n.get()).a(a, f2);
            a2 = SystemClock.b().a() - a2;
            Map hashMap = new HashMap();
            hashMap.put("fetch_location", FetchLocation.THREAD_DB.toString());
            hashMap.put("thread_db_duration", Long.toString(a2));
            a3.f17185h = hashMap;
            boolean z;
            if (a3.f17180c != null) {
                z = a3.f17180c.G;
            } else {
                z = false;
            }
            OperationResult a4;
            if (((Boolean) this.f10402f.get()).booleanValue() && a3.f17180c != null && a3.f17181d.a(f2) && r2) {
                a4 = OperationResult.a(FetchThreadResult.m17150b().m17142a(DataFetchDisposition.newBuilder().a(DataSource.LOCAL_DISK_CACHE).a(TriState.YES).b(TriState.NO).f(TriState.NO).h()).m17144a(a3.f17180c).m17143a(a3.f17181d).m17146a(hashMap).m17145a(a3.f17182e).m17141a(this.f10403g.a()).m17147a());
                return a4;
            }
            if (b2 == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                a4 = OperationResult.a(a3);
            } else {
                OperationResult a5;
                FetchThreadResult fetchThreadResult;
                FetchThreadResult a6 = m11042a(fetchThreadParams, f, a3, blueServiceHandler);
                if (a6 != null) {
                    a5 = OperationResult.a(a6);
                    fetchThreadResult = a6;
                } else {
                    ((FetchThreadTracer) this.f10415s.get()).m7982a(FetchThreadHandlerChange.m17099a(ChangeReason.NOT_MOSTLY_CACHED));
                    a6 = (FetchThreadResult) blueServiceHandler.a(operationParams).k();
                    SQLiteDatabase a7 = ((ThreadsDatabaseSupplier) this.f10400d.get()).a();
                    SQLiteDetour.a(a7, 335681161);
                    try {
                        if (a6.f17180c != null) {
                            m11045a(m11041a(a3.f17181d), a6);
                            ((DbInsertThreadsHandler) this.f10411o.get()).m11014a(a3, a6);
                        }
                        a7.setTransactionSuccessful();
                        SQLiteDetour.b(a7, -1516168445);
                        Map map = a6.f17185h;
                        Map hashMap2 = new HashMap();
                        if (map != null) {
                            hashMap2.putAll(map);
                        }
                        hashMap2.put("thread_db_duration", Long.toString(a2));
                        a6.f17185h = hashMap2;
                        this.f10405i.l(i);
                        if (a6.f17180c != null) {
                            a6 = FetchThreadResult.m17149a(((DbFetchThreadHandler) this.f10410n.get()).a(a6.f17180c.a, f2)).m17146a(hashMap2).m17142a(DataFetchDisposition.b).m17147a();
                        } else {
                            a6 = FetchThreadResult.m17149a(a6).m17146a(hashMap2).m17142a(DataFetchDisposition.b).m17147a();
                        }
                        a5 = OperationResult.a(a6);
                        fetchThreadResult = a6;
                    } catch (Throwable th) {
                        SQLiteDetour.b(a7, -274710110);
                    }
                }
                if (fetchThreadResult.f17181d != null) {
                    ((MediaDownloadManager) this.f10414r.get()).m12179a(fetchThreadResult.f17181d.b());
                }
                a4 = a5;
            }
            TracerDetour.a(-226719118);
            return a4;
        } finally {
            TracerDetour.a(-355813987);
        }
    }

    protected final OperationResult mo362i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) operationParams.b().getParcelable("fetchMoreMessagesParams");
        ThreadKey a = fetchMoreMessagesParams.m17086a();
        this.f10406j.a(MessagesDebugOverlaySettingsTags.f10825b, "fetchMoreMessages (DSH). " + a);
        long c = fetchMoreMessagesParams.m17087c();
        int d = fetchMoreMessagesParams.m17088d();
        TracerDetour.a("DbServiceHandler.handleFetchThread", -1262382082);
        try {
            FetchMoreMessagesResult a2 = ((DbFetchThreadHandler) this.f10410n.get()).a(a, 0, c, d);
            MessagesCollection messagesCollection = a2.f17072c;
            if (a2 == FetchMoreMessagesResult.f17070a || !(messagesCollection.b().size() == d || messagesCollection.e())) {
                OperationResult a3 = blueServiceHandler.a(operationParams);
                ((DbInsertThreadsHandler) this.f10411o.get()).m11008a(a2, (FetchMoreMessagesResult) a3.k());
                TracerDetour.a(-1073231489);
                return a3;
            }
            OperationResult a4 = OperationResult.a(a2);
            return a4;
        } finally {
            TracerDetour.a(1371824390);
        }
    }

    protected final OperationResult mo363j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        RemoveMemberParams removeMemberParams = (RemoveMemberParams) operationParams.b().getParcelable("removeMemberParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        SQLiteDatabase a2 = ((ThreadsDatabaseSupplier) this.f10400d.get()).a();
        SQLiteDetour.a(a2, 174589701);
        if (fetchThreadResult != null) {
            try {
                ((DbInsertThreadsHandler) this.f10411o.get()).m11012a(fetchThreadResult);
                if (!((ThreadParticipantUtils) this.f10413q.get()).m10161c(fetchThreadResult.f17180c)) {
                    ((DbInsertThreadsHandler) this.f10411o.get()).m11001a(fetchThreadResult.f17180c.a);
                }
            } catch (Throwable th) {
                SQLiteDetour.b(a2, 909250448);
            }
        }
        if (removeMemberParams.m17166c()) {
            ((DbInsertThreadsHandler) this.f10411o.get()).m11010a((FetchPinnedThreadsResult) a.b("fetchPinnedThreadsResult"), this.f10403g.a());
        }
        a2.setTransactionSuccessful();
        SQLiteDetour.b(a2, 1003477784);
        return a;
    }

    protected final OperationResult mo369p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchThreadResult fetchThreadResult = (FetchThreadResult) blueServiceHandler.a(operationParams).k();
        if (fetchThreadResult != null) {
            ((DbInsertThreadsHandler) this.f10411o.get()).m11012a(fetchThreadResult);
        }
        return OperationResult.a(fetchThreadResult);
    }

    protected final OperationResult mo338B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String a = operationParams.a();
        TracerDetour.a("DbServiceHandler.handleFetchBootstrappingDeliveryReceipts", 1720056861);
        try {
            int i;
            ThreadSummary threadSummary;
            OperationResult a2;
            ImmutableList b = this.f10398b.m10936b();
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = b.size();
            for (i = 0; i < size; i++) {
                threadSummary = (ThreadSummary) b.get(i);
                if (!m11049a(threadSummary)) {
                    builder.c(threadSummary.a);
                }
            }
            ImmutableList b2 = builder.b();
            if (b2.isEmpty()) {
                a2 = OperationResult.a();
            } else {
                Parcelable fetchDeliveryReceiptsParams = new FetchDeliveryReceiptsParams(b2);
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchDeliveryReceiptsParams", fetchDeliveryReceiptsParams);
                FetchDeliveryReceiptsResult fetchDeliveryReceiptsResult = (FetchDeliveryReceiptsResult) blueServiceHandler.a(new OperationParams(a, bundle)).k();
                ArrayList a3 = Lists.a();
                b = fetchDeliveryReceiptsResult.f17046a;
                int size2 = b.size();
                for (i = 0; i < size2; i++) {
                    ThreadDeliveryReceipts threadDeliveryReceipts = (ThreadDeliveryReceipts) b.get(i);
                    threadSummary = ((DbInsertThreadsHandler) this.f10411o.get()).m10988a(threadDeliveryReceipts.a(), threadDeliveryReceipts.b());
                    if (threadSummary != null) {
                        a3.add(threadSummary);
                    }
                }
                a2 = OperationResult.a(a3);
                TracerDetour.a(-1057885152);
            }
            return a2;
        } finally {
            TracerDetour.a(1651279525);
        }
    }

    private static boolean m11049a(ThreadSummary threadSummary) {
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((ThreadParticipant) immutableList.get(i)).d > 0) {
                return true;
            }
        }
        return false;
    }

    private FetchThreadResult m11042a(FetchThreadParams fetchThreadParams, CallerContext callerContext, FetchThreadResult fetchThreadResult, BlueServiceHandler blueServiceHandler) {
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        MessagesCollection messagesCollection = fetchThreadResult.f17181d;
        Map map = fetchThreadResult.f17185h;
        if (threadSummary == null || messagesCollection == null || messagesCollection.f()) {
            return null;
        }
        if (fetchThreadParams.m17131b() == DataFreshnessParam.STALE_DATA_OKAY) {
            return fetchThreadResult;
        }
        try {
            m11043a(fetchThreadParams, m11051b(fetchThreadParams, callerContext, fetchThreadResult, blueServiceHandler), blueServiceHandler);
            return FetchThreadResult.m17149a(((DbFetchThreadHandler) this.f10410n.get()).a(threadSummary.a, fetchThreadParams.m17133f())).m17142a(DataFetchDisposition.b).m17147a();
        } catch (IOException e) {
            if (fetchThreadParams.m17132c() != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
                return FetchThreadResult.m17150b().m17142a(DataFetchDisposition.i).m17144a(fetchThreadResult.f17180c).m17143a(fetchThreadResult.f17181d).m17146a(map).m17145a(fetchThreadResult.f17182e).m17141a(fetchThreadResult.f17183f).m17147a();
            }
            throw e;
        }
    }

    private FetchThreadResult m11051b(FetchThreadParams fetchThreadParams, CallerContext callerContext, FetchThreadResult fetchThreadResult, BlueServiceHandler blueServiceHandler) {
        if (!m11048a(fetchThreadParams.m17131b(), fetchThreadResult)) {
            return fetchThreadResult;
        }
        MessagesCollection messagesCollection = fetchThreadResult.f17181d;
        Message a = m11041a(messagesCollection);
        long j = -1;
        if (a != null) {
            j = a.g - 1;
        }
        Parcelable i = new FetchThreadParamsBuilder().m17138a(fetchThreadParams).m17136a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).m17139b(j).m17140i();
        ((FetchThreadTracer) this.f10415s.get()).m7982a(FetchThreadHandlerChange.m17099a(ChangeReason.NEED_MORE_RECENT_MESSAGES));
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchThreadParams", i);
        FetchThreadResult fetchThreadResult2 = (FetchThreadResult) blueServiceHandler.a(new OperationParams("fetch_thread", bundle, null, null, callerContext, null)).k();
        SQLiteDatabase a2 = ((ThreadsDatabaseSupplier) this.f10400d.get()).a();
        SQLiteDetour.a(a2, 1213790269);
        try {
            m11045a(a, fetchThreadResult2);
            ((DbInsertThreadsHandler) this.f10411o.get()).m11014a(fetchThreadResult, fetchThreadResult2);
            a2.setTransactionSuccessful();
            MessagesCollection b = ((MessagesCollectionMerger) this.f10416t.get()).b(fetchThreadResult2.f17181d, messagesCollection);
            return FetchThreadResult.m17150b().m17142a(DataFetchDisposition.b).m17144a(fetchThreadResult2.f17180c).m17143a(b).m17145a(fetchThreadResult2.f17182e).m17141a(this.f10403g.a()).m17147a();
        } finally {
            SQLiteDetour.b(a2, -1301736220);
        }
    }

    @Nullable
    private static Message m11041a(@Nullable MessagesCollection messagesCollection) {
        if (messagesCollection == null) {
            return null;
        }
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) immutableList.get(i);
            if (!message.o) {
                return message;
            }
        }
        return null;
    }

    private void m11045a(@Nullable Message message, FetchThreadResult fetchThreadResult) {
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        if (threadSummary != null) {
            Message c = fetchThreadResult.f17181d == null ? null : fetchThreadResult.f17181d.c();
            if (c != null) {
                Object obj;
                UserKey userKey = new UserKey(User.Type.FACEBOOK, this.f10401e.d().mUserId);
                if (message == null || message.g < c.g) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!c.e.a() || c.e.b.equals(userKey)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null && threadSummary.f()) {
                        ((DefaultSendDeliveryReceiptManager) this.f10412p.get()).m11275a(c, "FETCH_THREAD");
                    }
                }
            }
        }
    }

    private static boolean m11048a(DataFreshnessParam dataFreshnessParam, FetchThreadResult fetchThreadResult) {
        if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            return true;
        }
        return fetchThreadResult.f17179b.o.asBoolean(false);
    }

    private FetchThreadResult m11043a(FetchThreadParams fetchThreadParams, FetchThreadResult fetchThreadResult, BlueServiceHandler blueServiceHandler) {
        if (fetchThreadResult.f17181d.c) {
            return fetchThreadResult;
        }
        ThreadSummary threadSummary = fetchThreadResult.f17180c;
        MessagesCollection messagesCollection = fetchThreadResult.f17181d;
        int g = fetchThreadParams.f17160f - messagesCollection.g();
        if (g <= 0) {
            return fetchThreadResult;
        }
        Message d = messagesCollection.d();
        Parcelable fetchMoreMessagesParams = new FetchMoreMessagesParams(threadSummary.a, d.a, d.c, g + 1);
        ((FetchThreadTracer) this.f10415s.get()).m7982a(FetchThreadHandlerChange.m17099a(ChangeReason.NEED_OLDER_MESSAGES));
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchMoreMessagesParams", fetchMoreMessagesParams);
        FetchMoreMessagesResult fetchMoreMessagesResult = (FetchMoreMessagesResult) blueServiceHandler.a(new OperationParams("fetch_more_messages", bundle)).k();
        ((DbInsertThreadsHandler) this.f10411o.get()).m11013a(fetchThreadResult, fetchMoreMessagesResult);
        MessagesCollection b = ((MessagesCollectionMerger) this.f10416t.get()).b(messagesCollection, fetchMoreMessagesResult.f17072c);
        FetchThreadResult.Builder b2 = FetchThreadResult.m17150b();
        b2.f17171a = DataFetchDisposition.b;
        b2 = b2;
        b2.f17172b = threadSummary;
        b2 = b2;
        b2.f17173c = b;
        FetchThreadResult.Builder builder = b2;
        builder.f17174d = fetchThreadResult.f17182e;
        builder = builder;
        builder.f17176f = this.f10403g.a();
        return builder.m17147a();
    }

    private boolean m11046a(long j, Message message) {
        if (((DbFetchThreadHandler) this.f10410n.get()).a(j)) {
            return false;
        }
        Message b = ((DbFetchThreadHandler) this.f10410n.get()).b(message.a);
        return b == null || b.o;
    }

    protected final OperationResult mo372s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Message R;
        Bundle bundle = operationParams.c;
        Message message = (Message) bundle.getParcelable("message");
        FolderName folderName = FolderName.INBOX;
        long j = bundle.getLong("prevLastVisibleActionId", -1);
        if (m11046a(j, message)) {
            this.f10399c.b(DbThreadProperties.m11130c(folderName), true);
        }
        if (j == -1 || !((DbFetchThreadHandler) this.f10410n.get()).a(j)) {
            MessageBuilder a = Message.newBuilder().a(message);
            a.o = true;
            R = a.R();
        } else {
            R = message;
        }
        return OperationResult.a(((DbInsertThreadsHandler) this.f10411o.get()).m10998a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, R, null, null, System.currentTimeMillis()), -1));
    }

    protected final OperationResult mo373t(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a.b) {
            SetSettingsParams setSettingsParams = (SetSettingsParams) operationParams.c.getParcelable("setSettingsParams");
            if (setSettingsParams.f17328b != null) {
                this.f10407k.edit().a(MessagingPrefKeys.av, setSettingsParams.f17328b.a()).commit();
            }
        }
        return a;
    }

    protected final OperationResult mo376w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        long j = 0;
        Bundle bundle = operationParams.c;
        FetchPinnedThreadsParams fetchPinnedThreadsParams = (FetchPinnedThreadsParams) bundle.getParcelable("fetchPinnedThreadsParams");
        FetchPinnedThreadsResult a = this.f10398b.m10930a();
        if (fetchPinnedThreadsParams.f17095b == DataFreshnessParam.STALE_DATA_OKAY && a.f17100b > 0) {
            return OperationResult.a(a);
        }
        Object obj;
        if (!a.f17101c.isEmpty()) {
            j = a.f17103e;
        }
        bundle.putParcelable("fetchPinnedThreadsParams", new FetchPinnedThreadsParams(fetchPinnedThreadsParams.f17095b, j));
        OperationResult a2 = blueServiceHandler.a(new OperationParams(operationParams.b, bundle));
        FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a2.k();
        if (fetchPinnedThreadsResult.f17102d && fetchPinnedThreadsResult.f17101c.size() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            ((DbInsertThreadsHandler) this.f10411o.get()).m11010a(fetchPinnedThreadsResult, this.f10403g.a());
        }
        return a2;
    }

    protected final OperationResult mo340D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        AddMontageViewerParams addMontageViewerParams = (AddMontageViewerParams) operationParams.c.getParcelable("addMontageViewerParams");
        if (!(addMontageViewerParams == null || addMontageViewerParams.f17012b == null)) {
            DbInsertThreadsHandler dbInsertThreadsHandler = (DbInsertThreadsHandler) this.f10411o.get();
            UserBuilder a2 = new UserBuilder().a(addMontageViewerParams.f17012b);
            a2.Z = true;
            dbInsertThreadsHandler.m11019a(a2.aa());
        }
        return a;
    }

    protected final OperationResult mo341E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        RemoveMontageViewerParams removeMontageViewerParams = (RemoveMontageViewerParams) operationParams.c.getParcelable("removeMontageViewerParams");
        if (!(removeMontageViewerParams == null || removeMontageViewerParams.f17280b == null)) {
            DbInsertThreadsHandler dbInsertThreadsHandler = (DbInsertThreadsHandler) this.f10411o.get();
            UserBuilder a2 = new UserBuilder().a(removeMontageViewerParams.f17280b);
            a2.Z = false;
            dbInsertThreadsHandler.m11019a(a2.aa());
        }
        return a;
    }

    protected final OperationResult mo351O(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        EditUsernameResult editUsernameResult = (EditUsernameResult) a.k();
        if (editUsernameResult != null) {
            DbInsertThreadsHandler dbInsertThreadsHandler = (DbInsertThreadsHandler) this.f10411o.get();
            UserBuilder a2 = new UserBuilder().a((User) this.f10408l.get());
            a2.l = editUsernameResult.f17044a;
            dbInsertThreadsHandler.m11019a(a2.aa());
        }
        return a;
    }

    protected final OperationResult mo353Q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ImmutableList a = ((FetchEventRemindersMembersParams) operationParams.b().getParcelable(FetchEventRemindersMembersParams.f17047a)).m17084a();
        if (a == null) {
            return OperationResult.a(new FetchEventRemindersMembersResult(ImmutableList.of()));
        }
        ThreadEventReminderMembersIterator threadEventReminderMembersIterator = new ThreadEventReminderMembersIterator(DbThreadEventReminderMembersUtil.m11107a(((ThreadsDatabaseSupplier) this.f10400d.get()).a(), a));
        HashMap hashMap = new HashMap();
        try {
            Iterator it = threadEventReminderMembersIterator.iterator();
            while (it.hasNext()) {
                Result result = (Result) it.next();
                ImmutableMap.Builder builder = (ImmutableMap.Builder) hashMap.get(result.f10559a);
                if (builder == null) {
                    builder = new ImmutableMap.Builder();
                    hashMap.put(result.f10559a, builder);
                }
                builder.b(result.f10560b, result.f10561c);
            }
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ThreadEventReminder threadEventReminder = (ThreadEventReminder) a.get(i);
                if (((ImmutableMap.Builder) hashMap.get(threadEventReminder.a())) == null) {
                    builder2.c(new ThreadEventReminder.Builder(threadEventReminder).a(ImmutableBiMap.a()).g());
                } else {
                    builder2.c(new ThreadEventReminder.Builder(threadEventReminder).a(((ImmutableMap.Builder) hashMap.get(threadEventReminder.a())).b()).g());
                }
            }
            return OperationResult.a(new FetchEventRemindersMembersResult(builder2.b()));
        } finally {
            threadEventReminderMembersIterator.m11151a();
        }
    }

    private static boolean m11047a(DataFreshnessParam dataFreshnessParam, DataFetchDisposition dataFetchDisposition) {
        switch (C11871.f10395a[dataFreshnessParam.ordinal()]) {
            case 1:
                return dataFetchDisposition.l;
            case 2:
                return true;
            case 3:
                return dataFetchDisposition.l && !dataFetchDisposition.o.asBoolean(false);
            default:
                return false;
        }
    }

    private OperationResult m11039a(Message message) {
        int i = 0;
        boolean z = (message == null || message.m == null || message.m.size() <= 1) ? false : true;
        Preconditions.checkArgument(z);
        List arrayList = new ArrayList();
        ImmutableList immutableList = message.m;
        int size = immutableList.size();
        while (i < size) {
            ParticipantInfo participantInfo = (ParticipantInfo) immutableList.get(i);
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = participantInfo;
            arrayList.add(threadParticipantBuilder.f());
            i++;
        }
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.A = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.a = message.b;
        newBuilder = newBuilder;
        newBuilder.h = arrayList;
        newBuilder = newBuilder;
        newBuilder.u = true;
        ThreadSummary V = newBuilder.V();
        MessagesCollection messagesCollection = new MessagesCollection(message.b, ImmutableList.of(message), true);
        FetchThreadResult.Builder b = FetchThreadResult.m17150b();
        b.f17171a = DataFetchDisposition.a;
        b = b;
        b.f17176f = this.f10403g.a();
        b = b;
        b.f17172b = V;
        FetchThreadResult.Builder builder = b;
        builder.f17173c = messagesCollection;
        return OperationResult.a(builder.m17147a());
    }
}
