package com.facebook.photos.data.service;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserAcceptPlaceSuggestionInputData;
import com.facebook.graphql.calls.UserRejectPlaceSuggestionInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.http.protocol.MethodBatcher;
import com.facebook.http.protocol.MethodBatcherImpl;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.albums.protocols.AlbumQueryType;
import com.facebook.photos.albums.protocols.FetchSingleAlbumMethod;
import com.facebook.photos.albums.protocols.FetchSingleAlbumParams;
import com.facebook.photos.data.method.AcceptPlaceSuggestionUtil;
import com.facebook.photos.data.method.AddPhotoTagMethod;
import com.facebook.photos.data.method.AddPhotoTagParams;
import com.facebook.photos.data.method.CreatePagePhotoAlbumMethod;
import com.facebook.photos.data.method.CreatePagePhotoAlbumParams;
import com.facebook.photos.data.method.CreatePhotoAlbumMethod;
import com.facebook.photos.data.method.CreatePhotoAlbumParams;
import com.facebook.photos.data.method.CreateSharedPhotoAlbumMethod;
import com.facebook.photos.data.method.CreateSharedPhotoAlbumParams;
import com.facebook.photos.data.method.CropProfilePictureMethod;
import com.facebook.photos.data.method.CropProfilePictureParams;
import com.facebook.photos.data.method.DeletePhotoAlbumMethod;
import com.facebook.photos.data.method.DeletePhotoAlbumParams;
import com.facebook.photos.data.method.DeletePhotoAlbumResponse;
import com.facebook.photos.data.method.DeletePhotoMethod;
import com.facebook.photos.data.method.DeletePhotoParams;
import com.facebook.photos.data.method.DeletePhotoResponse;
import com.facebook.photos.data.method.DeletePhotoTagMethod;
import com.facebook.photos.data.method.DeletePhotoTagParams;
import com.facebook.photos.data.method.EditPhotoCaptionMethod;
import com.facebook.photos.data.method.EditPhotoCaptionParams;
import com.facebook.photos.data.method.EditPhotoLocationMethod;
import com.facebook.photos.data.method.EditPhotoLocationParams;
import com.facebook.photos.data.method.FetchPhotosMetadataMethod;
import com.facebook.photos.data.method.FetchPhotosMetadataParams;
import com.facebook.photos.data.method.ModifyAlbumContributorMethod;
import com.facebook.photos.data.method.ModifyAlbumContributorParams;
import com.facebook.photos.data.method.PlaceSuggestionMutationParams;
import com.facebook.photos.data.method.RejectPlaceSuggestionUtil;
import com.facebook.photos.data.method.UpdatePhotoAlbumMethod;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams.ConversionType;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutations.AcceptPlaceSuggestionMutationString;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutations.RejectPlaceSuggestionMutationString;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: holiday_cards */
public class PhotosServiceHandler implements BlueServiceHandler {
    private static volatile PhotosServiceHandler f12980s;
    public final Provider<SingleMethodRunner> f12981a;
    public final CreatePhotoAlbumMethod f12982b;
    public final CreatePagePhotoAlbumMethod f12983c;
    private final UpdatePhotoAlbumMethod f12984d;
    public final DeletePhotoMethod f12985e;
    public final DeletePhotoAlbumMethod f12986f;
    public final AddPhotoTagMethod f12987g;
    public final DeletePhotoTagMethod f12988h;
    public final EditPhotoCaptionMethod f12989i;
    public final FetchPhotosMetadataMethod f12990j;
    public final CropProfilePictureMethod f12991k;
    private final FetchSingleAlbumMethod f12992l;
    private final CreateSharedPhotoAlbumMethod f12993m;
    private final ModifyAlbumContributorMethod f12994n;
    public final EditPhotoLocationMethod f12995o;
    private final Provider<MethodBatcher> f12996p;
    private final AcceptPlaceSuggestionUtil f12997q;
    private final RejectPlaceSuggestionUtil f12998r;

