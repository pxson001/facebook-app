package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.Surface;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.videohome.adapter.viewholders.DefaultTopicClickListener;
import com.facebook.video.videohome.adapter.viewholders.DefaultTopicClickListenerProvider;
import com.facebook.video.videohome.adapter.viewholders.TopicViewHolder;
import com.facebook.video.videohome.adapter.viewholders.TopicViewHolder.TopicClickListener;
import com.facebook.video.videohome.environment.HasReactionSessionId;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms/mms thread mark read failed. # threads = %d */
public class VideoHomeExploreFeedRecommendationUnitPartDefinition<E extends HasContext & HasReactionSessionId> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, TopicClickListener, E, View> {
    public static final ViewType<View> f3058a = new C02871();
    private static VideoHomeExploreFeedRecommendationUnitPartDefinition f3059f;
    private static final Object f3060g = new Object();
    private final DefaultTopicClickListenerProvider f3061b;
    public final AbstractFbErrorReporter f3062c;
    public final Toaster f3063d;
    public final VideoHomeSessionManager f3064e;

    /* compiled from: sms/mms thread mark read failed. # threads = %d */
    final class C02871 extends ViewType<View> {
        C02871() {
        }

        public final View m2926a(Context context) {
            return LayoutInflater.from(new ContextThemeWrapper(context, 2131625886)).inflate(2130907717, null);
        }
    }

    /* compiled from: sms/mms thread mark read failed. # threads = %d */
    class C02893 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomeExploreFeedRecommendationUnitPartDefinition f3057a;

        C02893(VideoHomeExploreFeedRecommendationUnitPartDefinition videoHomeExploreFeedRecommendationUnitPartDefinition) {
            this.f3057a = videoHomeExploreFeedRecommendationUnitPartDefinition;
        }

        public final void m2929a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f3057a.f3064e.g() && this.f3057a.f3064e.i()) {
                this.f3057a.f3064e.c();
            }
        }
    }

    private static VideoHomeExploreFeedRecommendationUnitPartDefinition m2931b(InjectorLike injectorLike) {
        return new VideoHomeExploreFeedRecommendationUnitPartDefinition((DefaultTopicClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultTopicClickListenerProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Toaster.b(injectorLike), VideoHomeSessionManager.a(injectorLike));
    }

    public final Object m2933a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final HasContext hasContext = (HasContext) anyEnvironment;
        return this.f3061b.m2653a(new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ VideoHomeExploreFeedRecommendationUnitPartDefinition f3056b;

            protected final void m2927a(Object obj) {
            }

            protected final void m2928a(Throwable th) {
                this.f3056b.f3063d.a(new ToastBuilder(hasContext.getContext().getString(2131237324)));
                this.f3056b.f3062c.a(getClass().getSimpleName(), "Failed to pin/unpin topic", th);
            }
        }, hasContext.getContext(), ((HasReactionSessionId) hasContext).kL_(), PlayerOrigin.VIDEO_HOME, Surface.TOPICS_UPSELL_UNIT, new C02893(this));
    }

    public final /* bridge */ /* synthetic */ void m2934a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -816531303);
        new TopicViewHolder(view, (DefaultTopicClickListener) obj2).m2656a(((ReactionUnitComponentNode) obj).b.av());
        Logger.a(8, EntryType.MARK_POP, 1492391811, a);
    }

    public static VideoHomeExploreFeedRecommendationUnitPartDefinition m2930a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeExploreFeedRecommendationUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3060g) {
                VideoHomeExploreFeedRecommendationUnitPartDefinition videoHomeExploreFeedRecommendationUnitPartDefinition;
                if (a2 != null) {
                    videoHomeExploreFeedRecommendationUnitPartDefinition = (VideoHomeExploreFeedRecommendationUnitPartDefinition) a2.a(f3060g);
                } else {
                    videoHomeExploreFeedRecommendationUnitPartDefinition = f3059f;
                }
                if (videoHomeExploreFeedRecommendationUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2931b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3060g, b3);
                        } else {
                            f3059f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeExploreFeedRecommendationUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeExploreFeedRecommendationUnitPartDefinition(DefaultTopicClickListenerProvider defaultTopicClickListenerProvider, AbstractFbErrorReporter abstractFbErrorReporter, Toaster toaster, VideoHomeSessionManager videoHomeSessionManager) {
        this.f3061b = defaultTopicClickListenerProvider;
        this.f3062c = abstractFbErrorReporter;
        this.f3063d = toaster;
        this.f3064e = videoHomeSessionManager;
    }

    public final void m2936b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TopicViewHolder topicViewHolder = new TopicViewHolder(view, null);
        topicViewHolder.a.setOnClickListener(null);
        topicViewHolder.f2778n.setOnClickListener(null);
    }

    public final boolean m2935a(Object obj) {
        return true;
    }

    public final ViewType<View> m2932a() {
        return f3058a;
    }
}
