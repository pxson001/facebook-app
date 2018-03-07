package com.facebook.events.create.ui;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.create.EventCreationHostSelectionAdapter;
import com.facebook.events.create.EventCreationHostSelectionFragment;
import com.facebook.events.create.EventCreationHostSelectionFragment.C22471;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: confirm_password */
public class EventCreationHostSelectionItemViewHolder extends ViewHolder implements OnClickListener {
    private String f16354l;
    private C22471 f16355m;
    public CheckedContentView f16356n;

    public EventCreationHostSelectionItemViewHolder(View view) {
        super(view);
        this.f16356n = (CheckedContentView) view.findViewById(2131561270);
    }

    public final void m16825a(String str, String str2, String str3, boolean z, C22471 c22471) {
        this.f16354l = str;
        this.f16355m = c22471;
        if (str2 == null) {
            this.f16356n.setVisibility(8);
            return;
        }
        this.f16356n.setVisibility(0);
        this.f16356n.setTitleText(str2);
        this.f16356n.setThumbnailUri(str3 == null ? null : Uri.parse(str3));
        this.f16356n.setChecked(z);
        this.f16356n.setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -90669105);
        if (this.f16355m != null) {
            C22471 c22471 = this.f16355m;
            String str = this.f16354l;
            EventCreationHostSelectionFragment eventCreationHostSelectionFragment = c22471.f16126a;
            eventCreationHostSelectionFragment.f16131d = str;
            eventCreationHostSelectionFragment.f16134g = (PageHostInfoFragmentModel) eventCreationHostSelectionFragment.f16133f.get(eventCreationHostSelectionFragment.f16131d);
            EventCreationHostSelectionAdapter eventCreationHostSelectionAdapter = eventCreationHostSelectionFragment.f16132e;
            eventCreationHostSelectionAdapter.f16123f = str;
            eventCreationHostSelectionAdapter.notifyDataSetChanged();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 537985258, a);
    }
}
