package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchFromStoryString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchFromStory;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromStoryModel.AttachmentsModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromStoryModel.AttachmentsModel.SubattachmentsModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel.Builder;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: key_send_invite */
public class StoryMediaQuery extends PaginatedMediaQuery<MediaFetchFromStory, IdQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10633b;

    @Inject
    public StoryMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10633b = mediaMetadataUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchFromStory> graphQLResult) {
        Preconditions.checkNotNull(graphQLResult);
        Collection a = Lists.a();
        ImmutableList a2 = ((MediaFetchFromStoryModel) graphQLResult.e).m12566a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            AttachmentsModel attachmentsModel = (AttachmentsModel) a2.get(i);
            if (attachmentsModel != null) {
                ImmutableList a3 = attachmentsModel.m12560a();
                int size2 = a3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    SubattachmentsModel subattachmentsModel = (SubattachmentsModel) a3.get(i2);
                    if (subattachmentsModel.m12557a() != null) {
                        a.add(subattachmentsModel.m12557a());
                    }
                }
            }
        }
        ImmutableList copyOf = ImmutableList.copyOf(a);
        Builder builder = new Builder();
        builder.f10597c = false;
        return new PageResult(copyOf, builder.m12605a());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchFromStoryString = new MediaFetchFromStoryString();
        mediaFetchFromStoryString.a("id", ((IdQueryParam) this.f10557a).f10637a);
        this.f10633b.m12711a(mediaFetchFromStoryString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchFromStoryString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
