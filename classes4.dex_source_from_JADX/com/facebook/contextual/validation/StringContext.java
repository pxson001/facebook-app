package com.facebook.contextual.validation;

import com.facebook.contextual.ContextHandler;
import com.facebook.contextual.ContextValue;
import com.facebook.contextual.ContextsProvider;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: square_pic_url */
public class StringContext implements ContextsProvider {
    public final List<ContextHandler> mo134a() {
        return ImmutableList.of(new ContextHandler("validation_string", this, 0));
    }

    public final ContextValue mo133a(long j) {
        return new ContextValue(String.valueOf(j));
    }
}
