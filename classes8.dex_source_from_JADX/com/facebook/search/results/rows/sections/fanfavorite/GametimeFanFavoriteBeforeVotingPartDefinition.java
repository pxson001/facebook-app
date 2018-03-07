package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.graphql.gametime.GametimeFanFavoriteUpdateVotes.FBGametimeFanFavoriteUpdateVotesString;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.calls.MediaQuestionAddVoteInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.environment.CanReplaceFeedItem;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Prompt being shown */
public class GametimeFanFavoriteBeforeVotingPartDefinition<E extends HasPositionInformation & HasInvalidate & CanReplaceFeedItem> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<SportsTeam>>, Void, E, CustomLinearLayout> {
    public static final ViewType f24309a = ViewType.a(2130904240);
    private static GametimeFanFavoriteBeforeVotingPartDefinition f24310h;
    private static final Object f24311i = new Object();
    private final BackgroundPartDefinition f24312b;
    private final TextPartDefinition f24313c;
    private final GametimeFanFavoriteTeamBeforeVotingPartDefinition f24314d;
    private final ClickListenerPartDefinition f24315e;
    private final Context f24316f;
    private final GraphQLQueryExecutor f24317g;

    private static GametimeFanFavoriteBeforeVotingPartDefinition m27823b(InjectorLike injectorLike) {
        return new GametimeFanFavoriteBeforeVotingPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), GametimeFanFavoriteTeamBeforeVotingPartDefinition.m27836a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    public final Object m27825a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f24312b, new StylingData(feedProps, PaddingStyle.a));
        subParts.a(2131558927, this.f24313c, this.f24316f.getString(2131239028));
        subParts.a(2131561728, this.f24314d, searchResultsCollectionUnit.f23463d.get(0));
        subParts.a(2131561729, this.f24314d, searchResultsCollectionUnit.f23463d.get(1));
        subParts.a(2131561728, this.f24315e, new OnClickListener(this) {
            final /* synthetic */ GametimeFanFavoriteBeforeVotingPartDefinition f24305c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -425400548);
                GametimeFanFavoriteBeforeVotingPartDefinition.m27822a(this.f24305c, searchResultsCollectionUnit, true, hasPositionInformation);
                Logger.a(2, EntryType.UI_INPUT_END, 319098918, a);
            }
        });
        subParts.a(2131561729, this.f24315e, new OnClickListener(this) {
            final /* synthetic */ GametimeFanFavoriteBeforeVotingPartDefinition f24308c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1646692305);
                GametimeFanFavoriteBeforeVotingPartDefinition.m27822a(this.f24308c, searchResultsCollectionUnit, false, hasPositionInformation);
                Logger.a(2, EntryType.UI_INPUT_END, 1076380618, a);
            }
        });
        return null;
    }

    public final boolean m27826a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        return (searchResultsCollectionUnit.f23463d.size() != 2 || searchResultsCollectionUnit.f23463d.get(0) == null || searchResultsCollectionUnit.f23463d.get(1) == null || ((SportsTeam) searchResultsCollectionUnit.f23463d.get(0)).f23401j || ((SportsTeam) searchResultsCollectionUnit.f23463d.get(1)).f23401j) ? false : true;
    }

    @Inject
    public GametimeFanFavoriteBeforeVotingPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, GametimeFanFavoriteTeamBeforeVotingPartDefinition gametimeFanFavoriteTeamBeforeVotingPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f24316f = context;
        this.f24312b = backgroundPartDefinition;
        this.f24313c = textPartDefinition;
        this.f24314d = gametimeFanFavoriteTeamBeforeVotingPartDefinition;
        this.f24315e = clickListenerPartDefinition;
        this.f24317g = graphQLQueryExecutor;
    }

    public static GametimeFanFavoriteBeforeVotingPartDefinition m27821a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteBeforeVotingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24311i) {
                GametimeFanFavoriteBeforeVotingPartDefinition gametimeFanFavoriteBeforeVotingPartDefinition;
                if (a2 != null) {
                    gametimeFanFavoriteBeforeVotingPartDefinition = (GametimeFanFavoriteBeforeVotingPartDefinition) a2.a(f24311i);
                } else {
                    gametimeFanFavoriteBeforeVotingPartDefinition = f24310h;
                }
                if (gametimeFanFavoriteBeforeVotingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27823b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24311i, b3);
                        } else {
                            f24310h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoriteBeforeVotingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<CustomLinearLayout> m27824a() {
        return f24309a;
    }

    public static void m27822a(GametimeFanFavoriteBeforeVotingPartDefinition gametimeFanFavoriteBeforeVotingPartDefinition, SearchResultsCollectionUnit searchResultsCollectionUnit, boolean z, HasPositionInformation hasPositionInformation) {
        Object a;
        Object obj;
        SportsTeam sportsTeam = (SportsTeam) searchResultsCollectionUnit.f23463d.get(0);
        SportsTeam sportsTeam2 = (SportsTeam) searchResultsCollectionUnit.f23463d.get(1);
        GraphQlQueryString fBGametimeFanFavoriteUpdateVotesString = new FBGametimeFanFavoriteUpdateVotesString();
        MediaQuestionAddVoteInputData mediaQuestionAddVoteInputData = new MediaQuestionAddVoteInputData();
        if (z) {
            SportsTeam b = SportsTeam.m27112b(sportsTeam);
            a = SportsTeam.m27110a(sportsTeam2);
            if (b.f23397f != null) {
                mediaQuestionAddVoteInputData.a(b.f23397f);
                obj = b;
            } else {
                sportsTeam2 = b;
            }
        } else {
            sportsTeam2 = SportsTeam.m27112b(sportsTeam2);
            sportsTeam = SportsTeam.m27110a(sportsTeam);
            if (sportsTeam2.f23397f != null) {
                mediaQuestionAddVoteInputData.a(sportsTeam2.f23397f);
            }
            SportsTeam sportsTeam3 = sportsTeam2;
            sportsTeam2 = sportsTeam;
            sportsTeam = sportsTeam3;
        }
        fBGametimeFanFavoriteUpdateVotesString.a("id", mediaQuestionAddVoteInputData);
        gametimeFanFavoriteBeforeVotingPartDefinition.f24317g.a(GraphQLRequest.a(fBGametimeFanFavoriteUpdateVotesString));
        ((CanReplaceFeedItem) hasPositionInformation).mo1241a(searchResultsCollectionUnit, SearchResultsCollectionUnit.m27146a(searchResultsCollectionUnit, ImmutableList.of(obj, a)));
        ((HasInvalidate) hasPositionInformation).hL_();
    }
}
