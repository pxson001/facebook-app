package com.facebook.notifications.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationStoryHelper$NotificationLocation;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.ui.touchlistener.HighlightViewChildrenOnTouchListener;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: middleComponent */
public class CaspianNotificationsView extends ImageBlockLayout {
    private static final CallerContext f8979n = CallerContext.a(CaspianNotificationsView.class, "notifications_view");
    @Inject
    GlyphColorizer f8980h;
    @Inject
    TimeFormatUtil f8981i;
    @Inject
    TodayExperimentController f8982j;
    @Inject
    Provider<FbDraweeControllerBuilder> f8983k;
    @Inject
    AbstractFbErrorReporter f8984l;
    @Inject
    NotificationStoryHelper f8985m;
    private final DraweeHolder f8986o;
    private final CaspianNotificationTextView f8987p;
    private final BetterTextView f8988q;
    public final ImageButton f8989r;
    private final int f8990s;
    private final OnTouchListener f8991t;

    private static <T extends View> void m10852a(Class<T> cls, T t) {
        m10853a((Object) t, t.getContext());
    }

    private static void m10853a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CaspianNotificationsView) obj).m10851a(GlyphColorizer.a(fbInjector), (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector), TodayExperimentController.a(fbInjector), IdBasedProvider.a(fbInjector, 1117), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), NotificationStoryHelper.a(fbInjector));
    }

    public CaspianNotificationsView(Context context) {
        this(context, null);
    }

    public CaspianNotificationsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10852a(CaspianNotificationsView.class, (View) this);
        setContentView(2130903521);
        this.f8987p = (CaspianNotificationTextView) getView(2131560262);
        this.f8988q = (BetterTextView) getView(2131560263);
        this.f8989r = (ImageButton) getView(2131560264);
        this.f8990s = getResources().getDimensionPixelSize(2131429187);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.d = 1;
        this.f8986o = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), context);
        this.f8986o.h().setCallback(this);
        setThumbnailPlaceholderResource(2131361948);
        if (this.f8982j.u()) {
            Resources resources = getResources();
            setThumbnailPadding(resources.getDimensionPixelSize(2131429181));
            setThumbnailSize(resources.getDimensionPixelSize(2131427472));
            int dimensionPixelSize = resources.getDimensionPixelSize(2131429181);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            setOverlayGravity(16);
        }
        this.f8991t = new HighlightViewChildrenOnTouchListener();
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void m10857a(boolean z, String str, String str2, Spannable spannable, long j, String str3, String str4, GraphQLNotifImportanceType graphQLNotifImportanceType, @Nullable SpannableString spannableString) {
        setBackgroundResource(z ? 2131361871 : 2131362820);
        if (this.f8982j.u()) {
            int i;
            BetterTextView betterTextView = this.f8988q;
            Context context = getContext();
            if (z) {
                i = 2131625289;
            } else {
                i = 2131625290;
            }
            betterTextView.setTextAppearance(context, i);
        } else {
            this.f8988q.setTextAppearance(getContext(), z ? 2131625287 : 2131625288);
        }
        m10850a(spannable, str4, graphQLNotifImportanceType);
        m10854a(str2, j, str3, graphQLNotifImportanceType, spannableString);
        setThumbnailUri(str);
    }

    public final void m10856a(GraphQLStory graphQLStory, String str, int i, int i2) {
        setBackgroundResource(2131361871);
        setThumbnailResource(i);
        m10850a(this.f8985m.a(graphQLStory, NotificationStoryHelper$NotificationLocation.JEWEL, this.f8987p), null, null);
        this.f8988q.setText(str);
        this.f8988q.setTextAppearance(getContext(), 2131625287);
        setTimestampIconFromDrawable(getResources().getDrawable(i2));
    }

    public ImageButton getNotificationsAuxView() {
        return this.f8989r;
    }

    public void setAuxViewClickListener(OnClickListener onClickListener) {
        this.f8989r.setOnClickListener(onClickListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -512211370);
        if (this.f8982j.z()) {
            this.f8991t.onTouch(this, motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 1116354431, a);
        return onTouchEvent;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 712098172);
        super.onAttachedToWindow();
        this.f8986o.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 307873463, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 719544143);
        super.onDetachedFromWindow();
        this.f8986o.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1273918637, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f8986o.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f8986o.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8986o.h();
    }

    private void m10850a(Spannable spannable, String str, GraphQLNotifImportanceType graphQLNotifImportanceType) {
        if (this.f8982j.b.a(ExperimentsForTodayAbTestModule.v, false) && GraphQLNotifImportanceType.IMPORTANT.equals(graphQLNotifImportanceType) && !StringUtil.a(str)) {
            Object obj = " ";
            Object string = getResources().getString(2131233661);
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(str);
            spannableStringBuilder.append(obj);
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(obj);
            spannableStringBuilder.append(spannable);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, string.length() + (obj.length() + str.length()), 18);
            this.f8987p.m10847a(spannableStringBuilder, null);
            return;
        }
        this.f8987p.m10847a((CharSequence) spannable, null);
    }

    private void m10851a(GlyphColorizer glyphColorizer, TimeFormatUtil timeFormatUtil, TodayExperimentController todayExperimentController, Provider<FbDraweeControllerBuilder> provider, FbErrorReporter fbErrorReporter, NotificationStoryHelper notificationStoryHelper) {
        this.f8980h = glyphColorizer;
        this.f8981i = timeFormatUtil;
        this.f8982j = todayExperimentController;
        this.f8983k = provider;
        this.f8984l = fbErrorReporter;
        this.f8985m = notificationStoryHelper;
    }

    private void m10854a(String str, long j, String str2, GraphQLNotifImportanceType graphQLNotifImportanceType, @Nullable SpannableString spannableString) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder();
        separatedSpannableStringBuilder.a(m10849a(j));
        if (spannableString != null) {
            this.f8988q.setMovementMethod(LinkMovementMethod.getInstance());
            separatedSpannableStringBuilder.a(spannableString);
        }
        this.f8988q.setText(separatedSpannableStringBuilder);
        m10855a(str, str2, graphQLNotifImportanceType);
    }

    private String m10849a(long j) {
        return this.f8981i.a(TimeFormatStyle.NOTIFICATIONS_STREAM_RELATIVE_STYLE, 1000 * j);
    }

    private void m10855a(String str, String str2, GraphQLNotifImportanceType graphQLNotifImportanceType) {
        try {
            Drawable a = m10848a(str, graphQLNotifImportanceType);
            if (a == null) {
                this.f8988q.setCompoundDrawables(null, null, null, null);
            } else {
                setTimestampIconFromDrawable(a);
            }
        } catch (Throwable e) {
            this.f8984l.a("notifications_view_notifications_url", "notif_cache_id: " + str2, e);
            this.f8988q.setCompoundDrawables(null, null, null, null);
        }
    }

    private void setTimestampIconFromDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, this.f8990s, this.f8990s);
        boolean z = this.f8988q.g;
        BetterTextView betterTextView = this.f8988q;
        Drawable drawable2 = z ? null : drawable;
        if (!z) {
            drawable = null;
        }
        betterTextView.setCompoundDrawables(drawable2, null, drawable, null);
    }

    private Drawable m10848a(String str, GraphQLNotifImportanceType graphQLNotifImportanceType) {
        if (this.f8982j.b.a(ExperimentsForTodayAbTestModule.l, false) && GraphQLNotifImportanceType.IMPORTANT.equals(graphQLNotifImportanceType)) {
            return this.f8980h.a(2130840114, -10972929);
        }
        if (str == null || !this.f8982j.b.a(ExperimentsForTodayAbTestModule.u, true)) {
            return null;
        }
        this.f8986o.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8983k.get()).a(f8979n).b(this.f8986o.f)).a(str).s());
        return this.f8986o.h();
    }
}
