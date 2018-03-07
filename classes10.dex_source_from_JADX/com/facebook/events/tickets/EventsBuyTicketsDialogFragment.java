package com.facebook.events.tickets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.BuyTicketsLoggingInfo;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnDismissListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentsflow.PayViewControllerParams;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.ContentWrappingLinearLayoutManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: attached_files */
public class EventsBuyTicketsDialogFragment extends FbDialogFragment {
    @Inject
    public BuyTicketPayViewController am;
    @Inject
    public EventBuyTicketsDialogAdapterProvider an;
    @Inject
    public EventEventLogger ao;
    private EventsBuyTicketsDialogArgument ap;
    private BuyTicketsLoggingInfo aq;
    private EventBuyTicketsDialogAdapter ar;

    /* compiled from: attached_files */
    class C27191 implements OnDismissListener {
        final /* synthetic */ EventsBuyTicketsDialogFragment f19184a;

        C27191(EventsBuyTicketsDialogFragment eventsBuyTicketsDialogFragment) {
            this.f19184a = eventsBuyTicketsDialogFragment;
        }

        public final void m19355b() {
        }

        public final void m19356c() {
            super.a();
        }
    }

    /* compiled from: attached_files */
    class C27202 implements OnClickListener {
        final /* synthetic */ EventsBuyTicketsDialogFragment f19185a;

        C27202(EventsBuyTicketsDialogFragment eventsBuyTicketsDialogFragment) {
            this.f19185a = eventsBuyTicketsDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1217190459);
            super.a();
            Logger.a(2, EntryType.UI_INPUT_END, -2109053081, a);
        }
    }

    public static void m19359a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsBuyTicketsDialogFragment eventsBuyTicketsDialogFragment = (EventsBuyTicketsDialogFragment) obj;
        BuyTicketPayViewController a = BuyTicketPayViewController.m19301a(fbInjector);
        EventBuyTicketsDialogAdapterProvider eventBuyTicketsDialogAdapterProvider = (EventBuyTicketsDialogAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventBuyTicketsDialogAdapterProvider.class);
        EventEventLogger b = EventEventLogger.m18119b(fbInjector);
        eventsBuyTicketsDialogFragment.am = a;
        eventsBuyTicketsDialogFragment.an = eventBuyTicketsDialogAdapterProvider;
        eventsBuyTicketsDialogFragment.ao = b;
    }

    public final void m19363a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1688752414);
        Class cls = EventsBuyTicketsDialogFragment.class;
        m19359a((Object) this, getContext());
        super.a(bundle);
        a(2, 2131626577);
        this.ap = (EventsBuyTicketsDialogArgument) this.s.getParcelable("ARGS");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 902705059, a);
    }

    public final View m19361a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 348461645);
        View inflate = layoutInflater.inflate(2130903995, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1737244704, a);
        return inflate;
    }

    public final void m19364a(View view, @Nullable Bundle bundle) {
        int i;
        super.a(view, bundle);
        ((DismissibleFrameLayout) e(2131561209)).e = new C27191(this);
        e(2131561208).setOnClickListener(new C27202(this));
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) e(2131559427);
        ContentWrappingLinearLayoutManager contentWrappingLinearLayoutManager = new ContentWrappingLinearLayoutManager(getContext());
        contentWrappingLinearLayoutManager.b(1);
        betterRecyclerView.setLayoutManager(contentWrappingLinearLayoutManager);
        BuyTicketsLoggingInfo buyTicketsLoggingInfo = bundle == null ? new BuyTicketsLoggingInfo() : (BuyTicketsLoggingInfo) bundle.getParcelable("STATE_LOGGING_INFO");
        if (buyTicketsLoggingInfo == null) {
            buyTicketsLoggingInfo = new BuyTicketsLoggingInfo();
        }
        this.aq = buyTicketsLoggingInfo;
        EventBuyTicketsDialogAdapterProvider eventBuyTicketsDialogAdapterProvider = this.an;
        Context context = getContext();
        EventsBuyTicketsDialogArgument eventsBuyTicketsDialogArgument = this.ap;
        BuyTicketsLoggingInfo buyTicketsLoggingInfo2 = this.aq;
        if (bundle == null) {
            i = 1;
        } else {
            i = bundle.getInt("STATE_SELECTED_QUANTITY");
        }
        this.ar = eventBuyTicketsDialogAdapterProvider.m19322a(context, eventsBuyTicketsDialogArgument, buyTicketsLoggingInfo2, i, this);
        betterRecyclerView.setAdapter(this.ar);
    }

    public final void m19365e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("STATE_SELECTED_QUANTITY", this.ar.f19121u);
        bundle.putParcelable("STATE_LOGGING_INFO", this.aq);
        this.aq.f17778f = true;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 911418150);
        if (!this.aq.f17778f) {
            EventEventLogger eventEventLogger = this.ao;
            String str = this.ap.f19176b;
            ActionMechanism actionMechanism = this.ap.f19183i;
            BuyTicketsLoggingInfo buyTicketsLoggingInfo = this.aq;
            HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_buy_tickets_completed", false);
            if (a2.a()) {
                a2.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("action_mechanism", actionMechanism).a("event_id", str).a("quantity_button_tapped_count", buyTicketsLoggingInfo.f17773a).a("proceed_to_pay_button_tapped_count", buyTicketsLoggingInfo.f17774b).a("pay_button_tapped_count", buyTicketsLoggingInfo.f17775c).a("purchased_tickets_count", buyTicketsLoggingInfo.f17776d).a("purchased_tickets_failed_count", buyTicketsLoggingInfo.f17777e).b();
            }
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 949280425, a);
    }

    public final void m19362a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 505) {
            this.am.m19303a(i2, intent);
        }
    }

    public static EventsBuyTicketsDialogFragment m19357a(PayViewControllerParams payViewControllerParams, Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, ActionMechanism actionMechanism) {
        Parcelable eventsBuyTicketsDialogArgument = new EventsBuyTicketsDialogArgument(payViewControllerParams, event.a, event.b, event.Y, event.M, event.J(), fetchEventPermalinkFragmentModel.y(), fetchEventPermalinkFragmentModel.ac(), actionMechanism);
        EventsBuyTicketsDialogFragment eventsBuyTicketsDialogFragment = new EventsBuyTicketsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARGS", eventsBuyTicketsDialogArgument);
        eventsBuyTicketsDialogFragment.g(bundle);
        return eventsBuyTicketsDialogFragment;
    }
}
