package com.facebook.orca.compose;

import android.content.Intent;
import com.facebook.ui.media.attachments.MediaResource;

/* compiled from: overflow_menu_button */
public interface AttachmentContainer {

    /* compiled from: overflow_menu_button */
    public interface Callback {
        void mo142a(MediaResource mediaResource);

        void mo143b(MediaResource mediaResource);
    }

    void mo208a();

    void mo209a(Intent intent);

    void mo210a(MediaResource mediaResource);

    void mo211b(MediaResource mediaResource);

    void setAttachmentContainerCallback(Callback callback);
}
