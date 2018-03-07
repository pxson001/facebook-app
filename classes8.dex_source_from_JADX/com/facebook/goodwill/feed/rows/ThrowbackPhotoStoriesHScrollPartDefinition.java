package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackMissedMemoriesStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
/* compiled from: fb4a_draft_dialog_back_clicked */
public class ThrowbackPhotoStoriesHScrollPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackMissedMemoriesStory>, Void, E, HScrollRecyclerView> {
    private static final PaddingStyle f13766a;
    private static ThrowbackPhotoStoriesHScrollPartDefinition f13767h;
    private static final Object f13768i = new Object();
    private final Context f13769b;
    private final PersistentRecyclerPartDefinition<Object, E> f13770c;
    public final ThrowbackPhotoAttachmentPagePartDefinition f13771d;
    private final BackgroundPartDefinition f13772e;
    private final PageStyleFactory f13773f;
    private final Resources f13774g;

    private static ThrowbackPhotoStoriesHScrollPartDefinition m15433b(InjectorLike injectorLike) {
        return new ThrowbackPhotoStoriesHScrollPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ThrowbackPhotoAttachmentPagePartDefinition.m15424a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m15435a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        float c = (float) SizeUtil.c(this.f13769b, (float) this.f13774g.getDimensionPixelSize(2131433123));
        subParts.a(this.f13772e, new StylingData(null, f13766a));
        subParts.a(this.f13770c, new Props(this.f13773f.a(c + 8.0f, f13766a, true), 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ ThrowbackPhotoStoriesHScrollPartDefinition f13765b;

            public final void m15431c(int i) {
            }

            public final void m15430a(PageSubParts<E> pageSubParts) {
                ImmutableList b = ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStory graphQLStory = (GraphQLStory) b.get(i);
                    FeedProps a = feedProps.a(graphQLStory);
                    GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                    if (!(o == null || o.r() == null)) {
                        pageSubParts.a(this.f13765b.f13771d, a);
                    }
                }
            }
        }, ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).g(), (CacheableEntity) feedProps.a));
        return null;
    }

    public final boolean m15436a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null || ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b() == null || ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b().isEmpty()) {
            return false;
        }
        ImmutableList b = ((GraphQLGoodwillThrowbackMissedMemoriesStory) feedProps.a).b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) b.get(i));
            if (o != null && o.r() != null) {
                return true;
            }
        }
        return false;
    }

    static {
        Builder a = Builder.a();
        a.d = -4.0f;
        a = a;
        a.c = 12.0f;
        f13766a = a.i();
    }

    public static ThrowbackPhotoStoriesHScrollPartDefinition m15432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPhotoStoriesHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13768i) {
                ThrowbackPhotoStoriesHScrollPartDefinition throwbackPhotoStoriesHScrollPartDefinition;
                if (a2 != null) {
                    throwbackPhotoStoriesHScrollPartDefinition = (ThrowbackPhotoStoriesHScrollPartDefinition) a2.a(f13768i);
                } else {
                    throwbackPhotoStoriesHScrollPartDefinition = f13767h;
                }
                if (throwbackPhotoStoriesHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15433b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13768i, b3);
                        } else {
                            f13767h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPhotoStoriesHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackPhotoStoriesHScrollPartDefinition(Resources resources, Context context, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ThrowbackPhotoAttachmentPagePartDefinition throwbackPhotoAttachmentPagePartDefinition, PageStyleFactory pageStyleFactory) {
        this.f13774g = resources;
        this.f13769b = context;
        this.f13770c = persistentRecyclerPartDefinition;
        this.f13771d = throwbackPhotoAttachmentPagePartDefinition;
        this.f13772e = backgroundPartDefinition;
        this.f13773f = pageStyleFactory;
    }

    public final ViewType m15434a() {
        return HScrollRecyclerViewRowType.a;
    }
}
