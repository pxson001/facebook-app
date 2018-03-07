package com.google.protobuf;

import java.util.List;

/* compiled from: all_themes */
public class UninitializedMessageException extends RuntimeException {
    private final List<String> missingFields;

    public UninitializedMessageException() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder("Message missing required fields: ");
        Object obj = 1;
        for (String str : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(str);
        }
        super(stringBuilder.toString());
        this.missingFields = list;
    }
}
