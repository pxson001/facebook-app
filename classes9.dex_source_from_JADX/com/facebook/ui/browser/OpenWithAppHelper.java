package com.facebook.ui.browser;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.browser.lite.BrowserLiteFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;

/* compiled from: topic_feeds_composer_send_post */
public class OpenWithAppHelper {
    public static final String f1524a = OpenWithAppHelper.class.getSimpleName();

    public static boolean m1590a(Context context, String str, AbstractFbErrorReporter abstractFbErrorReporter, GooglePlayIntentHelper googlePlayIntentHelper) {
        if (context == null || StringUtil.a(str)) {
            return false;
        }
        try {
            if (FacebookUriUtil.g(Uri.parse(str))) {
                BLog.b(f1524a, "Ignoring a request to open fb app link from a webpage: %s", new Object[]{Uri.parse(str)});
                return false;
            }
            Intent parseUri = Intent.parseUri(str, 1);
            if (ContextUtils.a(context, Service.class) != null) {
                parseUri.addFlags(268435456);
            }
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                Object obj = parseUri.getPackage();
                if (!StringUtil.a(obj)) {
                    googlePlayIntentHelper.a(context, obj);
                    return true;
                }
            }
            return m1589a(context, parseUri, abstractFbErrorReporter);
        } catch (Throwable e) {
            abstractFbErrorReporter.a(SoftError.a(f1524a + "_startActivityForUrl", "Error trying to create Intent from url:" + str).a(e).g());
            return false;
        }
    }

    private static boolean m1589a(Context context, Intent intent, AbstractFbErrorReporter abstractFbErrorReporter) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("Referer", BrowserLiteFragment.a);
            intent.putExtra("com.android.browser.headers", bundle);
            context.startActivity(intent);
            return true;
        } catch (Throwable e) {
            abstractFbErrorReporter.a(SoftError.a(f1524a + "_startActivityForIntent", "Error trying to launch Activity for intent:" + intent).a(e).g());
            return false;
        }
    }
}
