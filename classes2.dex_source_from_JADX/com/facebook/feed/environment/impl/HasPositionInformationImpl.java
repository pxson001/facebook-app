package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.InjectorLike;

/* compiled from: new_subscription_status */
public class HasPositionInformationImpl implements HasPositionInformation {
    private MultiRowSinglePartDefinition f12299a;
    private MultiRowSinglePartDefinition f12300b;
    private MultiRowSinglePartDefinition f12301c;
    private Object f12302d;
    private Object f12303e;

    public static HasPositionInformationImpl m18345a(InjectorLike injectorLike) {
        return new HasPositionInformationImpl();
    }

    public final MultiRowSinglePartDefinition mo2449f() {
        return this.f12300b;
    }

    public final MultiRowSinglePartDefinition hK_() {
        return this.f12299a;
    }

    public final MultiRowSinglePartDefinition mo2451h() {
        return this.f12301c;
    }

    public final Object mo2455i() {
        return this.f12302d;
    }

    public final Object mo2456j() {
        return this.f12303e;
    }

    public final void mo2429a(MultiRowSinglePartDefinition multiRowSinglePartDefinition, MultiRowSinglePartDefinition multiRowSinglePartDefinition2, MultiRowSinglePartDefinition multiRowSinglePartDefinition3, Object obj, Object obj2) {
        this.f12299a = multiRowSinglePartDefinition;
        this.f12300b = multiRowSinglePartDefinition2;
        this.f12301c = multiRowSinglePartDefinition3;
        this.f12302d = obj;
        this.f12303e = obj2;
    }

    public final void mo2457k() {
        mo2429a(null, null, null, null, null);
    }
}
