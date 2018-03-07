package org.whispersystems.curve25519;

/* compiled from: admin_text_thread_ride_provider_name */
public class NoSuchProviderException extends RuntimeException {
    private final Throwable nested;

    public NoSuchProviderException(Throwable th) {
        this.nested = th;
    }

    public NoSuchProviderException(String str) {
        super(str);
        this.nested = null;
    }
}
