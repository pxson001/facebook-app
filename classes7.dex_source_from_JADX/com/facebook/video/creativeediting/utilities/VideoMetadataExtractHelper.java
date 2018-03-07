package com.facebook.video.creativeediting.utilities;

import android.media.MediaMetadataRetriever;

/* compiled from: doodle */
public class VideoMetadataExtractHelper {
    public static long m19609a(MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static float m19610b(MediaMetadataRetriever mediaMetadataRetriever) {
        int c = m19611c(mediaMetadataRetriever);
        int d = m19612d(mediaMetadataRetriever);
        if (m19613e(mediaMetadataRetriever) % 180 == 0) {
            if (d > 0) {
                return ((float) c) / ((float) d);
            }
        } else if (c > 0) {
            return ((float) d) / ((float) c);
        }
        return 1.0f;
    }

    public static int m19611c(MediaMetadataRetriever mediaMetadataRetriever) {
        return m19608a(mediaMetadataRetriever, 18);
    }

    public static int m19612d(MediaMetadataRetriever mediaMetadataRetriever) {
        return m19608a(mediaMetadataRetriever, 19);
    }

    public static int m19613e(MediaMetadataRetriever mediaMetadataRetriever) {
        return m19608a(mediaMetadataRetriever, 24);
    }

    private static int m19608a(MediaMetadataRetriever mediaMetadataRetriever, int i) {
        try {
            return Integer.parseInt(mediaMetadataRetriever.extractMetadata(i));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
