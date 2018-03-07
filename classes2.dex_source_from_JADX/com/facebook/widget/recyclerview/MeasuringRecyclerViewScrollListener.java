package com.facebook.widget.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.facebook.inject.Assisted;
import com.facebook.quicklog.QuickPerformanceLogger;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: num_stories_fetched_in_last_result */
public class MeasuringRecyclerViewScrollListener extends OnScrollListener {
    private final QuickPerformanceLogger f11881a;
    private final Random f11882b;
    private final int f11883c;
    private final OnScrollListener f11884d;

    @Inject
    public MeasuringRecyclerViewScrollListener(QuickPerformanceLogger quickPerformanceLogger, Random random, @Assisted Integer num, @Assisted OnScrollListener onScrollListener) {
        this.f11881a = quickPerformanceLogger;
        this.f11882b = random;
        this.f11883c = num.intValue();
        this.f11884d = onScrollListener;
    }

    public final void mo2219a(RecyclerView recyclerView, int i) {
        this.f11884d.mo2219a(recyclerView, i);
    }

    public final void mo2220a(RecyclerView recyclerView, int i, int i2) {
        Object obj = this.f11882b.nextInt(300) == 0 ? 1 : null;
        if (obj != null) {
            this.f11881a.mo462b(this.f11883c);
        }
        this.f11884d.mo2220a(recyclerView, i, i2);
        if (obj != null) {
            this.f11881a.mo468b(this.f11883c, (short) 2);
        }
    }
}
