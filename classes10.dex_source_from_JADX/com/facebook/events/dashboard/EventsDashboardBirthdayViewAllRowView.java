package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: completionUrl */
public class EventsDashboardBirthdayViewAllRowView extends FbTextView {
    @Inject
    public EventPermalinkController f16545a;

    /* compiled from: completionUrl */
    class C23071 implements OnClickListener {
        final /* synthetic */ EventsDashboardBirthdayViewAllRowView f16544a;

        C23071(EventsDashboardBirthdayViewAllRowView eventsDashboardBirthdayViewAllRowView) {
            this.f16544a = eventsDashboardBirthdayViewAllRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 601950649);
            this.f16544a.f16545a.m18263a(this.f16544a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1273518665, a);
        }
    }

    private static <T extends View> void m16954a(Class<T> cls, T t) {
        m16955a((Object) t, t.getContext());
    }

    private static void m16955a(Object obj, Context context) {
        ((EventsDashboardBirthdayViewAllRowView) obj).f16545a = EventPermalinkController.m18262b(FbInjector.get(context));
    }

    public EventsDashboardBirthdayViewAllRowView(Context context) {
        super(context);
        m16952a();
    }

    public EventsDashboardBirthdayViewAllRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16952a();
    }

    public EventsDashboardBirthdayViewAllRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16952a();
    }

    private void m16952a() {
        m16954a(EventsDashboardBirthdayViewAllRowView.class, (View) this);
        setOnClickListener(new C23071(this));
    }

    private void m16953a(EventPermalinkController eventPermalinkController) {
        this.f16545a = eventPermalinkController;
    }
}
