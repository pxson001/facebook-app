package com.facebook.contextual.validation;

import com.facebook.contextual.ContextHandler;
import com.facebook.contextual.ContextValue;
import com.facebook.contextual.ContextsProvider;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: src_pkg */
public class IntegerContext implements ContextsProvider {
    public final List<ContextHandler> mo134a() {
        return ImmutableList.of(new ContextHandler("validation_int", this, 0));
    }

    public final ContextValue mo133a(long j) {
        return new ContextValue(2 * j);
    }
}
