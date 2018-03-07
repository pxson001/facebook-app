package com.facebook.groups.editfavorites.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.groups.editfavorites.adapter.EditFavoritesSectionsPositionManager;
import com.facebook.groups.editfavorites.adapter.GroupDefaultEditFavoritesAdapterFactory;
import com.facebook.groups.editfavorites.adapter.GroupsEditFavoritesAdapter;
import com.facebook.groups.editfavorites.annotation.GroupsEditFavoritesNavigationHandler;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent.EventType;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEventBus;
import com.facebook.groups.editfavorites.navigation.GroupsDefaultEditFavoritesNavigationHandler;
import com.facebook.groups.editfavorites.view.GroupsEditFavoritesDragSortListView;
import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionRequeryListener;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager.SectionTailLoadListener;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.DragSortListView.DropListener;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: actorID */
public class GroupsEditFavoritesFragment extends FbFragment implements AnalyticsFragment {
    public static final String f10115f = GroupsEditFavoritesFragment.class.getName();
    @Inject
    Resources f10116a;
    public boolean al;
    @Inject
    GroupDefaultEditFavoritesAdapterFactory f10117b;
    @Inject
    public SectionedGroupsQueryManager f10118c;
    @Inject
    @GroupsEditFavoritesNavigationHandler
    GroupsNavigationHandler f10119d;
    @Inject
    public GroupFavoriteStatusEventBus f10120e;
    private GroupsEditFavoritesDragSortListView f10121g;
    public GroupsEditFavoritesAdapter f10122h;
    public SectionTailLoadListener f10123i;

    /* compiled from: actorID */
    class C11781 implements OnScrollListener {
        final /* synthetic */ GroupsEditFavoritesFragment f10110a;

