package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
/* compiled from: goodfriends_nux */
public class ThrowbackSimplePhotoAttachmentPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, PhotoAttachmentContainerView> {
    public static final PaddingStyle f12530a;
    private static ThrowbackSimplePhotoAttachmentPartDefinition f12531d;
    private static final Object f12532e = new Object();
    private final PhotoAttachmentPartDefinition<E> f12533b;
    private final BackgroundPartDefinition f12534c;

    private static ThrowbackSimplePhotoAttachmentPartDefinition m14412b(InjectorLike injectorLike) {
        return new ThrowbackSimplePhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14414a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12533b, (FeedProps) obj);
        subParts.a(this.f12534c, new StylingData(null, PaddingStyle.f, Position.MIDDLE));
        return null;
    }

    public final boolean m14415a(Object obj) {
        return PhotoAttachmentPartDefinition.a((FeedProps) obj);
    }

    static {
        Builder d = Builder.d();
        d.c = 8.0f;
        f12530a = d.i();
    }

    @Inject
    public ThrowbackSimplePhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12533b = photoAttachmentPartDefinition;
        this.f12534c = backgroundPartDefinition;
    }

    public final ViewType m14413a() {
        return this.f12533b.a();
    }

    public static ThrowbackSimplePhotoAttachmentPartDefinition m14411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackSimplePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12532e) {
                ThrowbackSimplePhotoAttachmentPartDefinition throwbackSimplePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackSimplePhotoAttachmentPartDefinition = (ThrowbackSimplePhotoAttachmentPartDefinition) a2.a(f12532e);
                } else {
                    throwbackSimplePhotoAttachmentPartDefinition = f12531d;
                }
                if (throwbackSimplePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14412b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12532e, b3);
                        } else {
                            f12531d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackSimplePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
