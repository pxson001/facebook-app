package com.facebook.ffmpeg;

import com.facebook.common.internal.ImmutableList;
import com.facebook.soloader.NativeLibrary;
import java.util.Arrays;

/* compiled from: mID */
public class FFMpegLib extends NativeLibrary {
    public FFMpegLib() {
        super(ImmutableList.m8975a(Arrays.asList(new String[]{"fb_ffmpeg", "fb_ffmpeg_jni"})));
    }

    public final boolean m8974d() {
        return ah_();
    }
}
