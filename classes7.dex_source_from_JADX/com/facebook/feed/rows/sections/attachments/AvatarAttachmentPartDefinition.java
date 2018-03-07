package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
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
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
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
/* compiled from: [[cta]] */
public class AvatarAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f20522a = new AtomicReference();
    private static final CallerContext f20523b = CallerContext.a(AvatarAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "large_photo", "native_newsfeed");
    private static final CallerContext f20524c = CallerContext.a(AvatarAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "small_photo", "native_newsfeed");
    private static AvatarAttachmentPartDefinition f20525m;
    private static final Object f20526n = new Object();
    private final AngoraAttachmentBackgroundPartDefinition f20527d;
    private final AngoraClearPartDefinition<V> f20528e;
    private final Lazy<AvatarAttachmentUtil> f20529f;
    private final ActionButtonPartDefinition<E, V> f20530g;
    private final AttachmentLinkPartDefinition<E> f20531h;
    private final LargeImagePartDefinition<V> f20532i;
    private final SmallImagePartDefinition<V> f20533j;
    private final LegacyAngoraAttachmentUtil f20534k;
    private final QeAccessor f20535l;

    /* compiled from: [[cta]] */
    public class State {
        public final CharSequence f20520a;
        public final CharSequence f20521b;

        public State(CharSequence charSequence, CharSequence charSequence2) {
            this.f20520a = charSequence;
            this.f20521b = charSequence2;
        }
    }

    private static AvatarAttachmentPartDefinition m23589b(InjectorLike injectorLike) {
        return new AvatarAttachmentPartDefinition(AngoraAttachmentBackgroundPartDefinition.a(injectorLike), AngoraClearPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 5974), ActionButtonPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), LargeImagePartDefinition.a(injectorLike), SmallImagePartDefinition.m23741a(injectorLike), LegacyAngoraAttachmentUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m23591a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLImage L;
        GraphQLImage graphQLImage;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f20530g, feedProps);
        subParts.a(this.f20527d, feedProps);
        subParts.a(this.f20531h, new Props(feedProps));
        if (graphQLStoryAttachment.z() != null) {
            Object obj2;
            GraphQLNode z = graphQLStoryAttachment.z();
            if (z.br() == null || z.br().j() == null || z.br().j().L() == null) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                L = graphQLStoryAttachment.z().br().j().L();
                graphQLImage = L;
                if (!(graphQLImage == null || graphQLImage.b() == null || !this.f20534k.a(graphQLImage, 3.4f))) {
                    subParts.a(this.f20532i, new LargeImagePartDefinition.Props(graphQLImage, f20523b, 3.4f));
                }
                subParts.a(this.f20533j, new SmallImagePartDefinition.Props(AngoraAttachmentUtil.a(graphQLStoryAttachment), f20524c));
                subParts.a(this.f20528e, null);
                return new State(((AvatarAttachmentUtil) this.f20529f.get()).m23598a(feedProps), ((AvatarAttachmentUtil) this.f20529f.get()).m23599b(feedProps));
            }
        }
        L = null;
        graphQLImage = L;
        subParts.a(this.f20532i, new LargeImagePartDefinition.Props(graphQLImage, f20523b, 3.4f));
        subParts.a(this.f20533j, new SmallImagePartDefinition.Props(AngoraAttachmentUtil.a(graphQLStoryAttachment), f20524c));
        subParts.a(this.f20528e, null);
        return new State(((AvatarAttachmentUtil) this.f20529f.get()).m23598a(feedProps), ((AvatarAttachmentUtil) this.f20529f.get()).m23599b(feedProps));
    }

    public final /* bridge */ /* synthetic */ void m23592a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 401275985);
        m23588a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -244577049, a);
    }

    public final void m23594b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasLabel) view).setTitle(null);
        ((AttachmentHasLabel) view).setContextText(null);
    }

    public static AvatarAttachmentPartDefinition m23587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AvatarAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20526n) {
                AvatarAttachmentPartDefinition avatarAttachmentPartDefinition;
                if (a2 != null) {
                    avatarAttachmentPartDefinition = (AvatarAttachmentPartDefinition) a2.a(f20526n);
                } else {
                    avatarAttachmentPartDefinition = f20525m;
                }
                if (avatarAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23589b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20526n, b3);
                        } else {
                            f20525m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = avatarAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AvatarAttachmentPartDefinition(AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, AngoraClearPartDefinition angoraClearPartDefinition, Lazy<AvatarAttachmentUtil> lazy, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, LargeImagePartDefinition largeImagePartDefinition, SmallImagePartDefinition smallImagePartDefinition, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, QeAccessor qeAccessor) {
        this.f20527d = angoraAttachmentBackgroundPartDefinition;
        this.f20528e = angoraClearPartDefinition;
        this.f20529f = lazy;
        this.f20530g = actionButtonPartDefinition;
        this.f20531h = attachmentLinkPartDefinition;
        this.f20532i = largeImagePartDefinition;
        this.f20533j = smallImagePartDefinition;
        this.f20534k = legacyAngoraAttachmentUtil;
        this.f20535l = qeAccessor;
    }

    public final ViewType<V> m23590a() {
        if (f20522a.get() == null) {
            f20522a.set(this.f20535l.a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f20522a.get();
    }

    public final boolean m23593a(Object obj) {
        return true;
    }

    private static void m23588a(State state, V v) {
        ((AttachmentHasLabel) v).setTitle(state.f20520a);
        ((AttachmentHasLabel) v).setContextText(state.f20521b);
    }
}
