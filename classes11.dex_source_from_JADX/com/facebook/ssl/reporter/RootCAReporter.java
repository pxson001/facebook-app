package com.facebook.ssl.reporter;

import android.util.Base64;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.debug.log.BLog;
import com.facebook.ssl.trustmanager.FbTrustManagerFactory;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: Null notif story in adapter */
public class RootCAReporter implements ConditionalWorker {
    private static final Class f12856a = RootCAReporter.class;
    private final AnalyticsLogger f12857b;
    private final XConfigReader f12858c;
    private final FbTrustManagerFactory f12859d;

    @Inject
    public RootCAReporter(AnalyticsLogger analyticsLogger, XConfigReader xConfigReader, FbTrustManagerFactory fbTrustManagerFactory) {
        this.f12857b = analyticsLogger;
        this.f12858c = xConfigReader;
        this.f12859d = fbTrustManagerFactory;
    }

    public final boolean m13532a(ConditionalWorkerRunner conditionalWorkerRunner) {
        boolean a = this.f12858c.a(RootCAReporterXConfig.f, true);
        boolean a2 = this.f12858c.a(RootCAReporterXConfig.g, true);
        if (!a && !a2) {
            return true;
        }
        double a3;
        double a4;
        if (a) {
            a3 = 1.0d / ((double) this.f12858c.a(RootCAReporterXConfig.d, 100000));
        } else {
            a3 = 0.0d;
        }
        if (a2) {
            a4 = 1.0d / ((double) this.f12858c.a(RootCAReporterXConfig.e, 1000));
        } else {
            a4 = 0.0d;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            Object a5 = this.f12859d.a();
            if (a5 == null) {
                BLog.a(f12856a, "Could not get root certificates");
                return false;
            }
            byte[] encoded;
            Preconditions.checkNotNull(a5);
            for (X509Certificate x509Certificate : a5) {
                if (Math.random() < a3) {
                    try {
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("rootca_sample");
                        honeyClientEvent.g("rootca_event");
                        honeyClientEvent.a("weight", (long) (1.0d / a3));
                        encoded = x509Certificate.getEncoded();
                        honeyClientEvent.b("hash", Base64.encodeToString(instance.digest(encoded), 0));
                        honeyClientEvent.b("cert", Base64.encodeToString(encoded, 0));
                        this.f12857b.c(honeyClientEvent);
                    } catch (Throwable e) {
                        BLog.b(f12856a, "Failed to encode certificate", e);
                    }
                }
            }
            if ((Math.random() < a4 ? 1 : null) != null) {
                Set a6 = Sets.a();
                Object b = this.f12859d.b();
                if (b == null) {
                    BLog.a(f12856a, "Could not get user certificates");
                    return false;
                }
                Preconditions.checkNotNull(b);
                for (byte[] digest : b) {
                    a6.add(ByteBuffer.wrap(instance.digest(digest)));
                }
                ArrayNode b2 = JsonNodeFactory.a.b();
                for (X509Certificate x509Certificate2 : a5) {
                    ObjectNode c = JsonNodeFactory.a.c();
                    try {
                        encoded = x509Certificate2.getEncoded();
                        if (instance != null) {
                            encoded = instance.digest(encoded);
                            c.a("hash", Base64.encodeToString(encoded, 0));
                            c.a("userCert", a6.contains(ByteBuffer.wrap(encoded)));
                        }
                    } catch (Throwable e2) {
                        BLog.b(f12856a, "Failed to encode certificate", e2);
                    }
                    b2.a(c);
                }
                HoneyClientEventFast a7 = this.f12857b.a("rootca_reporter", true);
                if (a7.a()) {
                    a7.a("rootca_event");
                    a7.a("weight", (long) (1.0d / a3));
                    a7.a("list", b2.toString());
                    a7.b();
                }
            }
            return true;
        } catch (Throwable e22) {
            BLog.a(f12856a, "Device can't hash with SHA1", e22);
            return false;
        }
    }
}
