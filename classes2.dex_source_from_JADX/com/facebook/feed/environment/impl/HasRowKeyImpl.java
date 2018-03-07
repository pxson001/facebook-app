package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;

/* compiled from: neighbor_cell_info */
public class HasRowKeyImpl implements HasRowKey {
    @Nullable
    private RowKey f12873a;

    public static HasRowKeyImpl m18942a(InjectorLike injectorLike) {
        return new HasRowKeyImpl();
    }

    public final void mo2428a(RowKey rowKey) {
        this.f12873a = rowKey;
    }

    public final void mo2460n() {
        this.f12873a = null;
    }

    public final boolean mo2461o() {
        return this.f12873a != null;
    }

    public final RowKey mo2459m() {
        if (this.f12873a != null) {
            return this.f12873a;
        }
        throw new IllegalStateException();
    }
}
