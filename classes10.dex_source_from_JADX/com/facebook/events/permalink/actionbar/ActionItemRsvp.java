package com.facebook.events.permalink.actionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.connectionqe.EventsConnectionStyleExperiment.PublicEventAction;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventIgnoredEvent;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.eventsevents.EventsEvents.RespondingInviteEvent;
import com.facebook.events.eventsevents.EventsEvents.RsvpChangeEvent;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.EventRsvpMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.events.protocol.EventsQueries;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.EventRsvpInputData;
import com.facebook.graphql.calls.EventRsvpInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventRsvpInputData.GuestStatus;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: calling_intent */
public class ActionItemRsvp {
    private static final List<GraphQLEventGuestStatus> f18027c = ImmutableList.of(GraphQLEventGuestStatus.GOING, GraphQLEventGuestStatus.MAYBE, GraphQLEventGuestStatus.NOT_GOING);
    protected DefaultBlueServiceOperationFactory f18028a;
    public TasksManager f18029b;
    public Event f18030d;
    public EventAnalyticsParams f18031e;
    public Context f18032f;
    public EventsEventBus f18033g;
    public ContentResolver f18034h;
    public EventsCommonContract f18035i;
    public ListeningExecutorService f18036j;
    public EventsQueries f18037k;
    private GlyphColorizer f18038l;
    private GraphQLQueryExecutor f18039m;
    private BookmarkManager f18040n;
    private EventsConnectionExperimentController f18041o;
    private final PrivateEventsRsvpMutator f18042p;
    public final PublicEventsRsvpMutator f18043q;
    public Toaster f18044r;

    /* compiled from: calling_intent */
    public class C25546 extends AbstractDisposableFutureCallback {
        final /* synthetic */ boolean f18016a;
        final /* synthetic */ Event f18017b;
        final /* synthetic */ Event f18018c;
        final /* synthetic */ ActionItemRsvp f18019d;

        public C25546(ActionItemRsvp actionItemRsvp, boolean z, Event event, Event event2) {
            this.f18019d = actionItemRsvp;
            this.f18016a = z;
            this.f18017b = event;
            this.f18018c = event2;
        }

        protected final void m18384a(Object obj) {
        }

        protected final void m18385a(Throwable th) {
            if (this.f18016a) {
                this.f18019d.f18033g.a(new EventIgnoredEvent(this.f18017b, true));
            }
            EventsProvider.a(this.f18019d.f18034h, this.f18019d.f18035i, this.f18018c, this.f18019d.f18036j);
        }
    }

