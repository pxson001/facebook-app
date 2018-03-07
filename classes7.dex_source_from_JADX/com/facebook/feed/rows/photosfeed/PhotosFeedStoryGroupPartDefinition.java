package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: _startLoading */
public class PhotosFeedStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLStory, Void, FeedEnvironment> {
    private static PhotosFeedStoryGroupPartDefinition f20296g;
    private static final Object f20297h = new Object();
    private final PhotosFeedStoryHeaderComponentPartDefinition<FeedEnvironment> f20298a;
    private final PhotosFeedStoryHeaderPartDefinition<FeedEnvironment> f20299b;
    private final PhotosFeedStoryTextComponentPartDefinition<FeedEnvironment> f20300c;
    private final PhotosFeedStoryTextPartDefinition<FeedEnvironment> f20301d;
    private final PhotosFeedStoryBlingBarSelectorPartDefinition<FeedEnvironment> f20302e;
    private final PhotosFeedStoryFooterSelectorPartDefinition<FeedEnvironment> f20303f;

    private static PhotosFeedStoryGroupPartDefinition m23423b(InjectorLike injectorLike) {
        return new PhotosFeedStoryGroupPartDefinition(PhotosFeedStoryHeaderComponentPartDefinition.m23427a(injectorLike), PhotosFeedStoryHeaderPartDefinition.m23434a(injectorLike), PhotosFeedStoryTextComponentPartDefinition.m23451a(injectorLike), PhotosFeedStoryTextPartDefinition.m23459a(injectorLike), PhotosFeedStoryBlingBarSelectorPartDefinition.m23408a(injectorLike), PhotosFeedStoryFooterSelectorPartDefinition.m23418a(injectorLike));
    }

    public final Object m23424a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps c = FeedProps.c((GraphQLStory) obj);
        SubPartsSelector.a(baseMultiRowSubParts, this.f20298a, c).a(this.f20299b, c);
        SubPartsSelector.a(baseMultiRowSubParts, this.f20300c, c).a(this.f20301d, c);
        baseMultiRowSubParts.a(this.f20302e, c);
        baseMultiRowSubParts.a(this.f20303f, c);
        return null;
    }

    @Inject
    public PhotosFeedStoryGroupPartDefinition(PhotosFeedStoryHeaderComponentPartDefinition photosFeedStoryHeaderComponentPartDefinition, PhotosFeedStoryHeaderPartDefinition photosFeedStoryHeaderPartDefinition, PhotosFeedStoryTextComponentPartDefinition photosFeedStoryTextComponentPartDefinition, PhotosFeedStoryTextPartDefinition photosFeedStoryTextPartDefinition, PhotosFeedStoryBlingBarSelectorPartDefinition photosFeedStoryBlingBarSelectorPartDefinition, PhotosFeedStoryFooterSelectorPartDefinition photosFeedStoryFooterSelectorPartDefinition) {
        this.f20298a = photosFeedStoryHeaderComponentPartDefinition;
        this.f20299b = photosFeedStoryHeaderPartDefinition;
        this.f20300c = photosFeedStoryTextComponentPartDefinition;
        this.f20301d = photosFeedStoryTextPartDefinition;
        this.f20302e = photosFeedStoryBlingBarSelectorPartDefinition;
        this.f20303f = photosFeedStoryFooterSelectorPartDefinition;
    }

    public final boolean m23425a(Object obj) {
        return true;
    }

    public static PhotosFeedStoryGroupPartDefinition m23422a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20297h) {
                PhotosFeedStoryGroupPartDefinition photosFeedStoryGroupPartDefinition;
                if (a2 != null) {
                    photosFeedStoryGroupPartDefinition = (PhotosFeedStoryGroupPartDefinition) a2.a(f20297h);
                } else {
                    photosFeedStoryGroupPartDefinition = f20296g;
                }
                if (photosFeedStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23423b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20297h, b3);
                        } else {
                            f20296g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
