package com.facebook.springs;

import com.facebook.ui.animations.ListViewEntryAnimator;
import com.facebook.ui.animations.ListViewEntryAnimator.AnimationState;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: connection_class */
public class SpringCurve {
    public final ChoreographerWrapper f5274a;
    public final List<Double> f5275b;
    public final Map<Integer, List<Object>> f5276c;
    public ListViewEntryAnimator f5277d;
    public boolean f5278e = true;
    public int f5279f;
    public int f5280g;
    public int f5281h;
    public final FrameCallbackWrapper f5282i = new C04941(this);

    /* compiled from: connection_class */
    class C04941 extends FrameCallbackWrapper {
        final /* synthetic */ SpringCurve f5273a;

        C04941(SpringCurve springCurve) {
            this.f5273a = springCurve;
        }

        public final void m10188a(long j) {
            if (this.f5273a.f5279f < this.f5273a.f5280g) {
                SpringCurve springCurve = this.f5273a;
                springCurve.f5279f++;
            }
            for (int max = Math.max(0, (this.f5273a.f5281h - this.f5273a.f5275b.size()) + 1); max < this.f5273a.f5279f; max++) {
                List list = (List) this.f5273a.f5276c.get(Integer.valueOf(max));
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i);
                        ((Double) this.f5273a.f5275b.get(this.f5273a.f5281h - max)).doubleValue();
                    }
                }
            }
            if (this.f5273a.f5281h < (this.f5273a.f5280g + this.f5273a.f5275b.size()) - 1) {
                springCurve = this.f5273a;
                springCurve.f5281h++;
                this.f5273a.f5274a.a(this.f5273a.f5282i);
                return;
            }
            this.f5273a.f5278e = true;
            if (this.f5273a.f5277d != null) {
                ListViewEntryAnimator listViewEntryAnimator = this.f5273a.f5277d;
                Preconditions.checkState(listViewEntryAnimator.f5367e != AnimationState.COMPLETE, "Entry animation cannot complete twice.");
                listViewEntryAnimator.f5367e = AnimationState.COMPLETE;
            }
        }
    }

    @Inject
    public SpringCurve(ChoreographerWrapper choreographerWrapper) {
        this.f5274a = choreographerWrapper;
        this.f5275b = Lists.a();
        this.f5276c = Maps.c();
    }
}
