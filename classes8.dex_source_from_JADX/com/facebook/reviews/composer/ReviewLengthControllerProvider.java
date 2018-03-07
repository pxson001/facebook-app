package com.facebook.reviews.composer;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.reviews.analytics.ReviewsLogger;

/* compiled from: promotion_feed_story */
public class ReviewLengthControllerProvider extends AbstractAssistedProvider<ReviewLengthController> {
    public final <DataProvider extends ProvidesTextWithEntities> ReviewLengthController<DataProvider> m4869a(DataProvider dataProvider, String str, String str2) {
        return new ReviewLengthController(dataProvider, str, str2, ResourcesMethodAutoProvider.a(this), ReviewsLogger.a(this));
    }
}
