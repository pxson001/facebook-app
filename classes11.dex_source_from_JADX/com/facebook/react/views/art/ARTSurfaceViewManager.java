package com.facebook.react.views.art;

import android.graphics.Bitmap;
import android.view.View;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;

/* compiled from: SEND_PROGRESS_DIALOG_TAG */
public class ARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, ARTSurfaceViewShadowNode> {
    private static final MeasureFunction f11427a = new C13831();

    /* compiled from: SEND_PROGRESS_DIALOG_TAG */
    final class C13831 implements MeasureFunction {
        C13831() {
        }

        public final void m11785a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
            throw new IllegalStateException("SurfaceView should have explicit width and height set");
        }
    }

    public final void m11788a(View view, Object obj) {
        ((ARTSurfaceView) view).setBitmap((Bitmap) obj);
    }

    public final String m11787a() {
        return "ARTSurfaceView";
    }

    public final ReactShadowNode m11790c() {
        ARTSurfaceViewShadowNode aRTSurfaceViewShadowNode = new ARTSurfaceViewShadowNode();
        aRTSurfaceViewShadowNode.a(f11427a);
        return aRTSurfaceViewShadowNode;
    }

    public final Class<ARTSurfaceViewShadowNode> m11789b() {
        return ARTSurfaceViewShadowNode.class;
    }

    protected final View m11786a(ThemedReactContext themedReactContext) {
        return new ARTSurfaceView(themedReactContext);
    }
}
