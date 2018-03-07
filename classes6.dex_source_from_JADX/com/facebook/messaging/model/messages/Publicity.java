package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* compiled from: upload_phase */
public class Publicity implements Parcelable {
    public static final Creator<Publicity> CREATOR = new C01001();
    public static final Publicity f2124a = new Publicity("unknown");
    public static final Publicity f2125b = new Publicity("local only");
    public static final Publicity f2126c = new Publicity("from server");
    private static final ImmutableSet<Publicity> f2127d = ImmutableSet.of(f2124a, f2125b, f2126c);
    public final String f2128e;

    /* compiled from: upload_phase */
    final class C01001 implements Creator<Publicity> {
        C01001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Publicity(parcel);
        }

        public final Object[] newArray(int i) {
            return new Publicity[i];
        }
    }

    private Publicity(String str) {
        this.f2128e = str;
    }

    public Publicity(Parcel parcel) {
        this.f2128e = parcel.readString();
    }

    public final String m3454a() {
        return this.f2128e;
    }

    public static final Publicity m3453a(String str) {
        Iterator it = f2127d.iterator();
        while (it.hasNext()) {
            Publicity publicity = (Publicity) it.next();
            if (publicity.f2128e.equals(str)) {
                return publicity;
            }
        }
        return f2124a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2128e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2128e.equals(((Publicity) obj).f2128e);
    }

    public int hashCode() {
        return this.f2128e.hashCode();
    }
}
