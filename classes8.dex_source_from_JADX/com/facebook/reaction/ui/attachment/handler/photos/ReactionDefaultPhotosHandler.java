package com.facebook.reaction.ui.attachment.handler.photos;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchFromReactionStory;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromReactionStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromReactionStoryModel.ReactionAttachmentsModel.NodesModel;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_PROFILE_TAP */
public class ReactionDefaultPhotosHandler extends ReactionPhotosHandler<MediaFetchFromReactionStory, SizeAwareMedia> {
    private final ReactionUtil f20981c;

    @Inject
    public ReactionDefaultPhotosHandler(ReactionExperimentController reactionExperimentController, Provider<HScrollLinearLayoutManager> provider, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionMediaGalleryUtil reactionMediaGalleryUtil, ReactionUtil reactionUtil, @Assisted GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        super(reactionExperimentController, provider, reactionIntentFactory, reactionIntentLauncher, reactionMediaGalleryUtil, graphQLReactionStoryAttachmentsStyle);
        this.f20981c = reactionUtil;
    }

    protected final ReactionPhotosRecyclerAdapter mo1145c(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        return new ReactionDefaultPhotosRecyclerAdapter(this, reactionAttachmentsModel, str, str2);
    }

    protected final void mo1142a(String str, String str2, int i, CallerContext callerContext) {
        this.f20981c.m22669b(str, str2, i, callerContext, m24630g());
    }

    @Nullable
    protected final List<SizeAwareMedia> mo1141a(@Nullable GraphQLResult<MediaFetchFromReactionStory> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null) {
            return null;
        }
        List<SizeAwareMedia> arrayList = new ArrayList();
        MediaFetchFromReactionStoryModel.ReactionAttachmentsModel a = ((MediaFetchFromReactionStoryModel) graphQLResult.e).a();
        if (a == null || a.a().isEmpty()) {
            return null;
        }
        String a2;
        ImmutableList a3 = a.a();
        int size = a3.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a3.get(i);
            if (nodesModel != null && mo1143a(nodesModel.a())) {
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
        return reactionStoryAttachmentFragmentModel.E();
    }

    protected final boolean mo1143a(@Nullable SizeAwareMedia sizeAwareMedia) {
        return ReactionDefaultPhotosRecyclerAdapter.m24642a(sizeAwareMedia);
    }
}
