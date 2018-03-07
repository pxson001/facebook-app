package com.facebook.pages.launchpoint.fragments;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import javax.inject.Inject;

/* compiled from: page_context_rows_suggest_edit_fail */
public class PagesReactionLaunchpointHomeFragment extends BaseFullscreenReactionFragment {
    @Inject
    public ReactionSessionHelper am;
    @Inject
    @LoggedInUserId
    public String an;

    public static void m5285a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PagesReactionLaunchpointHomeFragment pagesReactionLaunchpointHomeFragment = (PagesReactionLaunchpointHomeFragment) obj;
        ReactionSessionHelper b = ReactionSessionHelper.b(fbInjector);
        String b2 = String_LoggedInUserIdMethodAutoProvider.b(fbInjector);
        pagesReactionLaunchpointHomeFragment.am = b;
        pagesReactionLaunchpointHomeFragment.an = b2;
    }

    public final void m5286c(Bundle bundle) {
        Class cls = PagesReactionLaunchpointHomeFragment.class;
        m5285a(this, getContext());
        super.c(bundle);
    }

    public final String am_() {
        return "pages_launchpoint";
    }

    protected final ReactionSession ax() {
        ReactionSessionHelper reactionSessionHelper = this.am;
        Surface surface = Surface.ANDROID_PAGE_LAUNCH_POINT_HOME;
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.t = Long.valueOf(Long.parseLong(this.an));
        reactionQueryParams = reactionQueryParams;
        reactionQueryParams.b = 5;
        return reactionSessionHelper.a(surface, reactionQueryParams);
    }
}
