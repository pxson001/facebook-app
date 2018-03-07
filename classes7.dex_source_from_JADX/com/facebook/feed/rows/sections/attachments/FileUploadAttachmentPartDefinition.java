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
/* compiled from: Zero header request not sent because status is  */
public class FileUploadAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState, V extends View & AttachmentHasLabel & AttachmentHasClear> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20588a = new AtomicReference();
    private static FileUploadAttachmentPartDefinition f20589d;
    private static final Object f20590e = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f20591b;
    private final QeAccessor f20592c;

    private static FileUploadAttachmentPartDefinition m23632b(InjectorLike injectorLike) {
        return new FileUploadAttachmentPartDefinition(BaseShareAttachmentPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23634a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f20591b, (FeedProps) obj);
        return null;
    }

    @Inject
    public FileUploadAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, QeAccessor qeAccessor) {
        this.f20591b = baseShareAttachmentPartDefinition;
        this.f20592c = qeAccessor;
    }

    public final ViewType<V> m23633a() {
        if (f20588a.get() == null) {
            f20588a.set(this.f20592c.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20588a.get();
    }

    public static FileUploadAttachmentPartDefinition m23631a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FileUploadAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20590e) {
                FileUploadAttachmentPartDefinition fileUploadAttachmentPartDefinition;
                if (a2 != null) {
                    fileUploadAttachmentPartDefinition = (FileUploadAttachmentPartDefinition) a2.a(f20590e);
                } else {
                    fileUploadAttachmentPartDefinition = f20589d;
                }
                if (fileUploadAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23632b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20590e, b3);
                        } else {
                            f20589d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fileUploadAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23635a(Object obj) {
        return true;
    }
}
