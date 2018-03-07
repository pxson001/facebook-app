package com.facebook.rtc.helpers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: application/vnd.wap.wmlc */
public class RtcCallStartParams implements Parcelable {
    public static final Creator<?> CREATOR = new C23321();
    public final long f19777a;
    public final long f19778b;
    public final String f19779c;
    public final String f19780d;
    public final long f19781e;
    public final boolean f19782f;
    public final String f19783g;
    public final String f19784h;
    public final String f19785i;
    public final boolean f19786j;
    public final boolean f19787k;
    public ImmutableList<String> f19788l;
    public final long f19789m;

    /* compiled from: application/vnd.wap.wmlc */
    final class C23321 implements Creator<RtcCallStartParams> {
        C23321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RtcCallStartParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RtcCallStartParams[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    RtcCallStartParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f19777a = parcel.readLong();
        this.f19778b = parcel.readLong();
        this.f19779c = parcel.readString();
        this.f19780d = parcel.readString();
        this.f19781e = parcel.readLong();
        this.f19782f = parcel.readInt() > 0;
        this.f19783g = parcel.readString();
        this.f19784h = parcel.readString();
        this.f19785i = parcel.readString();
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19786j = z;
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.f19787k = z2;
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (!arrayList.isEmpty()) {
            this.f19788l = ImmutableList.copyOf(arrayList);
        }
        this.f19789m = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.f19777a);
        parcel.writeLong(this.f19778b);
        parcel.writeString(this.f19779c);
        parcel.writeString(this.f19780d);
        parcel.writeLong(this.f19781e);
        parcel.writeInt(this.f19782f ? 1 : 0);
        parcel.writeString(this.f19783g);
        parcel.writeString(this.f19784h);
        parcel.writeString(this.f19785i);
        if (this.f19786j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f19787k) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeStringList(this.f19788l);
        parcel.writeLong(this.f19789m);
    }

    public static RtcCallStartParams m19549a(long j, String str, long j2, boolean z, String str2) {
        return new RtcCallStartParams(j, -1, null, str, j2, z, null, null, str2, false, false, 0);
    }

    public static RtcCallStartParams m19550a(long j, String str, long j2, boolean z, String str2, String str3) {
        return new RtcCallStartParams(j, -1, null, str, j2, z, str3, null, str2, false, false, 0);
    }

    public static RtcCallStartParams m19552a(RtcCallStartParams rtcCallStartParams, String str) {
        return new RtcCallStartParams(rtcCallStartParams.f19777a, rtcCallStartParams.f19778b, rtcCallStartParams.f19779c, str, rtcCallStartParams.f19781e, rtcCallStartParams.f19782f, rtcCallStartParams.f19783g, rtcCallStartParams.f19784h, rtcCallStartParams.f19785i, rtcCallStartParams.f19786j, rtcCallStartParams.f19787k, rtcCallStartParams.f19789m);
    }

    public static RtcCallStartParams m19551a(long j, String str, boolean z, boolean z2) {
        return new RtcCallStartParams(j, -1, null, str, 0, z, null, null, "", false, z2, 0);
    }

    public static RtcCallStartParams m19553a(String str, String str2, boolean z, String str3) {
        return new RtcCallStartParams(0, -1, null, str3, 0, z, str, str2, "", false, false, 0);
    }

    public static RtcCallStartParams m19548a(long j, long j2, String str, String str2, boolean z) {
        return new RtcCallStartParams(j, j2, str, z ? "instant_video_chat_head" : "instant_video", 0, true, null, null, str2, true, false, 0);
    }

    private RtcCallStartParams(long j, long j2, String str, String str2, long j3, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, long j4) {
        this.f19777a = j;
        this.f19778b = j2;
        this.f19779c = str;
        this.f19780d = str2;
        this.f19781e = j3;
        this.f19782f = z;
        this.f19783g = str3;
        this.f19784h = str4;
        this.f19785i = str5;
        this.f19786j = z2;
        this.f19787k = z3;
        this.f19789m = j4;
    }

    public final boolean m19554a() {
        return this.f19777a > 0 || !StringUtil.a(this.f19783g);
    }
}
