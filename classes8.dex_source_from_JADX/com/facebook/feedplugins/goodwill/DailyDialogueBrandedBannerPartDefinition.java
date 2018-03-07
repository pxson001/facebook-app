package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLImage;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_gps_foreground_check_skipped */
public class DailyDialogueBrandedBannerPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, State, E, DailyDialogueBrandedBannerView> {
    public static final ViewType f12159a = new C12971();
    private static final PaddingStyle f12160b = Builder.f().i();
    private static DailyDialogueBrandedBannerPartDefinition f12161f;
    private static final Object f12162g = new Object();
    private final BackgroundPartDefinition f12163c;
    private final MenuButtonPartDefinition f12164d;
    public final CallerContext f12165e = CallerContext.a(getClass(), "native_newsfeed");

    /* compiled from: gravity_gps_foreground_check_skipped */
    final class C12971 extends ViewType {
        C12971() {
        }

        public final View m14158a(Context context) {
            return new DailyDialogueBrandedBannerView(context);
        }
    }

    /* compiled from: gravity_gps_foreground_check_skipped */
    public class State {
        public final GraphQLImage f12155a;
        @Nullable
        public final Integer f12156b;
        public final boolean f12157c;
        public final GraphQLImage f12158d;

        public State(GraphQLImage graphQLImage, @Nullable Integer num, boolean z, GraphQLImage graphQLImage2) {
            this.f12155a = graphQLImage;
            this.f12156b = num;
            this.f12157c = z;
            this.f12158d = graphQLImage2;
        }
    }

    private static DailyDialogueBrandedBannerPartDefinition m14160b(InjectorLike injectorLike) {
        return new DailyDialogueBrandedBannerPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m14162a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Integer num;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        subParts.a(this.f12163c, new StylingData(feedProps, f12160b, 2130839797, -1));
        subParts.a(2131560877, this.f12164d, new Props(feedProps, MenuConfig.CLICKABLE));
        boolean z = graphQLGoodwillThrowbackPromotionFeedUnit.A() != null;
        GraphQLImage A = z ? graphQLGoodwillThrowbackPromotionFeedUnit.A() : graphQLGoodwillThrowbackPromotionFeedUnit.l();
        GraphQLImage z2 = graphQLGoodwillThrowbackPromotionFeedUnit.z();
        if (graphQLGoodwillThrowbackPromotionFeedUnit.w() == null || graphQLGoodwillThrowbackPromotionFeedUnit.w().a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.w().a().isEmpty()) {
            num = null;
        } else {
            num = Integer.valueOf((int) Long.parseLong(graphQLGoodwillThrowbackPromotionFeedUnit.w().a(), 16));
        }
        return new State(A, num, z, z2);
    }

    public final /* bridge */ /* synthetic */ void m14163a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1974347380);
        State state = (State) obj2;
        DailyDialogueBrandedBannerView dailyDialogueBrandedBannerView = (DailyDialogueBrandedBannerView) view;
        GraphQLImage graphQLImage = state.f12155a;
        boolean z = state.f12157c;
        CallerContext callerContext = this.f12165e;
        if (graphQLImage != null) {
            dailyDialogueBrandedBannerView.f12170e = graphQLImage;
            dailyDialogueBrandedBannerView.f12169d = z;
            dailyDialogueBrandedBannerView.f12166a.a(ImageUtil.a(graphQLImage), callerContext);
        }
        graphQLImage = state.f12158d;
        dailyDialogueBrandedBannerView.f12168c.a(ImageUtil.a(graphQLImage), this.f12165e);
        LayoutParams layoutParams = dailyDialogueBrandedBannerView.f12168c.getLayoutParams();
        layoutParams.height = graphQLImage.a();
        layoutParams.width = graphQLImage.c();
        Integer num = state.f12156b;
        dailyDialogueBrandedBannerView.f12167b.setGlyphColor(num != null ? ColorStateList.valueOf(num.intValue()) : null);
        Logger.a(8, EntryType.MARK_POP, 1014270101, a);
    }

    public static DailyDialogueBrandedBannerPartDefinition m14159a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueBrandedBannerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12162g) {
                DailyDialogueBrandedBannerPartDefinition dailyDialogueBrandedBannerPartDefinition;
                if (a2 != null) {
                    dailyDialogueBrandedBannerPartDefinition = (DailyDialogueBrandedBannerPartDefinition) a2.a(f12162g);
                } else {
                    dailyDialogueBrandedBannerPartDefinition = f12161f;
                }
                if (dailyDialogueBrandedBannerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14160b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12162g, b3);
                        } else {
                            f12161f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueBrandedBannerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public DailyDialogueBrandedBannerPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f12163c = backgroundPartDefinition;
        this.f12164d = menuButtonPartDefinition;
    }

    public final ViewType m14161a() {
        return f12159a;
    }

    public final boolean m14164a(Object obj) {
        return true;
    }
}
