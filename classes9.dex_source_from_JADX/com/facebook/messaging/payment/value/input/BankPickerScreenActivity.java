package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.service.model.cards.NetBankingMethod;
import com.facebook.messaging.payment.service.model.pay.SendPaymentBankDetails;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_reset_data */
public class BankPickerScreenActivity extends FbFragmentActivity implements ActionBarOwner {
    @Inject
    public AppCompatActivityOverrider f15190p;
    private ListView f15191q;
    private BankPickerAdapter f15192r;

    /* compiled from: extra_reset_data */
    class BankPickerAdapter extends ArrayAdapter<SendPaymentBankDetails> {
        final /* synthetic */ BankPickerScreenActivity f15189a;

        public BankPickerAdapter(BankPickerScreenActivity bankPickerScreenActivity, Context context) {
            this.f15189a = bankPickerScreenActivity;
            super(context, 0);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new BankPickerItemView(this.f15189a);
            } else {
                BankPickerItemView bankPickerItemView = (BankPickerItemView) view;
            }
            byte[] decode = Base64.decode(((SendPaymentBankDetails) getItem(i)).m15178b(), 0);
            view.f15185a.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            view.f15186b.setText(((SendPaymentBankDetails) getItem(i)).m15181e());
            return view;
        }
    }

    public static void m15546a(Object obj, Context context) {
        ((BankPickerScreenActivity) obj).f15190p = AppCompatActivityOverrider.b(FbInjector.get(context));
    }

    protected final void m15548a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = BankPickerScreenActivity.class;
        m15546a(this, this);
        a(this.f15190p);
    }

    protected final void m15549b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130903382);
        this.f15192r = new BankPickerAdapter(this, this);
        this.f15191q = (ListView) a(16908298);
        this.f15191q.setAdapter(this.f15192r);
        final Object parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("payment_bar_code_details");
        this.f15192r.addAll(parcelableArrayListExtra);
        AdapterDetour.a(this.f15192r, 1498005464);
        this.f15191q.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BankPickerScreenActivity f15188b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object netBankingMethod = new NetBankingMethod(((SendPaymentBankDetails) parcelableArrayListExtra.get(i)).m15177a(), ((SendPaymentBankDetails) parcelableArrayListExtra.get(i)).m15178b(), ((SendPaymentBankDetails) parcelableArrayListExtra.get(i)).m15179c(), ((SendPaymentBankDetails) parcelableArrayListExtra.get(i)).m15181e());
                Intent intent = new Intent();
                intent.putExtra("selected_payment_method", netBankingMethod);
                this.f15188b.setResult(-1, intent);
                this.f15188b.finish();
            }
        });
    }

    public final ActionBar m15547a() {
        return this.f15190p.g();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
