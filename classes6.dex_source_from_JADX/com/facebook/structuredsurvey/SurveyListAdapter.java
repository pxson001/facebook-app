package com.facebook.structuredsurvey;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.structuredsurvey.items.SurveyCheckboxItem;
import com.facebook.structuredsurvey.items.SurveyEditTextItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyRadioItem;
import com.facebook.structuredsurvey.items.SurveyWriteInItem;
import com.facebook.structuredsurvey.views.SurveyCheckboxListItemView;
import com.facebook.structuredsurvey.views.SurveyDividerListItemView;
import com.facebook.structuredsurvey.views.SurveyEditTextListItemView;
import com.facebook.structuredsurvey.views.SurveyImageBlockListItemView;
import com.facebook.structuredsurvey.views.SurveyListItemView;
import com.facebook.structuredsurvey.views.SurveyMessageListItemView;
import com.facebook.structuredsurvey.views.SurveyNotificationListItemView;
import com.facebook.structuredsurvey.views.SurveyQuestionListItemView;
import com.facebook.structuredsurvey.views.SurveyRadioListItemView;
import com.facebook.structuredsurvey.views.SurveySpaceListItemView;
import com.facebook.structuredsurvey.views.SurveyWriteInListItemView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterButton;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: draft_dialog_discard */
public class SurveyListAdapter extends ArrayAdapter<SurveyItem> {
    HashMap<String, SurveyListItemView> f17121a = new HashMap();
    public OnClickListener f17122b;
    public Runnable f17123c;
    private final OnClickListener f17124d = new C12401(this);
    private String f17125e;
    private final OnFocusChangeListener f17126f = new C12412(this);
    private final OnFocusChangeListener f17127g = new C12423(this);
    private final OnFocusChangeListener f17128h = new C12434(this);

    /* compiled from: draft_dialog_discard */
    class C12401 implements OnClickListener {
        final /* synthetic */ SurveyListAdapter f17116a;

