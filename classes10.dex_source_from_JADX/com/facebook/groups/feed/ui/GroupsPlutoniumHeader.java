package com.facebook.groups.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView.StandardHeaderSizingType;
import com.facebook.caspian.ui.standardheader.StandardCoverPhotoView;
import com.facebook.caspian.ui.standardheader.StandardCoverType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.dracula.runtime.guava.DraculaImmutableList.0;
import com.facebook.dracula.runtime.iterator.DraculaFlatList;
import com.facebook.dracula.runtime.jdk.DraculaAbstractCollection.0.Dracula;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileGridView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadViewMessagesFragmentPaymentsHelper */
public class GroupsPlutoniumHeader extends StandardCoverHeaderView {
    private static final CallerContext f22255k = CallerContext.a(GroupsPlutoniumHeader.class, "group_feed", "plutonium_cover_photo");
    private static final String[] f22256l = new String[0];
    @Nullable
    public FetchGroupInformationModel f22257m;
    public SecureContextHelper f22258n;
    private Provider<IFeedIntentBuilder> f22259o;
    public NumberTruncationUtil f22260p;
    private boolean f22261q;
    private String[] f22262r;
    private boolean f22263s;
    private final OnClickListener f22264t = new C32131(this);

    /* compiled from: ThreadViewMessagesFragmentPaymentsHelper */
    class C32131 implements OnClickListener {
        final /* synthetic */ GroupsPlutoniumHeader f22252a;

        C32131(GroupsPlutoniumHeader groupsPlutoniumHeader) {
            this.f22252a = groupsPlutoniumHeader;
        }

