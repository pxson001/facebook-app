package com.facebook.http.entity.mime;

import java.io.OutputStream;
import org.apache.http.entity.StringEntity;

/* compiled from: disclaimer_title */
public class StringEntityWithProgressListener extends StringEntity {
    private ContentSerializationListener f5023a = null;

    public StringEntityWithProgressListener(String str) {
        super(str);
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        if (this.f5023a == null) {
            outputStream.write(this.content);
        } else {
            OutputStream outputStreamWithProgressListener = new OutputStreamWithProgressListener(outputStream, this.f5023a);
            int length = this.content.length;
            for (int i = 0; i < length; i += 4096) {
                outputStreamWithProgressListener.write(this.content, i, Math.min(length - i, 4096));
            }
            outputStream = outputStreamWithProgressListener;
        }
        outputStream.flush();
    }

    public final void m9954a(ContentSerializationListener contentSerializationListener) {
        this.f5023a = contentSerializationListener;
    }
}
