package com.facebook.contacts.omnistore;

import android.annotation.SuppressLint;
import com.facebook.common.util.TriState;
import com.facebook.contacts.graphql.C0498x332b405b;
import com.facebook.contacts.graphql.C0498x332b405b.ValueModel;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactBuilder;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel$NameEntriesModel$Builder;
import com.facebook.contacts.graphql.ContactGraphQLModels$CoverPhotoModel$Builder;
import com.facebook.contacts.graphql.ContactGraphQLModels$CoverPhotoModel$PhotoModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.NameEntriesModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.CoverPhotoModel;
import com.facebook.contacts.graphql.ContactPhone;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.omnistore.flatbuffer.Actor;
import com.facebook.contacts.omnistore.flatbuffer.City;
import com.facebook.contacts.omnistore.flatbuffer.ContactEntry;
import com.facebook.contacts.omnistore.flatbuffer.ContactField;
import com.facebook.contacts.omnistore.flatbuffer.CoverPhoto;
import com.facebook.contacts.omnistore.flatbuffer.Date;
import com.facebook.contacts.omnistore.flatbuffer.Image;
import com.facebook.contacts.omnistore.flatbuffer.Name;
import com.facebook.contacts.omnistore.flatbuffer.NamePart;
import com.facebook.contacts.omnistore.flatbuffer.PhoneNumber;
import com.facebook.contacts.omnistore.flatbuffer.Photo;
import com.facebook.contacts.omnistore.flatbuffer.ProfileType;
import com.facebook.contacts.omnistore.flatbuffer.SquareImage;
import com.facebook.contacts.omnistore.flatbuffer.TextWithEntities;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: participantId */
public class ContactTranscription {
    private static final Class<?> f8351a = ContactTranscription.class;

