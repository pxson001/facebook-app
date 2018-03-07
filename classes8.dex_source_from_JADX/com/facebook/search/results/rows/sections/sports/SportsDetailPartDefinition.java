package com.facebook.search.results.rows.sections.sports;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.protocol.BatchedSearchLoader;
import com.facebook.search.results.environment.CanReplaceFeedItem;
import com.facebook.search.results.model.GameStatusHelper.GameStatus;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit.Team;
import com.facebook.search.results.rows.sections.sports.SportsModuleDetailsView.TeamSubViews;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREINSTALLED_APP */
public class SportsDetailPartDefinition<E extends HasPositionInformation & HasPersistentState & CanReplaceFeedItem> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsSportsUnit>, Void, E, SportsModuleDetailsView> {
    public static final ViewType<SportsModuleDetailsView> f25035a = new C26311();
    private static SportsDetailPartDefinition f25036j;
    private static final Object f25037k = new Object();
    public final AbstractFbErrorReporter f25038b;
    private final BatchedSearchLoader f25039c;
    private final BackgroundPartDefinition f25040d;
    public final TimeFormatUtil f25041e;
    private final ClickListenerPartDefinition f25042f;
    public final QeAccessor f25043g;
    public final SecureContextHelper f25044h;
    public final UriIntentMapper f25045i;

    /* compiled from: PREINSTALLED_APP */
    final class C26311 extends ViewType<SportsModuleDetailsView> {
        C26311() {
        }

        public final View m28360a(Context context) {
            return new SportsModuleDetailsView(context);
        }
    }

    private static SportsDetailPartDefinition m28364b(InjectorLike injectorLike) {
        return new SportsDetailPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), BatchedSearchLoader.m8259a(injectorLike), BackgroundPartDefinition.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    public final Object m28366a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final SearchResultsSportsUnit searchResultsSportsUnit = (SearchResultsSportsUnit) feedProps.a;
        subParts.a(this.f25040d, new StylingData(feedProps, PaddingStyle.q, Position.BOTTOM));
        if (searchResultsSportsUnit.f23543o == GraphQLGraphSearchResultRole.SPORT_ENTRY) {
            subParts.a(this.f25042f, new OnClickListener(this) {
                final /* synthetic */ SportsDetailPartDefinition f25029b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 420653168);
                    this.f25029b.f25044h.a(this.f25029b.f25045i.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.fg, searchResultsSportsUnit.f23530b, searchResultsSportsUnit.f23531c)), view.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 16812062, a);
                }
            });
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28367a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 85677055);
        m28363a((FeedProps) obj, (HasPositionInformation) anyEnvironment, (SportsModuleDetailsView) view);
        Logger.a(8, EntryType.MARK_POP, 1159717483, a);
    }

    public final void m28369b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SearchResultsSportsUnit searchResultsSportsUnit = (SearchResultsSportsUnit) ((FeedProps) obj).a;
        SportsDetailState sportsDetailState = (SportsDetailState) ((HasPersistentState) ((HasPositionInformation) anyEnvironment)).a(new SportsDetailStateKey(searchResultsSportsUnit), searchResultsSportsUnit);
        String str = sportsDetailState.f25046a;
        if (str != null) {
            BatchedSearchLoader batchedSearchLoader = this.f25039c;
            if (str != null && batchedSearchLoader.f7872d.containsKey(str)) {
                batchedSearchLoader.f7872d.remove(str);
            }
            sportsDetailState.f25046a = null;
        }
    }

    public static SportsDetailPartDefinition m28362a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsDetailPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25037k) {
                SportsDetailPartDefinition sportsDetailPartDefinition;
                if (a2 != null) {
                    sportsDetailPartDefinition = (SportsDetailPartDefinition) a2.a(f25037k);
                } else {
                    sportsDetailPartDefinition = f25036j;
                }
                if (sportsDetailPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28364b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25037k, b3);
                        } else {
                            f25036j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsDetailPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SportsDetailPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, BatchedSearchLoader batchedSearchLoader, BackgroundPartDefinition backgroundPartDefinition, TimeFormatUtil timeFormatUtil, ClickListenerPartDefinition clickListenerPartDefinition, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f25038b = abstractFbErrorReporter;
        this.f25039c = batchedSearchLoader;
        this.f25040d = backgroundPartDefinition;
        this.f25041e = timeFormatUtil;
        this.f25042f = clickListenerPartDefinition;
        this.f25043g = qeAccessor;
        this.f25044h = secureContextHelper;
        this.f25045i = uriIntentMapper;
    }

    public final ViewType<SportsModuleDetailsView> m28365a() {
        return f25035a;
    }

    public final boolean m28368a(Object obj) {
        return true;
    }

    private void m28363a(FeedProps<SearchResultsSportsUnit> feedProps, final E e, SportsModuleDetailsView sportsModuleDetailsView) {
        boolean z;
        CharSequence charSequence;
        final SearchResultsSportsUnit searchResultsSportsUnit = (SearchResultsSportsUnit) feedProps.a;
        boolean z2 = true;
        TeamSubViews teamSubViews = sportsModuleDetailsView.f25064e;
        Team team = searchResultsSportsUnit.f23533e;
        if (searchResultsSportsUnit.f23534f != GameStatus.PREGAME) {
            z = true;
        } else {
            z = false;
        }
        teamSubViews.m28376a(team, z);
        TeamSubViews teamSubViews2 = sportsModuleDetailsView.f25065f;
        Team team2 = searchResultsSportsUnit.f23532d;
        if (searchResultsSportsUnit.f23534f == GameStatus.PREGAME) {
            z2 = false;
        }
        teamSubViews2.m28376a(team2, z2);
        BetterTextView betterTextView = sportsModuleDetailsView.f25066g;
        if (searchResultsSportsUnit.f23534f == GameStatus.PREGAME) {
            charSequence = searchResultsSportsUnit.f23537i;
        } else {
            Object obj = searchResultsSportsUnit.f23536h;
        }
        betterTextView.setText(charSequence);
        sportsModuleDetailsView.f25067h.setText(searchResultsSportsUnit.f23542n);
        SportsDetailState sportsDetailState = (SportsDetailState) ((HasPersistentState) e).a(new SportsDetailStateKey(searchResultsSportsUnit), searchResultsSportsUnit);
        if (searchResultsSportsUnit.f23534f == GameStatus.ONGOING && sportsDetailState.f25046a == null) {
            sportsDetailState.f25046a = this.f25039c.m8261a(new Object(this) {
                public final /* synthetic */ SportsDetailPartDefinition f25031b;
            }, new Object(this) {
                public final /* synthetic */ SportsDetailPartDefinition f25034c;

                public final void m28361a(Object obj) {
                    GraphQLPage graphQLPage = (GraphQLPage) ((GraphQLResult) obj).e;
                    if (graphQLPage != null && graphQLPage.bR() != null) {
                        SearchResultsSportsUnit a = SearchResultsSportsUnit.m27209a(searchResultsSportsUnit, this.f25034c.f25041e.a(TimeFormatStyle.EXACT_TIME_DATE_DOT_STYLE, graphQLPage.bR().C() * 1000), graphQLPage.bR());
                        if (a != null) {
                            ((CanReplaceFeedItem) e).mo1241a(searchResultsSportsUnit, a);
                        }
                    }
                }
            });
        }
    }
}
