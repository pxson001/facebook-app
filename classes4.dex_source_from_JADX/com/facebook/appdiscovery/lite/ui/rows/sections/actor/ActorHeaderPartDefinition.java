package com.facebook.appdiscovery.lite.ui.rows.sections.actor;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.appdiscovery.lite.ui.rows.sections.baseparts.HeaderThumbnailClickListenerPartDefintion;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.SpannableUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.HeaderView;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nux_history_decode_fail */
public class ActorHeaderPartDefinition extends MultiRowSinglePartDefinition<AppDetailsFeedUnit, Spannable, AnyEnvironment, HeaderView> {
    public static final ViewType f6493a = new C02931();
    private static ActorHeaderPartDefinition f6494h;
    private static final Object f6495i = new Object();
    private final HeaderThumbnailClickListenerPartDefintion f6496b;
    private final ClickListenerPartDefinition f6497c;
    public final SecureContextHelper f6498d;
    public final AnalyticsLogger f6499e;
    public final Context f6500f;
    public final TimeFormatUtil f6501g;

    /* compiled from: nux_history_decode_fail */
    final class C02931 extends ViewType {
        C02931() {
        }

        public final View m6920a(Context context) {
            return new HeaderView(context);
        }
    }

    private static ActorHeaderPartDefinition m6915b(InjectorLike injectorLike) {
        return new ActorHeaderPartDefinition(new HeaderThumbnailClickListenerPartDefintion(), ClickListenerPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike));
    }

    public final Object m6917a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) obj;
        OnClickListener 2 = new 2(this, appDetailsFeedUnit);
        subParts.a(this.f6496b, 2);
        subParts.a(2131562765, this.f6497c, 2);
        SpannableString spannableString = new SpannableString(appDetailsFeedUnit.d.b());
        3 3 = new 3(this, 2);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(this.f6500f, 2131626315);
        SpannableUtil.a(0, spannableString.length(), spannableString, new Object[]{3, textAppearanceSpan});
        return spannableString;
    }

    public final /* bridge */ /* synthetic */ void m6918a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -388673379);
        m6914a((AppDetailsFeedUnit) obj, (Spannable) obj2, (HeaderView) view);
        Logger.a(8, EntryType.MARK_POP, -2103573131, a);
    }

    public final boolean m6919a(Object obj) {
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) obj;
        return (appDetailsFeedUnit.d == null || StringUtil.a(appDetailsFeedUnit.d.b())) ? false : true;
    }

    public static ActorHeaderPartDefinition m6913a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActorHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6495i) {
                ActorHeaderPartDefinition actorHeaderPartDefinition;
                if (a2 != null) {
                    actorHeaderPartDefinition = (ActorHeaderPartDefinition) a2.a(f6495i);
                } else {
                    actorHeaderPartDefinition = f6494h;
                }
                if (actorHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6915b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6495i, b3);
                        } else {
                            f6494h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = actorHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ActorHeaderPartDefinition(HeaderThumbnailClickListenerPartDefintion headerThumbnailClickListenerPartDefintion, ClickListenerPartDefinition clickListenerPartDefinition, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Context context, TimeFormatUtil timeFormatUtil) {
        this.f6496b = headerThumbnailClickListenerPartDefintion;
        this.f6497c = clickListenerPartDefinition;
        this.f6498d = secureContextHelper;
        this.f6499e = analyticsLogger;
        this.f6500f = context;
        this.f6501g = timeFormatUtil;
    }

    public final ViewType m6916a() {
        return f6493a;
    }

    private void m6914a(AppDetailsFeedUnit appDetailsFeedUnit, Spannable spannable, HeaderView headerView) {
        headerView.setMenuButtonActive(false);
        if (appDetailsFeedUnit.t() != null) {
            headerView.setThumbnailUri(Uri.parse(appDetailsFeedUnit.t()));
        }
        headerView.a(spannable, Sponsored.NOT_SPONSORED);
        headerView.setPadding(SizeUtil.a(this.f6500f, 6.0f), 0, 0, Math.round(this.f6500f.getResources().getDimension(2131427416)));
        headerView.setBackgroundColor(this.f6500f.getResources().getColor(2131361920));
        if (appDetailsFeedUnit.v() != null) {
            headerView.a(this.f6501g.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * appDetailsFeedUnit.v().longValue()), null);
        }
    }
}
