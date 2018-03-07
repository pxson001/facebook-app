package com.facebook.composer.ui.tagging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_cancelled */
public class ComposerAttachmentsAutoTaggingController {
    private static ComposerAttachmentsAutoTaggingController f17101c;
    private static final Object f17102d = new Object();
    public final FaceBoxStore f17103a;
    public List<String> f17104b = Lists.a();

    private static ComposerAttachmentsAutoTaggingController m21042b(InjectorLike injectorLike) {
        return new ComposerAttachmentsAutoTaggingController(FaceBoxStore.a(injectorLike));
    }

    @Inject
    public ComposerAttachmentsAutoTaggingController(FaceBoxStore faceBoxStore) {
        this.f17103a = faceBoxStore;
    }

    @Nullable
    public final List<FaceBox> m21043a(MediaItem mediaItem) {
        if (!(mediaItem instanceof PhotoItem)) {
            return null;
        }
        PhotoItem photoItem = (PhotoItem) mediaItem;
        if (!(photoItem.f instanceof TaggablePhoto)) {
            return null;
        }
        return this.f17103a.a((TaggablePhoto) photoItem.f);
    }

    public static ComposerAttachmentsAutoTaggingController m21041a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ComposerAttachmentsAutoTaggingController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17102d) {
                ComposerAttachmentsAutoTaggingController composerAttachmentsAutoTaggingController;
                if (a2 != null) {
                    composerAttachmentsAutoTaggingController = (ComposerAttachmentsAutoTaggingController) a2.a(f17102d);
                } else {
                    composerAttachmentsAutoTaggingController = f17101c;
                }
                if (composerAttachmentsAutoTaggingController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21042b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17102d, b3);
                        } else {
                            f17101c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = composerAttachmentsAutoTaggingController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
