package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.reactions.ui.TokenPileDrawable;
import com.facebook.feedback.reactions.ui.TokenPileHelper;
import com.facebook.feedplugins.worktrending.views.WorkTrendingRowView;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnitItem;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: allow_others_to_see_checked */
public class WorkTrendingRowPartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, WorkTrendingRowView> {
    public static final ViewType<WorkTrendingRowView> f10041a = new C11621();
    private static WorkTrendingRowPartDefinition f10042g;
    private static final Object f10043h = new Object();
    private final TextPartDefinition f10044b;
    private final Provider<TokenPileDrawable> f10045c;
    private final TokenPileHelper f10046d;
    private final NumberTruncationUtil f10047e;
    private final Resources f10048f;

    /* compiled from: allow_others_to_see_checked */
    final class C11621 extends ViewType<WorkTrendingRowView> {
        C11621() {
        }

        public final View m10388a(Context context) {
            return new WorkTrendingRowView(context);
        }
    }

    /* compiled from: allow_others_to_see_checked */
    public class Props {
        public final GraphQLWorkCommunityTrendingFeedUnitItem f10040a;

        public Props(GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem) {
            this.f10040a = graphQLWorkCommunityTrendingFeedUnitItem;
        }
    }

    private static WorkTrendingRowPartDefinition m10391b(InjectorLike injectorLike) {
        return new WorkTrendingRowPartDefinition(TextPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 1788), TokenPileHelper.a(injectorLike), NumberTruncationUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10393a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem = ((Props) obj).f10040a;
        TextPartDefinition textPartDefinition = this.f10044b;
        StyleSpan styleSpan = new StyleSpan(1);
        Object nullToEmpty = Strings.nullToEmpty(graphQLWorkCommunityTrendingFeedUnitItem.k());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(nullToEmpty);
        spannableStringBuilder.setSpan(styleSpan, 0, nullToEmpty.length(), 33);
        subParts.a(2131568568, textPartDefinition, spannableStringBuilder);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10394a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -904141883);
        m10390a((Props) obj, (WorkTrendingRowView) view);
        Logger.a(8, EntryType.MARK_POP, -1484781544, a);
    }

    public final boolean m10395a(Object obj) {
        return true;
    }

    public static WorkTrendingRowPartDefinition m10389a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10043h) {
                WorkTrendingRowPartDefinition workTrendingRowPartDefinition;
                if (a2 != null) {
                    workTrendingRowPartDefinition = (WorkTrendingRowPartDefinition) a2.a(f10043h);
                } else {
                    workTrendingRowPartDefinition = f10042g;
                }
                if (workTrendingRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10391b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10043h, b3);
                        } else {
                            f10042g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    WorkTrendingRowPartDefinition(TextPartDefinition textPartDefinition, Provider<TokenPileDrawable> provider, TokenPileHelper tokenPileHelper, NumberTruncationUtil numberTruncationUtil, Resources resources) {
        this.f10044b = textPartDefinition;
        this.f10045c = provider;
        this.f10046d = tokenPileHelper;
        this.f10047e = numberTruncationUtil;
        this.f10048f = resources;
    }

    public final ViewType<WorkTrendingRowView> m10392a() {
        return f10041a;
    }

    private void m10390a(Props props, WorkTrendingRowView workTrendingRowView) {
        GraphQLFeedback l = props.f10040a.j().l();
        TokenPileDrawable tokenPileDrawable = (TokenPileDrawable) this.f10045c.get();
        ImmutableList a = this.f10046d.a(l);
        tokenPileDrawable.a(a.subList(0, Math.min(2, a.size())));
        tokenPileDrawable.a(true);
        workTrendingRowView.f10052b.setImageDrawable(tokenPileDrawable);
        int q = GraphQLHelper.q(l);
        String a2 = this.f10047e.a(q);
        workTrendingRowView.f10052b.setText(this.f10048f.getQuantityString(2131689642, q, new Object[]{a2}));
    }
}
