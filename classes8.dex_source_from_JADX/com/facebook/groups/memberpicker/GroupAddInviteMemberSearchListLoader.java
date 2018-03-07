package com.facebook.groups.memberpicker;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.editing.GroupEditFragmentInterface.Type;
import com.facebook.groups.memberpicker.SuggestedMembersBatchedListLoader.MemberBatchedListLoaderListener;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQuery;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQuery.GroupInviteMembersSearchQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryModels.GroupInviteMembersSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryModels.GroupInviteMembersSearchQueryModel.GroupInviteMembersModel.EdgesModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQuery;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQuery.GroupSuggestedMembersSearchQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQuery;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQuery.UserFriendsSearchQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel.FriendsModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_activity_result_data */
public class GroupAddInviteMemberSearchListLoader implements GroupAddInviteMembersListLoaderDelegate {
    public static final String f14566a = GroupAddInviteMemberSearchListLoader.class.getName();
    public final TasksManager f14567b;
    public final GraphQLQueryExecutor f14568c;
    public final ExecutorService f14569d;
    public MemberBatchedListLoaderListener f14570e;
    public String f14571f = "";
    private boolean f14572g;
    private String f14573h;
    public String f14574i;
    public Provider<String> f14575j;
    public ImmutableMap<UserType, ImmutableList<User>> f14576k;
    private Type f14577l;

    /* compiled from: extra_activity_result_data */
    class C15811 extends AbstractDisposableFutureCallback<ImmutableMap<UserType, ImmutableList<User>>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14560a;

        C15811(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14560a = groupAddInviteMemberSearchListLoader;
        }

        protected final void m16405a(Object obj) {
            this.f14560a.f14576k = (ImmutableMap) obj;
            GroupAddInviteMemberSearchListLoader.m16420j(this.f14560a);
        }