    /* compiled from: participantId */
    /* synthetic */ class C05261 {
        static final /* synthetic */ int[] f8348a = new int[GraphQLSubscribeStatus.values().length];
        static final /* synthetic */ int[] f8349b = new int[GraphQLFriendshipStatus.values().length];
        static final /* synthetic */ int[] f8350c = new int[ContactProfileType.values().length];

        static {
            try {
                f8350c[ContactProfileType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8350c[ContactProfileType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8350c[ContactProfileType.UNMATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.CANNOT_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8349b[GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8348a[GraphQLSubscribeStatus.CANNOT_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8348a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f8348a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f8348a[GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    private static ImmutableList<String> m12138a(Actor actor) {
        int a = actor.a(32);
        if (a != 0) {
            a = actor.d(a);
        } else {
            a = 0;
        }
        int i = a;
        Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < i; i2++) {
            String c;
            a = actor.a(32);
            if (a != 0) {
                c = actor.c(actor.e(a) + (i2 * 4));
            } else {
                c = null;
            }
            builder.c(c);
        }
        return builder.b();
    }

    public static Contact m12133a(ByteBuffer byteBuffer) {
        String c;
        com.facebook.contacts.omnistore.flatbuffer.Contact a = com.facebook.contacts.omnistore.flatbuffer.Contact.m12192a(byteBuffer);
        ContactBuilder contactBuilder = new ContactBuilder();
        int a2 = a.a(4);
        if (a2 != 0) {
            c = a.c(a2 + a.a);
        } else {
            c = null;
        }
        contactBuilder.a = c;
        contactBuilder = contactBuilder;
        a2 = a.a(6);
        if (a2 != 0) {
            c = a.c(a2 + a.a);
        } else {
            c = null;
        }
        contactBuilder.c = c;
        contactBuilder = contactBuilder;
        contactBuilder.d = m12137a(a.m12205a(new Name()));
        contactBuilder = contactBuilder;
        contactBuilder.h = m12137a(a.m12207b(new Name()));
        contactBuilder = contactBuilder;
        boolean z = false;
        int a3 = a.a(16);
        if (!(a3 == 0 || a.b.get(a3 + a.a) == (byte) 0)) {
            z = true;
        }
        contactBuilder.z = z;
        contactBuilder = contactBuilder;
        contactBuilder.E = m12132a(a.m12210i());
        contactBuilder = contactBuilder;
        contactBuilder.C = m12139a(a);
        contactBuilder = contactBuilder;
        contactBuilder.q = m12145b(a);
        contactBuilder = contactBuilder;
        SquareImage a4 = a.m12206a(new SquareImage());
        if (a4 != null) {
            contactBuilder.i = a4.m12224a();
            contactBuilder.l = a4.m12225b();
        }
        a4 = a.m12208b(new SquareImage());
        if (a4 != null) {
            contactBuilder.j = a4.m12224a();
            contactBuilder.m = a4.m12225b();
        }
        a4 = a.m12209c(new SquareImage());
        if (a4 != null) {
            contactBuilder.k = a4.m12224a();
            contactBuilder.n = a4.m12225b();
        }
        Actor a5 = a.m12204a(new Actor());
        if (a5 != null) {
            float f;
            byte b;
            GraphQLSubscribeStatus graphQLSubscribeStatus;
            GraphQLFriendshipStatus graphQLFriendshipStatus;
            ByteBuffer byteBuffer2;
            CoverPhoto coverPhoto;
            ProfileType profileType;
            City city;
            contactBuilder.b = a5.m12182a();
            ContactBuilder contactBuilder2 = contactBuilder;
            contactBuilder2.o = a5.m12183e();
            contactBuilder2 = contactBuilder2;
            a2 = a5.a(14);
            if (a2 != 0) {
                f = a5.b.getFloat(a2 + a5.a);
            } else {
                f = 0.0f;
            }
            contactBuilder2.p = f;
            contactBuilder2 = contactBuilder2;
            z = false;
            a3 = a5.a(16);
            if (!(a3 == 0 || a5.b.get(a3 + a5.a) == (byte) 0)) {
                z = true;
            }
            contactBuilder2.s = z;
            contactBuilder2 = contactBuilder2;
            a2 = a5.a(26);
            if (a2 != 0) {
                b = a5.b.get(a2 + a5.a);
            } else {
                b = (byte) 0;
            }
            switch (b) {
                case (byte) 1:
                    graphQLSubscribeStatus = GraphQLSubscribeStatus.CANNOT_SUBSCRIBE;
                    break;
                case (byte) 2:
                    graphQLSubscribeStatus = GraphQLSubscribeStatus.IS_SUBSCRIBED;
                    break;
                case (byte) 3:
                    graphQLSubscribeStatus = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
                    break;
                default:
                    graphQLSubscribeStatus = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    break;
            }
            contactBuilder2.u = graphQLSubscribeStatus;
            contactBuilder2 = contactBuilder2;
            switch (a5.m12187m()) {
                case (byte) 1:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.CANNOT_REQUEST;
                    break;
                case (byte) 2:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.ARE_FRIENDS;
                    break;
                case (byte) 3:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.INCOMING_REQUEST;
                    break;
                case (byte) 4:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                    break;
                case (byte) 5:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                    break;
                default:
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    break;
            }
            contactBuilder2.t = graphQLFriendshipStatus;
            contactBuilder2 = contactBuilder2;
            contactBuilder2.v = TriState.valueOf(a5.m12184h());
            contactBuilder2 = contactBuilder2;
            contactBuilder2.w = a5.m12185i();
            contactBuilder2 = contactBuilder2;
            contactBuilder2.x = m12132a(a5.m12186j());
            contactBuilder2 = contactBuilder2;
            z = false;
            a3 = a5.a(24);
            if (!(a3 == 0 || a5.b.get(a3 + a5.a) == (byte) 0)) {
                z = true;
            }
            contactBuilder2.y = z;
            contactBuilder2 = contactBuilder2;
            CoverPhoto coverPhoto2 = new CoverPhoto();
            a3 = a5.a(30);
            if (a3 != 0) {
                a3 = a5.b(a3 + a5.a);
                byteBuffer2 = a5.b;
                coverPhoto2.a = a3;
                coverPhoto2.b = byteBuffer2;
                coverPhoto = coverPhoto2;
            } else {
                coverPhoto = null;
            }
            contactBuilder2.B = m12135a(coverPhoto);
            contactBuilder2 = contactBuilder2;
            contactBuilder2.D = m12138a(a5);
            contactBuilder2 = contactBuilder2;
            contactBuilder2.I = a5.m12188p();
            contactBuilder2 = contactBuilder2;
            ProfileType profileType2 = new ProfileType();
            a3 = a5.a(6);
            if (a3 != 0) {
                a3 = a5.b(a3 + a5.a);
                byteBuffer2 = a5.b;
                profileType2.a = a3;
                profileType2.b = byteBuffer2;
                profileType = profileType2;
            } else {
                profileType = null;
            }
            contactBuilder2.A = m12136a(profileType);
            contactBuilder2 = contactBuilder2;
            a2 = a5.a(36);
            if (a2 != 0) {
                f = a5.b.getFloat(a2 + a5.a);
            } else {
                f = 0.0f;
            }
            contactBuilder2.M = f;
            contactBuilder2.N = a5.m12189r();
            Date a6 = a5.m12181a(new Date());
            if (a6 != null) {
                contactBuilder.a(a6.m12217b(), a6.m12216a());
            }
            City city2 = new City();
            a3 = a5.a(10);
            if (a3 != 0) {
                a3 = a5.b(a3 + a5.a);
                byteBuffer2 = a5.b;
                city2.a = a3;
                city2.b = byteBuffer2;
                city = city2;
            } else {
                city = null;
            }
            Table table = city;
            if (table != null) {
                a2 = table.a(4);
                if (a2 != 0) {
                    c = table.c(a2 + table.a);
                } else {
                    c = null;
                }
                contactBuilder.H = c;
            }
        }
        return contactBuilder.P();
    }

    public static ByteBuffer m12141a(Contact contact) {
        Preconditions.checkNotNull(contact);
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(512);
        flatBufferBuilder.m9971c(com.facebook.contacts.omnistore.flatbuffer.Contact.m12191a(flatBufferBuilder, m12130a(flatBufferBuilder, contact.b()), m12130a(flatBufferBuilder, contact.d()), m12125a(flatBufferBuilder, contact), m12128a(flatBufferBuilder, contact.e()), m12128a(flatBufferBuilder, contact.f()), m12146c(flatBufferBuilder, contact.o()), contact.v(), m12129a(flatBufferBuilder, contact.C()), m12144b(contact.w()), m12131a(flatBufferBuilder, contact.g(), contact.j()), m12131a(flatBufferBuilder, contact.h(), contact.k()), m12131a(flatBufferBuilder, contact.i(), contact.l())));
        return flatBufferBuilder.m9973d();
    }

    public static com.facebook.user.model.Name m12137a(@Nullable Name name) {
        String str = null;
        if (name == null) {
            return new com.facebook.user.model.Name(null, null);
        }
        String c;
        int a = name.a(6);
        if (a != 0) {
            c = name.c(a + name.a);
        } else {
            c = null;
        }
        String str2 = c;
        a = name.a(4);
        if (a != 0) {
            a = name.d(a);
        } else {
            a = 0;
        }
        int i = a;
        String str3 = null;
        for (int i2 = 0; i2 < i; i2++) {
            NamePart namePart;
            NamePart namePart2 = new NamePart();
            int a2 = name.a(4);
            if (a2 != 0) {
                a2 = name.b(name.e(a2) + (i2 * 4));
                ByteBuffer byteBuffer = name.b;
                namePart2.a = a2;
                namePart2.b = byteBuffer;
                namePart = namePart2;
            } else {
                namePart = null;
            }
            Table table = namePart;
            if (table != null) {
                byte b;
                a = table.a(4);
                if (a != 0) {
                    b = table.b.get(a + table.a);
                } else {
                    b = (byte) 0;
                }
                switch (b) {
                    case (byte) 1:
                        str = m12140a(str2, table.m12220b(), table.m12221c());
                        break;
                    case (byte) 3:
                        str3 = m12140a(str2, table.m12220b(), table.m12221c());
                        break;
                    default:
                        break;
                }
            }
        }
        return new com.facebook.user.model.Name(str, str3, str2);
    }

    public static long m12132a(long j) {
        return 1000 * j;
    }

    public static int m12130a(FlatBufferBuilder flatBufferBuilder, @Nullable String str) {
        if (str == null) {
            return 0;
        }
        return flatBufferBuilder.m9955a(str);
    }

    private static String m12140a(String str, int i, int i2) {
        int offsetByCodePoints = str.offsetByCodePoints(0, i);
        return str.substring(offsetByCodePoints, str.offsetByCodePoints(offsetByCodePoints, i2));
    }

    private static long m12144b(long j) {
        return j / 1000;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private static int m12128a(FlatBufferBuilder flatBufferBuilder, @Nullable com.facebook.user.model.Name name) {
        int i = 1;
        int i2 = -1;
        if (name == null) {
            return 0;
        }
        String i3 = name.i();
        if (i3 == null) {
            return 0;
        }
        int[] copyOfRange;
        String a = name.a();
        int[] iArr = new int[2];
        int indexOf = a == null ? -1 : i3.indexOf(a);
        if (indexOf >= 0) {
            iArr[0] = NamePart.m12219a(flatBufferBuilder, (byte) 1, i3.codePointCount(0, indexOf), a.codePointCount(0, a.length()));
        } else {
            i = 0;
        }
        String c = name.c();
        if (c != null) {
            i2 = i3.indexOf(c);
        }
        if (i2 >= 0) {
            iArr[i] = NamePart.m12219a(flatBufferBuilder, (byte) 3, i3.codePointCount(0, i2), c.codePointCount(0, c.length()));
            i++;
        }
        if (i != 2) {
            copyOfRange = Arrays.copyOfRange(iArr, 0, i);
        } else {
            copyOfRange = iArr;
        }
        flatBufferBuilder.m9963a(4, copyOfRange.length, 4);
        for (int length = copyOfRange.length - 1; length >= 0; length--) {
            flatBufferBuilder.m9958a(copyOfRange[length]);
        }
        i = flatBufferBuilder.m9967b();
        int a2 = m12130a(flatBufferBuilder, i3);
        flatBufferBuilder.m9968b(2);
        flatBufferBuilder.m9972c(1, a2, 0);
        flatBufferBuilder.m9972c(0, i, 0);
        return flatBufferBuilder.m9970c();
    }

    private static int m12125a(FlatBufferBuilder flatBufferBuilder, Contact contact) {
        String c = contact.c();
        if (c == null) {
            return 0;
        }
        return Actor.m12162a(flatBufferBuilder, m12130a(flatBufferBuilder, c), m12127a(flatBufferBuilder, contact.A()), m12124a(flatBufferBuilder, contact.E(), contact.D()), m12143b(flatBufferBuilder, contact.H()), contact.m(), contact.n(), contact.q(), contact.r().asBoolean(false), contact.s(), m12144b(contact.t()), contact.u(), m12123a(contact.y()), m12122a(contact.x()), m12126a(flatBufferBuilder, contact.B()), m12142b(flatBufferBuilder, contact.z()), contact.F(), contact.K(), m12130a(flatBufferBuilder, contact.L()));
    }

    private static int m12143b(FlatBufferBuilder flatBufferBuilder, String str) {
        if (str == null) {
            return 0;
        }
        int a = m12130a(flatBufferBuilder, str);
        flatBufferBuilder.m9968b(1);
        flatBufferBuilder.m9972c(0, a, 0);
        return flatBufferBuilder.m9970c();
    }

    private static int m12124a(FlatBufferBuilder flatBufferBuilder, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        flatBufferBuilder.m9968b(2);
        flatBufferBuilder.m9969b(1, i, 0);
        flatBufferBuilder.m9969b(0, i2, 0);
        return flatBufferBuilder.m9970c();
    }

    private static int m12131a(FlatBufferBuilder flatBufferBuilder, @Nullable String str, int i) {
        if (str == null) {
            return 0;
        }
        int a = m12130a(flatBufferBuilder, str);
        flatBufferBuilder.m9968b(2);
        flatBufferBuilder.m9969b(1, i, 0);
        flatBufferBuilder.m9972c(0, a, 0);
        return flatBufferBuilder.m9970c();
    }

    private static ImmutableList<NameEntriesModel> m12139a(com.facebook.contacts.omnistore.flatbuffer.Contact contact) {
        Builder builder = ImmutableList.builder();
        int a = contact.a(18);
        if (a != 0) {
            a = contact.d(a);
        } else {
            a = 0;
        }
        int i = a;
        for (int i2 = 0; i2 < i; i2++) {
            ContactEntry a2;
            ContactEntry contactEntry = new ContactEntry();
            int a3 = contact.a(18);
            if (a3 != 0) {
                a2 = contactEntry.m12212a(contact.b(contact.e(a3) + (i2 * 4)), contact.b);
            } else {
                a2 = null;
            }
            NameEntriesModel a4 = m12134a(a2);
            if (a4 != null) {
                builder.c(a4);
            }
        }
        return builder.b();
    }

    @Nullable
    private static NameEntriesModel m12134a(@Nullable ContactEntry contactEntry) {
        if (contactEntry == null) {
            return null;
        }
        C0498x332b405b c0498x332b405b;
        ContactGraphQLModels$ContactModel$NameEntriesModel$Builder contactGraphQLModels$ContactModel$NameEntriesModel$Builder = new ContactGraphQLModels$ContactModel$NameEntriesModel$Builder();
        ContactField b = contactEntry.m12214b();
        if (b == null) {
            c0498x332b405b = null;
        } else {
            TextWithEntities textWithEntities;
            ValueModel valueModel;
            C0498x332b405b.Builder builder = new C0498x332b405b.Builder();
            TextWithEntities textWithEntities2 = new TextWithEntities();
            int a = b.a(8);
            if (a != 0) {
                a = b.b(a + b.a);
                ByteBuffer byteBuffer = b.b;
                textWithEntities2.a = a;
                textWithEntities2.b = byteBuffer;
                textWithEntities = textWithEntities2;
            } else {
                textWithEntities = null;
            }
            Table table = textWithEntities;
            if (table == null) {
                valueModel = null;
            } else {
                String c;
                ValueModel.Builder builder2 = new ValueModel.Builder();
                int a2 = table.a(4);
                if (a2 != 0) {
                    c = table.c(a2 + table.a);
                } else {
                    c = null;
                }
                builder2.f8171a = c;
                builder2 = builder2;
                com.facebook.flatbuffers.FlatBufferBuilder flatBufferBuilder = new com.facebook.flatbuffers.FlatBufferBuilder(128);
                int b2 = flatBufferBuilder.b(builder2.f8171a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                valueModel = new ValueModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
            builder.f8170b = valueModel;
            c0498x332b405b = builder.m11800a();
        }
        contactGraphQLModels$ContactModel$NameEntriesModel$Builder.f8168a = c0498x332b405b;
        return contactGraphQLModels$ContactModel$NameEntriesModel$Builder.m11798a();
    }

    private static int m12129a(FlatBufferBuilder flatBufferBuilder, @Nullable ImmutableList<NameEntriesModel> immutableList) {
        if (immutableList == null) {
            return 0;
        }
        int size = immutableList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            C0498x332b405b a = ((NameEntriesModel) immutableList.get(i)).a();
            int i2 = 0;
            if (a != null) {
                int i3;
                ValueModel a2 = a.m11810a();
                if (a2 == null) {
                    i3 = 0;
                } else {
                    i3 = m12130a(flatBufferBuilder, a2.m11807a());
                    flatBufferBuilder.m9968b(1);
                    flatBufferBuilder.m9972c(0, i3, 0);
                    i3 = flatBufferBuilder.m9970c();
                }
                i2 = ContactField.m12215a(flatBufferBuilder, 0, 0, i3, 0);
            }
            iArr[i] = ContactEntry.m12211a(flatBufferBuilder, false, i2);
        }
        flatBufferBuilder.m9963a(4, iArr.length, 4);
        for (i2 = iArr.length - 1; i2 >= 0; i2--) {
            flatBufferBuilder.m9958a(iArr[i2]);
        }
        return flatBufferBuilder.m9967b();
    }

    private static byte m12123a(@Nullable GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (graphQLSubscribeStatus == null) {
            return (byte) 0;
        }
        switch (C05261.f8348a[graphQLSubscribeStatus.ordinal()]) {
            case 1:
                return (byte) 1;
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            default:
                return (byte) 0;
        }
    }

    private static byte m12122a(@Nullable GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (graphQLFriendshipStatus == null) {
            return (byte) 0;
        }
        switch (C05261.f8349b[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return (byte) 1;
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 4;
            case 5:
                return (byte) 5;
            default:
                return (byte) 0;
        }
    }

    @Nullable
    private static CoverPhotoModel m12135a(@Nullable CoverPhoto coverPhoto) {
        if (coverPhoto == null) {
            return null;
        }
        Photo photo;
        com.facebook.flatbuffers.FlatBufferBuilder flatBufferBuilder;
        ByteBuffer wrap;
        ContactGraphQLModels$CoverPhotoModel$Builder contactGraphQLModels$CoverPhotoModel$Builder = new ContactGraphQLModels$CoverPhotoModel$Builder();
        Photo photo2 = new Photo();
        int a = coverPhoto.a(6);
        if (a != 0) {
            a = coverPhoto.b(a + coverPhoto.a);
            ByteBuffer byteBuffer = coverPhoto.b;
            photo2.a = a;
            photo2.b = byteBuffer;
            photo = photo2;
        } else {
            photo = null;
        }
        Table table = photo;
        if (table != null) {
            Image image;
            DefaultImageFieldsModel defaultImageFieldsModel;
            ContactGraphQLModels$CoverPhotoModel$PhotoModel.Builder builder = new ContactGraphQLModels$CoverPhotoModel$PhotoModel.Builder();
            Image image2 = new Image();
            a = table.a(6);
            if (a != 0) {
                a = table.b(a + table.a);
                byteBuffer = table.b;
                image2.a = a;
                image2.b = byteBuffer;
                image = image2;
            } else {
                image = null;
            }
            table = image;
            if (table == null) {
                defaultImageFieldsModel = null;
            } else {
                String c;
                DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
                int a2 = table.a(4);
                if (a2 != 0) {
                    c = table.c(a2 + table.a);
                } else {
                    c = null;
                }
                builder2.b = c;
                builder2 = builder2;
                a2 = table.a(6);
                if (a2 != 0) {
                    a2 = table.b.getInt(a2 + table.a);
                } else {
                    a2 = 0;
                }
                builder2.c = a2;
                builder2 = builder2;
                a2 = table.a(8);
                if (a2 != 0) {
                    a2 = table.b.getInt(a2 + table.a);
                } else {
                    a2 = 0;
                }
                builder2.a = a2;
                defaultImageFieldsModel = builder2.a();
            }
            builder.f8180a = defaultImageFieldsModel;
            ContactGraphQLModels$CoverPhotoModel$PhotoModel.Builder builder3 = builder;
            flatBufferBuilder = new com.facebook.flatbuffers.FlatBufferBuilder(128);
            a = ModelHelper.a(flatBufferBuilder, builder3.f8180a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            contactGraphQLModels$CoverPhotoModel$Builder.f8179a = new ContactGraphQLModels$CoverPhotoModel$PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
        flatBufferBuilder = new com.facebook.flatbuffers.FlatBufferBuilder(128);
        a = ModelHelper.a(flatBufferBuilder, contactGraphQLModels$CoverPhotoModel$Builder.f8179a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new CoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m12126a(FlatBufferBuilder flatBufferBuilder, @Nullable CoverPhotoModel coverPhotoModel) {
        int i = 0;
        if (coverPhotoModel == null) {
            return 0;
        }
        ContactGraphQLModels$CoverPhotoModel$PhotoModel a = coverPhotoModel.a();
        if (a != null) {
            int i2;
            DefaultImageFieldsModel a2 = a.m11843a();
            if (a2 == null) {
                i2 = 0;
            } else {
                i2 = m12130a(flatBufferBuilder, a2.b());
                int c = a2.c();
                int a3 = a2.a();
                flatBufferBuilder.m9968b(3);
                flatBufferBuilder.m9969b(2, a3, 0);
                flatBufferBuilder.m9969b(1, c, 0);
                flatBufferBuilder.m9972c(0, i2, 0);
                i2 = flatBufferBuilder.m9970c();
            }
            int i3 = i2;
            flatBufferBuilder.m9968b(3);
            flatBufferBuilder.m9972c(2, 0, 0);
            flatBufferBuilder.m9972c(1, i3, 0);
            flatBufferBuilder.m9972c(0, 0, 0);
            i = flatBufferBuilder.m9970c();
        }
        flatBufferBuilder.m9968b(2);
        flatBufferBuilder.m9972c(1, i, 0);
        return flatBufferBuilder.m9970c();
    }

    private static ContactProfileType m12136a(@Nullable ProfileType profileType) {
        if (profileType == null) {
            return ContactProfileType.UNMATCHED;
        }
        String c;
        int a = profileType.a(4);
        if (a != 0) {
            c = profileType.c(a + profileType.a);
        } else {
            c = null;
        }
        String str = c;
        if ("User".equals(str)) {
            return ContactProfileType.USER;
        }
        if ("Page".equals(str)) {
            return ContactProfileType.PAGE;
        }
        BLog.b(f8351a, "Malformed contact type name: %s", new Object[]{str});
        return ContactProfileType.UNMATCHED;
    }

    private static int m12127a(FlatBufferBuilder flatBufferBuilder, ContactProfileType contactProfileType) {
        switch (C05261.f8350c[contactProfileType.ordinal()]) {
            case 1:
                return ProfileType.m12222a(flatBufferBuilder, flatBufferBuilder.m9955a("User"));
            case 2:
                return ProfileType.m12222a(flatBufferBuilder, flatBufferBuilder.m9955a("Page"));
            default:
                return 0;
        }
    }

    private static int m12142b(FlatBufferBuilder flatBufferBuilder, @Nullable ImmutableList<String> immutableList) {
        if (immutableList == null) {
            return 0;
        }
        int size = immutableList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = m12130a(flatBufferBuilder, (String) immutableList.get(i));
        }
        flatBufferBuilder.m9963a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m9958a(iArr[length]);
        }
        return flatBufferBuilder.m9967b();
    }

    private static ImmutableList<ContactPhone> m12145b(com.facebook.contacts.omnistore.flatbuffer.Contact contact) {
        Builder builder = ImmutableList.builder();
        int a = contact.a(14);
        if (a != 0) {
            a = contact.d(a);
        } else {
            a = 0;
        }
        int i = a;
        for (int i2 = 0; i2 < i; i2++) {
            ContactEntry a2;
            ContactEntry contactEntry = new ContactEntry();
            int a3 = contact.a(14);
            if (a3 != 0) {
                a2 = contactEntry.m12212a(contact.b(contact.e(a3) + (i2 * 4)), contact.b);
            } else {
                a2 = null;
            }
            ContactEntry contactEntry2 = a2;
            if (contactEntry2 != null) {
                ContactField b = contactEntry2.m12214b();
                if (b != null) {
                    PhoneNumber phoneNumber;
                    PhoneNumber phoneNumber2 = new PhoneNumber();
                    a3 = b.a(10);
                    if (a3 != 0) {
                        a3 = b.b(a3 + b.a);
                        ByteBuffer byteBuffer = b.b;
                        phoneNumber2.a = a3;
                        phoneNumber2.b = byteBuffer;
                        phoneNumber = phoneNumber2;
                    } else {
                        phoneNumber = null;
                    }
                    Table table = phoneNumber;
                    if (table != null) {
                        String c;
                        a = b.a(4);
                        if (a != 0) {
                            c = b.c(a + b.a);
                        } else {
                            c = null;
                        }
                        String str = c;
                        a = b.a(6);
                        if (a != 0) {
                            c = b.c(a + b.a);
                        } else {
                            c = null;
                        }
                        String str2 = c;
                        a = table.a(4);
                        if (a != 0) {
                            c = table.c(a + table.a);
                        } else {
                            c = null;
                        }
                        String str3 = c;
                        a = table.a(6);
                        if (a != 0) {
                            c = table.c(a + table.a);
                        } else {
                            c = null;
                        }
                        builder.c(new ContactPhone(str, str2, str3, c, contactEntry2.m12213a()));
                    }
                }
            }
        }
        return builder.b();
    }

    private static int m12146c(FlatBufferBuilder flatBufferBuilder, ImmutableList<ContactPhone> immutableList) {
        int size = immutableList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            ContactPhone contactPhone = (ContactPhone) immutableList.get(i);
            boolean e = contactPhone.m12032e();
            int a = m12130a(flatBufferBuilder, contactPhone.m12028a());
            int a2 = m12130a(flatBufferBuilder, contactPhone.m12029b());
            int a3 = m12130a(flatBufferBuilder, contactPhone.m12030c());
            int a4 = m12130a(flatBufferBuilder, contactPhone.m12031d());
            flatBufferBuilder.m9968b(2);
            flatBufferBuilder.m9972c(1, a4, 0);
            flatBufferBuilder.m9972c(0, a3, 0);
            iArr[i] = ContactEntry.m12211a(flatBufferBuilder, e, ContactField.m12215a(flatBufferBuilder, a, a2, 0, flatBufferBuilder.m9970c()));
        }
        flatBufferBuilder.m9963a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m9958a(iArr[length]);
        }
        return flatBufferBuilder.m9967b();
    }
}
