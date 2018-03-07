package com.facebook.widget.titlebar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: remove_video_already_seen */
public class TitleBarButtonSpec implements Parcelable {
    public static final Creator<TitleBarButtonSpec> CREATOR = new C03221();
    public static int f7574a = 0;
    public static final TitleBarButtonSpec f7575b;
    public final int f7576c;
    public final Drawable f7577d;
    public final boolean f7578e;
    public final boolean f7579f;
    public final String f7580g;
    public final int f7581h;
    public final String f7582i;
    public final int f7583j;
    public final String f7584k;
    public final int f7585l;
    public final int f7586m;
    public final boolean f7587n;
    public final int f7588o;
    public final boolean f7589p;
    public final boolean f7590q;
    public final int f7591r;
    public boolean f7592s;
    public boolean f7593t;

    /* compiled from: remove_video_already_seen */
    public class Builder {
        public int f7594a;
        public Drawable f7595b;
        public boolean f7596c;
        public boolean f7597d = true;
        public boolean f7598e;
        public String f7599f;
        public String f7600g;
        public int f7601h;
        public int f7602i = -1;
        public String f7603j;
        public boolean f7604k;
        public int f7605l;
        public int f7606m;
        public boolean f7607n;
        public int f7608o;
        public boolean f7609p = true;
        public boolean f7610q;
        public int f7611r = -1;

        public Builder(TitleBarButtonSpec titleBarButtonSpec) {
            this.f7594a = titleBarButtonSpec.f7576c;
            this.f7595b = titleBarButtonSpec.f7577d;
            this.f7596c = titleBarButtonSpec.f7578e;
            this.f7597d = titleBarButtonSpec.f7593t;
            this.f7598e = titleBarButtonSpec.f7579f;
            this.f7599f = titleBarButtonSpec.f7580g;
            this.f7600g = titleBarButtonSpec.f7582i;
            this.f7601h = titleBarButtonSpec.f7583j;
            this.f7602i = titleBarButtonSpec.f7581h;
            this.f7603j = titleBarButtonSpec.f7584k;
            this.f7604k = titleBarButtonSpec.f7592s;
            this.f7605l = titleBarButtonSpec.f7585l;
            this.f7607n = titleBarButtonSpec.f7587n;
            this.f7608o = titleBarButtonSpec.f7588o;
            this.f7609p = titleBarButtonSpec.f7589p;
            this.f7610q = titleBarButtonSpec.f7590q;
            this.f7611r = titleBarButtonSpec.f7591r;
        }

        public final TitleBarButtonSpec m12183a() {
            return new TitleBarButtonSpec(this);
        }
    }

    /* compiled from: remove_video_already_seen */
    final class C03221 implements Creator<TitleBarButtonSpec> {
        C03221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TitleBarButtonSpec(parcel);
        }

