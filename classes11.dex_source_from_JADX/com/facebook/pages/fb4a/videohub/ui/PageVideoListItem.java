package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.videohub.fragments.VideoPlaylistPermalinkFragment;
import com.facebook.pages.fb4a.videohub.util.VideoModelMutator;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_review_write_success */
public class PageVideoListItem extends CustomRelativeLayout {
    public static final CallerContext f3106e = CallerContext.a(VideoPlaylistPermalinkFragment.class, "pages_public_view");
    @Inject
    public Provider<FbDraweeControllerBuilder> f3107a;
    @Inject
    public NumberTruncationUtil f3108b;
    @Inject
    public FullscreenVideoPlayerLauncher f3109c;
    @Inject
    public FeedEventBus f3110d;
    public final String f3111f;
    public final BetterTextView f3112g;
    public final BetterTextView f3113h;
    public final FbDraweeView f3114i;
    public final BetterTextView f3115j;
    public final BetterTextView f3116k;
    public VideoDetailFragmentModel f3117l;

    /* compiled from: privacy_review_write_success */
    class LikeUpdatedUIEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEventSubscriber {
        final /* synthetic */ PageVideoListItem f3105a;

        public LikeUpdatedUIEventSubscriber(PageVideoListItem pageVideoListItem) {
            this.f3105a = pageVideoListItem;
        }

        public final void m4211b(FbEvent fbEvent) {
            LikeUpdatedUIEvent likeUpdatedUIEvent = (LikeUpdatedUIEvent) fbEvent;
            PageVideoListItem pageVideoListItem = this.f3105a;
            pageVideoListItem.f3117l = VideoModelMutator.m4233a(pageVideoListItem.f3117l, likeUpdatedUIEvent.a, likeUpdatedUIEvent.b);
        }
    }

    public static void m4213a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageVideoListItem pageVideoListItem = (PageVideoListItem) obj;
        Provider a = IdBasedProvider.a(fbInjector, 1117);
        NumberTruncationUtil a2 = NumberTruncationUtil.a(fbInjector);
        FullscreenVideoPlayerLauncher b = FullscreenVideoPlayerLauncher.b(fbInjector);
        FeedEventBus a3 = FeedEventBus.a(fbInjector);
        pageVideoListItem.f3107a = a;
        pageVideoListItem.f3108b = a2;
        pageVideoListItem.f3109c = b;
        pageVideoListItem.f3110d = a3;
    }

    protected /* bridge */ /* synthetic */ FbEventBus getEventBus() {
        return this.f3110d;
    }

    public static String m4212a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        return defaultTextWithEntitiesFields != null ? defaultTextWithEntitiesFields.a() : null;
    }

    public PageVideoListItem(Context context) {
        this(context, null);
    }

    private PageVideoListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PageVideoListItem.class;
        m4213a(this, getContext());
        setContentView(2130907690);
        this.f3111f = context.getString(2131235506);
        this.f3112g = (BetterTextView) a(2131563526);
        this.f3113h = (BetterTextView) a(2131568366);
        this.f3114i = (FbDraweeView) a(2131568363);
        this.f3115j = (BetterTextView) a(2131568356);
        this.f3116k = (BetterTextView) a(2131568365);
        a(new LikeUpdatedUIEventSubscriber(this));
    }

    public final void m4214a(final VideoDetailFragmentModel videoDetailFragmentModel) {
        String b;
        this.f3117l = videoDetailFragmentModel;
        this.f3114i.setAspectRatio(1.7777778f);
        this.f3114i.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.g).u());
        if (videoDetailFragmentModel.F() != null) {
            b = videoDetailFragmentModel.F().b();
        } else {
            b = null;
        }
        this.f3114i.setController(((FbDraweeControllerBuilder) this.f3107a.get()).a(f3106e).a(b).s());
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageVideoListItem f3104b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -659920455);
                this.f3104b.f3109c.b(videoDetailFragmentModel, this.f3104b.getContext(), PlayerOrigin.PAGE_VIDEO_LIST_PERMALINK);
                Logger.a(2, EntryType.UI_INPUT_END, 939220485, a);
            }
        });
        CharSequence a = m4212a(videoDetailFragmentModel.E());
        CharSequence a2 = m4212a(videoDetailFragmentModel.s());
        if (StringUtil.a(a)) {
            this.f3115j.setText(this.f3111f);
        } else {
            this.f3115j.setText(a);
        }
        if (!StringUtil.a(a2)) {
            this.f3116k.setText(a2);
        }
        if (videoDetailFragmentModel != null) {
            String a3;
            int t = videoDetailFragmentModel.t();
            BetterTextView betterTextView = this.f3112g;
            Resources resources = getResources();
            Object[] objArr = new Object[1];
            if (t < 1000) {
                a3 = StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(t)});
            } else {
                a3 = this.f3108b.a(t);
            }
            objArr[0] = a3;
            betterTextView.setText(resources.getQuantityString(2131689621, t, objArr));
            int u = videoDetailFragmentModel.u() / 1000;
            this.f3113h.setText(StringFormatUtil.formatStrLocaleSafe("%d:%02d", Integer.valueOf(u / 60), Integer.valueOf(u % 60)));
        }
    }
}
