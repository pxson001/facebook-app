package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
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

/* compiled from: composer_event_undefined_privacy */
public class TipManagerProvider extends AbstractAssistedProvider<TipManager> {
    public final <DataProvider extends ProvidesAttachments & ProvidesAudienceEducatorData & ProvidesIsMinutiaeSupported & ProvidesIsPrivacyPillSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode> TipManager<DataProvider> m21011a(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider, Listener listener, DataProvider dataProvider2, StickyGuardrailCallback stickyGuardrailCallback) {
        return new TipManager(InterstitialManager.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (ComposerTipSessionControlProvider) getOnDemandAssistedProviderForStaticDi(ComposerTipSessionControlProvider.class), viewGroup, viewGroup2, (ProvidesAttachments) dataProvider, listener, dataProvider2, stickyGuardrailCallback);
    }
}
