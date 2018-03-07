package com.facebook.events.widget.eventcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.text.BetterTextView;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: orca-audio- */
public class EventCalendarTimeView extends BetterTextView {
    @Inject
    public EventsDashboardTimeFormatUtil f5991a;
    private MetricAffectingSpan f5992b;
    private MetricAffectingSpan f5993c;
    private String f5994d;

    private static <T extends View> void m6454a(Class<T> cls, T t) {
        m6455a((Object) t, t.getContext());
    }

    private static void m6455a(Object obj, Context context) {
        ((EventCalendarTimeView) obj).f5991a = EventsDashboardTimeFormatUtil.m6462a(FbInjector.get(context));
    }

    private void m6453a(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil) {
        this.f5991a = eventsDashboardTimeFormatUtil;
    }

    public EventCalendarTimeView(Context context) {
        super(context);
        m6456b();
    }

    public EventCalendarTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6456b();
    }

    public EventCalendarTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6456b();
    }

    private void m6456b() {
        m6454a(EventCalendarTimeView.class, (View) this);
        this.f5993c = new TextAppearanceSpan(getContext(), 2131625299);
        this.f5992b = new TextAppearanceSpan(getContext(), 2131625300);
    }

    public final void m6457a(int i, int i2) {
        this.f5993c = new TextAppearanceSpan(getContext(), i);
        this.f5992b = new TextAppearanceSpan(getContext(), i2);
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final boolean m6459a(Date date) {
        return m6458a(this.f5991a.m6481d(date), this.f5991a.m6479c(date));
    }

    public final boolean m6458a(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Object obj = str + "\n" + str2.toUpperCase(Locale.getDefault());
        if (obj.equals(this.f5994d)) {
            return true;
        }
        this.f5994d = obj;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(this.f5993c, 0, str.length(), 17);
        spannableStringBuilder.setSpan(this.f5992b, str.length() + 1, obj.length(), 17);
        setText(spannableStringBuilder);
        return true;
    }
}
