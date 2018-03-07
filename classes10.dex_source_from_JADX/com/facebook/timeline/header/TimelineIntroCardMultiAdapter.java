package com.facebook.timeline.header;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: frame_durations */
public class TimelineIntroCardMultiAdapter extends MultiAdapterListAdapter {
    private List<TimelineHeaderCachedBindAdapter> f11500a;
    private final TimelineHeaderDataLogger f11501b;
    private final TimelineHeaderUserData f11502c;
    private final TimelineHeaderViewController f11503d;
    private final TimelineContext f11504e;
    private final FeaturedContainersHeaderData f11505f;

    @Inject
    public TimelineIntroCardMultiAdapter(@Assisted List<TimelineHeaderCachedBindAdapter> list, @Assisted TimelineHeaderDataLogger timelineHeaderDataLogger, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineContext timelineContext, TimelineHeaderViewController timelineHeaderViewController, FeaturedContainersHeaderData featuredContainersHeaderData) {
        super(false, list);
        this.f11500a = list;
        this.f11501b = timelineHeaderDataLogger;
        this.f11502c = timelineHeaderUserData;
        this.f11504e = timelineContext;
        this.f11503d = timelineHeaderViewController;
        this.f11505f = featuredContainersHeaderData;
    }

    public final void m11536d() {
        for (TimelineHeaderCachedBindAdapter b : this.f11500a) {
            b.mo528b();
        }
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (!(this.f11502c.j() || this.f11501b == null)) {
            boolean z = this.f11502c.W() || this.f11502c.Y() || TimelineHeaderViewController.m11688b(this.f11504e, this.f11502c, this.f11505f);
            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11501b;
            if (!timelineHeaderDataLogger.f11376k) {
                timelineHeaderDataLogger.f11376k = true;
                timelineHeaderDataLogger.f11370e.a(z, timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b, timelineHeaderDataLogger.f11375j);
            }
        }
        return view2;
    }
}
