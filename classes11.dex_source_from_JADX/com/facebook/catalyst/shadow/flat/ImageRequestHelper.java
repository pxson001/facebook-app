package com.facebook.catalyst.shadow.flat;

import android.content.Context;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import javax.annotation.Nullable;

/* compiled from: locked-closed */
class ImageRequestHelper {
    ImageRequestHelper() {
    }

    @Nullable
    static ImageRequest m7087a(Context context, @Nullable String str) {
        if (str == null) {
            return null;
        }
        Object obj;
        ImageRequestBuilder a;
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("data:")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            a = ImageRequestBuilder.a(Uri.parse(str));
        } else {
            a = ImageRequestBuilder.a(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
        }
        return a.m();
    }
}