        protected final void m16406a(Throwable th) {
            BLog.b(GroupAddInviteMemberSearchListLoader.f14566a, "fetching suggestions members failed");
        }
    }

    /* compiled from: extra_activity_result_data */
    public class C15822 implements Callable<GraphQLQueryFuture<GraphQLResult<GroupSuggestedMembersSearchQueryModel>>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14561a;

        public C15822(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14561a = groupAddInviteMemberSearchListLoader;
        }

        public Object call() {
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14561a.f14570e;
            return GroupAddInviteMemberSearchListLoader.m16421k(this.f14561a);
        }
    }

    /* compiled from: extra_activity_result_data */
    public class C15833 extends AbstractDisposableFutureCallback<GraphQLResult<GroupSuggestedMembersSearchQueryModel>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14562a;

        public C15833(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14562a = groupAddInviteMemberSearchListLoader;
        }

        protected final void m16407a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14562a.f14570e;
            if (graphQLResult != null && graphQLResult.e != null) {
                GroupAddInviteMemberSearchListLoader.m16417a(this.f14562a, GroupAddInviteMemberSearchListLoader.m16416a(this.f14562a, graphQLResult), UserType.CAN_ADD_FRIEND);
                GroupAddInviteMemberSearchListLoader.m16420j(this.f14562a);
            }
        }

        protected final void m16408a(Throwable th) {
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14562a.f14570e;
        }
    }

    /* compiled from: extra_activity_result_data */
    public class C15844 implements Callable<GraphQLQueryFuture<GraphQLResult<UserFriendsSearchQueryModel>>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14563a;

        public C15844(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14563a = groupAddInviteMemberSearchListLoader;
        }

        public Object call() {
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14563a.f14570e;
            return GroupAddInviteMemberSearchListLoader.m16422l(this.f14563a);
        }
    }

    /* compiled from: extra_activity_result_data */
    public class C15855 extends AbstractDisposableFutureCallback<GraphQLResult<UserFriendsSearchQueryModel>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14564a;

        public C15855(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14564a = groupAddInviteMemberSearchListLoader;
        }

        protected final void m16409a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14564a.f14570e;
            if (graphQLResult != null && graphQLResult.e != null) {
                GroupAddInviteMemberSearchListLoader.m16417a(this.f14564a, GroupAddInviteMemberSearchListLoader.m16418b(this.f14564a, graphQLResult), UserType.CAN_ADD_FRIEND);
                GroupAddInviteMemberSearchListLoader.m16420j(this.f14564a);
            }
        }

        protected final void m16410a(Throwable th) {
            MemberBatchedListLoaderListener memberBatchedListLoaderListener = this.f14564a.f14570e;
        }
    }

    /* compiled from: extra_activity_result_data */
    public class C15866 implements Function<List<?>, ImmutableMap<UserType, ImmutableList<User>>> {
        final /* synthetic */ GroupAddInviteMemberSearchListLoader f14565a;

        public C15866(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
            this.f14565a = groupAddInviteMemberSearchListLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            List list = (List) obj;
            if (list == null || list.size() != 2) {
                return null;
            }
            Builder builder = ImmutableMap.builder();
            if (GroupAddInviteMemberSearchListLoader.m16424o(this.f14565a)) {
                builder.b(UserType.CAN_ADD_FRIEND, GroupAddInviteMemberSearchListLoader.m16418b(this.f14565a, (GraphQLResult) list.get(0)));
            } else {
                builder.b(UserType.CAN_ADD_FRIEND, GroupAddInviteMemberSearchListLoader.m16416a(this.f14565a, (GraphQLResult) list.get(0)));
            }
            GraphQLResult graphQLResult = (GraphQLResult) list.get(1);
            ImmutableList.Builder builder2 = ImmutableList.builder();
            if (!(this.f14565a.f14576k == null || this.f14565a.f14576k.get(UserType.CAN_ADD_OTHER) == null)) {
                builder2.b((Iterable) this.f14565a.f14576k.get(UserType.CAN_ADD_OTHER));
            }
            ImmutableList.Builder builder3 = ImmutableList.builder();
            if (!(this.f14565a.f14576k == null || this.f14565a.f14576k.get(UserType.CAN_INVITE) == null)) {
                builder3.b((Iterable) this.f14565a.f14576k.get(UserType.CAN_INVITE));
            }
            if (!(graphQLResult == null || graphQLResult.e == null || ((GroupInviteMembersSearchQueryModel) graphQLResult.e).m16643j() == null || ((GroupInviteMembersSearchQueryModel) graphQLResult.e).m16643j().m16634a() == null)) {
                ImmutableList a = ((GroupInviteMembersSearchQueryModel) graphQLResult.e).m16643j().m16634a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    String a2 = edgesModel.m16628a();
                    String k = edgesModel.m16630k();
                    if (!Strings.isNullOrEmpty(a2) && a2.equals("can_add")) {
                        builder2.c(SuggestedMemberListLoader.m16493a(edgesModel.m16629j(), k));
                    } else if (!Strings.isNullOrEmpty(a2) && a2.equals("can_invite")) {
                        builder3.c(SuggestedMemberListLoader.m16493a(edgesModel.m16629j(), k));
                    }
                }
            }
            builder.b(UserType.CAN_ADD_OTHER, builder2.b());
            builder.b(UserType.CAN_INVITE, builder3.b());
            return builder.b();
        }
    }

    /* compiled from: extra_activity_result_data */
    public enum UserType {
        CAN_ADD_FRIEND,
        CAN_ADD_OTHER,
        CAN_INVITE
    }

    @Inject
    public GroupAddInviteMemberSearchListLoader(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Provider<String> provider) {
        this.f14567b = tasksManager;
        this.f14568c = graphQLQueryExecutor;
        this.f14569d = executorService;
        this.f14575j = provider;
    }

    public final void mo887a(String str, MemberBatchedListLoaderListener memberBatchedListLoaderListener, Type type) {
        if (this.f14570e != null) {
            BLog.c(f14566a, "init called more than once");
        }
        this.f14570e = memberBatchedListLoaderListener;
        this.f14574i = str;
        this.f14577l = type;
    }

    public final void mo886a(String str) {
        if (m16423n()) {
            Object obj = 1;
            if (Strings.isNullOrEmpty(this.f14571f)) {
                if (Strings.isNullOrEmpty(str)) {
                    obj = null;
                }
            } else if (this.f14571f.equals(str)) {
                obj = null;
            }
            if (obj != null) {
                mo885a();
                this.f14571f = str;
                m16419e();
            } else if (!this.f14572g) {
                if (m16424o(this)) {
                    this.f14567b.a("load_members_to_add", new C15844(this), new C15855(this));
                } else {
                    this.f14567b.a("load_members_to_add", new C15822(this), new C15833(this));
                }
            }
        }
    }

    public final void mo885a() {
        this.f14571f = "";
        this.f14572g = false;
        this.f14573h = null;
        this.f14567b.c();
        this.f14576k = null;
    }

    public final String mo888b() {
        return this.f14571f;
    }

    public final boolean mo889c() {
        return m16423n();
    }

    private void m16419e() {
        TasksManager tasksManager = this.f14567b;
        String str = "load_members_to_add";
        ListenableFuture[] listenableFutureArr = new ListenableFuture[2];
        listenableFutureArr[0] = m16424o(this) ? m16422l(this) : m16421k(this);
        GroupInviteMembersSearchQueryString a = GroupSuggestedInviteSearchQuery.m16601a();
        a.a("group_id", this.f14574i).a("user_id", (String) this.f14575j.get()).a("named", this.f14571f).a("max_count", Integer.valueOf(12));
        listenableFutureArr[1] = this.f14568c.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
        tasksManager.a(str, Futures.a(Futures.a(listenableFutureArr), new C15866(this), this.f14569d), new C15811(this));
    }

    public static void m16420j(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
        Builder builder = ImmutableMap.builder();
        if (groupAddInviteMemberSearchListLoader.f14576k == null) {
            groupAddInviteMemberSearchListLoader.f14570e.mo890a(RegularImmutableBiMap.a);
        } else if (groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND) != null && !groupAddInviteMemberSearchListLoader.f14572g) {
            groupAddInviteMemberSearchListLoader.f14570e.mo890a(ImmutableBiMap.b("member_search_result_section", groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND)));
        } else if (groupAddInviteMemberSearchListLoader.f14572g) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            if (groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND) != null) {
                builder2.b((Iterable) groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND));
            }
            if (groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_OTHER) != null) {
                builder2.b((Iterable) groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_OTHER));
            }
            builder.b("member_search_result_section", builder2.b());
            if (groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_INVITE) != null) {
                builder.b("member_search_invite_result_section", groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_INVITE));
            }
            groupAddInviteMemberSearchListLoader.f14570e.mo890a(builder.b());
        }
    }

    public static synchronized ImmutableList m16416a(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader, GraphQLResult graphQLResult) {
        ImmutableList b;
        synchronized (groupAddInviteMemberSearchListLoader) {
            PageInfoModel pageInfoModel;
            String a;
            ImmutableList.Builder builder = ImmutableList.builder();
            if (!(groupAddInviteMemberSearchListLoader.f14576k == null || groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND) == null)) {
                builder.b((Iterable) groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND));
            }
            ImmutableList asList = ((GroupSuggestedMembersSearchQueryModel) graphQLResult.d()).m16811j().m16802a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((SuggestedMembersModel.EdgesModel) asList.get(i)).m16790a(), null));
            }
            if (graphQLResult.d() == null || ((GroupSuggestedMembersSearchQueryModel) graphQLResult.d()).m16811j() == null) {
                pageInfoModel = null;
            } else {
                pageInfoModel = ((GroupSuggestedMembersSearchQueryModel) graphQLResult.d()).m16811j().m16803j();
            }
            if (pageInfoModel != null) {
                a = pageInfoModel.m16796a();
            } else {
                a = null;
            }
            groupAddInviteMemberSearchListLoader.f14573h = a;
            boolean z = pageInfoModel == null || !pageInfoModel.m16798j();
            groupAddInviteMemberSearchListLoader.f14572g = z;
            b = builder.b();
        }
        return b;
    }

    public static synchronized ImmutableList m16418b(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader, GraphQLResult graphQLResult) {
        ImmutableList b;
        synchronized (groupAddInviteMemberSearchListLoader) {
            FriendsModel.PageInfoModel pageInfoModel;
            String a;
            ImmutableList.Builder builder = ImmutableList.builder();
            if (!(groupAddInviteMemberSearchListLoader.f14576k == null || groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND) == null)) {
                builder.b((Iterable) groupAddInviteMemberSearchListLoader.f14576k.get(UserType.CAN_ADD_FRIEND));
            }
            ImmutableList asList = ((UserFriendsSearchQueryModel) graphQLResult.d()).m16950j().m16940a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((FriendsModel.EdgesModel) asList.get(i)).m16928a(), null));
            }
            if (graphQLResult.d() == null || ((UserFriendsSearchQueryModel) graphQLResult.d()).m16950j() == null) {
                pageInfoModel = null;
            } else {
                pageInfoModel = ((UserFriendsSearchQueryModel) graphQLResult.d()).m16950j().m16941j();
            }
            if (pageInfoModel != null) {
                a = pageInfoModel.m16934a();
            } else {
                a = null;
            }
            groupAddInviteMemberSearchListLoader.f14573h = a;
            boolean z = pageInfoModel == null || !pageInfoModel.m16936j();
            groupAddInviteMemberSearchListLoader.f14572g = z;
            b = builder.b();
        }
        return b;
    }

    public static void m16417a(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader, ImmutableList immutableList, UserType userType) {
        Builder builder = ImmutableMap.builder();
        builder.b(userType, immutableList);
        for (UserType userType2 : UserType.values()) {
            if (!(userType2.equals(userType) || groupAddInviteMemberSearchListLoader.f14576k == null || groupAddInviteMemberSearchListLoader.f14576k.get(userType2) == null)) {
                builder.b(userType2, groupAddInviteMemberSearchListLoader.f14576k.get(userType2));
            }
        }
        groupAddInviteMemberSearchListLoader.f14576k = builder.b();
    }

    public static GraphQLQueryFuture m16421k(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
        GroupSuggestedMembersSearchQueryString a = GroupSuggestedMembersSearchQuery.m16766a();
        a.a("group_id", groupAddInviteMemberSearchListLoader.f14574i);
        a.a("search_term", groupAddInviteMemberSearchListLoader.f14571f);
        a.a("member_count_to_fetch", Integer.valueOf(12));
        a.a("afterCursor", groupAddInviteMemberSearchListLoader.f14573h);
        return groupAddInviteMemberSearchListLoader.f14568c.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
    }

    public static GraphQLQueryFuture m16422l(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
        UserFriendsSearchQueryString a = UserFriendsSearchQuery.m16905a();
        a.a("user_id", (String) groupAddInviteMemberSearchListLoader.f14575j.get());
        a.a("searchTerm", groupAddInviteMemberSearchListLoader.f14571f);
        a.a("afterCursor", groupAddInviteMemberSearchListLoader.f14573h);
        a.a("member_count_to_fetch", Integer.valueOf(12));
        return groupAddInviteMemberSearchListLoader.f14568c.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
    }

    private boolean m16423n() {
        if (this.f14570e == null || (!m16424o(this) && Strings.isNullOrEmpty(this.f14574i))) {
            return false;
        }
        return true;
    }

    public static boolean m16424o(GroupAddInviteMemberSearchListLoader groupAddInviteMemberSearchListLoader) {
        return groupAddInviteMemberSearchListLoader.f14577l != null && groupAddInviteMemberSearchListLoader.f14577l.equals(Type.TYPE_CREATE_FLOW);
    }
}
