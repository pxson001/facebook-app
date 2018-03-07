package com.facebook.structuredsurvey.items;

import com.facebook.structuredsurvey.StructuredSurveyState.Answer;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;

/* compiled from: dismiss_toast */
public class SurveyWriteInItem extends SurveyItem implements AnswerableItem<Boolean> {
    public Answer f17180c;
    public boolean f17181d;
    public final SurveyEditTextItem f17182e;

    public SurveyWriteInItem(ItemType itemType, Answer answer, String str) {
        super(itemType, str);
        this.f17180c = answer;
        this.f17182e = new SurveyEditTextItem(str);
    }

    public final boolean mo1295b() {
        return this.f17181d;
    }

    public final void m24935a(String str) {
        this.f17182e.m24928a(str);
    }

    public final Answer mo1294a() {
        return new Answer(this.f17180c.f17110a, this.f17182e.m24930c(), this.f17180c.f17112c);
    }
}
