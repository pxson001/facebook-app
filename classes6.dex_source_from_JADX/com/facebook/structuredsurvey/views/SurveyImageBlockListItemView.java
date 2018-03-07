package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.resources.ui.FbTextView;
import com.facebook.structuredsurvey.items.SurveyImageBlockItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.widget.text.BetterButton;

/* compiled from: disambiguation_send_empty_modules */
public class SurveyImageBlockListItemView extends SurveyListItemView {
    private FbTextView f17207b;
    private BetterButton f17208c;

    public SurveyImageBlockListItemView(Context context) {
        super(context);
        m24956a();
    }

    public SurveyImageBlockListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24956a();
    }

    public static SurveyImageBlockListItemView m24955a(ViewGroup viewGroup) {
        SurveyImageBlockListItemView surveyImageBlockListItemView = (SurveyImageBlockListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907338, viewGroup, false);
        surveyImageBlockListItemView.setTag(ItemType.IMAGEBLOCK);
        return surveyImageBlockListItemView;
    }

    private void m24956a() {
        setContentView(2130907337);
        this.f17207b = (FbTextView) findViewById(2131567781);
        this.f17208c = (BetterButton) findViewById(2131567782);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        SurveyImageBlockItem surveyImageBlockItem = (SurveyImageBlockItem) surveyItem;
        this.f17207b.setText(surveyImageBlockItem.f17170c);
        this.f17208c.setText(surveyImageBlockItem.f17171d);
    }
}
