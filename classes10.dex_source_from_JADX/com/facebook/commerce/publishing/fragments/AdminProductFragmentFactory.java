package com.facebook.commerce.publishing.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.base.Optional;
import java.util.Currency;

/* compiled from: cymk_notice_accepted */
public class AdminProductFragmentFactory implements IFragmentFactory {
    public final Fragment m16061a(Intent intent) {
        Optional fromNullable = Optional.fromNullable(intent.getStringExtra("extra_product_item_id_to_fetch"));
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", 0);
        AdminCommerceProductItem adminCommerceProductItem = (AdminCommerceProductItem) FlatBufferModelHelper.a(intent, "extra_admin_product_item");
        Currency currency = (Currency) intent.getSerializableExtra("extra_currency");
        int intExtra = intent.getIntExtra("extra_featured_products_count", 0);
        boolean booleanExtra = intent.getBooleanExtra("extra_wait_for_mutation_finish", false);
        ViewerContext viewerContext = (ViewerContext) intent.getParcelableExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
        return intent.getBooleanExtra("extra_requires_initial_fetch", false) ? AdminProductFragment.m16068a(longExtra, fromNullable, booleanExtra, viewerContext) : AdminProductFragment.m16067a(longExtra, adminCommerceProductItem, currency, intExtra, booleanExtra, viewerContext, intent.getBooleanExtra("extra_has_empty_catalog", false));
    }
}
