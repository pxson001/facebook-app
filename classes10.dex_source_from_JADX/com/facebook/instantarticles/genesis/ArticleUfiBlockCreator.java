package com.facebook.instantarticles.genesis;

import android.view.View;
import com.facebook.instantarticles.presenter.ArticleUfiBlockPresenter;
import com.facebook.instantarticles.view.block.ArticleUfiBlockView;
import com.facebook.instantarticles.view.block.impl.ArticleUfiBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: video_time_report_url */
public class ArticleUfiBlockCreator extends BaseBlockCreator<ArticleUfiBlockView> {
    public final AbstractBlockPresenter m588a(BlockView blockView) {
        return new ArticleUfiBlockPresenter((ArticleUfiBlockViewImpl) blockView);
    }

    @Inject
    public ArticleUfiBlockCreator() {
        super(2130906884, 301);
    }

    public final BlockView m589a(View view) {
        return new ArticleUfiBlockViewImpl(view);
    }
}
