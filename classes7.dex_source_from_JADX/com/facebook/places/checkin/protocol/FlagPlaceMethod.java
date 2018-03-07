package com.facebook.places.checkin.protocol;

import com.facebook.common.time.Clock;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.places.checkin.models.FlagType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: initialProps */
public class FlagPlaceMethod implements ApiMethod<Params, Void> {
    private final Clock f11086a;

    /* compiled from: initialProps */
    public class Params {
        public final CheckinPlaceModel f11082a;
        public final FlagType f11083b;
        public final CrowdEntryPoint f11084c;
        public final CrowdEndpoint f11085d;

        public Params(CheckinPlaceModel checkinPlaceModel, FlagType flagType, CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
            this.f11082a = checkinPlaceModel;
            this.f11083b = flagType;
            this.f11084c = crowdEntryPoint;
            this.f11085d = crowdEndpoint;
        }
    }

    public final ApiRequest m13048a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        LongNode longNode = new LongNode(Long.parseLong(params.f11082a.cf_()));
        ArrayNode arrayNode = new ArrayNode(new JsonNodeFactory(false));
        arrayNode.a(longNode);
        a.add(new BasicNameValuePair("page_ids", arrayNode.toString()));
        a.add(new BasicNameValuePair("flag", params.f11083b.value));
        a.add(new BasicNameValuePair("value", "1"));
        a.add(new BasicNameValuePair("call_id", String.valueOf(this.f11086a.a())));
        a.add(new BasicNameValuePair("format", "JSON"));
        a.add(new BasicNameValuePair("entry_point", params.f11084c.getFullName()));
        a.add(new BasicNameValuePair("endpoint", params.f11085d.getFullName()));
        return new ApiRequest("FlagPlace", "GET", "method/places.setFlag", a, ApiResponseType.JSON);
    }

    @Inject
    public FlagPlaceMethod(Clock clock) {
        this.f11086a = clock;
    }

    public final Object m13049a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
