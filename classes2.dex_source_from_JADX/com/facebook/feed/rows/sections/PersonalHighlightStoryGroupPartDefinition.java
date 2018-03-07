package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.facebookvoice.PersonalHighlightHeaderPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: injector_autorequire_modules.GeneratedModuleLists */
public class PersonalHighlightStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PersonalHighlightStoryGroupPartDefinition f19949d;
    private static final Object f19950e = new Object();
    private final PersonalHighlightSubgroupSelectorPartDefinition f19951a;
    private final PersonalHighlightHeaderPartDefinition f19952b;
    private final FeedStoryUtil f19953c;

    private static PersonalHighlightStoryGroupPartDefinition m27730b(InjectorLike injectorLike) {
        return new PersonalHighlightStoryGroupPartDefinition(PersonalHighlightHeaderPartDefinition.a(injectorLike), PersonalHighlightSubgroupSelectorPartDefinition.a(injectorLike), FeedStoryUtil.m18578a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        baseMultiRowSubParts.m19112a(this.f19952b, obj);
        baseMultiRowSubParts.m19112a(this.f19951a, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return m27729a((FeedProps) obj, this.f19953c);
    }

    @Inject
    public PersonalHighlightStoryGroupPartDefinition(PersonalHighlightHeaderPartDefinition personalHighlightHeaderPartDefinition, PersonalHighlightSubgroupSelectorPartDefinition personalHighlightSubgroupSelectorPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f19953c = feedStoryUtil;
        this.f19951a = personalHighlightSubgroupSelectorPartDefinition;
        this.f19952b = personalHighlightHeaderPartDefinition;
    }

    public static boolean m27729a(FeedProps<GraphQLStory> feedProps, FeedStoryUtil feedStoryUtil) {
        return FeedStoryUtil.m18585e((FeedProps) feedProps);
    }

    public static PersonalHighlightStoryGroupPartDefinition m27728a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonalHighlightStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19950e) {
                PersonalHighlightStoryGroupPartDefinition personalHighlightStoryGroupPartDefinition;
                if (a2 != null) {
                    personalHighlightStoryGroupPartDefinition = (PersonalHighlightStoryGroupPartDefinition) a2.mo818a(f19950e);
                } else {
                    personalHighlightStoryGroupPartDefinition = f19949d;
                }
                if (personalHighlightStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27730b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19950e, b3);
                        } else {
                            f19949d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = personalHighlightStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
