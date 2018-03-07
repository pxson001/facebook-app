package com.facebook.events.widget.eventrow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.events.widget.eventcard.EventActionButtonState;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: header_card_instantiated */
public class EventRowView extends CustomLinearLayout implements OnClickListener, EventsRsvpActionListener {
    @Inject
    public Resources f11519a;
    @Inject
    public EventsDashboardTimeFormatUtil f11520b;
    @Inject
    PrivateEventsRsvpMutator f11521c;
    @Inject
    PublicEventsRsvpMutator f11522d;
    @Inject
    EventPermalinkIntentBuilder f11523e;
    @Inject
    public EventSocialContextFormatter f11524f;
    @Inject
    EventsConnectionExperimentController f11525g;
    @Inject
    EventActionButtonStateSelectorProvider f11526h;
    @Inject
    TasksManager f11527i;
    public EventRowProfilePictureView f11528j = ((EventRowProfilePictureView) a(2131561396));
    public FbTextView f11529k = ((FbTextView) a(2131561397));
    public FbTextView f11530l = ((FbTextView) a(2131561398));
    public FbTextView f11531m = ((FbTextView) a(2131561399));
    public FbTextView f11532n = ((FbTextView) a(2131561400));
    public ImageBlockLayout f11533o = ((ImageBlockLayout) a(2131561395));
    public ImageView f11534p = ((ImageView) a(2131561401));
    public int f11535q = this.f11533o.w;
    private EventRowViewUpdateRsvpStatusListener f11536r;
    public EventRowInlineRsvpView f11537s;
    public Event f11538t;
    public EventAnalyticsParams f11539u;
    public Context f11540v = getContext();

    /* compiled from: header_card_instantiated */
    public interface EventRowViewUpdateRsvpStatusListener {
        void m13433a(String str, Event event);
    }

