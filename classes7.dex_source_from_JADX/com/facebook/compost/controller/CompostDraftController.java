package com.facebook.compost.controller;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.compost.publish.graphql.CompostGraphQLCreators;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLInlineActivitiesConnection;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.photos.upload.progresspage.CompostNotificationService;
import com.facebook.photos.upload.progresspage.survey.CompostSurveyController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.nokia.pushnotifications.service */
public class CompostDraftController {
    private final Clock f17382a;
    private final CompostAnalyticsLogger f17383b;
    private final CompostDraftStoryStore f17384c;
    public final Lazy<CompostSurveyController> f17385d;
    public final Context f17386e;
    private final Executor f17387f;
    private final QeAccessor f17388g;
    public final SecureContextHelper f17389h;
    private final Lazy<TagStore> f17390i;

    public static CompostDraftController m21268b(InjectorLike injectorLike) {
        return new CompostDraftController((Clock) SystemClockMethodAutoProvider.a(injectorLike), CompostAnalyticsLogger.b(injectorLike), CompostDraftStoryStore.a(injectorLike), IdBasedLazy.a(injectorLike, 9474), (Context) injectorLike.getInstance(Context.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9442));
    }

    @Inject
    public CompostDraftController(Clock clock, CompostAnalyticsLogger compostAnalyticsLogger, CompostDraftStoryStore compostDraftStoryStore, Lazy<CompostSurveyController> lazy, Context context, Executor executor, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, Lazy<TagStore> lazy2) {
        this.f17382a = clock;
        this.f17383b = compostAnalyticsLogger;
        this.f17384c = compostDraftStoryStore;
        this.f17385d = lazy;
        this.f17386e = context;
        this.f17387f = executor;
        this.f17388g = qeAccessor;
        this.f17389h = secureContextHelper;
        this.f17390i = lazy2;
    }

    public final boolean m21270a() {
        return this.f17388g.a(ExperimentsForCompostAbTestModule.z, false) && this.f17388g.a(ExperimentsForCompostAbTestModule.d, false);
    }

    public final boolean m21272a(String str, ComposerTargetData composerTargetData, boolean z, ComposerLocationInfo composerLocationInfo, @Nullable ComposerStickerData composerStickerData, @Nullable ComposerShareParams composerShareParams, @Nullable GraphQLAlbum graphQLAlbum, @Nullable ComposerAppAttribution composerAppAttribution, ImmutableList<ComposerAttachment> immutableList) {
        if (composerTargetData.targetType != TargetType.UNDIRECTED && composerTargetData.targetType != TargetType.USER) {
            this.f17383b.a(str, "non_status", composerTargetData.targetType.toString());
            return false;
        } else if (z) {
            this.f17383b.b(str, "feed_only");
            return false;
        } else if (composerLocationInfo.d() || composerLocationInfo.a() != null) {
            this.f17383b.b(str, "check_in");
            return false;
        } else if (composerStickerData != null) {
            this.f17383b.b(str, "sticker_post");
            return false;
        } else if (composerShareParams != null && (composerShareParams.sharePreview == null || StringUtil.a(composerShareParams.linkForShare) || composerShareParams.includeReshareContext)) {
            this.f17383b.b(str, "reshare");
            return false;
        } else if (graphQLAlbum != null) {
            return false;
        } else {
            if (composerAppAttribution != null) {
                this.f17383b.b(str, "app_attribution");
                return false;
            }
            int size = immutableList.size();
            int i = 0;
            while (i < size) {
                ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
                if (composerAttachment.b() != null && composerAttachment.b().b().b() == Type.Video) {
                    this.f17383b.b(str, "video");
                    return false;
                } else if (composerAttachment.e() != null && composerAttachment.e().l()) {
                    this.f17383b.b(str, "creative_editing");
                    return false;
                } else if (((TagStore) this.f17390i.get()).a(new MediaIdKey(composerAttachment.b().e(), composerAttachment.b().a().d())).isEmpty()) {
                    i++;
                } else {
                    this.f17383b.b(str, "x_y_tags");
                    return false;
                }
            }
            return true;
        }
    }

    public final void m21269a(final String str, GraphQLTextWithEntities graphQLTextWithEntities, ImmutableList<ComposerTaggedUser> immutableList, @Nullable MinutiaeObject minutiaeObject, ComposerPrivacyData composerPrivacyData, ComposerTargetData composerTargetData, CompostAttachment compostAttachment) {
        ImmutableList of;
        GraphQLInlineActivitiesConnection g;
        GraphQLPrivacyScope graphQLPrivacyScope;
        GraphQLProfile graphQLProfile = null;
        if (compostAttachment.f17377a != null) {
            of = ImmutableList.of(CompostGraphQLCreators.m21278a(compostAttachment.f17377a));
        } else if (CollectionUtil.b(compostAttachment.f17378b)) {
            of = ImmutableList.of(CompostGraphQLCreators.m21279a(compostAttachment.f17378b));
        } else {
            of = RegularImmutableList.a;
        }
        Builder builder = new Builder();
        builder.X = graphQLTextWithEntities;
        builder = builder;
        builder.aK = CompostGraphQLCreators.m21280b(immutableList);
        Builder builder2 = builder;
        if (minutiaeObject != null) {
            g = minutiaeObject.g();
        } else {
            g = null;
        }
        builder2.M = g;
        builder2 = builder2;
        if (StringUtil.a(composerPrivacyData.m1946a())) {
            graphQLPrivacyScope = null;
        } else {
            graphQLPrivacyScope = CompostGraphQLCreators.m21274a(composerPrivacyData);
        }
        builder2.ae = graphQLPrivacyScope;
        builder = builder2;
        if (composerTargetData.targetType == TargetType.USER) {
            graphQLProfile = CompostGraphQLCreators.m21275a(composerTargetData);
        }
        builder.aA = graphQLProfile;
        builder = builder;
        builder.m = of;
        builder = builder;
        builder.x = this.f17382a.a() / 1000;
        Builder builder3 = builder;
        final boolean z = !m21271a(str);
        Futures.a(this.f17384c.a(CompostDraftStory.a(str, builder3.a())), new FutureCallback<Boolean>(this) {
            final /* synthetic */ CompostDraftController f17381c;

            public void onSuccess(@Nullable Object obj) {
                Boolean bool = (Boolean) obj;
                boolean z = bool != null && bool.booleanValue();
                Preconditions.checkState(z, "Error saving the draft for session <" + str + ">");
                if (z) {
                    this.f17381c.f17389h.c(new Intent(this.f17381c.f17386e, CompostNotificationService.class), this.f17381c.f17386e);
                }
            }

            public void onFailure(Throwable th) {
                throw new RuntimeException("Error saving the draft for session <" + str + ">", th);
            }
        }, this.f17387f);
        this.f17383b.d(str, of.size(), StringLengthHelper.a(graphQLTextWithEntities.a()));
    }

    public final boolean m21271a(String str) {
        return this.f17384c.d(str) != -1;
    }
}
