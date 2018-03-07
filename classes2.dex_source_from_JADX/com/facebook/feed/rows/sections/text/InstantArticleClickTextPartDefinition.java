package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListenerBinder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: hosting */
public class InstantArticleClickTextPartDefinition extends BaseSinglePartDefinition<GraphQLStory, ClickWithPositionListenerBinder, AnyEnvironment, View> {
    private static InstantArticleClickTextPartDefinition f20853b;
    private static final Object f20854c = new Object();
    private final Provider<InstantArticleClickWithPositionListener> f20855a;

    private static InstantArticleClickTextPartDefinition m28581b(InjectorLike injectorLike) {
        return new InstantArticleClickTextPartDefinition(IdBasedProvider.m1811a(injectorLike, 6045));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CharSequence a = m28580a((GraphQLStory) obj);
        if (StringUtil.m3589a(a)) {
            return null;
        }
        InstantArticleClickWithPositionListener instantArticleClickWithPositionListener = (InstantArticleClickWithPositionListener) this.f20855a.get();
        instantArticleClickWithPositionListener.b = a;
        if (anyEnvironment instanceof HasFeedListType) {
            instantArticleClickWithPositionListener.c = ((HasFeedListType) anyEnvironment).mo2446c().mo2419a().name().toLowerCase();
        } else {
            instantArticleClickWithPositionListener.c = null;
        }
        return new ClickWithPositionListenerBinder(instantArticleClickWithPositionListener);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1237007100);
        ClickWithPositionListenerBinder clickWithPositionListenerBinder = (ClickWithPositionListenerBinder) obj2;
        if (clickWithPositionListenerBinder != null) {
            clickWithPositionListenerBinder.m29439a(view);
        }
        Logger.a(8, EntryType.MARK_POP, 2102813388, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        if (((ClickWithPositionListenerBinder) obj2) != null) {
            ClickWithPositionListenerBinder.m29438b(view);
        }
    }

    @Inject
    public InstantArticleClickTextPartDefinition(Provider<InstantArticleClickWithPositionListener> provider) {
        this.f20855a = provider;
    }

    public static InstantArticleClickTextPartDefinition m28579a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleClickTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20854c) {
                InstantArticleClickTextPartDefinition instantArticleClickTextPartDefinition;
                if (a2 != null) {
                    instantArticleClickTextPartDefinition = (InstantArticleClickTextPartDefinition) a2.mo818a(f20854c);
                } else {
                    instantArticleClickTextPartDefinition = f20853b;
                }
                if (instantArticleClickTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28581b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20854c, b3);
                        } else {
                            f20853b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleClickTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static String m28580a(GraphQLStory graphQLStory) {
        GraphQLTextWithEntities b = StoryHierarchyHelper.m27435b(graphQLStory);
        ImmutableList b2 = b != null ? b.mo2912b() : null;
        if (b2 == null) {
            return null;
        }
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            GraphQLEntity j = ((GraphQLEntityAtRange) b2.get(i)).m23616j();
            if (j != null) {
                GraphQLObjectType b3 = j.mo2904b();
                if (b3 != null && b3.m22301g() == 1607392245) {
                    return j.mo2906d();
                }
            }
        }
        return null;
    }
}
