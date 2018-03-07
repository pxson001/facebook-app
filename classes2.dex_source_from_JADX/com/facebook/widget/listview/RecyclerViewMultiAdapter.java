package com.facebook.widget.listview;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.common.dispose.Disposable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.listview.RecyclerViewAdapterCursor.AdapterData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: method/auth.getSessionForApp */
public class RecyclerViewMultiAdapter extends Adapter<ViewHolder> implements Disposable, AdapterCompatibleWithListView<ViewHolder> {
    public final RecyclerViewAdapterCursor f13613a;
    public final ImmutableList<AdapterCompatibleWithListView> f13614b;
    public boolean f13615c;

    /* compiled from: method/auth.getSessionForApp */
    class SubAdapterObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerViewMultiAdapter f13647a;
        private final int f13648b;

        public SubAdapterObserver(RecyclerViewMultiAdapter recyclerViewMultiAdapter, int i) {
            this.f13647a = recyclerViewMultiAdapter;
            this.f13648b = i;
        }

        public final void bb_() {
            if (!this.f13647a.f13615c) {
                this.f13647a.f13615c = true;
                this.f13647a.notifyDataSetChanged();
                this.f13647a.f13615c = false;
            }
        }

        public final void mo2217a(int i, int i2) {
            m20050a(3, i, -1, i2);
        }

        public final void mo2210b(int i, int i2) {
            m20050a(4, i, -1, i2);
        }

        public final void mo2212c(int i, int i2) {
            m20050a(2, i, -1, i2);
        }

        public final void mo2218a(int i, int i2, int i3) {
            m20050a(1, i, i2, i3);
        }

