package com.facebook.reaction.ui.card.header;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.mutators.SubscribeToPageEventsMutator;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.SubscriptionStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEventSubscriber;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel.Builder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Unset Override */
public class ReactionEventSubscribeButtonBinder {
    public ReactionCardNode f21087a;
    private Context f21088b;
    public EventsSubscribeStatusChangedEventSubscriber f21089c;
    public ReactionUnitHeaderFieldsModel f21090d;
    public ReactionInteractionTracker f21091e;
    public boolean f21092f = false;
    public String f21093g;
    public PageScopedEventBus f21094h;
    public SubscribeToPageEventsMutator f21095i;
    public TasksManager f21096j;

    /* compiled from: Unset Override */
    public class C22303 extends AbstractDisposableFutureCallback {
        final /* synthetic */ TextView f21085a;
        final /* synthetic */ ReactionEventSubscribeButtonBinder f21086b;

        public C22303(ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder, TextView textView) {
            this.f21086b = reactionEventSubscribeButtonBinder;
            this.f21085a = textView;
        }

        protected final void m24714a(Object obj) {
        }

        protected final void m24715a(Throwable th) {
            boolean z;
            ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder = this.f21086b;
            if (this.f21086b.f21092f) {
                z = false;
            } else {
                z = true;
            }
            reactionEventSubscribeButtonBinder.f21092f = z;
            ReactionEventSubscribeButtonBinder.m24717b(this.f21086b, this.f21085a);
        }
    }

