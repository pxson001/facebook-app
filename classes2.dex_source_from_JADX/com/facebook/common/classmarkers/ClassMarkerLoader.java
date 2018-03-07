package com.facebook.common.classmarkers;

import android.util.Log;

/* compiled from: last_published_post_time */
public final class ClassMarkerLoader {
    private static final String TAG = ClassMarkerLoader.class.getSimpleName();

    private ClassMarkerLoader() {
    }

    public static void loadIsColdStartRunMarker() {
        loadClass("com.facebook.common.classmarkers.IsColdStartRun");
    }

    public static void loadIsNotColdStartRunMarker() {
        loadClass("com.facebook.common.classmarkers.IsNotColdStartRun");
    }

    public static void loadClass(String str) {
        try {
            Class.forName(str);
            Log.v(TAG, String.format("Class %s was loaded", new Object[]{str}));
        } catch (Throwable e) {
            Log.e(TAG, String.format("Class %s not found", new Object[]{str}), e);
        }
    }
}
