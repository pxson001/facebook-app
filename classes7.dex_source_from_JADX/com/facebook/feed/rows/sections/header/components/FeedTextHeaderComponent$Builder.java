package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unknown query param name  */
public class FeedTextHeaderComponent$Builder extends Builder<FeedTextHeaderComponent> {
    public FeedTextHeaderComponent$State f21230a;
    final /* synthetic */ FeedTextHeaderComponent f21231b;
    private String[] f21232c = new String[]{"storyProps", "environment"};
    private int f21233d = 2;
    public BitSet f21234e = new BitSet(this.f21233d);

    public FeedTextHeaderComponent$Builder(FeedTextHeaderComponent feedTextHeaderComponent) {
        this.f21231b = feedTextHeaderComponent;
    }

    public static void m24041a(FeedTextHeaderComponent$Builder feedTextHeaderComponent$Builder, ComponentContext componentContext, int i, FeedTextHeaderComponent$State feedTextHeaderComponent$State) {
        super.a(componentContext, i, feedTextHeaderComponent$State);
        feedTextHeaderComponent$Builder.f21230a = feedTextHeaderComponent$State;
        feedTextHeaderComponent$Builder.f21234e.clear();
    }

    public final Component<FeedTextHeaderComponent> m24043d() {
        int i = 0;
        if (this.f21234e == null || this.f21234e.nextClearBit(0) >= this.f21233d) {
            FeedTextHeaderComponent$State feedTextHeaderComponent$State = this.f21230a;
            m24042a();
            return feedTextHeaderComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21233d) {
            if (!this.f21234e.get(i)) {
                arrayList.add(this.f21232c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24042a() {
        super.a();
        this.f21230a = null;
        this.f21231b.c.a(this);
    }
}
