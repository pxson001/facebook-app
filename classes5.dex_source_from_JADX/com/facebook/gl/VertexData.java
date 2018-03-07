package com.facebook.gl;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: WWW_CHECKPOINTS_PAGE */
public class VertexData {
    public final FloatBuffer f12356a;
    public final int f12357b;
    public final int f12358c;
    public final boolean f12359d;

    public VertexData(float[] fArr, int i) {
        this(fArr, i, false);
    }

    private VertexData(float[] fArr, int i, boolean z) {
        boolean z2 = true;
        boolean z3 = i > 0 && i <= 4;
        Preconditions.checkArgument(z3);
        if (fArr.length % i != 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f12356a = (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).position(0);
        this.f12357b = i;
        this.f12358c = fArr.length / this.f12357b;
        this.f12359d = z;
    }
}
