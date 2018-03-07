package com.facebook.rtc.videoengine;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.rtc.helpers.ThreadUtils;
import com.facebook.rtc.opengl.EglBase14;
import com.facebook.rtc.opengl.GlRectDrawer;
import com.facebook.rtc.opengl.GlRectDrawer.Shader;
import com.facebook.rtc.opengl.GlShader;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@DoNotStrip
/* compiled from: app_section_units */
public class MediaCodecVideoEncoder {
    private static MediaCodecVideoEncoder f20030a = null;
    private static MediaCodecVideoEncoderErrorCallback f20031b = null;
    private static int f20032c = 0;
    public static Set<String> f20033d = new HashSet();
    public static final String[] f20034m = new String[]{"OMX.qcom.", "OMX.Intel."};
    public static final String[] f20035n = new String[]{"OMX.qcom."};
    public static final String[] f20036o = new String[]{"OMX.qcom."};
    private static final String[] f20037p = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4"};
    private static final int[] f20038q = new int[]{19, 21, 2141391872, 2141391876};
    public static final int[] f20039r = new int[]{2130708361};
    @DoNotStrip
    private int colorFormat;
    private Thread f20040e;
    public MediaCodec f20041f;
    private ByteBuffer[] f20042g;
    private EglBase14 f20043h;
    private int f20044i;
    private int f20045j;
    private Surface f20046k;
    private GlRectDrawer f20047l;
    private String f20048s;
    private ByteBuffer f20049t = null;

    @DoNotStrip
    /* compiled from: app_section_units */
    class EncoderProperties {
        @DoNotStrip
        public final String codecName;
        @DoNotStrip
        public final int colorFormat;

