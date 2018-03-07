package com.facebook.composer.ui.footerbar;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.ui.footerbar.ComposerPhotoFooterBarController.Listener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: fb_web_login_switchback_time */
public class ComposerPhotoFooterBarControllerProvider extends AbstractAssistedProvider<ComposerPhotoFooterBarController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesCapability> ComposerPhotoFooterBarController<DataProvider> m8329a(LazyFooterView<GlyphButton> lazyFooterView, DataProvider dataProvider, Listener listener) {
        return new ComposerPhotoFooterBarController(lazyFooterView, (ProvidesAttachments) dataProvider, listener, ResourcesMethodAutoProvider.a(this));
    }
}
