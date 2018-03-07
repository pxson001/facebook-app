package com.facebook.platform.composer.titlebar;

import com.facebook.ipc.composer.model.TargetType;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: result_display_styles */
public class PlatformComposerTargetTypesBuilder {
    public static final ImmutableSet<TargetType> f4433a = ImmutableSet.of(TargetType.UNDIRECTED, TargetType.USER, TargetType.GROUP, TargetType.PAGE);
    public static final ImmutableSet<TargetType> f4434b = ImmutableSet.of(TargetType.UNDIRECTED, TargetType.GROUP);
    public final boolean f4435c;

    @Inject
    public PlatformComposerTargetTypesBuilder(Boolean bool) {
        this.f4435c = bool.booleanValue();
    }
}