        public final Object[] newArray(int i) {
            return new TitleBarButtonSpec[i];
        }
    }

    static {
        Builder a = m12181a();
        a.f7597d = false;
        f7575b = a.m12183a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7576c);
        ParcelUtil.a(parcel, this.f7578e);
        ParcelUtil.a(parcel, this.f7579f);
        parcel.writeString(this.f7580g);
        parcel.writeInt(this.f7581h);
        parcel.writeString(this.f7582i);
        parcel.writeInt(this.f7583j);
        parcel.writeString(this.f7584k);
        parcel.writeInt(this.f7585l);
        parcel.writeInt(this.f7586m);
        ParcelUtil.a(parcel, this.f7587n);
        parcel.writeInt(this.f7588o);
        ParcelUtil.a(parcel, this.f7589p);
        ParcelUtil.a(parcel, this.f7590q);
        parcel.writeInt(this.f7591r);
        ParcelUtil.a(parcel, this.f7592s);
        ParcelUtil.a(parcel, this.f7593t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleBarButtonSpec)) {
            return false;
        }
        TitleBarButtonSpec titleBarButtonSpec = (TitleBarButtonSpec) obj;
        if (this.f7576c == titleBarButtonSpec.f7576c && Objects.equal(m12180a(this.f7577d), m12180a(titleBarButtonSpec.f7577d)) && this.f7578e == titleBarButtonSpec.f7578e && this.f7579f == titleBarButtonSpec.f7579f && Objects.equal(this.f7580g, titleBarButtonSpec.f7580g) && this.f7581h == titleBarButtonSpec.f7581h && Objects.equal(this.f7582i, titleBarButtonSpec.f7582i) && this.f7583j == titleBarButtonSpec.f7583j && Objects.equal(this.f7584k, titleBarButtonSpec.f7584k) && this.f7585l == titleBarButtonSpec.f7585l && this.f7586m == titleBarButtonSpec.f7586m && this.f7587n == titleBarButtonSpec.f7587n && this.f7588o == titleBarButtonSpec.f7588o && this.f7589p == titleBarButtonSpec.f7589p && this.f7592s == titleBarButtonSpec.f7592s && this.f7593t == titleBarButtonSpec.f7593t && this.f7590q == titleBarButtonSpec.f7590q && this.f7591r == titleBarButtonSpec.f7591r) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7576c), m12180a(this.f7577d), Boolean.valueOf(this.f7578e), Boolean.valueOf(this.f7579f), this.f7580g, Integer.valueOf(this.f7581h), this.f7582i, Integer.valueOf(this.f7583j), this.f7584k, Integer.valueOf(this.f7585l), Integer.valueOf(this.f7586m), Boolean.valueOf(this.f7587n), Integer.valueOf(this.f7588o), Boolean.valueOf(this.f7589p), Boolean.valueOf(this.f7592s), Boolean.valueOf(this.f7593t), Boolean.valueOf(this.f7590q), Integer.valueOf(this.f7591r));
    }

    private static ConstantState m12180a(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return drawable.getConstantState();
    }

    public static Builder m12181a() {
        return new Builder();
    }

    public static Builder m12182a(TitleBarButtonSpec titleBarButtonSpec) {
        return new Builder(titleBarButtonSpec);
    }

    public TitleBarButtonSpec(Builder builder) {
        this.f7576c = builder.f7594a;
        this.f7577d = builder.f7595b;
        this.f7578e = builder.f7596c;
        this.f7579f = builder.f7598e;
        this.f7580g = builder.f7599f;
        this.f7581h = builder.f7602i;
        this.f7582i = builder.f7600g;
        this.f7583j = builder.f7601h;
        this.f7584k = builder.f7603j;
        this.f7593t = builder.f7597d;
        this.f7592s = builder.f7604k;
        this.f7585l = builder.f7605l;
        this.f7586m = builder.f7606m;
        this.f7587n = builder.f7607n;
        this.f7588o = builder.f7608o;
        this.f7589p = builder.f7609p;
        this.f7590q = builder.f7610q;
        this.f7591r = builder.f7611r;
    }

    public TitleBarButtonSpec(Parcel parcel) {
        this.f7576c = parcel.readInt();
        this.f7577d = null;
        this.f7578e = ParcelUtil.a(parcel);
        this.f7579f = ParcelUtil.a(parcel);
        this.f7580g = parcel.readString();
        this.f7581h = parcel.readInt();
        this.f7582i = parcel.readString();
        this.f7583j = parcel.readInt();
        this.f7584k = parcel.readString();
        this.f7585l = parcel.readInt();
        this.f7586m = parcel.readInt();
        this.f7587n = ParcelUtil.a(parcel);
        this.f7588o = parcel.readInt();
        this.f7589p = ParcelUtil.a(parcel);
        this.f7590q = ParcelUtil.a(parcel);
        this.f7591r = parcel.readInt();
        this.f7592s = ParcelUtil.a(parcel);
        this.f7593t = ParcelUtil.a(parcel);
    }
}
