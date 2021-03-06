package com.facebook.platform.composer.privacy;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.privacy.common.ComposerAlbumPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerDisabledPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerEventPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPageAdminPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPagePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerTimelinePrivacyDelegateProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05254;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05265;

/* compiled from: resumeState */
public class PlatformComposerPrivacyControllerProvider extends AbstractAssistedProvider<PlatformComposerPrivacyController> {
    public final PlatformComposerPrivacyController m4192a(C05254 c05254, C05265 c05265) {
        return new PlatformComposerPrivacyController(c05254, c05265, (ComposerAlbumPrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerAlbumPrivacyDelegateProvider.class), (ComposerPageAdminPrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerPageAdminPrivacyDelegateProvider.class), (ComposerSelectablePrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerSelectablePrivacyDelegateProvider.class), (ComposerEventPrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerEventPrivacyDelegateProvider.class), (ComposerGroupPrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerGroupPrivacyDelegateProvider.class), (ComposerTimelinePrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerTimelinePrivacyDelegateProvider.class), (ComposerPagePrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerPagePrivacyDelegateProvider.class), (ComposerDisabledPrivacyDelegateProvider) getOnDemandAssistedProviderForStaticDi(ComposerDisabledPrivacyDelegateProvider.class), ResourcesMethodAutoProvider.a(this));
    }
}
