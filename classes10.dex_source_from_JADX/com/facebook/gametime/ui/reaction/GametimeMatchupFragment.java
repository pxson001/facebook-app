package com.facebook.gametime.ui.reaction;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.gametime.ui.reaction.GametimeReactionUtil.LoadType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {story_id none} */
public class GametimeMatchupFragment extends BaseFullscreenReactionFragment {
    @Inject
    public GametimeAdapterProvider am;
    @Inject
    public GametimeReactionUtil an;
    @Inject
    public GametimePlaySubscriberProvider ao;
    private LoadType ap;
    private GametimePlaySubscriber aq;
    private String ar;
    private Surface as;

    public static void m5a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GametimeMatchupFragment gametimeMatchupFragment = (GametimeMatchupFragment) obj;
        GametimeAdapterProvider gametimeAdapterProvider = (GametimeAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GametimeAdapterProvider.class);
        GametimeReactionUtil b = GametimeReactionUtil.m17b(fbInjector);
        GametimePlaySubscriberProvider gametimePlaySubscriberProvider = (GametimePlaySubscriberProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GametimePlaySubscriberProvider.class);
        gametimeMatchupFragment.am = gametimeAdapterProvider;
        gametimeMatchupFragment.an = b;
        gametimeMatchupFragment.ao = gametimePlaySubscriberProvider;
    }

    public final void m10c(@Nullable Bundle bundle) {
        Class cls = GametimeMatchupFragment.class;
        m5a(this, getContext());
        super.c(bundle);
        GametimePlaySubscriberProvider gametimePlaySubscriberProvider = this.ao;
        this.aq = new GametimePlaySubscriber(this.ar, this, DefaultAndroidThreadUtil.b(gametimePlaySubscriberProvider), GraphQLSubscriptionConnector.a(gametimePlaySubscriberProvider), GraphQLSubscriptionHolder.b(gametimePlaySubscriberProvider));
    }

    public final String am_() {
        return "gametime";
    }

    protected final AbstractReactionRecyclerViewAdapter m9b(Context context) {
        return this.am.m1a(context, aP(), aO(), this, this.ar, this.aq);
    }

    public final void m6G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -883486127);
        super.G();
        this.aq.f19f.e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -873443650, a);
    }

    public final void m7H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1544704127);
        super.H();
        this.aq.f19f.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1519402917, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2003645399);
        super.mj_();
        GametimePlaySubscriber gametimePlaySubscriber = this.aq;
        if (gametimePlaySubscriber.f21h != null) {
            gametimePlaySubscriber.f18e.a(Collections.singleton(gametimePlaySubscriber.f21h));
            gametimePlaySubscriber.f21h = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 106549484, a);
    }

    public final void m8I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 923392847);
        super.I();
        this.aq.f19f.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1054436613, a);
    }

    protected final ReactionSession ax() {
        if (this.s == null) {
            return this.an.m19a(Surface.ANDROID_GAMETIME_MATCHUP_TAB, "-1", LoadType.TAIL_LOAD);
        }
        this.ap = (LoadType) this.s.getSerializable("load_type");
        this.ar = this.s.getString("page_id");
        this.as = (Surface) this.s.getSerializable("reaction_surface");
        return this.an.m19a(this.as, this.ar, this.ap);
    }

    protected final void aV() {
        if (this.av != null && this.av.p && !this.av.q) {
            this.av.q = true;
            this.an.m20a(this.ar, getSessionId(), this.as, this.ap, this.av.g(), this.av.g());
        }
    }
}
