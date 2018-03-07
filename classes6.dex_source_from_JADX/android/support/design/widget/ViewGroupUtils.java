package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: publish func must contains publish post/edit post params key. */
public class ViewGroupUtils {
    public static final ViewGroupUtilsImpl f7136a;

    /* compiled from: publish func must contains publish post/edit post params key. */
    public interface ViewGroupUtilsImpl {
        void mo892a(ViewGroup viewGroup, View view, Rect rect);
    }

    /* compiled from: publish func must contains publish post/edit post params key. */
    class ViewGroupUtilsImplBase implements ViewGroupUtilsImpl {
        public final void mo892a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
        }
    }

    /* compiled from: publish func must contains publish post/edit post params key. */
    class ViewGroupUtilsImplHoneycomb implements ViewGroupUtilsImpl {
        public final void mo892a(ViewGroup viewGroup, View view, Rect rect) {
            Matrix matrix;
            Matrix matrix2 = (Matrix) ViewGroupUtilsHoneycomb.f7137a.get();
            if (matrix2 == null) {
                matrix2 = new Matrix();
                ViewGroupUtilsHoneycomb.f7137a.set(matrix2);
                matrix = matrix2;
            } else {
                matrix2.set(ViewGroupUtilsHoneycomb.f7139c);
                matrix = matrix2;
            }
            ViewGroupUtilsHoneycomb.m10269a(viewGroup, view, matrix);
            RectF rectF = (RectF) ViewGroupUtilsHoneycomb.f7138b.get();
            if (rectF == null) {
                rectF = new RectF();
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }
    }

    ViewGroupUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f7136a = new ViewGroupUtilsImplHoneycomb();
        } else {
            f7136a = new ViewGroupUtilsImplBase();
        }
    }

    static void m10268a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        f7136a.mo892a(viewGroup, view, rect);
    }
}
