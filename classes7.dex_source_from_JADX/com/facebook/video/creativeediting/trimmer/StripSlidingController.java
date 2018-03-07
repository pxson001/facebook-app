package com.facebook.video.creativeediting.trimmer;

import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.creativeediting.VideoTrimmingController;
import com.facebook.video.creativeediting.VideoTrimmingController.C11847;
import com.facebook.video.creativeediting.trimmer.StripHandleController.HandlePosition;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverter;
import com.facebook.video.creativeediting.utilities.TrimmedVideoLengthChecker;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: drainAndFeed */
public class StripSlidingController {
    public final Executor f15574a;
    public final StripHandleController f15575b;
    public final StripViewVideoTimeConverter f15576c;
    public final TrimmedVideoLengthChecker f15577d;
    public final C11847 f15578e;
    public ZoomableDraweeStripView f15579f;
    private Timer f15580g;
    public boolean f15581h;

    /* compiled from: drainAndFeed */
    public enum SlidingDirection {
        LEFT,
        RIGHT
    }

    @Inject
    public StripSlidingController(Executor executor, @Assisted StripViewVideoTimeConverter stripViewVideoTimeConverter, @Assisted StripHandleController stripHandleController, @Assisted TrimmedVideoLengthChecker trimmedVideoLengthChecker, @Assisted C11847 c11847) {
        this.f15574a = executor;
        this.f15575b = stripHandleController;
        this.f15576c = stripViewVideoTimeConverter;
        this.f15577d = trimmedVideoLengthChecker;
        this.f15578e = c11847;
    }

    public final void m19566a(final SlidingDirection slidingDirection, final HandlePosition handlePosition) {
        m19567b();
        this.f15580g = new Timer();
        this.f15581h = true;
        this.f15580g.scheduleAtFixedRate(new TimerTask(this) {
            final /* synthetic */ StripSlidingController f15573c;

            /* compiled from: drainAndFeed */
            class C11891 implements Runnable {
                final /* synthetic */ C11901 f15570a;

                C11891(C11901 c11901) {
                    this.f15570a = c11901;
                }

                public void run() {
                    if (this.f15570a.f15573c.f15581h && this.f15570a.f15573c.f15577d.m19607a(this.f15570a.f15573c.f15576c.m19605a(true, this.f15570a.f15573c.f15575b.m19553a(), this.f15570a.f15573c.f15575b.m19557b()))) {
                        StripSlidingController stripSlidingController = this.f15570a.f15573c;
                        SlidingDirection slidingDirection = slidingDirection;
                        HandlePosition handlePosition = handlePosition;
                        C11847 c11847;
                        if (slidingDirection == SlidingDirection.LEFT) {
                            if (stripSlidingController.f15579f.m19599a(10)) {
                                if (handlePosition == HandlePosition.LEFT) {
                                    stripSlidingController.f15575b.m19558b(10);
                                } else {
                                    stripSlidingController.f15575b.m19555a(10);
                                }
                                c11847 = stripSlidingController.f15578e;
                                c11847.f15486a.f15521r.m19563c();
                                if (handlePosition != HandlePosition.LEFT) {
                                    VideoTrimmingController.m19518a(c11847.f15486a, c11847.f15486a.f15520q.m19553a(), true);
                                    if (c11847.f15486a.f15497J != null) {
                                        c11847.f15486a.f15497J.b(VideoTrimmingController.m19530z(c11847.f15486a));
                                    }
                                } else {
                                    VideoTrimmingController.m19519b(c11847.f15486a, c11847.f15486a.f15520q.m19557b(), true);
                                    if (c11847.f15486a.f15498K != null) {
                                        c11847.f15486a.f15498K.b(VideoTrimmingController.m19530z(c11847.f15486a));
                                    }
                                }
                            }
                        } else if (stripSlidingController.f15579f.m19601b(10)) {
                            if (handlePosition == HandlePosition.LEFT) {
                                stripSlidingController.f15575b.m19558b(-10);
                            } else {
                                stripSlidingController.f15575b.m19555a(-10);
                            }
                            c11847 = stripSlidingController.f15578e;
                            c11847.f15486a.f15521r.m19563c();
                            if (handlePosition != HandlePosition.LEFT) {
                                VideoTrimmingController.m19519b(c11847.f15486a, c11847.f15486a.f15520q.m19557b(), true);
                                if (c11847.f15486a.f15498K != null) {
                                    c11847.f15486a.f15498K.b(VideoTrimmingController.m19530z(c11847.f15486a));
                                }
                            } else {
                                VideoTrimmingController.m19518a(c11847.f15486a, c11847.f15486a.f15520q.m19553a(), true);
                                if (c11847.f15486a.f15497J != null) {
                                    c11847.f15486a.f15497J.b(VideoTrimmingController.m19530z(c11847.f15486a));
                                }
                            }
                        }
                    }
                }
            }

            public void run() {
                ExecutorDetour.a(this.f15573c.f15574a, new C11891(this), 1654608189);
            }
        }, 0, 20);
    }

    public final void m19567b() {
        if (this.f15580g != null) {
            this.f15580g.cancel();
        }
    }
}
