package com.facebook.vault.service;

/* compiled from: thread */
class VaultManager$2 implements Runnable {
    final /* synthetic */ VaultManager f1887a;

    VaultManager$2(VaultManager vaultManager) {
        this.f1887a = vaultManager;
    }

    public void run() {
        ((VaultTable) this.f1887a.m.get()).a(0);
    }
}
