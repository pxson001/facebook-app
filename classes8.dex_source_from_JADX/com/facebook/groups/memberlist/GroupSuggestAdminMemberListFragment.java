package com.facebook.groups.memberlist;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupSuggestAdminInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberlist.GroupMembershipController.C15548;
import com.facebook.groups.memberlist.GroupMembershipController.C15559;
import com.facebook.groups.memberlist.annotation.GroupSuggestAdminNavHandler;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupSuggestAdminMutationString;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: extra_photo_items_list */
public class GroupSuggestAdminMemberListFragment extends GroupMemberListBaseFragment {
    @Inject
    public GroupMembersPagedListLoaderProvider f14339a;
    @Inject
    public GroupMembershipController f14340b;
    @GroupSuggestAdminNavHandler
    @Inject
    public GroupsNavigationHandler f14341c;
    @Inject
    public Resources f14342d;

    public static void m15922a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupSuggestAdminMemberListFragment groupSuggestAdminMemberListFragment = (GroupSuggestAdminMemberListFragment) obj;
        GroupMembersPagedListLoaderProvider groupMembersPagedListLoaderProvider = (GroupMembersPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMembersPagedListLoaderProvider.class);
        GroupMembershipController b = GroupMembershipController.m15917b(fbInjector);
        GroupsNavigationHandler a = DefaultGroupsNavigationHandler.m17162a(fbInjector);
        Resources a2 = ResourcesMethodAutoProvider.a(fbInjector);
        groupSuggestAdminMemberListFragment.f14339a = groupMembersPagedListLoaderProvider;
        groupSuggestAdminMemberListFragment.f14340b = b;
        groupSuggestAdminMemberListFragment.f14341c = a;
        groupSuggestAdminMemberListFragment.f14342d = a2;
    }

    public final void mo855c(Bundle bundle) {
        super.mo855c(bundle);
        Class cls = GroupSuggestAdminMemberListFragment.class;
        m15922a((Object) this, getContext());
        m15768h(true);
    }

    protected final void mo846a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
        if (groupMemberListMemberItem != null) {
            GroupMembershipController groupMembershipController = this.f14340b;
            String str = this.f14190a;
            String b = groupMemberListMemberItem.f14272d.b();
            String he_ = groupMemberListMemberItem.f14272d.he_();
            new Builder(getContext()).b(groupMembershipController.f14334c.getString(2131239500, new Object[]{he_})).a(2131230726, new C15548(groupMembershipController)).a().show();
            GroupSuggestAdminInputData groupSuggestAdminInputData = new GroupSuggestAdminInputData();
            groupSuggestAdminInputData.a("actor_id", groupMembershipController.f14332a);
            GraphQlCallInput graphQlCallInput = groupSuggestAdminInputData;
            graphQlCallInput.a("group_id", str);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("user_id", b);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString groupSuggestAdminMutationString = new GroupSuggestAdminMutationString();
            groupSuggestAdminMutationString.a("input", graphQlCallInput);
            Futures.a(groupMembershipController.f14335d.a(GraphQLRequest.a(groupSuggestAdminMutationString)), new C15559(groupMembershipController), groupMembershipController.f14333b);
            kO_().d();
        }
    }

    public final void mo871a(View view, Bundle bundle) {
        super.mo871a(view, bundle);
        this.f14341c.mo896a(this, this.f14342d.getString(2131239499), null);
    }

    protected final boolean ar() {
        return true;
    }

    protected final GroupMemberBaseListLoader mo844a(String str) {
        return this.f14339a.m15915a(this.f14190a, str, Boolean.valueOf(ar()), Boolean.valueOf(true), Integer.valueOf(aH()), this.aw);
    }

    protected final boolean at() {
        return true;
    }

    protected final void mo847a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        super.mo847a((ImmutableList) immutableList);
        if (az()) {
            this.aq.m15835b(immutableList);
        } else {
            this.aq.m15832a((ImmutableList) immutableList);
        }
    }

    protected final void au() {
    }
}
