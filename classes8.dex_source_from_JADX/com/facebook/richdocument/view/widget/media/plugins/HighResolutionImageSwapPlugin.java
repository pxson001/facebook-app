package com.facebook.richdocument.view.widget.media.plugins;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: num_left_swipes */
public class HighResolutionImageSwapPlugin extends BaseMediaFramePlugin<Void> {
    private final RichDocumentImageView f7634a;
    private final String f7635b;
    private int f7636c;
    private int f7637d;

    public HighResolutionImageSwapPlugin(MediaFrame mediaFrame, RichDocumentImageView richDocumentImageView, String str, int i, int i2) {
        super(mediaFrame);
        this.f7634a = richDocumentImageView;
        this.f7635b = str;
        this.f7636c = i;
        this.f7637d = i2;
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MEDIA) {
            ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(this.f7635b));
            a.b = RequestLevel.DISK_CACHE;
            ImageRequest m = a.m();
            this.f7634a.setFadeDuration(0);
            this.f7634a.m7584a(m, this.f7636c, this.f7637d);
        }
        return super.mo447a(event);
    }
}
