package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import javax.inject.Inject;

/* compiled from: fundraiser_page_sent_invite */
public class LocationInlineSproutItem<DataProvider extends ProvidesIsCheckinSupported & ProvidesLocationInfo> implements InlineSproutItem {
    private final DataProvider f6619a;
    public final ActionItemController$Delegate f6620b;
    private final SproutSpec f6621c;
    private final InlineSproutsQeWrapper f6622d;

    /* compiled from: fundraiser_page_sent_invite */
    class C08371 implements Runnable {
        final /* synthetic */ LocationInlineSproutItem f6618a;

        C08371(LocationInlineSproutItem locationInlineSproutItem) {
            this.f6618a = locationInlineSproutItem;
        }

        public void run() {
            this.f6618a.f6620b.mo184a();
        }
    }

    @Inject
    public LocationInlineSproutItem(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, @Assisted String str, InlineSproutsQeWrapper inlineSproutsQeWrapper) {
        this.f6619a = dataProvider;
        this.f6620b = actionItemController$Delegate;
        this.f6622d = inlineSproutsQeWrapper;
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6622d;
        Builder a = SproutSpec.a(17170445, 2130839970, inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.u, 2131234823, inlineSproutsQeWrapper2.f6599c), "composer_place_tagging_inline_sprout", new C08371(this));
        a.h = Integer.valueOf(2131362974);
        a = a;
        a.d = str;
        this.f6621c = a.a();
    }

    public final SproutSpec mo205a() {
        return this.f6621c;
    }

    public final boolean mo206b() {
        return this.f6619a.m7400A();
    }

    public final boolean mo207c() {
        return ((ProvidesLocationInfo) this.f6619a).g().a() != null;
    }

    public final boolean mo208d() {
        return true;
    }

    public final boolean mo209e() {
        return true;
    }

    public final String mo210f() {
        InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6622d;
        return inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.n, 2131234162, inlineSproutsQeWrapper.f6599c);
    }
}
