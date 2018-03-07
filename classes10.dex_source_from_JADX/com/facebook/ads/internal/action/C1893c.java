package com.facebook.ads.internal.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.C1975b.C1974a;
import com.facebook.ads.internal.util.C1980f;
import com.facebook.ads.internal.util.C1985i;
import com.facebook.ads.internal.util.C1994r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1893c extends C1891a {
    private static final String f13978a = C1893c.class.getSimpleName();
    public final Context f13979b;
    private final Uri f13980c;

    public C1893c(Context context, Uri uri) {
        this.f13979b = context;
        this.f13980c = uri;
    }

    private Uri m14214c() {
        String queryParameter = this.f13980c.getQueryParameter("store_url");
        if (!C1994r.m14486a(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        queryParameter = this.f13980c.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter}));
    }

    private List<C1985i> m14215d() {
        String queryParameter = this.f13980c.getQueryParameter("appsite_data");
        if (C1994r.m14486a(queryParameter) || "[]".equals(queryParameter)) {
            return null;
        }
        List<C1985i> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                C1985i a = C1985i.m14473a(optJSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            Log.w(f13978a, "Error parsing appsite_data", e);
            return arrayList;
        }
    }

    private List<Intent> m14216e() {
        List<C1985i> d = m14215d();
        List<Intent> arrayList = new ArrayList();
        if (d != null) {
            for (C1985i c1985i : d) {
                Intent intent;
                if (C1994r.m14486a(c1985i.f14334a)) {
                    intent = null;
                } else if (C1980f.m14455a(this.f13979b, c1985i.f14334a)) {
                    String str = c1985i.f14336c;
                    if (C1994r.m14486a(str) || !(str.startsWith("tel:") || str.startsWith("telprompt:"))) {
                        PackageManager packageManager = this.f13979b.getPackageManager();
                        if (C1994r.m14486a(c1985i.f14335b) && C1994r.m14486a(str)) {
                            intent = packageManager.getLaunchIntentForPackage(c1985i.f14334a);
                        } else {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            if (!(C1994r.m14486a(c1985i.f14334a) || C1994r.m14486a(c1985i.f14335b))) {
                                intent2.setComponent(new ComponentName(c1985i.f14334a, c1985i.f14335b));
                            }
                            if (!C1994r.m14486a(c1985i.f14336c)) {
                                intent2.setData(Uri.parse(c1985i.f14336c));
                            }
                            Intent intent3 = intent2;
                            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent3, 65536);
                            if (intent3.getComponent() == null) {
                                for (ResolveInfo resolveInfo : queryIntentActivities) {
                                    if (resolveInfo.activityInfo.packageName.equals(c1985i.f14334a)) {
                                        intent3.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                                        break;
                                    }
                                }
                            }
                            intent = (queryIntentActivities.isEmpty() || intent3.getComponent() == null) ? null : intent3;
                        }
                    } else {
                        intent = new Intent("android.intent.action.CALL", Uri.parse(str));
                    }
                } else {
                    intent = null;
                }
                Intent intent4 = intent;
                if (intent4 != null) {
                    arrayList.add(intent4);
                }
            }
        }
        return arrayList;
    }

    private void m14217f() {
        Intent intent = new Intent("android.intent.action.VIEW", m14214c());
        intent.addFlags(268435456);
        try {
            this.f13979b.startActivity(intent);
        } catch (Throwable e) {
            Log.d(f13978a, "Failed to open market url: " + this.f13980c.toString(), e);
            String queryParameter = this.f13980c.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                intent2.addFlags(268435456);
                try {
                    this.f13979b.startActivity(intent2);
                } catch (Throwable e2) {
                    Log.d(f13978a, "Failed to open fallback url: " + queryParameter, e2);
                }
            }
        }
    }

    public final C1974a mo704a() {
        return C1974a.OPEN_STORE;
    }

    public final void mo705b() {
        C1891a.m14210a(this.f13979b, this.f13980c);
        List<Intent> e = m14216e();
        if (e != null) {
            for (Intent startActivity : e) {
                try {
                    this.f13979b.startActivity(startActivity);
                    return;
                } catch (Throwable e2) {
                    Log.d(f13978a, "Failed to open app intent, falling back", e2);
                }
            }
        }
        m14217f();
    }
}
