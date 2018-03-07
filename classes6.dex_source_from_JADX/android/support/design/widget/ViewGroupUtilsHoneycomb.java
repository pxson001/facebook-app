package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;

/* compiled from: public_sticky */
public class ViewGroupUtilsHoneycomb {
    public static final ThreadLocal<Matrix> f7137a = new ThreadLocal();
    public static final ThreadLocal<RectF> f7138b = new ThreadLocal();
    public static final Matrix f7139c = new Matrix();

    ViewGroupUtilsHoneycomb() {
    }

    public static void m10269a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m10269a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
