package com.facebook.xconfig.sync;

import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.Assisted;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

@Immutable
/* compiled from: structured_address */
public class XSyncApiMethod implements ApiMethod<XSyncParams, XSyncResult> {
    public static final String f1634a = BootstrapRequestName.SYNC_X_CONFIGS.requestNameString;
    private final String f1635b;
    private final UniqueIdForDeviceHolderImpl f1636c;

    public final ApiRequest m1869a(Object obj) {
        XSyncParams xSyncParams = (XSyncParams) obj;
        boolean isNullOrEmpty = Strings.isNullOrEmpty(this.f1635b);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("debug", Boolean.toString(xSyncParams.f1962b)));
        if (isNullOrEmpty) {
            String a = this.f1636c.a();
            if (a == null) {
                throw new XSyncException("Unique ID to be used for sessionless xconfig sync was null");
            }
            arrayList.add(new BasicNameValuePair("hash_id", a));
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : xSyncParams.f1961a.entrySet()) {
            objectNode.a((String) entry.getKey(), (String) entry.getValue());
        }
        arrayList.add(new BasicNameValuePair("configs", objectNode.toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f1634a;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/xconfig.fetch";
        newBuilder = newBuilder.a(RequestPriority.CAN_WAIT);
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.t = isNullOrEmpty;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Nullable
    public final Object m1870a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        if (c.h() && c.e() == 0) {
            return new XSyncResult(ImmutableBiMap.a());
        }
        if (c.i()) {
            Builder builder = ImmutableMap.builder();
            Iterator H = c.H();
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                String str = (String) entry.getKey();
                try {
                    builder.b(str, m1868a(str, (JsonNode) entry.getValue()));
                } catch (XSyncException e) {
                    BLog.c("XSyncApiMethod", e, "Failed to parse response for xconfig %s", new Object[]{str});
                }
            }
            return new XSyncResult(builder.b());
        }
        BLog.c("XSyncApiMethod", "Response is not a JsonObject: %s", new Object[]{c});
        return null;
    }

    @Inject
    public XSyncApiMethod(@Assisted String str, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f1635b = str;
        this.f1636c = uniqueIdForDeviceHolderImpl;
    }

    private static XSyncConfigResult m1868a(String str, JsonNode jsonNode) {
        if (jsonNode.i()) {
            String str2 = null;
            Builder builder = ImmutableMap.builder();
            Iterator H = jsonNode.H();
            boolean z = false;
            boolean z2 = false;
            while (H.hasNext()) {
                Entry entry = (Entry) H.next();
                String str3 = (String) entry.getKey();
                JsonNode jsonNode2 = (JsonNode) entry.getValue();
                if (str3.equals("value_hash")) {
                    str2 = jsonNode2.s();
                    if (str2 == null) {
                        throw new XSyncException("'value_hash' for config " + str + " is not a text value: " + jsonNode2);
                    }
                } else if (str3.equals("debug")) {
                    if (jsonNode2.i()) {
                        JsonNode b = jsonNode2.b("would_have_skipped");
                        if (b == null) {
                            throw new XSyncException("'debug' value for config " + str + " does not have a 'would_have_skipped' field: " + jsonNode2);
                        }
                        if (b.C() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = true;
                    } else {
                        throw new XSyncException("'debug' value for config " + str + " is not a JsonObject: " + jsonNode2);
                    }
                } else if (jsonNode2.f()) {
                    builder.b(str3, jsonNode2.B());
                } else {
                    throw new XSyncException("Setting " + str3 + " in config " + str + " cannot be trivially converted to a text value: " + jsonNode2);
                }
            }
            if (str2 == null) {
                throw new XSyncException("No 'value_hash' was specified for config " + str + ": " + jsonNode);
            }
            return new XSyncConfigResult(str, builder.b(), str2, z2, z);
        }
        throw new XSyncException("Value for config " + str + " is not a JsonObject: " + jsonNode);
    }
}
