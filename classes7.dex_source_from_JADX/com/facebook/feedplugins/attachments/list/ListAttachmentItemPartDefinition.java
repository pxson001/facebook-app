package com.facebook.feedplugins.attachments.list;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.attachments.AttachmentStyleMap;
import com.facebook.feed.rows.attachments.AttachmentStyleMapImpl;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIME_SINCE_STORY */
public class ListAttachmentItemPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static ListAttachmentItemPartDefinition f22625b;
    private static final Object f22626c = new Object();
    private AttachmentStyleMap f22627a;

    private static ListAttachmentItemPartDefinition m25288b(InjectorLike injectorLike) {
        return new ListAttachmentItemPartDefinition((AttachmentStyleMap) AttachmentStyleMapImpl.a(injectorLike));
    }

    public final Object m25289a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        ImmutableList w = ((GraphQLStoryAttachment) feedProps.a).w();
        int size = w.size();
        for (int i = 0; i < size; i++) {
            MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) this.f22627a.a((GraphQLStoryAttachmentStyle) w.get(i));
            if (multiRowPartWithIsNeeded != null) {
                baseMultiRowSubParts.a(multiRowPartWithIsNeeded, feedProps);
                break;
            }
        }
        return null;
    }

    public final boolean m25290a(Object obj) {
        return ((GraphQLStoryAttachment) ((FeedProps) obj).a) != null;
    }

    @Inject
    public ListAttachmentItemPartDefinition(AttachmentStyleMap attachmentStyleMap) {
        this.f22627a = attachmentStyleMap;
    }

    public static ListAttachmentItemPartDefinition m25287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ListAttachmentItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22626c) {
                ListAttachmentItemPartDefinition listAttachmentItemPartDefinition;
                if (a2 != null) {
                    listAttachmentItemPartDefinition = (ListAttachmentItemPartDefinition) a2.a(f22626c);
                } else {
                    listAttachmentItemPartDefinition = f22625b;
                }
                if (listAttachmentItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22626c, b3);
                        } else {
                            f22625b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = listAttachmentItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
