package com.facebook.greetingcards.verve.render;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: view_post_insights */
public class VerveSequenceView extends FrameLayout {
    private final DeckInfo f420a;
    private final SparseArrayCompat<View> f421b;
    public final Handler f422c;
    private VMView f423d;
    public int f424e;
    private NoTransition f425f;
    private int f426g;
    public final Runnable f427h = new C00481(this);

    /* compiled from: view_post_insights */
    class C00481 implements Runnable {
        final /* synthetic */ VerveSequenceView f418a;

        C00481(VerveSequenceView verveSequenceView) {
            this.f418a = verveSequenceView;
        }

        public void run() {
            VerveSequenceView.m401a(this.f418a);
        }
    }

    /* compiled from: view_post_insights */
    public class C00492 {
        public final /* synthetic */ VerveSequenceView f419a;

        C00492(VerveSequenceView verveSequenceView) {
            this.f419a = verveSequenceView;
        }
    }

    public VerveSequenceView(Context context, DeckInfo deckInfo) {
        super(context);
        this.f420a = deckInfo;
        this.f421b = new SparseArrayCompat();
        this.f422c = new Handler();
    }

    public final void m402a(VMView vMView, int i) {
        this.f423d = vMView;
        this.f426g = 0;
        this.f421b.b();
        this.f425f = new NoTransition();
        this.f424e = (int) (this.f423d.m300g() * 1000.0f);
        VerveViewFactory.m409a(vMView.subviews, i, this.f420a, getContext(), this.f421b);
        addView(m400a(this.f426g));
        HandlerDetour.b(this.f422c, this.f427h, 1000, -229237367);
    }

    public static void m401a(VerveSequenceView verveSequenceView) {
        if (verveSequenceView.f423d.subviews != null && !verveSequenceView.f423d.subviews.isEmpty()) {
            View a = verveSequenceView.m400a(verveSequenceView.f426g);
            verveSequenceView.f426g = (verveSequenceView.f426g + 1) % verveSequenceView.f423d.subviews.size();
            View a2 = verveSequenceView.m400a(verveSequenceView.f426g);
            verveSequenceView.addView(a2);
            NoTransition noTransition = verveSequenceView.f425f;
            C00492 c00492 = new C00492(verveSequenceView);
            a.setVisibility(8);
            a2.setVisibility(0);
            if (c00492 != null) {
                c00492.f419a.removeView(a);
                HandlerDetour.b(c00492.f419a.f422c, c00492.f419a.f427h, (long) c00492.f419a.f424e, 1319392747);
            }
        }
    }

    private View m400a(int i) {
        return (View) this.f421b.a(((VMView) this.f423d.subviews.get(i)).f340a);
    }
}
