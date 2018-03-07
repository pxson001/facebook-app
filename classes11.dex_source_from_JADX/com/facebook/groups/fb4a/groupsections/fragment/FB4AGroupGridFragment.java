package com.facebook.groups.fb4a.groupsections.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupHideInputData;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupLeaveInputData.Source;
import com.facebook.graphql.calls.GroupUnhideInputData;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEvent.EventType;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEventBus;
import com.facebook.groups.editfavorites.event.GroupFavoriteStatusEventSubscriber;
import com.facebook.groups.editfavorites.intent.GroupEditFavoritesIntentBuilder;
import com.facebook.groups.fb4a.groupsections.view.FB4AGroupsPogGridViewFactory;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.SectionedGroupsQueryManager;
import com.facebook.groups.groupsections.noncursored.GroupPogGridData;
import com.facebook.groups.groupsections.noncursored.GroupSectionsOptimisiticMutationsHelper;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager.AnonymousClass11;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager.C12046;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager.C12057;
import com.facebook.groups.groupsections.noncursored.SectionGraphQLQueryManager.GraphQLTasks;
import com.facebook.groups.groupsgrid.adapter.GroupsRecyclerViewSectionedGridAdapter;
import com.facebook.groups.groupsgrid.adapter.GroupsRecyclerViewSectionedGridAdapterProvider;
import com.facebook.groups.groupsgrid.fragment.AbstractGroupsPogGridFragment;
import com.facebook.groups.groupsgrid.fragment.AbstractGroupsPogGridFragment.C12202;
import com.facebook.groups.groupsgrid.fragment.AbstractGroupsPogGridFragment.C12213;
import com.facebook.groups.groupsgrid.fragment.AbstractGroupsPogGridFragment.LoadingState;
import com.facebook.groups.groupsgrid.mutations.GroupHiddenStatusUpdater;
import com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutations.GroupHideMutationString;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutations.GroupUnhideMutationString;
import com.facebook.groups.groupsgrid.utils.ResizeValues;
import com.facebook.groups.preferences.GroupsPreferenceHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemLongClickListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import javax.inject.Inject;

@UriMatchPatterns(fragment = ContentFragmentType.GROUPS_GRID_FRAGMENT)
/* compiled from: account_setting_open */
public class FB4AGroupGridFragment extends AbstractGroupsPogGridFragment {
    public static final String au = FB4AGroupGridFragment.class.getName();
    @Inject
    SecureContextHelper am;
    @Inject
    GroupsRecyclerViewSectionedGridAdapterProvider an;
    @Inject
    public SectionedGroupsQueryManager ao;
    @Inject
    FB4AGroupsPogGridViewFactory ap;
    @Inject
    Lazy<FbErrorReporter> aq;
    @Inject
    Lazy<GroupEditFavoritesIntentBuilder> ar;
    @Inject
    public GroupLeaveDialogHelper as;
    @Inject
    GroupFavoriteStatusEventBus at;
    private GroupFavoriteStatusEventSubscriber av;
    public HashSet<EventType> aw = new HashSet();

    /* compiled from: account_setting_open */
    public final class AnonymousClass10 {
        final /* synthetic */ Adapter f10145a;
        final /* synthetic */ int f10146b;

        AnonymousClass10(Adapter adapter, int i) {
            this.f10145a = adapter;
            this.f10146b = i;
        }

        public final void m10491a() {
            this.f10145a.j_(this.f10146b);
        }
    }

    /* compiled from: account_setting_open */
    class C11851 extends GroupFavoriteStatusEventSubscriber {
        final /* synthetic */ FB4AGroupGridFragment f10147a;

        C11851(FB4AGroupGridFragment fB4AGroupGridFragment) {
            this.f10147a = fB4AGroupGridFragment;
        }

        public final /* synthetic */ void mo261b(FbEvent fbEvent) {
            mo260a((GroupFavoriteStatusEvent) fbEvent);
        }

