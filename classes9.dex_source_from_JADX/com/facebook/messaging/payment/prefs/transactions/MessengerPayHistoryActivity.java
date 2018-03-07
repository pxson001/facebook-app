package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import java.io.Serializable;

/* compiled from: fundraiser_page_missing_fields */
public class MessengerPayHistoryActivity extends FbFragmentActivity implements ActionBarOwner {
    public AnalyticsLogger f14326p;
    public AppCompatActivityOverrider f14327q;
    public ActionBarBasedFbTitleBar f14328r;

    /* compiled from: fundraiser_page_missing_fields */
    public class C16261 implements OnPageChangeListener {
        final /* synthetic */ MessengerPayHistoryActivity f14322a;

        public C16261(MessengerPayHistoryActivity messengerPayHistoryActivity) {
            this.f14322a = messengerPayHistoryActivity;
        }

        public final void m14729a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            this.f14322a.f14326p.a(P2pPaymentsLogEvent.d("p2p_history_visible_tab", "p2p_settings").e(MessengerPayHistoryActivity.m14736b(i).toString()).a);
        }

        public final void m14730b(int i) {
        }
    }

    /* compiled from: fundraiser_page_missing_fields */
    enum Tab {
        TAB_ALL(2131240320),
        TAB_OUTGOING(2131240321),
        TAB_INCOMING(2131240322);
        
        public final int titleResId;

        private Tab(int i) {
            this.titleResId = i;
        }
    }

    /* compiled from: fundraiser_page_missing_fields */
    public class TransactionHistoryPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ MessengerPayHistoryActivity f14325a;

        public TransactionHistoryPagerAdapter(MessengerPayHistoryActivity messengerPayHistoryActivity, FragmentManager fragmentManager) {
            this.f14325a = messengerPayHistoryActivity;
            super(fragmentManager);
        }

        public final Fragment m14731a(int i) {
            Serializable a = MessengerPayHistoryActivity.m14736b(i);
            Serializable serializable = MessengerPayHistoryMode.PAYMENT_TRANSACTIONS;
            MessengerPayHistoryFragment messengerPayHistoryFragment = new MessengerPayHistoryFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("payment_transaction_query_type", a);
            bundle.putSerializable("messenger_pay_history_mode", serializable);
            messengerPayHistoryFragment.g(bundle);
            return messengerPayHistoryFragment;
        }

        public final int m14732b() {
            return Tab.values().length;
        }

        public final CharSequence J_(int i) {
            return this.f14325a.getResources().getString(Tab.values()[i].titleResId);
        }
    }

    public static void m14735a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessengerPayHistoryActivity messengerPayHistoryActivity = (MessengerPayHistoryActivity) obj;
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        AppCompatActivityOverrider b = AppCompatActivityOverrider.b(fbInjector);
        messengerPayHistoryActivity.f14326p = a;
        messengerPayHistoryActivity.f14327q = b;
    }

    public static Intent m14733a(Context context, MessengerPayHistoryMode messengerPayHistoryMode) {
        Intent intent = new Intent(context, MessengerPayHistoryActivity.class);
        intent.putExtra("messenger_pay_history_mode", messengerPayHistoryMode);
        return intent;
    }

    protected final void m14738a(Bundle bundle) {
        Class cls = MessengerPayHistoryActivity.class;
        m14735a((Object) this, (Context) this);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        a(this.f14327q);
        setTheme(2131626368);
    }

    protected final void m14739b(Bundle bundle) {
        super.b(bundle);
        this.f14328r = new ActionBarBasedFbTitleBar(this, m14737a());
        MessengerPayHistoryMode messengerPayHistoryMode = (MessengerPayHistoryMode) getIntent().getSerializableExtra("messenger_pay_history_mode");
        switch (messengerPayHistoryMode) {
            case PAYMENT_TRANSACTIONS:
                setContentView(2130905259);
                this.f14326p.a(P2pPaymentsLogEvent.d("p2p_history_visible_tab", "p2p_settings").e(PaymentTransactionQueryType.ALL.toString()).a);
                ViewPager viewPager = (ViewPager) findViewById(2131563858);
                viewPager.setAdapter(new TransactionHistoryPagerAdapter(this, kO_()));
                TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) findViewById(2131563857);
                tabbedViewPagerIndicator.setViewPager(viewPager);
                tabbedViewPagerIndicator.l = new C16261(this);
                this.f14328r.setTitle(2131240268);
                return;
            case INCOMING_PAYMENT_REQUESTS:
            case OUTGOING_PAYMENT_REQUESTS:
                this.f14328r.setTitle(messengerPayHistoryMode == MessengerPayHistoryMode.INCOMING_PAYMENT_REQUESTS ? 2131240269 : 2131240270);
                setContentView(2130904413);
                if (kO_().a(2131560203) == null) {
                    MessengerPayHistoryFragment messengerPayHistoryFragment = new MessengerPayHistoryFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("messenger_pay_history_mode", messengerPayHistoryMode);
                    messengerPayHistoryFragment.g(bundle2);
                    kO_().a().b(2131560203, messengerPayHistoryFragment).b();
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown MessengerPayHistoryMode provided " + messengerPayHistoryMode);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        this.f14328r.a(menu);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        this.f14326p.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_cancel_history"));
        super.onBackPressed();
    }

    public final ActionBar m14737a() {
        return this.f14327q.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f14326p.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_cancel_history"));
        finish();
        return true;
    }

    private static PaymentTransactionQueryType m14736b(int i) {
        switch (Tab.values()[i]) {
            case TAB_ALL:
                return PaymentTransactionQueryType.ALL;
            case TAB_OUTGOING:
                return PaymentTransactionQueryType.OUTGOING;
            case TAB_INCOMING:
                return PaymentTransactionQueryType.INCOMING;
            default:
                throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("%s View Pager cannot view page with index %d", MessengerPayHistoryActivity.class.getName(), Integer.valueOf(i)));
        }
    }
}
