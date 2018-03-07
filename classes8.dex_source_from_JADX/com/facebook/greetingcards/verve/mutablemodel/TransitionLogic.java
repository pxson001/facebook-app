package com.facebook.greetingcards.verve.mutablemodel;

import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.mutablemodel.Transition.Builder;
import com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnim;
import com.facebook.greetingcards.verve.mutablemodel.Transition.ViewAnimType;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: viewed_wallet_inactive */
public class TransitionLogic {
    public static Transition m329a(int i, int i2, ImmutableList<VMView> immutableList, ImmutableList<VMView> immutableList2, boolean z) {
        ImmutableList immutableList3;
        ImmutableList of;
        int i3;
        if (immutableList == null) {
            immutableList3 = RegularImmutableList.a;
        }
        if (immutableList2 == null) {
            of = ImmutableList.of();
        }
        Builder a = Transition.m328a();
        int size = immutableList3.size();
        for (i3 = 0; i3 < size; i3++) {
            VMView vMView = (VMView) immutableList3.get(i3);
            if (i2 < i && m330a(vMView, "magic-move-before")) {
                a.m326b(vMView, (VMView) vMView.statesMap.get("magic-move-before"));
            } else if (i2 > i && m330a(vMView, "magic-move-after")) {
                a.m326b(vMView, (VMView) vMView.statesMap.get("magic-move-after"));
            } else if (m330a(vMView, "magic-move")) {
                a.m326b(vMView, (VMView) vMView.statesMap.get("magic-move"));
            } else if (!m331a(of, vMView.name)) {
                if (z) {
                    a.m326b(vMView, vMView);
                } else {
                    a.m325b(vMView);
                }
            }
        }
        size = of.size();
        for (i3 = 0; i3 < size; i3++) {
            vMView = (VMView) of.get(i3);
            if (i < i2 && m330a(vMView, "magic-move-before")) {
                a.m323a((VMView) vMView.statesMap.get("magic-move-before"), vMView);
            } else if (i > i2 && m330a(vMView, "magic-move-after")) {
                a.m323a((VMView) vMView.statesMap.get("magic-move-after"), vMView);
            } else if (m330a(vMView, "magic-move")) {
                a.m323a((VMView) vMView.statesMap.get("magic-move"), vMView);
            } else if (m331a(immutableList3, vMView.name)) {
                a.m327c(m332b(immutableList3, vMView.name), vMView);
            } else if (z) {
                a.m323a(vMView, vMView);
            } else {
                a.m322a(vMView);
            }
        }
        ImmutableList immutableList4 = a.m320a().f361a;
        int size2 = immutableList4.size();
        size = 0;
        int i4 = 0;
        while (size < size2) {
            ViewAnim viewAnim = (ViewAnim) immutableList4.get(size);
            if (viewAnim.f356a == ViewAnimType.IN) {
                ViewAnim viewAnim2;
                for (int i5 = i4 + 1; i5 < immutableList4.size(); i5++) {
                    if (((ViewAnim) immutableList4.get(i5)).f356a == ViewAnimType.MOVE) {
                        viewAnim2 = (ViewAnim) immutableList4.get(i5);
                        break;
                    }
                }
                viewAnim2 = null;
                if (viewAnim2 != null) {
                    a.m321a(a.m319a(viewAnim));
                    a.m324a(viewAnim, a.m319a(viewAnim2));
                }
            }
            size++;
            i4++;
        }
        return a.m320a();
    }

    private static boolean m331a(ImmutableList<VMView> immutableList, String str) {
        return m332b(immutableList, str) != null;
    }

    private static VMView m332b(ImmutableList<VMView> immutableList, String str) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMView vMView = (VMView) immutableList.get(i);
            if (Objects.equal(vMView.name, str)) {
                return vMView;
            }
        }
        return null;
    }

    private static boolean m330a(VMView vMView, String str) {
        return vMView.statesMap != null && vMView.statesMap.containsKey(str);
    }
}
