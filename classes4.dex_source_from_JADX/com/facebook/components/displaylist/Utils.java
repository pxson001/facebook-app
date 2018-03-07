package com.facebook.components.displaylist;

import java.lang.reflect.Method;

/* compiled from: thread_presence_local_duration */
class Utils {
    Utils() {
    }

    static Object m15024a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            throw new DisplayListException(e);
        }
    }
}
