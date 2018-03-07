package com.facebook.pages.common.surface.fragments.reaction;

import android.content.Context;
import android.os.Bundle;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.action.PagesReactionManager;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: returnKeyLabel */
public class BasePagesReactionFragment extends BaseFullscreenReactionFragment {
    @Inject
    public PagesReactionManager am;
    public long an;
    public String ao;
    public GraphQLEntityCardContextItemType ap;

    public static void m3362a(Object obj, Context context) {
        ((BasePagesReactionFragment) obj).am = PagesReactionManager.b(FbInjector.get(context));
    }

    public final void m3364c(@Nullable Bundle bundle) {
        Class cls = BasePagesReactionFragment.class;
        m3362a(this, getContext());
        this.ap = GraphQLEntityCardContextItemType.fromString(this.s.getString("page_context_item_type"));
        this.an = this.s.getLong("com.facebook.katana.profile.id", -1);
        this.ao = this.s.getString("reaction_session_id");
        super.c(bundle);
    }

    public final void m3363I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1053312963);
        if (getInteractionTracker() != null) {
            getInteractionTracker().c();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1366751471, a);
    }

    public final String am_() {
        return "page_reaction_fragment";
    }

    protected final ReactionSession ax() {
        return this.am.a(this.ap, this.an, this.ao);
    }

    protected final int aU() {
        int i = this.s.getInt("empty_view", 0);
        return i > 0 ? i : super.aU();
    }
}
