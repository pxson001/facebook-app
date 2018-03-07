package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDiscoveryDashboardPromptRowModel;
import com.facebook.events.dashboard.multirow.environment.HasEventAnalyticsParams;
import com.facebook.events.dashboard.prompts.EventsBirthdayPrompt;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel.ActionLinksModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel.ActionLinksModel.TemporalEventInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel.ActionLinksModel.TemporalEventInfoModel.ThemeModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: com.facebook.sdk.APP_EVENTS_FLUSH_RESULT */
public class EventsDashboardPromptRowPartDefinition extends MultiRowSinglePartDefinition<EventsDiscoveryDashboardPromptRowModel, Void, HasEventAnalyticsParams, EventsBirthdayPrompt> {
    public static final ViewType f17088a = new C23971();
    private static EventsDashboardPromptRowPartDefinition f17089b;
    private static final Object f17090c = new Object();

    /* compiled from: com.facebook.sdk.APP_EVENTS_FLUSH_RESULT */
    final class C23971 extends ViewType {
        C23971() {
        }

        public final View m17391a(Context context) {
            return new EventsBirthdayPrompt(context);
        }
    }

    private static EventsDashboardPromptRowPartDefinition m17394c() {
        return new EventsDashboardPromptRowPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m17396a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 897716969);
        m17393a((EventsDiscoveryDashboardPromptRowModel) obj, (HasEventAnalyticsParams) anyEnvironment, (EventsBirthdayPrompt) view);
        Logger.a(8, EntryType.MARK_POP, -1073951714, a);
    }

    public final boolean m17397a(Object obj) {
        return true;
    }

    public final ViewType<EventsBirthdayPrompt> m17395a() {
        return f17088a;
    }

    private static void m17393a(EventsDiscoveryDashboardPromptRowModel eventsDiscoveryDashboardPromptRowModel, HasEventAnalyticsParams hasEventAnalyticsParams, EventsBirthdayPrompt eventsBirthdayPrompt) {
        EventAnalyticsParams s = hasEventAnalyticsParams.mo794s();
        if (eventsDiscoveryDashboardPromptRowModel != null) {
            NodesModel nodesModel = eventsDiscoveryDashboardPromptRowModel.f16842a;
            if (nodesModel != null) {
                int i;
                eventsBirthdayPrompt.f17155p = s;
                View view = eventsBirthdayPrompt.f17144e;
                if (eventsDiscoveryDashboardPromptRowModel.f16843b) {
                    i = 0;
                } else {
                    i = 8;
                }
                view.setVisibility(i);
                if (!(nodesModel.l() == null || Strings.isNullOrEmpty(nodesModel.l().a()))) {
                    eventsBirthdayPrompt.f17145f.setImageURI(Uri.parse(nodesModel.l().a()));
                }
                eventsBirthdayPrompt.f17150k = nodesModel.k();
                eventsBirthdayPrompt.f17146g.setText(nodesModel.n().a());
                eventsBirthdayPrompt.f17147h.setText(nodesModel.m().a());
                ActionLinksModel actionLinksModel = nodesModel.j().isEmpty() ? null : (ActionLinksModel) nodesModel.j().get(0);
                if (actionLinksModel != null) {
                    eventsBirthdayPrompt.f17148i.setText(actionLinksModel.j());
                    TemporalEventInfoModel a = actionLinksModel.a();
                    if (a != null) {
                        eventsBirthdayPrompt.f17151l = a.c();
                        eventsBirthdayPrompt.f17152m = a.a();
                        ThemeModel b = a.b();
                        if (!(b == null || Strings.isNullOrEmpty(b.b()) || b.c() == null || Strings.isNullOrEmpty(b.c().a()))) {
                            eventsBirthdayPrompt.f17153n = b.b();
                            eventsBirthdayPrompt.f17154o = b.c().a();
                        }
                    }
                }
                EventEventLogger eventEventLogger = eventsBirthdayPrompt.f17141b;
                String str = eventsBirthdayPrompt.f17155p.c;
                String str2 = eventsBirthdayPrompt.f17155p.e;
                String str3 = eventsBirthdayPrompt.f17155p.d;
                String str4 = eventsBirthdayPrompt.f17150k;
                HoneyClientEventFast a2 = eventEventLogger.f17787i.a("event_prompt_impression", false);
                if (a2.a()) {
                    a2.a("event_dashboard").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b("EventPrompt").c(str4).a("ref_module", str).a("ref_mechanism", str2).a("source_module", str3).b();
                }
            }
        }
    }

    public static EventsDashboardPromptRowPartDefinition m17392a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardPromptRowPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17090c) {
                EventsDashboardPromptRowPartDefinition eventsDashboardPromptRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardPromptRowPartDefinition = (EventsDashboardPromptRowPartDefinition) a2.a(f17090c);
                } else {
                    eventsDashboardPromptRowPartDefinition = f17089b;
                }
                if (eventsDashboardPromptRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m17394c();
                        if (a2 != null) {
                            a2.a(f17090c, c);
                        } else {
                            f17089b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = eventsDashboardPromptRowPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
