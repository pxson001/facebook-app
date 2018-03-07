package com.facebook.composer.activity;

import android.text.SpannedString;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass41;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.capability.ComposerAlbumCapability;
import com.facebook.composer.capability.ComposerCheckinCapability;
import com.facebook.composer.capability.ComposerCustomPublishModeCapability;
import com.facebook.composer.capability.ComposerFacecastCapability;
import com.facebook.composer.capability.ComposerHeaderCapability;
import com.facebook.composer.capability.ComposerImplicitLocationCapability;
import com.facebook.composer.capability.ComposerMinutiaeCapability;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.composer.capability.ComposerPhotoCapability;
import com.facebook.composer.capability.ComposerPhotoCapability.Capability;
import com.facebook.composer.capability.ComposerPostCompositionViewCapability;
import com.facebook.composer.capability.ComposerRedSpaceCapability;
import com.facebook.composer.capability.ComposerSlideshowCapability;
import com.facebook.composer.capability.ComposerSouvenirCapability;
import com.facebook.composer.capability.ComposerTagPeopleCapability;
import com.facebook.composer.capability.ComposerTargetMenuCapability;
import com.facebook.composer.capability.ComposerTransliterationCapability;
import com.facebook.composer.controller.ComposerContentTypeController;
import com.facebook.composer.controller.ComposerSubmitEnabledController;
import com.facebook.composer.inlinesprouts.ComposerInlineSproutsCapability;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.config.application.Product;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMultimediaSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsAttachingToAlbumsGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsCheckinGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsDraftSavingGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsLiveGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsMinutiaeGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsPhotoGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsSubmitGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsTaggingPeopleGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAreAttachmentsReadOnlyGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginHasUserEditedContentGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginIsDatePickerSupportedGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginPublishButtonTextGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginShouldShowTargetSelectionGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginStatusHintGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginSurveyConstraintGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.places.features.PlacesFeatures;
import com.facebook.qe.api.QeAccessor;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: isPaused */
public class ComposerDataProviderImpl implements ProvidesAttachments, ProvidesMinutiae, ProvidesPrivacyData, ProvidesIsBackoutDraft, ProvidesIsComposerDrawn, ProvidesIsImplicitLocationSupported, ProvidesIsMultimediaSupported, ProvidesSessionId, ProvidesTargetAlbum, ProvidesTextWithEntities, ProvidesTopics, ProvidesConfiguration, ProvidesShareParams, ProvidesStickerData, ProvidesTargetData, ProvidesContentType, ProvidesLocationInfo, ProvidesTaggedUsers, ProvidesProductItemAttachment, ProvidesPublishMode, ProvidesRedSpaceValue, ProvidesPluginAllowsAttachingToAlbumsGetter, ProvidesPluginAllowsCheckinGetter, ProvidesPluginAllowsDraftSavingGetter, ProvidesPluginAllowsLiveGetter, ProvidesPluginAllowsMinutiaeGetter, ProvidesPluginAllowsPhotoGetter, ProvidesPluginAllowsSubmitGetter, ProvidesPluginAllowsTaggingPeopleGetter, ProvidesPluginAreAttachmentsReadOnlyGetter, ProvidesPluginHasUserEditedContentGetter, ProvidesPluginIsDatePickerSupportedGetter, ProvidesPluginPublishButtonTextGetter, ProvidesPluginShouldShowTargetSelectionGetter, ProvidesPluginStatusHintGetter, ProvidesPluginSurveyConstraintGetter, ProvidesPluginTitleGetter {
    private final Lazy<ComposerCheckinCapability> f6017a;
    private final Lazy<ComposerFacecastCapability> f6018b;
    private final Lazy<ComposerImplicitLocationCapability> f6019c;
    private final Lazy<ComposerMultimediaCapability> f6020d;
    private final Lazy<ComposerMinutiaeCapability> f6021e;
    private final Lazy<ComposerPhotoCapability> f6022f;
    private final Lazy<ComposerCustomPublishModeCapability> f6023g;
    public final Lazy<ComposerRedSpaceCapability> f6024h;
    public final Lazy<ComposerAlbumCapability> f6025i;
    public final Lazy<ComposerTargetMenuCapability> f6026j;
    private final Lazy<ComposerTagPeopleCapability> f6027k;
    private final Lazy<ComposerTransliterationCapability> f6028l;
    public final Lazy<ComposerSlideshowCapability> f6029m;
    public final Lazy<ComposerSouvenirCapability> f6030n;
    public final Lazy<ComposerHeaderCapability> f6031o;
    private final Lazy<ComposerInlineSproutsCapability> f6032p;
    private final Lazy<ComposerPostCompositionViewCapability> f6033q;
    public final Lazy<FbLocationStatusUtil> f6034r;
    public final AnonymousClass41 f6035s;
    private final Lazy<ComposerContentTypeController> f6036t;
    public ComposerSubmitEnabledController<ComposerDataProviderImpl> f6037u;

