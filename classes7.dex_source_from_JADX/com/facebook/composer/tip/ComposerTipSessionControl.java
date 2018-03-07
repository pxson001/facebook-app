package com.facebook.composer.tip;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerFragment.10;
import com.facebook.composer.activity.ComposerFragment.39;
import com.facebook.composer.activity.ComposerFragment.7;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.tip.MinutiaeNuxBubbleInterstitialController.Listener;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.DataProvider;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.StickyGuardrailCallback;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: composer_sample_content_page */
public class ComposerTipSessionControl<DataProvider extends ProvidesAttachments & ProvidesAudienceEducatorData & ProvidesIsMinutiaeSupported & ProvidesIsPrivacyPillSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode> {
    public final Context f16982a;
    public final InterstitialManager f16983b;
    private final AudienceTagExpansionTipControllerProvider f16984c;
    private final AudienceAlignmentPrivacyBubbleControllerProvider f16985d;
    private final NewcomerAudiencePrivacyBubbleControllerProvider f16986e;
    private final InlinePrivacySurveyBubbleControllerProvider f16987f;
    private final StickyGuardrailInterstitialControllerProvider f16988g;
    private final ComposerStickerIconTipControllerProvider f16989h;
    public final ViewGroup f16990i;
    private final ViewGroup f16991j;
    public final DataProvider f16992k;
    public final 10 f16993l;
    private final 39 f16994m;
    private final 7 f16995n;

    @Inject
    ComposerTipSessionControl(Context context, InterstitialManager interstitialManager, AudienceTagExpansionTipControllerProvider audienceTagExpansionTipControllerProvider, AudienceAlignmentPrivacyBubbleControllerProvider audienceAlignmentPrivacyBubbleControllerProvider, NewcomerAudiencePrivacyBubbleControllerProvider newcomerAudiencePrivacyBubbleControllerProvider, InlinePrivacySurveyBubbleControllerProvider inlinePrivacySurveyBubbleControllerProvider, StickyGuardrailInterstitialControllerProvider stickyGuardrailInterstitialControllerProvider, ComposerStickerIconTipControllerProvider composerStickerIconTipControllerProvider, @Assisted ViewGroup viewGroup, @Assisted ViewGroup viewGroup2, @Assisted DataProvider dataProvider, @Assisted Listener listener, @Assisted DataProvider dataProvider2, @Assisted StickyGuardrailCallback stickyGuardrailCallback) {
        this.f16982a = context;
        this.f16983b = interstitialManager;
        this.f16984c = audienceTagExpansionTipControllerProvider;
        this.f16985d = audienceAlignmentPrivacyBubbleControllerProvider;
        this.f16986e = newcomerAudiencePrivacyBubbleControllerProvider;
        this.f16987f = inlinePrivacySurveyBubbleControllerProvider;
        this.f16988g = stickyGuardrailInterstitialControllerProvider;
        this.f16989h = composerStickerIconTipControllerProvider;
        this.f16990i = viewGroup;
        this.f16991j = viewGroup2;
        this.f16992k = dataProvider;
        this.f16993l = listener;
        this.f16994m = dataProvider2;
        this.f16995n = stickyGuardrailCallback;
    }

    public final ImmutableSet<ComposerTip> m20939a() {
        ComposerStickerIconTipControllerProvider composerStickerIconTipControllerProvider = this.f16989h;
        ComposerStickerIconTipController composerStickerIconTipController = new ComposerStickerIconTipController(this.f16990i, TipSeenTracker.b(composerStickerIconTipControllerProvider), (Context) composerStickerIconTipControllerProvider.getInstance(Context.class));
        AudienceTagExpansionTipControllerProvider audienceTagExpansionTipControllerProvider = this.f16984c;
        return ImmutableSet.of(composerStickerIconTipController, new AudienceTagExpansionTipController((Context) audienceTagExpansionTipControllerProvider.getInstance(Context.class), TipSeenTracker.b(audienceTagExpansionTipControllerProvider), this.f16990i), AudienceAlignmentPrivacyBubbleControllerProvider.m20927a(this.f16990i, this.f16991j, this.f16992k), NewcomerAudiencePrivacyBubbleControllerProvider.m20971a(this.f16990i, this.f16991j, this.f16992k), this.f16987f.m20953a(this.f16990i, this.f16991j, this.f16992k), this.f16988g.m20995a(this.f16994m, this.f16995n), new ComposerTip[0]);
    }
}
