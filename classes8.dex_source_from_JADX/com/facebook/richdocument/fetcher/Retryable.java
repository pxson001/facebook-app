package com.facebook.richdocument.fetcher;

/* compiled from: product_item_image_size */
public abstract class Retryable {
    private boolean f5054a = false;

    protected abstract void mo246b();

    public final void m5048a() {
        if (!this.f5054a) {
            this.f5054a = true;
            mo246b();
        }
    }
}
