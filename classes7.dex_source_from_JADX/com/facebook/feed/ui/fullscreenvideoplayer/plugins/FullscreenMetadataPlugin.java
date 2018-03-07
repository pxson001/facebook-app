package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.facecastdisplay.LiveMetadataView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Timed out adding root view */
public class FullscreenMetadataPlugin extends RichVideoPlayerPlugin {
    protected boolean f22126a;
    @Inject
    public QeAccessor f22127b;
    private final LiveMetadataView f22128c;

    private static <T extends View> void m24756a(Class<T> cls, T t) {
        m24757a((Object) t, t.getContext());
    }

    private static void m24757a(Object obj, Context context) {
        ((FullscreenMetadataPlugin) obj).f22127b = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    private void m24755a(QeAccessor qeAccessor) {
        this.f22127b = qeAccessor;
    }

    public FullscreenMetadataPlugin(Context context) {
        this(context, null);
    }

    public FullscreenMetadataPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullscreenMetadataPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24756a(FullscreenMetadataPlugin.class, (View) this);
        setContentView(2130904552);
        this.f22128c = (LiveMetadataView) a(2131562431);
    }

    protected final void m24760a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            Object obj = (richVideoPlayerParams.a == null || !richVideoPlayerParams.a.f) ? null : 1;
            if (feedProps == null || obj != null) {
                m24759e();
                return;
            }
            m24758d();
            setMetadata((GraphQLStory) feedProps.a);
        }
    }

    private void setMetadata(GraphQLStory graphQLStory) {
        String str = null;
        GraphQLActor b = StoryActorHelper.b(graphQLStory);
        this.f22128c.setTitle(b != null ? b.aa() : null);
        this.f22128c.m22517h();
        this.f22128c.setSubtitle(m24754a(graphQLStory));
        LiveMetadataView liveMetadataView = this.f22128c;
        if (b != null && GraphQLActorUtil.b(b)) {
            str = GraphQLActorUtil.c(b);
        }
        liveMetadataView.setProfilePicture(str);
        if (this.f22127b.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
            setFollowVideosButton(graphQLStory);
        }
    }

    private void m24758d() {
        this.f22128c.setVisibility(0);
    }

    private void m24759e() {
        this.f22128c.setVisibility(8);
    }

    @Nullable
    private static String m24754a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null || o.r() == null) {
            return null;
        }
        GraphQLTextWithEntities aV = o.r().aV();
        if (aV != null) {
            return aV.a();
        }
        return null;
    }

    private void setFollowVideosButton(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o != null) {
            GraphQLMedia r = o.r();
            if (r != null) {
                GraphQLActor aF = r.aF();
                if (aF != null && !aF.aB() && aF.ay()) {
                    boolean z = aF.aJ() && !aF.aI() && r.bs() && this.f22126a;
                    this.f22128c.m22514a(aF, z);
                }
            }
        }
    }
}
