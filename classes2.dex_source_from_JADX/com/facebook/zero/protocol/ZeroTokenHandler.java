package com.facebook.zero.protocol;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.protocol.methods.FetchZeroHeaderRequestMethod;
import com.facebook.zero.protocol.methods.FetchZeroIndicatorMethod;
import com.facebook.zero.protocol.methods.FetchZeroInterstitialContentMethod;
import com.facebook.zero.protocol.methods.FetchZeroInterstitialEligibilityMethod;
import com.facebook.zero.protocol.methods.FetchZeroOptinContentRequestMethod;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;
import com.facebook.zero.protocol.methods.SendZeroHeaderRequestMethod;
import com.facebook.zero.protocol.methods.ZeroOptinMethod;
import com.facebook.zero.protocol.methods.ZeroOptoutMethod;
import com.facebook.zero.protocol.methods.ZeroUpdateStatusMethod;
import com.facebook.zero.sdk.request.FetchZeroIndicatorRequestParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityResult;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestParams;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestResult;
import com.facebook.zero.sdk.request.FetchZeroTokenRequestParams;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.request.ZeroOptinParams;
import com.facebook.zero.sdk.request.ZeroOptinResult;
import com.facebook.zero.sdk.request.ZeroOptoutParams;
import com.facebook.zero.sdk.request.ZeroOptoutResult;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.server.FetchZeroHeaderRequestParams;
import com.facebook.zero.server.FetchZeroHeaderRequestResult;
import com.facebook.zero.server.SendZeroHeaderRequestParams;
import com.facebook.zero.server.ZeroUpdateStatusParams;
import com.facebook.zero.ui.ZeroIndicatorDataSerialization;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: file_lock */
public class ZeroTokenHandler implements BlueServiceHandler {
    public static final CallerContext f23709a = CallerContext.m9060a(ZeroTokenHandler.class);
    private static ZeroTokenHandler f23710p;
    private static final Object f23711q = new Object();
    public final AbstractSingleMethodRunner f23712b;
    private final ZeroIndicatorDataSerialization f23713c;
    private final FetchZeroIndicatorMethod f23714d;
    private final FetchZeroTokenMethod f23715e;
    private final FetchZeroHeaderRequestMethod f23716f;
    private final FetchZeroOptinContentRequestMethod f23717g;
    private final FbSharedPreferences f23718h;
    public final SendZeroHeaderRequestMethod f23719i;
    private final ZeroOptinMethod f23720j;
    private final ZeroOptoutMethod f23721k;
    private final FetchZeroInterstitialEligibilityMethod f23722l;
    private final FetchZeroInterstitialContentMethod f23723m;
    private final ZeroUpdateStatusMethod f23724n;
    private final Provider<Boolean> f23725o;

