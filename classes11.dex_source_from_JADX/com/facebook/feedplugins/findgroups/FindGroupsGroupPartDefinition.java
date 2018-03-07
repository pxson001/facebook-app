package com.facebook.feedplugins.findgroups;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
import com.facebook.graphql.model.GraphQLFindGroupsFeedUnit;
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
/* compiled from: download_checksum */
public class FindGroupsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLFindGroupsFeedUnit>, Void, FeedEnvironment> {
    private static FindGroupsGroupPartDefinition f7577c;
    private static final Object f7578d = new Object();
    private final FindGroupsPartDefinition f7579a;
    private final EmptyFooterPartDefinition f7580b;

    private static FindGroupsGroupPartDefinition m8808b(InjectorLike injectorLike) {
        return new FindGroupsGroupPartDefinition(FindGroupsPartDefinition.m8812a(injectorLike), EmptyFooterPartDefinition.a(injectorLike));
    }

    public final Object m8809a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f7579a, feedProps);
        baseMultiRowSubParts.a(this.f7580b, feedProps);
        return null;
    }

    @Inject
    public FindGroupsGroupPartDefinition(FindGroupsPartDefinition findGroupsPartDefinition, EmptyFooterPartDefinition emptyFooterPartDefinition) {
        this.f7580b = emptyFooterPartDefinition;
        this.f7579a = findGroupsPartDefinition;
    }

    public final boolean m8810a(Object obj) {
        return true;
    }

    public static FindGroupsGroupPartDefinition m8807a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindGroupsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7578d) {
                FindGroupsGroupPartDefinition findGroupsGroupPartDefinition;
                if (a2 != null) {
                    findGroupsGroupPartDefinition = (FindGroupsGroupPartDefinition) a2.a(f7578d);
                } else {
                    findGroupsGroupPartDefinition = f7577c;
                }
                if (findGroupsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8808b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7578d, b3);
                        } else {
                            f7577c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = findGroupsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
