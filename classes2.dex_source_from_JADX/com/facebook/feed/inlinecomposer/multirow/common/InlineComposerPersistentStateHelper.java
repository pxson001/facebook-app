package com.facebook.feed.inlinecomposer.multirow.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.feed.rows.animations.AnimationsPartDefinition;
import com.facebook.feed.rows.animations.AnimationsPartDefinition.Props;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.abtest.InlineComposerExperiment$PromptsWithNoCollapsedState;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.multirow.api.SubParts;
import com.facebook.productionprompts.common.InlineComposerPromptViewController;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: multiple activities registered */
public class InlineComposerPersistentStateHelper<E extends HasPersistentState> {
    private final AnimationsPartDefinition f13193a;
    private final Provider<InlineComposerPromptViewController> f13194b;
    private final QeAccessor f13195c;

    /* compiled from: multiple activities registered */
    /* synthetic */ class C05952 {
        static final /* synthetic */ int[] f14311a = new int[InlineComposerExperiment$PromptsWithNoCollapsedState.values().length];

        static {
            try {
                f14311a[InlineComposerExperiment$PromptsWithNoCollapsedState.MEDIA_REMINDER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14311a[InlineComposerExperiment$PromptsWithNoCollapsedState.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14311a[InlineComposerExperiment$PromptsWithNoCollapsedState.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: multiple activities registered */
    public interface CanHideShowPromptOnClickListener<V extends View> extends OnClickListener {
        void mo2757a(V v, InlineComposerPromptSession inlineComposerPromptSession);
    }

    public static InlineComposerPersistentStateHelper m19396b(InjectorLike injectorLike) {
        return new InlineComposerPersistentStateHelper(AnimationsPartDefinition.m19402a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3137), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public InlineComposerPersistentStateHelper(AnimationsPartDefinition animationsPartDefinition, Provider<InlineComposerPromptViewController> provider, QeAccessor qeAccessor) {
        this.f13193a = animationsPartDefinition;
        this.f13194b = provider;
        this.f13195c = qeAccessor;
    }

    public static InlineComposerPersistentStateHelper m19394a(InjectorLike injectorLike) {
        return m19396b(injectorLike);
    }

    public static ContextStateKey<String, PromptPersitentState> m19395a(InlineComposerPromptSession inlineComposerPromptSession) {
        return inlineComposerPromptSession == null ? null : new 1(inlineComposerPromptSession);
    }

    public final void m19397a(SubParts<E> subParts, InlineComposerPromptSession inlineComposerPromptSession, CacheableEntity cacheableEntity, Class cls, AnimationBuilder animationBuilder) {
        if (inlineComposerPromptSession != null) {
            subParts.mo2756a(this.f13193a, new Props(inlineComposerPromptSession.f13411c.a, "Animation_" + cls.getSimpleName() + inlineComposerPromptSession.f13409a.mo2493b(), cacheableEntity, animationBuilder, PromptViewState$Visibility.MINIMIZED));
        }
    }

    public final void m19398a(InlineComposerPromptSession inlineComposerPromptSession, PromptViewStateUpdater promptViewStateUpdater, TapSource tapSource) {
        if (inlineComposerPromptSession.f13411c.a == PromptViewState$Visibility.MAXIMIZED) {
            promptViewStateUpdater.mo2487b(inlineComposerPromptSession, tapSource);
            ((InlineComposerPromptViewController) this.f13194b.get()).mo2619c(inlineComposerPromptSession);
            return;
        }
        promptViewStateUpdater.mo2486a(inlineComposerPromptSession, tapSource);
        ((InlineComposerPromptViewController) this.f13194b.get()).mo2618b(inlineComposerPromptSession);
    }

    public final boolean m19399b(InlineComposerPromptSession inlineComposerPromptSession) {
        boolean z = InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject;
        switch (C05952.f14311a[((InlineComposerExperiment$PromptsWithNoCollapsedState) this.f13195c.mo578a(ExperimentsForFeedUtilComposerAbtestModule.ai, InlineComposerExperiment$PromptsWithNoCollapsedState.class, InlineComposerExperiment$PromptsWithNoCollapsedState.NONE)).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return z;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return true;
            default:
                return false;
        }
    }
}
