package com.facebook.photos.pandora.common.ui.renderer.configs;

import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererHighlightPhotosGridRowFactoryProvider;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererRowFactory;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.cast.metadata.SUBTITLE */
public class PandoraRendererMixedMediaGridConfiguration implements PandoraRendererConfiguration {
    private final PandoraRendererHighlightPhotosGridRowFactoryProvider f17474a;

    @Inject
    public PandoraRendererMixedMediaGridConfiguration(PandoraRendererHighlightPhotosGridRowFactoryProvider pandoraRendererHighlightPhotosGridRowFactoryProvider) {
        this.f17474a = pandoraRendererHighlightPhotosGridRowFactoryProvider;
    }

    public final ImmutableList<? extends PandoraRendererRowFactory> mo1045a() {
        return ImmutableList.of(this.f17474a.m21472a(Boolean.valueOf(true)));
    }
}
