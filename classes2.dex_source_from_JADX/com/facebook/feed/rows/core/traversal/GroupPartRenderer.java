package com.facebook.feed.rows.core.traversal;

import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: native_name */
public class GroupPartRenderer<P, E extends AnyEnvironment> {
    public static <P, E extends AnyEnvironment> ImmutableList<SinglePartHolder<?, ?, ?, ?>> m19102a(MultiRowGroupPartDefinition<P, ?, ? super E> multiRowGroupPartDefinition, P p, E e, MultiRowPerfLogger multiRowPerfLogger) {
        Builder builder = ImmutableList.builder();
        if (multiRowGroupPartDefinition.mo2536a(p)) {
            GroupPartHolder.m19103a(multiRowGroupPartDefinition, null, builder, p, e, multiRowPerfLogger);
            return builder.m1068b();
        }
        throw new IllegalStateException("Root MultiRowGroupPartDefinition is not needed for the given props.");
    }
}
