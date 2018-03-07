package com.facebook.gametime.ui.reaction;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeDashboardReactionTailLoadQueryString;
import com.facebook.gametime.ui.reaction.GametimeReactionUtil.C00032;
import com.facebook.gametime.ui.reaction.GametimeReactionUtil.GametimeSuccessCallback;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData.ReactionContext;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData.ReactionContext.RequestType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns(fragment = ContentFragmentType.GAMETIME_DASHBOARD_FRAGMENT)
/* compiled from: }(); */
public class GametimeDashboardFragment extends BaseFullscreenReactionFragment {
    @Inject
    public GametimeReactionUtil am;

    public static void m2a(Object obj, Context context) {
        ((GametimeDashboardFragment) obj).am = GametimeReactionUtil.m17b(FbInjector.get(context));
    }

    public final void m3c(@Nullable Bundle bundle) {
        Class cls = GametimeDashboardFragment.class;
        m2a(this, getContext());
        super.c(bundle);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 50287780);
        super.mi_();
        b(b(2131241433));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1683753601, a);
    }

    protected final ReactionSession ax() {
        GametimeReactionUtil gametimeReactionUtil = this.am;
        Surface surface = Surface.ANDROID_GAMETIME_SCORES;
        String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = gametimeReactionUtil.f36d.a(uuid, surface);
        a.A = new C00032(gametimeReactionUtil, uuid, surface);
        gametimeReactionUtil.f36d.c(uuid);
        gametimeReactionUtil.f36d.d(uuid);
        GraphQlQueryString gametimeDashboardReactionTailLoadQueryString = new GametimeDashboardReactionTailLoadQueryString();
        gametimeReactionUtil.f37e.a(gametimeDashboardReactionTailLoadQueryString, surface);
        ReactionUtil reactionUtil = gametimeReactionUtil.f37e;
        ReactionContext.Surface valueOf = ReactionContext.Surface.valueOf(surface.toString());
        RequestType requestType = RequestType.NORMAL;
        ReactionContext reactionContext = new ReactionContext();
        reactionContext.a("request_type", requestType);
        GraphQlCallInput graphQlCallInput = reactionContext;
        graphQlCallInput.a("surface", valueOf);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        graphQlCallInput2.a("session_id", uuid);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("unit_styles", reactionUtil.i);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("story_header_styles", reactionUtil.t);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("story_attachment_styles", reactionUtil.l.a());
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("action_styles", reactionUtil.r.a(surface));
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("component_styles", reactionUtil.w.a());
        graphQlCallInput2 = graphQlCallInput2;
        GametimeReactionUnitsInputTriggerData gametimeReactionUnitsInputTriggerData = new GametimeReactionUnitsInputTriggerData();
        gametimeReactionUnitsInputTriggerData.a("reaction_context", graphQlCallInput2);
        gametimeDashboardReactionTailLoadQueryString.a("afterCursor", null).a("count", Integer.valueOf(10)).a("trigger_data", gametimeReactionUnitsInputTriggerData);
        gametimeReactionUtil.f38f.a(uuid, gametimeReactionUtil.f34b.a(GraphQLRequest.a(gametimeDashboardReactionTailLoadQueryString).a(GraphQLCachePolicy.c)), new GametimeSuccessCallback(gametimeReactionUtil, uuid));
        gametimeReactionUtil.f35c.a(new ReactionRequestEvent(uuid, null));
        return a;
    }

    public final String am_() {
        return "gametime";
    }

    protected final void aV() {
        if (this.av != null && this.av.p && !this.av.q) {
            this.av.q = true;
            GametimeReactionUtil gametimeReactionUtil = this.am;
            String sessionId = getSessionId();
            Surface surface = Surface.ANDROID_GAMETIME_SCORES;
            String g = this.av.g();
            GraphQlQueryString gametimeDashboardReactionTailLoadQueryString = new GametimeDashboardReactionTailLoadQueryString();
            gametimeReactionUtil.f37e.a(gametimeDashboardReactionTailLoadQueryString, surface);
            ReactionUtil reactionUtil = gametimeReactionUtil.f37e;
            ReactionContext.Surface valueOf = ReactionContext.Surface.valueOf(surface.toString());
            RequestType requestType = RequestType.NORMAL;
            ReactionContext reactionContext = new ReactionContext();
            reactionContext.a("request_type", requestType);
            GraphQlCallInput graphQlCallInput = reactionContext;
            graphQlCallInput.a("surface", valueOf);
            GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
            graphQlCallInput2.a("session_id", sessionId);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("unit_styles", reactionUtil.i);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("story_header_styles", reactionUtil.t);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("story_attachment_styles", reactionUtil.l.a());
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("action_styles", reactionUtil.r.a(surface));
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("component_styles", reactionUtil.w.a());
            graphQlCallInput2 = graphQlCallInput2;
            GametimeReactionUnitsInputTriggerData gametimeReactionUnitsInputTriggerData = new GametimeReactionUnitsInputTriggerData();
            gametimeReactionUnitsInputTriggerData.a("reaction_context", graphQlCallInput2);
            gametimeDashboardReactionTailLoadQueryString.a("afterCursor", g).a("count", Integer.valueOf(10)).a("trigger_data", gametimeReactionUnitsInputTriggerData);
            gametimeReactionUtil.f38f.a(sessionId, gametimeReactionUtil.f34b.a(GraphQLRequest.a(gametimeDashboardReactionTailLoadQueryString).a(GraphQLCachePolicy.c)), new GametimeSuccessCallback(gametimeReactionUtil, sessionId));
            gametimeReactionUtil.f35c.a(new ReactionRequestEvent(sessionId, null));
        }
    }
}
