package com.facebook.messaging.threads.graphql;

import android.net.Uri;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.graphql.enums.GraphQLMailboxFolder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.fetch.GQLBotConverter;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.threads.RtcCallModels.RtcCallDataInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.EventRemindersModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.EventRemindersModel.NodesModel.EventReminderMembersModel.EdgesModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.JoinableModeInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.PinnedThreadsQueryModel.PinnedMessageThreadsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ReceiptInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.CustomizationInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.CustomizationInfoModel.ParticipantCustomizationsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.LastMessageModel.NodesModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.ThreadGamesModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.ThreadGamesModel.HighScoreModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel.ThreadKeyModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadQueueInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadQueueInfoModel.ApprovalRequestsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadQueueInfoModel.ThreadAdminsModel;
import com.facebook.messaging.localfetch.FetchUserHandler;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.NicknamesMap;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadGameData;
import com.facebook.messaging.model.threads.ThreadJoinRequest;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsResultBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.katana.activity.ImmersiveActivity */
public class GQLThreadsConverter {
    private final GQLUserConverter f17827a;
    private final GQLMessagesConverter f17828b;
    private final GQLThreadsLogger f17829c;
    private final Provider<Boolean> f17830d;

    public static GQLThreadsConverter m17785b(InjectorLike injectorLike) {
        return new GQLThreadsConverter(GQLUserConverter.a(injectorLike), GQLThreadsLogger.m17795b(injectorLike), GQLMessagesConverter.m17739b(injectorLike), IdBasedProvider.a(injectorLike, 4216));
    }

    public static GQLThreadsConverter m17782a(InjectorLike injectorLike) {
        return m17785b(injectorLike);
    }

    @Inject
    public GQLThreadsConverter(GQLUserConverter gQLUserConverter, GQLThreadsLogger gQLThreadsLogger, GQLMessagesConverter gQLMessagesConverter, Provider<Boolean> provider) {
        this.f17827a = gQLUserConverter;
        this.f17828b = gQLMessagesConverter;
        this.f17829c = gQLThreadsLogger;
        this.f17830d = provider;
    }

    @Nullable
    public final ThreadKey m17787a(ThreadInfoModel threadInfoModel, User user) {
        Object obj;
        ThreadKeyModel J = threadInfoModel.J();
        if (J == null || (J.j() == null && J.a() == null)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            this.f17829c.m17804a("ThreadKey is invalid: " + threadInfoModel.x());
            return null;
        } else if (threadInfoModel.z()) {
            return ThreadKey.a(Long.parseLong(J.j()));
        } else {
            if (J.a() == null) {
                this.f17829c.m17804a("Thread key is missing other user id. " + "Folder: " + (threadInfoModel.s() != null ? threadInfoModel.s().toString() : "null") + ", Is archived: " + threadInfoModel.w() + ", Fbid: " + J.j());
                return null;
            }
            return ThreadKey.a(Long.parseLong(J.a()), Long.parseLong(user.a));
        }
    }

