package com.facebook.friendsharing.meme.prompt;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Result has already been set! */
public class MemePromptView extends CustomFrameLayout implements V2Attachment {
    @Inject
    public QeAccessor f23979a;
    @Inject
    public MemePromptScrollAdapterProvider f23980b;
    private MemePromptScrollingView f23981c;

    public static void m26093a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MemePromptView memePromptView = (MemePromptView) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        MemePromptScrollAdapterProvider memePromptScrollAdapterProvider = (MemePromptScrollAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MemePromptScrollAdapterProvider.class);
        memePromptView.f23979a = qeAccessor;
        memePromptView.f23980b = memePromptScrollAdapterProvider;
    }

    public MemePromptView(Context context) {
        super(context);
        m26094b();
    }

    private void m26094b() {
        Class cls = MemePromptView.class;
        m26093a(this, getContext());
        if (m26095e()) {
            setContentView(2130905211);
            this.f23981c = (MemePromptScrollingView) FindViewUtil.b(this, 2131563800);
            return;
        }
        setContentView(2130905212);
    }

    public final void m26097a(InlineComposerPromptSession inlineComposerPromptSession) {
        if (m26095e()) {
            MemePromptScrollAdapterProvider memePromptScrollAdapterProvider = this.f23980b;
            this.f23981c.getScrollView().setAdapter(new MemePromptScrollAdapter(Integer.valueOf(this.f23981c.getImageTrayHeight()), inlineComposerPromptSession, FbDraweeControllerBuilder.b(memePromptScrollAdapterProvider), PromptActionContextFactory.b(memePromptScrollAdapterProvider), InlineComposerPromptActionHandler.b(memePromptScrollAdapterProvider)));
        }
    }

    public final View mo1476a() {
        return this;
    }

    @Nullable
    public Animator getExpandAnimator() {
        return null;
    }

    @Nullable
    public Animator getCollapseAnimator() {
        return null;
    }

    private boolean m26095e() {
        return this.f23979a.a(ExperimentsForMemePromptModule.f23953b, false);
    }
}
