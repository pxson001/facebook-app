package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.gif.AnimatedImagePlayButtonView;
import com.facebook.gif.AnimatedImagePlayButtonView.State;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: V_MPEG4/ISO/SP */
public class ImageShareAttachmentView extends CustomLinearLayout {
    public final FbDraweeView f21062a;
    private final TextView f21063b;
    public View f21064c;
    public AnimatedImagePlayButtonView f21065d;

    public ImageShareAttachmentView(Context context) {
        this(context, 2130904837);
    }

    private ImageShareAttachmentView(Context context, int i) {
        super(context);
        setContentView(i);
        setOrientation(1);
        this.f21062a = (FbDraweeView) a(2131562541);
        this.f21063b = (TextView) a(2131563058);
        Class cls = ImageShareAttachmentView.class;
        FbInjector.get(getContext());
        this.f21065d = new AnimatedImagePlayButtonView(getContext());
        this.f21064c = this.f21065d;
        this.f21064c.setVisibility(8);
        ((FrameLayout) a(2131563057)).addView(this.f21064c);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        if (this.f21065d == null) {
            genericDraweeHierarchyBuilder.l = new AutoRotateDrawable(context.getResources().getDrawable(2130844043).getConstantState().newDrawable(), 1000);
        }
        this.f21062a.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setAspectRatio(float f) {
        this.f21062a.setAspectRatio(f);
    }

    public void setImageController(@Nullable DraweeController draweeController) {
        this.f21062a.setController(draweeController);
    }

    @VisibleForTesting
    public FbDraweeView getImage() {
        return this.f21062a;
    }

    @VisibleForTesting
    public View getPlayButton() {
        return this.f21064c;
    }

    public void setBottomText(CharSequence charSequence) {
        this.f21063b.setText(charSequence);
    }

    public void setBottomTextVisibility(boolean z) {
        this.f21063b.setVisibility(z ? 0 : 8);
    }

    public void setPlayButtonState(State state) {
        if (this.f21065d != null) {
            this.f21065d.setState(state);
        } else if (state == State.READY_TO_PLAY) {
            this.f21064c.setVisibility(0);
        } else {
            this.f21064c.setVisibility(8);
        }
    }

    public void setOnImageClickListener(@Nullable OnClickListener onClickListener) {
        this.f21062a.setOnClickListener(onClickListener);
        if (onClickListener == null) {
            this.f21062a.setClickable(false);
        }
    }
}