    public final ThreadsCollection m17789a(ImmutableList<ThreadInfoModel> immutableList, @Nullable ImmutableMap<String, User> immutableMap, boolean z, User user) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadInfoModel threadInfoModel = (ThreadInfoModel) immutableList.get(i);
            ThreadKey a = m17787a(threadInfoModel, user);
            if (a != null) {
                if (threadInfoModel.s() == GraphQLMailboxFolder.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                    this.f17829c.m17803a(Long.valueOf(a.i()));
                } else {
                    builder.c(m17788a(a, threadInfoModel, (ImmutableMap) immutableMap, user));
                }
            }
        }
        return new ThreadsCollection(builder.b(), z);
    }

    public final ThreadsCollection m17790a(ImmutableList<ThreadInfoModel> immutableList, boolean z, User user) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadInfoModel threadInfoModel = (ThreadInfoModel) immutableList.get(i);
            if (threadInfoModel.m() || !threadInfoModel.s().equals(GraphQLMailboxFolder.OTHER)) {
                ThreadKey a = m17787a(threadInfoModel, user);
                if (a != null) {
                    if (threadInfoModel.s() == GraphQLMailboxFolder.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                        this.f17829c.m17803a(Long.valueOf(a.i()));
                    } else {
                        builder.c(m17788a(a, threadInfoModel, null, user));
                    }
                }
            }
        }
        return new ThreadsCollection(builder.b(), z);
    }

    public final FetchThreadResult m17792a(ThreadKey threadKey, ThreadInfoModel threadInfoModel, User user, @Nullable ImmutableList<User> immutableList) {
        ThreadSummary a;
        ThreadSummary threadSummary;
        ImmutableList a2;
        boolean booleanValue = ((Boolean) this.f17830d.get()).booleanValue();
        if (!booleanValue || immutableList == null) {
            a = m17788a(threadKey, threadInfoModel, null, user);
        } else {
            a = null;
        }
        MessagesCollection a3 = this.f17828b.m17744a(threadKey, threadInfoModel.C(), user);
        if (immutableList == null) {
            threadSummary = a;
            a2 = this.f17827a.a(ImmutableList.of(threadInfoModel));
        } else {
            ImmutableList a4 = FetchUserHandler.m11957a(user, immutableList);
            ImmutableList immutableList2;
            if (booleanValue) {
                Map hashMap = new HashMap();
                int size = a4.size();
                for (int i = 0; i < size; i++) {
                    User user2 = (User) a4.get(i);
                    hashMap.put(user2.a, user2);
                }
                immutableList2 = a4;
                threadSummary = m17788a(threadKey, threadInfoModel, ImmutableMap.copyOf(hashMap), user);
                a2 = immutableList2;
            } else {
                immutableList2 = a4;
                threadSummary = a;
                a2 = immutableList2;
            }
        }
        FetchThreadResult.Builder b = FetchThreadResult.m17150b();
        b.f17171a = DataFetchDisposition.b;
        b = b;
        b.f17172b = threadSummary;
        FetchThreadResult.Builder builder = b;
        builder.f17173c = a3;
        builder = builder;
        builder.f17174d = a2;
        FetchThreadResult.Builder builder2 = builder;
        builder2.f17176f = System.currentTimeMillis();
        return builder2.m17147a();
    }

    public final FetchPinnedThreadsResult m17791a(@Nullable PinnedMessageThreadsModel pinnedMessageThreadsModel, User user) {
        boolean z;
        Builder builder = ImmutableList.builder();
        if (pinnedMessageThreadsModel != null) {
            ImmutableList a = pinnedMessageThreadsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ThreadInfoModel threadInfoModel = (ThreadInfoModel) a.get(i);
                if (threadInfoModel.J() == null) {
                    this.f17829c.m17804a("ThreadKey is null: " + threadInfoModel.x());
                } else if (!threadInfoModel.z()) {
                    this.f17829c.f17831a.a("pinned_threads_fetch", "Pinned thread is not a group thread. One to one with user: " + threadInfoModel.J().a());
                } else if (!threadInfoModel.w()) {
                    builder.c(m17788a(ThreadKey.a(Long.parseLong(threadInfoModel.J().j())), threadInfoModel, null, user));
                }
            }
        } else {
            this.f17829c.m17796a();
        }
        ImmutableList b = builder.b();
        FetchPinnedThreadsResultBuilder newBuilder = FetchPinnedThreadsResult.newBuilder();
        newBuilder.f17104a = b;
        newBuilder = newBuilder;
        if (pinnedMessageThreadsModel != null) {
            z = true;
        } else {
            z = false;
        }
        newBuilder.f17105b = z;
        return newBuilder.m17093a(pinnedMessageThreadsModel != null ? pinnedMessageThreadsModel.j() * 1000 : 0).m17096b(SystemClock.b().a()).m17097e();
    }

    public final ThreadSummary m17788a(ThreadKey threadKey, ThreadInfoModel threadInfoModel, @Nullable ImmutableMap<String, User> immutableMap, User user) {
        Map a;
        ImmutableMap a2;
        int size;
        int i;
        int i2;
        if (threadInfoModel.p() == null) {
            a = ImmutableBiMap.a();
        } else {
            a = m17786b(threadInfoModel.p().a());
        }
        if (threadInfoModel.G() == null) {
            a2 = ImmutableBiMap.a();
        } else {
            a2 = m17786b(threadInfoModel.G().a());
        }
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        HashSet hashSet = new HashSet();
        ThreadQueueInfoModel L = threadInfoModel.L();
        if (!(L == null || L.l() == null)) {
            ImmutableList l = L.l();
            size = l.size();
            for (i = 0; i < size; i++) {
                hashSet.add(((ThreadAdminsModel) l.get(i)).j());
            }
        }
        if (threadInfoModel.l() != null) {
            newBuilder.a(this.f17827a.a(threadInfoModel.l().a(), a, a2, hashSet));
        } else if (immutableMap == null || threadInfoModel.k() == null) {
            this.f17829c.m17804a("Invalid thread participant information: " + threadInfoModel.x());
        } else {
            newBuilder.a(this.f17827a.a(threadInfoModel.k().a(), immutableMap, a, a2, hashSet));
        }
        if (threadInfoModel.u() != null) {
            newBuilder.b(this.f17827a.a(threadInfoModel.u().a(), a, a2, hashSet));
        } else if (immutableMap == null || threadInfoModel.t() == null) {
            this.f17829c.m17804a("Invalid former thread participant information: " + threadInfoModel.x());
        } else {
            newBuilder.b(this.f17827a.a(threadInfoModel.t().a(), immutableMap, a, a2, hashSet));
        }
        if (threadInfoModel.j() != null) {
            newBuilder.c(GQLBotConverter.a(threadInfoModel.j().a()));
        } else {
            this.f17829c.m17804a("Invalid bot thread participant information: " + threadInfoModel.x());
        }
        newBuilder.a(threadKey);
        newBuilder.d(-1);
        newBuilder.a(threadInfoModel.x());
        if (threadInfoModel.F() != null) {
            newBuilder.b(threadInfoModel.F());
        }
        if (threadInfoModel.B() != null && threadInfoModel.B().a().size() == 1) {
            String str;
            NodesModel nodesModel = (NodesModel) threadInfoModel.B().a().get(0);
            String str2 = null;
            if (!(nodesModel.o() == null || nodesModel.o().j() == null || nodesModel.o().j().b() == null)) {
                str2 = nodesModel.o().j().b();
                newBuilder.a(new ParticipantInfo(new UserKey(Type.FACEBOOK, str2), nodesModel.o().j().c()));
            }
            if (nodesModel.a() != null) {
                GQLMessagesConverter gQLMessagesConverter = this.f17828b;
                size = nodesModel.a().g();
                boolean z = nodesModel.k() || nodesModel.j();
                MessageType a3 = gQLMessagesConverter.m17743a(size, user, str2, z, nodesModel.q(), nodesModel.p());
                if (a3 != MessageType.REGULAR || nodesModel.n() == null || StringUtil.a(nodesModel.n().a())) {
                    newBuilder.d(nodesModel.r());
                } else {
                    newBuilder.c(nodesModel.r());
                }
                boolean z2 = a3 == MessageType.MISSED_CALL || a3 == MessageType.MISSED_VIDEO_CALL;
                newBuilder.d(z2);
            }
            newBuilder.g(nodesModel.m());
            if (nodesModel.l() == null) {
                str = null;
            } else {
                str = nodesModel.l().name();
            }
            newBuilder.f(str);
        }
        long parseLong = Long.parseLong(threadInfoModel.N());
        newBuilder.e(parseLong);
        newBuilder.c(ActionIdHelper.b(parseLong));
        newBuilder.f(m17780a(threadInfoModel, a2, user));
        newBuilder.g((long) threadInfoModel.D());
        newBuilder.h((long) threadInfoModel.M());
        newBuilder.a(threadInfoModel.m());
        newBuilder.a(threadInfoModel.n());
        if (!(threadInfoModel.y() == null || Strings.isNullOrEmpty(threadInfoModel.y().a()))) {
            newBuilder.a(Uri.parse(threadInfoModel.y().a()));
        }
        newBuilder.b(threadInfoModel.A());
        newBuilder.a(FolderName.fromDbName(m17783a(threadInfoModel)));
        newBuilder.a(NotificationSetting.b((long) threadInfoModel.E()));
        CustomizationInfoModel o = threadInfoModel.o();
        if (o != null) {
            int i3 = 0;
            i = 0;
            i2 = 0;
            if (o.m() != null) {
                i3 = (int) Long.parseLong(o.m(), 16);
            }
            if (o.k() != null) {
                i = (int) Long.parseLong(o.k(), 16);
            }
            if (o.j() != null) {
                i2 = (int) Long.parseLong(o.j(), 16);
            }
            newBuilder.a(ThreadCustomization.newBuilder().a(i3).b(i).c(i2).a(o.a()).a(m17781a(o.l())).g());
        }
        newBuilder.a(threadInfoModel.q());
        EventRemindersModel r = threadInfoModel.r();
        if (r != null) {
            Builder builder = new Builder();
            ImmutableList a4 = r.a();
            size = a4.size();
            for (int i4 = 0; i4 < size; i4++) {
                EventRemindersModel.NodesModel nodesModel2 = (EventRemindersModel.NodesModel) a4.get(i4);
                ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
                if (!(nodesModel2.k() == null || nodesModel2.k().a().isEmpty())) {
                    ImmutableList a5 = nodesModel2.k().a();
                    int size2 = a5.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        EdgesModel edgesModel = (EdgesModel) a5.get(i2);
                        if (edgesModel.j() != null) {
                            builder2.b(new UserKey(Type.FACEBOOK, edgesModel.j().j()), edgesModel.a());
                        }
                    }
                }
                builder.c(new ThreadEventReminder.Builder().a(nodesModel2.m()).a(nodesModel2.n()).b(nodesModel2.l()).a(false).a(builder2.b()).b(nodesModel2.j()).g());
            }
            newBuilder.e(builder.b());
        }
        RtcCallDataInfoModel H = threadInfoModel.H();
        if (H != null) {
            newBuilder.a(ThreadRtcCallInfoData.newBuilder().a(H.a()).b(H.k()).c(H.j() != null ? H.j().j() : null).d());
        }
        newBuilder.a((float) threadInfoModel.v());
        if (L != null) {
            JoinableModeInfoModel k = L.k();
            if (k != null) {
                String a6 = k.a();
                if (!Strings.isNullOrEmpty(a6)) {
                    newBuilder.b(Uri.parse(a6));
                }
                newBuilder.a(GroupType.fromIntegerValue(Integer.parseInt(k.j())));
            }
            newBuilder.h(L.a() == 1);
            if (L.j() != null) {
                Builder builder3 = ImmutableList.builder();
                ImmutableList a7 = L.j().a();
                int size3 = a7.size();
                for (i = 0; i < size3; i++) {
                    ApprovalRequestsModel.EdgesModel edgesModel2 = (ApprovalRequestsModel.EdgesModel) a7.get(i);
                    if (!(edgesModel2.a() == null || Strings.isNullOrEmpty(edgesModel2.a().j()))) {
                        builder3.c(new ThreadJoinRequest(UserKey.b(edgesModel2.a().j()), edgesModel2.j()));
                    }
                }
                newBuilder.a(builder3.b());
            }
        }
        newBuilder.a(TriState.valueOf(threadInfoModel.K()));
        m17784a(newBuilder, threadInfoModel.I());
        return newBuilder.V();
    }

    private static NicknamesMap m17781a(ImmutableList<ParticipantCustomizationsModel> immutableList) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ParticipantCustomizationsModel participantCustomizationsModel = (ParticipantCustomizationsModel) immutableList.get(i);
            builder.b(participantCustomizationsModel.j(), participantCustomizationsModel.a());
        }
        return new NicknamesMap(builder.b());
    }

    private static void m17784a(ThreadSummaryBuilder threadSummaryBuilder, @Nullable List<ThreadGamesModel> list) {
        if (list != null) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (ThreadGamesModel threadGamesModel : list) {
                HighScoreModel j = threadGamesModel.j();
                if (j != null) {
                    builder.b(threadGamesModel.a(), new ThreadGameData(j.a(), j.j()));
                }
            }
            threadSummaryBuilder.M = builder.b();
        }
    }

    private static long m17780a(ThreadInfoModel threadInfoModel, ImmutableMap<String, Long> immutableMap, User user) {
        if ((threadInfoModel.M() == 0 ? 1 : null) != null) {
            return Long.parseLong(threadInfoModel.N());
        }
        return immutableMap.containsKey(user.a) ? ((Long) immutableMap.get(user.a)).longValue() : 0;
    }

    private static ImmutableMap<String, Long> m17786b(ImmutableList<ReceiptInfoModel> immutableList) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ReceiptInfoModel receiptInfoModel = (ReceiptInfoModel) immutableList.get(i);
            if (!(receiptInfoModel.a() == null || receiptInfoModel.a().j() == null || receiptInfoModel.j() == null)) {
                builder.b(receiptInfoModel.a().j(), Long.valueOf(Long.parseLong(receiptInfoModel.j())));
            }
        }
        return builder.b();
    }

    private String m17783a(ThreadInfoModel threadInfoModel) {
        if (threadInfoModel.w()) {
            Preconditions.checkNotNull(threadInfoModel.J());
            String j = threadInfoModel.J().j();
            if (StringUtil.a(j)) {
                j = threadInfoModel.J().a();
            }
            this.f17829c.f17831a.a("threads_fetch_archived", "Unexpected archived thread. Id: " + j);
            return "archived";
        }
        Preconditions.checkNotNull(threadInfoModel.s());
        Preconditions.checkNotNull(threadInfoModel.s().name());
        return threadInfoModel.s().name().toLowerCase(Locale.US);
    }
}
