package com.facebook.adinterfaces;

import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.external.events.AdInterfacesEvent;
import com.facebook.adinterfaces.external.events.AdInterfacesEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.HashSet;
import javax.inject.Inject;

/* compiled from: account_enabled */
public class AdInterfacesContext {
    public AdInterfacesEventBus f21483a;
    private HashSet<AdInterfacesDataValidation> f21484b = new HashSet();
    public FbEventSubscriberListManager f21485c = new FbEventSubscriberListManager();

    public static AdInterfacesContext m22427a(InjectorLike injectorLike) {
        return new AdInterfacesContext(AdInterfacesEventBus.m22728a(injectorLike));
    }

    @Inject
    public AdInterfacesContext(AdInterfacesEventBus adInterfacesEventBus) {
        this.f21483a = adInterfacesEventBus;
    }

    public final void m22431a(AdInterfacesDataValidation adInterfacesDataValidation, boolean z) {
        if (!this.f21484b.isEmpty() || !z) {
            if (z) {
                this.f21484b.remove(adInterfacesDataValidation);
                if (this.f21484b.isEmpty()) {
                    this.f21483a.a(new DataValidationEvent(true));
                    return;
                }
                return;
            }
            boolean isEmpty = this.f21484b.isEmpty();
            this.f21484b.add(adInterfacesDataValidation);
            if (isEmpty) {
                this.f21483a.a(new DataValidationEvent(false));
            }
        }
    }

    public final boolean m22432a() {
        return this.f21484b.isEmpty();
    }

    public final void m22429a(AdInterfacesEvent adInterfacesEvent) {
        this.f21483a.a(adInterfacesEvent);
    }

    public final void m22430a(AdInterfacesEventSubscriber adInterfacesEventSubscriber) {
        this.f21485c.a(adInterfacesEventSubscriber);
        this.f21483a.a(adInterfacesEventSubscriber);
    }

    public final void m22428a(int i, IntentHandler intentHandler) {
        this.f21483a.m22730a(i, intentHandler);
    }

    public final boolean m22433a(ImmutableSet<AdInterfacesDataValidation> immutableSet) {
        return !Collections.disjoint(this.f21484b, immutableSet);
    }
}