    @Inject
    public ComposerDataProviderImpl(Lazy<ComposerCheckinCapability> lazy, Lazy<ComposerFacecastCapability> lazy2, Lazy<ComposerImplicitLocationCapability> lazy3, Lazy<ComposerMinutiaeCapability> lazy4, Lazy<ComposerMultimediaCapability> lazy5, Lazy<ComposerPhotoCapability> lazy6, Lazy<ComposerCustomPublishModeCapability> lazy7, Lazy<ComposerRedSpaceCapability> lazy8, Lazy<ComposerAlbumCapability> lazy9, Lazy<ComposerTargetMenuCapability> lazy10, Lazy<ComposerTagPeopleCapability> lazy11, Lazy<ComposerTransliterationCapability> lazy12, Lazy<ComposerSlideshowCapability> lazy13, Lazy<ComposerSouvenirCapability> lazy14, Lazy<ComposerHeaderCapability> lazy15, Lazy<ComposerInlineSproutsCapability> lazy16, Lazy<ComposerPostCompositionViewCapability> lazy17, Lazy<FbLocationStatusUtil> lazy18, Lazy<ComposerContentTypeController> lazy19, @Assisted ModelLink modelLink) {
        this.f6017a = lazy;
        this.f6018b = lazy2;
        this.f6019c = lazy3;
        this.f6022f = lazy6;
        this.f6023g = lazy7;
        this.f6021e = lazy4;
        this.f6020d = lazy5;
        this.f6024h = lazy8;
        this.f6025i = lazy9;
        this.f6026j = lazy10;
        this.f6027k = lazy11;
        this.f6028l = lazy12;
        this.f6029m = lazy13;
        this.f6030n = lazy14;
        this.f6031o = lazy15;
        this.f6032p = lazy16;
        this.f6033q = lazy17;
        this.f6034r = lazy18;
        this.f6036t = lazy19;
        this.f6035s = (AnonymousClass41) Preconditions.checkNotNull(modelLink);
    }

    public final ComposerAppAttribution m7424a() {
        return this.f6035s.m7481a().f6745c.getAppAttribution();
    }

    public final ImmutableList<ComposerAttachment> m7437m() {
        return this.f6035s.m7481a().f6745c.getAttachments();
    }

    public final ComposerAudienceEducatorData az() {
        return this.f6035s.m7481a().f6751i;
    }

    public final ComposerConfiguration m7439o() {
        return this.f6035s.m7481a().f6744b;
    }

    public final ComposerContentType m7427c() {
        return ((ComposerContentTypeController) this.f6036t.get()).m7710a(m7437m(), m7429e(), m7441q(), m7442r(), m7436l(), m7431g(), aB());
    }

    public final ComposerDateInfo m7428d() {
        return (ComposerDateInfo) Preconditions.checkNotNull(this.f6035s.m7481a().f6745c.getComposerDateInfo());
    }

    public final InlineSproutsState aA() {
        return this.f6035s.m7481a().f6752j;
    }

    public final ComposerLifeEventModel m7438n() {
        return this.f6035s.m7481a().f6745c.m8149a();
    }

    public final ComposerLocationInfo m7431g() {
        return this.f6035s.m7481a().f6745c.getLocationInfo();
    }

    public final long m7418U() {
        return this.f6035s.m7481a().f6745c.getMarketplaceId();
    }

    public final SpannedString m7419V() {
        return this.f6035s.m7481a().f6760r;
    }

    @Nullable
    public final MinutiaeObject m7436l() {
        return this.f6035s.m7481a().f6745c.getMinutiaeObject();
    }

    @Nullable
    public final ComposerPageData m7440p() {
        return this.f6035s.m7481a().f6745c.getPageData();
    }

