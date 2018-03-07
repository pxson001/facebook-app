package com.facebook.feed.util.composer;

import android.content.Context;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.ThumbnailMaker;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.metatext.MinutiaeTemplateMetaTextBuilder;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.groupcommerce.util.GraphQLProductItemAttachmentCreator;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: shorturl */
public class OptimisticPostStoryBuilderProvider extends AbstractAssistedProvider<OptimisticPostStoryBuilder> {
    public final OptimisticPostStoryBuilder m4479a(GraphQLTextWithEntities graphQLTextWithEntities, ImmutableList<ComposerTaggedUser> immutableList, ImmutableList<ComposerAttachment> immutableList2) {
        return new OptimisticPostStoryBuilder((Context) getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(this), GraphQLLinkExtractor.a(this), MinutiaeTemplateMetaTextBuilder.m1391b((InjectorLike) this), BitmapUtils.a(this), ThumbnailMaker.b(this), GraphQLProductItemAttachmentCreator.m6180a(this), OptimisticStoryStateCache.a(this), OptimisticPostCollageChooser.m4445b(this), IdBasedSingletonScopeProvider.b(this, 600), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), graphQLTextWithEntities, immutableList, immutableList2);
    }
}
