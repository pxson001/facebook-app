package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: composer_quick_cam */
public class MusicPreviewWidePartDefinition extends MusicPreviewPartDefinition {
    public static final ViewType f8131a = new C10151();
    private static MusicPreviewWidePartDefinition f8132b;
    private static final Object f8133c = new Object();

    /* compiled from: composer_quick_cam */
    final class C10151 extends ViewType {
        C10151() {
        }

        public final View m9140a(Context context) {
            return new MusicPreviewView(context, true);
        }
    }

    private static MusicPreviewWidePartDefinition m9142b(InjectorLike injectorLike) {
        return new MusicPreviewWidePartDefinition(BackgroundPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), MusicPreviewNuxManager.m9106b(injectorLike), MusicPreviewLogger.m9098a(injectorLike), SaveButtonUtils.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6403), IdBasedProvider.a(injectorLike, 1117));
    }

    @Inject
    public MusicPreviewWidePartDefinition(BackgroundPartDefinition backgroundPartDefinition, Resources resources, MusicPreviewNuxManager musicPreviewNuxManager, MusicPreviewLogger musicPreviewLogger, SaveButtonUtils saveButtonUtils, Lazy<SongClipPlayer> lazy, Provider<FbDraweeControllerBuilder> provider) {
        super(backgroundPartDefinition, resources, musicPreviewNuxManager, musicPreviewLogger, saveButtonUtils, lazy, provider, f8131a);
    }

    public static MusicPreviewWidePartDefinition m9141a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPreviewWidePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8133c) {
                MusicPreviewWidePartDefinition musicPreviewWidePartDefinition;
                if (a2 != null) {
                    musicPreviewWidePartDefinition = (MusicPreviewWidePartDefinition) a2.a(f8133c);
                } else {
                    musicPreviewWidePartDefinition = f8132b;
                }
                if (musicPreviewWidePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9142b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8133c, b3);
                        } else {
                            f8132b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPreviewWidePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
