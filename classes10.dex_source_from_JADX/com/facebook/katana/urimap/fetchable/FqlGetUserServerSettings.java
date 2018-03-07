package com.facebook.katana.urimap.fetchable;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.model.UserServerSetting;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.method.FqlGeneratedQuery;
import com.facebook.katana.service.method.ServiceOperationListener;
import com.facebook.katana.util.StringUtils;
import com.facebook.manageddatastore.NetworkRequestCallback;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: timeline_see_more_fail */
public class FqlGetUserServerSettings extends FqlGeneratedQuery {
    private static final Class<?> f1236o = FqlGetUserServerSettings.class;
    protected NetworkRequestCallback<String, String> f1237k;
    public final String f1238l;
    public final String f1239m;
    protected String f1240n;

    public static void m1274a(AppSession appSession, Context context, String str, String str2, NetworkRequestCallback<String, String> networkRequestCallback) {
        appSession.a(context, m1275b(appSession, context, str, str2, networkRequestCallback), 1001, 1020, null);
    }

    private static FqlGetUserServerSettings m1275b(AppSession appSession, Context context, String str, String str2, NetworkRequestCallback<String, String> networkRequestCallback) {
        String str3;
        if (appSession == null || !appSession.c()) {
            str3 = null;
        } else {
            str3 = appSession.b().sessionKey;
        }
        return new FqlGetUserServerSettings(context, null, str3, null, str, str2, networkRequestCallback);
    }

    private FqlGetUserServerSettings(Context context, @Nullable Intent intent, String str, @Nullable ServiceOperationListener serviceOperationListener, String str2, String str3, NetworkRequestCallback<String, String> networkRequestCallback) {
        super(context, intent, str, serviceOperationListener, "user_settings", m1273a(str2, str3), UserServerSetting.class);
        this.f1237k = networkRequestCallback;
        this.f1238l = str2;
        this.f1239m = str3;
    }

    private static String m1273a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("project=").append(StringUtils.a.a(str)).append(" AND setting=").append(StringUtils.a.a(str2));
        return stringBuilder.toString();
    }

    protected final void mo50a(JsonParser jsonParser) {
        this.f1237k.b().a("got response");
        Iterator b = jsonParser.b(UserServerSetting.class);
        while (b.hasNext()) {
            UserServerSetting userServerSetting = (UserServerSetting) b.next();
            if (userServerSetting.mProjectName.equals(this.f1238l) && userServerSetting.mSettingName.equals(this.f1239m)) {
                this.f1240n = userServerSetting.mValue;
            }
        }
    }

    public final void m1276a(Context context, int i) {
        boolean z = i == 200 && this.f1240n != null;
        this.f1237k.b().a("executing callback (valid: %s, settingName: %s)", new Object[]{Boolean.valueOf(z), this.f1239m});
        this.f1237k.a(context, z, this.f1239m, this.f1240n, this.f1240n);
    }
}
