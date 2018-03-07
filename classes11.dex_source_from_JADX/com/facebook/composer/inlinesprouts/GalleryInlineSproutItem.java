package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: fundraiser_payment_info */
public class GalleryInlineSproutItem<DataProvider extends ProvidesCapability & ProvidesAttachments> implements InlineSproutItem {
    private final DataProvider f6552a;
    public final ActionItemController$Delegate f6553b;
    private final SproutSpec f6554c;
    private final InlineSproutsQeWrapper f6555d;

    /* compiled from: fundraiser_payment_info */
    class C08311 implements Runnable {
        final /* synthetic */ GalleryInlineSproutItem f6551a;

        C08311(GalleryInlineSproutItem galleryInlineSproutItem) {
            this.f6551a = galleryInlineSproutItem;
        }

        public void run() {
            this.f6551a.f6553b.mo184a();
        }
    }

    @Inject
    public GalleryInlineSproutItem(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, InlineSproutsQeWrapper inlineSproutsQeWrapper) {
        this.f6552a = dataProvider;
        this.f6553b = actionItemController$Delegate;
        this.f6555d = inlineSproutsQeWrapper;
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6555d;
        Builder a = SproutSpec.a(17170445, 2130839750, inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.t, 2131234821, inlineSproutsQeWrapper2.f6599c), "composer_media_inline_sprout", new C08311(this));
        a.h = Integer.valueOf(2131362972);
        this.f6554c = a.a();
    }

    public final SproutSpec mo205a() {
        return this.f6554c;
    }

    public final boolean mo206b() {
        return this.f6552a.ax().isSupported();
    }

    public final boolean mo207c() {
        ImmutableList m = ((ProvidesAttachments) this.f6552a).m();
        return AttachmentUtils.k(m) || AttachmentUtils.i(m);
    }

    public final boolean mo208d() {
        return true;
    }

    public final boolean mo209e() {
        return true;
    }

    public final String mo210f() {
        InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6555d;
        return inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.m, 2131234158, inlineSproutsQeWrapper.f6599c);
    }
}
