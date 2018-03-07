package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
/* compiled from: bundle_section */
public class SavedCollectionAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLSavedCollectionFeedUnit>, Void, FeedEnvironment> {
    private static SavedCollectionAttachmentSelectorPartDefinition f9269c;
    private static final Object f9270d = new Object();
    private final SavedCollectionSingleItemPartDefinition f9271a;
    private final SavedCollectionHScrollPartDefinition<FeedEnvironment> f9272b;

    private static SavedCollectionAttachmentSelectorPartDefinition m9902b(InjectorLike injectorLike) {
        return new SavedCollectionAttachmentSelectorPartDefinition(SavedCollectionHScrollPartDefinition.m9912a(injectorLike), SavedCollectionSingleItemPartDefinition.m9945a(injectorLike));
    }

    public final Object m9903a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f9271a, feedProps).a(this.f9272b, feedProps);
        return null;
    }

    @Inject
    public SavedCollectionAttachmentSelectorPartDefinition(SavedCollectionHScrollPartDefinition savedCollectionHScrollPartDefinition, SavedCollectionSingleItemPartDefinition savedCollectionSingleItemPartDefinition) {
        this.f9271a = savedCollectionSingleItemPartDefinition;
        this.f9272b = savedCollectionHScrollPartDefinition;
    }

    public final boolean m9904a(Object obj) {
        return true;
    }

    public static SavedCollectionAttachmentSelectorPartDefinition m9901a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9270d) {
                SavedCollectionAttachmentSelectorPartDefinition savedCollectionAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    savedCollectionAttachmentSelectorPartDefinition = (SavedCollectionAttachmentSelectorPartDefinition) a2.a(f9270d);
                } else {
                    savedCollectionAttachmentSelectorPartDefinition = f9269c;
                }
                if (savedCollectionAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9902b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9270d, b3);
                        } else {
                            f9269c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
