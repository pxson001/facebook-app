package com.facebook.bugreporter;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.os.IDeviceIdleController */
public class BugReportUploadParams {
    public String f10498a;
    public String f10499b;
    public ImmutableList<Uri> f10500c;
    ImmutableMap<String, String> f10501d;
    public ImmutableMap<String, String> f10502e;
    public ImmutableMap<String, String> f10503f;
    String f10504g;
    public String f10505h;
    String f10506i;
    public String f10507j;
    public String f10508k;
    public String f10509l;
    public String f10510m;
    public String f10511n;
    public String f10512o;
    public String f10513p;
    public BugReportSource f10514q;
    public boolean f10515r;
    public String f10516s;
    public String f10517t;

    public BugReportUploadParams(String str, String str2, ImmutableList<Uri> immutableList, ImmutableMap<String, String> immutableMap, ImmutableMap<String, String> immutableMap2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, BugReportSource bugReportSource, ImmutableMap<String, String> immutableMap3, boolean z, String str13, String str14) {
        this.f10498a = str;
        this.f10499b = str2;
        this.f10500c = immutableList;
        this.f10501d = immutableMap;
        this.f10502e = immutableMap2;
        this.f10504g = str3;
        this.f10505h = str4;
        this.f10506i = str5;
        this.f10507j = str6;
        this.f10508k = str7;
        this.f10509l = str8;
        this.f10510m = str9;
        this.f10511n = str10;
        this.f10512o = str11;
        this.f10513p = str12;
        this.f10514q = bugReportSource;
        this.f10503f = immutableMap3;
        this.f10515r = z;
        this.f10516s = str13;
        this.f10517t = str14;
    }

    public final String m18570a() {
        return this.f10498a;
    }

    public final String m18571b() {
        return this.f10499b;
    }

    public final ImmutableList<Uri> m18572c() {
        return this.f10500c;
    }

    public final ImmutableMap<String, String> m18573d() {
        return this.f10501d;
    }

    public final ImmutableMap<String, String> m18574e() {
        return this.f10502e;
    }

    public final String m18575f() {
        return this.f10504g;
    }

    public final String m18576g() {
        return this.f10505h;
    }

    public final String m18577h() {
        return this.f10506i;
    }

    public final String m18578i() {
        return this.f10507j;
    }

    public final String m18579j() {
        return this.f10508k;
    }

    @Nullable
    public final String m18580k() {
        return this.f10509l;
    }

    @Nullable
    public final String m18581l() {
        return this.f10510m;
    }

    public final String m18582m() {
        return this.f10511n;
    }

    public final String m18583n() {
        return this.f10512o;
    }

    public final String m18584o() {
        return this.f10513p;
    }

    public final BugReportSource m18585p() {
        return this.f10514q;
    }

    public final ImmutableMap<String, String> m18586q() {
        return this.f10503f;
    }

    public final boolean m18587r() {
        return this.f10515r;
    }

    public final String m18588s() {
        return this.f10516s;
    }

    public final String m18589t() {
        return this.f10517t;
    }
}
