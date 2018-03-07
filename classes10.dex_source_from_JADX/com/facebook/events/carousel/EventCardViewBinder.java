package com.facebook.events.carousel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.RsvpChangeEvent;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment.CoverPhoto;
import com.facebook.events.graphql.EventsGraphQLModels.EventCardFragmentModel.CoverPhotoModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Objects;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: contacts_upload_on */
public class EventCardViewBinder {
    private static final CallerContext f15975a = CallerContext.a(EventCardViewBinder.class, "event_dashboard_all_upcoming");
    public List<? extends EventCardRemover> f15976A;
    public final RsvpChangeEventSubscriber f15977B = new RsvpChangeEventSubscriber(this);
    public final Context f15978b;
    public final EventAnalyticsParams f15979c;
    public final DraweeController f15980d;
    public final PointF f15981e;
    public final Resources f15982f;
    public final EventActionButtonStateSelector f15983g;
    public final PrivateEventsRsvpMutator f15984h;
    public final PublicEventsRsvpMutator f15985i;
    private final EventsCardViewTimeFormatUtil f15986j;
    public final EventsEventBus f15987k;
    private final Provider<FbDraweeControllerBuilder> f15988l;
    private final EventSocialContextFormatter f15989m;
    public Event f15990n;
    public CharSequence f15991o;
    public Date f15992p;
    public CharSequence f15993q;
    public CharSequence f15994r;
    public CharSequence f15995s;
    public GraphQLEventGuestStatus f15996t;
    public GraphQLConnectionStyle f15997u;
    public GraphQLEventWatchStatus f15998v;
    public EventsCardView f15999w;
    public ActionMechanism f16000x;
    public EventsCarouselPagerAdapter f16001y;
    public String f16002z;

    /* compiled from: contacts_upload_on */
    public class C22321 implements OnClickListener {
        final /* synthetic */ View f15969a;
        final /* synthetic */ EventCardViewBinder f15970b;