    public static void m13436a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventRowView) obj).m13434a(ResourcesMethodAutoProvider.a(injectorLike), EventsDashboardTimeFormatUtil.a(injectorLike), PrivateEventsRsvpMutator.b(injectorLike), PublicEventsRsvpMutator.b(injectorLike), EventPermalinkIntentBuilder.m13395a(injectorLike), EventSocialContextFormatter.m13402b(injectorLike), EventsConnectionExperimentController.a(injectorLike), (EventActionButtonStateSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), TasksManager.b(injectorLike));
    }

    public EventRowView(Context context) {
        super(context);
        Class cls = EventRowView.class;
        m13436a((Object) this, getContext());
        setContentView(2130904098);
        setOrientation(1);
        setBackgroundResource(2130839531);
        setBackgroundResource(2131361920);
    }

    public final void m13438a(Event event, EventAnalyticsParams eventAnalyticsParams, boolean z, EventRowViewUpdateRsvpStatusListener eventRowViewUpdateRsvpStatusListener, boolean z2) {
        boolean z3;
        Object obj;
        this.f11538t = event;
        this.f11539u = eventAnalyticsParams;
        setOnClickListener(this);
        if (this.f11533o.w > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 != z) {
            int i;
            ImageBlockLayout imageBlockLayout = this.f11533o;
            if (z) {
                i = this.f11535q;
            } else {
                i = 0;
            }
            imageBlockLayout.a(0, i, 0, 0);
        }
        this.f11536r = eventRowViewUpdateRsvpStatusListener;
        this.f11528j.m13428a(this.f11538t, this.f11539u.d);
        this.f11529k.setText(this.f11538t.b);
        this.f11530l.setText(this.f11520b.a(this.f11538t.M, this.f11538t.J(), this.f11538t.L()));
        this.f11531m.setVisibility(0);
        if (!StringUtil.a(this.f11538t.P)) {
            this.f11531m.setText(this.f11538t.P);
        } else if (StringUtil.a(this.f11538t.Q)) {
            this.f11531m.setVisibility(8);
        } else {
            this.f11531m.setText(this.f11538t.Q);
        }
        if (z2) {
            this.f11532n.setVisibility(8);
        } else {
            CharSequence a = this.f11524f.m13407a(this.f11538t);
            if (StringUtil.a(a)) {
                this.f11532n.setVisibility(8);
            } else {
                this.f11532n.setVisibility(0);
                this.f11532n.setText(a);
                this.f11532n.setTextColor(getResources().getColor(this.f11538t.y ? 2131361917 : 2131361974));
            }
        }
        m13437d(z2);
        Event event2 = this.f11538t;
        if (z2 || event2.a(EventViewerCapability.ADMIN) || !event2.G) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f11537s == null) {
                this.f11537s = (EventRowInlineRsvpView) ((ViewStub) a(2131561402)).inflate();
            }
            this.f11537s.setVisibility(0);
            this.f11537s.m13421a(this.f11538t);
        } else if (this.f11537s != null) {
            this.f11537s.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1810543100);
        this.f11523e.m13397a(this.f11540v, this.f11538t.a, this.f11539u.b);
        Logger.a(2, EntryType.UI_INPUT_END, -1665011797, a);
    }

    public final void m13439a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        ListenableFuture a = this.f11521c.a(this.f11538t.a, graphQLEventGuestStatus2, this.f11539u, ActionMechanism.EVENTS_LIST, null);
        final Event event = this.f11538t;
        Builder builder = new Builder(this.f11538t);
        builder.B = graphQLEventGuestStatus2;
        this.f11536r.m13433a(this.f11538t.a, builder.b());
        this.f11527i.a(this, a, new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ EventRowView f11516b;

            protected final void m13429a(Object obj) {
            }

            protected final void m13430a(Throwable th) {
                EventRowView.m13435a(this.f11516b, event);
            }
        });
    }

    public final void m13440a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        ListenableFuture a = this.f11522d.a(this.f11538t.a, graphQLEventWatchStatus2, this.f11539u, ActionMechanism.EVENTS_LIST);
        final Event event = this.f11538t;
        Builder builder = new Builder(this.f11538t);
        builder.G = false;
        builder = builder;
        builder.C = graphQLEventWatchStatus2;
        this.f11536r.m13433a(this.f11538t.a, builder.b());
        this.f11527i.a(this, a, new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ EventRowView f11518b;

            protected final void m13431a(Object obj) {
            }

            protected final void m13432a(Throwable th) {
                EventRowView.m13435a(this.f11518b, event);
            }
        });
    }

    private void m13434a(Resources resources, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, EventPermalinkIntentBuilder eventPermalinkIntentBuilder, EventSocialContextFormatter eventSocialContextFormatter, EventsConnectionExperimentController eventsConnectionExperimentController, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, TasksManager tasksManager) {
        this.f11519a = resources;
        this.f11520b = eventsDashboardTimeFormatUtil;
        this.f11521c = privateEventsRsvpMutator;
        this.f11522d = publicEventsRsvpMutator;
        this.f11523e = eventPermalinkIntentBuilder;
        this.f11524f = eventSocialContextFormatter;
        this.f11525g = eventsConnectionExperimentController;
        this.f11526h = eventActionButtonStateSelectorProvider;
        this.f11527i = tasksManager;
    }

    private void m13437d(boolean z) {
        if (z) {
            this.f11534p.setVisibility(8);
            return;
        }
        this.f11534p.setVisibility(0);
        if (1 == 0 || !Event.a(this.f11538t)) {
            Drawable a;
            GraphQLEventGuestStatus graphQLEventGuestStatus;
            GlyphColorizer glyphColorizer = new GlyphColorizer(this.f11519a);
            final GraphQLEventGuestStatus D = this.f11538t.D();
            if (D == GraphQLEventGuestStatus.GOING) {
                a = glyphColorizer.a(2130839849, -1);
                this.f11534p.setBackgroundResource(2130839528);
                graphQLEventGuestStatus = GraphQLEventGuestStatus.NOT_GOING;
            } else {
                a = glyphColorizer.a(2130839847, -1);
                this.f11534p.setBackgroundResource(2130839529);
                graphQLEventGuestStatus = GraphQLEventGuestStatus.GOING;
            }
            this.f11534p.setImageDrawable(a);
            this.f11534p.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EventRowView f11514c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -2112476662);
                    this.f11514c.m13439a(D, graphQLEventGuestStatus);
                    Logger.a(2, EntryType.UI_INPUT_END, -1278971290, a);
                }
            });
            return;
        }
        EventActionButtonState a2 = this.f11526h.a(this).a(this.f11538t.l, this.f11538t.D(), this.f11538t.C);
        this.f11534p.setImageDrawable(a2.a);
        this.f11534p.setContentDescription(a2.b);
        this.f11534p.setOnClickListener(a2.c);
    }

    public static void m13435a(EventRowView eventRowView, Event event) {
        eventRowView.f11536r.m13433a(eventRowView.f11538t.a, event);
    }
}
