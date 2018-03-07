package com.facebook.messaging.payment.value.input;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: escalated */
public class OrionRequestMessengerPayViewParams implements MessengerPayViewParams {
    public final MessengerPayState f15673a;
    public final MessengerPayAmount f15674b;
    @Nullable
    public final String f15675c;
    @Nullable
    public final List<Theme> f15676d;
    @Nullable
    public final ThemeModel f15677e;

    public OrionRequestMessengerPayViewParams(OrionRequestMessengerPayViewParamsBuilder orionRequestMessengerPayViewParamsBuilder) {
        this.f15673a = orionRequestMessengerPayViewParamsBuilder.f15678a;
        this.f15674b = orionRequestMessengerPayViewParamsBuilder.f15679b;
        this.f15675c = orionRequestMessengerPayViewParamsBuilder.f15680c;
        this.f15676d = orionRequestMessengerPayViewParamsBuilder.f15681d;
        this.f15677e = orionRequestMessengerPayViewParamsBuilder.f15682e;
    }
}
