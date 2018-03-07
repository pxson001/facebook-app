package com.facebook.appdiscovery.lite.ui.widget.resultspage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appdiscovery.lite.ui.widget.resultspage.AppDiscoveryPage.State;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;

/* compiled from: selected_budget */
public class AppDiscoveryPageView extends CustomLinearLayout implements AppDiscoveryPage {
    public BetterListView f4190a = ((BetterListView) a(2131563456));
    protected State f4191b;
    public LoadingIndicatorView f4192c;
    public LinearLayout f4193d;
    public String f4194e;
    public TextView f4195f;
    public RetryClickedListener f4196g;

    public AppDiscoveryPageView(Context context) {
        super(context);
        setContentView(2130905062);
        setBackground(new ColorDrawable(getResources().getColor(2131361920)));
        this.f4192c = (LoadingIndicatorView) a(2131560407);
        this.f4193d = (LinearLayout) a(2131560287);
        this.f4195f = (TextView) a(2131563455);
        this.f4195f.setText(getResources().getString(2131239888));
        this.f4194e = getResources().getString(2131230758);
        setState(State.LOADING);
    }

    public void setState(State state) {
        if (this.f4191b != state) {
            switch (state) {
                case LOADING:
                    this.f4192c.setVisibility(0);
                    this.f4192c.a();
                    this.f4193d.setVisibility(8);
                    this.f4190a.setVisibility(8);
                    break;
                case LOAD_FINISHED:
                    this.f4192c.b();
                    this.f4192c.setVisibility(8);
                    this.f4193d.setVisibility(8);
                    BetterListView betterListView = this.f4190a;
                    if (!(betterListView.getVisibility() == 0 || (betterListView.getAnimation() instanceof AlphaAnimation))) {
                        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(1000);
                        betterListView.setVisibility(0);
                        betterListView.startAnimation(alphaAnimation);
                    }
                    break;
                case EMPTY:
                    this.f4192c.setVisibility(8);
                    this.f4190a.setVisibility(8);
                    this.f4193d.setVisibility(0);
                    requestLayout();
                    break;
                case ERROR:
                    this.f4192c.setVisibility(0);
                    this.f4192c.a(this.f4194e, this.f4196g);
                    this.f4193d.setVisibility(8);
                    this.f4190a.setVisibility(8);
                    break;
                default:
                    throw new IllegalStateException("Unimplemented state");
            }
            this.f4191b = state;
        }
    }

    public State getCurrentState() {
        return this.f4191b;
    }
}
