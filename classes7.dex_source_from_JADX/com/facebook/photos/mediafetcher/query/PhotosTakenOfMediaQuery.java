package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchForPhotosTakenOfString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchForPhotosTakenOf;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForPhotosTakenOfModel;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: kind */
public class PhotosTakenOfMediaQuery extends PaginatedMediaQuery<MediaFetchForPhotosTakenOf, IdQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10620b;

    @Inject
    public PhotosTakenOfMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10620b = mediaMetadataUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchForPhotosTakenOf> graphQLResult) {
        Collection a = Lists.a();
        ImmutableList a2 = ((MediaFetchForPhotosTakenOfModel) graphQLResult.e).m12470a().m12464a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            MediaMetadata mediaMetadata = (MediaMetadata) a2.get(i);
            if (!(mediaMetadata == null || mediaMetadata.be_() == null)) {
                a.add(mediaMetadata);
            }
        }
        return new PageResult(ImmutableList.copyOf(a), ((MediaFetchForPhotosTakenOfModel) graphQLResult.e).m12470a().m12465b());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchForPhotosTakenOfString = new MediaFetchForPhotosTakenOfString();
        mediaFetchForPhotosTakenOfString.a("after_cursor", str).a("first_count", Integer.toString(i)).a("node_id", ((IdQueryParam) this.f10557a).f10637a);
        this.f10620b.m12711a(mediaFetchForPhotosTakenOfString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchForPhotosTakenOfString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
