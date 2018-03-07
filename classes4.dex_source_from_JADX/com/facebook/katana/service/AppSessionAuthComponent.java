package com.facebook.katana.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.facebook.auth.broadcast.SsoLoginBroadcaster;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.file.FileTree;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ForAppContext;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.provider.legacykeyvalue.KeyValueStore;
import com.facebook.katana.provider.legacykeyvalue.LegacyKeyValueStore;
import com.facebook.katana.provider.legacykeyvalue.UserValuesManager;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.manageddatastore.ManagedDataStore;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.webview.FacebookJsBridge;
import javax.inject.Inject;

/* compiled from: sync_photo_success */
public class AppSessionAuthComponent extends AbstractAuthComponent {
    private final Context f1425a;

    @Inject
    public AppSessionAuthComponent(@ForAppContext Context context) {
        this.f1425a = context;
    }

    public final void m1665c() {
        AppSession a = AppSession.a(this.f1425a);
        ViewerContext a2 = a.n.a();
        a.k.edit().a(FbandroidPrefKeys.n, a2.mUsername).commit();
        a.k.edit().a(FbandroidPrefKeys.o, SecureHashUtil.a(a2.mUserId)).commit();
        Intent intent = new Intent(a.r, FacebookService.class);
        intent.putExtra("type", 2);
        Context context = a.r;
        String k = AppSession.k();
        if (a.c()) {
            String str = a.b().oAuthToken;
            if (str != null) {
                intent.putExtra("access_token", str);
            }
        }
        if (LoginStatus.STATUS_LOGGING_IN != a.f || AppSession.a(intent)) {
            a.e.put(k, intent);
            context.startService(intent);
        }
        SsoLoginBroadcaster.m1711b(FbInjector.get(a.r)).m1713b();
        a.e.clear();
        a.a.b();
        a.r.stopService(new Intent(a.r, FacebookService.class));
        FacebookService.a.clear();
    }

    public final void m1666f() {
        AppSession a = AppSession.a(this.f1425a);
        FileTree.m3117a(a.r.getFilesDir().getAbsoluteFile());
        AppSession.e(a.r);
        FacebookJsBridge.a(a.r);
        PreferenceManager.getDefaultSharedPreferences(a.r).edit().clear().commit();
        Context context = a.r;
        KeyValueStore keyValueStore = UserValuesManager.m11494d(context).f11062a;
        LegacyKeyValueStore legacyKeyValueStore = keyValueStore.f11076c;
        legacyKeyValueStore.f11063a.delete(legacyKeyValueStore.f11064b, null, null);
        keyValueStore.f11074a.edit().b(keyValueStore.f11075b).commit();
        UserValuesManager.m11490a(context, true);
        ManagedDataStore.m1815a();
    }

    public final void m1667g() {
        AppSession a = AppSession.a(this.f1425a);
        a.k.edit().a(FbandroidPrefKeys.p, System.currentTimeMillis()).commit();
        AppSession.a(a, LoginStatus.STATUS_LOGGED_OUT);
        NotificationLogObject notificationLogObject = new NotificationLogObject();
        notificationLogObject.c = null;
        notificationLogObject = notificationLogObject;
        notificationLogObject.d = 1;
        NotificationLogObject notificationLogObject2 = notificationLogObject;
        FbInjector fbInjector = FbInjector.get(a.r);
        ComponentName b = ComponentName_LoginActivityComponentMethodAutoProvider.b(fbInjector);
        if (a.i) {
            ((SystemTrayNotificationManager) a.t.get()).m12205a(NotificationType.AUTHENTICATION_FAILED, SystemTrayNotificationBuilder.b(fbInjector).a(a.r.getString(2131232478)).d(a.r.getResources().getString(2131236352)).c(a.r.getString(2131232478)).a(17301642).a(System.currentTimeMillis()), new Intent().setComponent(b), Component.ACTIVITY, notificationLogObject2);
            a.i = false;
        }
    }
}
