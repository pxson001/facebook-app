package com.facebook.feedback.reactions.ui;

import com.facebook.debug.log.BLog;
import com.facebook.reactionsanimations.data.ReactionsFace;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;

/* compiled from: setupReactContext */
class ReactionsFaceDataCache$PrepareDiskFaceRunnable implements Runnable {
    final /* synthetic */ ReactionsFaceDataCache f3880a;
    private final String f3881b;
    private final int f3882c;
    private final File f3883d;

    public ReactionsFaceDataCache$PrepareDiskFaceRunnable(ReactionsFaceDataCache reactionsFaceDataCache, String str, int i, File file) {
        this.f3880a = reactionsFaceDataCache;
        this.f3881b = str;
        this.f3882c = i;
        this.f3883d = file;
    }

    public void run() {
        try {
            ReactionsFace reactionsFace = (ReactionsFace) this.f3880a.c.a(this.f3883d, ReactionsFace.class);
            synchronized (this.f3880a) {
                this.f3880a.e.a(this.f3882c, reactionsFace);
            }
            ReactionsFaceDataCache.c(this.f3880a, this.f3881b);
        } catch (JsonMappingException e) {
            BLog.b(ReactionsFaceDataCache.a, e, "Error deserializing file for %s", new Object[]{Integer.valueOf(this.f3882c)});
        } catch (Throwable e2) {
            BLog.b(ReactionsFaceDataCache.a, e2, "Error reading file for %s", new Object[]{Integer.valueOf(this.f3882c)});
        }
    }
}
