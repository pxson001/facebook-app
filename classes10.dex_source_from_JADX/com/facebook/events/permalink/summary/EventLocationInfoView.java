package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.messaging.business.ride.utils.RideshareUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: background_location_one_page_nux_select_privacy_failure */
public class EventLocationInfoView extends FbTextView implements OnClickListener, EventPermalinkSummaryRow {
    @Inject
    AppInfo f18887a;
    @Inject
    public AnalyticsLogger f18888b;
    @Inject
    EventEventLogger f18889c;
    @Inject
    ExternalMapLauncher f18890d;
    @Inject
    GraphQLLinkExtractor f18891e;
    @Inject
    Provider<IFeedIntentBuilder> f18892f;
    @Inject
    QeAccessor f18893g;
    @Inject
    public SecureContextHelper f18894h;
    @Inject
    EventSummaryRowBuilder f18895i;
    @Inject
    RideshareUtil f18896j;
    public Event f18897k;
    public EventAnalyticsParams f18898l;

    /* compiled from: background_location_one_page_nux_select_privacy_failure */
    class C26824 implements OnCancelListener {
        final /* synthetic */ EventLocationInfoView f18880a;

        C26824(EventLocationInfoView eventLocationInfoView) {
            this.f18880a = eventLocationInfoView;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f18880a.f18889c.m18143c("event_location_summary_cancel", this.f18880a.f18897k.a, this.f18880a.f18898l.b.e.getParamValue(), this.f18880a.f18898l.b.f.getParamValue());
        }
    }

