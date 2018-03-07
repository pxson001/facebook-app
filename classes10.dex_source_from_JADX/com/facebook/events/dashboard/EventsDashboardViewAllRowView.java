package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.wearable.internal.IWearableCallbacks */
public class EventsDashboardViewAllRowView extends BetterTextView {
    @Inject
    public EventEventLogger f16764a;
    public CaspianEventsDashboardBucketAdapter f16765b;
    public EventAnalyticsParams f16766c;

    /* compiled from: com.google.android.gms.wearable.internal.IWearableCallbacks */
    class C23391 implements OnClickListener {
        final /* synthetic */ EventsDashboardViewAllRowView f16763a;

        C23391(EventsDashboardViewAllRowView eventsDashboardViewAllRowView) {
            this.f16763a = eventsDashboardViewAllRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1305988559);
            this.f16763a.f16764a.m18124a(this.f16763a.f16766c.b.f.getParamValue());
            this.f16763a.f16765b.m16920c(true);
            Logger.a(2, EntryType.UI_INPUT_END, -2048937107, a);
        }
    }

    private static <T extends View> void m17157a(Class<T> cls, T t) {
        m17158a((Object) t, t.getContext());
    }

    private static void m17158a(Object obj, Context context) {
        ((EventsDashboardViewAllRowView) obj).f16764a = EventEventLogger.m18119b(FbInjector.get(context));
    }

    public EventsDashboardViewAllRowView(Context context) {
        super(context);
        m17160b();
    }

    public EventsDashboardViewAllRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17160b();
    }

    public EventsDashboardViewAllRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17160b();
    }

    public void setEventsDashboardBucketAdapter(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
        this.f16765b = caspianEventsDashboardBucketAdapter;
    }

    private void m17160b() {
        m17157a(EventsDashboardViewAllRowView.class, (View) this);
        setOnClickListener(new C23391(this));
    }

    public final void m17161a(EventAnalyticsParams eventAnalyticsParams) {
        this.f16766c = eventAnalyticsParams;
    }

    private void m17156a(EventEventLogger eventEventLogger) {
        this.f16764a = eventEventLogger;
    }
}
