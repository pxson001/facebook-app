package com.facebook.events.tickets.modal.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.tickets.modal.EventBuyTicketController;
import com.facebook.events.tickets.modal.EventBuyTicketsModel;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: appsite */
public class EventTicketsPurchaseConfirmationFragment extends EventTicketsBaseFragment {
    public static final CallerContext f19314d = CallerContext.a(EventTicketsPurchaseConfirmationFragment.class);
    @Inject
    public SecureContextHelper f19315a;
    public BetterButton al;
    public Switch am;
    public View an;
    public EventBuyTicketsModel ao;
    public EventAnalyticsParams ap;
    public GraphQLEventWatchStatus aq;
    @Inject
    public PublicEventsRsvpMutator f19316b;
    @Inject
    public EventEventLogger f19317c;
    public FbTextView f19318e;
    public FbTextView f19319f;
    public TextWithEntitiesView f19320g;
    public TextWithEntitiesView f19321h;
    public FbDraweeView f19322i;

    /* compiled from: appsite */
    public class C27362 implements OnCheckedChangeListener {
        final /* synthetic */ EventTicketsPurchaseConfirmationFragment f19312a;

        public C27362(EventTicketsPurchaseConfirmationFragment eventTicketsPurchaseConfirmationFragment) {
            this.f19312a = eventTicketsPurchaseConfirmationFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            GraphQLEventWatchStatus graphQLEventWatchStatus;
            EventTicketsPurchaseConfirmationFragment eventTicketsPurchaseConfirmationFragment = this.f19312a;
            if (z) {
                graphQLEventWatchStatus = GraphQLEventWatchStatus.GOING;
            } else {
                graphQLEventWatchStatus = this.f19312a.ao.f19229s;
            }
            if (graphQLEventWatchStatus != eventTicketsPurchaseConfirmationFragment.aq) {
                eventTicketsPurchaseConfirmationFragment.aq = graphQLEventWatchStatus;
                eventTicketsPurchaseConfirmationFragment.f19316b.a(eventTicketsPurchaseConfirmationFragment.ao.f19226p, graphQLEventWatchStatus, eventTicketsPurchaseConfirmationFragment.ap, ActionMechanism.BUY_TICKETS_FLOW);
            }
        }
    }

    /* compiled from: appsite */
    class C27373 implements OnClickListener {
        final /* synthetic */ EventTicketsPurchaseConfirmationFragment f19313a;

