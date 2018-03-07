package com.facebook.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: WWW_CONFIRMATION */
public class Texture {
    public final int f12353a;
    public final int f12354b;
    private final ImmutableMap<Integer, Integer> f12355c;

    /* compiled from: WWW_CONFIRMATION */
    public class Builder {
        public int f12350a = 3553;
        public final Map<Integer, Integer> f12351b = Maps.c();
        public Bitmap f12352c;

        public Builder() {
            this.f12351b.put(Integer.valueOf(10241), Integer.valueOf(9729));
            this.f12351b.put(Integer.valueOf(10240), Integer.valueOf(9729));
            this.f12351b.put(Integer.valueOf(10242), Integer.valueOf(33071));
            this.f12351b.put(Integer.valueOf(10243), Integer.valueOf(33071));
        }

        public final Builder m20430a(int i, int i2) {
            this.f12351b.put(Integer.valueOf(i), Integer.valueOf(i2));
            return this;
        }

        public final Builder m20431a(Bitmap bitmap) {
            this.f12352c = bitmap;
            return this;
        }

        public final Texture m20432a() {
            return new Texture(this);
        }
    }

    public Texture(Builder builder) {
        this.f12355c = ImmutableMap.copyOf(builder.f12351b);
        this.f12353a = builder.f12350a;
        Bitmap bitmap = builder.f12352c;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f12354b = iArr[0];
        try {
            GLES20.glBindTexture(this.f12353a, this.f12354b);
            Iterator it = this.f12355c.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                GLES20.glTexParameteri(this.f12353a, ((Integer) entry.getKey()).intValue(), ((Integer) entry.getValue()).intValue());
            }
            if (bitmap != null) {
                GLUtils.texImage2D(this.f12353a, 0, bitmap, 0);
            }
            GLES20.glBindTexture(this.f12353a, 0);
        } catch (Throwable th) {
            GLES20.glBindTexture(this.f12353a, 0);
        }
    }
}
