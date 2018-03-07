package com.facebook.fbreactcomponents.stickers;

import android.view.View;
import com.facebook.attachments.ui.AttachmentViewSticker;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: edit_mode */
public class StickerViewManager extends SimpleViewManager<AttachmentViewSticker> {
    protected final void m8687b(View view) {
        ((AttachmentViewSticker) view).a();
    }

    public final String m8686a() {
        return "RCTStickerView";
    }

    protected final View m8685a(ThemedReactContext themedReactContext) {
        return new AttachmentViewSticker(themedReactContext);
    }

    @ReactProp(name = "stickerFBID")
    public void setStickerFbid(AttachmentViewSticker attachmentViewSticker, @Nullable String str) {
        attachmentViewSticker.l = str;
    }
}
