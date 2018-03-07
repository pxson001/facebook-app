package com.facebook.http.strictsocket;

import android.annotation.SuppressLint;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.net.Socket;
import java.net.SocketImplFactory;

/* compiled from: view_styles */
public class StrictSocketManager {
    private static final Class<StrictSocketManager> f405a = StrictSocketManager.class;
    private StrictSocketImplFactory f406b;
    private Mode f407c;

    /* compiled from: view_styles */
    public enum Mode {
        DISABLED,
        LOG,
        ENFORCE,
        LOG_TOR,
        ENFORCE_TOR
    }

    /* compiled from: view_styles */
    public class StrictSocketException extends RuntimeException {
        private final String mHost;
        private final int mPort;

        public StrictSocketException(String str, int i) {
            super(StringFormatUtil.formatStrLocaleSafe("Strict socket created for %s:%d", str, Integer.valueOf(i)));
            this.mHost = str;
            this.mPort = i;
        }

        public String toString() {
            return StringFormatUtil.formatStrLocaleSafe("StrictSocketException[%s:%d]", this.mHost, Integer.valueOf(this.mPort));
        }
    }

    public static StrictSocketManager m517a(InjectorLike injectorLike) {
        return new StrictSocketManager();
    }

    private void m518a() {
        SocketImplFactory strictSocketImplFactory = new StrictSocketImplFactory(this);
        this.f406b = strictSocketImplFactory;
        Socket.setSocketImplFactory(strictSocketImplFactory);
    }

    public final synchronized void m522a(Mode mode) {
        this.f407c = mode;
        switch (mode) {
            case LOG:
            case ENFORCE:
            case LOG_TOR:
            case ENFORCE_TOR:
                try {
                    m518a();
                    break;
                } catch (Throwable e) {
                    BLog.b(f405a, "Couldn't enable strict socket mode", e);
                    break;
                }
        }
    }

    final void m523a(String str, int i) {
        switch (this.f407c) {
            case LOG:
                m520b(str, i);
                return;
            case ENFORCE:
                m521c(str, i);
                return;
            case LOG_TOR:
                if (!m519a(str)) {
                    m520b(str, i);
                    return;
                }
                return;
            case ENFORCE_TOR:
                if (!m519a(str)) {
                    m521c(str, i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void m520b(String str, int i) {
        BLog.a(f405a, new StrictSocketException(str, i), "Socket connection made to %s:%d", new Object[]{str, Integer.valueOf(i)});
    }

    private static void m521c(String str, int i) {
        throw new StrictSocketException(str, i);
    }

    @SuppressLint({"HardcodedIPAddressUse"})
    private static boolean m519a(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1204607085:
                if (str.equals("localhost")) {
                    z = false;
                    break;
                }
                break;
            case 1505998205:
                if (str.equals("127.0.0.1")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                return true;
            default:
                return false;
        }
    }
}
