package com.facebook.livephotos.egl;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

@TargetApi(19)
/* compiled from: pendingMembers */
public class GLFrameRenderer {
    private static final float[] f6664c = new float[]{-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] f6665d = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final short[] f6666e = new short[]{(short) 0, (short) 1, (short) 2, (short) 0, (short) 2, (short) 3};
    private final String f6667a = "attribute mediump vec4 aPosition;\nattribute mediump vec2 aTexCoord;\nuniform mediump float uScale;\nuniform mediump float uAlpha;\nuniform mediump int uBlurType;\nuniform mediump mat4 uTransformMatrix;\nvarying mediump float vAlpha;\nvarying mediump vec2 vBlurTexCoord[14];\nvarying mediump vec2 vTexCoord;\nvoid main() {\n vTexCoord = (uTransformMatrix * vec4(aTexCoord, 0.0, 1.0)).xy;\n vAlpha = uAlpha;\n if (uBlurType == 1) {\n  vBlurTexCoord[ 0] = vTexCoord + vec2(-0.028, 0.0);\n  vBlurTexCoord[ 1] = vTexCoord + vec2(-0.024, 0.0);\n  vBlurTexCoord[ 2] = vTexCoord + vec2(-0.020, 0.0);\n  vBlurTexCoord[ 3] = vTexCoord + vec2(-0.016, 0.0);\n  vBlurTexCoord[ 4] = vTexCoord + vec2(-0.012, 0.0);\n  vBlurTexCoord[ 5] = vTexCoord + vec2(-0.008, 0.0);\n  vBlurTexCoord[ 6] = vTexCoord + vec2(-0.004, 0.0);\n  vBlurTexCoord[ 7] = vTexCoord + vec2( 0.004, 0.0);\n  vBlurTexCoord[ 8] = vTexCoord + vec2( 0.008, 0.0);\n  vBlurTexCoord[ 9] = vTexCoord + vec2( 0.012, 0.0);\n  vBlurTexCoord[10] = vTexCoord + vec2( 0.016, 0.0);\n  vBlurTexCoord[11] = vTexCoord + vec2( 0.020, 0.0);\n  vBlurTexCoord[12] = vTexCoord + vec2( 0.024, 0.0);\n  vBlurTexCoord[13] = vTexCoord + vec2( 0.028, 0.0);\n }\n vec2 pos = aPosition.xy * uScale;\n gl_Position = vec4(pos, 0.0, 1.0);\n}\n";
    private final String f6668b = "#extension GL_OES_EGL_image_external : require\nvarying mediump vec2 vBlurTexCoord[14];\nvarying mediump vec2 vTexCoord;\nuniform mediump int uBlurType;\nvarying mediump float vAlpha;\nuniform samplerExternalOES uTexture;\nvoid main() {\n if (uBlurType == 0) {\n  gl_FragColor = vAlpha * texture2D(uTexture, vTexCoord);\n } else {\n gl_FragColor = vec4(0.0);\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 0])*0.0044299121055113265;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 1])*0.00895781211794;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 2])*0.0215963866053;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 3])*0.0443683338718;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 4])*0.0776744219933;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 5])*0.115876621105;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 6])*0.147308056121;\n gl_FragColor += vAlpha * texture2D(uTexture, vTexCoord        )*0.159576912161;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 7])*0.147308056121;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 8])*0.115876621105;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 9])*0.0776744219933;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[10])*0.0443683338718;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[11])*0.0215963866053;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[12])*0.00895781211794;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[13])*0.0044299121055113265; }\n}\n";
    private final int f6669f;
    private final int f6670g;
    private final int f6671h;
    private final int f6672i;
    private final int f6673j;
    private final int f6674k;
    private final int f6675l;
    private final int f6676m;
    private final FloatBuffer f6677n;
    private final FloatBuffer f6678o;
    private final ShortBuffer f6679p;
    private final int f6680q;

