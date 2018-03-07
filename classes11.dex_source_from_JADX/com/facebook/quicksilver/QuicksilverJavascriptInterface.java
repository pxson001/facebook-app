package com.facebook.quicksilver;

import android.webkit.JavascriptInterface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.quicksilver.QuicksilverFragment.C13802;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: SONG */
public class QuicksilverJavascriptInterface {
    private static final String f11376a = QuicksilverJavascriptInterface.class.getName();
    private final AbstractFbErrorReporter f11377b;
    private final C13802 f11378c;

    @Inject
    public QuicksilverJavascriptInterface(@Assisted C13802 c13802, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11378c = c13802;
        this.f11377b = abstractFbErrorReporter;
    }

    @JavascriptInterface
    public void postMessage(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            if (string.equals("onendgame")) {
                this.f11378c.m11682a();
            } else if (string.equals("onscore")) {
                this.f11378c.m11683a(jSONObject);
            } else if (string.equals("onbeginload")) {
                this.f11378c.m11685b(jSONObject);
            } else if (string.equals("onprogressload")) {
                this.f11378c.m11686c(jSONObject);
            } else if (string.equals("ongameready")) {
                this.f11378c.m11684b();
            }
        } catch (Throwable e) {
            this.f11377b.a(f11376a, "Invalid JSON received via postMessage: " + str, e);
        }
    }
}
