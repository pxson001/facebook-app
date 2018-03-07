package com.google.common.hash;

import java.io.Serializable;

/* compiled from: bug_report_did_dismiss_creation_dialog */
final class MessageDigestHashFunction$SerializedForm implements Serializable {
    private final String algorithmName;
    private final int bytes;
    private final String toString;

    public MessageDigestHashFunction$SerializedForm(String str, int i, String str2) {
        this.algorithmName = str;
        this.bytes = i;
        this.toString = str2;
    }

    private Object readResolve() {
        return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
    }
}
