package com.facebook.instantshopping.presenter;

import android.net.Uri;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.instantshopping.view.block.impl.HeaderLogoBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;

/* compiled from: SUBTITLED_ITEM */
public class LogoHeaderBlockPresenter extends HeaderBlockPresenter {
    private final InstantShoppingPhotoElementFragment f23673d;

    public final /* synthetic */ void mo1023a(BlockData blockData) {
        mo1024b();
    }

    public LogoHeaderBlockPresenter(HeaderBlockView headerBlockView, InstantShoppingPhotoElementFragment instantShoppingPhotoElementFragment) {
        super(headerBlockView);
        this.f23673d = instantShoppingPhotoElementFragment;
    }

    public final void mo1024b() {
        if (this.f23673d.n() != null) {
            ((HeaderBlockView) this.d).mo1028c();
            HeaderLogoBlockViewImpl headerLogoBlockViewImpl = (HeaderLogoBlockViewImpl) this.d;
            headerLogoBlockViewImpl.f23769a.a(Uri.parse(this.f23673d.n().d()), headerLogoBlockViewImpl.mo1031f());
            LoggingParams loggingParams = new LoggingParams(this.f23673d.iI_(), this.f23673d.c().toString());
            ((HeaderLogoBlockViewImpl) this.d).f23772e = loggingParams;
            ((HeaderLogoBlockViewImpl) this.d).f23771c.m24856a(loggingParams);
            ((HeaderBlockView) this.d).mo1027a(this.f23673d.a());
        }
    }
}
