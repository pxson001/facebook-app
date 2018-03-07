package com.facebook.dialtone.switcher;

import android.net.Uri;
import android.view.View;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetchListener;
import javax.annotation.Nullable;

/* compiled from: permissions_avatar */
class DialtoneManualSwitcherNuxActivity$2 implements ZeroOptinInterstitialContentFetchListener {
    final /* synthetic */ View f6703a;
    final /* synthetic */ View f6704b;
    final /* synthetic */ DialtoneManualSwitcherNuxActivity f6705c;

    DialtoneManualSwitcherNuxActivity$2(DialtoneManualSwitcherNuxActivity dialtoneManualSwitcherNuxActivity, View view, View view2) {
        this.f6705c = dialtoneManualSwitcherNuxActivity;
        this.f6703a = view;
        this.f6704b = view2;
    }

    public final void m6993a(Throwable th) {
        this.f6705c.t.b(this);
        this.f6703a.setVisibility(8);
        this.f6704b.setVisibility(0);
    }

    public final void m6992a(@Nullable FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
        this.f6705c.t.b(this);
        if (fetchZeroInterstitialContentResult == null) {
            this.f6703a.setVisibility(8);
            this.f6704b.setVisibility(0);
            return;
        }
        Uri j = fetchZeroInterstitialContentResult.j();
        this.f6705c.q.edit().a(DialtonePrefKeys.u, j.toString()).commit();
        if (j != null) {
            DialtoneManualSwitcherNuxActivity.a(this.f6705c, j);
        }
        this.f6703a.setVisibility(8);
        this.f6704b.setVisibility(0);
    }
}
