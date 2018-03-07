package com.facebook.facecast.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ScrollView;
import com.facebook.facecast.plugin.FacecastEndScreenAnimationHelper.EnterExitAnimatorsBuilder;
import com.facebook.facecast.plugin.FacecastEndScreenAnimationHelper.TransitionAnimators;
import com.facebook.facecast.plugin.FacecastEndScreenV2Plugin.C15654;
import com.facebook.facecast.view.FacecastVideoPlaybackContainer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: borderWidth */
public class FacecastEndScreenV2FullscreenTransitionController {
    public final ViewGroup f18332a;
    private final ScrollView f18333b;
    public final ViewGroup f18334c;
    private final FacecastVideoPlaybackContainer f18335d;
    public final ViewGroup f18336e;
    public boolean f18337f = false;
    public boolean f18338g = false;
    public TransitionAnimators f18339h;
    public C15654 f18340i;

    /* compiled from: borderWidth */
    public class C15561 implements Runnable {
        final /* synthetic */ FacecastEndScreenV2FullscreenTransitionController f18326a;

        public C15561(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
            this.f18326a = facecastEndScreenV2FullscreenTransitionController;
        }

        public void run() {
            this.f18326a.f18338g = true;
        }
    }

    /* compiled from: borderWidth */
    public class C15572 implements Runnable {
        final /* synthetic */ FacecastEndScreenV2FullscreenTransitionController f18327a;

        public C15572(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
            this.f18327a = facecastEndScreenV2FullscreenTransitionController;
        }

        public void run() {
            this.f18327a.f18338g = false;
        }
    }

    /* compiled from: borderWidth */
    public class C15583 implements Runnable {
        final /* synthetic */ FacecastEndScreenV2FullscreenTransitionController f18328a;

        public C15583(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
            this.f18328a = facecastEndScreenV2FullscreenTransitionController;
        }

        public void run() {
            if (this.f18328a.f18340i != null) {
                this.f18328a.f18340i.f18353a.f18387r.m22438u();
            }
        }
    }

    /* compiled from: borderWidth */
    public class C15594 implements Runnable {
        final /* synthetic */ FacecastEndScreenV2FullscreenTransitionController f18329a;

        public C15594(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
            this.f18329a = facecastEndScreenV2FullscreenTransitionController;
        }

        public void run() {
            if (this.f18329a.f18340i != null) {
                this.f18329a.f18340i.f18353a.f18387r.m22437t();
            }
        }
    }

    /* compiled from: borderWidth */
    public class C15615 implements Runnable {
        final /* synthetic */ FacecastEndScreenV2FullscreenTransitionController f18331a;

        /* compiled from: borderWidth */
        class C15601 implements OnPreDrawListener {
            final /* synthetic */ C15615 f18330a;

            C15601(C15615 c15615) {
                this.f18330a = c15615;
            }

            public boolean onPreDraw() {
                this.f18330a.f18331a.f18334c.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f18330a.f18331a.f18334c.setTranslationY(FacecastEndScreenV2FullscreenTransitionController.m22038g(this.f18330a.f18331a));
                return true;
            }
        }

        public C15615(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
            this.f18331a = facecastEndScreenV2FullscreenTransitionController;
        }

        public void run() {
            this.f18331a.f18334c.getViewTreeObserver().addOnPreDrawListener(new C15601(this));
        }
    }

    public FacecastEndScreenV2FullscreenTransitionController(ViewGroup viewGroup, ScrollView scrollView, FacecastVideoPlaybackContainer facecastVideoPlaybackContainer, ViewGroup viewGroup2) {
        this.f18332a = viewGroup;
        this.f18333b = scrollView;
        this.f18334c = (ViewGroup) scrollView.getChildAt(0);
        this.f18335d = facecastVideoPlaybackContainer;
        this.f18336e = viewGroup2;
    }

    public static float m22038g(FacecastEndScreenV2FullscreenTransitionController facecastEndScreenV2FullscreenTransitionController) {
        return ((((float) facecastEndScreenV2FullscreenTransitionController.f18332a.getHeight()) / 2.0f) - (((float) facecastEndScreenV2FullscreenTransitionController.f18335d.getHeight()) / 2.0f)) + ((float) facecastEndScreenV2FullscreenTransitionController.f18333b.getScrollY());
    }

    public final void m22039a() {
        int i;
        this.f18337f = true;
        EnterExitAnimatorsBuilder enterExitAnimatorsBuilder = new EnterExitAnimatorsBuilder();
        Runnable c15561 = new C15561(this);
        Runnable c15572 = new C15572(this);
        enterExitAnimatorsBuilder.m22016a(c15561).m22020c(c15572).m22019b(c15561).f18291f.add(c15572);
        if (this.f18340i != null) {
            enterExitAnimatorsBuilder.m22016a(new C15594(this)).m22019b(new C15583(this));
        }
        float g = m22038g(this);
        View view = this.f18334c;
        enterExitAnimatorsBuilder.m22015a(FacecastEndScreenAnimationHelper.m22024b(view, g)).m22018b(FacecastEndScreenAnimationHelper.m22024b(view, 0.0f));
        enterExitAnimatorsBuilder.m22020c(new C15615(this));
        FacecastEndScreenAnimationHelper.m22023a(enterExitAnimatorsBuilder, this.f18336e);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (i = 0; i < this.f18332a.getChildCount(); i++) {
            View childAt = this.f18332a.getChildAt(i);
            if (!((childAt instanceof ScrollView) || (childAt instanceof ViewStub) || childAt.getVisibility() != 0)) {
                arrayList2.add(childAt);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2 = new ArrayList();
        for (i = 0; i < this.f18334c.getChildCount(); i++) {
            childAt = this.f18334c.getChildAt(i);
            if (!((childAt instanceof FacecastVideoPlaybackContainer) || (childAt instanceof ViewStub) || childAt.getVisibility() != 0)) {
                arrayList2.add(childAt);
            }
        }
        arrayList.addAll(arrayList2);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FacecastEndScreenAnimationHelper.m22023a(enterExitAnimatorsBuilder, (View) arrayList.get(i2));
        }
        View view2 = this.f18332a;
        enterExitAnimatorsBuilder.m22015a(FacecastEndScreenAnimationHelper.m22022a(view2, -1, -16777216)).m22018b(FacecastEndScreenAnimationHelper.m22022a(view2, -16777216, -1));
        this.f18339h = enterExitAnimatorsBuilder.m22017a();
        this.f18339h.f18292a.start();
    }
}
