package com.facebook.catalyst.shadow.flat;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactShadowNode;
import javax.annotation.Nullable;

/* compiled from: location_update */
public final class MoveProxy {
    @Nullable
    public ReadableArray f5764a;
    public int f5765b;
    private int[] f5766c = new int[8];
    public ReactShadowNode[] f5767d = new ReactShadowNode[4];

    MoveProxy() {
    }

    public final void m7096a(int i, ReactShadowNode reactShadowNode) {
        this.f5767d[m7093f(i)] = reactShadowNode;
    }

    public final int m7098b(int i) {
        return m7094g(i);
    }

    public final void m7097a(ReadableArray readableArray, ReadableArray readableArray2) {
        this.f5764a = readableArray2;
        if (readableArray == null) {
            m7095j(0);
            return;
        }
        int size = readableArray.size();
        int i = size + size;
        if (this.f5766c.length < i) {
            this.f5766c = new int[i];
            this.f5767d = new FlatShadowNode[size];
        }
        m7095j(size);
        m7091a(0, 0, readableArray.getInt(0));
        for (int i2 = 1; i2 < size; i2++) {
            int i3 = readableArray.getInt(i2);
            i = i2 - 1;
            while (i >= 0 && m7094g(i) >= i3) {
                m7091a(i + 1, m7093f(i), m7094g(i));
                i--;
            }
            m7091a(i + 1, i2, i3);
        }
    }

    private static int m7092e(int i) {
        return (i * 2) + 1;
    }

    private void m7091a(int i, int i2, int i3) {
        this.f5766c[i * 2] = i2;
        this.f5766c[m7092e(i)] = i3;
    }

    private int m7093f(int i) {
        return this.f5766c[i * 2];
    }

    private int m7094g(int i) {
        return this.f5766c[m7092e(i)];
    }

    public final int m7099c(int i) {
        return this.f5764a.getInt(i);
    }

    private void m7095j(int i) {
        for (int i2 = i; i2 < this.f5765b; i2++) {
            this.f5767d[i2] = null;
        }
        this.f5765b = i;
    }
}
