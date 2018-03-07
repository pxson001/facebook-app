package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: with_tags */
public class FragmentTransitionCompat21 {

    /* compiled from: with_tags */
    public interface ViewRetriever {
        View mo14a();
    }

    /* compiled from: with_tags */
    final class C00071 extends EpicenterCallback {
        final /* synthetic */ Rect f111a;

        C00071(Rect rect) {
            this.f111a = rect;
        }

        public final Rect onGetEpicenter(Transition transition) {
            return this.f111a;
        }
    }

    /* compiled from: with_tags */
    final class C00082 implements OnPreDrawListener {
        final /* synthetic */ View f112a;
        final /* synthetic */ ViewRetriever f113b;
        final /* synthetic */ Map f114c;
        final /* synthetic */ Map f115d;
        final /* synthetic */ Transition f116e;
        final /* synthetic */ ArrayList f117f;
        final /* synthetic */ View f118g;

        C00082(View view, ViewRetriever viewRetriever, Map map, Map map2, Transition transition, ArrayList arrayList, View view2) {
            this.f112a = view;
            this.f113b = viewRetriever;
            this.f114c = map;
            this.f115d = map2;
            this.f116e = transition;
            this.f117f = arrayList;
            this.f118g = view2;
        }

        public final boolean onPreDraw() {
            this.f112a.getViewTreeObserver().removeOnPreDrawListener(this);
            View a = this.f113b.mo14a();
            if (a != null) {
                if (!this.f114c.isEmpty()) {
                    FragmentTransitionCompat21.m93a(this.f115d, a);
                    this.f115d.keySet().retainAll(this.f114c.values());
                    for (Entry entry : this.f114c.entrySet()) {
                        View view = (View) this.f115d.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f116e != null) {
                    FragmentTransitionCompat21.m97b(this.f117f, a);
                    this.f117f.removeAll(this.f115d.values());
                    this.f117f.add(this.f118g);
                    this.f116e.removeTarget(this.f118g);
                    FragmentTransitionCompat21.m96b(this.f116e, this.f117f);
                }
            }
            return true;
        }
    }

    /* compiled from: with_tags */
    final class C00093 extends EpicenterCallback {
        final /* synthetic */ EpicenterView f119a;
        private Rect f120b;

        C00093(EpicenterView epicenterView) {
            this.f119a = epicenterView;
        }

        public final Rect onGetEpicenter(Transition transition) {
            if (this.f120b == null && this.f119a.f132a != null) {
                this.f120b = FragmentTransitionCompat21.m98c(this.f119a.f132a);
            }
            return this.f120b;
        }
    }

    /* compiled from: with_tags */
    final class C00104 implements OnPreDrawListener {
        final /* synthetic */ View f121a;
        final /* synthetic */ Transition f122b;
        final /* synthetic */ View f123c;
        final /* synthetic */ ArrayList f124d;
        final /* synthetic */ Transition f125e;
        final /* synthetic */ ArrayList f126f;
        final /* synthetic */ Transition f127g;
        final /* synthetic */ ArrayList f128h;
        final /* synthetic */ Map f129i;
        final /* synthetic */ ArrayList f130j;
        final /* synthetic */ Transition f131k;

        C00104(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
            this.f121a = view;
            this.f122b = transition;
            this.f123c = view2;
            this.f124d = arrayList;
            this.f125e = transition2;
            this.f126f = arrayList2;
            this.f127g = transition3;
            this.f128h = arrayList3;
            this.f129i = map;
            this.f130j = arrayList4;
            this.f131k = transition4;
        }

        public final boolean onPreDraw() {
            this.f121a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f122b != null) {
                this.f122b.removeTarget(this.f123c);
                FragmentTransitionCompat21.m92a(this.f122b, this.f124d);
            }
            if (this.f125e != null) {
                FragmentTransitionCompat21.m92a(this.f125e, this.f126f);
            }
            if (this.f127g != null) {
                FragmentTransitionCompat21.m92a(this.f127g, this.f128h);
            }
            for (Entry entry : this.f129i.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.f130j.size();
            for (int i = 0; i < size; i++) {
                this.f131k.excludeTarget((View) this.f130j.get(i), false);
            }
            this.f131k.excludeTarget(this.f123c, false);
            return true;
        }
    }

    /* compiled from: with_tags */
    public class EpicenterView {
        public View f132a;
    }

    FragmentTransitionCompat21() {
    }

    public static String m85a(View view) {
        return view.getTransitionName();
    }

    public static Object m82a(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object m83a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        m97b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        m96b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static void m90a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m88a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void m89a(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new C00071(m98c(view)));
    }

    public static void m91a(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                m96b((Transition) obj2, (ArrayList) arrayList2);
            }
            if (viewRetriever != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new C00082(view, viewRetriever, map, map2, transition, arrayList, view2));
            }
            m86a(transition, epicenterView);
        }
    }

    public static Object m84a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        Object transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    private static void m86a(Transition transition, EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new C00093(epicenterView));
        }
    }

    public static Rect m98c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    public static void m97b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m97b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void m93a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m93a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m87a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C00104(view, transition, view2, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4));
        }
    }

    public static void m92a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                m92a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!m94a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void m96b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                m96b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!m94a(transition) && m95a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean m94a(Transition transition) {
        return (m95a(transition.getTargetIds()) && m95a(transition.getTargetNames()) && m95a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m95a(List list) {
        return list == null || list.isEmpty();
    }
}
