package com.facebook.common.eventbus;

/* compiled from: place_picker_results_loaded */
class TypedEventBus$4 implements Runnable {
    final /* synthetic */ TypedEventBus f7714a;
    final /* synthetic */ TypedEventBus f7715b;

    TypedEventBus$4(TypedEventBus typedEventBus, TypedEventBus typedEventBus2) {
        this.f7715b = typedEventBus;
        this.f7714a = typedEventBus2;
    }

    public void run() {
        this.f7715b.b.remove(this.f7714a);
    }
}
