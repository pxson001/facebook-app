package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
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
/* compiled from: fetchBackupRewriteRules */
public class TranslationOrContentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TranslationOrContentSelectorPartDefinition f24349c;
    private static final Object f24350d = new Object();
    private final Lazy<ContentTextPartDefinition> f24351a;
    private final Lazy<AutoTranslateSelectorPartDefinition<FeedEnvironment>> f24352b;

    private static TranslationOrContentSelectorPartDefinition m32664b(InjectorLike injectorLike) {
        return new TranslationOrContentSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1896), IdBasedLazy.m1808a(injectorLike, 1685));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f24352b, obj).m19119a(this.f24351a, obj);
        return null;
    }

    @Inject
    public TranslationOrContentSelectorPartDefinition(Lazy<AutoTranslateSelectorPartDefinition> lazy, Lazy<ContentTextPartDefinition> lazy2) {
        this.f24351a = lazy2;
        this.f24352b = lazy;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static TranslationOrContentSelectorPartDefinition m32663a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TranslationOrContentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24350d) {
                TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition;
                if (a2 != null) {
                    translationOrContentSelectorPartDefinition = (TranslationOrContentSelectorPartDefinition) a2.mo818a(f24350d);
                } else {
                    translationOrContentSelectorPartDefinition = f24349c;
                }
                if (translationOrContentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32664b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24350d, b3);
                        } else {
                            f24349c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = translationOrContentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
