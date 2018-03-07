package com.facebook.messaging.cache;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.datastore.LoggedInUserAuthDataStoreIncremental;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationParams.Builder;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.threads.FetchThreadLogger;
import com.facebook.messaging.analytics.threads.FetchThreadLogger.FetchLocation;
import com.facebook.messaging.analytics.threads.FetchThreadTracer;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.deliveryreceipt.DefaultSendDeliveryReceiptManager;
import com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptManager;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.NewMessageNotificationFactory;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.service.base.ForwardingBlueServiceHandlerFilter;
import com.facebook.messaging.service.model.AddMontageViewerParams;
import com.facebook.messaging.service.model.AddPinnedThreadParams;
import com.facebook.messaging.service.model.CreateLocalAdminMessageParams;
import com.facebook.messaging.service.model.DeleteAllTincanThreadsResult;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.EditUsernameResult;
import com.facebook.messaging.service.model.FetchEventRemindersMembersParams;
import com.facebook.messaging.service.model.FetchEventRemindersMembersResult;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledParams;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledResult;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadHandlerChange;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsParams;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkFolderSeenResult;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.ReadReceiptParams;
import com.facebook.messaging.service.model.ReceiptResult;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.messaging.service.model.RemoveMontageViewerParams;
import com.facebook.messaging.service.model.SaveDraftParams;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.service.model.UnpinThreadParams;
import com.facebook.messaging.service.model.UpdateFolderCountsParams;
import com.facebook.messaging.service.model.UpdateFolderCountsResult;
import com.facebook.messaging.service.model.UpdateMessageSendErrorParams;
import com.facebook.messaging.service.model.UpdatePinnedThreadsParams;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.broadcast.UserInfoBroadcaster;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: method= */
public class CacheServiceHandler extends ForwardingBlueServiceHandlerFilter {
    private static final Class<?> f9465a = CacheServiceHandler.class;
    public final ThreadsCache f9466b;
    private final MessagesBroadcaster f9467c;
    private final CacheFetchThreadsHandler f9468d;
    private final Lazy<CacheInsertThreadsHandler> f9469e;
    private final GloballyDeletedMessagesPlaceholderCache f9470f;
    private final Provider<MessagesNotificationClient> f9471g;
    private final FetchThreadTracer f9472h;
    private final MessagingPerformanceLogger f9473i;
    private final DebugOverlayController f9474j;
    private final FetchThreadLogger f9475k;
    private final Provider<User> f9476l;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<LoggedInUserAuthDataStoreIncremental> f9477m = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<UserInfoBroadcaster> f9478n = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<SendDeliveryReceiptManager> f9479o = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<NewMessageNotificationFactory> f9480p = UltralightRuntime.b;

    final void m10047a(Lazy<LoggedInUserAuthDataStoreIncremental> lazy, Lazy<UserInfoBroadcaster> lazy2, Lazy<SendDeliveryReceiptManager> lazy3, Lazy<NewMessageNotificationFactory> lazy4) {
        this.f9477m = lazy;
        this.f9478n = lazy2;
        this.f9479o = lazy3;
        this.f9480p = lazy4;
    }

    protected final OperationResult mo339C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        UpdateMessageSendErrorParams updateMessageSendErrorParams = (UpdateMessageSendErrorParams) operationParams.c.getParcelable("updatedMessageSendErrorParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f9466b.a(updateMessageSendErrorParams);
        this.f9467c.a(updateMessageSendErrorParams.f17342c);
        return a;
    }

