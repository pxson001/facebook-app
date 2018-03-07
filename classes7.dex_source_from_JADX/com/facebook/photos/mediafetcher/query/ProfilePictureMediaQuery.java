package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel.Builder;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchForProfilePictureString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchForProfilePicture;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForProfilePictureModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: keyboard_down */
public class ProfilePictureMediaQuery extends PaginatedMediaQuery<MediaFetchForProfilePicture, IdQueryParam, MediaMetadata> {
    private final SizeAwareImageUtil f10622b;
    private final AbstractFbErrorReporter f10623c;

    @Inject
    public ProfilePictureMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, SizeAwareImageUtil sizeAwareImageUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10622b = sizeAwareImageUtil;
        this.f10623c = abstractFbErrorReporter;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchForProfilePicture> graphQLResult) {
        ImmutableList immutableList;
        if (graphQLResult == null || graphQLResult.e == null) {
            ImmutableList immutableList2 = RegularImmutableList.a;
            this.f10623c.a(SoftError.b(getClass().getSimpleName(), "Result is null for profile id: " + ((IdQueryParam) this.f10557a).f10637a));
            immutableList = immutableList2;
        } else {
            Builder builder = new Builder();
            builder.y = ((IdQueryParam) this.f10557a).f10637a;
            builder = builder;
            builder.A = DefaultImageFieldsModel.a(((MediaFetchForProfilePictureModel) graphQLResult.e).m12493a());
            immutableList = ImmutableList.of(builder.a());
        }
        return new PageResult(immutableList, new MediaPageInfoModel.Builder().m12605a());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchForProfilePictureString = new MediaFetchForProfilePictureString();
        mediaFetchForProfilePictureString.a("profile_id", ((IdQueryParam) this.f10557a).f10637a);
        this.f10622b.a(mediaFetchForProfilePictureString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchForProfilePictureString).a(RequestPriority.INTERACTIVE);
        a.f = this.f10612c;
        return a;
    }
}
