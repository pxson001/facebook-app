package com.facebook.common.network;

/* compiled from: show_sponsored_label */
class FbDataConnectionManager$NetworkConnectivityChangeRunnable implements Runnable {
    final /* synthetic */ FbDataConnectionManager f2715a;
    private boolean f2716b;

    public FbDataConnectionManager$NetworkConnectivityChangeRunnable(FbDataConnectionManager fbDataConnectionManager, boolean z) {
        this.f2715a = fbDataConnectionManager;
        this.f2716b = z;
    }

    public void run() {
        if (FbDataConnectionManager.j(this.f2715a) == this.f2716b) {
            FbDataConnectionManager.n(this.f2715a);
        }
    }
}