        C12401(SurveyListAdapter surveyListAdapter) {
            this.f17116a = surveyListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1673010749);
            switch ((ItemType) view.getTag()) {
                case RADIO:
                case RADIOWRITEIN:
                    SurveyListAdapter.m24812c(this.f17116a, view);
                    break;
                case CHECKBOX:
                case CHECKBOXWRITEIN:
                    ((Checkable) view).toggle();
                    break;
            }
            LogUtils.a(820388687, a);
        }
    }

    /* compiled from: draft_dialog_discard */
    class C12412 implements OnFocusChangeListener {
        final /* synthetic */ SurveyListAdapter f17117a;

        C12412(SurveyListAdapter surveyListAdapter) {
            this.f17117a = surveyListAdapter;
        }

        public void onFocusChange(View view, boolean z) {
            SurveyListAdapter.m24810a(this.f17117a, view, z);
            if (!z) {
                SurveyEditTextListItemView surveyEditTextListItemView = (SurveyEditTextListItemView) view.getParent();
                ((SurveyEditTextItem) surveyEditTextListItemView.f17202a).m24928a(surveyEditTextListItemView.getText());
            }
        }
    }

    /* compiled from: draft_dialog_discard */
    class C12423 implements OnFocusChangeListener {
        final /* synthetic */ SurveyListAdapter f17118a;

        C12423(SurveyListAdapter surveyListAdapter) {
            this.f17118a = surveyListAdapter;
        }

        public void onFocusChange(View view, boolean z) {
            SurveyListAdapter.m24810a(this.f17118a, view, z);
            if (z) {
                SurveyListAdapter.m24812c(this.f17118a, (View) view.getParent());
                return;
            }
            SurveyWriteInListItemView surveyWriteInListItemView = (SurveyWriteInListItemView) view.getParent();
            ((SurveyWriteInItem) surveyWriteInListItemView.f17202a).m24935a(surveyWriteInListItemView.getText());
        }
    }

    /* compiled from: draft_dialog_discard */
    class C12434 implements OnFocusChangeListener {
        final /* synthetic */ SurveyListAdapter f17119a;

        C12434(SurveyListAdapter surveyListAdapter) {
            this.f17119a = surveyListAdapter;
        }

        public void onFocusChange(View view, boolean z) {
            SurveyListAdapter.m24810a(this.f17119a, view, z);
        }
    }

    private void m24809a(int i, ListView listView) {
        while (i < getCount()) {
            if (((SurveyItem) getItem(i)).f17165a == ItemType.QUESTION) {
                listView.smoothScrollToPositionFromTop(i, 0);
                return;
            }
            i++;
        }
    }

    public static void m24812c(SurveyListAdapter surveyListAdapter, View view) {
        Checkable checkable = (Checkable) view;
        checkable.setChecked(true);
        SurveyListItemView surveyListItemView = (SurveyListItemView) view;
        if (surveyListItemView.f17202a != null) {
            String str = surveyListItemView.f17202a.f17166b;
            if (surveyListAdapter.f17121a.containsKey(str)) {
                SurveyListItemView surveyListItemView2 = (SurveyListItemView) surveyListAdapter.f17121a.get(str);
                if (!(surveyListItemView2 == null || surveyListItemView2 == checkable)) {
                    ((Checkable) surveyListItemView2).setChecked(false);
                }
            }
            surveyListAdapter.f17121a.put(str, surveyListItemView);
        }
        if (surveyListAdapter.f17123c != null) {
            surveyListAdapter.f17123c.run();
        }
        if (surveyListItemView.f17202a.f17165a != ItemType.RADIOWRITEIN) {
            surveyListAdapter.m24809a(surveyListAdapter.getPosition(surveyListItemView.f17202a), (ListView) surveyListItemView.getParent());
        }
    }

    public static void m24810a(SurveyListAdapter surveyListAdapter, View view, boolean z) {
        SurveyListItemView surveyListItemView = (SurveyListItemView) view.getParent();
        if (z) {
            surveyListAdapter.f17125e = surveyListItemView.f17202a.f17166b;
        }
    }

    public SurveyListAdapter(Context context, ArrayList<SurveyItem> arrayList) {
        super(context, 0, arrayList);
    }

    public int getViewTypeCount() {
        return ItemType.values().length;
    }

    public int getItemViewType(int i) {
        return ((SurveyItem) getItem(i)).f17165a.ordinal();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ItemType fromInt = ItemType.fromInt(getItemViewType(i));
        if (view == null) {
            switch (fromInt) {
                case RADIO:
                    View a = SurveyRadioListItemView.m24974a(viewGroup);
                    if (this.f17123c != null) {
                        ((SurveyRadioListItemView) a).m24977a();
                    }
                    a.setOnClickListener(this.f17124d);
                    view2 = a;
                    break;
                case RADIOWRITEIN:
                case CHECKBOXWRITEIN:
                    view = SurveyWriteInListItemView.m24983a(viewGroup, fromInt);
                    view.setOnClickListener(this.f17124d);
                    view2 = view;
                    break;
                case CHECKBOX:
                    view = SurveyCheckboxListItemView.m24945a(viewGroup);
                    view.setOnClickListener(this.f17124d);
                    view2 = view;
                    break;
                case EDITTEXT:
                    view2 = SurveyEditTextListItemView.m24950a(viewGroup);
                    break;
                case DIVIDER:
                    view2 = SurveyDividerListItemView.m24948a(viewGroup);
                    break;
                case WHITESPACE:
                    view2 = SurveySpaceListItemView.m24979a(viewGroup);
                    break;
                case QUESTION:
                    view2 = SurveyQuestionListItemView.m24971a(viewGroup);
                    break;
                case MESSAGE:
                    view2 = SurveyMessageListItemView.m24958a(viewGroup);
                    break;
                case IMAGEBLOCK:
                    view = SurveyImageBlockListItemView.m24955a(viewGroup);
                    ((BetterButton) view.findViewById(2131567782)).setOnClickListener(this.f17122b);
                    view2 = view;
                    break;
                case NOTIFICATION:
                    view2 = SurveyNotificationListItemView.m24961a(viewGroup);
                    break;
            }
        }
        view2 = view;
        SurveyItem surveyItem = (SurveyItem) getItem(i);
        SurveyListItemView surveyListItemView = (SurveyListItemView) view2;
        if (surveyListItemView != null) {
            surveyListItemView.mo1296a(surveyItem);
        }
        if (fromInt == ItemType.CHECKBOX) {
            ((SurveyCheckboxListItemView) view2).setChecked(((SurveyCheckboxItem) surveyItem).mo1295b());
        }
        if (fromInt == ItemType.CHECKBOXWRITEIN) {
            m24811a((SurveyWriteInItem) surveyItem, (SurveyWriteInListItemView) view2, this.f17128h);
        }
        if (fromInt == ItemType.RADIO) {
            SurveyRadioListItemView surveyRadioListItemView = (SurveyRadioListItemView) view2;
            SurveyRadioItem surveyRadioItem = (SurveyRadioItem) surveyItem;
            surveyRadioListItemView.setChecked(surveyRadioItem.mo1295b());
            if (surveyRadioItem.mo1295b()) {
                this.f17121a.put(surveyItem.f17166b, surveyRadioListItemView);
            }
        }
        if (fromInt == ItemType.RADIOWRITEIN) {
            SurveyWriteInListItemView surveyWriteInListItemView = (SurveyWriteInListItemView) view2;
            SurveyWriteInItem surveyWriteInItem = (SurveyWriteInItem) surveyItem;
            if (surveyWriteInItem.mo1295b()) {
                this.f17121a.put(surveyItem.f17166b, surveyWriteInListItemView);
            }
            m24811a(surveyWriteInItem, surveyWriteInListItemView, this.f17127g);
        }
        if (fromInt == ItemType.EDITTEXT) {
            SurveyEditTextListItemView surveyEditTextListItemView = (SurveyEditTextListItemView) view2;
            surveyEditTextListItemView.setItemOnFocusChangeListener(this.f17126f);
            if (surveyEditTextListItemView.f17202a.f17166b.equals(this.f17125e)) {
                surveyEditTextListItemView.m24952a();
            }
        }
        return view2;
    }

    private void m24811a(SurveyWriteInItem surveyWriteInItem, SurveyWriteInListItemView surveyWriteInListItemView, OnFocusChangeListener onFocusChangeListener) {
        surveyWriteInListItemView.setChecked(surveyWriteInItem.mo1295b());
        surveyWriteInListItemView.f17241f = onFocusChangeListener;
        if (surveyWriteInListItemView.f17202a.f17166b.equals(this.f17125e) && surveyWriteInItem.mo1295b()) {
            surveyWriteInListItemView.m24985a();
        }
    }
}