        private void m20050a(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (!this.f13647a.f13615c) {
                boolean z2 = i2 >= 0 && i4 >= 0;
                Preconditions.checkArgument(z2);
                this.f13647a.f13613a.m20045b(this.f13648b);
                int g = this.f13647a.f13613a.m20048g() + i2;
                if ((i != 4 || g >= this.f13647a.f13613a.f13636h) && g + i4 > this.f13647a.f13613a.f13636h) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Preconditions.checkArgument(z2);
                this.f13647a.f13615c = true;
                switch (i) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        int g2;
                        Preconditions.checkArgument(i4 == 1, "RecyclerView.Adapter.notifyItemRangedMoved() does not exist");
                        if (i3 >= 0) {
                            RecyclerViewAdapterCursor recyclerViewAdapterCursor = this.f13647a.f13613a;
                            if (i3 < ((AdapterData) recyclerViewAdapterCursor.f13630b.get(recyclerViewAdapterCursor.f13633e)).f13642c) {
                                z2 = true;
                                Preconditions.checkArgument(z2);
                                g2 = this.f13647a.f13613a.m20048g() + i3;
                                if (g2 >= this.f13647a.f13613a.f13636h) {
                                    z = false;
                                }
                                Preconditions.checkArgument(z);
                                this.f13647a.f13613a.m20044b();
                                this.f13647a.m17223b(g, g2);
                                break;
                            }
                        }
                        z2 = false;
                        Preconditions.checkArgument(z2);
                        g2 = this.f13647a.f13613a.m20048g() + i3;
                        if (g2 >= this.f13647a.f13613a.f13636h) {
                            z = false;
                        }
                        Preconditions.checkArgument(z);
                        this.f13647a.f13613a.m20044b();
                        this.f13647a.m17223b(g, g2);
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        this.f13647a.f13613a.m20044b();
                        this.f13647a.m17230d(g, i4);
                        break;
                    case 3:
                        this.f13647a.f13613a.m20044b();
                        this.f13647a.m17217a(g, i4);
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        this.f13647a.f13613a.m20044b();
                        this.f13647a.m17228c(g, i4);
                        break;
                }
                this.f13647a.f13615c = false;
            }
        }
    }

    /* compiled from: method/auth.getSessionForApp */
    class MultiAdapterObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerViewMultiAdapter f13649a;

        public MultiAdapterObserver(RecyclerViewMultiAdapter recyclerViewMultiAdapter) {
            this.f13649a = recyclerViewMultiAdapter;
        }

        public final void bb_() {
            if (this.f13649a.f13615c) {
                this.f13649a.f13613a.m20044b();
                return;
            }
            this.f13649a.f13615c = true;
            for (int i = 0; i < this.f13649a.f13614b.size(); i++) {
                ((AdapterCompatibleWithListView) this.f13649a.f13614b.get(i)).notifyDataSetChanged();
            }
            this.f13649a.f13615c = false;
            this.f13649a.f13613a.m20044b();
        }

        public final void mo2217a(int i, int i2) {
            m20055a(3, i, -1, i2);
        }

        public final void mo2210b(int i, int i2) {
            m20055a(4, i, -1, i2);
        }

        public final void mo2212c(int i, int i2) {
            m20055a(2, i, -1, i2);
        }

        public final void mo2218a(int i, int i2, int i3) {
            m20055a(1, i, i2, i3);
        }

        private void m20055a(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (this.f13649a.f13615c) {
                this.f13649a.f13613a.m20044b();
                return;
            }
            boolean z2 = i2 >= 0 && i2 < this.f13649a.aZ_();
            Preconditions.checkArgument(z2);
            if (i4 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            this.f13649a.f13613a.m20042a(i2);
            int i5 = this.f13649a.f13613a.f13635g;
            AdapterCompatibleWithListView j = this.f13649a.f13613a.m20049j();
            this.f13649a.f13615c = true;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    Preconditions.checkArgument(i4 == 1, "RecyclerView.Adapter.notifyItemRangedMoved() does not exist");
                    if (i3 < 0 || i3 >= this.f13649a.aZ_()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    Preconditions.checkArgument(z2);
                    this.f13649a.f13613a.m20042a(i3);
                    int i6 = this.f13649a.f13613a.f13635g;
                    if (this.f13649a.f13613a.m20049j() != j) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.f13649a.f13613a.m20044b();
                    j.mo2643b(i5, i6);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f13649a.f13613a.m20044b();
                    j.mo2645d(i5, i4);
                    break;
                case 3:
                    this.f13649a.f13613a.m20044b();
                    j.mo2642a(i5, i4);
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    this.f13649a.f13613a.m20044b();
                    j.mo2644c(i5, i4);
                    break;
            }
            this.f13649a.f13615c = false;
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public RecyclerViewMultiAdapter(ImmutableList<AdapterCompatibleWithListView> immutableList, boolean z) {
        this.f13614b = immutableList;
        this.f13613a = new RecyclerViewAdapterCursor(immutableList, z);
        for (int i = 0; i < this.f13614b.size(); i++) {
            ((AdapterCompatibleWithListView) this.f13614b.get(i)).mo2223a(new SubAdapterObserver(this, i));
        }
        m17221a(this.f13613a.f13638j);
        mo2223a(new MultiAdapterObserver(this));
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        this.f13613a.m20046c(i);
        return this.f13613a.m20049j().mo2222a(viewGroup, i - this.f13613a.m20047d());
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        this.f13613a.m20049j().mo2225a(viewHolder, this.f13613a.f13635g);
    }

    public final int iy_() {
        RecyclerViewAdapterCursor recyclerViewAdapterCursor = this.f13613a;
        Preconditions.checkState(recyclerViewAdapterCursor.f13632d);
        return recyclerViewAdapterCursor.f13637i;
    }

    public Object getItem(int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        return this.f13613a.m20049j().getItem(this.f13613a.f13635g);
    }

    public final long H_(int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        RecyclerViewAdapterCursor recyclerViewAdapterCursor = this.f13613a;
        long H_ = ((AdapterCompatibleWithListView) recyclerViewAdapterCursor.f13629a.get(recyclerViewAdapterCursor.f13633e)).H_(recyclerViewAdapterCursor.f13635g);
        Preconditions.checkArgument(H_ < 100000);
        return ((long) (100000 * recyclerViewAdapterCursor.f13633e)) + H_;
    }

    public final int aZ_() {
        return this.f13613a.f13636h;
    }

    public int getItemViewType(int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        return this.f13613a.m20049j().getItemViewType(this.f13613a.f13635g) + this.f13613a.m20047d();
    }

    public final AdapterCompatibleWithListView m20031e(int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        return this.f13613a.m20049j();
    }

    public final int m20032f(int i) {
        mo2514g(i);
        this.f13613a.m20042a(i);
        return this.f13613a.f13635g;
    }

    public void jc_() {
        this.f13613a.jc_();
    }

    public final boolean ba_() {
        return this.f13613a.ba_();
    }

    private void mo2514g(int i) {
        int aZ_ = aZ_();
        if (i < 0 || i >= aZ_) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("position: %d, total count: %d", Integer.valueOf(i), Integer.valueOf(aZ_)));
        }
    }
}
