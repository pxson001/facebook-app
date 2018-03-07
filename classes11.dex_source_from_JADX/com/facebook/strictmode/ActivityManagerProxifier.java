package com.facebook.strictmode;

import com.facebook.strictmode.StrictModeAggregator.ReportableImpl;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLParsers.FetchTimelineSingleCollectionViewQueryParser;
import java.lang.reflect.Proxy;

/* compiled from: Non-Authoritative Information */
public class ActivityManagerProxifier {
    private static Object f12972a;

    /* compiled from: Non-Authoritative Information */
    public final class ActivityManagerNativeClass {
        public static Object m13699a() {
            return FetchTimelineSingleCollectionViewQueryParser.m14747b().getDeclaredMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        }
    }

    /* compiled from: Non-Authoritative Information */
    public final class IActivityManagerClass {
        public static Class<?> m13700b() {
            return Class.forName("android.app.IActivityManager");
        }
    }

    ActivityManagerProxifier() {
    }

    private static Object m13701a(Object obj, ReportableImpl reportableImpl) {
        return Proxy.newProxyInstance(IActivityManagerClass.m13700b().getClassLoader(), new Class[]{IActivityManagerClass.m13700b()}, new IActivityManagerProxy(obj, reportableImpl));
    }

    public static synchronized void m13702a(boolean z, ReportableImpl reportableImpl) {
        synchronized (ActivityManagerProxifier.class) {
            Object a;
            if (z) {
                try {
                    if (f12972a == null) {
                        a = FetchTimelineSingleCollectionViewQueryParser.m14744a(m13701a(ActivityManagerNativeClass.m13699a(), reportableImpl));
                        f12972a = a;
                        if (a == null) {
                            throw new StrictModeNotSupportedException("Failed to get original activity manager.");
                        }
                    }
                } catch (StrictModeNotSupportedException e) {
                    throw e;
                } catch (Throwable th) {
                    StrictModeNotSupportedException strictModeNotSupportedException = new StrictModeNotSupportedException("Unexpected exception was thrown.", th);
                }
            }
            if (!(z || f12972a == null)) {
                a = FetchTimelineSingleCollectionViewQueryParser.m14744a(f12972a);
                f12972a = null;
                if (a == null) {
                    throw new StrictModeNotSupportedException("Original activity manager is null.");
                }
            }
        }
        return;
    }
}
