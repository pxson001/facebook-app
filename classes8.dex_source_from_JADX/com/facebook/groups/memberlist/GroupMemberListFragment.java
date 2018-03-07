package com.facebook.groups.memberlist;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.BlockState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.memberlist.GroupMemberListSeeMoreView.MemberListSeeMoreListener;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEventSubscriber;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupBlockedMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupBlockedMemberEventSubscriber;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveInviteEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveInviteEventSubscriber;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveMemberEventSubscriber;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.groups.memberlist.nux.GroupsMultiTierAdminNuxInterstitialController;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIds.FetchGroupAdminIdsString;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIdsModels.FetchGroupAdminIdsModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIdsModels.FetchGroupAdminIdsModel.GroupAdminsModel.EdgesModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIdsModels.FetchGroupAdminIdsModel.GroupAdminsModel.PageInfoModel;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIdsModels.FetchGroupAdminIdsModel.GroupConfigsModel.NodesModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: extra_show_current_location */
public class GroupMemberListFragment extends GroupMemberListBaseFragment {
    public static final Class<?> f14252g = GroupMemberListFragment.class;
    @Inject
    GroupMemberListWithStickyHeaderAdapterProvider f14253a;
    public GroupMemberListWithStickyHeaderAdapter aA;
    private GroupMemberListIndexModel aB;
    private GroupRemoveMemberEventSubscriber as;
    private GroupAdminMemberEventSubscriber at;
    private GroupBlockedMemberEventSubscriber au;
    private GroupRemoveInviteEventSubscriber av;
    public Set<String> aw = null;
    public Set<String> ax = null;
    public String ay = null;
    public MemberListRowSelectionHandler az;
    @Inject
    @ForUiThread
    ExecutorService f14254b;
    @Inject
    MemberListRowSelectionHandlerProvider f14255c;
    @Inject
    GroupMemberItemRendererProvider f14256d;
    @Inject
    GroupMembersPagedListLoaderProvider f14257e;
    @Inject
    InterstitialManager f14258f;

    /* compiled from: extra_show_current_location */
    class C15371 implements GroupsMemberRowListener {
        final /* synthetic */ GroupMemberListFragment f14244a;

        C15371(GroupMemberListFragment groupMemberListFragment) {
            this.f14244a = groupMemberListFragment;
        }

