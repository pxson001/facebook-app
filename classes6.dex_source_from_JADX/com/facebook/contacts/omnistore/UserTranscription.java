package com.facebook.contacts.omnistore;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.util.TriState;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.omnistore.flatbuffer.Actor;
import com.facebook.contacts.omnistore.flatbuffer.Contact;
import com.facebook.contacts.omnistore.flatbuffer.Date;
import com.facebook.contacts.omnistore.flatbuffer.Name;
import com.facebook.contacts.omnistore.flatbuffer.SquareImage;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.names.ContactPhoneBookUtils;
import com.facebook.user.names.ContactPhoneBookUtils.NameBucketParamsBuilder;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: param_key_category_info */
public class UserTranscription implements IHaveUserData {
    private static volatile UserTranscription f8372e;
    private final ContactsDatabaseSupplier f8373a;
    private final ContactPhoneBookUtils f8374b;
    private final Map<String, String> f8375c = Collections.synchronizedMap(new HashMap());
    public final ThreadLocal<FlatbufferRecycler> f8376d = new ThreadLocal();

    /* compiled from: param_key_category_info */
    public class FlatbufferRecycler {
        public Actor f8368a = new Actor();
        public Name f8369b = new Name();
        public SquareImage f8370c = new SquareImage();
        public Date f8371d = new Date();
    }

    public static com.facebook.contacts.omnistore.UserTranscription m12156a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8372e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.omnistore.UserTranscription.class;
        monitor-enter(r1);
        r0 = f8372e;	 Catch:{ all -> 0x003a }
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
        r0 = m12159b(r0);	 Catch:{ all -> 0x0035 }
        f8372e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8372e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.omnistore.UserTranscription.a(com.facebook.inject.InjectorLike):com.facebook.contacts.omnistore.UserTranscription");
    }

    private static UserTranscription m12159b(InjectorLike injectorLike) {
        return new UserTranscription(ContactsDatabaseSupplier.a(injectorLike), ContactPhoneBookUtils.a(injectorLike));
    }

    @Inject
    public UserTranscription(ContactsDatabaseSupplier contactsDatabaseSupplier, ContactPhoneBookUtils contactPhoneBookUtils) {
        this.f8373a = contactsDatabaseSupplier;
        this.f8374b = contactPhoneBookUtils;
    }

    public final User m12160a(String str, ByteBuffer byteBuffer) {
        FlatbufferRecycler flatbufferRecycler;
        PicSquare picSquare;
        boolean z;
        Contact a = Contact.m12192a(byteBuffer);
        FlatbufferRecycler flatbufferRecycler2 = (FlatbufferRecycler) this.f8376d.get();
        if (flatbufferRecycler2 == null) {
            flatbufferRecycler2 = new FlatbufferRecycler();
            this.f8376d.set(flatbufferRecycler2);
            flatbufferRecycler = flatbufferRecycler2;
        } else {
            flatbufferRecycler = flatbufferRecycler2;
        }
        Actor actor = (Actor) Preconditions.checkNotNull(a.m12204a(flatbufferRecycler.f8368a), "Represented profile must not be null");
        com.facebook.user.model.Name name = (com.facebook.user.model.Name) Preconditions.checkNotNull(ContactTranscription.m12137a(a.m12205a(flatbufferRecycler.f8369b)), "User must have name");
        UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, (String) Preconditions.checkNotNull(actor.m12182a(), "FBID must not be null"));
        a2.g = name;
        a2 = a2;
        SquareImage squareImage = ((FlatbufferRecycler) this.f8376d.get()).f8370c;
        PicSquareUrlWithSize a3 = m12157a(a.m12206a(squareImage));
        PicSquareUrlWithSize a4 = m12157a(a.m12208b(squareImage));
        PicSquareUrlWithSize a5 = m12157a(a.m12209c(squareImage));
        if (a3 == null && a4 == null && a5 == null) {
            picSquare = null;
        } else {
            picSquare = new PicSquare(a3, a4, a5);
        }
        a2.p = picSquare;
        a2 = a2;
        a2.t = actor.m12183e();
        a2 = a2;
        a2.l = actor.m12189r();
        a2 = a2;
        a2.u = TriState.valueOf(actor.m12184h());
        a2 = a2;
        a2.A = actor.m12185i();
        a2 = a2;
        a2.E = ContactTranscription.m12132a(actor.m12186j());
        a2 = a2;
        a2.F = ContactTranscription.m12132a(a.m12210i());
        UserBuilder userBuilder = a2;
        if (actor.m12187m() == (byte) 2) {
            z = true;
        } else {
            z = false;
        }
        userBuilder.G = z;
        a2 = userBuilder;
        a2.L = actor.m12188p();
        a2 = a2;
        a2.s = m12158a(str, name, ContactTranscription.m12137a(a.m12207b(flatbufferRecycler.f8369b)));
        a2 = a2;
        Date a6 = actor.m12181a(flatbufferRecycler.f8371d);
        if (a6 != null) {
            a2.a(a6.m12217b(), a6.m12216a());
        }
        SquareImage a7 = a.m12206a(flatbufferRecycler.f8370c);
        if (a7 != null) {
            a2.n = a7.m12224a();
        }
        return a2.aa();
    }

    public void clearUserData() {
        this.f8375c.clear();
    }

    private String m12158a(String str, com.facebook.user.model.Name name, @Nullable com.facebook.user.model.Name name2) {
        String str2 = (String) this.f8375c.get(str);
        if (str2 != null) {
            return str2;
        }
        NameBucketParamsBuilder nameBucketParamsBuilder = new NameBucketParamsBuilder();
        nameBucketParamsBuilder.a = name.i();
        nameBucketParamsBuilder = nameBucketParamsBuilder;
        nameBucketParamsBuilder.b = name.a();
        nameBucketParamsBuilder = nameBucketParamsBuilder;
        nameBucketParamsBuilder.c = name.c();
        nameBucketParamsBuilder = nameBucketParamsBuilder;
        if (name2 != null) {
            nameBucketParamsBuilder.d = name2.i();
            NameBucketParamsBuilder nameBucketParamsBuilder2 = nameBucketParamsBuilder;
            nameBucketParamsBuilder2.e = name2.a();
            nameBucketParamsBuilder2.f = name2.c();
        }
        str2 = this.f8374b.a(this.f8373a.a(), nameBucketParamsBuilder.a());
        this.f8375c.put(str, str2);
        return str2;
    }

    @Nullable
    public static PicSquareUrlWithSize m12157a(@Nullable SquareImage squareImage) {
        if (squareImage == null) {
            return null;
        }
        return new PicSquareUrlWithSize(squareImage.m12225b(), squareImage.m12224a());
    }
}
