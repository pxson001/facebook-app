package com.facebook.composer.ui.footerbar;

import android.content.Context;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.ui.footerbar.ComposerFacecastFooterBarController.Listener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;

/* compiled from: fbresources_start_prefetch_download */
public class ComposerFacecastFooterBarControllerProvider extends AbstractAssistedProvider<ComposerFacecastFooterBarController> {
    public final <DataProvider extends ProvidesIsFacecastSupported & ProvidesFacecastInfo> ComposerFacecastFooterBarController<DataProvider> m8320a(TipManager tipManager, LazyFooterView<GlyphButton> lazyFooterView, DataProvider dataProvider, Listener listener) {
        return new ComposerFacecastFooterBarController(tipManager, lazyFooterView, (ComposerDataProviderImpl) dataProvider, listener, (Context) getInstance(Context.class), TipSeenTracker.b(this));
    }
}
