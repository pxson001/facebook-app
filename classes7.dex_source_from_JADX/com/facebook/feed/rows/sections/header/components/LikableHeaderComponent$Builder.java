package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unexpected height! expected= */
public class LikableHeaderComponent$Builder extends Builder<LikableHeaderComponent> {
    public LikableHeaderComponent$State f21359a;
    final /* synthetic */ LikableHeaderComponent f21360b;
    private String[] f21361c = new String[]{"storyProps", "environment"};
    private int f21362d = 2;
    public BitSet f21363e = new BitSet(this.f21362d);

    public LikableHeaderComponent$Builder(LikableHeaderComponent likableHeaderComponent) {
        this.f21360b = likableHeaderComponent;
    }

    public static void m24092a(LikableHeaderComponent$Builder likableHeaderComponent$Builder, ComponentContext componentContext, int i, LikableHeaderComponent$State likableHeaderComponent$State) {
        super.a(componentContext, i, likableHeaderComponent$State);
        likableHeaderComponent$Builder.f21359a = likableHeaderComponent$State;
        likableHeaderComponent$Builder.f21363e.clear();
    }

    public final Component<LikableHeaderComponent> m24094d() {
        int i = 0;
        if (this.f21363e == null || this.f21363e.nextClearBit(0) >= this.f21362d) {
            LikableHeaderComponent$State likableHeaderComponent$State = this.f21359a;
            m24093a();
            return likableHeaderComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21362d) {
            if (!this.f21363e.get(i)) {
                arrayList.add(this.f21361c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24093a() {
        super.a();
        this.f21359a = null;
        this.f21360b.c.a(this);
    }
}
