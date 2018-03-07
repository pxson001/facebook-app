package com.facebook.composer.ui.footerbar;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.ui.footerbar.ComposerAlbumFooterBarController.Listener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAttachToAlbumSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;

/* compiled from: feed unit is null */
public class ComposerAlbumFooterBarControllerProvider extends AbstractAssistedProvider<ComposerAlbumFooterBarController> {
    public final <DataProvider extends ProvidesIsAttachToAlbumSupported & ProvidesTargetAlbum> ComposerAlbumFooterBarController<DataProvider> m8300a(LazyFooterView<GlyphButton> lazyFooterView, DataProvider dataProvider, Listener listener) {
        return new ComposerAlbumFooterBarController(lazyFooterView, (ComposerDataProviderImpl) dataProvider, listener, ResourcesMethodAutoProvider.a(this));
    }
}
