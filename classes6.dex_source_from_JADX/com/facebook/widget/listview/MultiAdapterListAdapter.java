package com.facebook.widget.listview;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.dispose.Disposable;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.AdapterListCursor.OnBeforeAdapterUpdateCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: ref_type */
public class MultiAdapterListAdapter extends BaseAdapter implements Disposable, BasicAdapter, FbListAdapter {
    public final ImmutableList<SubAdapterObserver> f6062a;
    public final AdapterListCursor f6063b;
    public final OnBeforeAdapterUpdateCallback f6064c;

    /* compiled from: ref_type */
    class C03561 implements OnBeforeAdapterUpdateCallback {
        final /* synthetic */ MultiAdapterListAdapter f6056a;

        C03561(MultiAdapterListAdapter multiAdapterListAdapter) {
            this.f6056a = multiAdapterListAdapter;
        }

        public final void mo437a(FbListAdapter fbListAdapter, int i) {
            SubAdapterObserver subAdapterObserver = (SubAdapterObserver) this.f6056a.f6062a.get(i);
            subAdapterObserver.m8623a(false);
            fbListAdapter.notifyDataSetChanged();
            subAdapterObserver.m8623a(true);
        }
    }

    /* compiled from: ref_type */
    class SubAdapterObserver extends DataSetObserver {
        final /* synthetic */ MultiAdapterListAdapter f6059a;
        private final FbListAdapter f6060b;
        private boolean f6061c = true;

        public SubAdapterObserver(MultiAdapterListAdapter multiAdapterListAdapter, FbListAdapter fbListAdapter) {
            this.f6059a = multiAdapterListAdapter;
            this.f6060b = fbListAdapter;
        }

        final synchronized void m8623a(boolean z) {
            this.f6061c = z;
        }

        public void onChanged() {
            if (this.f6061c) {
                MultiAdapterListAdapter.m8628b(this.f6059a, this.f6060b);
            }
        }

        public void onInvalidated() {
            AdapterDetour.b(this.f6059a, -511058079);
        }
    }

    public static MultiAdapterListAdapter m8624a(List<FbListAdapter> list) {
        return new MultiAdapterListAdapter(false, (List) list);
    }

    public static MultiAdapterListAdapter m8625a(FbListAdapter... fbListAdapterArr) {
        return new MultiAdapterListAdapter(false, fbListAdapterArr);
    }

    public static MultiAdapterListAdapter m8627b(FbListAdapter... fbListAdapterArr) {
        return new MultiAdapterListAdapter(true, fbListAdapterArr);
    }

    public MultiAdapterListAdapter(boolean z, List<? extends FbListAdapter> list) {
        this.f6064c = new C03561(this);
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        for (FbListAdapter fbListAdapter : list) {
            DataSetObserver subAdapterObserver = new SubAdapterObserver(this, fbListAdapter);
            fbListAdapter.registerDataSetObserver(subAdapterObserver);
            builder.c(subAdapterObserver);
            builder2.c(fbListAdapter);
        }
        this.f6062a = builder.b();
        this.f6063b = new AdapterListCursor(z, builder2.b());
        m8634b();
    }

    public MultiAdapterListAdapter(boolean z, FbListAdapter... fbListAdapterArr) {
        this(z, Lists.a(fbListAdapterArr));
    }

    public final View m8631a(int i, ViewGroup viewGroup) {
        this.f6063b.m8577b(i);
        return this.f6063b.m8579f().a(this.f6063b.m8578c(i), viewGroup);
    }

    public final void m8633a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f6063b.m8573a(i);
        this.f6063b.m8579f().a(this.f6063b.f5997d, obj, view, this.f6063b.m8578c(i2), viewGroup);
    }

    public boolean areAllItemsEnabled() {
        return this.f6063b.m8582i();
    }

    public boolean isEnabled(int i) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f().isEnabled(this.f6063b.f5997d);
    }

    public int getCount() {
        return this.f6063b.m8580g();
    }

    public final int aZ_() {
        return getCount();
    }

    public Object getItem(int i) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f().getItem(this.f6063b.f5997d);
    }

    public long getItemId(int i) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f().getItemId(this.f6063b.f5997d);
    }

    public boolean hasStableIds() {
        return this.f6063b.m8582i();
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f().getView(this.f6063b.f5997d, view, viewGroup);
    }

    public int getItemViewType(int i) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f().getItemViewType(this.f6063b.f5997d) + this.f6063b.m8576b();
    }

    public int getViewTypeCount() {
        return this.f6063b.m8581h();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public void notifyDataSetChanged() {
        TracerDetour.a("MultiAdapterListAdapter.notifyDataSetChanged", -178756327);
        try {
            m8626a(this.f6064c);
            super.notifyDataSetChanged();
        } finally {
            TracerDetour.a(-1126044492);
        }
    }

    public FbListAdapter mo1039a(int i) {
        this.f6063b.m8573a(i);
        return this.f6063b.m8579f();
    }

    public final int m8629a(FbListAdapter fbListAdapter) {
        this.f6063b.m8575a(fbListAdapter);
        return this.f6063b.f5996c;
    }

    public final int m8630a(FbListAdapter fbListAdapter, int i) {
        this.f6063b.m8575a(fbListAdapter);
        return this.f6063b.m8576b() + i;
    }

    public void m8634b() {
        m8626a(null);
    }

    private void m8626a(@Nullable OnBeforeAdapterUpdateCallback onBeforeAdapterUpdateCallback) {
        this.f6063b.m8574a(onBeforeAdapterUpdateCallback);
    }

    public static void m8628b(MultiAdapterListAdapter multiAdapterListAdapter, final FbListAdapter fbListAdapter) {
        multiAdapterListAdapter.m8626a(new OnBeforeAdapterUpdateCallback(multiAdapterListAdapter) {
            final /* synthetic */ MultiAdapterListAdapter f6058b;

            public final void mo437a(FbListAdapter fbListAdapter, int i) {
                if (fbListAdapter != fbListAdapter) {
                    this.f6058b.f6064c.mo437a(fbListAdapter, i);
                }
            }
        });
        super.notifyDataSetChanged();
    }

    public final void jc_() {
        this.f6063b.jc_();
    }

    public final boolean ba_() {
        return this.f6063b.ba_();
    }
}
