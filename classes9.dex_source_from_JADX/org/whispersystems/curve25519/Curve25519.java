package org.whispersystems.curve25519;

/* compiled from: ads_payments_holdout_2016_h1 */
public class Curve25519 {
    public final Curve25519Provider f21210a;

    public static Curve25519 m21651a(String str) {
        return m21652a(str, null);
    }

    private static Curve25519 m21652a(String str, JCESecureRandomProvider jCESecureRandomProvider) {
        if ("native".equals(str)) {
            return new Curve25519(m21653b("NativeCurve25519Provider", jCESecureRandomProvider));
        }
        if ("java".equals(str)) {
            return new Curve25519(m21653b("JavaCurve25519Provider", jCESecureRandomProvider));
        }
        if ("j2me".equals(str)) {
            return new Curve25519(m21653b("J2meCurve25519Provider", jCESecureRandomProvider));
        }
        if ("best".equals(str)) {
            return new Curve25519(m21653b("OpportunisticCurve25519Provider", jCESecureRandomProvider));
        }
        throw new NoSuchProviderException(str);
    }

    private Curve25519(Curve25519Provider curve25519Provider) {
        this.f21210a = curve25519Provider;
    }

    public static Curve25519Provider m21653b(String str, JCESecureRandomProvider jCESecureRandomProvider) {
        try {
            Curve25519Provider curve25519Provider = (Curve25519Provider) Class.forName("org.whispersystems.curve25519." + str).newInstance();
            if (jCESecureRandomProvider != null) {
                curve25519Provider.mo929a(jCESecureRandomProvider);
            }
            return curve25519Provider;
        } catch (Throwable e) {
            throw new NoSuchProviderException(e);
        } catch (Throwable e2) {
            throw new NoSuchProviderException(e2);
        } catch (Throwable e22) {
            throw new NoSuchProviderException(e22);
        }
    }
}
