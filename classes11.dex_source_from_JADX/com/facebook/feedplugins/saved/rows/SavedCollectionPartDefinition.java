package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
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
/* compiled from: bundle_friend_view_fetch */
public class SavedCollectionPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLSavedCollectionFeedUnit>, Void, FeedEnvironment> {
    private static SavedCollectionPartDefinition f9330d;
    private static final Object f9331e = new Object();
    private final SavedCollectionHeaderPartDefinition<FeedEnvironment> f9332a;
    private final SavedCollectionAttachmentSelectorPartDefinition f9333b;
    private final SavedCollectionFooterPartDefinition f9334c;

    private static SavedCollectionPartDefinition m9942b(InjectorLike injectorLike) {
        return new SavedCollectionPartDefinition(SavedCollectionHeaderPartDefinition.m9917a(injectorLike), SavedCollectionAttachmentSelectorPartDefinition.m9901a(injectorLike), SavedCollectionFooterPartDefinition.m9905a(injectorLike));
    }

    public final Object m9943a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f9332a, feedProps);
        baseMultiRowSubParts.a(this.f9333b, feedProps);
        baseMultiRowSubParts.a(this.f9334c, graphQLSavedCollectionFeedUnit);
        return null;
    }

    @Inject
    public SavedCollectionPartDefinition(SavedCollectionHeaderPartDefinition savedCollectionHeaderPartDefinition, SavedCollectionAttachmentSelectorPartDefinition savedCollectionAttachmentSelectorPartDefinition, SavedCollectionFooterPartDefinition savedCollectionFooterPartDefinition) {
        this.f9332a = savedCollectionHeaderPartDefinition;
        this.f9333b = savedCollectionAttachmentSelectorPartDefinition;
        this.f9334c = savedCollectionFooterPartDefinition;
    }

    public final boolean m9944a(Object obj) {
        return true;
    }

    public static SavedCollectionPartDefinition m9941a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9331e) {
                SavedCollectionPartDefinition savedCollectionPartDefinition;
                if (a2 != null) {
                    savedCollectionPartDefinition = (SavedCollectionPartDefinition) a2.a(f9331e);
                } else {
                    savedCollectionPartDefinition = f9330d;
                }
                if (savedCollectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9942b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9331e, b3);
                        } else {
                            f9330d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
