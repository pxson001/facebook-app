package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition$Props;
import com.facebook.feedplugins.multishare.ui.MultiShareEndItemView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: net_state */
public class MultiShareEndItemPartDefinition<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher> extends BaseSinglePartDefinitionWithViewType<MultiShareAttachmentItemViewModel, Uri, E, MultiShareEndItemView> {
    public static final CallerContext f7237a = CallerContext.a(MultiShareEndItemPartDefinition.class, "native_newsfeed");
    public static final ViewType<MultiShareEndItemView> f7238b = new C03441();
    private static MultiShareEndItemPartDefinition f7239e;
    private static final Object f7240f = new Object();
    private final MultiSharePagerItemViewPartDefinition<E, MultiShareEndItemView> f7241c;
    private final AttachmentLinkPartDefinition<E> f7242d;

    /* compiled from: net_state */
    final class C03441 extends ViewType<MultiShareEndItemView> {
        C03441() {
        }

        public final View m7568a(Context context) {
            return new MultiShareEndItemView(context);
        }
    }

    private static MultiShareEndItemPartDefinition m7564b(InjectorLike injectorLike) {
        return new MultiShareEndItemPartDefinition(MultiSharePagerItemViewPartDefinition.m7547a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m7566a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) obj;
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        if (feedProps == null) {
            return null;
        }
        Uri uri;
        subParts.a(this.f7242d, new AttachmentLinkPartDefinition$Props(feedProps));
        subParts.a(this.f7241c, multiShareAttachmentItemViewModel);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        Uri a = MultiShareAttachmentUtil.m14782a(MultiShareAttachmentUtil.m14783b(AttachmentProps.c(feedProps)));
        if (a != null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null) {
            uri = a;
        } else {
            uri = ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment));
        }
        return uri;
    }

    public final /* bridge */ /* synthetic */ void m7567a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1828957713);
        MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) obj;
        MultiShareEndItemView multiShareEndItemView = (MultiShareEndItemView) view;
        multiShareEndItemView.a.a((Uri) obj2, f7237a);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a;
        if (graphQLStoryAttachment.u() != null) {
            multiShareEndItemView.c.setText(graphQLStoryAttachment.u().a());
        }
        Logger.a(8, EntryType.MARK_POP, 601693465, a);
    }

    @Inject
    public MultiShareEndItemPartDefinition(MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f7241c = multiSharePagerItemViewPartDefinition;
        this.f7242d = attachmentLinkPartDefinition;
    }

    public static MultiShareEndItemPartDefinition m7563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareEndItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7240f) {
                MultiShareEndItemPartDefinition multiShareEndItemPartDefinition;
                if (a2 != null) {
                    multiShareEndItemPartDefinition = (MultiShareEndItemPartDefinition) a2.a(f7240f);
                } else {
                    multiShareEndItemPartDefinition = f7239e;
                }
                if (multiShareEndItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7564b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7240f, b3);
                        } else {
                            f7239e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareEndItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<MultiShareEndItemView> m7565a() {
        return f7238b;
    }
}
