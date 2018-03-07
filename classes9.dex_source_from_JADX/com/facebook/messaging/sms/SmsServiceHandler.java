package com.facebook.messaging.sms;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationParamsUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.SmsThreadKeyUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.messaging.service.base.ForwardingBlueServiceHandlerFilter;
import com.facebook.messaging.service.model.CreateGroupParams;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsParams;
import com.facebook.messaging.service.model.FetchThreadKeyByParticipantsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.FetchThreadResult.Builder;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.service.model.MarkThreadsParams;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.OfflineThreadingIdCache;
import com.facebook.messaging.sms.defaultapp.send.SmsSender;
import com.facebook.messaging.sms.readonly.AnonymousSmsThreadHelper;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserSmsIdentifier;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: completed_time */
public class SmsServiceHandler extends ForwardingBlueServiceHandlerFilter {
    private final Context f17470a;
    private final MessageSnippetHelper f17471b;
    private final Lazy<SmsThreadManager> f17472c;
    private final SmsMessageLoader f17473d;
    private final Lazy<SmsSender> f17474e;
    private final Clock f17475f;
    private final Lazy<SmsTakeoverAnalyticsLogger> f17476g;
    private final OfflineThreadingIdCache f17477h;

    /* compiled from: completed_time */
    class C20781 implements Function<ThreadKey, Long> {
        final /* synthetic */ SmsServiceHandler f17469a;

        C20781(SmsServiceHandler smsServiceHandler) {
            this.f17469a = smsServiceHandler;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ThreadKey threadKey = (ThreadKey) obj;
            return threadKey == null ? null : Long.valueOf(threadKey.i());
        }
    }

