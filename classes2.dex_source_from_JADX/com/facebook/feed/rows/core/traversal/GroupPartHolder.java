package com.facebook.feed.rows.core.traversal;

import android.view.View;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;
import com.facebook.multirow.api.ViewType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: native_memory_chunk_pool_stats_counters */
public class GroupPartHolder<P, S, E extends AnyEnvironment> extends BaseMultiRowSubParts<E> {
    public final MultiRowGroupPartDefinition<P, S, E> f12984a;
    @Nullable
    public final GroupPartHolder<?, ?, ?> f12985b;
    private final Builder<SinglePartHolder<?, ?, ?, ?>> f12986c;
    public final P f12987d;
    public final E f12988e;
    public final MultiRowPerfLogger f12989f;
    public boolean f12990g;
    public S f12991h;
    private View f12992i;
    private ViewType f12993j;

    private GroupPartHolder(MultiRowGroupPartDefinition<P, S, E> multiRowGroupPartDefinition, @Nullable GroupPartHolder<?, ?, ?> groupPartHolder, Builder<SinglePartHolder<?, ?, ?, ?>> builder, P p, E e, MultiRowPerfLogger multiRowPerfLogger) {
        this.f12984a = multiRowGroupPartDefinition;
        this.f12987d = p;
        this.f12985b = groupPartHolder;
        this.f12988e = e;
        this.f12986c = builder;
        this.f12989f = multiRowPerfLogger;
        Preconditions.checkNotNull(multiRowPerfLogger);
    }

    public static <P, S, E extends AnyEnvironment> GroupPartHolder<P, S, E> m19103a(MultiRowGroupPartDefinition<P, S, E> multiRowGroupPartDefinition, GroupPartHolder<?, ?, ?> groupPartHolder, Builder<SinglePartHolder<?, ?, ?, ?>> builder, P p, E e, MultiRowPerfLogger multiRowPerfLogger) {
        BaseMultiRowSubParts groupPartHolder2 = new GroupPartHolder(multiRowGroupPartDefinition, groupPartHolder, builder, p, e, multiRowPerfLogger);
        groupPartHolder2.f12990g = true;
        groupPartHolder2.f12991h = groupPartHolder2.f12984a.mo2535a(groupPartHolder2, groupPartHolder2.f12987d, groupPartHolder2.f12988e);
        groupPartHolder2.f12990g = false;
        return groupPartHolder2;
    }

    public final void m19105a(View view, ViewType viewType) {
        if (this.f12985b != null) {
            this.f12985b.m19105a(view, viewType);
        }
        this.f12992i = view;
        this.f12993j = viewType;
        this.f12989f.mo1983a(this.f12984a, 6);
        this.f12984a.mo2537a(this.f12987d, this.f12991h, this.f12988e, this);
        this.f12989f.mo1980a(6);
        this.f12992i = null;
        this.f12993j = null;
    }

    public final void m19109b(View view, ViewType viewType) {
        this.f12992i = view;
        this.f12993j = viewType;
        this.f12989f.mo1983a(this.f12984a, 7);
        this.f12984a.mo2538b(this.f12987d, this.f12991h, this.f12988e, this);
        this.f12989f.mo1980a(7);
        this.f12992i = null;
        this.f12993j = null;
        if (this.f12985b != null) {
            this.f12985b.m19109b(view, viewType);
        }
    }

    public final <P> boolean mo2546a(MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p) {
        Preconditions.checkState(this.f12990g);
        if (!multiRowGroupPartDefinition.mo2536a(p)) {
            return false;
        }
        m19103a(multiRowGroupPartDefinition, this, this.f12986c, p, this.f12988e, this.f12989f);
        return true;
    }

    public final <P> boolean mo2545a(SinglePartDefinitionWithViewTypeAndIsNeeded<P, ?, ? super E, ?> singlePartDefinitionWithViewTypeAndIsNeeded, P p) {
        Preconditions.checkState(this.f12990g);
        this.f12989f.mo1983a((MultiRowPartWithIsNeeded) singlePartDefinitionWithViewTypeAndIsNeeded, 0);
        boolean a = singlePartDefinitionWithViewTypeAndIsNeeded.mo2536a(p);
        this.f12989f.mo1980a(0);
        if (!a) {
            return false;
        }
        this.f12986c.m1069c(new SinglePartHolder(singlePartDefinitionWithViewTypeAndIsNeeded, this, p, this.f12989f));
        return true;
    }

    @VisibleForTesting
    public final MultiRowGroupPartDefinition<P, S, E> m19108b() {
        return this.f12984a;
    }

    public final View m19104a() {
        Preconditions.checkState(this.f12992i != null, "Can only call getView() during bind() or unbind()");
        return this.f12992i;
    }
}
