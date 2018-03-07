package com.facebook.http.strictsocket;

import android.annotation.TargetApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.SocketImpl;

/* compiled from: viewability_check_interval */
public class PlainSocketImplFactory {
    private static boolean f378a = false;
    private static Constructor<SocketImpl> f379b;
    private static Constructor<SocketImpl> f380c;
    private static Constructor<SocketImpl> f381d;
    private static Constructor<SocketImpl> f382e;

    /* compiled from: viewability_check_interval */
    public class InitializationException extends IOException {
        @TargetApi(9)
        public InitializationException(String str, Exception exception) {
            super(str, exception);
        }

        public InitializationException(String str) {
            super(str);
        }
    }

    public static SocketImpl m513a() {
        m514b();
        try {
            return (SocketImpl) f381d.newInstance(new Object[0]);
        } catch (Exception e) {
            throw new InitializationException("Failed to instantiate PlainSocketImpl", e);
        } catch (Exception e2) {
            throw new InitializationException("Failed to instantiate PlainSocketImpl", e2);
        } catch (Exception e22) {
            throw new InitializationException("Failed to instantiate PlainSocketImpl", e22);
        }
    }

    private static synchronized void m514b() {
        synchronized (PlainSocketImplFactory.class) {
            if (!f378a) {
                try {
                    Class cls = Class.forName("java.net.PlainSocketImpl");
                    if (SocketImpl.class.isAssignableFrom(cls)) {
                        f379b = cls.getDeclaredConstructor(new Class[]{FileDescriptor.class});
                        f380c = cls.getDeclaredConstructor(new Class[]{Proxy.class});
                        f381d = cls.getDeclaredConstructor(new Class[0]);
                        f382e = cls.getDeclaredConstructor(new Class[]{FileDescriptor.class, Integer.TYPE, InetAddress.class, Integer.TYPE});
                        f378a = true;
                    } else {
                        throw new InitializationException("Class found but not instance of SocketImpl");
                    }
                } catch (Exception e) {
                    throw new InitializationException("Failed to initialise DefaultSocketImpl", e);
                } catch (Exception e2) {
                    throw new InitializationException("Failed to initialise DefaultSocketImpl", e2);
                }
            }
        }
    }
}
