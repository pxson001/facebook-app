package com.facebook.photos.upload.protocol;

/* compiled from: game_type */
public class UploadVideoChunkStartResponse {
    private final String f14208a;
    private final String f14209b;
    private final long f14210c;
    private final long f14211d;
    private final boolean f14212e;

    public UploadVideoChunkStartResponse(String str, String str2, long j, long j2, boolean z) {
        this.f14208a = str;
        this.f14209b = str2;
        this.f14210c = j;
        this.f14211d = j2;
        this.f14212e = z;
    }

    public final String m21874a() {
        return this.f14208a;
    }

    public final String m21875b() {
        return this.f14209b;
    }

    public final long m21876c() {
        return this.f14210c;
    }

    public final long m21877d() {
        return this.f14211d;
    }

    public final boolean m21878e() {
        return this.f14212e;
    }
}
