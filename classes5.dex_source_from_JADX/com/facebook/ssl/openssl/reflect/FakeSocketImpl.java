package com.facebook.ssl.openssl.reflect;

import com.facebook.ssl.openssl.UnsupportedOpenSSLVersionException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

/* compiled from: concise_text */
public class FakeSocketImpl extends SocketImpl {
    private static Constructor<Inet4Address> f5333c;
    public static boolean f5334d;
    private InetAddress f5335a;
    private int f5336b;

    static {
        f5334d = false;
        try {
            Constructor declaredConstructor = Inet4Address.class.getDeclaredConstructor(new Class[]{byte[].class, String.class});
            f5333c = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f5334d = true;
        } catch (Throwable th) {
        }
    }

    public FakeSocketImpl(byte[] bArr, String str, int i) {
        try {
            this.f5335a = (InetAddress) f5333c.newInstance(new Object[]{bArr, str});
            this.f5336b = i;
        } catch (Exception e) {
            throw new UnsupportedOpenSSLVersionException(e);
        } catch (Exception e2) {
            throw new UnsupportedOpenSSLVersionException(e2);
        } catch (Exception e22) {
            throw new UnsupportedOpenSSLVersionException(e22);
        }
    }

    public InetAddress getInetAddress() {
        return this.f5335a;
    }

    public int getPort() {
        return this.f5336b;
    }

    protected void accept(SocketImpl socketImpl) {
        throw new IllegalStateException("calling accept() on FakeSocketImpl");
    }

    protected int available() {
        throw new IllegalStateException("calling available() on FakeSocketImpl");
    }

    protected void bind(InetAddress inetAddress, int i) {
        throw new IllegalStateException("calling bind(InetAddress, int) on FakeSocketImpl");
    }

    protected void close() {
        throw new IllegalStateException("calling close() on FakeSocketImpl");
    }

    protected void connect(String str, int i) {
        throw new IllegalStateException("calling connect(String, int) on FakeSocketImpl");
    }

    protected void connect(InetAddress inetAddress, int i) {
        throw new IllegalStateException("calling connect(InetAddress, int) on FakeSocketImpl");
    }

    protected void create(boolean z) {
        throw new IllegalStateException("calling create() on FakeSocketImpl");
    }

    protected InputStream getInputStream() {
        throw new IllegalStateException("calling getInputStream() on FakeSocketImpl");
    }

    protected OutputStream getOutputStream() {
        throw new IllegalStateException("calling getOutputStream() on FakeSocketImpl");
    }

    protected void listen(int i) {
        throw new IllegalStateException("calling listen(int) on FakeSocketImpl");
    }

    protected void connect(SocketAddress socketAddress, int i) {
        throw new IllegalStateException("calling connect(SocketAddress, int) on FakeSocketImpl");
    }

    protected void sendUrgentData(int i) {
        throw new IllegalStateException("calling sendUrgentData(int) on FakeSocketImpl");
    }

    public Object getOption(int i) {
        throw new IllegalStateException("calling getOption(int) on FakeSocketImpl");
    }

    public void setOption(int i, Object obj) {
        throw new IllegalStateException("calling setOption(int, Object) on FakeSocketImpl");
    }
}
