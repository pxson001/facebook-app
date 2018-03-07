package com.facebook.oxygen.installer.verification;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Process;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/* compiled from: logcat */
public class TrustedCallerVerifier {
    private final ImmutableSet<Signature> f9002a;
    private final ImmutableSetMultimap<Signature, String> f9003b;
    private final Context f9004c;
    private final PackageManager f9005d;

    public TrustedCallerVerifier(Multimap<Signature, String> multimap, Context context, PackageManager packageManager) {
        Builder builder = ImmutableSet.builder();
        ImmutableSetMultimap.Builder y = ImmutableSetMultimap.m9337y();
        for (Signature signature : multimap.p()) {
            if (multimap.b(signature, "*|all_packages|*")) {
                builder.c(signature);
            } else {
                y.m9348a(signature, multimap.c(signature));
            }
        }
        this.f9002a = builder.b();
        this.f9003b = y.m9349a();
        this.f9004c = context;
        this.f9005d = packageManager;
    }

    private TrustedCallerInfo m9327b() {
        int callingUid = Binder.getCallingUid();
        Signature b = m9326b(callingUid);
        ImmutableSet a = m9325a(callingUid);
        if (callingUid == Process.myUid()) {
            return TrustedCallerInfo.a(b, ImmutableSet.of(this.f9004c.getPackageName()));
        }
        if (this.f9002a.contains(b)) {
            return TrustedCallerInfo.a(b, a);
        }
        SetView b2 = Sets.b(a, this.f9003b.m9343e(b));
        if (b2.isEmpty()) {
            return new TrustedCallerInfo(false, b, a);
        }
        return TrustedCallerInfo.a(b, b2);
    }

    public final TrustedCallerInfo m9328a() {
        TrustedCallerInfo b = m9327b();
        if (b.a) {
            return b;
        }
        throw new SecurityException("Access denied.");
    }

    @VisibleForTesting
    private ImmutableSet<String> m9325a(int i) {
        String[] packagesForUid = this.f9005d.getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            return ImmutableSet.copyOf(packagesForUid);
        }
        throw new SecurityException("No packages associated with uid: " + i);
    }

    @VisibleForTesting
    private Signature m9326b(int i) {
        Signature signature = null;
        for (String str : m9325a(i)) {
            try {
                PackageInfo packageInfo = this.f9005d.getPackageInfo(str, 64);
                if (!str.equals(packageInfo.packageName)) {
                    throw new SecurityException("Package name mismatch: expected=" + str + ", was=" + packageInfo.packageName);
                } else if (packageInfo.signatures == null || packageInfo.signatures.length == 0) {
                    throw new SecurityException("Signatures are missing: " + str);
                } else if (packageInfo.signatures.length > 1) {
                    throw new SecurityException("Multiple signatures not supported: " + str);
                } else {
                    Signature signature2 = packageInfo.signatures[0];
                    if (signature == null) {
                        signature = signature2;
                    } else if (!signature.equals(signature2)) {
                        throw new SecurityException("Uid " + i + " has inconsistent signatures across packages.");
                    }
                }
            } catch (NameNotFoundException e) {
                throw new SecurityException("Name not found: " + str);
            }
        }
        if (signature != null) {
            return signature;
        }
        throw new SecurityException("No uid signature.");
    }
}
