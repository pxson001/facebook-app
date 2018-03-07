package com.facebook.video.watchandshop;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLVideoAnnotation;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: shouldTraceFetch */
public class WatchAndShopProductItemPagerController<E extends HasFeedListType & HasPersistentState & HasContext> {
    private static WatchAndShopProductItemPagerController f3448f;
    private static final Object f3449g = new Object();
    private final PageStyleFactory f3450a;
    private final PersistentRecyclerPartDefinition f3451b;
    public final WatchAndShopProductItemPartDefinition f3452c;
    public ViewGroup f3453d;
    public HScrollRecyclerView f3454e;

    private static WatchAndShopProductItemPagerController m3266b(InjectorLike injectorLike) {
        return new WatchAndShopProductItemPagerController(PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), WatchAndShopProductItemPartDefinition.m3269a(injectorLike));
    }

    @Inject
    public WatchAndShopProductItemPagerController(PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, WatchAndShopProductItemPartDefinition watchAndShopProductItemPartDefinition) {
        this.f3450a = pageStyleFactory;
        this.f3451b = persistentRecyclerPartDefinition;
        this.f3452c = watchAndShopProductItemPartDefinition;
    }

    public final void m3267a(FeedProps<GraphQLStory> feedProps, E e) {
        if (this.f3453d != null && feedProps != null && feedProps.a != null) {
            this.f3454e = (HScrollRecyclerView) this.f3453d.findViewById(2131568514);
            float c = ((float) SizeUtil.c(((HasContext) e).getContext(), ((HasContext) e).getContext().getResources().getDimension(2131432936))) * 2.0f;
            PageStyle a = this.f3450a.a(((float) ((int) (c + ((float) SizeUtil.c(((HasContext) e).getContext(), ((HasContext) e).getContext().getResources().getDimension(2131432937)))))) + 8.0f, PageStyle.a, true);
            Callbacks a2 = m3264a((FeedProps) feedProps);
            if (a2 != null) {
                Props props = new Props(a, 0, a2, ((GraphQLStory) feedProps.a).g(), (CacheableEntity) feedProps.a);
                if (e instanceof HasRowKey) {
                    ((HasRowKey) e).a(new RowKey());
                }
                this.f3451b.a(props, this.f3451b.a(props, (HasPersistentState) e), this.f3454e);
            }
        }
    }

    public static WatchAndShopProductItemPagerController m3265a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WatchAndShopProductItemPagerController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3449g) {
                WatchAndShopProductItemPagerController watchAndShopProductItemPagerController;
                if (a2 != null) {
                    watchAndShopProductItemPagerController = (WatchAndShopProductItemPagerController) a2.a(f3449g);
                } else {
                    watchAndShopProductItemPagerController = f3448f;
                }
                if (watchAndShopProductItemPagerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3266b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3449g, b3);
                        } else {
                            f3448f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = watchAndShopProductItemPagerController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private Callbacks m3264a(FeedProps<GraphQLStory> feedProps) {
        ImmutableList immutableList;
        int i = 0;
        if (StoryAttachmentHelper.o((GraphQLStory) feedProps.a) == null) {
            immutableList = null;
        } else {
            GraphQLStoryActionLink e = StoryActionLinkHelper.e((GraphQLStory) feedProps.a);
            if (e == null || e.aI() == null) {
                immutableList = null;
            } else {
                Builder builder = ImmutableList.builder();
                ImmutableList aI = e.aI();
                int size = aI.size();
                for (int i2 = 0; i2 < size; i2++) {
                    builder.c(new WatchAndShopProductItemViewModel(FeedProps.c((GraphQLVideoAnnotation) aI.get(i2)), AttachmentProps.a((GraphQLStory) feedProps.a), i));
                    i++;
                }
                immutableList = builder.b();
            }
        }
        final ImmutableList immutableList2 = immutableList;
        if (immutableList2 == null) {
            return null;
        }
        return new SimpleCallbacks(this) {
            final /* synthetic */ WatchAndShopProductItemPagerController f3447b;

            public final void m3262a(SimpleCallbacks simpleCallbacks) {
                int size = immutableList2.size();
                for (int i = 0; i < size; i++) {
                    simpleCallbacks.a(this.f3447b.f3452c, (WatchAndShopProductItemViewModel) immutableList2.get(i));
                }
            }

            public final void m3263c(int i) {
            }
        };
    }
}
