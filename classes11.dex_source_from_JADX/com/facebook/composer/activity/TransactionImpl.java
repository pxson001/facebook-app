package com.facebook.composer.activity;

import android.text.SpannedString;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.activity.ComposerMutatorImpl.C07691;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.model.ComposerModel;
import com.facebook.composer.model.Composition;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: input.getResult() is null */
public class TransactionImpl {
    private final Builder<ComposerEvent> f6220a = new Builder();
    private final ComposerModel f6221b;
    public final ComposerEventOriginator f6222c;
    private final WeakReference<Committer> f6223d;
    private final DefaultAndroidThreadUtil f6224e;
    private final Provider<String> f6225f;
    @Nullable
    private ComposerModel.Builder f6226g;
    @Nullable
    private Composition.Builder f6227h;

    public final /* synthetic */ Object m7683a(ComposerShareParams composerShareParams) {
        return m7690b(composerShareParams);
    }

    public final /* synthetic */ Object m7684a(ComposerFacecastInfo composerFacecastInfo) {
        return m7691b(composerFacecastInfo);
    }

    public final /* synthetic */ Object m7685a(ComposerLocationInfo composerLocationInfo) {
        return m7692b(composerLocationInfo);
    }

    public final /* synthetic */ Object m7687a(ImmutableList immutableList, ImmutableList immutableList2) {
        return m7695b(immutableList, immutableList2);
    }

    @Inject
    public TransactionImpl(@Assisted ComposerModel composerModel, @Assisted ComposerEventOriginator composerEventOriginator, @Assisted Committer committer, AndroidThreadUtil androidThreadUtil, Provider<String> provider) {
        this.f6221b = (ComposerModel) Preconditions.checkNotNull(composerModel);
        this.f6222c = composerEventOriginator;
        this.f6223d = new WeakReference(Preconditions.checkNotNull(committer));
        this.f6224e = androidThreadUtil;
        this.f6225f = provider;
    }

    private Composition.Builder m7658d() {
        if (this.f6227h == null) {
            this.f6227h = Composition.m8148a(this.f6221b.f6745c);
        }
        return this.f6227h;
    }

    private ComposerModel.Builder m7659e() {
        if (this.f6226g == null) {
            this.f6226g = new ComposerModel.Builder(this.f6221b);
        }
        return this.f6226g;
    }

