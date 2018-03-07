package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyWriteInItem;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: disable_friend_tagging */
public class SurveyWriteInListItemView extends SurveyListItemView implements Checkable {
    private CompoundButton f17237b;
    private BetterEditTextView f17238c;
    private BetterTextView f17239d;
    private ItemType f17240e;
    public OnFocusChangeListener f17241f;

    /* compiled from: disable_friend_tagging */
    class C12511 implements OnClickListener {
        final /* synthetic */ SurveyWriteInListItemView f17234a;

        C12511(SurveyWriteInListItemView surveyWriteInListItemView) {
            this.f17234a = surveyWriteInListItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1491557012);
            this.f17234a.setChecked(true);
            Logger.a(2, EntryType.UI_INPUT_END, -609676618, a);
        }
    }

    /* compiled from: disable_friend_tagging */
    class C12522 implements OnClickListener {
        final /* synthetic */ SurveyWriteInListItemView f17235a;

        C12522(SurveyWriteInListItemView surveyWriteInListItemView) {
            this.f17235a = surveyWriteInListItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1983197473);
            ((View) view.getParent()).performClick();
            Logger.a(2, EntryType.UI_INPUT_END, -1000218904, a);
        }
    }

    /* compiled from: disable_friend_tagging */
    class C12533 implements OnFocusChangeListener {
        final /* synthetic */ SurveyWriteInListItemView f17236a;

        C12533(SurveyWriteInListItemView surveyWriteInListItemView) {
            this.f17236a = surveyWriteInListItemView;
        }

        public void onFocusChange(View view, boolean z) {
            Assertions.a(this.f17236a.f17241f, "Adapter has not registered its listener");
            this.f17236a.f17241f.onFocusChange(view, z);
            if (z) {
                this.f17236a.setChecked(true);
            } else {
                ((SurveyWriteInItem) this.f17236a.f17202a).m24935a(this.f17236a.getText());
            }
        }
    }

    public SurveyWriteInListItemView(Context context) {
        super(context);
    }

    public SurveyWriteInListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static SurveyWriteInListItemView m24983a(ViewGroup viewGroup, ItemType itemType) {
        SurveyWriteInListItemView surveyWriteInListItemView = (SurveyWriteInListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907352, viewGroup, false);
        viewGroup.getContext();
        surveyWriteInListItemView.m24984a(itemType);
        surveyWriteInListItemView.setTag(itemType);
        return surveyWriteInListItemView;
    }

    private void m24984a(ItemType itemType) {
        int i;
        int i2;
        int i3;
        this.f17240e = itemType;
        if (itemType == ItemType.CHECKBOXWRITEIN) {
            i = 2130907331;
            i2 = 2131567774;
            i3 = 2131567773;
        } else if (itemType == ItemType.RADIOWRITEIN) {
            i = 2130907349;
            i2 = 2131567797;
            i3 = 2131567796;
        } else {
            throw new RuntimeException("Either CHECKBOXWRITEIN or RADIOWRITEIN type is allowed");
        }
        setContentView(i);
        this.f17237b = (CompoundButton) findViewById(i2);
        this.f17239d = (BetterTextView) findViewById(i3);
        this.f17238c = (BetterEditTextView) findViewById(2131567775);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        this.a = surveyItem;
        SurveyWriteInItem surveyWriteInItem = (SurveyWriteInItem) surveyItem;
        this.f17238c.setText(surveyWriteInItem.f17182e.m24930c());
        this.f17239d.setText(surveyWriteInItem.f17180c.f17112c);
        if (this.f17240e == ItemType.CHECKBOXWRITEIN) {
            this.f17238c.setOnClickListener(new C12511(this));
        } else if (this.f17240e == ItemType.RADIOWRITEIN) {
            this.f17238c.setOnClickListener(new C12522(this));
        }
        this.f17238c.setOnFocusChangeListener(new C12533(this));
    }

    public void setItemOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f17241f = onFocusChangeListener;
    }

    public String getText() {
        return this.f17238c.getText().toString();
    }

    public final void m24985a() {
        this.f17238c.requestFocus();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ((SurveyWriteInItem) this.f17202a).m24935a(getText());
    }

    public boolean isChecked() {
        return this.f17237b.isChecked();
    }

    public void setChecked(boolean z) {
        this.f17237b.setChecked(z);
        ((SurveyWriteInItem) this.f17202a).f17181d = Boolean.valueOf(z).booleanValue();
    }

    public void toggle() {
        setChecked(!this.f17237b.isChecked());
    }
}
