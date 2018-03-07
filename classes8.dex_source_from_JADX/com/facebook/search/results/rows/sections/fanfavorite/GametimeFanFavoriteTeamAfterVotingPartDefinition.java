package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.SportsTeam.Type;

@ContextScoped
/* compiled from: ProfileVideoUploader */
public class GametimeFanFavoriteTeamAfterVotingPartDefinition extends BaseSinglePartDefinition<SportsTeam, Void, AnyEnvironment, GametimeFanFavoriteTeamAfterVotingView> {
    private static GametimeFanFavoriteTeamAfterVotingPartDefinition f24322a;
    private static final Object f24323b = new Object();

    private static GametimeFanFavoriteTeamAfterVotingPartDefinition m27831a() {
        return new GametimeFanFavoriteTeamAfterVotingPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m27833a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -482203430);
        SportsTeam sportsTeam = (SportsTeam) obj;
        GametimeFanFavoriteTeamAfterVotingView gametimeFanFavoriteTeamAfterVotingView = (GametimeFanFavoriteTeamAfterVotingView) view;
        gametimeFanFavoriteTeamAfterVotingView.setLogo(sportsTeam.f23400i);
        gametimeFanFavoriteTeamAfterVotingView.setMarket(sportsTeam.f23395d);
        gametimeFanFavoriteTeamAfterVotingView.setName(sportsTeam.f23394c);
        gametimeFanFavoriteTeamAfterVotingView.setVoteCount(sportsTeam.f23398g);
        int round = sportsTeam.f23399h == 0 ? 0 : sportsTeam.f23393b == Type.HOME_TEAM ? (int) Math.round((((double) sportsTeam.f23398g) * 100.0d) / ((double) sportsTeam.f23399h)) : 100 - ((int) Math.round((((double) (sportsTeam.f23399h - sportsTeam.f23398g)) * 100.0d) / ((double) sportsTeam.f23399h)));
        gametimeFanFavoriteTeamAfterVotingView.setVotePercentage(round);
        Logger.a(8, EntryType.MARK_POP, -1066099598, a);
    }

    public static GametimeFanFavoriteTeamAfterVotingPartDefinition m27832a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteTeamAfterVotingPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24323b) {
                GametimeFanFavoriteTeamAfterVotingPartDefinition gametimeFanFavoriteTeamAfterVotingPartDefinition;
                if (a3 != null) {
                    gametimeFanFavoriteTeamAfterVotingPartDefinition = (GametimeFanFavoriteTeamAfterVotingPartDefinition) a3.a(f24323b);
                } else {
                    gametimeFanFavoriteTeamAfterVotingPartDefinition = f24322a;
                }
                if (gametimeFanFavoriteTeamAfterVotingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27831a();
                        if (a3 != null) {
                            a3.a(f24323b, a2);
                        } else {
                            f24322a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = gametimeFanFavoriteTeamAfterVotingPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
