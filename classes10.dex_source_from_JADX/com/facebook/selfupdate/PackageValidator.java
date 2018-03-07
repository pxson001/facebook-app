package com.facebook.selfupdate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.Signature;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.inject.Inject;

@TargetApi(9)
/* compiled from: has_seen_save_modal */
public class PackageValidator {
    public static final Set<String> f9966a = ImmutableSet.of("META-INF/MANIFEST.MF", "AndroidManifest.xml", "classes.dex");
    public static final Set<String> f9967b = ImmutableSet.of("META-INF/MANIFEST.MF", "metadata.txt");
    private final Context f9968c;
    private final SignatureUtils f9969d;
    private final SelfUpdateLogger f9970e;

    public static PackageValidator m10074b(InjectorLike injectorLike) {
        return new PackageValidator((Context) injectorLike.getInstance(Context.class), new SignatureUtils(), SelfUpdateLogger.b(injectorLike));
    }

    @Inject
    public PackageValidator(Context context, SignatureUtils signatureUtils, SelfUpdateLogger selfUpdateLogger) {
        this.f9968c = context;
        this.f9969d = signatureUtils;
        this.f9970e = selfUpdateLogger;
    }

    public final boolean m10075a(JarFile jarFile, String str) {
        if (jarFile == null) {
            return false;
        }
        boolean z;
        if (str.equals("application/java-archive")) {
            Set b = Sets.b(f9967b);
        } else {
            Object b2 = Sets.b(f9966a);
        }
        Enumeration entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) entries.nextElement();
            if (!jarEntry.isDirectory()) {
                String name = jarEntry.getName();
                if (b.contains(name)) {
                    b.remove(name);
                }
                if (b.size() == 0) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = z;
        if (!z2) {
            return z2;
        }
        Signature[] a = m10072a(this.f9968c);
        if (a == null || a.length <= 0 || SignatureUtils.m10108a(a[0]).contains("CN=Android Debug")) {
            return z2;
        }
        Signature[] a2 = m10073a(jarFile);
        z = false;
        if (a == null) {
            if (a2 == null) {
                z = true;
            }
        } else if (a2 != null) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(a));
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(Arrays.asList(a2));
            z = hashSet.equals(hashSet2);
        }
        return z;
    }

    private Signature[] m10072a(Context context) {
        Signature[] signatureArr = null;
        if (context != null) {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            } catch (Throwable e) {
                this.f9970e.a("PackageManager.NameNotFoundException", e);
            }
        }
        return signatureArr;
    }

    private Signature[] m10073a(JarFile jarFile) {
        try {
            Enumeration entries = jarFile.entries();
            Certificate[] certificateArr = null;
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                if (!(jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))) {
                    Certificate[] a = SignatureUtils.m10110a(jarFile, jarEntry);
                    if (a == null) {
                        this.f9970e.a(jarFile.getName() + " has no certificates");
                        return null;
                    } else if (certificateArr == null) {
                        certificateArr = a;
                    } else {
                        for (Certificate certificate : certificateArr) {
                            Object obj;
                            for (Object obj2 : a) {
                                if (certificate != null && certificate.equals(obj2)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null || certificateArr.length != a.length) {
                                this.f9970e.a("Package " + jarFile.getName() + " has mismatched certificates at entry " + jarEntry.getName());
                                return null;
                            }
                        }
                        continue;
                    }
                }
            }
            return SignatureUtils.m10109a(certificateArr);
        } catch (Throwable e) {
            this.f9970e.a("RuntimeException reading " + jarFile.getName(), e);
            return null;
        }
    }
}
