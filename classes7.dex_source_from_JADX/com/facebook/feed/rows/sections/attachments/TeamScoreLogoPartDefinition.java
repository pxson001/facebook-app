package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.attachments.SportsMatchScorePartDefinition.TeamData;
import com.facebook.feed.rows.sections.attachments.ui.TeamScoreLogoView;
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

@ContextScoped
/* compiled from: Was Ever Foregrounded */
public class TeamScoreLogoPartDefinition extends BaseSinglePartDefinition<TeamData, Void, AnyEnvironment, TeamScoreLogoView> {
    private static TeamScoreLogoPartDefinition f20820a;
    private static final Object f20821b = new Object();

    private static TeamScoreLogoPartDefinition m23776a() {
        return new TeamScoreLogoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23778a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 170148647);
        TeamData teamData = (TeamData) obj;
        TeamScoreLogoView teamScoreLogoView = (TeamScoreLogoView) view;
        teamScoreLogoView.f21070a.setText(Integer.toString(teamData.f20803c));
        String str = teamData.f20802b;
        teamScoreLogoView.f21071b.a(Uri.parse(str), teamData.f20804d);
        Logger.a(8, EntryType.MARK_POP, 638012121, a);
    }

    public static TeamScoreLogoPartDefinition m23777a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TeamScoreLogoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20821b) {
                TeamScoreLogoPartDefinition teamScoreLogoPartDefinition;
                if (a3 != null) {
                    teamScoreLogoPartDefinition = (TeamScoreLogoPartDefinition) a3.a(f20821b);
                } else {
                    teamScoreLogoPartDefinition = f20820a;
                }
                if (teamScoreLogoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23776a();
                        if (a3 != null) {
                            a3.a(f20821b, a2);
                        } else {
                            f20820a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = teamScoreLogoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
