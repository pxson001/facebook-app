package com.facebook.quickpromotion.asset;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import javax.annotation.Nullable;

/* compiled from: related_article_objects */
class QuickPromotionImageFetcher$1 extends BaseControllerListener {
    final /* synthetic */ QuickPromotionImageFetcher f4608a;

    QuickPromotionImageFetcher$1(QuickPromotionImageFetcher quickPromotionImageFetcher) {
        this.f4608a = quickPromotionImageFetcher;
    }

    public final void m4472a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        if (animatable != null) {
            animatable.start();
        }
    }
}
