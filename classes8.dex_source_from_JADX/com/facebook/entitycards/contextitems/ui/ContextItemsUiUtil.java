package com.facebook.entitycards.contextitems.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: immersive_views_on */
public class ContextItemsUiUtil {

    /* compiled from: immersive_views_on */
    /* synthetic */ class C11741 {
        static final /* synthetic */ int[] f10941a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f10941a[GraphQLEntityCardContextItemType.PLACE_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10941a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_NEW_LIKES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10941a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_POST_REACH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10941a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_ACTIVE_TROPHY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10941a[GraphQLEntityCardContextItemType.PAGE_MESSAGE_RESPONSE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static CharSequence m12878a(ContextItemFieldsModel contextItemFieldsModel, Context context) {
        DefaultTextWithEntitiesLongFields bC_ = contextItemFieldsModel.bC_();
        if (bC_ == null) {
            return "";
        }
        if (bC_.b() == null) {
            return bC_.a();
        }
        int color = context.getResources().getColor(2131361938);
        ImmutableList immutableList = RegularImmutableList.a;
        switch (C11741.f10941a[contextItemFieldsModel.d().ordinal()]) {
            case 1:
                if (contextItemFieldsModel.bB_() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(contextItemFieldsModel.bB_())));
                    break;
                }
                break;
            case 2:
                if (contextItemFieldsModel.bB_() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(contextItemFieldsModel.bB_())), Integer.valueOf(color));
                    break;
                }
                break;
            case 3:
                immutableList = ImmutableList.of(Integer.valueOf(color));
                break;
            case 4:
            case 5:
                if (contextItemFieldsModel.bB_() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(contextItemFieldsModel.bB_())));
                    break;
                }
                break;
        }
        return m12880a(immutableList, DefaultGraphQLConversionHelper.a(contextItemFieldsModel.bC_()));
    }

    public static CharSequence m12879a(GraphQLEntityCardContextItem graphQLEntityCardContextItem, Context context) {
        GraphQLTextWithEntities o = graphQLEntityCardContextItem.o();
        if (o == null) {
            return "";
        }
        if (o.b() == null) {
            return o.a();
        }
        int color = context.getResources().getColor(2131361938);
        ImmutableList immutableList = RegularImmutableList.a;
        switch (C11741.f10941a[graphQLEntityCardContextItem.l().ordinal()]) {
            case 1:
                if (graphQLEntityCardContextItem.p() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(graphQLEntityCardContextItem.p())));
                    break;
                }
                break;
            case 2:
                if (graphQLEntityCardContextItem.p() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(graphQLEntityCardContextItem.p())), Integer.valueOf(color));
                    break;
                }
                break;
            case 3:
                immutableList = ImmutableList.of(Integer.valueOf(color));
                break;
            case 4:
            case 5:
                if (graphQLEntityCardContextItem.p() != null) {
                    immutableList = ImmutableList.of(Integer.valueOf(m12877a(graphQLEntityCardContextItem.p())));
                    break;
                }
                break;
        }
        return m12880a(immutableList, graphQLEntityCardContextItem.o());
    }

    private static int m12877a(String str) {
        return Color.parseColor("#" + str);
    }

    private static CharSequence m12880a(ImmutableList<Integer> immutableList, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities.b() == null || immutableList.size() != graphQLTextWithEntities.b().size()) {
            return graphQLTextWithEntities.a();
        }
        CharSequence spannableString = new SpannableString(graphQLTextWithEntities.a());
        ImmutableList b = graphQLTextWithEntities.b();
        for (int i = 0; i < b.size(); i++) {
            GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
            spannableString.setSpan(new ForegroundColorSpan(((Integer) immutableList.get(i)).intValue()), graphQLEntityAtRange.c(), graphQLEntityAtRange.b() + graphQLEntityAtRange.c(), 33);
        }
        return spannableString;
    }
}
