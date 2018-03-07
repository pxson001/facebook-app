package com.facebook.messaging.payment.value.input;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetCompatibilityEnum;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetTypeEnum;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeAssetModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: error_load_new_user_signup */
public class ThemeHelper {
    public static int m15867a(@Nullable List<Theme> list, @Nullable Theme theme) {
        if (list == null || theme == null) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (((ThemeModel) list.get(i)).m13942d().equals(theme.m13942d())) {
                return i + 1;
            }
        }
        return 0;
    }

    @Nullable
    public static Theme m15869a(@Nullable List<Theme> list, int i) {
        if (list == null || i <= 0 || i > list.size()) {
            return null;
        }
        return (ThemeModel) list.get(i - 1);
    }

    @Nullable
    public static Uri m15868a(ThemeModel themeModel) {
        ImmutableList a = themeModel.m13940b().m13932a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ThemeAssetModel themeAssetModel = (ThemeAssetModel) a.get(i);
            if (themeAssetModel.m13925b().contains(GraphQLMessengerPayThemeAssetCompatibilityEnum.ANDROID) && themeAssetModel.m13923a().equals(GraphQLMessengerPayThemeAssetTypeEnum.SEND_VIEW)) {
                return Uri.parse(themeAssetModel.m13926c().m13918a());
            }
        }
        return null;
    }
}
