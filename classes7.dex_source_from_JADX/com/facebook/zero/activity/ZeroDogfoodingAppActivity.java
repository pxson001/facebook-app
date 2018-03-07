package com.facebook.zero.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: ्ऐ */
public class ZeroDogfoodingAppActivity extends FbFragmentActivity {
    @Inject
    InstallShortcutHelper f11p;
    @Inject
    SecureWebViewHelper f12q;

    private static <T extends Context> void m15a(Class<T> cls, T t) {
        m16a((Object) t, (Context) t);
    }

    public static void m16a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ZeroDogfoodingAppActivity) obj).m14a(InstallShortcutHelper.b(fbInjector), SecureWebViewHelper.a(fbInjector));
    }

    public final void m18b(Bundle bundle) {
        super.b(bundle);
        Class cls = ZeroDogfoodingAppActivity.class;
        m16a((Object) this, (Context) this);
        m17i();
        View webView = new WebView(this);
        setContentView(webView);
        this.f12q.a(webView, "https://m.facebook.com/zero/dogfooding");
    }

    private void m17i() {
        Bitmap a = this.f11p.a(getResources().getDrawable(2130844063));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://m.facebook.com/zero/dogfooding"));
        this.f11p.a(intent, "Iorg Dogfooding", a, null, false);
    }

    private void m14a(InstallShortcutHelper installShortcutHelper, SecureWebViewHelper secureWebViewHelper) {
        this.f11p = installShortcutHelper;
        this.f12q = secureWebViewHelper;
    }
}
