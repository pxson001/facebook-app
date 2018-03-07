package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoRowPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCallToActionCoreDeleteMutation */
public class SearchResultsNewsContextHeaderVideoPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsNewsContextUnit>, Void, FeedEnvironment, RichVideoAttachmentView> {
    public static final ViewType f24646a = new C26041();
    private static final PaddingStyle f24647b = Builder.f().i();
    private static SearchResultsNewsContextHeaderVideoPartDefinition f24648f;
    private static final Object f24649g = new Object();
    private final RichVideoRowPartDefinition f24650c;
    private final BackgroundPartDefinition f24651d;
    private final QeAccessor f24652e;

    /* compiled from: PageCallToActionCoreDeleteMutation */
    final class C26041 extends ViewType {
        C26041() {
        }

        public final View m28059a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static SearchResultsNewsContextHeaderVideoPartDefinition m28062b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextHeaderVideoPartDefinition(RichVideoRowPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m28064a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24650c, m28060a((SearchResultsNewsContextUnit) feedProps.a));
        subParts.a(this.f24651d, new StylingData(feedProps, f24647b, Position.MIDDLE));
        return null;
    }

    public final boolean m28065a(Object obj) {
        FeedProps a = m28060a((SearchResultsNewsContextUnit) ((FeedProps) obj).a);
        return a != null && this.f24650c.a(a) && this.f24652e.a(ExperimentsForSearchAbTestModule.bP, true);
    }

    @Inject
    public SearchResultsNewsContextHeaderVideoPartDefinition(RichVideoRowPartDefinition richVideoRowPartDefinition, BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor) {
        this.f24650c = richVideoRowPartDefinition;
        this.f24651d = backgroundPartDefinition;
        this.f24652e = qeAccessor;
    }

    public static SearchResultsNewsContextHeaderVideoPartDefinition m28061a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextHeaderVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24649g) {
                SearchResultsNewsContextHeaderVideoPartDefinition searchResultsNewsContextHeaderVideoPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextHeaderVideoPartDefinition = (SearchResultsNewsContextHeaderVideoPartDefinition) a2.a(f24649g);
                } else {
                    searchResultsNewsContextHeaderVideoPartDefinition = f24648f;
                }
                if (searchResultsNewsContextHeaderVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28062b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24649g, b3);
                        } else {
                            f24648f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextHeaderVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<RichVideoAttachmentView> m28063a() {
        return f24646a;
    }

    private static FeedProps<GraphQLStoryAttachment> m28060a(SearchResultsNewsContextUnit searchResultsNewsContextUnit) {
        if (searchResultsNewsContextUnit == null || searchResultsNewsContextUnit.f23490a == null || searchResultsNewsContextUnit.f23490a.iw() == null || searchResultsNewsContextUnit.f23490a.iw().bv() == null) {
            return null;
        }
        FeedProps c = FeedProps.c(searchResultsNewsContextUnit.f23490a.iw().bv());
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) c.a);
        return o != null ? c.a(o) : null;
    }
}
