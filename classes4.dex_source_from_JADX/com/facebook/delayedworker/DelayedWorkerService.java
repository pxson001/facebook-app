package com.facebook.delayedworker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: flush_tag_upload_now */
public class DelayedWorkerService extends FbIntentService {
    private static final String f11497a = DelayedWorkerService.class.getSimpleName();
    private static final String f11498b = (DelayedWorkerService.class.getName() + ".facebook.com");
    public DelayedWorkerExecutionTimeManager f11499c;
    public AbstractFbErrorReporter f11500d;

    private static <T extends Context> void m11987a(Class<T> cls, T t) {
        m11988a((Object) t, (Context) t);
    }

    public static void m11988a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DelayedWorkerService delayedWorkerService = (DelayedWorkerService) obj;
        DelayedWorkerExecutionTimeManager a = DelayedWorkerExecutionTimeManager.m8918a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        delayedWorkerService.f11499c = a;
        delayedWorkerService.f11500d = abstractFbErrorReporter;
    }

    public DelayedWorkerService() {
        super(DelayedWorkerService.class.getSimpleName());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 663028100);
        super.onCreate();
        Class cls = DelayedWorkerService.class;
        m11988a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 2114246124, a);
    }

    protected final void m11989a(Intent intent) {
        Process.setThreadPriority(10);
        if (intent != null) {
            AppInitLockHelper.a(this);
            Uri data = intent.getData();
            if (data != null) {
                data.toString();
                AbstractDelayedWorker a = m11984a(m11985a(data));
                if (a != null) {
                    a.f11496a = getApplicationContext();
                    a.mo851a();
                    a.mo852b();
                    m11986a(data, a.getClass());
                }
            }
        }
    }

    public static Uri m11983a(String str, boolean z) {
        Builder builder = new Builder();
        builder.authority(f11498b).appendQueryParameter("class", str);
        if (z) {
            builder.appendQueryParameter("last", Boolean.toString(true));
        }
        return builder.build();
    }

    private static String m11985a(Uri uri) {
        if (f11498b.equals(uri.getAuthority())) {
            return uri.getQueryParameter("class");
        }
        return null;
    }

    private AbstractDelayedWorker m11984a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof AbstractDelayedWorker) {
                    return (AbstractDelayedWorker) newInstance;
                }
                this.f11500d.b(f11497a, "It's not a DelayedWorker instance - DelayedWorkerClassName: " + str);
                return null;
            } catch (Throwable e) {
                this.f11500d.b(f11497a, "DelayedWorkerClassName: " + str, e);
                return null;
            } catch (Throwable e2) {
                this.f11500d.b(f11497a, "DelayedWorkerClassName: " + str, e2);
                return null;
            }
        } catch (ClassNotFoundException e3) {
            new Object[1][0] = str;
            return null;
        }
    }

    private void m11986a(Uri uri, Class<? extends DelayedWorker> cls) {
        if (Boolean.valueOf(uri.getQueryParameter("last")).booleanValue()) {
            PrefKey prefKey = (PrefKey) DelayedWorkerExecutionTimeManager.f8668a.a(cls.getName());
            this.f11499c.f8670b.edit().a(prefKey).commit();
        }
    }
}
