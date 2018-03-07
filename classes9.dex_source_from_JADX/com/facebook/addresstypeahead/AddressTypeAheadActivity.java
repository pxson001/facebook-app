package com.facebook.addresstypeahead;

import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import com.facebook.addresstypeahead.view.AddressTypeAheadSearchView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: sentShareAttachments.type */
public class AddressTypeAheadActivity extends FbFragmentActivity {
    private AddressTypeAheadSearchView f3901p;

    /* compiled from: sentShareAttachments.type */
    public class C03461 {
        final /* synthetic */ AddressTypeAheadActivity f3900a;

        C03461(AddressTypeAheadActivity addressTypeAheadActivity) {
            this.f3900a = addressTypeAheadActivity;
        }

        public final void m3762a(Address address) {
            Intent intent = new Intent();
            intent.putExtra("selected_address", address);
            this.f3900a.setResult(-1, intent);
            this.f3900a.finish();
        }
    }

    protected final void m3763b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903172);
        setRequestedOrientation(1);
        this.f3901p = (AddressTypeAheadSearchView) a(2131559374);
        Bundle extras = getIntent().getExtras();
        this.f3901p.f3961p = (Location) extras.getParcelable("current_location");
        this.f3901p.setIsUsingGoogleApi(extras.getBoolean("is_using_google_api"));
        this.f3901p.f3962q = extras.getString("product_tag");
        this.f3901p.f3964s = new C03461(this);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1589904864);
        super.onDestroy();
        this.f3901p.m3862c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2008511473, a);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f3901p.m3861b();
    }
}
