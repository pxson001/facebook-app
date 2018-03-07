package com.facebook.events.tickets.modal.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventDefaultTicketHolderInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketProviderFragmentModel.EventTicketProviderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierFragmentModel.TicketTiersModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.tickets.BuyTicketPayViewController;
import com.facebook.events.tickets.RetryLoadPaymentMethodView;
import com.facebook.events.tickets.modal.EventBuyTicketController;
import com.facebook.events.tickets.modal.EventBuyTicketStringFormattingUtil;
import com.facebook.events.tickets.modal.EventBuyTicketsModel;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.events.tickets.modal.EventBuyTicketsModelBuilder;
import com.facebook.events.tickets.modal.protocol.EventTicketTierInfoFetcher;
import com.facebook.events.tickets.modal.util.EventBuyTicketCommonViewBinder;
import com.facebook.events.tickets.modal.views.EventBuyTicketTextField;
import com.facebook.events.tickets.modal.views.EventTicketingQuantityPicker;
import com.facebook.events.tickets.modal.views.EventTicketingQuantityPicker.OnQuantityChangedListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentsflow.PayViewControllerParamsBuilder;
import com.facebook.payments.paymentsflow.ui.PayView;
import com.facebook.payments.paymentsflow.ui.PayViewController;
import com.facebook.payments.paymentsflow.ui.PayViewController$PaymentMethodChangeListener;
import com.facebook.payments.util.PaymentMethodUtil;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: archive */
public class EventSelectTicketsFragment extends EventTicketsBaseFragment implements OnQuantityChangedListener, PayViewController$PaymentMethodChangeListener {
    @Inject
    BuyTicketPayViewController f19288a;
    private View aA;
    private View aB;
    private GenericErrorView aC;
    private BetterButton aD;
    private PayViewController al;
    private TextWatcher am;
    private EventBuyTicketStringFormattingUtil an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private TextView as;
    public EventBuyTicketTextField at;
    public EventBuyTicketTextField au;
    private PayView av;
    private RetryLoadPaymentMethodView aw;
    private EventTicketingQuantityPicker ax;
    private TextView ay;
    private TextView az;
    @Inject
    Provider<PayViewController> f19289b;
    @Inject
    public EventEventLogger f19290c;
    @Inject
    TasksManager f19291d;
    @Inject
    EventTicketTierInfoFetcher f19292e;
    @Inject
    @LoggedInUser
    User f19293f;
    @Inject
    EventBuyTicketCommonViewBinder f19294g;
    public EventBuyTicketsModel f19295h;
    public FetchEventPermalinkFragmentModel f19296i;

    /* compiled from: archive */
    class C27261 implements OnClickListener {
        final /* synthetic */ EventSelectTicketsFragment f19281a;

