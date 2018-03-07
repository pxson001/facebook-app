package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLTrendingTopicData;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import com.facebook.search.results.rows.sections.common.ContextHeaderPhotoView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: PageCallToActionCoreUpdateMutation */
public class SearchResultsNewsContextHeaderPhotoPartDefinition extends MultiRowSinglePartDefinition<SearchResultsNewsContextUnit, Void, HasPositionInformation, ContextHeaderPhotoView> {
    public static final ViewType<ContextHeaderPhotoView> f24642a = new C26031();
    public static final CallerContext f24643b = CallerContext.a(SearchResultsNewsContextHeaderPhotoPartDefinition.class, "keyword_search");
    private static SearchResultsNewsContextHeaderPhotoPartDefinition f24644c;
    private static final Object f24645d = new Object();

    /* compiled from: PageCallToActionCoreUpdateMutation */
    final class C26031 extends ViewType<ContextHeaderPhotoView> {
        C26031() {
        }

        public final View m28053a(Context context) {
            ContextHeaderPhotoView contextHeaderPhotoView = new ContextHeaderPhotoView(context);
            contextHeaderPhotoView.m27557a(context, 2131626173);
            contextHeaderPhotoView.setTextPadding(2131427417);
            return contextHeaderPhotoView;
        }
    }

    private static SearchResultsNewsContextHeaderPhotoPartDefinition m28055b() {
        return new SearchResultsNewsContextHeaderPhotoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m28057a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 336548718);
        ContextHeaderPhotoView contextHeaderPhotoView = (ContextHeaderPhotoView) view;
        GraphQLTrendingTopicData graphQLTrendingTopicData = (GraphQLTrendingTopicData) Preconditions.checkNotNull(((SearchResultsNewsContextUnit) obj).f23490a.iL());
        contextHeaderPhotoView.m27558a(ImageUtil.a(graphQLTrendingTopicData.l()), f24643b);
        contextHeaderPhotoView.setCoverPhotoTitle(graphQLTrendingTopicData.m());
        Logger.a(8, EntryType.MARK_POP, -1516270821, a);
    }

    public final boolean m28058a(Object obj) {
        GraphQLTrendingTopicData iL = ((SearchResultsNewsContextUnit) obj).f23490a.iL();
        return (iL == null || iL.l() == null || Strings.isNullOrEmpty(iL.l().b())) ? false : true;
    }

    public final ViewType<ContextHeaderPhotoView> m28056a() {
        return f24642a;
    }

    public static SearchResultsNewsContextHeaderPhotoPartDefinition m28054a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextHeaderPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24645d) {
                SearchResultsNewsContextHeaderPhotoPartDefinition searchResultsNewsContextHeaderPhotoPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextHeaderPhotoPartDefinition = (SearchResultsNewsContextHeaderPhotoPartDefinition) a2.a(f24645d);
                } else {
                    searchResultsNewsContextHeaderPhotoPartDefinition = f24644c;
                }
                if (searchResultsNewsContextHeaderPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m28055b();
                        if (a2 != null) {
                            a2.a(f24645d, b3);
                        } else {
                            f24644c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextHeaderPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
