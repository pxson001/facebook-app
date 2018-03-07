package com.facebook.friendsharing.suggestedcoverphotos;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.google.common.collect.ImmutableList;

/* compiled from: ProviderMetadata{ componentName= */
public class CoverPhotoPickerScrollAdapterProvider extends AbstractAssistedProvider<CoverPhotoPickerScrollAdapter> {
    public final CoverPhotoPickerScrollAdapter m26499a(ImmutableList<String> immutableList, Context context, Fragment fragment, String str, PromptAnalytics promptAnalytics) {
        return new CoverPhotoPickerScrollAdapter(immutableList, context, fragment, str, promptAnalytics, FbDraweeControllerBuilder.b(this), (SuggestedCoverPhotoEditHelperProvider) getOnDemandAssistedProviderForStaticDi(SuggestedCoverPhotoEditHelperProvider.class), SuggestedCoverPhotosLogger.b(this));
    }
}
