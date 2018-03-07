package com.facebook.groups.memberpicker;

import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.editing.GroupEditFragmentInterface.Type;
import com.facebook.groups.memberpicker.SuggestedMembersBatchedListLoader.MemberBatchedListLoaderListener;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: external_click_time */
public class GroupAddMemberSearchListLoader implements GroupAddInviteMembersListLoaderDelegate {
    private final SuggestedSearchMemberListLoaderProvider f14585a;
    private SuggestedSearchMemberListLoader f14586b;
    public MemberBatchedListLoaderListener f14587c;
    private String f14588d;
    private String f14589e = "";

    /* compiled from: external_click_time */
    class C15881 implements MemberListLoaderListener {
        final /* synthetic */ GroupAddMemberSearchListLoader f14584a;

        C15881(GroupAddMemberSearchListLoader groupAddMemberSearchListLoader) {
            this.f14584a = groupAddMemberSearchListLoader;
        }

        public final void m16437a(ImmutableList immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f14584a.f14587c.mo890a(ImmutableBiMap.b("member_search_result_section", immutableList));
        }

        public final void m16438a(boolean z) {
        }
    }

    @Inject
    public GroupAddMemberSearchListLoader(SuggestedSearchMemberListLoaderProvider suggestedSearchMemberListLoaderProvider) {
        this.f14585a = suggestedSearchMemberListLoaderProvider;
    }

    public final void mo887a(String str, MemberBatchedListLoaderListener memberBatchedListLoaderListener, Type type) {
        this.f14588d = str;
        this.f14587c = memberBatchedListLoaderListener;
    }

    public final void mo886a(String str) {
        if (this.f14586b == null || !mo888b().equals(str)) {
            this.f14589e = str;
            SuggestedSearchMemberListLoaderProvider suggestedSearchMemberListLoaderProvider = this.f14585a;
            String str2 = this.f14588d;
            String str3 = str2;
            String str4 = str;
            this.f14586b = new SuggestedSearchMemberListLoader(TasksManager.b(suggestedSearchMemberListLoaderProvider), str3, str4, GraphQLQueryExecutor.a(suggestedSearchMemberListLoaderProvider), new C15881(this));
        }
        this.f14586b.f();
    }

    public final void mo885a() {
        if (this.f14586b != null) {
            this.f14586b.e();
        }
    }

    public final String mo888b() {
        return Strings.isNullOrEmpty(this.f14589e) ? "" : this.f14589e;
    }

    public final boolean mo889c() {
        return this.f14587c != null;
    }
}
