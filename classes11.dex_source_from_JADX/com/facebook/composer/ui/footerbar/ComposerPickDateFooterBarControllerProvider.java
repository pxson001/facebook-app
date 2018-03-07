package com.facebook.composer.ui.footerbar;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.ui.footerbar.ComposerPickDateFooterBarController.Listener;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.model.ComposerDateInfo.ProvidesDateInfo;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginIsDatePickerSupportedGetter;

/* compiled from: fb_music */
public class ComposerPickDateFooterBarControllerProvider extends AbstractAssistedProvider<ComposerPickDateFooterBarController> {
    public final <DataProvider extends ProvidesDateInfo & ProvidesPluginIsDatePickerSupportedGetter> ComposerPickDateFooterBarController<DataProvider> m8332a(DataProvider dataProvider, LazyFooterView<GlyphWithTextView> lazyFooterView, Listener listener) {
        return new ComposerPickDateFooterBarController((ComposerDataProviderImpl) dataProvider, lazyFooterView, listener, ResourcesMethodAutoProvider.a(this));
    }
}
