package com.facebook.zero.activity;

import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.zero.capping.SimpleMessageCapListener;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetchListener;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetchListener;
import javax.annotation.Nullable;

/* compiled from: ्ऊ */
class ZeroOptinInterstitialActivity$3 implements ZeroOptinInterstitialContentFetchListener {
    final /* synthetic */ String f52a;
    final /* synthetic */ String f53b;
    final /* synthetic */ Bundle f54c;
    final /* synthetic */ ZeroOptinInterstitialActivity f55d;

    /* compiled from: ्ऊ */
    class C00101 implements ZeroTokenFetchListener {
        final /* synthetic */ ZeroOptinInterstitialActivity$3 f51a;

        /* compiled from: ्ऊ */
        class C00091 extends SimpleMessageCapListener {
            final /* synthetic */ C00101 f50a;

            C00091(C00101 c00101) {
                this.f50a = c00101;
            }
        }

        C00101(ZeroOptinInterstitialActivity$3 zeroOptinInterstitialActivity$3) {
            this.f51a = zeroOptinInterstitialActivity$3;
        }

        public final void m53a(Throwable th, ZeroTokenType zeroTokenType) {
            this.f51a.f55d.x.b(this);
            this.f51a.f55d.y.a(th, zeroTokenType);
            ZeroOptinInterstitialActivity.a(this.f51a.f55d, this.f51a.f53b, this.f51a.f54c);
        }

        public final void m52a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
            this.f51a.f55d.x.b(this);
            this.f51a.f55d.y.a(zeroToken, zeroTokenType);
            if (((Boolean) this.f51a.f55d.D.get()).booleanValue()) {
                C00091 c00091 = new C00091(this);
                this.f51a.f55d.C.get();
                this.f51a.f55d.C.get();
                return;
            }
            ZeroOptinInterstitialActivity.a(this.f51a.f55d, this.f51a.f53b, this.f51a.f54c);
        }
    }

    ZeroOptinInterstitialActivity$3(ZeroOptinInterstitialActivity zeroOptinInterstitialActivity, String str, String str2, Bundle bundle) {
        this.f55d = zeroOptinInterstitialActivity;
        this.f52a = str;
        this.f53b = str2;
        this.f54c = bundle;
    }

    public final void m55a(Throwable th) {
        this.f55d.z.b(this);
        this.f55d.finish();
    }

    public final void m54a(@Nullable FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
        this.f55d.z.b(this);
        if (StringUtil.a(this.f52a)) {
            ZeroOptinInterstitialActivity.a(this.f55d, this.f53b, this.f54c);
        } else {
            ZeroTokenType valueOf = ZeroTokenType.valueOf(this.f52a);
            this.f55d.x.a(new C00101(this));
            this.f55d.x.a(valueOf, TokenRequestReason.OPTIN);
        }
        ZeroOptinInterstitialActivity.a(this.f55d, fetchZeroInterstitialContentResult);
        ZeroOptinInterstitialActivity.r(this.f55d);
    }
}