        public C22321(EventCardViewBinder eventCardViewBinder, View view) {
            this.f15970b = eventCardViewBinder;
            this.f15969a = view;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -475922285);
            if (this.f15970b.f15976A == null || this.f15970b.f15976A.isEmpty()) {
                Logger.a(2, EntryType.UI_INPUT_END, -396810246, a);
                return;
            }
            if (this.f15970b.f15976A.size() == 1) {
                EventCardRemover eventCardRemover = (EventCardRemover) this.f15970b.f15976A.get(0);
                if (this.f15970b.f16001y != null) {
                    this.f15970b.f16001y.m16431a(this.f15970b, eventCardRemover);
                }
                eventCardRemover.mo798a(this.f15970b.f15990n);
                this.f15969a.setContentDescription(eventCardRemover.mo797a(this.f15970b.f15978b, this.f15970b.f15990n));
            } else {
                EventCardViewBinder eventCardViewBinder = this.f15970b;
                View view2 = this.f15969a;
                FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(eventCardViewBinder.f15978b);
                figPopoverMenuWindow.e = false;
                PopoverMenu c = figPopoverMenuWindow.c();
                for (EventCardRemover eventCardRemover2 : eventCardViewBinder.f15976A) {
                    c.a(eventCardRemover2.mo797a(eventCardViewBinder.f15978b, eventCardViewBinder.f15990n)).setOnMenuItemClickListener(new C22332(eventCardViewBinder, eventCardRemover2));
                }
                figPopoverMenuWindow.f(view2);
                this.f15969a.setContentDescription(this.f15970b.f15982f.getString(2131236895));
            }
            LogUtils.a(-1656259065, a);
        }
    }

    /* compiled from: contacts_upload_on */
    public class C22332 implements OnMenuItemClickListener {
        final /* synthetic */ EventCardRemover f15971a;
        final /* synthetic */ EventCardViewBinder f15972b;

        public C22332(EventCardViewBinder eventCardViewBinder, EventCardRemover eventCardRemover) {
            this.f15972b = eventCardViewBinder;
            this.f15971a = eventCardRemover;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f15972b.f16001y != null) {
                this.f15972b.f16001y.m16431a(this.f15972b, this.f15971a);
            }
            this.f15971a.mo798a(this.f15972b.f15990n);
            return true;
        }
    }

    /* compiled from: contacts_upload_on */
    class EventCardBindRsvpActionListener implements EventsRsvpActionListener {
        final /* synthetic */ EventCardViewBinder f15973a;

        public EventCardBindRsvpActionListener(EventCardViewBinder eventCardViewBinder) {
            this.f15973a = eventCardViewBinder;
        }

        public final void m16409a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
            Builder builder = new Builder(this.f15973a.f15990n);
            EventCardViewBinder eventCardViewBinder = this.f15973a;
            builder.B = graphQLEventGuestStatus2;
            eventCardViewBinder.f15990n = builder.b();
            EventCardViewBinder.m16414c(this.f15973a);
            this.f15973a.f15984h.a(this.f15973a.f15990n.a, graphQLEventGuestStatus2, this.f15973a.f15979c.c, this.f15973a.f15979c.d, this.f15973a.f16000x, this.f15973a.f16002z);
        }

        public final void m16410a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
            Builder builder = new Builder(this.f15973a.f15990n);
            EventCardViewBinder eventCardViewBinder = this.f15973a;
            builder.G = false;
            builder = builder;
            builder.C = graphQLEventWatchStatus2;
            eventCardViewBinder.f15990n = builder.b();
            EventCardViewBinder.m16414c(this.f15973a);
            this.f15973a.f15985i.a(this.f15973a.f15990n.a, graphQLEventWatchStatus2, this.f15973a.f15979c, this.f15973a.f16000x);
        }
    }

    /* compiled from: contacts_upload_on */
    class RsvpChangeEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.RsvpChangeEventSubscriber {
        final /* synthetic */ EventCardViewBinder f15974a;

        public RsvpChangeEventSubscriber(EventCardViewBinder eventCardViewBinder) {
            this.f15974a = eventCardViewBinder;
        }

        public final void m16411b(FbEvent fbEvent) {
            RsvpChangeEvent rsvpChangeEvent = (RsvpChangeEvent) fbEvent;
            if (this.f15974a.f15990n != null && Objects.equal(this.f15974a.f15990n.a, rsvpChangeEvent.c.a)) {
                if (rsvpChangeEvent.a == EventStatus.FAILURE) {
                    this.f15974a.f15990n = rsvpChangeEvent.b;
                } else {
                    this.f15974a.f15990n = rsvpChangeEvent.c;
                }
                EventCardViewBinder.m16414c(this.f15974a);
            }
        }
    }

    @Inject
    public EventCardViewBinder(@Assisted Event event, @Assisted CoverPhoto coverPhoto, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted List<? extends EventCardRemover> list, Context context, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, EventsCardViewTimeFormatUtil eventsCardViewTimeFormatUtil, EventsEventBus eventsEventBus, Provider<FbDraweeControllerBuilder> provider, EventSocialContextFormatter eventSocialContextFormatter, Resources resources) {
        ActionSource actionSource;
        this.f15982f = resources;
        if (eventAnalyticsParams.b.a() == ActionSource.DASHBOARD) {
            actionSource = ActionSource.MOBILE_SUGGESTIONS_DASHBOARD;
        } else {
            actionSource = eventAnalyticsParams.b.a();
        }
        this.f15979c = eventAnalyticsParams.a(actionSource);
        this.f15976A = list;
        this.f15983g = eventActionButtonStateSelectorProvider.a(new EventCardBindRsvpActionListener(this));
        this.f15984h = privateEventsRsvpMutator;
        this.f15985i = publicEventsRsvpMutator;
        this.f15986j = eventsCardViewTimeFormatUtil;
        this.f15987k = eventsEventBus;
        this.f15988l = provider;
        this.f15978b = context;
        this.f15989m = eventSocialContextFormatter;
        this.f15980d = m16412a((CoverPhotoModel) coverPhoto);
        this.f15981e = m16413b(coverPhoto);
        m16416a(event);
    }

    public final void m16416a(Event event) {
        String str;
        this.f15990n = event;
        this.f15991o = this.f15990n.b;
        this.f15992p = this.f15990n.J();
        if (!StringUtil.a(this.f15990n.P)) {
            str = this.f15990n.P;
        } else if (StringUtil.a(this.f15990n.Q)) {
            str = null;
        } else {
            str = this.f15990n.Q;
        }
        this.f15993q = str;
        if (StringUtil.a(this.f15990n.T)) {
            str = null;
        } else {
            str = this.f15990n.T;
        }
        this.f15994r = str;
        this.f15995s = this.f15989m.a(this.f15990n);
        this.f15996t = event.D();
        this.f15998v = event.C;
        this.f15997u = event.l;
    }

    public final void m16415a() {
        this.f15987k.b(this.f15977B);
        if (this.f15999w != null) {
            this.f15999w.setCoverPhotoController(null);
            this.f15999w.g.setOnClickListener(null);
            this.f15999w.h.setOnClickListener(null);
            this.f15999w = null;
        }
        this.f16001y = null;
    }

    public static void m16414c(EventCardViewBinder eventCardViewBinder) {
        if (eventCardViewBinder.f15999w != null) {
            eventCardViewBinder.f15999w.g.a(eventCardViewBinder.f15983g.a(eventCardViewBinder.f15990n.l, eventCardViewBinder.f15990n.D(), eventCardViewBinder.f15990n.C));
        }
    }

    private DraweeController m16412a(CoverPhotoModel coverPhotoModel) {
        if (coverPhotoModel == null || coverPhotoModel.b() == null || coverPhotoModel.b().dO_() == null) {
            return ((FbDraweeControllerBuilder) this.f15988l.get()).a(f15975a).s();
        }
        DefaultImageFields dO_ = coverPhotoModel.b().dO_();
        DefaultImageFields g = coverPhotoModel.b().g();
        return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f15988l.get()).a(f15975a).a(dO_.b()).d(ImageRequest.a(g != null ? UriUtil.a(g.b()) : null))).s();
    }

    private static PointF m16413b(CoverPhotoModel coverPhotoModel) {
        if (coverPhotoModel == null) {
            return null;
        }
        DefaultVect2Fields a = coverPhotoModel.a();
        if (a != null) {
            return new PointF((float) a.a(), (float) a.b());
        }
        return null;
    }
}
