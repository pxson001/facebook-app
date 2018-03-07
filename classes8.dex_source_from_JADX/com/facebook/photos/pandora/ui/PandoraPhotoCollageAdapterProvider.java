package com.facebook.photos.pandora.ui;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;

/* compiled from: com.facebook.intent.action.REACTION_SHOW_DIALOG */
public class PandoraPhotoCollageAdapterProvider extends AbstractAssistedProvider<PandoraPhotoCollageAdapter> {
    public final PandoraPhotoCollageAdapter m21647a(PandoraPhotoCollageFetchPhotosFutureGenerator pandoraPhotoCollageFetchPhotosFutureGenerator, Boolean bool, Boolean bool2, PandoraRendererConfiguration pandoraRendererConfiguration) {
        return new PandoraPhotoCollageAdapter(IdBasedLazy.a(this, 9373), IdBasedLazy.a(this, 9376), IdBasedLazy.a(this, 3561), IdBasedSingletonScopeProvider.b(this, 9384), IdBasedSingletonScopeProvider.b(this, 494), String_LoggedInUserIdMethodAutoProvider.b(this), PandoraSequenceLogger.m21549a((InjectorLike) this), (PandoraInlineVideoEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(PandoraInlineVideoEnvironmentProvider.class), pandoraPhotoCollageFetchPhotosFutureGenerator, bool, bool2, pandoraRendererConfiguration);
    }
}
