package com.facebook.search.results.rows.sections.videos.topvideo;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
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
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PICKER_NUX_SEEN */
public class SearchVideoTimestampPartDefinition extends MultiRowSinglePartDefinition<SearchResultsVideoUnit, String, HasPositionInformation, BetterTextView> {
    private static SearchVideoTimestampPartDefinition f25303d;
    private static final Object f25304e = new Object();
    private final DefaultTimeFormatUtil f25305a;
    private final BackgroundPartDefinition f25306b;
    private final Context f25307c;

    private static SearchVideoTimestampPartDefinition m28547b(InjectorLike injectorLike) {
        return new SearchVideoTimestampPartDefinition(DefaultTimeFormatUtil.a(injectorLike), BackgroundPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m28549a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = ((SearchResultsVideoUnit) obj).f23550a;
        subParts.a(this.f25306b, new StylingData(null, PaddingStyle.e, Position.MIDDLE));
        return new SpannableStringBuilder().append(this.f25307c.getString(2131239055, new Object[]{StoryActorHelper.b(graphQLStory).aa()})).append(this.f25307c.getString(2131233658)).append(this.f25305a.a(TimeFormatStyle.EXACT_STREAM_RELATIVE_STYLE, graphQLStory.V() * 1000)).toString();
    }

    public final /* bridge */ /* synthetic */ void m28550a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1637165717);
        String str = (String) obj2;
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setTextAppearance(betterTextView.getContext(), 2131626188);
        betterTextView.setText(str);
        Logger.a(8, EntryType.MARK_POP, 926887211, a);
    }

    @Inject
    public SearchVideoTimestampPartDefinition(DefaultTimeFormatUtil defaultTimeFormatUtil, BackgroundPartDefinition backgroundPartDefinition, Context context) {
        this.f25305a = defaultTimeFormatUtil;
        this.f25306b = backgroundPartDefinition;
        this.f25307c = context;
    }

    public final ViewType m28548a() {
        return SearchResultsCommonViewTypes.f24003a;
    }

    public final boolean m28551a(Object obj) {
        return true;
    }

    public static SearchVideoTimestampPartDefinition m28546a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchVideoTimestampPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25304e) {
                SearchVideoTimestampPartDefinition searchVideoTimestampPartDefinition;
                if (a2 != null) {
                    searchVideoTimestampPartDefinition = (SearchVideoTimestampPartDefinition) a2.a(f25304e);
                } else {
                    searchVideoTimestampPartDefinition = f25303d;
                }
                if (searchVideoTimestampPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28547b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25304e, b3);
                        } else {
                            f25303d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchVideoTimestampPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
