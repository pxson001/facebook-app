package com.facebook.events.planning;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: b3577405191f3659245d04f6592eeea9 */
public class EventsPlanningStartAndEndTimeView extends CustomLinearLayout {
    @Inject
    public EventsDashboardTimeFormatUtil f18997a;
    public FbTextView f18998b = ((FbTextView) a(2131566075));
    public FbTextView f18999c = ((FbTextView) a(2131566077));
    private CalendarRange f19000d;
    public int f19001e;
    public int f19002f;

    public static void m19237a(Object obj, Context context) {
        ((EventsPlanningStartAndEndTimeView) obj).f18997a = EventsDashboardTimeFormatUtil.a(FbInjector.get(context));
    }

    public EventsPlanningStartAndEndTimeView(Context context) {
        super(context);
        Class cls = EventsPlanningStartAndEndTimeView.class;
        m19237a((Object) this, getContext());
        setContentView(2130906292);
        setOrientation(1);
    }

    public void setCalendarRange(CalendarRange calendarRange) {
        this.f19000d = calendarRange;
        m19236a(this.f18998b, this.f19000d.f18982a);
        if (this.f19000d.f18983b != null) {
            this.f18999c.setVisibility(0);
            m19236a(this.f18999c, this.f19000d.f18983b);
            return;
        }
        this.f18999c.setVisibility(8);
    }

    private void m19236a(FbTextView fbTextView, Calendar calendar) {
        fbTextView.setText(this.f18997a.a(false, calendar.getTime(), null));
    }

    public Date getStartTime() {
        return this.f19000d.f18982a == null ? null : this.f19000d.f18982a.getTime();
    }

    public Date getEndTime() {
        return this.f19000d.f18983b == null ? null : this.f19000d.f18983b.getTime();
    }

    public int getStartAndEndTimeViewActivityId() {
        return this.f19001e;
    }

    public int getPollPosition() {
        return this.f19002f;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("EventsPlanningStartAndEndTimeView_superState", onSaveInstanceState);
        bundle.putParcelable("EventsPlanningStartAndEndTimeView_calendarRange", this.f19000d);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("EventsPlanningStartAndEndTimeView_superState"));
        setCalendarRange((CalendarRange) bundle.getParcelable("EventsPlanningStartAndEndTimeView_calendarRange"));
    }
}
