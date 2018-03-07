package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;

/* compiled from: page/%s/events_list */
public class EmptyJpegGenerator {
    private static final byte[] f10592a = new byte[]{(byte) -1, (byte) -40, (byte) -1, (byte) -37, (byte) 0, (byte) 67, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -64, (byte) 0, (byte) 17, (byte) 8};
    private static final byte[] f10593b = new byte[]{(byte) 3, (byte) 1, (byte) 34, (byte) 0, (byte) 2, (byte) 17, (byte) 0, (byte) 3, (byte) 17, (byte) 0, (byte) -1, (byte) -60, (byte) 0, (byte) 31, (byte) 0, (byte) 0, (byte) 1, (byte) 5, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) -1, (byte) -60, (byte) 0, (byte) -75, (byte) 16, (byte) 0, (byte) 2, (byte) 1, (byte) 3, (byte) 3, (byte) 2, (byte) 4, (byte) 3, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 0, (byte) 0, (byte) 1, (byte) 125, (byte) 1, (byte) 2, (byte) 3, (byte) 0, (byte) 4, (byte) 17, (byte) 5, (byte) 18, (byte) 33, (byte) 49, (byte) 65, (byte) 6, (byte) 19, (byte) 81, (byte) 97, (byte) 7, (byte) 34, (byte) 113, (byte) 20, (byte) 50, (byte) -127, (byte) -111, (byte) -95, (byte) 8, (byte) 35, (byte) 66, (byte) -79, (byte) -63, (byte) 21, (byte) 82, (byte) -47, (byte) -16, (byte) 36, (byte) 51, (byte) 98, (byte) 114, (byte) -126, (byte) 9, (byte) 10, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) -125, (byte) -124, (byte) -123, (byte) -122, (byte) -121, (byte) -120, (byte) -119, (byte) -118, (byte) -110, (byte) -109, (byte) -108, (byte) -107, (byte) -106, (byte) -105, (byte) -104, (byte) -103, (byte) -102, (byte) -94, (byte) -93, (byte) -92, (byte) -91, (byte) -90, (byte) -89, (byte) -88, (byte) -87, (byte) -86, (byte) -78, (byte) -77, (byte) -76, (byte) -75, (byte) -74, (byte) -73, (byte) -72, (byte) -71, (byte) -70, (byte) -62, (byte) -61, (byte) -60, (byte) -59, (byte) -58, (byte) -57, (byte) -56, (byte) -55, (byte) -54, (byte) -46, (byte) -45, (byte) -44, (byte) -43, (byte) -42, (byte) -41, (byte) -40, (byte) -39, (byte) -38, (byte) -31, (byte) -30, (byte) -29, (byte) -28, (byte) -27, (byte) -26, (byte) -25, (byte) -24, (byte) -23, (byte) -22, (byte) -15, (byte) -14, (byte) -13, (byte) -12, (byte) -11, (byte) -10, (byte) -9, (byte) -8, (byte) -7, (byte) -6, (byte) -1, (byte) -60, (byte) 0, (byte) 31, (byte) 1, (byte) 0, (byte) 3, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) -1, (byte) -60, (byte) 0, (byte) -75, (byte) 17, (byte) 0, (byte) 2, (byte) 1, (byte) 2, (byte) 4, (byte) 4, (byte) 3, (byte) 4, (byte) 7, (byte) 5, (byte) 4, (byte) 4, (byte) 0, (byte) 1, (byte) 2, (byte) 119, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 17, (byte) 4, (byte) 5, (byte) 33, (byte) 49, (byte) 6, (byte) 18, (byte) 65, (byte) 81, (byte) 7, (byte) 97, (byte) 113, (byte) 19, (byte) 34, (byte) 50, (byte) -127, (byte) 8, (byte) 20, (byte) 66, (byte) -111, (byte) -95, (byte) -79, (byte) -63, (byte) 9, (byte) 35, (byte) 51, (byte) 82, (byte) -16, (byte) 21, (byte) 98, (byte) 114, (byte) -47, (byte) 10, (byte) 22, (byte) 36, (byte) 52, (byte) -31, (byte) 37, (byte) -15, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) -126, (byte) -125, (byte) -124, (byte) -123, (byte) -122, (byte) -121, (byte) -120, (byte) -119, (byte) -118, (byte) -110, (byte) -109, (byte) -108, (byte) -107, (byte) -106, (byte) -105, (byte) -104, (byte) -103, (byte) -102, (byte) -94, (byte) -93, (byte) -92, (byte) -91, (byte) -90, (byte) -89, (byte) -88, (byte) -87, (byte) -86, (byte) -78, (byte) -77, (byte) -76, (byte) -75, (byte) -74, (byte) -73, (byte) -72, (byte) -71, (byte) -70, (byte) -62, (byte) -61, (byte) -60, (byte) -59, (byte) -58, (byte) -57, (byte) -56, (byte) -55, (byte) -54, (byte) -46, (byte) -45, (byte) -44, (byte) -43, (byte) -42, (byte) -41, (byte) -40, (byte) -39, (byte) -38, (byte) -30, (byte) -29, (byte) -28, (byte) -27, (byte) -26, (byte) -25, (byte) -24, (byte) -23, (byte) -22, (byte) -14, (byte) -13, (byte) -12, (byte) -11, (byte) -10, (byte) -9, (byte) -8, (byte) -7, (byte) -6, (byte) -1, (byte) -38, (byte) 0, (byte) 12, (byte) 3, (byte) 1, (byte) 0, (byte) 2, (byte) 17, (byte) 3, (byte) 17, (byte) 0, (byte) 63, (byte) 0, (byte) -114, (byte) -118, (byte) 40, (byte) -96, (byte) 15, (byte) -1, (byte) -39};
    private final NativePooledByteBufferFactory f10594c;

    public EmptyJpegGenerator(NativePooledByteBufferFactory nativePooledByteBufferFactory) {
        this.f10594c = nativePooledByteBufferFactory;
    }

    public final CloseableReference<PooledByteBuffer> m15774a(short s, short s2) {
        PooledByteBufferOutputStream pooledByteBufferOutputStream = null;
        try {
            pooledByteBufferOutputStream = this.f10594c.m15780a((f10592a.length + f10593b.length) + 4);
            pooledByteBufferOutputStream.write(f10592a);
            pooledByteBufferOutputStream.write((byte) (s2 >> 8));
            pooledByteBufferOutputStream.write((byte) (s2 & 255));
            pooledByteBufferOutputStream.write((byte) (s >> 8));
            pooledByteBufferOutputStream.write((byte) (s & 255));
            pooledByteBufferOutputStream.write(f10593b);
            CloseableReference<PooledByteBuffer> a = CloseableReference.m15675a(pooledByteBufferOutputStream.mo2897a());
            if (pooledByteBufferOutputStream != null) {
                pooledByteBufferOutputStream.close();
            }
            return a;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            if (pooledByteBufferOutputStream != null) {
                pooledByteBufferOutputStream.close();
            }
        }
    }
}