    public final Capability ax() {
        boolean z = true;
        ComposerPhotoCapability composerPhotoCapability = (ComposerPhotoCapability) this.f6022f.get();
        BooleanGetter am = this.f6035s.m7482b().am();
        boolean z2 = this.f6035s.m7481a().f6744b.getInitialStickerData() != null;
        TargetType targetType = this.f6035s.m7481a().f6747e.targetType;
        boolean z3 = this.f6035s.m7481a().f6747e.actsAsTarget;
        boolean z4 = (this.f6035s.m7481a().f6745c.getShareParams() == null || this.f6035s.m7481a().f6745c.getShareParams().linkForShare == null) ? false : true;
        boolean z5 = !this.f6035s.m7481a().f6744b.shouldDisablePhotos();
        boolean isEdit = this.f6035s.m7481a().f6744b.isEdit();
        boolean canViewerEditPostMedia = this.f6035s.m7481a().f6744b.canViewerEditPostMedia();
        if (this.f6035s.m7481a().f6745c.getFacecastInfo().facecastCameraIndex == -1) {
            z = false;
        }
        return composerPhotoCapability.a(am, z2, targetType, z3, z4, z5, isEdit, canViewerEditPostMedia, z, this.f6035s.m7481a().f6745c.getAttachments());
    }

    @Nullable
    public final BooleanGetter ah() {
        return this.f6035s.m7482b().ah();
    }

    @Nullable
    public final BooleanGetter ai() {
        return this.f6035s.m7482b().ai();
    }

    @Nullable
    public final BooleanGetter aj() {
        return this.f6035s.m7482b().aj();
    }

    @Nullable
    public final BooleanGetter ak() {
        return this.f6035s.m7482b().ak();
    }

    @Nullable
    public final BooleanGetter al() {
        return this.f6035s.m7482b().al();
    }

    @Nullable
    public final BooleanGetter am() {
        return this.f6035s.m7482b().am();
    }

    @Nullable
    public final BooleanGetter an() {
        return this.f6035s.m7482b().an();
    }

    @Nullable
    public final BooleanGetter ao() {
        return this.f6035s.m7482b().ao();
    }

    @Nullable
    public final BooleanGetter ap() {
        return this.f6035s.m7482b().ap();
    }

    @Nullable
    public final BooleanGetter aq() {
        return this.f6035s.m7482b().aq();
    }

    public final BooleanGetter ar() {
        return this.f6035s.m7482b().ar();
    }

    @Nullable
    public final Getter<String> as() {
        return this.f6035s.m7482b().as();
    }

    @Nullable
    public final BooleanGetter at() {
        return this.f6035s.m7482b().at();
    }

    @Nullable
    public final Getter<String> au() {
        return this.f6035s.m7482b().au();
    }

    @Nullable
    public final Getter<ImmutableMap<String, String>> av() {
        return this.f6035s.m7482b().av();
    }

    @Nullable
    public final Getter<String> aw() {
        return this.f6035s.m7482b().aw();
    }

    public final ImmutableList<GraphQLExploreFeed> m7420W() {
        return this.f6035s.m7481a().f6745c.getPredictedTopics();
    }

    public final ComposerPrivacyData ag() {
        return this.f6035s.m7481a().f6746d;
    }

    public final GraphQLPrivacyOption m7421X() {
        return this.f6035s.m7481a().f6750h;
    }

    public final ProductItemAttachment m7433i() {
        return this.f6035s.m7481a().f6745c.getProductItemAttachment();
    }

    public final PublishMode m7434j() {
        return this.f6035s.m7481a().f6745c.getPublishMode();
    }

    @Nullable
    public final Long m7422Y() {
        return this.f6035s.m7481a().f6745c.getScheduleTime();
    }

    public final int m7423Z() {
        return this.f6035s.m7481a().f6745c.getRating();
    }

    public final RedSpaceValue m7435k() {
        return this.f6035s.m7481a().f6745c.getRedSpaceValue();
    }

    public final ComposerStickerData m7442r() {
        return this.f6035s.m7481a().f6745c.getReferencedStickerData();
    }

    public final ComposerSlideshowData aB() {
        return this.f6035s.m7481a().f6745c.getSlideshowData();
    }

    public final String ab() {
        return this.f6035s.m7481a().f6743a;
    }

    public final ComposerShareParams m7441q() {
        return this.f6035s.m7481a().f6745c.getShareParams();
    }

    public final ImmutableList<ComposerTaggedUser> m7432h() {
        return this.f6035s.m7481a().f6745c.getTaggedUsers();
    }

    public final GraphQLAlbum ad() {
        return this.f6035s.m7481a().f6745c.getTargetAlbum();
    }