        public void onClick(View view) {
            MutableFlatBuffer mutableFlatBuffer;
            int i;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1562107250);
            DraculaReturnValue b = this.f22252a.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i2 = b.b;
            int i3 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer2, mutableFlatBuffer2.g(i2, 1), null, 0)) {
                mutableFlatBuffer = null;
                i = 0;
            } else {
                DraculaReturnValue b2 = this.f22252a.f22257m.b();
                mutableFlatBuffer = b2.a;
                int i4 = b2.b;
                i = b2.c;
                i = mutableFlatBuffer.g(mutableFlatBuffer.g(i4, 1), 0);
            }
            GroupsPlutoniumHeader groupsPlutoniumHeader = this.f22252a;
            PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(groupsPlutoniumHeader.getContext());
            PopoverMenu c = popoverMenuWindow.c();
            OnMenuItemClickListener c32142 = new C32142(groupsPlutoniumHeader);
            OnMenuItemClickListener c32153 = new C32153(groupsPlutoniumHeader);
            if (groupsPlutoniumHeader.f22257m.c()) {
                c.a(2131237957).setOnMenuItemClickListener(c32153);
            }
            DraculaReturnValue b3 = groupsPlutoniumHeader.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer3 = b3.a;
            int i5 = b3.b;
            int i6 = b3.c;
            GraphQLGroupVisibility graphQLGroupVisibility = (GraphQLGroupVisibility) mutableFlatBuffer3.f(i5, 17, GraphQLGroupVisibility.class);
            GraphQLGroupJoinState p = groupsPlutoniumHeader.f22257m.p();
            if (!DraculaRuntime.a(mutableFlatBuffer, i, null, 0) && (p == GraphQLGroupJoinState.MEMBER || graphQLGroupVisibility == GraphQLGroupVisibility.OPEN)) {
                c.a(2131237958).setOnMenuItemClickListener(c32142);
                if (c.getCount() == 1) {
                    GroupsPlutoniumHeader.m23381j(groupsPlutoniumHeader);
                    LogUtils.a(1214878377, a);
                }
            }
            popoverMenuWindow.a(groupsPlutoniumHeader.g);
            LogUtils.a(1214878377, a);
        }
    }

    /* compiled from: ThreadViewMessagesFragmentPaymentsHelper */
    public class C32142 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeader f22253a;

        public C32142(GroupsPlutoniumHeader groupsPlutoniumHeader) {
            this.f22253a = groupsPlutoniumHeader;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsPlutoniumHeader.m23381j(this.f22253a);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragmentPaymentsHelper */
    public class C32153 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeader f22254a;

        public C32153(GroupsPlutoniumHeader groupsPlutoniumHeader) {
            this.f22254a = groupsPlutoniumHeader;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsPlutoniumHeader.m23374a(this.f22254a.f22258n, this.f22254a.getContext());
            return true;
        }
    }

    public static void m23376a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsPlutoniumHeader) obj).m23375a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), NumberTruncationUtil.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 2347), Boolean_IsTabletMethodAutoProvider.a(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
    }

    public GroupsPlutoniumHeader(Context context) {
        super(context);
        m23378b();
    }

    @Inject
    private void m23375a(SecureContextHelper secureContextHelper, NumberTruncationUtil numberTruncationUtil, Provider<IFeedIntentBuilder> provider, Boolean bool, Boolean bool2) {
        this.f22258n = secureContextHelper;
        this.f22260p = numberTruncationUtil;
        this.f22259o = provider;
        this.f22261q = bool.booleanValue();
        this.f22263s = bool2.booleanValue();
    }

    private void m23378b() {
        Class cls = GroupsPlutoniumHeader.class;
        m23376a((Object) this, getContext());
        e();
        if (this.f22261q) {
            this.i.setVisibility(8);
        }
        this.f.setFocusable(true);
        this.f.setTitleTextAppearance(2131626073);
        this.f.setSubtitleTextAppearance(2131626074);
        this.d = StandardHeaderSizingType.NARROW;
        f();
        m23379h();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = getContext().getResources().getConfiguration().orientation;
        if (this.b != i) {
            this.b = i;
            f();
            m23377a(false);
        }
    }

    public static void m23374a(SecureContextHelper secureContextHelper, Context context) {
        Builder a = new Builder(SimplePickerSource.GROUP).h().i().k().a(Action.LAUNCH_COVER_PIC_CROPPER);
        Intent intent = new Intent(context, SimplePickerLauncherActivity.class);
        intent.putExtra("extra_simple_picker_launcher_settings", a.r());
        secureContextHelper.a(intent, 301, (Activity) ContextUtils.a(context, Activity.class));
    }

    public final void m23382a(@Nullable FetchGroupInformationModel fetchGroupInformationModel, boolean z) {
        boolean z2;
        this.f22257m = fetchGroupInformationModel;
        if (this.f22257m == null) {
            z2 = true;
        } else {
            DraculaReturnValue b = this.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z2 = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (z2) {
            this.f.setTitleText("");
            this.f.setSubtitleText("");
        } else {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (mutableFlatBuffer.k(i, 13) != null) {
                b = this.f22257m.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                this.f.setTitleText(mutableFlatBuffer.k(i, 13));
            }
            StringBuilder stringBuilder = new StringBuilder();
            DraculaReturnValue b2 = this.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer2 = b2.a;
            int i3 = b2.b;
            int i4 = b2.c;
            if (mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class) != null) {
                b2 = this.f22257m.b();
                mutableFlatBuffer2 = b2.a;
                i3 = b2.b;
                i4 = b2.c;
                if (mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class) == GraphQLGroupVisibility.CLOSED) {
                    stringBuilder.append(getResources().getString(2131237961));
                } else {
                    b2 = this.f22257m.b();
                    mutableFlatBuffer2 = b2.a;
                    i3 = b2.b;
                    i4 = b2.c;
                    if (mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class) == GraphQLGroupVisibility.OPEN) {
                        b2 = this.f22257m.b();
                        mutableFlatBuffer2 = b2.a;
                        i3 = b2.b;
                        i4 = b2.c;
                        if (DraculaRuntime.a(mutableFlatBuffer2, mutableFlatBuffer2.g(i3, 14), null, 0)) {
                            stringBuilder.append(getResources().getString(2131237962));
                        } else {
                            b2 = this.f22257m.b();
                            mutableFlatBuffer2 = b2.a;
                            i3 = b2.b;
                            i4 = b2.c;
                            if (mutableFlatBuffer2.k(mutableFlatBuffer2.g(i3, 14), 1) != null) {
                                b2 = this.f22257m.b();
                                mutableFlatBuffer2 = b2.a;
                                i3 = b2.b;
                                i4 = b2.c;
                                i4 = mutableFlatBuffer2.g(i3, 14);
                                stringBuilder.append(getResources().getString(2131237964, new Object[]{mutableFlatBuffer2.k(i4, 1)}));
                            } else {
                                stringBuilder.append(getResources().getString(2131237963));
                            }
                        }
                    } else {
                        b2 = this.f22257m.b();
                        mutableFlatBuffer2 = b2.a;
                        i3 = b2.b;
                        i4 = b2.c;
                        if (mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class) == GraphQLGroupVisibility.SECRET) {
                            b2 = this.f22257m.b();
                            mutableFlatBuffer2 = b2.a;
                            i3 = b2.b;
                            i4 = b2.c;
                            if (mutableFlatBuffer2.h(i3, 12)) {
                                b2 = this.f22257m.b();
                                mutableFlatBuffer2 = b2.a;
                                i3 = b2.b;
                                i4 = b2.c;
                                stringBuilder.append(mutableFlatBuffer2.k(mutableFlatBuffer2.g(i3, 18), 0));
                            } else {
                                stringBuilder.append(getResources().getString(2131237965));
                            }
                        }
                    }
                }
            }
            b2 = this.f22257m.b();
            mutableFlatBuffer2 = b2.a;
            i3 = b2.b;
            i4 = b2.c;
            if (!DraculaRuntime.a(mutableFlatBuffer2, mutableFlatBuffer2.g(i3, 4), null, 0) && stringBuilder.length() > 0) {
                b2 = this.f22257m.b();
                mutableFlatBuffer2 = b2.a;
                i3 = b2.b;
                i4 = b2.c;
                i4 = mutableFlatBuffer2.g(i3, 4);
                DraculaReturnValue b3 = this.f22257m.b();
                MutableFlatBuffer mutableFlatBuffer3 = b3.a;
                int i5 = b3.b;
                i3 = b3.c;
                i3 = mutableFlatBuffer3.g(i5, 4);
                stringBuilder.append(" ").append(getResources().getString(2131237821)).append(" ").append(getResources().getQuantityString(2131689700, mutableFlatBuffer2.j(i4, 0), new Object[]{this.f22260p.a(mutableFlatBuffer3.j(i3, 0))}));
            }
            this.f.setSubtitleText(stringBuilder.toString());
        }
        m23377a(z);
    }

    public String[] getCoverPhotoDescription() {
        return this.f22262r;
    }

    public void setCoverPhotoDescription(FetchGroupInformationModel fetchGroupInformationModel) {
        boolean z;
        if (fetchGroupInformationModel == null) {
            z = true;
        } else {
            DraculaReturnValue b = fetchGroupInformationModel.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (!z && this.f22262r == null) {
            b = fetchGroupInformationModel.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 1), null, 0)) {
                i2 = 0;
            } else {
                b = fetchGroupInformationModel.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                i2 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), null, 0) ? 1 : 0;
            }
            if (i2 != 0) {
                b = fetchGroupInformationModel.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                i2 = mutableFlatBuffer.k(mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), 0) != null ? 1 : 0;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                b = fetchGroupInformationModel.b();
                mutableFlatBuffer = b.a;
                i = b.b;
                i2 = b.c;
                b = fetchGroupInformationModel.b();
                MutableFlatBuffer mutableFlatBuffer2 = b.a;
                int i3 = b.b;
                i2 = b.c;
                i2 = mutableFlatBuffer2.g(mutableFlatBuffer2.g(i3, 1), 0);
                this.f22262r = new String[]{mutableFlatBuffer.k(i, 13), mutableFlatBuffer2.k(i2, 0)};
                return;
            }
            b = fetchGroupInformationModel.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            this.f22262r = new String[]{mutableFlatBuffer.k(i, 13)};
        }
    }

    private void m23377a(boolean z) {
        int i;
        int i2 = 1;
        if (this.f22257m != null) {
            DraculaReturnValue b = this.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i3 = b.b;
            i = b.c;
            i = !DraculaRuntime.a(mutableFlatBuffer, i3, null, 0) ? 1 : 0;
        } else {
            i = 0;
        }
        if (i != 0) {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            i = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i3, 1), null, 0) ? 1 : 0;
        } else {
            i = 0;
        }
        if (i != 0) {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            i = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(i3, 1), 0), null, 0) ? 1 : 0;
        } else {
            i = 0;
        }
        if (i != 0) {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            i = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i3, 1), 0), 2), null, 0) ? 1 : 0;
        } else {
            i = 0;
        }
        if (i != 0) {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            i = mutableFlatBuffer.k(mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i3, 1), 0), 2), 0) != null ? 1 : 0;
        } else {
            i = 0;
        }
        if (i != 0) {
            setCoverPhotoDescription(this.f22257m);
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            setCoverPhoto(mutableFlatBuffer.k(mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i3, 1), 0), 2), 0));
            return;
        }
        boolean z2;
        if (this.f22257m == null) {
            z2 = true;
        } else {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            z2 = DraculaRuntime.a(mutableFlatBuffer, i3, null, 0);
        }
        if (!z2) {
            b = this.f22257m.b();
            mutableFlatBuffer = b.a;
            i3 = b.b;
            i = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i3, 4), null, 0)) {
                i2 = 0;
            } else {
                b = this.f22257m.b();
                mutableFlatBuffer = b.a;
                i3 = b.b;
                i = b.c;
                if (mutableFlatBuffer.j(mutableFlatBuffer.g(i3, 4), 0) < 8) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                m23380i();
                return;
            } else if (this.f22257m.c()) {
                setDefaultCoverPhoto(z);
                return;
            }
        }
        m23379h();
    }

    private void setCoverPhoto(String str) {
        setCoverType(StandardCoverType.IMAGE);
        this.g.setScaleType(ScaleType.CENTER_CROP);
        this.g.a(getScreenWidth(), this.c, true, null, ImageRequest.a(str), null, false, false, getCoverPhotoDescription(), f22255k, this.f22264t, null, true, false);
    }

    private void m23379h() {
        setCoverType(StandardCoverType.IMAGE);
        this.g.a(getScreenWidth(), this.c, true, null, null, null, false, false, f22256l, f22255k, null, null, true, false);
    }

    private void setDefaultCoverPhoto(boolean z) {
        boolean z2;
        StandardCoverPhotoView standardCoverPhotoView = this.g;
        int screenWidth = getScreenWidth();
        int i = this.c;
        String[] strArr = f22256l;
        CallerContext callerContext = f22255k;
        OnClickListener onClickListener = this.f22264t;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        standardCoverPhotoView.a(screenWidth, i, true, null, null, null, true, true, strArr, callerContext, onClickListener, null, true, z2);
    }

    private void m23380i() {
        DraculaReturnValue b = this.f22257m.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        DraculaFlatList a = DraculaFlatList.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 4), 1, -1760113995);
        Dracula a2 = a != null ? 0.Dracula.a(a) : 0.Dracula.h();
        List a3 = Lists.a();
        int c = a2.c();
        for (i = 0; i < c; i++) {
            DraculaReturnValue a4 = a2.a(i);
            MutableFlatBuffer mutableFlatBuffer2 = a4.a;
            int i3 = a4.b;
            int i4 = a4.c;
            if (DraculaRuntime.a(mutableFlatBuffer2, i3, null, 0)) {
                i4 = 0;
            } else if (DraculaRuntime.a(mutableFlatBuffer2, mutableFlatBuffer2.g(i3, 2), null, 0)) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            i4 = i4 != 0 ? mutableFlatBuffer2.k(mutableFlatBuffer2.g(i3, 2), 0) != null ? 1 : 0 : 0;
            if (i4 != 0) {
                a3.add(new Face(Uri.parse(mutableFlatBuffer2.k(mutableFlatBuffer2.g(i3, 2), 0).toString()), 1, 1));
            }
        }
        if (a3.size() >= 8) {
            setCoverType(StandardCoverType.FACEPILE);
            OnClickListener onClickListener = this.f22264t;
            f();
            ((FacepileGridView) this.h.a()).setLayoutParams(new LayoutParams(-1, this.c));
            if (a3.size() >= 8) {
                ((FacepileGridView) this.h.a()).setNumRows(2);
                ((FacepileGridView) this.h.a()).setNumCols(((FacepileGridView) this.h.a()).h * 2);
            } else {
                ((FacepileGridView) this.h.a()).setNumRows(1);
                ((FacepileGridView) this.h.a()).setNumCols(((FacepileGridView) this.h.a()).h * 2);
            }
            ((FacepileGridView) this.h.a()).setFaces(a3);
            ((FacepileGridView) this.h.a()).setOnClickListener(onClickListener);
        }
    }

    public static void m23381j(GroupsPlutoniumHeader groupsPlutoniumHeader) {
        DraculaReturnValue b = groupsPlutoniumHeader.f22257m.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        if (DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 1), null, 0)) {
            i2 = 0;
        } else {
            b = groupsPlutoniumHeader.f22257m.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), null, 0) ? 1 : 0;
        }
        if (i2 != 0) {
            b = groupsPlutoniumHeader.f22257m.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), 2), null, 0) ? 1 : 0;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            b = groupsPlutoniumHeader.f22257m.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = mutableFlatBuffer.k(mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), 2), 0) != null ? 1 : 0;
        } else {
            i2 = 0;
        }
        if (i2 != 0 && groupsPlutoniumHeader.f22259o != null) {
            b = groupsPlutoniumHeader.f22257m.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i = mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0);
            b = groupsPlutoniumHeader.f22257m.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i3 = b.b;
            i2 = b.c;
            i3 = mutableFlatBuffer2.g(mutableFlatBuffer2.g(mutableFlatBuffer2.g(i3, 1), 0), 2);
            IFeedIntentBuilder iFeedIntentBuilder = (IFeedIntentBuilder) groupsPlutoniumHeader.f22259o.get();
            long parseLong = Long.parseLong(mutableFlatBuffer.k(i, 1));
            mutableFlatBuffer2.k(i3, 0);
            Intent a = iFeedIntentBuilder.a(parseLong, null, FullscreenGallerySource.GROUPS_COVER_PHOTO);
            if (a != null) {
                groupsPlutoniumHeader.f22258n.a(a, groupsPlutoniumHeader.getContext());
            }
        }
    }
}
