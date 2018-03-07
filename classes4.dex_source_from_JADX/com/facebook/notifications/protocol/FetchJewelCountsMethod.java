package com.facebook.notifications.protocol;

import com.facebook.common.time.Clock;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: messenger_media_upload_phase_two_start */
public class FetchJewelCountsMethod implements ApiMethod<Void, FetchJewelCountsResult> {
    private static final String f7965a = BootstrapRequestName.GET_NOTIFICATION_COUNT.requestNameString;
    private final GraphQLProtocolHelper f7966b;
    private final Clock f7967c;

    @Inject
    public FetchJewelCountsMethod(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock) {
        this.f7966b = graphQLProtocolHelper;
        this.f7967c = clock;
    }

    public final ApiRequest m8292a(@Nullable Object obj) {
        List a = Lists.a(2);
        a.add(new BasicNameValuePair("call_id", String.valueOf(this.f7967c.a())));
        a.add(new BasicNameValuePair("format", "JSON"));
        return new ApiRequest(f7965a, TigonRequest.GET, "method/notifications.get", RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSONPARSER);
    }

    public final Object m8293a(@Nullable Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (FetchJewelCountsResult) this.f7966b.a(apiResponse.d(), FetchJewelCountsResult.class, f7965a);
    }
}
