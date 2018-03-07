package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchFromMediaSetIdString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchFromMediaSetId;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromMediaSetIdModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromMediaSetIdModel.MediaModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel.Builder;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: key_staging_ground_launch_config */
public class SetIdMediaQuery extends PaginatedMediaQuery<MediaFetchFromMediaSetId, IdQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10626b;
    private final String f10627c;
    private final Lazy<FbErrorReporter> f10628d;

    @Inject
    public SetIdMediaQuery(@Assisted IdQueryParam idQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil, Lazy<FbErrorReporter> lazy) {
        super(idQueryParam, MediaMetadata.class, callerContext);
        this.f10627c = idQueryParam.f10637a;
        this.f10626b = mediaMetadataUtil;
        this.f10628d = lazy;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchFromMediaSetId> graphQLResult) {
        Collection a = Lists.a();
        MediaModel mediaModel = null;
        if (graphQLResult.e != null) {
            mediaModel = ((MediaFetchFromMediaSetIdModel) graphQLResult.e).m12510a();
        }
        if (mediaModel == null) {
            ((AbstractFbErrorReporter) this.f10628d.get()).b("MediaGallery: SedIdMediaQuery", "getMedia NULL, albumId: " + this.f10627c);
            ImmutableList copyOf = ImmutableList.copyOf(a);
            Builder builder = new Builder();
            builder.f10597c = false;
            return new PageResult(copyOf, builder.m12605a());
        }
        MediaPageInfoModel b;
        ImmutableList a2 = mediaModel.m12503a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            MediaMetadata mediaMetadata = (MediaMetadata) a2.get(i);
            if (!(mediaMetadata == null || mediaMetadata.be_() == null)) {
                a.add(mediaMetadata);
            }
        }
        if (((MediaFetchFromMediaSetIdModel) graphQLResult.e).m12510a().m12504b() != null) {
            b = ((MediaFetchFromMediaSetIdModel) graphQLResult.e).m12510a().m12504b();
        } else {
            Builder builder2 = new Builder();
            builder2.f10597c = false;
            b = builder2.m12605a();
        }
        return new PageResult(ImmutableList.copyOf(a), b);
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchFromMediaSetIdString = new MediaFetchFromMediaSetIdString();
        mediaFetchFromMediaSetIdString.a("after_cursor", str).a("first_count", Integer.toString(i)).a("id", ((IdQueryParam) this.f10557a).f10637a);
        this.f10626b.m12711a(mediaFetchFromMediaSetIdString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchFromMediaSetIdString).a(RequestPriority.INTERACTIVE);
        a.f = this.f10612c;
        return a;
    }
}
