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

@ContextScoped
/* compiled from: ProfilePictureOverlayCategoryBrowserSearch */
public class GametimeFanFavoriteTeamBeforeVotingPartDefinition extends BaseSinglePartDefinition<SportsTeam, Void, AnyEnvironment, GametimeFanFavoriteTeamBeforeVotingView> {
    private static GametimeFanFavoriteTeamBeforeVotingPartDefinition f24330a;
    private static final Object f24331b = new Object();

    private static GametimeFanFavoriteTeamBeforeVotingPartDefinition m27835a() {
        return new GametimeFanFavoriteTeamBeforeVotingPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m27837a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -50103207);
        SportsTeam sportsTeam = (SportsTeam) obj;
        GametimeFanFavoriteTeamBeforeVotingView gametimeFanFavoriteTeamBeforeVotingView = (GametimeFanFavoriteTeamBeforeVotingView) view;
        gametimeFanFavoriteTeamBeforeVotingView.setTeamLogo(sportsTeam.f23400i);
        gametimeFanFavoriteTeamBeforeVotingView.setTeamName(sportsTeam.f23394c);
        gametimeFanFavoriteTeamBeforeVotingView.setTeamMarket(sportsTeam.f23395d);
        Logger.a(8, EntryType.MARK_POP, -1409576581, a);
    }

    public static GametimeFanFavoriteTeamBeforeVotingPartDefinition m27836a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteTeamBeforeVotingPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24331b) {
                GametimeFanFavoriteTeamBeforeVotingPartDefinition gametimeFanFavoriteTeamBeforeVotingPartDefinition;
                if (a3 != null) {
                    gametimeFanFavoriteTeamBeforeVotingPartDefinition = (GametimeFanFavoriteTeamBeforeVotingPartDefinition) a3.a(f24331b);
                } else {
                    gametimeFanFavoriteTeamBeforeVotingPartDefinition = f24330a;
                }
                if (gametimeFanFavoriteTeamBeforeVotingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27835a();
                        if (a3 != null) {
                            a3.a(f24331b, a2);
                        } else {
                            f24330a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = gametimeFanFavoriteTeamBeforeVotingPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
