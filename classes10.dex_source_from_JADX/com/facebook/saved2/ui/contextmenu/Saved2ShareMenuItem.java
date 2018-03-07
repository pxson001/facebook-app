package com.facebook.saved2.ui.contextmenu;

import android.support.v4.app.FragmentActivity;
import com.facebook.analytics.CurationMechanism;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import javax.inject.Inject;

/* compiled from: inline_sprouts */
public class Saved2ShareMenuItem implements Saved2ContextMenuItem {
    private final FragmentActivity f9567a;
    private final Lazy<ComposerLauncher> f9568b;

    @Inject
    public Saved2ShareMenuItem(@Assisted FragmentActivity fragmentActivity, Lazy<ComposerLauncher> lazy) {
        this.f9567a = fragmentActivity;
        this.f9568b = lazy;
    }

    public final int mo445a() {
        return 2131238180;
    }

    public final int mo446b() {
        return 2130840097;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        ((ComposerLauncher) this.f9568b.get()).a(null, ComposerConfigurationFactory.c(ComposerSourceType.SAVED_DASHBOARD, Builder.a(m9823c(baseQueryDAO)).b()).setIsFireAndForget(true).a(), 0, this.f9567a);
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.SHARE_BUTTON;
    }

    public static GraphQLEntity m9823c(BaseQueryDAO baseQueryDAO) {
        if (!baseQueryDAO.v()) {
            return null;
        }
        Object obj;
        if (baseQueryDAO.v() && baseQueryDAO.x() && baseQueryDAO.y() == 2479791) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            if (baseQueryDAO.v() && baseQueryDAO.x() && baseQueryDAO.y() == 67338874 && baseQueryDAO.E() && baseQueryDAO.F()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                obj = (baseQueryDAO.z() && baseQueryDAO.B() == 514783620) ? 1 : null;
                if (obj != null) {
                    return GraphQLHelper.a(baseQueryDAO.A(), 514783620);
                }
                return null;
            }
        }
        return GraphQLHelper.a(baseQueryDAO.w(), baseQueryDAO.y());
    }
}
