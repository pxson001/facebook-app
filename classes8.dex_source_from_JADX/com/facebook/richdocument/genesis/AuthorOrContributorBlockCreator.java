package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.AuthorsBlockPresenter;
import com.facebook.richdocument.view.block.AuthorsBlockView;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.impl.AuthorsBlockViewImpl;
import javax.inject.Inject;

/* compiled from: post_slideshow */
public class AuthorOrContributorBlockCreator extends BaseBlockCreator<AuthorsBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new AuthorsBlockPresenter((AuthorsBlockViewImpl) blockView);
    }

    @Inject
    public AuthorOrContributorBlockCreator() {
        super(2130904815, 1);
    }

    public final BlockView mo264a(View view) {
        return new AuthorsBlockViewImpl(view);
    }
}
