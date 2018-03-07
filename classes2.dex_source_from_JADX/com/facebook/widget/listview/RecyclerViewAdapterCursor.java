package com.facebook.widget.listview;

import com.facebook.common.dispose.Disposable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: method/ */
public class RecyclerViewAdapterCursor implements Disposable {
    public final ImmutableList<AdapterCompatibleWithListView> f13629a;
    public final ImmutableList<AdapterData> f13630b;
    private final int f13631c;
    public final boolean f13632d;
    public int f13633e;
    public int f13634f;
    public int f13635g;
    public int f13636h;
    public int f13637i;
    public boolean f13638j = true;
    private boolean f13639k;

    /* compiled from: method/ */
    public class AdapterData {
        final int f13640a;
        public final AdapterCompatibleWithListView<?> f13641b;
        public int f13642c;
        public int f13643d;
        public int f13644e;
        public int f13645f;
        public final /* synthetic */ RecyclerViewAdapterCursor f13646g;

        AdapterData(RecyclerViewAdapterCursor recyclerViewAdapterCursor, AdapterCompatibleWithListView<?> adapterCompatibleWithListView, int i) {
            this.f13646g = recyclerViewAdapterCursor;
            this.f13640a = i;
            this.f13641b = adapterCompatibleWithListView;
        }
    }

    public RecyclerViewAdapterCursor(ImmutableList<AdapterCompatibleWithListView> immutableList, boolean z) {
        this.f13632d = z;
        this.f13629a = immutableList;
        this.f13631c = immutableList.size();
        Builder builder = new Builder();
        for (int i = 0; i < this.f13631c; i++) {
            AdapterCompatibleWithListView adapterCompatibleWithListView = (AdapterCompatibleWithListView) immutableList.get(i);
            builder.m1069c(new AdapterData(this, adapterCompatibleWithListView, i));
            this.f13638j = adapterCompatibleWithListView.en_() & this.f13638j;
        }
        this.f13630b = builder.m1068b();
        m20044b();
    }

    public final void m20044b() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f13631c; i3++) {
            AdapterData adapterData = (AdapterData) this.f13630b.get(i3);
            adapterData.f13642c = adapterData.f13641b.aZ_();
            adapterData.f13643d = adapterData.f13646g.f13632d ? adapterData.f13641b.iy_() : 2000;
            adapterData.f13644e = i;
            adapterData.f13645f = i2;
            i += adapterData.f13642c;
            i2 += adapterData.f13643d;
        }
        this.f13636h = i;
        this.f13637i = i2;
        this.f13633e = 0;
        this.f13634f = 0;
        this.f13635g = 0;
    }

    public final void m20042a(int i) {
        if (i < 0 || i >= this.f13636h) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position: %d Count: %d", Integer.valueOf(i), Integer.valueOf(this.f13636h)));
        }
        this.f13634f = i;
        while (true) {
            AdapterData adapterData = (AdapterData) this.f13630b.get(this.f13633e);
            if (i < adapterData.f13644e) {
                this.f13633e--;
            } else if (i >= adapterData.f13644e + adapterData.f13642c) {
                this.f13633e++;
            } else {
                this.f13635g = i - adapterData.f13644e;
                return;
            }
        }
    }

    public final void m20043a(AdapterCompatibleWithListView adapterCompatibleWithListView) {
        int indexOf = this.f13629a.indexOf(adapterCompatibleWithListView);
        if (indexOf == -1) {
            throw new IllegalStateException("Unknown adapter " + adapterCompatibleWithListView);
        }
        m20045b(indexOf);
    }

    public final void m20045b(int i) {
        boolean z;
        if (i < 0 || i >= this.f13631c) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f13633e = i;
        this.f13635g = 0;
        this.f13634f = ((AdapterData) this.f13630b.get(i)).f13644e;
    }

    public final void m20046c(int i) {
        if (i < 0 || i >= this.f13637i) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("ViewType: %d TotalViewTypeCount: %d", Integer.valueOf(i), Integer.valueOf(this.f13637i)));
        }
        this.f13635g = 0;
        while (true) {
            AdapterData adapterData = (AdapterData) this.f13630b.get(this.f13633e);
            if (i < adapterData.f13645f) {
                this.f13633e--;
            } else if (i >= adapterData.f13645f + adapterData.f13643d) {
                this.f13633e++;
            } else {
                this.f13634f = adapterData.f13644e;
                return;
            }
        }
    }

    public final int m20047d() {
        return ((AdapterData) this.f13630b.get(this.f13633e)).f13645f;
    }

    public final int m20048g() {
        return ((AdapterData) this.f13630b.get(this.f13633e)).f13644e;
    }

    public final AdapterCompatibleWithListView m20049j() {
        return ((AdapterData) this.f13630b.get(this.f13633e)).f13641b;
    }

    public final void jc_() {
        for (int i = 0; i < this.f13631c; i++) {
            AdapterCompatibleWithListView adapterCompatibleWithListView = (AdapterCompatibleWithListView) this.f13629a.get(i);
            if (adapterCompatibleWithListView instanceof Disposable) {
                ((Disposable) adapterCompatibleWithListView).jc_();
            }
        }
        this.f13639k = true;
    }

    public final boolean ba_() {
        return this.f13639k;
    }
}
