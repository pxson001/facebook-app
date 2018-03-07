package com.facebook.gl;

import android.opengl.GLES20;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* compiled from: WWW_FEED_PIVOTS */
public class Program {
    public final int f12344a = GLES20.glCreateProgram();
    public final Map<String, Integer> f12345b = Maps.c();
    public final Map<String, Integer> f12346c = Maps.c();
    public final Map<String, Integer> f12347d = Maps.c();
    private final ProgramInUse f12348e;

    /* compiled from: WWW_FEED_PIVOTS */
    public class ProgramInUse {
        public final /* synthetic */ Program f12343a;

        public ProgramInUse(Program program) {
            this.f12343a = program;
        }

        public final ProgramInUse m20424a(String str, float[] fArr) {
            GLES20.glUniformMatrix4fv(m20417a(str), 1, false, fArr, 0);
            return this;
        }

        public final ProgramInUse m20420a(String str, float f) {
            GLES20.glUniform1f(m20417a(str), f);
            return this;
        }

        private ProgramInUse m20418a(String str, int i) {
            GLES20.glUniform1i(m20417a(str), i);
            return this;
        }

        public final ProgramInUse m20423a(String str, boolean z) {
            return m20418a(str, z ? 1 : 0);
        }

        public final ProgramInUse m20421a(String str, int i, int i2, int i3) {
            int a = m20417a(str);
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(i2, i3);
            GLES20.glUniform1i(a, i);
            return this;
        }

        public final ProgramInUse m20419a(Geometry geometry) {
            Program program = this.f12343a;
            ImmutableMap immutableMap = geometry.f12333a;
            Iterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                int intValue;
                String str = (String) it.next();
                if (program.f12345b.containsKey(str)) {
                    intValue = ((Integer) program.f12345b.get(str)).intValue();
                } else {
                    int glGetAttribLocation = GLES20.glGetAttribLocation(program.f12344a, str);
                    Preconditions.checkState(glGetAttribLocation != -1, "Vertex attribute location not found: %s", new Object[]{str});
                    program.f12345b.put(str, Integer.valueOf(glGetAttribLocation));
                    intValue = glGetAttribLocation;
                }
                int i = intValue;
                if (i != -1) {
                    VertexData vertexData = (VertexData) immutableMap.get(str);
                    GLES20.glVertexAttribPointer(i, vertexData.f12357b, 5126, vertexData.f12359d, 0, vertexData.f12356a);
                    GLES20.glEnableVertexAttribArray(i);
                }
            }
            if (geometry.f12334b != null) {
                GLES20.glDrawElements(geometry.f12335c, geometry.f12334b.f12342b, 5121, geometry.f12334b.f12341a);
            } else {
                GLES20.glDrawArrays(geometry.f12335c, 0, geometry.f12336d);
            }
            return this;
        }

        private int m20417a(String str) {
            if (this.f12343a.f12346c.containsKey(str)) {
                return ((Integer) this.f12343a.f12346c.get(str)).intValue();
            }
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f12343a.f12344a, str);
            Preconditions.checkState(glGetUniformLocation != -1, "Uniform location not found: %s", new Object[]{str});
            this.f12343a.f12346c.put(str, Integer.valueOf(glGetUniformLocation));
            return glGetUniformLocation;
        }

        public final ProgramInUse m20422a(String str, Texture texture) {
            int intValue;
            if (this.f12343a.f12347d.containsKey(str)) {
                intValue = ((Integer) this.f12343a.f12347d.get(str)).intValue();
            } else {
                intValue = this.f12343a.f12347d.size();
                this.f12343a.f12347d.put(str, Integer.valueOf(intValue));
            }
            return m20421a(str, intValue, texture.f12353a, texture.f12354b);
        }
    }

    Program(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(35633);
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glAttachShader(this.f12344a, glCreateShader);
        GLES20.glAttachShader(this.f12344a, glCreateShader2);
        m20425a(glCreateShader, str);
        m20425a(glCreateShader2, str2);
        GLES20.glLinkProgram(this.f12344a);
        this.f12348e = new ProgramInUse(this);
    }

    public final ProgramInUse m20426a() {
        GLES20.glUseProgram(this.f12344a);
        return this.f12348e;
    }

    private static void m20425a(int i, String str) {
        GLES20.glShaderSource(i, str);
        GLES20.glCompileShader(i);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(i, 35713, iArr, 0);
        if (iArr[0] == 0) {
            throw new RuntimeException("Failed to compile shader:\n" + GLES20.glGetShaderInfoLog(i));
        }
    }
}
