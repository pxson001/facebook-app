package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.about.EventPermalinkDetailsToxicleView;
import com.facebook.events.permalink.about.EventPermalinkDetailsView;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.actionbar.EventPermalinkActionBar;
import com.facebook.events.permalink.actionbar.EventsToxicleActionBar;
import com.facebook.events.permalink.calltoaction.EventCallToActionButtonView;
import com.facebook.events.permalink.calltoaction.EventCallToActionController;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.cancelevent.CancelEventBannerView;
import com.facebook.events.permalink.draft.DraftEventBannerView;
import com.facebook.events.permalink.guestlist.EventGuestListView;
import com.facebook.events.permalink.header.CaspianEventPermalinkHeaderView;
import com.facebook.events.permalink.invitedbybar.EventInvitedByBarToxicleView;
import com.facebook.events.permalink.invitefriends.EventPermalinkInviteFriendsView;
import com.facebook.events.permalink.messageinviter.EventMessageInviterToxicleView;
import com.facebook.events.permalink.summary.EventPermalinkSummaryView;
import com.facebook.events.permalink.summary.EventSummaryContextRowsStateTracker;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.events.tickets.EventsPurchasedTicketsView;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: bypass_without_login */
public class EventInfoAdapter extends FbBaseAdapter {
    private final Context f18142a;
    private final ActionItemPost f18143b;
    private final ActionItemInvite f18144c;
    private final EventCallToActionController f18145d;
    private final EventCheckinButtonController f18146e;
    private final EventAnalyticsParams f18147f;
    private ImmutableList<ViewType> f18148g = RegularImmutableList.a;
    private FetchEventPermalinkFragmentModel f18149h;
    private Event f18150i;
    public boolean f18151j = true;
    public boolean f18152k;
    private boolean f18153l;
    private EventPermalinkBazingaHelper f18154m;
    private boolean f18155n;
    private EventSummaryContextRowsStateTracker f18156o;
    private QeAccessor f18157p;

    @VisibleForTesting
    /* compiled from: bypass_without_login */
    public enum ViewType {
        TOXICLE_EVENT_COVER,
        EVENT_COVER,
        CANCEL_EVENT_BANNER,
        DRAFT_EVENT_BANNER,
        TOXICLE_BUY_TICKETS_CALL_TO_ACTION,
        BUY_TICKETS_CALL_TO_ACTION,
        PURCHASED_TICKETS_SUMMARY,
        TOXICLE_CHECKIN_CALL_TO_ACTION,
        CHECKIN_CALL_TO_ACTION,
        TOXICLE_INVITED_BY_BAR,
        TOXICLE_MESSAGE_INVITER_BAR,
        TOXICLE_ACTION_BAR,
        ACTION_BAR,
        SUMMARY_LINES,
        HEADER_SHADOW,
        GUEST_LIST,
        INVITE_FRIENDS,
        TOXICLE_DETAILS_VIEW,
        DETAILS_VIEW
    }

    public EventInfoAdapter(Context context, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite, EventCallToActionController eventCallToActionController, EventAnalyticsParams eventAnalyticsParams, EventCheckinButtonController eventCheckinButtonController, EventPermalinkBazingaHelper eventPermalinkBazingaHelper, EventSummaryContextRowsStateTracker eventSummaryContextRowsStateTracker, QeAccessor qeAccessor) {
        this.f18146e = eventCheckinButtonController;
        this.f18142a = new ContextThemeWrapper(context, 2131625810);
        this.f18143b = actionItemPost;
        this.f18144c = actionItemInvite;
        this.f18145d = eventCallToActionController;
        this.f18147f = eventAnalyticsParams;
        this.f18154m = eventPermalinkBazingaHelper;
        this.f18156o = eventSummaryContextRowsStateTracker;
        this.f18157p = qeAccessor;
    }

