package com.facebook.rtc.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: audio/x-midi */
public class RtcMergedAudioVideoDialogAdapter extends ArrayAdapter<RtcMergedAudioVideoDialogItem> {
    public RtcMergedAudioVideoDialogAdapter(Context context, RtcMergedAudioVideoDialogItem[] rtcMergedAudioVideoDialogItemArr) {
        super(context, 2130906920, rtcMergedAudioVideoDialogItemArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130906920, viewGroup, false);
        }
        RtcMergedAudioVideoDialogItem rtcMergedAudioVideoDialogItem = (RtcMergedAudioVideoDialogItem) getItem(i);
        ((ImageView) view.findViewById(2131567166)).setImageDrawable(rtcMergedAudioVideoDialogItem.f19340a);
        ((TextView) view.findViewById(2131567167)).setText(rtcMergedAudioVideoDialogItem.f19341b);
        return view;
    }
}
