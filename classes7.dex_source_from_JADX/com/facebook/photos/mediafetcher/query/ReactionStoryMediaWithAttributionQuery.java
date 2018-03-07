package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaWithAttributionFetchFromReactionStoryString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaWithAttributionFetchFromReactionStory;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaWithAttributionFetchFromReactionStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaWithAttributionFetchFromReactionStoryModel.ReactionAttachmentsModel.NodesModel;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: keyboardDidShow */
public class ReactionStoryMediaWithAttributionQuery extends PaginatedMediaQuery<MediaWithAttributionFetchFromReactionStory, IdQueryParam, PageMediaWithAttribution> {
    private final MediaMetadataUtil f10625b;

    @Inject
    public ReactionStoryMediaWithAttributionQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil) {
        super(idQueryParam, PageMediaWithAttribution.class, callerContext);
        this.f10625b = mediaMetadataUtil;
    }

    public final PageResult<PageMediaWithAttribution> mo601a(GraphQLResult<MediaWithAttributionFetchFromReactionStory> graphQLResult) {
        Collection arrayList = new ArrayList();
        ImmutableList a = ((MediaWithAttributionFetchFromReactionStoryModel) graphQLResult.e).m12635a().m12628a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel == null || nodesModel.m12623a() == null || nodesModel.m12623a().be_() == null || nodesModel.m12623a().k() == null || Strings.isNullOrEmpty(nodesModel.m12623a().k().b()) || nodesModel.m12623a().l() == null || nodesModel.m12623a().l().a() == null || Strings.isNullOrEmpty(nodesModel.m12623a().l().a().a())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                arrayList.add(nodesModel.m12623a());
            }
        }
        return new PageResult(ImmutableList.copyOf(arrayList), ((MediaWithAttributionFetchFromReactionStoryModel) graphQLResult.e).m12635a().m12629b());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaWithAttributionFetchFromReactionStoryString = new MediaWithAttributionFetchFromReactionStoryString();
        mediaWithAttributionFetchFromReactionStoryString.a("after_cursor", str).a("first_count", Integer.toString(i)).a("id", ((IdQueryParam) this.f10557a).f10637a).a("reaction_icon_scale", GraphQlQueryDefaults.a());
        this.f10625b.m12711a(mediaWithAttributionFetchFromReactionStoryString);
        GraphQLRequest a = GraphQLRequest.a(mediaWithAttributionFetchFromReactionStoryString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
