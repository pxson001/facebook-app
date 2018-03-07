package com.facebook.orca.compose;

import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.share.model.ShareItem;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.List;

/* compiled from: org.torproject.android.intent.extra.HTTP_PROXY_PORT */
public class ComposerInitParamsBuilder {
    public String f5433a;
    public List<MediaResource> f5434b;
    public PickMediaDialogParams f5435c;
    public OrionMessengerPayParams f5436d;
    public ShareItem f5437e;
    public boolean f5438f;
    public boolean f5439g;
    public ComposerAppAttribution f5440h;

    public final ComposerInitParams m5014i() {
        return new ComposerInitParams(this);
    }
}
