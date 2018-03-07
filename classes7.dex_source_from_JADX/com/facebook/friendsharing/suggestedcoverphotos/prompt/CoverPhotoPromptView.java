package com.facebook.friendsharing.suggestedcoverphotos.prompt;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptView;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger$Action;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: ProductItemChangeAvailabilityCoreMutation */
public class CoverPhotoPromptView extends ScrollingImagePromptView implements V2Attachment {
    @Inject
    public CoverPhotoPromptScrollAdapterProvider f24339b;
    @Inject
    public PromptImpressionLoggingSessionIdMap f24340c;
    @Inject
    public SuggestedCoverPhotosLogger f24341d;
    private boolean f24342e;
    private boolean f24343f;
    private InlineComposerPromptSession f24344g;

    public static void m26522a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CoverPhotoPromptView coverPhotoPromptView = (CoverPhotoPromptView) obj;
        CoverPhotoPromptScrollAdapterProvider coverPhotoPromptScrollAdapterProvider = (CoverPhotoPromptScrollAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CoverPhotoPromptScrollAdapterProvider.class);
        PromptImpressionLoggingSessionIdMap a = PromptImpressionLoggingSessionIdMap.a(fbInjector);
        SuggestedCoverPhotosLogger b = SuggestedCoverPhotosLogger.b(fbInjector);
        coverPhotoPromptView.f24339b = coverPhotoPromptScrollAdapterProvider;
        coverPhotoPromptView.f24340c = a;
        coverPhotoPromptView.f24341d = b;
    }

    public CoverPhotoPromptView(Context context) {
        super(context);
    }

    protected final void mo1467b() {
        Class cls = CoverPhotoPromptView.class;
        m26522a(this, getContext());
        super.mo1467b();
    }

    public final void m26524a(InlineComposerPromptSession inlineComposerPromptSession) {
        this.f24344g = inlineComposerPromptSession;
        CoverPhotoPromptScrollAdapterProvider coverPhotoPromptScrollAdapterProvider = this.f24339b;
        this.f19727b.setAdapter(new CoverPhotoPromptScrollAdapter(Integer.valueOf(getImageTrayHeight()), inlineComposerPromptSession, FbDraweeControllerBuilder.b(coverPhotoPromptScrollAdapterProvider), PromptActionContextFactory.b(coverPhotoPromptScrollAdapterProvider), InlineComposerPromptActionHandler.b(coverPhotoPromptScrollAdapterProvider), (Context) coverPhotoPromptScrollAdapterProvider.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(coverPhotoPromptScrollAdapterProvider)));
    }

    public final View mo1476a() {
        return this;
    }

    protected int getImageTrayHeight() {
        return getContext().getResources().getDimensionPixelSize(2131432482);
    }

    protected void setHasBeenShown(boolean z) {
        this.f24342e = z;
        if (z) {
            this.f24341d.a.a(SuggestedCoverPhotosLogger.a(this.f24340c.a(this.f24344g.a.b()), SuggestedCoverPhotosLogger$Action.IMPRESSION.name()));
            return;
        }
        this.f24341d.a.a(SuggestedCoverPhotosLogger.a(this.f24340c.a(this.f24344g.a.b()), SuggestedCoverPhotosLogger$Action.HIDE.name()));
    }

    protected final boolean mo1470g() {
        return this.f24342e;
    }

    protected void setIsAnimationRunning(boolean z) {
        this.f24343f = z;
    }

    protected final boolean mo1472h() {
        return this.f24343f;
    }

    public Animator getExpandAnimator() {
        return this.f19729d;
    }

    public Animator getCollapseAnimator() {
        return this.f19730e;
    }
}
