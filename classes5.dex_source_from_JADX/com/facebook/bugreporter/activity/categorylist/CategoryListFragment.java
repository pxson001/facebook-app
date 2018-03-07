package com.facebook.bugreporter.activity.categorylist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.facebook.actionbar.AppCompatFragmentOverrider;
import com.facebook.actionbar.FragmentActionBarHost;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.bugreporter.ConstBugReporterConfig;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.common.locale.LocaleModule;
import com.facebook.common.util.TriState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet$Builder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.media.metadata.ARTIST */
public class CategoryListFragment extends FbFragment implements NavigableFragment {
    private static final Class<?> f10703a = CategoryListFragment.class;
    private CategoryInfoComparator al;
    private Provider<AppCompatFragmentOverrider> am;
    private TriState an;
    public CategoryListAdapter f10704b;
    public BugReporterAnalyticsLogger f10705c;
    public Listener f10706d;
    private ListView f10707e;
    private boolean f10708f;
    private AppCompatFragmentOverrider f10709g;
    private FbTitleBar f10710h;
    private ActionBarBasedFbTitleBar f10711i;

    /* compiled from: android.media.metadata.ARTIST */
    class C10321 implements OnItemClickListener {
        final /* synthetic */ CategoryListFragment f10702a;

        C10321(CategoryListFragment categoryListFragment) {
            this.f10702a = categoryListFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            NavigableFragment navigableFragment = this.f10702a;
            navigableFragment.f10705c.m18746a(CoreEvent.BUG_REPORT_DID_SELECT_PRODUCT);
            if (navigableFragment.f10706d != null) {
                Intent intent = new Intent();
                CategoryInfo a = navigableFragment.f10704b.m18727a(i);
                if (a != null) {
                    intent.putExtra("category_id", String.valueOf(a.f10695c));
                }
                navigableFragment.f10706d.mo564a(navigableFragment, intent);
            }
        }
    }

    public static void m18729a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CategoryListFragment) obj).m18728a(FbActionBarUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 4578), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector), new CategoryListAdapter((Context) fbInjector.getInstance(Context.class), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector)), new CategoryInfoComparator(LocaleModule.a(LocaleMethodAutoProvider.b(fbInjector)), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector)), BugReporterAnalyticsLogger.m18744b(fbInjector));
    }

    @Inject
    private void m18728a(FbActionBarUtil fbActionBarUtil, Provider<AppCompatFragmentOverrider> provider, TriState triState, CategoryListAdapter categoryListAdapter, CategoryInfoComparator categoryInfoComparator, BugReporterAnalyticsLogger bugReporterAnalyticsLogger) {
        this.f10704b = categoryListAdapter;
        this.f10705c = bugReporterAnalyticsLogger;
        this.f10708f = fbActionBarUtil.a();
        this.am = provider;
        this.an = triState;
        this.al = categoryInfoComparator;
    }

    public final void m18734c(Bundle bundle) {
        super.c(bundle);
        Class cls = CategoryListFragment.class;
        m18729a((Object) this, getContext());
        if (this.f10708f) {
            this.f10709g = (AppCompatFragmentOverrider) this.am.get();
            this.f10709g.f8012b = new FragmentActionBarHost(this);
            a(this.f10709g);
            this.f10709g.m14165a(8);
        }
    }

    public final View m18730a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 85093292);
        View inflate = layoutInflater.inflate(2130903528, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1753220126, a);
        return inflate;
    }

    public final void m18735d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -849331418);
        super.d(bundle);
        ConstBugReporterConfig constBugReporterConfig = (ConstBugReporterConfig) this.s.getParcelable("reporter_config");
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder(this.al);
        ImmutableList a2 = constBugReporterConfig.mo1120a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            CategoryInfo categoryInfo = (CategoryInfo) a2.get(i);
            if (TriState.YES.equals(this.an) || categoryInfo.f10696d) {
                immutableSortedSet$Builder.m13431d(categoryInfo);
            }
        }
        BaseAdapter baseAdapter = this.f10704b;
        baseAdapter.f10701c = immutableSortedSet$Builder.m13430c().asList();
        AdapterDetour.a(baseAdapter, 2115796802);
        this.f10707e = (ListView) e(16908298);
        this.f10707e.setAdapter(this.f10704b);
        if (this.f10708f) {
            this.f10711i = new ActionBarBasedFbTitleBar(this, this.f10709g.m14170f());
            this.f10710h = this.f10711i;
            e(true);
        } else {
            FbTitleBarUtil.a(this.T);
            this.f10710h = (FbTitleBar) e(2131558563);
        }
        this.f10710h.setTitle(2131235826);
        this.f10707e.setOnItemClickListener(new C10321(this));
        if (this.s.getBoolean("retry", false)) {
            Intent intent = new Intent();
            intent.putExtra("retry", true);
            this.f10706d.mo564a(this, intent);
        }
        LogUtils.f(1897240750, a);
    }

    public final void mo563a(Listener listener) {
        this.f10706d = listener;
    }

    public final void m18732a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (this.f10708f) {
            this.f10711i.a(menu);
        }
    }

    public final void m18731a(Menu menu) {
        super.a(menu);
    }

    public final boolean a_(MenuItem menuItem) {
        boolean a_ = super.a_(menuItem);
        if (a_ || !this.f10708f) {
            return a_;
        }
        return this.f10711i.a(menuItem);
    }
}
