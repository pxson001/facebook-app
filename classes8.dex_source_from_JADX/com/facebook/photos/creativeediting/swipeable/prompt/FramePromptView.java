package com.facebook.photos.creativeediting.swipeable.prompt;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptView;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.actionhandlers.FramePromptActionHandler;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: speller */
public class FramePromptView extends ScrollingImagePromptView implements HasPhotoTray, V2Attachment {
    @Inject
    public FramePromptScrollAdapterProvider f2308b;
    private boolean f2309c;
    private boolean f2310d;
    private FramePromptScrollAdapter f2311e;

    public static void m2424a(Object obj, Context context) {
        ((FramePromptView) obj).f2308b = (FramePromptScrollAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FramePromptScrollAdapterProvider.class);
    }

    public FramePromptView(Context context) {
        this(context, null);
    }

    private FramePromptView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FramePromptView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2309c = false;
    }

    protected final void m2427b() {
        Class cls = FramePromptView.class;
        m2424a(this, getContext());
        super.b();
    }

    public final void m2426a(InlineComposerPromptSession inlineComposerPromptSession) {
        FramePromptScrollAdapterProvider framePromptScrollAdapterProvider = this.f2308b;
        this.f2311e = new FramePromptScrollAdapter(Integer.valueOf(getImageTrayHeight()), inlineComposerPromptSession, FbDraweeControllerBuilder.b(framePromptScrollAdapterProvider), SwipeableParamsHelper.b(framePromptScrollAdapterProvider), FramePromptActionHandler.b(framePromptScrollAdapterProvider), InlineComposerPromptActionHandler.b(framePromptScrollAdapterProvider), PromptActionContextFactory.b(framePromptScrollAdapterProvider), PromptsExperimentHelper.b(framePromptScrollAdapterProvider));
        this.b.setAdapter(this.f2311e);
    }

    protected int getImageTrayHeight() {
        return getResources().getDimensionPixelSize(2131429559);
    }

    protected void setHasBeenShown(boolean z) {
        this.f2310d = z;
    }

    protected final boolean m2428g() {
        return this.f2310d;
    }

    protected void setIsAnimationRunning(boolean z) {
        this.f2309c = z;
    }

    protected final boolean m2429h() {
        return this.f2309c;
    }

    public final View m2425a() {
        return this;
    }

    @Nullable
    public Animator getExpandAnimator() {
        return this.d;
    }

    @Nullable
    public Animator getCollapseAnimator() {
        return this.e;
    }
}
