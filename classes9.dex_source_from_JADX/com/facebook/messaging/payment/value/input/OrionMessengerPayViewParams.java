package com.facebook.messaging.payment.value.input;

import com.facebook.common.util.TriState;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import com.google.common.base.Optional;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: event_info */
public class OrionMessengerPayViewParams implements MessengerPayViewParams {
    public final MessengerPayState f15553a;
    @Nullable
    public final Optional<PaymentCard> f15554b;
    public final Name f15555c;
    public final UserKey f15556d;
    public final TriState f15557e;
    public final MessengerPayAmount f15558f;
    @Nullable
    public final String f15559g;
    @Nullable
    public final List<Theme> f15560h;
    @Nullable
    public final ThemeModel f15561i;

    public OrionMessengerPayViewParams(OrionMessengerPayViewParamsBuilder orionMessengerPayViewParamsBuilder) {
        this.f15553a = orionMessengerPayViewParamsBuilder.f15562a;
        this.f15554b = orionMessengerPayViewParamsBuilder.f15563b;
        this.f15555c = orionMessengerPayViewParamsBuilder.f15564c;
        this.f15556d = orionMessengerPayViewParamsBuilder.f15565d;
        this.f15557e = orionMessengerPayViewParamsBuilder.f15566e;
        this.f15558f = orionMessengerPayViewParamsBuilder.f15567f;
        this.f15559g = orionMessengerPayViewParamsBuilder.f15568g;
        this.f15560h = orionMessengerPayViewParamsBuilder.f15569h;
        this.f15561i = orionMessengerPayViewParamsBuilder.f15570i;
    }
}
