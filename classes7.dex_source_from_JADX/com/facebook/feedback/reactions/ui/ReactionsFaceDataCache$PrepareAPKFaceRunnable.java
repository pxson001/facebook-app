package com.facebook.feedback.reactions.ui;

import com.facebook.reactionsanimations.data.ReactionsFace;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: setupReactContext */
class ReactionsFaceDataCache$PrepareAPKFaceRunnable implements Runnable {
    final /* synthetic */ ReactionsFaceDataCache f3878a;
    private final ReactionsClientInfo f3879b;

    public ReactionsFaceDataCache$PrepareAPKFaceRunnable(ReactionsFaceDataCache reactionsFaceDataCache, ReactionsClientInfo reactionsClientInfo) {
        this.f3878a = reactionsFaceDataCache;
        this.f3879b = reactionsClientInfo;
    }

    public void run() {
        String b = this.f3879b.g().b();
        if ("".equals(b)) {
            ReactionsFaceDataCache.c(this.f3878a, ReactionsFaceDataCache.b("apk_faces_", this.f3879b.a()));
            return;
        }
        try {
            InputStream open = this.f3878a.b.getAssets().open(ReactionsFaceDataCache.d(b));
            ReactionsFace reactionsFace = (ReactionsFace) this.f3878a.c.a(open, ReactionsFace.class);
            open.close();
            synchronized (this.f3878a) {
                this.f3878a.e.a(this.f3879b.a(), reactionsFace);
            }
        } catch (IOException e) {
        }
        ReactionsFaceDataCache.c(this.f3878a, ReactionsFaceDataCache.b("apk_faces_", this.f3879b.a()));
    }
}
