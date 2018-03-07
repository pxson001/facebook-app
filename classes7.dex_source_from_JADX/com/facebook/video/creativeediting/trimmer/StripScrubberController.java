package com.facebook.video.creativeediting.trimmer;

import android.os.Handler;
import android.view.View;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentController;
import com.facebook.video.creativeediting.VideoTrimmingController;
import com.facebook.video.creativeediting.VideoTrimmingController.C11836;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverter;

/* compiled from: drawer_state */
public class StripScrubberController {
    public Runnable f15563a;
    public Handler f15564b = new Handler();
    public View f15565c;
    public final C11836 f15566d;
    public final StripViewVideoTimeConverter f15567e;
    public final VideoEditGalleryFragmentController f15568f;
    public final StripHandleController f15569g;

    /* compiled from: drawer_state */
    public class C11881 implements Runnable {
        final /* synthetic */ int f15561a;
        final /* synthetic */ StripScrubberController f15562b;

        public C11881(StripScrubberController stripScrubberController, int i) {
            this.f15562b = stripScrubberController;
            this.f15561a = i;
        }

        public void run() {
            int currentPositionMs = this.f15562b.f15568f.f15419f.as().getCurrentPositionMs();
            this.f15562b.f15565c.offsetLeftAndRight(Math.max(this.f15562b.f15567e.m19603a(currentPositionMs), this.f15562b.f15569g.m19553a()) - this.f15562b.m19565e());
            if (this.f15562b.f15568f.m19476j() || currentPositionMs >= this.f15562b.f15567e.m19604a(this.f15562b.f15569g.m19557b(), false)) {
                C11836 c11836 = this.f15562b.f15566d;
                VideoTrimmingController videoTrimmingController = c11836.f15485a;
                videoTrimmingController.f15521r.m19563c();
                videoTrimmingController.f15505b.m19475h();
                if (c11836.f15485a.f15512i) {
                    VideoTrimmingController.m19527u(c11836.f15485a);
                    return;
                }
                return;
            }
            HandlerDetour.b(this.f15562b.f15564b, this.f15562b.f15563a, (long) this.f15561a, -486581735);
        }
    }

    public StripScrubberController(C11836 c11836, StripViewVideoTimeConverter stripViewVideoTimeConverter, VideoEditGalleryFragmentController videoEditGalleryFragmentController, StripHandleController stripHandleController) {
        this.f15566d = c11836;
        this.f15567e = stripViewVideoTimeConverter;
        this.f15568f = videoEditGalleryFragmentController;
        this.f15569g = stripHandleController;
    }

    public final void m19562b() {
        HandlerDetour.a(this.f15564b, this.f15563a, -357575962);
    }

    public final void m19563c() {
        HandlerDetour.a(this.f15564b, this.f15563a);
        if (this.f15565c != null) {
            this.f15565c.setVisibility(4);
        }
    }

    public final void m19564d() {
        if (this.f15565c != null) {
            this.f15565c.setVisibility(0);
        }
    }

    public final int m19565e() {
        return this.f15565c.getLeft() + (this.f15565c.getWidth() / 2);
    }

    public final void m19561a(int i) {
        if (this.f15565c != null) {
            m19563c();
            this.f15565c.setVisibility(0);
            if (this.f15566d != null) {
                C11836 c11836 = this.f15566d;
                int a = this.f15567e.m19604a(i, false);
                VideoEditGalleryFragmentController videoEditGalleryFragmentController = c11836.f15485a.f15505b;
                videoEditGalleryFragmentController.f15419f.as().m19501d();
                videoEditGalleryFragmentController.f15419f.as().m19497a(a);
            }
            this.f15565c.offsetLeftAndRight(i - m19565e());
        }
    }
}