        public final void mo842a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
            this.f14244a.mo846a(view, groupMemberListMemberItem);
        }
    }

    /* compiled from: extra_show_current_location */
    class C15382 implements MemberListSeeMoreListener {
        final /* synthetic */ GroupMemberListFragment f14245a;

        C15382(GroupMemberListFragment groupMemberListFragment) {
            this.f14245a = groupMemberListFragment;
        }

        public final void mo843a(MemberSection memberSection, MemberListLoaderListener memberListLoaderListener) {
            this.f14245a.f14195f.a(memberSection, memberListLoaderListener);
        }
    }

    /* compiled from: extra_show_current_location */
    class C15393 extends GroupRemoveMemberEventSubscriber {
        final /* synthetic */ GroupMemberListFragment f14246a;

        C15393(GroupMemberListFragment groupMemberListFragment) {
            this.f14246a = groupMemberListFragment;
        }

        public final void m15842b(FbEvent fbEvent) {
            GroupRemoveMemberEvent groupRemoveMemberEvent = (GroupRemoveMemberEvent) fbEvent;
            if (groupRemoveMemberEvent.f14438a.equals(this.f14246a.f14190a)) {
                Object obj = null;
                if (this.f14246a.aw != null && this.f14246a.aw.contains(groupRemoveMemberEvent.f14439b)) {
                    this.f14246a.aw.remove(groupRemoveMemberEvent.f14439b);
                    obj = 1;
                }
                if (this.f14246a.ax != null && this.f14246a.ax.contains(groupRemoveMemberEvent.f14439b)) {
                    this.f14246a.ax.remove(groupRemoveMemberEvent.f14439b);
                    obj = 1;
                }
                if (obj != null) {
                    GroupMemberListFragment.aL(this.f14246a);
                }
                GroupMemberListFragment.m15849c(this.f14246a, groupRemoveMemberEvent.f14439b);
            }
        }
    }

    /* compiled from: extra_show_current_location */
    class C15404 extends GroupAdminMemberEventSubscriber {
        final /* synthetic */ GroupMemberListFragment f14247a;

        C15404(GroupMemberListFragment groupMemberListFragment) {
            this.f14247a = groupMemberListFragment;
        }

        public final void m15843b(FbEvent fbEvent) {
            GroupAdminMemberEvent groupAdminMemberEvent = (GroupAdminMemberEvent) fbEvent;
            if (groupAdminMemberEvent.f14430a.equals(this.f14247a.f14190a)) {
                AdminState adminState;
                if (GraphQLGroupAdminType.ADMIN == groupAdminMemberEvent.f14432c) {
                    if (this.f14247a.aw != null) {
                        this.f14247a.aw.add(groupAdminMemberEvent.f14431b);
                    }
                    if (this.f14247a.ax != null) {
                        this.f14247a.ax.remove(groupAdminMemberEvent.f14431b);
                    }
                } else if (GraphQLGroupAdminType.MODERATOR == groupAdminMemberEvent.f14432c) {
                    if (this.f14247a.ax != null) {
                        this.f14247a.ax.add(groupAdminMemberEvent.f14431b);
                    }
                    if (this.f14247a.aw != null) {
                        this.f14247a.aw.remove(groupAdminMemberEvent.f14431b);
                    }
                } else {
                    if (this.f14247a.aw != null) {
                        this.f14247a.aw.remove(groupAdminMemberEvent.f14431b);
                    }
                    if (this.f14247a.ax != null) {
                        this.f14247a.ax.remove(groupAdminMemberEvent.f14431b);
                    }
                }
                if (groupAdminMemberEvent.f14431b.equals(this.f14247a.ao)) {
                    this.f14247a.f14191b = groupAdminMemberEvent.f14432c;
                    this.f14247a.az.f14412m = this.f14247a.f14191b;
                    Bundle bundle = this.f14247a.s;
                    if (bundle != null) {
                        bundle.putString("group_admin_type", groupAdminMemberEvent.f14432c.toString());
                    }
                }
                GroupMemberListFragment.aL(this.f14247a);
                switch (C15448.f14251a[groupAdminMemberEvent.f14432c.ordinal()]) {
                    case 1:
                        adminState = AdminState.ADMIN;
                        break;
                    case 2:
                        adminState = AdminState.MODERATOR;
                        break;
                    default:
                        adminState = AdminState.NOT_ADMIN;
                        break;
                }
                GroupMemberListBaseFragment groupMemberListBaseFragment = this.f14247a;
                String str = groupAdminMemberEvent.f14431b;
                Builder builder = new Builder();
                ImmutableList immutableList = groupMemberListBaseFragment.f14192c;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    GroupMemberListMemberItem groupMemberListMemberItem = (GroupMemberListMemberItem) immutableList.get(i);
                    if (groupMemberListMemberItem.f14272d.b().equals(str)) {
                        builder.c(new GroupMemberListMemberItem(groupMemberListMemberItem.f14272d, adminState, BlockState.NOT_BLOCKED, groupMemberListMemberItem.f14273e));
                    } else {
                        builder.c(groupMemberListMemberItem);
                    }
                }
                groupMemberListBaseFragment.mo847a(builder.b());
            }
        }
    }

    /* compiled from: extra_show_current_location */
    class C15415 extends GroupBlockedMemberEventSubscriber {
        final /* synthetic */ GroupMemberListFragment f14248a;

        C15415(GroupMemberListFragment groupMemberListFragment) {
            this.f14248a = groupMemberListFragment;
        }

        public final void m15844b(FbEvent fbEvent) {
            GroupBlockedMemberEvent groupBlockedMemberEvent = (GroupBlockedMemberEvent) fbEvent;
            if (groupBlockedMemberEvent.f14435c && groupBlockedMemberEvent.f14433a.equals(this.f14248a.f14190a)) {
                GroupMemberListFragment.m15849c(this.f14248a, groupBlockedMemberEvent.f14434b);
            }
        }
    }

    /* compiled from: extra_show_current_location */
    class C15426 extends GroupRemoveInviteEventSubscriber {
        final /* synthetic */ GroupMemberListFragment f14249a;

        C15426(GroupMemberListFragment groupMemberListFragment) {
            this.f14249a = groupMemberListFragment;
        }

        public final void m15846b(FbEvent fbEvent) {
            GroupRemoveInviteEvent groupRemoveInviteEvent = (GroupRemoveInviteEvent) fbEvent;
            if (groupRemoveInviteEvent.f14436a.equals(this.f14249a.f14190a)) {
                GroupMemberListFragment.m15849c(this.f14249a, groupRemoveInviteEvent.f14437b);
            }
        }
    }

    /* compiled from: extra_show_current_location */
    class C15437 implements FutureCallback<GraphQLResult<FetchGroupAdminIdsModel>> {
        final /* synthetic */ GroupMemberListFragment f14250a;

        C15437(GroupMemberListFragment groupMemberListFragment) {
            this.f14250a = groupMemberListFragment;
        }

        public void onSuccess(Object obj) {
            boolean z;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            int i = 0;
            if (this.f14250a.aw == null) {
                this.f14250a.aw = new HashSet();
            }
            if (this.f14250a.ax == null) {
                this.f14250a.ax = new HashSet();
            }
            if (graphQLResult.e == null || ((FetchGroupAdminIdsModel) graphQLResult.e).m16040j() == null || ((FetchGroupAdminIdsModel) graphQLResult.e).m16040j().m16033a() == null || ((FetchGroupAdminIdsModel) graphQLResult.e).m16040j().m16033a().isEmpty()) {
                z = false;
            } else if (((FetchGroupAdminIdsModel) graphQLResult.e).m16040j().m16033a().get(0) == null || !((NodesModel) ((FetchGroupAdminIdsModel) graphQLResult.e).m16040j().m16033a().get(0)).m16029a()) {
                z = false;
            } else {
                z = true;
            }
            MemberListRowSelectionHandler.f14399n = z;
            if (graphQLResult.e != null && ((FetchGroupAdminIdsModel) graphQLResult.e).m16037a() != null && ((FetchGroupAdminIdsModel) graphQLResult.e).m16037a().m16017a() > 0) {
                ImmutableList j = ((FetchGroupAdminIdsModel) graphQLResult.e).m16037a().m16021j();
                int size = j.size();
                while (i < size) {
                    EdgesModel edgesModel = (EdgesModel) j.get(i);
                    if (!(edgesModel.m16006j() == null || edgesModel.m16006j().m16001j() == null)) {
                        if (GraphQLGroupAdminType.MODERATOR == edgesModel.m16004a()) {
                            this.f14250a.ax.add(edgesModel.m16006j().m16001j());
                        } else {
                            this.f14250a.aw.add(edgesModel.m16006j().m16001j());
                        }
                    }
                    i++;
                }
                GroupMemberListFragment.aL(this.f14250a);
                PageInfoModel k = ((FetchGroupAdminIdsModel) graphQLResult.e).m16037a().m16022k();
                if (k != null && k.m16015b()) {
                    this.f14250a.ay = k.m16013a();
                    GroupMemberListFragment.aK(this.f14250a);
                }
            }
        }

        public void onFailure(Throwable th) {
            if (this.f14250a.aw == null) {
                this.f14250a.aw = new HashSet();
                AdapterDetour.a(this.f14250a.aA, 1276746642);
            }
            if (this.f14250a.ax == null) {
                this.f14250a.ax = new HashSet();
            }
            BLog.b(GroupMemberListFragment.f14252g, "Failed to fetch all admin ids.");
        }
    }

    /* compiled from: extra_show_current_location */
    /* synthetic */ class C15448 {
        static final /* synthetic */ int[] f14251a = new int[GraphQLGroupAdminType.values().length];

        static {
            try {
                f14251a[GraphQLGroupAdminType.ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14251a[GraphQLGroupAdminType.MODERATOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m15848a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupMemberListFragment) obj).m15847a((GroupMemberListWithStickyHeaderAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMemberListWithStickyHeaderAdapterProvider.class), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (MemberListRowSelectionHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemberListRowSelectionHandlerProvider.class), (GroupMemberItemRendererProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMemberItemRendererProvider.class), (GroupMembersPagedListLoaderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupMembersPagedListLoaderProvider.class), InterstitialManager.a(fbInjector));
    }

    private void m15847a(GroupMemberListWithStickyHeaderAdapterProvider groupMemberListWithStickyHeaderAdapterProvider, ExecutorService executorService, MemberListRowSelectionHandlerProvider memberListRowSelectionHandlerProvider, GroupMemberItemRendererProvider groupMemberItemRendererProvider, GroupMembersPagedListLoaderProvider groupMembersPagedListLoaderProvider, InterstitialManager interstitialManager) {
        this.f14253a = groupMemberListWithStickyHeaderAdapterProvider;
        this.f14254b = executorService;
        this.f14255c = memberListRowSelectionHandlerProvider;
        this.f14256d = groupMemberItemRendererProvider;
        this.f14257e = groupMembersPagedListLoaderProvider;
        this.f14258f = interstitialManager;
    }

    public final void mo855c(Bundle bundle) {
        super.mo855c(bundle);
        Class cls = GroupMemberListFragment.class;
        m15848a((Object) this, getContext());
        m15768h(false);
    }

    public static void aK(GroupMemberListFragment groupMemberListFragment) {
        GraphQlQueryString fetchGroupAdminIdsString = new FetchGroupAdminIdsString();
        fetchGroupAdminIdsString.a("group_id", groupMemberListFragment.f14190a).a("member_count", "50").a("end_cursor", groupMemberListFragment.ay).a("fetch_admin_type", Boolean.valueOf(true));
        Futures.a(groupMemberListFragment.al.a(GraphQLRequest.a(fetchGroupAdminIdsString).a(GraphQLCachePolicy.c)), new C15437(groupMemberListFragment), groupMemberListFragment.f14254b);
    }

    public final void mo871a(View view, Bundle bundle) {
        super.mo871a(view, bundle);
        View e = e(2131563783);
        if (GraphQLGroupAdminType.ADMIN == this.f14191b) {
            GroupsMultiTierAdminNuxInterstitialController groupsMultiTierAdminNuxInterstitialController = (GroupsMultiTierAdminNuxInterstitialController) this.f14258f.a(new InterstitialTrigger(Action.GROUP_ADD_MODERATOR), GroupsMultiTierAdminNuxInterstitialController.class);
            if (!(groupsMultiTierAdminNuxInterstitialController == null || e == null)) {
                if (e != null) {
                    Tooltip tooltip = new Tooltip(e.getContext(), 2);
                    tooltip.t = -1;
                    tooltip.a(2131239514);
                    tooltip.f(e);
                }
                this.f14258f.a().a(groupsMultiTierAdminNuxInterstitialController.m15987b());
            }
        }
        aK(this);
    }

    private void aJ() {
        this.aB = new GroupMemberListIndexModel();
        GroupMemberListInfoManager groupMemberListInfoManager = new GroupMemberListInfoManager();
        this.aA = this.f14253a.m15902a(this.aB, this.aB, this.f14256d.m15822a(new C15371(this), groupMemberListInfoManager, new C15382(this)), groupMemberListInfoManager, new GroupMemberCompositeAdapterController());
    }

    protected final FbBaseAdapter mo856e() {
        if (this.aA == null) {
            aJ();
        }
        return this.aA;
    }

    protected final GroupMemberListAdapterHelper aq() {
        if (this.aA == null) {
            aJ();
        }
        return this.aA;
    }

    protected final boolean ar() {
        return false;
    }

    protected final void au() {
        this.az = this.f14255c.m15952a(this.f14190a, this.f14191b);
        m15768h(!this.az.m15949a());
        this.as = new C15393(this);
        this.at = new C15404(this);
        this.au = new C15415(this);
        this.av = new C15426(this);
        this.az.f14410k = this.f14194e;
        this.az.m15948a(this.as);
        this.az.m15948a(this.at);
        this.az.m15948a(this.au);
        this.az.m15948a(this.av);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 632802521);
        this.az.m15950b(this.f14194e);
        this.az.m15951b(this.as);
        this.az.m15951b(this.at);
        this.az.m15951b(this.au);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1346734527, a);
    }

    protected final GroupMemberBaseListLoader mo844a(String str) {
        return this.f14257e.m15915a(this.f14190a, str, Boolean.valueOf(ar()), Boolean.valueOf(false), Integer.valueOf(aH()), this.aw);
    }

    protected final void mo846a(View view, GroupMemberListMemberItem groupMemberListMemberItem) {
        this.az.m15947a(view, groupMemberListMemberItem, this.av);
    }

    protected final boolean at() {
        return true;
    }

    public final void mo847a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        this.aB.m15871a((ImmutableList) immutableList, this.f14195f.d());
        AdapterDetour.a(this.aA, -1705620535);
        super.mo847a((ImmutableList) immutableList);
    }

    public static void aL(GroupMemberListFragment groupMemberListFragment) {
        if (groupMemberListFragment.aw != null) {
            if (groupMemberListFragment.az != null) {
                groupMemberListFragment.az.f14408i = groupMemberListFragment.aw;
            }
            GroupMemberListInfoManager a = groupMemberListFragment.aA.mo867a();
            Collection collection = groupMemberListFragment.aw;
            a.f14263a.clear();
            a.f14263a.addAll(collection);
        }
        if (groupMemberListFragment.ax != null) {
            if (groupMemberListFragment.az != null) {
                groupMemberListFragment.az.f14409j = groupMemberListFragment.ax;
            }
            a = groupMemberListFragment.aA.mo867a();
            collection = groupMemberListFragment.ax;
            a.f14264b.clear();
            a.f14264b.addAll(collection);
        }
        groupMemberListFragment.m15768h(!groupMemberListFragment.az.m15949a());
    }

    protected final GroupMemberListMemberItem mo857g(int i) {
        Object item = this.aA.getItem(i);
        if (item instanceof GroupMemberListMemberItem) {
            return (GroupMemberListMemberItem) item;
        }
        return null;
    }

    protected final void mo845a(Editable editable) {
        this.aB.m15874c();
        AdapterDetour.a(this.aA, 57773303);
        super.mo845a(editable);
        aw();
    }

    protected final boolean mo854b() {
        return false;
    }

    public static void m15849c(GroupMemberListFragment groupMemberListFragment, String str) {
        groupMemberListFragment.m15761b(str);
        if (groupMemberListFragment.aA()) {
            groupMemberListFragment.aB.m15874c();
            AdapterDetour.a(groupMemberListFragment.aA, -2049221038);
            groupMemberListFragment.mo848a(true);
        }
    }
}
