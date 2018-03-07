package com.facebook.crypto.module;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.keychain.UserStorageKeyChain;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.google.common.base.Strings;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: openAssetFile */
public class LoggedInUserCrypto {
    private static final String f10987a = LoggedInUserCrypto.class.getName();
    private final Crypto f10988b;
    private final UserStorageKeyChain f10989c;
    private final AbstractFbErrorReporter f10990d;
    private final LocalStatsLoggerImpl f10991e;

    public LoggedInUserCrypto(Crypto crypto, UserStorageKeyChain userStorageKeyChain, AbstractFbErrorReporter abstractFbErrorReporter, LocalStatsLoggerImpl localStatsLoggerImpl) {
        this.f10988b = crypto;
        this.f10989c = userStorageKeyChain;
        this.f10990d = abstractFbErrorReporter;
        this.f10991e = localStatsLoggerImpl;
    }

    public final synchronized boolean m16309a() {
        return this.f10989c.m16263d();
    }

    public final synchronized OutputStream m16308a(OutputStream outputStream, Entity entity, byte[] bArr) {
        m16304a(10027012);
        return this.f10988b.m16231a(outputStream, entity, bArr);
    }

    public final synchronized InputStream m16307a(InputStream inputStream, Entity entity) {
        m16304a(10027013);
        return this.f10988b.m16229a(inputStream, entity);
    }

    private void m16304a(int i) {
        if (!m16309a()) {
            this.f10991e.m13616a(i);
            this.f10990d.m2340a(f10987a, "UserCrypto not available");
            throw new UserCryptoNotAvailableException();
        }
    }

    public static synchronized void m16305a(LoggedInUserCrypto loggedInUserCrypto, AuthenticationResult authenticationResult) {
        synchronized (loggedInUserCrypto) {
            String a = authenticationResult.a();
            String e = authenticationResult.e();
            if (!Strings.isNullOrEmpty(e)) {
                try {
                    loggedInUserCrypto.f10989c.m16259a(a, e, authenticationResult.f());
                    loggedInUserCrypto.f10991e.m13619a(10027009, (short) 2);
                } catch (Throwable e2) {
                    loggedInUserCrypto.f10990d.m2343a(f10987a, "Cannot enable encryption for user", e2);
                    loggedInUserCrypto.f10991e.m13616a(10027016);
                } catch (Throwable e22) {
                    loggedInUserCrypto.f10990d.m2343a(f10987a, "Cannot enable encryption for user", e22);
                    loggedInUserCrypto.f10991e.m13616a(10027015);
                } catch (Throwable e222) {
                    loggedInUserCrypto.f10990d.m2343a(f10987a, "Unexpected error configuring encryption", e222);
                    loggedInUserCrypto.f10991e.m13619a(10027009, (short) 3);
                }
            }
        }
    }

    public static synchronized void m16306b(LoggedInUserCrypto loggedInUserCrypto) {
        synchronized (loggedInUserCrypto) {
            try {
                loggedInUserCrypto.f10989c.m16262c();
            } catch (Throwable e) {
                loggedInUserCrypto.f10990d.m2343a(f10987a, "Unexpected error disabling encryption", e);
            }
        }
    }
}
