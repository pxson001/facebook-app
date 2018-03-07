package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.PhotoLayoutPartDefinition;
import com.facebook.feed.rows.sections.PhotoPartDefinition;
import com.facebook.feed.rows.sections.PhotoPartDefinition.PhotoProps;
import com.facebook.feed.rows.sections.attachments.ui.AlbumAttachmentItemView;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader$FeedImageType;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_new_stories */
public class AlbumAttachmentPagePartDefinition extends BaseSinglePartDefinitionWithViewType<FeedProps<GraphQLStoryAttachment>, Void, AnyEnvironment, AlbumAttachmentItemView> {
    public static final ViewType<AlbumAttachmentItemView> f6565a = new C02971();
    private static final CallerContext f6566b = CallerContext.a(AlbumAttachmentPagePartDefinition.class, "native_newsfeed");
    private static AlbumAttachmentPagePartDefinition f6567i;
    private static final Object f6568j = new Object();
    private final PhotoPartDefinition f6569c;
    private final PhotoLayoutPartDefinition f6570d;
    public final Lazy<PhotoGalleryLauncherHelper> f6571e;
    private final FeedImageLoader f6572f;
    private final ClickListenerPartDefinition f6573g;
    private final FbDraweeControllerBuilder f6574h;

    /* compiled from: num_new_stories */
    final class C02971 extends ViewType<AlbumAttachmentItemView> {
        C02971() {
        }

        public final View m6984a(Context context) {
            return new AlbumAttachmentItemView(context);
        }
    }

    private static AlbumAttachmentPagePartDefinition m6981b(InjectorLike injectorLike) {
        return new AlbumAttachmentPagePartDefinition(PhotoPartDefinition.a(injectorLike), PhotoLayoutPartDefinition.a(injectorLike), FeedImageLoader.a(injectorLike), IdBasedLazy.a(injectorLike, 4891), ClickListenerPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m6983a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ImageRequest imageRequest;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.a).r();
        int a = this.f6572f.a(FeedImageLoader$FeedImageType.Album);
        ImageRequest a2 = this.f6572f.a(r, FeedImageLoader$FeedImageType.Album);
        if (a2 == null) {
            imageRequest = null;
        } else {
            ImageRequestBuilder a3 = ImageRequestBuilder.a(a2);
            a3.g = true;
            imageRequest = a3.m();
        }
        subParts.a(2131559536, this.f6569c, new PhotoProps(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6574h.a(f6566b).a(true)).c(imageRequest)).s()));
        subParts.a(2131559536, this.f6570d, Integer.valueOf(a));
        subParts.a(this.f6573g, new AlbumClickListener(this, imageRequest, feedProps));
        return null;
    }

    public static AlbumAttachmentPagePartDefinition m6980a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumAttachmentPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6568j) {
                AlbumAttachmentPagePartDefinition albumAttachmentPagePartDefinition;
                if (a2 != null) {
                    albumAttachmentPagePartDefinition = (AlbumAttachmentPagePartDefinition) a2.a(f6568j);
                } else {
                    albumAttachmentPagePartDefinition = f6567i;
                }
                if (albumAttachmentPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6981b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6568j, b3);
                        } else {
                            f6567i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = albumAttachmentPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AlbumAttachmentPagePartDefinition(PhotoPartDefinition photoPartDefinition, PhotoLayoutPartDefinition photoLayoutPartDefinition, FeedImageLoader feedImageLoader, Lazy<PhotoGalleryLauncherHelper> lazy, ClickListenerPartDefinition clickListenerPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f6569c = photoPartDefinition;
        this.f6570d = photoLayoutPartDefinition;
        this.f6572f = feedImageLoader;
        this.f6571e = lazy;
        this.f6573g = clickListenerPartDefinition;
        this.f6574h = fbDraweeControllerBuilder;
    }

    public final ViewType<AlbumAttachmentItemView> m6982a() {
        return f6565a;
    }
}