        C27261(EventSelectTicketsFragment eventSelectTicketsFragment) {
            this.f19281a = eventSelectTicketsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1518930564);
            EventSelectTicketsFragment eventSelectTicketsFragment = this.f19281a;
            eventSelectTicketsFragment.f19295h = eventSelectTicketsFragment.f19295h.m19413a().mo866a(eventSelectTicketsFragment.at.getText()).mo869b(eventSelectTicketsFragment.au.getText()).mo868a();
            EventEventLogger eventEventLogger = eventSelectTicketsFragment.f19290c;
            String str = eventSelectTicketsFragment.f19295h.f19226p;
            int i = eventSelectTicketsFragment.f19295h.f19232v;
            HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_buy_tickets_continue_button_tapped", false);
            if (a2.a()) {
                a2.a("event_ticketing").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("event_id", str).a("purchased_tickets_count", i).b();
            }
            ((EventBuyTicketController) eventSelectTicketsFragment.a(EventBuyTicketController.class)).mo860a(eventSelectTicketsFragment.f19295h);
            Logger.a(2, EntryType.UI_INPUT_END, 1465163876, a);
        }
    }

    /* compiled from: archive */
    class C27272 extends BaseTextWatcher {
        final /* synthetic */ EventSelectTicketsFragment f19282a;

        C27272(EventSelectTicketsFragment eventSelectTicketsFragment) {
            this.f19282a = eventSelectTicketsFragment;
        }

        public void afterTextChanged(Editable editable) {
            EventSelectTicketsFragment.as(this.f19282a);
        }
    }

    /* compiled from: archive */
    class C27283 implements OnClickListener {
        final /* synthetic */ EventSelectTicketsFragment f19283a;

        C27283(EventSelectTicketsFragment eventSelectTicketsFragment) {
            this.f19283a = eventSelectTicketsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 979859542);
            this.f19283a.f19295h = this.f19283a.f19295h.m19413a().mo864a(State.FETCH).mo868a();
            this.f19283a.f19292e.m19489a(this.f19283a.f19296i.dL_(), this.f19283a);
            EventSelectTicketsFragment.m19450a(this.f19283a, this.f19283a.f19295h);
            Logger.a(2, EntryType.UI_INPUT_END, -1873982044, a);
        }
    }

    /* compiled from: archive */
    class C27305 implements OnClickListener {
        final /* synthetic */ EventSelectTicketsFragment f19286a;

        C27305(EventSelectTicketsFragment eventSelectTicketsFragment) {
            this.f19286a = eventSelectTicketsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 299404076);
            this.f19286a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1847166531, a);
        }
    }

    public static void m19451a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventSelectTicketsFragment) obj).m19449a(BuyTicketPayViewController.m19301a(fbInjector), IdBasedProvider.a(fbInjector, 9195), EventEventLogger.m18119b(fbInjector), TasksManager.b(fbInjector), new EventTicketTierInfoFetcher(GraphQLQueryExecutor.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector)), User_LoggedInUserMethodAutoProvider.b(fbInjector), EventBuyTicketCommonViewBinder.m19491b(fbInjector));
    }

    private void m19449a(BuyTicketPayViewController buyTicketPayViewController, Provider<PayViewController> provider, EventEventLogger eventEventLogger, TasksManager tasksManager, EventTicketTierInfoFetcher eventTicketTierInfoFetcher, User user, EventBuyTicketCommonViewBinder eventBuyTicketCommonViewBinder) {
        this.f19288a = buyTicketPayViewController;
        this.f19289b = provider;
        this.f19290c = eventEventLogger;
        this.f19291d = tasksManager;
        this.f19292e = eventTicketTierInfoFetcher;
        this.f19293f = user;
        this.f19294g = eventBuyTicketCommonViewBinder;
    }

    public final void mo878c(@Nullable Bundle bundle) {
        super.mo878c(bundle);
        Class cls = EventSelectTicketsFragment.class;
        m19451a((Object) this, getContext());
        this.an = new EventBuyTicketStringFormattingUtil(jW_());
        this.f19296i = (FetchEventPermalinkFragmentModel) FlatBufferModelHelper.a(this.s, "extra_event_model");
        if (bundle == null) {
            EventBuyTicketsModelBuilder eventBuyTicketsModelBuilder = new EventBuyTicketsModelBuilder();
            eventBuyTicketsModelBuilder.f19239C = State.FETCH;
            this.f19295h = eventBuyTicketsModelBuilder.mo868a();
        } else {
            this.f19295h = (EventBuyTicketsModel) bundle.getParcelable("state_event_ticketing_model");
        }
        if (this.f19295h.f19210C == State.FETCH) {
            this.f19292e.m19489a(this.f19296i.dL_(), this);
        }
        if (this.f19295h.f19210C == State.ERROR) {
            this.f19295h = this.f19295h.m19413a().mo864a(State.FETCH).mo868a();
            this.f19292e.m19489a(this.f19296i.dL_(), this);
        }
    }

    public final View m19453a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2114532166);
        View inflate = layoutInflater.inflate(2130904099, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -496886430, a);
        return inflate;
    }

    public final void m19455a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        View view2 = this.T;
        this.ao = (TextView) FindViewUtil.b(view2, 2131561405);
        this.ap = (TextView) FindViewUtil.b(view2, 2131561406);
        this.aq = (TextView) FindViewUtil.b(view2, 2131561407);
        this.as = (TextView) FindViewUtil.b(view2, 2131561410);
        this.ar = (TextView) FindViewUtil.b(view2, 2131561408);
        this.at = (EventBuyTicketTextField) FindViewUtil.b(view2, 2131561413);
        this.au = (EventBuyTicketTextField) FindViewUtil.b(view2, 2131561414);
        this.av = (PayView) FindViewUtil.b(view2, 2131561411);
        this.aw = (RetryLoadPaymentMethodView) FindViewUtil.b(view2, 2131561412);
        this.aD = (BetterButton) FindViewUtil.b(view2, 2131561417);
        this.ax = (EventTicketingQuantityPicker) FindViewUtil.b(view2, 2131561409);
        this.ay = (TextView) FindViewUtil.b(view2, 2131561416);
        this.az = (TextView) FindViewUtil.b(view2, 2131561415);
        this.aA = FindViewUtil.b(view2, 2131561404);
        this.aB = FindViewUtil.b(view2, 2131561418);
        this.aC = (GenericErrorView) FindViewUtil.b(view2, 2131561419);
        this.al = (PayViewController) this.f19289b.get();
        this.f19288a.f19080a = this.al;
        PayViewController payViewController = this.al;
        PayViewControllerParamsBuilder payViewControllerParamsBuilder = new PayViewControllerParamsBuilder();
        payViewControllerParamsBuilder.d = PaymentItemType.EVENT_TICKETING;
        payViewControllerParamsBuilder = payViewControllerParamsBuilder;
        payViewControllerParamsBuilder.c = PaymentsFlowType.PAY_VIEW_CONTROLLER;
        payViewControllerParamsBuilder = payViewControllerParamsBuilder;
        payViewControllerParamsBuilder.b = SafeUUIDGenerator.a().toString();
        payViewControllerParamsBuilder = payViewControllerParamsBuilder;
        payViewControllerParamsBuilder.a = "events_buy_ticket_flow";
        payViewControllerParamsBuilder = payViewControllerParamsBuilder;
        payViewControllerParamsBuilder.e = ImmutableList.of(NewPaymentOptionType.NEW_PAYPAL);
        payViewController.a(payViewControllerParamsBuilder.g(), 505, this, this);
        this.aD.setOnClickListener(new C27261(this));
        this.ax.f19380h = this;
        this.am = new C27272(this);
        this.aC.setOnClickListener(new C27283(this));
        this.au.m19499a(this.am);
        this.at.m19499a(this.am);
        m19450a(this, this.f19295h);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1050960038);
        super.mi_();
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -843467377, a);
    }

    public final void mo879c(boolean z) {
        super.mo879c(z);
        if (!z) {
            ar();
        }
    }

    public final void m19454a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 505) {
            this.f19288a.m19303a(i2, intent);
        }
    }

    public static void m19450a(EventSelectTicketsFragment eventSelectTicketsFragment, EventBuyTicketsModel eventBuyTicketsModel) {
        if (eventSelectTicketsFragment.aA != null) {
            if (eventSelectTicketsFragment.f19295h.f19210C == State.FETCH) {
                eventSelectTicketsFragment.aA.setVisibility(8);
                eventSelectTicketsFragment.aB.setVisibility(0);
                eventSelectTicketsFragment.aC.setVisibility(8);
            } else if (eventSelectTicketsFragment.f19295h.f19210C == State.ERROR) {
                eventSelectTicketsFragment.aA.setVisibility(8);
                eventSelectTicketsFragment.aB.setVisibility(8);
                eventSelectTicketsFragment.aC.setVisibility(0);
                eventSelectTicketsFragment.aC.b();
            } else {
                eventSelectTicketsFragment.aA.setVisibility(0);
                eventSelectTicketsFragment.aB.setVisibility(8);
                eventSelectTicketsFragment.aC.setVisibility(8);
                eventSelectTicketsFragment.m19452b(eventBuyTicketsModel);
                eventSelectTicketsFragment.ao.setText(eventBuyTicketsModel.f19227q);
                eventSelectTicketsFragment.ap.setText(eventBuyTicketsModel.f19228r);
                eventSelectTicketsFragment.aq.setText(eventSelectTicketsFragment.a(2131241927, new Object[]{eventBuyTicketsModel.f19219i}));
                if (!Strings.isNullOrEmpty(eventBuyTicketsModel.f19213c)) {
                    eventSelectTicketsFragment.ar.setText(eventBuyTicketsModel.f19213c);
                }
                eventSelectTicketsFragment.av.a(eventSelectTicketsFragment.al);
                eventSelectTicketsFragment.at.setText(eventBuyTicketsModel.f19230t);
                eventSelectTicketsFragment.au.setText(eventBuyTicketsModel.f19231u);
                eventSelectTicketsFragment.ax.setMaximumQuantity(eventBuyTicketsModel.f19215e);
                eventSelectTicketsFragment.ax.setCurrentQuantity(eventBuyTicketsModel.f19232v);
                eventSelectTicketsFragment.f19294g.m19492a(eventSelectTicketsFragment.T, eventBuyTicketsModel.f19222l);
                eventSelectTicketsFragment.az.setText(eventBuyTicketsModel.f19225o);
                as(eventSelectTicketsFragment);
            }
        }
    }

    private void m19452b(EventBuyTicketsModel eventBuyTicketsModel) {
        this.as.setText(EventBuyTicketStringFormattingUtil.m19390a(eventBuyTicketsModel.f19217g, eventBuyTicketsModel.f19218h, eventBuyTicketsModel.f19216f, eventBuyTicketsModel.f19232v));
    }

    public final void mo857a(@Nullable PaymentMethod paymentMethod) {
        this.av.setVisibility(0);
        this.aw.setVisibility(8);
        this.aw.setOnClickListener(null);
        if (paymentMethod != null) {
            this.f19295h = this.f19295h.m19413a().mo870c(PaymentMethodUtil.b(paymentMethod, jW_())).mo871d(paymentMethod.a()).mo868a();
        }
        as(this);
    }

    public final void mo858a(final Runnable runnable) {
        this.av.setVisibility(8);
        this.aw.setVisibility(0);
        this.aw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventSelectTicketsFragment f19285b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 133199867);
                runnable.run();
                Logger.a(2, EntryType.UI_INPUT_END, -30249777, a);
            }
        });
        as(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1292031280);
        super.mY_();
        this.ao = null;
        this.ap = null;
        this.aq = null;
        this.as = null;
        this.at = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ay = null;
        this.aA = null;
        this.aB = null;
        this.am = null;
        this.f19291d.c();
        this.al.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1062468295, a);
    }

    public final void mo881g(int i) {
        this.f19295h = this.f19295h.m19413a().mo863a(i).mo868a();
        m19452b(this.f19295h);
    }

    public final void mo880e(Bundle bundle) {
        super.mo880e(bundle);
        this.f19295h = this.f19295h.m19413a().mo866a(this.at.getText()).mo869b(this.au.getText()).mo868a();
        bundle.putParcelable("state_event_ticketing_model", this.f19295h);
    }

    private void ar() {
        FbTitleBar a = ((EventBuyTicketController) a(EventBuyTicketController.class)).mo859a();
        a.setTitle(2131241924);
        a.setTitlebarAsModal(new C27305(this));
    }

    public static void as(EventSelectTicketsFragment eventSelectTicketsFragment) {
        Object obj;
        CharSequence text = eventSelectTicketsFragment.at.getText();
        Object text2 = eventSelectTicketsFragment.au.getText();
        String str = eventSelectTicketsFragment.f19295h.f19234x;
        if (StringUtil.c(text)) {
            obj = 1;
        } else if (StringUtil.c(text2)) {
            obj = 2;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(text2.trim()).matches()) {
            obj = 3;
        } else if (Strings.isNullOrEmpty(str)) {
            obj = 4;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        eventSelectTicketsFragment.au.setTextColorResId(2131361972);
        if (obj2 == null) {
            eventSelectTicketsFragment.aD.setEnabled(true);
            eventSelectTicketsFragment.ay.setVisibility(8);
            return;
        }
        eventSelectTicketsFragment.aD.setEnabled(false);
        switch (obj2) {
            case 1:
                eventSelectTicketsFragment.ay.setText(eventSelectTicketsFragment.b(2131241942));
                eventSelectTicketsFragment.ay.setVisibility(0);
                return;
            case 2:
                eventSelectTicketsFragment.ay.setText(eventSelectTicketsFragment.b(2131241943));
                eventSelectTicketsFragment.ay.setVisibility(0);
                return;
            case 3:
                text = eventSelectTicketsFragment.b(2131241944);
                eventSelectTicketsFragment.au.setTextColorResId(2131361918);
                eventSelectTicketsFragment.ay.setText(text);
                eventSelectTicketsFragment.ay.setVisibility(0);
                return;
            case 4:
                eventSelectTicketsFragment.ay.setVisibility(8);
                return;
            default:
                throw new IllegalStateException("Invalid validation code");
        }
    }

    public final void m19456a(EventTicketTierFragmentModel eventTicketTierFragmentModel, @Nullable EventDefaultTicketHolderInfoModel eventDefaultTicketHolderInfoModel) {
        String dU_;
        String a;
        Uri uri = null;
        NodesModel nodesModel = (NodesModel) eventTicketTierFragmentModel.k().a().get(0);
        EventTicketProviderModel j = eventTicketTierFragmentModel.j();
        EventBuyTicketsModelBuilder eventBuyTicketsModelBuilder = new EventBuyTicketsModelBuilder();
        eventBuyTicketsModelBuilder.f19241b = nodesModel.d();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19242c = nodesModel.dZ_();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19255p = this.f19296i.dL_();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19256q = this.f19296i.dM_();
        EventBuyTicketsModelBuilder eventBuyTicketsModelBuilder2 = eventBuyTicketsModelBuilder;
        if (this.f19296i.ay() != null) {
            dU_ = this.f19296i.ay().dU_();
        } else {
            dU_ = null;
        }
        eventBuyTicketsModelBuilder2.f19257r = dU_;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder2;
        eventBuyTicketsModelBuilder.f19248i = j.m();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        if (!Strings.isNullOrEmpty(j.l())) {
            uri = Uri.parse(j.l());
        }
        eventBuyTicketsModelBuilder.f19249j = uri;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19250k = j.n();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19251l = j.k();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19253n = j.j();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19254o = j.a();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19243d = nodesModel.b();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19244e = nodesModel.c();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19245f = nodesModel.g().a();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19246g = nodesModel.g().b();
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19247h = nodesModel.g().c();
        EventBuyTicketsModelBuilder eventBuyTicketsModelBuilder3 = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder3.f19264y = 1;
        eventBuyTicketsModelBuilder3 = eventBuyTicketsModelBuilder3;
        eventBuyTicketsModelBuilder3.f19258s = this.f19296i.q();
        eventBuyTicketsModelBuilder3 = eventBuyTicketsModelBuilder3;
        eventBuyTicketsModelBuilder3.f19239C = State.SELECT;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder3;
        if (eventDefaultTicketHolderInfoModel != null) {
            a = eventDefaultTicketHolderInfoModel.a();
        } else {
            a = this.f19293f.u();
        }
        eventBuyTicketsModelBuilder.f19263x = a;
        eventBuyTicketsModelBuilder3 = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder3.f19262w = this.f19293f.j();
        eventBuyTicketsModelBuilder3 = eventBuyTicketsModelBuilder3;
        if (this.al.k != null) {
            eventBuyTicketsModelBuilder3.f19237A = this.al.j;
            eventBuyTicketsModelBuilder3.f19265z = PaymentMethodUtil.b(this.al.k, jW_());
        }
        this.f19295h = eventBuyTicketsModelBuilder3.mo868a();
        m19450a(this, this.f19295h);
    }
}
