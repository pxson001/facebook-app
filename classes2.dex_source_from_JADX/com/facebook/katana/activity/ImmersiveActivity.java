package com.facebook.katana.activity;

import com.facebook.analytics.ManualAnalyticsNavigationActivity;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.base.fragment.FbFragment;
import com.facebook.chrome.FbChromeDelegatingActivity;
import com.facebook.common.componentmap.ComponentMapConfig;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.sideshow.TypedSideshowFragmentContainer;
import com.facebook.widget.recycle.ViewPoolCleaner;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ComponentMapConfig
/* compiled from: n */
public class ImmersiveActivity extends FbChromeDelegatingActivity implements ManualAnalyticsNavigationActivity, ContentFragmentContainer, TypedSideshowFragmentContainer, ViewPoolCleaner {
    @Inject
    public ImmersiveActivity() {
        super(new ImmersiveActivityDelegate());
    }

    public final void mo793e() {
        ((ImmersiveActivityDelegate) this.f13063p).e();
    }

    public String toString() {
        return this.f13063p.toString();
    }

    @Nullable
    public final FbFragment mo783a() {
        return ((ImmersiveActivityDelegate) this.f13063p).a();
    }

    @Nullable
    public final FragmentConstants$ContentFragmentType mo814q() {
        return ((ImmersiveActivityDelegate) this.f13063p).q();
    }

    @Nullable
    public final ColumnWidthConfig mo815s() {
        return ((ImmersiveActivityDelegate) this.f13063p).s();
    }
}
