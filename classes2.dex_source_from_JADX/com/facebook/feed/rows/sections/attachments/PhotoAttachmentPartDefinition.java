package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.BasePhotoAttachmentPartDefinition.State;
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
/* compiled from: hitCount */
public class PhotoAttachmentPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, PhotoAttachmentContainerView> {
    public static final ViewType f20995a = new C08371();
    private static PhotoAttachmentPartDefinition f20996c;
    private static final Object f20997d = new Object();
    private final BasePhotoAttachmentPartDefinition f20998b;

    /* compiled from: hitCount */
    final class C08371 extends ViewType {
        C08371() {
        }

        public final View mo1995a(Context context) {
            return new PhotoAttachmentContainerView(context);
        }
    }

    private static PhotoAttachmentPartDefinition m28725b(InjectorLike injectorLike) {
        return new PhotoAttachmentPartDefinition(BasePhotoAttachmentPartDefinition.m28731a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f20998b, (FeedProps) obj);
        return null;
    }

    @Inject
    public PhotoAttachmentPartDefinition(BasePhotoAttachmentPartDefinition basePhotoAttachmentPartDefinition) {
        this.f20998b = basePhotoAttachmentPartDefinition;
    }

    public static PhotoAttachmentPartDefinition m28723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20997d) {
                PhotoAttachmentPartDefinition photoAttachmentPartDefinition;
                if (a2 != null) {
                    photoAttachmentPartDefinition = (PhotoAttachmentPartDefinition) a2.mo818a(f20997d);
                } else {
                    photoAttachmentPartDefinition = f20996c;
                }
                if (photoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28725b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20997d, b3);
                        } else {
                            f20996c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = photoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f20995a;
    }

    public static boolean m28724a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return ((GraphQLStoryAttachment) feedProps.f13444a).m23979r() != null;
    }
}
