package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
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
import com.facebook.productionprompts.logging.ProductionPromptsLogger;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: msg */
public class PromptImpressionLoggerPartDefinition<E extends HasPersistentState & PromptViewStateUpdater> extends BaseSinglePartDefinition<Props, Void, E, View> {
    private static PromptImpressionLoggerPartDefinition f13228c;
    private static final Object f13229d = new Object();
    public final Provider<PromptImpressionLoggingSessionIdMap> f13230a;
    public final Provider<ProductionPromptsLogger> f13231b;

    /* compiled from: msg */
    public class Props {
        public CanRenderV2Prompt f14324a;
        public InlineComposerPromptSession f14325b;
        public PromptPersitentState f14326c;

        public Props(CanRenderV2Prompt canRenderV2Prompt, InlineComposerPromptSession inlineComposerPromptSession, HasPersistentState hasPersistentState, CacheableEntity cacheableEntity) {
            this.f14324a = canRenderV2Prompt;
            this.f14325b = inlineComposerPromptSession;
            ContextStateKey a = InlineComposerPersistentStateHelper.m19395a(inlineComposerPromptSession);
            PromptPersitentState a2 = PromptPersitentState.m20698a();
            if (inlineComposerPromptSession != null) {
                a2 = (PromptPersitentState) hasPersistentState.mo2425a(a, cacheableEntity);
                if (a2 == PromptPersitentState.f14327c) {
                    hasPersistentState.mo2439a(a, PromptPersitentState.m20698a());
                    a2 = (PromptPersitentState) hasPersistentState.mo2425a(a, cacheableEntity);
                }
                if (a2.f14328a != null) {
                    a2.f14329b = false;
                }
            }
            this.f14326c = a2;
        }
    }

    private static PromptImpressionLoggerPartDefinition m19483b(InjectorLike injectorLike) {
        return new PromptImpressionLoggerPartDefinition(IdBasedSingletonScopeProvider.m1809a(injectorLike, 3153), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3152));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        if (!(props.f14324a == null || props.f14326c.f14328a == props.f14325b.f13411c.a)) {
            props.f14326c.f14329b = false;
        }
        return null;
    }

    public final /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 448659019);
        Props props = (Props) obj;
        if (props.f14324a != null) {
            boolean z;
            if (props.f14326c.f14329b) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ((PromptImpressionLoggingSessionIdMap) this.f13230a.get()).m19703a(props.f14325b.f13409a.mo2493b(), ((ProductionPromptsLogger) this.f13231b.get()).m18866a(props.f14325b));
                props.f14326c.f14329b = true;
            }
            if (props.f14326c.f14328a != props.f14325b.f13411c.a) {
                props.f14326c.f14328a = props.f14325b.f13411c.a;
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1846345574, a);
    }

    @Inject
    public PromptImpressionLoggerPartDefinition(Provider<PromptImpressionLoggingSessionIdMap> provider, Provider<ProductionPromptsLogger> provider2) {
        this.f13230a = provider;
        this.f13231b = provider2;
    }

    public static PromptImpressionLoggerPartDefinition m19482a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromptImpressionLoggerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13229d) {
                PromptImpressionLoggerPartDefinition promptImpressionLoggerPartDefinition;
                if (a2 != null) {
                    promptImpressionLoggerPartDefinition = (PromptImpressionLoggerPartDefinition) a2.mo818a(f13229d);
                } else {
                    promptImpressionLoggerPartDefinition = f13228c;
                }
                if (promptImpressionLoggerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19483b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13229d, b3);
                        } else {
                            f13228c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = promptImpressionLoggerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
