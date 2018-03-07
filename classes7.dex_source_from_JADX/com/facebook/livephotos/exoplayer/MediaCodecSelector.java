package com.facebook.livephotos.exoplayer;

import android.media.MediaCodecInfo.CodecCapabilities;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.util.Util;

/* compiled from: paint_map */
public interface MediaCodecSelector {
    public static final MediaCodecSelector f6800a = new C06151();

    /* compiled from: paint_map */
    final class C06151 implements MediaCodecSelector {
        C06151() {
        }

        public final String mo392a() {
            return "OMX.google.raw.decoder";
        }

        public final DecoderInfo mo391a(String str, boolean z) {
            DecoderInfo decoderInfo;
            Pair b = MediaCodecUtil.m8716b(str, z);
            if (b == null) {
                decoderInfo = null;
            } else {
                decoderInfo = new DecoderInfo((String) b.first, Util.f7736a >= 19 ? ((CodecCapabilities) b.second).isFeatureSupported("adaptive-playback") : false);
            }
            return decoderInfo;
        }
    }

    DecoderInfo mo391a(String str, boolean z);

    String mo392a();
}
