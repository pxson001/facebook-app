package com.facebook.reaction.placetips;

import com.google.common.base.Optional;

/* compiled from: XStorageCleaner */
public class PlaceTipsReactionManager$5 implements Runnable {
    final /* synthetic */ Optional f20743a;
    final /* synthetic */ PlaceTipsReactionManager f20744b;

    public PlaceTipsReactionManager$5(PlaceTipsReactionManager placeTipsReactionManager, Optional optional) {
        this.f20744b = placeTipsReactionManager;
        this.f20743a = optional;
    }

    public void run() {
        PlaceTipsReactionManager.d(this.f20744b, this.f20743a);
    }
}
