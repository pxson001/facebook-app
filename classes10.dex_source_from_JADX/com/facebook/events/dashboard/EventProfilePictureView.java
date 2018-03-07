package com.facebook.events.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Objects;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composeMode */
public class EventProfilePictureView extends BetterTextView {
    private static final CallerContext f16501c = CallerContext.a(EventProfilePictureView.class, "event_profile_pic");
    @Inject
    Provider<FbDraweeControllerBuilder> f16502a;
    @Inject
    EventsDashboardTimeFormatUtil f16503b;
    private DraweeHolder f16504d;
    private MetricAffectingSpan f16505e;
    private MetricAffectingSpan f16506f;
    private Uri f16507g;
    private String f16508h;

    private static <T extends View> void m16932a(Class<T> cls, T t) {
        m16933a((Object) t, t.getContext());
    }

    private static void m16933a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventProfilePictureView) obj).m16934a(IdBasedProvider.a(fbInjector, 1117), EventsDashboardTimeFormatUtil.a(fbInjector));
    }

    private void m16934a(Provider<FbDraweeControllerBuilder> provider, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil) {
        this.f16502a = provider;
        this.f16503b = eventsDashboardTimeFormatUtil;
    }

    public EventProfilePictureView(Context context) {
        super(context);
        m16935b();
    }

    public EventProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16935b();
    }

    public EventProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16935b();
    }

    private void m16935b() {
        m16932a(EventProfilePictureView.class, (View) this);
        Resources resources = getResources();
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131431335);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131431336);
        this.f16505e = m16930a(dimensionPixelSize, FontWeight.MEDIUM);
        this.f16506f = m16930a(dimensionPixelSize2, FontWeight.REGULAR);
        Drawable drawable = resources.getDrawable(2131363346);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = drawable;
        this.f16504d = DraweeHolder.a(genericDraweeHierarchyBuilder.f(getResources().getDrawable(2130839517)).u(), getContext());
        setBackgroundWithPadding(this.f16504d.h());
    }

    private DateSpan m16930a(int i, FontWeight fontWeight) {
        return new DateSpan(CustomFontHelper.a(getContext(), FontFamily.ROBOTO, fontWeight, getTypeface()), i, 0);
    }

    private void setBackgroundWithPadding(Drawable drawable) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        setBackgroundDrawable(drawable);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void m16931a(Uri uri, Date date) {
        setProfilePictureUri(uri);
        setStartDate(date);
    }

    private void setProfilePictureUri(Uri uri) {
        if (!Objects.equal(this.f16507g, uri)) {
            this.f16507g = uri;
            this.f16504d.a(((FbDraweeControllerBuilder) this.f16502a.get()).a(f16501c).b(this.f16507g).s());
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private void setStartDate(Date date) {
        String toUpperCase = this.f16503b.c(date).toUpperCase(Locale.getDefault());
        Object obj = toUpperCase + "\n" + this.f16503b.d(date);
        if (!obj.equals(this.f16508h)) {
            this.f16508h = obj;
            CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
            spannableStringBuilder.setSpan(this.f16505e, 0, toUpperCase.length(), 17);
            spannableStringBuilder.setSpan(this.f16506f, toUpperCase.length() + 1, obj.length(), 17);
            setText(spannableStringBuilder);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1796566282);
        super.onAttachedToWindow();
        this.f16504d.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1083519659, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -204210576);
        super.onDetachedFromWindow();
        this.f16504d.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 685316575, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f16504d.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f16504d.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f16504d.h() || super.verifyDrawable(drawable);
    }

    public final void m16936a(Event event) {
        m16931a(event.Y, event.J());
    }
}
