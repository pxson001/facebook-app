package com.facebook.composer.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannedString;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.AttachmentsValidator;
import com.facebook.composer.attachments.AttachmentsValidator.Error;
import com.facebook.composer.attachments.AttachmentsValidator.Result;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.model.ComposerModel;
import com.facebook.composer.model.ComposerModel.Builder;
import com.facebook.composer.model.Composition;
import com.facebook.composer.plugininternal.ComposerPluginRegistry;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.composer.savedsession.ComposerSavedSession;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.plugin.ComposerPlugin;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TagStoreCopy;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: invalid_composer_session_id */
public class ComposerIntentParser {
    public final Lazy<FbErrorReporter> f6156a;
    private final Lazy<FbObjectMapper> f6157b;
    private final Lazy<Clock> f6158c;
    private final Lazy<AttachmentsValidator> f6159d;
    private final Lazy<MediaItemFactory> f6160e;
    private final Provider<String> f6161f;
    private final Lazy<ComposerAnalyticsLogger> f6162g;
    private final Lazy<Toaster> f6163h;
    private final Lazy<Resources> f6164i;
    private final Lazy<Integer> f6165j;
    public final Lazy<ComposerPluginRegistry> f6166k;
    private final Lazy<TagStore> f6167l;
    public RuntimeException f6168m;

