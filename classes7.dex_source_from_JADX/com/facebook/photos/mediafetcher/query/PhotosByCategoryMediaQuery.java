package com.facebook.photos.mediafetcher.query;

import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchPhotosByCategoryString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPhotosByCategoryModel;
import com.facebook.photos.mediafetcher.query.param.CategoryQueryParam;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: label_one_color */
public class PhotosByCategoryMediaQuery extends PaginatedMediaQuery<MediaFetchPhotosByCategoryModel, CategoryQueryParam, MediaMetadata> {
    private final FetchReactorsParamBuilderUtil f10617b;
    private final FetchRecentActivityParamBuilderUtil f10618c;

    @Inject
    public PhotosByCategoryMediaQuery(@Assisted CategoryQueryParam categoryQueryParam, @Nullable @Assisted CallerContext callerContext, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil) {
        super(categoryQueryParam, MediaMetadata.class, callerContext);
        this.f10617b = fetchReactorsParamBuilderUtil;
        this.f10618c = fetchRecentActivityParamBuilderUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchPhotosByCategoryModel> graphQLResult) {
        return new PageResult(((MediaFetchPhotosByCategoryModel) graphQLResult.e).m12602a().m12597a(), ((MediaFetchPhotosByCategoryModel) graphQLResult.e).m12602a().m12598j());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchPhotosByCategoryString = new MediaFetchPhotosByCategoryString();
        mediaFetchPhotosByCategoryString.a("after_cursor", str).a("count", Integer.valueOf(i)).a("page_id", ((CategoryQueryParam) this.f10557a).f10634a).a("category", ((CategoryQueryParam) this.f10557a).f10635b).a("entry_point", ((CategoryQueryParam) this.f10557a).f10636c);
        this.f10617b.a(mediaFetchPhotosByCategoryString);
        this.f10618c.a(mediaFetchPhotosByCategoryString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchPhotosByCategoryString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
