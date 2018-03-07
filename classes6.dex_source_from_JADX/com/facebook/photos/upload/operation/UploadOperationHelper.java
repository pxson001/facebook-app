package com.facebook.photos.upload.operation;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingUploadParams;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.photos.tagging.store.FaceBoxStoreCopy;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: glUniformMatrix4fv */
public class UploadOperationHelper {
    private final Provider<PhotoFlowLogger> f13822a;
    private final FbHttpRequestProcessor f13823b;
    private final PhotoOverlayObjectMapper f13824c;
    private final ImmediateRetryTimingQEConfig f13825d;
    private final FbDataConnectionManager f13826e;
    private final AbstractFbErrorReporter f13827f;
    private final Provider<String> f13828g;

    public static UploadOperationHelper m21582b(InjectorLike injectorLike) {
        return new UploadOperationHelper(IdBasedProvider.a(injectorLike, 9251), FbHttpRequestProcessor.a(injectorLike), PhotoOverlayObjectMapper.m20234a(injectorLike), ImmediateRetryTimingQEConfig.m21204a(injectorLike), FbDataConnectionManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    public static UploadOperationHelper m21580a(InjectorLike injectorLike) {
        return m21582b(injectorLike);
    }

    @Inject
    public UploadOperationHelper(Provider<PhotoFlowLogger> provider, FbHttpRequestProcessor fbHttpRequestProcessor, PhotoOverlayObjectMapper photoOverlayObjectMapper, ImmediateRetryTimingQEConfig immediateRetryTimingQEConfig, FbDataConnectionManager fbDataConnectionManager, FbErrorReporter fbErrorReporter, Provider<String> provider2) {
        this.f13822a = provider;
        this.f13823b = fbHttpRequestProcessor;
        this.f13824c = photoOverlayObjectMapper;
        this.f13825d = immediateRetryTimingQEConfig;
        this.f13826e = fbDataConnectionManager;
        this.f13827f = fbErrorReporter;
        this.f13828g = provider2;
    }

    public final List<UploadPhotoParams> m21586a(UploadOperation uploadOperation) {
        List a = Lists.a();
        ImmutableList y = uploadOperation.m21549y();
        Dimension c = m21583c(uploadOperation);
        ImmutableList x = uploadOperation.m21548x();
        int size = x.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            MediaItem mediaItem = (MediaItem) x.get(i);
            if (MediaType.VIDEO.equals(mediaItem.m())) {
                i3 = i2 + 1;
            } else {
                CreativeEditingUploadParams creativeEditingUploadParams;
                float f;
                String str;
                ImmutableList copyOf;
                String A;
                boolean z;
                MinutiaeTag ac;
                int i4 = 0;
                ArrayList a2 = Lists.a();
                float f2 = 0.5f;
                if (mediaItem.m() == MediaType.PHOTO) {
                    int c2;
                    PhotoItem photoItem = (PhotoItem) mediaItem;
                    List b = uploadOperation.ap().m21174b(photoItem.d());
                    Photo r = photoItem.m20116r();
                    if (r instanceof LocalPhoto) {
                        LocalPhoto localPhoto = (LocalPhoto) r;
                        c2 = localPhoto.m20130c();
                        FaceBoxStoreCopy aq = uploadOperation.aq();
                        MediaIdKey a3 = localPhoto.mo1094a();
                        if (aq.m21138a(a3)) {
                            ImmutableList b2 = aq.m21139b(a3);
                            int size2 = b2.size();
                            for (i4 = 0; i4 < size2; i4++) {
                                a2.add(((FaceBox) b2.get(i4)).mo1099d());
                            }
                        }
                    } else {
                        c2 = 0;
                    }
                    if (y != null) {
                        Bundle bundle = (Bundle) y.get(i2);
                        bundle.setClassLoader(CreativeEditingData.class.getClassLoader());
                        CreativeEditingData creativeEditingData = (CreativeEditingData) bundle.getParcelable("creative_editing_metadata");
                        String string = bundle.getString("caption");
                        float f3 = bundle.getFloat("focusX");
                        float f4 = bundle.getFloat("focusY");
                        if (creativeEditingData != null) {
                            creativeEditingUploadParams = new CreativeEditingUploadParams(creativeEditingData, a2);
                            f2 = f4;
                            f = f3;
                            str = string;
                        } else {
                            creativeEditingUploadParams = null;
                            f2 = f4;
                            f = f3;
                            str = string;
                        }
                    } else {
                        creativeEditingUploadParams = null;
                        f = 0.5f;
                        str = null;
                    }
                    RectF rectF = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
                    Object obj = null;
                    if (!(b == null || b.isEmpty())) {
                        List list;
                        if (!(creativeEditingUploadParams == null || creativeEditingUploadParams.m4459a().m4440c() == null)) {
                            rectF = creativeEditingUploadParams.m4459a().m4440c();
                            obj = 1;
                        }
                        if (obj == null && c2 == 0) {
                            list = b;
                        } else {
                            this.f13824c.m20238a(rectF, c2);
                            list = this.f13824c.m20237a(b);
                        }
                        Collection a4 = m21581a(list, creativeEditingUploadParams, c2);
                        if (!(a4 == null || a4.isEmpty())) {
                            copyOf = ImmutableList.copyOf(a4);
                            i4 = c2;
                        }
                    }
                    copyOf = null;
                    i4 = c2;
                } else {
                    creativeEditingUploadParams = null;
                    f = 0.5f;
                    str = null;
                    copyOf = null;
                }
                Builder builder = new Builder(new UploadPhotoSource(mediaItem.e(), mediaItem.o()));
                if (str == null) {
                    A = uploadOperation.m21496A();
                } else {
                    A = str;
                }
                Builder a5 = builder.m21778c(A).m21755a(f).m21771b(f2).m21763a(creativeEditingUploadParams);
                if (str != null) {
                    z = true;
                } else {
                    z = false;
                }
                a5 = a5.m21779c(z).m21772b(uploadOperation.m21499D()).m21768a(uploadOperation.m21500E()).m21769a(uploadOperation.m21501F()).m21762a(uploadOperation.m21502G()).m21775b(uploadOperation.m21503H()).m21774b(uploadOperation.m21504I()).m21757a(uploadOperation.m21497B()).m21767a(uploadOperation.m21508M()).m21773b(copyOf);
                if (uploadOperation.m21548x().size() == 1) {
                    ac = uploadOperation.ac();
                } else {
                    ac = MinutiaeTag.a;
                }
                a.add(a5.m21760a(ac).m21764a(uploadOperation.m21498C()).m21781d(uploadOperation.m21509N()).m21784e(uploadOperation.m21509N() + '_' + Integer.toString(i2)).m21756a(i4).m21759a(c).m21758a(uploadOperation.m21515T()).m21776c(uploadOperation.ad()).m21766a(uploadOperation.m21517V()).m21782d(uploadOperation.m21518W()).m21785e(uploadOperation.m21519X()).m21761a(uploadOperation.ah()).m21780d(uploadOperation.ai()).m21786f(this.f13826e.c().name()).m21788g(uploadOperation.as()).m21790h(uploadOperation.at()).m21791i(uploadOperation.au()).m21783e(uploadOperation.av()).m21792j(uploadOperation.aw()).m21787f(uploadOperation.ax()).m21765a(uploadOperation.aC()).m21777c(uploadOperation.aD()).m21793k(mediaItem.q()).m21789g(uploadOperation.aE()).m21770a());
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        return a;
    }

    private List<Tag> m21581a(List<Tag> list, CreativeEditingUploadParams creativeEditingUploadParams, int i) {
        List<Tag> a = Lists.a();
        for (Tag tag : list) {
            PointF e = tag.f12786a.mo1100e();
            if (e.x < 0.0f || e.x > 1.0f || e.y < 0.0f || e.y > 1.0f) {
                CreativeEditingData creativeEditingData;
                String stringBuilder;
                if (creativeEditingUploadParams != null) {
                    creativeEditingData = creativeEditingUploadParams.f3381a;
                } else {
                    creativeEditingData = null;
                }
                String str = "Unexpected failure: invalid tags while uploading. \ntag position: " + e.x + ", " + e.y + "\nphoto orientation: " + i + "\n";
                if (creativeEditingData != null) {
                    int size;
                    int size2;
                    StringBuilder append = new StringBuilder().append(str).append("crop area: ");
                    if (creativeEditingData.m4440c() != null) {
                        str = creativeEditingData.m4440c().toString();
                    } else {
                        str = new RectF(0.0f, 0.0f, 1.0f, 1.0f).toString();
                    }
                    append = append.append(str).append("\nauto-enhance value: ").append(creativeEditingData.m4438a()).append("\ntext count: ");
                    if (creativeEditingData.m4442e() != null) {
                        size = creativeEditingData.m4442e().size();
                    } else {
                        size = 0;
                    }
                    StringBuilder append2 = append.append(size).append("\nsticker count: ");
                    if (creativeEditingData.m4441d() != null) {
                        size2 = creativeEditingData.m4441d().size();
                    } else {
                        size2 = 0;
                    }
                    stringBuilder = append2.append(size2).toString();
                } else {
                    stringBuilder = str;
                }
                this.f13827f.a(SoftError.a(getClass().getSimpleName(), stringBuilder).g());
            } else {
                a.add(tag);
            }
        }
        return a;
    }

    public static Dimension m21583c(UploadOperation uploadOperation) {
        switch (uploadOperation.f13795r) {
            case PROFILE_PIC:
                return new Dimension(180, 180);
            case COVER_PHOTO:
                return new Dimension(400, 150);
            default:
                return new Dimension(1, 1);
        }
    }

    private PhotoFlowLogger m21579a(String str, List<Long> list) {
        DefaultPhotoFlowLogger defaultPhotoFlowLogger = (DefaultPhotoFlowLogger) this.f13822a.get();
        defaultPhotoFlowLogger.m19891a(str);
        defaultPhotoFlowLogger.f12585F.f12654c.f12651b = list;
        List a = Lists.a();
        Object e = this.f13825d.m21203e();
        if (!StringUtil.a(e)) {
            a.add("timing_" + e);
        }
        a.add(FbHttpRequestProcessor.i(this.f13823b).e());
        if (a == null || a.isEmpty()) {
            defaultPhotoFlowLogger.f12601q = null;
        } else {
            defaultPhotoFlowLogger.f12601q = StringUtil.b(",", new Object[]{a});
        }
        return defaultPhotoFlowLogger;
    }

    public final DefaultPhotoFlowLogger m21585a(String str) {
        return m21579a(str, new ArrayList());
    }

    public final DefaultPhotoFlowLogger m21584a(UploadOperation uploadOperation, long j) {
        DefaultPhotoFlowLogger d = m21588d(uploadOperation);
        d.f12602r = d.f12591g.now() - (j - uploadOperation.ae());
        return d;
    }

    public final PublishPostParams.Builder m21587b(UploadOperation uploadOperation) {
        ImmutableList copyOf;
        String l;
        String str = uploadOperation.f13785h.f14024e;
        if (uploadOperation.f13780c != null) {
            copyOf = ImmutableList.copyOf(uploadOperation.f13780c);
        } else {
            copyOf = RegularImmutableList.a;
        }
        if (uploadOperation.f13786i >= 0) {
            l = Long.toString(uploadOperation.f13786i);
        } else {
            l = null;
        }
        PublishPostParams.Builder builder = new PublishPostParams.Builder();
        builder.j = Long.parseLong((String) this.f13828g.get());
        PublishPostParams.Builder builder2 = builder;
        builder2.b = uploadOperation.f13783f;
        builder2 = builder2;
        builder2.G = uploadOperation.f13793p;
        builder2 = builder2;
        builder2.g = str;
        builder2 = builder2.d(copyOf).a(uploadOperation.f13782e);
        builder2.r = uploadOperation.f13793p + "_status";
        builder2 = builder2;
        builder2.c = uploadOperation.f13781d;
        builder2 = builder2;
        builder2.d = l;
        builder2 = builder2;
        builder2.ab = uploadOperation.f13787j;
        builder2 = builder2;
        builder2.Z = uploadOperation.f13788k;
        builder2 = builder2;
        builder2.aa = uploadOperation.f13789l;
        builder2 = builder2;
        builder2.t = uploadOperation.f13801x;
        builder2 = builder2;
        builder2.o = uploadOperation.f13802y;
        builder2 = builder2.a(Long.valueOf(uploadOperation.f13803z));
        builder2.T = uploadOperation.f13760I;
        builder2 = builder2;
        builder2.U = uploadOperation.f13761J;
        builder2 = builder2;
        builder2.s = uploadOperation.f13754C;
        builder2 = builder2;
        builder2.Y = this.f13826e.c().name();
        builder2 = builder2;
        builder2.an = uploadOperation.ai;
        builder2 = builder2;
        builder2.v = uploadOperation.aj;
        builder2 = builder2;
        builder2.ao = uploadOperation.ak;
        return builder2;
    }

    public final DefaultPhotoFlowLogger m21588d(UploadOperation uploadOperation) {
        return m21579a(uploadOperation.f13793p, uploadOperation.f13762K);
    }
}
