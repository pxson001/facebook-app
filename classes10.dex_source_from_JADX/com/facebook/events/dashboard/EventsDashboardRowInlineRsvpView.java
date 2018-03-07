package com.facebook.events.dashboard;

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

/* compiled from: com.google.android.location.intent.extra.transition */
public class EventsDashboardRowInlineRsvpView extends SegmentedLinearLayout {
    @Inject
    public EventsConnectionExperimentController f16708a;
    public Event f16709b;
    private FbTextView f16710c;
    private FbTextView f16711d;
    private FbTextView f16712e;
    private OnClickListener f16713f;
    private OnClickListener f16714g;
    private OnClickListener f16715h;
    private OnClickListener f16716i;
    private OnClickListener f16717j;
    private OnClickListener f16718k;
    public RsvpActionListener f16719l;

    /* compiled from: com.google.android.location.intent.extra.transition */
    public interface RsvpActionListener {
        void mo790a(Event event, ActionMechanism actionMechanism, GraphQLEventWatchStatus graphQLEventWatchStatus);

        void mo791a(Event event, GraphQLEventGuestStatus graphQLEventGuestStatus);
    }

    private static <T extends View> void m17107a(Class<T> cls, T t) {
        m17108a((Object) t, t.getContext());
    }

    private static void m17108a(Object obj, Context context) {
        ((EventsDashboardRowInlineRsvpView) obj).f16708a = EventsConnectionExperimentController.a(FbInjector.get(context));
    }

    public EventsDashboardRowInlineRsvpView(Context context) {
        super(context);
        m17105a();
    }

    public EventsDashboardRowInlineRsvpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17105a();
    }

    private void m17106a(EventsConnectionExperimentController eventsConnectionExperimentController) {
        this.f16708a = eventsConnectionExperimentController;
    }

    private void m17105a() {
        m17107a(EventsDashboardRowInlineRsvpView.class, (View) this);
        setContentView(2130904132);
        this.f16713f = m17102a(GraphQLEventGuestStatus.GOING);
        this.f16714g = m17102a(GraphQLEventGuestStatus.MAYBE);
        this.f16715h = m17102a(GraphQLEventGuestStatus.NOT_GOING);
        this.f16716i = m17103a(GraphQLEventWatchStatus.WATCHED);
        this.f16717j = m17103a(GraphQLEventWatchStatus.GOING);
        this.f16718k = m17103a(GraphQLEventWatchStatus.UNWATCHED);
        this.f16710c = (FbTextView) a(2131561515);
        this.f16711d = (FbTextView) a(2131561516);
        this.f16712e = (FbTextView) a(2131561517);
    }

    public final void m17112a(Event event) {
        this.f16709b = event;
        if (!Event.a(event) || 1 == 0) {
            this.f16710c.setText(2131237022);
            this.f16711d.setText(2131237023);
            this.f16712e.setText(2131237025);
            m17110b();
            return;
        }
        this.f16710c.setText(2131237204);
        this.f16711d.setText(2131237022);
        this.f16712e.setText(2131237026);
        m17111c();
    }

    private void m17110b() {
        this.f16710c.setOnClickListener(this.f16713f);
        this.f16711d.setOnClickListener(this.f16714g);
        this.f16712e.setOnClickListener(this.f16715h);
    }

    private void m17111c() {
        this.f16710c.setOnClickListener(this.f16716i);
        this.f16711d.setOnClickListener(this.f16717j);
        this.f16712e.setOnClickListener(this.f16718k);
    }

    public void setRsvpActionListener(RsvpActionListener rsvpActionListener) {
        this.f16719l = rsvpActionListener;
    }

    private OnClickListener m17102a(final GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventsDashboardRowInlineRsvpView f16705b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 601679446);
                if (this.f16705b.f16719l != null) {
                    this.f16705b.f16719l.mo791a(this.f16705b.f16709b, graphQLEventGuestStatus);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1389026847, a);
            }
        };
    }

    private OnClickListener m17103a(final GraphQLEventWatchStatus graphQLEventWatchStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventsDashboardRowInlineRsvpView f16707b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1244780809);
                if (this.f16707b.f16719l != null) {
                    this.f16707b.f16719l.mo790a(this.f16707b.f16709b, ActionMechanism.DASHBOARD_ROW_INLINE_ACTIONS, graphQLEventWatchStatus);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1968137551, a);
            }
        };
    }
}
