package com.facebook.oxygen.installer.verification;

import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.common.collect.Multimap;

/* compiled from: log_data */
public class PermissionDeclarationVerifier {
    private final String f9019a;
    private final Multimap<Signature, String> f9020b;
    private final PackageManager f9021c;

    public PermissionDeclarationVerifier(String str, Multimap<Signature, String> multimap, PackageManager packageManager) {
        this.f9019a = str;
        this.f9020b = multimap;
        this.f9021c = packageManager;
    }

    public final void m9369a() {
        try {
            PackageItemInfo permissionInfo = this.f9021c.getPermissionInfo(this.f9019a, 0);
            if ((permissionInfo.protectionLevel & 15) != 2) {
                throw new SecurityException(String.format(null, "Access denied: permission '%s' is not of signature protection level.", new Object[]{this.f9019a}));
            }
            try {
                PackageInfo packageInfo = this.f9021c.getPackageInfo(permissionInfo.packageName, 64);
                if (packageInfo.signatures == null || packageInfo.signatures.length == 0) {
                    throw new SecurityException(String.format(null, "Access denied: permission '%s' owner package '%s' has no signatures.", new Object[]{this.f9019a, permissionInfo.packageName}));
                } else if (packageInfo.signatures.length > 1) {
                    throw new SecurityException(String.format(null, "Access denied: permission '%s' owner package '%s' has multiple signatures.", new Object[]{this.f9019a, permissionInfo.packageName}));
                } else {
                    Object obj = packageInfo.signatures[0];
                    if (!this.f9020b.b(obj, permissionInfo.packageName) && !this.f9020b.b(obj, "*|all_packages|*")) {
                        throw new SecurityException(String.format(null, "Access denied: permission '%s' is declared by an untrusted package '%s'.", new Object[]{this.f9019a, permissionInfo.packageName}));
                    }
                }
            } catch (NameNotFoundException e) {
                throw new SecurityException(String.format(null, "Access denied: permission '%s' is declared in '%s' package which is missing.", new Object[]{this.f9019a, permissionInfo.packageName}));
            }
        } catch (NameNotFoundException e2) {
            throw new SecurityException(String.format(null, "Access denied: '%s' permission is missing.", new Object[]{this.f9019a}));
        }
    }
}
