package com.facebook.privacy.checkup.protocol;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckup.FetchGenericPrivacyReviewQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: page/{#%s}/recommendations */
public class FetchGenericPrivacyReviewMethod extends AbstractPersistedGraphQlApiMethod<FetchGenericPrivacyReviewParams, FetchGenericPrivacyReviewQueryModel> {
    private static FetchGenericPrivacyReviewMethod m5407b(InjectorLike injectorLike) {
        return new FetchGenericPrivacyReviewMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    public final GraphQlQueryString m5410f(Object obj) {
        FetchGenericPrivacyReviewParams fetchGenericPrivacyReviewParams = (FetchGenericPrivacyReviewParams) obj;
        FetchGenericPrivacyReviewQueryString d = FetchPrivacyCheckup.m5523d();
        d.a("max_num_steps", Integer.valueOf(fetchGenericPrivacyReviewParams.f4420a));
        d.a("privacy_review_type", fetchGenericPrivacyReviewParams.f4421b);
        d.a("item_count", String.valueOf(fetchGenericPrivacyReviewParams.f4422c));
        d.a("after", fetchGenericPrivacyReviewParams.f4423d);
        d.a("image_scale", fetchGenericPrivacyReviewParams.f4424e);
        d.a("review_id", fetchGenericPrivacyReviewParams.f4425f);
        return d;
    }

    @Inject
    public FetchGenericPrivacyReviewMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m5408a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (FetchGenericPrivacyReviewQueryModel) jsonParser.a(FetchGenericPrivacyReviewQueryModel.class);
    }

    public final int m5409b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
