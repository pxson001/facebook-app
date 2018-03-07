package com.facebook.katana;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebViewClient;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.inject.FbInjector;
import com.facebook.katana.PlatformDialogActivity.PlatformDialogWebViewClient;
import com.facebook.katana.util.URLQueryBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.toaster.Toaster;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: vbox86p */
public class ProxyAuthDialog extends PlatformDialogActivity implements IAuthNotRequired {
    private static final Class<?> f669s = ProxyAuthDialog.class;
    public AbstractFbErrorReporter f670t;
    private String f671u;
    public QeAccessor f672v;

    /* compiled from: vbox86p */
    public class ProxyAuthWebViewClient extends PlatformDialogWebViewClient {
        final /* synthetic */ ProxyAuthDialog f668b;

        protected ProxyAuthWebViewClient(ProxyAuthDialog proxyAuthDialog) {
            this.f668b = proxyAuthDialog;
            super(proxyAuthDialog);
        }
    }

    private static <T extends Context> void m698a(Class<T> cls, T t) {
        m699a((Object) t, (Context) t);
    }

    public static void m699a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProxyAuthDialog proxyAuthDialog = (ProxyAuthDialog) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        proxyAuthDialog.f670t = abstractFbErrorReporter;
        proxyAuthDialog.f672v = qeAccessor;
    }

    public final void mo24b(Bundle bundle) {
        Class cls = ProxyAuthDialog.class;
        m699a((Object) this, (Context) this);
        if (this.f672v.a(ExperimentsForFb4aActivitiesModule.f528a, false)) {
            setRequestedOrientation(1);
        }
        ComponentName callingActivity = getCallingActivity();
        String packageName = callingActivity != null ? callingActivity.getPackageName() : null;
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f671u = getIntent().getExtras().getString("client_id");
            this.f670t.c("client_id", this.f671u);
        }
        if (packageName == null) {
            this.f670t.b("sso", "getCallingPackage==null; finish() called. see t1118578");
            Toaster.a(this, getString(2131232504));
            finish();
        } else if (m700p() == null) {
            this.f670t.b("sso", "getCallingPackageSigHash==null; finish() called. see t1732910");
            Toaster.a(this, getString(2131232505));
            finish();
        }
        super.mo24b(bundle);
    }

    protected final void mo25m() {
        Bundle bundle = new Bundle();
        Bundle extras = getIntent().getExtras();
        for (String str : extras.keySet()) {
            Object obj = extras.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            }
        }
        String str2 = Base64.encodeToString(m700p(), 9);
        bundle.putString("type", "user_agent");
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("display", "touch");
        bundle.putString("android_key", str2);
        StringBuilder append = new StringBuilder().append(NetworkLogUrl.a(this, "https://m.%s/dialog/oauth")).append("?");
        Map treeMap = new TreeMap();
        for (String str3 : bundle.keySet()) {
            treeMap.put(str3, bundle.getString(str3));
        }
        this.q = append.append(URLQueryBuilder.a(treeMap)).toString();
    }

    private byte[] m700p() {
        String l = m695l();
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(hz_());
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("platform_login_get_calling_package");
        honeyClientEvent.b("calling_package_name", l);
        honeyClientEvent.b("client_id", this.f671u);
        if (StringUtil.c(l)) {
            l = m694j();
            honeyClientEvent.b("saved_calling_package_name", l);
        }
        a.a(honeyClientEvent);
        if (StringUtil.c(l)) {
            this.f670t.b("ProxyAuthDialog", "Calling package and saved calling package are both null");
            return null;
        } else if (l.startsWith("com.facebook.katana")) {
            this.f670t.b("ProxyAuthDialog", "not fetching key hash for FB package:" + l);
            return null;
        } else {
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(l, 64);
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(packageInfo.signatures[0].toByteArray());
                    return instance.digest();
                } catch (NoSuchAlgorithmException e) {
                    this.f670t.b("ProxyAuthDialog-alg", "Failed to instantiate SHA-1 algorithm. It is evidently missing from this system.");
                    return null;
                }
            } catch (NameNotFoundException e2) {
                this.f670t.b("ProxyAuthDialog-sig", "Failed to read calling package's signature:" + l);
                return null;
            }
        }
    }

    protected final WebViewClient mo26n() {
        return new ProxyAuthWebViewClient(this);
    }
}
