package com.facebook.api.feedcache.db;

/* compiled from: mp4 */
class FeedDbMutationService$1 implements Runnable {
    final /* synthetic */ FeedDbMutationService f9782a;

    FeedDbMutationService$1(FeedDbMutationService feedDbMutationService) {
        this.f9782a = feedDbMutationService;
    }

    public void run() {
        this.f9782a.c.c();
        FeedDbMutationService.b(this.f9782a);
    }
}