    protected final OperationResult mo340D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        AddMontageViewerParams addMontageViewerParams = (AddMontageViewerParams) operationParams.c.getParcelable("addMontageViewerParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        if (!(addMontageViewerParams == null || addMontageViewerParams.f17012b == null)) {
            CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
            UserBuilder a2 = new UserBuilder().a(addMontageViewerParams.f17012b);
            a2.Z = true;
            a2 = a2;
            a2.X = SystemClock.a.a();
            cacheInsertThreadsHandler.m9935a(a2.aa());
            ((UserInfoBroadcaster) this.f9478n.get()).a(addMontageViewerParams.f17012b.T);
        }
        return a;
    }

    protected final OperationResult mo341E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        RemoveMontageViewerParams removeMontageViewerParams = (RemoveMontageViewerParams) operationParams.c.getParcelable("removeMontageViewerParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        if (!(removeMontageViewerParams == null || removeMontageViewerParams.f17280b == null)) {
            CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
            UserBuilder a2 = new UserBuilder().a(removeMontageViewerParams.f17280b);
            a2.Z = false;
            a2 = a2;
            a2.X = SystemClock.a.a();
            cacheInsertThreadsHandler.m9935a(a2.aa());
            ((UserInfoBroadcaster) this.f9478n.get()).a(removeMontageViewerParams.f17280b.T);
        }
        return a;
    }

    protected final OperationResult mo344H(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        if (bundle == null) {
            return OperationResult.a(new NullPointerException("operationParams.getBundle() is null"));
        }
        CreateLocalAdminMessageParams createLocalAdminMessageParams = (CreateLocalAdminMessageParams) bundle.getParcelable("createLocalAdminMessageParams");
        if (createLocalAdminMessageParams == null || createLocalAdminMessageParams.f17022a == null) {
            return OperationResult.a(new NullPointerException("adminMessage is null"));
        }
        OperationResult S = m10035S(operationParams, blueServiceHandler);
        if (!S.b) {
            return S;
        }
        if (((FetchThreadResult) S.h()).f17180c == null) {
            return OperationResult.a(ErrorCode.OTHER, "empty thread");
        }
        Message message = createLocalAdminMessageParams.f17022a;
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f9466b.a(message, null, -1);
        this.f9467c.a(message.b);
        return a;
    }

    protected final OperationResult mo345I(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        Message message = (Message) bundle.getParcelable("message");
        OperationResult a = blueServiceHandler.a(operationParams);
        NewMessageResult newMessageResult = (NewMessageResult) a.k();
        if (newMessageResult != null) {
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9933a(newMessageResult);
            String string = bundle.getString("delete_msg_id");
            if (string != null) {
                Message b = this.f9466b.b(string);
                if (b != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("deleteMessagesParams", new DeleteMessagesParams(ImmutableSet.of(string), ServerParam.CLIENT_ONLY, b.b));
                    Builder a2 = OperationParams.g().a(operationParams);
                    a2.b = "delete_messages";
                    a2 = a2;
                    a2.c = bundle2;
                    mo368o(a2.g(), blueServiceHandler);
                }
            }
            this.f9467c.a(message.b);
            if (bundle.getBoolean("should_show_notification", true)) {
                ((MessagesNotificationClient) this.f9471g.get()).m13121a(((NewMessageNotificationFactory) this.f9480p.get()).a(message, message.b, ThreadCustomization.a, bundle.getBoolean("only_notify_from_chathead", false) ? new PushProperty(PushSource.SMS_READONLY_MODE) : new PushProperty(PushSource.SMS_DEFAULT_APP), TriState.UNSET));
            }
        }
        return a;
    }

    protected final OperationResult mo352P(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchIsThreadQueueEnabledParams fetchIsThreadQueueEnabledParams = (FetchIsThreadQueueEnabledParams) operationParams.c.getParcelable(FetchIsThreadQueueEnabledParams.f17060a);
        OperationResult a = blueServiceHandler.a(operationParams);
        ThreadSummary a2 = this.f9466b.a(fetchIsThreadQueueEnabledParams.f17061b);
        if (a2 != null) {
            FetchIsThreadQueueEnabledResult fetchIsThreadQueueEnabledResult = (FetchIsThreadQueueEnabledResult) a.k();
            Preconditions.checkNotNull(fetchIsThreadQueueEnabledResult);
            ThreadSummaryBuilder a3 = ThreadSummary.newBuilder().a(a2);
            a3.T = TriState.valueOf(fetchIsThreadQueueEnabledResult.f17062a);
            this.f9466b.a(a3.V(), SystemClock.a.a());
            this.f9467c.a(a2.a);
        }
        return a;
    }

    protected final OperationResult mo353Q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchEventRemindersMembersParams fetchEventRemindersMembersParams = (FetchEventRemindersMembersParams) operationParams.c.getParcelable(FetchEventRemindersMembersParams.f17047a);
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchEventRemindersMembersResult fetchEventRemindersMembersResult = (FetchEventRemindersMembersResult) a.k();
        if (fetchEventRemindersMembersResult == null || fetchEventRemindersMembersResult.f17050a == null) {
            return a;
        }
        this.f9466b.a(fetchEventRemindersMembersResult.f17050a);
        this.f9467c.e(fetchEventRemindersMembersParams.f17048b);
        return OperationResult.a(a);
    }

    protected final OperationResult mo363j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        RemoveMemberParams removeMemberParams = (RemoveMemberParams) operationParams.c.getParcelable("removeMemberParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        if (!(fetchThreadResult == null || fetchThreadResult.f17180c == null)) {
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9938b(fetchThreadResult);
            ThreadSummary threadSummary = fetchThreadResult.f17180c;
            if (!threadSummary.w) {
                this.f9467c.c(ImmutableList.of(threadSummary.a));
            }
        }
        if (removeMemberParams.f17276a) {
            FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a.b("fetchPinnedThreadsResult");
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a(fetchPinnedThreadsResult, false);
            m10036a(fetchPinnedThreadsResult);
        }
        return a;
    }

    protected final OperationResult mo364k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        MarkThreadsParams markThreadsParams = (MarkThreadsParams) operationParams.c.getParcelable("markThreadsParams");
        HashMultimap u = HashMultimap.u();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = markThreadsParams.f17217c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MarkThreadFields markThreadFields = (MarkThreadFields) immutableList.get(i);
            Object obj = markThreadFields.f17209f;
            if (obj == null) {
                obj = FolderName.INBOX;
            }
            u.a(obj, markThreadFields);
            if (markThreadFields.f17205b) {
                builder.c(markThreadFields.f17204a);
            }
        }
        Mark mark = markThreadsParams.f17215a;
        for (FolderName folderName : u.p()) {
            CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
            MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
            markThreadsParamsBuilder.f17212a = mark;
            markThreadsParamsBuilder = markThreadsParamsBuilder;
            markThreadsParamsBuilder.f17214c.b(ImmutableList.copyOf(u.a(folderName)));
            cacheInsertThreadsHandler.m9922a(folderName, markThreadsParamsBuilder.m17154a());
        }
        ImmutableList b = builder.b();
        if (!b.isEmpty()) {
            if (mark == Mark.READ) {
                this.f9467c.b(b);
            } else if (mark == Mark.ARCHIVED || mark == Mark.SPAM) {
                this.f9467c.c(b);
            }
        }
        if (!u.n()) {
            this.f9467c.b();
        }
        return blueServiceHandler.a(operationParams);
    }

    protected final OperationResult mo366m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        DeleteThreadsParams deleteThreadsParams = (DeleteThreadsParams) operationParams.c.getParcelable("deleteThreadsParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9923a(FolderName.INBOX, deleteThreadsParams.f17036a);
        return a;
    }

    protected final OperationResult mo368o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Iterator it = ((DeleteMessagesParams) operationParams.c.getParcelable("deleteMessagesParams")).f17026b.iterator();
        while (it.hasNext()) {
            this.f9470f.f9511i.add((String) it.next());
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        DeleteMessagesResult deleteMessagesResult = (DeleteMessagesResult) a.k();
        ThreadKey threadKey = deleteMessagesResult.f17030c;
        if (threadKey == null) {
            return a;
        }
        if (this.f9466b.a(threadKey) == null) {
            return a;
        }
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9921a(FolderName.INBOX, deleteMessagesResult);
        this.f9467c.a(threadKey, deleteMessagesResult.f17031d, deleteMessagesResult.f17032e.values());
        if (!deleteMessagesResult.f17034g) {
            this.f9467c.a(threadKey);
        }
        return a;
    }

    protected final OperationResult mo372s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        PushProperty pushProperty = (PushProperty) operationParams.c.getParcelable("pushProperty");
        ThreadKey threadKey = ((Message) operationParams.c.getParcelable("message")).b;
        ThreadSummary a = this.f9466b.a(threadKey);
        if (a == null) {
            FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
            fetchThreadParamsBuilder.f17164b = DataFreshnessParam.DO_NOT_CHECK_SERVER;
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.f17163a = ThreadCriteria.a(threadKey);
            fetchThreadParamsBuilder = fetchThreadParamsBuilder;
            fetchThreadParamsBuilder.f17168f = 20;
            Parcelable i = fetchThreadParamsBuilder.m17140i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadParams", i);
            Builder a2 = OperationParams.g().a(operationParams);
            a2.b = "fetch_thread";
            a2 = a2;
            a2.c = bundle;
            a = ((FetchThreadResult) mo357d(a2.g(), blueServiceHandler).k()).f17180c;
        }
        ThreadSummary threadSummary = a;
        OperationResult a3 = blueServiceHandler.a(operationParams);
        NewMessageResult newMessageResult = (NewMessageResult) a3.k();
        if (newMessageResult != null) {
            Message message = newMessageResult.f17253a;
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9939b(newMessageResult);
            this.f9467c.a(message.b);
            DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager = (DefaultSendDeliveryReceiptManager) this.f9479o.get();
            if (!(threadSummary == null || defaultSendDeliveryReceiptManager.f10847g != Product.MESSENGER || message.e == null || !message.e.a() || defaultSendDeliveryReceiptManager.f10845e.P(message))) {
                String pushSource = pushProperty.a == null ? null : pushProperty.a.toString();
                String str = pushProperty.b;
                defaultSendDeliveryReceiptManager.m11275a(message, pushSource);
            }
        }
        return a3;
    }

    protected final OperationResult mo376w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchPinnedThreadsParams fetchPinnedThreadsParams = (FetchPinnedThreadsParams) operationParams.c.getParcelable("fetchPinnedThreadsParams");
        if (((fetchPinnedThreadsParams.f17095b == DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE && this.f9466b.d()) || fetchPinnedThreadsParams.f17095b == DataFreshnessParam.STALE_DATA_OKAY) && this.f9468d.m9904a().f17103e != 0) {
            return OperationResult.a(this.f9468d.m9904a());
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a.k();
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a(fetchPinnedThreadsResult, false);
        m10036a(fetchPinnedThreadsResult);
        return a;
    }

    protected final OperationResult mo377x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((CacheInsertThreadsHandler) this.f9469e.get()).f9449a.a(((UpdatePinnedThreadsParams) operationParams.c.getParcelable("updatePinnedThreadsParams")).f17343a);
        OperationResult a = blueServiceHandler.a(operationParams);
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a((FetchPinnedThreadsResult) a.k(), false);
        this.f9467c.c();
        return a;
    }

    protected final OperationResult mo378y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        AddPinnedThreadParams addPinnedThreadParams = (AddPinnedThreadParams) operationParams.c.getParcelable("addPinnedThreadParams");
        CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
        if (addPinnedThreadParams.f17013a != null) {
            cacheInsertThreadsHandler.f9449a.g(addPinnedThreadParams.f17013a);
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a((FetchPinnedThreadsResult) a.k(), false);
        this.f9467c.c();
        return a;
    }

    protected final OperationResult mo379z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ((CacheInsertThreadsHandler) this.f9469e.get()).f9449a.h(((UnpinThreadParams) operationParams.c.getParcelable("unpinThreadParams")).f17335a);
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a.k();
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a(fetchPinnedThreadsResult, false);
        m10036a(fetchPinnedThreadsResult);
        return a;
    }

    @Inject
    public CacheServiceHandler(@Assisted String str, @Assisted ThreadsCache threadsCache, MessagesBroadcaster messagesBroadcaster, @Assisted CacheFetchThreadsHandler cacheFetchThreadsHandler, @Assisted Lazy<CacheInsertThreadsHandler> lazy, GloballyDeletedMessagesPlaceholderCache globallyDeletedMessagesPlaceholderCache, Provider<MessagesNotificationClient> provider, FetchThreadTracer fetchThreadTracer, MessagingPerformanceLogger messagingPerformanceLogger, DebugOverlayController debugOverlayController, FetchThreadLogger fetchThreadLogger, Provider<User> provider2) {
        super(str);
        this.f9466b = threadsCache;
        this.f9467c = messagesBroadcaster;
        this.f9468d = cacheFetchThreadsHandler;
        this.f9469e = lazy;
        this.f9470f = globallyDeletedMessagesPlaceholderCache;
        this.f9471g = provider;
        this.f9472h = fetchThreadTracer;
        this.f9473i = messagingPerformanceLogger;
        this.f9474j = debugOverlayController;
        this.f9475k = fetchThreadLogger;
        this.f9476l = provider2;
    }

    protected final OperationResult mo355b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a;
        this.f9474j.a(MessagesDebugOverlaySettingsTags.f10826c, "fetchThreadList (CSH).");
        Bundle bundle = operationParams.c;
        int i = bundle.getInt("logger_instance_key");
        this.f9473i.d.a(5505042, i, (short) 34);
        FetchThreadListParams fetchThreadListParams = (FetchThreadListParams) bundle.getParcelable("fetchThreadListParams");
        FolderName folderName = fetchThreadListParams.f17118b;
        bundle.putInt("logger_instance_key", i);
        new StringBuilder("handleFetchThreadList with freshness=").append(fetchThreadListParams.f17117a.toString());
        FetchThreadListParams a2 = this.f9468d.m9905a(fetchThreadListParams);
        if (fetchThreadListParams != a2) {
            bundle.putParcelable("fetchThreadListParams", a2);
            new StringBuilder("handleFetchThreadList upgraded to ").append(a2.f17117a);
            fetchThreadListParams = a2;
        }
        boolean a3 = this.f9468d.m9908a(folderName, fetchThreadListParams.f17117a);
        new StringBuilder("handleFetchThreadList canServeFromCache=").append(a3);
        if (a3) {
            a = OperationResult.a(this.f9468d.m9906a(folderName));
        } else {
            OperationResult a4 = blueServiceHandler.a(operationParams);
            FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) a4.k();
            if (!fetchThreadListResult.f17131a.r.asBoolean(false)) {
                ((CacheInsertThreadsHandler) this.f9469e.get()).m9931a(fetchThreadListResult);
                this.f9473i.d.a(5505042, i, (short) 29);
                this.f9467c.a();
                ((MessagesNotificationClient) this.f9471g.get()).m13118a(fetchThreadListResult.f17137g);
            }
            a = a4;
        }
        this.f9473i.a(i, ((FetchThreadListResult) a.k()).f17131a);
        return a;
    }

    protected final OperationResult mo356c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f9474j.a(MessagesDebugOverlaySettingsTags.f10826c, "fetchMoreThreads (CSH).");
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchMoreThreadsResult fetchMoreThreadsResult = (FetchMoreThreadsResult) a.k();
        CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
        cacheInsertThreadsHandler.f9460l.a(fetchMoreThreadsResult.f17092d);
        cacheInsertThreadsHandler.f9449a.a(fetchMoreThreadsResult.f17090b, fetchMoreThreadsResult.f17091c, fetchMoreThreadsResult.f17093e);
        cacheInsertThreadsHandler.f9450b.m10142a();
        return a;
    }

    public final OperationResult mo357d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a;
        Bundle b = operationParams.b();
        int i = b.getInt("logger_instance_key");
        this.f9473i.i(i);
        FetchThreadParams fetchThreadParams = (FetchThreadParams) b.getParcelable("fetchThreadParams");
        this.f9474j.a(MessagesDebugOverlaySettingsTags.f10826c, "fetchThread (CSH). " + fetchThreadParams.m17130a().a());
        boolean h = fetchThreadParams.m17134h();
        if (h) {
            this.f9472h.m7981a();
        }
        Map hashMap = new HashMap();
        hashMap.put("fetch_location", FetchLocation.UNKNOWN.toString());
        long a2 = SystemClock.b().a();
        FetchThreadResult a3 = this.f9468d.m9907a(operationParams);
        hashMap.put("thread_cache_duration", Long.toString(SystemClock.b().a() - a2));
        if (a3 != null) {
            hashMap.put("fetch_location", FetchLocation.THREAD_CACHE.toString());
            a = OperationResult.a(a3);
        } else {
            this.f9472h.m7982a(FetchThreadHandlerChange.m17098a());
            b.putInt("logger_instance_key", i);
            OperationResult a4 = blueServiceHandler.a(operationParams);
            FetchThreadResult fetchThreadResult = (FetchThreadResult) a4.k();
            if (fetchThreadResult.f17179b.l) {
                Object obj;
                ThreadSummary threadSummary = fetchThreadResult.f17180c;
                if (threadSummary != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                ThreadSummary threadSummary2 = null;
                if (obj != null) {
                    threadSummary2 = this.f9466b.a(threadSummary.a);
                }
                if (obj != null && threadSummary2 != null && threadSummary.d != -1 && threadSummary.d < threadSummary2.d) {
                    Long.valueOf(threadSummary2.d);
                    Long.valueOf(threadSummary.d);
                    a = a4;
                } else if (threadSummary == null || !ThreadKey.d(threadSummary.a) || ThreadKey.e(threadSummary.a) || fetchThreadResult.f17181d == null || !fetchThreadResult.f17181d.f()) {
                    ((CacheInsertThreadsHandler) this.f9469e.get()).m9917a(fetchThreadParams.m17133f(), fetchThreadResult);
                    this.f9473i.k(i);
                }
            }
            a = a4;
        }
        FetchThreadResult fetchThreadResult2 = (FetchThreadResult) a.h();
        Map map = fetchThreadResult2.f17185h;
        if (map != null) {
            hashMap.putAll(map);
        }
        this.f9475k.m7978a(hashMap);
        if (h) {
            a = OperationResult.a(FetchThreadResult.m17149a(fetchThreadResult2).m17148b(ImmutableList.copyOf(this.f9472h.m7983b())).m17147a());
        }
        this.f9473i.b(i, ((FetchThreadResult) a.h()).f17179b);
        return a;
    }

    protected final OperationResult mo358e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (this.f9468d.m9908a(FolderName.INBOX, DataFreshnessParam.DO_NOT_CHECK_SERVER)) {
            ThreadSummary a = ((FetchThreadKeyByParticipantsParams) operationParams.c.getParcelable("fetch_thread_with_participants_key")).m17102a((List) this.f9468d.m9906a(FolderName.INBOX).f17133c.c);
            if (a != null) {
                return OperationResult.a(new FetchThreadKeyByParticipantsResult(a.a));
            }
        }
        return blueServiceHandler.a(operationParams);
    }

    protected final OperationResult mo361h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        try {
            OperationResult a = blueServiceHandler.a(operationParams);
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9932a((FetchThreadResult) a.k());
            return a;
        } catch (SendMessageException e) {
            if (e.failedMessage.b != null) {
                this.f9466b.a(e.failedMessage);
            }
            throw e;
        }
    }

    protected final OperationResult mo360g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        if (!(fetchThreadResult == null || fetchThreadResult.f17180c == null || ThreadKey.d(fetchThreadResult.f17180c.a))) {
            FetchPinnedThreadsResult fetchPinnedThreadsResult = (FetchPinnedThreadsResult) a.b("fetchPinnedThreadsResult");
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9932a(fetchThreadResult);
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9930a(fetchPinnedThreadsResult, false);
            m10036a(fetchPinnedThreadsResult);
        }
        return a;
    }

    protected final OperationResult mo359f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        if (!(fetchThreadResult == null || fetchThreadResult.f17180c == null)) {
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9938b(fetchThreadResult);
        }
        return a;
    }

    protected final OperationResult mo374u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        ReceiptResult receiptResult = (ReceiptResult) a.k();
        ThreadSummary threadSummary = receiptResult.f17270b;
        if (threadSummary != null) {
            ReadReceiptParams readReceiptParams = (ReadReceiptParams) operationParams.c.getParcelable("readReceiptParams");
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9929a(threadSummary, receiptResult.f17271c);
            this.f9467c.a(threadSummary.a, this.f9467c.a(threadSummary, readReceiptParams.f17268c));
        }
        return a;
    }

    protected final OperationResult mo367n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9923a(FolderName.INBOX, ImmutableList.copyOf(((DeleteAllTincanThreadsResult) a.h()).f17024a));
        return a;
    }

    protected final OperationResult mo369p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) a.k();
        if (!(fetchThreadResult == null || fetchThreadResult.f17180c == null)) {
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9938b(fetchThreadResult);
        }
        return a;
    }

    protected final OperationResult mo371r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        SaveDraftParams saveDraftParams = (SaveDraftParams) operationParams.c.getParcelable("saveDraftParams");
        CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f9469e.get();
        ThreadKey threadKey = saveDraftParams.f17281a;
        MessageDraft messageDraft = saveDraftParams.f17282b;
        ThreadSummary a2 = cacheInsertThreadsHandler.f9449a.a(threadKey);
        if (a2 != null) {
            cacheInsertThreadsHandler.f9449a.a(a2, messageDraft);
        }
        return a;
    }

    protected final OperationResult mo370q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a == null || !a.b) {
            return a;
        }
        MarkFolderSeenResult markFolderSeenResult = (MarkFolderSeenResult) a.k();
        if (markFolderSeenResult == null) {
            return null;
        }
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9918a(markFolderSeenResult.f17197b, markFolderSeenResult.f17196a);
        return a;
    }

    protected final OperationResult mo338B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        List<ThreadSummary> l = a.l();
        if (l != null) {
            for (ThreadSummary threadSummary : l) {
                ThreadKey threadKey = threadSummary.a;
                this.f9466b.a(threadSummary);
            }
        }
        return a;
    }

    protected final OperationResult mo347K(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a == null || !a.b) {
            return null;
        }
        UpdateFolderCountsResult updateFolderCountsResult = (UpdateFolderCountsResult) a.k();
        if (updateFolderCountsResult == null) {
            return null;
        }
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9919a(((UpdateFolderCountsParams) operationParams.c.getParcelable("updateFolderCountsParams")).f17336a, updateFolderCountsResult.f17339a);
        return a;
    }

    protected final OperationResult mo351O(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        EditUsernameResult editUsernameResult = (EditUsernameResult) a.k();
        if (editUsernameResult != null) {
            UserBuilder a2 = new UserBuilder().a((User) this.f9476l.get());
            a2.l = editUsernameResult.f17044a;
            User aa = a2.aa();
            ((LoggedInUserSessionManager) this.f9477m.get()).a(aa);
            ((CacheInsertThreadsHandler) this.f9469e.get()).m9935a(aa);
            UserInfoBroadcaster userInfoBroadcaster = (UserInfoBroadcaster) this.f9478n.get();
            Parcelable parcelable = aa.T;
            Intent intent = new Intent("com.facebook.user.broadcast.ACTION_USERNAME_UPDATED");
            intent.putExtra("updated_user", parcelable);
            userInfoBroadcaster.a.a(intent);
        }
        return a;
    }

    private OperationResult m10035S(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        boolean z = false;
        Bundle bundle = operationParams.c;
        Preconditions.checkArgument(bundle != null);
        CreateLocalAdminMessageParams createLocalAdminMessageParams = (CreateLocalAdminMessageParams) bundle.getParcelable("createLocalAdminMessageParams");
        if (!(createLocalAdminMessageParams == null || createLocalAdminMessageParams.f17022a == null)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        ThreadKey threadKey = createLocalAdminMessageParams.f17022a.b;
        FetchThreadParamsBuilder newBuilder = FetchThreadParams.newBuilder();
        newBuilder.f17163a = ThreadCriteria.a(threadKey);
        newBuilder = newBuilder;
        newBuilder.f17164b = DataFreshnessParam.STALE_DATA_OKAY;
        newBuilder = newBuilder;
        newBuilder.f17168f = 20;
        Parcelable i = newBuilder.m17140i();
        bundle = new Bundle();
        bundle.putParcelable("fetchThreadParams", i);
        Builder a = OperationParams.g().a(operationParams);
        a.b = "fetch_thread";
        a = a;
        a.c = bundle;
        OperationResult d = mo357d(a.g(), blueServiceHandler);
        if (!d.b || !createLocalAdminMessageParams.f17023b || ((FetchThreadResult) d.h()).f17180c != null) {
            return d;
        }
        Parcelable sendMessageByRecipientsParams = new SendMessageByRecipientsParams(null, createLocalAdminMessageParams.f17022a, Collections.singletonList(new UserFbidIdentifier(Long.toString(threadKey.d))));
        sendMessageByRecipientsParams.f17307d = true;
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("createThreadParams", sendMessageByRecipientsParams);
        a = OperationParams.g().a(operationParams);
        a.b = "create_thread";
        a = a;
        a.c = bundle2;
        OperationResult a2 = blueServiceHandler.a(a.g());
        ((CacheInsertThreadsHandler) this.f9469e.get()).m9932a((FetchThreadResult) a2.k());
        return a2;
    }

    private void m10036a(FetchPinnedThreadsResult fetchPinnedThreadsResult) {
        Object obj = (fetchPinnedThreadsResult.f17101c.isEmpty() && fetchPinnedThreadsResult.f17102d) ? 1 : null;
        if (obj == null) {
            this.f9467c.a(fetchPinnedThreadsResult.f17103e);
        }
    }
}
