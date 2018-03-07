package com.facebook.video.creativeediting.trimmer;

import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.creativeediting.VideoTrimmingController.C11858;
import com.facebook.video.creativeediting.analytics.TrimmerLoggingParams;
import com.facebook.video.creativeediting.trimmer.StripHandleController.HandlePosition;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.video.creativeediting.utilities.ZoomPositionConverter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: draft_comment_photo_restored */
public class StripZoomingController {
    public final Executor f15585a;
    public final ZoomPositionConverter f15586b;
    public final StripHandleController f15587c;
    public final StripScrubberController f15588d;
    public final C11858 f15589e;
    public ZoomableDraweeStripView f15590f;
    private Timer f15591g = new Timer();
    public boolean f15592h;

    @Inject
    public StripZoomingController(Executor executor, @Assisted ZoomPositionConverter zoomPositionConverter, @Assisted StripHandleController stripHandleController, @Assisted StripScrubberController stripScrubberController, @Assisted C11858 c11858) {
        this.f15585a = executor;
        this.f15586b = zoomPositionConverter;
        this.f15587c = stripHandleController;
        this.f15588d = stripScrubberController;
        this.f15589e = c11858;
    }

    public final void m19569a(int i, HandlePosition handlePosition) {
        if (this.f15592h) {
            this.f15592h = false;
            int a = this.f15586b.m19615a(i);
            if (handlePosition == HandlePosition.LEFT) {
                this.f15587c.m19556a(a, false);
                this.f15587c.m19559b(this.f15586b.m19615a(this.f15587c.m19557b()), false);
            } else {
                this.f15587c.m19559b(a, false);
                this.f15587c.m19556a(this.f15586b.m19615a(this.f15587c.m19553a()), false);
            }
            this.f15590f.m19596a((float) a);
            this.f15588d.m19564d();
        }
    }

    public final void m19570a(final HandlePosition handlePosition) {
        m19571b();
        this.f15591g = new Timer();
        this.f15591g.schedule(new TimerTask(this) {
            final /* synthetic */ StripZoomingController f15584b;

            /* compiled from: draft_comment_photo_restored */
            class C11911 implements Runnable {
                final /* synthetic */ C11921 f15582a;

                C11911(C11921 c11921) {
                    this.f15582a = c11921;
                }

                public void run() {
                    StripZoomingController stripZoomingController = this.f15582a.f15584b;
                    int a = this.f15582a.f15584b.f15587c.m19554a(handlePosition);
                    HandlePosition handlePosition = handlePosition;
                    if (!stripZoomingController.f15592h) {
                        stripZoomingController.f15592h = true;
                        stripZoomingController.f15590f.m19602c(a);
                        if (handlePosition == HandlePosition.LEFT) {
                            stripZoomingController.f15587c.f15542f.setLeft(0);
                            stripZoomingController.f15587c.m19559b(stripZoomingController.f15586b.m19616b(stripZoomingController.f15587c.m19557b()), false);
                        } else {
                            StripHandleController stripHandleController = stripZoomingController.f15587c;
                            stripHandleController.f15543g.setRight(stripHandleController.f15539c.getZoomedOutWidth());
                            stripZoomingController.f15587c.m19556a(stripZoomingController.f15586b.m19616b(stripZoomingController.f15587c.m19553a()), false);
                        }
                        C11858 c11858 = stripZoomingController.f15589e;
                        TrimmerLoggingParams trimmerLoggingParams = c11858.f15487a.f15503P;
                        if (handlePosition == HandlePosition.LEFT) {
                            trimmerLoggingParams.f15533c++;
                        } else {
                            trimmerLoggingParams.f15534d++;
                        }
                        c11858.f15487a.f15505b.m19474a(c11858.f15487a.f15518o.m19604a(a, false));
                        stripZoomingController.f15588d.m19563c();
                    }
                }
            }

            public void run() {
                ExecutorDetour.a(this.f15584b.f15585a, new C11911(this), -1460133891);
            }
        }, 300);
    }

    public final void m19571b() {
        if (this.f15591g != null) {
            this.f15591g.cancel();
        }
    }
}
