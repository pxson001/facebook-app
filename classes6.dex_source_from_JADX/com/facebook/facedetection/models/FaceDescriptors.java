package com.facebook.facedetection.models;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: null northeast */
public final class FaceDescriptors extends Table {
    public static FaceDescriptors m15582a(ByteBuffer byteBuffer) {
        FaceDescriptors faceDescriptors = new FaceDescriptors();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        faceDescriptors.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        faceDescriptors.b = byteBuffer;
        return faceDescriptors;
    }

    public final FaceDescriptor m15584a(FaceDescriptor faceDescriptor, int i) {
        int a = a(4);
        if (a == 0) {
            return null;
        }
        a = b(e(a) + (i * 4));
        ByteBuffer byteBuffer = this.b;
        faceDescriptor.a = a;
        faceDescriptor.b = byteBuffer;
        return faceDescriptor;
    }

    public final int m15583a() {
        int a = a(4);
        return a != 0 ? d(a) : 0;
    }
}
