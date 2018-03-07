package com.facebook.feed.rows.sections.attachments.components;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannablePreparer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: ViewerTopPagesQuery */
public class LifeEventTitleTextComponentSpec<E extends HasInvalidate & HasPersistentState> {
    private static LifeEventTitleTextComponentSpec f20952c;
    private static final Object f20953d = new Object();
    private final LifeEventAttachmentHeaderTextPersistentSpannableInputProvider f20954a;
    private final PersistentSpannablePreparer f20955b;

    private static LifeEventTitleTextComponentSpec m23870b(InjectorLike injectorLike) {
        return new LifeEventTitleTextComponentSpec((LifeEventAttachmentHeaderTextPersistentSpannableInputProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LifeEventAttachmentHeaderTextPersistentSpannableInputProvider.class), PersistentSpannablePreparer.a(injectorLike));
    }

    @Inject
    public LifeEventTitleTextComponentSpec(LifeEventAttachmentHeaderTextPersistentSpannableInputProvider lifeEventAttachmentHeaderTextPersistentSpannableInputProvider, PersistentSpannablePreparer persistentSpannablePreparer) {
        this.f20954a = lifeEventAttachmentHeaderTextPersistentSpannableInputProvider;
        this.f20955b = persistentSpannablePreparer;
    }

    public static LifeEventTitleTextComponentSpec m23869a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventTitleTextComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20953d) {
                LifeEventTitleTextComponentSpec lifeEventTitleTextComponentSpec;
                if (a2 != null) {
                    lifeEventTitleTextComponentSpec = (LifeEventTitleTextComponentSpec) a2.a(f20953d);
                } else {
                    lifeEventTitleTextComponentSpec = f20952c;
                }
                if (lifeEventTitleTextComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23870b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20953d, b3);
                        } else {
                            f20952c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventTitleTextComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final ComponentLayout m23871a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, FeedProps<GraphQLStory> feedProps2, E e, GraphQLTextWithEntities graphQLTextWithEntities, FlyoutClickSource flyoutClickSource, String str, int i, int i2) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps2.a();
        LifeEventAttachmentHeaderTextPersistentSpannableInput a = this.f20954a.m23836a(feedProps, feedProps2, graphQLTextWithEntities, flyoutClickSource, str);
        this.f20955b.a(a, (HasPersistentState) e);
        return Text.a(componentContext).a(((PersistentSpannable) ((HasPersistentState) e).a(a.a(), graphQLStory)).a).n(i).k(i2).a(Typeface.DEFAULT).a(Alignment.ALIGN_CENTER).d(true).c().j();
    }
}
