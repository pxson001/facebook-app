package com.facebook.dracula.runtime.base;

import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: sale_price */
public class DraculaArray implements Cloneable {
    public static final DraculaArray f2930a = new DraculaArray(new MutableFlatBuffer[0], new int[0], new int[0]);
    public final int f2931b;
    private final MutableFlatBuffer[] f2932c;
    private final int[] f2933d;
    private final int[] f2934e;

    public /* synthetic */ Object clone() {
        return m4069a();
    }

    private DraculaArray(MutableFlatBuffer[] mutableFlatBufferArr, int[] iArr, int[] iArr2) {
        this.f2931b = iArr.length;
        this.f2932c = mutableFlatBufferArr;
        this.f2933d = iArr;
        this.f2934e = iArr2;
    }

    public final DraculaArray m4069a() {
        try {
            return (DraculaArray) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static DraculaArray m4066a(int i) {
        if (i > 0) {
            return new DraculaArray(new MutableFlatBuffer[i], new int[i], new int[i]);
        }
        return f2930a;
    }

    public static void m4067a(DraculaArray draculaArray, int i, DraculaArray draculaArray2, int i2, int i3) {
        System.arraycopy(draculaArray.f2932c, i, draculaArray2.f2932c, i2, i3);
        System.arraycopy(draculaArray.f2933d, i, draculaArray2.f2933d, i2, i3);
        System.arraycopy(draculaArray.f2934e, i, draculaArray2.f2934e, i2, i3);
    }

    public final MutableFlatBuffer m4072b(int i) {
        return this.f2932c[i];
    }

    public final int m4073c(int i) {
        return this.f2933d[i];
    }

    public final int m4074d(int i) {
        return this.f2934e[i];
    }

    public final MutableFlatBuffer m4070a(int i, MutableFlatBuffer mutableFlatBuffer) {
        this.f2932c[i] = mutableFlatBuffer;
        return mutableFlatBuffer;
    }

    public final int m4068a(int i, int i2) {
        this.f2933d[i] = i2;
        return i2;
    }

    public final int m4071b(int i, int i2) {
        this.f2934e[i] = i2;
        return i2;
    }
}
