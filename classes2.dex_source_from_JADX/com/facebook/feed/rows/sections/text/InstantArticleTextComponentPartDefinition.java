package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.text.InstantArticleTextComponent.Builder;
import com.facebook.feed.rows.sections.text.InstantArticleTextComponent.State;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hot_like_has_sent_larger_like */
public class InstantArticleTextComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static InstantArticleTextComponentPartDefinition f20842h;
    private static final Object f20843i = new Object();
    private final InstantArticleTextLayoutClickablePartDefinition f20844c;
    private final InstantArticleTextComponent<E> f20845d;
    private final FeedBackgroundStylerComponentWrapper f20846e;
    private final CopyTextPartDefinition f20847f;
    private final AndroidComponentsExperimentHelper f20848g;

    private static InstantArticleTextComponentPartDefinition m28565b(InjectorLike injectorLike) {
        return new InstantArticleTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), InstantArticleTextLayoutClickablePartDefinition.m28572a(injectorLike), InstantArticleTextComponent.m28633a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), CopyTextPartDefinition.m28618a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f20847f, obj.f13444a);
    }

    public final boolean m28570a(Object obj) {
        return this.f20844c.m28576a((FeedProps) obj) && this.f20848g.m10058g();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return (CacheableEntity) ((FeedProps) obj).f13444a;
    }

    @Inject
    public InstantArticleTextComponentPartDefinition(Context context, InstantArticleTextLayoutClickablePartDefinition instantArticleTextLayoutClickablePartDefinition, InstantArticleTextComponent instantArticleTextComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, CopyTextPartDefinition copyTextPartDefinition, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f20844c = instantArticleTextLayoutClickablePartDefinition;
        this.f20845d = instantArticleTextComponent;
        this.f20846e = feedBackgroundStylerComponentWrapper;
        this.f20847f = copyTextPartDefinition;
        this.f20848g = androidComponentsExperimentHelper;
    }

    public static InstantArticleTextComponentPartDefinition m28564a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20843i) {
                InstantArticleTextComponentPartDefinition instantArticleTextComponentPartDefinition;
                if (a2 != null) {
                    instantArticleTextComponentPartDefinition = (InstantArticleTextComponentPartDefinition) a2.mo818a(f20843i);
                } else {
                    instantArticleTextComponentPartDefinition = f20842h;
                }
                if (instantArticleTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28565b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20843i, b3);
                        } else {
                            f20842h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return ContentTextComponentPartDefinition.f23279c;
    }

    private Component<?> m28563a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        InstantArticleTextComponent instantArticleTextComponent = this.f20845d;
        State state = new State(instantArticleTextComponent);
        Builder builder = (Builder) instantArticleTextComponent.f20908c.mo740a();
        if (builder == null) {
            builder = new Builder(instantArticleTextComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        builder2 = builder2;
        builder2.a.b = e;
        builder2.e.set(1);
        return this.f20846e.m28340b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.f13075e), builder2.mo3296d());
    }
}
