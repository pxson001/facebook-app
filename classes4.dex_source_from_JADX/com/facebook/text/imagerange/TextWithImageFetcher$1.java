package com.facebook.text.imagerange;

import android.net.Uri;
import com.facebook.ui.images.fetch.FetchedImage;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: end_time */
class TextWithImageFetcher$1 implements FutureCallback<FetchedImage> {
    final /* synthetic */ Uri f13022a;
    final /* synthetic */ TextWithImageFetcher f13023b;

    TextWithImageFetcher$1(TextWithImageFetcher textWithImageFetcher, Uri uri) {
        this.f13023b = textWithImageFetcher;
        this.f13022a = uri;
    }

    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
    }

    public void onFailure(Throwable th) {
        this.f13023b.c.a("minutiae_single_icon_fetch", "failure while fetching single icon. Uri: " + this.f13022a, th);
    }
}