    public final TransactionImpl m7690b(ComposerShareParams composerShareParams) {
        this.f6224e.a();
        m7658d().setShareParams(composerShareParams);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7696b(boolean z) {
        this.f6224e.a();
        m7659e().f6738n = z;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7677a(ProductItemAttachment productItemAttachment) {
        this.f6224e.a();
        m7658d().setProductItemAttachment(productItemAttachment);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7697c() {
        this.f6224e.a();
        m7659e().f6739o = true;
        this.f6220a.c(ComposerEvent.ON_USER_INTERACTION);
        return this;
    }

    public final TransactionImpl m7664a(ComposerLifeEventModel composerLifeEventModel) {
        this.f6224e.a();
        m7658d().m8144a(composerLifeEventModel);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7674a(ComposerDateInfo composerDateInfo) {
        this.f6224e.a();
        m7658d().setComposerDateInfo(composerDateInfo);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7678a(PublishMode publishMode) {
        this.f6224e.a();
        m7658d().setPublishMode(publishMode);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7681a(@Nullable Long l) {
        this.f6224e.a();
        m7658d().setScheduleTime(l);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7660a(int i) {
        this.f6224e.a();
        m7658d().setRating(i);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7668a(GraphQLAlbum graphQLAlbum) {
        this.f6224e.a();
        m7658d().setTargetAlbum(graphQLAlbum);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7699c(boolean z) {
        this.f6224e.a();
        m7659e().f6737m = z;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7700d(boolean z) {
        this.f6224e.a();
        m7659e().f6736l = z;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7669a(GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f6224e.a();
        m7659e().f6732h = graphQLPrivacyOption;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7666a(ComposerPrivacyData composerPrivacyData) {
        this.f6224e.a();
        m7659e().f6728d = composerPrivacyData;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7667a(ComposerSessionLoggingData composerSessionLoggingData) {
        this.f6224e.a();
        m7659e().f6731g = composerSessionLoggingData;
        return this;
    }

    public final Object m7682a(InlineSproutsState inlineSproutsState) {
        this.f6224e.a();
        m7659e().f6734j = inlineSproutsState;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7665a(MinutiaeObject minutiaeObject) {
        this.f6224e.a();
        m7658d().setMinutiaeObject(minutiaeObject);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7692b(ComposerLocationInfo composerLocationInfo) {
        this.f6224e.a();
        m7658d().setLocationInfo(composerLocationInfo);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7663a(ComposerAudienceEducatorData composerAudienceEducatorData) {
        this.f6224e.a();
        m7659e().f6733i = composerAudienceEducatorData;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7693b(RedSpaceValue redSpaceValue) {
        this.f6224e.a();
        m7658d().setRedSpaceValue(redSpaceValue);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final Object m7688a(boolean z) {
        this.f6224e.a();
        m7658d().setIsFeedOnlyPost(z);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7670a(GraphQLTextWithEntities graphQLTextWithEntities) {
        this.f6224e.a();
        m7658d().setTextWithEntities(graphQLTextWithEntities);
        this.f6220a.c(ComposerEvent.ON_STATUS_TEXT_CHANGED);
        return this;
    }

    public final TransactionImpl m7694b(ImmutableList<ComposerAttachment> immutableList) {
        this.f6224e.a();
        m7658d().setAttachments(immutableList);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7698c(ImmutableList<ComposerTaggedUser> immutableList) {
        this.f6224e.a();
        m7658d().setTaggedUsers(immutableList);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7673a(ComposerTargetData composerTargetData) {
        this.f6224e.a();
        m7659e().m8141a(composerTargetData, Long.parseLong((String) this.f6225f.get()));
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7695b(ImmutableList<GraphQLExploreFeed> immutableList, ImmutableList<GraphQLExploreFeed> immutableList2) {
        this.f6224e.a();
        m7658d().setPredictedTopics(immutableList).setTopics(immutableList2);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7671a(@Nullable ComposerPageData composerPageData) {
        this.f6224e.a();
        if (composerPageData instanceof ComposerPageData) {
            m7658d().setPageData(composerPageData);
        } else {
            m7658d().setPageData(ComposerPageData.a(composerPageData).a());
        }
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final Object m7686a(ImmutableList immutableList) {
        this.f6224e.a();
        m7658d().setRemovedURLs(immutableList);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7679a(ComposerAppAttribution composerAppAttribution) {
        this.f6224e.a();
        m7658d().setAppAttribution(composerAppAttribution);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7672a(ComposerStickerData composerStickerData) {
        this.f6224e.a();
        m7658d().setReferencedStickerData(composerStickerData);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7661a(long j) {
        this.f6224e.a();
        m7658d().setMarketplaceId(j);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7680a(ImmutableMap<String, CreativeEditingUsageParams> immutableMap) {
        this.f6224e.a();
        m7658d().m8145a((ImmutableMap) immutableMap);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7675a(ComposerLocation composerLocation) {
        this.f6224e.a();
        m7659e().f6730f = composerLocation;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7701e(boolean z) {
        this.f6224e.a();
        m7659e().f6740p = z;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final void m7689a() {
        ComposerModel a;
        this.f6224e.a();
        if (this.f6227h != null) {
            m7659e().f6727c = m7658d().m8146a();
        }
        C07691 c07691 = (C07691) Preconditions.checkNotNull(this.f6223d.get());
        if (this.f6226g != null) {
            a = m7659e().m8142a();
        } else {
            a = this.f6221b;
        }
        ImmutableSet b = this.f6220a.b();
        ComposerEventOriginator composerEventOriginator = this.f6222c;
        ComposerMutatorImpl composerMutatorImpl = c07691.f6181a;
        Preconditions.checkNotNull(composerMutatorImpl.f6186e);
        Preconditions.checkState(composerMutatorImpl.f6186e == this);
        composerMutatorImpl.f6186e = null;
        composerMutatorImpl.f6187f = a;
        Iterator it = b.iterator();
        while (it.hasNext()) {
            ComposerEvent composerEvent = (ComposerEvent) it.next();
            for (ComposerEventHandler a2 : composerMutatorImpl.f6185d) {
                a2.a(composerEvent, composerEventOriginator);
            }
        }
    }

    public final TransactionImpl m7691b(ComposerFacecastInfo composerFacecastInfo) {
        this.f6224e.a();
        m7658d().setFacecastInfo(composerFacecastInfo);
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7662a(SpannedString spannedString) {
        this.f6224e.a();
        m7659e().f6742r = spannedString;
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }

    public final TransactionImpl m7676a(@Nullable ComposerSlideshowData composerSlideshowData) {
        this.f6224e.a();
        if (composerSlideshowData == null || (composerSlideshowData instanceof ComposerSlideshowData)) {
            m7658d().setSlideshowData(composerSlideshowData);
        } else {
            m7658d().setSlideshowData(ComposerSlideshowData.a(composerSlideshowData).a());
        }
        this.f6220a.c(ComposerEvent.ON_DATASET_CHANGE);
        return this;
    }
}
