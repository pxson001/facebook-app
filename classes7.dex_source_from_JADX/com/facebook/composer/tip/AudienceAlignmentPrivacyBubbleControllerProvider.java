package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;

/* compiled from: composer_swipeable_frame_nux */
public class AudienceAlignmentPrivacyBubbleControllerProvider extends AbstractAssistedProvider<AudienceAlignmentPrivacyBubbleController> {
    public static <DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> AudienceAlignmentPrivacyBubbleController<DataProvider> m20927a(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider) {
        return new AudienceAlignmentPrivacyBubbleController(viewGroup, viewGroup2, (ComposerDataProviderImpl) dataProvider);
    }
}
