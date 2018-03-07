package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unknown query param type  */
public class ExplanationTextComponent$Builder extends Builder<ExplanationTextComponent> {
    public ExplanationTextComponent$State f21216a;
    final /* synthetic */ ExplanationTextComponent f21217b;
    private String[] f21218c = new String[]{"storyProps", "environment", "textColor", "textSize", "textStyle"};
    private int f21219d = 5;
    public BitSet f21220e = new BitSet(this.f21219d);

    public ExplanationTextComponent$Builder(ExplanationTextComponent explanationTextComponent) {
        this.f21217b = explanationTextComponent;
    }

    public static void m24038a(ExplanationTextComponent$Builder explanationTextComponent$Builder, ComponentContext componentContext, int i, ExplanationTextComponent$State explanationTextComponent$State) {
        super.a(componentContext, i, explanationTextComponent$State);
        explanationTextComponent$Builder.f21216a = explanationTextComponent$State;
        explanationTextComponent$Builder.f21220e.clear();
    }

    public final Component<ExplanationTextComponent> m24040d() {
        int i = 0;
        if (this.f21220e == null || this.f21220e.nextClearBit(0) >= this.f21219d) {
            ExplanationTextComponent$State explanationTextComponent$State = this.f21216a;
            m24039a();
            return explanationTextComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21219d) {
            if (!this.f21220e.get(i)) {
                arrayList.add(this.f21218c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24039a() {
        super.a();
        this.f21216a = null;
        this.f21217b.c.a(this);
    }
}
