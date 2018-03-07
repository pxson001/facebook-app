package com.facebook.feed.inlinecomposer.multirow.common.views;

import android.view.View;
import android.widget.FrameLayout;
import com.facebook.productionprompts.common.views.HasPromptTitleBar;
import javax.annotation.Nullable;

/* compiled from: messenger_chat_head_notif_info_action_disabled */
public interface HasPromptFlyout extends HasPromptDisplayReasonView, HasPromptTitleBar {
    FrameLayout getAttachmentInsertPoint();

    int getCollapsedHeight();

    int getExpandedFlyoutHeight();

    View getFlyoutView();

    View getFlyoutXoutButton();

    @Nullable
    View getV2AttachmentView();
}
