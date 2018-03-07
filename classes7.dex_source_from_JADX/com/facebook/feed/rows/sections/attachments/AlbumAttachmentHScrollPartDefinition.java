package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.VisibleItemHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: [createActor] Invalid actorId */
public class AlbumAttachmentHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, HScrollRecyclerView> {
    private static final PaddingStyle f20481a = PageStyle.a;
    private static AlbumAttachmentHScrollPartDefinition f20482h;
    private static final Object f20483i = new Object();
    private final Context f20484b;
    private final PersistentRecyclerPartDefinition<Object, E> f20485c;
    public final AlbumAttachmentPagePartDefinition f20486d;
    private final BackgroundPartDefinition f20487e;
    private final FeedImageLoader f20488f;
    private final PageStyleFactory f20489g;

    private static AlbumAttachmentHScrollPartDefinition m23568b(InjectorLike injectorLike) {
        return new AlbumAttachmentHScrollPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), AlbumAttachmentPagePartDefinition.a(injectorLike), FeedImageLoader.a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m23570a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        float c = (float) SizeUtil.c(this.f20484b, (float) this.f20488f.a(FeedImageType.Album));
        GraphQLStory c2 = AttachmentProps.c(feedProps);
        subParts.a(this.f20487e, new StylingData(null, f20481a));
        subParts.a(this.f20485c, new Props(this.f20489g.a(c + 8.0f, f20481a, true), c2.ac_(), new SimpleCallbacks<E>(this) {
            final /* synthetic */ AlbumAttachmentHScrollPartDefinition f20480b;

            public final void m23566c(int i) {
                VisibleItemHelper.a(AttachmentProps.c(feedProps), i);
            }

            public final void m23565a(PageSubParts<E> pageSubParts) {
                ImmutableList x = ((GraphQLStoryAttachment) feedProps.a).x();
                int size = x.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f20480b.f20486d, feedProps.a((GraphQLStoryAttachment) x.get(i)));
                }
            }
        }, StoryKeyUtil.a(c2), c2));
        return null;
    }

    @Inject
    public AlbumAttachmentHScrollPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, AlbumAttachmentPagePartDefinition albumAttachmentPagePartDefinition, FeedImageLoader feedImageLoader, PageStyleFactory pageStyleFactory) {
        this.f20484b = context;
        this.f20485c = persistentRecyclerPartDefinition;
        this.f20486d = albumAttachmentPagePartDefinition;
        this.f20487e = backgroundPartDefinition;
        this.f20488f = feedImageLoader;
        this.f20489g = pageStyleFactory;
    }

    public static AlbumAttachmentHScrollPartDefinition m23567a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumAttachmentHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20483i) {
                AlbumAttachmentHScrollPartDefinition albumAttachmentHScrollPartDefinition;
                if (a2 != null) {
                    albumAttachmentHScrollPartDefinition = (AlbumAttachmentHScrollPartDefinition) a2.a(f20483i);
                } else {
                    albumAttachmentHScrollPartDefinition = f20482h;
                }
                if (albumAttachmentHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23568b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20483i, b3);
                        } else {
                            f20482h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = albumAttachmentHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23569a() {
        return HScrollRecyclerViewRowType.a;
    }

    public final boolean m23571a(Object obj) {
        return true;
    }
}
