package com.facebook.events.widget.eventcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.connectionqe.EventsConnectionStyleExperiment$PublicEventAction;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: operation_id */
public class EventActionButtonStateSelector {
    public static final List<GraphQLEventGuestStatus> f6061a = ImmutableList.of(GraphQLEventGuestStatus.GOING, GraphQLEventGuestStatus.MAYBE, GraphQLEventGuestStatus.NOT_GOING);
    public final Context f6062b;
    private final GlyphColorizer f6063c;
    private final EventsConnectionExperimentController f6064d;
    public final EventsRsvpActionListener f6065e;

    /* compiled from: operation_id */
    class PublicEventOneClickRsvpChanger implements OnClickListener {
        final /* synthetic */ EventActionButtonStateSelector f6068a;
        private final GraphQLEventWatchStatus f6069b;
        private final GraphQLEventWatchStatus f6070c;

        public PublicEventOneClickRsvpChanger(EventActionButtonStateSelector eventActionButtonStateSelector, GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
            this.f6068a = eventActionButtonStateSelector;
            this.f6069b = graphQLEventWatchStatus;
            this.f6070c = graphQLEventWatchStatus2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1143249621);
            this.f6068a.f6065e.mo545a(this.f6069b, this.f6070c);
            Logger.a(2, EntryType.UI_INPUT_END, 1869933373, a);
        }
    }

    /* compiled from: operation_id */
    public class PublicEventOptionsPresenter implements OnClickListener {
        final /* synthetic */ EventActionButtonStateSelector f6074a;
        private final List<EventsConnectionStyleExperiment$PublicEventAction> f6075b;
        public final GraphQLEventWatchStatus f6076c;

        public PublicEventOptionsPresenter(EventActionButtonStateSelector eventActionButtonStateSelector, List<EventsConnectionStyleExperiment$PublicEventAction> list, GraphQLEventWatchStatus graphQLEventWatchStatus) {
            this.f6074a = eventActionButtonStateSelector;
            this.f6075b = list;
            this.f6076c = graphQLEventWatchStatus;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1248184608);
            FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
            PopoverMenu c = figPopoverMenuWindow.c();
            for (EventsConnectionStyleExperiment$PublicEventAction eventsConnectionStyleExperiment$PublicEventAction : this.f6075b) {
                GraphQLEventWatchStatus graphQLEventWatchStatus;
                switch (1.a[eventsConnectionStyleExperiment$PublicEventAction.ordinal()]) {
                    case 1:
                        graphQLEventWatchStatus = GraphQLEventWatchStatus.WATCHED;
                        break;
                    case 2:
                        graphQLEventWatchStatus = GraphQLEventWatchStatus.GOING;
                        break;
                    case 3:
                        graphQLEventWatchStatus = GraphQLEventWatchStatus.UNWATCHED;
                        break;
                    default:
                        graphQLEventWatchStatus = null;
                        break;
                }
                GraphQLEventWatchStatus graphQLEventWatchStatus2 = graphQLEventWatchStatus;
                boolean z = graphQLEventWatchStatus2 == this.f6076c;
                MenuItemImpl a2 = c.a(EventActionButtonStateSelector.m6511a(this.f6076c, eventsConnectionStyleExperiment$PublicEventAction, z));
                a2.setIcon(EventActionButtonStateSelector.m6514a(this.f6074a, eventsConnectionStyleExperiment$PublicEventAction, z));
                a2.setCheckable(true);
                a2.setChecked(z);
                a2.setOnMenuItemClickListener(new 1(this, graphQLEventWatchStatus2));
            }
            figPopoverMenuWindow.m6297f(view);
            LogUtils.a(2001918319, a);
        }
    }

    public final EventActionButtonState m6525a(GraphQLConnectionStyle graphQLConnectionStyle, @Nullable GraphQLEventGuestStatus graphQLEventGuestStatus, @Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (1 == 0 || graphQLConnectionStyle != GraphQLConnectionStyle.INTERESTED) {
            return m6518b(graphQLEventGuestStatus);
        }
        return m6516a(graphQLEventWatchStatus);
    }

    public final EventActionButtonState m6526b(GraphQLConnectionStyle graphQLConnectionStyle, @Nullable GraphQLEventGuestStatus graphQLEventGuestStatus, @Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (1 == 0 || graphQLConnectionStyle != GraphQLConnectionStyle.INTERESTED) {
            return m6519c(graphQLEventGuestStatus);
        }
        return m6516a(graphQLEventWatchStatus);
    }

    @Inject
    public EventActionButtonStateSelector(@Assisted EventsRsvpActionListener eventsRsvpActionListener, Context context, GlyphColorizer glyphColorizer, EventsConnectionExperimentController eventsConnectionExperimentController) {
        this.f6062b = context;
        this.f6063c = glyphColorizer;
        this.f6065e = eventsRsvpActionListener;
        this.f6064d = eventsConnectionExperimentController;
    }

    private EventActionButtonState m6516a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        OnClickListener publicEventOptionsPresenter;
        int i;
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED || graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING || graphQLEventWatchStatus == GraphQLEventWatchStatus.DECLINED) {
            publicEventOptionsPresenter = new PublicEventOptionsPresenter(this, EventsConnectionExperimentController.m6528b(), graphQLEventWatchStatus);
        } else {
            publicEventOptionsPresenter = new PublicEventOneClickRsvpChanger(this, graphQLEventWatchStatus, GraphQLEventWatchStatus.WATCHED);
        }
        Drawable d = m6521d(graphQLEventWatchStatus);
        Context context = this.f6062b;
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
            i = 2131233847;
        } else if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
            i = 2131233850;
        } else if (graphQLEventWatchStatus == GraphQLEventWatchStatus.DECLINED) {
            i = 2131233849;
        } else {
            i = 2131233846;
        }
        return new EventActionButtonState(d, context.getString(i), publicEventOptionsPresenter);
    }

    private EventActionButtonState m6518b(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (f6061a.contains(graphQLEventGuestStatus)) {
            return new EventActionButtonState(m6522e(graphQLEventGuestStatus), m6523f(graphQLEventGuestStatus), new PrivateEventOptionsPresenter(this, graphQLEventGuestStatus));
        }
        return new EventActionButtonState(m6522e(graphQLEventGuestStatus), m6523f(graphQLEventGuestStatus), new PrivateEventOneClickRsvpChanger(this, graphQLEventGuestStatus, GraphQLEventGuestStatus.GOING));
    }

    private EventActionButtonState m6519c(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        String string;
        Drawable d = m6520d(graphQLEventGuestStatus);
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            string = this.f6062b.getResources().getString(2131233852);
        } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            string = this.f6062b.getResources().getString(2131233853);
        } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            string = this.f6062b.getResources().getString(2131233854);
        } else {
            string = null;
        }
        return new EventActionButtonState(d, string, new PrivateEventOptionsPresenter(this, graphQLEventGuestStatus));
    }

    private Drawable m6520d(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return m6512a(2130839490);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return m6512a(2130839493);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return m6512a(2130839489);
        }
        return null;
    }

    private Drawable m6522e(@Nullable GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (m6524i(graphQLEventGuestStatus)) {
            return m6512a(2130839848);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return m6512a(2130839852);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return m6512a(2130839853);
        }
        return m6517b(2130839846);
    }

    private String m6523f(@Nullable GraphQLEventGuestStatus graphQLEventGuestStatus) {
        int i;
        Context context = this.f6062b;
        if (m6524i(graphQLEventGuestStatus)) {
            i = 2131233847;
        } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            i = 2131233848;
        } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            i = 2131233849;
        } else {
            i = 2131233845;
        }
        return context.getString(i);
    }

    private Drawable m6521d(@Nullable GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
            return m6512a(2130839491);
        }
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
            return m6512a(2130839490);
        }
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.DECLINED) {
            return m6512a(2130839489);
        }
        return m6517b(2130839505);
    }

    public static boolean m6524i(@Nullable GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING || graphQLEventGuestStatus == GraphQLEventGuestStatus.HOST;
    }

    public static Drawable m6514a(EventActionButtonStateSelector eventActionButtonStateSelector, EventsConnectionStyleExperiment$PublicEventAction eventsConnectionStyleExperiment$PublicEventAction, boolean z) {
        switch (1.a[eventsConnectionStyleExperiment$PublicEventAction.ordinal()]) {
            case 1:
                return eventActionButtonStateSelector.m6513a(2130839505, z);
            case 2:
                return eventActionButtonStateSelector.m6513a(2130839848, z);
            case 3:
                return eventActionButtonStateSelector.m6513a(2130839815, z);
            default:
                throw new IllegalArgumentException("Unsupported rsvp type for icons: " + eventsConnectionStyleExperiment$PublicEventAction);
        }
    }

    static /* synthetic */ int m6511a(GraphQLEventWatchStatus graphQLEventWatchStatus, EventsConnectionStyleExperiment$PublicEventAction eventsConnectionStyleExperiment$PublicEventAction, boolean z) {
        int i;
        switch (1.a[eventsConnectionStyleExperiment$PublicEventAction.ordinal()]) {
            case 1:
                i = 2131233840;
                break;
            case 2:
                i = 2131233837;
                break;
            case 3:
                if (graphQLEventWatchStatus != GraphQLEventWatchStatus.GOING) {
                    if (graphQLEventWatchStatus != GraphQLEventWatchStatus.WATCHED) {
                        i = 2131233842;
                        break;
                    }
                    i = 2131233844;
                    break;
                }
                i = 2131233843;
                break;
            default:
                i = 0;
                break;
        }
        return i;
    }

    public static Drawable m6515a(EventActionButtonStateSelector eventActionButtonStateSelector, GraphQLEventGuestStatus graphQLEventGuestStatus, boolean z) {
        switch (1.b[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                return eventActionButtonStateSelector.m6513a(2130839848, z);
            case 2:
                return eventActionButtonStateSelector.m6513a(2130839852, z);
            case 3:
                return eventActionButtonStateSelector.m6513a(2130839853, z);
            default:
                throw new IllegalArgumentException("Unsupported rsvp type for icons: " + graphQLEventGuestStatus);
        }
    }

    private Drawable m6512a(int i) {
        return this.f6063c.a(i, -10972929);
    }

    private Drawable m6517b(int i) {
        return this.f6063c.a(i, -7235677);
    }

    private Drawable m6513a(int i, boolean z) {
        return z ? m6512a(i) : m6517b(i);
    }
}
