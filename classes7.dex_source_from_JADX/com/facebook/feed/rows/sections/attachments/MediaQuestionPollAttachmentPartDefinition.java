package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLPhoto;
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
import com.facebook.text.CustomFontUtil;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZOOM */
public class MediaQuestionPollAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation, V extends View & AttachmentHasLabel & AttachmentHasLargeImage & AttachmentHasClear> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20670a = new AtomicReference();
    private static final CallerContext f20671b = CallerContext.a(MediaQuestionPollAttachmentPartDefinition.class, "newsfeed_angora_attachment_view");
    private static MediaQuestionPollAttachmentPartDefinition f20672k;
    private static final Object f20673l = new Object();
    private final Resources f20674c;
    private final CustomFontUtil f20675d;
    private final AngoraClearPartDefinition<AngoraAttachmentView> f20676e;
    private final AttachmentLabelPartDefinition<V> f20677f;
    private final FbDraweeControllerBuilder f20678g;
    private final AttachmentLinkPartDefinition<E> f20679h;
    private final AngoraAttachmentBackgroundPartDefinition f20680i;
    private final QeAccessor f20681j;

    /* compiled from: ZOOM */
    public class State {
        public DraweeController f20668a;
        public float f20669b;

        public State(DraweeController draweeController, float f) {
            this.f20668a = draweeController;
            this.f20669b = f;
        }
    }

    private static MediaQuestionPollAttachmentPartDefinition m23685b(InjectorLike injectorLike) {
        return new MediaQuestionPollAttachmentPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), CustomFontUtil.a(injectorLike), AngoraClearPartDefinition.a(injectorLike), AttachmentLabelPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23688a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object state;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20677f, new Props(m23686c(), null));
        subParts.a(this.f20680i, feedProps);
        subParts.a(this.f20679h, new AttachmentLinkPartDefinition.Props(feedProps));
        String b = (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().ez() == null || graphQLStoryAttachment.z().ez().isEmpty() || ((GraphQLPhoto) graphQLStoryAttachment.z().ez().get(0)).L() == null || ((GraphQLPhoto) graphQLStoryAttachment.z().ez().get(0)).L().a() <= 0) ? null : ((GraphQLPhoto) graphQLStoryAttachment.z().ez().get(0)).L().b();
        if (b != null) {
            state = new State(this.f20678g.a(f20671b).a(b).s(), ((float) ((GraphQLPhoto) graphQLStoryAttachment.z().ez().get(0)).L().c()) / ((float) ((GraphQLPhoto) graphQLStoryAttachment.z().ez().get(0)).L().a()));
        } else {
            state = null;
        }
        subParts.a(this.f20676e, null);
        return state;
    }

    public final /* bridge */ /* synthetic */ void m23689a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1363005577);
        m23684a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -2145877312, a);
    }

    public static MediaQuestionPollAttachmentPartDefinition m23683a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaQuestionPollAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20673l) {
                MediaQuestionPollAttachmentPartDefinition mediaQuestionPollAttachmentPartDefinition;
                if (a2 != null) {
                    mediaQuestionPollAttachmentPartDefinition = (MediaQuestionPollAttachmentPartDefinition) a2.a(f20673l);
                } else {
                    mediaQuestionPollAttachmentPartDefinition = f20672k;
                }
                if (mediaQuestionPollAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23685b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20673l, b3);
                        } else {
                            f20672k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaQuestionPollAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MediaQuestionPollAttachmentPartDefinition(Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder, CustomFontUtil customFontUtil, AngoraClearPartDefinition angoraClearPartDefinition, AttachmentLabelPartDefinition attachmentLabelPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, QeAccessor qeAccessor) {
        this.f20674c = resources;
        this.f20675d = customFontUtil;
        this.f20676e = angoraClearPartDefinition;
        this.f20677f = attachmentLabelPartDefinition;
        this.f20678g = fbDraweeControllerBuilder;
        this.f20679h = attachmentLinkPartDefinition;
        this.f20680i = angoraAttachmentBackgroundPartDefinition;
        this.f20681j = qeAccessor;
    }

    public final ViewType m23687a() {
        if (f20670a.get() == null) {
            f20670a.set(this.f20681j.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20670a.get();
    }

    public final boolean m23690a(Object obj) {
        return true;
    }

    private static void m23684a(State state, V v) {
        if (state != null && state.f20668a != null && state.f20669b > 0.0f) {
            ((AttachmentHasLargeImage) v).setLargeImageController(state.f20668a);
            ((AttachmentHasLargeImage) v).setLargeImageAspectRatio(state.f20669b);
        }
    }

    public final void m23691b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasLargeImage) view).setLargeImageController(null);
        ((AttachmentHasClear) view).a();
    }

    private Spannable m23686c() {
        Object string = this.f20674c.getString(2131233400);
        Spannable valueOf = SpannableStringBuilder.valueOf(string);
        valueOf.setSpan(CustomFontUtil.a(), 0, StringLengthHelper.a(string), 17);
        return valueOf;
    }
}
