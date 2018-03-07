package com.facebook.events.dashboard.multirow;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironment;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGenerated;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED */
public class EventsDashboardViewAllEventsRowPartDefinition extends MultiRowSinglePartDefinition<Object, OnClickListener, EventsDashboardEnvironment, View> {
    public static final ViewType f17095a = ViewType.a(2130904143);
    private static EventsDashboardViewAllEventsRowPartDefinition f17096e;
    private static final Object f17097f = new Object();
    public final EventEventLogger f17098b;
    public final Provider<ComponentName> f17099c;
    public final SecureContextHelper f17100d;

    private static EventsDashboardViewAllEventsRowPartDefinition m17405b(InjectorLike injectorLike) {
        return new EventsDashboardViewAllEventsRowPartDefinition(EventEventLogger.m18119b(injectorLike), IdBasedProvider.a(injectorLike, 12), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m17407a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final EventsDashboardEnvironmentGenerated eventsDashboardEnvironmentGenerated = (EventsDashboardEnvironmentGenerated) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ EventsDashboardViewAllEventsRowPartDefinition f17094b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 177435616);
                this.f17094b.f17098b.m18124a(eventsDashboardEnvironmentGenerated.mo794s().b.f.getParamValue());
                Intent component = new Intent().setComponent((ComponentName) this.f17094b.f17099c.get());
                component.putExtra("target_fragment", ContentFragmentType.EVENTS_DISCOVERY_UPCOMING_EVENTS_FRAGMENT.ordinal());
                component.putExtra("extra_ref_module", eventsDashboardEnvironmentGenerated.mo794s().d);
                this.f17094b.f17100d.a(component, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -806924007, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m17408a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2087376017);
        view.setOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 857664462, a);
    }

    @Inject
    public EventsDashboardViewAllEventsRowPartDefinition(EventEventLogger eventEventLogger, @FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper) {
        this.f17098b = eventEventLogger;
        this.f17099c = provider;
        this.f17100d = secureContextHelper;
    }

    public final boolean m17409a(Object obj) {
        return obj == EventsDashboardItemCollection.f17054c;
    }

    public final ViewType<View> m17406a() {
        return f17095a;
    }

    public static EventsDashboardViewAllEventsRowPartDefinition m17404a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardViewAllEventsRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17097f) {
                EventsDashboardViewAllEventsRowPartDefinition eventsDashboardViewAllEventsRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardViewAllEventsRowPartDefinition = (EventsDashboardViewAllEventsRowPartDefinition) a2.a(f17097f);
                } else {
                    eventsDashboardViewAllEventsRowPartDefinition = f17096e;
                }
                if (eventsDashboardViewAllEventsRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17405b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17097f, b3);
                        } else {
                            f17096e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardViewAllEventsRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m17410b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
