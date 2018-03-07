package com.fasterxml.jackson.annotation;

import com.facebook.proxygen.HTTPTransportCallback;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: story_gallery_survey_actions_type */
public @interface JsonAutoDetect {

    /* compiled from: story_gallery_survey_actions_type */
    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public final boolean isVisible(Member member) {
            switch (1.a[ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return true;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return false;
                case 3:
                    if (Modifier.isPrivate(member.getModifiers())) {
                        return false;
                    }
                    return true;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    if (Modifier.isProtected(member.getModifiers())) {
                        return true;
                    }
                    break;
                case 5:
                    break;
                default:
                    return false;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;
}
