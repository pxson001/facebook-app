package com.facebook.share.protocol;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.share.model.LinksPreview;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: gcm_response */
public class LinksPreviewMethod implements ApiMethod<LinksPreviewParams, LinksPreview> {
    private final ObjectMapper f11299a;

    public static LinksPreviewMethod m11698b(InjectorLike injectorLike) {
        return new LinksPreviewMethod((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m11699a(Object obj) {
        LinksPreviewParams linksPreviewParams = (LinksPreviewParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        if (linksPreviewParams.b != null) {
            a.add(new BasicNameValuePair("url", linksPreviewParams.b));
        }
        if (linksPreviewParams.a != null) {
            a.add(new BasicNameValuePair("id", linksPreviewParams.a));
        }
        if (linksPreviewParams.c != null) {
            a.add(new BasicNameValuePair("composer_session_id", linksPreviewParams.c));
        }
        if (!linksPreviewParams.d.isEmpty()) {
            a.add(new BasicNameValuePair("requested_sizes", this.f11299a.a(linksPreviewParams.d)));
        }
        return new ApiRequest("links.preview", TigonRequest.GET, "method/links.preview", a, ApiResponseType.JSON);
    }

    @Inject
    public LinksPreviewMethod(ObjectMapper objectMapper) {
        this.f11299a = objectMapper;
    }

    public final Object m11700a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonParser c = apiResponse.c().c();
        c.a(this.f11299a);
        return (LinksPreview) c.a(LinksPreview.class);
    }
}
