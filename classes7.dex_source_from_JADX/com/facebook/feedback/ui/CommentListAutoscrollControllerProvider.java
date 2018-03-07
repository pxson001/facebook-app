package com.facebook.feedback.ui;

import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: secondary_button_intent */
public class CommentListAutoscrollControllerProvider extends AbstractAssistedProvider<CommentListAutoscrollController> {
    public static CommentListAutoscrollController m4873a(CommentAdapter commentAdapter, CommentListScrollStateController commentListScrollStateController) {
        return new CommentListAutoscrollController(commentAdapter, commentListScrollStateController);
    }
}
