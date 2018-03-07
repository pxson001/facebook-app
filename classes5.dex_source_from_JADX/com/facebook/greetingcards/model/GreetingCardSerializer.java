package com.facebook.greetingcards.model;

import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: TRENDING_STORIES */
public class GreetingCardSerializer extends JsonSerializer<GreetingCard> {
    public final void m22806a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GreetingCard greetingCard = (GreetingCard) obj;
        jsonGenerator.f();
        jsonGenerator.a("template_id", greetingCard.f13524d);
        jsonGenerator.a("theme", greetingCard.f13525e);
        jsonGenerator.f("slides");
        jsonGenerator.f();
        m22805a(jsonGenerator, greetingCard.f13521a);
        jsonGenerator.a("slide_type", "COVER_SLIDE");
        jsonGenerator.g();
        ImmutableList immutableList = greetingCard.f13522b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Slide slide = (Slide) immutableList.get(i);
            jsonGenerator.f();
            m22805a(jsonGenerator, slide);
            jsonGenerator.a("slide_type", "STORY_SLIDE");
            jsonGenerator.g();
        }
        jsonGenerator.f();
        m22805a(jsonGenerator, greetingCard.f13523c);
        jsonGenerator.a("slide_type", "CLOSING_SLIDE");
        jsonGenerator.g();
        jsonGenerator.e();
        jsonGenerator.g();
    }

    private static void m22805a(JsonGenerator jsonGenerator, Slide slide) {
        jsonGenerator.a("title", slide.f13518a);
        if (slide.f13519b != null) {
            jsonGenerator.a("message", slide.f13519b);
        }
        if (slide.f13520c != null && !slide.f13520c.isEmpty()) {
            jsonGenerator.f("photos");
            ImmutableList immutableList = slide.f13520c;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                jsonGenerator.a(((CardPhoto) immutableList.get(i)).f13515c);
            }
            jsonGenerator.e();
        }
    }
}
