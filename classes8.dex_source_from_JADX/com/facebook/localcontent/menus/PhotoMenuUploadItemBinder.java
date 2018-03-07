package com.facebook.localcontent.menus;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ec_config_context_rows */
public class PhotoMenuUploadItemBinder {

    /* compiled from: ec_config_context_rows */
    public final class C16341 implements TextWatcher {
        final /* synthetic */ PhotoMenuUploadItemModel f15035a;

        public C16341(PhotoMenuUploadItemModel photoMenuUploadItemModel) {
            this.f15035a = photoMenuUploadItemModel;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f15035a.f15041d = charSequence.toString();
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: ec_config_context_rows */
    public final class C16352 implements OnClickListener {
        final /* synthetic */ PhotoMenuUploadFragment f15036a;
        final /* synthetic */ int f15037b;

        public C16352(PhotoMenuUploadFragment photoMenuUploadFragment, int i) {
            this.f15036a = photoMenuUploadFragment;
            this.f15037b = i;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1514801388);
            this.f15036a.m17474g(this.f15037b);
            Logger.a(2, EntryType.UI_INPUT_END, 84411832, a);
        }
    }
}
