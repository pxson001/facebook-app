package com.facebook.richdocument.genesis;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.instantarticles.genesis.ArticleUfiBlockCreator;
import com.facebook.instantshopping.genesis.ColorPickerBlockCreator;
import com.facebook.instantshopping.genesis.ColorPileBlockCreator;
import com.facebook.instantshopping.genesis.CompositeBlockCreator;
import com.facebook.instantshopping.genesis.DividerBlockCreator;
import com.facebook.instantshopping.genesis.ExpandableSectionBlockCreator;
import com.facebook.instantshopping.genesis.InstantShoppingButtonBlockCreator;
import com.facebook.instantshopping.genesis.InstantShoppingPhotoBlockCreator;
import com.facebook.instantshopping.genesis.InstantShoppingRichTextBlockCreator;
import com.facebook.instantshopping.genesis.InstantShoppingSlideshowBlockCreator;
import com.facebook.instantshopping.genesis.InstantShoppingVideoBlockCreator;
import com.facebook.instantshopping.genesis.NoCaptionSlideshowPhotoBlockCreator;
import com.facebook.instantshopping.genesis.SlideshowPhotoBlockCreator;
import com.facebook.instantshopping.genesis.SlideshowPhotoFullscreenBlockCreator;
import com.facebook.instantshopping.genesis.ToggleButtonBlockCreator;
import com.facebook.notes.genesis.FromAuthorBlockCreator;
import com.facebook.notes.genesis.TimestampAndPrivacyBlockCreator;
import com.facebook.notes.genesis.UFIBlockCreator;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$BlockCreator implements MultiBindIndexedProvider<BlockCreator>, Provider<Set<BlockCreator>> {
    private final InjectorLike f5290a;

    public STATICDI_MULTIBIND_PROVIDER$BlockCreator(InjectorLike injectorLike) {
        this.f5290a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5290a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 38;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new ArticleUfiBlockCreator();
            case 1:
                return new ColorPickerBlockCreator();
            case 2:
                return new ColorPileBlockCreator();
            case 3:
                return new CompositeBlockCreator();
            case 4:
                return new DividerBlockCreator();
            case 5:
                return new ExpandableSectionBlockCreator();
            case 6:
                return new InstantShoppingButtonBlockCreator();
            case 7:
                return new InstantShoppingPhotoBlockCreator();
            case 8:
                return new InstantShoppingRichTextBlockCreator();
            case 9:
                return new InstantShoppingSlideshowBlockCreator();
            case 10:
                return new InstantShoppingVideoBlockCreator();
            case 11:
                return new NoCaptionSlideshowPhotoBlockCreator();
            case 12:
                return new SlideshowPhotoBlockCreator();
            case 13:
                return new SlideshowPhotoFullscreenBlockCreator();
            case 14:
                return new ToggleButtonBlockCreator();
            case 15:
                return new FromAuthorBlockCreator();
            case 16:
                return new TimestampAndPrivacyBlockCreator();
            case 17:
                return new UFIBlockCreator();
            case 18:
                return new AuthorOrContributorBlockCreator();
            case 19:
                return new BlockQuoteBlockCreator();
            case 20:
                return new BylineBlockCreator();
            case 21:
                return new CodeBlockCreator();
            case 22:
                return new FooterRichTextHeaderBlockCreator();
            case 23:
                return new HairlineBlockCreator();
            case 24:
                return new InlineRelatedArticlesFooterBlockCreator();
            case 25:
                return new InlineRelatedArticlesHeaderBlockCreator();
            case 26:
                return new ListItemBlockCreator();
            case 27:
                return new LogoBlockCreator();
            case 28:
                return new MapBlockCreator();
            case 29:
                return new NativeAdBlockCreator();
            case 30:
                return new PhotoBlockCreator(CompositeRecyclableViewFactory.m7356a((InjectorLike) injector));
            case 31:
                return new RelatedArticleBlockCreator();
            case 32:
                return new RelatedArticlesHeaderBlockCreator();
            case 33:
                return new RichTextBlockCreator();
            case 34:
                return new ShareBlockCreator();
            case 35:
                return new SlideshowBlockCreator();
            case 36:
                return new VideoBlockCreator();
            case 37:
                return new WebViewBlockCreator();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
