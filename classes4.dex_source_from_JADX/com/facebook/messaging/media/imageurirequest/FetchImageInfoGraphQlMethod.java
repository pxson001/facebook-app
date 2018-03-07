package com.facebook.messaging.media.imageurirequest;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragment.DownloadImageFragmentString;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentInterfaces.DownloadImageFragment;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentModels.DownloadImageFragmentModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: pymi_cancel */
public class FetchImageInfoGraphQlMethod extends AbstractPersistedGraphQlApiMethod<FetchImageParams, DownloadImageFragment> {
    public static FetchImageInfoGraphQlMethod m4493b(InjectorLike injectorLike) {
        return new FetchImageInfoGraphQlMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m4496f(Object obj) {
        FetchImageParams fetchImageParams = (FetchImageParams) obj;
        return new DownloadImageFragmentString().a("fbid", fetchImageParams.a).a("img_size", Integer.valueOf(fetchImageParams.b));
    }

    @Inject
    public FetchImageInfoGraphQlMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m4494a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (DownloadImageFragmentModel) jsonParser.a(DownloadImageFragmentModel.class);
    }

    public final int m4495b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public static FetchImageInfoGraphQlMethod m4492a(InjectorLike injectorLike) {
        return m4493b(injectorLike);
    }
}
