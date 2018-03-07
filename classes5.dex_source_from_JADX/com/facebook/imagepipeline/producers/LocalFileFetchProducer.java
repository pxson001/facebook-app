package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_MOUNTAIN */
public class LocalFileFetchProducer extends LocalFetchProducer {
    public LocalFileFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, boolean z) {
        super(executor, nativePooledByteBufferFactory, z);
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        return m23106b(new FileInputStream(imageRequest.m().toString()), (int) imageRequest.m().length());
    }

    protected final String mo1276a() {
        return "LocalFileFetchProducer";
    }
}
