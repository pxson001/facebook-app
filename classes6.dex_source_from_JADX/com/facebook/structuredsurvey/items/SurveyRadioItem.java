package com.facebook.structuredsurvey.items;

import com.facebook.structuredsurvey.StructuredSurveyState.Answer;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;

/* compiled from: dismissed */
public class SurveyRadioItem extends SurveyItem implements AnswerableItem<Boolean> {
    public Answer f17177c;
    private boolean f17178d;

    public SurveyRadioItem(Answer answer, String str) {
        super(ItemType.RADIO, str);
        this.f17177c = answer;
    }

    public final Answer mo1294a() {
        return this.f17177c;
    }

    public final boolean mo1295b() {
        return this.f17178d;
    }

    public final void m24932a(Boolean bool) {
        this.f17178d = bool.booleanValue();
    }
}
