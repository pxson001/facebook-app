package com.facebook.richdocument.presenter;

import android.content.Context;
import android.widget.TextView;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.data.impl.ListItemBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.view.block.impl.ListBlockViewImpl;

/* compiled from: person_card_message_button */
public class ListBlockPresenter extends TextBlockPresenter {
    public ListBlockPresenter(ListBlockViewImpl listBlockViewImpl) {
        super(listBlockViewImpl);
    }

    public final void mo368a(TextBlockData textBlockData) {
        super.mo368a(textBlockData);
        ListItemBlockDataImpl listItemBlockDataImpl = (ListItemBlockDataImpl) textBlockData;
        ListBlockViewImpl listBlockViewImpl = (ListBlockViewImpl) this.f6382d;
        Context context = getContext();
        RichDocumentText f = listItemBlockDataImpl.mo297f();
        String str = listItemBlockDataImpl.f5729c;
        RichTextBuilder a = new RichTextBuilder(context).m5445a(f);
        a.f5636d = str;
        RichText a2 = a.m5446a();
        if (listItemBlockDataImpl.f5728b) {
            listBlockViewImpl.f6660b.m1359a((TextView) listBlockViewImpl.f6662f.f7393d, a2);
            listBlockViewImpl.f6662f.setVisibility(0);
            listBlockViewImpl.f6663g.setVisibility(8);
        } else {
            listBlockViewImpl.f6663g.setText(a2.f5641a);
            listBlockViewImpl.f6662f.setVisibility(8);
            listBlockViewImpl.f6663g.setVisibility(0);
        }
        listBlockViewImpl.iY_().setPadding(listBlockViewImpl.f6661e * listItemBlockDataImpl.f5727a, 0, 0, 0);
    }
}
