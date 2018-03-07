package com.facebook.composer.controller;

import android.view.ViewStub;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.redspace.nux.RedSpaceInterstitialController;

/* compiled from: hide_photos_of_tab */
public class ComposerRedSpaceSubtitleControllerProvider extends AbstractAssistedProvider<ComposerRedSpaceSubtitleController> {
    public final <DataProvider extends ProvidesTargetData & ProvidesRedSpaceValue> ComposerRedSpaceSubtitleController<DataProvider> m7734a(ViewStub viewStub, DataProvider dataProvider) {
        return new ComposerRedSpaceSubtitleController(RedSpaceInterstitialController.m5816b(this), GlyphColorizer.a(this), viewStub, (ProvidesTargetData) dataProvider);
    }
}
