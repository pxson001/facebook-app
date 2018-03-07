package com.facebook.ui.images.webp;

import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

@DoNotStrip
/* compiled from: search_results_thread_name */
public class AnimatedImageDecoder$TranscodedWebPImageWrapper {
    private ByteArrayOutputStream currentFrameOutputStream;
    public final int[] frameDurations;
    public final int height;
    public final boolean isAnimated;
    public final boolean isLooped;
    private List<byte[]> jpegFrames = Lists.a();
    public final int width;

    @DoNotStrip
    public AnimatedImageDecoder$TranscodedWebPImageWrapper(int i, int i2, boolean z, boolean z2, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.isAnimated = z;
        this.isLooped = z2;
        this.frameDurations = iArr;
    }

    @DoNotStrip
    public OutputStream createFrame() {
        closeCurrentFrame();
        this.currentFrameOutputStream = new ByteArrayOutputStream();
        return this.currentFrameOutputStream;
    }

    public void closeCurrentFrame() {
        if (this.currentFrameOutputStream != null) {
            this.jpegFrames.add(this.currentFrameOutputStream.toByteArray());
            this.currentFrameOutputStream = null;
        }
    }

    public List<byte[]> getJpegFrames() {
        closeCurrentFrame();
        return ImmutableList.copyOf(this.jpegFrames);
    }
}
