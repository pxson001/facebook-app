package com.facebook.video.server;

import android.net.Uri;
import com.google.common.base.Strings;

/* compiled from: oxygen_map_tree_compaction_time */
public class VideoMimes {
    public static String m6001a(Uri uri) {
        Uri e = VideoServer.e(uri);
        if (e == null) {
            return "unknown";
        }
        String lastPathSegment = e.getLastPathSegment();
        if (Strings.isNullOrEmpty(lastPathSegment)) {
            return null;
        }
        if (lastPathSegment.contains(".webm")) {
            return "vp9";
        }
        if (lastPathSegment.contains(".mp4")) {
            return "mp4";
        }
        if (lastPathSegment.contains(".mpd")) {
            return "dash";
        }
        if (lastPathSegment.contains(".m3u8") || lastPathSegment.contains(".m3u")) {
            return "hls";
        }
        return "unknown";
    }
}
