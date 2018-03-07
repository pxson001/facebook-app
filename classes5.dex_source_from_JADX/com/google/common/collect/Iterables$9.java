package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

/* compiled from: button_icon_image */
final class Iterables$9 extends FluentIterable<T> {
    final /* synthetic */ List f7359a;
    final /* synthetic */ int f7360b;

    Iterables$9(List list, int i) {
        this.f7359a = list;
        this.f7360b = i;
    }

    public final Iterator<T> iterator() {
        return this.f7359a.subList(Math.min(this.f7359a.size(), this.f7360b), this.f7359a.size()).iterator();
    }
}
