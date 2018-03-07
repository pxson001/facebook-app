package com.facebook.interstitial.api;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SqlUtil;
import com.facebook.fql.FqlApiRequestHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager.DataSource;
import com.facebook.interstitial.manager.InterstitialRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: street_1 */
public class FetchInterstitialsMethod implements ApiMethod<FetchInterstitialsParams, ArrayList<FetchInterstitialResult>> {
    private final FqlApiRequestHelper f1646a;
    private final InterstitialRepository f1647b;

    public static FetchInterstitialsMethod m1876b(InjectorLike injectorLike) {
        return new FetchInterstitialsMethod(new FqlApiRequestHelper(), InterstitialRepository.a(injectorLike));
    }

    public final ApiRequest m1877a(Object obj) {
        String a = SqlUtil.m14313a(((FetchInterstitialsParams) obj).f1645a);
        return FqlApiRequestHelper.m1879a("fetch_interstitials", StringFormatUtil.a("SELECT %s FROM %s WHERE nux_id IN %s", new Object[]{"rank, nux_id, nux_data", "user_nux_status", a}), RequestPriority.NON_INTERACTIVE, ApiResponseType.JSONPARSER);
    }

    @Inject
    public FetchInterstitialsMethod(FqlApiRequestHelper fqlApiRequestHelper, InterstitialRepository interstitialRepository) {
        this.f1646a = fqlApiRequestHelper;
        this.f1647b = interstitialRepository;
    }

    public final Object m1878a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonParser d = apiResponse.d();
        d.c();
        while (true) {
            if (d.g() == JsonToken.FIELD_NAME && d.i().equals("data")) {
                d.c();
                return this.f1647b.a(DataSource.SERVER, d);
            }
            d.c();
        }
    }
}