        public final void mo260a(GroupFavoriteStatusEvent groupFavoriteStatusEvent) {
            if (!this.f10147a.aw.contains(groupFavoriteStatusEvent.f10108a)) {
                this.f10147a.aw.add(groupFavoriteStatusEvent.f10108a);
            }
        }
    }

    /* compiled from: account_setting_open */
    class C11862 implements OnItemClickListener {
        final /* synthetic */ FB4AGroupGridFragment f10148a;

        C11862(FB4AGroupGridFragment fB4AGroupGridFragment) {
            this.f10148a = fB4AGroupGridFragment;
        }

        public final void m10494a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter = (GroupsRecyclerViewSectionedGridAdapter) betterRecyclerView.o;
            if (!groupsRecyclerViewSectionedGridAdapter.m10754f(i)) {
                GroupPogGridData e = groupsRecyclerViewSectionedGridAdapter.m10752e(i);
                Intent intent = new Intent();
                intent.setData(Uri.parse(StringFormatUtil.a(FBLinks.u, new Object[]{e.f10223a})));
                this.f10148a.am.a(intent, view.getContext());
                ((SectionGraphQLQueryManager) this.f10148a.ao).m10661a(e.f10223a, FB4AGroupGridFragment.m10511b(groupsRecyclerViewSectionedGridAdapter, i));
            }
        }
    }

    /* compiled from: account_setting_open */
    class C11873 implements OnItemLongClickListener {
        final /* synthetic */ FB4AGroupGridFragment f10149a;

        C11873(FB4AGroupGridFragment fB4AGroupGridFragment) {
            this.f10149a = fB4AGroupGridFragment;
        }

        public final boolean m10495a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter = (GroupsRecyclerViewSectionedGridAdapter) betterRecyclerView.o;
            if (groupsRecyclerViewSectionedGridAdapter.m10754f(i)) {
                return false;
            }
            GroupPogGridData e = groupsRecyclerViewSectionedGridAdapter.m10752e(i);
            if (e == null || !(e instanceof GroupPogGridData)) {
                ((AbstractFbErrorReporter) this.f10149a.aq.get()).b(FB4AGroupGridFragment.au, "Tried to open group options without a model");
                return false;
            }
            FB4AGroupGridFragment.m10509a(this.f10149a, e, betterRecyclerView, FB4AGroupGridFragment.m10511b(groupsRecyclerViewSectionedGridAdapter, i));
            return true;
        }
    }

    public static void m10510a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4AGroupGridFragment) obj).m10508a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (GroupsRecyclerViewSectionedGridAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsRecyclerViewSectionedGridAdapterProvider.class), SectionGraphQLQueryManager.m10646b(fbInjector), new FB4AGroupsPogGridViewFactory(), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedLazy.a(fbInjector, 6899), GroupLeaveDialogHelper.b(fbInjector), GroupFavoriteStatusEventBus.m10456a(fbInjector));
    }

    public final void mo270c(Bundle bundle) {
        super.mo270c(bundle);
        Class cls = FB4AGroupGridFragment.class;
        m10510a((Object) this, getContext());
        this.av = new C11851(this);
        this.ao.mo282a(ImmutableList.of(GroupSections.FAVORITES_SECTION, GroupSections.RECENTLY_JOINED_SECTION, GroupSections.FILTERED_GROUPS_SECTION, GroupSections.HIDDEN_GROUPS_SECTION));
    }

    public final void m10513I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1993719975);
        this.aw = null;
        this.ao.mo276a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1449041247, a);
    }

    public final void mo264a(View view, Bundle bundle) {
        super.mo264a(view, bundle);
        au();
        ViewGroup viewGroup = (ViewGroup) view;
        LayoutInflater from = LayoutInflater.from(getContext());
        FB4AGroupsPogGridViewFactory fB4AGroupsPogGridViewFactory = this.ap;
        from.inflate(2130904741, viewGroup, true);
        FB4AGroupsPogGridViewFactory fB4AGroupsPogGridViewFactory2 = this.ap;
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) e(2131562816);
        betterRecyclerView.v = true;
        GroupsRecyclerViewSectionedGridAdapter a = mo263a(this.f10180i, this.at);
        this.ao = a;
        betterRecyclerView.setOnItemClickListener(mo271e());
        betterRecyclerView.setOnItemLongClickListener(aq());
        if (ar() != null) {
            betterRecyclerView.a(ar());
        }
        this.f10178g = betterRecyclerView;
        betterRecyclerView.setLayoutManager(AbstractGroupsPogGridFragment.az(this));
        betterRecyclerView.setAdapter(a);
        betterRecyclerView.setPadding(this.f10180i.f10359d, betterRecyclerView.getPaddingTop(), this.f10180i.f10359d, betterRecyclerView.getPaddingBottom());
        betterRecyclerView.setOnScrollListener(new C12213(this));
        ax();
        this.h = LoadingState.LOADING;
        m10504b(this.f10179h);
        this.at.a(this.av);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1671267324);
        super.mi_();
        if (!this.s.getBoolean("doNotSetTitleBar")) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.y_(2131242512);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2026752694, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -565181087);
        this.at.b(this.av);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -516512471, a);
    }

    public final void mo262G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 216447314);
        super.mo262G();
        if (this.aw != null) {
            if (this.aw.contains(EventType.STATUS_CHANGE)) {
                ((SectionGraphQLQueryManager) this.ao).m10663b();
            } else if (this.aw.contains(EventType.REORDER)) {
                ((SectionGraphQLQueryManager) this.ao).m10657a(GroupSections.FAVORITES_SECTION, aw());
            }
            this.aw.clear();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 746644628, a);
    }

    protected final OnItemClickListener mo271e() {
        return new C11862(this);
    }

    protected final OnItemLongClickListener aq() {
        return new C11873(this);
    }

    public static void m10509a(FB4AGroupGridFragment fB4AGroupGridFragment, final GroupPogGridData groupPogGridData, final BetterRecyclerView betterRecyclerView, final AnonymousClass10 anonymousClass10) {
        int i;
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(betterRecyclerView.getContext());
        PopoverMenu c = popoverMenuWindow.c();
        if (groupPogGridData.f10229g) {
            i = 2131242527;
        } else {
            i = 2131242525;
        }
        c.a(i).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupGridFragment) {
            final /* synthetic */ FB4AGroupGridFragment f10151b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                SectionedGroupsQueryManager sectionedGroupsQueryManager = this.f10151b.ao;
                String str = groupPogGridData.f10223a;
                if (groupPogGridData.f10229g) {
                    z = false;
                } else {
                    z = true;
                }
                sectionedGroupsQueryManager.mo283a(str, z, groupPogGridData.f10230h);
                return true;
            }
        });
        if (groupPogGridData.f10229g) {
            c.a(2131242526).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupGridFragment) {
                final /* synthetic */ FB4AGroupGridFragment f10153b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f10153b.am.a(((GroupEditFavoritesIntentBuilder) this.f10153b.ar.get()).m10474a(), betterRecyclerView.getContext());
                    return true;
                }
            });
        }
        final GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel = groupPogGridData.f10233k;
        if (!(graphQLGroupSubscriptionLevel == GraphQLGroupSubscriptionLevel.OFF || graphQLGroupSubscriptionLevel == GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || groupPogGridData.f10230h)) {
            c.a(2131242528).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupGridFragment) {
                final /* synthetic */ FB4AGroupGridFragment f10157d;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ((SectionGraphQLQueryManager) this.f10157d.ao).m10660a(groupPogGridData.f10223a, graphQLGroupSubscriptionLevel, anonymousClass10);
                    return true;
                }
            });
        }
        if (!groupPogGridData.f10230h || groupPogGridData.f10229g) {
            i = 2131242529;
        } else {
            i = 2131242530;
        }
        c.a(i).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupGridFragment) {
            final /* synthetic */ FB4AGroupGridFragment f10159b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                SectionGraphQLQueryManager sectionGraphQLQueryManager = (SectionGraphQLQueryManager) this.f10159b.ao;
                String str = groupPogGridData.f10223a;
                if (!groupPogGridData.f10230h || groupPogGridData.f10229g) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = groupPogGridData.f10229g;
                sectionGraphQLQueryManager.f10275g = GroupSectionsOptimisiticMutationsHelper.m10618a(sectionGraphQLQueryManager.f10275g, str, z ? false : z2, z);
                SectionGraphQLQueryManager.m10651g(sectionGraphQLQueryManager);
                String str2 = GraphQLTasks.EDIT_HIDDEN + str;
                TasksManager tasksManager;
                GroupHiddenStatusUpdater groupHiddenStatusUpdater;
                GraphQlCallInput graphQlCallInput;
                GraphQlQueryString groupHideMutationString;
                if (z) {
                    tasksManager = sectionGraphQLQueryManager.f10281m;
                    groupHiddenStatusUpdater = (GroupHiddenStatusUpdater) sectionGraphQLQueryManager.f10286r.get();
                    GroupHideInputData groupHideInputData = new GroupHideInputData();
                    groupHideInputData.a("actor_id", (String) groupHiddenStatusUpdater.a.get());
                    graphQlCallInput = groupHideInputData;
                    graphQlCallInput.a("group_id", str);
                    graphQlCallInput.a("client_mutation_id", SafeUUIDGenerator.a().toString());
                    groupHideMutationString = new GroupHideMutationString();
                    groupHideMutationString.a("input", groupHideInputData);
                    tasksManager.a(str2, groupHiddenStatusUpdater.b.a(GraphQLRequest.a(groupHideMutationString)), new C12046(sectionGraphQLQueryManager, str, z2, z));
                } else {
                    tasksManager = sectionGraphQLQueryManager.f10281m;
                    groupHiddenStatusUpdater = (GroupHiddenStatusUpdater) sectionGraphQLQueryManager.f10286r.get();
                    GroupUnhideInputData groupUnhideInputData = new GroupUnhideInputData();
                    groupUnhideInputData.a("actor_id", (String) groupHiddenStatusUpdater.a.get());
                    graphQlCallInput = groupUnhideInputData;
                    graphQlCallInput.a("group_id", str);
                    graphQlCallInput.a("client_mutation_id", SafeUUIDGenerator.a().toString());
                    groupHideMutationString = new GroupUnhideMutationString();
                    groupHideMutationString.a("input", groupUnhideInputData);
                    tasksManager.a(str2, groupHiddenStatusUpdater.b.a(GraphQLRequest.a(groupHideMutationString)), new C12057(sectionGraphQLQueryManager, str, z2, z));
                }
                return true;
            }
        });
        final BetterRecyclerView betterRecyclerView2 = betterRecyclerView;
        final GroupPogGridData groupPogGridData2 = groupPogGridData;
        final AnonymousClass10 anonymousClass102 = anonymousClass10;
        c.a(2131242531).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupGridFragment) {
            final /* synthetic */ FB4AGroupGridFragment f10165e;

            /* compiled from: account_setting_open */
            class C11921 implements OnClickListener {
                final /* synthetic */ C11938 f10160a;

                C11921(C11938 c11938) {
                    this.f10160a = c11938;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    ((SectionGraphQLQueryManager) this.f10160a.f10165e.ao).m10660a(groupPogGridData2.f10223a, graphQLGroupSubscriptionLevel, anonymousClass102);
                }
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f10165e.as.a(betterRecyclerView2.getContext(), FB4AGroupGridFragment.m10507a(this.f10165e, betterRecyclerView2.getContext(), groupPogGridData2.f10223a, true), FB4AGroupGridFragment.m10507a(this.f10165e, betterRecyclerView2.getContext(), groupPogGridData2.f10223a, false), new C11921(this), groupPogGridData2.f10234l, groupPogGridData2.f10224b);
                return true;
            }
        });
        popoverMenuWindow.c(2131242524);
        popoverMenuWindow.a(betterRecyclerView);
    }

    protected final GroupsRecyclerViewSectionedGridAdapter mo263a(ResizeValues resizeValues, C12202 c12202) {
        GroupsRecyclerViewSectionedGridAdapterProvider groupsRecyclerViewSectionedGridAdapterProvider = this.an;
        return new GroupsRecyclerViewSectionedGridAdapter(resizeValues, (SecureContextHelper) DefaultSecureContextHelper.a(groupsRecyclerViewSectionedGridAdapterProvider), GroupsPreferenceHelper.a(groupsRecyclerViewSectionedGridAdapterProvider), c12202, GroupEditFavoritesIntentBuilder.m10473b(groupsRecyclerViewSectionedGridAdapterProvider), ResourcesMethodAutoProvider.a(groupsRecyclerViewSectionedGridAdapterProvider));
    }

    protected final OnDrawListener ar() {
        return null;
    }

    protected final SectionedGroupsQueryManager as() {
        return this.ao;
    }

    protected final void mo265a(LoadingState loadingState) {
        m10504b(loadingState);
    }

    protected final FB4AGroupsPogGridViewFactory at() {
        return this.ap;
    }

    public static OnClickListener m10507a(FB4AGroupGridFragment fB4AGroupGridFragment, final Context context, final String str, final boolean z) {
        return new OnClickListener(fB4AGroupGridFragment) {
            public final /* synthetic */ FB4AGroupGridFragment f10171d;

            public void onClick(DialogInterface dialogInterface, int i) {
                GroupLeaveDialogHelper groupLeaveDialogHelper = this.f10171d.as;
                final DialogFragment a = GroupLeaveDialogHelper.a(this.f10171d.kO_(), 2131237882);
                SectionGraphQLQueryManager sectionGraphQLQueryManager = (SectionGraphQLQueryManager) this.f10171d.ao;
                String str = str;
                sectionGraphQLQueryManager.f10281m.a(GraphQLTasks.LEAVE_GROUP + str, sectionGraphQLQueryManager.f10282n.a(str, Source.MOBILE_GROUPS_DASH, z ? ReaddPolicy.ALLOW_READD : ReaddPolicy.PREVENT_READD), new AnonymousClass11(sectionGraphQLQueryManager, new Object(this) {
                    public final /* synthetic */ C11959 f10167b;
                }, str));
            }
        };
    }

    private void m10508a(SecureContextHelper secureContextHelper, GroupsRecyclerViewSectionedGridAdapterProvider groupsRecyclerViewSectionedGridAdapterProvider, SectionedGroupsQueryManager sectionedGroupsQueryManager, FB4AGroupsPogGridViewFactory fB4AGroupsPogGridViewFactory, Lazy<FbErrorReporter> lazy, Lazy<GroupEditFavoritesIntentBuilder> lazy2, GroupLeaveDialogHelper groupLeaveDialogHelper, GroupFavoriteStatusEventBus groupFavoriteStatusEventBus) {
        this.am = secureContextHelper;
        this.an = groupsRecyclerViewSectionedGridAdapterProvider;
        this.ao = sectionedGroupsQueryManager;
        this.ap = fB4AGroupsPogGridViewFactory;
        this.aq = lazy;
        this.ar = lazy2;
        this.as = groupLeaveDialogHelper;
        this.at = groupFavoriteStatusEventBus;
    }

    public static AnonymousClass10 m10511b(Adapter adapter, int i) {
        return new AnonymousClass10(adapter, i);
    }
}
