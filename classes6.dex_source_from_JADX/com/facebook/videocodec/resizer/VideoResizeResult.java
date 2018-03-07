package com.facebook.videocodec.resizer;

import com.facebook.videocodec.policy.VideoTranscodeParams;
import java.io.File;

/* compiled from: result_canceled */
public class VideoResizeResult {
    public final File f5650a;
    public final long f5651b;
    public final long f5652c;
    public final int f5653d;
    public final int f5654e;
    public final int f5655f;
    public final int f5656g;
    public final int f5657h;
    public final int f5658i;
    public final int f5659j;
    public final int f5660k;
    public final long f5661l;

    private VideoResizeResult(File file, long j, long j2, int i, int i2, int i3, int i4, long j3, VideoTranscodeParams videoTranscodeParams) {
        this.f5650a = file;
        this.f5651b = j;
        this.f5652c = j2;
        this.f5653d = i;
        this.f5654e = i2;
        this.f5655f = i3;
        this.f5656g = i4;
        this.f5661l = j3;
        if (videoTranscodeParams == null) {
            this.f5657h = -1;
            this.f5658i = -1;
            this.f5659j = -1;
            this.f5660k = -1;
            return;
        }
        this.f5657h = videoTranscodeParams.f5577d;
        this.f5658i = videoTranscodeParams.f5578e;
        this.f5659j = videoTranscodeParams.f5583j;
        this.f5660k = videoTranscodeParams.f5584k;
    }

    public static VideoResizeResult m8275a(File file, long j, long j2, int i, int i2, int i3, int i4, long j3, VideoTranscodeParams videoTranscodeParams) {
        return new VideoResizeResult(file, j, j2, i, i2, i3, i4, j3, videoTranscodeParams);
    }
}
