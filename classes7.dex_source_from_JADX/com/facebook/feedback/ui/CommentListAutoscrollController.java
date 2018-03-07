package com.facebook.feedback.ui;

import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: secondary_message */
public class CommentListAutoscrollController {
    public CommentAdapter f4272a;
    public CommentListScrollStateController f4273b;
    public boolean f4274c;

    @Inject
    public CommentListAutoscrollController(@Assisted CommentAdapter commentAdapter, @Assisted CommentListScrollStateController commentListScrollStateController) {
        this.f4272a = commentAdapter;
        this.f4273b = commentListScrollStateController;
    }
}
