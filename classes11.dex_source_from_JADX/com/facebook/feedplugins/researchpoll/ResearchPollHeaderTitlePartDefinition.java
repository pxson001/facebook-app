package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ufiservices.util.LinkifyUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: call_to_action_enabled */
public class ResearchPollHeaderTitlePartDefinition<E extends HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<GraphQLResearchPollFeedUnit, Void, E, ContentTextView> {
    private static ResearchPollHeaderTitlePartDefinition f9062c;
    private static final Object f9063d = new Object();
    private final SpannableInTextViewPartDefinition<E> f9064a;
    public final LinkifyUtil f9065b;

    /* compiled from: call_to_action_enabled */
    class ResearchHeaderTitlePersistentSpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ ResearchPollHeaderTitlePartDefinition f9059a;
        private final GraphQLResearchPollFeedUnit f9060b;
        private final ContextStateKey<String, PersistentSpannable> f9061c;

        public ResearchHeaderTitlePersistentSpannableInput(ResearchPollHeaderTitlePartDefinition researchPollHeaderTitlePartDefinition, GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
            this.f9059a = researchPollHeaderTitlePartDefinition;
            this.f9060b = graphQLResearchPollFeedUnit;
            this.f9061c = new PollTitlePersistentSpannableKey(graphQLResearchPollFeedUnit, researchPollHeaderTitlePartDefinition.f9065b);
        }

        public final ContextStateKey<String, PersistentSpannable> m9753a() {
            return this.f9061c;
        }

        @Nullable
        public final GraphQLTextWithEntities m9754b() {
            return null;
        }

        public final CacheableEntity m9755c() {
            return this.f9060b;
        }

        public final int m9752a(Spannable spannable) {
            return 0;
        }
    }

    private static ResearchPollHeaderTitlePartDefinition m9757b(InjectorLike injectorLike) {
        return new ResearchPollHeaderTitlePartDefinition(SpannableInTextViewPartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final Object m9758a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9064a, new ResearchHeaderTitlePersistentSpannableInput(this, (GraphQLResearchPollFeedUnit) obj));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9759a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1993315947);
        ((ContentTextView) view).setTag(2131558541, Boolean.valueOf(true));
        Logger.a(8, EntryType.MARK_POP, -2097713166, a);
    }

    @Inject
    public ResearchPollHeaderTitlePartDefinition(SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, LinkifyUtil linkifyUtil) {
        this.f9064a = spannableInTextViewPartDefinition;
        this.f9065b = linkifyUtil;
    }

    public static ResearchPollHeaderTitlePartDefinition m9756a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollHeaderTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9063d) {
                ResearchPollHeaderTitlePartDefinition researchPollHeaderTitlePartDefinition;
                if (a2 != null) {
                    researchPollHeaderTitlePartDefinition = (ResearchPollHeaderTitlePartDefinition) a2.a(f9063d);
                } else {
                    researchPollHeaderTitlePartDefinition = f9062c;
                }
                if (researchPollHeaderTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9757b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9063d, b3);
                        } else {
                            f9062c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollHeaderTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
