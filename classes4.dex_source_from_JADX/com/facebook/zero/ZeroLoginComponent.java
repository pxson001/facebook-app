package com.facebook.zero;

import com.facebook.auth.component.LoginComponent;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.protocol.methods.FetchZeroHeaderRequestMethod;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.server.FetchZeroHeaderRequestParams;
import com.facebook.zero.server.FetchZeroHeaderRequestResult;
import com.facebook.zero.service.FbZeroTokenFetcher;
import com.facebook.zero.service.ZeroHeaderRequestManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: sms_internal_no_readonly_notification */
public class ZeroLoginComponent implements LoginComponent {
    public final ZeroTokenFetcher f2087a;
    public final ZeroHeaderRequestManager f2088b;
    public final ZeroNetworkAndTelephonyHelper f2089c;
    public final FetchZeroTokenMethod f2090d;
    public final FetchZeroHeaderRequestMethod f2091e;
    public final FbSharedPreferences f2092f;
    public final boolean f2093g;

    /* compiled from: sms_internal_no_readonly_notification */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ ZeroLoginComponent f2105a;

        public MyBatchComponent(ZeroLoginComponent zeroLoginComponent) {
            this.f2105a = zeroLoginComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            if (this.f2105a.f2093g) {
                return RegularImmutableList.a;
            }
            Builder a = BatchOperation.m12541a(this.f2105a.f2090d, this.f2105a.f2087a.b(ZeroTokenType.NORMAL, TokenRequestReason.LOGIN));
            a.f11927c = "fetchZeroToken";
            BatchOperation a2 = a.m12548a(false).m12549a();
            Builder a3 = BatchOperation.m12541a(this.f2105a.f2090d, this.f2105a.f2087a.b(ZeroTokenType.DIALTONE, TokenRequestReason.LOGIN));
            a3.f11927c = "fetchZeroTokenForDialtone";
            BatchOperation a4 = a3.m12548a(false).m12549a();
            Builder a5 = BatchOperation.m12541a(this.f2105a.f2091e, new FetchZeroHeaderRequestParams(this.f2105a.f2089c.a(), this.f2105a.f2089c.b(), this.f2105a.f2092f.a(AuthPrefKeys.f, ""), true));
            a5.f11927c = "fetchZeroHeaderRequest";
            return ImmutableList.of(a2, a4, a5.m12548a(false).m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            ZeroToken zeroToken = (ZeroToken) map.get("fetchZeroToken");
            if (zeroToken != null) {
                this.f2105a.f2087a.b(zeroToken, ZeroTokenType.NORMAL);
            }
            zeroToken = (ZeroToken) map.get("fetchZeroTokenForDialtone");
            if (zeroToken != null) {
                this.f2105a.f2087a.b(zeroToken, ZeroTokenType.DIALTONE);
            }
            FetchZeroHeaderRequestResult fetchZeroHeaderRequestResult = (FetchZeroHeaderRequestResult) map.get("fetchZeroHeaderRequest");
            if (fetchZeroHeaderRequestResult != null) {
                ZeroHeaderRequestManager zeroHeaderRequestManager = this.f2105a.f2088b;
                zeroHeaderRequestManager.f2103i.edit().a(ZeroPrefKeys.t, fetchZeroHeaderRequestResult.m2307f()).commit();
                if ("enabled".equals(fetchZeroHeaderRequestResult.m2302a())) {
                    ZeroHeaderRequestManager.m2192b(zeroHeaderRequestManager, fetchZeroHeaderRequestResult);
                }
            }
        }
    }

    public static ZeroLoginComponent m2187b(InjectorLike injectorLike) {
        return new ZeroLoginComponent((ZeroTokenFetcher) FbZeroTokenFetcher.a(injectorLike), ZeroHeaderRequestManager.m2190a(injectorLike), ZeroNetworkAndTelephonyHelper.b(injectorLike), FetchZeroTokenMethod.b(injectorLike), FetchZeroHeaderRequestMethod.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ZeroLoginComponent(ZeroTokenFetcher zeroTokenFetcher, ZeroHeaderRequestManager zeroHeaderRequestManager, ZeroNetworkAndTelephonyHelper zeroNetworkAndTelephonyHelper, FetchZeroTokenMethod fetchZeroTokenMethod, FetchZeroHeaderRequestMethod fetchZeroHeaderRequestMethod, FbSharedPreferences fbSharedPreferences, Boolean bool) {
        this.f2087a = zeroTokenFetcher;
        this.f2088b = zeroHeaderRequestManager;
        this.f2089c = zeroNetworkAndTelephonyHelper;
        this.f2090d = fetchZeroTokenMethod;
        this.f2091e = fetchZeroHeaderRequestMethod;
        this.f2092f = fbSharedPreferences;
        this.f2093g = bool.booleanValue();
    }

    public final BatchComponent mo143a() {
        return new MyBatchComponent(this);
    }
}
