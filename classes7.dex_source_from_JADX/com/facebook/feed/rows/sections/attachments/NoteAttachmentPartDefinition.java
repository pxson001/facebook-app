package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLImage;
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
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: YourExpiredForSalePosts */
public class NoteAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AttachmentHasLabel & AttachmentHasLargeImage & AttachmentHasClear> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20716a = new AtomicReference();
    private static final CallerContext f20717b = CallerContext.a(NoteAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "large_photo", "native_newsfeed");
    private static NoteAttachmentPartDefinition f20718k;
    private static final Object f20719l = new Object();
    private final CustomFontUtil f20720c;
    private final LegacyAngoraAttachmentUtil f20721d;
    private final AngoraClearPartDefinition<V> f20722e;
    private final AttachmentLabelPartDefinition<V> f20723f;
    private final AttachmentLinkPartDefinition<E> f20724g;
    private final AngoraAttachmentBackgroundPartDefinition f20725h;
    private final LargeImagePartDefinition<V> f20726i;
    private final QeAccessor f20727j;

    private static NoteAttachmentPartDefinition m23719b(InjectorLike injectorLike) {
        return new NoteAttachmentPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), CustomFontUtil.a(injectorLike), AngoraClearPartDefinition.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), LargeImagePartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23721a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SpannableStringBuilder valueOf;
        GraphQLImage T;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        AttachmentLabelPartDefinition attachmentLabelPartDefinition = this.f20723f;
        CharSequence b = m23718b(graphQLStoryAttachment);
        if (graphQLStoryAttachment.n() != null) {
            valueOf = SpannableStringBuilder.valueOf(graphQLStoryAttachment.n().a());
        } else {
            valueOf = null;
        }
        subParts.a(attachmentLabelPartDefinition, new Props(b, valueOf));
        subParts.a(this.f20725h, feedProps);
        subParts.a(this.f20724g, new AttachmentLinkPartDefinition.Props(feedProps));
        if (graphQLStoryAttachment.r() != null) {
            T = graphQLStoryAttachment.r().T();
        } else {
            T = null;
        }
        GraphQLImage graphQLImage = T;
        if (!(graphQLImage == null || graphQLImage.b() == null || !this.f20721d.a(graphQLImage, 1.9318181f))) {
            subParts.a(this.f20726i, new LargeImagePartDefinition.Props(graphQLImage, f20717b, 1.9318181f));
        }
        subParts.a(this.f20722e, null);
        return null;
    }

    public static NoteAttachmentPartDefinition m23717a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NoteAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20719l) {
                NoteAttachmentPartDefinition noteAttachmentPartDefinition;
                if (a2 != null) {
                    noteAttachmentPartDefinition = (NoteAttachmentPartDefinition) a2.a(f20719l);
                } else {
                    noteAttachmentPartDefinition = f20718k;
                }
                if (noteAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23719b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20719l, b3);
                        } else {
                            f20718k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = noteAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NoteAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, CustomFontUtil customFontUtil, AngoraClearPartDefinition angoraClearPartDefinition, AttachmentLabelPartDefinition attachmentLabelPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, LargeImagePartDefinition largeImagePartDefinition, QeAccessor qeAccessor) {
        this.f20721d = legacyAngoraAttachmentUtil;
        this.f20720c = customFontUtil;
        this.f20722e = angoraClearPartDefinition;
        this.f20723f = attachmentLabelPartDefinition;
        this.f20724g = attachmentLinkPartDefinition;
        this.f20725h = angoraAttachmentBackgroundPartDefinition;
        this.f20726i = largeImagePartDefinition;
        this.f20727j = qeAccessor;
    }

    public final ViewType m23720a() {
        if (f20716a.get() == null) {
            f20716a.set(this.f20727j.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20716a.get();
    }

    public final boolean m23722a(Object obj) {
        return true;
    }

    private Spannable m23718b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (Strings.isNullOrEmpty(graphQLStoryAttachment.A())) {
            return SpannableStringBuilder.valueOf("");
        }
        Spannable valueOf = SpannableStringBuilder.valueOf(graphQLStoryAttachment.A());
        valueOf.setSpan(CustomFontUtil.a(), 0, graphQLStoryAttachment.A().length(), 17);
        return valueOf;
    }
}
