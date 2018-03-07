package com.facebook.rtc.videoengine;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.rtc.helpers.ThreadUtils;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@DoNotStrip
/* compiled from: appcenter.* */
class MediaCodecVideoDecoder {
    private static int f20016c = 0;
    private static final String[] f20017f = new String[]{"OMX.qcom.", "OMX.Nvidia.", "OMX.Exynos.", "OMX.Intel."};
    private static final String[] f20018g = new String[]{"OMX.google."};
    private static final String[] f20019h = new String[]{"OMX.qcom.", "OMX.Exynos."};
    private static final String[] f20020i = new String[]{"OMX.qcom."};
    private static final String[] f20021j = new String[]{"OMX.google."};
    private static final List<Integer> f20022k = Arrays.asList(new Integer[]{Integer.valueOf(19), Integer.valueOf(21), Integer.valueOf(2141391872), Integer.valueOf(2141391876)});
    private boolean f20023a = false;
    public MediaCodec f20024b;
    private ByteBuffer[] f20025d;
    private ByteBuffer[] f20026e;
    private DecoderProperties f20027l = null;
    @DoNotStrip
    private int mColorFormat;
    @DoNotStrip
    private int mHeight;
    @DoNotStrip
    private ByteBuffer mInputBuffer;
    @DoNotStrip
    private ByteBuffer mOutputBuffer;
    @DoNotStrip
    private int mSliceHeight;
    @DoNotStrip
    private int mStride;
    @DoNotStrip
    private int mWidth;

    @DoNotStrip
    /* compiled from: appcenter.* */
    class DecoderOutputBufferInfo {
        @DoNotStrip
        private final int mIndex;
        @DoNotStrip
        private final int mOffset;
        @DoNotStrip
        private final int mSize;

        public DecoderOutputBufferInfo(int i, int i2, int i3) {
            this.mIndex = i;
            this.mOffset = i2;
            this.mSize = i3;
        }
    }

    /* compiled from: appcenter.* */
    class DecoderProperties {
        public final String f20014a;
        public final int f20015b;

        public DecoderProperties(String str, int i) {
            this.f20014a = str;
            this.f20015b = i;
        }
    }

    @DoNotStrip
    private MediaCodecVideoDecoder() {
    }

