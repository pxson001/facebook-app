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

/* compiled from: ttings */
public class FetchNearbyTypeaheadPlacesLayoutMethod implements ApiMethod<FetchNearbyPlacesLayoutParams, FetchNearbyPlacesLayoutResult> {
    private static final Class<?> f523a = FetchNearbyTypeaheadPlacesLayoutMethod.class;
    private final Clock f524b;

    public static FetchNearbyTypeaheadPlacesLayoutMethod m648b(InjectorLike injectorLike) {
        return new FetchNearbyTypeaheadPlacesLayoutMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchNearbyTypeaheadPlacesLayoutMethod(Clock clock) {
        this.f524b = clock;
    }

    public final ApiRequest m649a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("places", "{result=search_places:$..result_sections.edges..node.results.edges..node.id}"));
        a.add(new BasicNameValuePair("hash", "{result=search_places:$..search_session_id}"));
        return new ApiRequest("xml_places", "GET", "nearbyandroidlayouts", a, ApiResponseType.JSONPARSER);
    }

    public final Object m650a(Object obj, ApiResponse apiResponse) {
        NearbyLayoutResponse nearbyLayoutResponse = (NearbyLayoutResponse) apiResponse.d().a(NearbyLayoutResponse.class);
        Map c = Maps.c();
        for (NearbyPlaceLayout nearbyPlaceLayout : nearbyLayoutResponse.layouts) {
            c.put(nearbyPlaceLayout.id, nearbyPlaceLayout.layout);
        }
        return new FetchNearbyPlacesLayoutResult(DataFreshnessResult.FROM_SERVER, this.f524b.a(), c);
    }
}
