package com.facebook.widget.viewdiagnostics;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.base.Preconditions;

/* compiled from: messages_android_video_use_resumable_upload */
public class ViewDiagnosticsWrapper extends CustomViewGroup implements RecyclerViewKeepAttached, SupportsViewDiagnostics, ViewDiagnosticsWrapperMarker {
    public ViewDiagnostics f14281a;

    public static void m20675a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ViewDiagnosticsWrapper) obj).f14281a = new ViewDiagnostics(FbSharedPreferencesImpl.m1826a(injectorLike), C0055x2995691a.m1881a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public ViewDiagnosticsWrapper(Context context) {
        super(context);
        Class cls = ViewDiagnosticsWrapper.class;
        m20675a(this, getContext());
    }

    public ViewDiagnostics getViewDiagnostics() {
        return this.f14281a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (m20676d()) {
            TracerDetour.a("ViewDiagnosticsWrapper.onLayout", 1882937236);
            try {
                super.onLayout(z, i, i2, i3, i4);
            } finally {
                this.f14281a.m19829d(TracerDetour.b(-1353614074));
            }
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (m20676d()) {
            TracerDetour.a("ViewDiagnosticsWrapper.onMeasure", -1003778899);
            try {
                super.onMeasure(i, i2);
            } finally {
                this.f14281a.m19831e(TracerDetour.b(-1094594036));
            }
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (m20676d()) {
            TracerDetour.a("ViewDiagnosticsWrapper.dispatchDraw", 1135283186);
            try {
                super.dispatchDraw(canvas);
                this.f14281a.m19824a(getChildAt(0));
                if (this.f14281a.m19826b()) {
                    this.f14281a.draw(canvas);
                }
                if (this.f14281a.m19830d()) {
                    this.f14281a.m19832f();
                }
                this.f14281a.m19823a();
            } finally {
                this.f14281a.m19833f(TracerDetour.b(-6299401));
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public void addView(View view) {
        Preconditions.checkState(getChildCount() == 0);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            Object obj;
            if ((layoutParams instanceof AbsListView.LayoutParams) || (layoutParams instanceof RecyclerView.LayoutParams) || (layoutParams instanceof LayoutParams)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("\nChild view %s with id %d has %s.\nThis will cause a ClassCastException when ViewDiagnostics are disabled.\nChild views should NOT call setLayoutParams() on themselves.\nPlease see intern/wiki/Android/SetLayoutParams.", view.getClass().getCanonicalName(), Integer.valueOf(view.getId()), view.getLayoutParams().getClass().getCanonicalName()));
            }
        }
        super.addView(view);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public View getWrappedView() {
        boolean z = true;
        if (getChildCount() != 1) {
            z = false;
        }
        Preconditions.checkState(z);
        return super.getChildAt(0);
    }

    @Deprecated
    public View getChildAt(int i) {
        return super.getChildAt(i);
    }

    public static View m20674a(View view) {
        if (view instanceof ViewDiagnosticsWrapper) {
            return ((ViewDiagnosticsWrapper) view).getWrappedView();
        }
        return view;
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final boolean gK_() {
        return getChildCount() == 1 && (getWrappedView() instanceof RecyclerViewKeepAttached) && ((RecyclerViewKeepAttached) getWrappedView()).gK_();
    }

    private boolean m20676d() {
        ViewDiagnostics viewDiagnostics = this.f14281a;
        boolean z = viewDiagnostics.m19826b() || viewDiagnostics.f13459C;
        return z;
    }
}