    public static void m19142a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventLocationInfoView) obj).m19141a(AppInfo.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), EventEventLogger.m18119b(fbInjector), ExternalMapLauncher.a(fbInjector), GraphQLLinkExtractor.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 2347), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), EventSummaryRowBuilder.m19164b(fbInjector), RideshareUtil.a(fbInjector));
    }

    private void m19141a(AppInfo appInfo, AnalyticsLogger analyticsLogger, EventEventLogger eventEventLogger, ExternalMapLauncher externalMapLauncher, GraphQLLinkExtractor graphQLLinkExtractor, Provider<IFeedIntentBuilder> provider, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, EventSummaryRowBuilder eventSummaryRowBuilder, RideshareUtil rideshareUtil) {
        this.f18887a = appInfo;
        this.f18888b = analyticsLogger;
        this.f18889c = eventEventLogger;
        this.f18890d = externalMapLauncher;
        this.f18891e = graphQLLinkExtractor;
        this.f18892f = provider;
        this.f18893g = qeAccessor;
        this.f18894h = secureContextHelper;
        this.f18895i = eventSummaryRowBuilder;
        this.f18896j = rideshareUtil;
    }

    public EventLocationInfoView(Context context) {
        super(context);
        Class cls = EventLocationInfoView.class;
        m19142a((Object) this, getContext());
        setOnClickListener(this);
    }

    public final void mo851a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        String str;
        this.f18897k = event;
        this.f18898l = eventAnalyticsParams;
        CharSequence charSequence = this.f18897k.P;
        String str2 = this.f18897k.Q;
        if (StringUtil.a(str2)) {
            str = null;
        } else {
            String str3 = "\n";
            str = str2.replaceAll(str3, getContext().getString(2131236994, new Object[]{"", ""}));
        }
        this.f18895i.m19166a((TextView) this, charSequence, (CharSequence) str, z);
        this.f18895i.m19165a(this, 2130838282, z);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1247257909);
        ActionSheetDialogBuilder actionSheetDialogBuilder = new ActionSheetDialogBuilder(getContext());
        final String str = this.f18897k.P;
        final String str2 = this.f18897k.Q;
        final int i = this.f18897k.S;
        if (i == 2479791) {
            actionSheetDialogBuilder.a(getContext().getString(2131236997), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventLocationInfoView f18875b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Context context = this.f18875b.getContext();
                    this.f18875b.f18889c.m18143c("event_location_summary_open_page", this.f18875b.f18897k.a, this.f18875b.f18898l.b.e.getParamValue(), this.f18875b.f18898l.b.f.getParamValue());
                    this.f18875b.f18894h.a(((IFeedIntentBuilder) this.f18875b.f18892f.get()).b(context, GraphQLLinkExtractor.a(i, new Object[]{Long.valueOf(this.f18875b.f18897k.O)})), context);
                }
            });
        }
        if (this.f18897k.P()) {
            String string = getContext().getString(2131236998);
            final Event event = this.f18897k;
            actionSheetDialogBuilder.a(string, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventLocationInfoView f18882b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f18882b.f18889c.m18143c("event_location_summary_open_maps", event.a, this.f18882b.f18898l.b.e.getParamValue(), this.f18882b.f18898l.b.f.getParamValue());
                    this.f18882b.f18890d.a(this.f18882b.getContext(), CurationSurface.NATIVE_EVENT.toString(), event.Q(), event.R(), event.P, event.Q);
                }
            });
            if (!Strings.isNullOrEmpty(str) && this.f18893g.a(ExperimentsForEventsGatingModule.I, false) && this.f18887a.e("com.ubercab")) {
                string = getContext().getString(2131236999);
                event = this.f18897k;
                actionSheetDialogBuilder.a(string, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EventLocationInfoView f18884b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ImmutableLocation a = ImmutableLocation.a(event.Q(), event.R()).a();
                        EventLocationInfoView eventLocationInfoView = this.f18884b;
                        String str = event.a;
                        String str2 = event.P;
                        String str3 = event.Q;
                        eventLocationInfoView.f18894h.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("uber://?action=setPickup").buildUpon().appendQueryParameter("client_id", "vCKSz9ulPV-fu56O6kQlOLW0hEJL7wzb").appendQueryParameter("pickup", "my_location").appendQueryParameter("dropoff[latitude]", Double.toString(a.a())).appendQueryParameter("dropoff[longitude]", Double.toString(a.b())).appendQueryParameter("dropoff[nickname]", str2).build()), eventLocationInfoView.getContext());
                        HoneyClientEventFast a2 = eventLocationInfoView.f18888b.a("event_location_summary_open_in_uber", true);
                        if (a2.a()) {
                            a2.a("event_permalink").b("Event").c(str).a("source_module", eventLocationInfoView.f18898l.d).a("ref_module", eventLocationInfoView.f18898l.c).b();
                        }
                    }
                });
            }
            if (this.f18893g.a(ExperimentsForEventsGatingModule.J, false) && this.f18896j.a()) {
                string = getContext().getString(2131237000);
                event = this.f18897k;
                actionSheetDialogBuilder.a(string, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EventLocationInfoView f18886b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ImmutableLocation a = ImmutableLocation.a(event.Q(), event.R()).a();
                        EventLocationInfoView eventLocationInfoView = this.f18886b;
                        String str = event.a;
                        Uri a2 = RideshareUtil.a(event.Q, Double.valueOf(a.a()), Double.valueOf(a.b()), null, "events_order_ride");
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(a2);
                        eventLocationInfoView.f18894h.a(intent, eventLocationInfoView.getContext());
                        HoneyClientEventFast a3 = eventLocationInfoView.f18888b.a("event_location_summary_order_ride", true);
                        if (a3.a()) {
                            a3.a("event_permalink").b("Event").c(str).a("source_module", eventLocationInfoView.f18898l.d).a("ref_module", eventLocationInfoView.f18898l.c).b();
                        }
                    }
                });
            }
        }
        if (!Strings.isNullOrEmpty(str2)) {
            actionSheetDialogBuilder.a(getContext().getString(2131237002), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventLocationInfoView f18877b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f18877b.f18889c.m18143c("event_location_summary_copy_address", this.f18877b.f18897k.a, this.f18877b.f18898l.b.e.getParamValue(), this.f18877b.f18898l.b.f.getParamValue());
                    ClipboardUtil.a(this.f18877b.getContext(), str2);
                }
            });
        } else if (!Strings.isNullOrEmpty(str)) {
            actionSheetDialogBuilder.a(getContext().getString(2131237003), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventLocationInfoView f18879b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f18879b.f18889c.m18143c("event_location_summary_copy_location", this.f18879b.f18897k.a, this.f18879b.f18898l.b.e.getParamValue(), this.f18879b.f18898l.b.f.getParamValue());
                    ClipboardUtil.a(this.f18879b.getContext(), str);
                }
            });
        }
        actionSheetDialogBuilder.setOnCancelListener(new C26824(this));
        actionSheetDialogBuilder.show();
        LogUtils.a(1109390881, a);
    }

    public final boolean mo852a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        return !StringUtil.a(event.P);
    }
}