        C11781(GroupsEditFavoritesFragment groupsEditFavoritesFragment) {
            this.f10110a = groupsEditFavoritesFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f10110a.f10118c != null) {
                Object obj = null;
                if (!this.f10110a.f10122h.isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 3 > i3) {
                    obj = 1;
                }
                if (obj != null) {
                    GroupsEditFavoritesFragment groupsEditFavoritesFragment = this.f10110a;
                    if (groupsEditFavoritesFragment.f10123i == null) {
                        groupsEditFavoritesFragment.f10123i = new C11825(groupsEditFavoritesFragment);
                    }
                    groupsEditFavoritesFragment.f10118c.mo278a(10, groupsEditFavoritesFragment.f10123i);
                }
            }
        }
    }

    /* compiled from: actorID */
    public class C11792 {
        public final /* synthetic */ GroupsEditFavoritesFragment f10111a;

        C11792(GroupsEditFavoritesFragment groupsEditFavoritesFragment) {
            this.f10111a = groupsEditFavoritesFragment;
        }
    }

    /* compiled from: actorID */
    class C11803 implements SectionRequeryListener {
        final /* synthetic */ GroupsEditFavoritesFragment f10112a;

        C11803(GroupsEditFavoritesFragment groupsEditFavoritesFragment) {
            this.f10112a = groupsEditFavoritesFragment;
        }

        public final void mo258a(HashMap<GroupSections, GroupsSectionInterface> hashMap, boolean z, int i) {
            if (!z) {
                GroupsEditFavoritesAdapter groupsEditFavoritesAdapter = this.f10112a.f10122h;
                groupsEditFavoritesAdapter.f10105b = hashMap;
                groupsEditFavoritesAdapter.f10104a.f10101b = hashMap;
                AdapterDetour.a(groupsEditFavoritesAdapter, 809872968);
            }
        }

        public final void mo257a() {
            BLog.b(GroupsEditFavoritesFragment.f10115f, "Unable to fetch groups from groupsstore");
        }
    }

    /* compiled from: actorID */
    class C11814 implements DropListener {
        final /* synthetic */ GroupsEditFavoritesFragment f10113a;

        C11814(GroupsEditFavoritesFragment groupsEditFavoritesFragment) {
            this.f10113a = groupsEditFavoritesFragment;
        }

        public final void m10464a(int i, int i2) {
            this.f10113a.f10118c.mo277a(i - 1, i2 - 1);
            GroupsEditFavoritesAdapter groupsEditFavoritesAdapter = this.f10113a.f10122h;
            this.f10113a.f10120e.a(new GroupFavoriteStatusEvent(EventType.REORDER));
            this.f10113a.al = true;
        }
    }

    /* compiled from: actorID */
    public class C11825 implements SectionTailLoadListener {
        final /* synthetic */ GroupsEditFavoritesFragment f10114a;

        public C11825(GroupsEditFavoritesFragment groupsEditFavoritesFragment) {
            this.f10114a = groupsEditFavoritesFragment;
        }

        public final void mo259a(GroupSections groupSections, boolean z) {
        }
    }

    public static void m10468a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsEditFavoritesFragment) obj).m10467a(ResourcesMethodAutoProvider.a(fbInjector), new GroupDefaultEditFavoritesAdapterFactory(new GroupsEditFavoritesAdapter(new EditFavoritesSectionsPositionManager(ResourcesMethodAutoProvider.a(fbInjector)), ResourcesMethodAutoProvider.a(fbInjector))), SectionGraphQLQueryManager.m10646b(fbInjector), (GroupsNavigationHandler) GroupsDefaultEditFavoritesNavigationHandler.m10476a(fbInjector), GroupFavoriteStatusEventBus.m10456a(fbInjector));
    }

    public final void m10472c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = GroupsEditFavoritesFragment.class;
        m10468a((Object) this, getContext());
        this.f10118c.mo282a(ImmutableList.of(GroupSections.FAVORITES_SECTION, GroupSections.FILTERED_GROUPS_SECTION));
    }

    public final View m10470a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2135396057);
        View inflate = layoutInflater.inflate(2130904701, viewGroup, false);
        this.f10121g = (GroupsEditFavoritesDragSortListView) inflate.findViewById(2131562750);
        this.f10121g.setOnScrollListener(new C11781(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1673619160, a);
        return inflate;
    }

    private void m10467a(Resources resources, GroupDefaultEditFavoritesAdapterFactory groupDefaultEditFavoritesAdapterFactory, SectionedGroupsQueryManager sectionedGroupsQueryManager, GroupsNavigationHandler groupsNavigationHandler, GroupFavoriteStatusEventBus groupFavoriteStatusEventBus) {
        this.f10116a = resources;
        this.f10117b = groupDefaultEditFavoritesAdapterFactory;
        this.f10118c = sectionedGroupsQueryManager;
        this.f10119d = groupsNavigationHandler;
        this.f10120e = groupFavoriteStatusEventBus;
    }

    public final void m10471a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f10119d.a(this, this.f10116a.getString(2131242538), null);
        this.f10121g = (GroupsEditFavoritesDragSortListView) e(2131562750);
        GroupDefaultEditFavoritesAdapterFactory groupDefaultEditFavoritesAdapterFactory = this.f10117b;
        groupDefaultEditFavoritesAdapterFactory.f10102a.f10107d = new C11792(this);
        this.f10122h = groupDefaultEditFavoritesAdapterFactory.f10102a;
        this.f10118c.mo280a(FilteredGroupsSectionOrdering.ALPHABETICAL, 10, new C11803(this));
        this.f10121g.setAdapter(this.f10122h);
        this.f10121g.setStickyHeaderEnabled(true);
        this.f10121g.m = new C11814(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1600815093);
        super.mY_();
        this.f10121g.setOnScrollListener(null);
        this.f10121g = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 551494052, a);
    }

    public final void m10469I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1864400591);
        super.I();
        this.f10118c.mo276a();
        this.f10118c = null;
        if (this.al) {
            this.f10120e.a(new GroupFavoriteStatusEvent(EventType.EDIT_DONE));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1588350206, a);
    }

    public final String am_() {
        return "group_edit_favorites";
    }
}
