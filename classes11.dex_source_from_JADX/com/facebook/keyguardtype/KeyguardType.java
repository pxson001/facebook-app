package com.facebook.keyguardtype;

/* compiled from: Unrecognized drawing instruction  */
public enum KeyguardType {
    ALPHABETIC,
    ALPHANUMERIC,
    AOSP_NONE,
    BIOMETRIC_WITH_UNKNOWN_BACKUP,
    BIOMETRIC_WITH_PATTERN_BACKUP,
    COMPLEX,
    DETECTION_FAILED,
    NUMERIC,
    PATTERN,
    UNSPECIFIED_PROBABLY_OEM_INSECURE,
    UNKNOWN_SECURE,
    UNKNOWN_INSECURE;

    public final boolean isInsecure() {
        switch (this) {
            case AOSP_NONE:
            case DETECTION_FAILED:
            case UNSPECIFIED_PROBABLY_OEM_INSECURE:
            case UNKNOWN_INSECURE:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSecure() {
        return !isInsecure();
    }
}
