package com.facebook.groups.memberlist;

import android.support.v4.util.Pair;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.BlockState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminList;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminList.FetchGroupAdminListString;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminListModels.AdminConnectionDefaultFieldsModel.EdgesModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminListModels.AdminConnectionDefaultFieldsModel.PageInfoModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminListModels.FetchGroupAdminListModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminListModels.FetchGroupAdminListModel.GroupConfigsModel.NodesModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: extra_webview_height */
public final class GroupAdminsPagedListLoader extends GroupMemberBaseListLoader<FetchGroupAdminListModel> {
    private ImmutableList<GroupMemberListMemberItem> f14206e = RegularImmutableList.a;
    private String f14207f;
    private String f14208g;
    private Integer f14209h;
    public boolean f14210i;

    @Inject
    public GroupAdminsPagedListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, @Assisted Integer num, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14207f = str;
        this.f14209h = num;
        this.f14208g = str2;
    }

    public final boolean m15786c() {
        return true;
    }

    protected final TypedGraphQlQueryString<FetchGroupAdminListModel> m15784a(String str) {
        FetchGroupAdminListString a = FetchGroupAdminList.m16056a();
        a.a("admin_end_cursor", str).a("moderator_end_cursor", str).a("group_id", this.f14207f).a("search_term", this.f14208g).a("profile_image_size", String.valueOf(this.f14209h)).a("admin_count", "12").a("moderator_count", "12").a("fetch_admin_type", Boolean.valueOf(true));
        return a;
    }

    protected final void m15789j() {
        this.f14206e = RegularImmutableList.a;
    }

    protected final TypedGraphQlQueryString m15783a(Enum enumR) {
        FetchGroupAdminListString a = FetchGroupAdminList.m16056a();
        a.a("group_id", this.f14207f).a("search_term", this.f14208g).a("profile_image_size", String.valueOf(this.f14209h)).a("fetch_admin_type", Boolean.valueOf(true));
        if (enumR == MemberSection.ADMIN && this.c != null && this.c.get(MemberSection.ADMIN) != null && !((Boolean) ((Pair) this.c.get(MemberSection.ADMIN)).b).booleanValue()) {
            a.a("admin_end_cursor", (String) ((Pair) this.c.get(MemberSection.ADMIN)).a).a("admin_count", "12").a("moderator_count", Integer.valueOf(1));
            if (this.c.get(MemberSection.MODERATOR) != null) {
                a.a("moderator_end_cursor", (String) ((Pair) this.c.get(MemberSection.MODERATOR)).a);
            }
        } else if (enumR != MemberSection.MODERATOR || this.c == null || this.c.get(MemberSection.MODERATOR) == null || ((Boolean) ((Pair) this.c.get(MemberSection.MODERATOR)).b).booleanValue()) {
            return null;
        } else {
            a.a("moderator_end_cursor", (String) ((Pair) this.c.get(MemberSection.MODERATOR)).a).a("moderator_count", "12").a("admin_count", Integer.valueOf(1));
            if (this.c.get(MemberSection.ADMIN) != null) {
                a.a("admin_end_cursor", (String) ((Pair) this.c.get(MemberSection.ADMIN)).a);
            }
        }
        return a;
    }

    protected final void m15785a(GraphQLResult<FetchGroupAdminListModel> graphQLResult) {
        Object obj;
        PageInfoModel pageInfoModel;
        Builder builder = new Builder();
        builder.b(this.f14206e);
        if (graphQLResult.d() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16119j() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16119j().m16112a() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16119j().m16112a().isEmpty()) {
            obj = null;
        } else {
            Object obj2 = (((FetchGroupAdminListModel) graphQLResult.d()).m16119j().m16112a().get(0) == null || !((NodesModel) ((FetchGroupAdminListModel) graphQLResult.d()).m16119j().m16112a().get(0)).m16108a()) ? null : 1;
            obj = obj2;
        }
        List<EdgesModel> arrayList = new ArrayList();
        if (!(graphQLResult.d() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16099j() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16099j().m16088a() == null)) {
            arrayList.addAll(((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16099j().m16088a());
        }
        if (!(graphQLResult.d() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16100k() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16100k().m16088a() == null || obj == null)) {
            arrayList.addAll(((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16100k().m16088a());
        }
        if (!arrayList.isEmpty()) {
            for (EdgesModel edgesModel : arrayList) {
                if (edgesModel != null) {
                    MemberSection memberSection;
                    GroupMemberAddedByInformation groupMemberAddedByInformation;
                    AdminState adminState = AdminState.ADMIN;
                    if (!(obj == null || edgesModel.m16074k() == null || edgesModel.m16074k() != GraphQLGroupAdminType.MODERATOR)) {
                        adminState = AdminState.MODERATOR;
                    }
                    GroupMemberDataModel l = edgesModel.m16075l();
                    BlockState blockState = BlockState.NOT_BLOCKED;
                    if (adminState == AdminState.ADMIN) {
                        memberSection = MemberSection.ADMIN;
                    } else {
                        memberSection = MemberSection.MODERATOR;
                    }
                    if (edgesModel.m16071a() == null) {
                        groupMemberAddedByInformation = null;
                    } else {
                        groupMemberAddedByInformation = new GroupMemberAddedByInformation(edgesModel.m16071a().m16066k(), edgesModel.m16071a().m16065j(), edgesModel.m16073j());
                    }
                    builder.c(new GroupMemberListMemberItem(l, adminState, blockState, memberSection, groupMemberAddedByInformation));
                }
            }
        }
        if (graphQLResult.d() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16099j() == null) {
            pageInfoModel = null;
        } else {
            pageInfoModel = ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16099j().m16089j();
        }
        this.f14206e = builder.b();
        this.a = pageInfoModel != null ? pageInfoModel.m16082a() : null;
        boolean z = pageInfoModel == null || !pageInfoModel.m16084j();
        this.b = z;
        if (!(graphQLResult.d() == null || ((FetchGroupAdminListModel) graphQLResult.d()).m16116a() == null)) {
            this.f14210i = ((FetchGroupAdminListModel) graphQLResult.d()).m16116a().m16098a();
        }
        m15782b(graphQLResult);
        g();
    }

    private void m15782b(GraphQLResult<FetchGroupAdminListModel> graphQLResult) {
        boolean z = false;
        if (!(graphQLResult == null || graphQLResult.e == null || ((FetchGroupAdminListModel) graphQLResult.e).m16116a() == null || ((FetchGroupAdminListModel) graphQLResult.e).m16116a().m16099j() == null)) {
            PageInfoModel j = ((FetchGroupAdminListModel) graphQLResult.e).m16116a().m16099j().m16089j();
            if (b(MemberSection.ADMIN)) {
                boolean z2;
                HashMap hashMap = this.c;
                MemberSection memberSection = MemberSection.ADMIN;
                Object a = j != null ? j.m16082a() : null;
                if (j == null || !j.m16084j()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                hashMap.put(memberSection, Pair.a(a, Boolean.valueOf(z2)));
            }
        }
        if (graphQLResult != null && graphQLResult.e != null && ((FetchGroupAdminListModel) graphQLResult.e).m16116a() != null && ((FetchGroupAdminListModel) graphQLResult.e).m16116a().m16100k() != null) {
            PageInfoModel j2 = ((FetchGroupAdminListModel) graphQLResult.e).m16116a().m16100k().m16089j();
            if (b(MemberSection.MODERATOR)) {
                HashMap hashMap2 = this.c;
                MemberSection memberSection2 = MemberSection.MODERATOR;
                Object a2 = j2 != null ? j2.m16082a() : null;
                if (j2 == null || !j2.m16084j()) {
                    z = true;
                }
                hashMap2.put(memberSection2, Pair.a(a2, Boolean.valueOf(z)));
            }
        }
    }

    protected final String m15787h() {
        return "Group admin members fetch failed";
    }

    protected final ImmutableList<? extends Object> m15788i() {
        return this.f14206e;
    }
}
