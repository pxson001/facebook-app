package com.facebook.multirow.api.renderers;

import android.view.View;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import java.util.ArrayList;
import java.util.List;

/* compiled from: time_elapsed */
public class PartHolder<P, S, E extends AnyEnvironment, V extends View> implements SubParts<E> {
    public final SinglePartDefinition<P, S, E, V> f3049a;
    public final P f3050b;
    public final List<PartHolder> f3051c = new ArrayList();
    public S f3052d;
    private int f3053e;

    public PartHolder(SinglePartDefinition<P, S, E, V> singlePartDefinition, int i, P p) {
        this.f3049a = singlePartDefinition;
        this.f3053e = i;
        this.f3050b = p;
    }

    public final <V2 extends View> V2 m4043a(View view) {
        return RendererUtils.a(view, this.f3053e);
    }

    public final <P2> void m4045a(SinglePartDefinition<P2, ?, ? super E, ? extends View> singlePartDefinition, P2 p2) {
        this.f3051c.add(new PartHolder(singlePartDefinition, -1, p2));
    }

    public final <P2> void m4044a(int i, SinglePartDefinition<P2, ?, ? super E, ? extends View> singlePartDefinition, P2 p2) {
        this.f3051c.add(new PartHolder(singlePartDefinition, i, p2));
    }
}
