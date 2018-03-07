package com.facebook.feed.rows.permalink;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: activity_picker_started */
public class ShareCountPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, DefaultBlingBarView> {
    public static final ViewType f19986a = new C17291();
    private static ShareCountPartDefinition f19987d;
    private static final Object f19988e = new Object();
    private final BackgroundPartDefinition f19989b;
    private final QeAccessor f19990c;

    /* compiled from: activity_picker_started */
    final class C17291 extends ViewType {
        C17291() {
        }

        public final View m23186a(Context context) {
            return new DefaultBlingBarView(context, 2130905465);
        }
    }

    private static ShareCountPartDefinition m23188b(InjectorLike injectorLike) {
        return new ShareCountPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m23191a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f19989b, new StylingData((FeedProps) obj, PaddingStyle.e));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23192a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 235591131);
        FeedProps feedProps = (FeedProps) obj;
        DefaultBlingBarView defaultBlingBarView = (DefaultBlingBarView) view;
        defaultBlingBarView.setLikes(0);
        defaultBlingBarView.setComments(0);
        defaultBlingBarView.setShares(GraphQLHelper.m(m23189b(feedProps).l()));
        Logger.a(8, EntryType.MARK_POP, 852040317, a);
    }

    public final boolean m23193a(Object obj) {
        return this.f19990c.a(ExperimentsForFeedbackTestModule.T, false) && GraphQLHelper.m(m23189b((FeedProps) obj).l()) > 0;
    }

    @Inject
    public ShareCountPartDefinition(QeAccessor qeAccessor, BackgroundPartDefinition backgroundPartDefinition) {
        this.f19990c = qeAccessor;
        this.f19989b = backgroundPartDefinition;
    }

    public static ShareCountPartDefinition m23187a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareCountPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19988e) {
                ShareCountPartDefinition shareCountPartDefinition;
                if (a2 != null) {
                    shareCountPartDefinition = (ShareCountPartDefinition) a2.a(f19988e);
                } else {
                    shareCountPartDefinition = f19987d;
                }
                if (shareCountPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23188b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19988e, b3);
                        } else {
                            f19987d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = shareCountPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<DefaultBlingBarView> m23190a() {
        return f19986a;
    }

    public static GraphQLStory m23189b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return StoryProps.m(feedProps) ? graphQLStory.L() : graphQLStory;
    }
}
