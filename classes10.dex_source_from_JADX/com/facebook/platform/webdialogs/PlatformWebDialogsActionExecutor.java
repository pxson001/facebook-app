package com.facebook.platform.webdialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.content.SecureContextHelper;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.webview.FacebookWebView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: location_message_map_view */
public class PlatformWebDialogsActionExecutor extends AbstractPlatformActionExecutor {
    public final PlatformWebDialogsPerformanceLogger f8477a;
    public final Provider<ViewerContext> f8478b;
    public final ObjectMapper f8479c;
    private final SecureContextHelper f8480d;
    public final Activity f8481e;
    private final Intent f8482f;
    public final PlatformAppCall f8483g;
    public final Provider<String> f8484h;
    public final Provider<String> f8485i;
    private boolean f8486j;

    public PlatformWebDialogsActionExecutor(PlatformWebDialogsPerformanceLogger platformWebDialogsPerformanceLogger, Provider<ViewerContext> provider, ObjectMapper objectMapper, SecureContextHelper secureContextHelper, Activity activity, Intent intent, PlatformAppCall platformAppCall, Provider<String> provider2, Provider<String> provider3) {
        this.f8477a = platformWebDialogsPerformanceLogger;
        this.f8478b = provider;
        this.f8479c = objectMapper;
        this.f8480d = secureContextHelper;
        this.f8481e = activity;
        this.f8482f = intent;
        this.f8483g = platformAppCall;
        this.f8484h = provider2;
        this.f8485i = provider3;
    }

    public final void m8386a(int i, int i2, Intent intent) {
        if (i == 195) {
            Bundle extras;
            if (intent != null) {
                extras = intent.getExtras();
            } else {
                extras = new Bundle();
            }
            if (i2 == -1) {
                d(extras);
                return;
            }
            if (!this.f8483g.c) {
                extras = PlatformAppResults.a(this.f8483g, "ApplicationError", "Error occurred in dialog's operation");
            }
            c(extras);
        }
    }

    public final void m8387a(Bundle bundle) {
        if (bundle != null) {
            this.f8486j = bundle.getBoolean("is_ui_showing");
        }
        if (!this.f8486j) {
            this.f8486j = true;
            this.f8477a.m8419a(this.f8483g);
            PlatformActivityWebDialogsRequest platformActivityWebDialogsRequest = new PlatformActivityWebDialogsRequest();
            Bundle bundle2;
            if (platformActivityWebDialogsRequest.a(this.f8483g, this.f8482f)) {
                Bundle bundle3;
                Intent intent = new Intent(this.f8481e, PlatformWebDialogsActivity.class);
                Bundle a = PlatformAppCall.a(this.f8482f);
                if (platformActivityWebDialogsRequest.f8476b == null) {
                    bundle3 = null;
                } else {
                    bundle3 = new Bundle(platformActivityWebDialogsRequest.f8476b);
                }
                bundle2 = bundle3;
                if (!this.f8483g.c) {
                    if (platformActivityWebDialogsRequest.f8475a == null) {
                        bundle3 = null;
                    } else {
                        bundle3 = new Bundle(platformActivityWebDialogsRequest.f8475a);
                    }
                    bundle2 = bundle3;
                    bundle3 = new Bundle();
                    bundle3.putString("app_name", this.f8483g.f);
                    bundle2.remove("com.facebook.platform.extra.APPLICATION_NAME");
                    bundle3.putString("action_id", this.f8483g.a);
                    bundle2.remove("com.facebook.platform.protocol.CALL_ID");
                    a = bundle3;
                }
                intent.putExtra("com.facebook.platform.webdialogs.APPCALL_PARCEL", this.f8483g);
                intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", a);
                intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle2);
                Bundle bundle4 = new Bundle();
                bundle4.putString("uid", (String) this.f8484h.get());
                bundle4.putString("access_token", (String) this.f8485i.get());
                bundle4.putString("android_calling_package", this.f8483g.d);
                bundle4.putString("android_key_hash", this.f8483g.g);
                intent.putExtra("com.facebook.platform.webdialogs.HOST_ARGS", bundle4);
                intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", this.f8483g.b);
                this.f8477a.m8430i();
                ViewerContext viewerContext = (ViewerContext) this.f8478b.get();
                if (viewerContext != null) {
                    String str = viewerContext.mSessionCookiesString;
                    if (!Strings.isNullOrEmpty(str)) {
                        ImmutableList a2 = SessionCookie.a(this.f8479c, str);
                        if (a2 != null) {
                            FacebookWebView.a(this.f8481e.getApplicationContext(), NetworkLogUrl.a(this.f8481e, "https://m.%s"), a2);
                        }
                    }
                }
                this.f8477a.m8431j();
                this.f8477a.m8418a();
                this.f8480d.a(intent, 195, this.f8481e);
                return;
            }
            bundle2 = platformActivityWebDialogsRequest.b;
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle2.putString("com.facebook.platform.status.ERROR_CODE", "UnknownError");
            }
            c(bundle2);
            this.f8477a.m8433l();
        }
    }

    public final void m8388b(Bundle bundle) {
        super.b(bundle);
        bundle.putBoolean("is_ui_showing", this.f8486j);
    }
}
