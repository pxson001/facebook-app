package com.facebook.events.permalink.relationshipbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.connectionqe.EventsConnectionStyleExperiment.PublicEventAction;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.permalink.interestednux.InterestedNuxController;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_settings_perf_fetch_data */
public class EventRelationshipBar extends AbstractRelationshipBar {
    @Inject
    public EventsConnectionExperimentController f18843c;
    @Inject
    public PrivateEventsRsvpMutator f18844d;
    @Inject
    public PublicEventsRsvpMutator f18845e;
    @Inject
    public InterestedNuxController f18846f;
    private FbButton f18847g;
    private FbButton f18848h;
    private FbButton f18849i;
    private FbButton[] f18850j;
    public OnClickListener f18851k;
    public OnClickListener f18852l;
    public OnClickListener f18853m;
    public OnClickListener f18854n;
    public OnClickListener f18855o;
    public OnClickListener f18856p;
    private boolean f18857q;
    public EventAnalyticsParams f18858r;
    public Event f18859s;
    @Nullable
    public FetchEventPermalinkFragmentModel f18860t;

    /* compiled from: background_location_settings_perf_fetch_data */
    public /* synthetic */ class C26783 {
        public static final /* synthetic */ int[] f18842a = new int[PublicEventAction.values().length];

        static {
            try {
                f18842a[PublicEventAction.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18842a[PublicEventAction.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18842a[PublicEventAction.PRIVATE_NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18842a[PublicEventAction.WATCH_INTERESTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18842a[PublicEventAction.GOING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18842a[PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void m19130a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventRelationshipBar eventRelationshipBar = (EventRelationshipBar) obj;
        EventsConnectionExperimentController a = EventsConnectionExperimentController.a(fbInjector);
        PrivateEventsRsvpMutator b = PrivateEventsRsvpMutator.b(fbInjector);
        PublicEventsRsvpMutator b2 = PublicEventsRsvpMutator.b(fbInjector);
        InterestedNuxController b3 = InterestedNuxController.m18900b(fbInjector);
        eventRelationshipBar.f18843c = a;
        eventRelationshipBar.f18844d = b;
        eventRelationshipBar.f18845e = b2;
        eventRelationshipBar.f18846f = b3;
    }

    public EventRelationshipBar(Context context) {
        super(context);
        m19129a();
    }

    private void m19129a() {
        Class cls = EventRelationshipBar.class;
        m19130a(this, getContext());
        setContentView(2130904090);
        this.f18851k = m19127a(GraphQLEventGuestStatus.GOING);
        this.f18852l = m19127a(GraphQLEventGuestStatus.MAYBE);
        this.f18853m = m19127a(GraphQLEventGuestStatus.NOT_GOING);
        this.f18854n = m19128a(GraphQLEventWatchStatus.WATCHED);
        this.f18855o = m19128a(GraphQLEventWatchStatus.GOING);
        this.f18856p = m19128a(GraphQLEventWatchStatus.UNWATCHED);
        this.f18847g = (FbButton) a(2131561371);
        this.f18848h = (FbButton) a(2131561372);
        this.f18849i = (FbButton) a(2131561373);
        this.f18850j = new FbButton[]{this.f18847g, this.f18848h, this.f18849i};
    }

    private OnClickListener m19127a(final GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventRelationshipBar f18839b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1132296194);
                if (this.f18839b.f18860t != null) {
                    this.f18839b.f18844d.a(this.f18839b.f18860t, graphQLEventGuestStatus, this.f18839b.f18858r, ActionMechanism.PERMALINK_RELATIONSHIP_BAR);
                } else {
                    this.f18839b.f18844d.a(this.f18839b.f18859s.a, graphQLEventGuestStatus, this.f18839b.f18858r, ActionMechanism.PERMALINK_RELATIONSHIP_BAR);
                }
                LogUtils.a(1096258216, a);
            }
        };
    }

    private OnClickListener m19128a(final GraphQLEventWatchStatus graphQLEventWatchStatus) {
        return new OnClickListener(this) {
            final /* synthetic */ EventRelationshipBar f18841b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1558798811);
                if (this.f18841b.f18860t != null) {
                    this.f18841b.f18845e.a(this.f18841b.f18860t, graphQLEventWatchStatus, this.f18841b.f18858r, ActionMechanism.PERMALINK_RELATIONSHIP_BAR);
                } else {
                    this.f18841b.f18845e.a(this.f18841b.f18859s.a, graphQLEventWatchStatus, this.f18841b.f18858r, ActionMechanism.PERMALINK_RELATIONSHIP_BAR);
                }
                LogUtils.a(776192098, a);
            }
        };
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18857q && this.f18846f.m18902a()) {
            this.f18846f.m18901a(this.f18847g);
        }
    }

    public final void mo849a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams) {
        EventUser eventUser = event.ai;
        if (eventUser != null) {
            setSocialSentence(this.f18823a.a(eventUser.c, event.m, event.l));
        }
        this.f18859s = event;
        this.f18860t = fetchEventPermalinkFragmentModel;
        this.f18858r = eventAnalyticsParams;
        if (!Event.a(event) || 1 == 0) {
            this.f18847g.setText(2131237059);
            this.f18847g.setOnClickListener(this.f18851k);
            this.f18848h.setText(2131237060);
            this.f18848h.setOnClickListener(this.f18852l);
            this.f18849i.setText(2131237061);
            this.f18849i.setOnClickListener(this.f18853m);
            return;
        }
        ImmutableList b = EventsConnectionExperimentController.b();
        for (int i = 0; i < this.f18850j.length; i++) {
            int i2;
            OnClickListener onClickListener;
            FbButton fbButton = this.f18850j[i];
            PublicEventAction publicEventAction = (PublicEventAction) b.get(i);
            switch (C26783.f18842a[publicEventAction.ordinal()]) {
                case 1:
                    i2 = 2131237059;
                    break;
                case 2:
                    i2 = 2131237060;
                    break;
                case 3:
                    i2 = 2131237061;
                    break;
                case 4:
                    i2 = 2131237062;
                    break;
                case 5:
                    i2 = 2131237059;
                    break;
                case 6:
                    i2 = 2131237063;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            fbButton.setText(i2);
            switch (C26783.f18842a[publicEventAction.ordinal()]) {
                case 1:
                    onClickListener = this.f18851k;
                    break;
                case 2:
                    onClickListener = this.f18852l;
                    break;
                case 3:
                    onClickListener = this.f18853m;
                    break;
                case 4:
                    onClickListener = this.f18854n;
                    break;
                case 5:
                    onClickListener = this.f18855o;
                    break;
                case 6:
                    onClickListener = this.f18856p;
                    break;
                default:
                    onClickListener = null;
                    break;
            }
            fbButton.setOnClickListener(onClickListener);
            if (publicEventAction == PublicEventAction.WATCH_INTERESTED) {
                this.f18857q = true;
            }
        }
    }
}
