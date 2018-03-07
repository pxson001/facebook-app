package com.facebook.groups.widget.groupeventrow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.model.Event;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Objects;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: THREADVIEW */
public class GroupEventProfilePictureView extends BetterTextView {
    private static final CallerContext f23205d = CallerContext.a(GroupEventProfilePictureView.class, "group_events");
    @Inject
    EventsDashboardTimeFormatUtil f23206a;
    @Inject
    Provider<FbDraweeControllerBuilder> f23207b;
    @Inject
    Resources f23208c;
    private DraweeHolder f23209e;
    private Uri f23210f;
    private String f23211g;
    private MetricAffectingSpan f23212h;
    private MetricAffectingSpan f23213i;

    private static <T extends View> void m24562a(Class<T> cls, T t) {
        m24563a((Object) t, t.getContext());
    }

    private static void m24563a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupEventProfilePictureView) obj).m24561a(EventsDashboardTimeFormatUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 1117), ResourcesMethodAutoProvider.a(fbInjector));
    }

    public GroupEventProfilePictureView(Context context) {
        super(context);
        m24564b();
    }

    public GroupEventProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24564b();
    }

    public GroupEventProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24564b();
    }

    private void m24564b() {
        m24562a(GroupEventProfilePictureView.class, (View) this);
        GenericDraweeHierarchy u = new GenericDraweeHierarchyBuilder(this.f23208c).f(this.f23208c.getDrawable(2131363932)).u();
        this.f23209e = DraweeHolder.a(u, getContext());
        setBackgroundWithPadding(u.a());
    }

    private void setBackgroundWithPadding(Drawable drawable) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        setBackgroundDrawable(drawable);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void setProfilePictureUri(Uri uri) {
        if (!Objects.equal(this.f23210f, uri)) {
            this.f23210f = uri;
            this.f23209e.a(((FbDraweeControllerBuilder) this.f23207b.get()).a(f23205d).b(this.f23210f).s());
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private void setStartDate(Date date) {
        String toUpperCase = this.f23206a.c(date).toUpperCase(Locale.getDefault());
        Object obj = toUpperCase + "\n" + this.f23206a.d(date);
        if (!obj.equals(this.f23211g)) {
            this.f23211g = obj;
            this.f23213i = new TextAppearanceSpan(getContext(), 2131626600);
            this.f23212h = new TextAppearanceSpan(getContext(), 2131626599);
            CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
            spannableStringBuilder.setSpan(this.f23212h, 0, toUpperCase.length(), 17);
            spannableStringBuilder.setSpan(this.f23213i, toUpperCase.length() + 1, obj.length(), 17);
            setText(spannableStringBuilder);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -288345418);
        super.onAttachedToWindow();
        this.f23209e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 980475701, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1124481028);
        super.onDetachedFromWindow();
        this.f23209e.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1637941782, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f23209e.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f23209e.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f23209e.h() || super.verifyDrawable(drawable);
    }

    private void m24561a(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, Provider<FbDraweeControllerBuilder> provider, Resources resources) {
        this.f23206a = eventsDashboardTimeFormatUtil;
        this.f23207b = provider;
        this.f23208c = resources;
    }

    public final void m24565a(Event event) {
        setProfilePictureUri(event.Y);
        setStartDate(event.J());
    }
}
