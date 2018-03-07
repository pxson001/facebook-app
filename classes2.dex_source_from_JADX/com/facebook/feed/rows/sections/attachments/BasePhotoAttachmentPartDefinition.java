package com.facebook.feed.rows.sections.attachments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.photos.PostpostTaggingUtil;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$PhotoClickedEvent;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition.DimensionData;
import com.facebook.photos.galleryutil.GalleryVisibilityState;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.places.checkin.launcher.PlacePickerLauncher;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.images.DrawableUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hit */
public class BasePhotoAttachmentPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher, V extends View & HasPhotoAttachment> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
    public static final CallerContext f20999a = CallerContext.m9061a(BasePhotoAttachmentPartDefinition.class, "native_newsfeed");
    private static BasePhotoAttachmentPartDefinition f21000s;
    private static final Object f21001t = new Object();
    private final BackgroundPartDefinition f21002b;
    private final ViewDimensionsPartDefinition f21003c;
    private final PhotoAttachmentLayoutHelper f21004d;
    private final Rect f21005e;
    public final Lazy<PhotoGalleryLauncherHelper> f21006f;
    public final Lazy<PlacePickerLauncher> f21007g;
    public final FeedEventBus f21008h;
    public final PostpostTaggingUtil f21009i;
    private final BasePaddingStyleResolver f21010j;
    private final float f21011k;
    private final FbDraweeControllerBuilder f21012l;
    public final DialtoneController f21013m;
    public final GalleryVisibilityState f21014n;
    public final QeAccessor f21015o;
    public final InlineCommentComposerCache f21016p;
    public final AutomaticPhotoCaptioningUtils f21017q;
    private final PhotoAttachmentUtil f21018r;

    /* compiled from: hit */
    class LaunchPhotoGalleryClickListener implements OnPhotoClickListener {
        final /* synthetic */ BasePhotoAttachmentPartDefinition f22003a;
        private final ImageRequest f22004b;
        private final FeedProps<GraphQLStoryAttachment> f22005c;
        private final FeedProps<GraphQLStory> f22006d = AttachmentProps.m28715e(this.f22005c);
        private final E f22007e;

        public LaunchPhotoGalleryClickListener(BasePhotoAttachmentPartDefinition basePhotoAttachmentPartDefinition, ImageRequest imageRequest, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
            this.f22003a = basePhotoAttachmentPartDefinition;
            this.f22004b = imageRequest;
            this.f22005c = feedProps;
            this.f22007e = e;
        }

        private void m29782a() {
            GraphQLStory graphQLStory = (GraphQLStory) this.f22006d.f13444a;
            if (graphQLStory != null) {
                FeedUnitCommon a = StoryProps.m27454a(this.f22006d);
                this.f22003a.f21008h.mo651a(new StoryEvents$PhotoClickedEvent(graphQLStory.mo2507g(), a != null ? a.mo2507g() : null));
            }
        }

        @SuppressLint({"DeprecatedClass"})
        public final <V extends View & HasPhotoAttachment> void mo3222a(V v, boolean z, int i) {
            GraphQLStory graphQLStory = (GraphQLStory) this.f22006d.f13444a;
            m29782a();
            if (z) {
                this.f22003a.f21009i.m28769b(graphQLStory);
                ((HasPhotoAttachment) v).mo3213a(0, 0);
            }
            if (!this.f22003a.f21013m.mo1231j() || this.f22003a.f21013m.mo1215a(this.f22004b.f12746c, BasePhotoAttachmentPartDefinition.f20999a)) {
                OnDismissListener onDismissListener = null;
                if (this.f22003a.f21015o.mo596a(ExperimentsForMediaGalleryAbTestModule.i, false)) {
                    onDismissListener = new 1(this);
                } else {
                    m29783a(this, true);
                }
                ((PhotoGalleryLauncherHelper) this.f22003a.f21006f.get()).a(this.f22005c, ((HasPhotoAttachment) v).getPhotoAttachmentView(), this.f22004b, z, i, onDismissListener);
                return;
            }
            m29783a(this, true);
            this.f22003a.f21013m.mo1219a(false);
        }

        public static void m29783a(LaunchPhotoGalleryClickListener launchPhotoGalleryClickListener, boolean z) {
            launchPhotoGalleryClickListener.f22003a.f21016p.m14462a((FeedUnit) launchPhotoGalleryClickListener.f22006d.f13444a, (HasInvalidate) launchPhotoGalleryClickListener.f22007e, Boolean.valueOf(z));
        }
    }

    /* compiled from: hit */
    public class State {
        public final DraweeController f22026a;
        public final OnPhotoClickListener f22027b;
        public final OnPhotoClickListener f22028c;
        public final Uri f22029d;
        public final String f22030e;
        public final PointF f22031f;
        public final int f22032g;
        public final int f22033h;
        public final String f22034i;
        public final DimensionData f22035j;

        public State(DimensionData dimensionData, DraweeController draweeController, OnPhotoClickListener onPhotoClickListener, OnPhotoClickListener onPhotoClickListener2, PointF pointF, Uri uri, String str, int i, int i2, String str2) {
            this.f22035j = dimensionData;
            this.f22026a = draweeController;
            this.f22027b = onPhotoClickListener;
            this.f22028c = onPhotoClickListener2;
            this.f22031f = pointF;
            this.f22029d = uri;
            this.f22030e = str;
            this.f22032g = i;
            this.f22033h = i2;
            this.f22034i = str2;
        }
    }

    private static BasePhotoAttachmentPartDefinition m28732b(InjectorLike injectorLike) {
        return new BasePhotoAttachmentPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), ViewDimensionsPartDefinition.m28737a(injectorLike), PhotoAttachmentLayoutHelper.m28742a(injectorLike), DrawableUtil.m28756a(injectorLike), FeedEventBus.m4573a(injectorLike), IdBasedLazy.m1808a(injectorLike, 4891), IdBasedLazy.m1808a(injectorLike, 9520), PostpostTaggingUtil.m28760a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike), FbDraweeControllerBuilder.m19409a(injectorLike), DialtoneControllerImpl.m8272a(injectorLike), GalleryVisibilityState.m28771a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), InlineCommentComposerCache.m14459a(injectorLike), AutomaticPhotoCaptioningUtils.m10186a(injectorLike), PhotoAttachmentUtil.m28775a(injectorLike));
    }

    public static BasePhotoAttachmentPartDefinition m28731a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21001t) {
                BasePhotoAttachmentPartDefinition basePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    basePhotoAttachmentPartDefinition = (BasePhotoAttachmentPartDefinition) a2.mo818a(f21001t);
                } else {
                    basePhotoAttachmentPartDefinition = f21000s;
                }
                if (basePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28732b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21001t, b3);
                        } else {
                            f21000s = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = basePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        float f;
        String k;
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        PaddingStyle a = this.f21018r.m28777a(feedProps, (HasPositionInformation) hasFeedListType);
        FeedProps e = AttachmentProps.m28715e(feedProps);
        subParts.mo2756a(this.f21002b, new StylingData(e, a));
        int a2 = this.f21010j.m19174a(a, e, this.f21011k);
        FeedListType c = hasFeedListType.mo2446c();
        if (c.mo2419a() == FeedListName.SEARCH_DENSE_FEED || c.mo2419a() == FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI) {
            f = 0.5625f;
        } else {
            f = 0.0f;
        }
        PhotoAttachmentInfo a3 = this.f21004d.m28745a(graphQLStoryAttachment.m23979r(), this.f21005e, a2, f);
        if (this.f21017q.m10188a()) {
            k = graphQLStoryAttachment.m23979r().m24454k();
        } else {
            k = null;
        }
        String str = k;
        DimensionData dimensionData = new DimensionData(a3.f21997g, a3.f21998h);
        subParts.mo2755a(2131565875, this.f21003c, dimensionData);
        return m28730a(dimensionData, feedProps, a3, hasFeedListType, str);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 213312045);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        ((HasPhotoAttachment) view).setController(state.f22026a);
        ((HasPhotoAttachment) view).setOnPhotoClickListener(state.f22027b);
        ((HasPhotoAttachment) view).setOnBadgeClickListener(state.f22028c);
        ((HasPhotoAttachment) view).setPairedVideoUri(state.f22030e);
        ((HasPhotoAttachment) view).mo3214a(graphQLStoryAttachment.m23979r() != null ? graphQLStoryAttachment.m23979r().m24452b() : null, this.f21014n.f21040c);
        ((HasPhotoAttachment) view).setActualImageFocusPoint(state.f22031f);
        if (this.f21009i.m28768a(AttachmentProps.m28714c(feedProps))) {
            ((HasPhotoAttachment) view).mo3213a(0, 0);
        } else {
            ((HasPhotoAttachment) view).mo3213a(state.f22032g, state.f22033h);
        }
        ((HasPhotoAttachment) view).getPhotoAttachmentView().setContentDescription(state.f22034i != null ? state.f22034i : view.getContext().getString(2131230814));
        if (!this.f21013m.mo1231j() || this.f21013m.mo1215a(state.f22029d, f20999a)) {
            state.f22035j.f22000b = false;
        } else {
            state.f22035j.f22000b = true;
            state.f22035j.f21999a = this.f21013m.mo1226e();
        }
        Logger.a(8, EntryType.MARK_POP, 1309176298, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HasPhotoAttachment) view).getUnderlyingDraweeView().setController(null);
        ((HasPhotoAttachment) view).setOnPhotoClickListener(null);
        ((HasPhotoAttachment) view).mo3213a(0, 0);
        ((HasPhotoAttachment) view).setOnBadgeClickListener(null);
    }

    @Inject
    public BasePhotoAttachmentPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition, ViewDimensionsPartDefinition viewDimensionsPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, DrawableUtil drawableUtil, FeedEventBus feedEventBus, Lazy<PhotoGalleryLauncherHelper> lazy, Lazy<PlacePickerLauncher> lazy2, PostpostTaggingUtil postpostTaggingUtil, BasePaddingStyleResolver basePaddingStyleResolver, FbDraweeControllerBuilder fbDraweeControllerBuilder, DialtoneController dialtoneController, GalleryVisibilityState galleryVisibilityState, QeAccessor qeAccessor, InlineCommentComposerCache inlineCommentComposerCache, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, PhotoAttachmentUtil photoAttachmentUtil) {
        this.f21002b = backgroundPartDefinition;
        this.f21003c = viewDimensionsPartDefinition;
        this.f21004d = photoAttachmentLayoutHelper;
        this.f21008h = feedEventBus;
        this.f21006f = lazy;
        this.f21007g = lazy2;
        this.f21009i = postpostTaggingUtil;
        this.f21010j = basePaddingStyleResolver;
        this.f21012l = fbDraweeControllerBuilder;
        this.f21013m = dialtoneController;
        this.f21014n = galleryVisibilityState;
        this.f21016p = inlineCommentComposerCache;
        this.f21018r = photoAttachmentUtil;
        this.f21015o = qeAccessor;
        this.f21017q = automaticPhotoCaptioningUtils;
        this.f21011k = (float) resources.getDimensionPixelSize(2131427380);
        this.f21005e = drawableUtil.m28758a(2130840254);
        galleryVisibilityState.m28773a();
    }

    private State m28730a(DimensionData dimensionData, FeedProps<GraphQLStoryAttachment> feedProps, PhotoAttachmentInfo photoAttachmentInfo, E e, String str) {
        String b = photoAttachmentInfo.m29776b();
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        PointF a = PhotoAttachmentLayoutHelper.m28739a(graphQLStoryAttachment.m23979r());
        ((HasPrefetcher) e).mo2434a(photoAttachmentInfo.m29780h(), f20999a);
        LaunchPhotoGalleryClickListener launchPhotoGalleryClickListener = new LaunchPhotoGalleryClickListener(this, photoAttachmentInfo.m29780h(), feedProps, e);
        int a2 = this.f21009i.m28766a((FeedProps) feedProps, graphQLStoryAttachment.m23979r());
        int i = 0;
        OnPhotoClickListener onPhotoClickListener = null;
        switch (a2) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = this.f21009i.m28767a(graphQLStoryAttachment.m23979r());
                Object obj = launchPhotoGalleryClickListener;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                onPhotoClickListener = new LaunchPlacePickerClickListener(this, feedProps);
                break;
        }
        AbstractDraweeControllerBuilder r = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f21012l.m19417a(f20999a).m19441a(true)).m19456d(photoAttachmentInfo.m29781i())).m19434r();
        if (photoAttachmentInfo.m29779g() != null) {
            r.m19452c(null);
            r.m19442a(photoAttachmentInfo.m29779g());
        } else {
            ((FbDraweeControllerBuilder) r.m19452c(photoAttachmentInfo.m29780h())).m19442a(null);
        }
        DraweeController s = r.m19435s();
        ((HasImageLoadListener) e).mo2426a(s, AttachmentProps.m28712a((FeedProps) feedProps).mo2507g(), photoAttachmentInfo.m29780h());
        return new State(dimensionData, s, launchPhotoGalleryClickListener, onPhotoClickListener, a, photoAttachmentInfo.m29775a(), b, a2, i, str);
    }
}