        C27373(EventTicketsPurchaseConfirmationFragment eventTicketsPurchaseConfirmationFragment) {
            this.f19313a = eventTicketsPurchaseConfirmationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2069273066);
            this.f19313a.o().setResult(-1);
            this.f19313a.o().finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1994388446, a);
        }
    }

    public static void m19475a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventTicketsPurchaseConfirmationFragment eventTicketsPurchaseConfirmationFragment = (EventTicketsPurchaseConfirmationFragment) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        PublicEventsRsvpMutator b = PublicEventsRsvpMutator.b(fbInjector);
        EventEventLogger b2 = EventEventLogger.m18119b(fbInjector);
        eventTicketsPurchaseConfirmationFragment.f19315a = secureContextHelper;
        eventTicketsPurchaseConfirmationFragment.f19316b = b;
        eventTicketsPurchaseConfirmationFragment.f19317c = b2;
    }

    public final void mo878c(@Nullable Bundle bundle) {
        super.mo878c(bundle);
        Class cls = EventTicketsPurchaseConfirmationFragment.class;
        m19475a((Object) this, getContext());
    }

    public final View m19476a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -657110406);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130904108, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1320400597, a);
        return inflate;
    }

    public final void m19477a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f19318e = (FbTextView) FindViewUtil.b(view, 2131561448);
        this.f19319f = (FbTextView) FindViewUtil.b(view, 2131561449);
        this.f19320g = (TextWithEntitiesView) FindViewUtil.b(view, 2131561451);
        this.f19321h = (TextWithEntitiesView) FindViewUtil.b(view, 2131561452);
        this.f19322i = (FbDraweeView) FindViewUtil.b(view, 2131561450);
        this.al = (BetterButton) FindViewUtil.b(view, 2131561453);
        this.am = (Switch) FindViewUtil.b(view, 2131561455);
        this.an = FindViewUtil.b(view, 2131561454);
        this.ao = (EventBuyTicketsModel) this.s.getParcelable("extra_buy_ticket_model");
        this.ap = (EventAnalyticsParams) this.s.getParcelable("extras_event_analytics_params");
        if (bundle == null) {
            this.aq = this.ao.f19229s;
        } else {
            this.aq = GraphQLEventWatchStatus.values()[bundle.getInt("state_buy_ticket_model")];
        }
    }

    public static void m19474a(TextWithEntitiesView textWithEntitiesView, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel) {
        if (linkableTextWithEntitiesModel != null) {
            textWithEntitiesView.setLinkableTextWithEntities(linkableTextWithEntitiesModel);
            textWithEntitiesView.setVisibility(0);
            return;
        }
        textWithEntitiesView.setVisibility(8);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1625494117);
        super.mi_();
        FbTitleBar a2 = ((EventBuyTicketController) a(EventBuyTicketController.class)).mo859a();
        a2.setTitle(2131241934);
        a2.setTitlebarAsModal(new C27373(this));
        final EventBuyTicketsModel eventBuyTicketsModel = this.ao;
        Resources jW_ = jW_();
        this.f19318e.setText(jW_.getQuantityString(2131689809, eventBuyTicketsModel.f19232v, new Object[]{Integer.valueOf(eventBuyTicketsModel.f19232v)}));
        this.f19319f.setText(eventBuyTicketsModel.f19227q);
        m19474a(this.f19320g, eventBuyTicketsModel.f19209B);
        m19474a(this.f19321h, eventBuyTicketsModel.f19223m);
        if (eventBuyTicketsModel.f19220j != null) {
            this.f19322i.a(eventBuyTicketsModel.f19220j, f19314d);
            this.f19322i.setVisibility(0);
        } else {
            this.f19322i.setVisibility(8);
        }
        if (eventBuyTicketsModel.f19235y) {
            if (Strings.isNullOrEmpty(this.ao.f19208A)) {
                this.al.setText(jW_().getString(2131241948));
            } else {
                this.al.setText(this.ao.f19208A);
            }
            this.al.setOnClickListener(((EventBuyTicketController) a(EventBuyTicketController.class)).mo862c(eventBuyTicketsModel));
            this.al.setVisibility(0);
        } else if (Strings.isNullOrEmpty(eventBuyTicketsModel.f19236z) || Strings.isNullOrEmpty(eventBuyTicketsModel.f19208A)) {
            this.al.setVisibility(8);
        } else {
            this.al.setText(this.ao.f19208A);
            this.al.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EventTicketsPurchaseConfirmationFragment f19311b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -242519386);
                    EventEventLogger eventEventLogger = this.f19311b.f19317c;
                    String str = this.f19311b.ao.f19226p;
                    HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_buy_tickets_view_order", false);
                    if (a2.a()) {
                        a2.a("event_ticketing").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("Event").c(str).a("event_id", str).b();
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(eventBuyTicketsModel.f19236z));
                    intent.setFlags(268435456);
                    intent.putExtra("force_in_app_browser", true);
                    this.f19311b.f19315a.b(intent, this.f19311b.getContext());
                    this.f19311b.o().finish();
                    Logger.a(2, EntryType.UI_INPUT_END, -1874227933, a);
                }
            });
            this.al.setVisibility(0);
        }
        if (eventBuyTicketsModel.f19229s == GraphQLEventWatchStatus.GOING) {
            this.an.setVisibility(8);
        } else {
            boolean z;
            this.an.setVisibility(0);
            Switch switchR = this.am;
            if (this.aq == GraphQLEventWatchStatus.GOING) {
                z = true;
            } else {
                z = false;
            }
            switchR.setChecked(z);
            this.am.setOnCheckedChangeListener(new C27362(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1532819053, a);
    }

    public final boolean mo882e() {
        ao().finish();
        return true;
    }

    public final void mo880e(Bundle bundle) {
        super.mo880e(bundle);
        bundle.putInt("state_buy_ticket_model", this.aq.ordinal());
    }
}
