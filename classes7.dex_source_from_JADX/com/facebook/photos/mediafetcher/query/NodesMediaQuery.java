package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchByIdsString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel.Builder;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: label_two */
public class NodesMediaQuery extends PaginatedMediaQuery<MediaMetadata, MultiIdQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10616b;

    /* compiled from: label_two */
    class C09001 implements Comparator<MediaMetadata> {
        final /* synthetic */ NodesMediaQuery f10615a;

        C09001(NodesMediaQuery nodesMediaQuery) {
            this.f10615a = nodesMediaQuery;
        }

        public int compare(Object obj, Object obj2) {
            return ((MultiIdQueryParam) this.f10615a.f10557a).f10640a.indexOf(((MediaMetadata) obj).d()) - ((MultiIdQueryParam) this.f10615a.f10557a).f10640a.indexOf(((MediaMetadata) obj2).d());
        }
    }

    @Inject
    public NodesMediaQuery(@Assisted MultiIdQueryParam multiIdQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil) {
        super(multiIdQueryParam, MediaMetadata.class, callerContext);
        this.f10616b = mediaMetadataUtil;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaMetadata> graphQLResult) {
        Preconditions.checkNotNull(graphQLResult);
        Collection a = Lists.a();
        for (Object next : graphQLResult.e()) {
            if (next != null && (next instanceof MediaMetadata)) {
                MediaMetadata mediaMetadata = (MediaMetadata) next;
                if (mediaMetadata.be_() != null) {
                    a.add(mediaMetadata);
                }
            }
        }
        Collections.sort(a, new C09001(this));
        ImmutableList copyOf = ImmutableList.copyOf(a);
        Builder builder = new Builder();
        builder.f10597c = false;
        return new PageResult(copyOf, builder.m12605a());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchByIdsString = new MediaFetchByIdsString();
        mediaFetchByIdsString.a("ids", ((MultiIdQueryParam) this.f10557a).f10640a);
        this.f10616b.m12711a(mediaFetchByIdsString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchByIdsString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
