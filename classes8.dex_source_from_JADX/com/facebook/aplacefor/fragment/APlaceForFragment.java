package com.facebook.aplacefor.fragment;

import android.content.Context;
import android.os.Bundle;
import com.facebook.aplacefor.APlaceForRecyclerViewAdapterProvider;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.ui.fragment.BaseReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: joinOptions(connectionType=%s) */
public class APlaceForFragment extends BaseReactionFragment {
    @Inject
    public ReactionSessionHelper f10512a;
    @Inject
    public APlaceForRecyclerViewAdapterProvider am;

    public static void m12416a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        APlaceForFragment aPlaceForFragment = (APlaceForFragment) obj;
        ReactionSessionHelper b = ReactionSessionHelper.m22580b(fbInjector);
        APlaceForRecyclerViewAdapterProvider aPlaceForRecyclerViewAdapterProvider = (APlaceForRecyclerViewAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(APlaceForRecyclerViewAdapterProvider.class);
        aPlaceForFragment.f10512a = b;
        aPlaceForFragment.am = aPlaceForRecyclerViewAdapterProvider;
    }

    public final void mo743c(@Nullable Bundle bundle) {
        Class cls = APlaceForFragment.class;
        m12416a(this, getContext());
        super.mo743c(bundle);
    }

    protected final ReactionSession ax() {
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.f18624e = o().getIntent().hasExtra("a_place_for_theme") ? o().getIntent().getStringExtra("a_place_for_theme") : "";
        return this.f10512a.m22583a(Surface.A_PLACE_FOR, reactionQueryParams);
    }

    public final String am_() {
        return "a_place_for";
    }

    protected final AbstractReactionRecyclerViewAdapter mo742b(Context context) {
        return this.am.m12372a(context, aP(), aO(), this);
    }

    public final long aw() {
        long aw = super.aw();
        if (aw > 0 && D()) {
            ReactionInteractionTracker interactionTracker = getInteractionTracker();
            if (interactionTracker != null) {
                interactionTracker.m18947c();
                interactionTracker.m18922a();
            }
        }
        return aw;
    }
}
