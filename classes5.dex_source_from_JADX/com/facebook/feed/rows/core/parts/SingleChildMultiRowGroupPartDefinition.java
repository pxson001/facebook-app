package com.facebook.feed.rows.core.parts;

import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;

/* compiled from: WWW_TPS_INLINE */
public class SingleChildMultiRowGroupPartDefinition<P, E extends AnyEnvironment> extends BaseMultiRowGroupPartDefinition<P, Void, E> {
    private final SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, E, ?> f12258a;

    public SingleChildMultiRowGroupPartDefinition(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, E, ?> singlePartDefinitionWithViewTypeAndIsNeeded) {
        this.f12258a = singlePartDefinitionWithViewTypeAndIsNeeded;
    }

    public final boolean m20284a(P p) {
        return this.f12258a.a(p);
    }

    public final Object m20283a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f12258a, obj);
        return null;
    }
}
