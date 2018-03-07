package com.facebook.notifications.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TabStopSpan;
import android.text.style.TabStopSpan.Standard;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: minStarsForStore */
public class CaspianNotificationTextView extends BetterTextView {
    private static final CallerContext f8971c = CallerContext.a(CaspianNotificationTextView.class, "notifications_view");
    public final String f8972a;
    @Inject
    public Provider<FbDraweeControllerBuilder> f8973b;
    private final TabStopSpan f8974d;
    private final int f8975e;
    private final Rect f8976f;
    private final int f8977g;
    private final DraweeHolder f8978h;

    private static <T extends View> void m10844a(Class<T> cls, T t) {
        m10845a((Object) t, t.getContext());
    }

    private static void m10845a(Object obj, Context context) {
        ((CaspianNotificationTextView) obj).f8973b = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public CaspianNotificationTextView(Context context) {
        this(context, null);
    }

    public CaspianNotificationTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CaspianNotificationTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8972a = "\t";
        this.f8976f = new Rect();
        m10844a(CaspianNotificationTextView.class, (View) this);
        Resources resources = getResources();
        this.f8974d = new Standard(resources.getDimensionPixelSize(2131429186));
        this.f8977g = resources.getDimensionPixelSize(2131429187);
        this.f8975e = resources.getDimensionPixelSize(2131429184);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.d = 1;
        this.f8978h = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), context);
        this.f8978h.h().setCallback(this);
    }

    public final void m10847a(CharSequence charSequence, @Nullable String str) {
        if (str == null) {
            setText(charSequence);
            return;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.insert(0, "\t");
        spannableStringBuilder.setSpan(this.f8974d, 0, 1, 17);
        setText(spannableStringBuilder);
        this.f8978h.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8973b.get()).a(f8971c).b(this.f8978h.f)).a(str).s());
    }

    public void onMeasure(int i, int i2) {
        int i3 = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 616442712);
        super.onMeasure(i, i2);
        getLineBounds(0, this.f8976f);
        if (this.g) {
            i3 = getMeasuredWidth() - this.f8977g;
        }
        int descent = ((int) ((((float) this.f8976f.bottom) - getPaint().descent()) - ((float) this.f8975e))) - this.f8977g;
        this.f8978h.h().setBounds(i3, descent, this.f8977g + i3, this.f8977g + descent);
        LogUtils.g(1111741008, a);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable h = this.f8978h.h();
        if (h != null) {
            h.draw(canvas);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 580644123);
        super.onAttachedToWindow();
        this.f8978h.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1530349533, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -673933241);
        super.onDetachedFromWindow();
        this.f8978h.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1278323438, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f8978h.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f8978h.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8978h.h();
    }

    private void m10846a(Provider<FbDraweeControllerBuilder> provider) {
        this.f8973b = provider;
    }
}
