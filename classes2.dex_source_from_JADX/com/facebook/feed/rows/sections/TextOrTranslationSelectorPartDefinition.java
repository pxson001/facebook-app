package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.TextSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.AutoTranslateSelectorPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: init_feed_fetch_news_feed_after */
public class TextOrTranslationSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TextOrTranslationSelectorPartDefinition f20075c;
    private static final Object f20076d = new Object();
    private final Lazy<TextSelectorPartDefinition> f20077a;
    private final Lazy<AutoTranslateSelectorPartDefinition<FeedEnvironment>> f20078b;

    private static TextOrTranslationSelectorPartDefinition m27793b(InjectorLike injectorLike) {
        return new TextOrTranslationSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1896), IdBasedLazy.m1808a(injectorLike, 1696));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20078b, obj).m19119a(this.f20077a, obj);
        return null;
    }

    @Inject
    public TextOrTranslationSelectorPartDefinition(Lazy<AutoTranslateSelectorPartDefinition> lazy, Lazy<TextSelectorPartDefinition> lazy2) {
        this.f20077a = lazy2;
        this.f20078b = lazy;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static TextOrTranslationSelectorPartDefinition m27792a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextOrTranslationSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20076d) {
                TextOrTranslationSelectorPartDefinition textOrTranslationSelectorPartDefinition;
                if (a2 != null) {
                    textOrTranslationSelectorPartDefinition = (TextOrTranslationSelectorPartDefinition) a2.mo818a(f20076d);
                } else {
                    textOrTranslationSelectorPartDefinition = f20075c;
                }
                if (textOrTranslationSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27793b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20076d, b3);
                        } else {
                            f20075c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textOrTranslationSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
