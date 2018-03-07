package com.facebook.appirater.api;

import com.facebook.appirater.Appirater;
import com.facebook.appirater.AppiraterPrefKeys;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: rtc_floating_point_isac_uni */
public class AppRaterShouldAskUserApiMethod implements ApiMethod<Void, FetchISRConfigResult> {
    private final Appirater f3269a;
    private final Clock f3270b;

    public static AppRaterShouldAskUserApiMethod m3468b(InjectorLike injectorLike) {
        return new AppRaterShouldAskUserApiMethod(Appirater.m7681a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppRaterShouldAskUserApiMethod(Appirater appirater, SystemClock systemClock) {
        this.f3269a = appirater;
        this.f3270b = systemClock;
    }

    public final ApiRequest m3469a(Object obj) {
        List a = Lists.a(2);
        a.add(new BasicNameValuePair("format", "json"));
        Appirater appirater = this.f3269a;
        a.add(new BasicNameValuePair("time_since_last_install_millisecs", String.valueOf(this.f3270b.a() - appirater.f7373g.a(AppiraterPrefKeys.f2843b, appirater.f7371e.a()))));
        return new ApiRequest("app_rater_should_ask_user", TigonRequest.GET, "method/app_rater.should_ask_user", a, ApiResponseType.JSONPARSER);
    }

    public final Object m3470a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return (FetchISRConfigResult) apiResponse.d().a(FetchISRConfigResult.class);
    }
}
