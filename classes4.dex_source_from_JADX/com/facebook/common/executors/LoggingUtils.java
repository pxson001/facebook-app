package com.facebook.common.executors;

import android.os.Build.VERSION;
import com.google.common.util.concurrent.Futures;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: db_write_count */
public class LoggingUtils {
    LoggingUtils() {
    }

    public static String m15007a(Object obj) {
        int i = 4;
        Object obj2 = obj;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                if (!(obj2 instanceof ProvidesName)) {
                    if (!(obj2 instanceof FutureTask)) {
                        if (obj2.getClass().getEnclosingClass() != Futures.class) {
                            break;
                        }
                        obj = m15012c(obj2);
                        if (obj == null) {
                            break;
                        }
                        i = i2;
                        obj2 = obj;
                    } else {
                        obj2 = m15011b(obj2);
                        i = i2;
                    }
                } else {
                    return ((ProvidesName) obj2).a();
                }
            }
            break;
        }
        String name = m15013d(obj2).getClass().getName();
        i = name.lastIndexOf(46) + 1;
        int length = name.length();
        if (length >= 3) {
            int i3 = length - 1;
            int i4 = i3 - 1;
            if (m15010a(name.charAt(i3))) {
                while (i4 >= 0) {
                    char charAt = name.charAt(i4);
                    if (charAt != '$') {
                        if (!m15010a(charAt)) {
                            break;
                        }
                        i4--;
                    } else {
                        length = i4;
                        break;
                    }
                }
            }
        }
        return name.substring(i, length);
    }

    private static Object m15011b(Object obj) {
        Object obj2 = null;
        if (VERSION.SDK_INT <= 16) {
            Object a = m15005a(FutureTask.class, obj, "sync");
            if (a != null) {
                obj2 = m15005a(a.getClass(), a, "callable");
            }
        }
        if (obj2 == null) {
            obj2 = m15005a(FutureTask.class, obj, "callable");
        }
        if (obj2 == null) {
            return obj;
        }
        if (obj2 instanceof ProvidesName) {
            return obj2;
        }
        if (obj2 instanceof Callable) {
            obj = m15006a(obj2.getClass().getName(), obj2, "task");
            if (obj != null) {
                return obj;
            }
        }
        return obj2;
    }

    private static Object m15012c(Object obj) {
        try {
            Class cls = Class.forName(obj.getClass().getName());
            Object a = m15005a(cls, obj, "function");
            if (a != null) {
                return a;
            }
            a = m15005a(cls, obj, "val$function");
            if (a != null) {
                return a;
            }
            a = m15005a(cls, obj, "val$callback");
            if (a == null) {
                return null;
            }
            return a;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Object m15013d(Object obj) {
        Object a = m15005a(obj.getClass(), obj, "this$0");
        if (a != null) {
            return a;
        }
        return obj;
    }

    private static Object m15006a(String str, Object obj, String str2) {
        Object obj2 = null;
        try {
            Field a = m15009a(str, str2);
            if (a != null) {
                obj2 = a.get(obj);
            }
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        }
        return obj2;
    }

    private static Object m15005a(Class cls, Object obj, String str) {
        Object obj2 = null;
        try {
            Field a = m15008a(cls, str);
            if (a != null) {
                obj2 = a.get(obj);
            }
        } catch (IllegalAccessException e) {
        }
        return obj2;
    }

    private static Field m15009a(String str, String str2) {
        try {
            return m15008a(Class.forName(str), str2);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Field m15008a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static boolean m15010a(char c) {
        return c >= '0' && c <= '9';
    }
}
