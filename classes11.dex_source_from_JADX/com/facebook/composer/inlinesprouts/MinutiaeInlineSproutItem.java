package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import javax.inject.Inject;

/* compiled from: fundraiser_page_personal_message_failure */
public class MinutiaeInlineSproutItem<DataProvider extends ProvidesIsMinutiaeSupported & ProvidesMinutiae> implements InlineSproutItem {
    private final DataProvider f6624a;
    public final ActionItemController$Delegate f6625b;
    private final SproutSpec f6626c;
    private final InlineSproutsQeWrapper f6627d;

    /* compiled from: fundraiser_page_personal_message_failure */
    class C08381 implements Runnable {
        final /* synthetic */ MinutiaeInlineSproutItem f6623a;

        C08381(MinutiaeInlineSproutItem minutiaeInlineSproutItem) {
            this.f6623a = minutiaeInlineSproutItem;
        }

        public void run() {
            this.f6623a.f6625b.mo184a();
        }
    }

    @Inject
    public MinutiaeInlineSproutItem(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, @Assisted String str, InlineSproutsQeWrapper inlineSproutsQeWrapper) {
        this.f6624a = dataProvider;
        this.f6625b = actionItemController$Delegate;
        this.f6627d = inlineSproutsQeWrapper;
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6627d;
        Builder a = SproutSpec.a(17170445, 2130843443, inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.w, 2131234832, inlineSproutsQeWrapper2.f6599c), "composer_activity_tagging_inline_sprout", new C08381(this));
        a.h = Integer.valueOf(2131362980);
        a = a;
        a.d = str;
        this.f6626c = a.a();
    }

    public final SproutSpec mo205a() {
        return this.f6626c;
    }

    public final boolean mo206b() {
        return this.f6624a.m7409J();
    }

    public final boolean mo207c() {
        return ((ProvidesMinutiae) this.f6624a).l() != null;
    }

    public final boolean mo208d() {
        return true;
    }

    public final boolean mo209e() {
        return true;
    }

    public final String mo210f() {
        InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6627d;
        return inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.o, 2131234161, inlineSproutsQeWrapper.f6599c);
    }
}
