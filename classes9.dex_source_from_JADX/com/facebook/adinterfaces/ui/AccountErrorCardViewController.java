package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateAccountEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLAdAccountStatus;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import java.text.NumberFormat;
import java.util.Currency;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VaultSyncJobProcessor onStartCommand */
public class AccountErrorCardViewController extends BaseAdInterfacesViewController<TextWithEntitiesView, BaseAdInterfacesData> {
    private final QeAccessor f22441a;
    public BaseAdInterfacesData f22442b;
    public TextWithEntitiesView f22443c;

    /* compiled from: VaultSyncJobProcessor onStartCommand */
    class C25561 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ AccountErrorCardViewController f22435a;

        C25561(AccountErrorCardViewController accountErrorCardViewController) {
            this.f22435a = accountErrorCardViewController;
        }

        public final void m24303b(FbEvent fbEvent) {
            AccountErrorCardViewController.m24313b(this.f22435a);
        }
    }

    /* compiled from: VaultSyncJobProcessor onStartCommand */
    class C25572 implements IntentHandler {
        final /* synthetic */ AccountErrorCardViewController f22436a;

        C25572(AccountErrorCardViewController accountErrorCardViewController) {
            this.f22436a = accountErrorCardViewController;
        }

        public final void mo980a(int i, Intent intent) {
            this.f22436a.f22440b.m22429a(new InvalidateAccountEvent(this.f22436a.f22442b.m22853i()));
        }
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        super.mo982a(textWithEntitiesView, adInterfacesCardLayout);
        this.f22443c = textWithEntitiesView;
        this.f22440b.m22430a(new C25561(this));
        this.f22440b.m22428a(6, new C25572(this));
        m24313b(this);
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22442b = baseAdInterfacesData;
    }

    @Inject
    public AccountErrorCardViewController(QeAccessor qeAccessor) {
        this.f22441a = qeAccessor;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22443c = null;
    }

    public static void m24313b(AccountErrorCardViewController accountErrorCardViewController) {
        if (accountErrorCardViewController.f22443c != null) {
            AdAccountModel e = AdInterfacesDataHelper.m22806e(accountErrorCardViewController.f22442b);
            if (e == null || e.m23138l() != GraphQLAdAccountStatus.UNSETTLED) {
                accountErrorCardViewController.f22443c.setVisibility(8);
                return;
            }
            TextWithEntitiesView textWithEntitiesView = accountErrorCardViewController.f22443c;
            CurrencyQuantityModel o = e.m23141o();
            final Resources resources = accountErrorCardViewController.f22443c.getResources();
            textWithEntitiesView.setText(new StyledStringBuilder(resources).a(resources.getString(accountErrorCardViewController.f22442b.mo962b() == ObjectiveType.BOOST_POST ? 2131234060 : 2131234061, new Object[]{"{balance}", "{link}"})).a("{balance}", m24312b(o), new StyleSpan(1), 33).a("{link}", resources.getString(2131234062), new ClickableSpan(accountErrorCardViewController) {
                final /* synthetic */ AccountErrorCardViewController f22438b;

                public void onClick(View view) {
                    BaseAdInterfacesViewController baseAdInterfacesViewController = this.f22438b;
                    AdInterfacesContext adInterfacesContext = baseAdInterfacesViewController.f22440b;
                    String entryPoint = baseAdInterfacesViewController.f22442b.mo962b().getEntryPoint();
                    String a = FBLinks.a("close/");
                    Uri build = new Builder().scheme("https").authority("m.facebook.com").appendPath("ads").appendPath("payments").appendPath("settle").appendQueryParameter("ad_account_id", baseAdInterfacesViewController.f22442b.m22853i()).appendQueryParameter("entry_point", entryPoint).appendQueryParameter("success_uri", a).appendQueryParameter("cancel_uri", a).build();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(build);
                    intent.putExtra("force_in_app_browser", true);
                    adInterfacesContext.m22429a(new IntentEvent(intent, 6, false));
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(resources.getColor(2131361996));
                }
            }, 33).b());
            accountErrorCardViewController.f22443c.setMovementMethod(LinkMovementMethod.getInstance());
            accountErrorCardViewController.f22443c.setVisibility(0);
        }
    }

    public static String m24312b(CurrencyQuantityModel currencyQuantityModel) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(currencyQuantityModel.m23419a()));
        return currencyInstance.format(Double.parseDouble(currencyQuantityModel.m23422k()) / 100.0d);
    }
}
