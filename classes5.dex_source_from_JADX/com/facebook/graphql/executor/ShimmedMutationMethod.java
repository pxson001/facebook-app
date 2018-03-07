package com.facebook.graphql.executor;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.graphql.query.ShimmedMutationRequestParams;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.Assisted;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: legacy_api_story_id */
public class ShimmedMutationMethod implements ApiMethod<TypedGraphQLMutationString, String> {
    private final String f3240a;
    private final boolean f3241b;
    private final FbObjectMapper f3242c;

    public final ApiRequest m6298a(Object obj) {
        String str;
        TypedGraphQLMutationString typedGraphQLMutationString = (TypedGraphQLMutationString) obj;
        ShimmedMutationRequestParams shimmedMutationRequestParams = typedGraphQLMutationString.b;
        Map e = typedGraphQLMutationString.a.e();
        if (this.f3240a != null) {
            str = "shimmedMutation_" + shimmedMutationRequestParams.f4803a + this.f3240a;
        } else {
            str = "shimmedMutation_" + shimmedMutationRequestParams.f4803a;
        }
        List c = shimmedMutationRequestParams.m9605c(e, this.f3242c);
        if (this.f3241b) {
            c.add(new BasicNameValuePair("is_offline", "true"));
        }
        return new ApiRequest(str, shimmedMutationRequestParams.f4804b, shimmedMutationRequestParams.m9604b(e, this.f3242c), RequestPriority.INTERACTIVE, c, ApiResponseType.JSON);
    }

    @Inject
    public ShimmedMutationMethod(@Assisted String str, @Assisted boolean z, FbObjectMapper fbObjectMapper) {
        this.f3242c = fbObjectMapper;
        this.f3241b = z;
        this.f3240a = str;
    }

    public final Object m6299a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        if (c != null) {
            return c.toString();
        }
        return null;
    }
}
