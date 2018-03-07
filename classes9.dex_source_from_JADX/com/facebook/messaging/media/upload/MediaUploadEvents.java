package com.facebook.messaging.media.upload;

import android.content.Intent;
import com.facebook.ui.media.attachments.MediaResource;

/* compiled from: loading_indicator_state */
public class MediaUploadEvents {
    public static Intent m12485a(MediaResource mediaResource) {
        return m12487a("com.facebook.orca.media.upload.MEDIA_RESIZE_COMPLETE", mediaResource);
    }

    public static Intent m12486a(MediaResource mediaResource, double d) {
        return m12488a("com.facebook.orca.media.upload.MEDIA_RESIZE_PROGRESS", mediaResource, d);
    }

    public static Intent m12489b(MediaResource mediaResource) {
        return m12487a("com.facebook.orca.media.upload.MEDIA_UPLOAD_COMPLETE", mediaResource);
    }

    public static Intent m12490b(MediaResource mediaResource, double d) {
        return m12488a("com.facebook.orca.media.upload.MEDIA_UPLOAD_PROGRESS", mediaResource, d);
    }

    public static Intent m12491c(MediaResource mediaResource) {
        return m12487a("com.facebook.orca.media.upload.MEDIA_GET_FBID_COMPLETE", mediaResource);
    }

    public static Intent m12492d(MediaResource mediaResource) {
        return m12487a("com.facebook.orca.media.upload.PROCESS_MEDIA_COMPLETE", mediaResource);
    }

    private static Intent m12487a(String str, MediaResource mediaResource) {
        Intent intent = new Intent(str);
        intent.putExtra("resource", mediaResource);
        return intent;
    }

    public static Intent m12488a(String str, MediaResource mediaResource, double d) {
        Intent intent = new Intent(str);
        intent.putExtra("resource", mediaResource);
        intent.putExtra("p", d);
        return intent;
    }

    public static Intent m12484a() {
        return new Intent("com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED");
    }
}
