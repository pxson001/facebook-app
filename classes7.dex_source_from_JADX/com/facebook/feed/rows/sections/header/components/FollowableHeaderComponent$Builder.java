package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unknown condition type  */
public class FollowableHeaderComponent$Builder extends Builder<FollowableHeaderComponent> {
    public FollowableHeaderComponent$State f21258a;
    final /* synthetic */ FollowableHeaderComponent f21259b;
    private String[] f21260c = new String[]{"storyProps", "environment"};
    private int f21261d = 2;
    public BitSet f21262e = new BitSet(this.f21261d);

    public FollowableHeaderComponent$Builder(FollowableHeaderComponent followableHeaderComponent) {
        this.f21259b = followableHeaderComponent;
    }

    public static void m24047a(FollowableHeaderComponent$Builder followableHeaderComponent$Builder, ComponentContext componentContext, int i, FollowableHeaderComponent$State followableHeaderComponent$State) {
        super.a(componentContext, i, followableHeaderComponent$State);
        followableHeaderComponent$Builder.f21258a = followableHeaderComponent$State;
        followableHeaderComponent$Builder.f21262e.clear();
    }

    public final Component<FollowableHeaderComponent> m24049d() {
        int i = 0;
        if (this.f21262e == null || this.f21262e.nextClearBit(0) >= this.f21261d) {
            FollowableHeaderComponent$State followableHeaderComponent$State = this.f21258a;
            m24048a();
            return followableHeaderComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21261d) {
            if (!this.f21262e.get(i)) {
                arrayList.add(this.f21260c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24048a() {
        super.a();
        this.f21258a = null;
        this.f21259b.c.a(this);
    }
}
