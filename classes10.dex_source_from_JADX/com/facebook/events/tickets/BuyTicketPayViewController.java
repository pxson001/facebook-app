package com.facebook.events.tickets;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentsflow.ui.PayViewController;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audio_clips_playback_error */
public class BuyTicketPayViewController {
    private static BuyTicketPayViewController f19078e;
    private static final Object f19079f = new Object();
    public PayViewController f19080a;
    public EventAnalyticsParams f19081b;
    private final TasksManager f19082c;
    public final EventBuyTicketsGraphQLMutator f19083d;

    private static BuyTicketPayViewController m19302b(InjectorLike injectorLike) {
        return new BuyTicketPayViewController(TasksManager.b(injectorLike), new EventBuyTicketsGraphQLMutator((Context) injectorLike.getInstance(Context.class), GraphQLQueryExecutor.a(injectorLike), ImpressionManager.a(injectorLike), TasksManager.b(injectorLike)));
    }

    @Inject
    public BuyTicketPayViewController(TasksManager tasksManager, EventBuyTicketsGraphQLMutator eventBuyTicketsGraphQLMutator) {
        this.f19082c = tasksManager;
        this.f19083d = eventBuyTicketsGraphQLMutator;
    }

    public final void m19303a(int i, Intent intent) {
        if (i == -1 && this.f19080a != null) {
            this.f19080a.a((PaymentMethod) intent.getParcelableExtra("selected_payment_method"));
        }
    }

    public final boolean m19304a() {
        return this.f19082c.a(this);
    }

    public static BuyTicketPayViewController m19301a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BuyTicketPayViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19079f) {
                BuyTicketPayViewController buyTicketPayViewController;
                if (a2 != null) {
                    buyTicketPayViewController = (BuyTicketPayViewController) a2.a(f19079f);
                } else {
                    buyTicketPayViewController = f19078e;
                }
                if (buyTicketPayViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19302b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19079f, b3);
                        } else {
                            f19078e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = buyTicketPayViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
