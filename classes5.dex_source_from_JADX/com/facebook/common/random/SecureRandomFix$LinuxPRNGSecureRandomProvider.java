package com.facebook.common.random;

import java.security.Provider;

/* compiled from: show_ad_preferences */
class SecureRandomFix$LinuxPRNGSecureRandomProvider extends Provider {
    public SecureRandomFix$LinuxPRNGSecureRandomProvider() {
        super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
        put("SecureRandom.SHA1PRNG", SecureRandomFix$LinuxPRNGSecureRandom.class.getName());
        put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
}