    public final ComposerTargetData m7443s() {
        return this.f6035s.m7481a().f6747e;
    }

    public final GraphQLTextWithEntities ae() {
        return this.f6035s.m7481a().f6745c.getTextWithEntities();
    }

    public final ImmutableList<GraphQLExploreFeed> af() {
        return this.f6035s.m7481a().f6745c.getTopics();
    }

    public final ComposerLocation m7430f() {
        return this.f6035s.m7481a().f6748f;
    }

    public final boolean m7444u() {
        return this.f6035s.m7481a().f6754l;
    }

    public final ComposerSessionLoggingData m7426b() {
        return this.f6035s.m7481a().f6749g;
    }

    public final boolean m7447y() {
        return m7425a(this.f6035s.m7481a().f6745c.getAttachments());
    }

    public final boolean m7425a(ImmutableList<ComposerAttachment> immutableList) {
        return ((ComposerAlbumCapability) this.f6025i.get()).a(this.f6035s.m7482b().ah(), this.f6035s.m7481a().f6747e.targetType, String.valueOf(this.f6035s.m7481a().f6747e.targetId), this.f6035s.m7481a().f6745c.getPublishMode(), this.f6035s.m7481a().f6744b.isEdit(), this.f6035s.m7481a().f6744b.shouldDisableAttachToAlbum(), immutableList, m7436l() != null, this.f6035s.m7481a().f6747e.actsAsTarget, this.f6035s.m7481a().f6745c.getRedSpaceValue(), m7416S(), m7408I());
    }

    public final boolean m7446x() {
        ComposerHeaderCapability composerHeaderCapability = (ComposerHeaderCapability) this.f6031o.get();
        boolean z = composerHeaderCapability.c(this.f6035s.m7482b().S) && ((QeAccessor) composerHeaderCapability.a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.b, false);
        return z;
    }

    public final boolean m7448z() {
        return this.f6035s.m7481a().f6745c.isBackoutDraft();
    }

    public final boolean m7400A() {
        this.f6017a.get();
        return ComposerCheckinCapability.a(m7439o().isEdit(), m7439o().isEditTagEnabled(), this.f6035s.m7482b().ai());
    }

    public final boolean m7401B() {
        return this.f6035s.m7481a().f6758p;
    }

    public final boolean m7402C() {
        this.f6023g.get();
        boolean isEdit = this.f6035s.m7481a().f6744b.isEdit();
        ComposerTargetData composerTargetData = this.f6035s.m7481a().f6747e;
        ComposerShareParams shareParams = this.f6035s.m7481a().f6745c.getShareParams();
        boolean z = composerTargetData.a() && ((shareParams == null || shareParams.shareable == null) && (ad() != null ? 1 : null) == null && !isEdit && m7427c() != ComposerContentType.FACECAST);
        return z;
    }

    public final ComposerFacecastInfo m7429e() {
        return this.f6035s.m7481a().f6745c.getFacecastInfo();
    }

    public final boolean m7445w() {
        return this.f6035s.m7481a().f6757o;
    }

    public final boolean m7403D() {
        return ((ComposerFacecastCapability) this.f6018b.get()).a(this.f6035s.m7481a().f6747e.targetType, this.f6035s.m7481a().f6744b.isEdit(), !this.f6035s.m7481a().f6745c.getAttachments().isEmpty(), this.f6035s.m7481a().f6745c.getPublishMode(), this.f6035s.m7482b().ak());
    }

    public final boolean m7406G() {
        ComposerImplicitLocationCapability composerImplicitLocationCapability = (ComposerImplicitLocationCapability) this.f6019c.get();
        m7439o();
        ComposerLocationInfo g = m7431g();
        boolean A = m7400A();
        BooleanGetter booleanGetter = this.f6035s.m7482b().o;
        boolean z = g.f() == null ? false : (!g.l() && !g.e() && g.a() == null && A && (booleanGetter == null || booleanGetter.a())) ? !((PlacesFeatures) composerImplicitLocationCapability.a.get()).a() : false;
        return z;
    }

    public final boolean aF() {
        ComposerHeaderCapability composerHeaderCapability = (ComposerHeaderCapability) this.f6031o.get();
        boolean z = composerHeaderCapability.c(this.f6035s.m7482b().S) && ((QeAccessor) composerHeaderCapability.a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.f, false);
        return z;
    }

