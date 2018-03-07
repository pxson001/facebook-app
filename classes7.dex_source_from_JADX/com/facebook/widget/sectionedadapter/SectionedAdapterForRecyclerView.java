package com.facebook.widget.sectionedadapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.Observer;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.Section;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.SectionLookUpResult;
import com.facebook.widget.sectionedadapter.SectionedAdapterController.ViewTypeLookUpResult;
import com.google.common.collect.ImmutableList;

/* compiled from: dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2 */
public class SectionedAdapterForRecyclerView<T extends SectionAdapter> extends Adapter<SectionedAdapterViewHolder> {
    private final SectionedAdapterController<T> f16166a;

    /* compiled from: dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2 */
    class C12761 extends Observer {
        final /* synthetic */ SectionedAdapterForRecyclerView f16163a;

        C12761(SectionedAdapterForRecyclerView sectionedAdapterForRecyclerView) {
            this.f16163a = sectionedAdapterForRecyclerView;
        }

        public final void mo1239a() {
            super.mo1239a();
            this.f16163a.notifyDataSetChanged();
        }

        public final void mo1240a(int i, int i2) {
            super.mo1240a(i, i2);
            this.f16163a.a(i, i2);
        }

        public final void mo1242b(int i, int i2) {
            super.mo1242b(i, i2);
            this.f16163a.c(i, i2);
        }

        public final void mo1243c(int i, int i2) {
            super.mo1243c(i, i2);
            this.f16163a.d(i, i2);
        }

        public final void mo1241a(int i, int i2, int i3) {
            super.mo1241a(i, i2, i3);
            for (int i4 = 0; i4 < i3; i4++) {
                this.f16163a.b(i + i4, i2 + i4);
            }
        }
    }

    /* compiled from: dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2 */
    public abstract class SectionAdapter extends Adapter<SectionedAdapterViewHolder> implements Section {
        public abstract void m20210a(View view, int i);

        public abstract View m20214d(ViewGroup viewGroup, int i);

        public final /* synthetic */ ViewHolder m20208a(ViewGroup viewGroup, int i) {
            return m20213c(viewGroup, i);
        }

        public final void mo57a(final Observer observer) {
            super.a(new AdapterDataObserver(this) {
                final /* synthetic */ SectionAdapter f16165b;

                public final void bb_() {
                    observer.mo1239a();
                }

                public final void m20204a(int i, int i2) {
                    observer.mo1240a(i, i2);
                }

                public final void m20206b(int i, int i2) {
                    observer.mo1242b(i, i2);
                }

                public final void m20207c(int i, int i2) {
                    observer.mo1243c(i, i2);
                }

                public final void m20205a(int i, int i2, int i3) {
                    observer.mo1241a(i, i2, i3);
                }
            });
        }

        public final SectionedAdapterViewHolder m20213c(ViewGroup viewGroup, int i) {
            return new SectionedAdapterViewHolder(m20214d(viewGroup, i));
        }

        public final void m20212a(SectionedAdapterViewHolder sectionedAdapterViewHolder, int i) {
            m20210a(sectionedAdapterViewHolder.a, i);
        }

        public final int aZ_() {
            return getCount();
        }
    }

    /* compiled from: dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2 */
    public class SectionedAdapterViewHolder extends ViewHolder {
        public SectionedAdapterViewHolder(View view) {
            super(view);
        }
    }

    public final void m20216a(ViewHolder viewHolder) {
        SectionedAdapterViewHolder sectionedAdapterViewHolder = (SectionedAdapterViewHolder) viewHolder;
        ((SectionAdapter) this.f16166a.m20191a(sectionedAdapterViewHolder.e).f16146b).a(sectionedAdapterViewHolder);
    }

    public final void m20217a(ViewHolder viewHolder, int i) {
        SectionedAdapterViewHolder sectionedAdapterViewHolder = (SectionedAdapterViewHolder) viewHolder;
        SectionLookUpResult e = m20218e(i);
        ((SectionAdapter) e.f16140b).m20212a(sectionedAdapterViewHolder, e.f16139a);
    }

    public SectionedAdapterForRecyclerView(ImmutableList<T> immutableList) {
        this((ImmutableList) immutableList, null);
    }

    public SectionedAdapterForRecyclerView(ImmutableList<T> immutableList, boolean z) {
        this(immutableList, null, z);
    }

    private SectionedAdapterForRecyclerView(ImmutableList<T> immutableList, T t) {
        this(immutableList, t, false);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private SectionedAdapterForRecyclerView(ImmutableList<T> immutableList, T t, boolean z) {
        this.f16166a = z ? SectionedAdapterController.m20187a(immutableList, t) : new SectionedAdapterController(immutableList, t);
        this.f16166a.f16150c = new C12761(this);
    }

    public final ViewHolder m20215a(ViewGroup viewGroup, int i) {
        ViewTypeLookUpResult a = this.f16166a.m20191a(i);
        return ((SectionAdapter) a.f16146b).m20213c(viewGroup, a.f16145a);
    }

    protected final SectionLookUpResult<T> m20218e(int i) {
        return this.f16166a.m20193b(i);
    }

    public final int aZ_() {
        return this.f16166a.m20190a();
    }

    public int getItemViewType(int i) {
        return this.f16166a.m20194c(i);
    }
}
