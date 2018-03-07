package com.facebook.ipc.simplepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: latest */
public class SimplePickerConfiguration implements Parcelable {
    public static final Creator<SimplePickerConfiguration> CREATOR = new C07481();
    public final boolean f11700a;
    public final SupportedMediaType f11701b;
    public final boolean f11702c;
    public final ImmutableList<MediaItem> f11703d;
    public final SimplePickerSource f11704e;
    public final boolean f11705f;
    private final boolean f11706g;
    public final boolean f11707h;
    public final boolean f11708i;
    public final boolean f11709j;
    private final boolean f11710k;
    public final boolean f11711l;
    private final boolean f11712m;
    private final boolean f11713n;
    public final boolean f11714o;
    private final boolean f11715p;
    public final int f11716q;
    public final int f11717r;
    public final boolean f11718s;
    public final int f11719t;
    public final int f11720u;
    public final boolean f11721v;

    /* compiled from: latest */
    final class C07481 implements Creator<SimplePickerConfiguration> {
        C07481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePickerConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePickerConfiguration[i];
        }
    }

    /* compiled from: latest */
    public class Builder {
        public boolean f11678a = true;
        public SupportedMediaType f11679b = SupportedMediaType.ALL;
        public boolean f11680c = true;
        public ImmutableList<MediaItem> f11681d = RegularImmutableList.a;
        public SimplePickerSource f11682e;
        public boolean f11683f = false;
        public boolean f11684g = false;
        public boolean f11685h = false;
        public boolean f11686i = false;
        public boolean f11687j = false;
        public boolean f11688k = true;
        public boolean f11689l = true;
        public boolean f11690m = false;
        public boolean f11691n = false;
        public boolean f11692o = false;
        public boolean f11693p = false;
        public int f11694q = 0;
        public int f11695r = 0;
        public boolean f11696s = false;
        public int f11697t = 0;
        public int f11698u = 0;
        public boolean f11699v = false;

        public final Builder m18363m() {
            this.f11685h = true;
            return this;
        }

        public final Builder m18362a(int i, int i2) {
            boolean z = i >= 0 && (i2 >= i || i2 == 0);
            Preconditions.checkArgument(z, "min >= 0 AND (max >= min OR max == NO_MAX)");
            this.f11694q = i;
            this.f11695r = i2;
            return this;
        }
    }

    public final boolean m18364d() {
        return this.f11713n;
    }

    public final boolean m18365e() {
        return this.f11714o;
    }

    public final boolean m18366f() {
        return this.f11715p;
    }

    public final SupportedMediaType m18367g() {
        return this.f11701b;
    }

    public final boolean m18368i() {
        return this.f11710k;
    }

    public final boolean m18369k() {
        return this.f11716q == 0;
    }

    public SimplePickerConfiguration(Builder builder) {
        this.f11700a = builder.f11678a;
        this.f11701b = builder.f11679b;
        this.f11702c = builder.f11680c;
        this.f11703d = builder.f11681d;
        this.f11704e = builder.f11682e;
        this.f11705f = builder.f11683f;
        this.f11706g = builder.f11684g;
        this.f11707h = builder.f11685h;
        this.f11708i = builder.f11686i;
        this.f11709j = builder.f11687j;
        this.f11710k = builder.f11688k;
        this.f11711l = builder.f11689l;
        this.f11712m = builder.f11690m;
        this.f11716q = builder.f11694q;
        this.f11717r = builder.f11695r;
        this.f11713n = builder.f11691n;
        this.f11714o = builder.f11692o;
        this.f11715p = builder.f11693p;
        this.f11718s = builder.f11696s;
        this.f11719t = builder.f11697t;
        this.f11720u = builder.f11698u;
        this.f11721v = builder.f11699v;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SimplePickerConfiguration)) {
            return false;
        }
        SimplePickerConfiguration simplePickerConfiguration = (SimplePickerConfiguration) obj;
        if (this.f11700a == simplePickerConfiguration.f11700a && this.f11701b == simplePickerConfiguration.f11701b && this.f11702c == simplePickerConfiguration.f11702c && this.f11703d.equals(simplePickerConfiguration.f11703d) && this.f11704e == simplePickerConfiguration.f11704e && this.f11705f == simplePickerConfiguration.f11705f && this.f11706g == simplePickerConfiguration.f11706g && this.f11708i == simplePickerConfiguration.f11708i && this.f11709j == simplePickerConfiguration.f11709j && this.f11710k == simplePickerConfiguration.f11710k && this.f11711l == simplePickerConfiguration.f11711l && this.f11712m == simplePickerConfiguration.f11712m && this.f11716q == simplePickerConfiguration.f11716q && this.f11717r == simplePickerConfiguration.f11717r && this.f11713n == simplePickerConfiguration.f11713n && this.f11714o == simplePickerConfiguration.f11714o && this.f11715p == simplePickerConfiguration.f11715p && this.f11718s == simplePickerConfiguration.f11718s && this.f11719t == simplePickerConfiguration.f11719t && this.f11720u == simplePickerConfiguration.f11720u && this.f11721v == simplePickerConfiguration.f11721v) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f11700a), this.f11701b, Boolean.valueOf(this.f11702c), this.f11703d, this.f11704e, Boolean.valueOf(this.f11705f), Boolean.valueOf(this.f11706g), Boolean.valueOf(this.f11708i), Boolean.valueOf(this.f11709j), Boolean.valueOf(this.f11710k), Boolean.valueOf(this.f11711l), Integer.valueOf(this.f11716q), Integer.valueOf(this.f11717r), Boolean.valueOf(this.f11713n), Boolean.valueOf(this.f11714o), Boolean.valueOf(this.f11715p), Boolean.valueOf(this.f11718s), Integer.valueOf(this.f11719t), Integer.valueOf(this.f11720u), Boolean.valueOf(this.f11721v)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f11700a);
        parcel.writeInt(this.f11701b.ordinal());
        ParcelUtil.a(parcel, this.f11702c);
        parcel.writeList(this.f11703d);
        parcel.writeInt(this.f11704e.ordinal());
        ParcelUtil.a(parcel, this.f11705f);
        ParcelUtil.a(parcel, this.f11706g);
        ParcelUtil.a(parcel, this.f11707h);
        ParcelUtil.a(parcel, this.f11708i);
        ParcelUtil.a(parcel, this.f11709j);
        ParcelUtil.a(parcel, this.f11710k);
        ParcelUtil.a(parcel, this.f11711l);
        ParcelUtil.a(parcel, this.f11712m);
        parcel.writeInt(this.f11716q);
        parcel.writeInt(this.f11717r);
        ParcelUtil.a(parcel, this.f11713n);
        ParcelUtil.a(parcel, this.f11714o);
        ParcelUtil.a(parcel, this.f11715p);
        ParcelUtil.a(parcel, this.f11718s);
        parcel.writeInt(this.f11719t);
        parcel.writeInt(this.f11720u);
        ParcelUtil.a(parcel, this.f11721v);
    }

    public SimplePickerConfiguration(Parcel parcel) {
        this.f11700a = ParcelUtil.a(parcel);
        this.f11701b = SupportedMediaType.values()[parcel.readInt()];
        this.f11702c = ParcelUtil.a(parcel);
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, MediaItem.class.getClassLoader());
        this.f11703d = ImmutableList.copyOf(arrayList);
        this.f11704e = SimplePickerSource.values()[parcel.readInt()];
        this.f11705f = ParcelUtil.a(parcel);
        this.f11706g = ParcelUtil.a(parcel);
        this.f11707h = ParcelUtil.a(parcel);
        this.f11708i = ParcelUtil.a(parcel);
        this.f11709j = ParcelUtil.a(parcel);
        this.f11710k = ParcelUtil.a(parcel);
        this.f11711l = ParcelUtil.a(parcel);
        this.f11712m = ParcelUtil.a(parcel);
        this.f11716q = parcel.readInt();
        this.f11717r = parcel.readInt();
        this.f11713n = ParcelUtil.a(parcel);
        this.f11714o = ParcelUtil.a(parcel);
        this.f11715p = ParcelUtil.a(parcel);
        this.f11718s = ParcelUtil.a(parcel);
        this.f11719t = parcel.readInt();
        this.f11720u = parcel.readInt();
        this.f11721v = ParcelUtil.a(parcel);
    }
}
