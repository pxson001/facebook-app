package com.facebook.flatbuffers.flatteners;

import android.net.Uri;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattener;
import java.nio.ByteBuffer;

/* compiled from: render_create_entry_button */
public class UriFlattener implements Flattener<Uri> {
    public static final UriFlattener f3161a = new UriFlattener();

    public final int mo608a(Object obj, FlatBufferBuilder flatBufferBuilder) {
        int b = flatBufferBuilder.b(((Uri) obj).toString());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        return flatBufferBuilder.d();
    }

    public final Object mo609a(ByteBuffer byteBuffer, int i) {
        return Uri.parse(FlatBuffer.b(byteBuffer, i, 0));
    }
}
