package com.facebook.timeline.publisher.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
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
import com.facebook.timeline.environment.TimelineEnvironment;
import com.facebook.timeline.feed.parts.TimelinePostsLabelPartDefinition;
import com.facebook.timeline.publisher.TimelinePublisherBarModel;
import com.facebook.timeline.units.model.TimelineSectionData.TimelinePostsLabel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: failed to get inviter short name */
public class PublisherRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, TimelineEnvironment> {
    private static PublisherRootGroupPartDefinition f12446b;
    private static final Object f12447c = new Object();
    private final RootPartSelector<TimelineEnvironment> f12448a;

    private static PublisherRootGroupPartDefinition m12483b(InjectorLike injectorLike) {
        return new PublisherRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 11240), IdBasedLazy.a(injectorLike, 11348), IdBasedLazy.a(injectorLike, 6023));
    }

    @Inject
    public PublisherRootGroupPartDefinition(Lazy<TimelinePostsLabelPartDefinition> lazy, Lazy<OpenPublisherBarWithStatusButtonsPartDefinition> lazy2, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy3) {
        this.f12448a = RootPartSelector.a().a(TimelinePostsLabel.class, lazy).a(TimelinePublisherBarModel.class, lazy2).a(Object.class, lazy3);
    }

    public final boolean m12485a(Object obj) {
        return true;
    }

    public final Object m12484a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f12448a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static PublisherRootGroupPartDefinition m12482a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PublisherRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12447c) {
                PublisherRootGroupPartDefinition publisherRootGroupPartDefinition;
                if (a2 != null) {
                    publisherRootGroupPartDefinition = (PublisherRootGroupPartDefinition) a2.a(f12447c);
                } else {
                    publisherRootGroupPartDefinition = f12446b;
                }
                if (publisherRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12483b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12447c, b3);
                        } else {
                            f12446b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = publisherRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