    private static int m18515a(ViewType viewType) {
        switch (viewType) {
            case TOXICLE_EVENT_COVER:
                return 2130903518;
            case EVENT_COVER:
                return 2130903518;
            case CANCEL_EVENT_BANNER:
                return 2130904060;
            case DRAFT_EVENT_BANNER:
                return 2130904070;
            case TOXICLE_BUY_TICKETS_CALL_TO_ACTION:
            case TOXICLE_CHECKIN_CALL_TO_ACTION:
                return 2130904056;
            case BUY_TICKETS_CALL_TO_ACTION:
            case CHECKIN_CALL_TO_ACTION:
                return 2130904058;
            case PURCHASED_TICKETS_SUMMARY:
                return 2130904084;
            case TOXICLE_INVITED_BY_BAR:
                return 2130904079;
            case TOXICLE_MESSAGE_INVITER_BAR:
                return 2130904080;
            case HEADER_SHADOW:
                return 2130904076;
            case GUEST_LIST:
                return 2130904075;
            case INVITE_FRIENDS:
                return 2130904078;
            case TOXICLE_DETAILS_VIEW:
                return 2130904067;
            case DETAILS_VIEW:
                return 2130904066;
            default:
                throw new IllegalArgumentException("Unknown viewType " + viewType);
        }
    }

    public int getCount() {
        return this.f18148g.size();
    }

    public Object getItem(int i) {
        return this.f18148g.get(i);
    }

    public int getItemViewType(int i) {
        return ((ViewType) this.f18148g.get(i)).ordinal();
    }

    public long getItemId(int i) {
        return (long) ((ViewType) this.f18148g.get(i)).ordinal();
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public final View m18518a(int i, ViewGroup viewGroup) {
        ViewType viewType = ViewType.values()[i];
        if (viewType == ViewType.SUMMARY_LINES) {
            return new EventPermalinkSummaryView(this.f18142a, this.f18155n);
        }
        View inflate;
        if (viewType == ViewType.TOXICLE_ACTION_BAR) {
            inflate = LayoutInflater.from(this.f18142a).inflate(2130904088, viewGroup, false);
            inflate.setId(2131558633);
            return inflate;
        } else if (viewType == ViewType.ACTION_BAR) {
            inflate = new EventPermalinkActionBar(this.f18142a);
            inflate.setId(2131558633);
            return inflate;
        } else if (viewType == ViewType.TOXICLE_EVENT_COVER) {
            return new CaspianEventPermalinkHeaderView(new ContextThemeWrapper(this.f18142a, 2131624518), true);
        } else {
            if (viewType == ViewType.EVENT_COVER) {
                return new CaspianEventPermalinkHeaderView(this.f18142a, false);
            }
            return LayoutInflater.from(this.f18142a).inflate(m18515a(viewType), viewGroup, false);
        }
    }

    public final void m18520a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        boolean z = false;
        switch ((ViewType) obj) {
            case TOXICLE_EVENT_COVER:
                ((CaspianEventPermalinkHeaderView) view).m18893a(this.f18150i, this.f18149h, this.f18147f, true, this.f18150i.A());
                return;
            case EVENT_COVER:
                ((CaspianEventPermalinkHeaderView) view).m18893a(this.f18150i, this.f18149h, this.f18147f, false, this.f18150i.A());
                return;
            case CANCEL_EVENT_BANNER:
                ((CancelEventBannerView) view).m18652a(this.f18150i, this.f18147f);
                break;
            case DRAFT_EVENT_BANNER:
                break;
            case TOXICLE_BUY_TICKETS_CALL_TO_ACTION:
                this.f18145d.m18633a().m18627a(this.f18150i, this.f18149h, ((EventCallToActionButtonView) view).getCallToActionButtonView(), this.f18147f);
                return;
            case TOXICLE_CHECKIN_CALL_TO_ACTION:
                View callToActionButtonView = ((EventCallToActionButtonView) view).getCallToActionButtonView();
                callToActionButtonView.setText(2131237228);
                this.f18146e.m18643a(callToActionButtonView, this.f18150i, this.f18149h, this.f18153l);
                return;
            case BUY_TICKETS_CALL_TO_ACTION:
                this.f18145d.m18633a().m18627a(this.f18150i, this.f18149h, (TextView) view, this.f18147f);
                return;
            case CHECKIN_CALL_TO_ACTION:
                TextView textView = (TextView) view;
                textView.setText(2131237228);
                this.f18146e.m18643a(textView, this.f18150i, this.f18149h, this.f18153l);
                return;
            case PURCHASED_TICKETS_SUMMARY:
                ((EventsPurchasedTicketsView) view).m19378a(this.f18149h);
                return;
            case TOXICLE_INVITED_BY_BAR:
                ((EventInvitedByBarToxicleView) view).m18914a(this.f18150i, this.f18147f, m18516b());
                return;
            case TOXICLE_MESSAGE_INVITER_BAR:
                ((EventMessageInviterToxicleView) view).m18988a(this.f18150i, this.f18147f, m18516b());
                return;
            case GUEST_LIST:
                ((EventGuestListView) view).m18822a(this.f18150i, this.f18149h, this.f18147f.b);
                return;
            case INVITE_FRIENDS:
                ((EventPermalinkInviteFriendsView) view).m18919a(this.f18150i, this.f18144c);
                return;
            case TOXICLE_DETAILS_VIEW:
                ((EventPermalinkDetailsToxicleView) view).m18330a(this.f18150i);
                return;
            case DETAILS_VIEW:
                EventPermalinkDetailsView eventPermalinkDetailsView = (EventPermalinkDetailsView) view;
                eventPermalinkDetailsView.setTitle(2131237014);
                eventPermalinkDetailsView.m18337a(this.f18150i, this.f18149h);
                return;
            case TOXICLE_ACTION_BAR:
                EventsToxicleActionBar eventsToxicleActionBar = (EventsToxicleActionBar) view;
                Event event = this.f18150i;
                FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = this.f18149h;
                EventAnalyticsParams eventAnalyticsParams = this.f18147f;
                ActionItemPost actionItemPost = this.f18143b;
                ActionItemInvite actionItemInvite = this.f18144c;
                if (!(this.f18148g.contains(ViewType.TOXICLE_INVITED_BY_BAR) || this.f18148g.contains(ViewType.TOXICLE_MESSAGE_INVITER_BAR) || !m18516b())) {
                    z = true;
                }
                eventsToxicleActionBar.m18504a(event, fetchEventPermalinkFragmentModel, eventAnalyticsParams, actionItemPost, actionItemInvite, z);
                return;
            case ACTION_BAR:
                EventPermalinkActionBar eventPermalinkActionBar = (EventPermalinkActionBar) view;
                eventPermalinkActionBar.m18432a(this.f18150i, this.f18149h, this.f18147f, this.f18143b, this.f18144c);
                if (this.f18151j) {
                    eventPermalinkActionBar.mo819a();
                    return;
                } else {
                    eventPermalinkActionBar.mo820a(this.f18152k);
                    return;
                }
            case SUMMARY_LINES:
                ((EventPermalinkSummaryView) view).m19160a(this.f18150i, this.f18149h, this.f18147f, this.f18155n);
                return;
            default:
                return;
        }
        ((DraftEventBannerView) view).m18667a(this.f18150i, this.f18147f);
    }

