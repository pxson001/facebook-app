package com.facebook.feedplugins.multishare;

import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.multishare.MultiSharePagerItemViewPartDefinition.State;
import com.facebook.feedplugins.multishare.ui.MultiShareProductItemView;
import com.facebook.video.engine.ExitFullScreenResult;

/* compiled from: conncls_latency_qual */
class MultiSharePagerItemViewPartDefinition$3 implements FullscreenTransitionListener {
    final /* synthetic */ State f8010a;
    final /* synthetic */ MultiShareProductItemView f8011b;
    final /* synthetic */ MultiSharePagerItemViewPartDefinition f8012c;

    MultiSharePagerItemViewPartDefinition$3(MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition, State state, MultiShareProductItemView multiShareProductItemView) {
        this.f8012c = multiSharePagerItemViewPartDefinition;
        this.f8010a = state;
        this.f8011b = multiShareProductItemView;
    }

    public final void m9074a(ExitFullScreenResult exitFullScreenResult) {
        boolean z;
        boolean z2;
        this.f8010a.l.a(exitFullScreenResult.b, exitFullScreenResult.a);
        State state = this.f8010a;
        if (exitFullScreenResult == null || exitFullScreenResult.a || exitFullScreenResult.b || exitFullScreenResult.c < 0) {
            z = false;
        } else {
            z = true;
        }
        state.i = z;
        this.f8010a.j.a(exitFullScreenResult.c);
        this.f8010a.j.a = exitFullScreenResult.b;
        InlineVideoPersistentState inlineVideoPersistentState = this.f8010a.j;
        if (exitFullScreenResult.a) {
            z2 = false;
        } else {
            z2 = true;
        }
        inlineVideoPersistentState.d = z2;
        if (exitFullScreenResult.b) {
            this.f8010a.e.u.c();
        }
        MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition = this.f8012c;
        MultiSharePagerItemViewPartDefinition.c(this.f8010a, this.f8011b);
    }
}
