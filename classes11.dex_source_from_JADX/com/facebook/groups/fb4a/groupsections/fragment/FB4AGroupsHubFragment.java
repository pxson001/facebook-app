package com.facebook.groups.fb4a.groupsections.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.base.fragment.CanHandleMenuPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubInfoFetcher;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubInfoFetcher.C11971;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubInfoFetcher.C11982;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubInfoFetcher.Tasks;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapter;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapter.GroupsHubTab;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapter.TabType;
import com.facebook.groups.fb4a.groupshub.adapter.FB4AGroupsHubViewPagerAdapterProvider;
import com.facebook.groups.fb4a.groupshub.nux.FB4AGroupsDiscoverToolTipInterstitialController;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.app.module.common.ComponentName_ReactFragmentActivityMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ac30855d4691779afc58ec3929e6d7c0 */
public class FB4AGroupsHubFragment extends FbFragment implements CanHandleMenuPressed {
    @Inject
    FB4AGroupsHubViewPagerAdapterProvider f10182a;
    @Inject
    @ReactFragmentActivity
    ComponentName f10183b;
    @Inject
    SecureContextHelper f10184c;
    @Inject
    public FB4AGroupsHubExperiments f10185d;
    @Inject
    FB4AGroupsHubInfoFetcher f10186e;
    @Inject
    InterstitialManager f10187f;
    private ViewPager f10188g;
    private FB4AGroupsHubViewPagerAdapter f10189h;
    private TabbedViewPagerIndicator f10190i;

    /* compiled from: ac30855d4691779afc58ec3929e6d7c0 */
    public class C11961 implements OnClickListener {
        final /* synthetic */ FB4AGroupsHubFragment f10181a;

