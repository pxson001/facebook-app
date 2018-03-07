package com.facebook.composer.targetselection;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: fetchEventsList */
public class DefaultComposerTargetTypesBuilder {
    private static final ImmutableSet<TargetType> f6982a = ImmutableSet.of(TargetType.UNDIRECTED, TargetType.USER, TargetType.GROUP, TargetType.PAGE);

    public static DefaultComposerTargetTypesBuilder m8282a(InjectorLike injectorLike) {
        return new DefaultComposerTargetTypesBuilder();
    }

    public final Set<TargetType> m8283a() {
        return Sets.a(f6982a, TargetType.class);
    }
}
