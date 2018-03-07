package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition$Props;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feedplugins.multishare.ui.MultiShareProductItemView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_extra_info */
public class MultiShareProductItemPartDefinition<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher> extends BaseSinglePartDefinitionWithViewType<MultiShareAttachmentItemViewModel, Void, E, MultiShareProductItemView> {
    public static final ViewType<MultiShareProductItemView> f7208a = new C03431();
    private static MultiShareProductItemPartDefinition f7209f;
    private static final Object f7210g = new Object();
    private final MultiSharePagerItemViewPartDefinition<E, MultiShareProductItemView> f7211b;
    private final MultiShareLinkUtil f7212c;
    private final ActionButtonPartDefinition<E, MultiShareProductItemView> f7213d;
    private final AttachmentLinkPartDefinition<E> f7214e;

    /* compiled from: network_extra_info */
    final class C03431 extends ViewType<MultiShareProductItemView> {
        C03431() {
        }

        public final View m7545a(Context context) {
            return new MultiShareProductItemView(context);
        }
    }

    private static MultiShareProductItemPartDefinition m7540b(InjectorLike injectorLike) {
        return new MultiShareProductItemPartDefinition(MultiSharePagerItemViewPartDefinition.m7547a(injectorLike), MultiShareLinkUtil.m7560a(injectorLike), ActionButtonPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m7542a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) obj;
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment != null) {
            subParts.a(this.f7211b, multiShareAttachmentItemViewModel);
        }
        subParts.a(this.f7213d, feedProps);
        if (this.f7212c.m7562a(graphQLStoryAttachment) || ((graphQLStoryAttachment.C() != null && (AttachmentLinkLauncher.b(Uri.parse(graphQLStoryAttachment.C())) || AttachmentLinkLauncher.a(Uri.parse(graphQLStoryAttachment.C())))) || GraphQLStoryAttachmentUtil.t(graphQLStoryAttachment) != null)) {
            subParts.a(this.f7214e, new AttachmentLinkPartDefinition$Props(feedProps));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m7543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1506869762);
        m7539a((MultiShareAttachmentItemViewModel) obj, (MultiShareProductItemView) view);
        Logger.a(8, EntryType.MARK_POP, -116636112, a);
    }

    public final void m7544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        MultiShareProductItemView multiShareProductItemView = (MultiShareProductItemView) view;
        multiShareProductItemView.setItemImageViewVisibility(false);
        multiShareProductItemView.setInlineVideoViewVisibility(false);
        multiShareProductItemView.setDescriptionTextVisibility(0);
        multiShareProductItemView.setItemFooterViewVisibility(true);
    }

    public static MultiShareProductItemPartDefinition m7538a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareProductItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7210g) {
                MultiShareProductItemPartDefinition multiShareProductItemPartDefinition;
                if (a2 != null) {
                    multiShareProductItemPartDefinition = (MultiShareProductItemPartDefinition) a2.a(f7210g);
                } else {
                    multiShareProductItemPartDefinition = f7209f;
                }
                if (multiShareProductItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7540b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7210g, b3);
                        } else {
                            f7209f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareProductItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MultiShareProductItemPartDefinition(MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition, MultiShareLinkUtil multiShareLinkUtil, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f7211b = multiSharePagerItemViewPartDefinition;
        this.f7212c = multiShareLinkUtil;
        this.f7213d = actionButtonPartDefinition;
        this.f7214e = attachmentLinkPartDefinition;
    }

    public final ViewType<MultiShareProductItemView> m7541a() {
        return f7208a;
    }

    private void m7539a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, MultiShareProductItemView multiShareProductItemView) {
        Uri uri;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a;
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) feedProps.a;
        GraphQLStory c = AttachmentProps.c(feedProps);
        int i = multiShareAttachmentItemViewModel.f13899c;
        GraphQLStoryAttachment b = MultiShareAttachmentUtil.m14783b(c);
        GraphQLStoryAttachment graphQLStoryAttachment3 = null;
        if (!(b == null || b.x() == null || i >= b.x().size())) {
            graphQLStoryAttachment3 = (GraphQLStoryAttachment) b.x().get(i);
        }
        Uri a = MultiShareAttachmentUtil.m14782a(graphQLStoryAttachment3);
        if (a != null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment2) == null) {
            uri = a;
        } else {
            uri = ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment2));
        }
        multiShareProductItemView.setItemImageViewVisibility(true);
        multiShareProductItemView.setInlineVideoViewVisibility(false);
        multiShareProductItemView.f13990a.a(uri, MultiShareAttachmentPartDefinition.f7171a);
        if (multiShareAttachmentItemViewModel.f13903g) {
            multiShareProductItemView.setItemFooterViewVisibility(false);
            return;
        }
        CharSequence a2 = graphQLStoryAttachment.n() != null ? graphQLStoryAttachment.n().a() : null;
        multiShareProductItemView.f13994e.setText(Strings.nullToEmpty(graphQLStoryAttachment.A()));
        if (multiShareAttachmentItemViewModel.f13902f) {
            multiShareProductItemView.setDescriptionTextVisibility(8);
            return;
        }
        multiShareProductItemView.setDescriptionTextVisibility(0);
        multiShareProductItemView.f13995f.setText(a2);
    }
}
