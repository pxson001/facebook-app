package com.facebook.groups.memberlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEventSubscriber;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupBlockedMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupBlockedMemberEventSubscriber;
import com.facebook.groups.memberlist.view.DefaultGroupMembershipViewFactory;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: extra_video_uri */
public class GroupBlockedListFragment extends GroupMemberListBaseFragment {
    @Inject
    public GroupBlockedPagedListLoaderProvider f14213a;
    @Inject
    public MemberListRowSelectionHandlerProvider f14214b;
    private GroupBlockedMemberEventSubscriber f14215c;
    private GroupAdminMemberEventSubscriber f14216d;
    public MemberListRowSelectionHandler f14217e;

    /* compiled from: extra_video_uri */
    class C15261 extends GroupBlockedMemberEventSubscriber {
        final /* synthetic */ GroupBlockedListFragment f14211a;

        C15261(GroupBlockedListFragment groupBlockedListFragment) {
            this.f14211a = groupBlockedListFragment;
        }

        public final void m15791b(FbEvent fbEvent) {
            GroupBlockedMemberEvent groupBlockedMemberEvent = (GroupBlockedMemberEvent) fbEvent;
            if (!groupBlockedMemberEvent.f14433a.equals(this.f14211a.f14190a)) {
                return;
            }
            if (groupBlockedMemberEvent.f14435c) {
                GroupBlockedListFragment.aI(this.f14211a);
                if (this.f14211a.ar) {
                    this.f14211a.aw();
                    return;
                }
                return;
            }
            this.f14211a.m15761b(groupBlockedMemberEvent.f14434b);
            this.f14211a.mo848a(this.f14211a.aA());
        }
    }

    /* compiled from: extra_video_uri */
    class C15272 extends GroupAdminMemberEventSubscriber {
        final /* synthetic */ GroupBlockedListFragment f14212a;

        C15272(GroupBlockedListFragment groupBlockedListFragment) {
            this.f14212a = groupBlockedListFragment;
        }

        public final void m15792b(FbEvent fbEvent) {
            GroupAdminMemberEvent groupAdminMemberEvent = (GroupAdminMemberEvent) fbEvent;
            if (groupAdminMemberEvent.f14430a.equals(this.f14212a.f14190a) && groupAdminMemberEvent.f14431b.equals(this.f14212a.ao)) {
                this.f14212a.f14191b = groupAdminMemberEvent.f14432c;
                this.f14212a.f14217e.f14412m = this.f14212a.f14191b;
                Bundle bundle = this.f14212a.s;
                if (bundle != null) {
                    bundle.putString("group_admin_type", groupAdminMemberEvent.f14432c.toString());
                }
                GroupBlockedListFragment.aI(this.f14212a);
                if (this.f14212a.ar) {
                    this.f14212a.aw();
                }
            }
        }
    }

    public static void m15793a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupBlockedListFragment groupBlockedListFragment = (GroupBlockedListFragment) obj;
        GroupBlockedPagedListLoaderProvider groupBlockedPagedListLoaderProvider = (GroupBlockedPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupBlockedPagedListLoaderProvider.class);
        MemberListRowSelectionHandlerProvider memberListRowSelectionHandlerProvider = (MemberListRowSelectionHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemberListRowSelectionHandlerProvider.class);
        groupBlockedListFragment.f14213a = groupBlockedPagedListLoaderProvider;
        groupBlockedListFragment.f14214b = memberListRowSelectionHandlerProvider;
    }

    public final void mo855c(Bundle bundle) {
        super.mo855c(bundle);
        Class cls = GroupBlockedListFragment.class;
        m15793a((Object) this, getContext());
    }

    public final void mo858g(boolean z) {
        Object obj;
        super.mo858g(z);
        if (this.ar && this.f14195f != null && this.f14195f.b()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aw();
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1346273153);
        this.f14217e.m15950b(this.f14194e);
        this.f14217e.m15951b(this.f14215c);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2018225872, a);
    }

    protected final View as() {
        LayoutInflater from = LayoutInflater.from(getContext());
        DefaultGroupMembershipViewFactory defaultGroupMembershipViewFactory = this.ap;
        from.inflate(2130904733, (ViewGroup) e(2131563781), true);
        BetterTextView betterTextView = (BetterTextView) e(2131562802);
        betterTextView.setText(this.f14197h.getString(2131239506));
        return betterTextView;
    }

    protected final void mo847a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        super.mo847a((ImmutableList) immutableList);
        if (az()) {
            this.aq.m15835b(immutableList);
        } else {
            this.aq.m15832a((ImmutableList) immutableList);
        }
    }

    protected final boolean ar() {
        return false;
    }

    protected final void au() {
        this.f14217e = this.f14214b.m15952a(this.f14190a, this.f14191b);
        this.f14215c = new C15261(this);
        this.f14216d = new C15272(this);
        this.f14217e.f14410k = this.f14194e;
        this.f14217e.m15948a(this.f14215c);
        this.f14217e.m15948a(this.f14216d);
    }

    protected final GroupMemberBaseListLoader mo844a(String str) {
        GroupBlockedPagedListLoaderProvider groupBlockedPagedListLoaderProvider = this.f14213a;
        String str2 = this.f14190a;
        Integer valueOf = Integer.valueOf(aH());
        return new GroupBlockedPagedListLoader(TasksManager.b(groupBlockedPagedListLoaderProvider), str2, str, valueOf, GraphQLQueryExecutor.a(groupBlockedPagedListLoaderProvider), this.aw);
    }

    protected final boolean at() {
        return false;
    }

    protected final void mo846a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
        this.f14217e.m15947a(view, groupMemberListMemberItem, null);
    }

    protected final void mo848a(boolean z) {
        if (az() && z) {
            m15794j(true);
            return;
        }
        super.mo848a(z);
        int i = z ? 8 : 0;
        if (this.T != null) {
            e(2131563782).setVisibility(i);
        }
        m15794j(false);
    }

    private void m15794j(boolean z) {
        int i = z ? 0 : 8;
        if (this.T != null) {
            e(2131559433).setVisibility(i);
        }
    }

    public static void aI(GroupBlockedListFragment groupBlockedListFragment) {
        groupBlockedListFragment.ax();
        groupBlockedListFragment.aG();
    }
}
