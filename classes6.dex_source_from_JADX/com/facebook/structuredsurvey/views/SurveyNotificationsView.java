package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: disable_progressive */
public class SurveyNotificationsView extends ImageBlockLayout {
    private static final CallerContext f17219k = CallerContext.a(SurveyNotificationsView.class, "notifications_view");
    @Inject
    public TimeFormatUtil f17220h;
    @Inject
    public Provider<FbDraweeControllerBuilder> f17221i;
    @Inject
    public AbstractFbErrorReporter f17222j;
    private final DraweeHolder f17223l;
    private final SurveyNotificationTextView f17224m;
    private final BetterTextView f17225n;
    private final int f17226o;

    private static <T extends View> void m24968a(Class<T> cls, T t) {
        m24969a((Object) t, t.getContext());
    }

    private static void m24969a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SurveyNotificationsView surveyNotificationsView = (SurveyNotificationsView) obj;
        TimeFormatUtil timeFormatUtil = (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector);
        Provider a = IdBasedProvider.a(fbInjector, 1117);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        surveyNotificationsView.f17220h = timeFormatUtil;
        surveyNotificationsView.f17221i = a;
        surveyNotificationsView.f17222j = abstractFbErrorReporter;
    }

    public SurveyNotificationsView(Context context) {
        this(context, null);
    }

    public SurveyNotificationsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24968a(SurveyNotificationsView.class, (View) this);
        setContentView(2130907342);
        this.f17224m = (SurveyNotificationTextView) getView(2131567791);
        this.f17225n = (BetterTextView) getView(2131567792);
        this.f17226o = getResources().getDimensionPixelSize(2131430764);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.d = 1;
        this.f17223l = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), context);
        this.f17223l.h().setCallback(this);
        setThumbnailPlaceholderResource(2131361948);
    }

    public final void m24970a(String str, String str2, Spannable spannable, long j) {
        setBackgroundColor(-1);
        this.f17225n.setTextAppearance(getContext(), 2131625674);
        this.f17224m.m24967a((CharSequence) spannable, null);
        this.f17225n.setText(this.f17220h.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * j));
        if (str2 != null) {
            try {
                Drawable drawable;
                this.f17223l.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f17221i.get()).a(f17219k).b(this.f17223l.e())).a(str2).s());
                Drawable h = this.f17223l.h();
                h.setBounds(0, 0, this.f17226o, this.f17226o);
                boolean a = this.f17225n.a();
                BetterTextView betterTextView = this.f17225n;
                if (a) {
                    drawable = null;
                } else {
                    drawable = h;
                }
                if (!a) {
                    h = null;
                }
                betterTextView.setCompoundDrawables(drawable, null, h, null);
            } catch (Throwable e) {
                this.f17222j.a("SurveyNotificationsView binding error", e);
            }
            setThumbnailUri(str);
        }
        this.f17225n.setCompoundDrawables(null, null, null, null);
        setThumbnailUri(str);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 710870924);
        super.onAttachedToWindow();
        this.f17223l.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 494043275, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1928976175);
        super.onDetachedFromWindow();
        this.f17223l.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 4573237, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f17223l.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f17223l.b();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f17223l.h();
    }
}
