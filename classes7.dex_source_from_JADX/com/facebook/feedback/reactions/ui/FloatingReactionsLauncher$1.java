package com.facebook.feedback.reactions.ui;

/* compiled from: share_caption */
public class FloatingReactionsLauncher$1 {
    final /* synthetic */ FloatingReactionsLauncher f3867a;

    FloatingReactionsLauncher$1(FloatingReactionsLauncher floatingReactionsLauncher) {
        this.f3867a = floatingReactionsLauncher;
    }

    public final void m4505a() {
        FloatingReactionsLauncher floatingReactionsLauncher = this.f3867a;
        if (floatingReactionsLauncher.b != null) {
            floatingReactionsLauncher.b.dismiss();
        }
        floatingReactionsLauncher.b = null;
        if (floatingReactionsLauncher.c != null) {
            floatingReactionsLauncher.c.setParticleSystemCallback(null);
            floatingReactionsLauncher.c = null;
        }
    }
}
