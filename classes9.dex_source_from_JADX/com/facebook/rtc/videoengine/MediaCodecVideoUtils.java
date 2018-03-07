package com.facebook.rtc.videoengine;

/* compiled from: app_section_render_style */
public class MediaCodecVideoUtils {
    public static int m19717a() {
        Object obj;
        int i = 0;
        if (MediaCodecVideoEncoder.isH264HwSupported()) {
            i = 1;
        }
        if (MediaCodecVideoEncoder.f20033d.contains("video/avc") || MediaCodecVideoEncoder.findHwEncoder("video/avc", MediaCodecVideoEncoder.f20036o, MediaCodecVideoEncoder.f20039r) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i |= 2;
        }
        if (MediaCodecVideoEncoder.isVp8HwSupported()) {
            i |= 4;
        }
        if (MediaCodecVideoEncoder.f20033d.contains("video/x-vnd.on2.vp8") || MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp8", MediaCodecVideoEncoder.f20034m, MediaCodecVideoEncoder.f20039r) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i |= 8;
        }
        if (MediaCodecVideoEncoder.isVp9HwSupported()) {
            i |= 16;
        }
        if (MediaCodecVideoEncoder.f20033d.contains("video/x-vnd.on2.vp9") || MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp9", MediaCodecVideoEncoder.f20035n, MediaCodecVideoEncoder.f20039r) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i |= 32;
        }
        if (MediaCodecVideoDecoder.isH264HwSupported()) {
            i |= 64;
        }
        if (MediaCodecVideoDecoder.isVp8HwSupported()) {
            i |= 128;
        }
        if (MediaCodecVideoDecoder.isVp9HwSupported()) {
            return i | 256;
        }
        return i;
    }
}
