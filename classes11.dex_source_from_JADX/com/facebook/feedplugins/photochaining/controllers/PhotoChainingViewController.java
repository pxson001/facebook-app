package com.facebook.feedplugins.photochaining.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.internal.widget.ViewUtils;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.feed.ui.chaining.HScrollChainingUtil;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.feed.ui.chaining.HScrollChainingViewController.ItemListRecyclablePagerAdapter;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.photochaining.view.PhotoChainingFeedUnitItemView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.photos.photogallery.photoviewcontrollers.NestedViewPagerPhotoViewController;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.CustomViewPager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_section_prelim */
public class PhotoChainingViewController extends HScrollChainingViewController {
    private static final PagerViewType f8589e = new C10571();
    private static final CallerContext f8590f = CallerContext.a(PhotoChainingViewController.class, "photo_gallery");
    private static PhotoChainingViewController f8591o;
    private static final Object f8592p = new Object();
    private final FeedImageLoader f8593g;
    public final AnalyticsLogger f8594h;
    private final NavigationLogger f8595i;
    private final NewsFeedAnalyticsEventBuilder f8596j;
    private final MediaGalleryLauncher f8597k;
    private final MediaGalleryLauncherParamsFactory f8598l;
    private final InstagramUtils f8599m;
    private final FbDraweeControllerBuilder f8600n;

    /* compiled from: collections_section_prelim */
    final class C10571 implements PagerViewType {
        C10571() {
        }

        public final Class m9429a() {
            return PhotoChainingFeedUnitItemView.class;
        }

        public final View m9428a(Context context) {
            return new PhotoChainingFeedUnitItemView(context);
        }
    }

    /* compiled from: collections_section_prelim */
    public class C10593 {
        final /* synthetic */ PhotoChainingViewController f8583a;

        C10593(PhotoChainingViewController photoChainingViewController) {
            this.f8583a = photoChainingViewController;
        }
    }

    /* compiled from: collections_section_prelim */
    class PhotoChainingAnimationParamProvider implements AnimationParamProvider {
        private ImageView f8584a;
        private GraphQLStoryAttachment f8585b;
        private ImageRequest f8586c;
        private CustomViewPager f8587d;
        private FeedImageLoader f8588e;

        private PhotoChainingAnimationParamProvider(ImageView imageView, GraphQLStoryAttachment graphQLStoryAttachment, ImageRequest imageRequest, CustomViewPager customViewPager, FeedImageLoader feedImageLoader) {
            this.f8584a = imageView;
            this.f8585b = graphQLStoryAttachment;
            this.f8586c = imageRequest;
            this.f8587d = customViewPager;
            this.f8588e = feedImageLoader;
        }

        public final AnimationParams m9430a(String str) {
            if (str.equals(this.f8585b.r().b()) && this.f8584a.getDrawable() != null) {
                return new AnimationParams(DrawingRule.a(this.f8584a), this.f8586c);
            }
            GraphQLStoryAttachment o;
            int i = 0;
            AnimationParams animationParams = null;
            PhotoChainingFeedUnitItemView photoChainingFeedUnitItemView = null;
            while (i < this.f8587d.getChildCount()) {
                photoChainingFeedUnitItemView = (PhotoChainingFeedUnitItemView) this.f8587d.getChildAt(i);
                if (photoChainingFeedUnitItemView != null) {
                    GraphQLStory graphQLStory = (GraphQLStory) photoChainingFeedUnitItemView.getTag(2131558745);
                    if (graphQLStory != null) {
                        o = StoryAttachmentHelper.o(graphQLStory);
                        if (!(o == null || o.r() == null || !str.equals(o.r().b()))) {
                            break;
                        }
                        i++;
                        animationParams = o;
                    }
                }
                o = animationParams;
                i++;
                animationParams = o;
            }
            o = animationParams;
            if (i >= this.f8587d.getChildCount()) {
                return null;
            }
            FbDraweeView fbDraweeView = photoChainingFeedUnitItemView.a.f8601a;
            if (fbDraweeView == null) {
                return null;
            }
            return new AnimationParams(DrawingRule.a(fbDraweeView), FeedImageLoader.a(GraphQLStoryAttachmentUtil.l(o)));
        }
    }

