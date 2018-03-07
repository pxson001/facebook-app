package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import android.util.Log;

/* compiled from: wifi.scan */
public class NavUtils {
    private static final NavUtilsImpl f134a;

    /* compiled from: wifi.scan */
    interface NavUtilsImpl {
        Intent mo18a(Activity activity);

        String mo19a(Context context, ActivityInfo activityInfo);

        boolean mo20a(Activity activity, Intent intent);

        void mo21b(Activity activity, Intent intent);
    }

    /* compiled from: wifi.scan */
    class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }

        public Intent mo18a(Activity activity) {
            String b = NavUtils.m120b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return NavUtils.m121b((Context) activity, componentName) == null ? IntentCompat.m234a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public boolean mo20a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo21b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String mo19a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    /* compiled from: wifi.scan */
    class NavUtilsImplJB extends NavUtilsImplBase {
        public final Intent mo18a(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent == null) {
                return m113b(activity);
            }
            return parentActivityIntent;
        }

        public final boolean mo20a(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }

        public final String mo19a(Context context, ActivityInfo activityInfo) {
            String str = activityInfo.parentActivityName;
            if (str == null) {
                return super.mo19a(context, activityInfo);
            }
            return str;
        }

        NavUtilsImplJB() {
        }

        private Intent m113b(Activity activity) {
            return super.mo18a(activity);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f134a = new NavUtilsImplJB();
        } else {
            f134a = new NavUtilsImplBase();
        }
    }

    public static boolean m119a(Activity activity, Intent intent) {
        return f134a.mo20a(activity, intent);
    }

    public static void m122b(Activity activity, Intent intent) {
        f134a.mo21b(activity, intent);
    }

    public static Intent m117a(Activity activity) {
        return f134a.mo18a(activity);
    }

    public static Intent m118a(Context context, ComponentName componentName) {
        String b = m121b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return m121b(context, componentName2) == null ? IntentCompat.m234a(componentName2) : new Intent().setComponent(componentName2);
    }

    @Nullable
    public static String m120b(Activity activity) {
        try {
            return m121b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static String m121b(Context context, ComponentName componentName) {
        return f134a.mo19a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    private NavUtils() {
    }
}
