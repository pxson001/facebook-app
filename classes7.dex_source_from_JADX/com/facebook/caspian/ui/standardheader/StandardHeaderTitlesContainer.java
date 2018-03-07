package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.BetterLinkMovementMethod;
import javax.annotation.Nullable;

/* compiled from: crop-right */
public class StandardHeaderTitlesContainer extends ImageBlockLayout {
    private FbTextView f16575h;
    private FbTextView f16576i;

    public StandardHeaderTitlesContainer(Context context) {
        super(context);
    }

    public StandardHeaderTitlesContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected StandardHeaderTitlesContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1326694360);
        super.onFinishInflate();
        m20631a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1234920532, a);
    }

    private void m20631a() {
        this.f16575h = (FbTextView) getView(2131567616);
        this.f16576i = (FbTextView) getView(2131567617);
        this.f16576i.setMovementMethod(BetterLinkMovementMethod.getInstance());
        this.f16575h.setMovementMethod(BetterLinkMovementMethod.getInstance());
        this.f16575h.setFocusable(false);
        this.f16575h.setOnClickListener(null);
        this.f16576i.setOnClickListener(null);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f16575h.setText(charSequence);
    }

    public void setSubtitleText(CharSequence charSequence) {
        this.f16576i.setText(charSequence);
        this.f16576i.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setSubtitleOnClickListener(OnClickListener onClickListener) {
        this.f16576i.setOnClickListener(onClickListener);
    }

    public void setTitleTextAppearance(int i) {
        this.f16575h.setTextAppearance(this.f16575h.getContext(), i);
    }

    public void setSubtitleTextAppearance(int i) {
        this.f16576i.setTextAppearance(this.f16576i.getContext(), i);
    }

    public TextPaint getTitleTextPaint() {
        return this.f16575h.getPaint();
    }
}
