package com.facebook.widget.recyclerview.interleaved;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseIntArray;
import android.view.ViewGroup;

/* compiled from: exposure_point */
public class InterleavedRecyclerViewAdapter<IA extends Adapter<? super ViewHolder> & Interleavable<? super ViewHolder>> extends Adapter<ViewHolder> implements Interleavable<ViewHolder> {
    private final WhichAdapterInfo f12994a = new WhichAdapterInfo();
    private final SparseIntArray f12995b;
    public final Adapter[] f12996c;
    private final ForwardingDataObserver f12997d = new ForwardingDataObserver(this);

    /* compiled from: exposure_point */
    class ForwardingDataObserver extends AdapterDataObserver {
        final /* synthetic */ InterleavedRecyclerViewAdapter f12991a;

        public ForwardingDataObserver(InterleavedRecyclerViewAdapter interleavedRecyclerViewAdapter) {
            this.f12991a = interleavedRecyclerViewAdapter;
        }

        public final void bb_() {
            m13021b();
        }

        public final void m13022a(int i, int i2) {
            m13021b();
        }

        public final void m13024b(int i, int i2) {
            m13021b();
        }

        public final void m13025c(int i, int i2) {
            m13021b();
        }

        public final void m13023a(int i, int i2, int i3) {
            m13021b();
        }

        private void m13021b() {
            this.f12991a.notifyDataSetChanged();
        }
    }

    /* compiled from: exposure_point */
    public class WhichAdapterInfo {
        public int f12992a;
        public int f12993b;
    }

    public InterleavedRecyclerViewAdapter(IA ia, Adapter adapter) {
        boolean z = ia.en_() && adapter.en_();
        super.a(z);
        this.f12995b = new SparseIntArray();
        this.f12996c = new Adapter[2];
        this.f12996c[0] = ia;
        this.f12996c[1] = adapter;
    }

    public final ViewHolder m13029a(ViewGroup viewGroup, int i) {
        return this.f12996c[this.f12995b.get(i)].a(viewGroup, i);
    }

    public final void m13031a(ViewHolder viewHolder, int i) {
        WhichAdapterInfo g = m13028g(i);
        this.f12996c[g.f12992a].a(viewHolder, g.f12993b);
    }

    public final int aZ_() {
        return this.f12996c[0].aZ_() + this.f12996c[1].aZ_();
    }

    public int getItemViewType(int i) {
        WhichAdapterInfo g = m13028g(i);
        int itemViewType = this.f12996c[g.f12992a].getItemViewType(g.f12993b);
        this.f12995b.put(itemViewType, g.f12992a);
        return itemViewType;
    }

    public final long H_(int i) {
        WhichAdapterInfo g = m13028g(i);
        Adapter adapter = this.f12996c[g.f12992a];
        long H_ = adapter.H_(g.f12993b);
        return (31 * ((long) adapter.hashCode())) + ((H_ >>> 32) ^ H_);
    }

    public final void m13032a(boolean z) {
        this.f12996c[0].a(z);
        this.f12996c[1].a(z);
    }

    public final void m13030a(ViewHolder viewHolder) {
        this.f12996c[this.f12995b.get(viewHolder.e)].a(viewHolder);
    }

    public final boolean m13035b(ViewHolder viewHolder) {
        return this.f12996c[this.f12995b.get(viewHolder.e)].b(viewHolder);
    }

    public final void m13036c(ViewHolder viewHolder) {
        this.f12996c[this.f12995b.get(viewHolder.e)].c(viewHolder);
    }

    public final void m13037d(ViewHolder viewHolder) {
        this.f12996c[this.f12995b.get(viewHolder.e)].d(viewHolder);
    }

    public final void a_(RecyclerView recyclerView) {
        this.f12996c[0].a(this.f12997d);
        this.f12996c[0].a_(recyclerView);
        this.f12996c[1].a(this.f12997d);
        this.f12996c[1].a_(recyclerView);
    }

    public final void m13033b(RecyclerView recyclerView) {
        this.f12996c[0].b(recyclerView);
        this.f12996c[0].b(this.f12997d);
        this.f12996c[1].b(recyclerView);
        this.f12996c[1].b(this.f12997d);
    }

    public final boolean mo451b(int i) {
        return i < aZ_();
    }

    private void m13027a(WhichAdapterInfo whichAdapterInfo, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("position=" + i);
        } else if (((Interleavable) this.f12996c[0]).mo451b(i)) {
            whichAdapterInfo.f12992a = 0;
            whichAdapterInfo.f12993b = m13026a((Interleavable) this.f12996c[0], i);
        } else {
            whichAdapterInfo.f12992a = 1;
            whichAdapterInfo.f12993b = i - m13026a((Interleavable) this.f12996c[0], i);
        }
    }

    private WhichAdapterInfo m13028g(int i) {
        m13027a(this.f12994a, i);
        return this.f12994a;
    }

    public static int m13026a(Interleavable interleavable, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (interleavable.mo451b(i3)) {
                i2++;
            }
        }
        return i2;
    }
}
