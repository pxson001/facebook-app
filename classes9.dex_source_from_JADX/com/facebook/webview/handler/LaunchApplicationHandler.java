package com.facebook.webview.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.invariants.Invariants;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacewebPalCall;
import com.facebook.webview.FacewebUriPalCall;

/* compiled from: shipping_address */
public class LaunchApplicationHandler implements NativeCallHandler {
    private Handler f3526a;

    public LaunchApplicationHandler(Handler handler) {
        this.f3526a = handler;
    }

    public final void mo85a(final Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
        Invariants.a(facewebPalCall instanceof FacewebUriPalCall);
        if (facewebPalCall instanceof FacewebUriPalCall) {
            final Uri uri = ((FacewebUriPalCall) facewebPalCall).f3515b;
            HandlerDetour.a(this.f3526a, new Runnable(this) {
                final /* synthetic */ LaunchApplicationHandler f3525c;

                public void run() {
                    Intent a = NativeThirdPartyUriHelper.a(context, uri);
                    if (a != null) {
                        NativeThirdPartyUriHelper.a(context, a);
                        ((SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context))).b(a, context);
                    }
                }
            }, -1120966120);
        }
    }
}
