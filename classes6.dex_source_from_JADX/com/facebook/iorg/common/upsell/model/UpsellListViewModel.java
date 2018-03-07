package com.facebook.iorg.common.upsell.model;

import android.os.Parcelable;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: mCanMessage */
public class UpsellListViewModel {
    private List<UpsellRowViewModel> f11278a = Lists.a();
    public OnCheckedChangeListener f11279b;

    /* compiled from: mCanMessage */
    public class UpsellRowViewModel {
        public final String f11272a;
        public String f11273b;
        public String f11274c;
        public String f11275d;
        public Parcelable f11276e;
        public boolean f11277f;

        public UpsellRowViewModel(String str, String str2, String str3, String str4, Parcelable parcelable, boolean z) {
            this.f11272a = str;
            this.f11273b = str2;
            this.f11274c = str3;
            this.f11275d = str4;
            this.f11276e = parcelable;
            this.f11277f = z;
        }
    }

    public final UpsellListViewModel m18132a(String str, String str2, String str3, String str4, Parcelable parcelable, boolean z) {
        this.f11278a.add(new UpsellRowViewModel(str, str2, str3, str4, parcelable, z));
        return this;
    }

    public final ImmutableList<UpsellRowViewModel> m18133a() {
        return ImmutableList.copyOf(this.f11278a);
    }
}
