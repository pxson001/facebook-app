package com.facebook.feedplugins.base.footer.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.feed.widget.DownstateType;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import java.util.Set;

/* compiled from: is_modal */
public interface Footer {

    /* compiled from: is_modal */
    public enum DividerStyle {
        VISIBLE(0),
        HIDDEN(8);
        
        public final int visibilityValue;

        private DividerStyle(int i) {
            this.visibilityValue = i;
        }
    }

    /* compiled from: is_modal */
    public enum FooterButtonId {
        LIKE,
        COMMENT,
        SHARE,
        SEND,
        VISIT_LINK,
        SAVE
    }

    /* compiled from: is_modal */
    public interface ButtonClickedListener {
        void mo3276a(View view, FooterButtonId footerButtonId);
    }

    View mo3250a(FooterButtonId footerButtonId);

    void mo3251a();

    void setBottomDividerStyle(DividerStyle dividerStyle);

    void setButtonContainerBackground(Drawable drawable);

    void setButtonContainerHeight(int i);

    void setButtonWeights(float[] fArr);

    void setButtons(Set<FooterButtonId> set);

    void setDownstateType(DownstateType downstateType);

    void setEnabled(boolean z);

    void setHasCachedComments(boolean z);

    void setIsLiked(boolean z);

    void setOnButtonClickedListener(ButtonClickedListener buttonClickedListener);

    void setShowIcons(boolean z);

    void setSprings(EnumMap<FooterButtonId, TouchSpring> enumMap);

    void setTopDividerStyle(DividerStyle dividerStyle);
}
