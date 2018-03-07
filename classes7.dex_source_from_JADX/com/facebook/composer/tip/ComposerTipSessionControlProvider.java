package com.facebook.composer.tip;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.tip.MinutiaeNuxBubbleInterstitialController.Listener;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.DataProvider;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.StickyGuardrailCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;

/* compiled from: composer_quick_cam_tab */
public class ComposerTipSessionControlProvider extends AbstractAssistedProvider<ComposerTipSessionControl> {
    public final <DataProvider extends ProvidesAttachments & ProvidesAudienceEducatorData & ProvidesIsMinutiaeSupported & ProvidesIsPrivacyPillSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode> ComposerTipSessionControl<DataProvider> m20940a(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider, Listener listener, DataProvider dataProvider2, StickyGuardrailCallback stickyGuardrailCallback) {
        return new ComposerTipSessionControl((Context) getInstance(Context.class), InterstitialManager.a(this), (AudienceTagExpansionTipControllerProvider) getOnDemandAssistedProviderForStaticDi(AudienceTagExpansionTipControllerProvider.class), (AudienceAlignmentPrivacyBubbleControllerProvider) getOnDemandAssistedProviderForStaticDi(AudienceAlignmentPrivacyBubbleControllerProvider.class), (NewcomerAudiencePrivacyBubbleControllerProvider) getOnDemandAssistedProviderForStaticDi(NewcomerAudiencePrivacyBubbleControllerProvider.class), (InlinePrivacySurveyBubbleControllerProvider) getOnDemandAssistedProviderForStaticDi(InlinePrivacySurveyBubbleControllerProvider.class), (StickyGuardrailInterstitialControllerProvider) getOnDemandAssistedProviderForStaticDi(StickyGuardrailInterstitialControllerProvider.class), (ComposerStickerIconTipControllerProvider) getOnDemandAssistedProviderForStaticDi(ComposerStickerIconTipControllerProvider.class), viewGroup, viewGroup2, (ProvidesAttachments) dataProvider, listener, dataProvider2, stickyGuardrailCallback);
    }
}
