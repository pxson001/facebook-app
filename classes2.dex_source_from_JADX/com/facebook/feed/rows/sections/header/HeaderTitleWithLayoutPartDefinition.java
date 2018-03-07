package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.SpannablePartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hu */
public class HeaderTitleWithLayoutPartDefinition<E extends HasPersistentState & HasInvalidate & HasMenuButtonProvider & HasContext> extends BaseSinglePartDefinition<Props, Boolean, E, View> {
    private static HeaderTitleWithLayoutPartDefinition f20678h;
    private static final Object f20679i = new Object();
    private final Lazy<FeedHighlighter> f20680a;
    private final Lazy<TitleTextLayoutBuilderHolder> f20681b;
    private final Lazy<HeaderTextLayoutWidthResolver> f20682c;
    private final Lazy<FeedRenderUtils> f20683d;
    private final Lazy<SpannablePartDefinition<E>> f20684e;
    private final Lazy<HeaderTitleSpannableBuilder> f20685f;
    private final QeAccessor f20686g;

    /* compiled from: hu */
    public class Props {
        public final FeedProps<GraphQLStory> f21732a;
        public final boolean f21733b;
        public final int f21734c;

        public Props(FeedProps<GraphQLStory> feedProps, boolean z, int i) {
            this.f21732a = feedProps;
            this.f21733b = z;
            this.f21734c = i;
        }
    }

    private static HeaderTitleWithLayoutPartDefinition m28428b(InjectorLike injectorLike) {
        return new HeaderTitleWithLayoutPartDefinition(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1914), IdBasedLazy.m1808a(injectorLike, 1625), IdBasedLazy.m1808a(injectorLike, 1604), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1759), IdBasedLazy.m1808a(injectorLike, 2030), IdBasedLazy.m1808a(injectorLike, 1880), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        TextLayoutBuilder textLayoutBuilder;
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        int b = ContextUtils.m2501b(((HasContext) hasPersistentState).getContext(), 2130772562, 2131361972);
        SinglePartDefinition singlePartDefinition = (SinglePartDefinition) this.f20684e.get();
        if (props.f21733b) {
            textLayoutBuilder = ((TitleTextLayoutBuilderHolder) this.f20681b.get()).f21790a;
        } else {
            textLayoutBuilder = null;
        }
        subParts.mo2756a(singlePartDefinition, new HeaderTitlePersistentSpannableInputForTextLayout(textLayoutBuilder, props.f21732a, ((HasMenuButtonProvider) hasPersistentState).mo2448e(), (FeedHighlighter) this.f20680a.get(), (HeaderTextLayoutWidthResolver) this.f20682c.get(), (FeedRenderUtils) this.f20683d.get(), (HeaderTitleSpannableBuilder) this.f20685f.get(), props.f21734c, b));
        return Boolean.valueOf(StoryProps.m27466p(props.f21732a));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1675785091);
        view.setTag(2131558541, (Boolean) obj2);
        Logger.a(8, EntryType.MARK_POP, 677511909, a);
    }

    public static HeaderTitleWithLayoutPartDefinition m28427a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleWithLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20679i) {
                HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition;
                if (a2 != null) {
                    headerTitleWithLayoutPartDefinition = (HeaderTitleWithLayoutPartDefinition) a2.mo818a(f20679i);
                } else {
                    headerTitleWithLayoutPartDefinition = f20678h;
                }
                if (headerTitleWithLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28428b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20679i, b3);
                        } else {
                            f20678h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleWithLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public HeaderTitleWithLayoutPartDefinition(Lazy<FeedHighlighter> lazy, Lazy<TitleTextLayoutBuilderHolder> lazy2, Lazy<HeaderTextLayoutWidthResolver> lazy3, Lazy<FeedRenderUtils> lazy4, Lazy<SpannablePartDefinition> lazy5, Lazy<HeaderTitleSpannableBuilder> lazy6, QeAccessor qeAccessor) {
        this.f20680a = lazy;
        this.f20681b = lazy2;
        this.f20682c = lazy3;
        this.f20683d = lazy4;
        this.f20684e = lazy5;
        this.f20685f = lazy6;
        this.f20686g = qeAccessor;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setTag(2131558541, null);
    }
}
