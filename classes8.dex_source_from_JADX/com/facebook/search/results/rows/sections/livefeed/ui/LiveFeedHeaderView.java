package com.facebook.search.results.rows.sections.livefeed.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: REACTION_FRIEND_REQUESTS_CARD */
public abstract class LiveFeedHeaderView extends ImageBlockLayout {
    public FbDraweeView f24078h = ((FbDraweeView) getView(2131560956));
    public BetterTextView f24079i = ((BetterTextView) getView(2131560957));

    public LiveFeedHeaderView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        setContentView(i2);
    }

    public void setActorClickListener(OnClickListener onClickListener) {
        this.f24078h.setOnClickListener(onClickListener);
    }

    public void setBodyClickListener(OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.f24079i.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setPostBodyText(CharSequence charSequence) {
        this.f24079i.setText(charSequence);
    }
}
