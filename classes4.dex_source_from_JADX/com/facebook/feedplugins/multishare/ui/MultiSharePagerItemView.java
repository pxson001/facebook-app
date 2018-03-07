package com.facebook.feedplugins.multishare.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: deltas */
public abstract class MultiSharePagerItemView extends PagerItemWrapperLayout implements AttachmentHasButton, RecyclableView {
    public int f13999a;

    public MultiSharePagerItemView(Context context) {
        super(context);
    }

    public View getCallToActionView() {
        return c(2131564016);
    }

    public int getItemPageIndex() {
        return this.f13999a;
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        ((GenericActionButtonView) c(2131564016)).f13757a.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return (GenericActionButtonView) c(2131564016);
    }
}
