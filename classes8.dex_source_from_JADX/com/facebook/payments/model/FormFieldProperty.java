package com.facebook.payments.model;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_privacy_picker_donebutton */
public enum FormFieldProperty {
    REQUIRED,
    OPTIONAL,
    HIDDEN;

    public static FormFieldProperty forValue(String str) {
        for (FormFieldProperty formFieldProperty : values()) {
            if (formFieldProperty.toString().equalsIgnoreCase(str)) {
                return formFieldProperty;
            }
        }
        return REQUIRED;
    }
}
