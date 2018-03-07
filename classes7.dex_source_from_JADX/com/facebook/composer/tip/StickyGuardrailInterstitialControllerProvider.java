package com.facebook.composer.tip;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerFragment.39;
import com.facebook.composer.activity.ComposerFragment.7;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.InlinePrivacySurveyManager;

/* compiled from: composer_group_fetch_error */
public class StickyGuardrailInterstitialControllerProvider extends AbstractAssistedProvider<StickyGuardrailInterstitialController> {
    public final StickyGuardrailInterstitialController m20995a(39 39, 7 7) {
        return new StickyGuardrailInterstitialController(ResourcesMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 3104), InlinePrivacySurveyManager.a(this), PrivacyOperationsClient.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (Context) getInstance(Context.class), AudienceEducatorManager.a(this), IdBasedProvider.a(this, 741), GatekeeperStoreImplMethodAutoProvider.a(this), 39, 7);
    }
}
