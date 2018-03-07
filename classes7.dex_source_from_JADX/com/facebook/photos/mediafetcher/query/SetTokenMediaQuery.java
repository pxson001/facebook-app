package com.facebook.photos.mediafetcher.query;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.PageResult;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueries.MediaFetchFromMediaSetTokenString;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaFetchFromMediaSetToken;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromMediaSetTokenModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel.Builder;
import com.facebook.photos.mediafetcher.query.param.MediaTypeQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: key_send_social_prompt_invite */
public class SetTokenMediaQuery extends PaginatedMediaQuery<MediaFetchFromMediaSetToken, MediaTypeQueryParam, MediaMetadata> {
    private final MediaMetadataUtil f10629b;
    private final AbstractFbErrorReporter f10630c;
    private final String f10631d;
    private final AutomaticPhotoCaptioningUtils f10632e;

    @Inject
    public SetTokenMediaQuery(@Assisted MediaTypeQueryParam mediaTypeQueryParam, @Nullable @Assisted CallerContext callerContext, MediaMetadataUtil mediaMetadataUtil, AbstractFbErrorReporter abstractFbErrorReporter, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        super(mediaTypeQueryParam, MediaMetadata.class, callerContext);
        this.f10629b = mediaMetadataUtil;
        this.f10630c = abstractFbErrorReporter;
        this.f10631d = mediaTypeQueryParam.f10638a;
        this.f10632e = automaticPhotoCaptioningUtils;
    }

    public final PageResult<MediaMetadata> mo601a(GraphQLResult<MediaFetchFromMediaSetToken> graphQLResult) {
        boolean z;
        boolean z2;
        int i = 0;
        Collection a = Lists.a();
        boolean z3 = graphQLResult == null;
        if (z3 || graphQLResult.e != null) {
            z = false;
        } else {
            z = true;
        }
        if (z || ((MediaFetchFromMediaSetTokenModel) graphQLResult.e).m12526a() != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z3 || z || z2) {
            this.f10630c.a(SoftError.b("MediaGallery:" + getClass().getSimpleName(), "null in response, set id: " + this.f10631d + ", resultIsNull: " + z3 + ", getResultIsNull: " + z + ", mediaIsNull: " + z2));
            ImmutableList copyOf = ImmutableList.copyOf(a);
            Builder builder = new Builder();
            builder.f10597c = false;
            return new PageResult(copyOf, builder.m12605a());
        }
        copyOf = ((MediaFetchFromMediaSetTokenModel) graphQLResult.e).m12526a().m12519a();
        int size = copyOf.size();
        while (i < size) {
            MediaMetadata mediaMetadata = (MediaMetadata) copyOf.get(i);
            if (!(mediaMetadata == null || mediaMetadata.be_() == null)) {
                a.add(mediaMetadata);
            }
            i++;
        }
        return new PageResult(ImmutableList.copyOf(a), ((MediaFetchFromMediaSetTokenModel) graphQLResult.e).m12526a().m12520b());
    }

    public final GraphQLRequest mo600a(int i, @Nullable String str) {
        GraphQlQueryString mediaFetchFromMediaSetTokenString = new MediaFetchFromMediaSetTokenString();
        mediaFetchFromMediaSetTokenString.a("after_cursor", str).a("first_count", Integer.toString(i)).a("node_id", ((MediaTypeQueryParam) this.f10557a).f10638a).a("query_media_type", ((MediaTypeQueryParam) this.f10557a).f10639b).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10632e.a()));
        this.f10629b.m12711a(mediaFetchFromMediaSetTokenString);
        GraphQLRequest a = GraphQLRequest.a(mediaFetchFromMediaSetTokenString);
        a.f = this.f10612c;
        return a.a(RequestPriority.INTERACTIVE);
    }
}
