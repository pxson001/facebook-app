package com.facebook.groups.widget.groupeventrow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.events.model.Event;
import com.facebook.events.widget.eventcard.EventActionButtonState;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: THREADS */
public class GroupEventRsvpStatusIconView extends ImageView implements EventsRsvpActionListener {
    @Inject
    public EventActionButtonStateSelectorProvider f23252a;
    private GroupEventRsvpViewListener f23253b;
    private Event f23254c;
    private EventActionButtonStateSelector f23255d;

    private static <T extends View> void m24584a(Class<T> cls, T t) {
        m24585a((Object) t, t.getContext());
    }

    private static void m24585a(Object obj, Context context) {
        ((GroupEventRsvpStatusIconView) obj).f23252a = (EventActionButtonStateSelectorProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class);
    }

    public GroupEventRsvpStatusIconView(Context context) {
        super(context);
        m24582a();
    }

    public GroupEventRsvpStatusIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24582a();
    }

    public GroupEventRsvpStatusIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24582a();
    }

    private void m24582a() {
        m24584a(GroupEventRsvpStatusIconView.class, (View) this);
        this.f23255d = this.f23252a.a(this);
    }

    public final void m24586a(Event event, GroupEventRsvpViewListener groupEventRsvpViewListener) {
        this.f23254c = event;
        if (this.f23253b == null && groupEventRsvpViewListener != null) {
            this.f23253b = groupEventRsvpViewListener;
        }
        EventActionButtonState a = this.f23255d.a(event.l, event.D(), event.C);
        if (a == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setImageDrawable(a.a);
        setContentDescription(a.b);
        setOnClickListener(a.c);
    }

    public final void m24587a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        if (this.f23253b != null) {
            this.f23253b.mo958a(this.f23254c, graphQLEventGuestStatus2);
        }
    }

    public final void m24588a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        if (this.f23253b != null) {
            this.f23253b.mo959a(this.f23254c, graphQLEventWatchStatus2);
        }
    }

    private void m24583a(EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider) {
        this.f23252a = eventActionButtonStateSelectorProvider;
    }
}
