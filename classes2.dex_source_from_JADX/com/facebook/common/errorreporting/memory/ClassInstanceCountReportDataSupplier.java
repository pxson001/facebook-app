package com.facebook.common.errorreporting.memory;

import android.os.Debug;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.debug.log.BLog;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: trying to switch to dialtone without any activity present! */
public class ClassInstanceCountReportDataSupplier implements FbCustomReportDataSupplier {
    private final String f2233a = ClassInstanceCountReportDataSupplier.class.getSimpleName();
    private final ImmutableList<ClassInstancesToLog> f2234b;
    private final Random f2235c;

    @Inject
    public ClassInstanceCountReportDataSupplier(Set<ClassInstancesToLog> set, Random random) {
        this.f2234b = ImmutableList.copyOf((Collection) set);
        this.f2235c = random;
    }

    public final String mo633a(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Method declaredMethod = Debug.class.getDeclaredMethod("countInstancesOfClass", new Class[]{Class.class});
            ClassInstancesToLog b = m4379b();
            if (b != null) {
                for (Class cls : b.mo636a()) {
                    try {
                        long longValue = ((Long) declaredMethod.invoke(null, new Object[]{cls})).longValue();
                        stringBuilder.append(cls.getSimpleName());
                        stringBuilder.append("=");
                        stringBuilder.append(Long.toString(longValue));
                        stringBuilder.append("\n");
                    } catch (Throwable e) {
                        BLog.b(this.f2233a, e, "Class invocation exception for %s", new Object[]{cls});
                    } catch (Throwable e2) {
                        BLog.b(this.f2233a, e2, "Class illegal access exception for %s", new Object[]{cls});
                    }
                }
            }
            return stringBuilder.toString();
        } catch (NoSuchMethodException e3) {
            return stringBuilder.toString();
        }
    }

    private ClassInstancesToLog m4379b() {
        int size = this.f2234b.size();
        if (size == 0) {
            return null;
        }
        return (ClassInstancesToLog) this.f2234b.get(this.f2235c.nextInt(size));
    }

    public final String mo632a() {
        return "class_instances";
    }
}
