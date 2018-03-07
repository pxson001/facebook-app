package com.facebook.videocodec.effects.renderers;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.facebook.debug.log.BLog;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Program;
import com.facebook.gl.Program.ProgramInUse;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.Texture.Builder;
import com.facebook.gl.VertexData;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.renderers.DoodleEvent.Type;
import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.List;

/* compiled from: detailed_story */
public class DoodleRenderer implements GLRenderer {
    private static final String f15810a = DoodleRenderer.class.getName();
    private static final float[] f15811b;
    public Geometry f15812c;
    public VertexData f15813d;
    public VertexData f15814e;
    private Texture f15815f;
    private Program f15816g;
    private float[] f15817h = new float[16];
    private List<DoodleLine> f15818i = new LinkedList();
    private DoodleLine f15819j;

    /* compiled from: detailed_story */
    class DoodleLine {
        List<DoodleEvent> f15809a = new LinkedList();

        DoodleLine() {
        }
    }

    static {
        float[] fArr = new float[16];
        f15811b = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public DoodleRenderer() {
        Matrix.setIdentityM(this.f15817h, 0);
    }

    public final synchronized void m19778a(List<DoodleEvent> list) {
        for (DoodleEvent doodleEvent : list) {
            switch (doodleEvent.f15804a) {
                case VIEW_INIT:
                    m19769a(doodleEvent.f15805b, doodleEvent.f15806c);
                    break;
                case START:
                    m19770a(doodleEvent);
                    break;
                case MOVE:
                    m19772b(doodleEvent);
                    break;
                case END:
                    this.f15819j = null;
                    break;
                case UNDO:
                    m19771b();
                    break;
                case CLEAR:
                    m19773c();
                    break;
                default:
                    break;
            }
        }
    }

    public final void m19777a(ProgramFactory programFactory) {
        this.f15816g = programFactory.a(2131165207, 2131165206);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) programFactory.a.getDrawable(2130840418);
        Builder a = new Builder().a(10241, 9729).a(10240, 9729).a(10242, 33071).a(10243, 33071);
        a.c = bitmapDrawable.getBitmap();
        this.f15815f = a.a();
        GLES20.glEnable(3042);
        GLHelpers.a("GL_BLEND");
        GLES20.glBlendFunc(1, 771);
        GLHelpers.a("blendFunc");
    }

    public final void m19775a() {
    }

    public final void m19776a(SurfaceTexture surfaceTexture, Texture texture, float[] fArr, float[] fArr2) {
        if (this.f15812c != null && this.f15812c.d != 0) {
            GLHelpers.a("onDrawFrame");
            ProgramInUse a = this.f15816g.a();
            a.a("pointSize", 20.0f).a("uConstMatrix", this.f15817h).a("uMVPMatrix", f15811b).a("sTexture", this.f15815f);
            a.a(this.f15812c);
        }
    }

    private void m19769a(float f, float f2) {
        Matrix.orthoM(this.f15817h, 0, 0.0f, f, f2, 0.0f, -1.0f, 1.0f);
    }

    private void m19770a(DoodleEvent doodleEvent) {
        this.f15819j = new DoodleLine();
        this.f15818i.add(this.f15819j);
        this.f15819j.f15809a.add(doodleEvent);
        m19774c(doodleEvent);
    }

    private void m19772b(DoodleEvent doodleEvent) {
        boolean z = (this.f15819j == null || this.f15819j.f15809a.isEmpty()) ? false : true;
        Preconditions.checkState(z, "Should not be attempting to update an empty line");
        DoodleEvent doodleEvent2 = (DoodleEvent) this.f15819j.f15809a.get(this.f15819j.f15809a.size() - 1);
        float f = doodleEvent2.f15805b;
        float f2 = doodleEvent2.f15806c;
        float f3 = doodleEvent.f15805b;
        float f4 = doodleEvent.f15806c;
        float f5 = (f + f3) / 2.0f;
        float f6 = (f2 + f4) / 2.0f;
        int max = (int) Math.max(Math.ceil(Math.sqrt((double) (((f3 - f) * (f3 - f)) + ((f4 - f2) * (f4 - f2)))) / 4.0d), 1.0d);
        float f7 = 0.0f;
        for (int i = 0; i < max; i++) {
            DoodleEvent doodleEvent3 = new DoodleEvent(Type.MOVE, (float) (((((1.0d - ((double) f7)) * (1.0d - ((double) f7))) * ((double) f)) + (((2.0d * (1.0d - ((double) f7))) * ((double) f7)) * ((double) f5))) + ((double) ((f7 * f7) * f3))), (float) (((((1.0d - ((double) f7)) * (1.0d - ((double) f7))) * ((double) f2)) + (((2.0d * (1.0d - ((double) f7))) * ((double) f7)) * ((double) f6))) + ((double) ((f7 * f7) * f4))), doodleEvent.f15807d);
            this.f15819j.f15809a.add(doodleEvent3);
            m19774c(doodleEvent3);
            f7 = (float) (((double) f7) + (1.0d / ((double) max)));
        }
    }

    private void m19774c(DoodleEvent doodleEvent) {
        if (this.f15812c == null) {
            boolean z = this.f15812c == null && this.f15813d == null && this.f15814e == null;
            Preconditions.checkState(z, "Geometry already initialized");
            this.f15813d = new VertexData(new float[40000], 2);
            this.f15814e = new VertexData(new float[60000], 3);
            Geometry.Builder builder = new Geometry.Builder(0);
            builder.a = 0;
            this.f15812c = builder.a("a_vertex", this.f15813d).a("a_vertexColor", this.f15814e).a();
        } else if (this.f15812c.d == 20000) {
            BLog.a(f15810a, "Doodle renderer has reached its max number of points");
            return;
        }
        int i = this.f15812c.d * 2;
        this.f15813d.a.put(i, doodleEvent.f15805b);
        this.f15813d.a.put(i + 1, doodleEvent.f15806c);
        i = this.f15812c.d * 3;
        this.f15814e.a.put(i, (float) Color.red(doodleEvent.f15807d));
        this.f15814e.a.put(i + 1, (float) Color.green(doodleEvent.f15807d));
        this.f15814e.a.put(i + 2, (float) Color.blue(doodleEvent.f15807d));
        Geometry geometry = this.f15812c;
        geometry.d++;
    }

    private void m19771b() {
        if (!this.f15818i.isEmpty()) {
            int size = ((DoodleLine) this.f15818i.remove(this.f15818i.size() - 1)).f15809a.size();
            this.f15812c.d = Math.max(this.f15812c.d - size, 0);
        }
    }

    private void m19773c() {
        this.f15818i.clear();
        this.f15812c.d = 0;
    }
}