    public static ReactionEventSubscribeButtonBinder m24716b(InjectorLike injectorLike) {
        return new ReactionEventSubscribeButtonBinder((Context) injectorLike.getInstance(Context.class), PageScopedEventBus.m19596a(injectorLike), SubscribeToPageEventsMutator.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public ReactionEventSubscribeButtonBinder(Context context, PageScopedEventBus pageScopedEventBus, SubscribeToPageEventsMutator subscribeToPageEventsMutator, TasksManager tasksManager) {
        this.f21088b = context;
        this.f21094h = pageScopedEventBus;
        this.f21095i = subscribeToPageEventsMutator;
        this.f21096j = tasksManager;
    }

    public final void m24718a(ReactionCardNode reactionCardNode, final TextView textView, ReactionInteractionTracker reactionInteractionTracker) {
        this.f21087a = reactionCardNode;
        this.f21090d = reactionCardNode.mo1117k().fw_();
        this.f21091e = reactionInteractionTracker;
        if (this.f21090d.b() != null && this.f21090d.b().F() != null && !Strings.isNullOrEmpty(this.f21090d.b().F().b())) {
            this.f21092f = this.f21090d.b().W();
            this.f21093g = this.f21090d.b().F().b();
            m24717b(this, textView);
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ReactionEventSubscribeButtonBinder f21082b;

                public void onClick(View view) {
                    boolean z;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -486218568);
                    ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder = this.f21082b;
                    if (this.f21082b.f21092f) {
                        z = false;
                    } else {
                        z = true;
                    }
                    reactionEventSubscribeButtonBinder.f21092f = z;
                    ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder2 = this.f21082b;
                    reactionEventSubscribeButtonBinder2.f21096j.a(reactionEventSubscribeButtonBinder2, reactionEventSubscribeButtonBinder2.f21095i.a(reactionEventSubscribeButtonBinder2.f21093g, reactionEventSubscribeButtonBinder2.f21092f ? SubscriptionStatus.LOCAL : SubscriptionStatus.NONE, ActionMechanism.PLACE_TIPS, "reaction_dialog", "unknown"), new C22303(reactionEventSubscribeButtonBinder2, textView));
                    ReactionEventSubscribeButtonBinder.m24717b(this.f21082b, textView);
                    if (this.f21082b.f21091e != null) {
                        this.f21082b.f21091e.mo981a(this.f21082b.f21087a.mo1117k().d(), this.f21082b.f21087a.mo1117k().n(), new ReactionAttachmentIntent(this.f21082b.f21093g, UnitInteractionType.SUBSCRIBE_PAGE_EVENTS_TAP));
                    }
                    LogUtils.a(-760030526, a);
                }
            });
            this.f21089c = new EventsSubscribeStatusChangedEventSubscriber(this, Long.valueOf(Long.parseLong(this.f21093g))) {
                final /* synthetic */ ReactionEventSubscribeButtonBinder f21084c;

                public final void m24713b(FbEvent fbEvent) {
                    boolean z;
                    EventsSubscribeStatusChangedEvent eventsSubscribeStatusChangedEvent = (EventsSubscribeStatusChangedEvent) fbEvent;
                    ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder = this.f21084c;
                    if (eventsSubscribeStatusChangedEvent.f16574b == GraphQLEventsCalendarSubscriptionStatus.LOCAL) {
                        z = true;
                    } else {
                        z = false;
                    }
                    reactionEventSubscribeButtonBinder.f21092f = z;
                    ReactionEventSubscribeButtonBinder.m24717b(this.f21084c, textView);
                }
            };
            this.f21094h.a(this.f21089c);
        }
    }

    public static void m24717b(ReactionEventSubscribeButtonBinder reactionEventSubscribeButtonBinder, TextView textView) {
        int i = reactionEventSubscribeButtonBinder.f21092f ? 2131239537 : 2131239535;
        int i2 = reactionEventSubscribeButtonBinder.f21092f ? 2131361917 : 2131361974;
        textView.setText(reactionEventSubscribeButtonBinder.f21088b.getResources().getString(i));
        textView.setTextColor(reactionEventSubscribeButtonBinder.f21088b.getResources().getColor(i2));
        ReactionStoryAttachmentActionFragmentModel a = ReactionStoryAttachmentActionFragmentModel.a(reactionEventSubscribeButtonBinder.f21090d.b());
        Builder builder = new Builder();
        builder.a = a.a();
        builder.b = a.af();
        builder.c = a.ag();
        builder.d = a.ah();
        builder.e = a.ai();
        builder.f = a.aj();
        builder.g = a.fS_();
        builder.h = a.ak();
        builder.i = a.j();
        builder.j = a.al();
        builder.k = a.l();
        builder.l = a.am();
        builder.m = a.an();
        builder.n = a.o();
        builder.o = a.ao();
        builder.p = a.q();
        builder.q = a.r();
        builder.r = a.s();
        builder.s = a.ap();
        builder.t = a.aq();
        builder.u = a.v();
        builder.v = a.ar();
        builder.w = a.x();
        builder.x = a.as();
        builder.y = a.at();
        builder.z = a.au();
        builder.A = a.B();
        builder.B = a.ae();
        builder.C = a.av();
        builder.D = a.aw();
        builder.E = a.E();
        builder.F = a.ax();
        builder.G = a.G();
        builder.H = a.H();
        builder.I = a.I();
        builder.J = a.ay();
        builder.K = a.K();
        builder.L = a.L();
        builder.M = a.az();
        builder.N = a.N();
        builder.O = a.O();
        builder.P = a.P();
        builder.Q = a.aA();
        builder.R = a.aB();
        builder.S = a.S();
        builder.T = a.T();
        builder.U = a.U();
        builder.V = a.aC();
        builder.W = a.W();
        builder.X = a.X();
        builder.Y = a.aD();
        builder.Z = a.Z();
        builder.aa = a.aE();
        builder.ab = a.ab();
        builder.ac = a.ac();
        builder.ad = a.aF();
        Builder builder2 = builder;
        builder2.W = reactionEventSubscribeButtonBinder.f21092f;
        a = builder2.a();
        ReactionCardNode reactionCardNode = reactionEventSubscribeButtonBinder.f21087a;
        ReactionUnitHeaderFieldsModel a2 = ReactionUnitHeaderFieldsModel.a(reactionCardNode.f18838a.fw_());
        ReactionUnitHeaderFieldsModel.Builder builder3 = new ReactionUnitHeaderFieldsModel.Builder();
        builder3.a = a2.a();
        builder3.b = a2.j();
        builder3.c = a2.c();
        builder3.d = a2.k();
        builder3.e = a2.l();
        builder3.f = a2.g();
        builder3.g = a2.fy_();
        builder3.h = a2.m();
        ReactionUnitHeaderFieldsModel.Builder builder4 = builder3;
        builder4.b = a;
        a2 = builder4.a();
        ReactionUnitFragmentModel.Builder a3 = ReactionUnitFragmentModel.Builder.a(ReactionUnitFragmentModel.a(reactionCardNode.f18838a));
        a3.j = a2;
        reactionCardNode.f18838a = a3.a();
    }
}
