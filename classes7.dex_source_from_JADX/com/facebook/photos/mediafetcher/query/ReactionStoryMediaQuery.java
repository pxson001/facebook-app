package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchFromReactionStoryString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchFromReactionStory;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromReactionStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromReactionStoryModel.ReactionAttachmentsModel.NodesModel;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: keyboard_ */
public class ReactionStoryMediaQuery extends PaginatedMediaQuery<MediaFetchFromReactionStory, IdQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10624b;

    @Inject
    public ReactionStoryMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10624b = mediaMetadataUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchFromReactionStory> graphQLResult) {
        Collection a = Lists.a();
        ImmutableList a2 = ((MediaFetchFromReactionStoryModel) graphQLResult.e).m12547a().m12540a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a2.get(i);
            if (!(nodesModel == null || nodesModel.m12535a() == null || nodesModel.m12535a().be_() == null)) {
                a.add(nodesModel.m12535a());
            }
        }
        return new PageResult(ImmutableList.copyOf(a), ((MediaFetchFromReactionStoryModel) graphQLResult.e).m12547a().m12541b());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchFromReactionStoryString = new MediaFetchFromReactionStoryString();
        mediaFetchFromReactionStoryString.a("after_cursor", str).a("first_count", Integer.toString(i)).a("id", ((IdQueryParam) this.f10557a).f10637a);
        this.f10624b.m12711a(mediaFetchFromReactionStoryString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchFromReactionStoryString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
