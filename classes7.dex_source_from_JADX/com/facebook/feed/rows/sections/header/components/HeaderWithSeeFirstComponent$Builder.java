package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unexpected moov box. */
public class HeaderWithSeeFirstComponent$Builder extends Builder<HeaderWithSeeFirstComponent> {
    public HeaderWithSeeFirstComponent$State f21348a;
    final /* synthetic */ HeaderWithSeeFirstComponent f21349b;
    private String[] f21350c = new String[]{"storyProps", "environment"};
    private int f21351d = 2;
    public BitSet f21352e = new BitSet(this.f21351d);

    public HeaderWithSeeFirstComponent$Builder(HeaderWithSeeFirstComponent headerWithSeeFirstComponent) {
        this.f21349b = headerWithSeeFirstComponent;
    }

    public static void m24089a(HeaderWithSeeFirstComponent$Builder headerWithSeeFirstComponent$Builder, ComponentContext componentContext, int i, HeaderWithSeeFirstComponent$State headerWithSeeFirstComponent$State) {
        super.a(componentContext, i, headerWithSeeFirstComponent$State);
        headerWithSeeFirstComponent$Builder.f21348a = headerWithSeeFirstComponent$State;
        headerWithSeeFirstComponent$Builder.f21352e.clear();
    }

    public final Component<HeaderWithSeeFirstComponent> m24091d() {
        int i = 0;
        if (this.f21352e == null || this.f21352e.nextClearBit(0) >= this.f21351d) {
            HeaderWithSeeFirstComponent$State headerWithSeeFirstComponent$State = this.f21348a;
            m24090a();
            return headerWithSeeFirstComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21351d) {
            if (!this.f21352e.get(i)) {
                arrayList.add(this.f21350c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24090a() {
        super.a();
        this.f21348a = null;
        this.f21349b.c.a(this);
    }
}
