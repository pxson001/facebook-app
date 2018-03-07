package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.SparseArray;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.HeaderTextLayoutWidthResolver;
import com.facebook.feed.rows.sections.header.HeaderTitlePersistentSpannableInputForTextLayout;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.PersistentSpannableInput;
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
/* compiled from: image/gif */
public class HeaderTitleComponentSpec<E extends HasPersistentState & HasInvalidate & HasContext> {
    private static final SparseArray<Object> f20513a;
    private static HeaderTitleComponentSpec f20514e;
    private static final Object f20515f = new Object();
    private final FeedHighlighter f20516b;
    private final HeaderTitleSpannableBuilder f20517c;
    private final PersistentSpannablePreparer f20518d;

    private static HeaderTitleComponentSpec m28256b(InjectorLike injectorLike) {
        return new HeaderTitleComponentSpec(FeedHighlighter.m28184a(injectorLike), PersistentSpannablePreparer.m28258a(injectorLike), HeaderTitleSpannableBuilder.m28271a(injectorLike));
    }

    static {
        SparseArray sparseArray = new SparseArray(1);
        f20513a = sparseArray;
        sparseArray.put(2131558541, Boolean.valueOf(true));
    }

    @Inject
    public HeaderTitleComponentSpec(FeedHighlighter feedHighlighter, PersistentSpannablePreparer persistentSpannablePreparer, HeaderTitleSpannableBuilder headerTitleSpannableBuilder) {
        this.f20516b = feedHighlighter;
        this.f20518d = persistentSpannablePreparer;
        this.f20517c = headerTitleSpannableBuilder;
    }

    public static HeaderTitleComponentSpec m28255a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20515f) {
                HeaderTitleComponentSpec headerTitleComponentSpec;
                if (a2 != null) {
                    headerTitleComponentSpec = (HeaderTitleComponentSpec) a2.mo818a(f20515f);
                } else {
                    headerTitleComponentSpec = f20514e;
                }
                if (headerTitleComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28256b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20515f, b3);
                        } else {
                            f20514e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m28257a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        SparseArray sparseArray = null;
        FeedProps<GraphQLStory> feedProps2 = feedProps;
        BaseFeedStoryMenuHelper baseFeedStoryMenuHelper = null;
        HeaderTextLayoutWidthResolver headerTextLayoutWidthResolver = null;
        FeedRenderUtils feedRenderUtils = null;
        PersistentSpannableInput headerTitlePersistentSpannableInputForTextLayout = new HeaderTitlePersistentSpannableInputForTextLayout(null, feedProps2, baseFeedStoryMenuHelper, this.f20516b, headerTextLayoutWidthResolver, feedRenderUtils, this.f20517c, -1, ContextUtils.m2501b(((HasContext) e).getContext(), 2130772562, 2131361972));
        this.f20518d.m28261b(headerTitlePersistentSpannableInputForTextLayout, e);
        ComponentLayout$Builder c = Text.m31011a(componentContext).m31042a(((PersistentSpannable) e.mo2425a(headerTitlePersistentSpannableInputForTextLayout.mo3193a(), (CacheableEntity) feedProps.f13444a)).f21833a).m31058o(2131430351).m31056m(16842806).m31061s(2131362771).m31059q(2131430350).m31049d(1.0f).m31040a(TruncateAt.END).m31043a(false).m31047c(true).m30663c();
        if (StoryProps.m27466p(feedProps)) {
            sparseArray = f20513a;
        }
        return c.mo3310a(sparseArray).mo3343j();
    }
}
