package com.facebook.oxygen.preloads.integration.dogfooding;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.oxygen.installer.verification.PermissionDeclarationVerifier;
import com.facebook.oxygen.installer.verification.TrustedCallerVerifier;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkConstants;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import javax.inject.Inject;

/* compiled from: logcat-manager */
public class AppManagerSsoCallerVerifier {
    public final TrustedCallerVerifier f9000a;
    public final PermissionDeclarationVerifier f9001b;

    public static AppManagerSsoCallerVerifier m9323b(InjectorLike injectorLike) {
        return new AppManagerSsoCallerVerifier((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppManagerSsoCallerVerifier(Context context, PackageManager packageManager) {
        HashMultimap u = HashMultimap.u();
        u.a(PreloadSdkConstants.l, PreloadSdkConstants.a);
        u.a(PreloadSdkConstants.h, PreloadSdkConstants.a);
        Multimap multimap = u;
        this.f9000a = new TrustedCallerVerifier(multimap, context, packageManager);
        this.f9001b = new PermissionDeclarationVerifier(PreloadSdkConstants.b, multimap, packageManager);
    }

    public final void m9324b() {
        this.f9001b.m9369a();
    }
}
