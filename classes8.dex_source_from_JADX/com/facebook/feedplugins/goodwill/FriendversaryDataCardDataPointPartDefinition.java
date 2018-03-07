package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackDataPoint;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_page_blended_videos */
public class FriendversaryDataCardDataPointPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackDataPoint>, Void, HasPositionInformation, FriendversaryDataCardDataPointView> {
    public static final ViewType f12262a = new C13011();
    private static final PaddingStyle f12263c;
    private static FriendversaryDataCardDataPointPartDefinition f12264d;
    private static final Object f12265e = new Object();
    private final BackgroundPartDefinition f12266b;

    /* compiled from: graph_search_results_page_blended_videos */
    final class C13011 extends ViewType {
        C13011() {
        }

        public final View m14227a(Context context) {
            return new FriendversaryDataCardDataPointView(context);
        }
    }

    private static FriendversaryDataCardDataPointPartDefinition m14230b(InjectorLike injectorLike) {
        return new FriendversaryDataCardDataPointPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14232a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12266b, new StylingData(null, f12263c, Position.MIDDLE));
        return null;
    }

    public final boolean m14234a(Object obj) {
        GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackDataPoint == null || graphQLGoodwillThrowbackDataPoint.j() == null || graphQLGoodwillThrowbackDataPoint.a() == null) ? false : true;
    }

    static {
        Builder f = Builder.f();
        f.c = 8.0f;
        f12263c = f.i();
    }

    @Inject
    public FriendversaryDataCardDataPointPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12266b = backgroundPartDefinition;
    }

    public final ViewType m14231a() {
        return f12262a;
    }

    public static FriendversaryDataCardDataPointPartDefinition m14228a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardDataPointPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12265e) {
                FriendversaryDataCardDataPointPartDefinition friendversaryDataCardDataPointPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardDataPointPartDefinition = (FriendversaryDataCardDataPointPartDefinition) a2.a(f12265e);
                } else {
                    friendversaryDataCardDataPointPartDefinition = f12264d;
                }
                if (friendversaryDataCardDataPointPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14230b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12265e, b3);
                        } else {
                            f12264d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardDataPointPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m14229a(FeedProps<GraphQLGoodwillThrowbackDataPoint> feedProps, Void voidR, HasPositionInformation hasPositionInformation, FriendversaryDataCardDataPointView friendversaryDataCardDataPointView) {
        GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) feedProps.a;
        super.a(feedProps, voidR, hasPositionInformation, friendversaryDataCardDataPointView);
        friendversaryDataCardDataPointView.m14235a(graphQLGoodwillThrowbackDataPoint.j().a(), graphQLGoodwillThrowbackDataPoint.a().b());
    }
}
