package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.permalink.guestlist.EventGuestListCountView.EventGuestCountModel;
import com.facebook.events.permalink.guestlist.common.EventsGuestListFragmentNavigationHelper;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: broadcastMessage */
public class EventGuestListCountsView extends SegmentedLinearLayout {
    @VisibleForTesting
    public EventGuestListCountView f18357a;
    @VisibleForTesting
    public EventGuestListCountView f18358b;
    @VisibleForTesting
    public EventGuestListCountView f18359c;
    @Inject
    public EventsGuestListFragmentNavigationHelper f18360d;

    private static <T extends View> void m18698a(Class<T> cls, T t) {
        m18699a((Object) t, t.getContext());
    }

    private static void m18699a(Object obj, Context context) {
        ((EventGuestListCountsView) obj).f18360d = EventsGuestListFragmentNavigationHelper.b(FbInjector.get(context));
    }

    public EventGuestListCountsView(Context context) {
        super(context);
        m18695a();
    }

    public EventGuestListCountsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18695a();
    }

    private void m18695a() {
        setContentView(2130904037);
        setOrientation(0);
        m18698a(EventGuestListCountsView.class, (View) this);
        this.f18357a = (EventGuestListCountView) a(2131561299);
        this.f18358b = (EventGuestListCountView) a(2131561300);
        this.f18359c = (EventGuestListCountView) a(2131561301);
    }

    public final void m18700a(EventsGuestListInitializationModel eventsGuestListInitializationModel, EventGuestCountModel eventGuestCountModel, EventGuestCountModel eventGuestCountModel2, EventGuestCountModel eventGuestCountModel3) {
        setVisibility(0);
        m18696a(this.f18357a, eventGuestCountModel, eventsGuestListInitializationModel);
        m18696a(this.f18358b, eventGuestCountModel2, eventsGuestListInitializationModel);
        m18696a(this.f18359c, eventGuestCountModel3, eventsGuestListInitializationModel);
    }

    private void m18697a(EventsGuestListFragmentNavigationHelper eventsGuestListFragmentNavigationHelper) {
        this.f18360d = eventsGuestListFragmentNavigationHelper;
    }

    private void m18696a(EventGuestListCountView eventGuestListCountView, final EventGuestCountModel eventGuestCountModel, final EventsGuestListInitializationModel eventsGuestListInitializationModel) {
        eventGuestListCountView.m18693a(eventGuestCountModel);
        eventGuestListCountView.setVisibility(0);
        eventGuestListCountView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventGuestListCountsView f18356c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -483336932);
                this.f18356c.f18360d.a(this.f18356c.getContext(), eventsGuestListInitializationModel, eventGuestCountModel.f18348c);
                Logger.a(2, EntryType.UI_INPUT_END, 120054156, a);
            }
        });
    }

    public EventGuestListCountView getCountView3() {
        return this.f18359c;
    }

    public EventGuestListCountView getCountView1() {
        return this.f18357a;
    }

    public EventGuestListCountView getCountView2() {
        return this.f18358b;
    }
}
