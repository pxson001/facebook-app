package com.facebook.common.eventbus;

/* compiled from: payment_transaction */
class TypedEventBus$3 implements Runnable {
    final /* synthetic */ TypedEventBus f5429a;
    final /* synthetic */ TypedEventBus f5430b;

    TypedEventBus$3(TypedEventBus typedEventBus, TypedEventBus typedEventBus2) {
        this.f5430b = typedEventBus;
        this.f5429a = typedEventBus2;
    }

    public void run() {
        this.f5430b.b.add(this.f5429a);
    }
}
