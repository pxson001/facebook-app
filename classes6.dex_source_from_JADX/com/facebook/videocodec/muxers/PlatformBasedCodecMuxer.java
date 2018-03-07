package com.facebook.videocodec.muxers;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.codecs.CodecBuffer;

@TargetApi(18)
/* compiled from: retail_items */
public class PlatformBasedCodecMuxer implements CodecMuxer {
    private MediaMuxer f5558a;
    private int f5559b;
    private int f5560c;

    public static PlatformBasedCodecMuxer m8236a(InjectorLike injectorLike) {
        return new PlatformBasedCodecMuxer();
    }

    public final void mo373a(String str) {
        this.f5558a = new MediaMuxer(str, 0);
    }

    public final void mo371a(MediaFormat mediaFormat) {
        this.f5559b = this.f5558a.addTrack(mediaFormat);
    }

    public final void mo375b(MediaFormat mediaFormat) {
        this.f5560c = this.f5558a.addTrack(mediaFormat);
    }

    public final void mo372a(CodecBuffer codecBuffer) {
        this.f5558a.writeSampleData(this.f5559b, codecBuffer.mo363a(), codecBuffer.mo365b());
    }

    public final void mo376b(CodecBuffer codecBuffer) {
        this.f5558a.writeSampleData(this.f5560c, codecBuffer.mo363a(), codecBuffer.mo365b());
    }

    public final void mo369a() {
        this.f5558a.start();
    }

    public final void mo374b() {
        this.f5558a.stop();
        this.f5558a.release();
    }

    public final void mo370a(int i) {
        this.f5558a.setOrientationHint(i);
    }
}
