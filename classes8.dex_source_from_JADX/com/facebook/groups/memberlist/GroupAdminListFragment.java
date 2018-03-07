package com.facebook.groups.memberlist;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.memberlist.GroupMemberListSeeMoreView.MemberListSeeMoreListener;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEventSubscriber;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveMemberEventSubscriber;
import com.facebook.groups.memberlist.intent.MembershipIntentBuilder;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.groups.memberlist.view.DefaultGroupMembershipViewFactory;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: extras_taggable_gallery_creative_editing_data_list */
public class GroupAdminListFragment extends GroupMemberListBaseFragment {
    @Inject
    SecureContextHelper f14199a;
    public GroupAdminsPagedListLoader as;
    private GroupRemoveMemberEventSubscriber at;
    private GroupAdminMemberEventSubscriber au;
    public MemberListRowSelectionHandler av;
    public BetterTextView aw;
    public BetterTextView ax;
    public GroupMemberListWithStickyHeaderAdapter ay;
    public GroupMemberListIndexModel az;
    @Inject
    GroupAdminsPagedListLoaderProvider f14200b;
    @Inject
    GroupMembershipController f14201c;
    @Inject
    MembershipIntentBuilder f14202d;
    @Inject
    MemberListRowSelectionHandlerProvider f14203e;
    @Inject
    GroupMemberListWithStickyHeaderAdapterProvider f14204f;
    @Inject
    GroupMemberItemRendererProvider f14205g;

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15201 implements GroupsMemberRowListener {
        final /* synthetic */ GroupAdminListFragment f14184a;

        C15201(GroupAdminListFragment groupAdminListFragment) {
            this.f14184a = groupAdminListFragment;
        }

        public final void mo842a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
            this.f14184a.mo846a(view, groupMemberListMemberItem);
        }
    }

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15212 implements MemberListSeeMoreListener {
        final /* synthetic */ GroupAdminListFragment f14185a;

        C15212(GroupAdminListFragment groupAdminListFragment) {
            this.f14185a = groupAdminListFragment;
        }

        public final void mo843a(MemberSection memberSection, MemberListLoaderListener memberListLoaderListener) {
            this.f14185a.f14195f.a(memberSection, memberListLoaderListener);
        }
    }

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15223 implements OnClickListener {
        final /* synthetic */ GroupAdminListFragment f14186a;

        C15223(GroupAdminListFragment groupAdminListFragment) {
            this.f14186a = groupAdminListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1139500866);
            this.f14186a.mo848a(false);
            this.f14186a.m15762b(true);
            this.f14186a.f14201c.m15919c(this.f14186a.f14190a, this.f14186a.ao);
            Logger.a(2, EntryType.UI_INPUT_END, -1178579223, a);
        }
    }

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15234 implements OnClickListener {
        final /* synthetic */ GroupAdminListFragment f14187a;

        C15234(GroupAdminListFragment groupAdminListFragment) {
            this.f14187a = groupAdminListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -879117547);
            this.f14187a.f14199a.a(this.f14187a.f14202d.m15979a(this.f14187a.f14190a, this.f14187a.f14191b.toString()), this.f14187a.ao());
            Logger.a(2, EntryType.UI_INPUT_END, 740714930, a);
        }
    }

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15245 extends GroupRemoveMemberEventSubscriber {
        final /* synthetic */ GroupAdminListFragment f14188a;

        C15245(GroupAdminListFragment groupAdminListFragment) {
            this.f14188a = groupAdminListFragment;
        }

        public final void m15748b(FbEvent fbEvent) {
            GroupRemoveMemberEvent groupRemoveMemberEvent = (GroupRemoveMemberEvent) fbEvent;
            if (groupRemoveMemberEvent.f14438a.equals(this.f14188a.f14190a)) {
                GroupMemberListBaseFragment groupMemberListBaseFragment = this.f14188a;
                groupMemberListBaseFragment.m15761b(groupRemoveMemberEvent.f14439b);
                groupMemberListBaseFragment.mo848a(groupMemberListBaseFragment.aA());
            }
        }
    }

    /* compiled from: extras_taggable_gallery_creative_editing_data_list */
    class C15256 extends GroupAdminMemberEventSubscriber {
        final /* synthetic */ GroupAdminListFragment f14189a;

        C15256(GroupAdminListFragment groupAdminListFragment) {
            this.f14189a = groupAdminListFragment;
        }

        public final void m15750b(FbEvent fbEvent) {
            GroupAdminMemberEvent groupAdminMemberEvent = (GroupAdminMemberEvent) fbEvent;
            if (groupAdminMemberEvent.f14430a.equals(this.f14189a.f14190a)) {
                if (groupAdminMemberEvent.f14431b.equals(this.f14189a.ao)) {
                    this.f14189a.f14191b = groupAdminMemberEvent.f14432c;
                    this.f14189a.av.f14412m = this.f14189a.f14191b;
                    this.f14189a.m15768h(!this.f14189a.av.m15949a());
                    Bundle bundle = this.f14189a.s;
                    if (bundle != null) {
                        bundle.putString("group_admin_type", groupAdminMemberEvent.f14432c.toString());
                    }
                }
                GroupMemberListBaseFragment groupMemberListBaseFragment = this.f14189a;
                groupMemberListBaseFragment.az.m15874c();
                AdapterDetour.a(groupMemberListBaseFragment.ay, -1206382529);
                groupMemberListBaseFragment.ax();
                groupMemberListBaseFragment.aG();
                this.f14189a.aw();
            }
        }
    }

    public static void m15770a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupAdminListFragment) obj).m15769a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (GroupAdminsPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupAdminsPagedListLoaderProvider.class), GroupMembershipController.m15917b(fbInjector), MembershipIntentBuilder.m15977a(fbInjector), (MemberListRowSelectionHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemberListRowSelectionHandlerProvider.class), (GroupMemberListWithStickyHeaderAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMemberListWithStickyHeaderAdapterProvider.class), (GroupMemberItemRendererProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMemberItemRendererProvider.class));
    }

    private void m15769a(SecureContextHelper secureContextHelper, GroupAdminsPagedListLoaderProvider groupAdminsPagedListLoaderProvider, GroupMembershipController groupMembershipController, MembershipIntentBuilder membershipIntentBuilder, MemberListRowSelectionHandlerProvider memberListRowSelectionHandlerProvider, GroupMemberListWithStickyHeaderAdapterProvider groupMemberListWithStickyHeaderAdapterProvider, GroupMemberItemRendererProvider groupMemberItemRendererProvider) {
        this.f14199a = secureContextHelper;
        this.f14200b = groupAdminsPagedListLoaderProvider;
        this.f14201c = groupMembershipController;
        this.f14202d = membershipIntentBuilder;
        this.f14203e = memberListRowSelectionHandlerProvider;
        this.f14204f = groupMemberListWithStickyHeaderAdapterProvider;
        this.f14205g = groupMemberItemRendererProvider;
    }

    public final void mo855c(Bundle bundle) {
        super.mo855c(bundle);
        Class cls = GroupAdminListFragment.class;
        m15770a((Object) this, getContext());
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

    protected final boolean mo854b() {
        return false;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1326409299);
        this.av.m15950b(this.f14194e);
        this.av.m15951b(this.at);
        this.av.m15951b(this.au);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -352422712, a);
    }

    protected final FbBaseAdapter mo856e() {
        if (this.ay == null) {
            aI();
        }
        return this.ay;
    }

    protected final GroupMemberListAdapterHelper aq() {
        if (this.ay == null) {
            aI();
        }
        return this.ay;
    }

    private void aI() {
        this.az = new GroupMemberListIndexModel();
        GroupMemberListInfoManager groupMemberListInfoManager = new GroupMemberListInfoManager();
        this.ay = this.f14204f.m15902a(this.az, this.az, this.f14205g.m15822a(new C15201(this), groupMemberListInfoManager, new C15212(this)), groupMemberListInfoManager, new GroupMemberCompositeAdapterController());
    }

    protected final boolean ar() {
        return false;
    }

    protected final View as() {
        LayoutInflater.from(getContext()).inflate(2130903184, (ViewGroup) e(2131563781), true);
        ViewGroup viewGroup = (ViewGroup) e(2131559431);
        ViewStub viewStub = (ViewStub) e(2131559432);
        DefaultGroupMembershipViewFactory defaultGroupMembershipViewFactory = this.ap;
        viewStub.setLayoutResource(2130904733);
        ((BetterTextView) viewStub.inflate()).setText(this.f14197h.getText(2131239497));
        this.aw = (BetterTextView) e(2131559434);
        this.aw.setOnClickListener(new C15223(this));
        this.ax = (BetterTextView) e(2131559435);
        this.ax.setOnClickListener(new C15234(this));
        return viewGroup;
    }

    protected final boolean at() {
        return false;
    }

    protected final GroupMemberBaseListLoader mo844a(String str) {
        GroupAdminsPagedListLoaderProvider groupAdminsPagedListLoaderProvider = this.f14200b;
        String str2 = this.f14190a;
        Integer valueOf = Integer.valueOf(aH());
        String str3 = str2;
        String str4 = str;
        Integer num = valueOf;
        this.as = new GroupAdminsPagedListLoader(TasksManager.b(groupAdminsPagedListLoaderProvider), str3, str4, num, GraphQLQueryExecutor.a(groupAdminsPagedListLoaderProvider), this.aw);
        return this.as;
    }

    protected final void au() {
        this.av = this.f14203e.m15952a(this.f14190a, this.f14191b);
        m15768h(!this.av.m15949a());
        this.at = new C15245(this);
        this.au = new C15256(this);
        this.av.f14410k = this.f14194e;
        this.av.m15948a(this.at);
        this.av.m15948a(this.au);
    }

    public final void mo848a(boolean z) {
        if (az() && z) {
            m15771k(true);
            return;
        }
        super.mo848a(z);
        if (!(this.aw == null || this.ax == null)) {
            if (z && this.as != null && this.as.f14210i) {
                this.aw.setVisibility(0);
                this.ax.setVisibility(0);
            } else {
                this.aw.setVisibility(8);
                this.ax.setVisibility(8);
            }
        }
        int i = z ? 8 : 0;
        if (this.T != null) {
            e(2131563782).setVisibility(i);
        }
        m15771k(false);
    }

    protected final GroupMemberListMemberItem mo857g(int i) {
        return (GroupMemberListMemberItem) this.ay.getItem(i);
    }

    protected final void mo846a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
        this.av.m15947a(view, groupMemberListMemberItem, null);
    }

    private void m15771k(boolean z) {
        int i = z ? 0 : 8;
        if (this.T != null) {
            e(2131559433).setVisibility(i);
        }
    }

    protected final void mo845a(Editable editable) {
        this.az.m15874c();
        AdapterDetour.a(this.ay, 1796009912);
        super.mo845a(editable);
        aw();
    }

    protected final void mo847a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        this.az.m15871a((ImmutableList) immutableList, this.f14195f.d());
        AdapterDetour.a(this.ay, -1826039688);
        super.mo847a((ImmutableList) immutableList);
    }
}
