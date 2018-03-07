package org.whispersystems.libsignal;

import java.util.List;

/* compiled from: addAdminsToGroup */
public class InvalidMessageException extends Exception {
    public InvalidMessageException(String str) {
        super(str);
    }

    public InvalidMessageException(Throwable th) {
        super(th);
    }

    public InvalidMessageException(String str, List<Exception> list) {
        super(str, (Throwable) list.get(0));
    }
}
