package com.facebook.photos.creativecam.ui;

import android.text.format.DateUtils;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.13;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import javax.inject.Inject;

/* compiled from: spherical_playable_url_sd_string */
public class ProgressBarController {
    public final 13 f2278a;
    public final FbTextView f2279b;
    public final MonotonicClock f2280c;
    public final ProgressBar f2281d;
    public final ViewGroup f2282e;
    public long f2283f;
    public ChoreographerWrapper f2284g;
    public final FrameCallbackWrapper f2285h = new C02741(this);

    /* compiled from: spherical_playable_url_sd_string */
    class C02741 extends FrameCallbackWrapper {
        final /* synthetic */ ProgressBarController f2277a;

        C02741(ProgressBarController progressBarController) {
            this.f2277a = progressBarController;
        }

        public final void m2411a(long j) {
            int now = (int) (this.f2277a.f2280c.now() - this.f2277a.f2283f);
            int max = this.f2277a.f2281d.getMax();
            if (max <= 0 || now < max) {
                this.f2277a.f2279b.setText(DateUtils.formatElapsedTime(((long) now) / 1000));
                ProgressBar progressBar = this.f2277a.f2281d;
                if (max <= 0) {
                    now = 0;
                }
                progressBar.setProgress(now);
                this.f2277a.f2284g.a(this.f2277a.f2285h);
                return;
            }
            this.f2277a.f2278a.a.az.m2356j();
        }
    }

    @Inject
    public ProgressBarController(@Assisted 13 13, @Assisted ProgressBar progressBar, @Assisted FbTextView fbTextView, @Assisted ViewGroup viewGroup, ChoreographerWrapper choreographerWrapper, MonotonicClock monotonicClock) {
        this.f2278a = 13;
        this.f2281d = progressBar;
        this.f2279b = fbTextView;
        this.f2282e = viewGroup;
        this.f2284g = choreographerWrapper;
        this.f2280c = monotonicClock;
    }

    public final void m2412a(boolean z) {
        this.f2281d.setVisibility(4);
        this.f2279b.setVisibility(4);
        this.f2284g.b(this.f2285h);
        if (!z) {
            this.f2282e.setVisibility(0);
        }
    }
}
