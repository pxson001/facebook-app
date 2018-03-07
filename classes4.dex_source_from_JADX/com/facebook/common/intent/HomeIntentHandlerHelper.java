package com.facebook.common.intent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.facebook.device.DeviceProperties;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: machineId */
public class HomeIntentHandlerHelper {
    private static final Class<?> f8431a = HomeIntentHandlerHelper.class;
    private static final ComponentName f8432b = new ComponentName("com.android.launcher", "com.android.launcher2.Launcher");
    private static final ComponentName f8433c = new ComponentName("", "");
    private static final ImmutableList<String> f8434f = ImmutableList.of("com.htc.launcher", "com.sec.android.app.twlauncher", "com.sec.android.app.launcher");
    private static final ImmutableList<String> f8435g = ImmutableList.of("com.google.android.googlequicksearchbox", "com.android.launcher");
    private final Context f8436d;
    private final DeviceProperties f8437e = new DeviceProperties(this.f8436d);

    public static HomeIntentHandlerHelper m8685b(InjectorLike injectorLike) {
        return new HomeIntentHandlerHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public HomeIntentHandlerHelper(Context context) {
        this.f8436d = (Context) Preconditions.checkNotNull(context);
    }

    public final boolean m8688a() {
        return m8686f().getPackageName().equals("com.htc.launcher");
    }

    public final boolean m8689b() {
        return m8686f().getPackageName().equals("com.sec.android.app.twlauncher");
    }

    public final boolean m8690c() {
        return m8687g().getPackageName().equals("com.sec.android.app.twlauncher");
    }

    public final boolean m8691d() {
        return m8686f().getPackageName().equals("com.sec.android.app.launcher");
    }

    public final boolean m8692e() {
        return m8687g().getPackageName().equals("com.sec.android.app.launcher");
    }

    private ComponentName m8686f() {
        PackageManager packageManager = this.f8436d.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            ComponentName componentName = null;
            int i = 0;
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (!resolveInfo.activityInfo.packageName.startsWith("com.facebook.")) {
                    ComponentName componentName2 = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    if (i < 3 && f8434f.contains(componentName2.getPackageName())) {
                        i = 3;
                        componentName = componentName2;
                    } else if (i >= 2 || !f8435g.contains(componentName2.getPackageName())) {
                        int i2;
                        ComponentName componentName3;
                        if (i <= 0) {
                            i2 = 1;
                            componentName3 = componentName2;
                        } else {
                            i2 = i;
                            componentName3 = componentName;
                        }
                        componentName = componentName3;
                        i = i2;
                    } else {
                        i = 2;
                        componentName = componentName2;
                    }
                }
            }
            if (componentName == null) {
                componentName = f8432b;
            }
            new StringBuilder("Chosen launcher ").append(componentName.getPackageName()).append(" of priority ").append(i);
            return componentName;
        } catch (Exception e) {
            return f8433c;
        }
    }

    private ComponentName m8687g() {
        PackageManager packageManager = this.f8436d.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            PackageItemInfo packageItemInfo = packageManager.resolveActivity(intent, 0).activityInfo;
            return new ComponentName(packageItemInfo.packageName, packageItemInfo.name);
        } catch (Exception e) {
            return f8433c;
        }
    }
}
