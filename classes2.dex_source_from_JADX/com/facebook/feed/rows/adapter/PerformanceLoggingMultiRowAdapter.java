package com.facebook.feed.rows.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.inject.Assisted;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: min_auto_refresh_period_sec */
public class PerformanceLoggingMultiRowAdapter extends DelegatingMultiRowRecyclerViewAdapter {
    private final QuickPerformanceLogger f13520a;
    private final String f13521b;
    private final String f13522c;

    @Inject
    public PerformanceLoggingMultiRowAdapter(@Assisted MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, @Assisted String str, QuickPerformanceLogger quickPerformanceLogger) {
        super(multiRowRecyclerViewAdapter);
        this.f13520a = quickPerformanceLogger;
        this.f13520a.mo463b(655482, 100);
        this.f13520a.mo463b(655369, 100);
        this.f13521b = str + ".bindView";
        this.f13522c = str + ".createView";
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        this.f13520a.mo462b(655482);
        TracerDetour.a(this.f13521b, -269458810);
        try {
            super.mo2225a(viewHolder, i);
        } finally {
            TracerDetour.a(1637592337);
            this.f13520a.mo468b(655482, (short) 2);
        }
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        this.f13520a.mo462b(655369);
        TracerDetour.a(this.f13522c, -1361665616);
        try {
            ViewHolder a = super.mo2222a(viewGroup, i);
            return a;
        } finally {
            TracerDetour.a(-2097946809);
            this.f13520a.mo468b(655369, (short) 2);
        }
    }
}
