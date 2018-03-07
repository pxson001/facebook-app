package com.facebook.video.engine;

import android.graphics.Matrix;
import com.facebook.video.engine.VideoDataSource.VideoMirroringMode;

/* compiled from: oxygen_map_tile_overlay_draw_time_ns */
public class VideoRenderUtils {
    static final Matrix f5588a = new Matrix();

    public static Matrix m6003a(int i, int i2, VideoDataSource videoDataSource) {
        float f = 1.0f;
        Matrix matrix = f5588a;
        if (VideoDataSource.f4815a.equals(videoDataSource.f4822h) && videoDataSource.f4823i != VideoMirroringMode.MIRROR_HORIZONTALLY) {
            return matrix;
        }
        float f2;
        Matrix matrix2 = new Matrix();
        int i3 = i / 2;
        int i4 = i2 / 2;
        if (VideoDataSource.f4815a.equals(videoDataSource.f4822h)) {
            f2 = 1.0f;
        } else {
            f2 = 1.0f / videoDataSource.f4822h.width();
            f = 1.0f / videoDataSource.f4822h.height();
        }
        if (videoDataSource.f4823i == VideoMirroringMode.MIRROR_HORIZONTALLY) {
            f2 *= -1.0f;
        }
        int abs = (((int) (((float) i2) * Math.abs(f))) - i2) / 2;
        int abs2 = (((int) (((float) i) * Math.abs(f2))) - i) / 2;
        matrix2.preScale(f2, f, (float) i3, (float) i4);
        matrix2.postTranslate((float) abs2, (float) abs);
        return matrix2;
    }

    public static double m6002a(int i, int i2, int i3) {
        return Math.min(((double) i) / ((double) Math.max(i2, i3)), 1.0d);
    }
}
