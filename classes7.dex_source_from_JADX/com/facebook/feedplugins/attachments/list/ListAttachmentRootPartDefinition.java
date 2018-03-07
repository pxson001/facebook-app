package com.facebook.feedplugins.attachments.list;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIMERS_EVENTS */
public class ListAttachmentRootPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static ListAttachmentRootPartDefinition f22628b;
    private static final Object f22629c = new Object();
    private final ListAttachmentItemPartDefinition f22630a;

    private static ListAttachmentRootPartDefinition m25292b(InjectorLike injectorLike) {
        return new ListAttachmentRootPartDefinition(ListAttachmentItemPartDefinition.m25287a(injectorLike));
    }

    public final Object m25293a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        ImmutableList x = ((GraphQLStoryAttachment) feedProps.a).x();
        int min = Math.min(x.size(), 3);
        for (int i = 0; i < min; i++) {
            baseMultiRowSubParts.a(this.f22630a, feedProps.b((GraphQLStoryAttachment) x.get(i)));
        }
        return null;
    }

    public final boolean m25294a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty()) ? false : true;
    }

    @Inject
    public ListAttachmentRootPartDefinition(ListAttachmentItemPartDefinition listAttachmentItemPartDefinition) {
        this.f22630a = listAttachmentItemPartDefinition;
    }

    public static ListAttachmentRootPartDefinition m25291a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ListAttachmentRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22629c) {
                ListAttachmentRootPartDefinition listAttachmentRootPartDefinition;
                if (a2 != null) {
                    listAttachmentRootPartDefinition = (ListAttachmentRootPartDefinition) a2.a(f22629c);
                } else {
                    listAttachmentRootPartDefinition = f22628b;
                }
                if (listAttachmentRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25292b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22629c, b3);
                        } else {
                            f22628b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = listAttachmentRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
