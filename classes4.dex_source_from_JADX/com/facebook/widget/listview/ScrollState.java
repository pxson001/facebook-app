package com.facebook.widget.listview;

import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: proximity */
public class ScrollState {
    public final ScrollPosition f12741a;
    public final ImmutableMap<Long, Integer> f12742b;

    /* compiled from: proximity */
    public enum ScrollPosition {
        BOTTOM,
        TOP,
        MIDDLE
    }

    public ScrollState(ScrollPosition scrollPosition, ImmutableMap<Long, Integer> immutableMap) {
        this.f12741a = scrollPosition;
        this.f12742b = immutableMap;
    }

    public String toString() {
        return this.f12741a + " " + this.f12742b;
    }
}
