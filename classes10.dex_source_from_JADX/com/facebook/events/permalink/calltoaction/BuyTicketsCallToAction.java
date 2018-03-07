package com.facebook.events.permalink.calltoaction;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPhaseSelector;
import com.facebook.events.tickets.EventsBuyTicketsDialogFragment;
import com.facebook.events.tickets.EventsPurchasedTicketsView;
import com.facebook.events.tickets.modal.EventBuyTicketsModalActivity;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentsflow.PayViewControllerParams;
import com.facebook.payments.paymentsflow.PayViewControllerParamsBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: button_border_color */
public class BuyTicketsCallToAction {
    public final ImpressionManager f18265a;
    public final QeAccessor f18266b;
    public final EventEventLogger f18267c;
    private final EventPhaseSelector f18268d;
    public final SecureContextHelper f18269e;
    public OnClickListener f18270f;
    public Event f18271g;
    public FetchEventPermalinkFragmentModel f18272h;
    private boolean f18273i;

    public static BuyTicketsCallToAction m18625b(InjectorLike injectorLike) {
        return new BuyTicketsCallToAction(EventEventLogger.m18119b(injectorLike), EventPhaseSelector.m18299a(injectorLike), ImpressionManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public BuyTicketsCallToAction(EventEventLogger eventEventLogger, EventPhaseSelector eventPhaseSelector, ImpressionManager impressionManager, QeAccessor qeAccessor, SecureContextHelper secureContextHelper) {
        this.f18267c = eventEventLogger;
        this.f18268d = eventPhaseSelector;
        this.f18265a = impressionManager;
        this.f18266b = qeAccessor;
        this.f18269e = secureContextHelper;
    }

    public final boolean m18629b(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        return (fetchEventPermalinkFragmentModel == null || this.f18268d.m18303a(event) || fetchEventPermalinkFragmentModel.ac() == null || fetchEventPermalinkFragmentModel.ac().a().isEmpty() || !this.f18266b.a(ExperimentsForEventsGatingModule.i, false)) ? false : true;
    }

    public final void m18627a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, TextView textView, EventAnalyticsParams eventAnalyticsParams) {
        this.f18271g = event;
        this.f18272h = fetchEventPermalinkFragmentModel;
        if (fetchEventPermalinkFragmentModel.aR().a().isEmpty() || !fetchEventPermalinkFragmentModel.T()) {
            textView.setEnabled(false);
            textView.setText(textView.getResources().getString(2131237242));
            textView.setOnClickListener(null);
            return;
        }
        OnClickListener onClickListener;
        textView.setEnabled(true);
        textView.setText(textView.getResources().getString(EventsPurchasedTicketsView.m19372b(fetchEventPermalinkFragmentModel) > 0 ? 2131237230 : 2131237229));
        if (this.f18270f != null) {
            onClickListener = this.f18270f;
        } else {
            onClickListener = m18626a(this.f18271g, this.f18272h, ActionMechanism.PERMALINK_CONTEXT_ROW, eventAnalyticsParams);
        }
        textView.setOnClickListener(onClickListener);
        m18628a(this.f18271g.a, ActionMechanism.BUY_TICKETS_CTA);
    }

    public final void m18628a(String str, ActionMechanism actionMechanism) {
        if (!this.f18273i) {
            this.f18273i = true;
            EventEventLogger eventEventLogger = this.f18267c;
            HoneyClientEventFast a = eventEventLogger.f17787i.a("event_buy_tickets_button_impression", false);
            if (a.a()) {
                a.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("action_mechanism", actionMechanism).a("event_id", str).b();
            }
        }
    }

    public final OnClickListener m18626a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, ActionMechanism actionMechanism, EventAnalyticsParams eventAnalyticsParams) {
        final Event event2 = event;
        final ActionMechanism actionMechanism2 = actionMechanism;
        final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel2 = fetchEventPermalinkFragmentModel;
        final EventAnalyticsParams eventAnalyticsParams2 = eventAnalyticsParams;
        OnClickListener c25871 = new OnClickListener(this) {
            final /* synthetic */ BuyTicketsCallToAction f18263e;
            public boolean f18264f;

            /* compiled from: button_border_color */
            class C25861 implements Runnable {
                final /* synthetic */ C25871 f18258a;

                C25861(C25871 c25871) {
                    this.f18258a = c25871;
                }

                public void run() {
                    this.f18258a.f18264f = false;
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1612251437);
                if (this.f18264f) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1724617544, a);
                    return;
                }
                this.f18264f = true;
                EventEventLogger eventEventLogger = this.f18263e.f18267c;
                String str = event2.a;
                ActionMechanism actionMechanism = actionMechanism2;
                HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_buy_tickets_button_tapped", false);
                if (a2.a()) {
                    a2.a("event_permalink").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("action_mechanism", actionMechanism).a("event_id", str).b();
                }
                if (this.f18263e.f18266b.a(ExperimentsForEventsGatingModule.j, false) && fetchEventPermalinkFragmentModel2.Z()) {
                    BuyTicketsCallToAction.m18624a(this.f18263e, view, event2, fetchEventPermalinkFragmentModel2, eventAnalyticsParams2);
                } else {
                    BuyTicketsCallToAction buyTicketsCallToAction = this.f18263e;
                    Event event = event2;
                    FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = fetchEventPermalinkFragmentModel2;
                    ActionMechanism actionMechanism2 = actionMechanism2;
                    FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(view.getContext(), FragmentActivity.class);
                    Preconditions.checkNotNull(fragmentActivity);
                    PayViewControllerParamsBuilder payViewControllerParamsBuilder = new PayViewControllerParamsBuilder();
                    payViewControllerParamsBuilder.a = "events_buy_ticket_flow";
                    payViewControllerParamsBuilder = payViewControllerParamsBuilder;
                    payViewControllerParamsBuilder.c = PaymentsFlowType.PAY_VIEW_CONTROLLER;
                    payViewControllerParamsBuilder = payViewControllerParamsBuilder;
                    payViewControllerParamsBuilder.d = PaymentItemType.EVENT_TICKETING;
                    payViewControllerParamsBuilder = payViewControllerParamsBuilder;
                    payViewControllerParamsBuilder.b = buyTicketsCallToAction.f18265a.b(fragmentActivity);
                    PayViewControllerParams g = payViewControllerParamsBuilder.g();
                    EventsBuyTicketsDialogFragment.m19357a(g, event, fetchEventPermalinkFragmentModel, actionMechanism2).a(fragmentActivity.kO_(), "buy_event_tickets");
                }
                view.post(new C25861(this));
                LogUtils.a(-1872933864, a);
            }
        };
        this.f18270f = c25871;
        return c25871;
    }

    static /* synthetic */ void m18624a(BuyTicketsCallToAction buyTicketsCallToAction, View view, Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams) {
        Intent intent = new Intent(view.getContext(), EventBuyTicketsModalActivity.class);
        FlatBufferModelHelper.a(intent, "extra_event_model", fetchEventPermalinkFragmentModel);
        intent.putExtra("extras_event_analytics_params", eventAnalyticsParams);
        buyTicketsCallToAction.f18269e.a(intent, 506, (Activity) ContextUtils.a(view.getContext(), Activity.class));
    }
}
