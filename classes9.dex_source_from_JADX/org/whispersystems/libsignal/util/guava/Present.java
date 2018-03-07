package org.whispersystems.libsignal.util.guava;

/* compiled from: acd86800338bd14e0430d36fb2ee7270 */
final class Present<T> extends Optional<T> {
    private final T reference;

    Present(T t) {
        this.reference = t;
    }

    public final boolean mo939a() {
        return true;
    }

    public final T mo940b() {
        return this.reference;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Present)) {
            return false;
        }
        return this.reference.equals(((Present) obj).reference);
    }

    public final int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    public final String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
