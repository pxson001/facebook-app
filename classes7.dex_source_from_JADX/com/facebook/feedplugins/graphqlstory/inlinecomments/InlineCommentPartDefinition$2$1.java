package com.facebook.feedplugins.graphqlstory.inlinecomments;

import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentPartDefinition.2;

/* compiled from: ServerHost */
class InlineCommentPartDefinition$2$1 implements Runnable {
    final /* synthetic */ InlineCommentView f23347a;
    final /* synthetic */ 2 f23348b;

    InlineCommentPartDefinition$2$1(2 2, InlineCommentView inlineCommentView) {
        this.f23348b = 2;
        this.f23347a = inlineCommentView;
    }

    public void run() {
        this.f23347a.setBodyText(this.f23348b.b);
    }
}
