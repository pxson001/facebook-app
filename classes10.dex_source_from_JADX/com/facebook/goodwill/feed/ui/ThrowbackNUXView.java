package com.facebook.goodwill.feed.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.goodwill.feed.data.ThrowbackFeedResources;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;

/* compiled from: VALID_AND_EXPIRED */
public class ThrowbackNUXView extends FbRelativeLayout {
    View f21239a;
    View f21240b;
    Button f21241c;
    LoadingIndicatorView f21242d;

    public ThrowbackNUXView(Context context) {
        super(context);
        m22155a(context);
    }

    public ThrowbackNUXView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22155a(context);
    }

    public ThrowbackNUXView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22155a(context);
    }

    private void m22155a(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(2130907415, this, true);
        this.f21239a = findViewById(2131567887);
        this.f21239a.setVisibility(8);
        this.f21240b = findViewById(2131567886);
        this.f21240b.setVisibility(8);
        this.f21241c = (Button) this.f21240b.findViewById(2131567885);
        ((FbDraweeView) this.f21240b.findViewById(2131567884)).setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(2131361920)));
        this.f21242d = (LoadingIndicatorView) this.f21240b.findViewById(2131567288);
    }

    public final void m22157a(ThrowbackFeedResources throwbackFeedResources, boolean z) {
        View view = z ? this.f21239a : this.f21240b;
        ((FbDraweeView) view.findViewById(2131567884)).a(ImageUtil.a(throwbackFeedResources.f21084b), CallerContext.a(getClass(), "goodwill_throwback"));
        ((TextView) view.findViewById(2131558927)).setText(throwbackFeedResources.f21089g);
        ((TextView) view.findViewById(2131559769)).setText(throwbackFeedResources.f21091i);
        if (!z) {
            this.f21241c.setEnabled(true);
            this.f21241c.setText(throwbackFeedResources.f21092j);
            this.f21241c.setVisibility(0);
        }
        view.setVisibility(0);
    }

    public void setNotificationButtonListener(OnClickListener onClickListener) {
        this.f21241c.setOnClickListener(onClickListener);
    }

    public final void m22158b(ThrowbackFeedResources throwbackFeedResources, final boolean z) {
        View view = z ? this.f21239a : this.f21240b;
        final View view2 = z ? this.f21240b : this.f21239a;
        m22157a(throwbackFeedResources, z);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968779);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130968635);
        loadAnimation2.setAnimationListener(null);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ThrowbackNUXView f21238c;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view2.setVisibility(8);
                if (z) {
                    this.f21238c.f21242d.b();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(loadAnimation);
        view.startAnimation(loadAnimation2);
    }

    public final void m22156a() {
        this.f21241c.setVisibility(8);
        this.f21242d.a();
    }
}
