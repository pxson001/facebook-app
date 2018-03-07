package com.facebook.instantarticles.view.block.impl;

import android.view.View;
import com.facebook.instantarticles.presenter.ArticleUfiBlockPresenter;
import com.facebook.instantarticles.view.block.ArticleUfiBlockView;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.UFIView;

/* compiled from: video_call_button */
public class ArticleUfiBlockViewImpl extends AbstractBlockView<ArticleUfiBlockPresenter> implements ArticleUfiBlockView {
    public final UFIView f514a;

    public ArticleUfiBlockViewImpl(View view) {
        super(view);
        this.f514a = (UFIView) view;
        this.f514a.setIsOverlay(false);
    }
}
