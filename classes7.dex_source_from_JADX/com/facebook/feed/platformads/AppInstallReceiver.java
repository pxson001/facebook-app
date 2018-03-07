package com.facebook.feed.platformads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin_click_page_tips */
public class AppInstallReceiver extends DynamicSecureBroadcastReceiver {

    /* compiled from: admin_click_page_tips */
    public class AppInstallActionReceiver implements ActionReceiver {
        @Inject
        public SecureContextHelper f19799a;

        private static <T extends InjectableComponentWithoutContext> void m23057a(Class<T> cls, T t, Context context) {
            m23058a(t, context);
        }

        public static void m23058a(Object obj, Context context) {
            ((AppInstallActionReceiver) obj).f19799a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1739487958);
            Object b = AppInstallReceiver.m23063b(intent);
            if (StringUtil.a(b)) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -590744552, a);
                return;
            }
            Class cls = AppInstallActionReceiver.class;
            m23058a(this, context);
            Intent intent2 = new Intent(context, AppInstallService.class);
            intent2.putExtra("package_name", b);
            intent2.putExtra("action_type", "install");
            this.f19799a.c(intent2, context);
            LogUtils.e(-583392960, a);
        }

        private void m23056a(SecureContextHelper secureContextHelper) {
            this.f19799a = secureContextHelper;
        }
    }

    /* compiled from: admin_click_page_tips */
    public class AppUninstallActionReceiver implements ActionReceiver {
        @Inject
        public SecureContextHelper f19800a;

        private static <T extends InjectableComponentWithoutContext> void m23060a(Class<T> cls, T t, Context context) {
            m23061a(t, context);
        }

        public static void m23061a(Object obj, Context context) {
            ((AppUninstallActionReceiver) obj).f19800a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1319813240);
            Object b = AppInstallReceiver.m23063b(intent);
            if (StringUtil.a(b)) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1323995910, a);
                return;
            }
            Class cls = AppUninstallActionReceiver.class;
            m23061a(this, context);
            Intent intent2 = new Intent(context, AppInstallService.class);
            intent2.putExtra("package_name", b);
            intent2.putExtra("action_type", "uninstall");
            this.f19800a.c(intent2, context);
            LogUtils.e(-1558756851, a);
        }

        private void m23059a(SecureContextHelper secureContextHelper) {
            this.f19800a = secureContextHelper;
        }
    }

    public AppInstallReceiver() {
        super(new Builder().b("android.intent.action.PACKAGE_ADDED", new AppInstallActionReceiver()).b("android.intent.action.PACKAGE_REMOVED", new AppUninstallActionReceiver()).b());
    }

    @Nullable
    public static String m23063b(Intent intent) {
        Uri data = intent.getData();
        return data == null ? null : data.getSchemeSpecificPart();
    }
}
