package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import org.json.JSONObject;

/* compiled from: SEND_SKIPPED_HAS_EVENT_MESSAGE */
public class FacebookWebFallbackDialog extends WebDialog {
    private static final String f23999a = FacebookWebFallbackDialog.class.getName();
    private boolean f24000b;

    /* compiled from: SEND_SKIPPED_HAS_EVENT_MESSAGE */
    class C34481 implements Runnable {
        final /* synthetic */ FacebookWebFallbackDialog f23988a;

        C34481(FacebookWebFallbackDialog facebookWebFallbackDialog) {
            this.f23988a = facebookWebFallbackDialog;
        }

        public void run() {
            super.cancel();
        }
    }

    public FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        this.f23990b = str2;
    }

    protected final Bundle mo1039a(String str) {
        Bundle b = Utility.m25348b(Uri.parse(str).getQuery());
        String string = b.getString("bridge_args");
        b.remove("bridge_args");
        if (!Utility.m25345a(string)) {
            try {
                b.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.m25252a(new JSONObject(string)));
            } catch (Throwable e) {
                Utility.m25340a(f23999a, "Unable to parse bridge_args JSON", e);
            }
        }
        string = b.getString("method_results");
        b.remove("method_results");
        if (!Utility.m25345a(string)) {
            if (Utility.m25345a(string)) {
                string = "{}";
            }
            try {
                b.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.m25252a(new JSONObject(string)));
            } catch (Throwable e2) {
                Utility.m25340a(f23999a, "Unable to parse bridge_args JSON", e2);
            }
        }
        b.remove("version");
        b.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.m25291a());
        return b;
    }

    public void cancel() {
        WebView webView = this.f23992d;
        if (!this.f23998j || this.f23996h || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.f24000b) {
            this.f24000b = true;
            webView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            HandlerDetour.b(new Handler(Looper.getMainLooper()), new C34481(this), 1500, 1999187012);
        }
    }
}
