package com.facebook.photos.pandora.common.ui.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: combined_results */
public abstract class AbstractPandoraAdapter extends FbBaseAdapter {
    public final List<AbstractPandoraChildAdapter> f17435a = Lists.a();
    private final List<Class<? extends View>> f17436b = Lists.a();
    public final PandoraAdapterDataSetObserver f17437c = new PandoraAdapterDataSetObserver(this);

    /* compiled from: combined_results */
    class PandoraAdapterDataSetObserver extends DataSetObserver {
        final /* synthetic */ AbstractPandoraAdapter f17434a;

        public PandoraAdapterDataSetObserver(AbstractPandoraAdapter abstractPandoraAdapter) {
            this.f17434a = abstractPandoraAdapter;
        }

        public void onChanged() {
            AdapterDetour.a(this.f17434a, -913186828);
        }

        public void onInvalidated() {
            AdapterDetour.b(this.f17434a, -503714010);
        }
    }

    protected final void m21412a(AbstractPandoraChildAdapter abstractPandoraChildAdapter) {
        Preconditions.checkNotNull(abstractPandoraChildAdapter);
        this.f17435a.add(abstractPandoraChildAdapter);
        ImmutableList a = abstractPandoraChildAdapter.mo1043a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Class cls = (Class) a.get(i);
            if (!this.f17436b.contains(cls)) {
                this.f17436b.add(cls);
            }
        }
        abstractPandoraChildAdapter.registerDataSetObserver(this.f17437c);
        AdapterDetour.a(this, -2069890807);
    }

    public final Object getItem(int i) {
        AbstractPandoraChildAdapter a = m21408a(i);
        if (a == null) {
            return null;
        }
        return a.getItem(i - m21409b(a));
    }

    public final long getItemId(int i) {
        AbstractPandoraChildAdapter a = m21408a(i);
        if (a == null) {
            return 0;
        }
        return a.getItemId(i - m21409b(a));
    }

    public final int getCount() {
        int i = 0;
        for (AbstractPandoraChildAdapter count : this.f17435a) {
            i = count.getCount() + i;
        }
        return i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AbstractPandoraChildAdapter a = m21408a(i);
        if (a == null) {
            return null;
        }
        return a.getView(i - m21409b(a), view, viewGroup);
    }

    public final View m21410a(int i, ViewGroup viewGroup) {
        return null;
    }

    public final void m21411a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }

    public final int getViewTypeCount() {
        return Math.max(1, this.f17436b.size());
    }

    public final int getItemViewType(int i) {
        AbstractPandoraChildAdapter a = m21408a(i);
        if (a == null) {
            return 0;
        }
        return this.f17436b.indexOf(a.mo1044a(i - m21409b(a)));
    }

    private AbstractPandoraChildAdapter m21408a(int i) {
        int i2 = 0;
        for (AbstractPandoraChildAdapter abstractPandoraChildAdapter : this.f17435a) {
            if (abstractPandoraChildAdapter.getCount() + i2 > i) {
                return abstractPandoraChildAdapter;
            }
            i2 = abstractPandoraChildAdapter.getCount() + i2;
        }
        return null;
    }

    private int m21409b(AbstractPandoraChildAdapter abstractPandoraChildAdapter) {
        Preconditions.checkNotNull(abstractPandoraChildAdapter);
        int i = 0;
        for (AbstractPandoraChildAdapter abstractPandoraChildAdapter2 : this.f17435a) {
            if (abstractPandoraChildAdapter2 == abstractPandoraChildAdapter) {
                return i;
            }
            i = abstractPandoraChildAdapter2.getCount() + i;
        }
        throw new RuntimeException("Failed to get absolute starting position of current adapter");
    }
}
