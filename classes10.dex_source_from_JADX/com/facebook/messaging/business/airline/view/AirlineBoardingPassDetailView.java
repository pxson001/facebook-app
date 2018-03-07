package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.airline.enums.TapSourceType;
import com.facebook.messaging.business.airline.utils.AirlineAnalyticsLogger;
import com.facebook.messaging.business.common.view.BusinessPairTextView;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineBoardingPassBubble;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsInterfaces.AirlineProductItem;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineBoardingPassModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineFlightInfoModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineProductItemModel;
import com.facebook.messaging.intents.OrcaMessagingIntentUris;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterButton;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_group_upsell_photo */
public class AirlineBoardingPassDetailView extends CustomLinearLayout {
    @Inject
    SecureContextHelper f1560a;
    @Inject
    OrcaMessagingIntentUris f1561b;
    @Inject
    MessageForwardHandler f1562c;
    @Inject
    AirlineAnalyticsLogger f1563d;
    private final FbDraweeView f1564e;
    private final FbDraweeView f1565f;
    private final FbDraweeView f1566g;
    private final FbDraweeView f1567h;
    private final AirlineAirportRouteView f1568i;
    private final BusinessPairTextView f1569j;
    private final BusinessPairTextView f1570k;
    private final AirlineGridView f1571l;
    private final AirlineGridView f1572m;
    private final BetterButton f1573n;
    private final BetterButton f1574o;
    private final LayoutInflater f1575p;

    public AirlineBoardingPassDetailView(Context context) {
        this(context, null, 0);
    }

    public AirlineBoardingPassDetailView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected AirlineBoardingPassDetailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903205);
        FbInjector.a(AirlineBoardingPassDetailView.class, this);
        this.f1564e = (FbDraweeView) a(2131559481);
        this.f1565f = (FbDraweeView) a(2131559482);
        this.f1566g = (FbDraweeView) a(2131559483);
        this.f1567h = (FbDraweeView) a(2131559484);
        this.f1568i = (AirlineAirportRouteView) a(2131559477);
        this.f1569j = (BusinessPairTextView) a(2131559475);
        this.f1570k = (BusinessPairTextView) a(2131559476);
        this.f1571l = (AirlineGridView) a(2131559478);
        this.f1572m = (AirlineGridView) a(2131559479);
        this.f1573n = (BetterButton) a(2131559485);
        this.f1574o = (BetterButton) a(2131559486);
        this.f1575p = LayoutInflater.from(context);
        this.f1568i.m1547a();
        setOrientation(1);
    }

    public final void m1567a(AirlineBoardingPassModel airlineBoardingPassModel) {
        AirlineFlightInfoModel c = airlineBoardingPassModel.c();
        if (airlineBoardingPassModel.g() != null && airlineBoardingPassModel.g().a() != null) {
            this.f1568i.m1548a(c);
            this.f1569j.setText(airlineBoardingPassModel.g().a().a());
            m1564a(this.f1570k, airlineBoardingPassModel.aU_());
            m1562a(this.f1565f, airlineBoardingPassModel.d());
            m1562a(this.f1566g, airlineBoardingPassModel.aT_());
            m1562a(this.f1567h, airlineBoardingPassModel.j());
            m1562a(this.f1564e, airlineBoardingPassModel.a());
            m1563a(this.f1571l, airlineBoardingPassModel.b());
            m1563a(this.f1572m, airlineBoardingPassModel.k());
        }
    }

    public final void m1568a(final Message message) {
        this.f1573n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AirlineBoardingPassDetailView f1557b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1179388035);
                this.f1557b.f1562c.m2244a(message, NavigationTrigger.b("forward_boarding_pass"));
                this.f1557b.f1563d.m1545a(message.a, TapSourceType.BOARDING_PASS_SHARE);
                Logger.a(2, EntryType.UI_INPUT_END, -1322674811, a);
            }
        });
    }

    private void m1562a(FbDraweeView fbDraweeView, String str) {
        if (!Strings.isNullOrEmpty(str)) {
            fbDraweeView.a(Uri.parse(str), CallerContext.a(getClass()));
        }
    }

    private static void m1564a(BusinessPairTextView businessPairTextView, @Nullable AirlineProductItemModel airlineProductItemModel) {
        if (airlineProductItemModel == null) {
            businessPairTextView.setVisibility(8);
            return;
        }
        businessPairTextView.setTitle(airlineProductItemModel.a());
        businessPairTextView.setText(airlineProductItemModel.b());
    }

    private void m1563a(AirlineGridView airlineGridView, ImmutableList<? extends AirlineProductItem> immutableList) {
        airlineGridView.removeAllViews();
        for (int i = 0; i < immutableList.size(); i++) {
            BusinessPairTextView businessPairTextView = (BusinessPairTextView) this.f1575p.inflate(2130903201, airlineGridView, false);
            m1564a(businessPairTextView, (AirlineProductItemModel) immutableList.get(i));
            airlineGridView.addView(businessPairTextView);
        }
    }

    public final void m1566a(AirlineBoardingPassBubble airlineBoardingPassBubble) {
        m1565b(airlineBoardingPassBubble);
        setupMessageButton(airlineBoardingPassBubble);
    }

    private void m1565b(AirlineBoardingPassBubble airlineBoardingPassBubble) {
        this.f1569j.setTitle(airlineBoardingPassBubble.aU());
        this.f1573n.setText(airlineBoardingPassBubble.bj());
        this.f1574o.setText(airlineBoardingPassBubble.aO());
    }

    private void setupMessageButton(final AirlineBoardingPassBubble airlineBoardingPassBubble) {
        if (airlineBoardingPassBubble.bN() == null) {
            this.f1574o.setVisibility(8);
        } else {
            this.f1574o.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AirlineBoardingPassDetailView f1559b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1318389038);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(this.f1559b.f1561b.a(airlineBoardingPassBubble.bN().b()));
                    intent.setFlags(67108864);
                    this.f1559b.f1560a.a(intent, this.f1559b.getContext());
                    this.f1559b.f1563d.m1545a(airlineBoardingPassBubble.c(), TapSourceType.BOARDING_PASS_MESSAGE);
                    Logger.a(2, EntryType.UI_INPUT_END, -1317362799, a);
                }
            });
        }
    }
}
