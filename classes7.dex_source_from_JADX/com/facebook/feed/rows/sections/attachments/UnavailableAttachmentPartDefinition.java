package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.UnavailableAttachmentView;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
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
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: WRONG_USER */
public class UnavailableAttachmentPartDefinition<V extends View & AttachmentHasLabel & AttachmentHasClear> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20856a = new AtomicReference();
    private static UnavailableAttachmentPartDefinition f20857f;
    private static final Object f20858g = new Object();
    private final CustomFontUtil f20859b;
    private final AttachmentLabelPartDefinition<V> f20860c;
    private final AngoraAttachmentBackgroundPartDefinition f20861d;
    private final QeAccessor f20862e;

    private static UnavailableAttachmentPartDefinition m23805b(InjectorLike injectorLike) {
        return new UnavailableAttachmentPartDefinition(CustomFontUtil.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23807a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        AttachmentLabelPartDefinition attachmentLabelPartDefinition = this.f20860c;
        Object A = graphQLStoryAttachment.A();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!Strings.isNullOrEmpty(A)) {
            spannableStringBuilder.append(A);
            spannableStringBuilder.setSpan(CustomFontUtil.a(), 0, A.length(), 17);
        }
        subParts.a(attachmentLabelPartDefinition, new Props(spannableStringBuilder, GraphQLStoryAttachmentUtil.s(graphQLStoryAttachment)));
        subParts.a(this.f20861d, feedProps);
        return null;
    }

    @Inject
    public UnavailableAttachmentPartDefinition(CustomFontUtil customFontUtil, AttachmentLabelPartDefinition attachmentLabelPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, QeAccessor qeAccessor) {
        this.f20859b = customFontUtil;
        this.f20860c = attachmentLabelPartDefinition;
        this.f20861d = angoraAttachmentBackgroundPartDefinition;
        this.f20862e = qeAccessor;
    }

    public static UnavailableAttachmentPartDefinition m23804a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnavailableAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20858g) {
                UnavailableAttachmentPartDefinition unavailableAttachmentPartDefinition;
                if (a2 != null) {
                    unavailableAttachmentPartDefinition = (UnavailableAttachmentPartDefinition) a2.a(f20858g);
                } else {
                    unavailableAttachmentPartDefinition = f20857f;
                }
                if (unavailableAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23805b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20858g, b3);
                        } else {
                            f20857f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = unavailableAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23806a() {
        if (f20856a.get() == null) {
            f20856a.set(this.f20862e.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : UnavailableAttachmentView.f21108a);
        }
        return (ViewType) f20856a.get();
    }

    public final boolean m23808a(Object obj) {
        return true;
    }

    public final void m23809b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).a();
    }
}
