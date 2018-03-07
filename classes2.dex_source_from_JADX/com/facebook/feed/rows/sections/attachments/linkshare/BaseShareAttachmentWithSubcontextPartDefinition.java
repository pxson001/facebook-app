package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentWithSubcontextView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_initial_recommended_pages */
public class BaseShareAttachmentWithSubcontextPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState, V extends View & AttachmentHasLabel & AttachmentHasClear & AttachmentHasSubcontext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, String, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24058a = new AtomicReference();
    private static BaseShareAttachmentWithSubcontextPartDefinition f24059e;
    private static final Object f24060f = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f24061b;
    private final Resources f24062c;
    private final QeAccessor f24063d;

    private static BaseShareAttachmentWithSubcontextPartDefinition m32446b(InjectorLike injectorLike) {
        return new BaseShareAttachmentWithSubcontextPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24061b, feedProps);
        return CallToActionUtil.m32466m((GraphQLStoryAttachment) feedProps.f13444a) ? CallToActionUtil.m32454a(this.f24062c) : null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 778865715);
        m32445a((String) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1784232310, a);
    }

    @Inject
    public BaseShareAttachmentWithSubcontextPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, Resources resources, QeAccessor qeAccessor) {
        this.f24061b = baseShareAttachmentPartDefinition;
        this.f24062c = resources;
        this.f24063d = qeAccessor;
    }

    public final ViewType<V> mo2547a() {
        if (f24058a.get() == null) {
            f24058a.set(this.f24063d.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentWithSubcontextView.c);
        }
        return (ViewType) f24058a.get();
    }

    public static BaseShareAttachmentWithSubcontextPartDefinition m32444a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseShareAttachmentWithSubcontextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24060f) {
                BaseShareAttachmentWithSubcontextPartDefinition baseShareAttachmentWithSubcontextPartDefinition;
                if (a2 != null) {
                    baseShareAttachmentWithSubcontextPartDefinition = (BaseShareAttachmentWithSubcontextPartDefinition) a2.mo818a(f24060f);
                } else {
                    baseShareAttachmentWithSubcontextPartDefinition = f24059e;
                }
                if (baseShareAttachmentWithSubcontextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32446b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24060f, b3);
                        } else {
                            f24059e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseShareAttachmentWithSubcontextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final /* synthetic */ boolean m32450a(Object obj) {
        return true;
    }

    private static void m32445a(String str, V v) {
        ((AttachmentHasSubcontext) v).setSubcontextText(str);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasSubcontext) view).setSubcontextText(null);
        ((AttachmentHasClear) view).a();
    }
}
