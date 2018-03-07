package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Prefill Profile Photo via Me Profile in user account NUX flow on ICS+ */
public class SearchResultsTitlePartDefinition extends MultiRowSinglePartDefinition<Props, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType<BetterTextView> f24411a = ViewType.a(2130907015);
    public static final ImmutableMap<Integer, Integer> f24412b = ImmutableMap.builder().b(Integer.valueOf(2130837657), Integer.valueOf(-12730298)).b(Integer.valueOf(2130837668), Integer.valueOf(-12887656)).b(Integer.valueOf(2130838183), Integer.valueOf(-12887656)).b(Integer.valueOf(2130838204), Integer.valueOf(-2479831)).b(Integer.valueOf(2130839552), Integer.valueOf(-973778)).b(Integer.valueOf(2130840747), Integer.valueOf(-16685604)).b(Integer.valueOf(2130842527), Integer.valueOf(-30961)).b(Integer.valueOf(2130842574), Integer.valueOf(-12887656)).b(Integer.valueOf(2130842630), Integer.valueOf(-15415386)).b(Integer.valueOf(2130842684), Integer.valueOf(-715409)).b(Integer.valueOf(2130841693), Integer.valueOf(-16150017)).b(Integer.valueOf(2130843013), Integer.valueOf(-10972929)).b(Integer.valueOf(2130843295), Integer.valueOf(-12887656)).b(Integer.valueOf(2130843461), Integer.valueOf(-7639)).b(Integer.valueOf(2130838154), Integer.valueOf(-12146688)).b(Integer.valueOf(2130843912), Integer.valueOf(-15415386)).b();
    private static final ImmutableMap<GraphQLGraphSearchResultRole, Integer> f24413c = ImmutableMap.builder().b(GraphQLGraphSearchResultRole.COMMERCE_B2C, Integer.valueOf(2130838154)).b(GraphQLGraphSearchResultRole.COMMERCE_C2C, Integer.valueOf(2130838154)).b(GraphQLGraphSearchResultRole.COMMERCE_COMBINED, Integer.valueOf(2130838154)).b(GraphQLGraphSearchResultRole.COMMON_PHRASES, Integer.valueOf(2130838183)).b(GraphQLGraphSearchResultRole.COMMON_QUOTES, Integer.valueOf(2130838204)).b(GraphQLGraphSearchResultRole.NEWS_EYEWITNESSES, Integer.valueOf(2130842684)).b(GraphQLGraphSearchResultRole.NEWS_MODULE, Integer.valueOf(2130841693)).b(GraphQLGraphSearchResultRole.NEWS_PUBLISHERS, Integer.valueOf(2130837668)).b(GraphQLGraphSearchResultRole.POSTS_CONTENTS, Integer.valueOf(2130837668)).b(GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA, Integer.valueOf(2130842630)).b(GraphQLGraphSearchResultRole.RELATED_SHARES, Integer.valueOf(2130843013)).b(GraphQLGraphSearchResultRole.RELATED_TOPICS, Integer.valueOf(2130843295)).b(GraphQLGraphSearchResultRole.GAMETIME_FAN_FAVORITE, Integer.valueOf(2130843461)).b(GraphQLGraphSearchResultRole.SPORT_LINKS, Integer.valueOf(2130843013)).b(GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE, Integer.valueOf(2130837668)).b(GraphQLGraphSearchResultRole.VIDEOS_LIVE, Integer.valueOf(2130841087)).b();
    private static final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, Integer> f24414d = ImmutableMap.builder().b(GraphQLGraphSearchResultsDisplayStyle.APPS, Integer.valueOf(2130837657)).b(GraphQLGraphSearchResultsDisplayStyle.EVENTS, Integer.valueOf(2130839552)).b(GraphQLGraphSearchResultsDisplayStyle.GROUPS, Integer.valueOf(2130840747)).b(GraphQLGraphSearchResultsDisplayStyle.PAGES, Integer.valueOf(2130842527)).b(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, Integer.valueOf(2130842630)).b(GraphQLGraphSearchResultsDisplayStyle.PLACES, Integer.valueOf(2130842684)).b(GraphQLGraphSearchResultsDisplayStyle.STORIES, Integer.valueOf(2130837668)).b(GraphQLGraphSearchResultsDisplayStyle.USERS, Integer.valueOf(2130842574)).b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, Integer.valueOf(2130843912)).b();
    private static final PaddingStyle f24415e;
    private static final PaddingStyle f24416f;
    private static SearchResultsTitlePartDefinition f24417k;
    private static final Object f24418l = new Object();
    private final TextPartDefinition f24419g;
    private final TextAppearancePartDefinition f24420h;
    private final TextIconPartDefinition f24421i;
    private final BackgroundPartDefinition f24422j;

    /* compiled from: Prefill Profile Photo via Me Profile in user account NUX flow on ICS+ */
    public class Props {
        public final String f24408a;
        public final GraphQLGraphSearchResultRole f24409b;
        @Nullable
        public final GraphQLGraphSearchResultsDisplayStyle f24410c;

        public Props(String str, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
            this.f24408a = str;
            this.f24409b = graphQLGraphSearchResultRole;
            this.f24410c = graphQLGraphSearchResultsDisplayStyle;
        }
    }

    private static SearchResultsTitlePartDefinition m27892b(InjectorLike injectorLike) {
        return new SearchResultsTitlePartDefinition(TextPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike), TextIconPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27894a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f24420h, Integer.valueOf(2131624396));
        subParts.a(this.f24419g, props.f24408a);
        Integer a = m27891a(props.f24409b, props.f24410c);
        Object obj2 = (a == null || props.f24410c == GraphQLGraphSearchResultsDisplayStyle.SALE_POST) ? null : 1;
        subParts.a(this.f24422j, new StylingData(null, obj2 != null ? f24416f : f24415e, Position.TOP));
        if (obj2 != null) {
            subParts.a(this.f24421i, new IconData(a.intValue(), (Integer) f24412b.get(a), Integer.valueOf(2131432552)));
        }
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        f24415e = a.i();
        a = Builder.a();
        a.b = 6.0f;
        f24416f = a.i();
    }

    public static SearchResultsTitlePartDefinition m27890a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24418l) {
                SearchResultsTitlePartDefinition searchResultsTitlePartDefinition;
                if (a2 != null) {
                    searchResultsTitlePartDefinition = (SearchResultsTitlePartDefinition) a2.a(f24418l);
                } else {
                    searchResultsTitlePartDefinition = f24417k;
                }
                if (searchResultsTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27892b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24418l, b3);
                        } else {
                            f24417k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsTitlePartDefinition(TextPartDefinition textPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, TextIconPartDefinition textIconPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24419g = textPartDefinition;
        this.f24420h = textAppearancePartDefinition;
        this.f24421i = textIconPartDefinition;
        this.f24422j = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m27893a() {
        return f24411a;
    }

    public final boolean m27895a(Object obj) {
        return true;
    }

    @Nullable
    public static Integer m27891a(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        Integer num = (Integer) f24413c.get(graphQLGraphSearchResultRole);
        if (num != null) {
            return num;
        }
        return graphQLGraphSearchResultsDisplayStyle == null ? null : (Integer) f24414d.get(graphQLGraphSearchResultsDisplayStyle);
    }
}
