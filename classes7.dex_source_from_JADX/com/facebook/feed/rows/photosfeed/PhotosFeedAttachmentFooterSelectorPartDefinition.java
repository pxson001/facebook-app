package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_default_activated_message */
public class PhotosFeedAttachmentFooterSelectorPartDefinition<E extends CanLaunchPhotosFeedFlyout & HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<MediaMetadata, Void, E> {
    private static PhotosFeedAttachmentFooterSelectorPartDefinition f20053c;
    private static final Object f20054d = new Object();
    private final PhotosFeedAttachmentFooterRootPartDefinition f20055a;
    private final PhotosFeedAttachmentRootReactionsFooterPartDefinition f20056b;

    private static PhotosFeedAttachmentFooterSelectorPartDefinition m23242b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentFooterSelectorPartDefinition(PhotosFeedAttachmentFooterRootPartDefinition.m23235a(injectorLike), PhotosFeedAttachmentRootReactionsFooterPartDefinition.m23276a(injectorLike));
    }

    public final Object m23243a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20056b, mediaMetadata).a(this.f20055a, mediaMetadata);
        return null;
    }

    @Inject
    public PhotosFeedAttachmentFooterSelectorPartDefinition(PhotosFeedAttachmentFooterRootPartDefinition photosFeedAttachmentFooterRootPartDefinition, PhotosFeedAttachmentRootReactionsFooterPartDefinition photosFeedAttachmentRootReactionsFooterPartDefinition) {
        this.f20055a = photosFeedAttachmentFooterRootPartDefinition;
        this.f20056b = photosFeedAttachmentRootReactionsFooterPartDefinition;
    }

    public final boolean m23244a(Object obj) {
        return true;
    }

    public static PhotosFeedAttachmentFooterSelectorPartDefinition m23241a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentFooterSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20054d) {
                PhotosFeedAttachmentFooterSelectorPartDefinition photosFeedAttachmentFooterSelectorPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentFooterSelectorPartDefinition = (PhotosFeedAttachmentFooterSelectorPartDefinition) a2.a(f20054d);
                } else {
                    photosFeedAttachmentFooterSelectorPartDefinition = f20053c;
                }
                if (photosFeedAttachmentFooterSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23242b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20054d, b3);
                        } else {
                            f20053c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentFooterSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
