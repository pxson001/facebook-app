package com.facebook.ui.drawers;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: ensureSync full refresh delayed because it was already performed recently. */
public class DrawerController$StateChangeFuture {
    public DrawerState f15266a;
    public SettableFuture<Void> f15267b = SettableFuture.f();

    public DrawerController$StateChangeFuture(DrawerState drawerState) {
        this.f15266a = (DrawerState) Preconditions.checkNotNull(drawerState);
    }

    public final void m19260c() {
        this.f15267b.cancel(false);
    }
}
