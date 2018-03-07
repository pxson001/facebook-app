package com.facebook.directinstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentListener;
import com.facebook.directinstall.appdetails.AppDetailsActivity;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.directinstall.logging.DirectInstallLogger;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onUploadSuccess */
public class DirectInstallIntentListener implements UriIntentListener {
    private final Provider<DirectInstallLogger> f8677a;

    @Inject
    public DirectInstallIntentListener(Provider<DirectInstallLogger> provider) {
        this.f8677a = provider;
    }

    public final void m12477a(Context context, String str, Intent intent, Map<String, Object> map) {
        Object obj;
        if (map != null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("app_details_dialog", Boolean.valueOf(true));
            map = hashMap;
        }
        if (DirectInstallIntentUtils.m12552a(intent.getExtras()) == null || intent.getComponent() == null || !intent.getComponent().getClassName().equals(AppDetailsActivity.class.getName())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            DirectInstallLogger directInstallLogger = (DirectInstallLogger) this.f8677a.get();
            Map hashMap2 = new HashMap();
            if (map != null) {
                hashMap2.putAll(map);
            }
            hashMap2.put("did_direct_install", Boolean.valueOf(true));
            Intent a = NativeThirdPartyUriHelper.a(context, Uri.parse(str));
            if (a != null) {
                NativeThirdPartyUriHelper.a(context, a, hashMap2);
                return;
            }
            SoftErrorBuilder a2 = SoftError.a(DirectInstallLogger.f8813a, StringFormatUtil.formatStrLocaleSafe("Could not log open_application for direct install ad  with url %s", str));
            a2.e = 1;
            a2 = a2;
            a2.d = true;
            directInstallLogger.f8816c.a(a2.g());
        }
    }
}
