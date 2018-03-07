package com.facebook.events.permalink.actionbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.Assisted;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cacheable */
public class EventsActionBarMenuHandler implements InlineActionBarMenuHandler {
    public Event f18095a;
    @Nullable
    private FetchEventPermalinkFragmentModel f18096b;
    private EventAnalyticsParams f18097c;
    public ActionItemPost f18098d;
    private ActionItemInvite f18099e;
    private EventActionsHandlerUtil f18100f;
    private final ActionItemDelete f18101g;
    private final ActionItemEdit f18102h;
    private final ActionItemRsvp f18103i;
    private final ActionItemSave f18104j;
    private final ActionItemPromoteEvent f18105k;
    private final EventActionsHandlerUtilProvider f18106l;
    private final EventEventLogger f18107m;
    private final EventPermalinkController f18108n;
    private final EventsDashboardTimeFormatUtil f18109o;
    private final MessengerAppUtils f18110p;
    private final Product f18111q;
    private final SendAsMessageUtil f18112r;
    private final View f18113s;
    public final SecureContextHelper f18114t;
    private final SaveButtonUtils f18115u;
    private final boolean f18116v;

    /* compiled from: cacheable */
    class C25611 implements OnClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18088a;

        C25611(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18088a = eventsActionBarMenuHandler;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18088a.m18474b();
        }
    }

    /* compiled from: cacheable */
    class C25622 implements OnClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18089a;

        C25622(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18089a = eventsActionBarMenuHandler;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18089a.f18098d.m18375e();
        }
    }

    /* compiled from: cacheable */
    class C25633 implements OnMenuItemClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18090a;

        C25633(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18090a = eventsActionBarMenuHandler;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18090a.m18474b();
            return true;
        }
    }

    /* compiled from: cacheable */
    class C25644 implements OnMenuItemClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18091a;

        C25644(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18091a = eventsActionBarMenuHandler;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18091a.f18098d.m18375e();
            return true;
        }
    }

    /* compiled from: cacheable */
    class C25655 implements OnMenuItemClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18092a;

        C25655(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18092a = eventsActionBarMenuHandler;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            EventsActionBarMenuHandler.m18457c(this.f18092a);
            return true;
        }
    }

    /* compiled from: cacheable */
    class C25666 implements OnMenuItemClickListener {
        final /* synthetic */ EventsActionBarMenuHandler f18093a;

        C25666(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
            this.f18093a = eventsActionBarMenuHandler;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!(this.f18093a.f18095a == null || this.f18093a.f18095a.U == null)) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", FacebookUriUtil.a(this.f18093a.f18095a.U, "ti", "as").toString());
                this.f18093a.f18114t.b(Intent.createChooser(intent, EventsActionBarMenuHandler.m18457c(this.f18093a).getResources().getString(2131237051)), EventsActionBarMenuHandler.m18457c(this.f18093a));
            }
            return true;
        }
    }

    @Inject
    public EventsActionBarMenuHandler(@Assisted View view, ActionItemDelete actionItemDelete, ActionItemEdit actionItemEdit, ActionItemRsvp actionItemRsvp, ActionItemSave actionItemSave, ActionItemPromoteEvent actionItemPromoteEvent, EventActionsHandlerUtilProvider eventActionsHandlerUtilProvider, EventEventLogger eventEventLogger, EventPermalinkController eventPermalinkController, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, MessengerAppUtils messengerAppUtils, Product product, SecureContextHelper secureContextHelper, SendAsMessageUtil sendAsMessageUtil, SaveButtonUtils saveButtonUtils, Boolean bool) {
        this.f18101g = actionItemDelete;
        this.f18102h = actionItemEdit;
        this.f18103i = actionItemRsvp;
        this.f18104j = actionItemSave;
        this.f18105k = actionItemPromoteEvent;
        this.f18107m = eventEventLogger;
        this.f18106l = eventActionsHandlerUtilProvider;
        this.f18108n = eventPermalinkController;
        this.f18109o = eventsDashboardTimeFormatUtil;
        this.f18110p = messengerAppUtils;
        this.f18111q = product;
        this.f18112r = sendAsMessageUtil;
        this.f18113s = view;
        this.f18114t = secureContextHelper;
        this.f18115u = saveButtonUtils;
        this.f18116v = bool.booleanValue();
    }

    public final void m18469a(EventAnalyticsParams eventAnalyticsParams, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite) {
        this.f18097c = eventAnalyticsParams;
        this.f18098d = actionItemPost;
        this.f18099e = actionItemInvite;
    }

    public final void m18471a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f18095a = event;
        this.f18096b = fetchEventPermalinkFragmentModel;
        this.f18101g.m18344a(this.f18095a, this.f18097c);
        this.f18102h.m18350a(this.f18095a, this.f18097c);
        this.f18103i.m18406a(this.f18095a, this.f18097c);
        this.f18105k.m18381a(event);
        if (m18472a()) {
            ActionItemSave actionItemSave = this.f18104j;
            Event event2 = this.f18095a;
            actionItemSave.f18047a = event2;
            actionItemSave.f18048b = event2.E;
            actionItemSave.f18049c = event2.F;
        }
        this.f18100f = this.f18106l.m18426a(this.f18095a, this.f18097c);
    }

    public final void m18470a(BoostableStoryModel boostableStoryModel) {
        this.f18105k.m18380a(boostableStoryModel);
    }

    public static Context m18457c(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
        return eventsActionBarMenuHandler.f18113s.getContext();
    }

    public final boolean m18472a() {
        return this.f18111q == Product.FB4A && this.f18095a.a(EventViewerCapability.SAVE) && !StringUtil.a(this.f18095a.E) && !StringUtil.a(this.f18095a.F);
    }

    public final boolean m18473a(MenuItem menuItem) {
        String str = null;
        EventsActionBarButtonType fromOrdinal = EventsActionBarButtonType.fromOrdinal(menuItem.getItemId());
        if (fromOrdinal != null) {
            ActionItemRsvp actionItemRsvp;
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel;
            GraphQLEventWatchStatus graphQLEventWatchStatus;
            ActionMechanism actionMechanism;
            GraphQLEventWatchStatus graphQLEventWatchStatus2;
            View view;
            ActionMechanism actionMechanism2;
            switch (fromOrdinal) {
                case GOING_SELECTED:
                    this.f18103i.m18407a(GraphQLEventGuestStatus.GOING, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case MAYBED:
                    this.f18103i.m18407a(GraphQLEventGuestStatus.MAYBE, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case CANT_GO_SELECTED:
                    this.f18103i.m18407a(GraphQLEventGuestStatus.NOT_GOING, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case PRIVATE_INVITED:
                    this.f18103i.m18402a(this.f18096b, null, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_GOING_SELECTED_WITH_CHEVRON:
                    this.f18103i.m18403a(this.f18096b, GraphQLEventGuestStatus.GOING, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case PRIVATE_GOING_SELECTED:
                    this.f18103i.m18402a(this.f18096b, GraphQLEventGuestStatus.GOING, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_MAYBE_SELECTED_WITH_CHEVRON:
                    this.f18103i.m18403a(this.f18096b, GraphQLEventGuestStatus.MAYBE, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case PRIVATE_MAYBE_SELECTED:
                    this.f18103i.m18402a(this.f18096b, GraphQLEventGuestStatus.MAYBE, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_CANT_GO_SELECTED_WITH_CHEVRON:
                    this.f18103i.m18403a(this.f18096b, GraphQLEventGuestStatus.NOT_GOING, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case PRIVATE_CANT_GO_SELECTED:
                    this.f18103i.m18402a(this.f18096b, GraphQLEventGuestStatus.NOT_GOING, null, this.f18113s, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_GOING:
                case OPTIMISTIC_JOIN:
                    this.f18103i.m18400a(this.f18096b, GraphQLEventGuestStatus.GOING, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_MAYBE:
                    this.f18103i.m18400a(this.f18096b, GraphQLEventGuestStatus.MAYBE, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case TOXICLE_PRIVATE_CANT_GO:
                    this.f18103i.m18400a(this.f18096b, GraphQLEventGuestStatus.NOT_GOING, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case GOING:
                case JOIN:
                    this.f18103i.m18408a(GraphQLEventGuestStatus.GOING, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case MAYBE:
                    this.f18103i.m18408a(GraphQLEventGuestStatus.MAYBE, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case CANT_GO:
                    this.f18103i.m18408a(GraphQLEventGuestStatus.NOT_GOING, ActionMechanism.PERMALINK_ACTION_BAR, false);
                    break;
                case PUBLIC_INVITED:
                    actionItemRsvp = this.f18103i;
                    fetchEventPermalinkFragmentModel = this.f18096b;
                    View view2 = this.f18113s;
                    ActionMechanism actionMechanism3 = ActionMechanism.PERMALINK_ACTION_BAR;
                    actionItemRsvp.m18405a(fetchEventPermalinkFragmentModel, null, null, view2);
                    break;
                case PHOTOS:
                case PHOTOS_OVERFLOW:
                    EventEventLogger eventEventLogger = this.f18107m;
                    String str2 = this.f18095a.a;
                    str = ActionMechanism.PERMALINK_ACTION_BAR.toString();
                    HoneyClientEventFast a = eventEventLogger.f17787i.a("event_album_click", false);
                    if (a.a()) {
                        a.a("action_mechanism", str).a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str2).b();
                    }
                    m18462e();
                    break;
                case PUBLIC_INTERESTED:
                case TOXICLE_PUBLIC_INTERESTED:
                case TOXICLE_PUBLIC_INTERESTED_OVERFLOW:
                    this.f18103i.m18401a(this.f18096b, GraphQLEventWatchStatus.WATCHED);
                    break;
                case PUBLIC_GOING:
                case TOXICLE_PUBLIC_GOING:
                    this.f18103i.m18401a(this.f18096b, GraphQLEventWatchStatus.GOING);
                    break;
                case PUBLIC_INTERESTED_SELECTED:
                case PUBLIC_GOING_SELECTED:
                case TOXICLE_PUBLIC_INTERESTED_SELECTED:
                case TOXICLE_PUBLIC_GOING_SELECTED:
                case TOXICLE_PUBLIC_IGNORE:
                    this.f18103i.m18401a(this.f18096b, GraphQLEventWatchStatus.UNWATCHED);
                    break;
                case TOXICLE_PUBLIC_GOING_SELECTED_WITH_CHEVRON:
                    actionItemRsvp = this.f18103i;
                    fetchEventPermalinkFragmentModel = this.f18096b;
                    graphQLEventWatchStatus = GraphQLEventWatchStatus.GOING;
                    actionMechanism = ActionMechanism.PERMALINK_ACTION_BAR;
                    actionItemRsvp.m18404a(fetchEventPermalinkFragmentModel, graphQLEventWatchStatus);
                    break;
                case PUBLIC_GOING_SELECTED_WITH_CHEVRON:
                    actionItemRsvp = this.f18103i;
                    fetchEventPermalinkFragmentModel = this.f18096b;
                    graphQLEventWatchStatus2 = GraphQLEventWatchStatus.GOING;
                    view = this.f18113s;
                    actionMechanism2 = ActionMechanism.PERMALINK_ACTION_BAR;
                    actionItemRsvp.m18405a(fetchEventPermalinkFragmentModel, graphQLEventWatchStatus2, null, view);
                    break;
                case TOXICLE_PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON:
                    actionItemRsvp = this.f18103i;
                    fetchEventPermalinkFragmentModel = this.f18096b;
                    graphQLEventWatchStatus = GraphQLEventWatchStatus.WATCHED;
                    actionMechanism = ActionMechanism.PERMALINK_ACTION_BAR;
                    actionItemRsvp.m18404a(fetchEventPermalinkFragmentModel, graphQLEventWatchStatus);
                    break;
                case PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON:
                    actionItemRsvp = this.f18103i;
                    fetchEventPermalinkFragmentModel = this.f18096b;
                    graphQLEventWatchStatus2 = GraphQLEventWatchStatus.WATCHED;
                    view = this.f18113s;
                    actionMechanism2 = ActionMechanism.PERMALINK_ACTION_BAR;
                    actionItemRsvp.m18405a(fetchEventPermalinkFragmentModel, graphQLEventWatchStatus2, null, view);
                    break;
                case PUBLIC_INVITE_QE_SEND:
                case PUBLIC_INVITE_QE_SEND_OVERFLOW:
                case PUBLIC_INVITE_QE_SHARE:
                case PUBLIC_INVITE_QE_SHARE_OVERFLOW:
                    m18464g();
                    break;
                case SAVE:
                    this.f18104j.m18415a();
                    this.f18115u.a(m18457c(this));
                    break;
                case SAVED:
                    this.f18104j.m18416b();
                    break;
                case INVITE_OR_SHARE:
                case INVITE_OR_SHARE_OVERFLOW:
                    m18463f();
                    break;
                case SHARE:
                case SHARE_OVERFLOW:
                    this.f18098d.m18375e();
                    break;
                case POST:
                    this.f18098d.m18373a();
                    break;
                case INVITE:
                case INVITE_OVERFLOW:
                    m18474b();
                    break;
                case CREATOR_EDIT:
                case EDIT:
                    ActionItemEdit actionItemEdit = this.f18102h;
                    ActionMechanism actionMechanism4 = ActionMechanism.PERMALINK_ACTION_BAR;
                    if (this.f18096b != null) {
                        str = this.f18096b.U();
                    }
                    actionItemEdit.m18349a(actionMechanism4, str);
                    break;
                case REPORT_EVENT:
                    this.f18100f.m18424c();
                    break;
                case CANCEL_EVENT:
                    this.f18100f.m18423b();
                    break;
                case NOTIFICATION_SETTINGS:
                    this.f18100f.m18421a();
                    break;
                case COPY_LINK:
                    this.f18100f.m18422a("ti", "cl");
                    break;
                case EXPORT_TO_CALENDAR:
                    this.f18100f.m18425d();
                    break;
                case DELETE:
                    this.f18101g.m18343a(ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case CREATE_EVENT:
                    this.f18108n.m18265a(m18457c(this), this.f18097c, ActionMechanism.PERMALINK_ACTION_BAR);
                    break;
                case CREATOR_PROMOTE:
                case CREATOR_PROMOTED:
                    this.f18105k.m18379a();
                    break;
            }
        }
        return true;
    }

    public final void m18474b() {
        this.f18099e.m18367a(this.f18095a, ActionMechanism.PERMALINK_ACTION_BAR.toString());
    }

    public static void m18460d(EventsActionBarMenuHandler eventsActionBarMenuHandler) {
        if (eventsActionBarMenuHandler.f18095a != null && eventsActionBarMenuHandler.f18095a.U != null) {
            eventsActionBarMenuHandler.f18112r.a(m18457c(eventsActionBarMenuHandler), eventsActionBarMenuHandler.f18095a.U.toString(), true, true, "event_invite_sheet_action_bar");
        }
    }

    private void m18462e() {
        Intent intent = new Intent();
        if (this.f18095a.Z != null) {
            intent.setData(Uri.parse(StringFormatUtil.a(FBLinks.aL, new Object[]{this.f18095a.Z})));
            this.f18114t.a(intent, m18457c(this));
        }
    }

    private void m18463f() {
        int i;
        ActionSheetDialogBuilder actionSheetDialogBuilder = new ActionSheetDialogBuilder(m18457c(this));
        Context c = m18457c(this);
        if (this.f18116v) {
            i = 2131237038;
        } else {
            i = 2131237037;
        }
        actionSheetDialogBuilder.a(c.getString(i), new C25611(this));
        actionSheetDialogBuilder.a(m18457c(this).getString(2131236865), new C25622(this));
        actionSheetDialogBuilder.show();
    }

    private void m18464g() {
        if (this.f18095a != null) {
            Context c = m18457c(this);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(c);
            BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(c);
            Resources resources = c.getResources();
            if (this.f18095a.a(EventViewerCapability.INVITE)) {
                bottomSheetAdapter.a(resources.getString(2131237037)).setIcon(2130839877).setOnMenuItemClickListener(m18465h());
            }
            if (this.f18095a.a(EventViewerCapability.SHARE)) {
                bottomSheetAdapter.a(resources.getString(2131236847)).setIcon(2130839809).setOnMenuItemClickListener(m18466i());
            }
            if (this.f18110p.a() && this.f18110p.d() && this.f18112r.a()) {
                bottomSheetAdapter.a(resources.getString(2131236848)).setIcon(2130839685).setOnMenuItemClickListener(m18467j());
            }
            bottomSheetAdapter.a(resources.getString(2131237050)).setIcon(2130840095).setOnMenuItemClickListener(m18468k());
            bottomSheetDialog.a(bottomSheetAdapter);
            bottomSheetDialog.show();
        }
    }

    private OnMenuItemClickListener m18465h() {
        return new C25633(this);
    }

    private OnMenuItemClickListener m18466i() {
        return new C25644(this);
    }

    private OnMenuItemClickListener m18467j() {
        return new C25655(this);
    }

    private OnMenuItemClickListener m18468k() {
        return new C25666(this);
    }
}
