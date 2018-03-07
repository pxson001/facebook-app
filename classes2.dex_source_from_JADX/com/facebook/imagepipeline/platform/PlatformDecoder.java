package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: page/videolist?page_id=%s&source=%s */
public interface PlatformDecoder {
    CloseableReference<Bitmap> m15668a(EncodedImage encodedImage, Config config);

    CloseableReference<Bitmap> m15669a(EncodedImage encodedImage, Config config, int i);
}
