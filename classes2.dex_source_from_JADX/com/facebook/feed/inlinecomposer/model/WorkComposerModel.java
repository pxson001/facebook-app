package com.facebook.feed.inlinecomposer.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: needs_backup_rules */
public final class WorkComposerModel {
    public static final WorkComposerModel f12921a = new WorkComposerModel(RegularImmutableList.f535a, 0);
    public final ImmutableList<ComposerGroup> f12922b;
    public final int f12923c;

    public WorkComposerModel(ImmutableList<ComposerGroup> immutableList, int i) {
        this.f12922b = immutableList;
        this.f12923c = i;
    }
}
