package com.facebook.apptab.ui.nux;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController.State;

/* compiled from: profile_wizard_nux_view */
class FbMainTabActivityNuxController$NuxBubbleTouchListener implements OnTouchListener {
    final /* synthetic */ FbMainTabActivityNuxController f7242a;

    public FbMainTabActivityNuxController$NuxBubbleTouchListener(FbMainTabActivityNuxController fbMainTabActivityNuxController) {
        this.f7242a = fbMainTabActivityNuxController;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (1 == motionEvent.getAction()) {
            switch (FbMainTabActivityNuxController$1.f7241a[this.f7242a.a.ordinal()]) {
                case 1:
                    FbMainTabActivityNuxController.a(this.f7242a, State.SHOWN_MORE);
                    break;
                case 2:
                    FbMainTabActivityNuxController.a(this.f7242a, State.HIDDEN);
                    break;
            }
        }
        return true;
    }
}
