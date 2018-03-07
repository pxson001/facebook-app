package com.facebook.feed.photoreminder.v3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.photoreminder.PhotoReminderV2View;
import com.facebook.productionprompts.common.views.HasPromptTitleBar;
import com.facebook.widget.text.BetterTextView;

/* compiled from: admin_click_pages_feed */
public class MediaReminderV3LargeView extends ImageBlockLayout implements HasPhotoTray, HasPromptTitleBar {
    private final BetterTextView f19797h;
    private final BetterTextView f19798i;

    public MediaReminderV3LargeView(Context context) {
        this(context, null);
    }

    private MediaReminderV3LargeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MediaReminderV3LargeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906208);
        this.f19797h = (BetterTextView) getView(2131565300);
        this.f19798i = (BetterTextView) getView(2131565301);
    }

    public BetterTextView getPromptTitleView() {
        return this.f19797h;
    }

    public BetterTextView getPromptSubtitleView() {
        return this.f19798i;
    }

    public View getPhotoTray() {
        return getV2AttachmentView().getPhotoTray();
    }

    public PhotoReminderV2View getV2AttachmentView() {
        return (PhotoReminderV2View) findViewById(2131565921);
    }
}
