package com.facebook.reaction.placetips;

import com.google.common.base.Optional;

/* compiled from: XStorageCleaner */
public class PlaceTipsReactionManager$4 implements Runnable {
    final /* synthetic */ Optional f20741a;
    final /* synthetic */ PlaceTipsReactionManager f20742b;

    public PlaceTipsReactionManager$4(PlaceTipsReactionManager placeTipsReactionManager, Optional optional) {
        this.f20742b = placeTipsReactionManager;
        this.f20741a = optional;
    }

    public void run() {
        PlaceTipsReactionManager.c(this.f20742b, this.f20741a);
    }
}
