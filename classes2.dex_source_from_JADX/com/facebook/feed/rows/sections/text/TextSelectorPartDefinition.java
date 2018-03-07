package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
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
/* compiled from: hprof */
public class TextSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TextSelectorPartDefinition f20833h;
    private static final Object f20834i = new Object();
    private final Lazy<ContentTextLayoutClickablePartDefinition> f20835a;
    private final Lazy<ContentTextComponentPartDefinition<FeedEnvironment>> f20836b;
    private final Lazy<InstantArticleTextLayoutClickablePartDefinition> f20837c;
    private final Lazy<InstantArticleTextComponentPartDefinition<FeedEnvironment>> f20838d;
    private final Lazy<VariableTextSizeClickablePartDefinition> f20839e;
    private final Lazy<VariableTextSizeClickableComponentPartDefinition<FeedEnvironment>> f20840f;
    private final AndroidComponentsExperimentHelper f20841g;

    private static TextSelectorPartDefinition m28560b(InjectorLike injectorLike) {
        return new TextSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1682), IdBasedLazy.m1808a(injectorLike, 1684), IdBasedLazy.m1808a(injectorLike, 1693), IdBasedLazy.m1808a(injectorLike, 1691), IdBasedLazy.m1808a(injectorLike, 1698), IdBasedLazy.m1808a(injectorLike, 1697), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        SubPartsSelector a = SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20838d, obj).m19119a(this.f20837c, obj);
        Object obj2 = null;
        FeedListType c = feedEnvironment.mo2446c();
        if (c != null) {
            FeedListName a2 = c.mo2419a();
            if (a2 == FeedListName.FEED || a2 == FeedListName.MY_TIMELINE || a2 == FeedListName.OTHER_PERSON_TIMELINE) {
                obj2 = 1;
            }
        }
        if (obj2 != null) {
            a.m19119a(this.f20840f, obj);
            a.m19119a(this.f20839e, obj);
        }
        AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f20841g;
        boolean z = false;
        if (androidComponentsExperimentHelper.f5900d == null) {
            androidComponentsExperimentHelper.f5900d = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5933q, false));
        }
        if (androidComponentsExperimentHelper.f5900d.booleanValue() || androidComponentsExperimentHelper.m10064s()) {
            z = true;
        }
        a.m19121a(z, this.f20836b, obj).m19119a(this.f20835a, obj);
        return null;
    }

    @Inject
    public TextSelectorPartDefinition(Lazy<ContentTextComponentPartDefinition> lazy, Lazy<ContentTextLayoutClickablePartDefinition> lazy2, Lazy<InstantArticleTextLayoutClickablePartDefinition> lazy3, Lazy<InstantArticleTextComponentPartDefinition> lazy4, Lazy<VariableTextSizeClickablePartDefinition> lazy5, Lazy<VariableTextSizeClickableComponentPartDefinition> lazy6, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f20835a = lazy2;
        this.f20836b = lazy;
        this.f20837c = lazy3;
        this.f20838d = lazy4;
        this.f20839e = lazy5;
        this.f20840f = lazy6;
        this.f20841g = androidComponentsExperimentHelper;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static TextSelectorPartDefinition m28559a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20834i) {
                TextSelectorPartDefinition textSelectorPartDefinition;
                if (a2 != null) {
                    textSelectorPartDefinition = (TextSelectorPartDefinition) a2.mo818a(f20834i);
                } else {
                    textSelectorPartDefinition = f20833h;
                }
                if (textSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28560b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20834i, b3);
                        } else {
                            f20833h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
