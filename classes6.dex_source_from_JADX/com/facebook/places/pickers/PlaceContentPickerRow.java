package com.facebook.places.pickers;

import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: firstPosition is invalid */
public class PlaceContentPickerRow<T> {
    public final T f14811a;
    public final long f14812b;
    public final String f14813c;
    public final Optional<String> f14814d;
    public final int f14815e;
    public final int f14816f;

    /* compiled from: firstPosition is invalid */
    public class Builder<T> {
        public T f14805a;
        public long f14806b;
        public String f14807c;
        public int f14808d = 2131624226;
        public Optional<String> f14809e = Absent.INSTANCE;
        public int f14810f = 0;

        public Builder(T t, long j, String str) {
            this.f14805a = t;
            this.f14806b = j;
            this.f14807c = str;
        }

        public final PlaceContentPickerRow<T> m22454a() {
            return new PlaceContentPickerRow(this);
        }
    }

    public PlaceContentPickerRow(Builder<T> builder) {
        this.f14811a = builder.f14805a;
        this.f14812b = builder.f14806b;
        this.f14813c = builder.f14807c;
        this.f14815e = builder.f14808d;
        this.f14814d = builder.f14809e;
        this.f14816f = builder.f14810f;
    }

    public static <T> Builder<T> m22455a(T t, long j, String str) {
        return new Builder(t, j, str);
    }
}
