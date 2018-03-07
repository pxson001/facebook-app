package com.facebook.oxygen.installer.verification;

import android.content.pm.Signature;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: Tried to render plus button for collection %s with no default privacy */
public class TrustedCallerVerifier$TrustedCallerInfo {
    public final boolean f10546a;
    public final Signature f10547b;
    public final ImmutableSet<String> f10548c;

    public TrustedCallerVerifier$TrustedCallerInfo(boolean z, Signature signature, Set<String> set) {
        this.f10546a = z;
        this.f10547b = signature;
        this.f10548c = ImmutableSet.copyOf(set);
    }

    public static TrustedCallerVerifier$TrustedCallerInfo m11043a(Signature signature, Set<String> set) {
        return new TrustedCallerVerifier$TrustedCallerInfo(true, signature, set);
    }
}
