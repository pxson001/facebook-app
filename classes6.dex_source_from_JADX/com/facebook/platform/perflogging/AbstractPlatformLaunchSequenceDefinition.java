package com.facebook.platform.perflogging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

/* compiled from: sticky-subscriptions */
public abstract class AbstractPlatformLaunchSequenceDefinition extends AbstractSequenceDefinition {
    protected AbstractPlatformLaunchSequenceDefinition(int i, String str, ImmutableSet<String> immutableSet, String str2) {
        Builder builder = ImmutableSet.builder();
        builder.b(immutableSet);
        if (str2 != null) {
            for (Object c : str2.split("\\|")) {
                builder.c(c);
            }
        }
        super(i, str, false, builder.b());
    }
}
