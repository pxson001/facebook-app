package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;

/* compiled from: TOPIC_RIVER */
public class DataFetchProducer extends LocalFetchProducer {
    public DataFetchProducer(NativePooledByteBufferFactory nativePooledByteBufferFactory, boolean z) {
        super(CallerThreadExecutor.a, nativePooledByteBufferFactory, z);
    }

    protected final String mo1276a() {
        return "DataFetchProducer";
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        boolean equals;
        byte[] decode;
        String uri = imageRequest.c.toString();
        Preconditions.a(uri.substring(0, 5).equals("data:"));
        int indexOf = uri.indexOf(44);
        String substring = uri.substring(indexOf + 1, uri.length());
        String substring2 = uri.substring(0, indexOf);
        if (substring2.contains(";")) {
            String[] split = substring2.split(";");
            equals = split[split.length - 1].equals("base64");
        } else {
            equals = false;
        }
        if (equals) {
            decode = Base64.decode(substring, 0);
        } else {
            decode = Uri.decode(substring).getBytes();
        }
        byte[] bArr = decode;
        return m23103a(new ByteArrayInputStream(bArr), bArr.length);
    }
}
