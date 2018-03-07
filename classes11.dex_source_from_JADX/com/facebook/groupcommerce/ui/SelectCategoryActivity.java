package com.facebook.groupcommerce.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/* compiled from: admined_groups */
public class SelectCategoryActivity extends FbFragmentActivity {
    ArrayList<GroupCommerceCategory> f10086p;

    /* compiled from: admined_groups */
    class C11711 implements OnItemClickListener {
        final /* synthetic */ SelectCategoryActivity f10085a;

        C11711(SelectCategoryActivity selectCategoryActivity) {
            this.f10085a = selectCategoryActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f10085a.m10432a((GroupCommerceCategory) this.f10085a.f10086p.get(i));
        }
    }

    public final void m10434b(Bundle bundle) {
        setContentView(2130907058);
        BetterListView betterListView = (BetterListView) findViewById(2131560128);
        this.f10086p = getIntent().getParcelableArrayListExtra("categories");
        List a = Lists.a();
        int size = this.f10086p.size();
        for (int i = 0; i < size; i++) {
            a.add(((GroupCommerceCategory) this.f10086p.get(i)).name);
        }
        betterListView.setAdapter(new ArrayAdapter(betterListView.getContext(), 17367062, a));
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(-1));
        betterListView.setOnItemClickListener(new C11711(this));
    }

    private void m10432a(GroupCommerceCategory groupCommerceCategory) {
        setResult(-1, new Intent().putExtra("category_id", groupCommerceCategory.categoryID));
        finish();
    }
}
