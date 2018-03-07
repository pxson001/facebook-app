package com.facebook.text.imagerange;

import com.facebook.common.unicode.UTF16Range;
import com.facebook.ui.images.fetch.FetchedImage;
import com.facebook.ui.images.fetch.FetchedImage.Source;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: end_time */
class TextWithImageFetcher$2 implements Function<FetchedImage, TextWithImageFetcher$IconSpanDefinition> {
    final /* synthetic */ UTF16Range f13024a;
    final /* synthetic */ TextWithImageFetcher f13025b;

    TextWithImageFetcher$2(TextWithImageFetcher textWithImageFetcher, UTF16Range uTF16Range) {
        this.f13025b = textWithImageFetcher;
        this.f13024a = uTF16Range;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        boolean z;
        FetchedImage fetchedImage = (FetchedImage) obj;
        Preconditions.checkNotNull(fetchedImage);
        if (Source.ERROR.equals(fetchedImage.f13049d)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(fetchedImage.m13903b());
        return new TextWithImageFetcher$IconSpanDefinition(fetchedImage, this.f13024a);
    }
}
