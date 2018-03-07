package com.facebook.feedplugins.video;

import android.content.Context;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;

/* compiled from: ufi/reactions/v2/24x24/love */
public class FullscreenVideoLauncherProvider extends AbstractAssistedProvider<FullscreenVideoLauncher> {
    public final FullscreenVideoLauncher m135a(VideoAttachmentDelegate videoAttachmentDelegate) {
        return new FullscreenVideoLauncher(FragmentActivityMethodAutoProvider.b(this), videoAttachmentDelegate, (ZeroDialogController) FbZeroDialogController.b(this), (Context) getInstance(Context.class, ForAppContext.class));
    }
}
