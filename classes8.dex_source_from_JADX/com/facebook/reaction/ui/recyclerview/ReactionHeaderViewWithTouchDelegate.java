package com.facebook.reaction.ui.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: Unimplemented call to action of type %s */
public class ReactionHeaderViewWithTouchDelegate extends CustomFrameLayout {
    @Nullable
    public ReactionContextItemsView f21177a;
    private final Set<ReactionHeaderTouchDelegateView> f21178b = new HashSet();

    public ReactionHeaderViewWithTouchDelegate(Context context) {
        super(context);
    }

    public ReactionHeaderViewWithTouchDelegate(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReactionHeaderViewWithTouchDelegate(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m24801a(ReactionHeaderTouchDelegateView reactionHeaderTouchDelegateView) {
        if (reactionHeaderTouchDelegateView != null) {
            this.f21178b.add(reactionHeaderTouchDelegateView);
        }
    }

    public final void m24800a() {
        for (ReactionHeaderTouchDelegateView reactionHeaderTouchDelegateView : this.f21178b) {
            reactionHeaderTouchDelegateView.f21175b = true;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (ReactionHeaderTouchDelegateView requestLayout : this.f21178b) {
            requestLayout.requestLayout();
        }
    }
}
