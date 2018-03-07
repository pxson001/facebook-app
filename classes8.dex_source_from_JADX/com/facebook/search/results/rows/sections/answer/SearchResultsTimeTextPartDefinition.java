package com.facebook.search.results.rows.sections.answer;

import android.content.Context;
import android.view.View;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REVIEW_CREATOR */
public class SearchResultsTimeTextPartDefinition<E extends HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsTimeUnit>, State, E, SearchResultsTimeTextView> {
    public static final ViewType<SearchResultsTimeTextView> f23618a = new C25271();
    private static SearchResultsTimeTextPartDefinition f23619e;
    private static final Object f23620f = new Object();
    private final Clock f23621b;
    private final BackgroundPartDefinition f23622c;
    private final Locales f23623d;

    /* compiled from: REVIEW_CREATOR */
    final class C25271 extends ViewType<SearchResultsTimeTextView> {
        C25271() {
        }

        public final View m27279a(Context context) {
            return new SearchResultsTimeTextView(context);
        }
    }

    /* compiled from: REVIEW_CREATOR */
    public class State {
        public final String f23615a;
        public final String f23616b;
        public final String f23617c;

        public State(String str, String str2, String str3) {
            this.f23615a = str;
            this.f23616b = str2;
            this.f23617c = str3;
        }
    }

    private static SearchResultsTimeTextPartDefinition m27281b(InjectorLike injectorLike) {
        return new SearchResultsTimeTextPartDefinition((Clock) SystemClockMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike), Locales.a(injectorLike));
    }

    public final Object m27283a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        BackgroundPartDefinition backgroundPartDefinition = this.f23622c;
        Builder a = Builder.a();
        a.c = 12.0f;
        a = a;
        a.b = 12.0f;
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, a.i(), Position.BOTTOM));
        String str = ((SearchResultsTimeUnit) feedProps.a).f23554a;
        Date time = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a", this.f23623d.a());
        simpleDateFormat.setTimeZone(((SearchResultsTimeUnit) feedProps.a).f23555b);
        String format = simpleDateFormat.format(time);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE, MMMM dd, yyyy", this.f23623d.a());
        simpleDateFormat2.setTimeZone(((SearchResultsTimeUnit) feedProps.a).f23555b);
        String format2 = simpleDateFormat2.format(time);
        int offset = (((SearchResultsTimeUnit) feedProps.a).f23555b.getOffset(this.f23621b.a()) - Calendar.getInstance().getTimeZone().getOffset(this.f23621b.a())) / 3600000;
        String str2 = null;
        if (offset > 0) {
            str2 = hasContext.getContext().getResources().getQuantityString(2131689715, offset, new Object[]{Integer.valueOf(offset)});
        } else if (offset < 0) {
            str2 = hasContext.getContext().getResources().getQuantityString(2131689715, Math.abs(offset), new Object[]{Integer.valueOf(Math.abs(offset))});
        }
        return new State(hasContext.getContext().getResources().getString(2131239042, new Object[]{format, str}), format2, str2);
    }

    public final /* bridge */ /* synthetic */ void m27284a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -450293746);
        State state = (State) obj2;
        SearchResultsTimeTextView searchResultsTimeTextView = (SearchResultsTimeTextView) view;
        searchResultsTimeTextView.f23624a.setText(state.f23615a);
        searchResultsTimeTextView.f23625b.setText(state.f23616b);
        searchResultsTimeTextView.f23626c.setText(state.f23617c);
        Logger.a(8, EntryType.MARK_POP, 1629775049, a);
    }

    @Inject
    public SearchResultsTimeTextPartDefinition(Clock clock, BackgroundPartDefinition backgroundPartDefinition, Locales locales) {
        this.f23621b = clock;
        this.f23622c = backgroundPartDefinition;
        this.f23623d = locales;
    }

    public static SearchResultsTimeTextPartDefinition m27280a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTimeTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23620f) {
                SearchResultsTimeTextPartDefinition searchResultsTimeTextPartDefinition;
                if (a2 != null) {
                    searchResultsTimeTextPartDefinition = (SearchResultsTimeTextPartDefinition) a2.a(f23620f);
                } else {
                    searchResultsTimeTextPartDefinition = f23619e;
                }
                if (searchResultsTimeTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27281b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23620f, b3);
                        } else {
                            f23619e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTimeTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SearchResultsTimeTextView> m27282a() {
        return f23618a;
    }

    public final boolean m27285a(Object obj) {
        return true;
    }
}
