package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedListName;
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
/* compiled from: a6f253b2a73c4aed21327f1d869e2de6 */
public class PhotosFeedMediaMetadataRootPartDefinition extends BaseMultiRowGroupPartDefinition<MediaMetadata, Void, PhotosFeedEnvironment> {
    private static PhotosFeedMediaMetadataRootPartDefinition f20242i;
    private static final Object f20243j = new Object();
    private final PhotosFeedAttachmentFooterSelectorPartDefinition<PhotosFeedEnvironment> f20244a;
    private final PhotosFeedAttachmentPillsBlingBarPartDefinition<PhotosFeedEnvironment> f20245b;
    private final PhotosFeedAttachmentTextPartDefinition f20246c;
    private final PhotosFeedObjectionableAttachmentImagePartDefinition<PhotosFeedEnvironment> f20247d;
    private final PhotosFeedObjectionableAttachmentMessagePartDefinition<PhotosFeedEnvironment> f20248e;
    private final PhotosFeedAttachmentImagePartDefinition<PhotosFeedEnvironment, ?> f20249f;
    private final PhotosFeedAttachmentVideoPartDefinition<PhotosFeedEnvironment> f20250g;
    private final PhotosFeedAttachmentStaticVideoPartDefinition<PhotosFeedEnvironment> f20251h;

    private static PhotosFeedMediaMetadataRootPartDefinition m23386b(InjectorLike injectorLike) {
        return new PhotosFeedMediaMetadataRootPartDefinition(PhotosFeedAttachmentImagePartDefinition.m23247a(injectorLike), PhotosFeedAttachmentVideoPartDefinition.m23306a(injectorLike), PhotosFeedAttachmentStaticVideoPartDefinition.m23282a(injectorLike), PhotosFeedAttachmentTextPartDefinition.m23292a(injectorLike), PhotosFeedAttachmentPillsBlingBarPartDefinition.m23255a(injectorLike), PhotosFeedAttachmentFooterSelectorPartDefinition.m23241a(injectorLike), PhotosFeedObjectionableAttachmentImagePartDefinition.m23390a(injectorLike), PhotosFeedObjectionableAttachmentMessagePartDefinition.m23398a(injectorLike));
    }

    public final Object m23387a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        PhotosFeedEnvironment photosFeedEnvironment = (PhotosFeedEnvironment) anyEnvironment;
        if (photosFeedEnvironment.m23339c().a() == FeedListName.PHOTOS_FEED) {
            SubPartsSelector.a(baseMultiRowSubParts, this.f20247d, mediaMetadata).a(this.f20249f, mediaMetadata);
        } else {
            baseMultiRowSubParts.a(this.f20249f, mediaMetadata);
        }
        baseMultiRowSubParts.a(this.f20250g, mediaMetadata);
        baseMultiRowSubParts.a(this.f20251h, mediaMetadata);
        baseMultiRowSubParts.a(this.f20246c, mediaMetadata);
        baseMultiRowSubParts.a(this.f20245b, mediaMetadata);
        if (photosFeedEnvironment.m23339c().a() == FeedListName.PHOTOS_FEED) {
            baseMultiRowSubParts.a(this.f20248e, mediaMetadata);
        }
        baseMultiRowSubParts.a(this.f20244a, mediaMetadata);
        return null;
    }

    @Inject
    public PhotosFeedMediaMetadataRootPartDefinition(PhotosFeedAttachmentImagePartDefinition photosFeedAttachmentImagePartDefinition, PhotosFeedAttachmentVideoPartDefinition photosFeedAttachmentVideoPartDefinition, PhotosFeedAttachmentStaticVideoPartDefinition photosFeedAttachmentStaticVideoPartDefinition, PhotosFeedAttachmentTextPartDefinition photosFeedAttachmentTextPartDefinition, PhotosFeedAttachmentPillsBlingBarPartDefinition photosFeedAttachmentPillsBlingBarPartDefinition, PhotosFeedAttachmentFooterSelectorPartDefinition photosFeedAttachmentFooterSelectorPartDefinition, PhotosFeedObjectionableAttachmentImagePartDefinition photosFeedObjectionableAttachmentImagePartDefinition, PhotosFeedObjectionableAttachmentMessagePartDefinition photosFeedObjectionableAttachmentMessagePartDefinition) {
        this.f20244a = photosFeedAttachmentFooterSelectorPartDefinition;
        this.f20245b = photosFeedAttachmentPillsBlingBarPartDefinition;
        this.f20247d = photosFeedObjectionableAttachmentImagePartDefinition;
        this.f20248e = photosFeedObjectionableAttachmentMessagePartDefinition;
        this.f20246c = photosFeedAttachmentTextPartDefinition;
        this.f20249f = photosFeedAttachmentImagePartDefinition;
        this.f20250g = photosFeedAttachmentVideoPartDefinition;
        this.f20251h = photosFeedAttachmentStaticVideoPartDefinition;
    }

    public static PhotosFeedMediaMetadataRootPartDefinition m23385a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedMediaMetadataRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20243j) {
                PhotosFeedMediaMetadataRootPartDefinition photosFeedMediaMetadataRootPartDefinition;
                if (a2 != null) {
                    photosFeedMediaMetadataRootPartDefinition = (PhotosFeedMediaMetadataRootPartDefinition) a2.a(f20243j);
                } else {
                    photosFeedMediaMetadataRootPartDefinition = f20242i;
                }
                if (photosFeedMediaMetadataRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23386b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20243j, b3);
                        } else {
                            f20242i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedMediaMetadataRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23388a(Object obj) {
        return true;
    }
}
