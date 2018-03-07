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
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchPageMenusString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPageMenusModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPageMenusModel.PagePhotoMenusModel.NodesModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPageMenusModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel.Builder;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: label_two_color */
public class MenuPhotosMediaQuery extends PaginatedMediaQuery<MediaFetchPageMenusModel, IdQueryParam, MediaMetadata> {
    private final FetchReactorsParamBuilderUtil f10613b;
    private final FetchRecentActivityParamBuilderUtil f10614c;

    @Inject
    public MenuPhotosMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10613b = fetchReactorsParamBuilderUtil;
        this.f10614c = fetchRecentActivityParamBuilderUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchPageMenusModel> graphQLResult) {
        if (graphQLResult.e == null || ((MediaFetchPageMenusModel) graphQLResult.e).m12589a() == null || ((MediaFetchPageMenusModel) graphQLResult.e).m12589a().m12585a().isEmpty() || ((NodesModel) ((MediaFetchPageMenusModel) graphQLResult.e).m12589a().m12585a().get(0)).m12581a() == null) {
            ImmutableList immutableList = RegularImmutableList.a;
            Builder builder = new Builder();
            builder.f10597c = false;
            return new PageResult(immutableList, builder.m12605a());
        }
        MediaPageInfoModel a;
        PagePhotoMenuPhotosModel a2 = ((NodesModel) ((MediaFetchPageMenusModel) graphQLResult.e).m12589a().m12585a().get(0)).m12581a();
        if (a2.m12577j() == null) {
            Builder builder2 = new Builder();
            builder2.f10597c = false;
            a = builder2.m12605a();
        } else {
            a = a2.m12577j();
        }
        return new PageResult(a2.m12576a(), a);
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchPageMenusString = new MediaFetchPageMenusString();
        mediaFetchPageMenusString.a("page_id", ((IdQueryParam) this.f10557a).f10637a).a("after_cursor", str).a("count", Integer.valueOf(i));
        this.f10613b.a(mediaFetchPageMenusString);
        this.f10614c.a(mediaFetchPageMenusString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchPageMenusString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
