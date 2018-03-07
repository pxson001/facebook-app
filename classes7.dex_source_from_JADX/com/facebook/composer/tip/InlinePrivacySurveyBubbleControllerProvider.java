package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;

/* compiled from: composer_privacy_fetch_cached_error */
public class InlinePrivacySurveyBubbleControllerProvider extends AbstractAssistedProvider<InlinePrivacySurveyBubbleController> {
    public final <DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> InlinePrivacySurveyBubbleController<DataProvider> m20953a(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider) {
        return new InlinePrivacySurveyBubbleController(IdBasedSingletonScopeProvider.b(this, 30), IdBasedProvider.a(this, 741), IdBasedSingletonScopeProvider.b(this, 494), viewGroup, viewGroup2, (ComposerDataProviderImpl) dataProvider);
    }
}
