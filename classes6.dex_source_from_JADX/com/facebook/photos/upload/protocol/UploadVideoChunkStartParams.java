package com.facebook.photos.upload.protocol;

import com.facebook.photos.upload.uploaders.UploadAssetSegment;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Optional;

/* compiled from: gate */
public class UploadVideoChunkStartParams {
    public final long f14198a;
    private final long f14199b;
    public final String f14200c;
    public final String f14201d;
    public final ComposerAppAttribution f14202e;
    public final boolean f14203f;
    public final boolean f14204g;
    public final boolean f14205h;
    private final long f14206i;
    public final UploadAssetSegment f14207j;

    public UploadVideoChunkStartParams(long j, long j2, String str, String str2, ComposerAppAttribution composerAppAttribution, boolean z, boolean z2, Optional<Boolean> optional, Optional<Long> optional2, UploadAssetSegment uploadAssetSegment) {
        this.f14198a = j2;
        this.f14199b = j;
        this.f14200c = str;
        this.f14201d = str2;
        this.f14202e = composerAppAttribution;
        this.f14203f = z;
        this.f14204g = z2;
        this.f14205h = ((Boolean) optional.or(Boolean.valueOf(true))).booleanValue();
        this.f14206i = ((Long) optional2.or(Long.valueOf(0))).longValue();
        this.f14207j = uploadAssetSegment;
    }

    public final long m21872a() {
        return this.f14199b;
    }

    public final long m21873i() {
        return this.f14206i;
    }
}
