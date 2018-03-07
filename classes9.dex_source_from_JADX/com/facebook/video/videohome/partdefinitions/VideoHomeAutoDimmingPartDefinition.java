package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.HasVideoAutoDimming;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.channelfeed.ChannelFeedDimmingController;
import com.facebook.video.videohome.environment.VideoHomeStoryPersistentState;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;

@ContextScoped
/* compiled from: smstakeover_schema */
public class VideoHomeAutoDimmingPartDefinition<E extends HasVideoAutoDimming<VideoHomeVideoPlayerView>> extends BaseSinglePartDefinition<VideoHomeStoryPersistentState, ChannelFeedDimmingController, E, VideoHomeVideoPlayerView> {
    private static VideoHomeAutoDimmingPartDefinition f3012a;
    private static final Object f3013b = new Object();

    private static VideoHomeAutoDimmingPartDefinition m2892a() {
        return new VideoHomeAutoDimmingPartDefinition();
    }

    public final Object m2894a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return ((VideoHomeStoryPersistentState) obj).f2889c;
    }

    public final /* bridge */ /* synthetic */ void m2895a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1240544402);
        ((HasVideoAutoDimming) anyEnvironment).a((VideoHomeVideoPlayerView) view, (ChannelFeedDimmingController) obj2);
        Logger.a(8, EntryType.MARK_POP, 2036998630, a);
    }

    public static VideoHomeAutoDimmingPartDefinition m2893a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeAutoDimmingPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f3013b) {
                VideoHomeAutoDimmingPartDefinition videoHomeAutoDimmingPartDefinition;
                if (a3 != null) {
                    videoHomeAutoDimmingPartDefinition = (VideoHomeAutoDimmingPartDefinition) a3.a(f3013b);
                } else {
                    videoHomeAutoDimmingPartDefinition = f3012a;
                }
                if (videoHomeAutoDimmingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m2892a();
                        if (a3 != null) {
                            a3.a(f3013b, a2);
                        } else {
                            f3012a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = videoHomeAutoDimmingPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
