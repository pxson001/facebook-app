package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.VideoSizeAndBackgroundOverride;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StorySetAnalyticsAttributes;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: jsc_perf_event */
public class VideoSetsVideoPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<StorySetPageProps, Integer, E, RichVideoAttachmentView> {
    public static final ViewType<RichVideoAttachmentView> f18572a = new C07381();
    private static VideoSetsVideoPartDefinition f18573g;
    private static final Object f18574h = new Object();
    private final Context f18575b;
    private final RichVideoPlayerPartDefinition<E, RichVideoAttachmentView> f18576c;
    private final VideoSetsChannelFeedLauncherPartDefinition<E, RichVideoAttachmentView> f18577d;
    private final VideoSetsQeAccessor f18578e;
    private final VideoLoggingPropertyBag f18579f;

    /* compiled from: jsc_perf_event */
    final class C07381 extends ViewType<RichVideoAttachmentView> {
        C07381() {
        }

        public final View mo1995a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static VideoSetsVideoPartDefinition m26048b(InjectorLike injectorLike) {
        return new VideoSetsVideoPartDefinition((Context) injectorLike.getInstance(Context.class), RichVideoPlayerPartDefinition.a(injectorLike), VideoSetsChannelFeedLauncherPartDefinition.a(injectorLike), VideoSetsQeAccessor.m15178a(injectorLike), VideoLoggingPropertyBag.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        Flattenable o = StoryAttachmentHelper.m28042o((GraphQLStory) storySetPageProps.b.f13444a);
        m26047a(storySetPageProps, GraphQLMediaConversionHelper.b(o.m23979r()));
        AtomicReference atomicReference = new AtomicReference();
        Optional a = m26046a(storySetPageProps);
        subParts.mo2756a(this.f18576c, new Props(storySetPageProps.b.m19803a(o), storySetPageProps.c, a, atomicReference, PlayerOrigin.VIDEO_SETS));
        subParts.mo2756a(this.f18577d, new VideoSetsChannelFeedLauncherPartDefinition.Props(storySetPageProps, atomicReference, 3));
        return a.isPresent() ? Integer.valueOf(((VideoSizeAndBackgroundOverride) a.get()).b) : null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 813558017);
        Integer num = (Integer) obj2;
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        if (!(num == null || richVideoAttachmentView.getLayoutParams() == null)) {
            richVideoAttachmentView.getLayoutParams().height = num.intValue();
        }
        Logger.a(8, EntryType.MARK_POP, -915828583, a);
    }

    public static VideoSetsVideoPartDefinition m26045a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18574h) {
                VideoSetsVideoPartDefinition videoSetsVideoPartDefinition;
                if (a2 != null) {
                    videoSetsVideoPartDefinition = (VideoSetsVideoPartDefinition) a2.mo818a(f18574h);
                } else {
                    videoSetsVideoPartDefinition = f18573g;
                }
                if (videoSetsVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26048b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18574h, b3);
                        } else {
                            f18573g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VideoSetsVideoPartDefinition(Context context, RichVideoPlayerPartDefinition richVideoPlayerPartDefinition, VideoSetsChannelFeedLauncherPartDefinition videoSetsChannelFeedLauncherPartDefinition, VideoSetsQeAccessor videoSetsQeAccessor, VideoLoggingPropertyBag videoLoggingPropertyBag) {
        this.f18575b = context;
        this.f18576c = richVideoPlayerPartDefinition;
        this.f18577d = videoSetsChannelFeedLauncherPartDefinition;
        this.f18578e = videoSetsQeAccessor;
        this.f18579f = videoLoggingPropertyBag;
    }

    public final ViewType<RichVideoAttachmentView> mo2547a() {
        return f18572a;
    }

    public final boolean m26052a(Object obj) {
        return true;
    }

    private Optional<VideoSizeAndBackgroundOverride> m26046a(StorySetPageProps storySetPageProps) {
        if (!this.f18578e.m15182e()) {
            return Absent.INSTANCE;
        }
        int a = storySetPageProps.d - SizeUtil.m19191a(this.f18575b, 8.0f);
        return Optional.of(new VideoSizeAndBackgroundOverride(a, (int) (((float) a) / 1.39f), 0));
    }

    private void m26047a(StorySetPageProps storySetPageProps, GraphQLVideo graphQLVideo) {
        if (graphQLVideo != null) {
            this.f18579f.a(graphQLVideo.m24060J(), StorySetAnalyticsAttributes.STORY_SET_ID.value, ((GraphQLStorySet) storySetPageProps.a.f13444a).mo2507g());
            this.f18579f.a(graphQLVideo.m24060J(), StorySetAnalyticsAttributes.STORY_SET_VIDEO_POSITION.value, Integer.valueOf(storySetPageProps.c));
        }
    }
}
