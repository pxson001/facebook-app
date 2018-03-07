package com.facebook.video.videostreaming;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

/* compiled from: saved_videos */
public interface LiveStreamingEncoderOutputConsumer {
    void mo361a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo);

    void mo362b(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, BufferInfo bufferInfo);
}
