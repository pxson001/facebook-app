package com.facebook.ssl.openssl;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.reflect.Method;
import java.net.Socket;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImplWrapper;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

@DoNotStrip
/* compiled from: configs */
public class TicketEnabledOpenSSLSocketImplWrapper extends OpenSSLSocketImplWrapper {
    private static Method f5309c;
    private static boolean f5310d;
    private static Method f5311e;
    private static boolean f5312f;
    private Socket f5313a;
    private final AbstractFbErrorReporter f5314b;

    static {
        f5310d = false;
        f5312f = false;
        try {
            Method declaredMethod = Socket.class.getDeclaredMethod("setSoSndTimeout", new Class[]{Integer.TYPE});
            f5309c = declaredMethod;
            declaredMethod.setAccessible(true);
            f5310d = true;
            declaredMethod = Socket.class.getDeclaredMethod("getSoSNDTimeout", new Class[0]);
            f5311e = declaredMethod;
            declaredMethod.setAccessible(true);
            f5312f = true;
        } catch (Throwable th) {
        }
    }

    protected TicketEnabledOpenSSLSocketImplWrapper(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(socket, str, i, z, sSLParametersImpl);
        this.f5313a = socket;
        this.f5314b = abstractFbErrorReporter;
    }

    public boolean isConnected() {
        return true;
    }

    public void setSoTimeout(int i) {
        this.f5313a.setSoTimeout(i);
    }

    @DoNotStrip
    public void setSoSndTimeout(int i) {
        Throwable th = null;
        if (f5310d) {
            try {
                f5309c.invoke(this.f5313a, new Object[]{Integer.valueOf(i)});
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (th != null) {
            this.f5314b.a("error_calling_setSoSndTimeout", th);
        }
        if (th != null || !f5310d) {
            this.f5313a.setSoTimeout(i);
        }
    }

    @DoNotStrip
    public int getSoSNDTimeout() {
        if (f5312f) {
            try {
                return ((Integer) f5311e.invoke(this.f5313a, new Object[0])).intValue();
            } catch (Throwable th) {
                this.f5314b.a("error_calling_getSoSNDTimeout", th);
            }
        }
        return this.f5313a.getSoTimeout();
    }
}
