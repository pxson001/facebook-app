package com.facebook.reaction.placetips;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionUtil;

/* compiled from: XStorageCleaner */
class PlaceTipsReactionManager$7 implements Runnable {
    final /* synthetic */ long f20745a;
    final /* synthetic */ String f20746b;
    final /* synthetic */ Surface f20747c;
    final /* synthetic */ PlaceTipsReactionManager f20748d;

    PlaceTipsReactionManager$7(PlaceTipsReactionManager placeTipsReactionManager, long j, String str, Surface surface) {
        this.f20748d = placeTipsReactionManager;
        this.f20745a = j;
        this.f20746b = str;
        this.f20747c = surface;
    }

    public void run() {
        ReactionUtil reactionUtil = (ReactionUtil) this.f20748d.g.get();
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.f18631l = Long.valueOf(this.f20745a);
        reactionUtil.m22660a(reactionQueryParams, this.f20746b, this.f20747c);
    }
}
