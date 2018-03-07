package com.facebook.feed.rows.sections.offline.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import java.util.Set;

/* compiled from: UNSUPPORTED */
public class OfflineFooterView<V extends View & Footer> extends CustomFrameLayout implements Footer {
    public OfflineFooterView(Context context) {
        super(context);
    }

    public V getBaseView() {
        V childAt = getChildAt(0);
        Preconditions.checkState(childAt instanceof Footer);
        return childAt;
    }

    public void setAlpha(float f) {
        getBaseView().setAlpha(f);
    }

    public void setButtonContainerBackground(Drawable drawable) {
        ((Footer) getBaseView()).setButtonContainerBackground(drawable);
    }

    public void setDownstateType(DownstateType downstateType) {
        ((Footer) getBaseView()).setDownstateType(downstateType);
    }

    public void setButtonContainerHeight(int i) {
        ((Footer) getBaseView()).setButtonContainerHeight(i);
    }

    public void setTopDividerStyle(DividerStyle dividerStyle) {
        ((Footer) getBaseView()).setTopDividerStyle(dividerStyle);
    }

    public void setBottomDividerStyle(DividerStyle dividerStyle) {
        ((Footer) getBaseView()).setBottomDividerStyle(dividerStyle);
    }

    public void setIsLiked(boolean z) {
        ((Footer) getBaseView()).setIsLiked(z);
    }

    public void setHasCachedComments(boolean z) {
        ((Footer) getBaseView()).setHasCachedComments(z);
    }

    public void setButtons(Set<FooterButtonId> set) {
        ((Footer) getBaseView()).setButtons(set);
    }

    public void setSprings(EnumMap<FooterButtonId, TouchSpring> enumMap) {
        ((Footer) getBaseView()).setSprings(enumMap);
    }

    public final void m24198a() {
        ((Footer) getBaseView()).a();
    }

    public final View m24197a(FooterButtonId footerButtonId) {
        return ((Footer) getBaseView()).a(footerButtonId);
    }

    public void setOnButtonClickedListener(ButtonClickedListener buttonClickedListener) {
        ((Footer) getBaseView()).setOnButtonClickedListener(buttonClickedListener);
    }

    public void setButtonWeights(float[] fArr) {
        ((Footer) getBaseView()).setButtonWeights(fArr);
    }

    public void setShowIcons(boolean z) {
        ((Footer) getBaseView()).setShowIcons(z);
    }

    public void setEnabled(boolean z) {
        getBaseView().setEnabled(z);
    }
}
