package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer;
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
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_default_activated_submessage */
public class PhotosFeedAttachmentFooterRootPartDefinition<E extends HasPersistentState & CanLaunchPhotosFeedFlyout & CanLikePhotosFeedImage, V extends View & Footer> extends MultiRowSinglePartDefinition<MediaMetadata, Void, E, V> {
    private static PhotosFeedAttachmentFooterRootPartDefinition f20049c;
    private static final Object f20050d = new Object();
    private final DefaultFooterBackgroundPartDefinition<V> f20051a;
    private final MediaMetadataFooterPartDefinition f20052b;

    private static PhotosFeedAttachmentFooterRootPartDefinition m23237b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentFooterRootPartDefinition(DefaultFooterBackgroundPartDefinition.a(injectorLike), MediaMetadataFooterPartDefinition.m23216a(injectorLike));
    }

    public final Object m23239a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean g;
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        boolean z = false;
        SimpleMediaFeedbackModel C = mediaMetadata.C();
        if (C != null) {
            g = C.g();
            z = C.c();
        } else {
            g = false;
        }
        subParts.a(this.f20052b, mediaMetadata);
        subParts.a(this.f20051a, new Props(g, z, MediaMetadataFooterPartDefinition.m23220a(mediaMetadata), FooterLevel.TOP, null));
        return null;
    }

    @Inject
    public PhotosFeedAttachmentFooterRootPartDefinition(DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition, MediaMetadataFooterPartDefinition mediaMetadataFooterPartDefinition) {
        this.f20051a = defaultFooterBackgroundPartDefinition;
        this.f20052b = mediaMetadataFooterPartDefinition;
    }

    public final ViewType m23238a() {
        return DefaultFooterView.a;
    }

    public static PhotosFeedAttachmentFooterRootPartDefinition m23235a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentFooterRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20050d) {
                PhotosFeedAttachmentFooterRootPartDefinition photosFeedAttachmentFooterRootPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentFooterRootPartDefinition = (PhotosFeedAttachmentFooterRootPartDefinition) a2.a(f20050d);
                } else {
                    photosFeedAttachmentFooterRootPartDefinition = f20049c;
                }
                if (photosFeedAttachmentFooterRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23237b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20050d, b3);
                        } else {
                            f20049c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentFooterRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m23236a(MediaMetadata mediaMetadata) {
        if (MediaMetadataFooterPartDefinition.m23220a(mediaMetadata)) {
            return true;
        }
        SimpleMediaFeedbackModel C = mediaMetadata.C();
        if (C == null) {
            return false;
        }
        if (C.c() || C.g()) {
            return true;
        }
        return false;
    }
}