    @TargetApi(16)
    private static DecoderProperties m19716a(String str, String[] strArr) {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String name;
                for (String equals : codecInfoAt.getSupportedTypes()) {
                    if (equals.equals(str)) {
                        name = codecInfoAt.getName();
                        break;
                    }
                }
                name = null;
                if (name != null) {
                    Object obj;
                    for (String equals2 : strArr) {
                        if (name.startsWith(equals2)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        int intValue;
                        CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                        for (int toHexString : capabilitiesForType.colorFormats) {
                            Integer.toHexString(toHexString);
                        }
                        for (Integer intValue2 : f20022k) {
                            intValue = intValue2.intValue();
                            for (int i2 : capabilitiesForType.colorFormats) {
                                if (i2 == intValue) {
                                    Integer.toHexString(i2);
                                    return new DecoderProperties(name, i2);
                                }
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    @DoNotStrip
    public static boolean isVp8HwSupported() {
        return m19716a("video/x-vnd.on2.vp8", f20017f) != null;
    }

    @DoNotStrip
    public static boolean isVp9HwSupported() {
        return m19716a("video/x-vnd.on2.vp9", f20019h) != null;
    }

    @DoNotStrip
    public static boolean isH264HwSupported() {
        return m19716a("video/avc", f20020i) != null;
    }

    @DoNotStrip
    @TargetApi(16)
    private boolean initDecode(String str, int i, int i2, boolean z) {
        Throwable e;
        new StringBuilder("Java initDecode: ").append(str).append(" : ").append(i).append(" x ").append(i2);
        if (f20016c > 3) {
            BLog.b("MediaCodecVideoDecoder", "MediaCodec has irrecoverably failed too many times: %d", new Object[]{Integer.valueOf(f20016c)});
            return false;
        } else if (VERSION.SDK_INT < 16) {
            return false;
        } else {
            if (this.f20023a) {
                BLog.b("MediaCodecVideoDecoder", "Already inited, forgot to release?");
                return false;
            }
            String[] strArr;
            if (str.equals("video/x-vnd.on2.vp8")) {
                strArr = z ? f20018g : f20017f;
            } else if (str.equals("video/avc")) {
                strArr = z ? f20021j : f20020i;
            } else {
                throw new IllegalArgumentException("Non supported codec " + str);
            }
            this.f20027l = m19716a(str, strArr);
            if (this.f20027l == null) {
                BLog.b("MediaCodecVideoDecoder", "Cannot find HW decoder for %s.", new Object[]{str});
                return false;
            }
            try {
                this.mWidth = i;
                this.mHeight = i2;
                this.mStride = i;
                this.mSliceHeight = i2;
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
                createVideoFormat.setInteger("color-format", this.f20027l.f20015b);
                this.f20024b = MediaCodec.createByCodecName(this.f20027l.f20014a);
                if (this.f20024b == null) {
                    return false;
                }
                this.f20024b.configure(createVideoFormat, null, null, 0);
                this.f20024b.start();
                this.mColorFormat = this.f20027l.f20015b;
                this.f20026e = this.f20024b.getOutputBuffers();
                this.f20025d = this.f20024b.getInputBuffers();
                this.f20023a = true;
                return true;
            } catch (IllegalStateException e2) {
                e = e2;
                BLog.b("MediaCodecVideoDecoder", "initDecode failed", e);
                return false;
            } catch (IOException e3) {
                e = e3;
                BLog.b("MediaCodecVideoDecoder", "initDecode failed", e);
                return false;
            }
        }
    }

    @DoNotStrip
    @TargetApi(16)
    private void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ MediaCodecVideoDecoder f20013b;

            public void run() {
                try {
                    this.f20013b.f20024b.stop();
                    this.f20013b.f20024b.release();
                } catch (Throwable e) {
                    BLog.b("MediaCodecVideoDecoder", "Media decoder release failed", e);
                }
                countDownLatch.countDown();
            }
        }, 621153951).start();
        if (!ThreadUtils.m19556a(countDownLatch, 5000)) {
            BLog.b("MediaCodecVideoDecoder", "Media decoder release timeout");
            f20016c++;
        }
        this.f20024b = null;
        this.f20023a = false;
    }

    @DoNotStrip
    @TargetApi(16)
    private int dequeueInputBuffer() {
        try {
            int dequeueInputBuffer = this.f20024b.dequeueInputBuffer(500000);
            this.mInputBuffer = null;
            if (dequeueInputBuffer < 0) {
                return dequeueInputBuffer;
            }
            if (VERSION.SDK_INT >= 21) {
                this.mInputBuffer = this.f20024b.getInputBuffer(dequeueInputBuffer);
                return dequeueInputBuffer;
            }
            this.mInputBuffer = this.f20025d[dequeueInputBuffer];
            return dequeueInputBuffer;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoDecoder", "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    @DoNotStrip
    @TargetApi(16)
    private boolean queueInputBuffer(int i, int i2, long j) {
        try {
            this.mInputBuffer.position(0);
            this.mInputBuffer.limit(i2);
            this.f20024b.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoDecoder", "decode failed", e);
            return false;
        }
    }

    @DoNotStrip
    @TargetApi(16)
    private DecoderOutputBufferInfo dequeueOutputBuffer(int i) {
        this.mOutputBuffer = null;
        try {
            BufferInfo bufferInfo = new BufferInfo();
            int dequeueOutputBuffer = this.f20024b.dequeueOutputBuffer(bufferInfo, (long) i);
            while (true) {
                if (dequeueOutputBuffer != -3 && dequeueOutputBuffer != -2) {
                    break;
                }
                if (dequeueOutputBuffer == -3) {
                    if (VERSION.SDK_INT < 21) {
                        this.f20026e = this.f20024b.getOutputBuffers();
                        Integer.valueOf(this.f20026e.length);
                    }
                } else if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f20024b.getOutputFormat();
                    this.mWidth = outputFormat.getInteger("width");
                    this.mHeight = outputFormat.getInteger("height");
                    if (outputFormat.containsKey("color-format")) {
                        this.mColorFormat = outputFormat.getInteger("color-format");
                        Integer.valueOf(this.mColorFormat);
                        if (!f20022k.contains(Integer.valueOf(this.mColorFormat))) {
                            throw new IllegalStateException("Non supported color format" + this.mColorFormat);
                        }
                    }
                    if (outputFormat.containsKey("stride")) {
                        this.mStride = outputFormat.getInteger("stride");
                    }
                    if (outputFormat.containsKey("slice-height")) {
                        this.mSliceHeight = outputFormat.getInteger("slice-height");
                    }
                    this.mStride = Math.max(this.mWidth, this.mStride);
                    this.mSliceHeight = Math.max(this.mHeight, this.mSliceHeight);
                } else {
                    continue;
                }
                dequeueOutputBuffer = this.f20024b.dequeueOutputBuffer(bufferInfo, (long) i);
            }
            if (dequeueOutputBuffer < 0) {
                return null;
            }
            if (VERSION.SDK_INT >= 21) {
                this.mOutputBuffer = this.f20024b.getOutputBuffer(dequeueOutputBuffer);
            } else {
                this.mOutputBuffer = this.f20026e[dequeueOutputBuffer];
            }
            return new DecoderOutputBufferInfo(dequeueOutputBuffer, bufferInfo.offset, bufferInfo.size);
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoDecoder", "dequeueOutputBuffer failed", e);
            return null;
        }
    }

    @DoNotStrip
    @TargetApi(16)
    private boolean releaseOutputBuffer(int i) {
        if (this.f20024b == null) {
            BLog.b("MediaCodecVideoDecoder", "mMediaCodec is null when release.");
            return false;
        }
        try {
            this.f20024b.releaseOutputBuffer(i, false);
            return true;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoDecoder", "releaseOutputBuffer failed", e);
            return false;
        }
    }
}
