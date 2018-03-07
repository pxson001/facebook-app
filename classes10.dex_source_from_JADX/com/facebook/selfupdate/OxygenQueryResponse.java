package com.facebook.selfupdate;

import com.facebook.common.util.JSONUtil;
import com.facebook.oxygen.appmanager.protocol.constants.ProtocolConstants.ClientAction;
import com.facebook.oxygen.appmanager.protocol.constants.ProtocolConstants.DownloadNetworks;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: has_title_bar */
public class OxygenQueryResponse {
    public final ClientAction f9956a;
    public final DownloadNetworks f9957b;
    public final String f9958c;
    public final long f9959d;
    public final String f9960e;
    public final int f9961f;
    public final String f9962g;
    public final String f9963h;
    public final String f9964i;
    public final String f9965j;

    public OxygenQueryResponse(JsonNode jsonNode) {
        JsonNode a = jsonNode.a(0);
        JsonNode f = a.f("release_package");
        JsonNode f2 = a.f("release_number");
        JsonNode f3 = a.f("application_name");
        JsonNode f4 = a.f("application_version");
        JsonNode f5 = a.f("download_url");
        JsonNode f6 = a.f("allowed_networks");
        JsonNode f7 = a.f("client_action");
        JsonNode f8 = a.f("release_notes");
        JsonNode f9 = a.f("file_mime_type");
        a = a.f("file_size");
        this.f9956a = ClientAction.fromInt(JSONUtil.d(f7));
        this.f9957b = DownloadNetworks.fromInt(JSONUtil.d(f6));
        this.f9958c = JSONUtil.b(f5);
        this.f9959d = JSONUtil.c(a);
        this.f9960e = JSONUtil.b(f);
        this.f9961f = JSONUtil.d(f2);
        this.f9962g = JSONUtil.b(f8);
        this.f9963h = JSONUtil.b(f3);
        this.f9964i = JSONUtil.b(f4);
        this.f9965j = JSONUtil.b(f9);
    }
}
