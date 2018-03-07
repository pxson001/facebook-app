package com.facebook.events.tickets.modal;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.tickets.EventsTicketOrderClickListener;
import com.facebook.events.tickets.EventsTicketOrderClickListenerProvider;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.events.tickets.modal.fragments.EventSelectTicketsFragment;
import com.facebook.events.tickets.modal.fragments.EventTicketsBaseFragment;
import com.facebook.events.tickets.modal.fragments.EventTicketsCheckoutFragment;
import com.facebook.events.tickets.modal.fragments.EventTicketsPurchaseConfirmationFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: args_greeting_card */
public class EventBuyTicketsModalActivity extends FbFragmentActivity implements AnalyticsActivity, EventBuyTicketController {
    @Inject
    public EventsTicketOrderClickListenerProvider f19206p;
    private EventAnalyticsParams f19207q;

    private static <T extends Context> void m19393a(Class<T> cls, T t) {
        m19394a((Object) t, (Context) t);
    }

    public static void m19394a(Object obj, Context context) {
        ((EventBuyTicketsModalActivity) obj).f19206p = (EventsTicketOrderClickListenerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(EventsTicketOrderClickListenerProvider.class);
    }

    protected final void m19398b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventBuyTicketsModalActivity.class;
        m19394a((Object) this, (Context) this);
        overridePendingTransition(2130968589, 2130968588);
        setContentView(2130904114);
        this.f19207q = (EventAnalyticsParams) getIntent().getParcelableExtra("extras_event_analytics_params");
        if (bundle == null) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) FlatBufferModelHelper.a(getIntent(), "extra_event_model");
            EventSelectTicketsFragment eventSelectTicketsFragment = new EventSelectTicketsFragment();
            Bundle bundle2 = new Bundle();
            FlatBufferModelHelper.a(bundle2, "extra_event_model", fetchEventPermalinkFragmentModel);
            eventSelectTicketsFragment.g(bundle2);
            kO_().a().a(2131561480, eventSelectTicketsFragment).b();
        }
        FbTitleBarUtil.b(this);
    }

    public final String am_() {
        return "event_ticketing";
    }

    public final FbTitleBar mo859a() {
        return (FbTitleBar) a(2131558563);
    }

    public final void mo860a(EventBuyTicketsModel eventBuyTicketsModel) {
        EventAnalyticsParams eventAnalyticsParams = this.f19207q;
        EventTicketsCheckoutFragment eventTicketsCheckoutFragment = new EventTicketsCheckoutFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_event_ticketing", eventBuyTicketsModel.m19413a().mo864a(State.CHECKOUT).mo868a());
        bundle.putParcelable("extras_event_analytics_params", eventAnalyticsParams);
        eventTicketsCheckoutFragment.g(bundle);
        kO_().a().a(2130968752, 2130968755, 2130968764, 2130968767).b(m19395i()).a(2131561480, eventTicketsCheckoutFragment).a(EventTicketsCheckoutFragment.class.getSimpleName()).b();
    }

    public final void mo861b(EventBuyTicketsModel eventBuyTicketsModel) {
        EventAnalyticsParams eventAnalyticsParams = this.f19207q;
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_buy_ticket_model", eventBuyTicketsModel);
        bundle.putParcelable("extras_event_analytics_params", eventAnalyticsParams);
        EventTicketsPurchaseConfirmationFragment eventTicketsPurchaseConfirmationFragment = new EventTicketsPurchaseConfirmationFragment();
        eventTicketsPurchaseConfirmationFragment.g(bundle);
        kO_().a().a(2130968752, 2130968755, 2130968764, 2130968767).a(m19395i()).a(2131561480, eventTicketsPurchaseConfirmationFragment).b();
    }

    public final OnClickListener mo862c(EventBuyTicketsModel eventBuyTicketsModel) {
        FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) FlatBufferModelHelper.a(getIntent(), "extra_event_model");
        Preconditions.checkNotNull(fetchEventPermalinkFragmentModel);
        EventsTicketOrderClickListenerProvider eventsTicketOrderClickListenerProvider = this.f19206p;
        return new EventsTicketOrderClickListener(fetchEventPermalinkFragmentModel, eventBuyTicketsModel.f19211a, EventEventLogger.m18119b(eventsTicketOrderClickListenerProvider), (SecureContextHelper) DefaultSecureContextHelper.a(eventsTicketOrderClickListenerProvider));
    }

    public void onBackPressed() {
        EventTicketsBaseFragment eventTicketsBaseFragment = (EventTicketsBaseFragment) m19395i();
        if (eventTicketsBaseFragment == null || !eventTicketsBaseFragment.mo882e()) {
            super.onBackPressed();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968588, 2130968590);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1131874863);
        super.onStop();
        KeyboardUtils.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1876758564, a);
    }

    @Nullable
    private <T extends FbFragment> T m19395i() {
        return (FbFragment) kO_().a(2131561480);
    }

    private void m19392a(EventsTicketOrderClickListenerProvider eventsTicketOrderClickListenerProvider) {
        this.f19206p = eventsTicketOrderClickListenerProvider;
    }
}
