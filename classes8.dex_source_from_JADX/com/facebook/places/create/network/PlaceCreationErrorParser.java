package com.facebook.places.create.network;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.http.protocol.ApiErrorResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: card_form_fragment */
public class PlaceCreationErrorParser {
    private JsonFactory f18365a;
    private ObjectMapper f18366b;

    @VisibleForTesting
    /* compiled from: card_form_fragment */
    enum CreationError {
        ERROR_PARAM(100),
        SENTRY_FAIL(368),
        TOO_MANY_PLACE(2400),
        SIMILAR_NAME(2406),
        INVALID_NAME(2409),
        LOCATION_INACCURATE(2408),
        INVALID_PHONE(2410),
        INVALID_WEBSITE(2411),
        OTHER(0);
        
        public final int errorCode;

        private CreationError(int i) {
            this.errorCode = i;
        }

        public static CreationError fromErrorCode(int i) {
            for (CreationError creationError : values()) {
                if (creationError.errorCode == i) {
                    return creationError;
                }
            }
            return OTHER;
        }
    }

    /* compiled from: card_form_fragment */
    public class ErrorParameterException extends Exception {
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlaceCreationErrorParser_InvalidNameExceptionDeserializer.class)
    /* compiled from: card_form_fragment */
    public class InvalidNameException extends Exception {
        @JsonProperty("reason")
        public final InvalidNameReason reason = InvalidNameReason.OTHER;
        @JsonProperty("suggestion")
        public final String suggestion = null;
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlaceCreationErrorParser_InvalidNameReasonDeserializer.class)
    /* compiled from: card_form_fragment */
    public enum InvalidNameReason {
        INVALID_CHARS("invalid_chars"),
        BLACKLIST("blacklist"),
        INVALID_CAPS("caps"),
        OTHER("other");
        
        private final String reason;

        private InvalidNameReason(String str) {
            this.reason = str;
        }

        @JsonCreator
        public static InvalidNameReason fromString(String str) {
            for (InvalidNameReason invalidNameReason : values()) {
                if (invalidNameReason.reason.equals(str)) {
                    return invalidNameReason;
                }
            }
            return OTHER;
        }
    }

    /* compiled from: card_form_fragment */
    public class InvalidPhoneException extends Exception {
    }

    /* compiled from: card_form_fragment */
    public class InvalidWebsiteException extends Exception {
    }

    /* compiled from: card_form_fragment */
    public class LocationInaccurateException extends Exception {
    }

    /* compiled from: card_form_fragment */
    public class SentryFailException extends Exception {
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlaceCreationErrorParser_SimilarPlaceExceptionDeserializer.class)
    /* compiled from: card_form_fragment */
    public class SimilarPlaceException extends Exception {
        @JsonProperty("id")
        public final long id = 0;
        @JsonProperty("name")
        public final String name = null;
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlaceCreationErrorParser_SimilarPlaceWrapperDeserializer.class)
    /* compiled from: card_form_fragment */
    class SimilarPlaceWrapper {
        @JsonProperty("similar_places")
        public final List<SimilarPlaceException> similarPlaces = Lists.a();

        SimilarPlaceWrapper() {
        }
    }

    /* compiled from: card_form_fragment */
    public class TooManyPlaceException extends Exception {
    }

    /* compiled from: card_form_fragment */
    public class UnknownError extends Exception {
    }

    @Inject
    public PlaceCreationErrorParser(JsonFactory jsonFactory, ObjectMapper objectMapper) {
        this.f18365a = jsonFactory;
        this.f18366b = objectMapper;
    }

    private InvalidNameException m22312b(ApiErrorResult apiErrorResult) {
        try {
            JsonParser b = this.f18365a.b(apiErrorResult.d());
            b.a(this.f18366b);
            return (InvalidNameException) b.a(InvalidNameException.class);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private List<SimilarPlaceException> m22313c(ApiErrorResult apiErrorResult) {
        try {
            JsonParser b = this.f18365a.b(apiErrorResult.d());
            b.a(this.f18366b);
            return ((SimilarPlaceWrapper) b.a(SimilarPlaceWrapper.class)).similarPlaces;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void m22314a(ApiErrorResult apiErrorResult) {
        switch (CreationError.fromErrorCode(apiErrorResult.a())) {
            case ERROR_PARAM:
                throw new ErrorParameterException();
            case SENTRY_FAIL:
                throw new SentryFailException();
            case TOO_MANY_PLACE:
                throw new TooManyPlaceException();
            case SIMILAR_NAME:
                throw ((SimilarPlaceException) m22313c(apiErrorResult).get(0));
            case INVALID_NAME:
                throw m22312b(apiErrorResult);
            case LOCATION_INACCURATE:
                throw m22312b(apiErrorResult);
            case INVALID_PHONE:
                throw new InvalidPhoneException();
            case INVALID_WEBSITE:
                throw new InvalidWebsiteException();
            default:
                throw new UnknownError();
        }
    }
}