    private static PhotoChainingViewController m9435b(InjectorLike injectorLike) {
        return new PhotoChainingViewController((Context) injectorLike.getInstance(Context.class), FeedImageLoader.a(injectorLike), ScreenUtil.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), FeedRenderUtils.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), InstagramUtils.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public static PhotoChainingViewController m9431a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoChainingViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8592p) {
                PhotoChainingViewController photoChainingViewController;
                if (a2 != null) {
                    photoChainingViewController = (PhotoChainingViewController) a2.a(f8592p);
                } else {
                    photoChainingViewController = f8591o;
                }
                if (photoChainingViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9435b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8592p, b3);
                        } else {
                            f8591o = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoChainingViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ArrayNode m9437a(FeedProps<ScrollableItemListFeedUnit> feedProps) {
        GraphQLStory a = m9432a((ScrollableItemListFeedUnit) feedProps.a);
        if (a != null) {
            return TrackableFeedProps.a(feedProps.a(a));
        }
        return null;
    }

    @Inject
    public PhotoChainingViewController(Context context, FeedImageLoader feedImageLoader, ScreenUtil screenUtil, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FeedRenderUtils feedRenderUtils, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, InstagramUtils instagramUtils, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(context, screenUtil, feedRenderUtils);
        this.f8593g = feedImageLoader;
        this.f8594h = analyticsLogger;
        this.f8595i = navigationLogger;
        this.f8596j = newsFeedAnalyticsEventBuilder;
        this.f8597k = mediaGalleryLauncher;
        this.f8598l = mediaGalleryLauncherParamsFactory;
        this.f8599m = instagramUtils;
        this.f8600n = fbDraweeControllerBuilder;
    }

    protected final int m9442d() {
        return this.a.getResources().getDimensionPixelSize(2131428814);
    }

    protected final int m9444f() {
        return this.a.getResources().getDimensionPixelSize(2131428812);
    }

    protected final int m9443e() {
        return m9444f();
    }

    protected final int m9445g() {
        return this.a.getResources().getDimensionPixelSize(2131428819);
    }

    protected final Class<? extends ScrollableItemListFeedUnit> m9441c() {
        return GraphQLStorySet.class;
    }

    protected final void m9439a(FeedProps<ScrollableItemListFeedUnit> feedProps, TextView textView) {
        HScrollChainingUtil.a(this.a.getResources(), (ScrollableItemListFeedUnit) feedProps.a, textView, 2131689532);
        GraphQLStory a = m9432a((ScrollableItemListFeedUnit) feedProps.a);
        if (a != null && !ImpressionUtil.c(a)) {
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            ArrayNode a2 = TrackableFeedProps.a(feedProps.a(a));
            if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent a3 = new HoneyClientEvent("chained_story_title_impression").a("tracking", a2);
                a3.c = "native_newsfeed";
                honeyAnalyticsEvent = a3;
            }
            this.f8594h.c(honeyAnalyticsEvent);
            ImpressionUtil.b(a);
        }
    }

    public static GraphQLStory m9432a(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        if (scrollableItemListFeedUnit == null || scrollableItemListFeedUnit.v().isEmpty()) {
            return null;
        }
        return (GraphQLStory) scrollableItemListFeedUnit.v().get(0);
    }

    public final void m9438a(View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        PhotoChainingFeedUnitItemView photoChainingFeedUnitItemView = (PhotoChainingFeedUnitItemView) view;
        final GraphQLStory graphQLStory = (GraphQLStory) obj;
        FbDraweeView fbDraweeView = photoChainingFeedUnitItemView.a.f8601a;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || o.r() == null || o.r().S() == null) {
            fbDraweeView.setOnClickListener(null);
            fbDraweeView.setVisibility(8);
            return;
        }
        a(view, position);
        fbDraweeView.setController(((FbDraweeControllerBuilder) this.f8600n.a(f8590f).r().c(FeedImageLoader.a(GraphQLStoryAttachmentUtil.l(StoryAttachmentHelper.o(graphQLStory))))).s());
        final FeedListItemUserActionListener feedListItemUserActionListener2 = feedListItemUserActionListener;
        final View view2 = view;
        final ScrollableItemListFeedUnit scrollableItemListFeedUnit2 = scrollableItemListFeedUnit;
        fbDraweeView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhotoChainingViewController f8582e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -359403007);
                feedListItemUserActionListener2.a(view2, graphQLStory, scrollableItemListFeedUnit2);
                Logger.a(2, EntryType.UI_INPUT_END, 202929393, a);
            }
        });
        fbDraweeView.setVisibility(0);
        ImmutableList b = graphQLStory.b();
        if (b != null && b.size() > 0) {
            photoChainingFeedUnitItemView.getBody().f8602b.setText(((GraphQLActor) b.get(0)).aa());
        }
        photoChainingFeedUnitItemView.getBody().f8603c.setText(m9433a(graphQLStory, photoChainingFeedUnitItemView.getContext().getResources(), ViewUtils.a(photoChainingFeedUnitItemView)));
    }

    private static CharSequence m9433a(GraphQLStory graphQLStory, Resources resources, boolean z) {
        List a;
        List a2 = Lists.a();
        int aa_ = graphQLStory.aa_();
        int n = graphQLStory.n();
        Spannable spannableString = new SpannableString("  " + (aa_ == 0 ? "" : Integer.valueOf(aa_)) + " ");
        Drawable drawable = resources.getDrawable(2130841174);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(drawable, 0), 0, 1, 33);
        a2.add(spannableString);
        spannableString = new SpannableString("  " + (n == 0 ? "" : Integer.valueOf(n)));
        drawable = resources.getDrawable(2130841172);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(drawable, 0), 0, 1, 33);
        a2.add(spannableString);
        if (z) {
            a = Lists.a(a2);
        } else {
            a = a2;
        }
        return TextUtils.concat((CharSequence[]) a.toArray(new CharSequence[a.size()]));
    }

    public final void m9440a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager, View view, Object obj, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(obj);
        CustomViewPager customViewPager = (CustomViewPager) viewPager;
        PhotoChainingFeedUnitItemView photoChainingFeedUnitItemView = (PhotoChainingFeedUnitItemView) view;
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        Flattenable flattenable = (scrollableItemListFeedUnit == null || !(scrollableItemListFeedUnit instanceof GraphQLStorySet)) ? null : (GraphQLStorySet) scrollableItemListFeedUnit;
        FeedProps a = flattenable != null ? FeedProps.c(flattenable).a(graphQLStory) : FeedProps.c(graphQLStory);
        FbDraweeView fbDraweeView = photoChainingFeedUnitItemView.a.f8601a;
        this.f8595i.a("tap_photo").a(f8590f.c(), true);
        ArrayNode a2 = TrackableFeedProps.a(a);
        AnalyticsLogger analyticsLogger = this.f8594h;
        if (NewsFeedAnalyticsEventBuilder.B(a2)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a3 = new HoneyClientEvent("chained_story_item_click").a("tracking", a2);
            a3.c = "native_newsfeed";
            honeyAnalyticsEvent = a3;
        }
        analyticsLogger.c(honeyAnalyticsEvent);
        m9434a(graphQLStory, fbDraweeView, FeedImageLoader.a(GraphQLStoryAttachmentUtil.l(StoryAttachmentHelper.o(graphQLStory))), customViewPager, false, scrollableItemListFeedUnit);
    }

    private void m9434a(GraphQLStory graphQLStory, ImageView imageView, ImageRequest imageRequest, CustomViewPager customViewPager, boolean z, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        DeepLinkBinderConfig a;
        NestedViewPagerPhotoViewController nestedViewPagerPhotoViewController = new NestedViewPagerPhotoViewController(((Activity) this.a).getWindow(), customViewPager, new C10593(this));
        if (InstagramUtils.a(graphQLStory) && this.f8599m.a(InstagramEntryPoint.Photo)) {
            a = this.f8599m.a(false, null);
        } else {
            a = null;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        scrollableItemListFeedUnit = (scrollableItemListFeedUnit == null || !(scrollableItemListFeedUnit instanceof GraphQLStorySet)) ? null : (GraphQLStorySet) scrollableItemListFeedUnit;
        FeedProps a2 = scrollableItemListFeedUnit != null ? FeedProps.c(scrollableItemListFeedUnit).a(graphQLStory) : FeedProps.c(graphQLStory);
        String arrayNode = TrackableFeedProps.a(a2).toString();
        String c = ((GraphQLStory) a2.a()).c();
        String ai = ((GraphQLStory) a2.a()).ai();
        boolean p = StoryProps.p(a2);
        Builder a3 = MediaGalleryLauncherParamsFactory.a(scrollableItemListFeedUnit).a(o.r().b()).a(FullscreenGallerySource.NEWSFEED);
        a3.h = graphQLStory.g();
        a3 = a3;
        a3.k = c;
        Builder builder = a3;
        builder.i = ai;
        Builder builder2 = builder;
        builder2.l = p;
        builder2 = builder2;
        builder2.j = arrayNode;
        builder2 = builder2.a(imageRequest).a(nestedViewPagerPhotoViewController);
        builder2.o = z;
        builder2 = builder2;
        builder2.r = a;
        this.f8597k.a(this.a, builder2.b(), new PhotoChainingAnimationParamProvider(imageView, o, imageRequest, customViewPager, this.f8593g));
    }

    public final PagerViewType m9436a() {
        return f8589e;
    }
}
