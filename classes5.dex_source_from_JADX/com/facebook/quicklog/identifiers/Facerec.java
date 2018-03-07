package com.facebook.quicklog.identifiers;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: cropped_area_image_width_pixels */
public class Facerec {
    public static String m10139a(int i) {
        switch (i) {
            case 1:
                return "FACEREC_SERVER_COMMUNICATION_MARKER";
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return "FACEREC_FILE_DETECTION_PERF_MARKER_NAME";
            case 3:
                return "FACEREC_BITMAP_DETECTION_PERF_MARKER_NAME";
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return "FACEREC_FRAME_DETECTION_PERF_MARKER_NAME";
            case 5:
                return "FACEREC_BITMAP_ROTATION";
            default:
                return "UNDEFINED_QPL_EVENT";
        }
    }
}
