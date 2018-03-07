package com.facebook.common.iolite;

import java.io.OutputStream;

/* compiled from: pack_id */
public class Streams {
    public static OutputStream m5987a(OutputStream outputStream) {
        return new NonClosingOutputStream(outputStream);
    }
}
