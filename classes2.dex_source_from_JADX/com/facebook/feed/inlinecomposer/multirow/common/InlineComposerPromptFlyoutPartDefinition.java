package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper.CanHideShowPromptOnClickListener;
import com.facebook.feed.inlinecomposer.multirow.common.animations.PromptFlyoutAnimationBuilder;
import com.facebook.feed.inlinecomposer.multirow.common.animations.PromptFlyoutContainerAnimationBuilder;
import com.facebook.feed.inlinecomposer.multirow.common.animations.XoutButtonOnClickListenerProvider;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptViewController;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.ui.animations.persistent.parts.AnimationPartFactory;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mr */
public class InlineComposerPromptFlyoutPartDefinition<V extends View & HasPromptFlyout, E extends HasPersistentState & PromptViewStateUpdater> extends BaseSinglePartDefinition<Props, CanHideShowPromptOnClickListener, E, V> {
    private static InlineComposerPromptFlyoutPartDefinition f13240k;
    private static final Object f13241l = new Object();
    private final InlineComposerPromptFlyoutTitleBarPartDefinition f13242a;
    private final InlineComposerExposedBackgroundPartDefinition f13243b;
    private final InlineComposerPromptDisplayReasonPartDefinition f13244c;
    private final AbstractFbErrorReporter f13245d;
    private final InlineComposerPersistentStateHelper f13246e;
    private final Context f13247f;
    private final DefaultAnimationPartFactory f13248g;
    public final Provider<InlineComposerPromptViewController> f13249h;
    private final XoutButtonOnClickListenerProvider f13250i;
    private final PromptsExperimentHelper f13251j;

    @Immutable
    /* compiled from: mr */
    public class Props {
        public final CanRenderV2Prompt f19749a;
        public final V2Attachment f19750b;
        public final InlineComposerPromptSession f19751c;
        public final CacheableEntity f19752d;
        public final boolean f19753e;

        public Props(CanRenderV2Prompt canRenderV2Prompt, V2Attachment v2Attachment, InlineComposerPromptSession inlineComposerPromptSession, CacheableEntity cacheableEntity, boolean z) {
            this.f19749a = canRenderV2Prompt;
            this.f19750b = v2Attachment;
            this.f19751c = inlineComposerPromptSession;
            this.f19752d = cacheableEntity;
            this.f19753e = z;
        }
    }

    private static InlineComposerPromptFlyoutPartDefinition m19499b(InjectorLike injectorLike) {
        return new InlineComposerPromptFlyoutPartDefinition(InlineComposerPromptFlyoutTitleBarPartDefinition.m19504a(injectorLike), InlineComposerExposedBackgroundPartDefinition.m19366a(injectorLike), InlineComposerPromptDisplayReasonPartDefinition.m19509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), InlineComposerPersistentStateHelper.m19396b(injectorLike), (Context) injectorLike.getInstance(Context.class), DefaultAnimationPartFactory.m19389a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3137), (XoutButtonOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(XoutButtonOnClickListenerProvider.class), PromptsExperimentHelper.m15312b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        subParts.mo2756a(this.f13242a, new com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutTitleBarPartDefinition.Props(props.f19749a));
        subParts.mo2756a(this.f13243b, new com.facebook.feed.inlinecomposer.multirow.common.InlineComposerExposedBackgroundPartDefinition.Props(false, false, false, false));
        subParts.mo2756a(this.f13244c, props.f19749a == null ? null : props.f19749a.mo2632h());
        OnClickListener a = this.f13250i.m19521a((PromptViewStateUpdater) hasPersistentState);
        this.f13246e.m19397a(subParts, props.f19751c, props.f19752d, InlineComposerPromptFlyoutPartDefinition.class, new PromptFlyoutAnimationBuilder(this.f13247f, this.f13248g, props.f19750b, a));
        if (this.f13251j.m15315d()) {
            this.f13246e.m19397a(subParts, props.f19751c, props.f19752d, PromptFlyoutContainerAnimationBuilder.class, new PromptFlyoutContainerAnimationBuilder(this.f13247f, this.f13248g));
        }
        return a;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1017979111);
        m19498a((Props) obj, (CanHideShowPromptOnClickListener) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1844038284, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Props props = (Props) obj;
        ((HasPromptFlyout) view).getFlyoutXoutButton().setOnClickListener(null);
        InlineComposerPromptSession inlineComposerPromptSession = props.f19751c;
        ((InlineComposerPromptViewController) this.f13249h.get()).mo2615b(new V2ObjectsRequiredForBinding(((HasPromptFlyout) view).getFlyoutView(), props.f19749a, props.f19750b), inlineComposerPromptSession);
    }

