package com.facebook.videocodec.resizer;

import android.graphics.RectF;
import com.facebook.videocodec.base.VideoMetadata;

/* compiled from: responseData is not available */
public class VideoResizerUtils {
    public static RectF m8295a(float f, VideoMetadata videoMetadata) {
        int i;
        if (m8296c(videoMetadata)) {
            i = videoMetadata.f5482c;
        } else {
            i = videoMetadata.f5481b;
        }
        int i2 = i;
        if (m8296c(videoMetadata)) {
            i = videoMetadata.f5481b;
        } else {
            i = videoMetadata.f5482c;
        }
        int i3 = i;
        float f2 = ((float) i2) / f;
        float f3 = ((float) i3) / f;
        if (f2 < ((float) i3)) {
            float f4 = ((((float) i3) - f2) / 2.0f) / ((float) i3);
            return new RectF(0.0f, 0.0f + f4, 1.0f, 1.0f - f4);
        }
        f4 = ((((float) i2) - f3) / 2.0f) / ((float) i2);
        return new RectF(0.0f + f4, 0.0f, 1.0f - f4, 1.0f);
    }

    public static boolean m8296c(VideoMetadata videoMetadata) {
        return videoMetadata.f5483d == 90 || videoMetadata.f5483d == 270;
    }
}