    private boolean m18516b() {
        return this.f18148g.contains(ViewType.TOXICLE_CHECKIN_CALL_TO_ACTION) || this.f18148g.contains(ViewType.TOXICLE_BUY_TICKETS_CALL_TO_ACTION);
    }

    public final void m18521a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, boolean z) {
        this.f18155n = z;
        this.f18150i = event;
        this.f18149h = fetchEventPermalinkFragmentModel;
        EventSummaryContextRowsStateTracker eventSummaryContextRowsStateTracker = this.f18156o;
        if (eventSummaryContextRowsStateTracker.f18924b == 0) {
            if (fetchEventPermalinkFragmentModel != null) {
                eventSummaryContextRowsStateTracker.f18924b = EventSummaryContextRowsStateTracker.m19161a(fetchEventPermalinkFragmentModel.p(), fetchEventPermalinkFragmentModel.k(), fetchEventPermalinkFragmentModel.o(), fetchEventPermalinkFragmentModel.q());
            } else {
                eventSummaryContextRowsStateTracker.f18923a = EventSummaryContextRowsStateTracker.m19161a(event.G, event.l, event.D(), event.C);
            }
        }
        if (this.f18149h != null) {
            this.f18153l = false;
        }
        m18517c();
    }

    public final void m18519a() {
        this.f18153l = true;
        m18517c();
    }

    private void m18517c() {
        if (this.f18150i != null) {
            boolean z;
            ImmutableList immutableList;
            Builder builder = new Builder();
            builder.c(this.f18155n ? ViewType.TOXICLE_EVENT_COVER : ViewType.EVENT_COVER);
            if (!this.f18155n && this.f18150i.x) {
                builder.c(ViewType.CANCEL_EVENT_BANNER);
            }
            if (!this.f18155n && this.f18150i.y) {
                builder.c(ViewType.DRAFT_EVENT_BANNER);
            }
            int a = this.f18145d.m18632a(this.f18150i, this.f18149h);
            if (a == 2) {
                builder.c(this.f18155n ? ViewType.TOXICLE_BUY_TICKETS_CALL_TO_ACTION : ViewType.BUY_TICKETS_CALL_TO_ACTION);
            } else if (a == 1) {
                builder.c(this.f18155n ? ViewType.TOXICLE_CHECKIN_CALL_TO_ACTION : ViewType.CHECKIN_CALL_TO_ACTION);
            }
            if (!(this.f18149h == null || !this.f18149h.T() || this.f18149h.aR() == null || this.f18149h.aR().a().isEmpty()) || EventsPurchasedTicketsView.m19372b(this.f18149h) > 0) {
                builder.c(ViewType.PURCHASED_TICKETS_SUMMARY);
            }
            if (this.f18155n && this.f18150i.G && this.f18150i.ai != null && !StringUtil.a(this.f18150i.ai.c)) {
                builder.c(ViewType.TOXICLE_INVITED_BY_BAR);
            }
            if (this.f18155n && !this.f18150i.G && this.f18150i.l == GraphQLConnectionStyle.RSVP && this.f18150i.D() == GraphQLEventGuestStatus.NOT_GOING && this.f18150i.ai != null && !StringUtil.a(this.f18150i.ai.c)) {
                builder.c(ViewType.TOXICLE_MESSAGE_INVITER_BAR);
            }
            if (!(this.f18150i.y || this.f18150i.x)) {
                builder.c(this.f18155n ? ViewType.TOXICLE_ACTION_BAR : ViewType.ACTION_BAR);
            }
            builder.c(ViewType.SUMMARY_LINES);
            if (this.f18150i.c != null) {
                if (!StringUtil.a(new CharSequence[]{this.f18150i.c.a()})) {
                    int i;
                    a = 1;
                    if (this.f18150i.l == GraphQLConnectionStyle.RSVP || !this.f18155n) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (!(a == 0 || i == 0)) {
                        builder.c(ViewType.TOXICLE_DETAILS_VIEW);
                    }
                    if (!this.f18155n) {
                        builder.c(ViewType.HEADER_SHADOW);
                    }
                    if (this.f18150i.l != GraphQLConnectionStyle.INTERESTED) {
                        if (!(this.f18157p.a(ExperimentsForEventsGatingModule.Y, false) || this.f18150i.y || ((this.f18149h != null || this.f18153l) && (this.f18149h == null || !this.f18149h.af())))) {
                            builder.c(ViewType.GUEST_LIST);
                        }
                        if (!(this.f18157p.a(ExperimentsForEventsGatingModule.Y, false) || this.f18150i.x || !this.f18150i.a(EventViewerCapability.INVITE))) {
                            builder.c(ViewType.INVITE_FRIENDS);
                        }
                        if (this.f18149h != null) {
                            immutableList = RegularImmutableList.a;
                        } else {
                            immutableList = EventGraphQLModelHelper.m19260a(this.f18149h);
                        }
                        if (i == 0 && !(r1.isEmpty() && a == 0)) {
                            builder.c(ViewType.DETAILS_VIEW);
                        }
                    }
                    this.f18148g = builder.b();
                }
            }
            boolean z2 = false;
            if (this.f18150i.l == GraphQLConnectionStyle.RSVP) {
            }
            z = false;
            builder.c(ViewType.TOXICLE_DETAILS_VIEW);
            if (this.f18155n) {
                builder.c(ViewType.HEADER_SHADOW);
            }
            if (this.f18150i.l != GraphQLConnectionStyle.INTERESTED) {
                builder.c(ViewType.GUEST_LIST);
                builder.c(ViewType.INVITE_FRIENDS);
                if (this.f18149h != null) {
                    immutableList = EventGraphQLModelHelper.m19260a(this.f18149h);
                } else {
                    immutableList = RegularImmutableList.a;
                }
                builder.c(ViewType.DETAILS_VIEW);
            }
            this.f18148g = builder.b();
        }
    }
}
