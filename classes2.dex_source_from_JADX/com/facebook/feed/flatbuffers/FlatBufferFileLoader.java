package com.facebook.feed.flatbuffers;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;

/* compiled from: session_write_count */
public class FlatBufferFileLoader {
    FileInputStream f5389a = null;
    String f5390b = null;

    public final ByteBuffer m9279a(String str, int i, int i2) {
        if (this.f5389a == null || !str.equalsIgnoreCase(this.f5390b)) {
            if (this.f5389a != null) {
                try {
                    this.f5389a.close();
                    this.f5389a = null;
                } catch (IOException e) {
                }
            }
            this.f5389a = new FileInputStream(str);
        }
        this.f5390b = str;
        if (this.f5389a != null) {
            return this.f5389a.getChannel().map(MapMode.READ_ONLY, (long) i, (long) i2);
        }
        throw new IOException("Couldn't build stream for " + str);
    }

    public final void m9280a() {
        try {
            if (this.f5389a != null) {
                this.f5389a.close();
                this.f5389a = null;
            }
        } catch (IOException e) {
        }
    }

    protected void finalize() {
        m9280a();
    }
}
