package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackSection;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.fragments.GraphQLGoodwillThrowbackSectionFields;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: feed_unit_show_suggestifier_footer */
public class ThrowbackFeedStorySectionHeaderPartDefinition extends MultiRowSinglePartDefinition<Props, State, HasPositionInformation, ThrowbackFeedStorySectionHeaderView> {
    private static final PaddingStyle f13564b;
    private static final PaddingStyle f13565c;
    private static ThrowbackFeedStorySectionHeaderPartDefinition f13566d;
    private static final Object f13567e = new Object();
    private final BackgroundPartDefinition f13568a;

    /* compiled from: feed_unit_show_suggestifier_footer */
    public class Props implements HasFeedProps<FeedUnit>, HasFeedUnit {
        public FeedProps<? extends FeedUnit> f13557a;
        public GraphQLGoodwillThrowbackSection f13558b;
        public boolean f13559c;

        public Props(FeedProps<? extends FeedUnit> feedProps, GraphQLGoodwillThrowbackSectionFields graphQLGoodwillThrowbackSectionFields, boolean z) {
            this.f13557a = feedProps;
            this.f13558b = graphQLGoodwillThrowbackSectionFields;
            this.f13559c = z;
        }

        public final FeedUnit m15321c() {
            return (FeedUnit) this.f13557a.a;
        }

        public final FeedProps<? extends FeedUnit> m15322f() {
            return this.f13557a;
        }
    }

    /* compiled from: feed_unit_show_suggestifier_footer */
    public class State {
        public final String f13560a;
        public final String f13561b;
        public final Uri f13562c;
        public final boolean f13563d;

        public State(String str, String str2, Uri uri, boolean z) {
            this.f13560a = str;
            this.f13561b = str2;
            this.f13562c = uri;
            this.f13563d = z;
        }
    }

    private static ThrowbackFeedStorySectionHeaderPartDefinition m15324b(InjectorLike injectorLike) {
        return new ThrowbackFeedStorySectionHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m15326a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = props.f13558b;
        subParts.a(this.f13568a, new StylingData(props.f13557a, graphQLGoodwillThrowbackSection.b() != null ? f13564b : f13565c));
        return new State(graphQLGoodwillThrowbackSection.c().a(), graphQLGoodwillThrowbackSection.b() != null ? graphQLGoodwillThrowbackSection.b().a() : null, Uri.parse(graphQLGoodwillThrowbackSection.a().b()), props.f13559c);
    }

    public final /* bridge */ /* synthetic */ void m15327a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 570841972);
        State state = (State) obj2;
        ThrowbackFeedStorySectionHeaderView throwbackFeedStorySectionHeaderView = (ThrowbackFeedStorySectionHeaderView) view;
        CharSequence charSequence = state.f13560a;
        if (TextUtils.isEmpty(charSequence)) {
            throwbackFeedStorySectionHeaderView.f13572d.setVisibility(8);
        } else {
            throwbackFeedStorySectionHeaderView.f13572d.setText(charSequence);
            throwbackFeedStorySectionHeaderView.f13572d.setVisibility(0);
        }
        charSequence = state.f13561b;
        if (TextUtils.isEmpty(charSequence)) {
            throwbackFeedStorySectionHeaderView.f13573e.setVisibility(8);
        } else {
            throwbackFeedStorySectionHeaderView.f13573e.setText(charSequence);
            throwbackFeedStorySectionHeaderView.f13573e.setVisibility(0);
        }
        Uri uri = state.f13562c;
        if (uri != null) {
            throwbackFeedStorySectionHeaderView.f13571c.a(uri, ThrowbackFeedStorySectionHeaderView.f13570b);
            throwbackFeedStorySectionHeaderView.f13571c.setVisibility(0);
        }
        if (state.f13563d) {
            throwbackFeedStorySectionHeaderView.f13574f.setShowSegmentedDividers(4);
        } else {
            throwbackFeedStorySectionHeaderView.f13574f.setShowSegmentedDividers(0);
        }
        Logger.a(8, EntryType.MARK_POP, -927630192, a);
    }

    public final boolean m15328a(Object obj) {
        Props props = (Props) obj;
        GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = props.f13558b;
        return (props == null || props.m15321c() == null || graphQLGoodwillThrowbackSection == null || graphQLGoodwillThrowbackSection.c() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackSection.c().a()) || graphQLGoodwillThrowbackSection.a() == null || graphQLGoodwillThrowbackSection.a().b() == null) ? false : true;
    }

    public static ThrowbackFeedStorySectionHeaderPartDefinition m15323a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFeedStorySectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13567e) {
                ThrowbackFeedStorySectionHeaderPartDefinition throwbackFeedStorySectionHeaderPartDefinition;
                if (a2 != null) {
                    throwbackFeedStorySectionHeaderPartDefinition = (ThrowbackFeedStorySectionHeaderPartDefinition) a2.a(f13567e);
                } else {
                    throwbackFeedStorySectionHeaderPartDefinition = f13566d;
                }
                if (throwbackFeedStorySectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15324b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13567e, b3);
                        } else {
                            f13566d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFeedStorySectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    static {
        Builder d = Builder.d();
        d.b = 12.0f;
        f13564b = d.i();
        d = Builder.d();
        d.b = 12.0f;
        d = d;
        d.c = 8.0f;
        f13565c = d.i();
    }

    @Inject
    public ThrowbackFeedStorySectionHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f13568a = backgroundPartDefinition;
    }

    public final ViewType m15325a() {
        return ThrowbackFeedStorySectionHeaderView.f13569a;
    }
}
