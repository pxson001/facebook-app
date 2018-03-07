package com.facebook.feedplugins.video;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.fallback.annotations.FallbackSpec;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.feedplugins.attachments.video.VideoSizer.VideoSize;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
@FallbackSpec(mountType = RichVideoAttachmentView.class)
/* compiled from: ufi/reactions/v2/16x16/like */
public class RichVideoRowPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, RichVideoAttachmentView> {
    public static final ViewType<RichVideoAttachmentView> f189a = new C00031();
    private static RichVideoRowPartDefinition f190j;
    private static final Object f191k = new Object();
    private final VideoAttachmentBackgroundPartDefinition<E> f192b;
    private final Lazy<RichVideoPlayerPartDefinition<E, RichVideoAttachmentView>> f193c;
    private final ChannelFeedFromVideoLauncherPartDefinition<E, RichVideoAttachmentView> f194d;
    private final InlineVideoAttachmentPartDefinition<FeedEnvironment> f195e;
    private final Inline360VideoAttachmentPartDefinition<FeedEnvironment> f196f;
    private final DataSensitivitySettingsPrefUtil f197g;
    private final Display f198h;
    private final VideoSizer f199i;

    /* compiled from: ufi/reactions/v2/16x16/like */
    final class C00031 extends ViewType<RichVideoAttachmentView> {
        C00031() {
        }

        public final View m182a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static RichVideoRowPartDefinition m177b(InjectorLike injectorLike) {
        return new RichVideoRowPartDefinition(VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), IdBasedLazy.a(injectorLike, 2061), ChannelFeedFromVideoLauncherPartDefinition.m173a(injectorLike), InlineVideoAttachmentPartDefinition.m153a(injectorLike), Inline360VideoAttachmentPartDefinition.m183a(injectorLike), DataSensitivitySettingsPrefUtil.a(injectorLike), VideoSizer.m108a(injectorLike), WindowManagerMethodAutoProvider.b(injectorLike));
    }

    public final Object m179a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Optional of;
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f192b, feedProps);
        AtomicReference atomicReference = new AtomicReference();
        Absent absent = Absent.INSTANCE;
        if (this.f197g.b(false)) {
            Point point = new Point();
            this.f198h.getSize(point);
            point.x /= 2;
            VideoSize a = this.f199i.m111a(feedProps, 0.0f, point);
            of = Optional.of(new VideoSizeAndBackgroundOverride(a.a, a.b, 0));
        } else {
            of = absent;
        }
        subParts.a((SinglePartDefinition) this.f193c.get(), new Props(feedProps, -1, of, atomicReference));
        subParts.a(this.f194d, new ChannelFeedFromVideoLauncherPartDefinition.Props(feedProps, atomicReference));
        return null;
    }

    public static RichVideoRowPartDefinition m176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichVideoRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f191k) {
                RichVideoRowPartDefinition richVideoRowPartDefinition;
                if (a2 != null) {
                    richVideoRowPartDefinition = (RichVideoRowPartDefinition) a2.a(f191k);
                } else {
                    richVideoRowPartDefinition = f190j;
                }
                if (richVideoRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f191k, b3);
                        } else {
                            f190j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richVideoRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichVideoRowPartDefinition(VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, Lazy<RichVideoPlayerPartDefinition> lazy, ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition, InlineVideoAttachmentPartDefinition inlineVideoAttachmentPartDefinition, Inline360VideoAttachmentPartDefinition inline360VideoAttachmentPartDefinition, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, VideoSizer videoSizer, WindowManager windowManager) {
        this.f192b = videoAttachmentBackgroundPartDefinition;
        this.f193c = lazy;
        this.f194d = channelFeedFromVideoLauncherPartDefinition;
        this.f195e = inlineVideoAttachmentPartDefinition;
        this.f196f = inline360VideoAttachmentPartDefinition;
        this.f197g = dataSensitivitySettingsPrefUtil;
        this.f199i = videoSizer;
        this.f198h = windowManager.getDefaultDisplay();
    }

    public final ViewType<RichVideoAttachmentView> m178a() {
        return f189a;
    }

    public final boolean m180a(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (Inline360VideoAttachmentPartDefinition.m185b((FeedProps) feedProps)) {
            return this.f196f.m188a((FeedProps) feedProps);
        }
        return this.f195e.m157a((FeedProps) feedProps);
    }
}
