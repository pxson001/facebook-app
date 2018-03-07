package com.facebook.platform.opengraph.server;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotextComposer;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: gc_freed_size */
public class GetRobotextPreviewMethod implements ApiMethod<Params, OpenGraphActionRobotext> {
    private final JsonFactory f11315a;
    private final ObjectMapper f11316b;

    public static GetRobotextPreviewMethod m11735b(InjectorLike injectorLike) {
        return new GetRobotextPreviewMethod(JsonFactoryMethodAutoProvider.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m11736a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        Iterator H = ((JsonNode) this.f11315a.b(params.a).J()).H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            if (!"image".equals(entry.getKey())) {
                JsonNode jsonNode = (JsonNode) entry.getValue();
                a.add(new BasicNameValuePair((String) entry.getKey(), jsonNode.o() ? jsonNode.B() : jsonNode.toString()));
            }
        }
        a.add(new BasicNameValuePair("preview", "1"));
        a.add(new BasicNameValuePair("proxied_app_id", params.c));
        a.add(new BasicNameValuePair("android_key_hash", params.d));
        if (params.e != null) {
            a.add(new BasicNameValuePair("fb:channel", params.e));
        }
        return new ApiRequest("get_robotext_preview_method", TigonRequest.POST, "me/" + params.b, a, ApiResponseType.JSON);
    }

    @Inject
    public GetRobotextPreviewMethod(JsonFactory jsonFactory, ObjectMapper objectMapper) {
        this.f11315a = jsonFactory;
        this.f11316b = objectMapper;
    }

    public final Object m11737a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        if (c != null && c.d("data")) {
            c = c.b("data").a(0);
        }
        JsonParser c2 = c.c();
        c2.a(this.f11316b);
        return (OpenGraphActionRobotext) c2.a(OpenGraphActionRobotextComposer.class);
    }
}
