package com.facebook.goodfriends.audience;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.awesomizer.ui.AwesomizerGridItemView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: fetch_live_conversations_headload */
public class FriendItemView extends AwesomizerGridItemView {
    private final FbDraweeView f13430b;
    private final FbTextView f13431c;
    private final Drawable f13432d;

    public FriendItemView(Context context) {
        this(context, null);
    }

    public FriendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13432d = getResources().getDrawable(2130838055);
        this.f13430b = (FbDraweeView) FindViewUtil.b(this, 2131559791);
        this.f13431c = (FbTextView) FindViewUtil.b(this, 2131559793);
        this.f13431c.setTextColor(getResources().getColor(17170444));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isSelected()) {
            int width = (canvas.getWidth() - this.f13430b.getWidth()) / 2;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131430798);
            this.f13432d.setBounds((this.f13430b.getRight() + width) - dimensionPixelSize, 0, width + this.f13430b.getRight(), dimensionPixelSize);
            this.f13432d.draw(canvas);
        }
    }
}
