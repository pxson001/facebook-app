package com.facebook.strictmode;

import com.facebook.strictmode.StrictModeAggregator.ReportableImpl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: NoPreview */
public class IActivityManagerProxy implements InvocationHandler {
    private final Class<?> f12973a = Class.forName("android.os.StrictMode$ViolationInfo");
    private final Field f12974b = this.f12973a.getDeclaredField("crashInfo");
    private final Class<?> f12975c = this.f12974b.getType();
    private final Field f12976d = this.f12975c.getDeclaredField("stackTrace");
    private final ReportableImpl f12977e;
    private final Object f12978f;

    public IActivityManagerProxy(Object obj, ReportableImpl reportableImpl) {
        this.f12978f = obj;
        this.f12977e = reportableImpl;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (!"handleApplicationStrictModeViolation".equals(method.getName())) {
            return method.invoke(this.f12978f, objArr);
        }
        if (objArr.length > 2) {
            Object obj2 = objArr[2];
            if (this.f12973a.isAssignableFrom(obj2.getClass())) {
                obj2 = this.f12976d.get(this.f12974b.get(obj2));
                if (obj2 instanceof String) {
                    ReportableImpl reportableImpl = this.f12977e;
                    String str = (String) obj2;
                    if (str != null && reportableImpl.f12980b.nextInt(StrictModeAggregator.f12981a) == 0) {
                        String str2 = str.split("\n")[0];
                        String[] split = str2.split(": ");
                        if (split.length > 1) {
                            str2 = split[1];
                        }
                        reportableImpl.f12979a.a(str2, str2, str);
                    }
                }
            }
        }
        return null;
    }
}