    public static InlineComposerPromptFlyoutPartDefinition m19496a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerPromptFlyoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13241l) {
                InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition;
                if (a2 != null) {
                    inlineComposerPromptFlyoutPartDefinition = (InlineComposerPromptFlyoutPartDefinition) a2.mo818a(f13241l);
                } else {
                    inlineComposerPromptFlyoutPartDefinition = f13240k;
                }
                if (inlineComposerPromptFlyoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19499b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13241l, b3);
                        } else {
                            f13240k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerPromptFlyoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerPromptFlyoutPartDefinition(InlineComposerPromptFlyoutTitleBarPartDefinition inlineComposerPromptFlyoutTitleBarPartDefinition, InlineComposerExposedBackgroundPartDefinition inlineComposerExposedBackgroundPartDefinition, InlineComposerPromptDisplayReasonPartDefinition inlineComposerPromptDisplayReasonPartDefinition, FbErrorReporter fbErrorReporter, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, Context context, AnimationPartFactory animationPartFactory, Provider<InlineComposerPromptViewController> provider, XoutButtonOnClickListenerProvider xoutButtonOnClickListenerProvider, PromptsExperimentHelper promptsExperimentHelper) {
        this.f13242a = inlineComposerPromptFlyoutTitleBarPartDefinition;
        this.f13243b = inlineComposerExposedBackgroundPartDefinition;
        this.f13244c = inlineComposerPromptDisplayReasonPartDefinition;
        this.f13245d = fbErrorReporter;
        this.f13246e = inlineComposerPersistentStateHelper;
        this.f13247f = context;
        this.f13248g = animationPartFactory;
        this.f13249h = provider;
        this.f13250i = xoutButtonOnClickListenerProvider;
        this.f13251j = promptsExperimentHelper;
    }

    private void m19498a(Props props, CanHideShowPromptOnClickListener canHideShowPromptOnClickListener, V v) {
        View findViewById;
        if (!this.f13251j.m15315d()) {
            findViewById = v.findViewById(2131561939);
            if (findViewById instanceof ViewStub) {
                ((ViewStub) findViewById).inflate().setVisibility(0);
            }
        }
        findViewById = ((HasPromptFlyout) v).getFlyoutView();
        if (props.f19753e) {
            int paddingLeft = findViewById.getPaddingLeft();
            int paddingTop = findViewById.getPaddingTop();
            int paddingRight = findViewById.getPaddingRight();
            int paddingBottom = findViewById.getPaddingBottom();
            findViewById.setBackgroundResource(2130842800);
            findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        if (props.f19749a == null) {
            ((HasPromptFlyout) v).getFlyoutView().setVisibility(8);
            return;
        }
        canHideShowPromptOnClickListener.mo2757a(v, props.f19751c);
        if (this.f13251j.m15315d()) {
            int i;
            View a = props.f19750b == null ? null : props.f19750b.a();
            FrameLayout attachmentInsertPoint = ((HasPromptFlyout) v).getAttachmentInsertPoint();
            if (a == null) {
                i = 8;
            } else {
                i = 0;
            }
            attachmentInsertPoint.setVisibility(i);
        } else {
            m19497a(v, props.f19750b);
        }
        ((InlineComposerPromptViewController) this.f13249h.get()).mo2612a(new V2ObjectsRequiredForBinding(((HasPromptFlyout) v).getFlyoutView(), props.f19749a, props.f19750b), props.f19751c);
    }

    private void m19497a(V v, V2Attachment v2Attachment) {
        FrameLayout attachmentInsertPoint = ((HasPromptFlyout) v).getAttachmentInsertPoint();
        if (v2Attachment != null) {
            Object obj;
            View a = v2Attachment.a();
            if (a == null || attachmentInsertPoint.indexOfChild(a) == -1) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                attachmentInsertPoint.removeAllViews();
                attachmentInsertPoint.setVisibility(0);
                if (a.getParent() == null) {
                    attachmentInsertPoint.addView(a);
                    return;
                }
                this.f13245d.m2340a(InlineComposerPromptFlyoutPartDefinition.class.getSimpleName(), "Adding child view of type " + a.getClass().getSimpleName() + " to a new parent " + attachmentInsertPoint.getClass().getSimpleName() + "@" + attachmentInsertPoint.hashCode() + ", but child already has parent " + a.getParent().getClass().getSimpleName() + "@" + a.getParent().hashCode());
                ((ViewGroup) a.getParent()).removeView(a);
                attachmentInsertPoint.addView(a);
                return;
            }
            return;
        }
        attachmentInsertPoint.removeAllViews();
        attachmentInsertPoint.setVisibility(8);
    }
}
