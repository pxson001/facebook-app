package com.facebook.groups.memberpicker;

import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: expiryYear */
public class SuggestedMembersBatchedListLoader {
    private static final String f14611c = SuggestedMembersBatchedListLoader.class.getName();
    MemberListLoaderListener<User> f14612a = new C15971(this);
    MemberListLoaderListener<User> f14613b = new C15982(this);
    public SuggestedMemberAlphabeticalListLoader f14614d;
    public SuggestedMemberListLoader f14615e;
    public ImmutableList<User> f14616f;
    public ImmutableList<User> f14617g;
    public Set<String> f14618h;
    private MemberBatchedListLoaderListener f14619i;
    private final int f14620j;

    /* compiled from: expiryYear */
    public interface MemberBatchedListLoaderListener<DATA> {
        void mo890a(ImmutableMap<String, DATA> immutableMap);
    }

    /* compiled from: expiryYear */
    class C15971 implements MemberListLoaderListener<User> {
        final /* synthetic */ SuggestedMembersBatchedListLoader f14609a;

        C15971(SuggestedMembersBatchedListLoader suggestedMembersBatchedListLoader) {
            this.f14609a = suggestedMembersBatchedListLoader;
        }

        public final void m16499a(ImmutableList<User> immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            SuggestedMembersBatchedListLoader.m16504a(this.f14609a, "member_picker_merged_section", immutableList);
        }

        public final void m16500a(boolean z) {
        }
    }

    /* compiled from: expiryYear */
    class C15982 implements MemberListLoaderListener<User> {
        final /* synthetic */ SuggestedMembersBatchedListLoader f14610a;

        C15982(SuggestedMembersBatchedListLoader suggestedMembersBatchedListLoader) {
            this.f14610a = suggestedMembersBatchedListLoader;
        }

        public final void m16501a(ImmutableList<User> immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            SuggestedMembersBatchedListLoader.m16504a(this.f14610a, "member_suggestions_section", immutableList);
        }

        public final void m16502a(boolean z) {
        }
    }

    @Inject
    public SuggestedMembersBatchedListLoader(@Assisted String str, @Assisted Integer num, @Assisted MemberBatchedListLoaderListener memberBatchedListLoaderListener, SuggestedMemberListLoaderProvider suggestedMemberListLoaderProvider, SuggestedMemberAlphabeticalListLoaderProvider suggestedMemberAlphabeticalListLoaderProvider) {
        this.f14614d = new SuggestedMemberAlphabeticalListLoader(TasksManager.b(suggestedMemberAlphabeticalListLoaderProvider), str, GraphQLQueryExecutor.a(suggestedMemberAlphabeticalListLoaderProvider), this.f14612a);
        String str2 = str;
        Integer num2 = num;
        this.f14615e = new SuggestedMemberListLoader(TasksManager.b(suggestedMemberListLoaderProvider), str2, num2, GraphQLQueryExecutor.a(suggestedMemberListLoaderProvider), this.f14613b);
        this.f14619i = memberBatchedListLoaderListener;
        this.f14620j = num.intValue();
    }

    public static void m16504a(SuggestedMembersBatchedListLoader suggestedMembersBatchedListLoader, String str, ImmutableList immutableList) {
        if (str.equals("member_suggestions_section")) {
            suggestedMembersBatchedListLoader.f14616f = immutableList;
            suggestedMembersBatchedListLoader.f14618h = new HashSet();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                suggestedMembersBatchedListLoader.f14618h.add(((User) immutableList.get(i)).a);
            }
            if (suggestedMembersBatchedListLoader.f14617g != null) {
                suggestedMembersBatchedListLoader.f14617g = suggestedMembersBatchedListLoader.m16503a(suggestedMembersBatchedListLoader.f14617g);
            }
        } else if (immutableList.size() > suggestedMembersBatchedListLoader.f14620j) {
            suggestedMembersBatchedListLoader.f14617g = suggestedMembersBatchedListLoader.m16503a(immutableList);
        } else {
            suggestedMembersBatchedListLoader.f14616f = RegularImmutableList.a;
            suggestedMembersBatchedListLoader.f14617g = immutableList;
        }
        suggestedMembersBatchedListLoader.m16506a(false);
    }

    public final void m16506a(boolean z) {
        if (this.f14616f != null && this.f14617g != null) {
            Map hashMap = new HashMap();
            if (this.f14616f.size() > 0) {
                hashMap.put("member_suggestions_section", this.f14616f);
            }
            if (this.f14617g.size() > 0) {
                hashMap.put("member_picker_merged_section", this.f14617g);
                this.f14619i.mo890a(ImmutableMap.copyOf(hashMap));
            }
        } else if (z) {
            m16505a();
        }
    }

    private ImmutableList<User> m16503a(ImmutableList<User> immutableList) {
        if (this.f14618h == null || immutableList == null) {
            return immutableList;
        }
        Collection arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User user = (User) immutableList.get(i);
            if (!this.f14618h.contains(user.a)) {
                arrayList.add(user);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    public final void m16505a() {
        if (this.f14616f == null) {
            this.f14615e.f();
        }
        this.f14614d.f();
    }
}
