package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: com.google.android.gms.cast.metadata.HEIGHT */
public class PandoraRendererHighlightPhotosGridRowFactoryProvider extends AbstractAssistedProvider<PandoraRendererHighlightPhotosGridRowFactory> {
    public final PandoraRendererHighlightPhotosGridRowFactory m21472a(Boolean bool) {
        return new PandoraRendererHighlightPhotosGridRowFactory(IdBasedSingletonScopeProvider.b(this, 9392), IdBasedSingletonScopeProvider.b(this, 9387), IdBasedSingletonScopeProvider.b(this, 9389), bool);
    }
}
