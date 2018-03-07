package com.facebook.feed.rows.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.frameblame.DataChangedFrameBlameMarker;
import com.facebook.feed.rows.core.frameblame.GetViewAfterDataChangedFrameBlameMarker;
import com.facebook.feed.rows.core.frameblame.GetViewFrameBlameMarker;
import com.facebook.inject.Assisted;
import com.facebook.widget.recyclerview.SimpleAdapterDataObserver;
import javax.inject.Inject;

/* compiled from: method/intl.getLocaleSuggestions */
public class FrameRateBlameMultiRowAdapter extends DelegatingMultiRowRecyclerViewAdapter {
    public final FrameRateBlameMarkers f13604a;
    public boolean f13605b;

    /* compiled from: method/intl.getLocaleSuggestions */
    class C05531 extends SimpleAdapterDataObserver {
        final /* synthetic */ FrameRateBlameMultiRowAdapter f13606a;

        C05531(FrameRateBlameMultiRowAdapter frameRateBlameMultiRowAdapter) {
            this.f13606a = frameRateBlameMultiRowAdapter;
        }

        public final void mo2216b() {
            FrameRateBlameMarkers frameRateBlameMarkers = this.f13606a.f13604a;
            if (DataChangedFrameBlameMarker.f13676a == null) {
                DataChangedFrameBlameMarker.f13676a = new DataChangedFrameBlameMarker();
            }
            frameRateBlameMarkers.m16552c(DataChangedFrameBlameMarker.f13676a);
            this.f13606a.f13605b = true;
        }
    }

    @Inject
    public FrameRateBlameMultiRowAdapter(@Assisted MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, FrameRateBlameMarkers frameRateBlameMarkers) {
        super(multiRowRecyclerViewAdapter);
        this.f13604a = frameRateBlameMarkers;
        mo2223a(new C05531(this));
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        if (this.f13605b) {
            if (GetViewAfterDataChangedFrameBlameMarker.f19245a == null) {
                GetViewAfterDataChangedFrameBlameMarker.f19245a = new GetViewAfterDataChangedFrameBlameMarker();
            }
            this.f13604a.m16552c(GetViewAfterDataChangedFrameBlameMarker.f19245a);
            this.f13605b = false;
        }
        if (GetViewFrameBlameMarker.f19246a == null) {
            GetViewFrameBlameMarker.f19246a = new GetViewFrameBlameMarker();
        }
        GetViewFrameBlameMarker getViewFrameBlameMarker = GetViewFrameBlameMarker.f19246a;
        getViewFrameBlameMarker.f19247b = getItemViewType(i);
        this.f13604a.m16552c(getViewFrameBlameMarker);
        super.mo2225a(viewHolder, i);
    }
}
