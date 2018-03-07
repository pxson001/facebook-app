package com.facebook.ui.edithistory;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLModels.EditActionFragmentModel;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.List;

/* compiled from: event_guest_status */
public abstract class EditHistoryAdapter extends FbBaseAdapter {
    public List<EditActionExpandState> f15189a = null;
    private CharSequence f15190b = null;
    public final TimeFormatUtil f15191c;
    private final LinkifyUtil f15192d;

    /* compiled from: event_guest_status */
    class ViewHolder {
        public TextView f15293a;
        public TextView f15294b;
        public TextView f15295c;
        final /* synthetic */ EditHistoryAdapter f15296d;

        public ViewHolder(EditHistoryAdapter editHistoryAdapter) {
            this.f15296d = editHistoryAdapter;
        }
    }

    protected abstract int mo1173a();

    public EditHistoryAdapter(TimeFormatUtil timeFormatUtil, LinkifyUtil linkifyUtil) {
        this.f15191c = timeFormatUtil;
        this.f15192d = linkifyUtil;
    }

    public int getCount() {
        if (this.f15189a == null) {
            return 0;
        }
        return this.f15189a.size();
    }

    public Object getItem(int i) {
        return this.f15189a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m19195a(int i, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(mo1173a(), viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this);
        viewHolder.f15293a = (TextView) inflate.findViewById(2131559673);
        viewHolder.f15294b = (TextView) inflate.findViewById(2131559674);
        viewHolder.f15295c = (TextView) inflate.findViewById(2131562004);
        inflate.setTag(viewHolder);
        return inflate;
    }

    public void m19196a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        EditActionExpandState editActionExpandState = (EditActionExpandState) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.f15294b.setText(m19193a(editActionExpandState, view));
        viewHolder.f15294b.setMovementMethod(LinkMovementMethod.getInstance());
        viewHolder.f15294b.setFocusable(false);
        TextView textView = viewHolder.f15293a;
        String str = editActionExpandState.f15290e;
        if (str == null) {
            str = this.f15191c.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, editActionExpandState.f15286a.m19296k() * 1000);
            editActionExpandState.f15290e = str;
        }
        textView.setText(str);
    }

    private CharSequence m19193a(final EditActionExpandState editActionExpandState, View view) {
        CharSequence a;
        CharSequence a2;
        CharSequence charSequence = editActionExpandState.f15288c;
        CharSequence charSequence2 = editActionExpandState.f15289d;
        TextView textView = (TextView) view.findViewById(2131559674);
        TextView textView2 = (TextView) view.findViewById(2131562004);
        if (StringUtil.a(charSequence)) {
            CharSequence charSequence3;
            String str = "";
            textView.setVisibility(8);
            textView2.setVisibility(0);
            EditActionFragmentModel editActionFragmentModel = editActionExpandState.f15286a;
            if (editActionFragmentModel != null) {
                LinkableUtilApplyActorsLinksGraphQLModel j = editActionFragmentModel.m19295j();
                if (!(j == null || j.a() == null)) {
                    textView.setVisibility(0);
                    textView2.setVisibility(8);
                    a = this.f15192d.a(j);
                    if (this.f15190b != null) {
                        a = TextUtils.concat(new CharSequence[]{a, this.f15190b});
                    }
                    a2 = this.f15192d.a(a, new OnClickListener(this) {
                        final /* synthetic */ EditHistoryAdapter f15292b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1813028499);
                            editActionExpandState.f15287b = true;
                            AdapterDetour.a(this.f15292b, 1745451195);
                            Logger.a(2, EntryType.UI_INPUT_END, 815170369, a);
                        }
                    });
                    if (a2 == null) {
                        editActionExpandState.f15287b = true;
                    }
                    editActionExpandState.f15288c = a;
                    editActionExpandState.f15289d = a2;
                    charSequence3 = a2;
                    a2 = a;
                    a = charSequence3;
                }
            }
            Object obj = str;
            if (this.f15190b != null) {
                a = TextUtils.concat(new CharSequence[]{a, this.f15190b});
            }
            a2 = this.f15192d.a(a, /* anonymous class already generated */);
            if (a2 == null) {
                editActionExpandState.f15287b = true;
            }
            editActionExpandState.f15288c = a;
            editActionExpandState.f15289d = a2;
            charSequence3 = a2;
            a2 = a;
            a = charSequence3;
        } else {
            textView.setVisibility(0);
            textView2.setVisibility(8);
            a = charSequence2;
            a2 = charSequence;
        }
        if (editActionExpandState.f15287b) {
            return a2;
        }
        return a;
    }
}
