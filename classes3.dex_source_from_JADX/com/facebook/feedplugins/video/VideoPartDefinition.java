package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.UriUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLVideo;
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
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.server.VideoPrefetchModelMethodAutoProvider;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/24x24/confused */
public class VideoPartDefinition extends MultiRowSinglePartDefinition<GraphQLVideo, VideoResourceMetadata, HasPositionInformation, TextView> {
    public static final ViewType f156a = new C00011();
    private static VideoPartDefinition f157d;
    private static final Object f158e = new Object();
    private final BackgroundPartDefinition f159b;
    private final VideoPrefetchList f160c;

    /* compiled from: ufi/reactions/v2/24x24/confused */
    final class C00011 extends ViewType {
        C00011() {
        }

        public final View m152a(Context context) {
            return new TextView(context);
        }
    }

    private static VideoPartDefinition m147b(InjectorLike injectorLike) {
        return new VideoPartDefinition(BackgroundPartDefinition.a(injectorLike), VideoPrefetchModelMethodAutoProvider.a(injectorLike));
    }

    public final Object m149a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLVideo graphQLVideo = (GraphQLVideo) obj;
        subParts.a(this.f159b, new StylingData(PaddingStyle.a));
        return new VideoResourceMetadata(UriUtil.a(graphQLVideo.aE()), graphQLVideo.J());
    }

    public final /* bridge */ /* synthetic */ void m150a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2941385);
        m146a((VideoResourceMetadata) obj2, (TextView) view);
        Logger.a(8, EntryType.MARK_POP, -1848617903, a);
    }

    @Inject
    public VideoPartDefinition(BackgroundPartDefinition backgroundPartDefinition, VideoPrefetchModel videoPrefetchModel) {
        this.f159b = backgroundPartDefinition;
        this.f160c = videoPrefetchModel.a(VideoPrefetchLocation.NEWSFEED);
    }

    public final ViewType m148a() {
        return f156a;
    }

    public static VideoPartDefinition m145a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f158e) {
                VideoPartDefinition videoPartDefinition;
                if (a2 != null) {
                    videoPartDefinition = (VideoPartDefinition) a2.a(f158e);
                } else {
                    videoPartDefinition = f157d;
                }
                if (videoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m147b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f158e, b3);
                        } else {
                            f157d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m151a(Object obj) {
        return false;
    }

    private void m146a(VideoResourceMetadata videoResourceMetadata, TextView textView) {
        TracerDetour.a("VideoPartDefinition.bind", 897350947);
        try {
            textView.setText("Videos testing.");
            this.f160c.a(new VideoResourceMetadata[]{videoResourceMetadata});
        } finally {
            TracerDetour.a(-1716229615);
        }
    }
}
