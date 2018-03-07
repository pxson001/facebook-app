package com.facebook.http.protocol;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;

/* compiled from: dialtone_photocapping_upgrade_dialog_impression */
public class DeviceApiResult {
    public JsonNode f5076a;
    private JsonNode f5077b;
    public JsonNode f5078c;

    public DeviceApiResult(JsonNode jsonNode) {
        this.f5076a = jsonNode.b("api_success_response");
        this.f5077b = jsonNode.b("api_error_response");
        JsonNode b = jsonNode.b("internal_result");
        if (Objects.equal(b.b("control").s(), "success")) {
            this.f5078c = b.b("response");
        }
    }
}
