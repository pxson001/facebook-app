package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.FbAppType;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.Method;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.service.method.NetworkServiceOperation.NetworkServiceOperationHttpListener;
import com.facebook.katana.util.SignatureBuilder;
import com.facebook.katana.util.URLQueryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: to_list */
public abstract class ApiMethod extends NetworkServiceOperation {
    private static final Class<?> f1194k;
    private static final String f1195l;
    protected final String f1196a;
    protected final String f1197b;
    protected final Map<String, String> f1198c = new TreeMap();
    public Locales f1199m;

    static {
        Class cls = ApiMethod.class;
        f1194k = cls;
        f1195l = cls.getSimpleName();
    }

    protected final void mo48a(ServiceOperation serviceOperation, int i, String str, @Nullable Exception exception) {
        if (null != null) {
            exception = new FacebookApiException(102, "Invalid credentials");
        }
        super.mo48a(serviceOperation, i, str, exception);
    }

    protected ApiMethod(Context context, @Nullable Intent intent, String str, String str2, String str3, @Nullable ServiceOperationListener serviceOperationListener) {
        super(context, intent, str, serviceOperationListener);
        this.f1196a = str2;
        this.f1197b = str3;
        this.f1193f = new NetworkServiceOperationHttpListener(this);
        this.f1199m = Locales.a(FbInjector.get(this.f1187h));
    }

    private String m1218e() {
        return getClass().getSimpleName();
    }

    public final void mo46a() {
        try {
            m1219f();
            m1220g();
            String e = m1218e();
            if (this.f1191d.equals("GET")) {
                this.e = new HttpOperation(this.f1187h, Method.GET, m1216a(this.f1197b), this.f1193f, true, e);
            } else if (this.f1191d.equals("POST")) {
                this.e = new HttpOperation(this.f1187h, this.f1197b, m1221h().toString(), "application/x-www-form-urlencoded", this.f1193f, true, e);
            }
            this.f1192e.b();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.f1189j != null) {
                this.f1189j.mo45a(this, 0, null, e2);
            }
        }
    }

    public final void mo49a(boolean z) {
        if (this.f1192e != null) {
            HttpOperation httpOperation = this.f1192e;
            if (httpOperation.j != null) {
                httpOperation.j.interrupt();
            }
            httpOperation.a.abort();
            if (z) {
                mo48a(this, 0, null, null);
            }
            this.e = null;
        }
    }

    public static boolean m1217a(Exception exception) {
        if (exception == null || !(exception instanceof FacebookApiException)) {
            return false;
        }
        int a = ((FacebookApiException) exception).m982a();
        if (a == 102 || a == 190) {
            return true;
        }
        return false;
    }

    private void m1219f() {
        this.f1198c.put("api_key", ((FbAppType) FbInjector.get(this.f1187h).getInstance(FbAppType.class)).d());
        this.f1198c.put("format", "JSON");
        this.f1198c.put("method", this.f1196a);
        this.f1198c.put("v", "1.0");
        this.f1198c.put("return_ssl_resources", "1");
        this.f1198c.put("locale", this.f1199m.c());
        if (this.f1188i.hasExtra("access_token")) {
            this.f1198c.put("access_token", this.f1188i.getStringExtra("access_token"));
        }
    }

    private void m1220g() {
        this.f1198c.put("sig", SignatureBuilder.a(this.f1198c, ""));
    }

    private String m1216a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        CharSequence h = m1221h();
        if (h.length() == 0) {
            String name = getClass().getName();
            if (f1195l != name) {
                StringBuffer stringBuffer = new StringBuffer(f1195l);
                stringBuffer.append("(");
                stringBuffer.append(name);
                stringBuffer.append(")");
                name = stringBuffer.toString();
            } else {
                name = f1195l;
            }
            BLog.b(name, "We always should have something in the query (e.g., the signature)");
            return str;
        }
        stringBuilder.append("?");
        stringBuilder.append(h);
        return stringBuilder.toString();
    }

    private StringBuilder m1221h() {
        return URLQueryBuilder.a(this.f1198c);
    }

    protected final void mo47a(ResponseInputStream responseInputStream) {
        JsonParser a = JsonFactoryMethodAutoProvider.a(FbInjector.get(this.f1187h)).a(responseInputStream);
        FbJsonChecker.a(a);
        mo50a(a);
    }

    protected void mo50a(JsonParser jsonParser) {
    }
}
