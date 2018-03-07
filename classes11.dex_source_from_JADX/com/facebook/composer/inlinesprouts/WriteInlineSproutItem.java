package com.facebook.composer.inlinesprouts;

import android.content.res.Resources;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: fundraiser_data_model */
public class WriteInlineSproutItem implements InlineSproutItem {
    private final Resources f6634a;
    public final ActionItemController$Delegate f6635b;
    private final SproutSpec f6636c;
    private final InlineSproutsQeWrapper f6637d;

    /* compiled from: fundraiser_data_model */
    class C08401 implements Runnable {
        final /* synthetic */ WriteInlineSproutItem f6633a;

        C08401(WriteInlineSproutItem writeInlineSproutItem) {
            this.f6633a = writeInlineSproutItem;
        }

        public void run() {
            this.f6633a.f6635b.mo184a();
        }
    }

    @Inject
    public WriteInlineSproutItem(@Assisted ActionItemController$Delegate actionItemController$Delegate, Resources resources, InlineSproutsQeWrapper inlineSproutsQeWrapper) {
        this.f6635b = actionItemController$Delegate;
        this.f6634a = resources;
        this.f6637d = inlineSproutsQeWrapper;
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6637d;
        Builder a = SproutSpec.a(17170445, 2130839837, inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.E, 2131234820, inlineSproutsQeWrapper2.f6599c), "composer_write_inline_sprout", new C08401(this));
        a.h = Integer.valueOf(2131362971);
        this.f6636c = a.a();
    }

    public final SproutSpec mo205a() {
        return this.f6636c;
    }

    public final boolean mo206b() {
        return true;
    }

    public final boolean mo207c() {
        return false;
    }

    public final boolean mo208d() {
        return false;
    }

    public final boolean mo209e() {
        return false;
    }

    public final String mo210f() {
        return this.f6634a.getString(2131234164);
    }
}
