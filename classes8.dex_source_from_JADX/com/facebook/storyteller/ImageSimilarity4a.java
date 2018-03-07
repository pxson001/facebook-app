package com.facebook.storyteller;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.imageprocessing.ImageDupeDetector;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: mediaItem is null */
public class ImageSimilarity4a {
    private static final String f9019a = ImageSimilarity4a.class.getSimpleName();
    private final ImageDupeDetector f9020b;

    public static ImageSimilarity4a m10746b(InjectorLike injectorLike) {
        return new ImageSimilarity4a(ImageDupeDetector.b(injectorLike));
    }

    @Inject
    ImageSimilarity4a(ImageDupeDetector imageDupeDetector) {
        this.f9020b = imageDupeDetector;
    }

    @DoNotStrip
    public float similarityScore(String str, double d, int i, boolean z, String str2, double d2, int i2, boolean z2) {
        float similarityScore = this.f9020b.similarityScore(str, d, i, z, str2, d2, i2, z2);
        Float.valueOf(similarityScore);
        return similarityScore;
    }

    public static ImageSimilarity4a m10745a(InjectorLike injectorLike) {
        return m10746b(injectorLike);
    }
}
