package com.facebook.languages.switcher.protocol;

import android.telephony.TelephonyManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: timeline_hide_story */
public class SuggestedLocalesMethod implements ApiMethod<Void, SuggestedLocalesResult> {
    private final Locales f2776a;
    private final TelephonyManager f2777b;

    public static SuggestedLocalesMethod m4753b(InjectorLike injectorLike) {
        return new SuggestedLocalesMethod(Locales.m2604a(injectorLike), TelephonyManagerMethodAutoProvider.m3851b(injectorLike));
    }

    @Inject
    public SuggestedLocalesMethod(Locales locales, TelephonyManager telephonyManager) {
        this.f2777b = telephonyManager;
        this.f2776a = locales;
    }

    public final ApiRequest mo672a(Object obj) {
        return new ApiRequest("suggestedLanguages", "GET", "method/intl.getLocaleSuggestions", RequestPriority.INTERACTIVE, Lists.m1300a(new BasicNameValuePair("format", "json"), new BasicNameValuePair("device_locale", Locales.m2607e().toString()), new BasicNameValuePair("sim_country", this.f2777b.getSimCountryIso()), new BasicNameValuePair("network_country", this.f2777b.getNetworkCountryIso())), ApiResponseType.JSONPARSER);
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (SuggestedLocalesResult) apiResponse.m22206d().m13259a(SuggestedLocalesResult.class);
    }
}
