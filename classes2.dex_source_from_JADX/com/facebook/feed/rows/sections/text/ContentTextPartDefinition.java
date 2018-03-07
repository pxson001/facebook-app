package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.util.story.FeedStoryUtil;
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
/* compiled from: feedback/reactions/vector/ */
public class ContentTextPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ContentTextPartDefinition f24437e;
    private static final Object f24438f = new Object();
    private final Lazy<ContentTextComponentPartDefinition<FeedEnvironment>> f24439a;
    private final Lazy<DefaultContentTextPartDefinition> f24440b;
    private final FeedStoryUtil f24441c;
    private final AndroidComponentsExperimentHelper f24442d;

    private static ContentTextPartDefinition m32754b(InjectorLike injectorLike) {
        return new ContentTextPartDefinition(IdBasedLazy.m1808a(injectorLike, 1682), IdBasedLazy.m1808a(injectorLike, 1687), FeedStoryUtil.m18578a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19117a(baseMultiRowSubParts, this.f24442d.m10057f(), this.f24439a, obj).m19119a(this.f24440b, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return FeedStoryUtil.m18583b((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    @Inject
    public ContentTextPartDefinition(Lazy<ContentTextComponentPartDefinition> lazy, Lazy<DefaultContentTextPartDefinition> lazy2, FeedStoryUtil feedStoryUtil, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f24439a = lazy;
        this.f24440b = lazy2;
        this.f24441c = feedStoryUtil;
        this.f24442d = androidComponentsExperimentHelper;
    }

    public static ContentTextPartDefinition m32753a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24438f) {
                ContentTextPartDefinition contentTextPartDefinition;
                if (a2 != null) {
                    contentTextPartDefinition = (ContentTextPartDefinition) a2.mo818a(f24438f);
                } else {
                    contentTextPartDefinition = f24437e;
                }
                if (contentTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32754b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24438f, b3);
                        } else {
                            f24437e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contentTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
