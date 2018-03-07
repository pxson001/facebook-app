package com.facebook.reaction.common;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import javax.annotation.Nullable;

/* compiled from: jsonEncode DeviceOwnerData failed */
public interface ReactionCardContainer {
    @Nullable
    ReactionUnitFragment mo725a(String str);

    boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType);

    boolean mo729a(String str, CardSearchType cardSearchType);

    @Nullable
    ViewGroup getCardViewGroup();

    Context getContext();

    Fragment getFragment();

    @Nullable
    ReactionInteractionTracker getInteractionTracker();

    String getSessionId();

    @Nullable
    Surface getSurface();
}
