package com.facebook.messaging.login;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: is_in_tray */
public class RemoteLogoutBroadcastReceiver extends DynamicSecureBroadcastReceiver {

    /* compiled from: is_in_tray */
    public class RemoteLogoutActionReceiver implements ActionReceiver {
        @Inject
        public FbSharedPreferences f12060a;

        private static <T extends InjectableComponentWithoutContext> void m18980a(Class<T> cls, T t, Context context) {
            m18981a(t, context);
        }

        public static void m18981a(Object obj, Context context) {
            ((RemoteLogoutActionReceiver) obj).f12060a = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
        }

        private void m18979a(FbSharedPreferences fbSharedPreferences) {
            this.f12060a = fbSharedPreferences;
        }

        RemoteLogoutActionReceiver() {
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 122312413);
            Class cls = RemoteLogoutActionReceiver.class;
            m18981a(this, context);
            if (this.f12060a.a()) {
                this.f12060a.edit().putBoolean(LoginPrefKeys.b, true).commit();
                LogUtils.e(470893496, a);
                return;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1110505446, a);
        }
    }

    public RemoteLogoutBroadcastReceiver() {
        super("ACTION_MQTT_NO_AUTH", new RemoteLogoutActionReceiver());
    }
}
