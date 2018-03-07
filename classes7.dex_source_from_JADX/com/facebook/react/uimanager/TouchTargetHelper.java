package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import javax.annotation.Nullable;

/* compiled from: frame_prefs_manager/ */
public class TouchTargetHelper {
    private static final float[] f11770a = new float[2];
    private static final PointF f11771b = new PointF();
    private static final float[] f11772c = new float[2];
    private static final Matrix f11773d = new Matrix();

    public static int m13979a(float f, float f2, ViewGroup viewGroup) {
        return m13980a(f, f2, viewGroup, f11770a);
    }

    public static int m13980a(float f, float f2, ViewGroup viewGroup, float[] fArr) {
        UiThreadUtil.m13554b();
        int id = viewGroup.getId();
        fArr[0] = f;
        fArr[1] = f2;
        View a = m13984a(fArr, viewGroup);
        if (a == null) {
            return id;
        }
        a = m13982a(a);
        if (a != null) {
            return m13981a(a, fArr[0], fArr[1]);
        }
        return id;
    }

    private static View m13982a(View view) {
        while (view != null && view.getId() <= 0) {
            view = (View) view.getParent();
        }
        return view;
    }

    private static View m13984a(float[] fArr, ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            PointF pointF = f11771b;
            if (m13985a(fArr[0], fArr[1], viewGroup, childAt, pointF)) {
                float f = fArr[0];
                float f2 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                childAt = m13983a(fArr, childAt);
                if (childAt != null) {
                    return childAt;
                }
                fArr[0] = f;
                fArr[1] = f2;
            }
        }
        return viewGroup;
    }

    private static boolean m13985a(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float f3;
        float scrollX = (((float) viewGroup.getScrollX()) + f) - ((float) view.getLeft());
        float scrollY = (((float) viewGroup.getScrollY()) + f2) - ((float) view.getTop());
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            f3 = scrollX;
            scrollX = scrollY;
        } else {
            float[] fArr = f11772c;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = f11773d;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            f3 = fArr[0];
            scrollX = fArr[1];
        }
        if ((view instanceof ReactHitSlopView) && ((ReactHitSlopView) view).getHitSlopRect() != null) {
            Rect hitSlopRect = ((ReactHitSlopView) view).getHitSlopRect();
            if (f3 >= ((float) (-hitSlopRect.left)) && f3 < ((float) ((view.getRight() - view.getLeft()) + hitSlopRect.right)) && scrollX >= ((float) (-hitSlopRect.top))) {
                if (scrollX < ((float) (hitSlopRect.bottom + (view.getBottom() - view.getTop())))) {
                    pointF.set(f3, scrollX);
                    return true;
                }
            }
            return false;
        } else if (f3 < 0.0f || f3 >= ((float) (view.getRight() - view.getLeft())) || scrollX < 0.0f || scrollX >= ((float) (view.getBottom() - view.getTop()))) {
            return false;
        } else {
            pointF.set(f3, scrollX);
            return true;
        }
    }

    @Nullable
    private static View m13983a(float[] fArr, View view) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.AUTO;
        if (pointerEvents == PointerEvents.NONE) {
            return null;
        }
        if (pointerEvents == PointerEvents.BOX_ONLY) {
            return view;
        }
        if (pointerEvents == PointerEvents.BOX_NONE) {
            if (view instanceof ViewGroup) {
                View a = m13984a(fArr, (ViewGroup) view);
                if (a != view) {
                    return a;
                }
                if ((view instanceof ReactCompoundView) && ((ReactCompoundView) view).m13935a(fArr[0], fArr[1]) != view.getId()) {
                    return view;
                }
            }
            return null;
        } else if (pointerEvents != PointerEvents.AUTO) {
            throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + pointerEvents.toString());
        } else if ((!(view instanceof ReactCompoundViewGroup) || !((ReactCompoundViewGroup) view).m13936b(fArr[0], fArr[1])) && (view instanceof ViewGroup)) {
            return m13984a(fArr, (ViewGroup) view);
        } else {
            return view;
        }
    }

    private static int m13981a(View view, float f, float f2) {
        if (view instanceof ReactCompoundView) {
            return ((ReactCompoundView) view).m13935a(f, f2);
        }
        return view.getId();
    }
}
