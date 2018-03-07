package com.facebook.feedplugins.hpp;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelHeaderView;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
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
import java.util.Calendar;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_field_value */
public class MobilePageAdminPanelHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLMobilePageAdminPanelFeedUnit>, State, HasPositionInformation, MobilePageAdminPanelHeaderView> {
    public static final ViewType f7789a = new C09881();
    private static MobilePageAdminPanelHeaderPartDefinition f7790e;
    private static final Object f7791f = new Object();
    private final BackgroundPartDefinition f7792b;
    private final BasicDateTimeFormat f7793c;
    private final Resources f7794d;

    /* compiled from: custom_field_value */
    final class C09881 extends ViewType {
        C09881() {
        }

        public final View m8955a(Context context) {
            return new MobilePageAdminPanelHeaderView(context);
        }
    }

    /* compiled from: custom_field_value */
    public class State {
        public final String f7787a;
        public final String f7788b;

        public State(String str, String str2) {
            this.f7787a = str;
            this.f7788b = str2;
        }
    }

    private static MobilePageAdminPanelHeaderPartDefinition m8957b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), BasicDateTimeFormat.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m8960a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = (GraphQLMobilePageAdminPanelFeedUnit) feedProps.a;
        subParts.a(this.f7792b, new StylingData(feedProps, PaddingStyle.e));
        String str = null;
        if (!(graphQLMobilePageAdminPanelFeedUnit.s() == null || graphQLMobilePageAdminPanelFeedUnit.s().a() == null)) {
            str = graphQLMobilePageAdminPanelFeedUnit.s().a();
        }
        return new State(str, m8958c());
    }

    public final /* bridge */ /* synthetic */ void m8961a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1261498597);
        State state = (State) obj2;
        MobilePageAdminPanelHeaderView mobilePageAdminPanelHeaderView = (MobilePageAdminPanelHeaderView) view;
        mobilePageAdminPanelHeaderView.f7812a.setText(state.f7787a);
        mobilePageAdminPanelHeaderView.f7813b.setText(state.f7788b);
        Logger.a(8, EntryType.MARK_POP, 227730055, a);
    }

    @Inject
    public MobilePageAdminPanelHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, BasicDateTimeFormat basicDateTimeFormat, Resources resources) {
        this.f7792b = backgroundPartDefinition;
        this.f7793c = basicDateTimeFormat;
        this.f7794d = resources;
    }

    public static MobilePageAdminPanelHeaderPartDefinition m8956a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7791f) {
                MobilePageAdminPanelHeaderPartDefinition mobilePageAdminPanelHeaderPartDefinition;
                if (a2 != null) {
                    mobilePageAdminPanelHeaderPartDefinition = (MobilePageAdminPanelHeaderPartDefinition) a2.a(f7791f);
                } else {
                    mobilePageAdminPanelHeaderPartDefinition = f7790e;
                }
                if (mobilePageAdminPanelHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8957b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7791f, b3);
                        } else {
                            f7790e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m8959a() {
        return f7789a;
    }

    public final boolean m8962a(Object obj) {
        return true;
    }

    private String m8958c() {
        Calendar instance = Calendar.getInstance();
        while (instance.get(7) > instance.getFirstDayOfWeek()) {
            instance.add(5, -1);
        }
        return this.f7794d.getString(2131242483, new Object[]{this.f7793c.e().format(Long.valueOf(instance.getTimeInMillis()))}).toUpperCase(Locale.getDefault());
    }
}
