package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
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
/* compiled from: couldn't find activity */
public class InstagramPromoteUnitPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLInstagramPhotosFromFriendsFeedUnit>, Void, FeedEnvironment> {
    private static InstagramPromoteUnitPartDefinition f7963c;
    private static final Object f7964d = new Object();
    private final InstagramPromoteUnitHeaderPartDefinition f7965a;
    private final InstagramPromoteUnitHScrollPartDefinition<FeedEnvironment> f7966b;

    private static InstagramPromoteUnitPartDefinition m9040b(InjectorLike injectorLike) {
        return new InstagramPromoteUnitPartDefinition(InstagramPromoteUnitHeaderPartDefinition.m9020a(injectorLike), InstagramPromoteUnitHScrollPartDefinition.m9015a(injectorLike));
    }

    public final Object m9041a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f7965a, feedProps);
        baseMultiRowSubParts.a(this.f7966b, feedProps);
        return null;
    }

    @Inject
    public InstagramPromoteUnitPartDefinition(InstagramPromoteUnitHeaderPartDefinition instagramPromoteUnitHeaderPartDefinition, InstagramPromoteUnitHScrollPartDefinition instagramPromoteUnitHScrollPartDefinition) {
        this.f7965a = instagramPromoteUnitHeaderPartDefinition;
        this.f7966b = instagramPromoteUnitHScrollPartDefinition;
    }

    public final boolean m9042a(Object obj) {
        return true;
    }

    public static InstagramPromoteUnitPartDefinition m9039a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPromoteUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7964d) {
                InstagramPromoteUnitPartDefinition instagramPromoteUnitPartDefinition;
                if (a2 != null) {
                    instagramPromoteUnitPartDefinition = (InstagramPromoteUnitPartDefinition) a2.a(f7964d);
                } else {
                    instagramPromoteUnitPartDefinition = f7963c;
                }
                if (instagramPromoteUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9040b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7964d, b3);
                        } else {
                            f7963c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPromoteUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
