package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentWithSubcontextPartDefinition;
import com.facebook.flatbuffers.Flattenable;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: conncls_latency_ms */
public class MultiShareSingleTextAttachmentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AttachmentHasButton & AttachmentHasClear & AttachmentHasLabel & AttachmentHasSubcontext> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E> {
    private static MultiShareSingleTextAttachmentPartDefinition f8020c;
    private static final Object f8021d = new Object();
    private final MultiShareAttachmentPartDefinition f8022a;
    private final BaseShareAttachmentWithSubcontextPartDefinition<E, V> f8023b;

    private static MultiShareSingleTextAttachmentPartDefinition m9082b(InjectorLike injectorLike) {
        return new MultiShareSingleTextAttachmentPartDefinition(MultiShareAttachmentPartDefinition.a(injectorLike), BaseShareAttachmentWithSubcontextPartDefinition.a(injectorLike));
    }

    public final Object m9083a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f8022a, feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (!graphQLStoryAttachment.x().isEmpty()) {
            baseMultiRowSubParts.a(this.f8023b, feedProps.a((Flattenable) graphQLStoryAttachment.x().get(0)));
        }
        return null;
    }

    @Inject
    public MultiShareSingleTextAttachmentPartDefinition(MultiShareAttachmentPartDefinition multiShareAttachmentPartDefinition, BaseShareAttachmentWithSubcontextPartDefinition baseShareAttachmentWithSubcontextPartDefinition) {
        this.f8022a = multiShareAttachmentPartDefinition;
        this.f8023b = baseShareAttachmentWithSubcontextPartDefinition;
    }

    public static MultiShareSingleTextAttachmentPartDefinition m9081a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareSingleTextAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8021d) {
                MultiShareSingleTextAttachmentPartDefinition multiShareSingleTextAttachmentPartDefinition;
                if (a2 != null) {
                    multiShareSingleTextAttachmentPartDefinition = (MultiShareSingleTextAttachmentPartDefinition) a2.a(f8021d);
                } else {
                    multiShareSingleTextAttachmentPartDefinition = f8020c;
                }
                if (multiShareSingleTextAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9082b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8021d, b3);
                        } else {
                            f8020c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareSingleTextAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9084a(Object obj) {
        return true;
    }
}
