package com.facebook.groups.members;

import android.content.Context;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: progress_segments */
public class GroupsMembersSelectorFragment extends GenericFriendsSelectorFragment {
    private GroupUsersListLoader aA;
    private GroupUsersListLoader aB;
    private final MemberListLoaderListener aC = new C05391(this);
    @Inject
    Toaster au;
    @Inject
    GroupUsersListLoaderProvider av;
    private String aw;
    private String ax = "";
    private TokenizedAutoCompleteTextView ay;
    private SectionedListSection<SimpleUserToken> az;

    /* compiled from: progress_segments */
    class C05391 implements MemberListLoaderListener<User> {
        final /* synthetic */ GroupsMembersSelectorFragment f5786a;

        C05391(GroupsMembersSelectorFragment groupsMembersSelectorFragment) {
            this.f5786a = groupsMembersSelectorFragment;
        }

        public final void mo312a(ImmutableList<User> immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f5786a.m7150a((ImmutableList) immutableList);
        }

        public final void mo313a(boolean z) {
            GenericFriendsSelectorFragment genericFriendsSelectorFragment = this.f5786a;
            if (genericFriendsSelectorFragment.at != null) {
                genericFriendsSelectorFragment.at.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* compiled from: progress_segments */
    class C05402 implements OnScrollListener {
        final /* synthetic */ GroupsMembersSelectorFragment f5787a;

        C05402(GroupsMembersSelectorFragment groupsMembersSelectorFragment) {
            this.f5787a = groupsMembersSelectorFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (GroupsMembersSelectorFragment.m7153a(i, i2, i3)) {
                GroupsMembersSelectorFragment.aS(this.f5787a);
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m7151a(Class<T> cls, T t) {
        m7152a((Object) t, t.getContext());
    }

    private static void m7152a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsMembersSelectorFragment) obj).m7149a(Toaster.b(fbInjector), (GroupUsersListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupUsersListLoaderProvider.class));
    }

    public final ImmutableList<String> m7159b() {
        return ax();
    }

    private GroupUsersListLoader m7155e() {
        if (this.aA == null) {
            this.aA = this.av.m7110a(this.aw, "", Integer.valueOf(jW_().getDimensionPixelSize(2131432407)), this.aC, Boolean.valueOf(false));
        }
        return this.aA;
    }

    private GroupUsersListLoader aQ() {
        if (!(this.aB == null || this.aB.f5784h.equals(this.ax))) {
            this.aB.m7099e();
        }
        if (this.aB == null || !this.aB.f5784h.equals(this.ax)) {
            this.aB = this.av.m7110a(this.aw, this.ax.trim(), Integer.valueOf(jW_().getDimensionPixelSize(2131432407)), this.aC, Boolean.valueOf(true));
        }
        return this.aB;
    }

    public void mo321c(Bundle bundle) {
        super.mo321c(bundle);
        m7151a(GroupsMembersSelectorFragment.class, (InjectableComponentWithContext) this);
        Bundle extras = o().getIntent().getExtras();
        if (extras != null) {
            this.aw = extras.getString("group_feed_id");
        }
        if (StringUtil.a(this.aw) && this.s != null) {
            this.aw = this.s.getString("group_feed_id");
        }
        Preconditions.checkNotNull(this.aw);
    }

    public final void mo322d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1004816572);
        super.mo322d(bundle);
        this.ay = this.ao.mo1230d(this.T);
        this.ay.setTextMode(TextMode.PLAIN_TEXT);
        this.ay.setHint(2131238310);
        this.ay.p = jW_().getColor(2131363506);
        this.ao.mo1229c(this.T).a(new C05402(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -440682932, a);
    }

    private void m7149a(Toaster toaster, GroupUsersListLoaderProvider groupUsersListLoaderProvider) {
        this.au = toaster;
        this.av = groupUsersListLoaderProvider;
    }

    public final void mo314H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -572860572);
        if (this.aA != null) {
            this.aA.m7099e();
        }
        if (this.aB != null) {
            this.aB.m7099e();
        }
        super.mo314H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 565770511, a);
    }

    protected final void aG() {
        String charSequence = this.ay.getUserEnteredPlainText().toString();
        if (!this.ax.equals(charSequence)) {
            this.ax = charSequence;
            aR();
            aS(this);
        }
    }

    protected final void mo323g(int i) {
        ImmutableList b = m7159b();
        SimpleUserToken simpleUserToken = (SimpleUserToken) this.al.getItem(i);
        if (simpleUserToken == null || b.contains(simpleUserToken.p()) || b.size() <= 49) {
            super.mo323g(i);
        } else {
            this.au.b(new ToastBuilder(2131238312));
        }
    }

    protected final int mo320b(String str) {
        return 2131238311;
    }

    protected final ImmutableList<String> aD() {
        return ImmutableList.of("group_members_section");
    }

    protected final boolean at() {
        return true;
    }

    protected final boolean aP() {
        return false;
    }

    private void aR() {
        if (this.az == null) {
            this.az = new ImmutableSectionedListSection(jW_().getString(mo320b("group_members_section")), RegularImmutableList.a);
        }
        if (!this.al.isEmpty()) {
            this.al.a(0, this.az);
        }
    }

    public final void m7157a(ArrayList<User> arrayList) {
        Builder builder = ImmutableSet.builder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            builder.c(new SimpleUserToken((User) arrayList.get(i)));
        }
        m7135a(builder.b());
    }

    private void m7150a(ImmutableList<User> immutableList) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.b("group_members_section", immutableList);
        m7134a(builder.b());
    }

    public static void aS(GroupsMembersSelectorFragment groupsMembersSelectorFragment) {
        if (StringUtil.a(groupsMembersSelectorFragment.ax)) {
            groupsMembersSelectorFragment.m7155e().m7100f();
            if (groupsMembersSelectorFragment.aB != null) {
                groupsMembersSelectorFragment.aB.m7099e();
                return;
            }
            return;
        }
        groupsMembersSelectorFragment.aQ().m7100f();
        if (groupsMembersSelectorFragment.aA != null) {
            groupsMembersSelectorFragment.aA.m7099e();
        }
    }

    private static boolean m7153a(int i, int i2, int i3) {
        return (i + i2) + 5 >= i3;
    }

    protected final void aM() {
        aS(this);
    }

    static /* synthetic */ void m7148a(GroupsMembersSelectorFragment groupsMembersSelectorFragment, boolean z) {
        if (groupsMembersSelectorFragment.at != null) {
            groupsMembersSelectorFragment.at.setVisibility(z ? 0 : 8);
        }
    }
}
