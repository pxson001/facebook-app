package com.facebook.timeline.header.intro;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.IntroCardAbstractInterstitialController;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: for_sale_profile_type */
public class IntroCardShareToNewsfeedController {
    private final Context f11822a;
    private final IntroCardAbstractInterstitialController f11823b;
    private final FeedSharingSwitchNuxProvider f11824c;
    private final QeAccessor f11825d;
    private final RTLUtil f11826e;
    private CompoundButton f11827f;
    private Tooltip f11828g;
    private boolean f11829h;

    /* compiled from: for_sale_profile_type */
    public interface FeedSharingSwitchNuxProvider {
        Tooltip mo543b();
    }

    @Inject
    public IntroCardShareToNewsfeedController(@Assisted Context context, @Assisted IntroCardAbstractInterstitialController introCardAbstractInterstitialController, @Assisted FeedSharingSwitchNuxProvider feedSharingSwitchNuxProvider, QeAccessor qeAccessor, RTLUtil rTLUtil) {
        this.f11822a = context;
        this.f11823b = introCardAbstractInterstitialController;
        this.f11824c = feedSharingSwitchNuxProvider;
        this.f11825d = qeAccessor;
        this.f11826e = rTLUtil;
    }

    public final void m11886a(Bundle bundle, Bundle bundle2, View view) {
        boolean z;
        IntroCardShareToNewsfeedController introCardShareToNewsfeedController;
        int i = 0;
        if (bundle != null) {
            z = bundle.getBoolean("is_feed_sharing_switch_checked");
            introCardShareToNewsfeedController = this;
        } else if (bundle2 == null || !bundle2.getBoolean("initial_is_feed_sharing_switch_checked")) {
            z = false;
            introCardShareToNewsfeedController = this;
        } else {
            z = true;
            introCardShareToNewsfeedController = this;
        }
        introCardShareToNewsfeedController.f11829h = z;
        if (bundle2 == null || !bundle2.containsKey("show_feed_sharing_switch_extra")) {
            z = false;
        } else {
            z = bundle2.getBoolean("show_feed_sharing_switch_extra");
        }
        View a = m11882a(view);
        if (!z) {
            i = 8;
        }
        a.setVisibility(i);
        ((FbTextView) a.findViewById(2131563272)).setText(2131235041);
        this.f11827f = (CompoundButton) a.findViewById(2131563273);
    }

    public final void m11885a(Bundle bundle) {
        bundle.putBoolean("is_feed_sharing_switch_checked", this.f11827f.isChecked());
    }

    public final void m11884a() {
        this.f11827f.setEnabled(true);
        this.f11827f.setChecked(this.f11829h);
    }

    public final boolean m11887b() {
        return this.f11827f.isChecked();
    }

    public final void m11888c() {
        if (this.f11823b.mo533e()) {
            if (this.f11828g == null) {
                this.f11828g = this.f11824c.mo543b();
            }
            if (!this.f11828g.r) {
                int dimensionPixelSize;
                this.f11823b.m11366f();
                this.f11823b.m11367g();
                int dimensionPixelSize2 = m11883d() ? this.f11822a.getResources().getDimensionPixelSize(2131429944) : 0;
                if (m11883d()) {
                    dimensionPixelSize = this.f11822a.getResources().getDimensionPixelSize(2131429945);
                } else {
                    dimensionPixelSize = 0;
                }
                this.f11828g.a(this.f11827f, dimensionPixelSize2 * (this.f11826e.a() ? -1 : 1), dimensionPixelSize, 0, 0);
                this.f11828g.d();
            }
        }
    }

    private View m11882a(View view) {
        LazyView lazyView = new LazyView((ViewStub) view.findViewById(2131567910));
        lazyView.a(m11883d() ? 2130904967 : 2130904966);
        return lazyView.a();
    }

    private boolean m11883d() {
        return this.f11825d.a(ExperimentsForTimelineAbTestModule.an, false);
    }
}
