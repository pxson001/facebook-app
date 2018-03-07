package com.facebook.events.widget.eventrow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.model.Event;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: header_context_item_tap */
public class EventRowInlineRsvpView extends SegmentedLinearLayout {
    @Inject
    public EventsConnectionExperimentController f11491a;
    private Event f11492b;
    private FbTextView f11493c;
    private FbTextView f11494d;
    private FbTextView f11495e;
    private OnClickListener f11496f;
    private OnClickListener f11497g;
    private OnClickListener f11498h;
    private OnClickListener f11499i;
    private OnClickListener f11500j;
    private OnClickListener f11501k;
    private OnClickListener f11502l;
    public RsvpActionListener f11503m;

    /* compiled from: header_context_item_tap */
    public interface RsvpActionListener {
    }

    private static <T extends View> void m13418a(Class<T> cls, T t) {
        m13419a((Object) t, t.getContext());
    }

    private static void m13419a(Object obj, Context context) {
        ((EventRowInlineRsvpView) obj).f11491a = EventsConnectionExperimentController.a(FbInjector.get(context));
    }

    public EventRowInlineRsvpView(Context context) {
        super(context);
        m13416a();
    }

    public EventRowInlineRsvpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13416a();
    }

    private void m13416a() {
        m13418a(EventRowInlineRsvpView.class, (View) this);
        setContentView(2130904096);
        this.f11496f = m13413a(GraphQLEventGuestStatus.GOING);
        this.f11497g = m13413a(GraphQLEventGuestStatus.MAYBE);
        this.f11498h = m13413a(GraphQLEventGuestStatus.NOT_GOING);
        this.f11499i = m13414a(GraphQLEventWatchStatus.WATCHED);
        this.f11500j = m13414a(GraphQLEventWatchStatus.GOING);
        this.f11501k = m13414a(GraphQLEventWatchStatus.DECLINED);
        this.f11502l = m13414a(GraphQLEventWatchStatus.UNWATCHED);
        this.f11493c = (FbTextView) a(2131561392);
        this.f11494d = (FbTextView) a(2131561393);
        this.f11495e = (FbTextView) a(2131561394);
    }

    public final void m13421a(Event event) {
        this.f11492b = event;
        if (!Event.a(event) || 1 == 0) {
            this.f11493c.setText(2131237270);
            this.f11494d.setText(2131237267);
            this.f11495e.setText(2131237271);
            m13420b();
            return;
        }
        this.f11493c.setText(2131237268);
        this.f11493c.setOnClickListener(this.f11499i);
        this.f11494d.setText(2131237270);
        this.f11494d.setOnClickListener(this.f11500j);
        this.f11495e.setText(2131237269);
        this.f11495e.setOnClickListener(this.f11502l);
    }

    private void m13420b() {
        this.f11493c.setOnClickListener(this.f11496f);
        this.f11494d.setOnClickListener(this.f11497g);
        this.f11495e.setOnClickListener(this.f11498h);
    }

    public void setRsvpActionListener(RsvpActionListener rsvpActionListener) {
        this.f11503m = rsvpActionListener;
    }

    private OnClickListener m13413a(final GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventRowInlineRsvpView f11488b;

            public void onClick(View view) {
                Logger.a(2, EntryType.UI_INPUT_END, -1886831249, Logger.a(2, EntryType.UI_INPUT_START, 1312443939));
            }
        };
    }

    private OnClickListener m13414a(final GraphQLEventWatchStatus graphQLEventWatchStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventRowInlineRsvpView f11490b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -269277310);
                if (this.f11490b.f11503m != null) {
                    ActionMechanism actionMechanism = ActionMechanism.DASHBOARD_ROW_INLINE_ACTIONS;
                }
                Logger.a(2, EntryType.UI_INPUT_END, -828273677, a);
            }
        };
    }

    private void m13417a(EventsConnectionExperimentController eventsConnectionExperimentController) {
        this.f11491a = eventsConnectionExperimentController;
    }
}
