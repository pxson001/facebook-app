package com.facebook.photos.upload.manager;

/* compiled from: graph_search_results_page_app */
/* synthetic */ class UploadManager$8 {
    static final /* synthetic */ int[] f13649a = new int[UploadManager$RequestType.values().length];

    static {
        try {
            f13649a[UploadManager$RequestType.InitialPost.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f13649a[UploadManager$RequestType.AutoRetry.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f13649a[UploadManager$RequestType.Resume.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f13649a[UploadManager$RequestType.Restore.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f13649a[UploadManager$RequestType.UserRetry.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f13649a[UploadManager$RequestType.UserRestart.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
