package com.facebook.today.ui.notificationslist;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.feedback.ui.AbstractPillController;
import com.facebook.inject.Assisted;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: transferType */
public class TodayNotificationPillController extends AbstractPillController {
    public int f1374a;
    public LazyView<View> f1375b;
    public View f1376c;
    public OnClickListener f1377d;

    @Inject
    public TodayNotificationPillController(@Assisted View view, SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        super(springSystem, viewHelperViewAnimatorFactory);
        this.f1376c = view;
        if (this.f1376c instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) this.f1376c;
            View viewStub = new ViewStub(frameLayout.getContext());
            viewStub.setLayoutResource(2130905442);
            viewStub.setVisibility(8);
            this.f1375b = new LazyView(viewStub);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = frameLayout.getContext().getResources().getDimensionPixelOffset(2131427419);
            frameLayout.addView(viewStub, layoutParams);
        }
    }

    protected final LazyView<? extends View> m1498g() {
        return this.f1375b;
    }
}
