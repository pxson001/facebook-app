package com.facebook.http.strictsocket;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

/* compiled from: viewability_check_initial_delay */
public class StrictSocketImpl extends SocketImpl {
    private static boolean f383a;
    private static Field f384d;
    private static Field f385e;
    private static Field f386f;
    private static Field f387g;
    private static Method f388h;
    private static Method f389i;
    private static Method f390j;
    private static Method f391k;
    private static Method f392l;
    private static Method f393m;
    private static Method f394n;
    private static Method f395o;
    private static Method f396p;
    private static Method f397q;
    private static Method f398r;
    private static Method f399s;
    private SocketImpl f400b;
    private StrictSocketManager f401c;

    /* compiled from: viewability_check_initial_delay */
    public class StrictSocketCallException extends IOException {
        public StrictSocketCallException(Throwable th) {
            super(th);
        }
    }

    /* compiled from: viewability_check_initial_delay */
    public class StrictSocketCastException extends IOException {
    }

    /* compiled from: viewability_check_initial_delay */
    public class StrictSocketInitException extends IOException {
        public StrictSocketInitException(Throwable th) {
            super(th);
        }
    }

    public StrictSocketImpl(SocketImpl socketImpl, StrictSocketManager strictSocketManager) {
        m516a();
        this.f401c = strictSocketManager;
        this.f400b = socketImpl;
    }

    protected void accept(SocketImpl socketImpl) {
        m515a(Void.class, f388h, socketImpl);
    }

    protected int available() {
        return ((Integer) m515a(Integer.class, f389i, new Object[0])).intValue();
    }

    protected void bind(InetAddress inetAddress, int i) {
        m515a(Void.class, f390j, inetAddress, Integer.valueOf(i));
    }

    protected void close() {
        m515a(Void.class, f391k, new Object[0]);
    }

    protected void connect(String str, int i) {
        this.f401c.m523a(str, i);
        m515a(Void.class, f392l, str, Integer.valueOf(i));
    }

    protected void connect(InetAddress inetAddress, int i) {
        this.f401c.m523a(inetAddress.getHostName(), i);
        m515a(Void.class, f393m, inetAddress, Integer.valueOf(i));
    }

    protected void create(boolean z) {
        m515a(Void.class, f394n, Boolean.valueOf(z));
    }

    protected InputStream getInputStream() {
        return (InputStream) m515a(InputStream.class, f395o, new Object[0]);
    }

    protected OutputStream getOutputStream() {
        return (OutputStream) m515a(OutputStream.class, f396p, new Object[0]);
    }

    protected void listen(int i) {
        m515a(Void.class, f397q, Integer.valueOf(i));
    }

    protected void connect(SocketAddress socketAddress, int i) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            this.f401c.m523a(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
        } else {
            this.f401c.m523a("<unknown>", 0);
        }
        m515a(Void.class, f398r, socketAddress, Integer.valueOf(i));
    }

    protected void sendUrgentData(int i) {
        m515a(Void.class, f399s, Integer.valueOf(i));
    }

    public Object getOption(int i) {
        return this.f400b.getOption(i);
    }

    public void setOption(int i, Object obj) {
        this.f400b.setOption(i, obj);
    }

    private static synchronized void m516a() {
        synchronized (StrictSocketImpl.class) {
            if (!f383a) {
                Class cls = SocketImpl.class;
                try {
                    Method declaredMethod = cls.getDeclaredMethod("accept", new Class[]{SocketImpl.class});
                    f388h = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("available", new Class[0]);
                    f389i = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("bind", new Class[]{InetAddress.class, Integer.TYPE});
                    f390j = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("close", new Class[0]);
                    f391k = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("connect", new Class[]{String.class, Integer.TYPE});
                    f392l = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("connect", new Class[]{InetAddress.class, Integer.TYPE});
                    f393m = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("create", new Class[]{Boolean.TYPE});
                    f394n = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("getInputStream", new Class[0]);
                    f395o = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("getOutputStream", new Class[0]);
                    f396p = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("listen", new Class[]{Integer.TYPE});
                    f397q = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("connect", new Class[]{SocketAddress.class, Integer.TYPE});
                    f398r = declaredMethod;
                    declaredMethod.setAccessible(true);
                    declaredMethod = cls.getDeclaredMethod("sendUrgentData", new Class[]{Integer.TYPE});
                    f399s = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Field declaredField = cls.getDeclaredField("address");
                    f384d = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = cls.getDeclaredField("port");
                    f385e = declaredField;
                    declaredField.setAccessible(true);
                    declaredField = cls.getDeclaredField("fd");
                    f386f = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = cls.getDeclaredField("localport");
                    f387g = declaredField2;
                    declaredField2.setAccessible(true);
                    f383a = true;
                } catch (Throwable e) {
                    throw new StrictSocketInitException(e);
                } catch (Throwable e2) {
                    throw new StrictSocketInitException(e2);
                }
            }
        }
    }

    private <T> T m515a(Class<T> cls, Method method, Object... objArr) {
        try {
            T invoke = method.invoke(this.f400b, objArr);
            this.address = (InetAddress) f384d.get(this.f400b);
            this.port = ((Integer) f385e.get(this.f400b)).intValue();
            this.fd = (FileDescriptor) f386f.get(this.f400b);
            this.localport = ((Integer) f387g.get(this.f400b)).intValue();
            if (invoke == null || cls.isInstance(invoke)) {
                return invoke;
            }
            throw new StrictSocketCastException();
        } catch (Throwable e) {
            throw new IOException("Failed to call inner method", e);
        } catch (Throwable e2) {
            if (e2.getTargetException() instanceof IOException) {
                throw ((IOException) e2.getTargetException());
            }
            throw new StrictSocketCallException(e2);
        }
    }
}
