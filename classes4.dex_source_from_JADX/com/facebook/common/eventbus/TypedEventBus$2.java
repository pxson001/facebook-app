package com.facebook.common.eventbus;

import java.util.List;

/* compiled from: payment_transaction */
class TypedEventBus$2 implements Runnable {
    final /* synthetic */ Class f5315a;
    final /* synthetic */ TypedHandler f5316b;
    final /* synthetic */ TypedEventBus f5317c;

    TypedEventBus$2(TypedEventBus typedEventBus, Class cls, TypedHandler typedHandler) {
        this.f5317c = typedEventBus;
        this.f5315a = cls;
        this.f5316b = typedHandler;
    }

    public void run() {
        List list = (List) this.f5317c.a.get(this.f5315a);
        if (list != null) {
            list.remove(this.f5316b);
        }
    }
}
