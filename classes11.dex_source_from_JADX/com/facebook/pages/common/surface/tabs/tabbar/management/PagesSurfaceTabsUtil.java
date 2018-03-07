package com.facebook.pages.common.surface.tabs.tabbar.management;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLPagePresenceTabContentType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageHeaderTabDataModel.TabsModel;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Locale;

/* compiled from: request_ */
public class PagesSurfaceTabsUtil {
    public ImmutableList<TabsModel> f2555a = RegularImmutableList.a;

    public static Surface m3499a(TabsModel tabsModel) {
        return Surface.valueOf(tabsModel.j().toUpperCase(Locale.US));
    }

    public final boolean m3502a(ImmutableList<TabsModel> immutableList) {
        boolean z = false;
        Builder builder = new Builder();
        for (int i = 0; i < immutableList.size(); i++) {
            TabsModel tabsModel = (TabsModel) immutableList.get(i);
            if (tabsModel != null) {
                Object obj;
                GraphQLPagePresenceTabType k = tabsModel.k();
                GraphQLPagePresenceTabContentType a = tabsModel.a();
                if (PagesSurfaceSupportedTabs.f2553a.containsKey(k) && ((Boolean) PagesSurfaceSupportedTabs.f2553a.get(k)).booleanValue() && PagesSurfaceSupportedTabs.f2554b.containsKey(a) && ((Boolean) PagesSurfaceSupportedTabs.f2554b.get(a)).booleanValue()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (tabsModel.l() == null || StringUtil.a(tabsModel.l().a()) || tabsModel.k() == null || tabsModel.a() == null) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        if (tabsModel.a() != GraphQLPagePresenceTabContentType.REACTION_SURFACE || ReactionSurfaceUtil.j(m3499a(tabsModel))) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            builder.c(tabsModel);
                        }
                    }
                }
            }
        }
        if (this.f2555a.size() != immutableList.size()) {
            z = true;
        }
        this.f2555a = builder.b();
        return z;
    }

    public final TabsModel m3500a(int i) {
        return (TabsModel) this.f2555a.get(i);
    }

    public final boolean m3501a(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        for (TabsModel k : this.f2555a) {
            if (k.k() == graphQLPagePresenceTabType) {
                return true;
            }
        }
        return false;
    }

    public final int m3503b() {
        return this.f2555a.size();
    }

    public final int m3504b(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (m3501a(graphQLPagePresenceTabType)) {
            for (int i = 0; i < this.f2555a.size(); i++) {
                if (((TabsModel) this.f2555a.get(i)).k() == graphQLPagePresenceTabType) {
                    return i;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("Accessing non-existing tab: " + graphQLPagePresenceTabType.toString());
    }
}
