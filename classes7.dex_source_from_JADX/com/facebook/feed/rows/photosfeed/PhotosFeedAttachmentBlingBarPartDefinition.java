package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_default_icon */
public class PhotosFeedAttachmentBlingBarPartDefinition<E extends CanLaunchPhotosFeedFlyout & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<MediaMetadata, Void, E, DefaultBlingBarView> {
    private static PhotosFeedAttachmentBlingBarPartDefinition f20046b;
    private static final Object f20047c = new Object();
    private final MediaMetadataBlingBarPartDefinition f20048a;

    private static PhotosFeedAttachmentBlingBarPartDefinition m23231b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentBlingBarPartDefinition(MediaMetadataBlingBarPartDefinition.m23212a(injectorLike));
    }

    public final Object m23233a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f20048a, (MediaMetadata) obj);
        return null;
    }

    @Inject
    public PhotosFeedAttachmentBlingBarPartDefinition(MediaMetadataBlingBarPartDefinition mediaMetadataBlingBarPartDefinition) {
        this.f20048a = mediaMetadataBlingBarPartDefinition;
    }

    public final ViewType m23232a() {
        return DefaultBlingBarView.f22918a;
    }

    public final boolean m23234a(Object obj) {
        return true;
    }

    public static PhotosFeedAttachmentBlingBarPartDefinition m23230a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20047c) {
                PhotosFeedAttachmentBlingBarPartDefinition photosFeedAttachmentBlingBarPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentBlingBarPartDefinition = (PhotosFeedAttachmentBlingBarPartDefinition) a2.a(f20047c);
                } else {
                    photosFeedAttachmentBlingBarPartDefinition = f20046b;
                }
                if (photosFeedAttachmentBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23231b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20047c, b3);
                        } else {
                            f20046b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
