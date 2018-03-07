package com.facebook.catalyst.shadow.flat;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import javax.annotation.Nullable;

/* compiled from: mBrowserFrame */
public final class FlatNativeViewHierarchyManager extends NativeViewHierarchyManager {
    FlatNativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        super(viewManagerRegistry);
    }

    public final View m6980d(int i) {
        return super.a(i);
    }

    public final void m6973a(int i, SizeMonitoringFrameLayout sizeMonitoringFrameLayout, ThemedReactContext themedReactContext) {
        View flatViewGroup = new FlatViewGroup(themedReactContext);
        sizeMonitoringFrameLayout.addView(flatViewGroup);
        sizeMonitoringFrameLayout.setId(i);
        a(i, flatViewGroup);
    }

    final void m6975a(int i, @Nullable DrawCommand[] drawCommandArr, @Nullable AttachDetachListener[] attachDetachListenerArr, @Nullable NodeRegion[] nodeRegionArr, boolean z) {
        FlatViewGroup flatViewGroup = (FlatViewGroup) a(i);
        if (drawCommandArr != null) {
            flatViewGroup.f5734d = drawCommandArr;
            flatViewGroup.f5749s = z;
            if (flatViewGroup.f5745o) {
                flatViewGroup.f5747q.clear();
                for (DrawCommand drawCommand : flatViewGroup.f5734d) {
                    if (drawCommand instanceof DrawView) {
                        DrawView drawView = (DrawView) drawCommand;
                        flatViewGroup.f5747q.put(Integer.valueOf(drawView.f5650c), drawView);
                    }
                }
            }
            flatViewGroup.invalidate();
        }
        if (attachDetachListenerArr != null) {
            flatViewGroup.m7081a(attachDetachListenerArr);
        }
        if (nodeRegionArr != null) {
            flatViewGroup.f5736f = nodeRegionArr;
        }
    }

    final void m6974a(int i, int[] iArr, int[] iArr2) {
        View a = a(i);
        if (a instanceof FlatViewGroup) {
            ((FlatViewGroup) a).m7079a(this, iArr, iArr2);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) a;
        ViewGroupManager viewGroupManager = (ViewGroupManager) b(i);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            viewGroupManager.a(viewGroup, a(Math.abs(iArr[i2])), i2);
        }
    }

    final void m6972a(int i, int i2, int i3, int i4, int i5) {
        View a = a(i);
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (a.getWidth() == i6 && a.getHeight() == i7) {
            a.offsetLeftAndRight(i2 - a.getLeft());
            a.offsetTopAndBottom(i3 - a.getTop());
            return;
        }
        a.measure(MeasureSpec.makeMeasureSpec(i6, 1073741824), MeasureSpec.makeMeasureSpec(i7, 1073741824));
        a.layout(i2, i3, i4, i5);
    }

    final void m6978b(int i, int i2, int i3, int i4, int i5) {
        a(i).setPadding(i2, i3, i4, i5);
    }

    final void m6977a(int[] iArr) {
        for (int a : iArr) {
            m6976a(a(a));
        }
    }

    protected final void m6976a(View view) {
        super.a(view);
        if (view instanceof FlatViewGroup) {
            FlatViewGroup flatViewGroup = (FlatViewGroup) view;
            if (flatViewGroup.getRemoveClippedSubviews()) {
                for (FlatViewGroup flatViewGroup2 : flatViewGroup.f5748r.values()) {
                    super.a(flatViewGroup2);
                    flatViewGroup.m7080a(flatViewGroup2);
                }
            }
        }
    }

    final void m6979b(int[] iArr) {
        for (int i : iArr) {
            View a = a(i);
            if (a instanceof FlatViewGroup) {
                ((FlatViewGroup) a).detachAllViewsFromParent();
            } else {
                ViewGroup viewGroup = (ViewGroup) a;
                ViewGroupManager viewGroupManager = (ViewGroupManager) b(i);
                for (int a2 = viewGroupManager.a(viewGroup) - 1; a2 >= 0; a2--) {
                    viewGroupManager.b(viewGroup, a2);
                }
            }
        }
    }
}
