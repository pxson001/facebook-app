package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unknown module type  */
public class FollowButtonComponent$Builder extends Builder<FollowButtonComponent> {
    public FollowButtonComponent$State f21241a;
    final /* synthetic */ FollowButtonComponent f21242b;
    private String[] f21243c = new String[]{"feedUnitProps", "profileId", "subscribeStatus", "environment", "subscribeLocation", "unsubscribeLocation"};
    private int f21244d = 6;
    public BitSet f21245e = new BitSet(this.f21244d);

    public FollowButtonComponent$Builder(FollowButtonComponent followButtonComponent) {
        this.f21242b = followButtonComponent;
    }

    public static void m24044a(FollowButtonComponent$Builder followButtonComponent$Builder, ComponentContext componentContext, int i, FollowButtonComponent$State followButtonComponent$State) {
        super.a(componentContext, i, followButtonComponent$State);
        followButtonComponent$Builder.f21241a = followButtonComponent$State;
        followButtonComponent$Builder.f21245e.clear();
    }

    public final Component<FollowButtonComponent> m24046d() {
        int i = 0;
        if (this.f21245e == null || this.f21245e.nextClearBit(0) >= this.f21244d) {
            FollowButtonComponent$State followButtonComponent$State = this.f21241a;
            m24045a();
            return followButtonComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21244d) {
            if (!this.f21245e.get(i)) {
                arrayList.add(this.f21243c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24045a() {
        super.a();
        this.f21241a = null;
        this.f21242b.c.a(this);
    }
}
