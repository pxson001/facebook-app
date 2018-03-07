package com.google.common.collect;

import com.google.common.collect.ImmutableSet.Indexed;

/* compiled from: buyer_email */
class ImmutableSet$Indexed$1 extends ImmutableAsList<E> {
    final /* synthetic */ Indexed this$0;

    ImmutableSet$Indexed$1(Indexed indexed) {
        this.this$0 = indexed;
    }

    public E get(int i) {
        return this.this$0.a(i);
    }

    final ImmutableCollection m13404a() {
        return this.this$0;
    }
}
