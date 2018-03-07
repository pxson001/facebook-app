package com.facebook.reaction;

import android.content.Context;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.composer.ReactionComposerManager;

@InjectorModule
/* compiled from: byline_style */
public class ReactionModule extends AbstractLibraryModule {

    /* compiled from: byline_style */
    public final class C20601 {
        final /* synthetic */ ReactionComposerManagerImplProvider f18615a;

        C20601(ReactionComposerManagerImplProvider reactionComposerManagerImplProvider) {
            this.f18615a = reactionComposerManagerImplProvider;
        }

        public final ReactionComposerManager m22516a(String str, boolean z, Surface surface) {
            InjectorLike injectorLike = this.f18615a;
            return new ReactionComposerManagerImpl(str, Boolean.valueOf(z), surface, (Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 9834), IdBasedProvider.a(injectorLike, 4442), ReactionExperimentController.a(injectorLike), ReactionSessionManager.m22590a(injectorLike), ReactionUtil.m22637a(injectorLike));
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static C20601 m22517a(ReactionComposerManagerImplProvider reactionComposerManagerImplProvider) {
        return new C20601(reactionComposerManagerImplProvider);
    }
}
