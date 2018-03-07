package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.PhotoLayoutPartDefinition;
import com.facebook.feed.rows.sections.PhotoPartDefinition;
import com.facebook.feed.rows.sections.PhotoPartDefinition.PhotoProps;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackShareComposerLauncherProvider;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_draft_dialog_discard_clicked */
public class ThrowbackPhotoAttachmentPagePartDefinition extends BaseSinglePartDefinitionWithViewType<FeedProps<GraphQLStory>, OnClickListener, AnyEnvironment, ThrowbackPhotoAttachmentItemView> {
    public static final ViewType<ThrowbackPhotoAttachmentItemView> f13751a = new C14591();
    private static final CallerContext f13752b = CallerContext.a(ThrowbackPhotoAttachmentPagePartDefinition.class, "goodwill_throwback");
    private static ThrowbackPhotoAttachmentPagePartDefinition f13753l;
    private static final Object f13754m = new Object();
    private final PhotoPartDefinition f13755c;
    private final PhotoLayoutPartDefinition f13756d;
    private final FeedImageLoader f13757e;
    private final ClickListenerPartDefinition f13758f;
    private final FbDraweeControllerBuilder f13759g;
    public final MediaGalleryLauncher f13760h;
    public final MediaGalleryLauncherParamsFactory f13761i;
    private final ThrowbackShareComposerLauncherProvider f13762j;
    private final Resources f13763k;

    /* compiled from: fb4a_draft_dialog_discard_clicked */
    final class C14591 extends ViewType<ThrowbackPhotoAttachmentItemView> {
        C14591() {
        }

        public final View m15423a(Context context) {
            return new ThrowbackPhotoAttachmentItemView(context);
        }
    }

    /* compiled from: fb4a_draft_dialog_discard_clicked */
    class PhotoClickListener implements OnClickListener {
        final /* synthetic */ ThrowbackPhotoAttachmentPagePartDefinition f13749a;
        private final GraphQLStoryAttachment f13750b;

        public PhotoClickListener(ThrowbackPhotoAttachmentPagePartDefinition throwbackPhotoAttachmentPagePartDefinition, GraphQLStoryAttachment graphQLStoryAttachment) {
            this.f13749a = throwbackPhotoAttachmentPagePartDefinition;
            this.f13750b = graphQLStoryAttachment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -449486887);
            MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = this.f13749a.f13761i;
            this.f13749a.f13760h.a(view.getContext(), MediaGalleryLauncherParamsFactory.a(this.f13750b).a(FullscreenGallerySource.NEWSFEED).b(), null);
            Logger.a(2, EntryType.UI_INPUT_END, -1346779215, a);
        }
    }

    private static ThrowbackPhotoAttachmentPagePartDefinition m15425b(InjectorLike injectorLike) {
        return new ThrowbackPhotoAttachmentPagePartDefinition(PhotoPartDefinition.a(injectorLike), PhotoLayoutPartDefinition.a(injectorLike), FeedImageLoader.a(injectorLike), (ThrowbackShareComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThrowbackShareComposerLauncherProvider.class), ClickListenerPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike));
    }

    public final Object m15427a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Object obj2 = null;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
        GraphQLMedia r = o.r();
        int dimensionPixelSize = this.f13763k.getDimensionPixelSize(2131433123);
        ImageRequest a = FeedImageLoader.a(this.f13757e.a(r, dimensionPixelSize, null));
        if (a != null) {
            ImageRequestBuilder a2 = ImageRequestBuilder.a(a);
            a2.g = true;
            ImageRequest m = a2.m();
        }
        subParts.a(2131567888, this.f13755c, new PhotoProps(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f13759g.a(f13752b).a(true)).c(obj2)).s()));
        subParts.a(2131567888, this.f13756d, Integer.valueOf(dimensionPixelSize));
        subParts.a(this.f13758f, new PhotoClickListener(this, o));
        return this.f13762j.a(feedProps, ComposerSourceType.ON_THIS_DAY_FEED, "goodwill_throwback_permalink_ufi");
    }

    public final /* bridge */ /* synthetic */ void m15428a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -570060551);
        ((ThrowbackPhotoAttachmentItemView) view).setShareOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 44765752, a);
    }

    public final void m15429b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ThrowbackPhotoAttachmentItemView) view).setShareOnClickListener(null);
    }

    public static ThrowbackPhotoAttachmentPagePartDefinition m15424a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPhotoAttachmentPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13754m) {
                ThrowbackPhotoAttachmentPagePartDefinition throwbackPhotoAttachmentPagePartDefinition;
                if (a2 != null) {
                    throwbackPhotoAttachmentPagePartDefinition = (ThrowbackPhotoAttachmentPagePartDefinition) a2.a(f13754m);
                } else {
                    throwbackPhotoAttachmentPagePartDefinition = f13753l;
                }
                if (throwbackPhotoAttachmentPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15425b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13754m, b3);
                        } else {
                            f13753l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPhotoAttachmentPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackPhotoAttachmentPagePartDefinition(PhotoPartDefinition photoPartDefinition, PhotoLayoutPartDefinition photoLayoutPartDefinition, FeedImageLoader feedImageLoader, ThrowbackShareComposerLauncherProvider throwbackShareComposerLauncherProvider, ClickListenerPartDefinition clickListenerPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory) {
        this.f13763k = resources;
        this.f13755c = photoPartDefinition;
        this.f13756d = photoLayoutPartDefinition;
        this.f13757e = feedImageLoader;
        this.f13758f = clickListenerPartDefinition;
        this.f13759g = fbDraweeControllerBuilder;
        this.f13760h = mediaGalleryLauncher;
        this.f13761i = mediaGalleryLauncherParamsFactory;
        this.f13762j = throwbackShareComposerLauncherProvider;
    }

    public final ViewType<ThrowbackPhotoAttachmentItemView> m15426a() {
        return f13751a;
    }
}
