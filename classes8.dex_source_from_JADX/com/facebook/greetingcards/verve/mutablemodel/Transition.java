package com.facebook.greetingcards.verve.mutablemodel;

import com.facebook.greetingcards.verve.model.VMView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: viewer's tag can't be found in tag list */
public class Transition {
    public static final VMView f359b;
    public static final VMView f360c;
    public final ImmutableList<ViewAnim> f361a;

    /* compiled from: viewer's tag can't be found in tag list */
    public class Builder {
        private final ArrayList<ViewAnim> f355a = Lists.a();

        public final void m322a(VMView vMView) {
            m323a(Transition.f359b, vMView);
        }

        public final void m323a(VMView vMView, VMView vMView2) {
            this.f355a.add(new ViewAnim(ViewAnimType.IN, vMView, vMView2));
        }

        public final void m325b(VMView vMView) {
            m326b(vMView, Transition.f360c);
        }

        public final void m326b(VMView vMView, VMView vMView2) {
            this.f355a.add(new ViewAnim(ViewAnimType.OUT, vMView, vMView2));
        }

        public final void m327c(VMView vMView, VMView vMView2) {
            this.f355a.add(new ViewAnim(ViewAnimType.MOVE, vMView, vMView2));
        }

        public final void m321a(int i) {
            this.f355a.remove(i);
        }

        public final void m324a(ViewAnim viewAnim, int i) {
            this.f355a.add(i, viewAnim);
        }

        public final int m319a(ViewAnim viewAnim) {
            return this.f355a.indexOf(viewAnim);
        }

        public final Transition m320a() {
            return new Transition(ImmutableList.copyOf(this.f355a));
        }
    }

    /* compiled from: viewer's tag can't be found in tag list */
    public class ViewAnim {
        public final ViewAnimType f356a;
        public final VMView f357b;
        public final VMView f358c;

        public ViewAnim(ViewAnimType viewAnimType, VMView vMView, VMView vMView2) {
            this.f356a = viewAnimType;
            this.f357b = vMView;
            this.f358c = vMView2;
        }
    }

    /* compiled from: viewer's tag can't be found in tag list */
    public enum ViewAnimType {
        IN,
        OUT,
        MOVE
    }

    static {
        com.facebook.greetingcards.verve.model.VMView.Builder p = VMView.m289p();
        p.f315h = Float.valueOf(0.0f);
        VMView a = p.m287a();
        f359b = a;
        f360c = a;
    }

    public Transition(ImmutableList<ViewAnim> immutableList) {
        this.f361a = immutableList;
    }

    public static Builder m328a() {
        return new Builder();
    }
}
