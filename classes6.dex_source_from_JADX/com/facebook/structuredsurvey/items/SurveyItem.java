package com.facebook.structuredsurvey.items;

/* compiled from: displayed_text */
public class SurveyItem {
    public ItemType f17165a;
    public String f17166b;

    /* compiled from: displayed_text */
    public enum ItemType {
        QUESTION,
        RADIO,
        CHECKBOX,
        EDITTEXT,
        MESSAGE,
        IMAGEBLOCK,
        DIVIDER,
        WHITESPACE,
        RADIOWRITEIN,
        CHECKBOXWRITEIN,
        NOTIFICATION;

        public static ItemType fromInt(int i) {
            switch (i) {
                case 0:
                    return QUESTION;
                case 1:
                    return RADIO;
                case 2:
                    return CHECKBOX;
                case 3:
                    return EDITTEXT;
                case 4:
                    return MESSAGE;
                case 5:
                    return IMAGEBLOCK;
                case 6:
                    return DIVIDER;
                case 7:
                    return WHITESPACE;
                case 8:
                    return RADIOWRITEIN;
                case 9:
                    return CHECKBOXWRITEIN;
                case 10:
                    return NOTIFICATION;
                default:
                    return WHITESPACE;
            }
        }
    }

    public SurveyItem(ItemType itemType, String str) {
        this.f17165a = itemType;
        this.f17166b = str;
    }
}
