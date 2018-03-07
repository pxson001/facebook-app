package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unicode Exception */
public class HeaderLikeButtonComponent$Builder extends Builder<HeaderLikeButtonComponent> {
    public HeaderLikeButtonComponent$State f21318a;
    final /* synthetic */ HeaderLikeButtonComponent f21319b;
    private String[] f21320c = new String[]{"feedUnitProps", "environment"};
    private int f21321d = 2;
    public BitSet f21322e = new BitSet(this.f21321d);

    public HeaderLikeButtonComponent$Builder(HeaderLikeButtonComponent headerLikeButtonComponent) {
        this.f21319b = headerLikeButtonComponent;
    }

    public static void m24078a(HeaderLikeButtonComponent$Builder headerLikeButtonComponent$Builder, ComponentContext componentContext, int i, HeaderLikeButtonComponent$State headerLikeButtonComponent$State) {
        super.a(componentContext, i, headerLikeButtonComponent$State);
        headerLikeButtonComponent$Builder.f21318a = headerLikeButtonComponent$State;
        headerLikeButtonComponent$Builder.f21322e.clear();
    }

    public final Component<HeaderLikeButtonComponent> m24080d() {
        int i = 0;
        if (this.f21322e == null || this.f21322e.nextClearBit(0) >= this.f21321d) {
            HeaderLikeButtonComponent$State headerLikeButtonComponent$State = this.f21318a;
            m24079a();
            return headerLikeButtonComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21321d) {
            if (!this.f21322e.get(i)) {
                arrayList.add(this.f21320c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24079a() {
        super.a();
        this.f21318a = null;
        this.f21319b.c.a(this);
    }
}