    public GLFrameRenderer(GLContext gLContext) {
        this.f6669f = gLContext.m8563a("attribute mediump vec4 aPosition;\nattribute mediump vec2 aTexCoord;\nuniform mediump float uScale;\nuniform mediump float uAlpha;\nuniform mediump int uBlurType;\nuniform mediump mat4 uTransformMatrix;\nvarying mediump float vAlpha;\nvarying mediump vec2 vBlurTexCoord[14];\nvarying mediump vec2 vTexCoord;\nvoid main() {\n vTexCoord = (uTransformMatrix * vec4(aTexCoord, 0.0, 1.0)).xy;\n vAlpha = uAlpha;\n if (uBlurType == 1) {\n  vBlurTexCoord[ 0] = vTexCoord + vec2(-0.028, 0.0);\n  vBlurTexCoord[ 1] = vTexCoord + vec2(-0.024, 0.0);\n  vBlurTexCoord[ 2] = vTexCoord + vec2(-0.020, 0.0);\n  vBlurTexCoord[ 3] = vTexCoord + vec2(-0.016, 0.0);\n  vBlurTexCoord[ 4] = vTexCoord + vec2(-0.012, 0.0);\n  vBlurTexCoord[ 5] = vTexCoord + vec2(-0.008, 0.0);\n  vBlurTexCoord[ 6] = vTexCoord + vec2(-0.004, 0.0);\n  vBlurTexCoord[ 7] = vTexCoord + vec2( 0.004, 0.0);\n  vBlurTexCoord[ 8] = vTexCoord + vec2( 0.008, 0.0);\n  vBlurTexCoord[ 9] = vTexCoord + vec2( 0.012, 0.0);\n  vBlurTexCoord[10] = vTexCoord + vec2( 0.016, 0.0);\n  vBlurTexCoord[11] = vTexCoord + vec2( 0.020, 0.0);\n  vBlurTexCoord[12] = vTexCoord + vec2( 0.024, 0.0);\n  vBlurTexCoord[13] = vTexCoord + vec2( 0.028, 0.0);\n }\n vec2 pos = aPosition.xy * uScale;\n gl_Position = vec4(pos, 0.0, 1.0);\n}\n", "#extension GL_OES_EGL_image_external : require\nvarying mediump vec2 vBlurTexCoord[14];\nvarying mediump vec2 vTexCoord;\nuniform mediump int uBlurType;\nvarying mediump float vAlpha;\nuniform samplerExternalOES uTexture;\nvoid main() {\n if (uBlurType == 0) {\n  gl_FragColor = vAlpha * texture2D(uTexture, vTexCoord);\n } else {\n gl_FragColor = vec4(0.0);\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 0])*0.0044299121055113265;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 1])*0.00895781211794;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 2])*0.0215963866053;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 3])*0.0443683338718;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 4])*0.0776744219933;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 5])*0.115876621105;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 6])*0.147308056121;\n gl_FragColor += vAlpha * texture2D(uTexture, vTexCoord        )*0.159576912161;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 7])*0.147308056121;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 8])*0.115876621105;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[ 9])*0.0776744219933;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[10])*0.0443683338718;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[11])*0.0215963866053;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[12])*0.00895781211794;\n gl_FragColor += vAlpha * texture2D(uTexture, vBlurTexCoord[13])*0.0044299121055113265; }\n}\n");
        Preconditions.checkState(this.f6669f != 0);
        this.f6670g = GLES20.glGetAttribLocation(this.f6669f, "aPosition");
        this.f6672i = GLES20.glGetAttribLocation(this.f6669f, "aTexCoord");
        this.f6671h = GLES20.glGetUniformLocation(this.f6669f, "uTexture");
        this.f6673j = GLES20.glGetUniformLocation(this.f6669f, "uScale");
        this.f6674k = GLES20.glGetUniformLocation(this.f6669f, "uAlpha");
        this.f6675l = GLES20.glGetUniformLocation(this.f6669f, "uBlurType");
        this.f6676m = GLES20.glGetUniformLocation(this.f6669f, "uTransformMatrix");
        this.f6680q = f6666e.length;
        short[] sArr = f6666e;
        ShortBuffer asShortBuffer = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        this.f6679p = asShortBuffer;
        this.f6678o = m8566a(f6665d);
        this.f6677n = m8566a(f6664c);
    }

    public final void m8568a(float[] fArr, int i, float f, float f2, boolean z) {
        if (((double) f2) >= 1.0E-4d) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            m8567a(fArr, i, f, f2, z ? 1 : 0);
        }
    }

    private static FloatBuffer m8566a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private void m8567a(float[] fArr, int i, float f, float f2, int i2) {
        GLES20.glEnable(3042);
        GLES20.glDisable(2929);
        GLES20.glDepthMask(false);
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 771);
        GLES20.glUseProgram(this.f6669f);
        GLES20.glEnableVertexAttribArray(this.f6670g);
        GLES20.glEnableVertexAttribArray(this.f6672i);
        GLES20.glVertexAttribPointer(this.f6670g, 3, 5126, false, 0, this.f6677n);
        GLES20.glVertexAttribPointer(this.f6672i, 2, 5126, false, 0, this.f6678o);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.f6671h, 0);
        GLES20.glUniform1f(this.f6673j, f);
        GLES20.glUniform1f(this.f6674k, f2);
        GLES20.glUniform1i(this.f6675l, i2);
        GLES20.glUniformMatrix4fv(this.f6676m, 1, false, fArr, 0);
        GLES20.glDrawElements(4, this.f6680q, 5123, this.f6679p);
        GLES20.glDisableVertexAttribArray(this.f6670g);
        GLES20.glDisableVertexAttribArray(this.f6672i);
        GLES20.glBindTexture(36197, 0);
        GLES20.glDisable(3042);
        GLES20.glUseProgram(0);
    }
}