        public EncoderProperties(String str, int i) {
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    /* compiled from: app_section_units */
    public interface MediaCodecVideoEncoderErrorCallback {
    }

    @DoNotStrip
    /* compiled from: app_section_units */
    class OutputBufferInfo {
        @DoNotStrip
        public final ByteBuffer buffer;
        @DoNotStrip
        public final int index;
        @DoNotStrip
        public final boolean isKeyFrame;
        @DoNotStrip
        public final long presentationTimestampUs;

        public OutputBufferInfo(int i, ByteBuffer byteBuffer, boolean z, long j) {
            this.index = i;
            this.buffer = byteBuffer;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j;
        }
    }

    @DoNotStrip
    public static boolean isVp8HwSupported() {
        return (f20033d.contains("video/x-vnd.on2.vp8") || findHwEncoder("video/x-vnd.on2.vp8", f20034m, f20038q) == null) ? false : true;
    }

    @DoNotStrip
    public static boolean isVp9HwSupported() {
        return (f20033d.contains("video/x-vnd.on2.vp9") || findHwEncoder("video/x-vnd.on2.vp9", f20035n, f20038q) == null) ? false : true;
    }

    @DoNotStrip
    public static boolean isH264HwSupported() {
        return (f20033d.contains("video/avc") || findHwEncoder("video/avc", f20036o, f20038q) == null) ? false : true;
    }

    @DoNotStrip
    @TargetApi(19)
    public static EncoderProperties findHwEncoder(String str, String[] strArr, int[] iArr) {
        if (VERSION.SDK_INT < 19) {
            return null;
        }
        if (str.equals("video/avc") && Arrays.asList(f20037p).contains(Build.MODEL)) {
            BLog.a("MediaCodecVideoEncoder", "Model: " + Build.MODEL + " has black listed H.264 encoder.");
            return null;
        }
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
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
                    new StringBuilder("Found candidate encoder ").append(name);
                    for (String equals2 : strArr) {
                        if (name.startsWith(equals2)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                        for (int toHexString : capabilitiesForType.colorFormats) {
                            new StringBuilder("   Color: 0x").append(Integer.toHexString(toHexString));
                        }
                        for (int toHexString2 : iArr) {
                            for (int i2 : capabilitiesForType.colorFormats) {
                                if (i2 == toHexString2) {
                                    new StringBuilder("Found target encoder for mime ").append(str).append(" : ").append(name).append(". Color: 0x").append(Integer.toHexString(i2));
                                    return new EncoderProperties(name, i2);
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
    private void checkOnMediaCodecThread() {
    }

    @DoNotStrip
    @TargetApi(19)
    static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e) {
            return null;
        }
    }

    @DoNotStrip
    @TargetApi(19)
    boolean initEncode(String str, int i, int i2, int i3, int i4) {
        int i5 = 100;
        EncoderProperties encoderProperties = null;
        new StringBuilder("Java initEncode: ").append(str).append(" : ").append(i).append(" x ").append(i2).append(". @ ").append(i3).append(" kbps. Fps: ").append(i4).append(". Encode from texture : false");
        this.f20044i = i;
        this.f20045j = i2;
        if (this.f20040e != null) {
            throw new RuntimeException("Forgot to release()?");
        }
        if (str.equals("video/x-vnd.on2.vp8")) {
            encoderProperties = findHwEncoder("video/x-vnd.on2.vp8", f20034m, f20038q);
        } else if (str.equals("video/x-vnd.on2.vp9")) {
            encoderProperties = findHwEncoder("video/x-vnd.on2.vp9", f20035n, f20038q);
        } else if (str.equals("video/avc")) {
            encoderProperties = findHwEncoder("video/avc", f20036o, f20038q);
            i5 = 20;
        } else {
            i5 = 0;
        }
        if (encoderProperties == null) {
            throw new RuntimeException("Can not find HW encoder for " + str);
        }
        f20030a = this;
        this.colorFormat = encoderProperties.colorFormat;
        new StringBuilder("Color format: ").append(this.colorFormat);
        this.f20040e = Thread.currentThread();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
            createVideoFormat.setInteger("bitrate", i3 * 1000);
            createVideoFormat.setInteger("bitrate-mode", 2);
            createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
            createVideoFormat.setInteger("frame-rate", i4);
            createVideoFormat.setInteger("i-frame-interval", i5);
            new StringBuilder("  Format: ").append(createVideoFormat);
            this.f20041f = createByCodecName(encoderProperties.codecName);
            this.f20048s = str;
            if (this.f20041f == null) {
                BLog.b("MediaCodecVideoEncoder", "Can not create media encoder");
                return false;
            }
            this.f20041f.configure(createVideoFormat, null, null, 1);
            this.f20041f.start();
            this.f20042g = this.f20041f.getOutputBuffers();
            new StringBuilder("Output buffers: ").append(this.f20042g.length);
            return true;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoEncoder", "initEncode failed", e);
            return false;
        }
    }

    @DoNotStrip
    @TargetApi(19)
    ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.f20041f.getInputBuffers();
        new StringBuilder("Input buffers: ").append(inputBuffers.length);
        return inputBuffers;
    }

    @DoNotStrip
    @TargetApi(19)
    boolean encodeBuffer(boolean z, int i, int i2, long j) {
        checkOnMediaCodecThread();
        if (z) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.f20041f.setParameters(bundle);
            } catch (Throwable e) {
                BLog.b("MediaCodecVideoEncoder", "encodeBuffer failed", e);
                return false;
            }
        }
        this.f20041f.queueInputBuffer(i, 0, i2, j, 0);
        return true;
    }

    @DoNotStrip
    @TargetApi(19)
    boolean encodeTexture(boolean z, int i, float[] fArr, long j) {
        checkOnMediaCodecThread();
        if (z) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.f20041f.setParameters(bundle);
            } catch (Throwable e) {
                BLog.b("MediaCodecVideoEncoder", "encodeTexture failed", e);
                return false;
            }
        }
        this.f20043h.m19581b();
        GLES20.glClear(16384);
        this.f20047l.m19592a(i, fArr, 0, 0, this.f20044i, this.f20045j);
        this.f20043h.m19580a(TimeUnit.MICROSECONDS.toNanos(j));
        return true;
    }

    @DoNotStrip
    @TargetApi(19)
    void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ MediaCodecVideoEncoder f20029b;

