package com.facebook.feedback.ui.rows.views;

import android.view.View;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: responsive_badge_color */
public class CommentRowViewControllerProvider extends AbstractAssistedProvider<CommentRowViewController> {
    public final CommentRowViewController m5645a(View view) {
        return new CommentRowViewController(view, CommentBackgroundUtil.m4807a((InjectorLike) this));
    }
}
