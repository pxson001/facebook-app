package com.facebook.richdocument.utils;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentNestedListItemFields;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentListItemEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentListItemEdgeModel.RichDocumentListItemModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentListItemsModel.ListElementsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel.NLENLEModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel.NLENLEModel.NLENLENModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel.NLENLEModel.NLENLENModel.NLENLENLModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentNestedListItemModel.LModel.EModel.NModel.NLModel.NLEModel.NLENModel.NLENLModel.NLENLEModel.NLENLENModel.NLENLENLModel.NLENLENLEModel;
import com.google.common.collect.ImmutableList;

/* compiled from: pending_contactpoint */
public class ListBlockAccessors {
    public static Object m6855f(Object obj) {
        if (obj instanceof ListElementsModel) {
            return ((ListElementsModel) obj).m6018a();
        }
        if (obj instanceof LModel) {
            return ((LModel) obj).m6143a();
        }
        if (obj instanceof NLModel) {
            return ((NLModel) obj).m6125a();
        }
        if (obj instanceof NLENLModel) {
            return ((NLENLModel) obj).m6107a();
        }
        if (obj instanceof NLENLENLModel) {
            return ((NLENLENLModel) obj).m6089a();
        }
        return null;
    }

    public static Object m6850a(Object obj, int i) {
        if (obj instanceof ListElementsModel) {
            return ((RichDocumentListItemEdgeModel) ((ImmutableList) m6855f(obj)).get(i)).m6012a();
        }
        if (obj instanceof LModel) {
            return ((EModel) ((ImmutableList) m6855f(obj)).get(i)).m6139a();
        }
        if (obj instanceof NLModel) {
            return ((NLEModel) ((ImmutableList) m6855f(obj)).get(i)).m6121a();
        }
        if (obj instanceof NLENLModel) {
            return ((NLENLEModel) ((ImmutableList) m6855f(obj)).get(i)).m6103a();
        }
        if (obj instanceof NLENLENLModel) {
            return ((NLENLENLEModel) ((ImmutableList) m6855f(obj)).get(i)).m6085a();
        }
        return null;
    }

    public static GraphQLDocumentElementType m6851b(Object obj) {
        if (obj instanceof RichDocumentListItemModel) {
            return ((RichDocumentListItemModel) obj).mo358b();
        }
        if (obj instanceof NModel) {
            return ((NModel) obj).mo358b();
        }
        if (obj instanceof NLENModel) {
            return ((NLENModel) obj).mo358b();
        }
        if (obj instanceof NLENLENModel) {
            return ((NLENLENModel) obj).mo358b();
        }
        if (obj instanceof RichDocumentNestedListItemFields) {
            return ((RichDocumentNestedListItemFields) obj).mo358b();
        }
        return null;
    }

    public static RichDocumentText m6852c(Object obj) {
        if (obj instanceof RichDocumentListItemModel) {
            return ((RichDocumentListItemModel) obj).mo359c();
        }
        if (obj instanceof NModel) {
            return ((NModel) obj).mo359c();
        }
        if (obj instanceof NLENModel) {
            return ((NLENModel) obj).mo359c();
        }
        if (obj instanceof NLENLENModel) {
            return ((NLENLENModel) obj).mo359c();
        }
        if (obj instanceof RichDocumentNestedListItemFields) {
            return ((RichDocumentNestedListItemFields) obj).mo359c();
        }
        return null;
    }

    public static GraphQLDocumentListStyle m6853d(Object obj) {
        if (obj instanceof RichDocumentListItemModel) {
            return ((RichDocumentListItemModel) obj).ih_();
        }
        if (obj instanceof NModel) {
            return ((NModel) obj).ih_();
        }
        if (obj instanceof NLENModel) {
            return ((NLENModel) obj).ih_();
        }
        if (obj instanceof NLENLENModel) {
            return ((NLENLENModel) obj).ih_();
        }
        if (obj instanceof RichDocumentNestedListItemFields) {
            return ((RichDocumentNestedListItemFields) obj).ih_();
        }
        return null;
    }

    public static Object m6854e(Object obj) {
        if (obj instanceof RichDocumentListItemModel) {
            return ((RichDocumentListItemModel) obj).m6006d();
        }
        if (obj instanceof NModel) {
            return ((NModel) obj).m6132a();
        }
        if (obj instanceof NLENModel) {
            return ((NLENModel) obj).m6114a();
        }
        if (obj instanceof NLENLENModel) {
            return ((NLENLENModel) obj).m6096a();
        }
        return null;
    }
}
