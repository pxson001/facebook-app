package com.facebook.friendsnearby.pingdialog;

import com.facebook.common.time.Clock;
import com.facebook.friendsnearby.pingdialog.LocationPingTime.Type;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.location.ImmutableLocation;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: \d+[^()0-9]+ */
public class LocationPingMethod implements ApiMethod<LocationPingParams, Boolean> {
    private final Clock f20619a;

    public final ApiRequest m21036a(Object obj) {
        LocationPingParams locationPingParams = (LocationPingParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("recipient", locationPingParams.f20620a));
        if (locationPingParams.f20622c.isPresent()) {
            a.add(new BasicNameValuePair("lat", Double.toString(((ImmutableLocation) locationPingParams.f20622c.get()).a())));
            a.add(new BasicNameValuePair("lon", Double.toString(((ImmutableLocation) locationPingParams.f20622c.get()).b())));
            a.add(new BasicNameValuePair("accuracy", Float.toString(((Float) ((ImmutableLocation) locationPingParams.f20622c.get()).c().get()).floatValue())));
            a.add(new BasicNameValuePair("location_ts", Long.toString(((Long) ((ImmutableLocation) locationPingParams.f20622c.get()).g().get()).longValue() / 1000)));
        }
        a.add(new BasicNameValuePair("ping_type", m21035a(locationPingParams.f20621b.f20625a)));
        if (locationPingParams.f20621b.f20626b.isPresent()) {
            a.add(new BasicNameValuePair("remaining_duration", Long.toString(m21034a(((Long) locationPingParams.f20621b.f20626b.get()).longValue()))));
        }
        if (locationPingParams.f20623d.isPresent()) {
            a.add(new BasicNameValuePair("message", (String) locationPingParams.f20623d.get()));
        }
        return new ApiRequest("locationPing", "POST", "/me/locationping", a, ApiResponseType.STRING);
    }

    @Inject
    public LocationPingMethod(Clock clock) {
        this.f20619a = clock;
    }

    private static String m21035a(Type type) {
        switch (type) {
            case DURATION:
                return "duration";
            case FOREVER:
                return "forever";
            default:
                throw new IllegalArgumentException("Invalid ping type: " + type);
        }
    }

    private long m21034a(long j) {
        return (j - this.f20619a.a()) / 1000;
    }

    public final Object m21037a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.b()));
    }
}
