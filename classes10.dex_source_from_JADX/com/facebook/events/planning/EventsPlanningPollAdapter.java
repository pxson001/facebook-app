package com.facebook.events.planning;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

/* compiled from: b5e0246e51741958635a2646904dc829 */
public class EventsPlanningPollAdapter extends ArrayAdapter<CalendarRange> {
    private int f18984a;

    public EventsPlanningPollAdapter(Context context, ArrayList<CalendarRange> arrayList, int i) {
        super(context, 0, arrayList);
        this.f18984a = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View eventsPlanningStartAndEndTimeView;
        if (view == null) {
            eventsPlanningStartAndEndTimeView = new EventsPlanningStartAndEndTimeView(getContext());
        } else {
            eventsPlanningStartAndEndTimeView = view;
        }
        CalendarRange calendarRange = (CalendarRange) getItem(i);
        EventsPlanningStartAndEndTimeView eventsPlanningStartAndEndTimeView2 = (EventsPlanningStartAndEndTimeView) eventsPlanningStartAndEndTimeView;
        eventsPlanningStartAndEndTimeView2.f19001e = this.f18984a;
        eventsPlanningStartAndEndTimeView2.f19002f = i;
        eventsPlanningStartAndEndTimeView2.setCalendarRange(calendarRange);
        return eventsPlanningStartAndEndTimeView;
    }
}
