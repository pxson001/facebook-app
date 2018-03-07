package com.facebook.ssl.openssl.heartbleed;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import javax.inject.Inject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;

@DoNotStrip
/* compiled from: confidence */
public class HeartbleedMitigation {
    private static TriState f5331b = TriState.UNSET;
    private final AbstractFbErrorReporter f5332a;

    @DoNotStrip
    private native boolean isHeartbeatActivated();

    @DoNotStrip
    private native boolean nativeApply(int i);

    @VisibleForTesting
    native boolean wasCallbackInvoked();

    public static HeartbleedMitigation m10228b(InjectorLike injectorLike) {
        return new HeartbleedMitigation((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public HeartbleedMitigation(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5332a = abstractFbErrorReporter;
    }

    public final synchronized void m10231a(SSLContext sSLContext) {
        if (m10232a()) {
            m10229b(sSLContext);
        }
    }

    public static HeartbleedMitigation m10227a(InjectorLike injectorLike) {
        return m10228b(injectorLike);
    }

    @VisibleForTesting
    private synchronized void m10229b(SSLContext sSLContext) {
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        try {
            if (m10230b()) {
                int intValue;
                Field declaredField = clientSessionContext.getClass().getSuperclass().getDeclaredField("sslCtxNativePointer");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(clientSessionContext);
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    intValue = ((Long) obj).intValue();
                }
                if (!(intValue == 0 || nativeApply(intValue))) {
                    this.f5332a.a("heartbleed", "could not init");
                }
            }
        } catch (Throwable th) {
        }
    }

    public final boolean m10232a() {
        if (m10230b()) {
            return isHeartbeatActivated();
        }
        return false;
    }

    private synchronized boolean m10230b() {
        boolean asBoolean;
        try {
            if (f5331b != TriState.UNSET) {
                asBoolean = f5331b.asBoolean();
            } else {
                SoLoader.a("heartbleed");
                f5331b = TriState.YES;
                asBoolean = true;
            }
        } catch (Throwable th) {
            f5331b = TriState.NO;
            asBoolean = false;
        }
        return asBoolean;
    }
}
