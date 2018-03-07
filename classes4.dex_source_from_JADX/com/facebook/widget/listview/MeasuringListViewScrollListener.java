package com.facebook.widget.listview;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.inject.Assisted;
import com.facebook.quicklog.QuickPerformanceLogger;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: event_id */
public class MeasuringListViewScrollListener implements OnScrollListener {
    private final QuickPerformanceLogger f12743a;
    private final Random f12744b;
    private final int f12745c;
    private final OnScrollListener f12746d;

    @Inject
    public MeasuringListViewScrollListener(QuickPerformanceLogger quickPerformanceLogger, Random random, @Assisted Integer num, @Assisted OnScrollListener onScrollListener) {
        this.f12743a = quickPerformanceLogger;
        this.f12744b = random;
        this.f12746d = onScrollListener;
        this.f12745c = num.intValue();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f12746d.onScrollStateChanged(absListView, i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Object obj = this.f12744b.nextInt(300) == 0 ? 1 : null;
        if (obj != null) {
            this.f12743a.b(this.f12745c);
        }
        this.f12746d.onScroll(absListView, i, i2, i3);
        if (obj != null) {
            this.f12743a.b(this.f12745c, (short) 2);
        }
    }
}
