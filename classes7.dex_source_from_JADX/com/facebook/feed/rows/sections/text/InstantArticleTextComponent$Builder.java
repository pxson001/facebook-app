package com.facebook.feed.rows.sections.text;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: UNDO_CLICKED */
public class InstantArticleTextComponent$Builder extends Builder<InstantArticleTextComponent> {
    public InstantArticleTextComponent$State f21579a;
    final /* synthetic */ InstantArticleTextComponent f21580b;
    private String[] f21581c = new String[]{"storyProps", "environment"};
    private int f21582d = 2;
    public BitSet f21583e = new BitSet(this.f21582d);

    public InstantArticleTextComponent$Builder(InstantArticleTextComponent instantArticleTextComponent) {
        this.f21580b = instantArticleTextComponent;
    }

    public static void m24204a(InstantArticleTextComponent$Builder instantArticleTextComponent$Builder, ComponentContext componentContext, int i, InstantArticleTextComponent$State instantArticleTextComponent$State) {
        super.a(componentContext, i, instantArticleTextComponent$State);
        instantArticleTextComponent$Builder.f21579a = instantArticleTextComponent$State;
        instantArticleTextComponent$Builder.f21583e.clear();
    }

    public final Component<InstantArticleTextComponent> m24206d() {
        int i = 0;
        if (this.f21583e == null || this.f21583e.nextClearBit(0) >= this.f21582d) {
            InstantArticleTextComponent$State instantArticleTextComponent$State = this.f21579a;
            m24205a();
            return instantArticleTextComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21582d) {
            if (!this.f21583e.get(i)) {
                arrayList.add(this.f21581c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24205a() {
        super.a();
        this.f21579a = null;
        this.f21580b.c.a(this);
    }
}
