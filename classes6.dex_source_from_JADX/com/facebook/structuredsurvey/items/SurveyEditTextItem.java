package com.facebook.structuredsurvey.items;

import com.facebook.structuredsurvey.StructuredSurveyState.Answer;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;

/* compiled from: display_uri */
public class SurveyEditTextItem extends SurveyItem implements AnswerableItem<String> {
    private Answer f17169c;

    public SurveyEditTextItem(String str) {
        super(ItemType.EDITTEXT, str);
    }

    public final String m24930c() {
        if (this.f17169c == null) {
            return null;
        }
        return this.f17169c.f17111b;
    }

    public final Answer mo1294a() {
        return this.f17169c;
    }

    public final void m24928a(String str) {
        this.f17169c = new Answer(str);
    }

    public final boolean mo1295b() {
        return m24930c() != null;
    }
}
