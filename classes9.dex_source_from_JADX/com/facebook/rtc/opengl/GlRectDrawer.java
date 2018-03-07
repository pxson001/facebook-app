package com.facebook.rtc.opengl;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: application/vnd.syncml.dm+xml */
public class GlRectDrawer {
    private static final FloatBuffer f19871a = GlUtil.m19598a(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer f19872b = GlUtil.m19598a(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    public final Map<String, Shader> f19873c = new IdentityHashMap();

    /* compiled from: application/vnd.syncml.dm+xml */
    public class Shader {
        public final GlShader f19869a;
        public final int f19870b = this.f19869a.m19595a("texMatrix");

        public Shader(String str) {
            this.f19869a = new GlShader("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", str);
        }
    }

    public final void m19592a(int i, float[] fArr, int i2, int i3, int i4, int i5) {
        m19591a("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n", fArr);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glViewport(i2, i3, i4, i5);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    private void m19591a(String str, float[] fArr) {
        Shader shader;
        if (this.f19873c.containsKey(str)) {
            shader = (Shader) this.f19873c.get(str);
        } else {
            shader = new Shader(str);
            this.f19873c.put(str, shader);
            shader.f19869a.m19596a();
            if (str == "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n") {
                GLES20.glUniform1i(shader.f19869a.m19595a("y_tex"), 0);
                GLES20.glUniform1i(shader.f19869a.m19595a("u_tex"), 1);
                GLES20.glUniform1i(shader.f19869a.m19595a("v_tex"), 2);
            } else if (str == "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n") {
                GLES20.glUniform1i(shader.f19869a.m19595a("rgb_tex"), 0);
            } else if (str == "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n") {
                GLES20.glUniform1i(shader.f19869a.m19595a("oes_tex"), 0);
            } else {
                throw new IllegalStateException("Unknown fragment shader: " + str);
            }
            GlUtil.m19600a("Initialize fragment shader uniform values.");
            shader.f19869a.m19597a("in_pos", 2, f19871a);
            shader.f19869a.m19597a("in_tc", 2, f19872b);
        }
        shader.f19869a.m19596a();
        GLES20.glUniformMatrix4fv(shader.f19870b, 1, false, fArr, 0);
    }
}
