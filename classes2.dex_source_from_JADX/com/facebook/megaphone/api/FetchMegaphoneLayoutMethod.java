package com.facebook.megaphone.api;

import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.megaphone.model.MegaphoneLayoutResponse;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: pcampaignid */
public class FetchMegaphoneLayoutMethod implements ApiMethod<FetchMegaphoneParams, FetchMegaphoneLayoutResult> {
    private final Clock f10313a;

    public final ApiRequest mo672a(Object obj) {
        FetchMegaphoneParams fetchMegaphoneParams = (FetchMegaphoneParams) obj;
        List a = Lists.m1296a();
        a.add(new BasicNameValuePair("megaphone_location", fetchMegaphoneParams.a.toString()));
        a.add(new BasicNameValuePair("img_size", Integer.toString(fetchMegaphoneParams.b)));
        return new ApiRequest("xml_megaphone", "GET", "megaphoneandroidlayouts", a, ApiResponseType.JSONPARSER);
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        if (apiResponse.m22203a() != 200) {
            return new FetchMegaphoneLayoutResult(DataFreshnessResult.NO_DATA, this.f10313a.mo211a(), null, null);
        }
        try {
            String str;
            String str2;
            MegaphoneLayoutResponse megaphoneLayoutResponse = (MegaphoneLayoutResponse) apiResponse.m22206d().m13259a(MegaphoneLayoutResponse.class);
            DataFreshnessResult dataFreshnessResult = DataFreshnessResult.FROM_SERVER;
            long a = this.f10313a.mo211a();
            if (megaphoneLayoutResponse == null) {
                str = null;
            } else {
                str = megaphoneLayoutResponse.cacheId;
            }
            if (megaphoneLayoutResponse == null) {
                str2 = null;
            } else {
                str2 = megaphoneLayoutResponse.layout;
            }
            return new FetchMegaphoneLayoutResult(dataFreshnessResult, a, str, str2);
        } catch (IOException e) {
            return new FetchMegaphoneLayoutResult(DataFreshnessResult.NO_DATA, this.f10313a.mo211a(), null, null);
        }
    }

    @Inject
    public FetchMegaphoneLayoutMethod(Clock clock) {
        this.f10313a = clock;
    }
}
