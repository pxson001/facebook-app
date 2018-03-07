package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.util.Util;
import java.io.IOException;
import java.util.HashMap;

@TargetApi(16)
/* compiled from: paid_mqtt_rewrite_rules */
public final class MediaCodecUtil {
    private static final HashMap<CodecKey, Pair<String, CodecCapabilities>> f6813a = new HashMap();

    /* compiled from: paid_mqtt_rewrite_rules */
    final class CodecKey {
        public final String f6809a;
        public final boolean f6810b;

        public CodecKey(String str, boolean z) {
            this.f6809a = str;
            this.f6810b = z;
        }

        public final int hashCode() {
            return (this.f6810b ? 1231 : 1237) + (((this.f6809a == null ? 0 : this.f6809a.hashCode()) + 31) * 31);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            if (TextUtils.equals(this.f6809a, codecKey.f6809a) && this.f6810b == codecKey.f6810b) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: paid_mqtt_rewrite_rules */
    public class DecoderQueryException extends IOException {
        public DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* compiled from: paid_mqtt_rewrite_rules */
    interface MediaCodecListCompat {
        int mo393a();

        MediaCodecInfo mo394a(int i);

        boolean mo395a(String str, CodecCapabilities codecCapabilities);

        boolean mo396b();
    }

    /* compiled from: paid_mqtt_rewrite_rules */
    final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public final int mo393a() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo mo394a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean mo396b() {
            return false;
        }

        public final boolean mo395a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    @TargetApi(21)
    /* compiled from: paid_mqtt_rewrite_rules */
    final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int f6811a;
        private MediaCodecInfo[] f6812b;

        public MediaCodecListCompatV21(boolean z) {
            this.f6811a = z ? 1 : 0;
        }

        public final int mo393a() {
            m8708c();
            return this.f6812b.length;
        }

        public final MediaCodecInfo mo394a(int i) {
            m8708c();
            return this.f6812b[i];
        }

        public final boolean mo396b() {
            return true;
        }

        public final boolean mo395a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void m8708c() {
            if (this.f6812b == null) {
                this.f6812b = new MediaCodecList(this.f6811a).getCodecInfos();
            }
        }
    }

    private MediaCodecUtil() {
    }

    public static synchronized Pair<String, CodecCapabilities> m8716b(String str, boolean z) {
        Pair<String, CodecCapabilities> pair;
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z);
            if (f6813a.containsKey(codecKey)) {
                pair = (Pair) f6813a.get(codecKey);
            } else {
                pair = m8713a(codecKey, Util.f7736a >= 21 ? new MediaCodecListCompatV21(z) : new MediaCodecListCompatV16());
                if (z && pair == null && 21 <= Util.f7736a && Util.f7736a <= 23) {
                    Pair<String, CodecCapabilities> a = m8713a(codecKey, new MediaCodecListCompatV16());
                    if (a != null) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((String) a.first));
                    }
                    pair = a;
                }
            }
        }
        return pair;
    }

    private static Pair<String, CodecCapabilities> m8713a(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) {
        try {
            return m8715b(codecKey, mediaCodecListCompat);
        } catch (Throwable e) {
            throw new DecoderQueryException(e);
        }
    }

    private static Pair<String, CodecCapabilities> m8715b(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) {
        String str = codecKey.f6809a;
        int a = mediaCodecListCompat.mo393a();
        boolean b = mediaCodecListCompat.mo396b();
        for (int i = 0; i < a; i++) {
            MediaCodecInfo a2 = mediaCodecListCompat.mo394a(i);
            String name = a2.getName();
            if (m8714a(a2, name, b)) {
                String[] supportedTypes = a2.getSupportedTypes();
                for (String str2 : supportedTypes) {
                    if (str2.equalsIgnoreCase(str)) {
                        CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                        boolean a3 = mediaCodecListCompat.mo395a(codecKey.f6809a, capabilitiesForType);
                        HashMap hashMap;
                        Object obj;
                        if (b) {
                            hashMap = f6813a;
                            if (codecKey.f6810b == a3) {
                                obj = codecKey;
                            } else {
                                obj = new CodecKey(str, a3);
                            }
                            hashMap.put(obj, Pair.create(name, capabilitiesForType));
                        } else {
                            hashMap = f6813a;
                            if (codecKey.f6810b) {
                                obj = new CodecKey(str, false);
                            } else {
                                CodecKey codecKey2 = codecKey;
                            }
                            hashMap.put(obj, Pair.create(name, capabilitiesForType));
                            if (a3) {
                                f6813a.put(codecKey.f6810b ? codecKey : new CodecKey(str, true), Pair.create(name + ".secure", capabilitiesForType));
                            }
                        }
                        if (f6813a.containsKey(codecKey)) {
                            return (Pair) f6813a.get(codecKey);
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static boolean m8714a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z && str.endsWith(".secure")) {
            return false;
        }
        if ((Util.f7736a < 21 && "CIPAACDecoder".equals(str)) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str)) {
            return false;
        }
        if (Util.f7736a == 16 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (Util.f7736a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(Util.f7737b) || "protou".equals(Util.f7737b) || "C6602".equals(Util.f7737b) || "C6603".equals(Util.f7737b) || "C6606".equals(Util.f7737b) || "C6616".equals(Util.f7737b) || "L36h".equals(Util.f7737b) || "SO-02E".equals(Util.f7737b))) {
            return false;
        }
        if (Util.f7736a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(Util.f7737b) || "C1505".equals(Util.f7737b) || "C1604".equals(Util.f7737b) || "C1605".equals(Util.f7737b))) {
            return false;
        }
        if (Util.f7736a > 19 || Util.f7737b == null || ((!Util.f7737b.startsWith("d2") && !Util.f7737b.startsWith("serrano")) || !"samsung".equals(Util.f7738c) || !str.equals("OMX.SEC.vp8.dec"))) {
            return true;
        }
        return false;
    }
}
