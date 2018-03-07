package com.facebook.search.results.model.unit;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLSportsDataMatchData;
import com.facebook.graphql.model.GraphQLSportsDataMatchDataFact;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.GameStatusHelper;
import com.facebook.search.results.model.GameStatusHelper.GameStatus;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Refresh Quick Promotion Interstitial Data */
public class SearchResultsSportsUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    private final Optional<String> f23529a;
    public String f23530b;
    public String f23531c;
    public Team f23532d;
    public Team f23533e;
    public GameStatus f23534f;
    public String f23535g;
    public String f23536h;
    public String f23537i;
    public String f23538j;
    public ImmutableList<GraphQLSportsDataMatchDataFact> f23539k;
    public GraphQLPhoto f23540l;
    public Uri f23541m;
    public String f23542n;
    public GraphQLGraphSearchResultRole f23543o;

    /* compiled from: Refresh Quick Promotion Interstitial Data */
    public class Team {
        public String f23523a;
        public int f23524b;
        public Uri f23525c;
        public boolean f23526d;
        public String f23527e;
        public String f23528f;
    }

    private SearchResultsSportsUnit(@Nullable String str) {
        this.f23529a = Optional.fromNullable(str);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23543o;
    }

    public final Optional<String> mo1322l() {
        return this.f23529a;
    }

    public final ImmutableList<String> mo1328a() {
        if (this.f23530b != null) {
            return ImmutableList.of(this.f23530b);
        }
        return RegularImmutableList.a;
    }

    @Nullable
    public final Uri m27214o() {
        if (this.f23540l == null || this.f23540l.L() == null || this.f23540l.L().b() == null) {
            return null;
        }
        return ImageUtil.a(this.f23540l.L());
    }

    @Nullable
    public static SearchResultsSportsUnit m27210a(String str, String str2, String str3, GraphQLSportsDataMatchData graphQLSportsDataMatchData, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str4) {
        SearchResultsSportsUnit searchResultsSportsUnit = new SearchResultsSportsUnit(str4);
        searchResultsSportsUnit.f23530b = str;
        searchResultsSportsUnit = searchResultsSportsUnit;
        searchResultsSportsUnit.f23531c = str2;
        searchResultsSportsUnit = searchResultsSportsUnit;
        searchResultsSportsUnit.f23543o = graphQLGraphSearchResultRole;
        return m27209a(searchResultsSportsUnit, str3, graphQLSportsDataMatchData);
    }

    @Nullable
    public static SearchResultsSportsUnit m27209a(SearchResultsSportsUnit searchResultsSportsUnit, String str, GraphQLSportsDataMatchData graphQLSportsDataMatchData) {
        Uri uri = null;
        if (graphQLSportsDataMatchData.u() == null || graphQLSportsDataMatchData.k() == null) {
            return null;
        }
        ImmutableList a;
        String a2;
        Uri a3;
        ImmutableList immutableList = RegularImmutableList.a;
        if (graphQLSportsDataMatchData.s() != null) {
            a = graphQLSportsDataMatchData.s().a();
            a2 = graphQLSportsDataMatchData.s().j() != null ? graphQLSportsDataMatchData.s().j().a() : null;
        } else {
            a = immutableList;
            a2 = null;
        }
        Object ae = graphQLSportsDataMatchData.j() == null ? null : graphQLSportsDataMatchData.j().ae();
        Team team = new Team();
        team.f23523a = graphQLSportsDataMatchData.u().ae();
        team = team;
        team.f23527e = graphQLSportsDataMatchData.w();
        team = team;
        team.f23528f = graphQLSportsDataMatchData.x();
        Team team2 = team;
        if (graphQLSportsDataMatchData.u().bs() != null) {
            a3 = ImageUtil.a(graphQLSportsDataMatchData.u().bs());
        } else {
            a3 = null;
        }
        team2.f23525c = a3;
        team = team2;
        team.f23524b = graphQLSportsDataMatchData.z();
        team = team;
        team.f23526d = graphQLSportsDataMatchData.u().ae().equals(ae);
        team2 = team;
        team = new Team();
        team.f23523a = graphQLSportsDataMatchData.k().ae();
        team = team;
        team.f23527e = graphQLSportsDataMatchData.m();
        team = team;
        team.f23528f = graphQLSportsDataMatchData.n();
        Team team3 = team;
        if (graphQLSportsDataMatchData.k().bs() != null) {
            a3 = ImageUtil.a(graphQLSportsDataMatchData.k().bs());
        } else {
            a3 = null;
        }
        team3.f23525c = a3;
        team = team3;
        team.f23524b = graphQLSportsDataMatchData.p();
        team = team;
        team.f23526d = graphQLSportsDataMatchData.k().ae().equals(ae);
        searchResultsSportsUnit.f23533e = team;
        SearchResultsSportsUnit searchResultsSportsUnit2 = searchResultsSportsUnit;
        searchResultsSportsUnit2.f23532d = team2;
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23535g = graphQLSportsDataMatchData.r();
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23537i = str;
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23536h = graphQLSportsDataMatchData.H();
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23542n = graphQLSportsDataMatchData.q();
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23534f = GameStatusHelper.m27022a(graphQLSportsDataMatchData.C(), graphQLSportsDataMatchData.G());
        searchResultsSportsUnit2 = searchResultsSportsUnit2;
        searchResultsSportsUnit2.f23538j = a2;
        SearchResultsSportsUnit searchResultsSportsUnit3 = searchResultsSportsUnit2;
        searchResultsSportsUnit3.f23539k = a;
        searchResultsSportsUnit3 = searchResultsSportsUnit3;
        searchResultsSportsUnit3.f23540l = graphQLSportsDataMatchData.D();
        searchResultsSportsUnit3 = searchResultsSportsUnit3;
        if (graphQLSportsDataMatchData.E() != null) {
            uri = ImageUtil.a(graphQLSportsDataMatchData.E());
        }
        searchResultsSportsUnit3.f23541m = uri;
        return searchResultsSportsUnit3;
    }
}
