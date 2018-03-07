package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigation;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPEAT_OFF */
public class SearchResultsPostsContentsPartDefinition<E extends OldCanLogEntityNavigation & HasContext & HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<GraphQLNode, State, E, ContentView> {
    public static final ViewType f23820a = SearchResultsCommonViewTypes.f24005c;
    private static SearchResultsPostsContentsPartDefinition f23821g;
    private static final Object f23822h = new Object();
    private final ClickListenerPartDefinition f23823b;
    private final BackgroundPartDefinition f23824c;
    public final SearchResultsIntentBuilder f23825d;
    public final SecureContextHelper f23826e;
    private final GlyphColorizer f23827f;

    /* compiled from: REPEAT_OFF */
    public class State {
        public Drawable f23817a;
        public String f23818b;
        public int f23819c;

        public State(Drawable drawable, String str, int i) {
            this.f23817a = drawable;
            this.f23818b = str;
            this.f23819c = i;
        }
    }

    private static SearchResultsPostsContentsPartDefinition m27439b(InjectorLike injectorLike) {
        return new SearchResultsPostsContentsPartDefinition(ClickListenerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m27441a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String string;
        Drawable a;
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final OldCanLogEntityNavigation oldCanLogEntityNavigation = (OldCanLogEntityNavigation) anyEnvironment;
        subParts.a(this.f23824c, new StylingData(null, PaddingStyle.a, Position.MIDDLE));
        subParts.a(this.f23823b, new OnClickListener(this) {
            final /* synthetic */ SearchResultsPostsContentsPartDefinition f23816c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 849074836);
                this.f23816c.f23826e.a(this.f23816c.f23825d.a(GraphQLGraphSearchResultsDisplayStyle.STORIES, graphQLNode.kb().a(), graphQLNode.jZ(), ((HasSearchResultsContext) oldCanLogEntityNavigation).mo1248s().f23382q, SearchResultsSource.z, ((HasSearchResultsContext) oldCanLogEntityNavigation).mo1248s().f23369d), ((HasContext) oldCanLogEntityNavigation).getContext());
                oldCanLogEntityNavigation.mo1251b(graphQLNode);
                Logger.a(2, EntryType.UI_INPUT_END, -518907898, a);
            }
        });
        Context context = ((HasContext) oldCanLogEntityNavigation).getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131432600);
        if (GraphQLGraphSearchResultRole.MY_POSTS.toString().equals(graphQLNode.ka())) {
            string = context.getString(2131239021);
            a = this.f23827f.a(2130842593, -12887656);
        } else if (GraphQLGraphSearchResultRole.FEED_POSTS.toString().equals(graphQLNode.ka())) {
            string = context.getString(2131239022);
            a = this.f23827f.a(2130842574, -12887656);
        } else {
            string = context.getString(2131239023);
            a = this.f23827f.a(2130840555, -12887656);
        }
        return new State(a, string, dimensionPixelSize);
    }

    public final /* bridge */ /* synthetic */ void m27442a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -356511628);
        GraphQLNode graphQLNode = (GraphQLNode) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setTitleTextAppearance(2131624396);
        contentView.setTitleText(graphQLNode.kb().a());
        contentView.setSubtitleTextAppearance(2131624416);
        contentView.setSubtitleText(state.f23818b);
        contentView.setThumbnailDrawable(state.f23817a);
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.setThumbnailPadding(state.f23819c);
        contentView.setThumbnailGravity(16);
        Logger.a(8, EntryType.MARK_POP, 1504895281, a);
    }

    public final void m27444b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ContentView contentView = (ContentView) view;
        contentView.setTitleTextAppearance(0);
        contentView.setTitleText("");
        contentView.setSubtitleTextAppearance(0);
        contentView.setSubtitleText("");
        contentView.setThumbnailDrawable(null);
        contentView.setMaxLinesFromThumbnailSize(true);
        contentView.setThumbnailPadding(0);
        contentView.setThumbnailGravity(48);
    }

    public static SearchResultsPostsContentsPartDefinition m27437a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsPostsContentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23822h) {
                SearchResultsPostsContentsPartDefinition searchResultsPostsContentsPartDefinition;
                if (a2 != null) {
                    searchResultsPostsContentsPartDefinition = (SearchResultsPostsContentsPartDefinition) a2.a(f23822h);
                } else {
                    searchResultsPostsContentsPartDefinition = f23821g;
                }
                if (searchResultsPostsContentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27439b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23822h, b3);
                        } else {
                            f23821g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsPostsContentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsPostsContentsPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, BackgroundPartDefinition backgroundPartDefinition, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, GlyphColorizer glyphColorizer) {
        this.f23823b = clickListenerPartDefinition;
        this.f23824c = backgroundPartDefinition;
        this.f23825d = searchResultsIntentBuilder;
        this.f23826e = secureContextHelper;
        this.f23827f = glyphColorizer;
    }

    public static boolean m27438a(GraphQLNode graphQLNode) {
        return (graphQLNode.kb() == null || graphQLNode.kb().a() == null || graphQLNode.jZ() == null) ? false : true;
    }

    public final ViewType<ContentView> m27440a() {
        return f23820a;
    }
}
