package com.facebook.events.widget.eventrow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
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
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: header_check_in */
public class EventRowProfilePictureView extends BetterTextView {
    private static CallerContext f11504c;
    @Inject
    EventsDashboardTimeFormatUtil f11505a;
    @Inject
    Provider<FbDraweeControllerBuilder> f11506b;
    private DraweeHolder f11507d;
    private Uri f11508e;
    private String f11509f;
    private MetricAffectingSpan f11510g;
    private MetricAffectingSpan f11511h;

    private static <T extends View> void m13425a(Class<T> cls, T t) {
        m13426a((Object) t, t.getContext());
    }

    private static void m13426a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventRowProfilePictureView) obj).m13424a(EventsDashboardTimeFormatUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 1117));
    }

    public EventRowProfilePictureView(Context context) {
        super(context);
        m13423a(null);
    }

    public EventRowProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13423a(attributeSet);
    }

    public EventRowProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13423a(attributeSet);
    }

    private void m13423a(@Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        m13425a(EventRowProfilePictureView.class, (View) this);
        Resources resources = getResources();
        int[] iArr = new int[]{2130773557, 2130773558, 2130773559};
        if (attributeSet == null) {
            obtainStyledAttributes = getContext().obtainStyledAttributes(iArr);
        } else {
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        obtainStyledAttributes.recycle();
        this.f11510g = m13422a(dimensionPixelSize, 2131431347, FontWeight.MEDIUM);
        this.f11511h = m13422a(dimensionPixelSize2, 2131431348, FontWeight.REGULAR);
        Drawable drawable2 = drawable == null ? resources.getDrawable(2130839527) : drawable;
        drawable = resources.getDrawable(2131363358);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = drawable;
        this.f11507d = DraweeHolder.a(genericDraweeHierarchyBuilder.f(drawable2).u(), getContext());
        setBackgroundWithPadding(this.f11507d.h());
    }

    private EventRowDateSpan m13422a(int i, int i2, FontWeight fontWeight) {
        Typeface a = CustomFontHelper.a(getContext(), FontFamily.ROBOTO, fontWeight, getTypeface());
        if (i <= 0) {
            i = getResources().getDimensionPixelSize(i2);
        }
        return new EventRowDateSpan(a, i, 0);
    }

    private void setBackgroundWithPadding(Drawable drawable) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        setBackgroundDrawable(drawable);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void m13427a(Uri uri, Date date, String str) {
        f11504c = CallerContext.a(EventRowProfilePictureView.class, str);
        setProfilePictureUri(uri);
        setStartDate(date);
    }

    private void setProfilePictureUri(Uri uri) {
        if (!Objects.equal(this.f11508e, uri)) {
            this.f11508e = uri;
            this.f11507d.a(((FbDraweeControllerBuilder) this.f11506b.get()).a(f11504c).b(this.f11508e).s());
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private void setStartDate(Date date) {
        String toUpperCase = this.f11505a.c(date).toUpperCase(Locale.getDefault());
        Object obj = toUpperCase + "\n" + this.f11505a.d(date);
        if (!obj.equals(this.f11509f)) {
            this.f11509f = obj;
            CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
            spannableStringBuilder.setSpan(this.f11510g, 0, toUpperCase.length(), 17);
            spannableStringBuilder.setSpan(this.f11511h, toUpperCase.length() + 1, obj.length(), 17);
            setText(spannableStringBuilder);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2059763152);
        super.onAttachedToWindow();
        this.f11507d.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1024448174, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1545124085);
        super.onDetachedFromWindow();
        this.f11507d.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 662313842, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f11507d.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f11507d.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f11507d.h() || super.verifyDrawable(drawable);
    }

    private void m13424a(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, Provider<FbDraweeControllerBuilder> provider) {
        this.f11505a = eventsDashboardTimeFormatUtil;
        this.f11506b = provider;
    }

    public final void m13428a(Event event, String str) {
        m13427a(event.Y, event.J(), str);
    }
}
