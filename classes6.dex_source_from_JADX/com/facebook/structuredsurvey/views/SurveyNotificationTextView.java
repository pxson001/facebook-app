package com.facebook.structuredsurvey.views;

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

/* compiled from: disallow_web_dialog */
public class SurveyNotificationTextView extends BetterTextView {
    private static final CallerContext f17211c = CallerContext.a(SurveyNotificationsView.class, "notifications_view");
    public final String f17212a;
    @Inject
    public Provider<FbDraweeControllerBuilder> f17213b;
    private final TabStopSpan f17214d;
    private final int f17215e;
    private final Rect f17216f;
    private final int f17217g;
    private final DraweeHolder f17218h;

    private static <T extends View> void m24964a(Class<T> cls, T t) {
        m24965a((Object) t, t.getContext());
    }

    private static void m24965a(Object obj, Context context) {
        ((SurveyNotificationTextView) obj).f17213b = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public SurveyNotificationTextView(Context context) {
        this(context, null);
    }

    public SurveyNotificationTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SurveyNotificationTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17212a = "\t";
        this.f17216f = new Rect();
        m24964a(SurveyNotificationTextView.class, (View) this);
        Resources resources = getResources();
        this.f17214d = new Standard(resources.getDimensionPixelSize(2131430763));
        this.f17217g = resources.getDimensionPixelSize(2131430764);
        this.f17215e = resources.getDimensionPixelSize(2131430761);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.d = 1;
        this.f17218h = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), context);
        this.f17218h.h().setCallback(this);
    }

    public final void m24967a(CharSequence charSequence, @Nullable String str) {
        if (str == null) {
            setText(charSequence);
            return;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.insert(0, "\t");
        spannableStringBuilder.setSpan(this.f17214d, 0, 1, 17);
        setText(spannableStringBuilder);
        this.f17218h.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f17213b.get()).a(f17211c).b(this.f17218h.f)).a(str).s());
    }

    private void m24966a(Provider<FbDraweeControllerBuilder> provider) {
        this.f17213b = provider;
    }

    public void onMeasure(int i, int i2) {
        int i3 = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1428459850);
        super.onMeasure(i, i2);
        getLineBounds(0, this.f17216f);
        if (this.g) {
            i3 = getMeasuredWidth() - this.f17217g;
        }
        int descent = ((int) ((((float) this.f17216f.bottom) - getPaint().descent()) - ((float) this.f17215e))) - this.f17217g;
        this.f17218h.h().setBounds(i3, descent, this.f17217g + i3, this.f17217g + descent);
        LogUtils.g(1519642723, a);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable h = this.f17218h.h();
        if (h != null) {
            h.draw(canvas);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1906464988);
        super.onAttachedToWindow();
        this.f17218h.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1953320838, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 340814934);
        super.onDetachedFromWindow();
        this.f17218h.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1679493906, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f17218h.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f17218h.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f17218h.h();
    }
}
