package com.facebook.reaction;

import com.facebook.composer.publish.common.PendingStory;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment.7;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: c91c50b8a5b94772a4b8416ef48d7cd6 */
public class ReactionCacheWithNetworkReplayFetcher {
    public final ReactionSessionHelper f18585a;
    public final ReactionSessionListener f18586b;
    public final 7 f18587c;
    public ReactionSession f18588d;
    public boolean f18589e = false;
    public final ReactionSessionListener f18590f = new C20571(this);

    /* compiled from: c91c50b8a5b94772a4b8416ef48d7cd6 */
    class C20571 implements ReactionSessionListener {
        final /* synthetic */ ReactionCacheWithNetworkReplayFetcher f18584a;

        C20571(ReactionCacheWithNetworkReplayFetcher reactionCacheWithNetworkReplayFetcher) {
            this.f18584a = reactionCacheWithNetworkReplayFetcher;
        }

        public final boolean kq_() {
            return this.f18584a.f18589e;
        }

        public final void mo726a(ReactionStories reactionStories) {
        }

        public final void kr_() {
        }

        public final void mo727a(String str, Optional<PendingStory> optional) {
        }

        public final void kQ_() {
            this.f18584a.f18589e = false;
            if (this.f18584a.f18588d.m22546A()) {
                7 7 = this.f18584a.f18587c;
                ReactionSession reactionSession = this.f18584a.f18588d;
                if (7.a.hn_()) {
                    reactionSession.m22556a(7.a);
                    7.a.m12412b(reactionSession);
                    7.a.kQ_();
                }
            }
        }

        public final void kp_() {
        }
    }

    @Inject
    public ReactionCacheWithNetworkReplayFetcher(@Assisted ReactionSessionListener reactionSessionListener, @Assisted 7 7, ReactionSessionHelper reactionSessionHelper) {
        this.f18586b = reactionSessionListener;
        this.f18587c = 7;
        this.f18585a = reactionSessionHelper;
    }
}
