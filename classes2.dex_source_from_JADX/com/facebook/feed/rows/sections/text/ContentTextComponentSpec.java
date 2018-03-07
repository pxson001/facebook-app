package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.util.SparseArray;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.Text.Builder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.spannable.PersistentSpannable;
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
/* compiled from: home_stories_seen_state_index */
public class ContentTextComponentSpec<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState> {
    protected static final int f20918a = 2131430351;
    protected static final Typeface f20919b = Typeface.DEFAULT;
    protected static final Alignment f20920c = Alignment.ALIGN_NORMAL;
    protected static final int f20921d = 2131362048;
    private static final SparseArray<Object> f20922e;
    private static final SparseArray<Object> f20923f;
    private static ContentTextComponentSpec f20924i;
    private static final Object f20925j = new Object();
    private final ContentTextLayoutPersistentSpannableInputProvider f20926g;
    private final PersistentSpannablePreparer f20927h;

    private static ContentTextComponentSpec m28646b(InjectorLike injectorLike) {
        return new ContentTextComponentSpec((ContentTextLayoutPersistentSpannableInputProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutPersistentSpannableInputProvider.class), PersistentSpannablePreparer.m28258a(injectorLike));
    }

    static {
        SparseArray sparseArray = new SparseArray(1);
        f20922e = sparseArray;
        sparseArray.put(2131558541, Boolean.valueOf(true));
        sparseArray = new SparseArray(1);
        f20923f = sparseArray;
        sparseArray.put(2131558541, Boolean.valueOf(false));
    }

    public static ContentTextComponentSpec m28645a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentTextComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20925j) {
                ContentTextComponentSpec contentTextComponentSpec;
                if (a2 != null) {
                    contentTextComponentSpec = (ContentTextComponentSpec) a2.mo818a(f20925j);
                } else {
                    contentTextComponentSpec = f20924i;
                }
                if (contentTextComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28646b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20925j, b3);
                        } else {
                            f20924i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contentTextComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ContentTextComponentSpec(ContentTextLayoutPersistentSpannableInputProvider contentTextLayoutPersistentSpannableInputProvider, PersistentSpannablePreparer persistentSpannablePreparer) {
        this.f20926g = contentTextLayoutPersistentSpannableInputProvider;
        this.f20927h = persistentSpannablePreparer;
    }

    protected final ComponentLayout m28647a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, int i, int i2, Typeface typeface, Alignment alignment, boolean z, PersistentSpannableInput persistentSpannableInput) {
        SparseArray sparseArray;
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.m19804a();
        Resources resources = componentContext.getResources();
        int c = ContextUtils.m2503c(e.getContext(), 2130772562, 2131361972);
        if (persistentSpannableInput == null) {
            persistentSpannableInput = this.f20926g.m28632a(null, feedProps, resources.getDimensionPixelSize(i), c, z, ((HasFeedListType) e).mo2446c());
        }
        this.f20927h.m28260a(persistentSpannableInput, (HasPersistentState) e);
        Builder a = Text.m31011a(componentContext).m31042a(((PersistentSpannable) ((HasPersistentState) e).mo2425a(persistentSpannableInput.mo3193a(), cacheableEntity)).f21833a).m31058o(i).m31038a(typeface).m31039a(alignment);
        if (i2 > 0) {
            a.m31055l(i2);
        } else {
            a.m31051f(2130772561, f20921d);
        }
        ComponentLayout$Builder c2 = a.m31059q(2131430350).m31049d(1.0f).m31043a(false).m31050d(true).m31047c(true).m30663c();
        if (StoryProps.m27466p(feedProps)) {
            sparseArray = f20922e;
        } else {
            sparseArray = f20923f;
        }
        return c2.mo3310a(sparseArray).mo3343j();
    }
}
