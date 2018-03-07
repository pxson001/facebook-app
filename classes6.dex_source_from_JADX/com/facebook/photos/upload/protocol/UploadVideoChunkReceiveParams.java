package com.facebook.photos.upload.protocol;

import com.facebook.photos.upload.uploaders.UploadAssetSegment;
import com.google.common.base.Strings;

/* compiled from: generic_map_ls_upsell_result */
public class UploadVideoChunkReceiveParams {
    private final String f14177a;
    private final long f14178b;
    public final long f14179c;
    private final long f14180d;
    private final long f14181e;
    private final String f14182f;
    private final String f14183g;
    private final float f14184h;
    private final boolean f14185i;
    private final long f14186j;
    private final long f14187k;
    private final UploadAssetSegment f14188l;
    private final String f14189m;

    public UploadVideoChunkReceiveParams(long j, long j2, long j3, long j4, String str, String str2, String str3, float f, boolean z, long j5, long j6, UploadAssetSegment uploadAssetSegment, String str4) {
        this.f14177a = str;
        this.f14178b = j;
        this.f14179c = j2;
        this.f14180d = j3;
        this.f14181e = j4;
        this.f14182f = str2;
        this.f14183g = str3;
        this.f14184h = f;
        this.f14185i = z;
        this.f14186j = j5;
        this.f14187k = j6;
        this.f14188l = uploadAssetSegment;
        this.f14189m = str4;
    }

    public final long m21847a() {
        return this.f14178b;
    }

    public final long m21848b() {
        return this.f14179c;
    }

    public final long m21849c() {
        return this.f14180d;
    }

    public final long m21850d() {
        return this.f14181e;
    }

    public final String m21851e() {
        return this.f14182f;
    }

    public final String m21852f() {
        return this.f14183g;
    }

    public final String m21853g() {
        return this.f14177a;
    }

    public final float m21854h() {
        return this.f14184h;
    }

    public final boolean m21855i() {
        return this.f14185i;
    }

    public final long m21856j() {
        return this.f14186j;
    }

    public final long m21857k() {
        return this.f14187k;
    }

    public final UploadAssetSegment m21858l() {
        return this.f14188l;
    }

    public final String m21859m() {
        if (this.f14189m == null) {
            return "";
        }
        return this.f14189m;
    }

    public final boolean m21860n() {
        return !Strings.isNullOrEmpty(this.f14189m);
    }
}
