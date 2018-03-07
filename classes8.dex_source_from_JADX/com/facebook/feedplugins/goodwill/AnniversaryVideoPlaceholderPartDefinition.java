package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_negative_feedback */
public class AnniversaryVideoPlaceholderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, PhotoAttachmentContainerView> {
    private static AnniversaryVideoPlaceholderPartDefinition f12138c;
    private static final Object f12139d = new Object();
    private final PhotoAttachmentPartDefinition f12140a;
    private final AnniversaryVideoClickOverridePartDefinition f12141b;

    private static AnniversaryVideoPlaceholderPartDefinition m14143b(InjectorLike injectorLike) {
        return new AnniversaryVideoPlaceholderPartDefinition(PhotoAttachmentPartDefinition.a(injectorLike), AnniversaryVideoClickOverridePartDefinition.m14136a(injectorLike));
    }

    public final Object m14145a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12140a, (FeedProps) obj);
        subParts.a(this.f12141b, null);
        return null;
    }

    public final boolean m14146a(Object obj) {
        return PhotoAttachmentPartDefinition.a((FeedProps) obj);
    }

    @Inject
    public AnniversaryVideoPlaceholderPartDefinition(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, AnniversaryVideoClickOverridePartDefinition anniversaryVideoClickOverridePartDefinition) {
        this.f12140a = photoAttachmentPartDefinition;
        this.f12141b = anniversaryVideoClickOverridePartDefinition;
    }

    public final ViewType<PhotoAttachmentContainerView> m14144a() {
        return this.f12140a.a();
    }

    public static AnniversaryVideoPlaceholderPartDefinition m14142a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryVideoPlaceholderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12139d) {
                AnniversaryVideoPlaceholderPartDefinition anniversaryVideoPlaceholderPartDefinition;
                if (a2 != null) {
                    anniversaryVideoPlaceholderPartDefinition = (AnniversaryVideoPlaceholderPartDefinition) a2.a(f12139d);
                } else {
                    anniversaryVideoPlaceholderPartDefinition = f12138c;
                }
                if (anniversaryVideoPlaceholderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14143b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12139d, b3);
                        } else {
                            f12138c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = anniversaryVideoPlaceholderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
