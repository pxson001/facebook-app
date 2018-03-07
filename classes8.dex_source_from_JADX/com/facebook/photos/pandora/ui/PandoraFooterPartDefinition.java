package com.facebook.photos.pandora.ui;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.permalink.rows.PermalinkFooterPartDefinition;
import com.facebook.permalink.rows.ReactionsPermalinkFooterPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.pages.app.activity.PagesManagerChromeActivity */
public class PandoraFooterPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLFeedback, Void, FeedEnvironment> {
    private static PandoraFooterPartDefinition f17653c;
    private static final Object f17654d = new Object();
    private final ReactionsPermalinkFooterPartDefinition f17655a;
    private final PermalinkFooterPartDefinition f17656b;

    private static PandoraFooterPartDefinition m21628b(InjectorLike injectorLike) {
        return new PandoraFooterPartDefinition(ReactionsPermalinkFooterPartDefinition.m2276a(injectorLike), PermalinkFooterPartDefinition.m2267a(injectorLike));
    }

    public final Object m21629a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
        Builder builder = new Builder();
        builder.D = graphQLFeedback;
        FeedProps c = FeedProps.c(builder.a());
        SubPartsSelector.a(baseMultiRowSubParts, this.f17655a, c).a(this.f17656b, c);
        return null;
    }

    @Inject
    public PandoraFooterPartDefinition(ReactionsPermalinkFooterPartDefinition reactionsPermalinkFooterPartDefinition, PermalinkFooterPartDefinition permalinkFooterPartDefinition) {
        this.f17655a = reactionsPermalinkFooterPartDefinition;
        this.f17656b = permalinkFooterPartDefinition;
    }

    public final boolean m21630a(Object obj) {
        return true;
    }

    public static PandoraFooterPartDefinition m21627a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PandoraFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17654d) {
                PandoraFooterPartDefinition pandoraFooterPartDefinition;
                if (a2 != null) {
                    pandoraFooterPartDefinition = (PandoraFooterPartDefinition) a2.a(f17654d);
                } else {
                    pandoraFooterPartDefinition = f17653c;
                }
                if (pandoraFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21628b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17654d, b3);
                        } else {
                            f17653c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pandoraFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
