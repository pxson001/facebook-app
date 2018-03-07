package com.facebook.structuredsurvey.items;

import com.facebook.structuredsurvey.StructuredSurveyState.Answer;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;

/* compiled from: displayable_flow_text */
public class SurveyCheckboxItem extends SurveyItem implements AnswerableItem<Boolean> {
    private Answer f17167c;
    public boolean f17168d;

    public SurveyCheckboxItem(Answer answer, String str) {
        super(ItemType.CHECKBOX, str);
        this.f17167c = answer;
    }

    public final Answer mo1294a() {
        return this.f17167c;
    }

    public final boolean mo1295b() {
        return this.f17168d;
    }
}
