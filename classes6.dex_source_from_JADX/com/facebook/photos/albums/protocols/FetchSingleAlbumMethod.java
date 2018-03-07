package com.facebook.photos.albums.protocols;

import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumDetailAccessibilityQueryString;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumDetailQueryString;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumSimpleAccessibilityQueryString;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumSimpleQueryString;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: invalid operation size */
public class FetchSingleAlbumMethod extends AbstractPersistedGraphQlApiMethod<FetchSingleAlbumParams, GraphQLAlbum> {
    private static final ScaleInputPixelRatio f12359c = ScaleInputPixelRatio.NUMBER_3;
    private final GraphQLProtocolHelper f12360d;
    private final GraphQLImageHelper f12361e;

    public static FetchSingleAlbumMethod m19425a(InjectorLike injectorLike) {
        return new FetchSingleAlbumMethod(GraphQLProtocolHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike));
    }

    public final GraphQlQueryString m19428f(Object obj) {
        GraphQlQueryString albumSimpleQueryString;
        FetchSingleAlbumParams fetchSingleAlbumParams = (FetchSingleAlbumParams) obj;
        Preconditions.checkNotNull(fetchSingleAlbumParams);
        Preconditions.checkNotNull(fetchSingleAlbumParams.f12362a);
        switch (AlbumQueryType.values()[fetchSingleAlbumParams.f12370i]) {
            case SIMPLE:
                albumSimpleQueryString = new AlbumSimpleQueryString();
                break;
            case SIMPLE_ACCESSIBILITY:
                albumSimpleQueryString = new AlbumSimpleAccessibilityQueryString();
                break;
            case DETAIL_ACCESSIBILITY:
                albumSimpleQueryString = new AlbumDetailAccessibilityQueryString();
                break;
            default:
                albumSimpleQueryString = new AlbumDetailQueryString();
                break;
        }
        albumSimpleQueryString.a("node_id", fetchSingleAlbumParams.f12362a);
        albumSimpleQueryString.a("before", fetchSingleAlbumParams.f12363b);
        albumSimpleQueryString.a("after", fetchSingleAlbumParams.f12364c);
        albumSimpleQueryString.a("media_type", this.f12361e.a());
        if (fetchSingleAlbumParams.f12365d > 0) {
            albumSimpleQueryString.a("first", String.valueOf(fetchSingleAlbumParams.f12365d));
        }
        if (fetchSingleAlbumParams.f12366e > 0) {
            albumSimpleQueryString.a("image_width", String.valueOf(GraphQLImageHelper.a(fetchSingleAlbumParams.f12366e)));
        }
        if (fetchSingleAlbumParams.f12367f > 0) {
            albumSimpleQueryString.a("image_height", String.valueOf(this.f12361e.a(fetchSingleAlbumParams.f12366e, fetchSingleAlbumParams.f12367f)));
        }
        if (fetchSingleAlbumParams.f12368g > 0) {
            albumSimpleQueryString.a("contributor_pic_width", String.valueOf(GraphQLImageHelper.a(fetchSingleAlbumParams.f12368g)));
        }
        if (fetchSingleAlbumParams.f12369h > 0) {
            albumSimpleQueryString.a("contributor_pic_height", String.valueOf(this.f12361e.a(fetchSingleAlbumParams.f12368g, fetchSingleAlbumParams.f12369h)));
        }
        albumSimpleQueryString.a("scale", f12359c);
        return albumSimpleQueryString;
    }

    @Inject
    public FetchSingleAlbumMethod(GraphQLProtocolHelper graphQLProtocolHelper, GraphQLImageHelper graphQLImageHelper) {
        super(graphQLProtocolHelper);
        this.f12360d = graphQLProtocolHelper;
        this.f12361e = graphQLImageHelper;
    }

    public final Object m19426a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (GraphQLAlbum) this.f12360d.a(jsonParser, GraphQLAlbum.class, "FetchSingleAlbumMethod");
    }

    public final int m19427b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
