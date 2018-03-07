package com.facebook.multirow.api;

import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.Lazy;

/* compiled from: native_megaphone */
public abstract class BaseMultiRowSubParts<E extends AnyEnvironment> {
    public abstract <P> boolean mo2545a(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, ? super E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, P p);

    public abstract <P> boolean mo2546a(MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p);

    public <P> boolean m19112a(MultiRowPartWithIsNeeded<P, ? super E> multiRowPartWithIsNeeded, P p) {
        if (multiRowPartWithIsNeeded instanceof MultiRowGroupPartDefinition) {
            return mo2546a((MultiRowGroupPartDefinition) multiRowPartWithIsNeeded, (Object) p);
        }
        if (multiRowPartWithIsNeeded instanceof MultiRowSinglePartDefinition) {
            return mo2545a((MultiRowSinglePartDefinition) multiRowPartWithIsNeeded, (Object) p);
        }
        throw new UnsupportedOperationException("Unknown MultiRowPart " + multiRowPartWithIsNeeded);
    }

    public final <P> boolean m19113a(boolean z, Lazy<? extends MultiRowPartWithIsNeeded<P, ? super E>> lazy, P p) {
        if (!z) {
            return false;
        }
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) lazy.get();
        if (multiRowPartWithIsNeeded instanceof MultiRowGroupPartDefinition) {
            return mo2546a((MultiRowGroupPartDefinition) multiRowPartWithIsNeeded, (Object) p);
        }
        if (multiRowPartWithIsNeeded instanceof MultiRowSinglePartDefinition) {
            return mo2545a((MultiRowSinglePartDefinition) multiRowPartWithIsNeeded, (Object) p);
        }
        throw new UnsupportedOperationException("Unknown MultiRowPart " + multiRowPartWithIsNeeded);
    }
}
