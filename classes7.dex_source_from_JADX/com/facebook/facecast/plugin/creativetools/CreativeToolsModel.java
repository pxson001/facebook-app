package com.facebook.facecast.plugin.creativetools;

import android.os.Handler;
import com.facebook.common.util.CollectionUtil;
import com.facebook.facecast.plugin.FacecastRecordingAggregatePlugin.C15851;
import com.facebook.facecast.plugin.creativetools.FacecastCreativeToolsButtonPlugin.C16191;
import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.FetchCreativeToolsQueryModel;
import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.FetchCreativeToolsQueryModel.CreativeToolsModel.EdgesModel;
import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.FetchCreativeToolsQueryModel.CreativeToolsModel.EdgesModel.NodeModel;
import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.VideoBasicAdjustmentFilterModel;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bb13383f4344186edf6f9abc17d8ba40 */
public class CreativeToolsModel {
    public static final String f18702a = CreativeToolsModel.class.getName();
    public final GraphQLQueryExecutor f18703b;
    public final Handler f18704c;
    public final GatekeeperStoreImpl f18705d;
    public final String f18706e;
    public final C15851 f18707f;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchCreativeToolsQueryModel>> f18708g;
    public boolean f18709h;

    /* compiled from: bb13383f4344186edf6f9abc17d8ba40 */
    public class C16151 implements FutureCallback<GraphQLResult<FetchCreativeToolsQueryModel>> {
        final /* synthetic */ CreativeToolsModel f18699a;

        public void onFailure(Throwable th) {
            String str = CreativeToolsModel.f18702a;
        }

        public C16151(CreativeToolsModel creativeToolsModel) {
            this.f18699a = creativeToolsModel;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                CreativeToolsModel creativeToolsModel = this.f18699a;
                com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.FetchCreativeToolsQueryModel.CreativeToolsModel j = ((FetchCreativeToolsQueryModel) graphQLResult.e).m22348j();
                if (j != null) {
                    List arrayList = new ArrayList();
                    Object arrayList2 = new ArrayList();
                    ImmutableList a = j.m22341a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i);
                        if (edgesModel != null) {
                            NodeModel a2 = edgesModel.m22336a();
                            if (a2 != null) {
                                int i2;
                                if (creativeToolsModel.f18705d.a(590, false)) {
                                    ImmutableList j2 = a2.m22333j();
                                    int size2 = j2.size();
                                    for (i2 = 0; i2 < size2; i2++) {
                                        VideoBasicAdjustmentFilterModel videoBasicAdjustmentFilterModel = (VideoBasicAdjustmentFilterModel) j2.get(i2);
                                        if (videoBasicAdjustmentFilterModel != null) {
                                            CreativeToolsBasicAdjustmentFilter a3 = CreativeToolsBasicAdjustmentFilter.m22230a(videoBasicAdjustmentFilterModel);
                                            if (a3 != null) {
                                                arrayList.add(a3);
                                            }
                                        }
                                    }
                                }
                                if (creativeToolsModel.f18705d.a(591, false)) {
                                    ImmutableList a4 = a2.m22332a();
                                    int size3 = a4.size();
                                    for (i2 = 0; i2 < size3; i2++) {
                                        CreativeToolsColorDoodle a5 = CreativeToolsColorDoodle.m22261a((String) a4.get(i2));
                                        if (a5 != null) {
                                            arrayList2.add(a5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Object arrayList3 = new ArrayList();
                    if (CollectionUtil.b(arrayList)) {
                        arrayList.add(0, CreativeToolsBasicAdjustmentFilter.f18641a);
                        arrayList3.add(new CreativeToolsBasicAdjustmentPack(arrayList));
                    }
                    if (CollectionUtil.b(arrayList2)) {
                        arrayList3.add(new CreativeToolsColorDoodlePack(arrayList2));
                    }
                    if (CollectionUtil.b(arrayList3)) {
                        HandlerDetour.a(creativeToolsModel.f18704c, new C16162(creativeToolsModel, arrayList3), -1216634858);
                    }
                }
            }
        }
    }

    /* compiled from: bb13383f4344186edf6f9abc17d8ba40 */
    public class C16162 implements Runnable {
        final /* synthetic */ List f18700a;
        final /* synthetic */ CreativeToolsModel f18701b;

        public C16162(CreativeToolsModel creativeToolsModel, List list) {
            this.f18701b = creativeToolsModel;
            this.f18700a = list;
        }

        public void run() {
            if (!this.f18701b.f18709h) {
                this.f18701b.f18708g = null;
                C15851 c15851 = this.f18701b.f18707f;
                c15851.f18471a.f18497t = this.f18700a;
                c15851.f18471a.f18493p = new FacecastCreativeToolsButtonPlugin(c15851.f18471a.getContext());
                FacecastCreativeToolsButtonPlugin facecastCreativeToolsButtonPlugin = c15851.f18471a.f18493p;
                facecastCreativeToolsButtonPlugin.f18734c.setOnClickListener(new C16191(facecastCreativeToolsButtonPlugin, c15851.f18471a));
                c15851.f18471a.m21955a(c15851.f18471a.f18493p);
            }
        }
    }

    @Inject
    public CreativeToolsModel(GraphQLQueryExecutor graphQLQueryExecutor, Handler handler, GatekeeperStoreImpl gatekeeperStoreImpl, @Assisted String str, @Assisted C15851 c15851) {
        this.f18703b = graphQLQueryExecutor;
        this.f18704c = handler;
        this.f18705d = gatekeeperStoreImpl;
        this.f18706e = str;
        this.f18707f = c15851;
    }

    public final void m22275b() {
        if (this.f18708g != null) {
            this.f18708g.cancel(false);
            this.f18708g = null;
            this.f18709h = true;
            this.f18704c.removeCallbacksAndMessages(null);
        }
    }
}
