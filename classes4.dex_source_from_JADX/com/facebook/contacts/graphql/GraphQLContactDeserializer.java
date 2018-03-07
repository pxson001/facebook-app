package com.facebook.contacts.graphql;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel.ImportedPhoneEntriesModel;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel.ImportedPhoneEntriesModel.PrimaryFieldModel;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactModel.RepresentedProfileModel;
import com.facebook.contacts.graphql.ContactGraphQLModels$ContactNameModel.PartsModel;
import com.facebook.contacts.graphql.ContactGraphQLModels.PhoneNumberFieldsModel;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.Name;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtc_enable_ipv6 */
public class GraphQLContactDeserializer {
    private static final Class<?> f3276a = GraphQLContactDeserializer.class;
    private static volatile GraphQLContactDeserializer f3277c;
    private final Clock f3278b;

    public static com.facebook.contacts.graphql.GraphQLContactDeserializer m3479a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3277c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.graphql.GraphQLContactDeserializer.class;
        monitor-enter(r1);
        r0 = f3277c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3482b(r0);	 Catch:{ all -> 0x0035 }
        f3277c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3277c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.graphql.GraphQLContactDeserializer.a(com.facebook.inject.InjectorLike):com.facebook.contacts.graphql.GraphQLContactDeserializer");
    }

    private static GraphQLContactDeserializer m3482b(InjectorLike injectorLike) {
        return new GraphQLContactDeserializer((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GraphQLContactDeserializer(Clock clock) {
        this.f3278b = clock;
    }

    public final ContactBuilder m3483a(ContactGraphQLModels$ContactModel contactGraphQLModels$ContactModel) {
        if (contactGraphQLModels$ContactModel == null) {
            throw new IOException("Server sent a null response for a contact");
        }
        Name a = m3481a(contactGraphQLModels$ContactModel.m4036n());
        Name a2 = m3481a(contactGraphQLModels$ContactModel.m4033k());
        ContactBuilder newBuilder = Contact.newBuilder();
        newBuilder.f3639a = contactGraphQLModels$ContactModel.m4031g();
        newBuilder = newBuilder;
        newBuilder.f3641c = contactGraphQLModels$ContactModel.m4030d();
        newBuilder = newBuilder;
        newBuilder.f3642d = a;
        ContactBuilder contactBuilder = newBuilder;
        contactBuilder.f3646h = a2;
        contactBuilder = contactBuilder;
        contactBuilder.f3664z = contactGraphQLModels$ContactModel.cy_();
        contactBuilder = contactBuilder;
        contactBuilder.f3628E = m3478a(contactGraphQLModels$ContactModel.m4028b());
        contactBuilder = contactBuilder;
        contactBuilder.f3647i = contactGraphQLModels$ContactModel.m4035m().m4097a();
        contactBuilder = contactBuilder;
        contactBuilder.f3648j = contactGraphQLModels$ContactModel.m4029c().m4097a();
        contactBuilder = contactBuilder;
        contactBuilder.f3649k = contactGraphQLModels$ContactModel.cz_().m4097a();
        contactBuilder = contactBuilder;
        contactBuilder.f3650l = contactGraphQLModels$ContactModel.m4035m().m4099b();
        contactBuilder = contactBuilder;
        contactBuilder.f3651m = contactGraphQLModels$ContactModel.m4029c().m4099b();
        contactBuilder = contactBuilder;
        contactBuilder.f3652n = contactGraphQLModels$ContactModel.cz_().m4099b();
        contactBuilder = contactBuilder;
        contactBuilder.f3626C = contactGraphQLModels$ContactModel.m4032j();
        ContactBuilder contactBuilder2 = contactBuilder;
        RepresentedProfileModel l = contactGraphQLModels$ContactModel.m4034l();
        if (l != null) {
            long parseLong;
            TriState triState;
            contactBuilder2.f3640b = l.m4120k();
            contactBuilder = contactBuilder2;
            contactBuilder.f3653o = (float) l.m4118g();
            contactBuilder = contactBuilder;
            contactBuilder.f3654p = (float) l.m4131v();
            contactBuilder = contactBuilder;
            contactBuilder.f3656r = l.m4122m();
            contactBuilder = contactBuilder;
            contactBuilder.f3657s = l.cA_();
            contactBuilder = contactBuilder;
            contactBuilder.f3659u = l.m4130u();
            contactBuilder = contactBuilder;
            contactBuilder.f3658t = l.m4119j();
            ContactBuilder contactBuilder3 = contactBuilder;
            if (l.m4128s() != null) {
                parseLong = Long.parseLong(l.m4128s());
            } else {
                parseLong = 0;
            }
            contactBuilder3.f3634K = parseLong;
            contactBuilder3.f3635L = l.m4117d();
            if (l.m4124o()) {
                triState = TriState.YES;
            } else {
                triState = TriState.NO;
            }
            contactBuilder2.f3660v = triState;
            contactBuilder2.f3661w = l.m4123n();
            contactBuilder2.f3662x = m3478a(l.m4126q());
            contactBuilder2.f3633J = this.f3278b.a();
            contactBuilder2.f3663y = l.m4121l();
            ContactGraphQLModels$CoverPhotoModel cC_ = l.cC_();
            if (cC_ != null) {
                contactBuilder2.f3625B = cC_;
            }
            contactBuilder2.f3624A = m3480a(l.m4115b());
            ImmutableList t = l.m4129t();
            if (t != null) {
                contactBuilder2.f3627D = t;
            }
            if (l.m4116c() != null) {
                contactBuilder2.m4093a(l.m4116c().m4139b(), l.m4116c().m4135a());
            }
            if (!(l.cB_() == null || l.cB_().m4142a() == null)) {
                contactBuilder2.f3631H = l.cB_().m4142a();
            }
            contactBuilder2.f3632I = l.m4125p();
            contactBuilder2.f3638O = (float) l.m4127r();
        } else {
            contactBuilder2.f3624A = ContactProfileType.UNMATCHED;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList cx_ = contactGraphQLModels$ContactModel.cx_();
        if (!(cx_ == null || cx_.isEmpty())) {
            int size = cx_.size();
            for (int i = 0; i < size; i++) {
                ImportedPhoneEntriesModel importedPhoneEntriesModel = (ImportedPhoneEntriesModel) cx_.get(i);
                PrimaryFieldModel b = importedPhoneEntriesModel.m4150b();
                PhoneNumberFieldsModel d = b.d();
                builder.c(new ContactPhone(b.b(), b.c(), d.a(), d.b(), importedPhoneEntriesModel.m4149a()));
            }
            contactBuilder2.f3655q = builder.b();
        }
        return contactBuilder2;
    }

    private static ContactProfileType m3480a(GraphQLObjectType graphQLObjectType) {
        String e = graphQLObjectType.e();
        if ("User".equals(e)) {
            return ContactProfileType.USER;
        }
        if ("Page".equals(e)) {
            return ContactProfileType.PAGE;
        }
        BLog.b(f3276a, "Malformed contact type name: " + e);
        throw new IllegalArgumentException("Malformed contact type name: " + e);
    }

    private static Name m3481a(ContactGraphQLModels$ContactNameModel contactGraphQLModels$ContactNameModel) {
        String str = null;
        if (contactGraphQLModels$ContactNameModel == null) {
            return new Name(null, null);
        }
        String b = contactGraphQLModels$ContactNameModel.m4044b();
        ImmutableList a = contactGraphQLModels$ContactNameModel.m4043a();
        if (b == null || a == null) {
            return new Name(null, null, b);
        }
        int size = a.size();
        int i = 0;
        String str2 = null;
        while (i < size) {
            PartsModel partsModel = (PartsModel) a.get(i);
            int b2 = partsModel.m4049b();
            int a2 = partsModel.m4045a();
            GraphQLStructuredNamePart c = partsModel.m4050c();
            int offsetByCodePoints = b.offsetByCodePoints(0, b2);
            String substring = b.substring(offsetByCodePoints, b.offsetByCodePoints(offsetByCodePoints, a2));
            if (Objects.equal(c, GraphQLStructuredNamePart.FIRST)) {
                String str3 = str;
                str = substring;
                substring = str3;
            } else if (Objects.equal(c, GraphQLStructuredNamePart.LAST)) {
                str = str2;
            } else {
                substring = str;
                str = str2;
            }
            i++;
            str2 = str;
            str = substring;
        }
        return new Name(str2, str, b);
    }

    private static long m3478a(long j) {
        return 1000 * j;
    }
}
