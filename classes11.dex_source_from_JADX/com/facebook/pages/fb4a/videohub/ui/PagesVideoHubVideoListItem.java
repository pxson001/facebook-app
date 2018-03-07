package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
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
import com.facebook.pages.fb4a.videohub.fragments.VideoHubPermalinkFragment;
import com.facebook.pages.fb4a.videohub.util.VideoModelMutator;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_review_write_failure */
public class PagesVideoHubVideoListItem extends CustomLinearLayout {
    public static final CallerContext f3128e = CallerContext.a(VideoHubPermalinkFragment.class, "pages_public_view");
    @Inject
    public Provider<FbDraweeControllerBuilder> f3129a;
    @Inject
    NumberTruncationUtil f3130b;
    @Inject
    FullscreenVideoPlayerLauncher f3131c;
    @Inject
    public FeedEventBus f3132d;
    public final String f3133f;
    private final FbTextView f3134g;
    public final FbDraweeView f3135h;
    public final FbTextView f3136i;
    private VideoDetailFragmentModel f3137j;

    /* compiled from: privacy_review_write_failure */
    class LikeUpdatedUIEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEventSubscriber {
        final /* synthetic */ PagesVideoHubVideoListItem f3127a;

        public LikeUpdatedUIEventSubscriber(PagesVideoHubVideoListItem pagesVideoHubVideoListItem) {
            this.f3127a = pagesVideoHubVideoListItem;
        }

        public final void m4218b(FbEvent fbEvent) {
            LikeUpdatedUIEvent likeUpdatedUIEvent = (LikeUpdatedUIEvent) fbEvent;
            this.f3127a.m4223a(likeUpdatedUIEvent.a, likeUpdatedUIEvent.b);
        }
    }

    private static <T extends View> void m4221a(Class<T> cls, T t) {
        m4222a((Object) t, t.getContext());
    }

    private static void m4222a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesVideoHubVideoListItem) obj).m4224a(IdBasedProvider.a(fbInjector, 1117), NumberTruncationUtil.a(fbInjector), FullscreenVideoPlayerLauncher.b(fbInjector), FeedEventBus.a(fbInjector));
    }

    private void m4223a(String str, boolean z) {
        this.f3137j = VideoModelMutator.m4233a(this.f3137j, str, z);
    }

    protected FeedEventBus getEventBus() {
        return this.f3132d;
    }

    public static String m4219a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        return defaultTextWithEntitiesFields != null ? defaultTextWithEntitiesFields.a() : null;
    }

    public PagesVideoHubVideoListItem(Context context) {
        this(context, null);
    }

    public PagesVideoHubVideoListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4221a(PagesVideoHubVideoListItem.class, (View) this);
        setContentView(2130907687);
        setOrientation(0);
        this.f3133f = context.getString(2131235506);
        this.f3134g = (FbTextView) findViewById(2131568357);
        this.f3135h = (FbDraweeView) findViewById(2131568354);
        this.f3136i = (FbTextView) findViewById(2131568356);
        a(new LikeUpdatedUIEventSubscriber(this));
    }

    private void m4225b(final VideoDetailFragmentModel videoDetailFragmentModel) {
        this.f3137j = videoDetailFragmentModel;
        this.f3135h.setAspectRatio(1.7777778f);
        this.f3135h.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.g).u());
        if (!(videoDetailFragmentModel == null || videoDetailFragmentModel.F() == null)) {
            Uri parse;
            String b = videoDetailFragmentModel.F().b();
            if (b != null) {
                parse = Uri.parse(b);
            } else {
                parse = null;
            }
            this.f3135h.setController(((FbDraweeControllerBuilder) this.f3129a.get()).a(f3128e).b(parse).s());
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PagesVideoHubVideoListItem f3126b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1188523606);
                    this.f3126b.f3131c.b(videoDetailFragmentModel, this.f3126b.getContext(), PlayerOrigin.PAGE_TIMELINE);
                    Logger.a(2, EntryType.UI_INPUT_END, -2113184397, a);
                }
            });
        }
        CharSequence a = m4219a(videoDetailFragmentModel.E());
        CharSequence a2 = m4219a(videoDetailFragmentModel.s());
        if (!StringUtil.a(a)) {
            this.f3136i.setText(a);
        } else if (StringUtil.a(a2)) {
            this.f3136i.setText(this.f3133f);
        } else {
            this.f3136i.setText(a2);
        }
        setVideoPreviewStats(videoDetailFragmentModel);
    }

    public final void m4227a(VideoDetailFragmentModel videoDetailFragmentModel) {
        m4225b(videoDetailFragmentModel);
    }

    private void m4224a(Provider<FbDraweeControllerBuilder> provider, NumberTruncationUtil numberTruncationUtil, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, FeedEventBus feedEventBus) {
        this.f3129a = provider;
        this.f3130b = numberTruncationUtil;
        this.f3131c = fullscreenVideoPlayerLauncher;
        this.f3132d = feedEventBus;
    }

    private void setVideoPreviewStats(VideoDetailFragmentModel videoDetailFragmentModel) {
        Resources resources = getResources();
        if (videoDetailFragmentModel.g() != null && videoDetailFragmentModel.g().d() != null) {
            int t = videoDetailFragmentModel.t();
            FeedbackModel d = videoDetailFragmentModel.g().d();
            int a = d.j() != null ? d.j().a() : 0;
            String quantityString = resources.getQuantityString(2131689625, a, new Object[]{m4226c(a)});
            String quantityString2 = resources.getQuantityString(2131689621, t, new Object[]{m4226c(t)});
            StringBuffer stringBuffer = new StringBuffer();
            if (a > 0 && t > 0) {
                stringBuffer.append(quantityString);
                stringBuffer.append(" • ");
                stringBuffer.append(quantityString2);
            } else if (a > 0) {
                stringBuffer.append(quantityString);
            } else if (t > 0) {
                stringBuffer.append(quantityString2);
            }
            this.f3134g.setText(stringBuffer.toString());
        }
    }

    private String m4226c(int i) {
        if (i >= 1000) {
            return this.f3130b.a(i);
        }
        return StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(i)});
    }
}
