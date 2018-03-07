package org.whispersystems.libsignal;

/* compiled from: ad_conversion_pixel_id */
public class UntrustedIdentityException extends Exception {
    private final IdentityKey key;
    private final String name;

    public UntrustedIdentityException(String str, IdentityKey identityKey) {
        this.name = str;
        this.key = identityKey;
    }
}
