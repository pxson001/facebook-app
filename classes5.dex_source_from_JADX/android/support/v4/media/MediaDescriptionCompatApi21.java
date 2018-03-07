package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: viewer_edit_post_feature_capabilities */
public class MediaDescriptionCompatApi21 {

    /* compiled from: viewer_edit_post_feature_capabilities */
    public class Builder {
        public static void m267a(Object obj, String str) {
            ((android.media.MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void m266a(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void m268b(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void m269c(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void m263a(Object obj, Bitmap bitmap) {
            ((android.media.MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void m264a(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void m265a(Object obj, Bundle bundle) {
            ((android.media.MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static Object m262a(Object obj) {
            return ((android.media.MediaDescription.Builder) obj).build();
        }
    }

    public static String m270a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m272b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m273c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m274d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m275e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m276f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m277g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m271a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }
}
