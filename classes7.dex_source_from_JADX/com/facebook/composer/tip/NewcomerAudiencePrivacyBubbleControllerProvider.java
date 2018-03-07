package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;

/* compiled from: composer_hot_like */
public class NewcomerAudiencePrivacyBubbleControllerProvider extends AbstractAssistedProvider<NewcomerAudiencePrivacyBubbleController> {
    public static <DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> NewcomerAudiencePrivacyBubbleController<DataProvider> m20971a(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider) {
        return new NewcomerAudiencePrivacyBubbleController(viewGroup, viewGroup2, (ComposerDataProviderImpl) dataProvider);
    }
}
