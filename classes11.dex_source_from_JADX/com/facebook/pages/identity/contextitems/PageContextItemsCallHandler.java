package com.facebook.pages.identity.contextitems;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.facebook.content.SecureContextHelper;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel.ItemLinksModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: picker */
public class PageContextItemsCallHandler {
    private final SecureContextHelper f3808a;
    private final Activity f3809b;

    @Inject
    public PageContextItemsCallHandler(Activity activity, SecureContextHelper secureContextHelper) {
        this.f3809b = activity;
        this.f3808a = secureContextHelper;
    }

    public final void m4769a(ContextItemFieldsModel contextItemFieldsModel) {
        ImmutableList c = contextItemFieldsModel.c();
        if (c != null && !c.isEmpty()) {
            ItemLinksModel itemLinksModel = (ItemLinksModel) c.get(0);
            if (itemLinksModel.a() != null && !itemLinksModel.a().isEmpty()) {
                this.f3808a.b(new Intent("android.intent.action.DIAL").setData(Uri.parse((String) itemLinksModel.a().get(0))), 22805, this.f3809b);
            }
        }
    }
}
