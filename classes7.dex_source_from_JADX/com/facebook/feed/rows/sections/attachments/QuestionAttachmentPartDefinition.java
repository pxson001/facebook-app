package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: YOU_CAN_STILL_POST */
public class QuestionAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState, V extends View & AttachmentHasLabel & AttachmentHasClear> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20742a = new AtomicReference();
    private static QuestionAttachmentPartDefinition f20743d;
    private static final Object f20744e = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f20745b;
    private final QeAccessor f20746c;

    private static QuestionAttachmentPartDefinition m23728b(InjectorLike injectorLike) {
        return new QuestionAttachmentPartDefinition(BaseShareAttachmentPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23730a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f20745b, (FeedProps) obj);
        return null;
    }

    @Inject
    public QuestionAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, QeAccessor qeAccessor) {
        this.f20745b = baseShareAttachmentPartDefinition;
        this.f20746c = qeAccessor;
    }

    public final ViewType<V> m23729a() {
        if (f20742a.get() == null) {
            f20742a.set(this.f20746c.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20742a.get();
    }

    public static QuestionAttachmentPartDefinition m23727a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuestionAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20744e) {
                QuestionAttachmentPartDefinition questionAttachmentPartDefinition;
                if (a2 != null) {
                    questionAttachmentPartDefinition = (QuestionAttachmentPartDefinition) a2.a(f20744e);
                } else {
                    questionAttachmentPartDefinition = f20743d;
                }
                if (questionAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23728b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20744e, b3);
                        } else {
                            f20743d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = questionAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23731a(Object obj) {
        return true;
    }
}
