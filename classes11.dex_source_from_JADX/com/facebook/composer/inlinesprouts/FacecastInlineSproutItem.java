package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.feed.util.composer.sprout.SproutSpec.Builder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import javax.inject.Inject;

/* compiled from: gDefault */
public class FacecastInlineSproutItem<DataProvider extends ProvidesIsFacecastSupported & ProvidesFacecastInfo> implements InlineSproutItem {
    private final DataProvider f6541a;
    public final ActionItemController$Delegate f6542b;
    private final SproutSpec f6543c;
    private final InlineSproutsQeWrapper f6544d;
    public final FacecastSproutNuxController f6545e;

    /* compiled from: gDefault */
    class C08301 implements Runnable {
        final /* synthetic */ FacecastInlineSproutItem f6540a;

        C08301(FacecastInlineSproutItem facecastInlineSproutItem) {
            this.f6540a = facecastInlineSproutItem;
        }

        public void run() {
            FacecastSproutNuxController facecastSproutNuxController = this.f6540a.f6545e;
            facecastSproutNuxController.f6550e.b();
            ((TransactionImpl) facecastSproutNuxController.f6548c.m7626a(FacecastSproutNuxController.f6546a).m7682a(InlineSproutsState.m8093a(facecastSproutNuxController.f6547b.aA()).setIsFacecastNuxShowing(false).m8091a())).m7689a();
            this.f6540a.f6542b.mo184a();
        }
    }

    @Inject
    public FacecastInlineSproutItem(@Assisted DataProvider dataProvider, @Assisted ActionItemController$Delegate actionItemController$Delegate, @Assisted FacecastSproutNuxController facecastSproutNuxController, InlineSproutsQeWrapper inlineSproutsQeWrapper, FacecastUtil facecastUtil) {
        this.f6541a = dataProvider;
        this.f6542b = actionItemController$Delegate;
        this.f6544d = inlineSproutsQeWrapper;
        this.f6545e = facecastSproutNuxController;
        int a = facecastUtil.a(false);
        InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6544d;
        Builder a2 = SproutSpec.a(17170445, a, inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.s, 2131234520, inlineSproutsQeWrapper2.f6599c), "composer_facecast_inline_sprout", new C08301(this));
        a2.h = Integer.valueOf(2131362977);
        a2 = a2;
        a2.j = this.f6545e;
        this.f6543c = a2.a();
    }

    public final SproutSpec mo205a() {
        return this.f6543c;
    }

    public final boolean mo206b() {
        return this.f6541a.m7403D() && !mo207c();
    }

    public final boolean mo207c() {
        return ((ComposerDataProviderImpl) this.f6541a).m7429e().facecastCameraIndex != -1;
    }

    public final boolean mo208d() {
        return true;
    }

    public final boolean mo209e() {
        return true;
    }

    public final String mo210f() {
        InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6544d;
        return inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.l, 2131234163, inlineSproutsQeWrapper.f6599c);
    }
}
