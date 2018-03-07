package com.facebook.graphql.model;

import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: max_idle_spdy_sessions */
public final class PropertyHelper {
    private PropertyHelper() {
    }

    public static PropertyBag m21261a(Object obj) {
        if (obj instanceof HasProperty) {
            return ((HasProperty) obj).U_();
        }
        throw new RuntimeException("class doesn't implement PropertyBag.HasProperty:" + obj.getClass().getSimpleName());
    }

    @Nullable
    public static String m21265a(GraphQLFeedback graphQLFeedback) {
        return m21261a((Object) graphQLFeedback).f14852a;
    }

    public static void m21273a(GraphQLFeedback graphQLFeedback, @Nullable String str) {
        m21261a((Object) graphQLFeedback).f14852a = str;
    }

    @Nullable
    public static ArrayNode m21262a(CachedFeedTrackable cachedFeedTrackable) {
        return m21261a((Object) cachedFeedTrackable).f14854c;
    }

    public static void m21281a(CachedFeedTrackable cachedFeedTrackable, @Nullable ArrayNode arrayNode) {
        m21261a((Object) cachedFeedTrackable).f14854c = arrayNode;
    }

    public static void m21272a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable String str) {
        m21261a((Object) graphQLFeedUnitEdge).f14856e = str;
    }

    @Nullable
    public static String m21264a(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14857f;
    }

    public static void m21268a(FeedUnit feedUnit, @Nullable String str) {
        m21261a((Object) feedUnit).f14857f = str;
    }

    public static void m21292b(GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable String str) {
        m21261a((Object) graphQLFeedUnitEdge).f14858g = str;
    }

    @Nullable
    public static String m21294c(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return m21261a((Object) graphQLFeedUnitEdge).f14859h;
    }

    public static void m21297c(GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable String str) {
        m21261a((Object) graphQLFeedUnitEdge).f14859h = str;
    }

    @Nullable
    public static String m21289b(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14859h;
    }

    public static void m21291b(FeedUnit feedUnit, @Nullable String str) {
        m21261a((Object) feedUnit).f14859h = str;
    }

    @Nullable
    public static String m21293c(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14860i;
    }

    public static void m21296c(FeedUnit feedUnit, @Nullable String str) {
        m21261a((Object) feedUnit).f14860i = str;
    }

    public static boolean m21282a(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14861j;
    }

    public static void m21277a(GraphQLStory graphQLStory, boolean z) {
        m21261a((Object) graphQLStory).f14861j = z;
    }

    @Nullable
    public static FeedUnit m21288b(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14863l;
    }

    @Nullable
    public static FeedUnitMediaLoadedInfo m21298d(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return m21261a((Object) graphQLFeedUnitEdge).f14865n;
    }

    public static void m21271a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, @Nullable FeedUnitMediaLoadedInfo feedUnitMediaLoadedInfo) {
        m21261a((Object) graphQLFeedUnitEdge).f14865n = feedUnitMediaLoadedInfo;
    }

    public static void m21270a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i) {
        m21261a((Object) graphQLFeedUnitEdge).f14866o = i;
    }

    public static boolean m21286a(FollowUpFeedUnit followUpFeedUnit) {
        return m21261a((Object) followUpFeedUnit).f14867p;
    }

    public static boolean m21283a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m21261a((Object) graphQLStoryAttachment).f14868q;
    }

    public static void m21278a(GraphQLStoryAttachment graphQLStoryAttachment, boolean z) {
        m21261a((Object) graphQLStoryAttachment).f14868q = z;
    }

    public static boolean m21284a(GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit) {
        return m21261a((Object) graphQLStoryGallerySurveyFeedUnit).f14868q;
    }

    static boolean m21285a(Sponsorable sponsorable) {
        return m21261a((Object) sponsorable).f14868q;
    }

    static void m21280a(Sponsorable sponsorable, boolean z) {
        m21261a((Object) sponsorable).f14868q = z;
    }

    static int m21287b(Sponsorable sponsorable) {
        return m21261a((Object) sponsorable).f14869r;
    }

    static void m21279a(Sponsorable sponsorable, int i) {
        m21261a((Object) sponsorable).f14869r = i;
    }

    public static boolean m21302e(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14871t;
    }

    public static int m21304f(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14872u;
    }

    public static void m21274a(GraphQLStory graphQLStory, int i) {
        m21261a((Object) graphQLStory).f14872u = i;
    }

    @Nullable
    public static String m21306g(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14873v;
    }

    public static void m21276a(GraphQLStory graphQLStory, @Nullable String str) {
        m21261a((Object) graphQLStory).f14873v = str;
    }

    @Nullable
    public static String m21290b(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m21261a((Object) graphQLStoryAttachment).f14875x;
    }

    public static void m21269a(FeedUnit feedUnit, boolean z) {
        m21261a((Object) feedUnit).f14876y = z;
    }

    @Nullable
    public static String m21295c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return m21261a((Object) graphQLStoryAttachment).f14877z;
    }

    @Nullable
    public static GraphQLGraphSearchResultDecoration m21307i(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14844A;
    }

    public static void m21275a(GraphQLStory graphQLStory, @Nullable GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration) {
        m21261a((Object) graphQLStory).f14844A = graphQLGraphSearchResultDecoration;
    }

    public static boolean m21308j(GraphQLStory graphQLStory) {
        return m21261a((Object) graphQLStory).f14845B;
    }

    public static void m21301e(GraphQLStory graphQLStory, boolean z) {
        m21261a((Object) graphQLStory).f14845B = z;
    }

    @Nullable
    public static String m21300e(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14846C;
    }

    public static void m21299d(FeedUnit feedUnit, @Nullable String str) {
        m21261a((Object) feedUnit).f14846C = str;
    }

    public static int m21303f(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14847D;
    }

    public static void m21266a(FeedUnit feedUnit, int i) {
        m21261a((Object) feedUnit).f14847D = i;
    }

    @Nullable
    public static ImmutableSet<String> m21305g(FeedUnit feedUnit) {
        return m21261a((Object) feedUnit).f14848E;
    }

    public static void m21267a(FeedUnit feedUnit, @Nullable ImmutableSet<String> immutableSet) {
        m21261a((Object) feedUnit).f14848E = immutableSet;
    }

    @Nullable
    static Integer m21263a(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        return m21261a((Object) scrollableItemListFeedUnit).f14849F;
    }
}
