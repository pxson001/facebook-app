package com.facebook.http.protocol;

import com.facebook.http.protocol.ApiResponseChecker.AbstractHttpResponseAdapter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;

/* compiled from: fbot_onion_rewrite */
class ApiResponseChecker$3 extends AbstractHttpResponseAdapter {
    final /* synthetic */ JsonParser f11951a;
    final /* synthetic */ ApiResponseChecker f11952b;

    ApiResponseChecker$3(ApiResponseChecker apiResponseChecker, int i, String str, JsonParser jsonParser) {
        this.f11952b = apiResponseChecker;
        this.f11951a = jsonParser;
        super(i, str);
    }

    @Nullable
    protected final String m12608a() {
        return this.f11952b.b.a(this.f11951a.a(JsonNode.class));
    }
}
