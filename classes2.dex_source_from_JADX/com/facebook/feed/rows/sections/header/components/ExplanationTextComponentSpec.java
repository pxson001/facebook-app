package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.ExplanationTextSpannableInput;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.graphqlstory.explanation.ExplanationSpannableBuilder;
import com.facebook.feedplugins.spannable.PersistentSpannablePreparer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: friending/suggestion/%s/%s */
public class ExplanationTextComponentSpec<E extends HasInvalidate & HasPersistentState> {
    private static final SparseArray<Object> f23151a;
    private static final SparseArray<Object> f23152b;
    private static ExplanationTextComponentSpec f23153e;
    private static final Object f23154f = new Object();
    private final ExplanationSpannableBuilder f23155c;
    private final PersistentSpannablePreparer f23156d;

    private static ExplanationTextComponentSpec m31265b(InjectorLike injectorLike) {
        return new ExplanationTextComponentSpec(ExplanationSpannableBuilder.m31267a(injectorLike), PersistentSpannablePreparer.m28258a(injectorLike));
    }

    static {
        SparseArray sparseArray = new SparseArray(1);
        f23151a = sparseArray;
        sparseArray.put(2131558541, Boolean.valueOf(true));
        sparseArray = new SparseArray(1);
        f23152b = sparseArray;
        sparseArray.put(2131558541, Boolean.valueOf(false));
    }

    @Inject
    public ExplanationTextComponentSpec(ExplanationSpannableBuilder explanationSpannableBuilder, PersistentSpannablePreparer persistentSpannablePreparer) {
        this.f23155c = explanationSpannableBuilder;
        this.f23156d = persistentSpannablePreparer;
    }

    public static ExplanationTextComponentSpec m31264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationTextComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23154f) {
                ExplanationTextComponentSpec explanationTextComponentSpec;
                if (a2 != null) {
                    explanationTextComponentSpec = (ExplanationTextComponentSpec) a2.mo818a(f23154f);
                } else {
                    explanationTextComponentSpec = f23153e;
                }
                if (explanationTextComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31265b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23154f, b3);
                        } else {
                            f23153e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationTextComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m31266a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, int i, int i2, int i3) {
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.f13444a;
        ExplanationTextSpannableInput explanationTextSpannableInput = new ExplanationTextSpannableInput(feedProps, this.f23155c);
        this.f23156d.m28261b(explanationTextSpannableInput, (HasPersistentState) e);
        return Text.m31011a(componentContext).m31042a(((PersistentSpannable) ((HasPersistentState) e).mo2425a(explanationTextSpannableInput.mo3193a(), cacheableEntity)).f21833a).m31054k(i).m31057n(i2).m31060r(i3).m31043a(false).m30663c().mo3310a(StoryProps.m27466p(feedProps) ? f23151a : f23152b).mo3343j();
    }
}
