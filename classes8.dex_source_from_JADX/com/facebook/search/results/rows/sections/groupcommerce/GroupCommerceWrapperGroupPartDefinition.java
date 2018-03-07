package com.facebook.search.results.rows.sections.groupcommerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.groupcommerce.GroupCommerceProductFeedGroupPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsSalePostUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ProfilePictureOverlayCameraActivity */
public class GroupCommerceWrapperGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsSalePostUnit>, Void, SearchResultsFeedEnvironment> {
    private static GroupCommerceWrapperGroupPartDefinition f24342b;
    private static final Object f24343c = new Object();
    private final GroupCommerceProductFeedGroupPartDefinition f24344a;

    private static GroupCommerceWrapperGroupPartDefinition m27844b(InjectorLike injectorLike) {
        return new GroupCommerceWrapperGroupPartDefinition(GroupCommerceProductFeedGroupPartDefinition.m14568a(injectorLike));
    }

    public final Object m27845a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24344a, feedProps.a(((SearchResultsSalePostUnit) feedProps.a).mo1333f()));
        return null;
    }

    @Inject
    public GroupCommerceWrapperGroupPartDefinition(GroupCommerceProductFeedGroupPartDefinition groupCommerceProductFeedGroupPartDefinition) {
        this.f24344a = groupCommerceProductFeedGroupPartDefinition;
    }

    public final boolean m27846a(Object obj) {
        return true;
    }

    public static GroupCommerceWrapperGroupPartDefinition m27843a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceWrapperGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24343c) {
                GroupCommerceWrapperGroupPartDefinition groupCommerceWrapperGroupPartDefinition;
                if (a2 != null) {
                    groupCommerceWrapperGroupPartDefinition = (GroupCommerceWrapperGroupPartDefinition) a2.a(f24343c);
                } else {
                    groupCommerceWrapperGroupPartDefinition = f24342b;
                }
                if (groupCommerceWrapperGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27844b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24343c, b3);
                        } else {
                            f24342b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceWrapperGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