    public static com.facebook.photos.data.service.PhotosServiceHandler m20336a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12980s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.data.service.PhotosServiceHandler.class;
        monitor-enter(r1);
        r0 = f12980s;	 Catch:{ all -> 0x003a }
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
        r0 = m20337b(r0);	 Catch:{ all -> 0x0035 }
        f12980s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12980s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.service.PhotosServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.photos.data.service.PhotosServiceHandler");
    }

    private static PhotosServiceHandler m20337b(InjectorLike injectorLike) {
        return new PhotosServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), CreatePhotoAlbumMethod.m20279a(injectorLike), CreateSharedPhotoAlbumMethod.m20282a(injectorLike), CreatePagePhotoAlbumMethod.m20276a(injectorLike), UpdatePhotoAlbumMethod.m20325a(injectorLike), DeletePhotoMethod.m20291a(injectorLike), DeletePhotoAlbumMethod.m20288a(injectorLike), AddPhotoTagMethod.m20268a(injectorLike), DeletePhotoTagMethod.m20294a(injectorLike), EditPhotoCaptionMethod.m20300a(injectorLike), FetchPhotosMetadataMethod.m20313a(injectorLike), CropProfilePictureMethod.m20285a(injectorLike), FetchSingleAlbumMethod.m19425a(injectorLike), ModifyAlbumContributorMethod.m20318a(injectorLike), EditPhotoLocationMethod.m20303a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2287), AcceptPlaceSuggestionUtil.m20267a(injectorLike), RejectPlaceSuggestionUtil.m20324a(injectorLike));
    }

    public final OperationResult m20342a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("photos_create_album".equals(str)) {
            return OperationResult.a(((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12982b, (CreatePhotoAlbumParams) operationParams.c.getParcelable("createAlbumParams")));
        } else if ("create_page_album".equals(str)) {
            return m20338c(operationParams);
        } else {
            if ("create_page_album_for_id".equals(str)) {
                return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12983c, (CreatePagePhotoAlbumParams) operationParams.c.getParcelable("createPageAlbumParams")));
            } else if ("photos_update_album".equals(str)) {
                return m20339e(operationParams);
            } else {
                if ("delete_photo".equals(str)) {
                    return OperationResult.a((DeletePhotoResponse) ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12985e, (DeletePhotoParams) operationParams.c.getParcelable("deletePhotoParams")));
                } else if ("delete_photo_album".equals(str)) {
                    return OperationResult.a((DeletePhotoAlbumResponse) ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12986f, (DeletePhotoAlbumParams) operationParams.c.getParcelable("deletePhotoAlbumParams")));
                } else if ("add_photo_tag".equals(str)) {
                    ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12987g, (AddPhotoTagParams) operationParams.c.getParcelable("addPhotoTagParams"));
                    return OperationResult.a;
                } else if ("delete_photo_tag".equals(str)) {
                    ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12988h, (DeletePhotoTagParams) operationParams.c.getParcelable("deletePhotoTagParams"));
                    return OperationResult.a;
                } else if ("edit_photo_caption".equals(str)) {
                    ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12989i, (EditPhotoCaptionParams) operationParams.c.getParcelable("editPhotoCaptionParams"));
                    return OperationResult.a;
                } else if ("fetch_photos_metadata".equals(str)) {
                    return OperationResult.a(((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12990j, (FetchPhotosMetadataParams) operationParams.c.getParcelable("fetchPhotosMetadataParams"), operationParams.e));
                } else if ("crop_profile_picture".equals(str)) {
                    ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12991k, (CropProfilePictureParams) operationParams.c.getParcelable("cropProfilePictureParams"));
                    return OperationResult.a;
                } else if ("edit_photo_location".equals(str)) {
                    ((AbstractSingleMethodRunner) this.f12981a.get()).a(this.f12995o, (EditPhotoLocationParams) operationParams.c.getParcelable("editPhotoLocationParams"));
                    return OperationResult.a;
                } else if ("accept_place_suggestion".equals(str)) {
                    return m20340n(operationParams);
                } else {
                    if ("reject_place_suggestion".equals(str)) {
                        return m20341o(operationParams);
                    }
                    throw new UnsupportedOperationException("Unsupported operation " + str);
                }
            }
        }
    }

    private OperationResult m20340n(OperationParams operationParams) {
        PlaceSuggestionMutationParams placeSuggestionMutationParams = (PlaceSuggestionMutationParams) operationParams.c.getParcelable("placeSuggestionMutationParams");
        AcceptPlaceSuggestionUtil acceptPlaceSuggestionUtil = this.f12997q;
        UserAcceptPlaceSuggestionInputData userAcceptPlaceSuggestionInputData = new UserAcceptPlaceSuggestionInputData();
        userAcceptPlaceSuggestionInputData.a("photo_id", placeSuggestionMutationParams.f12952a);
        GraphQlCallInput graphQlCallInput = userAcceptPlaceSuggestionInputData;
        graphQlCallInput.a("place_id", placeSuggestionMutationParams.f12953b);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("session_id", placeSuggestionMutationParams.f12954c);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("actor_id", acceptPlaceSuggestionUtil.f12884a);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString acceptPlaceSuggestionMutationString = new AcceptPlaceSuggestionMutationString();
        acceptPlaceSuggestionMutationString.a("input", graphQlCallInput);
        acceptPlaceSuggestionUtil.f12885b.a(GraphQLRequest.a(acceptPlaceSuggestionMutationString));
        return OperationResult.a;
    }

    private OperationResult m20341o(OperationParams operationParams) {
        PlaceSuggestionMutationParams placeSuggestionMutationParams = (PlaceSuggestionMutationParams) operationParams.c.getParcelable("placeSuggestionMutationParams");
        RejectPlaceSuggestionUtil rejectPlaceSuggestionUtil = this.f12998r;
        UserRejectPlaceSuggestionInputData userRejectPlaceSuggestionInputData = new UserRejectPlaceSuggestionInputData();
        userRejectPlaceSuggestionInputData.a("photo_id", placeSuggestionMutationParams.f12952a);
        GraphQlCallInput graphQlCallInput = userRejectPlaceSuggestionInputData;
        graphQlCallInput.a("place_id", placeSuggestionMutationParams.f12953b);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("session_id", placeSuggestionMutationParams.f12954c);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("actor_id", rejectPlaceSuggestionUtil.f12955a);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString rejectPlaceSuggestionMutationString = new RejectPlaceSuggestionMutationString();
        rejectPlaceSuggestionMutationString.a("input", graphQlCallInput);
        rejectPlaceSuggestionUtil.f12956b.a(GraphQLRequest.a(rejectPlaceSuggestionMutationString));
        return OperationResult.a;
    }

    @Inject
    public PhotosServiceHandler(Provider<SingleMethodRunner> provider, CreatePhotoAlbumMethod createPhotoAlbumMethod, CreateSharedPhotoAlbumMethod createSharedPhotoAlbumMethod, CreatePagePhotoAlbumMethod createPagePhotoAlbumMethod, UpdatePhotoAlbumMethod updatePhotoAlbumMethod, DeletePhotoMethod deletePhotoMethod, DeletePhotoAlbumMethod deletePhotoAlbumMethod, AddPhotoTagMethod addPhotoTagMethod, DeletePhotoTagMethod deletePhotoTagMethod, EditPhotoCaptionMethod editPhotoCaptionMethod, FetchPhotosMetadataMethod fetchPhotosMetadataMethod, CropProfilePictureMethod cropProfilePictureMethod, FetchSingleAlbumMethod fetchSingleAlbumMethod, ModifyAlbumContributorMethod modifyAlbumContributorMethod, EditPhotoLocationMethod editPhotoLocationMethod, Provider<MethodBatcher> provider2, AcceptPlaceSuggestionUtil acceptPlaceSuggestionUtil, RejectPlaceSuggestionUtil rejectPlaceSuggestionUtil) {
        this.f12981a = provider;
        this.f12982b = createPhotoAlbumMethod;
        this.f12983c = createPagePhotoAlbumMethod;
        this.f12984d = updatePhotoAlbumMethod;
        this.f12985e = deletePhotoMethod;
        this.f12986f = deletePhotoAlbumMethod;
        this.f12987g = addPhotoTagMethod;
        this.f12988h = deletePhotoTagMethod;
        this.f12989i = editPhotoCaptionMethod;
        this.f12990j = fetchPhotosMetadataMethod;
        this.f12991k = cropProfilePictureMethod;
        this.f12992l = fetchSingleAlbumMethod;
        this.f12996p = provider2;
        this.f12993m = createSharedPhotoAlbumMethod;
        this.f12994n = modifyAlbumContributorMethod;
        this.f12995o = editPhotoLocationMethod;
        this.f12997q = acceptPlaceSuggestionUtil;
        this.f12998r = rejectPlaceSuggestionUtil;
    }

    private OperationResult m20338c(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Batch a = ((MethodBatcherImpl) this.f12996p.get()).a();
        Builder a2 = BatchOperation.a(this.f12983c, (CreatePagePhotoAlbumParams) bundle.getParcelable("createPageAlbumParams"));
        a2.c = "create-page-album";
        a.a(a2.a());
        a2 = BatchOperation.a(this.f12992l, new FetchSingleAlbumParams("{result=create-page-album:$.id}", null, null, 0, 0, 0, 0, 0, AlbumQueryType.DETAIL));
        a2.c = "fetch-album";
        a2 = a2;
        a2.d = "create-page-album";
        a.a(a2.a());
        a.a("create-page-album", CallerContext.a(getClass()));
        return OperationResult.a((GraphQLAlbum) a.a("fetch-album"));
    }

    private OperationResult m20339e(OperationParams operationParams) {
        Object obj;
        Bundle b = operationParams.b();
        UpdatePhotoAlbumParams updatePhotoAlbumParams = (UpdatePhotoAlbumParams) b.getParcelable("updateAlbumParams");
        Batch a = ((MethodBatcherImpl) this.f12996p.get()).a();
        String str = "change_information";
        String str2 = "make_shared";
        String str3 = "add_contributors";
        String str4 = "delete_contributors";
        Boolean valueOf = Boolean.valueOf(b.getBoolean("IsAlbumTypeShared"));
        if (updatePhotoAlbumParams.f12962f != ConversionType.NORMAL_TO_SHARED || valueOf.booleanValue()) {
            obj = null;
        } else {
            obj = 1;
        }
        a.a(BatchOperation.a(this.f12984d, new UpdatePhotoAlbumParams(updatePhotoAlbumParams.f12957a, updatePhotoAlbumParams.f12958b, updatePhotoAlbumParams.f12959c, updatePhotoAlbumParams.f12960d, updatePhotoAlbumParams.f12961e, updatePhotoAlbumParams.f12962f, updatePhotoAlbumParams.f12963g)).a(str).a());
        if (obj != null) {
            a.a(BatchOperation.a(this.f12993m, new CreateSharedPhotoAlbumParams(updatePhotoAlbumParams.f12961e, updatePhotoAlbumParams.f12957a)).a(str2).b(str).a());
        }
        ModifyAlbumContributorParams modifyAlbumContributorParams = (ModifyAlbumContributorParams) b.getParcelable("addContributors");
        if (modifyAlbumContributorParams != null) {
            if (obj != null) {
                a.a(BatchOperation.a(this.f12994n, ModifyAlbumContributorParams.Builder.m20321a(modifyAlbumContributorParams).m20322a(StringFormatUtil.a("{result=%s:id}", new Object[]{str2})).m20323a()).a(str3).b(str2).a());
            } else {
                a.a(BatchOperation.a(this.f12994n, modifyAlbumContributorParams).a(str3).b(str).a());
            }
        }
        modifyAlbumContributorParams = (ModifyAlbumContributorParams) b.getParcelable("deleteContributors");
        if (modifyAlbumContributorParams != null) {
            a.a(BatchOperation.a(this.f12994n, modifyAlbumContributorParams).a(str4).b(str).a());
        }
        a.a("create_shared_album", CallerContext.a(getClass()));
        return OperationResult.a(obj != null ? String.valueOf(a.a(str2)) : updatePhotoAlbumParams.f12957a);
    }
}
