package com.facebook.feedplugins.storyset.funnel;

import com.facebook.feedplugins.storyset.experiment.ExperimentsForStorySetsExperimentModule;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.funnellogger.FunnelDefinition;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: player_version */
public class StorySetFunnelLogger {
    private static final FunnelDefinition f4459d = FunnelRegistry.A;
    @Inject
    public FunnelLoggerImpl f4460a;
    @Inject
    public VideoSetsQeAccessor f4461b;
    @Inject
    public StorySetLruCache f4462c;

    public static StorySetFunnelLogger m4966b(InjectorLike injectorLike) {
        StorySetFunnelLogger storySetFunnelLogger = new StorySetFunnelLogger();
        VideoSetsQeAccessor a = VideoSetsQeAccessor.a(injectorLike);
        StorySetLruCache storySetLruCache = new StorySetLruCache();
        storySetFunnelLogger.f4460a = FunnelLoggerImpl.a(injectorLike);
        storySetFunnelLogger.f4461b = a;
        storySetFunnelLogger.f4462c = storySetLruCache;
        return storySetFunnelLogger;
    }

    public final void m4967a(FunnelDefinition funnelDefinition, GraphQLStorySet graphQLStorySet) {
        this.f4460a.a(funnelDefinition, (long) m4963a(graphQLStorySet));
    }

    public final void m4969b(FunnelDefinition funnelDefinition, GraphQLStorySet graphQLStorySet) {
        short a = m4963a(graphQLStorySet);
        if (funnelDefinition.equals(f4459d)) {
            m4965a(a);
        }
    }

    public final void m4968a(FunnelDefinition funnelDefinition, GraphQLStorySet graphQLStorySet, int i, String str) {
        String str2;
        FunnelLoggerImpl funnelLoggerImpl = this.f4460a;
        long a = (long) m4963a(graphQLStorySet);
        switch (i) {
            case 0:
                str2 = "page_swipe";
                break;
            case 1:
                str2 = "page_swipe_end";
                break;
            case 2:
                str2 = "see_all";
                break;
            case 3:
                str2 = "enter_channel";
                break;
            default:
                str2 = "";
                break;
        }
        funnelLoggerImpl.a(funnelDefinition, a, str2, str);
    }

    public final void m4970c(FunnelDefinition funnelDefinition, GraphQLStorySet graphQLStorySet) {
        this.f4460a.b(funnelDefinition, (long) m4963a(graphQLStorySet));
    }

    private short m4963a(GraphQLStorySet graphQLStorySet) {
        return this.f4462c.m4971a(graphQLStorySet.g());
    }

    private void m4965a(short s) {
        this.f4460a.a(f4459d, (long) s, "video_sets_tag:v3");
        List arrayList = new ArrayList();
        if (this.f4461b.a.a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f, false)) {
            arrayList.add("Recommended");
        } else {
            arrayList.add("Friends");
        }
        if (this.f4461b.b()) {
            arrayList.add("UFI");
        } else if (this.f4461b.c()) {
            arrayList.add("SocialSentence");
        } else {
            arrayList.add("BasicBlingbar");
        }
        if (this.f4461b.e()) {
            arrayList.add("NewAspectRatio");
        }
        if (this.f4461b.f()) {
            arrayList.add("VolumeControl");
        }
        arrayList.add("IconVersion:" + this.f4461b.g());
        arrayList.add("QeNumStories:" + this.f4461b.h());
        m4964a(f4459d, s, arrayList);
    }

    private void m4964a(FunnelDefinition funnelDefinition, short s, List<String> list) {
        for (String a : list) {
            this.f4460a.a(funnelDefinition, (long) s, a);
        }
    }
}
