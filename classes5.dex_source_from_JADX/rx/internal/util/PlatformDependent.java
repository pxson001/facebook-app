package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: bookmarks_menu */
public final class PlatformDependent {
    private static final boolean f7848a = m14001b();

    /* compiled from: bookmarks_menu */
    final class C08931 implements PrivilegedAction<ClassLoader> {
        C08931() {
        }

        public final Object run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    public static boolean m14000a() {
        return f7848a;
    }

    private static boolean m14001b() {
        try {
            Class.forName("android.app.Application", false, m14002c());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ClassLoader m14002c() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new C08931());
    }
}
