package com.facebook.events.tickets.modal.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.tickets.EventBuyTicketsPollingGraphQLMutator;
import com.facebook.events.tickets.modal.EventBuyTicketController;
import com.facebook.events.tickets.modal.EventBuyTicketStringFormattingUtil;
import com.facebook.events.tickets.modal.EventBuyTicketsModel;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.events.tickets.modal.views.EventBuyTicketProgressDialog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.LinkableEntityListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.base.Strings;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: appsite_data */
public class EventTicketsCheckoutFragment extends EventTicketsBaseFragment {
    @Inject
    GlyphColorizer f19301a;
    public FbTextView al;
    public FbTextView am;
    public FbTextView an;
    public FbTextView ao;
    public FbTextView ap;
    public FbTextView aq;
    public TextWithEntitiesView ar;
    private ImageWithTextView as;
    @Nullable
    public EventBuyTicketProgressDialog at;
    public EventBuyTicketsModel au;
    private EventAnalyticsParams av;
    private EventBuyTicketStringFormattingUtil aw;
    private Drawable ax;
    @Inject
    EventBuyTicketsPollingGraphQLMutator f19302b;
    @Inject
    Toaster f19303c;
    @Inject
    EventEventLogger f19304d;
    @Inject
    GraphQLLinkExtractor f19305e;
    @Inject
    SecureContextHelper f19306f;
    public FbTextView f19307g;
    public FbTextView f19308h;
    public FbTextView f19309i;

    /* compiled from: appsite_data */
    public class C27311 implements LinkableEntityListener {
        final /* synthetic */ EventTicketsCheckoutFragment f19297a;

        public C27311(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
            this.f19297a = eventTicketsCheckoutFragment;
        }

