package com.facebook.photos.base.analytics.efficiency;

import android.net.Uri;
import com.google.common.base.Optional;

/* compiled from: ledk */
public class UriRecord {
    public final Uri f17694a;
    public final int f17695b;
    public final long f17696c;
    public final Optional<Long> f17697d;
    public final boolean f17698e;
    public final boolean f17699f;
    public final String f17700g;
    public final String f17701h;
    public final String f17702i;

    public UriRecord(Uri uri, int i, long j, Optional<Long> optional, boolean z, boolean z2, String str, String str2, String str3) {
        this.f17694a = uri;
        this.f17695b = i;
        this.f17696c = j;
        this.f17697d = optional;
        this.f17698e = z;
        this.f17699f = z2;
        this.f17700g = str;
        this.f17701h = str2;
        this.f17702i = str3;
    }

    public int hashCode() {
        return this.f17694a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UriRecord)) {
            return false;
        }
        UriRecord uriRecord = (UriRecord) obj;
        if (this.f17694a.equals(uriRecord.f17694a) && this.f17695b == uriRecord.f17695b && this.f17696c == uriRecord.f17696c && this.f17697d.equals(uriRecord.f17697d) && this.f17698e == uriRecord.f17698e && this.f17699f == uriRecord.f17699f && this.f17700g.equals(uriRecord.f17700g) && this.f17701h.equals(uriRecord.f17701h) && this.f17702i.equals(uriRecord.f17702i)) {
            return true;
        }
        return false;
    }
}
