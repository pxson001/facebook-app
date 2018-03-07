package com.facebook.messaging.business.commerceui.views;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerceui.utils.ModelUtils;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: numToFetch */
public class CommerceOrderHistoryAdapter extends BaseAdapter {
    public List<Receipt> f8426a = Lists.a();
    private Context f8427b;

    public CommerceOrderHistoryAdapter(Context context) {
        this.f8427b = context;
    }

    public int getCount() {
        return this.f8426a.size();
    }

    public Object getItem(int i) {
        return this.f8426a.get(i);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String string;
        if (view == null) {
            view = new CommerceOrderItemView(this.f8427b);
        } else {
            CommerceOrderItemView commerceOrderItemView = (CommerceOrderItemView) view;
        }
        Receipt receipt = (Receipt) this.f8426a.get(i);
        view.f8443e = receipt;
        BetterTextView betterTextView = view.f8442d;
        ModelUtils modelUtils = view.f8439a;
        int i2 = receipt.s;
        if (receipt.r) {
            string = modelUtils.f8404a.getString(2131240687, new Object[]{receipt.o});
        } else if (i2 <= 1) {
            string = modelUtils.f8404a.getString(2131240685, new Object[]{receipt.o});
        } else {
            string = modelUtils.f8404a.getResources().getString(2131240686, new Object[]{Integer.valueOf(i2 - 1), receipt.o});
        }
        betterTextView.setText(string);
        ImmutableList immutableList = receipt.t;
        if (immutableList == null || immutableList.isEmpty() || immutableList.get(0) == null) {
            view.f8441c.setText(null);
            view.f8440b.a(null, CallerContext.a(view.getClass()));
        } else {
            PlatformGenericAttachmentItem platformGenericAttachmentItem = (PlatformGenericAttachmentItem) immutableList.get(0);
            CharSequence charSequence = platformGenericAttachmentItem.b;
            Uri uri = platformGenericAttachmentItem.d;
            view.f8441c.setText(charSequence);
            view.f8440b.a(uri, CallerContext.a(view.getClass()));
        }
        return view;
    }

    public boolean isEmpty() {
        return this.f8426a.isEmpty();
    }

    public int getViewTypeCount() {
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }
}
