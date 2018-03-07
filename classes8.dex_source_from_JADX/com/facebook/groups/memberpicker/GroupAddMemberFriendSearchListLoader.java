package com.facebook.groups.memberpicker;

import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.editing.GroupEditFragmentInterface.Type;
import com.facebook.groups.memberpicker.SuggestedMembersBatchedListLoader.MemberBatchedListLoaderListener;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: external_profile_link_share */
public class GroupAddMemberFriendSearchListLoader implements GroupAddInviteMembersListLoaderDelegate {
    private UserFriendsSearchListLoaderProvider f14579a;
    private UserFriendsSearchListLoader f14580b;
    public MemberBatchedListLoaderListener f14581c;
    private String f14582d = "";
    private String f14583e;

    /* compiled from: external_profile_link_share */
    class C15871 implements MemberListLoaderListener {
        final /* synthetic */ GroupAddMemberFriendSearchListLoader f14578a;

        C15871(GroupAddMemberFriendSearchListLoader groupAddMemberFriendSearchListLoader) {
            this.f14578a = groupAddMemberFriendSearchListLoader;
        }

        public final void m16430a(ImmutableList immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14578a.f14581c.mo890a(ImmutableBiMap.b(GenericFriendsSelectorFragment.a, immutableList));
        }

        public final void m16431a(boolean z) {
        }
    }

    @Inject
    public GroupAddMemberFriendSearchListLoader(Provider<String> provider, UserFriendsSearchListLoaderProvider userFriendsSearchListLoaderProvider) {
        this.f14583e = (String) provider.get();
        this.f14579a = userFriendsSearchListLoaderProvider;
    }

    public final void mo887a(String str, MemberBatchedListLoaderListener memberBatchedListLoaderListener, Type type) {
        this.f14581c = memberBatchedListLoaderListener;
    }

    public final void mo886a(String str) {
        if (this.f14580b == null || !mo888b().equals(str)) {
            this.f14582d = str;
            UserFriendsSearchListLoaderProvider userFriendsSearchListLoaderProvider = this.f14579a;
            String str2 = this.f14583e;
            String str3 = str2;
            String str4 = str;
            this.f14580b = new UserFriendsSearchListLoader(TasksManager.b(userFriendsSearchListLoaderProvider), str3, str4, GraphQLQueryExecutor.a(userFriendsSearchListLoaderProvider), new C15871(this));
        }
        this.f14580b.f();
    }

    public final void mo885a() {
        if (this.f14580b != null) {
            this.f14580b.e();
        }
    }

    public final String mo888b() {
        return Strings.isNullOrEmpty(this.f14582d) ? "" : this.f14582d;
    }

    public final boolean mo889c() {
        return this.f14581c != null;
    }
}
