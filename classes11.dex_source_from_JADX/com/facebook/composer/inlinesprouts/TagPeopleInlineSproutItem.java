package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: fundraiser_increment_personal_updates_count */
public class TagPeopleInlineSproutItem<DataProvider extends ProvidesIsTagPeopleSupported & ProvidesTaggedUsers> implements InlineSproutItem {
    private final DataProvider f6629a;
    public final ActionItemController$Delegate f6630b;
    private final SproutSpec f6631c;
    private final InlineSproutsQeWrapper f6632d;

    /* compiled from: fundraiser_increment_personal_updates_count */
    class C08391 implements Runnable {
        final /* synthetic */ TagPeopleInlineSproutItem f6628a;

        C08391(TagPeopleInlineSproutItem tagPeopleInlineSproutItem) {
            this.f6628a = tagPeopleInlineSproutItem;
        }

        public void run() {
            this.f6628a.f6630b.mo184a();
        }
    }

    @Inject
    public TagPeopleInlineSproutItem(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, @Assisted String str, InlineSproutsQeWrapper inlineSproutsQeWrapper) {
        int i;
        this.f6629a = dataProvider;
        this.f6630b = actionItemController$Delegate;
        this.f6632d = inlineSproutsQeWrapper;
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6632d;
        QeAccessor qeAccessor = inlineSproutsQeWrapper2.f6600d;
        char c = ExperimentsForFeedUtilComposerAbtestModule.B;
        if (inlineSproutsQeWrapper2.f6602f) {
            i = 2131234157;
        } else {
            i = 2131234156;
        }
        Builder a = SproutSpec.a(17170445, 2130839895, qeAccessor.a(c, i, inlineSproutsQeWrapper2.f6599c), "composer_user_tagging_inline_sprout", new C08391(this));
        a.h = Integer.valueOf(2131362971);
        a = a;
        a.d = str;
        this.f6631c = a.a();
    }

    public final SproutSpec mo205a() {
        return this.f6631c;
    }

    public final boolean mo206b() {
        return this.f6629a.m7415Q();
    }

    public final boolean mo207c() {
        return !((ProvidesTaggedUsers) this.f6629a).h().isEmpty();
    }

    public final boolean mo208d() {
        return true;
    }

    public final boolean mo209e() {
        return true;
    }

    public final String mo210f() {
        InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6632d;
        return inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.p, inlineSproutsQeWrapper.f6602f ? 2131234160 : 2131234159, inlineSproutsQeWrapper.f6599c);
    }
}
