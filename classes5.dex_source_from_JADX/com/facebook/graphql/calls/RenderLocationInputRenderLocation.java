package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: post_play_count */
public enum RenderLocationInputRenderLocation implements JsonSerializable {
    DEFAULT_LOCATION("DEFAULT_LOCATION"),
    WWW_TIMELINE("WWW_TIMELINE"),
    WWW_FRIENDS("WWW_FRIENDS"),
    MTOUCH_TIMELINE("MTOUCH_TIMELINE"),
    IOS_TIMELINE("IOS_TIMELINE"),
    ANDROID_TIMELINE("ANDROID_TIMELINE"),
    WWW_HOVERCARD("WWW_HOVERCARD"),
    WWW_CHAT_HOVERCARD("WWW_CHAT_HOVERCARD"),
    M_EXPANDED_CONTEXT("M_EXPANDED_CONTEXT"),
    CONTACT_CARD("CONTACT_CARD"),
    MARKETPLACE("MARKETPLACE"),
    MESSENGER("MESSENGER"),
    MESSENGER_SEARCH("MESSENGER_SEARCH"),
    MESSENGER_ONLY_USER_ONBOARDING("MESSENGER_ONLY_USER_ONBOARDING"),
    WWW_PROFILE_TILE("WWW_PROFILE_TILE"),
    MTOUCH_PROFILE_TILE("MTOUCH_PROFILE_TILE"),
    IOS_PROFILE_TILE("IOS_PROFILE_TILE"),
    ANDROID_PROFILE_TILE("ANDROID_PROFILE_TILE"),
    IOS_PROFILE_INTRO_CARD_HEADER("IOS_PROFILE_INTRO_CARD_HEADER"),
    ANDROID_PROFILE_INTRO_CARD_HEADER("ANDROID_PROFILE_INTRO_CARD_HEADER"),
    IOS_PROFILE_INTRO_CARD("IOS_PROFILE_INTRO_CARD"),
    ANDROID_PROFILE_INTRO_CARD("ANDROID_PROFILE_INTRO_CARD"),
    MTOUCH_PROFILE_INTRO_CARD("MTOUCH_PROFILE_INTRO_CARD"),
    WWW_PROFILE_INTRO_CARD("WWW_PROFILE_INTRO_CARD"),
    IOS_MORE_MENU_PROFILE_CARD("IOS_MORE_MENU_PROFILE_CARD"),
    ANDROID_MORE_MENU_PROFILE_CARD("ANDROID_MORE_MENU_PROFILE_CARD"),
    MTOUCH_MORE_MENU_PROFILE_CARD("MTOUCH_MORE_MENU_PROFILE_CARD"),
    IOS_MORE_MENU_PROFILE_HEADER("IOS_MORE_MENU_PROFILE_HEADER"),
    ANDROID_MORE_MENU_PROFILE_HEADER("ANDROID_MORE_MENU_PROFILE_HEADER"),
    MTOUCH_MORE_MENU_PROFILE_HEADER("MTOUCH_MORE_MENU_PROFILE_HEADER"),
    PROFILE_MUTUALITY("PROFILE_MUTUALITY"),
    PEOPLE_DISCOVERY("PEOPLE_DISCOVERY"),
    PEOPLE_DISCOVERY_RANKING("PEOPLE_DISCOVERY_RANKING"),
    UNIT_TEST("UNIT_TEST"),
    INTERN_PROFILE("INTERN_PROFILE");
    
    protected final String serverValue;

    private RenderLocationInputRenderLocation(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
