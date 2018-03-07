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
/* compiled from: composer_session_delete_failed */
public class MusicPreviewSquarePartDefinition extends MusicPreviewPartDefinition {
    public static final ViewType f8093a = new C10121();
    private static MusicPreviewSquarePartDefinition f8094b;
    private static final Object f8095c = new Object();

    /* compiled from: composer_session_delete_failed */
    final class C10121 extends ViewType {
        C10121() {
        }

        public final View m9123a(Context context) {
            return new MusicPreviewView(context, false);
        }
    }

    private static MusicPreviewSquarePartDefinition m9125b(InjectorLike injectorLike) {
        return new MusicPreviewSquarePartDefinition(BackgroundPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), MusicPreviewNuxManager.m9106b(injectorLike), MusicPreviewLogger.m9098a(injectorLike), SaveButtonUtils.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6403), IdBasedProvider.a(injectorLike, 1117));
    }

    @Inject
    public MusicPreviewSquarePartDefinition(BackgroundPartDefinition backgroundPartDefinition, Resources resources, MusicPreviewNuxManager musicPreviewNuxManager, MusicPreviewLogger musicPreviewLogger, SaveButtonUtils saveButtonUtils, Lazy<SongClipPlayer> lazy, Provider<FbDraweeControllerBuilder> provider) {
        super(backgroundPartDefinition, resources, musicPreviewNuxManager, musicPreviewLogger, saveButtonUtils, lazy, provider, f8093a);
    }

    public static MusicPreviewSquarePartDefinition m9124a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPreviewSquarePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8095c) {
                MusicPreviewSquarePartDefinition musicPreviewSquarePartDefinition;
                if (a2 != null) {
                    musicPreviewSquarePartDefinition = (MusicPreviewSquarePartDefinition) a2.a(f8095c);
                } else {
                    musicPreviewSquarePartDefinition = f8094b;
                }
                if (musicPreviewSquarePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9125b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8095c, b3);
                        } else {
                            f8094b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPreviewSquarePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
