package com.facebook.location.foreground;

import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.hardware.WifiDiagnosticsSerializer;
import com.facebook.common.util.TriState;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: Unknown MapInitialFetchState =  */
public class UpdateForegroundLocationMethod implements ApiMethod<ImmutableLocation, Void> {
    public final UniqueIdForDeviceHolderImpl f10443a;
    public final Provider<TriState> f10444b;
    public final Provider<TriState> f10445c;
    public final CellDiagnosticsSerializer f10446d;
    public final WifiDiagnosticsSerializer f10447e;
    public final LocationAgeUtil f10448f;

    public final ApiRequest m10842a(Object obj) {
        JsonNode a;
        ImmutableLocation immutableLocation = (ImmutableLocation) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update-foreground-location";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/places.setLastLocation";
        newBuilder = newBuilder.a(RequestPriority.CAN_WAIT);
        List a2 = Lists.a();
        String str = "coords";
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("latitude", immutableLocation.a());
        objectNode.a("longitude", immutableLocation.b());
        objectNode.a("accuracy", (Float) immutableLocation.c().get());
        objectNode.a("age_ms", this.f10448f.a(immutableLocation));
        Optional d = immutableLocation.d();
        if (d.isPresent()) {
            objectNode.a("altitude_meters", (Double) d.get());
        }
        d = immutableLocation.e();
        if (d.isPresent()) {
            objectNode.a("bearing_degrees", (Float) d.get());
        }
        d = immutableLocation.f();
        if (d.isPresent()) {
            objectNode.a("speed_meters_per_sec", (Float) d.get());
        }
        a2.add(new BasicNameValuePair(str, objectNode.toString()));
        if (this.f10444b.get() == TriState.YES) {
            a = this.f10446d.a();
            if (a != null) {
                a2.add(new BasicNameValuePair("cell_tower", a.toString()));
            }
        }
        if (this.f10445c.get() == TriState.YES) {
            a = this.f10447e.a();
            if (a != null) {
                a2.add(new BasicNameValuePair("wifi", a.toString()));
            }
        }
        a2.add(new BasicNameValuePair("marauder_device_id", this.f10443a.a()));
        newBuilder.g = a2;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.C();
    }

    @Inject
    public UpdateForegroundLocationMethod(UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Provider<TriState> provider, Provider<TriState> provider2, CellDiagnosticsSerializer cellDiagnosticsSerializer, WifiDiagnosticsSerializer wifiDiagnosticsSerializer, LocationAgeUtil locationAgeUtil) {
        this.f10443a = uniqueIdForDeviceHolder;
        this.f10444b = provider;
        this.f10445c = provider2;
        this.f10446d = cellDiagnosticsSerializer;
        this.f10447e = wifiDiagnosticsSerializer;
        this.f10448f = locationAgeUtil;
    }

    public final Object m10843a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
