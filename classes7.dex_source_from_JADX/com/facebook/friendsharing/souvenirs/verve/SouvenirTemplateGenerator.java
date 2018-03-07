package com.facebook.friendsharing.souvenirs.verve;

import android.content.res.Resources;
import android.graphics.PointF;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.locale.Locales;
import com.facebook.friendsharing.souvenirs.models.SouvenirFormattingStringModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirsFetchResult;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsInterfaces.SouvenirsDetailsFields.MediaElements.Edges;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel.ContainerPostModel.ActorsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel.MediaElementsModel.EdgesModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaElementFieldsModel.SouvenirMediaModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMSlide.Builder;
import com.facebook.greetingcards.verve.model.VMSlideValue;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Queue %s for %s is temporarily not available. Backing off. */
public class SouvenirTemplateGenerator {
    private static volatile SouvenirTemplateGenerator f24233d;
    private final Resources f24234a;
    private final AbstractFbErrorReporter f24235b;
    private final Locales f24236c;

    public static com.facebook.friendsharing.souvenirs.verve.SouvenirTemplateGenerator m26465a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24233d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.verve.SouvenirTemplateGenerator.class;
        monitor-enter(r1);
        r0 = f24233d;	 Catch:{ all -> 0x003a }
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
        r0 = m26469b(r0);	 Catch:{ all -> 0x0035 }
        f24233d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24233d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.verve.SouvenirTemplateGenerator.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.verve.SouvenirTemplateGenerator");
    }

    private static SouvenirTemplateGenerator m26469b(InjectorLike injectorLike) {
        return new SouvenirTemplateGenerator(ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public SouvenirTemplateGenerator(Resources resources, AbstractFbErrorReporter abstractFbErrorReporter, Locales locales) {
        this.f24234a = resources;
        this.f24235b = abstractFbErrorReporter;
        this.f24236c = locales;
    }

    private VMSlide m26466a(VMSlide vMSlide, SouvenirsFetchResult souvenirsFetchResult) {
        String str;
        Builder builder = new Builder();
        builder.a(vMSlide);
        builder.e = false;
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        String str2 = "media_1";
        ActorsModel actorsModel = (ActorsModel) souvenirsFetchResult.f24076a.m26306j().m26284a().get(0);
        if (actorsModel == null || actorsModel.m26275a() == null) {
            str = null;
        } else {
            str = actorsModel.m26275a().m26270a();
        }
        builder2.c(VMSlideValue.a(str2, str, null));
        DefaultTextWithEntitiesFieldsModel m = souvenirsFetchResult.f24076a.m26309m();
        if (!(m == null || Strings.isNullOrEmpty(m.a()))) {
            builder2.c(VMSlideValue.a("title", m.a()));
        }
        builder2.c(VMSlideValue.a("subtitle", this.f24234a.getString(2131238445, new Object[]{((ActorsModel) souvenirsFetchResult.f24076a.m26306j().m26284a().get(0)).m26279j()}).toUpperCase(this.f24236c.a())));
        builder.g = builder2.b();
        return builder.a();
    }

    private ImmutableList<SouvenirFormattingStringModel> m26468a(HashMap<String, VMSlide> hashMap, SouvenirsFetchResult souvenirsFetchResult) {
        int i = 0;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = souvenirsFetchResult.f24077b;
        int size = immutableList.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            SouvenirFormattingStringModel souvenirFormattingStringModel = (SouvenirFormattingStringModel) immutableList.get(i2);
            if (hashMap.containsKey(souvenirFormattingStringModel.m26161a())) {
                int i4 = 0;
                int i5 = 0;
                Object obj = 1;
                while (i4 < souvenirFormattingStringModel.assetCount && i + i4 < souvenirsFetchResult.f24076a.m26308l().m26298a().size()) {
                    SouvenirsMediaElementFieldsModel j = ((EdgesModel) souvenirsFetchResult.f24076a.m26308l().m26298a().get(i + i4)).m26294j();
                    Object obj2;
                    int i6;
                    if (j.m26330d() == GraphQLSouvenirMediaFieldType.PHOTO || j.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO) {
                        if (((SouvenirMediaModel.EdgesModel) j.m26329c().m26322a().get(0)).m26317a() == null) {
                            obj2 = null;
                            i6 = i5;
                        } else {
                            obj2 = obj;
                            i6 = i5 + 1;
                        }
                        i4++;
                        i5 = i6;
                        obj = obj2;
                    } else {
                        Object obj3;
                        for (int i7 = 0; i7 < j.m26329c().m26322a().size(); i7++) {
                            if (((SouvenirMediaModel.EdgesModel) j.m26329c().m26322a().get(i7)).m26317a() != null) {
                                obj3 = 1;
                                break;
                            }
                        }
                        obj3 = null;
                        if (obj != null) {
                            obj2 = obj3;
                        } else {
                            obj2 = obj;
                        }
                        if (obj3 != null) {
                            i6 = i5 + 1;
                        } else {
                            i6 = i5;
                        }
                        i4++;
                        i5 = i6;
                        obj = obj2;
                    }
                }
                if (i4 == souvenirFormattingStringModel.assetCount && obj != null) {
                    builder.c(souvenirFormattingStringModel);
                    i3 = souvenirFormattingStringModel.assetCount + i;
                } else if (i5 == 0 && souvenirFormattingStringModel.assetCount == 1) {
                    i3 = i + 1;
                } else {
                    SouvenirFormattingStringModel souvenirFormattingStringModel2 = new SouvenirFormattingStringModel(souvenirFormattingStringModel.name, i5);
                    i3 = souvenirFormattingStringModel.assetCount + i;
                    builder.c(souvenirFormattingStringModel2);
                }
            } else {
                this.f24235b.b("SouvenirTemplateGen", "Missing slide key: " + souvenirFormattingStringModel.m26161a());
                i3 = i;
            }
            i2++;
            i = i3;
        }
        return builder.b();
    }

    private static ImmutableList<VMSlideValue> m26467a(SouvenirFormattingStringModel souvenirFormattingStringModel, UnmodifiableIterator<? extends Edges> unmodifiableIterator) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        while (i < souvenirFormattingStringModel.assetCount) {
            SouvenirsMediaElementFieldsModel a = ((EdgesModel) Preconditions.checkNotNull(unmodifiableIterator.next())).m26292a();
            if (!(((SouvenirMediaModel.EdgesModel) a.m26329c().m26322a().get(0)).m26317a() == null && (a.m26330d() == GraphQLSouvenirMediaFieldType.PHOTO || a.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO))) {
                int i2;
                for (int i3 = 0; i3 < a.m26329c().m26322a().size(); i3++) {
                    if (((SouvenirMediaModel.EdgesModel) a.m26329c().m26322a().get(i3)).m26317a() != null) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 != 0) {
                    if (a.m26330d() == GraphQLSouvenirMediaFieldType.BURST) {
                        builder.c(VMSlideValue.a("media_" + (i + 1), a.m26328b(), null));
                        i++;
                    } else {
                        String p;
                        SouvenirsMediaFieldsModel a2 = ((SouvenirMediaModel.EdgesModel) a.m26329c().m26322a().get(0)).m26317a();
                        String b = a2.bc_().b();
                        DefaultVect2Fields c = a2.m26384c();
                        PointF pointF = c != null ? new PointF((float) c.a(), (float) c.b()) : new PointF(0.5f, 0.5f);
                        if (a.m26330d() == GraphQLSouvenirMediaFieldType.VIDEO) {
                            a2 = ((SouvenirMediaModel.EdgesModel) a.m26329c().m26322a().get(0)).m26317a();
                            p = a2.m26393p() != null ? a2.m26393p() : a2.bc_().b();
                        } else {
                            p = b;
                        }
                        builder.c(VMSlideValue.a("media_" + (i + 1), p, pointF));
                        i++;
                    }
                }
            }
        }
        return builder.b();
    }

    public final VMDeck m26470a(VMDeck vMDeck, SouvenirsFetchResult souvenirsFetchResult) {
        Preconditions.checkNotNull(vMDeck);
        Preconditions.checkNotNull(souvenirsFetchResult);
        HashMap hashMap = new HashMap(vMDeck.slides.size());
        ImmutableList immutableList = vMDeck.slides;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            VMSlide vMSlide = (VMSlide) immutableList.get(i);
            hashMap.put(vMSlide.name, vMSlide);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (hashMap.containsKey(vMDeck.initialSlide)) {
            Object obj;
            DefaultTextWithEntitiesFieldsModel m = souvenirsFetchResult.f24076a.m26309m();
            if (m == null || Strings.isNullOrEmpty(m.a())) {
                obj = "Cover_0_notitle";
            } else {
                obj = "Cover_0";
            }
            builder.c(m26466a((VMSlide) hashMap.get(obj), souvenirsFetchResult));
        }
        ImmutableList a = m26468a(hashMap, souvenirsFetchResult);
        UnmodifiableIterator it = souvenirsFetchResult.f24076a.m26308l().m26298a().iterator();
        int size2 = a.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SouvenirFormattingStringModel souvenirFormattingStringModel = (SouvenirFormattingStringModel) a.get(i2);
            if (hashMap.containsKey(souvenirFormattingStringModel.m26161a())) {
                Builder builder2 = new Builder();
                builder2.a((VMSlide) hashMap.get(souvenirFormattingStringModel.m26161a()));
                builder2.g = m26467a(souvenirFormattingStringModel, it);
                builder2.e = false;
                builder.c(builder2.a());
            }
        }
        builder.b(vMDeck.slides);
        VMDeck.Builder builder3 = new VMDeck.Builder();
        builder3.a = vMDeck.size;
        builder3.b = vMDeck.slides;
        builder3.c = vMDeck.resources;
        builder3.d = vMDeck.initialSlide;
        builder3.e = vMDeck.styles;
        builder3.f = vMDeck.theme;
        builder3.g = vMDeck.bgColor;
        builder3.b = builder.b();
        return builder3.a();
    }
}
