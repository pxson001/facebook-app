package com.facebook.katana.activity.faceweb.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.katana.model.NewsFeedToggleOption;
import com.facebook.webview.FacebookWebView;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/* compiled from: uri must not be null */
public class FeedFilterPickerDialogFragment extends DialogFragment {
    private static final Class<?> al = FeedFilterPickerDialogFragment.class;
    public List<NewsFeedToggleOption> am = null;
    public JsonFactory an;
    public FacebookWebView ao;

    /* compiled from: uri must not be null */
    class C01401 extends TypeReference<List<NewsFeedToggleOption>> {
        final /* synthetic */ FeedFilterPickerDialogFragment f864b;

        C01401(FeedFilterPickerDialogFragment feedFilterPickerDialogFragment) {
            this.f864b = feedFilterPickerDialogFragment;
        }
    }

    /* compiled from: uri must not be null */
    class C01412 implements OnClickListener {
        final /* synthetic */ FeedFilterPickerDialogFragment f865a;

        C01412(FeedFilterPickerDialogFragment feedFilterPickerDialogFragment) {
            this.f865a = feedFilterPickerDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f865a.a();
        }
    }

    public final Dialog m855c(Bundle bundle) {
        FragmentActivity o = o();
        final String string = mt_().getString("feed_filter_dismiss_script");
        final int i = mt_().getInt("feed_filter_selected_index");
        try {
            this.am = (List) this.an.a(mt_().getString("feed_filter_buttons")).a(new C01401(this));
        } catch (JsonParseException e) {
            BLog.b(al, "received bad faceweb data", e);
        } catch (Throwable e2) {
            BLog.b(al, "received bad faceweb data", e2);
        }
        if (this.am.size() == 0) {
            return new Builder(o).a(2131236463).b(2131236463).b(2131230756, new C01412(this)).a();
        }
        CharSequence[] charSequenceArr = new CharSequence[this.am.size()];
        for (int i2 = 0; i2 < this.am.size(); i2++) {
            charSequenceArr[i2] = ((NewsFeedToggleOption) this.am.get(i2)).title;
        }
        return new Builder(o).a(charSequenceArr, new OnClickListener(this) {
            final /* synthetic */ FeedFilterPickerDialogFragment f868c;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f868c.a();
                if (this.f868c.ao != null) {
                    if (!(this.f868c.am == null || this.f868c.am.size() <= i || i == i)) {
                        String str = ((NewsFeedToggleOption) this.f868c.am.get(i)).script;
                        if (str != null) {
                            this.f868c.ao.a(str, null);
                        }
                    }
                    this.f868c.ao.a(string, null);
                }
            }
        }).a();
    }

    public static DialogFragment m854a(String str, String str2, int i, JsonFactory jsonFactory, FacebookWebView facebookWebView) {
        FeedFilterPickerDialogFragment feedFilterPickerDialogFragment = new FeedFilterPickerDialogFragment();
        feedFilterPickerDialogFragment.an = jsonFactory;
        feedFilterPickerDialogFragment.ao = facebookWebView;
        Bundle bundle = new Bundle();
        bundle.putString("feed_filter_buttons", str);
        bundle.putString("feed_filter_dismiss_script", str2);
        bundle.putInt("feed_filter_selected_index", i);
        feedFilterPickerDialogFragment.g(bundle);
        return feedFilterPickerDialogFragment;
    }
}
