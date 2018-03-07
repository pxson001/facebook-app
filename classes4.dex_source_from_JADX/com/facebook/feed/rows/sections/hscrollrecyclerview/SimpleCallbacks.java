package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import java.util.ArrayList;
import java.util.List;

/* compiled from: device_created_time */
public abstract class SimpleCallbacks<E2 extends AnyEnvironment> implements PageSubParts<E2> {
    private final List<SinglePartDefinitionWithViewType<?, ?, ? super E2, ?>> f13911a = new ArrayList();
    private final List<Object> f13912b = new ArrayList();

    public abstract void mo566a(PageSubParts<E2> pageSubParts);

    protected SimpleCallbacks() {
        mo566a(this);
    }

    public final <P> void m14702a(SinglePartDefinitionWithViewType<P, ?, ? super E2, ?> singlePartDefinitionWithViewType, P p) {
        this.f13911a.add(singlePartDefinitionWithViewType);
        this.f13912b.add(p);
    }

    public SinglePartDefinitionWithViewType<Object, ?, ? super E2, ?> m14700a(int i) {
        return (SinglePartDefinitionWithViewType) this.f13911a.get(i);
    }

    public final Object m14703b(int i) {
        return this.f13912b.get(i);
    }

    public int m14699a() {
        return this.f13911a.size();
    }
}