            public void run() {
                try {
                    this.f20029b.f20041f.stop();
                    this.f20029b.f20041f.release();
                } catch (Throwable e) {
                    BLog.b("MediaCodecVideoEncoder", "Media encoder release failed", e);
                }
                countDownLatch.countDown();
            }
        }, -666517034).start();
        if (!ThreadUtils.m19556a(countDownLatch, 5000)) {
            BLog.b("MediaCodecVideoEncoder", "Media encoder release timeout");
            f20032c++;
            if (f20031b != null) {
                BLog.b("MediaCodecVideoEncoder", "Invoke codec error callback. Errors: " + f20032c);
            }
        }
        this.f20041f = null;
        this.f20040e = null;
        if (this.f20047l != null) {
            GlRectDrawer glRectDrawer = this.f20047l;
            for (Shader shader : glRectDrawer.f19873c.values()) {
                GlShader glShader = shader.f19869a;
                if (glShader.f19874a != -1) {
                    GLES20.glDeleteProgram(glShader.f19874a);
                    glShader.f19874a = -1;
                }
            }
            glRectDrawer.f19873c.clear();
            this.f20047l = null;
        }
        if (this.f20043h != null) {
            this.f20043h.m19579a();
            this.f20043h = null;
        }
        if (this.f20046k != null) {
            this.f20046k.release();
            this.f20046k = null;
        }
        f20030a = null;
    }

    @DoNotStrip
    @TargetApi(19)
    private boolean setRates(int i, int i2) {
        checkOnMediaCodecThread();
        new StringBuilder("setRates: ").append(i).append(" kbps. Fps: ").append(i2);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i * 1000);
            this.f20041f.setParameters(bundle);
            return true;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoEncoder", "setRates failed", e);
            return false;
        }
    }

    @DoNotStrip
    @TargetApi(19)
    int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.f20041f.dequeueInputBuffer(0);
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoEncoder", "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    @DoNotStrip
    @TargetApi(19)
    OutputBufferInfo dequeueOutputBuffer() {
        boolean z = true;
        checkOnMediaCodecThread();
        try {
            BufferInfo bufferInfo = new BufferInfo();
            int dequeueOutputBuffer = this.f20041f.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    new StringBuilder("Config frame generated. Offset: ").append(bufferInfo.offset).append(". Size: ").append(bufferInfo.size);
                    this.f20049t = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.f20042g[dequeueOutputBuffer].position(bufferInfo.offset);
                    this.f20042g[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                    this.f20049t.put(this.f20042g[dequeueOutputBuffer]);
                    this.f20041f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.f20041f.dequeueOutputBuffer(bufferInfo, 0);
                }
            }
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer duplicate = this.f20042g[dequeueOutputBuffer].duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                if ((bufferInfo.flags & 1) == 0) {
                    z = false;
                }
                if (!z || !this.f20048s.equals("video/avc")) {
                    return new OutputBufferInfo(dequeueOutputBuffer, duplicate.slice(), z, bufferInfo.presentationTimeUs);
                }
                new StringBuilder("Appending config frame of size ").append(this.f20049t.capacity()).append(" to output buffer with offset ").append(bufferInfo.offset).append(", size ").append(bufferInfo.size);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f20049t.capacity() + bufferInfo.size);
                this.f20049t.rewind();
                allocateDirect.put(this.f20049t);
                allocateDirect.put(duplicate);
                allocateDirect.position(0);
                return new OutputBufferInfo(dequeueOutputBuffer, allocateDirect, true, bufferInfo.presentationTimeUs);
            } else if (dequeueOutputBuffer == -3) {
                this.f20042g = this.f20041f.getOutputBuffers();
                return dequeueOutputBuffer();
            } else if (dequeueOutputBuffer == -2) {
                return dequeueOutputBuffer();
            } else {
                if (dequeueOutputBuffer == -1) {
                    return null;
                }
                throw new RuntimeException("dequeueOutputBuffer: " + dequeueOutputBuffer);
            }
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoEncoder", "dequeueOutputBuffer failed", e);
            return new OutputBufferInfo(-1, null, false, -1);
        }
    }

    @DoNotStrip
    @TargetApi(19)
    boolean releaseOutputBuffer(int i) {
        checkOnMediaCodecThread();
        try {
            this.f20041f.releaseOutputBuffer(i, false);
            return true;
        } catch (Throwable e) {
            BLog.b("MediaCodecVideoEncoder", "releaseOutputBuffer failed", e);
            return false;
        }
    }
}
