package com.facebook.instantarticles.presenter;

import com.facebook.instantarticles.model.data.UfiBlockData;
import com.facebook.instantarticles.model.data.impl.UfiBlockDataImpl;
import com.facebook.instantarticles.view.block.ArticleUfiBlockView;
import com.facebook.instantarticles.view.block.impl.ArticleUfiBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: video_conference_call_button */
public class ArticleUfiBlockPresenter extends AbstractBlockPresenter<ArticleUfiBlockView, UfiBlockData> {
    public final void m618a(BlockData blockData) {
        UfiBlockDataImpl ufiBlockDataImpl = (UfiBlockDataImpl) blockData;
        ((ArticleUfiBlockViewImpl) this.d).a(null);
        ArticleUfiBlockViewImpl articleUfiBlockViewImpl = (ArticleUfiBlockViewImpl) this.d;
        articleUfiBlockViewImpl.f514a.setAnnotation(ufiBlockDataImpl.f513a);
    }

    public ArticleUfiBlockPresenter(ArticleUfiBlockViewImpl articleUfiBlockViewImpl) {
        super(articleUfiBlockViewImpl);
    }
}
