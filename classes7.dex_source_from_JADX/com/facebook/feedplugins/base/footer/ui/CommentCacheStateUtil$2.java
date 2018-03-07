package com.facebook.feedplugins.base.footer.ui;

/* compiled from: Sync network */
public class CommentCacheStateUtil$2 implements Runnable {
    final /* synthetic */ Footer f23026a;
    final /* synthetic */ boolean f23027b;
    final /* synthetic */ CommentCacheStateUtil f23028c;

    public CommentCacheStateUtil$2(CommentCacheStateUtil commentCacheStateUtil, Footer footer, boolean z) {
        this.f23028c = commentCacheStateUtil;
        this.f23026a = footer;
        this.f23027b = z;
    }

    public void run() {
        this.f23026a.setHasCachedComments(this.f23027b);
    }
}
