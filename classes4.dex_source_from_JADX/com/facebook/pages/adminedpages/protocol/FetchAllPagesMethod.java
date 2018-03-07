package com.facebook.pages.adminedpages.protocol;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodEvents;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: error deleting old asset file. */
public class FetchAllPagesMethod implements ApiMethod<Void, FetchAllPagesResult>, ApiMethodEvents<Void> {
    PagesInfoFqlHelper f12840a;
    PagesManagerStartupSequencesHelper f12841b;

    @Inject
    public FetchAllPagesMethod(PagesInfoFqlHelper pagesInfoFqlHelper, PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper) {
        this.f12840a = pagesInfoFqlHelper;
        this.f12841b = pagesManagerStartupSequencesHelper;
    }

    public final ApiRequest m13671a(Object obj) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("fields", "picture.height(74).type(square),id,access_token,perms,name,link"));
        a.add(new BasicNameValuePair("limit", "50"));
        return new ApiRequest("fetch_pages", TigonRequest.GET, "me/accounts", a, ApiResponseType.JSON);
    }

    public final Object m13672a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = this.f12840a.m13679c(apiResponse.c());
        return new FetchAllPagesResult(DataFreshnessResult.FROM_SERVER, this.f12840a.m13678a(c), c.toString(), System.currentTimeMillis());
    }

    public final void m13674b(Object obj) {
        this.f12841b.m13698a("FetchAllPagesGraphApiMethod");
    }

    public final void m13675c(Object obj) {
        this.f12841b.m13699b("FetchAllPagesGraphApiMethod");
    }

    public final void m13673a(Object obj, Exception exception) {
        this.f12841b.m13701d("FetchAllPagesGraphApiMethod");
    }
}