    private static ZeroTokenHandler m32135b(InjectorLike injectorLike) {
        return new ZeroTokenHandler(SingleMethodRunnerImpl.m11724a(injectorLike), ZeroIndicatorDataSerialization.m32145b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FetchZeroTokenMethod.m32149b(injectorLike), FetchZeroIndicatorMethod.m32154b(injectorLike), FetchZeroHeaderRequestMethod.m32159b(injectorLike), FetchZeroOptinContentRequestMethod.m32163b(injectorLike), SendZeroHeaderRequestMethod.m32166a(injectorLike), ZeroOptinMethod.m32170b(injectorLike), ZeroOptoutMethod.m32174b(injectorLike), FetchZeroInterstitialEligibilityMethod.m32177b(injectorLike), FetchZeroInterstitialContentMethod.m32180b(injectorLike), ZeroUpdateStatusMethod.m32183a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4385));
    }

    public final OperationResult mo3506a(OperationParams operationParams) {
        String str = operationParams.f23704b;
        if (str.equals("fetch_zero_token")) {
            return m32131a(operationParams, Boolean.valueOf(true));
        }
        if (str.equals("fetch_zero_token_not_bootstrap")) {
            return m32131a(operationParams, Boolean.valueOf(false));
        }
        if (str.equals("fetch_zero_indicator")) {
            return m32134b(operationParams);
        }
        if (str.equals("fetch_zero_header_request")) {
            return m32136c(operationParams);
        }
        if (str.equals("fetch_zero_optin_content_request")) {
            return m32137d(operationParams);
        }
        if (str.equals("send_zero_header_request")) {
            this.f23712b.m11744a(this.f23719i, (SendZeroHeaderRequestParams) operationParams.f23705c.getParcelable("sendZeroHeaderRequestParams"), f23709a);
            return OperationResult.f22219a;
        } else if (str.equals("zero_optin")) {
            return m32138f(operationParams);
        } else {
            if (str.equals("zero_optout")) {
                return m32139g(operationParams);
            }
            if (str.equals("fetch_zero_interstitial_eligibility")) {
                return m32140h(operationParams);
            }
            if (str.equals("fetch_zero_interstitial_content")) {
                return m32141i(operationParams);
            }
            if (str.equals("zero_update_status")) {
                return m32142j(operationParams);
            }
            throw new Exception("Unknown type: " + str);
        }
    }

    private OperationResult m32131a(OperationParams operationParams, Boolean bool) {
        Object obj = (ZeroToken) m32133a(this.f23715e, (FetchZeroTokenRequestParams) operationParams.f23705c.getParcelable("fetchZeroTokenRequestParams"), bool.booleanValue());
        return obj != null ? OperationResult.m30115a(obj) : OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32136c(OperationParams operationParams) {
        Object obj = (FetchZeroHeaderRequestResult) m32133a(this.f23716f, (FetchZeroHeaderRequestParams) operationParams.f23705c.getParcelable("fetchZeroHeaderRequestParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32137d(OperationParams operationParams) {
        Object obj = (FetchZeroOptinContentRequestResult) m32133a(this.f23717g, (FetchZeroOptinContentRequestParams) operationParams.f23705c.getParcelable("fetchZeroOptinContentRequestParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32138f(OperationParams operationParams) {
        Object obj = (ZeroOptinResult) m32133a(this.f23720j, (ZeroOptinParams) operationParams.f23705c.getParcelable("zeroOptinParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32139g(OperationParams operationParams) {
        Object obj = (ZeroOptoutResult) m32133a(this.f23721k, (ZeroOptoutParams) operationParams.f23705c.getParcelable("zeroOptoutParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32140h(OperationParams operationParams) {
        Object obj = (FetchZeroInterstitialEligibilityResult) m32133a(this.f23722l, (FetchZeroInterstitialEligibilityParams) operationParams.f23705c.getParcelable("fetchZeroInterstitialEligibilityParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32141i(OperationParams operationParams) {
        Object obj = (FetchZeroInterstitialContentResult) m32133a(this.f23723m, (FetchZeroInterstitialContentParams) operationParams.f23705c.getParcelable("fetchZeroInterstitialContentParams"), !((Boolean) this.f23725o.get()).booleanValue());
        if (obj != null) {
            return OperationResult.m30115a(obj);
        }
        return OperationResult.m30111a(ErrorCode.API_ERROR);
    }

    private OperationResult m32142j(OperationParams operationParams) {
        m32133a(this.f23724n, (ZeroUpdateStatusParams) operationParams.f23705c.getParcelable("zeroUpdateStatusParams"), !((Boolean) this.f23725o.get()).booleanValue());
        return OperationResult.f22219a;
    }

    public static ZeroTokenHandler m32132a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ZeroTokenHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23711q) {
                ZeroTokenHandler zeroTokenHandler;
                if (a2 != null) {
                    zeroTokenHandler = (ZeroTokenHandler) a2.mo818a(f23711q);
                } else {
                    zeroTokenHandler = f23710p;
                }
                if (zeroTokenHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32135b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23711q, b3);
                        } else {
                            f23710p = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = zeroTokenHandler;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ZeroTokenHandler(SingleMethodRunner singleMethodRunner, ZeroIndicatorDataSerialization zeroIndicatorDataSerialization, FbSharedPreferences fbSharedPreferences, FetchZeroTokenMethod fetchZeroTokenMethod, FetchZeroIndicatorMethod fetchZeroIndicatorMethod, FetchZeroHeaderRequestMethod fetchZeroHeaderRequestMethod, FetchZeroOptinContentRequestMethod fetchZeroOptinContentRequestMethod, SendZeroHeaderRequestMethod sendZeroHeaderRequestMethod, ZeroOptinMethod zeroOptinMethod, ZeroOptoutMethod zeroOptoutMethod, FetchZeroInterstitialEligibilityMethod fetchZeroInterstitialEligibilityMethod, FetchZeroInterstitialContentMethod fetchZeroInterstitialContentMethod, ZeroUpdateStatusMethod zeroUpdateStatusMethod, Provider<Boolean> provider) {
        this.f23712b = singleMethodRunner;
        this.f23713c = zeroIndicatorDataSerialization;
        this.f23718h = fbSharedPreferences;
        this.f23715e = fetchZeroTokenMethod;
        this.f23714d = fetchZeroIndicatorMethod;
        this.f23716f = fetchZeroHeaderRequestMethod;
        this.f23717g = fetchZeroOptinContentRequestMethod;
        this.f23719i = sendZeroHeaderRequestMethod;
        this.f23720j = zeroOptinMethod;
        this.f23721k = zeroOptoutMethod;
        this.f23722l = fetchZeroInterstitialEligibilityMethod;
        this.f23723m = fetchZeroInterstitialContentMethod;
        this.f23724n = zeroUpdateStatusMethod;
        this.f23725o = provider;
    }

    private OperationResult m32134b(OperationParams operationParams) {
        try {
            Object obj = (ZeroIndicatorData) m32133a(this.f23714d, ((FetchZeroIndicatorRequestParams) operationParams.m32127b().getParcelable("fetchZeroIndicatorParams")).b(), !((Boolean) this.f23725o.get()).booleanValue());
            if (obj == null) {
                return OperationResult.m30111a(ErrorCode.API_ERROR);
            }
            this.f23718h.edit().mo1276a(ZeroPrefKeys.ac, this.f23713c.m32147a((ZeroIndicatorData) obj)).commit();
            return OperationResult.m30115a(obj);
        } catch (Throwable e) {
            if (e.b().a() == 100) {
                return OperationResult.m30114a(ErrorCode.NO_ERROR, e);
            }
            throw e;
        }
    }

    private <PARAMS, RESULT> RESULT m32133a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, boolean z) {
        AbstractSingleMethodRunner abstractSingleMethodRunner = this.f23712b;
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        if (z) {
            apiMethodRunnerParams.m12149a(HttpConfig.BOOTSTRAP);
        } else {
            apiMethodRunnerParams.m12149a(HttpConfig.DEFAULT);
        }
        return abstractSingleMethodRunner.m11746a(apiMethod, params, apiMethodRunnerParams, f23709a);
    }
}
