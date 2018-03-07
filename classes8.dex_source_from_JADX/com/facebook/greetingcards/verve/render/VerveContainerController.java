package com.facebook.greetingcards.verve.render;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.facebook.greetingcards.verve.mutablemodel.Transition;
import com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnim;
import com.facebook.greetingcards.verve.mutablemodel.TransitionLogic;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: view_result_list */
public class VerveContainerController {
    public final FrameLayout f399a;
    private final DeckInfo f400b;
    public final TransitionValueSetter f401c = new TransitionValueSetter();
    public final Set<Integer> f402d = Sets.b();
    private final SparseArrayCompat<ImmutableList<VMView>> f403e = new SparseArrayCompat();
    public final SparseArrayCompat<VMView> f404f = new SparseArrayCompat();
    public final SparseArrayCompat<View> f405g = new SparseArrayCompat();
    private VMView f406h;

    public VerveContainerController(FrameLayout frameLayout, DeckInfo deckInfo) {
        this.f399a = frameLayout;
        this.f400b = deckInfo;
    }

    public final void m380a(VMView vMView, int i) {
        if (this.f406h != null) {
            VerveViewFactory.m408a(this.f400b, this.f399a);
            this.f402d.clear();
            this.f403e.b();
            this.f404f.b();
            this.f405g.b();
        }
        this.f406h = vMView;
        m375a(vMView.subviews, i);
    }

    public final void m377a() {
        ImmutableList immutableList = this.f406h.subviews;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m376b(((VMView) immutableList.get(i)).f340a);
        }
    }

    public final void m379a(int i, int i2, VMView vMView, VMView vMView2) {
        ImmutableList immutableList = null;
        if (!(vMView == null || vMView.subviews == null)) {
            m375a(vMView.subviews, i);
        }
        if (!(vMView2 == null || vMView2.subviews == null)) {
            m375a(vMView2.subviews, i2);
        }
        ImmutableList immutableList2 = vMView == null ? null : vMView.subviews;
        if (vMView2 != null) {
            immutableList = vMView2.subviews;
        }
        Transition a = TransitionLogic.m329a(i, i2, immutableList2, immutableList, true);
        ImmutableList immutableList3 = a.f361a;
        int size = immutableList3.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewAnim viewAnim = (ViewAnim) immutableList3.get(i3);
            switch (viewAnim.f356a) {
                case IN:
                    ViewPropertiesUtil.m415b((View) this.f405g.a(viewAnim.f358c.f340a), viewAnim.f357b);
                    m376b(viewAnim.f358c.f340a);
                    break;
                case OUT:
                case MOVE:
                    this.f399a.bringChildToFront((View) this.f405g.a(viewAnim.f357b.f340a));
                    break;
                default:
                    break;
            }
        }
        this.f401c.f397b = a;
    }

    public final void m378a(int i) {
        Set<Integer> a = Sets.a();
        for (Integer intValue : this.f402d) {
            a.add(Integer.valueOf(intValue.intValue()));
        }
        ImmutableList immutableList = (ImmutableList) this.f403e.a(i);
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                VMView vMView = (VMView) immutableList.get(i2);
                if (this.f402d.contains(Integer.valueOf(vMView.f340a))) {
                    this.f399a.bringChildToFront((View) this.f405g.a(vMView.f340a));
                } else {
                    m376b(vMView.f340a);
                }
                a.remove(Integer.valueOf(vMView.f340a));
            }
        }
        for (Integer intValue2 : a) {
            int intValue3 = intValue2.intValue();
            this.f402d.remove(Integer.valueOf(intValue3));
            View view = (View) this.f405g.a(intValue3);
            ViewPropertiesUtil.m413a(view, (VMView) this.f404f.a(intValue3));
            this.f399a.removeView(view);
        }
    }

    private void m375a(ImmutableList<VMView> immutableList, int i) {
        if (this.f403e.a(i) == null) {
            this.f403e.b(i, immutableList);
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                VMView vMView = (VMView) immutableList.get(i2);
                this.f404f.b(vMView.f340a, vMView);
            }
            VerveViewFactory.m409a((ImmutableList) immutableList, i, this.f400b, this.f399a.getContext(), this.f405g);
        }
    }

    private void m376b(int i) {
        this.f402d.add(Integer.valueOf(i));
        this.f399a.addView((View) this.f405g.a(i));
    }
}
