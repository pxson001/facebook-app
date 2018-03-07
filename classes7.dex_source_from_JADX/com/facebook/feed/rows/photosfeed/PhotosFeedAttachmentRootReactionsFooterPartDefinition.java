package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
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
/* compiled from: accessibilityLabel */
public class PhotosFeedAttachmentRootReactionsFooterPartDefinition<E extends HasPersistentState & CanLaunchPhotosFeedFlyout & CanLikePhotosFeedImage & CanReactToPhotosFeeedImage, V extends ReactionsFooterView> extends MultiRowSinglePartDefinition<MediaMetadata, Void, E, V> {
    private static PhotosFeedAttachmentRootReactionsFooterPartDefinition f20113c;
    private static final Object f20114d = new Object();
    private final PhotosFeedAttachmentReactionsFooterPartDefinition<E, V> f20115a;
    private final PhotosFeedAttachmentFooterRootPartDefinition<E, V> f20116b;

    private static PhotosFeedAttachmentRootReactionsFooterPartDefinition m23277b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentRootReactionsFooterPartDefinition(PhotosFeedAttachmentReactionsFooterPartDefinition.m23264a(injectorLike), PhotosFeedAttachmentFooterRootPartDefinition.m23235a(injectorLike));
    }

    public final Object m23279a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        subParts.a(this.f20116b, mediaMetadata);
        subParts.a(this.f20115a, mediaMetadata);
        return null;
    }

    public final boolean m23280a(Object obj) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return mediaMetadata != null && mediaMetadata.C() != null && mediaMetadata.C().bo_() && PhotosFeedAttachmentFooterRootPartDefinition.m23236a(mediaMetadata);
    }

    @Inject
    public PhotosFeedAttachmentRootReactionsFooterPartDefinition(PhotosFeedAttachmentReactionsFooterPartDefinition photosFeedAttachmentReactionsFooterPartDefinition, PhotosFeedAttachmentFooterRootPartDefinition photosFeedAttachmentFooterRootPartDefinition) {
        this.f20115a = photosFeedAttachmentReactionsFooterPartDefinition;
        this.f20116b = photosFeedAttachmentFooterRootPartDefinition;
    }

    public final ViewType m23278a() {
        return ReactionsFooterView.h;
    }

    public static PhotosFeedAttachmentRootReactionsFooterPartDefinition m23276a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentRootReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20114d) {
                PhotosFeedAttachmentRootReactionsFooterPartDefinition photosFeedAttachmentRootReactionsFooterPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentRootReactionsFooterPartDefinition = (PhotosFeedAttachmentRootReactionsFooterPartDefinition) a2.a(f20114d);
                } else {
                    photosFeedAttachmentRootReactionsFooterPartDefinition = f20113c;
                }
                if (photosFeedAttachmentRootReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23277b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20114d, b3);
                        } else {
                            f20113c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentRootReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
