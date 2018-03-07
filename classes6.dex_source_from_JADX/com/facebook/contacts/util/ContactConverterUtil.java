package com.facebook.contacts.util;

import com.facebook.contacts.graphql.Contact;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;

/* compiled from: own_page_timeline */
public class ContactConverterUtil {
    public static UserKey m12315b(Contact contact) {
        if (contact.c() != null) {
            return new UserKey(Type.FACEBOOK, contact.c());
        }
        return new UserKey(Type.FACEBOOK_CONTACT, contact.b());
    }

    public static User m12314a(Contact contact) {
        PicSquare picSquare;
        boolean z;
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.g = contact.e();
        userBuilder = userBuilder;
        userBuilder.X = contact.G();
        userBuilder = userBuilder;
        userBuilder.P = contact.p();
        userBuilder = userBuilder;
        userBuilder.n = contact.g();
        userBuilder = userBuilder;
        if (contact.g() == null || contact.h() == null || contact.i() == null) {
            picSquare = null;
        } else {
            picSquare = new PicSquare(new PicSquareUrlWithSize(contact.j(), contact.g()), new PicSquareUrlWithSize(contact.k(), contact.h()), new PicSquareUrlWithSize(contact.l(), contact.i()));
        }
        userBuilder.p = picSquare;
        userBuilder = userBuilder;
        userBuilder.t = contact.m();
        UserBuilder userBuilder2 = userBuilder;
        if (contact.x() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            z = true;
        } else {
            z = false;
        }
        userBuilder2.G = z;
        userBuilder = userBuilder2;
        userBuilder.u = contact.r();
        userBuilder = userBuilder;
        userBuilder.A = contact.s();
        userBuilder = userBuilder;
        userBuilder.E = contact.t();
        userBuilder = userBuilder;
        userBuilder.F = contact.w();
        userBuilder = userBuilder.a(contact.E(), contact.D());
        userBuilder.Y = contact.I();
        userBuilder = userBuilder;
        userBuilder.Z = contact.J();
        UserBuilder userBuilder3 = userBuilder;
        if (contact.c() != null) {
            userBuilder3.a(Type.FACEBOOK, contact.c());
        } else {
            userBuilder3.a(Type.FACEBOOK_CONTACT, contact.b());
        }
        return userBuilder3.aa();
    }
}