        public final void m19463a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
            String a = this.f19297a.f19305e.a(getEntityFbLinkGraphQL);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(a));
            intent.addFlags(268435456);
            this.f19297a.f19306f.b(intent, this.f19297a.getContext());
        }
    }

    /* compiled from: appsite_data */
    class C27322 implements OnClickListener {
        final /* synthetic */ EventTicketsCheckoutFragment f19298a;

        C27322(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
            this.f19298a = eventTicketsCheckoutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -29814117);
            EventTicketsCheckoutFragment.m19468b(this.f19298a);
            Logger.a(2, EntryType.UI_INPUT_END, -2018021351, a);
        }
    }

    /* compiled from: appsite_data */
    public class C27333 {
        public final /* synthetic */ EventTicketsCheckoutFragment f19299a;

        C27333(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
            this.f19299a = eventTicketsCheckoutFragment;
        }

        public final void m19465a(String str) {
            this.f19299a.au = this.f19299a.au.m19413a().mo864a(State.CHECKOUT).mo868a();
            EventTicketsCheckoutFragment.m19469b(this.f19299a, this.f19299a.au);
            EventTicketsCheckoutFragment.ar(this.f19299a);
            this.f19299a.f19303c.a(new ToastBuilder(str));
        }

        public final void m19464a() {
            this.f19299a.au = this.f19299a.au.m19413a().mo864a(State.CHECKOUT).mo868a();
            EventTicketsCheckoutFragment.m19469b(this.f19299a, this.f19299a.au);
            EventTicketsCheckoutFragment.ar(this.f19299a);
            this.f19299a.f19303c.a(new ToastBuilder(2131230762));
        }
    }

    /* compiled from: appsite_data */
    class C27344 implements OnClickListener {
        final /* synthetic */ EventTicketsCheckoutFragment f19300a;

        C27344(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
            this.f19300a = eventTicketsCheckoutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1045238859);
            this.f19300a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 2009921866, a);
        }
    }

    public static void m19467a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventTicketsCheckoutFragment) obj).m19466a(GlyphColorizer.a(fbInjector), new EventBuyTicketsPollingGraphQLMutator((Context) fbInjector.getInstance(Context.class), GraphQLQueryExecutor.a(fbInjector), ImpressionManager.a(fbInjector), TasksManager.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), GraphQLSubscriptionConnector.a(fbInjector)), Toaster.b(fbInjector), EventEventLogger.m18119b(fbInjector), GraphQLLinkExtractor.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m19466a(GlyphColorizer glyphColorizer, EventBuyTicketsPollingGraphQLMutator eventBuyTicketsPollingGraphQLMutator, Toaster toaster, EventEventLogger eventEventLogger, GraphQLLinkExtractor graphQLLinkExtractor, SecureContextHelper secureContextHelper) {
        this.f19301a = glyphColorizer;
        this.f19302b = eventBuyTicketsPollingGraphQLMutator;
        this.f19303c = toaster;
        this.f19304d = eventEventLogger;
        this.f19305e = graphQLLinkExtractor;
        this.f19306f = secureContextHelper;
    }

    public final void mo878c(@Nullable Bundle bundle) {
        super.mo878c(bundle);
        Class cls = EventTicketsCheckoutFragment.class;
        m19467a((Object) this, getContext());
        this.ax = this.f19301a.a(2130839972, -1);
    }

    public final View m19470a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 239497708);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130904111, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2122231105, a);
        return inflate;
    }

    public final void m19471a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.aw = new EventBuyTicketStringFormattingUtil(jW_());
        this.au = (EventBuyTicketsModel) this.s.getParcelable("extra_event_ticketing");
        this.av = (EventAnalyticsParams) this.s.getParcelable("extras_event_analytics_params");
        this.f19307g = (FbTextView) FindViewUtil.b(view, 2131561459);
        this.f19308h = (FbTextView) FindViewUtil.b(view, 2131561460);
        this.f19309i = (FbTextView) FindViewUtil.b(view, 2131561461);
        this.al = (FbTextView) FindViewUtil.b(view, 2131561462);
        this.am = (FbTextView) FindViewUtil.b(view, 2131561463);
        this.an = (FbTextView) FindViewUtil.b(view, 2131561464);
        this.ao = (FbTextView) FindViewUtil.b(view, 2131561465);
        this.ap = (FbTextView) FindViewUtil.b(view, 2131561466);
        this.ar = (TextWithEntitiesView) FindViewUtil.b(view, 2131561469);
        this.as = (ImageWithTextView) FindViewUtil.b(view, 2131561468);
        this.aq = (FbTextView) FindViewUtil.b(view, 2131561467);
        EventBuyTicketsModel eventBuyTicketsModel = this.au;
        this.f19307g.setText(eventBuyTicketsModel.f19227q);
        this.f19308h.setText(eventBuyTicketsModel.f19228r);
        this.f19309i.setText(a(2131241927, new Object[]{eventBuyTicketsModel.f19219i}));
        this.am.setText(EventBuyTicketStringFormattingUtil.m19390a(eventBuyTicketsModel.f19217g, eventBuyTicketsModel.f19218h, eventBuyTicketsModel.f19216f, eventBuyTicketsModel.f19232v));
        if (Strings.isNullOrEmpty(eventBuyTicketsModel.f19213c)) {
            this.al.setText(jW_().getQuantityString(2131689807, eventBuyTicketsModel.f19232v, new Object[]{Integer.valueOf(eventBuyTicketsModel.f19232v)}));
        } else if (eventBuyTicketsModel.f19232v == 1) {
            this.al.setText(jW_().getQuantityString(2131689808, eventBuyTicketsModel.f19232v, new Object[]{eventBuyTicketsModel.f19213c}));
        } else {
            this.al.setText(jW_().getQuantityString(2131689808, eventBuyTicketsModel.f19232v, new Object[]{Integer.valueOf(eventBuyTicketsModel.f19232v), eventBuyTicketsModel.f19213c}));
        }
        this.an.setText(eventBuyTicketsModel.f19233w);
        this.ao.setText(eventBuyTicketsModel.f19230t);
        this.ap.setText(eventBuyTicketsModel.f19231u);
        if (eventBuyTicketsModel.f19221k != null) {
            this.ar.a(eventBuyTicketsModel.f19221k, new C27311(this));
            this.ar.setVisibility(0);
        } else {
            this.ar.setVisibility(8);
        }
        m19469b(this, eventBuyTicketsModel);
        this.aq.setText(eventBuyTicketsModel.f19224n);
    }

    public final boolean mo882e() {
        return this.au.f19210C == State.BUYING || super.mo882e();
    }

    public static void m19469b(EventTicketsCheckoutFragment eventTicketsCheckoutFragment, EventBuyTicketsModel eventBuyTicketsModel) {
        eventTicketsCheckoutFragment.as.setText(eventTicketsCheckoutFragment.aw.m19391b(eventBuyTicketsModel.f19217g, eventBuyTicketsModel.f19218h, eventBuyTicketsModel.f19216f, eventBuyTicketsModel.f19232v));
        eventTicketsCheckoutFragment.as.setImageDrawable(eventTicketsCheckoutFragment.ax);
        eventTicketsCheckoutFragment.as.setOnClickListener(new C27322(eventTicketsCheckoutFragment));
    }

    public static void m19468b(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
        EventEventLogger eventEventLogger = eventTicketsCheckoutFragment.f19304d;
        String str = eventTicketsCheckoutFragment.au.f19226p;
        int i = eventTicketsCheckoutFragment.au.f19232v;
        HoneyClientEventFast a = eventEventLogger.f17787i.a("event_buy_tickets_purchase_button_tapped", false);
        if (a.a()) {
            a.a("event_ticketing").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("event_id", str).a("purchased_tickets_count", i).b();
        }
        eventTicketsCheckoutFragment.au = eventTicketsCheckoutFragment.au.m19413a().mo864a(State.BUYING).mo868a();
        m19469b(eventTicketsCheckoutFragment, eventTicketsCheckoutFragment.au);
        if (eventTicketsCheckoutFragment.at == null) {
            eventTicketsCheckoutFragment.at = new EventBuyTicketProgressDialog(eventTicketsCheckoutFragment.getContext());
        }
        if (!eventTicketsCheckoutFragment.at.isShowing()) {
            eventTicketsCheckoutFragment.at.show();
        }
        eventTicketsCheckoutFragment.f19302b.m19336a(eventTicketsCheckoutFragment.au.f19212b, eventTicketsCheckoutFragment.au.f19234x, eventTicketsCheckoutFragment.au.f19232v, eventTicketsCheckoutFragment.au.f19230t, eventTicketsCheckoutFragment.au.f19231u, eventTicketsCheckoutFragment.av, new C27333(eventTicketsCheckoutFragment));
    }

    public static void ar(EventTicketsCheckoutFragment eventTicketsCheckoutFragment) {
        if (eventTicketsCheckoutFragment.at != null && eventTicketsCheckoutFragment.at.isShowing()) {
            eventTicketsCheckoutFragment.at.dismiss();
        }
        eventTicketsCheckoutFragment.at = null;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -186649369);
        super.mi_();
        FbTitleBar a2 = ((EventBuyTicketController) a(EventBuyTicketController.class)).mo859a();
        a2.setTitle(2131241928);
        a2.a(new C27344(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1762843722, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 993123634);
        super.mY_();
        this.f19307g = null;
        this.f19308h = null;
        this.f19309i = null;
        this.al = null;
        this.am = null;
        this.an = null;
        this.ao = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.as = null;
        this.at = null;
        this.f19302b.m19334a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1850290641, a);
    }
}
