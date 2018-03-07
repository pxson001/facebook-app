package com.facebook.spherical;

import com.facebook.gl.Geometry;
import com.facebook.gl.Geometry.Builder;
import com.facebook.gl.IndexArray;
import com.facebook.gl.VertexData;
import com.google.common.base.Preconditions;

/* compiled from: event_email_declines */
public class CubeGeometry {
    public static Geometry m23671a(boolean z) {
        int i;
        byte b = (byte) 0;
        int[] iArr = new int[]{5, 1, 3, 7, 0, 4, 6, 2, 6, 7, 3, 2, 0, 1, 5, 4, 4, 5, 7, 6, 1, 0, 2, 3};
        float[] fArr = new float[72];
        int i2 = 0;
        for (i = 0; i < 24; i++) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            fArr[i2] = ((float) ((((i3 >> 2) & 1) * 2) - 1)) * 1.0f;
            int i5 = i4 + 1;
            fArr[i4] = ((float) ((((i3 >> 1) & 1) * 2) - 1)) * 1.0f;
            i2 = i5 + 1;
            fArr[i5] = ((float) (((i3 & 1) * 2) - 1)) * 1.0f;
        }
        float[] fArr2 = new float[48];
        int i6 = 0;
        byte b2 = (byte) 0;
        while (i6 < 2) {
            byte b3 = b2;
            for (i = 0; i < 3; i++) {
                i4 = 1 - i6;
                i5 = b3 + 1;
                fArr2[b3] = (((float) i) + 0.004999995f) * 0.33333334f;
                i2 = i5 + 1;
                fArr2[i5] = (((float) i4) + 0.004999995f) * 0.5f;
                i5 = i2 + 1;
                fArr2[i2] = (((float) (i + 1)) - 0.004999995f) * 0.33333334f;
                i2 = i5 + 1;
                fArr2[i5] = (((float) i4) + 0.004999995f) * 0.5f;
                i5 = i2 + 1;
                fArr2[i2] = (((float) (i + 1)) - 0.004999995f) * 0.33333334f;
                i2 = i5 + 1;
                fArr2[i5] = (((float) (i4 + 1)) - 0.004999995f) * 0.5f;
                i5 = i2 + 1;
                fArr2[i2] = (((float) i) + 0.004999995f) * 0.33333334f;
                b3 = i5 + 1;
                fArr2[i5] = (((float) (i4 + 1)) - 0.004999995f) * 0.5f;
            }
            i6++;
            b2 = b3;
        }
        byte[] bArr = new byte[36];
        i = 0;
        while (b < (byte) 24) {
            bArr[i + 0] = b;
            bArr[i + 1] = (byte) (b + 2);
            bArr[i + 2] = (byte) (b + 1);
            bArr[i + 3] = b;
            bArr[i + 4] = (byte) (b + 3);
            bArr[i + 5] = (byte) (b + 2);
            i += 6;
            b = (byte) (b + 4);
        }
        Builder builder = new Builder(24);
        builder.a = 4;
        builder = builder.a("aPosition", new VertexData(fArr, 3));
        builder.d = (IndexArray) Preconditions.checkNotNull(new IndexArray(bArr));
        builder = builder;
        if (z) {
            builder.a("aTextureCoord", new VertexData(fArr2, 2));
        }
        return builder.a();
    }
}
