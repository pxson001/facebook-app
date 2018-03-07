package com.facebook.feed.rows.sections.attachments.places;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.location.LocationPartDefinition;
import com.facebook.feedplugins.graphqlstory.location.ZeroLocationPartDefinition;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
/* compiled from: new_user_info/ */
public class LocationMultiRowAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static LocationMultiRowAttachmentSelectorPartDefinition f7108c;
    private static final Object f7109d = new Object();
    private final Lazy<LocationPartDefinition> f7110a;
    private final Lazy<ZeroLocationPartDefinition> f7111b;

    private static LocationMultiRowAttachmentSelectorPartDefinition m7432b(InjectorLike injectorLike) {
        return new LocationMultiRowAttachmentSelectorPartDefinition(IdBasedLazy.a(injectorLike, 1889), IdBasedLazy.a(injectorLike, 1890));
    }

    public final Object m7433a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f7111b, feedProps).a(this.f7110a, feedProps);
        return null;
    }

    public final boolean m7434a(Object obj) {
        GraphQLStory c = AttachmentProps.c((FeedProps) obj);
        return c != null && (GraphQLHelper.m(c) || GraphQLHelper.n(c));
    }

    @Inject
    public LocationMultiRowAttachmentSelectorPartDefinition(Lazy<LocationPartDefinition> lazy, Lazy<ZeroLocationPartDefinition> lazy2) {
        this.f7110a = lazy;
        this.f7111b = lazy2;
    }

    public static LocationMultiRowAttachmentSelectorPartDefinition m7431a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LocationMultiRowAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7109d) {
                LocationMultiRowAttachmentSelectorPartDefinition locationMultiRowAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    locationMultiRowAttachmentSelectorPartDefinition = (LocationMultiRowAttachmentSelectorPartDefinition) a2.a(f7109d);
                } else {
                    locationMultiRowAttachmentSelectorPartDefinition = f7108c;
                }
                if (locationMultiRowAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7432b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7109d, b3);
                        } else {
                            f7108c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = locationMultiRowAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
