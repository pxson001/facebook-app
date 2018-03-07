package com.facebook.pages.launchpoint.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.launchpoint.adapters.PagesLaunchpointFragmentPagerAdapter;
import com.facebook.pages.launchpoint.adapters.PagesLaunchpointFragmentPagerAdapterProvider;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPymlSeeMoreEventSubscriber;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.viewpager.ViewPagerWithCompositeOnPageChangeListener;
import javax.inject.Inject;

/* compiled from: page_data */
public class PagesLaunchpointFragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed {
    @Inject
    public FbTitleBarSupplier f4336a;
    @Inject
    public PagesLaunchpointFragmentPagerAdapterProvider f4337b;
    @Inject
    public ReactionEventBus f4338c;
    private FbTitleBar f4339d;
    public ViewPagerWithCompositeOnPageChangeListener f4340e;
    private boolean f4341f = false;
    private final ReactionPymlSeeMoreEventSubscriber f4342g = new C06071(this);

    /* compiled from: page_data */
    class C06071 extends ReactionPymlSeeMoreEventSubscriber {
        final /* synthetic */ PagesLaunchpointFragment f4335a;

        C06071(PagesLaunchpointFragment pagesLaunchpointFragment) {
            this.f4335a = pagesLaunchpointFragment;
        }

        public final void m5279b(FbEvent fbEvent) {
            this.f4335a.f4340e.setCurrentItem(1);
        }
    }

    public static void m5280a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PagesLaunchpointFragment pagesLaunchpointFragment = (PagesLaunchpointFragment) obj;
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector);
        PagesLaunchpointFragmentPagerAdapterProvider pagesLaunchpointFragmentPagerAdapterProvider = (PagesLaunchpointFragmentPagerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PagesLaunchpointFragmentPagerAdapterProvider.class);
        ReactionEventBus a = ReactionEventBus.a(fbInjector);
        pagesLaunchpointFragment.f4336a = fbTitleBarSupplier;
        pagesLaunchpointFragment.f4337b = pagesLaunchpointFragmentPagerAdapterProvider;
        pagesLaunchpointFragment.f4338c = a;
    }

    public final void m5284c(Bundle bundle) {
        super.c(bundle);
        Class cls = PagesLaunchpointFragment.class;
        m5280a((Object) this, getContext());
        if (this.f4336a != null) {
            this.f4339d = (FbTitleBar) this.f4336a.get();
        }
    }

    public final View m5282a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1999050081);
        View inflate = layoutInflater.inflate(2130906115, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1095563035, a);
        return inflate;
    }

    public final void m5283a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f4340e = (ViewPagerWithCompositeOnPageChangeListener) e(2131565718);
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) e(2131565717);
        PagesLaunchpointFragmentPagerAdapterProvider pagesLaunchpointFragmentPagerAdapterProvider = this.f4337b;
        this.f4340e.setAdapter(new PagesLaunchpointFragmentPagerAdapter(String_LoggedInUserIdMethodAutoProvider.b(pagesLaunchpointFragmentPagerAdapterProvider), kO_(), getContext()));
        tabbedViewPagerIndicator.setViewPager(this.f4340e);
        this.f4338c.a(this.f4342g);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1773791525);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239345);
        } else if (this.f4339d != null) {
            this.f4339d.setTitle(2131239345);
        }
        LogUtils.f(-1676668251, a);
    }

    public final void m5281I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1410773845);
        super.I();
        this.f4338c.b(this.f4342g);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1511529748, a);
    }

    public final boolean O_() {
        if (this.f4340e.k == 0) {
            return false;
        }
        this.f4340e.setCurrentItem(0);
        return true;
    }

    public final String am_() {
        return "pages_launchpoint";
    }
}
