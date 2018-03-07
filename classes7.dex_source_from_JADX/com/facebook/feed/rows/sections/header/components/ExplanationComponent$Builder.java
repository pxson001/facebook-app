package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.graphql.model.GraphQLStory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Unknown type */
public class ExplanationComponent$Builder extends Builder<ExplanationComponent> {
    ExplanationComponent$State f21204a;
    final /* synthetic */ ExplanationComponent f21205b;
    private String[] f21206c = new String[]{"storyProps", "environment", "textHeaderStyle"};
    private int f21207d = 3;
    private BitSet f21208e = new BitSet(this.f21207d);

    public ExplanationComponent$Builder(ExplanationComponent explanationComponent) {
        this.f21205b = explanationComponent;
    }

    public static void m24032a(ExplanationComponent$Builder explanationComponent$Builder, ComponentContext componentContext, int i, ExplanationComponent$State explanationComponent$State) {
        super.a(componentContext, i, explanationComponent$State);
        explanationComponent$Builder.f21204a = explanationComponent$State;
        explanationComponent$Builder.f21208e.clear();
    }

    public final ExplanationComponent$Builder m24034a(FeedProps<GraphQLStory> feedProps) {
        this.f21204a.f21209a = feedProps;
        this.f21208e.set(0);
        return this;
    }

    public final ExplanationComponent$Builder m24033a(E e) {
        this.f21204a.f21210b = e;
        this.f21208e.set(1);
        return this;
    }

    public final ExplanationComponent$Builder m24035a(TextHeaderStyle textHeaderStyle) {
        this.f21204a.f21211c = textHeaderStyle;
        this.f21208e.set(2);
        return this;
    }

    public final Component<ExplanationComponent> m24037d() {
        int i = 0;
        if (this.f21208e == null || this.f21208e.nextClearBit(0) >= this.f21207d) {
            ExplanationComponent$State explanationComponent$State = this.f21204a;
            m24036a();
            return explanationComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21207d) {
            if (!this.f21208e.get(i)) {
                arrayList.add(this.f21206c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m24036a() {
        super.a();
        this.f21204a = null;
        this.f21205b.c.a(this);
    }
}
