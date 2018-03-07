package com.facebook.videocodec.trimmer;

import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.google.common.base.Preconditions;
import java.io.File;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.permission.WRITE_CONTACTS */
public class VideoTrimmerParams {
    public final File f20439a;
    public final File f20440b;
    public final int f20441c;
    public final int f20442d;
    public final VideoOperationProgressListener f20443e;
    public final boolean f20444f;

    public VideoTrimmerParams(File file, File file2, int i, int i2, VideoOperationProgressListener videoOperationProgressListener) {
        this(file, file2, i, i2, videoOperationProgressListener, false);
    }

    public VideoTrimmerParams(File file, File file2, int i, int i2, VideoOperationProgressListener videoOperationProgressListener, boolean z) {
        boolean z2 = false;
        boolean z3 = i == -1 || i >= 0;
        Preconditions.checkArgument(z3);
        if (i2 == -2 || i2 >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f20439a = file;
        this.f20440b = file2;
        this.f20441c = i;
        this.f20442d = i2;
        this.f20443e = videoOperationProgressListener;
        this.f20444f = z;
    }
}