    /* compiled from: invalid_composer_session_id */
    public /* synthetic */ class C07671 {
        public static final /* synthetic */ int[] f6152a = new int[ComposerSourceType.values().length];

        static {
            try {
                f6152a[ComposerSourceType.FEED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6152a[ComposerSourceType.FEED_INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6152a[ComposerSourceType.TIMELINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6152a[ComposerSourceType.GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6152a[ComposerSourceType.PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6152a[ComposerSourceType.EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: invalid_composer_session_id */
    public class ParseResult {
        final /* synthetic */ ComposerIntentParser f6153a;
        public final ComposerModel f6154b;
        @Nullable
        private final InstanceState f6155c;

        ParseResult(ComposerIntentParser composerIntentParser, ComposerModel composerModel, @Nullable InstanceState instanceState) {
            this.f6153a = composerIntentParser;
            this.f6154b = (ComposerModel) Preconditions.checkNotNull(composerModel);
            this.f6155c = instanceState;
        }

        public final ComposerPluginDefault m7602a(ComposerPluginSession composerPluginSession) {
            Preconditions.checkNotNull(composerPluginSession);
            try {
                return ((ComposerPluginRegistry) this.f6153a.f6166k.get()).m8203a(this.f6154b.f6744b.getPluginConfig(), composerPluginSession, this.f6155c);
            } catch (Throwable e) {
                Throwable th = e;
                ((AbstractFbErrorReporter) this.f6153a.f6156a.get()).a("composer_load_model_from_saved_session_failed", "Failed to restore the composer plugin: " + this.f6154b.f6744b.getPluginConfig(), th);
                if (this.f6155c != null) {
                    return ((ComposerPluginRegistry) this.f6153a.f6166k.get()).m8203a(this.f6154b.f6744b.getPluginConfig(), composerPluginSession, null);
                }
                throw Throwables.propagate(th);
            }
        }
    }

    public static ComposerIntentParser m7603a(InjectorLike injectorLike) {
        return new ComposerIntentParser(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 5193), IdBasedLazy.a(injectorLike, 2963), IdBasedProvider.a(injectorLike, 4442), IdBasedSingletonScopeProvider.b(injectorLike, 5189), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 30), IdBasedLazy.a(injectorLike, 4421), IdBasedLazy.a(injectorLike, 5266), IdBasedSingletonScopeProvider.b(injectorLike, 9442), IdBasedSingletonScopeProvider.b(injectorLike, 572));
    }

    @Inject
    public ComposerIntentParser(Lazy<FbErrorReporter> lazy, Lazy<Clock> lazy2, Lazy<AttachmentsValidator> lazy3, Lazy<MediaItemFactory> lazy4, Provider<String> provider, Lazy<ComposerAnalyticsLogger> lazy5, Lazy<Toaster> lazy6, Lazy<Resources> lazy7, Lazy<Integer> lazy8, Lazy<ComposerPluginRegistry> lazy9, Lazy<TagStore> lazy10, Lazy<FbObjectMapper> lazy11) {
        this.f6156a = lazy;
        this.f6158c = lazy2;
        this.f6159d = lazy3;
        this.f6160e = lazy4;
        this.f6161f = provider;
        this.f6162g = lazy5;
        this.f6163h = lazy6;
        this.f6164i = lazy7;
        this.f6165j = lazy8;
        this.f6166k = lazy9;
        this.f6167l = lazy10;
        this.f6157b = lazy11;
    }

    public final ParseResult m7610a(Bundle bundle, @Nullable Bundle bundle2) {
        Object containsKey = bundle.containsKey("extra_composer_saved_session");
        try {
            return m7608b(bundle, bundle2);
        } catch (Throwable e) {
            if (containsKey == null) {
                throw e;
            }
            ((AbstractFbErrorReporter) this.f6156a.get()).a("composer_load_model_from_saved_session_failed", "Failed to load the composer model from a saved session", e);
            this.f6168m = e;
            ComposerSavedSession composerSavedSession = (ComposerSavedSession) bundle.getParcelable("extra_composer_saved_session");
            ComposerConfiguration a = ComposerConfiguration.newBuilder().setSourceType(ComposerSourceType.UNKNOWN).setComposerType(ComposerType.STATUS).a();
            bundle.remove("extra_composer_saved_session");
            bundle.putString("extra_composer_internal_session_id", composerSavedSession.sessionId);
            bundle.putParcelable("extra_composer_configuration", a);
            return m7608b(bundle, bundle2);
        }
    }

    private ParseResult m7608b(Bundle bundle, @Nullable Bundle bundle2) {
        ComposerModel a;
        Composition composition;
        InstanceState instanceState = null;
        ComposerSavedSession composerSavedSession = (ComposerSavedSession) bundle.getParcelable("extra_composer_saved_session");
        ComposerConfiguration a2 = m7606a(bundle);
        m7607a(a2, bundle);
        ComposerConfiguration b = m7609b(a2);
        Builder builder = new Builder();
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.a = false;
        builder2 = builder2;
        builder2.c = true;
        builder.f6728d = builder2.a();
        builder = builder;
        builder.f6731g = ComposerSessionLoggingData.newBuilder().a();
        Builder builder3 = builder;
        builder3.f6741q = ((Clock) this.f6158c.get()).a();
        builder = builder3;
        builder.f6726b = b;
        builder = builder;
        builder.f6733i = new ComposerAudienceEducatorData.Builder().a();
        ComposerModel a3 = builder.m8142a();
        if (bundle2 != null) {
            SpannedString spannedString;
            builder = a3.m8143a();
            builder.f6725a = bundle2.getString("session_id");
            builder3 = builder;
            builder3.f6727c = (Composition) bundle2.getParcelable("composition");
            builder3 = builder3;
            builder3.f6731g = (ComposerSessionLoggingData) bundle2.getParcelable("composer_session_logging_data");
            builder3 = builder3.m8140a(bundle2.getLong("session_start_time_ms"));
            builder3.f6730f = (ComposerLocation) bundle2.getParcelable("viewer_coordinates");
            builder3 = builder3.m8141a((ComposerTargetData) bundle2.getParcelable("target_data"), Long.parseLong((String) this.f6161f.get()));
            builder3.f6732h = (GraphQLPrivacyOption) FlatBufferModelHelper.a(bundle2, "privacy_override");
            builder3 = builder3;
            builder3.f6733i = (ComposerAudienceEducatorData) bundle2.getParcelable("audience_educator_data");
            builder = builder3;
            builder.f6737m = bundle2.getBoolean("has_shown_tag_place_tip_or_suggestion");
            builder = builder;
            builder.f6736l = bundle2.getBoolean("privacy_has_changed");
            builder = builder;
            builder.f6738n = bundle2.getBoolean("post_composition_shown");
            builder3 = builder;
            builder3.f6734j = (InlineSproutsState) bundle2.getParcelable("inline_sprouts_state");
            builder3 = builder3;
            if (bundle2.getCharSequence("meta_text") != null) {
                spannedString = new SpannedString(bundle2.getCharSequence("meta_text"));
            } else {
                spannedString = null;
            }
            builder3.f6742r = spannedString;
            builder = builder3;
            builder.f6739o = true;
            a = builder.m8142a();
            instanceState = InstanceState.a(bundle2.getString("plugin_state"));
        } else if (composerSavedSession != null) {
            Composition composition2 = composerSavedSession.composition;
            ImmutableList attachments = composition2.getAttachments();
            int size = attachments.size();
            for (int i = 0; i < size; i++) {
                ((ComposerAttachment) attachments.get(i)).a((MediaItemFactory) this.f6160e.get(), (TagStore) this.f6167l.get());
            }
            builder = a3.m8143a();
            builder.f6725a = composerSavedSession.sessionId;
            builder = builder;
            builder.f6727c = composition2;
            builder = builder;
            builder.f6730f = composerSavedSession.viewerCoordinates;
            builder = builder.m8141a(composerSavedSession.targetData, Long.parseLong((String) this.f6161f.get()));
            builder.f6732h = composerSavedSession.privacyOverride;
            builder = builder;
            builder.f6735k = composerSavedSession.loadAttempts;
            builder = builder;
            builder.f6736l = composerSavedSession.privacyHasChanged;
            builder = builder;
            builder.f6739o = true;
            a = builder.m8142a();
            instanceState = InstanceState.a(composerSavedSession.pluginState);
        } else {
            builder = a3.m8143a();
            builder.f6725a = bundle.getString("extra_composer_internal_session_id");
            builder = builder;
            builder.f6727c = m7604a(a3.f6744b);
            a = builder.m8141a(b.getInitialTargetData(), Long.parseLong((String) this.f6161f.get())).m8142a();
        }
        if (a.f6750h == null && b.getInitialPrivacyOverride() != null && composerSavedSession == null) {
            builder = a.m8143a();
            builder.f6732h = b.getInitialPrivacyOverride();
            a = builder.m8142a();
        }
        Composition composition3 = a.f6745c;
        if (a.f6745c.getAttachments().isEmpty()) {
            composition = composition3;
        } else {
            String str = a.f6743a;
            boolean z = a.f6744b.getPlatformConfiguration().b() || a.f6744b.isEdit();
            composition = m7605a(str, composition3, z);
        }
        if (composition != a.f6745c) {
            builder = a.m8143a();
            builder.f6727c = composition;
            a = builder.m8142a();
        }
        if (composerSavedSession != null) {
            ((ComposerAnalyticsLogger) this.f6162g.get()).a(Events.LOAD_SAVED_SESSION, a.f6743a);
        }
        return new ParseResult(this, a, instanceState);
    }

    private Composition m7605a(String str, Composition composition, boolean z) {
        return Composition.m8148a(composition).setAttachments(m7611a(str, composition.getAttachments(), z).a).m8146a();
    }

    public final Result m7611a(String str, ImmutableList<ComposerAttachment> immutableList, boolean z) {
        int i;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.b() != null && composerAttachment.b().l() == MediaType.VIDEO) {
                i = 1;
                break;
            }
        }
        i = 0;
        Result a = ((AttachmentsValidator) this.f6159d.get()).a(immutableList, z);
        if (i != 0 && a.a.isEmpty()) {
            ((ComposerAnalyticsLogger) this.f6162g.get()).a(Events.COMPOSER_ATTACH_MOVIE_FAILURE, str);
        } else if (!(immutableList.isEmpty() || a.b.isEmpty())) {
            ((ComposerAnalyticsLogger) this.f6162g.get()).a(Events.COMPOSER_ATTACH_PHOTO_FAILURE, str);
        }
        if (a.b.contains(Error.NONEXISTANT_PHOTO)) {
            ((AbstractFbErrorReporter) this.f6156a.get()).a("composer_non_existing_attachment", "Tried to share nonexistent photo");
            Toaster toaster = (Toaster) this.f6163h.get();
            ToastBuilder toastBuilder = new ToastBuilder(2131234532);
            toastBuilder.b = 17;
            toaster.b(toastBuilder);
        }
        if (a.b.contains(Error.TOO_MANY_PHOTOS)) {
            ((AbstractFbErrorReporter) this.f6156a.get()).a("composer_too_many_attachments", "Tried to attach " + immutableList.size() + " attachments");
            ((Toaster) this.f6163h.get()).b(new ToastBuilder(((Resources) this.f6164i.get()).getString(2131234576, new Object[]{this.f6165j.get(), Integer.valueOf(immutableList.size()), this.f6165j.get()})));
        }
        return a;
    }

    private static Composition m7604a(ComposerConfiguration composerConfiguration) {
        Composition.Builder slideshowData = Composition.newBuilder().setAttachments(composerConfiguration.getInitialAttachments()).setTargetAlbum(composerConfiguration.getInitialTargetAlbum()).setTaggedUsers(composerConfiguration.getInitialTaggedUsers()).setMinutiaeObject(composerConfiguration.getMinutiaeObjectTag()).setRating(composerConfiguration.getInitialRating()).setLocationInfo(composerConfiguration.getInitialLocationInfo()).setReferencedStickerData(composerConfiguration.getInitialStickerData()).setShareParams(composerConfiguration.getInitialShareParams()).setComposerDateInfo(composerConfiguration.getInitialDateInfo()).setRedSpaceValue(composerConfiguration.getInitialRedSpaceValue()).setAppAttribution(composerConfiguration.getInitialAppAttribution()).setTopics(composerConfiguration.getTopics()).setFacecastInfo(composerConfiguration.getInitialFacecastInfo()).setPageData(composerConfiguration.getInitialPageData()).setSlideshowData(composerConfiguration.getInitialSlideshowData());
        if (composerConfiguration.getInitialText() != null) {
            slideshowData.setTextWithEntities(composerConfiguration.getInitialText());
        }
        if (composerConfiguration.getComposerType() == ComposerType.SELL) {
            slideshowData.setProductItemAttachment(composerConfiguration.getProductItemAttachment());
        }
        if (composerConfiguration.getComposerType() == ComposerType.LIFE_EVENT) {
            slideshowData.m8144a((ComposerLifeEventModel) Preconditions.checkNotNull(composerConfiguration.a()));
        }
        return slideshowData.m8146a();
    }

    private ComposerConfiguration m7606a(Bundle bundle) {
        boolean z = true;
        ComposerConfiguration composerConfiguration = (ComposerConfiguration) bundle.getParcelable("extra_composer_configuration");
        ComposerSavedSession composerSavedSession = (ComposerSavedSession) bundle.getParcelable("extra_composer_saved_session");
        boolean z2 = (composerConfiguration == null && composerSavedSession == null) ? false : true;
        Preconditions.checkArgument(z2, "No composer configuration or saved session supplied to composer");
        if (!(composerConfiguration == null || composerSavedSession == null)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot launch composer with both a configuration and a saved session");
        if (composerSavedSession == null) {
            return composerConfiguration;
        }
        ImmutableList initialAttachments = composerSavedSession.configuration.getInitialAttachments();
        int size = initialAttachments.size();
        for (int i = 0; i < size; i++) {
            ((ComposerAttachment) initialAttachments.get(i)).a((MediaItemFactory) this.f6160e.get(), (TagStore) this.f6167l.get());
        }
        return composerSavedSession.configuration;
    }

    private void m7607a(ComposerConfiguration composerConfiguration, Bundle bundle) {
        if (bundle.getString("extra_composer_internal_session_id") == null && !bundle.containsKey("extra_composer_saved_session")) {
            String a;
            try {
                a = ((FbObjectMapper) this.f6157b.get()).a(composerConfiguration);
            } catch (JsonProcessingException e) {
                a = "error serializing ComposerConfiguration";
            }
            ((AbstractFbErrorReporter) this.f6156a.get()).a(SoftError.a("invalid_composer_session_id", "No session id supplied to composer. ComposerConfiguration = " + a).a(1).g());
            bundle.putString("extra_composer_internal_session_id", SafeUUIDGenerator.a().toString());
        }
    }

    public final Optional<ComposerSavedSession> m7612a(ComposerModel composerModel, ComposerPlugin composerPlugin) {
        int i = 0;
        try {
            TagStoreCopy a = TagStoreCopy.a((TagStore) this.f6167l.get(), AttachmentUtils.e(composerModel.f6745c.getAttachments()));
            ImmutableList attachments = composerModel.f6745c.getAttachments();
            int size = attachments.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ComposerAttachment) attachments.get(i2)).a(a);
            }
            TagStoreCopy a2 = TagStoreCopy.a((TagStore) this.f6167l.get(), AttachmentUtils.e(composerModel.f6744b.getInitialAttachments()));
            ImmutableList initialAttachments = composerModel.f6744b.getInitialAttachments();
            int size2 = initialAttachments.size();
            while (i < size2) {
                ((ComposerAttachment) initialAttachments.get(i)).a(a2);
                i++;
            }
            return Optional.of(new ComposerSavedSession.Builder(composerModel.f6743a, composerModel.f6744b, composerModel.f6745c).m8236a(((Clock) this.f6158c.get()).a()).m8235a(composerModel.f6753k).m8239a(composerModel.f6748f).m8238a(composerModel.f6747e).m8237a(composerModel.f6750h).m8241a(composerModel.f6754l).m8240a(((InstanceState) Preconditions.checkNotNull(composerPlugin.a())).a()).m8242a());
        } catch (Throwable th) {
            ((AbstractFbErrorReporter) this.f6156a.get()).a("composer_saved_session_creation_failed", "Failed to create saved session", th);
            return Absent.withType();
        }
    }

    @Deprecated
    private static ComposerConfiguration m7609b(ComposerConfiguration composerConfiguration) {
        ComposerSourceSurface composerSourceSurface;
        ComposerLaunchLoggingParams launchLoggingParams = composerConfiguration.getLaunchLoggingParams();
        ComposerConfiguration.Builder a = ComposerConfiguration.a(composerConfiguration);
        ComposerLaunchLoggingParams.Builder a2 = ComposerLaunchLoggingParams.a(launchLoggingParams);
        if (launchLoggingParams.getSourceSurface() == ComposerSourceSurface.UNKNOWN) {
            ComposerSourceSurface composerSourceSurface2;
            switch (C07671.f6152a[composerConfiguration.getSourceType().ordinal()]) {
                case 1:
                case 2:
                    composerSourceSurface2 = ComposerSourceSurface.NEWSFEED;
                    break;
                case 3:
                    composerSourceSurface2 = ComposerSourceSurface.TIMELINE;
                    break;
                case 4:
                    composerSourceSurface2 = ComposerSourceSurface.GROUP_FEED;
                    break;
                case 5:
                    composerSourceSurface2 = ComposerSourceSurface.PAGE_FEED;
                    break;
                case 6:
                    composerSourceSurface2 = ComposerSourceSurface.EVENT;
                    break;
                default:
                    composerSourceSurface2 = ComposerSourceSurface.UNKNOWN;
                    break;
            }
            composerSourceSurface = composerSourceSurface2;
        } else {
            composerSourceSurface = launchLoggingParams.getSourceSurface();
        }
        return a.setLaunchLoggingParams(a2.setSourceSurface(composerSourceSurface).setEntryPointDescription(StringUtil.c(launchLoggingParams.getEntryPointDescription()) ? composerConfiguration.getSourceType().analyticsName : launchLoggingParams.getEntryPointDescription()).a()).a();
    }
}
