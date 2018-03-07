package com.facebook.stickers.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.ChildSharingFrameLayout;
import java.util.concurrent.ExecutorService;

/* compiled from: edit_objects_privacy_operation_type */
public class ExpandableFrameLayout extends ChildSharingFrameLayout {
    public final ChildSharingFrameLayout f16776a = new ChildSharingFrameLayout(getContext());
    public final Spring f16777b;
    public SoftInputDetector f16778c;
    public SpringSystem f16779d;
    public ExecutorService f16780e;
    public float f16781f;
    public boolean f16782g;
    public View f16783h;

    /* compiled from: edit_objects_privacy_operation_type */
    class C11821 implements Runnable {
        final /* synthetic */ ExpandableFrameLayout f16774a;

        C11821(ExpandableFrameLayout expandableFrameLayout) {
            this.f16774a = expandableFrameLayout;
        }

        public void run() {
            this.f16774a.f16781f = ExpandableFrameLayout.getInlineContainerPositionY(this.f16774a);
            this.f16774a.m24557a();
        }
    }

    /* compiled from: edit_objects_privacy_operation_type */
    class C11832 extends SimpleSpringListener {
        final /* synthetic */ ExpandableFrameLayout f16775a;

        C11832(ExpandableFrameLayout expandableFrameLayout) {
            this.f16775a = expandableFrameLayout;
        }

        public final void m24552a(Spring spring) {
            ExpandableFrameLayout.setPopOutLayoutExpansion(this.f16775a, (float) spring.d());
        }

        public final void m24553b(Spring spring) {
            if (spring.d() == 1.0d) {
                ExpandableFrameLayout expandableFrameLayout = this.f16775a;
                if (expandableFrameLayout.f16783h != null) {
                    expandableFrameLayout.f16783h.requestFocus();
                    return;
                }
                return;
            }
            ExpandableFrameLayout.m24556f(this.f16775a);
        }
    }

    public static void m24555a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ExpandableFrameLayout expandableFrameLayout = (ExpandableFrameLayout) obj;
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        SoftInputDetector a = SoftInputDetector.a(fbInjector);
        SpringSystem b = SpringSystem.b(fbInjector);
        expandableFrameLayout.f16780e = executorService;
        expandableFrameLayout.f16778c = a;
        expandableFrameLayout.f16779d = b;
    }

    public ExpandableFrameLayout(Context context) {
        super(context);
        Class cls = ExpandableFrameLayout.class;
        m24555a((Object) this, getContext());
        Spring a = this.f16779d.a().a(new SpringConfig(850.0d, 50.0d));
        a.c = true;
        this.f16777b = a;
    }

    protected void onMeasure(int i, int i2) {
        if (!this.f16778c.f || (findFocus() == null && this.f16776a.findFocus() == null)) {
            this.f16777b.b(0.0d);
        } else {
            ExecutorDetour.a(this.f16780e, new C11821(this), -579440843);
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -207213542);
        this.f16777b.a(new C11832(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1971081140, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1134857302);
        m24556f(this);
        this.f16777b.m();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1043945318, a);
    }

    public final void m24557a() {
        if (getChildCount() != 0) {
            this.f16777b.b(1.0d);
            setPopOutLayoutExpansion(this, (float) this.f16777b.d());
            getFullscreenHostView().addView(this.f16776a);
            this.f16783h = findFocus();
            m24554a((ChildSharingFrameLayout) this, this.f16776a);
            requestLayout();
            this.f16782g = true;
        }
    }

    public static void m24556f(ExpandableFrameLayout expandableFrameLayout) {
        if (expandableFrameLayout.f16776a.getChildCount() != 0) {
            expandableFrameLayout.f16782g = false;
            m24554a(expandableFrameLayout.f16776a, (ChildSharingFrameLayout) expandableFrameLayout);
            expandableFrameLayout.getFullscreenHostView().removeView(expandableFrameLayout.f16776a);
            expandableFrameLayout.requestLayout();
        }
    }

    private static void m24554a(ChildSharingFrameLayout childSharingFrameLayout, ChildSharingFrameLayout childSharingFrameLayout2) {
        while (childSharingFrameLayout.getChildCount() > 0) {
            childSharingFrameLayout2.a(childSharingFrameLayout.getChildAt(0), new LayoutParams(-1, -1));
        }
    }

    public static void setPopOutLayoutExpansion(ExpandableFrameLayout expandableFrameLayout, float f) {
        if (expandableFrameLayout.f16776a != null) {
            expandableFrameLayout.f16776a.setTranslationY(MathUtil.a(expandableFrameLayout.f16781f, 0.0f, f));
        }
    }

    public static float getInlineContainerPositionY(ExpandableFrameLayout expandableFrameLayout) {
        int[] iArr = new int[]{0, 0};
        int[] iArr2 = new int[]{0, 0};
        int paddingTop = expandableFrameLayout.getFullscreenHostView().getPaddingTop();
        expandableFrameLayout.getLocationOnScreen(iArr);
        expandableFrameLayout.getFullscreenHostView().getLocationOnScreen(iArr2);
        return (float) ((iArr[1] - iArr2[1]) - paddingTop);
    }

    private ViewGroup getFullscreenHostView() {
        return (ViewGroup) getRootView().findViewById(16908290);
    }
}
