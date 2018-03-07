package com.facebook.timeline.header;

import android.os.Handler;
import com.facebook.common.executors.ForUiThread;
import com.facebook.inject.Assisted;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.ui.TimelineFragmentView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friend_list_suggestions_seen */
public class TimelineHeaderPerfControllerImpl implements TimelineHeaderPerfController {
    private final TimelinePerformanceLogger f11406a;
    private final TimelineHeaderRenderState f11407b;
    @ForUiThread
    private final Handler f11408c;
    private final TimelineHeaderDataLogger f11409d;
    @Nullable
    public TimelineFragment f11410e;
    private boolean f11411f = false;
    private boolean f11412g = false;

    /* compiled from: friend_list_suggestions_seen */
    class C16451 implements Runnable {
        final /* synthetic */ TimelineHeaderPerfControllerImpl f11404a;

        C16451(TimelineHeaderPerfControllerImpl timelineHeaderPerfControllerImpl) {
            this.f11404a = timelineHeaderPerfControllerImpl;
        }

        public void run() {
            if (this.f11404a.f11410e != null) {
                this.f11404a.f11410e.aJ();
            }
        }
    }

    /* compiled from: friend_list_suggestions_seen */
    class C16462 implements Runnable {
        final /* synthetic */ TimelineHeaderPerfControllerImpl f11405a;

        C16462(TimelineHeaderPerfControllerImpl timelineHeaderPerfControllerImpl) {
            this.f11405a = timelineHeaderPerfControllerImpl;
        }

        public void run() {
            if (this.f11405a.f11410e != null) {
                this.f11405a.f11410e.aK();
            }
        }
    }

    @Inject
    public TimelineHeaderPerfControllerImpl(TimelinePerformanceLogger timelinePerformanceLogger, TimelineHeaderRenderState timelineHeaderRenderState, Handler handler, @Assisted TimelineHeaderDataLogger timelineHeaderDataLogger) {
        this.f11406a = timelinePerformanceLogger;
        this.f11407b = timelineHeaderRenderState;
        this.f11408c = handler;
        this.f11409d = timelineHeaderDataLogger;
    }

    public final void mo524a(@Nullable TimelineFragment timelineFragment) {
        this.f11410e = timelineFragment;
    }

    public final void mo525a(PhotoLoadState photoLoadState) {
        this.f11406a.c(photoLoadState);
        m11463a();
    }

    public final void mo527b(PhotoLoadState photoLoadState) {
        this.f11406a.a(photoLoadState);
        m11463a();
    }

    public final void mo526a(@Nullable TimelineHeaderUserData timelineHeaderUserData, TimelineFragmentView timelineFragmentView) {
        TimelinePerformanceLogger timelinePerformanceLogger = this.f11406a;
        if (!timelinePerformanceLogger.k) {
            timelinePerformanceLogger.c.f("TimelineFirstOnDraw");
            timelinePerformanceLogger.k = true;
        }
        if (timelineHeaderUserData != null && !timelineHeaderUserData.j()) {
            this.f11406a.t();
            timelineFragmentView.f12750a = null;
            m11463a();
        }
    }

    private void m11463a() {
        if (!(!this.f11407b.i() || this.f11410e == null || this.f11411f)) {
            this.f11411f = true;
            HandlerDetour.a(this.f11408c, new C16451(this), -1615608865);
        }
        if (this.f11407b.k() && this.f11410e != null && !this.f11412g) {
            this.f11412g = true;
            HandlerDetour.a(this.f11408c, new C16462(this), -196566189);
        }
    }
}
