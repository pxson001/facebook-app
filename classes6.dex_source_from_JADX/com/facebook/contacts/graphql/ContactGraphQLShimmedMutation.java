package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLShimModels.AddContactModel;
import com.facebook.graphql.query.ShimmedMutationRequestParams;
import com.facebook.graphql.query.ShimmedMutationRequestParams.ResultQuery;
import com.facebook.graphql.query.ShimmedMutationRequestParams.Variable;
import com.facebook.graphql.query.ShimmedMutationRequestParams.VariableType;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photoFbids */
public final class ContactGraphQLShimmedMutation {

    /* compiled from: photoFbids */
    public class AddContactContactString extends TypedGraphQlQueryString<ContactModel> {
        public AddContactContactString() {
            super(ContactModel.class, false, "AddContactContact", "984b21750846aa105557835c93169c8c", "node", "10154444360781729", RegularImmutableSet.a);
        }

        public final String m12026a(String str) {
            switch (str.hashCode()) {
                case -1906025967:
                    return "2";
                case -1589682499:
                    return "0";
                case -1439844555:
                    return "3";
                case 693548892:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: photoFbids */
    public class AddContactString extends TypedGraphQLMutationString<AddContactModel> {
        public AddContactString() {
            ImmutableSet of = ImmutableSet.of();
            Variable[] variableArr = new Variable[]{new Variable(VariableType.FIELD, "actor_id")};
            String[] strArr = new String[]{"profile_id", "phone", "country_code", "add_unless_deleted"};
            Variable[] variableArr2 = new Variable[]{new Variable(VariableType.FIELD, "user_id"), new Variable(VariableType.FIELD, "phone"), new Variable(VariableType.FIELD, "country_code"), new Variable(VariableType.FIELD, "add_unless_deleted")};
            ResultQuery[] resultQueryArr = new ResultQuery[1];
            resultQueryArr[0] = new ResultQuery(new String[]{"argument"}, new Variable[]{new Variable(VariableType.LITERAL, "literal", "{result=Mutation:$.id}")}, new String[]{"argument", "small_img_size", "big_img_size", "huge_img_size"}, ContactGraphQLShimmedMutation.m12027a(), "contact");
            super(AddContactModel.class, false, "AddContact", "c26fb381c7dda448fa7e63cbafed84c1", "contact_create", "input", null, of, new ShimmedMutationRequestParams("contact_create", "POST", "%s/contacts", variableArr, strArr, variableArr2, resultQueryArr, "input"));
        }
    }

    public static final AddContactContactString m12027a() {
        return new AddContactContactString();
    }
}