        public C11961(FB4AGroupsHubFragment fB4AGroupsHubFragment) {
            this.f10181a = fB4AGroupsHubFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2127809863);
            Intent component = new Intent().setComponent(this.f10181a.f10183b);
            component.putExtra("target_fragment", ContentFragmentType.GROUPS_HUB_SEARCH_FRAGMENT.ordinal());
            this.f10181a.f10184c.a(component, this.f10181a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1723714653, a);
        }
    }

    public static void m10520a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4AGroupsHubFragment) obj).m10519a((FB4AGroupsHubViewPagerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FB4AGroupsHubViewPagerAdapterProvider.class), ComponentName_ReactFragmentActivityMethodAutoProvider.m68b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), FB4AGroupsHubExperiments.a(fbInjector), new FB4AGroupsHubInfoFetcher(TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector)), InterstitialManager.a(fbInjector));
    }

    public final void m10525c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FB4AGroupsHubFragment.class;
        m10520a((Object) this, getContext());
    }

    public final View m10521a(LayoutInflater layoutInflater, @android.support.annotation.Nullable ViewGroup viewGroup, @android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1240424849);
        View inflate = layoutInflater.inflate(2130904721, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1633182647, a);
        return inflate;
    }

    public final void m10523a(View view, @android.support.annotation.Nullable Bundle bundle) {
        this.f10188g = (ViewPager) e(2131562782);
        FB4AGroupsHubViewPagerAdapterProvider fB4AGroupsHubViewPagerAdapterProvider = this.f10182a;
        this.f10189h = new FB4AGroupsHubViewPagerAdapter(o().getIntent(), s(), ResourcesMethodAutoProvider.a(fB4AGroupsHubViewPagerAdapterProvider), FB4AGroupsHubExperiments.a(fB4AGroupsHubViewPagerAdapterProvider));
        this.f10188g.setAdapter(this.f10189h);
        this.f10190i = (TabbedViewPagerIndicator) e(2131562781);
        this.f10190i.setViewPager(this.f10188g);
        if (this.s != null) {
            if ("groups_hub_discover".equals(this.s.getString("groups_hub_tab"))) {
                this.f10188g.setCurrentItem(this.f10189h.m10544a(TabType.DISCOVER));
            } else if ("gysc".equals(this.s.getString("extra_navigation_source"))) {
                this.f10188g.setCurrentItem(this.f10189h.m10544a(TabType.CREATE));
            }
        }
        if (this.f10185d.f()) {
            FB4AGroupsHubInfoFetcher fB4AGroupsHubInfoFetcher = this.f10186e;
            FB4AGroupsHubViewPagerAdapter fB4AGroupsHubViewPagerAdapter = this.f10189h;
            TabbedViewPagerIndicator tabbedViewPagerIndicator = this.f10190i;
            if (!fB4AGroupsHubInfoFetcher.f10195a.a(Tasks.ADMINED_GROUPS_QUERY)) {
                fB4AGroupsHubInfoFetcher.f10195a.a(Tasks.ADMINED_GROUPS_QUERY, new C11971(fB4AGroupsHubInfoFetcher), new C11982(fB4AGroupsHubInfoFetcher, fB4AGroupsHubViewPagerAdapter, tabbedViewPagerIndicator));
            }
        }
        FB4AGroupsDiscoverToolTipInterstitialController fB4AGroupsDiscoverToolTipInterstitialController = (FB4AGroupsDiscoverToolTipInterstitialController) this.f10187f.a(new InterstitialTrigger(Action.GROUPS_DISCOVER_TAB_TOOL_TIP), FB4AGroupsDiscoverToolTipInterstitialController.class);
        if (fB4AGroupsDiscoverToolTipInterstitialController != null && this.f10185d.b() && this.f10188g.k != this.f10189h.m10544a(TabType.DISCOVER)) {
            View d = this.f10190i.d(this.f10189h.m10544a(TabType.DISCOVER));
            if (d != null) {
                Tooltip tooltip = new Tooltip(d.getContext(), 2);
                tooltip.b(fB4AGroupsDiscoverToolTipInterstitialController.f10208b.a(2130839808, -1));
                tooltip.a(2131242505);
                tooltip.b(2131242506);
                tooltip.f(d);
            }
            this.f10187f.a().a(fB4AGroupsDiscoverToolTipInterstitialController.m10554b());
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2115657693);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131242504);
            if (this.f10185d.b()) {
                GraphSearchTitleSearchBox graphSearchTitleSearchBox = new GraphSearchTitleSearchBox(getContext());
                graphSearchTitleSearchBox.e.setHint(2131242503);
                graphSearchTitleSearchBox.e.setFocusable(false);
                graphSearchTitleSearchBox.a(new C11961(this));
                hasTitleBar.setCustomTitle(graphSearchTitleSearchBox);
                hasTitleBar.c(true);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1088493180, a);
    }

    public final void m10522a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (this.f10189h != null) {
            for (int i3 = 0; i3 < this.f10189h.b(); i3++) {
                Fragment e = this.f10189h.e(i3);
                if (e != null) {
                    e.a(i, i2, intent);
                }
            }
        }
    }

    public final boolean m10524a() {
        int i = this.f10188g.k;
        if (((GroupsHubTab) this.f10189h.f10202b.get(i)).mo273b()) {
            Fragment e = this.f10189h.e(i);
            if (e != null && (e instanceof CanHandleMenuPressed) && ((CanHandleMenuPressed) e).a()) {
                return true;
            }
        }
        return false;
    }

    private void m10519a(FB4AGroupsHubViewPagerAdapterProvider fB4AGroupsHubViewPagerAdapterProvider, ComponentName componentName, SecureContextHelper secureContextHelper, FB4AGroupsHubExperiments fB4AGroupsHubExperiments, FB4AGroupsHubInfoFetcher fB4AGroupsHubInfoFetcher, InterstitialManager interstitialManager) {
        this.f10182a = fB4AGroupsHubViewPagerAdapterProvider;
        this.f10183b = componentName;
        this.f10184c = secureContextHelper;
        this.f10185d = fB4AGroupsHubExperiments;
        this.f10186e = fB4AGroupsHubInfoFetcher;
        this.f10187f = interstitialManager;
    }
}
