package com.facebook.feedplugins.musicpreview;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.attachments.angora.actionbutton.SaveButton;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.musicpreview.MusicPreviewView.C10131;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipPlayerListener;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLAudio;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLOpenGraphObject;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Provider;

/* compiled from: composer_share_location */
public abstract class MusicPreviewPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, HasPositionInformation, MusicPreviewView> {
    private static final int f8068a = 2130840170;
    private static final CallerContext f8069b = CallerContext.a(MusicPreviewPartDefinition.class, "unknown");
    private final BackgroundPartDefinition f8070c;
    private final Resources f8071d;
    private final MusicPreviewNuxManager f8072e;
    private final MusicPreviewLogger f8073f;
    private final SaveButtonUtils f8074g;
    private final Lazy<SongClipPlayer> f8075h;
    private final Provider<FbDraweeControllerBuilder> f8076i;
    private final ViewType f8077j;

    /* compiled from: composer_share_location */
    public class State {
        public final Rect f8063a;
        public final GraphQLApplication f8064b;
        public final List<String> f8065c;
        public final ImmutableList<GraphQLOpenGraphObject> f8066d;
        public final ImmutableList<GraphQLAudio> f8067e;

        public State(Rect rect, GraphQLApplication graphQLApplication, List<String> list, ImmutableList<GraphQLOpenGraphObject> immutableList, ImmutableList<GraphQLAudio> immutableList2) {
            this.f8063a = rect;
            this.f8064b = graphQLApplication;
            this.f8065c = list;
            this.f8066d = immutableList;
            this.f8067e = immutableList2;
        }
    }

    public final Object m9112a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLApplication k;
        List j;
        ImmutableList D;
        ImmutableList K;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment a = m9108a((GraphQLStoryAttachment) feedProps.a);
        subParts.a(this.f8070c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a, f8068a, -1));
        Drawable drawable = this.f8071d.getDrawable(f8068a);
        Rect rect = new Rect();
        drawable.getPadding(rect);
        GraphQLNode z = a.z();
        if (z.eK() != null) {
            k = z.eK().k();
            j = z.eK().j();
            D = z.eK().D();
            K = z.eK().K();
        } else if (z.fZ() != null) {
            k = z.T();
            j = z.J();
            D = z.fZ().eN();
            K = z.fZ().fT();
        } else {
            k = z.T();
            j = z.J();
            D = z.eN();
            K = z.fT();
        }
        return new State(rect, k, j, D, K);
    }

    public final /* bridge */ /* synthetic */ void m9113a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1061431771);
        m9109a((FeedProps) obj, (State) obj2, (MusicPreviewView) view);
        Logger.a(8, EntryType.MARK_POP, 1304067033, a);
    }

    public final void m9115b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        MusicPreviewView musicPreviewView = (MusicPreviewView) view;
        if (musicPreviewView.f8119n.isPresent()) {
            View view2 = (View) musicPreviewView.f8119n.get();
            this.f8072e.f8061a.a(view2);
        }
    }

    public MusicPreviewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, Resources resources, MusicPreviewNuxManager musicPreviewNuxManager, MusicPreviewLogger musicPreviewLogger, SaveButtonUtils saveButtonUtils, Lazy<SongClipPlayer> lazy, Provider<FbDraweeControllerBuilder> provider, ViewType viewType) {
        this.f8072e = musicPreviewNuxManager;
        this.f8073f = musicPreviewLogger;
        this.f8074g = saveButtonUtils;
        this.f8075h = lazy;
        this.f8076i = provider;
        this.f8070c = backgroundPartDefinition;
        this.f8071d = resources;
        this.f8077j = viewType;
    }

    public final ViewType m9111a() {
        return this.f8077j;
    }

    public final boolean m9114a(Object obj) {
        return true;
    }

    private static GraphQLStoryAttachment m9108a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty()) {
            return graphQLStoryAttachment;
        }
        return (GraphQLStoryAttachment) graphQLStoryAttachment.x().get(0);
    }

    private void m9109a(FeedProps<GraphQLStoryAttachment> feedProps, State state, MusicPreviewView musicPreviewView) {
        FeedProps e = AttachmentProps.e(feedProps);
        Flattenable flattenable = e.a;
        GraphQLStoryAttachment a = m9108a((GraphQLStoryAttachment) feedProps.a);
        musicPreviewView.setPadding(musicPreviewView.getPaddingLeft() + state.f8063a.left, musicPreviewView.getPaddingTop() + state.f8063a.top, musicPreviewView.getPaddingRight() + state.f8063a.right, musicPreviewView.getPaddingBottom() + state.f8063a.bottom);
        musicPreviewView.f8106a.setContentDescription(Strings.nullToEmpty(a.A()));
        musicPreviewView.f8129y = a.r();
        musicPreviewView.f8128x = true;
        musicPreviewView.post(new C10131(musicPreviewView));
        musicPreviewView.f8109d.setText(state.f8064b.y());
        musicPreviewView.f8111f = state.f8064b.y();
        musicPreviewView.f8107b.setText(a.A());
        int dimensionPixelSize = musicPreviewView.getResources().getDimensionPixelSize(2131430254);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(Uri.parse(state.f8064b.O().b()));
        a2.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
        musicPreviewView.f8110e.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8076i.get()).a(f8069b).b(musicPreviewView.f8110e.getController())).c(a2.m())).s());
        musicPreviewView.f8108c.setText(((GraphQLOpenGraphObject) state.f8066d.get(0)).E());
        musicPreviewView.f8113h = Uri.parse(((GraphQLAudio) state.f8067e.get(0)).a());
        ((SongClipPlayer) this.f8075h.get()).m9332a(musicPreviewView.f8113h, (SongClipPlayerListener) musicPreviewView);
        musicPreviewView.f8115j = (String) state.f8065c.get(0);
        musicPreviewView.f8114i = state.f8064b.j().l();
        if (musicPreviewView.f8119n.isPresent()) {
            this.f8072e.m9107a(musicPreviewView.getContext(), (View) musicPreviewView.f8119n.get(), state.f8064b.y());
        }
        m9110a(e, a, musicPreviewView);
        musicPreviewView.f8121p = a.z().dp();
        musicPreviewView.f8120o = a.z().dp();
        musicPreviewView.f8122q = TrackableFeedProps.a(e);
        MusicPreviewLogger musicPreviewLogger = this.f8073f;
        String dp = a.z().dp();
        String dp2 = a.z().dp();
        ArrayNode a3 = TrackableFeedProps.a(e);
        musicPreviewLogger.f8057a.a(new HoneyClientEvent("music_preview_impression").b("og_song_id", dp).b("og_object_id", dp2).a("tracking_codes", a3).b("provider_name", state.f8064b.y()));
    }

    private void m9110a(FeedProps<GraphQLStory> feedProps, GraphQLStoryAttachment graphQLStoryAttachment, MusicPreviewView musicPreviewView) {
        if (musicPreviewView.f8117l.isPresent() && SaveButtonUtils.a(graphQLStoryAttachment)) {
            ((SaveButton) musicPreviewView.f8117l.get()).a(ActionLinkHelper.a(graphQLStoryAttachment, -908457779).J(), CurationSurface.NATIVE_STORY, feedProps, null);
            ((View) musicPreviewView.f8118m.get()).setVisibility(0);
        }
    }
}
