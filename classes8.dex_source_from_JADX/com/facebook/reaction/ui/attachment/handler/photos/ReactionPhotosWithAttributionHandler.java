package com.facebook.reaction.ui.attachment.handler.photos;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaWithAttributionFetchFromReactionStory;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaWithAttributionFetchFromReactionStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaWithAttributionFetchFromReactionStoryModel.ReactionAttachmentsModel.NodesModel;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_PAGE_SHARES */
public class ReactionPhotosWithAttributionHandler extends ReactionPhotosHandler<MediaWithAttributionFetchFromReactionStory, PageMediaWithAttribution> {
    private final ReactionPhotosWithAttributionRecyclerAdapterProvider f20995c;
    private final ReactionUtil f20996d;

    @Inject
    public ReactionPhotosWithAttributionHandler(ReactionPhotosWithAttributionRecyclerAdapterProvider reactionPhotosWithAttributionRecyclerAdapterProvider, ReactionExperimentController reactionExperimentController, Provider<HScrollLinearLayoutManager> provider, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionMediaGalleryUtil reactionMediaGalleryUtil, ReactionUtil reactionUtil, @Assisted GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        super(reactionExperimentController, provider, reactionIntentFactory, reactionIntentLauncher, reactionMediaGalleryUtil, graphQLReactionStoryAttachmentsStyle);
        this.f20995c = reactionPhotosWithAttributionRecyclerAdapterProvider;
        this.f20996d = reactionUtil;
    }

    protected final ReactionPhotosRecyclerAdapter mo1145c(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        ReactionPhotosWithAttributionRecyclerAdapterProvider reactionPhotosWithAttributionRecyclerAdapterProvider = this.f20995c;
        return new ReactionPhotosWithAttributionRecyclerAdapter(Locales.a(reactionPhotosWithAttributionRecyclerAdapterProvider), (TimeFormatUtil) DefaultTimeFormatUtil.a(reactionPhotosWithAttributionRecyclerAdapterProvider), this, reactionAttachmentsModel, str, str2);
    }

    protected final void mo1142a(String str, String str2, int i, CallerContext callerContext) {
        this.f20996d.m22665a(str, str2, i, callerContext, m24630g());
    }

    @Nullable
    protected final List<PageMediaWithAttribution> mo1141a(@Nullable GraphQLResult<MediaWithAttributionFetchFromReactionStory> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null) {
            return null;
        }
        List<PageMediaWithAttribution> arrayList = new ArrayList();
        MediaWithAttributionFetchFromReactionStoryModel.ReactionAttachmentsModel a = ((MediaWithAttributionFetchFromReactionStoryModel) graphQLResult.e).a();
        if (a == null || a.a().isEmpty()) {
            return null;
        }
        String a2;
        ImmutableList a3 = a.a();
        int size = a3.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a3.get(i);
            if (nodesModel != null && m24647a(nodesModel.a())) {
                arrayList.add(nodesModel.a());
            }
        }
        if (a.b() != null) {
            a2 = a.b().a();
        } else {
            a2 = null;
        }
        this.f20971h = a2;
        return arrayList;
    }

    protected final SizeAwareMedia mo1144c(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return reactionStoryAttachmentFragmentModel.P();
    }

    private static boolean m24647a(@Nullable PageMediaWithAttribution pageMediaWithAttribution) {
        return (pageMediaWithAttribution == null || Strings.isNullOrEmpty(pageMediaWithAttribution.d()) || pageMediaWithAttribution.bc_() == null || pageMediaWithAttribution.bc_().b() == null || pageMediaWithAttribution.k() == null || Strings.isNullOrEmpty(pageMediaWithAttribution.k().b()) || pageMediaWithAttribution.l() == null || pageMediaWithAttribution.l().a() == null || Strings.isNullOrEmpty(pageMediaWithAttribution.l().a().a())) ? false : true;
    }
}
