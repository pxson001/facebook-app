package com.facebook.nearby.protocol;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.model.NearbyLayoutResponse;
import com.facebook.nearby.model.NearbyPlaceLayout;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: underline */
public class FetchNearbyPlacesLayoutMethod implements ApiMethod<FetchNearbyPlacesLayoutParams, FetchNearbyPlacesLayoutResult> {
    private static final Class<?> f519a = FetchNearbyPlacesLayoutMethod.class;
    private final Clock f520b;

    public static FetchNearbyPlacesLayoutMethod m645b(InjectorLike injectorLike) {
        return new FetchNearbyPlacesLayoutMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchNearbyPlacesLayoutMethod(Clock clock) {
        this.f520b = clock;
    }

    public final ApiRequest m646a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("places", "{result=nearby_tiles:$..tiles.edges..node..edges..node.id}"));
        a.add(new BasicNameValuePair("hash", "{result=nearby_tiles:$..nearby_tiles.search_session_key}"));
        return new ApiRequest("xml_places", "GET", "nearbyandroidlayouts", a, ApiResponseType.JSONPARSER);
    }

    public final Object m647a(Object obj, ApiResponse apiResponse) {
        NearbyLayoutResponse nearbyLayoutResponse = (NearbyLayoutResponse) apiResponse.d().a(NearbyLayoutResponse.class);
        Map c = Maps.c();
        for (NearbyPlaceLayout nearbyPlaceLayout : nearbyLayoutResponse.layouts) {
            c.put(nearbyPlaceLayout.id, nearbyPlaceLayout.layout);
        }
        return new FetchNearbyPlacesLayoutResult(DataFreshnessResult.FROM_SERVER, this.f520b.a(), c);
    }
}