    /* compiled from: calling_intent */
    /* synthetic */ class C25557 {
        static final /* synthetic */ int[] f18020a = new int[GraphQLEventGuestStatus.values().length];
        static final /* synthetic */ int[] f18021b = new int[PublicEventAction.values().length];

        static {
            try {
                f18021b[PublicEventAction.WATCH_INTERESTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18021b[PublicEventAction.GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18021b[PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18020a[GraphQLEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18020a[GraphQLEventGuestStatus.MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18020a[GraphQLEventGuestStatus.NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: calling_intent */
    class GuestStatusOnClickListener implements OnMenuItemClickListener {
        final /* synthetic */ ActionItemRsvp f18022a;
        private final GraphQLEventGuestStatus f18023b;
        private final GraphQLEventGuestStatus f18024c;
        private ActionMechanism f18025d;
        private final boolean f18026e;

        GuestStatusOnClickListener(ActionItemRsvp actionItemRsvp, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2, ActionMechanism actionMechanism, boolean z) {
            this.f18022a = actionItemRsvp;
            this.f18023b = graphQLEventGuestStatus;
            this.f18024c = graphQLEventGuestStatus2;
            this.f18025d = actionMechanism;
            this.f18026e = z;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f18023b != this.f18024c) {
                this.f18022a.m18408a(this.f18024c, this.f18025d, this.f18026e);
            }
            return true;
        }
    }

    public static ActionItemRsvp m18397b(InjectorLike injectorLike) {
        return new ActionItemRsvp((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.a(injectorLike), TasksManager.a(injectorLike), EventsEventBus.a(injectorLike), ContentResolverMethodAutoProvider.a(injectorLike), EventsCommonContract.a(injectorLike), GlyphColorizer.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), EventsQueries.m19293a(injectorLike), (BookmarkManager) BookmarkClient.a(injectorLike), EventsConnectionExperimentController.a(injectorLike), PrivateEventsRsvpMutator.a(injectorLike), PublicEventsRsvpMutator.a(injectorLike), Toaster.a(injectorLike));
    }

    public static ActionItemRsvp m18390a(InjectorLike injectorLike) {
        return m18397b(injectorLike);
    }

    @Inject
    public ActionItemRsvp(Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, TasksManager tasksManager, EventsEventBus eventsEventBus, ContentResolver contentResolver, EventsCommonContract eventsCommonContract, GlyphColorizer glyphColorizer, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, EventsQueries eventsQueries, BookmarkManager bookmarkManager, EventsConnectionExperimentController eventsConnectionExperimentController, PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator, Toaster toaster) {
        this.f18032f = context;
        this.f18028a = defaultBlueServiceOperationFactory;
        this.f18039m = graphQLQueryExecutor;
        this.f18029b = tasksManager;
        this.f18033g = eventsEventBus;
        this.f18034h = contentResolver;
        this.f18035i = eventsCommonContract;
        this.f18038l = glyphColorizer;
        this.f18036j = listeningExecutorService;
        this.f18037k = eventsQueries;
        this.f18040n = bookmarkManager;
        this.f18041o = eventsConnectionExperimentController;
        this.f18042p = privateEventsRsvpMutator;
        this.f18043q = publicEventsRsvpMutator;
        this.f18044r = toaster;
    }

    public final void m18406a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        this.f18030d = event;
        this.f18031e = eventAnalyticsParams;
    }

    public final void m18408a(GraphQLEventGuestStatus graphQLEventGuestStatus, ActionMechanism actionMechanism, boolean z) {
        m18396a(graphQLEventGuestStatus, actionMechanism, z, null, null);
    }

    private void m18396a(GraphQLEventGuestStatus graphQLEventGuestStatus, ActionMechanism actionMechanism, boolean z, FutureCallback<EventStatus> futureCallback, String str) {
        Builder builder = new Builder(this.f18030d);
        builder.B = graphQLEventGuestStatus;
        m18409a(graphQLEventGuestStatus, builder.b(), actionMechanism, z, futureCallback, str);
    }

    public final void m18409a(GraphQLEventGuestStatus graphQLEventGuestStatus, Event event, ActionMechanism actionMechanism, boolean z, FutureCallback<EventStatus> futureCallback, String str) {
        if (this.f18030d != null && this.f18030d.D() != graphQLEventGuestStatus) {
            final Event b = new Builder(this.f18030d).b();
            this.f18033g.a(new RsvpChangeEvent(EventStatus.SENDING, b, event));
            m18395a(this, b, EventStatus.SENDING);
            GuestStatus b2 = m18398b(graphQLEventGuestStatus);
            EventsProvider.a(this.f18034h, this.f18035i, event, this.f18036j);
            EventRsvpInputData a = new EventRsvpInputData().a(m18391a(actionMechanism, str)).b(this.f18030d.c()).a(b2);
            if (!TextUtils.isEmpty(this.f18031e.f)) {
                a.a(Arrays.asList(new String[]{this.f18031e.f}));
            }
            final Event event2 = event;
            final boolean z2 = z;
            final FutureCallback<EventStatus> futureCallback2 = futureCallback;
            this.f18029b.a(m18393a(graphQLEventGuestStatus), this.f18039m.a(GraphQLRequest.a((EventRsvpMutationString) EventsMutations.e().a("input", a))), new AbstractDisposableFutureCallback<GraphQLResult<EventRsvpMutationModel>>(this) {
                final /* synthetic */ ActionItemRsvp f18001e;

                protected final void m18382a(Object obj) {
                    this.f18001e.f18033g.a(new EventUpdatedEvent(event2.a));
                    if (z2) {
                        ActionItemRsvp actionItemRsvp = this.f18001e;
                        String str = event2.a;
                        actionItemRsvp.f18037k.m19295a(actionItemRsvp.f18032f.getResources().getDimensionPixelSize(2131431107), str);
                    }
                    if (futureCallback2 != null) {
                        futureCallback2.onSuccess(EventStatus.SUCCESS);
                    }
                }

                protected final void m18383a(Throwable th) {
                    this.f18001e.f18033g.a(new RsvpChangeEvent(EventStatus.FAILURE, b, event2));
                    ActionItemRsvp.m18395a(this.f18001e, b, EventStatus.FAILURE);
                    this.f18001e.f18044r.b(new ToastBuilder(2131237121));
                    EventsProvider.a(this.f18001e.f18034h, this.f18001e.f18035i, b, this.f18001e.f18036j);
                    if (futureCallback2 != null) {
                        futureCallback2.onFailure(th);
                    }
                }
            });
        }
    }

    private EventRsvpInputData.Context m18391a(ActionMechanism actionMechanism, String str) {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.f18031e.c);
        if (!StringUtil.a(this.f18031e.e)) {
            eventActionHistory.b(this.f18031e.e);
        }
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(this.f18031e.d);
        eventActionHistory2.b(actionMechanism.toString());
        if (str != null) {
            eventActionHistory2.c(str);
        }
        EventRsvpInputData.Context context = new EventRsvpInputData.Context();
        context.a(ImmutableList.of(eventActionHistory, eventActionHistory2));
        return context;
    }

    private String m18393a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return "tasks-rsvpEvent:" + this.f18030d.a + ":" + graphQLEventGuestStatus.name();
    }

    public final void m18407a(GraphQLEventGuestStatus graphQLEventGuestStatus, @Nullable View view, @Nonnull View view2, ActionMechanism actionMechanism, boolean z) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18032f);
        PopoverMenu c = figPopoverMenuWindow.c();
        for (GraphQLEventGuestStatus graphQLEventGuestStatus2 : f18027c) {
            MenuItemImpl a = c.a(m18399c(graphQLEventGuestStatus2));
            a.setIcon(m18389a(graphQLEventGuestStatus2, graphQLEventGuestStatus, false));
            a.setCheckable(true);
            a.setChecked(graphQLEventGuestStatus2 == graphQLEventGuestStatus);
            a.setOnMenuItemClickListener(new GuestStatusOnClickListener(this, graphQLEventGuestStatus, graphQLEventGuestStatus2, actionMechanism, z));
        }
        if (view == null) {
            figPopoverMenuWindow.a(view2);
        } else {
            figPopoverMenuWindow.f(view);
        }
    }

    public final void m18402a(@Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nullable GraphQLEventGuestStatus graphQLEventGuestStatus, @Nullable View view, View view2, final ActionMechanism actionMechanism) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18032f);
        PopoverMenu c = figPopoverMenuWindow.c();
        for (final GraphQLEventGuestStatus graphQLEventGuestStatus2 : f18027c) {
            boolean z = graphQLEventGuestStatus2 == graphQLEventGuestStatus;
            MenuItemImpl a = c.a(m18399c(graphQLEventGuestStatus2));
            a.setIcon(m18389a(graphQLEventGuestStatus2, graphQLEventGuestStatus, false));
            a.setCheckable(true);
            a.setChecked(z);
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ ActionItemRsvp f18005d;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f18005d.m18400a(fetchEventPermalinkFragmentModel, graphQLEventGuestStatus2, actionMechanism);
                    return true;
                }
            });
        }
        if (view == null) {
            figPopoverMenuWindow.a(view2);
        } else {
            figPopoverMenuWindow.f(view);
        }
    }

    public final void m18405a(@Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nullable GraphQLEventWatchStatus graphQLEventWatchStatus, @Nullable View view, View view2) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18032f);
        PopoverMenu c = figPopoverMenuWindow.c();
        ImmutableList b = EventsConnectionExperimentController.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            boolean z;
            PublicEventAction publicEventAction = (PublicEventAction) b.get(i);
            final GraphQLEventWatchStatus a = m18392a(publicEventAction);
            if (a == graphQLEventWatchStatus) {
                z = true;
            } else {
                z = false;
            }
            MenuItemImpl a2 = c.a(m18386a(graphQLEventWatchStatus, publicEventAction));
            a2.setIcon(m18388a(publicEventAction, z, false));
            a2.setCheckable(true);
            a2.setChecked(z);
            a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ ActionItemRsvp f18008c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f18008c.m18401a(fetchEventPermalinkFragmentModel, a);
                    return true;
                }
            });
        }
        if (view == null) {
            figPopoverMenuWindow.a(view2);
        } else {
            figPopoverMenuWindow.f(view);
        }
    }

    public final void m18403a(@Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nullable GraphQLEventGuestStatus graphQLEventGuestStatus, final ActionMechanism actionMechanism) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.f18032f);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(this.f18032f);
        for (final GraphQLEventGuestStatus graphQLEventGuestStatus2 : f18027c) {
            if (graphQLEventGuestStatus2 != graphQLEventGuestStatus) {
                bottomSheetAdapter.e(m18399c(graphQLEventGuestStatus2)).setIcon(m18389a(graphQLEventGuestStatus2, graphQLEventGuestStatus, true)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ActionItemRsvp f18012d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f18012d.m18400a(fetchEventPermalinkFragmentModel, graphQLEventGuestStatus2, actionMechanism);
                        return true;
                    }
                });
            }
        }
        bottomSheetDialog.a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    public final void m18404a(@Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.f18032f);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(this.f18032f);
        ImmutableList b = EventsConnectionExperimentController.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            PublicEventAction publicEventAction = (PublicEventAction) b.get(i);
            final GraphQLEventWatchStatus a = m18392a(publicEventAction);
            if (a != graphQLEventWatchStatus) {
                bottomSheetAdapter.e(m18386a(graphQLEventWatchStatus, publicEventAction)).setIcon(m18388a(publicEventAction, false, true)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ActionItemRsvp f18015c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f18015c.m18401a(fetchEventPermalinkFragmentModel, a);
                        return true;
                    }
                });
            }
        }
        bottomSheetDialog.a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    public final void m18400a(@Nullable EventCommonFragment eventCommonFragment, GraphQLEventGuestStatus graphQLEventGuestStatus, ActionMechanism actionMechanism) {
        if (eventCommonFragment == null) {
            this.f18042p.a(this.f18030d.a, graphQLEventGuestStatus, this.f18031e, actionMechanism);
        } else {
            this.f18042p.a(eventCommonFragment, graphQLEventGuestStatus, this.f18031e, actionMechanism);
        }
    }

    public final void m18410b(GraphQLEventWatchStatus graphQLEventWatchStatus, ActionMechanism actionMechanism) {
        m18394a(EventGraphQLModelHelper.m19259a(this.f18030d), graphQLEventWatchStatus, actionMechanism);
    }

    private void m18394a(@Nullable EventCommonFragment eventCommonFragment, GraphQLEventWatchStatus graphQLEventWatchStatus, ActionMechanism actionMechanism) {
        if (eventCommonFragment == null) {
            this.f18043q.a(this.f18030d.a, graphQLEventWatchStatus, this.f18031e, actionMechanism);
        } else {
            this.f18043q.a(eventCommonFragment, graphQLEventWatchStatus, this.f18031e, actionMechanism);
        }
    }

    public final void m18401a(@Nullable EventCommonFragment eventCommonFragment, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        m18394a(eventCommonFragment, graphQLEventWatchStatus, ActionMechanism.PERMALINK_ACTION_BAR);
    }

    private static GuestStatus m18398b(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        switch (C25557.f18020a[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                return GuestStatus.GOING;
            case 2:
                return GuestStatus.MAYBE;
            case 3:
                return GuestStatus.NOT_GOING;
            default:
                throw new IllegalArgumentException("Unsupported guest status: " + graphQLEventGuestStatus);
        }
    }

    private static int m18399c(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        switch (C25557.f18020a[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                return 2131237022;
            case 2:
                return 2131237024;
            case 3:
                return 2131237025;
            default:
                throw new IllegalArgumentException("Unsupported rsvp type: " + graphQLEventGuestStatus);
        }
    }

    private static int m18386a(GraphQLEventWatchStatus graphQLEventWatchStatus, PublicEventAction publicEventAction) {
        switch (C25557.f18021b[publicEventAction.ordinal()]) {
            case 1:
                return 2131237204;
            case 2:
                return 2131237022;
            case 3:
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                    return 2131233843;
                }
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
                    return 2131233844;
                }
                return 2131237026;
            default:
                return 0;
        }
    }

    private static GraphQLEventWatchStatus m18392a(PublicEventAction publicEventAction) {
        switch (C25557.f18021b[publicEventAction.ordinal()]) {
            case 1:
                return GraphQLEventWatchStatus.WATCHED;
            case 2:
                return GraphQLEventWatchStatus.GOING;
            case 3:
                return GraphQLEventWatchStatus.UNWATCHED;
            default:
                return null;
        }
    }

    private Drawable m18388a(PublicEventAction publicEventAction, boolean z, boolean z2) {
        switch (C25557.f18021b[publicEventAction.ordinal()]) {
            case 1:
                return z2 ? m18387a(2130840114, z) : m18387a(2130839505, z);
            case 2:
                return z2 ? m18387a(2130839774, z) : m18387a(2130839848, z);
            case 3:
                return m18387a(2130839815, z);
            default:
                throw new IllegalArgumentException("Unsupported rsvp type for icons: " + publicEventAction);
        }
    }

    private Drawable m18387a(int i, boolean z) {
        return z ? this.f18038l.a(i, -10972929) : this.f18032f.getResources().getDrawable(i);
    }

    private Drawable m18389a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2, boolean z) {
        boolean z2 = true;
        switch (C25557.f18020a[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                if (z) {
                    if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                        z2 = false;
                    }
                    return m18387a(2130839774, z2);
                }
                if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                    z2 = false;
                }
                return m18387a(2130838369, z2);
            case 2:
                if (z) {
                    if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                        z2 = false;
                    }
                    return m18387a(2130840064, z2);
                }
                if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                    z2 = false;
                }
                return m18387a(2130838372, z2);
            case 3:
                if (z) {
                    if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                        z2 = false;
                    }
                    return m18387a(2130839815, z2);
                }
                if (graphQLEventGuestStatus != graphQLEventGuestStatus2) {
                    z2 = false;
                }
                return m18387a(2130838358, z2);
            default:
                throw new IllegalArgumentException("Unsupported rsvp type for icons: " + graphQLEventGuestStatus);
        }
    }

    public static void m18395a(ActionItemRsvp actionItemRsvp, Event event, EventStatus eventStatus) {
        if (event.G) {
            actionItemRsvp.f18033g.a(new RespondingInviteEvent(eventStatus));
        }
    }
}
