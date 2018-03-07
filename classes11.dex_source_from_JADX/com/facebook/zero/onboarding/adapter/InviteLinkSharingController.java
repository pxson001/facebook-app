package com.facebook.zero.onboarding.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fig.bottomsheet.FigBottomSheetAdapter;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.funnellogger.PayloadBundle;
import com.facebook.graphql.calls.AssistedRegSendInviteWithSourceInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.facebook.widget.text.BetterTextView;
import com.facebook.zero.onboarding.graphql.AssistedOnboarding;
import com.facebook.zero.onboarding.graphql.AssistedOnboarding.AssistedRegSendInviteWithSourceString;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: model is null */
public class InviteLinkSharingController {
    public static final Intent f5357a = new Intent("android.intent.action.SEND").setType("text/plain");
    private final GraphQLQueryExecutor f5358b;
    public final SecureContextHelper f5359c;
    private final Provider<String> f5360d;
    private final Lazy<FbPhoneNumberUtils> f5361e;
    public final Lazy<ToastThreadUtil> f5362f;
    public final FunnelLoggerImpl f5363g;

    public static InviteLinkSharingController m6597b(InjectorLike injectorLike) {
        return new InviteLinkSharingController((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedLazy.a(injectorLike, 3494), FunnelLoggerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 11511), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public InviteLinkSharingController(SecureContextHelper secureContextHelper, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<FbPhoneNumberUtils> lazy, FunnelLogger funnelLogger, Lazy<ToastThreadUtil> lazy2, Provider<String> provider) {
        this.f5359c = secureContextHelper;
        this.f5360d = provider;
        this.f5361e = lazy;
        this.f5358b = graphQLQueryExecutor;
        this.f5362f = lazy2;
        this.f5363g = funnelLogger;
    }

    public final FigBottomSheetAdapter m6598a(final Context context, final String str) {
        FigBottomSheetAdapter figBottomSheetAdapter = new FigBottomSheetAdapter(context);
        figBottomSheetAdapter.d = true;
        figBottomSheetAdapter.i = true;
        View inflate = LayoutInflater.from(context).inflate(2130903289, null, false);
        BetterTextView betterTextView = (BetterTextView) inflate.findViewById(2131559693);
        BetterTextView betterTextView2 = (BetterTextView) inflate.findViewById(2131559694);
        CharSequence string = context.getResources().getString(2131241775, new Object[]{m6599a()});
        betterTextView.setText(Html.fromHtml(string));
        betterTextView.setContentDescription(string);
        CharSequence string2 = context.getResources().getString(2131241776, new Object[]{str});
        betterTextView2.setText(Html.fromHtml(string2));
        betterTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        betterTextView2.setContentDescription(string2);
        figBottomSheetAdapter.a(inflate, context.getResources().getDimension(2131434154));
        MenuItemImpl a = figBottomSheetAdapter.a(context.getResources().getString(2131241782));
        a.setIcon(2130839954);
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteLinkSharingController f5352b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f5352b.f5363g.a(FunnelRegistry.F, "share_action_click", "copy_link_tag");
                ClipboardUtil.a(context, this.f5352b.m6599a());
                ((ToastThreadUtil) this.f5352b.f5362f.get()).a(context.getResources().getString(2131241783));
                return true;
            }
        });
        PackageManager packageManager = context.getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(f5357a, 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            final ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            if (resolveInfo.activityInfo == null || !resolveInfo.activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                MenuItemImpl a2 = figBottomSheetAdapter.a(resolveInfo.loadLabel(packageManager).toString());
                a2.setIcon(resolveInfo.loadIcon(packageManager));
                a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ InviteLinkSharingController f5356d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String a = this.f5356d.m6599a();
                        PackageItemInfo packageItemInfo = resolveInfo.activityInfo;
                        Intent intent = new Intent(InviteLinkSharingController.f5357a);
                        intent.putExtra("android.intent.extra.TEXT", context.getResources().getString(2131241784, new Object[]{str, a}));
                        intent.setClassName(packageItemInfo.packageName, packageItemInfo.name);
                        intent.setFlags(268435456);
                        PayloadBundle a2 = PayloadBundle.a();
                        a2.a("link", a);
                        this.f5356d.f5363g.a(FunnelRegistry.F, "share_action_click", packageItemInfo.packageName, a2);
                        this.f5356d.f5359c.b(intent, context);
                        return true;
                    }
                });
            }
        }
        return figBottomSheetAdapter;
    }

    public final String m6599a() {
        String a = MathUtil.a(Long.parseLong((String) this.f5360d.get()));
        return StringFormatUtil.a("fb.com/reg?i=%s", new Object[]{a}) + "&";
    }

    public final boolean m6600a(String str) {
        PhoneNumber a = ((FbPhoneNumberUtils) this.f5361e.get()).a(str);
        if (a == null) {
            return false;
        }
        AssistedRegSendInviteWithSourceInputData a2 = new AssistedRegSendInviteWithSourceInputData().a("top_up").b("top_up").c(a.rawInput_).a(Integer.valueOf(5));
        AssistedRegSendInviteWithSourceString a3 = AssistedOnboarding.m6616a();
        a3.a("input", a2);
        this.f5358b.a(GraphQLRequest.a(a3));
        return true;
    }
}
