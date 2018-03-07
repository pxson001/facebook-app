package com.facebook.feedplugins.survey;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.spannable.PersistentSpannableWithoutLayoutInput;
import com.facebook.feedplugins.spannable.SpannableInTextViewPartDefinition;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
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
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_malware_scanner_send_installed_packages_event */
public class SurveyHeaderTitlePartDefinition extends BaseSinglePartDefinition<GraphQLSurveyFeedUnit, Void, HasPersistentState, TextView> {
    private static SurveyHeaderTitlePartDefinition f9904c;
    private static final Object f9905d = new Object();
    private final SpannableInTextViewPartDefinition f9906a;
    public final LinkifyUtil f9907b;

    /* compiled from: android_malware_scanner_send_installed_packages_event */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ SurveyHeaderTitlePartDefinition f9898a;
        private final String f9899b;
        private final GraphQLSurveyFeedUnit f9900c;

        public final Object m10268a() {
            ArrayNode a = FeedTrackableUtil.a(this.f9900c);
            GraphQLTextWithEntities x = this.f9900c.x();
            if (x == null || x.a() == null) {
                return new PersistentSpannable(null, false);
            }
            Spannable valueOf = SpannableString.valueOf(x.a());
            this.f9898a.f9907b.a(LinkifyUtilConverter.c(x), FlyoutClickSource.SUBTITLE, valueOf, FeedTrackableUtil.a(this.f9900c));
            this.f9898a.f9907b.a(LinkifyUtilConverter.d(x), valueOf, a);
            return new PersistentSpannable(valueOf, false);
        }

        public PersistentSpannableKey(SurveyHeaderTitlePartDefinition surveyHeaderTitlePartDefinition, GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
            this.f9898a = surveyHeaderTitlePartDefinition;
            this.f9899b = "survey:title:" + (graphQLSurveyFeedUnit.g() != null ? graphQLSurveyFeedUnit.g() : String.valueOf(graphQLSurveyFeedUnit.hashCode()));
            this.f9900c = graphQLSurveyFeedUnit;
        }

        public final Object m10269b() {
            return this.f9899b;
        }
    }

    /* compiled from: android_malware_scanner_send_installed_packages_event */
    class SpannableInput extends PersistentSpannableWithoutLayoutInput {
        final /* synthetic */ SurveyHeaderTitlePartDefinition f9901a;
        private final GraphQLSurveyFeedUnit f9902b;
        private final ContextStateKey<String, PersistentSpannable> f9903c;

        public SpannableInput(SurveyHeaderTitlePartDefinition surveyHeaderTitlePartDefinition, GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
            this.f9901a = surveyHeaderTitlePartDefinition;
            this.f9902b = graphQLSurveyFeedUnit;
            this.f9903c = new PersistentSpannableKey(surveyHeaderTitlePartDefinition, graphQLSurveyFeedUnit);
        }

        public final ContextStateKey<String, PersistentSpannable> m10271a() {
            return this.f9903c;
        }

        @Nullable
        public final GraphQLTextWithEntities m10272b() {
            return null;
        }

        public final CacheableEntity m10273c() {
            return this.f9902b;
        }

        public final int m10270a(Spannable spannable) {
            return 0;
        }
    }

    private static SurveyHeaderTitlePartDefinition m10275b(InjectorLike injectorLike) {
        return new SurveyHeaderTitlePartDefinition(SpannableInTextViewPartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final Object m10276a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9906a, new SpannableInput(this, (GraphQLSurveyFeedUnit) obj));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10277a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -814364572);
        ((TextView) view).setTag(2131558541, Boolean.valueOf(true));
        Logger.a(8, EntryType.MARK_POP, -2126371036, a);
    }

    public final void m10278b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TextView) view).setTag(2131558541, null);
    }

    @Inject
    public SurveyHeaderTitlePartDefinition(SpannableInTextViewPartDefinition spannableInTextViewPartDefinition, LinkifyUtil linkifyUtil) {
        this.f9906a = spannableInTextViewPartDefinition;
        this.f9907b = linkifyUtil;
    }

    public static SurveyHeaderTitlePartDefinition m10274a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SurveyHeaderTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9905d) {
                SurveyHeaderTitlePartDefinition surveyHeaderTitlePartDefinition;
                if (a2 != null) {
                    surveyHeaderTitlePartDefinition = (SurveyHeaderTitlePartDefinition) a2.a(f9905d);
                } else {
                    surveyHeaderTitlePartDefinition = f9904c;
                }
                if (surveyHeaderTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10275b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9905d, b3);
                        } else {
                            f9904c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = surveyHeaderTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