    public final boolean m7407H() {
        return this.f6035s.m7481a().f6752j != null && this.f6035s.m7481a().f6752j.isInlineSproutsOpen();
    }

    public final boolean m7408I() {
        boolean z;
        ComposerInlineSproutsCapability composerInlineSproutsCapability = (ComposerInlineSproutsCapability) this.f6032p.get();
        TargetType targetType = m7439o().getInitialTargetData().targetType;
        BooleanGetter booleanGetter = this.f6035s.m7482b().p;
        if (composerInlineSproutsCapability.f6539a.m8047u().contains(targetType) || !(booleanGetter == null || booleanGetter.a())) {
            z = false;
        } else {
            z = composerInlineSproutsCapability.f6539a.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.q, false);
        }
        return z;
    }

    public final boolean m7405F() {
        return ((ComposerHeaderCapability) this.f6031o.get()).c(this.f6035s.m7482b().S);
    }

    public final boolean m7409J() {
        return ((ComposerMinutiaeCapability) this.f6021e.get()).a(this.f6035s.m7481a().f6747e.targetType, this.f6035s.m7481a().f6744b.isEdit(), this.f6035s.m7481a().f6744b.isEditTagEnabled(), ad() != null, this.f6035s.m7482b().al());
    }

    public final boolean m7410K() {
        return ((ComposerMultimediaCapability) this.f6020d.get()).a(this.f6035s.m7481a().f6747e.targetType, this.f6035s.m7481a().f6744b.isEdit());
    }

    public final boolean m7411L() {
        ComposerHeaderCapability composerHeaderCapability = (ComposerHeaderCapability) this.f6031o.get();
        boolean z = composerHeaderCapability.c(this.f6035s.m7482b().S) && ((QeAccessor) composerHeaderCapability.a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.T, false);
        return z;
    }

    public final boolean m7412N() {
        if (m7402C()) {
            boolean z = !m7439o().isEdit() && m7443s().a() && ((QeAccessor) ((ComposerPostCompositionViewCapability) this.f6033q.get()).a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.U, false);
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean m7413O() {
        return ((ComposerHeaderCapability) this.f6031o.get()).b(this.f6035s.m7482b().S);
    }

    public final boolean ay() {
        ComposerRedSpaceCapability composerRedSpaceCapability = (ComposerRedSpaceCapability) this.f6024h.get();
        BooleanGetter booleanGetter = this.f6035s.m7482b().K;
        ComposerConfiguration composerConfiguration = this.f6035s.m7481a().f6744b;
        boolean z = composerConfiguration.getAllowsRedSpaceToggle() && composerRedSpaceCapability.b(booleanGetter, composerConfiguration, this.f6035s.m7481a().f6747e.targetType, ad() != null);
        return z;
    }

    public final boolean m7414P() {
        ComposerHeaderCapability composerHeaderCapability = (ComposerHeaderCapability) this.f6031o.get();
        boolean z = composerHeaderCapability.b(this.f6035s.m7482b().S) && ((QeAccessor) composerHeaderCapability.a.get()).a(ExperimentsForFeedUtilComposerAbtestModule.ac, false);
        return z;
    }

    public final boolean m7415Q() {
        this.f6027k.get();
        return ComposerTagPeopleCapability.a(this.f6035s.m7481a().f6747e.targetType, this.f6035s.m7481a().f6744b.isEdit(), this.f6035s.m7481a().f6744b.isEditTagEnabled(), this.f6035s.m7481a().f6747e.actsAsTarget, this.f6035s.m7481a().f6744b.shouldDisableFriendTagging(), this.f6035s.m7482b().ao());
    }

    public final boolean m7416S() {
        ComposerTransliterationCapability composerTransliterationCapability = (ComposerTransliterationCapability) this.f6028l.get();
        TargetType targetType = this.f6035s.m7481a().f6747e.targetType;
        boolean D = m7403D();
        boolean I = m7408I();
        boolean z = false;
        Preconditions.checkNotNull(targetType);
        if ((!D || I) && ((targetType == TargetType.UNDIRECTED || targetType == TargetType.GROUP || targetType == TargetType.USER) && composerTransliterationCapability.a == Product.FB4A && composerTransliterationCapability.b.b())) {
            z = true;
        }
        return z;
    }

    public final boolean m7417T() {
        return this.f6035s.m7481a().f6745c.isUserSelectedTags();
    }

    public final boolean m7404E() {
        return this.f6035s.m7481a().f6745c.isFeedOnlyPost();
    }
}
