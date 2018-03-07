package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import com.facebook.contacts.picker.PickablePhoneContactRow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;

/* compiled from: tap_activity_log_action_item */
public class PickablePhoneContactItem extends CustomRelativeLayout {
    public SimpleVariableTextLayoutView f2055a = ((SimpleVariableTextLayoutView) a(2131564763));
    public SimpleVariableTextLayoutView f2056b = ((SimpleVariableTextLayoutView) a(2131564764));
    public UserTileView f2057c = ((UserTileView) a(2131564762));
    public CheckBox f2058d = ((CheckBox) a(2131564758));
    public Button f2059e = ((Button) a(2131564765));
    public PickablePhoneContactRow f2060f;

    /* compiled from: tap_activity_log_action_item */
    public class C03441 implements OnClickListener {
        final /* synthetic */ PickablePhoneContactItem f2053a;
        final /* synthetic */ PickablePhoneContactItem f2054b;

        public C03441(PickablePhoneContactItem pickablePhoneContactItem, PickablePhoneContactItem pickablePhoneContactItem2) {
            this.f2054b = pickablePhoneContactItem;
            this.f2053a = pickablePhoneContactItem2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1431638428);
            ListView listView = (ListView) this.f2053a.getParent();
            listView.performItemClick(this.f2053a, listView.getPositionForView(this.f2053a), (long) this.f2053a.getId());
            Logger.a(2, EntryType.UI_INPUT_END, -1958404678, a);
        }
    }

    public PickablePhoneContactItem(Context context) {
        super(context, null, 2130772985);
        setContentView(2130905657);
    }
}
