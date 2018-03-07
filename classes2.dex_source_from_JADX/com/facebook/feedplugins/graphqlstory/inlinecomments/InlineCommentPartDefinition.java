package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FeedStoryMessageFlyoutClickWithPositionListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
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
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListenerBinder;
import com.facebook.ui.emoji.EmojiUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: index.bin.tmp */
public class InlineCommentPartDefinition<E extends HasPersistentState & HasRowKey & HasPrefetcher> extends MultiRowSinglePartDefinition<InlineCommentData, State, E, InlineCommentView> {
    public static final ViewType f20211a = new C08181();
    public static final CallerContext f20212b = CallerContext.m9061a(InlineCommentPartDefinition.class, "native_newsfeed");
    private static InlineCommentPartDefinition f20213h;
    private static final Object f20214i = new Object();
    private final Context f20215c;
    private final LinkifyUtil f20216d;
    private final EmojiUtil f20217e;
    private final Provider<FeedStoryMessageFlyoutClickWithPositionListener> f20218f;
    public final QeAccessor f20219g;

    /* compiled from: index.bin.tmp */
    final class C08181 extends ViewType {
        C08181() {
        }

        public final View mo1995a(Context context) {
            return new InlineCommentView(context);
        }
    }

    private static InlineCommentPartDefinition m27870b(InjectorLike injectorLike) {
        return new InlineCommentPartDefinition((Context) injectorLike.getInstance(Context.class), LinkifyUtil.m26532a(injectorLike), EmojiUtil.m27878a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1733), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence a;
        CharSequence spannableStringBuilder;
        InlineCommentData inlineCommentData = (InlineCommentData) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        Uri uri = null;
        if (GraphQLCommentHelper.m29313i(inlineCommentData.f21611b)) {
            String a2 = inlineCommentData.f21611b.m27186s().mo2911a();
            a = GraphQLCommentHelper.m29307a(inlineCommentData.f21611b);
            spannableStringBuilder = new SpannableStringBuilder(a2);
            this.f20217e.m27887a((Editable) spannableStringBuilder, this.f20215c.getResources().getDimensionPixelSize(2131427402));
        } else {
            spannableStringBuilder = new SpannableStringBuilder(inlineCommentData.f21612c.d);
            a = null;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        OnClickListener a3 = m27866a(spannableStringBuilder, atomicBoolean);
        ClickWithPositionListenerBinder a4 = m27868a(inlineCommentData.f21610a, inlineCommentData.f21611b);
        CharSequence a5 = m27869a(inlineCommentData.f21611b, (GraphQLStory) inlineCommentData.f21610a.m19804a());
        CharSequence a6 = this.f20216d.m26555a(spannableStringBuilder, a3, 90, this.f20215c.getResources().getString(2131233416));
        if (a6 == null) {
            a6 = spannableStringBuilder;
        }
        if (inlineCommentData.f21611b.m27185r().ai() != null) {
            uri = Uri.parse(inlineCommentData.f21611b.m27185r().ai().mo2924b());
            if (((HasRowKey) hasPersistentState).mo2461o()) {
                ((HasPrefetcher) hasPersistentState).mo2434a(ImageRequest.m18795a(uri), f20212b);
            }
        }
        return new State(a, a5, a6, spannableStringBuilder, uri, atomicBoolean, a3, a4);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -933478170);
        InlineCommentData inlineCommentData = (InlineCommentData) obj;
        State state = (State) obj2;
        InlineCommentView inlineCommentView = (InlineCommentView) view;
        if (this.f20219g.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6714d, false)) {
            if (InlineCommentView.g(inlineCommentView)) {
                inlineCommentView.n.setTextLayout(inlineCommentView.o.m28610e(1).m28608d());
            } else {
                inlineCommentView.m.setMaxLines(1);
            }
        }
        CharSequence charSequence = state.a;
        if (charSequence == null) {
            inlineCommentView.l.setVisibility(8);
        } else {
            inlineCommentView.l.setVisibility(0);
            inlineCommentView.l.setText(charSequence);
        }
        inlineCommentView.l.setBadgeText(state.b);
        inlineCommentView.setBodyText(state.f.get() ? state.d : state.c);
        if (inlineCommentData.f21611b.m27185r().ai() != null) {
            inlineCommentView.h.m20507a(state.e, f20212b);
        }
        if (state.h != null) {
            state.h.m29439a(inlineCommentView);
        }
        inlineCommentView.a(inlineCommentData.f21612c, f20212b);
        Logger.a(8, EntryType.MARK_POP, 875694070, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InlineCommentView inlineCommentView = (InlineCommentView) view;
        if (((State) obj2).h != null) {
            ClickWithPositionListenerBinder.m29438b(inlineCommentView);
        }
    }

    public static InlineCommentPartDefinition m27867a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineCommentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20214i) {
                InlineCommentPartDefinition inlineCommentPartDefinition;
                if (a2 != null) {
                    inlineCommentPartDefinition = (InlineCommentPartDefinition) a2.mo818a(f20214i);
                } else {
                    inlineCommentPartDefinition = f20213h;
                }
                if (inlineCommentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27870b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20214i, b3);
                        } else {
                            f20213h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineCommentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineCommentPartDefinition(Context context, LinkifyUtil linkifyUtil, EmojiUtil emojiUtil, Provider<FeedStoryMessageFlyoutClickWithPositionListener> provider, QeAccessor qeAccessor) {
        this.f20215c = context;
        this.f20216d = linkifyUtil;
        this.f20217e = emojiUtil;
        this.f20218f = provider;
        this.f20219g = qeAccessor;
    }

    public final ViewType mo2547a() {
        return f20211a;
    }

    public final /* synthetic */ boolean m27874a(Object obj) {
        return true;
    }

    private CharSequence m27869a(GraphQLComment graphQLComment, GraphQLStory graphQLStory) {
        if (!(graphQLComment.m27182o() == 0 || graphQLStory.mo2891n() == 1)) {
            boolean z;
            if (graphQLStory.mo2890l() == null) {
                z = false;
            } else {
                z = CommentOrderType.RANKED_ORDER.toString.equalsIgnoreCase(graphQLStory.mo2890l().m23252s());
            }
            if (!z) {
                return this.f20215c.getString(2131233560, new Object[]{Integer.valueOf(graphQLComment.m27182o()), Integer.valueOf(graphQLStory.mo2891n())});
            }
        }
        return "";
    }

    private static OnClickListener m27866a(CharSequence charSequence, AtomicBoolean atomicBoolean) {
        return new 2(atomicBoolean, charSequence);
    }

    @Nullable
    private ClickWithPositionListenerBinder m27868a(FeedProps<GraphQLStory> feedProps, GraphQLComment graphQLComment) {
        FeedStoryMessageFlyoutClickWithPositionListener feedStoryMessageFlyoutClickWithPositionListener = (FeedStoryMessageFlyoutClickWithPositionListener) this.f20218f.get();
        feedStoryMessageFlyoutClickWithPositionListener.m29434a((FeedProps) feedProps, graphQLComment, StoryRenderContext.NEWSFEED);
        return new ClickWithPositionListenerBinder(feedStoryMessageFlyoutClickWithPositionListener);
    }
}
