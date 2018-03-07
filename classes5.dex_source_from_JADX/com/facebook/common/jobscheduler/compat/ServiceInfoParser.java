package com.facebook.common.jobscheduler.compat;

import android.content.Context;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.SparseArray;
import com.facebook.debug.log.BLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

/* compiled from: socialWifiTitle */
class ServiceInfoParser<T> {
    private static boolean f2673a = false;
    private final SparseArray<Class<? extends T>> f2674b = new SparseArray();
    private final Context f2675c;
    private final String f2676d;
    private final Class<?> f2677e;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: socialWifiTitle */
    public @interface JobType {
    }

    /* compiled from: socialWifiTitle */
    class NoJobMetaDataFoundException extends Exception {
        public NoJobMetaDataFoundException(String str) {
            super(str);
        }
    }

    public ServiceInfoParser(Context context, int i) {
        this.f2675c = context;
        switch (i) {
            case 0:
                this.f2677e = JobServiceCompat.class;
                this.f2676d = "android.permission.BIND_JOB_SERVICE";
                break;
            case 1:
                this.f2677e = GcmTaskServiceCompat.class;
                this.f2676d = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
                break;
            default:
                throw new IllegalArgumentException("unknown jobType: " + i);
        }
        m3777a();
    }

    @Nullable
    public final Class<? extends T> m3779a(int i) {
        return (Class) this.f2674b.get(i);
    }

    private void m3777a() {
        try {
            ServiceInfo[] serviceInfoArr = this.f2675c.getPackageManager().getPackageInfo(this.f2675c.getApplicationInfo().packageName, 4228).services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (this.f2676d.equals(serviceInfo.permission)) {
                        try {
                            m3778a(serviceInfo, this.f2674b, this.f2675c, this.f2677e);
                        } catch (Throwable e) {
                            if (f2673a) {
                                throw new IllegalStateException(e);
                            }
                            BLog.a("ServiceInfoParser", e.toString());
                        }
                    }
                }
            }
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static synchronized <D> void m3778a(ServiceInfo serviceInfo, SparseArray<D> sparseArray, Context context, Class cls) {
        int i = 0;
        synchronized (ServiceInfoParser.class) {
            int i2;
            String str = serviceInfo.name;
            Bundle bundle = serviceInfo.metaData;
            if (bundle != null) {
                i2 = bundle.getInt("com.facebook.common.jobscheduler.compat.jobIds");
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                throw new NoJobMetaDataFoundException("Service " + serviceInfo.name + " is missing meta key com.facebook.common.jobscheduler.compat.jobIds");
            }
            try {
                TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i2);
                while (i < obtainTypedArray.length()) {
                    try {
                        int resourceId = obtainTypedArray.getResourceId(i, 0);
                        if (resourceId == 0) {
                            throw new RuntimeException("value not found");
                        }
                        try {
                            if (sparseArray.get(resourceId) != null) {
                                throw new RuntimeException("Duplicate jobId: " + String.valueOf(resourceId) + " detected for class: " + sparseArray.get(resourceId) + " and " + serviceInfo.name);
                            }
                            Class cls2 = Class.forName(serviceInfo.name);
                            if (cls.isAssignableFrom(cls2)) {
                                sparseArray.put(resourceId, cls2);
                                Integer.valueOf(resourceId);
                                String str2 = serviceInfo.name;
                                i++;
                            } else {
                                throw new RuntimeException("Service class of " + cls2.getName() + " is not assignable to:  " + cls.getName());
                            }
                        } catch (Throwable e) {
                            throw new RuntimeException("Unable to resolve service class " + serviceInfo.name, e);
                        }
                    } finally {
                        obtainTypedArray.recycle();
                    }
                }
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
