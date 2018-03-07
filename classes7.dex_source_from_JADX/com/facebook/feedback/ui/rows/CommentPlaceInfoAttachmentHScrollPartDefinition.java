package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlaceListItem;
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
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_displayed */
public class CommentPlaceInfoAttachmentHScrollPartDefinition extends MultiRowSinglePartDefinition<Props, Void, CommentsEnvironment, HScrollRecyclerView> {
    private static CommentPlaceInfoAttachmentHScrollPartDefinition f4953d;
    private static final Object f4954e = new Object();
    private final PersistentRecyclerPartDefinition<Object, CommentsEnvironment> f4955a;
    public final CommentPlaceInfoAttachmentPartDefinition f4956b;
    private final PageStyleFactory f4957c;

    /* compiled from: ridge_opt_in_displayed */
    public class Props {
        public final FeedProps<GraphQLStoryAttachment> f4951a;
        public final CommentRowPadding f4952b;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, CommentRowPadding commentRowPadding) {
            this.f4951a = feedProps;
            this.f4952b = commentRowPadding;
        }
    }

    private static CommentPlaceInfoAttachmentHScrollPartDefinition m5461b(InjectorLike injectorLike) {
        return new CommentPlaceInfoAttachmentHScrollPartDefinition(PersistentRecyclerPartDefinition.a(injectorLike), CommentPlaceInfoAttachmentPartDefinition.m5466a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m5463a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        GraphQLComment h = AttachmentProps.h(props.f4951a);
        if (h != null) {
            ImmutableList a;
            PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f4955a;
            PageStyle a2 = this.f4957c.a(300.0f, PaddingStyle.f, true);
            GraphQLNode z = ((GraphQLStoryAttachment) props.f4951a.a).z();
            final ImmutableList kJ = z.kJ();
            if (z.fu() != null) {
                a = z.fu().a();
            } else {
                a = RegularImmutableList.a;
            }
            subParts.a(persistentRecyclerPartDefinition, new com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props(a2, 0, new SimpleCallbacks<CommentsEnvironment>(this) {
                final /* synthetic */ CommentPlaceInfoAttachmentHScrollPartDefinition f4950d;

                public final void m5458a(PageSubParts<CommentsEnvironment> pageSubParts) {
                    int i;
                    int i2;
                    for (i = 0; i < kJ.size(); i++) {
                        GraphQLPage graphQLPage = (GraphQLPage) kJ.get(i);
                        if (i == 0) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        pageSubParts.a(this.f4950d.f4956b, new com.facebook.feedback.ui.rows.CommentPlaceInfoAttachmentPartDefinition.Props(props.f4951a, graphQLPage, i2, false, props.f4952b));
                    }
                    boolean isEmpty = kJ.isEmpty();
                    for (i = 0; i < a.size(); i++) {
                        GraphQLPlaceListItem graphQLPlaceListItem = (GraphQLPlaceListItem) a.get(i);
                        if (i == 0 && isEmpty) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        pageSubParts.a(this.f4950d.f4956b, new com.facebook.feedback.ui.rows.CommentPlaceInfoAttachmentPartDefinition.Props(props.f4951a, graphQLPlaceListItem.k(), i2, true, props.f4952b));
                    }
                }

                public final void m5459c(int i) {
                }
            }, h.g(), h));
        }
        return null;
    }

    @Inject
    public CommentPlaceInfoAttachmentHScrollPartDefinition(PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, CommentPlaceInfoAttachmentPartDefinition commentPlaceInfoAttachmentPartDefinition, PageStyleFactory pageStyleFactory) {
        this.f4955a = persistentRecyclerPartDefinition;
        this.f4956b = commentPlaceInfoAttachmentPartDefinition;
        this.f4957c = pageStyleFactory;
    }

    public static CommentPlaceInfoAttachmentHScrollPartDefinition m5460a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentPlaceInfoAttachmentHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4954e) {
                CommentPlaceInfoAttachmentHScrollPartDefinition commentPlaceInfoAttachmentHScrollPartDefinition;
                if (a2 != null) {
                    commentPlaceInfoAttachmentHScrollPartDefinition = (CommentPlaceInfoAttachmentHScrollPartDefinition) a2.a(f4954e);
                } else {
                    commentPlaceInfoAttachmentHScrollPartDefinition = f4953d;
                }
                if (commentPlaceInfoAttachmentHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5461b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4954e, b3);
                        } else {
                            f4953d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentPlaceInfoAttachmentHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5464a(Object obj) {
        return true;
    }

    public final ViewType<HScrollRecyclerView> m5462a() {
        return HScrollRecyclerViewRowType.a;
    }
}
