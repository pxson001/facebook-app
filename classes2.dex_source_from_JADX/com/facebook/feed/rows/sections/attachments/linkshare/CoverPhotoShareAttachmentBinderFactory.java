package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_recommended_pages_in_category */
public class CoverPhotoShareAttachmentBinderFactory {
    private static CoverPhotoShareAttachmentBinderFactory f23947b;
    private static final Object f23948c = new Object();
    private final LegacyAngoraAttachmentUtil f23949a;

    private static CoverPhotoShareAttachmentBinderFactory m32332b(InjectorLike injectorLike) {
        return new CoverPhotoShareAttachmentBinderFactory(LegacyAngoraAttachmentUtil.m28831a(injectorLike));
    }

    @Inject
    public CoverPhotoShareAttachmentBinderFactory(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
        this.f23949a = legacyAngoraAttachmentUtil;
    }

    public final boolean m32333a(GraphQLMedia graphQLMedia) {
        return m32331a(graphQLMedia.m24444W()) || m32331a(graphQLMedia.m24440S());
    }

    private boolean m32331a(@Nullable GraphQLImage graphQLImage) {
        return this.f23949a.m28836a(graphQLImage, 1.9318181f);
    }

    public static CoverPhotoShareAttachmentBinderFactory m32330a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoShareAttachmentBinderFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23948c) {
                CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory;
                if (a2 != null) {
                    coverPhotoShareAttachmentBinderFactory = (CoverPhotoShareAttachmentBinderFactory) a2.mo818a(f23948c);
                } else {
                    coverPhotoShareAttachmentBinderFactory = f23947b;
                }
                if (coverPhotoShareAttachmentBinderFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32332b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23948c, b3);
                        } else {
                            f23947b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoShareAttachmentBinderFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
