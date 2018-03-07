package com.google.android.gms.internal;

import java.io.IOException;

public class zztj extends IOException {
    public zztj(String str) {
        super(str);
    }

    static zztj m13037a() {
        return new zztj("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zztj m13038b() {
        return new zztj("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zztj m13039c() {
        return new zztj("CodedInputStream encountered a malformed varint.");
    }
}
