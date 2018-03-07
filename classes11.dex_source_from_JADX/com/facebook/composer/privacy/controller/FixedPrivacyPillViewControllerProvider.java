package com.facebook.composer.privacy.controller;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.ui.statusview.FixedPrivacyPillView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAlbumPillSupported;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.widget.LazyView;

/* compiled from: flex_settings_screen_optout */
public class FixedPrivacyPillViewControllerProvider extends AbstractAssistedProvider<FixedPrivacyPillViewController> {
    public final <DataProvider extends ProvidesIsAlbumPillSupported & ProvidesPrivacyData> FixedPrivacyPillViewController<DataProvider> m8206a(DataProvider dataProvider, LazyView<FixedPrivacyPillView> lazyView) {
        return new FixedPrivacyPillViewController(GlyphColorizer.a(this), ResourcesMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 494), (ComposerDataProviderImpl) dataProvider, lazyView, PrivacyIcons.a(this));
    }
}
