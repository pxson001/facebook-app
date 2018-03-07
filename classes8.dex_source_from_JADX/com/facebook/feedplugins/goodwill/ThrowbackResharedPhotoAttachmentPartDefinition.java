package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
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
/* compiled from: goodfriends_picker_search */
public class ThrowbackResharedPhotoAttachmentPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, PhotoAttachmentContainerView> {
    public static final PaddingStyle f12513a;
    private static ThrowbackResharedPhotoAttachmentPartDefinition f12514d;
    private static final Object f12515e = new Object();
    private final PhotoAttachmentPartDefinition<E> f12516b;
    private final BackgroundPartDefinition f12517c;

    private static ThrowbackResharedPhotoAttachmentPartDefinition m14395b(InjectorLike injectorLike) {
        return new ThrowbackResharedPhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14397a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12516b, feedProps);
        subParts.a(this.f12517c, new StylingData(AttachmentProps.e(feedProps), f12513a));
        return null;
    }

    public final boolean m14398a(Object obj) {
        return PhotoAttachmentPartDefinition.a((FeedProps) obj);
    }

    static {
        Builder a = Builder.a();
        a.c = -9.0f;
        a = a;
        a.d = -11.0f;
        f12513a = a.i();
    }

    @Inject
    public ThrowbackResharedPhotoAttachmentPartDefinition(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12516b = photoAttachmentPartDefinition;
        this.f12517c = backgroundPartDefinition;
    }

    public final ViewType m14396a() {
        return PhotoAttachmentPartDefinition.a;
    }

    public static ThrowbackResharedPhotoAttachmentPartDefinition m14394a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackResharedPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12515e) {
                ThrowbackResharedPhotoAttachmentPartDefinition throwbackResharedPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackResharedPhotoAttachmentPartDefinition = (ThrowbackResharedPhotoAttachmentPartDefinition) a2.a(f12515e);
                } else {
                    throwbackResharedPhotoAttachmentPartDefinition = f12514d;
                }
                if (throwbackResharedPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14395b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12515e, b3);
                        } else {
                            f12514d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackResharedPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