    public static SmsServiceHandler m17446b(InjectorLike injectorLike) {
        return new SmsServiceHandler((Context) injectorLike.getInstance(Context.class), MessageSnippetHelper.b(injectorLike), IdBasedLazy.a(injectorLike, 8446), SmsMessageLoader.m17430a(injectorLike), IdBasedLazy.a(injectorLike, 8474), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2706), OfflineThreadingIdCache.m17547a(injectorLike));
    }

    protected final OperationResult mo369p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ImmutableList immutableList = RegularImmutableList.a;
        if (!ThreadKey.e(((ModifyThreadParams) OperationParamsUtil.a(operationParams, "modifyThreadParams")).f17221a)) {
            return OperationResult.a;
        }
        ThreadSummary a = ((SmsThreadManager) this.f17472c.get()).m17484a(AnonymousSmsThreadHelper.f17729a, null);
        Builder b = FetchThreadResult.m17150b();
        b.f17171a = DataFetchDisposition.e;
        b = b;
        b.f17176f = this.f17475f.a();
        b = b;
        b.f17172b = a;
        Builder builder = b;
        builder.f17174d = immutableList;
        return OperationResult.a(builder.m17147a());
    }

    @Inject
    protected SmsServiceHandler(Context context, MessageSnippetHelper messageSnippetHelper, Lazy<SmsThreadManager> lazy, SmsMessageLoader smsMessageLoader, Lazy<SmsSender> lazy2, Clock clock, Lazy<SmsTakeoverAnalyticsLogger> lazy3, OfflineThreadingIdCache offlineThreadingIdCache) {
        super("SmsServiceHandler");
        this.f17470a = context;
        this.f17471b = messageSnippetHelper;
        this.f17472c = lazy;
        this.f17473d = smsMessageLoader;
        this.f17474e = lazy2;
        this.f17475f = clock;
        this.f17476g = lazy3;
        this.f17477h = offlineThreadingIdCache;
    }

    protected final OperationResult mo355b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleFetchThreadList", -1992304430);
        try {
            OperationResult a = OperationResult.a(((SmsThreadManager) this.f17472c.get()).m17486a((FetchThreadListParams) operationParams.b().getParcelable("fetchThreadListParams")));
            return a;
        } finally {
            TracerDetour.a(1050253808);
        }
    }

    protected final OperationResult mo371r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a;
    }

    protected final OperationResult mo356c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleFetchMoreThreads", -1400805761);
        try {
            OperationResult a = OperationResult.a(((SmsThreadManager) this.f17472c.get()).m17485a((FetchMoreThreadsParams) OperationParamsUtil.a(operationParams, "fetchMoreThreadsParams")));
            return a;
        } finally {
            TracerDetour.a(-2114130474);
        }
    }

    protected final OperationResult mo357d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleFetchThread", 338443844);
        try {
            FetchThreadParams fetchThreadParams = (FetchThreadParams) operationParams.b().getParcelable("fetchThreadParams");
            OperationResult a = OperationResult.a(m17444a(fetchThreadParams.m17130a().a().i(), fetchThreadParams.m17133f()));
            return a;
        } finally {
            TracerDetour.a(1848059140);
        }
    }

    protected final OperationResult mo358e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleFetchThreadKeyByParticipants", -1423373788);
        try {
            Object obj;
            FetchThreadKeyByParticipantsParams fetchThreadKeyByParticipantsParams = (FetchThreadKeyByParticipantsParams) operationParams.b().getParcelable("fetch_thread_with_participants_key");
            Set hashSet = new HashSet(fetchThreadKeyByParticipantsParams.m17105b().size());
            UserKey a = fetchThreadKeyByParticipantsParams.m17103a();
            Iterator it = fetchThreadKeyByParticipantsParams.m17105b().iterator();
            while (it.hasNext()) {
                UserKey userKey = (UserKey) it.next();
                if (!userKey.equals(a)) {
                    if (!userKey.e()) {
                        obj = null;
                        break;
                    }
                    hashSet.add(userKey.g());
                }
            }
            int i = 1;
            OperationResult a2;
            if (obj == null || hashSet.isEmpty()) {
                a2 = OperationResult.a(ErrorCode.OTHER, "Unable to get or create thread key");
                TracerDetour.a(-321964940);
                return a2;
            }
            a2 = OperationResult.a(new FetchThreadKeyByParticipantsResult(ThreadKey.b(SmsThreadKeyUtil.a(this.f17470a, hashSet))));
            return a2;
        } finally {
            TracerDetour.a(-2074829807);
        }
    }

    protected final OperationResult mo362i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleFetchMoreMessages", -8187345);
        try {
            FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) operationParams.b().getParcelable("fetchMoreMessagesParams");
            ThreadKey a = fetchMoreMessagesParams.m17086a();
            long c = fetchMoreMessagesParams.m17087c();
            OperationResult a2 = OperationResult.a(new FetchMoreMessagesResult(DataFetchDisposition.e, m17443a(a.b, fetchMoreMessagesParams.m17088d(), c), this.f17475f.a()));
            return a2;
        } finally {
            TracerDetour.a(-1319413135);
        }
    }

    protected final OperationResult mo364k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleMarkThreads", -1956813237);
        try {
            MarkThreadsParams markThreadsParams = (MarkThreadsParams) operationParams.b().getParcelable("markThreadsParams");
            if (Mark.READ.equals(markThreadsParams.f17215a)) {
                MarkThreadFields markThreadFields;
                if (markThreadsParams.f17217c.size() == 1) {
                    markThreadFields = (MarkThreadFields) markThreadsParams.f17217c.get(0);
                    if (markThreadFields.f17205b) {
                        ((SmsThreadManager) this.f17472c.get()).m17495c(markThreadFields.f17204a.i());
                    } else {
                        ((SmsThreadManager) this.f17472c.get()).m17494b(ImmutableList.of(Long.valueOf(markThreadFields.f17204a.i())));
                    }
                } else {
                    Collection hashSet = new HashSet(markThreadsParams.f17217c.size());
                    ImmutableList immutableList = markThreadsParams.f17217c;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        MarkThreadFields markThreadFields2 = (MarkThreadFields) immutableList.get(i);
                        if (markThreadFields2.f17205b) {
                            hashSet.add(Long.valueOf(markThreadFields2.f17204a.i()));
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        ((SmsThreadManager) this.f17472c.get()).m17490a(hashSet);
                        hashSet.clear();
                    }
                    ImmutableList immutableList2 = markThreadsParams.f17217c;
                    int size2 = immutableList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        markThreadFields = (MarkThreadFields) immutableList2.get(i2);
                        if (!markThreadFields.f17205b) {
                            hashSet.add(Long.valueOf(markThreadFields.f17204a.i()));
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        ((SmsThreadManager) this.f17472c.get()).m17494b(hashSet);
                    }
                }
            }
            OperationResult a = OperationResult.a();
            return a;
        } finally {
            TracerDetour.a(336434122);
        }
    }

    protected final OperationResult mo345I(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleReceivedSms", 963929913);
        try {
            Bundle b = operationParams.b();
            Message message = (Message) b.getParcelable("message");
            if (!b.getBoolean("is_readonly_mode", false)) {
                m17445a(message);
            }
            Message message2 = message;
            OperationResult a = OperationResult.a(new NewMessageResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, message2, m17443a(message.b.b, 20, -1), null, this.f17475f.a()));
            return a;
        } finally {
            TracerDetour.a(-221252501);
        }
    }

    protected final OperationResult mo361h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleCreateThread", 1563958687);
        try {
            SendMessageByRecipientsParams sendMessageByRecipientsParams = (SendMessageByRecipientsParams) operationParams.b().getParcelable("createThreadParams");
            Set hashSet = new HashSet(sendMessageByRecipientsParams.m17180e().size());
            ImmutableList e = sendMessageByRecipientsParams.m17180e();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(((UserSmsIdentifier) ((UserIdentifier) e.get(i))).b());
            }
            long a = SmsThreadKeyUtil.a(this.f17470a, hashSet);
            ((SmsSender) this.f17474e.get()).m17683a(Message.newBuilder().a(sendMessageByRecipientsParams.m17178a()).a(ThreadKey.b(a)).R(), false);
            OperationResult a2 = OperationResult.a(m17444a(a, 20));
            return a2;
        } finally {
            TracerDetour.a(-525425338);
        }
    }

    protected final OperationResult mo360g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleCreateGroup", -1962482707);
        try {
            ImmutableList c = ((CreateGroupParams) operationParams.b().getParcelable("createGroupParams")).m17082c();
            Set<String> hashSet = new HashSet(c.size());
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String userFbidIdentifier : hashSet) {
                builder.c(new UserFbidIdentifier(userFbidIdentifier));
            }
            int size = c.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(((UserIdentifier) c.get(i)).a());
            }
            OperationResult a = OperationResult.a(m17444a(SmsThreadKeyUtil.a(this.f17470a, hashSet), 20));
            return a;
        } finally {
            TracerDetour.a(1959612629);
        }
    }

    protected final OperationResult mo366m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("SmsServiceHandler.handleDeleteThreads", 1213976767);
        try {
            DeleteThreadsParams deleteThreadsParams = (DeleteThreadsParams) operationParams.b().getParcelable("deleteThreadsParams");
            if (!deleteThreadsParams.m17083a().isEmpty()) {
                ((SmsThreadManager) this.f17472c.get()).m17491a(new HashSet(Lists.a(deleteThreadsParams.m17083a(), new C20781(this))));
            }
            OperationResult a = OperationResult.a();
            return a;
        } finally {
            TracerDetour.a(-1140287436);
        }
    }

    protected final OperationResult mo368o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ThreadSummary threadSummary = null;
        boolean z = false;
        TracerDetour.a("SmsServiceHandler.handleDeleteMessages", -564672340);
        try {
            DeleteMessagesParams deleteMessagesParams = (DeleteMessagesParams) operationParams.b().getParcelable("deleteMessagesParams");
            Iterator it = deleteMessagesParams.f17026b.iterator();
            while (it.hasNext()) {
                String b;
                String str = (String) it.next();
                if (str.startsWith("sent.")) {
                    b = this.f17477h.m17550b(str.substring(5));
                } else {
                    b = str;
                }
                ((SmsThreadManager) this.f17472c.get()).m17489a(b);
            }
            if (deleteMessagesParams.f17025a != null) {
                ThreadSummary a = ((SmsThreadManager) this.f17472c.get()).m17484a(deleteMessagesParams.f17025a.i(), null);
                if (this.f17473d.m17442a(deleteMessagesParams.f17025a.i(), 1, -1).isEmpty()) {
                    ((SmsThreadManager) this.f17472c.get()).m17492a(true);
                    z = true;
                }
                if (a == null && r8) {
                    threadSummary = ThreadSummary.newBuilder().a(FolderName.INBOX).a(deleteMessagesParams.f17025a).V();
                } else {
                    threadSummary = a;
                }
            }
            OperationResult a2 = OperationResult.a(new DeleteMessagesResult(threadSummary, deleteMessagesParams.f17025a, deleteMessagesParams.f17026b, new HashMap(0), new HashSet(0), z));
            return a2;
        } finally {
            TracerDetour.a(288529750);
        }
    }

    private FetchThreadResult m17444a(long j, int i) {
        ThreadSummary V;
        MessagesCollection a = m17443a(j, i, -1);
        Map hashMap = new HashMap();
        ThreadSummary a2 = ((SmsThreadManager) this.f17472c.get()).m17484a(j, hashMap);
        Message c = a.c();
        if (c != null) {
            boolean z;
            String str = c.f;
            String str2 = null;
            if (MessageUtil.B(c) && !Strings.isNullOrEmpty(str)) {
                str2 = str;
            } else if (this.f17471b.a(c)) {
                str2 = this.f17471b.a(c, a2.D);
            } else if (Strings.isNullOrEmpty(str)) {
                str2 = this.f17471b.b(c, a2.D);
            }
            ThreadSummaryBuilder a3 = ThreadSummary.newBuilder().a(a2);
            a3.p = str;
            ThreadSummaryBuilder threadSummaryBuilder = a3;
            threadSummaryBuilder.r = str2;
            ThreadSummaryBuilder threadSummaryBuilder2 = threadSummaryBuilder;
            threadSummaryBuilder2.c = c.g;
            threadSummaryBuilder2 = threadSummaryBuilder2;
            threadSummaryBuilder2.f = c.g;
            threadSummaryBuilder2 = threadSummaryBuilder2;
            threadSummaryBuilder2.q = c.e;
            threadSummaryBuilder = threadSummaryBuilder2;
            if (SendError.a.equals(c.w)) {
                z = false;
            } else {
                z = true;
            }
            threadSummaryBuilder.z = z;
            V = threadSummaryBuilder.V();
        } else {
            V = a2;
        }
        Builder b = FetchThreadResult.m17150b();
        b.f17171a = DataFetchDisposition.e;
        b = b;
        b.f17176f = this.f17475f.a();
        b = b;
        b.f17172b = V;
        Builder builder = b;
        builder.f17173c = a;
        builder = builder;
        builder.f17174d = ImmutableList.copyOf(hashMap.values());
        return builder.m17147a();
    }

    private MessagesCollection m17443a(long j, int i, long j2) {
        ImmutableList a = this.f17473d.m17442a(j, i, j2);
        return new MessagesCollection(ThreadKey.b(j), a, a.size() < i);
    }

    private void m17445a(Message message) {
        boolean z = true;
        int b = ((SmsThreadManager) this.f17472c.get()).m17493b(message.b.i());
        String c = message.L.c();
        if (b <= 1 && c == null) {
            z = false;
        }
        ((SmsTakeoverAnalyticsLogger) this.f17476g.get()).a(z, message.L.a(), c, message.L.d.size(), b);
    }
}
