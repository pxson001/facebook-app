package com.facebook.messaging.payment.model.verification;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_seen_tooltip/ */
public class UserInputSerializer extends JsonSerializer<UserInput> {
    public final void m14091a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        UserInput userInput = (UserInput) obj;
        if (userInput == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m14090b(userInput, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(UserInput.class, new UserInputSerializer());
    }

    private static void m14090b(UserInput userInput, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "first_name", userInput.mFirstName);
        AutoGenJsonHelper.a(jsonGenerator, "last_name", userInput.mLastName);
        AutoGenJsonHelper.a(jsonGenerator, "card_first_six", userInput.mCardFirstSix);
        AutoGenJsonHelper.a(jsonGenerator, "dob_year", userInput.mDobYear);
        AutoGenJsonHelper.a(jsonGenerator, "dob_month", userInput.mDobMonth);
        AutoGenJsonHelper.a(jsonGenerator, "dob_day", userInput.mDobDay);
        AutoGenJsonHelper.a(jsonGenerator, "ssn_last_four", userInput.mSsnLastFour);
    }
}
