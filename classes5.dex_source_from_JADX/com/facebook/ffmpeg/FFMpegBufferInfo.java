package com.facebook.ffmpeg;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
/* compiled from: WWW_SEARCH_LOCAL_FEEDSTORY */
public class FFMpegBufferInfo {
    @DoNotStrip
    public int flags;
    @DoNotStrip
    public int offset;
    @DoNotStrip
    public long presentationTimeUs;
    @DoNotStrip
    public int size;

    public final void m20330a(int i, int i2, long j, int i3) {
        this.offset = i;
        this.size = i2;
        this.presentationTimeUs = j;
        this.flags = i3;
    }

    @TargetApi(16)
    public final void m20331a(BufferInfo bufferInfo) {
        this.offset = bufferInfo.offset;
        this.size = bufferInfo.size;
        this.presentationTimeUs = bufferInfo.presentationTimeUs;
        this.flags = bufferInfo.flags;
    }
}
