package com.facebook.photos.pandora.common.ui.renderer.configs;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererHighlightPhotosGridRowFactoryProvider;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererRowFactory;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.cast.metadata.TITLE */
public class PandoraRendererGridConfiguration implements PandoraRendererConfiguration {
    private final PandoraRendererHighlightPhotosGridRowFactoryProvider f17473a;

    public static PandoraRendererGridConfiguration m21450b(InjectorLike injectorLike) {
        return new PandoraRendererGridConfiguration((PandoraRendererHighlightPhotosGridRowFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraRendererHighlightPhotosGridRowFactoryProvider.class));
    }

    @Inject
    public PandoraRendererGridConfiguration(PandoraRendererHighlightPhotosGridRowFactoryProvider pandoraRendererHighlightPhotosGridRowFactoryProvider) {
        this.f17473a = pandoraRendererHighlightPhotosGridRowFactoryProvider;
    }

    public final ImmutableList<? extends PandoraRendererRowFactory> mo1045a() {
        return ImmutableList.of(this.f17473a.m21472a(Boolean.valueOf(false)));
    }

    public static PandoraRendererGridConfiguration m21449a(InjectorLike injectorLike) {
        return m21450b(injectorLike);
    }
}
