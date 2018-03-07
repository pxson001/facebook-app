package com.facebook.photos.data.method;

import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.data.protocol.FetchPhotosMetadataQuery.FetchPhotosMetadataQueryString;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: ib */
public class FetchPhotosMetadataMethod extends AbstractPersistedGraphQlApiMethod<FetchPhotosMetadataParams, FetchPhotosMetadataResult> {
    private SizeAwareImageUtil f12942c;

    /* compiled from: ib */
    class C08361 extends TypeReference<LinkedHashMap<String, GraphQLPhoto>> {
        final /* synthetic */ FetchPhotosMetadataMethod f12941b;

        C08361(FetchPhotosMetadataMethod fetchPhotosMetadataMethod) {
            this.f12941b = fetchPhotosMetadataMethod;
        }
    }

    public static FetchPhotosMetadataMethod m20313a(InjectorLike injectorLike) {
        return new FetchPhotosMetadataMethod(GraphQLProtocolHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike));
    }

    public final GraphQlQueryString m20316f(Object obj) {
        FetchPhotosMetadataParams fetchPhotosMetadataParams = (FetchPhotosMetadataParams) obj;
        TypedGraphQlQueryString fetchPhotosMetadataQueryString = new FetchPhotosMetadataQueryString();
        fetchPhotosMetadataQueryString.b(true);
        if (fetchPhotosMetadataParams == null) {
            return fetchPhotosMetadataQueryString;
        }
        List a = Lists.a(fetchPhotosMetadataParams.f12943a.size());
        for (Long longValue : fetchPhotosMetadataParams.f12943a) {
            a.add(Long.toString(longValue.longValue()));
        }
        this.f12942c.a(fetchPhotosMetadataQueryString);
        fetchPhotosMetadataQueryString.a("nodes", a);
        return fetchPhotosMetadataQueryString;
    }

    public final RequestPriority m20317j(Object obj) {
        FetchCause fetchCause;
        FetchPhotosMetadataParams fetchPhotosMetadataParams = (FetchPhotosMetadataParams) obj;
        if (fetchPhotosMetadataParams.f12944b == null) {
            fetchCause = null;
        } else {
            fetchCause = fetchPhotosMetadataParams.f12944b.f12753a;
        }
        return fetchCause.getMetadataRecommendedRequestPriority();
    }

    @Inject
    public FetchPhotosMetadataMethod(GraphQLProtocolHelper graphQLProtocolHelper, SizeAwareImageUtil sizeAwareImageUtil) {
        super(graphQLProtocolHelper);
        this.f12942c = sizeAwareImageUtil;
    }

    public final Object m20314a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return new FetchPhotosMetadataResult(Lists.b(((Map) jsonParser.a(new C08361(this))).values()));
    }

    public final int m20315b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
