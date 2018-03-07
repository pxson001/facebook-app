package com.facebook.feed.rows.core.parts;

import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;

/* compiled from: native_injection */
public class SubPartsSelector<E extends AnyEnvironment> {
    public final MultiRowSubParts<E> f12994a;
    public boolean f12995b;

    private SubPartsSelector(MultiRowSubParts<E> multiRowSubParts) {
        this.f12994a = multiRowSubParts;
    }

    public static <P, E extends AnyEnvironment> SubPartsSelector<E> m19116a(MultiRowSubParts<E> multiRowSubParts, MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p) {
        SubPartsSelector<E> subPartsSelector = new SubPartsSelector(multiRowSubParts);
        subPartsSelector.f12995b = subPartsSelector.f12994a.m19112a((MultiRowPartWithIsNeeded) multiRowGroupPartDefinition, (Object) p);
        return subPartsSelector;
    }

    public static <P, E extends AnyEnvironment> SubPartsSelector<E> m19114a(MultiRowSubParts<E> multiRowSubParts, SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, ? super E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, P p) {
        SubPartsSelector<E> subPartsSelector = new SubPartsSelector(multiRowSubParts);
        subPartsSelector.f12995b = subPartsSelector.f12994a.m19112a((MultiRowPartWithIsNeeded) singlePartDefinitionWithViewTypeAndIsNeeded, (Object) p);
        return subPartsSelector;
    }

    public static <P, E extends AnyEnvironment> SubPartsSelector<E> m19115a(MultiRowSubParts<E> multiRowSubParts, Lazy<? extends MultiRowPartWithIsNeeded<P, ? super E>> lazy, P p) {
        SubPartsSelector<E> subPartsSelector = new SubPartsSelector(multiRowSubParts);
        subPartsSelector.f12995b = subPartsSelector.f12994a.m19112a((MultiRowPartWithIsNeeded) lazy.get(), (Object) p);
        return subPartsSelector;
    }

    public static <P, E extends AnyEnvironment> SubPartsSelector<E> m19117a(MultiRowSubParts<E> multiRowSubParts, boolean z, Lazy<? extends MultiRowPartWithIsNeeded<P, ? super E>> lazy, P p) {
        SubPartsSelector<E> subPartsSelector = new SubPartsSelector(multiRowSubParts);
        if (z) {
            subPartsSelector.f12995b = subPartsSelector.f12994a.m19112a((MultiRowPartWithIsNeeded) lazy.get(), (Object) p);
        }
        return subPartsSelector;
    }

    public final <P> SubPartsSelector<E> m19120a(MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p) {
        if (!this.f12995b) {
            this.f12995b = this.f12994a.m19112a((MultiRowPartWithIsNeeded) multiRowGroupPartDefinition, (Object) p);
        }
        return this;
    }

    public final <P> SubPartsSelector<E> m19118a(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, ? super E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, P p) {
        if (!this.f12995b) {
            this.f12995b = this.f12994a.m19112a((MultiRowPartWithIsNeeded) singlePartDefinitionWithViewTypeAndIsNeeded, (Object) p);
        }
        return this;
    }

    public final <P> SubPartsSelector<E> m19119a(Lazy<? extends MultiRowPartWithIsNeeded<P, ? super E>> lazy, P p) {
        if (!this.f12995b) {
            this.f12995b = this.f12994a.m19112a((MultiRowPartWithIsNeeded) lazy.get(), (Object) p);
        }
        return this;
    }

    public final <P> SubPartsSelector<E> m19121a(boolean z, Lazy<? extends MultiRowPartWithIsNeeded<P, ? super E>> lazy, P p) {
        if (!this.f12995b && z) {
            this.f12995b = this.f12994a.m19112a((MultiRowPartWithIsNeeded) lazy.get(), (Object) p);
        }
        return this;
    }
}
