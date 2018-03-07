package com.facebook.feed.fragment.controllercallbacks;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.framerateprogressbar.FrameRateProgressBarXConfigReader;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_link_share_upload */
public class ProgressBarExperimentsController extends BaseController implements ViewCreatedDestroyedCallbacks {
    private final Handler f9655a = new Handler();
    private final NewsFeedXConfigReader f9656b;
    private final FrameRateProgressBarXConfigReader f9657c;
    @Nullable
    private Runnable f9658d;

    public static ProgressBarExperimentsController m14663a(InjectorLike injectorLike) {
        return new ProgressBarExperimentsController(NewsFeedXConfigReader.m8187a(injectorLike), FrameRateProgressBarXConfigReader.m14665a(injectorLike));
    }

    @Inject
    public ProgressBarExperimentsController(NewsFeedXConfigReader newsFeedXConfigReader, FrameRateProgressBarXConfigReader frameRateProgressBarXConfigReader) {
        this.f9656b = newsFeedXConfigReader;
        this.f9657c = frameRateProgressBarXConfigReader;
    }

    public final void mo1886a(View view) {
        LayoutInflater from = LayoutInflater.from(view.getContext());
        if (this.f9657c.m14667a() != 60) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131561173);
            linearLayout.removeViewAt(0);
            from.inflate(2130904292, linearLayout);
        }
        final View findViewById = view.findViewById(2131561174);
        NewsFeedXConfigReader newsFeedXConfigReader = this.f9656b;
        if (newsFeedXConfigReader.f4504n == -1) {
            newsFeedXConfigReader.f4504n = newsFeedXConfigReader.f4491a.m2683a(NewsFeedXConfig.f5014t, 3000);
        }
        int i = newsFeedXConfigReader.f4504n;
        if (i > 0) {
            findViewById.setVisibility(8);
            this.f9658d = new Runnable(this) {
                final /* synthetic */ ProgressBarExperimentsController f19740b;

                public void run() {
                    findViewById.setVisibility(0);
                }
            };
            HandlerDetour.b(this.f9655a, this.f9658d, (long) i, -148574039);
        }
    }

    public final void kG_() {
        HandlerDetour.a(this.f9655a, this.f9658d);
    }
}
