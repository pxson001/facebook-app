package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzi CREATOR = new zzi();
    public final int f7045a;
    public final Bundle f7046b;

    class C07951 implements Iterator<String> {
        Iterator<String> f7043a = this.f7044b.f7046b.keySet().iterator();
        final /* synthetic */ EventParams f7044b;

        C07951(EventParams eventParams) {
            this.f7044b = eventParams;
        }

        public boolean hasNext() {
            return this.f7043a.hasNext();
        }

        public Object next() {
            return (String) this.f7043a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int i, Bundle bundle) {
        this.f7045a = i;
        this.f7046b = bundle;
    }

    EventParams(Bundle bundle) {
        zzx.a(bundle);
        this.f7046b = bundle;
        this.f7045a = 1;
    }

    public final int m13065a() {
        return this.f7046b.size();
    }

    final Object m13066a(String str) {
        return this.f7046b.get(str);
    }

    public final Bundle m13067b() {
        return new Bundle(this.f7046b);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<String> iterator() {
        return new C07951(this);
    }

    public String toString() {
        return this.f7046b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7045a);
        zzb.m12243a(parcel, 2, m13067b(), false);
        zzb.m12258c(parcel, a);
    }
}
