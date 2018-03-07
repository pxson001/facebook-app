package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedplugins.worktrending.views.WorkTrendingPageView;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnit;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnitItem;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.app.ActivityManagerNative */
public class WorkTrendingPagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, AnyEnvironment, WorkTrendingPageView> {
    public static final ViewType<WorkTrendingPageView> f10035a = new C11611();
    private static WorkTrendingPagePartDefinition f10036d;
    private static final Object f10037e = new Object();
    private final TextPartDefinition f10038b;
    private final PillsBlingBarPartDefinitionHelper f10039c;

    /* compiled from: android.app.ActivityManagerNative */
    final class C11611 extends ViewType<WorkTrendingPageView> {
        C11611() {
        }

        public final View m10382a(Context context) {
            return new WorkTrendingPageView(context);
        }
    }

    /* compiled from: android.app.ActivityManagerNative */
    public class Props {
        public final GraphQLWorkCommunityTrendingFeedUnit f10033a;
        public final GraphQLWorkCommunityTrendingFeedUnitItem f10034b;

        public Props(GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit, GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem) {
            this.f10033a = graphQLWorkCommunityTrendingFeedUnit;
            this.f10034b = graphQLWorkCommunityTrendingFeedUnitItem;
        }
    }

    private static WorkTrendingPagePartDefinition m10384b(InjectorLike injectorLike) {
        return new WorkTrendingPagePartDefinition(TextPartDefinition.a(injectorLike), PillsBlingBarPartDefinitionHelper.a(injectorLike));
    }

    public final Object m10386a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem = ((Props) obj).f10034b;
        TextPartDefinition textPartDefinition = this.f10038b;
        StyleSpan styleSpan = new StyleSpan(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StoryHierarchyHelper.b(graphQLWorkCommunityTrendingFeedUnitItem.j()).a());
        spannableStringBuilder.setSpan(styleSpan, 0, StoryHierarchyHelper.b(graphQLWorkCommunityTrendingFeedUnitItem.j()).a().length(), 33);
        subParts.a(2131568570, textPartDefinition, spannableStringBuilder);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10387a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1112522168);
        PillsBlingBarPartDefinitionHelper.a(((Props) obj).f10034b.j().l(), Integer.valueOf(0), ((WorkTrendingPageView) view).f10050b);
        Logger.a(8, EntryType.MARK_POP, -745814038, a);
    }

    @Inject
    public WorkTrendingPagePartDefinition(TextPartDefinition textPartDefinition, PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper) {
        this.f10038b = textPartDefinition;
        this.f10039c = pillsBlingBarPartDefinitionHelper;
    }

    public static WorkTrendingPagePartDefinition m10383a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10037e) {
                WorkTrendingPagePartDefinition workTrendingPagePartDefinition;
                if (a2 != null) {
                    workTrendingPagePartDefinition = (WorkTrendingPagePartDefinition) a2.a(f10037e);
                } else {
                    workTrendingPagePartDefinition = f10036d;
                }
                if (workTrendingPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10384b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10037e, b3);
                        } else {
                            f10036d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<WorkTrendingPageView> m10385a() {
        return f10035a;
    }
}
