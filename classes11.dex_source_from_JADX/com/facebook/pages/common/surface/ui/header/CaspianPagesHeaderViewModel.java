package com.facebook.pages.common.surface.ui.header;

import android.graphics.PointF;
import android.view.View.OnClickListener;
import javax.annotation.concurrent.Immutable;

/* compiled from: remote_push_trigger */
public class CaspianPagesHeaderViewModel {

    /* compiled from: remote_push_trigger */
    public class BindModel {
        public final boolean f2631a;
        public final boolean f2632b;
        public final CoverPhotoViewModel f2633c;
        public final boolean f2634d;
        public final String f2635e;
        public final long f2636f;
        public final ProfilePicViewModel f2637g;
        public final boolean f2638h;

        /* compiled from: remote_push_trigger */
        public class CoverPhotoViewModel {
            public final String f2618a;
            public final PointF f2619b;
            public final String[] f2620c;
            public final CoverPhotoSubtitleState f2621d;
            public final String f2622e;
            public final boolean f2623f;
            public final boolean f2624g;
            public final OnClickListener f2625h;

            /* compiled from: remote_push_trigger */
            public enum CoverPhotoSubtitleState {
                CATEGORY,
                USERNAME,
                CREATE_USERNAME
            }

            public CoverPhotoViewModel(java.lang.String r1, android.graphics.PointF r2, java.lang.String[] r3, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.CoverPhotoSubtitleState r4, java.lang.String r5, boolean r6, boolean r7, android.view.View.OnClickListener r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.f2618a = r1;
                r0.f2619b = r2;
                r0.f2620c = r3;
                r0.f2621d = r4;
                r0.f2622e = r5;
                r0.f2623f = r6;
                r0.f2624g = r7;
                r0.f2625h = r8;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.<init>(java.lang.String, android.graphics.PointF, java.lang.String[], com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$CoverPhotoViewModel$CoverPhotoSubtitleState, java.lang.String, boolean, boolean, android.view.View$OnClickListener):void");
            }

            public boolean equals(java.lang.Object r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = 1;
                r1 = 0;
                if (r5 != r6) goto L_0x0005;
            L_0x0004:
                return r2;
            L_0x0005:
                r0 = r6 instanceof com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel;
                if (r0 != 0) goto L_0x000b;
            L_0x0009:
                r2 = r1;
                goto L_0x0004;
            L_0x000b:
                r6 = (com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel) r6;
                r0 = r5.f2625h;
                if (r0 == 0) goto L_0x0015;
            L_0x0011:
                r0 = r6.f2625h;
                if (r0 != 0) goto L_0x001d;
            L_0x0015:
                r0 = r5.f2625h;
                if (r0 != 0) goto L_0x0066;
            L_0x0019:
                r0 = r6.f2625h;
                if (r0 != 0) goto L_0x0066;
            L_0x001d:
                r0 = r2;
            L_0x001e:
                r3 = r5.f2618a;
                r4 = r6.f2618a;
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x0028:
                r3 = r5.f2619b;
                r4 = r6.f2619b;
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x0032:
                r3 = r5.f2620c;
                r4 = r6.f2620c;
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x003c:
                r3 = r5.f2621d;
                r4 = r6.f2621d;
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x0046:
                r3 = r5.f2622e;
                r4 = r6.f2622e;
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x0050:
                r3 = r5.f2623f;
                r3 = java.lang.Boolean.valueOf(r3);
                r4 = r6.f2623f;
                r4 = java.lang.Boolean.valueOf(r4);
                r3 = com.google.common.base.Objects.equal(r3, r4);
                if (r3 == 0) goto L_0x0064;
            L_0x0062:
                if (r0 != 0) goto L_0x0004;
            L_0x0064:
                r2 = r1;
                goto L_0x0004;
            L_0x0066:
                r0 = r1;
                goto L_0x001e;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 6;
                r0 = new java.lang.Object[r0];
                r1 = 0;
                r2 = r3.f2618a;
                r0[r1] = r2;
                r1 = 1;
                r2 = r3.f2619b;
                r0[r1] = r2;
                r1 = 2;
                r2 = r3.f2620c;
                r0[r1] = r2;
                r1 = 3;
                r2 = r3.f2621d;
                r0[r1] = r2;
                r1 = 4;
                r2 = r3.f2622e;
                r0[r1] = r2;
                r1 = 5;
                r2 = r3.f2623f;
                r2 = java.lang.Boolean.valueOf(r2);
                r0[r1] = r2;
                r0 = com.google.common.base.Objects.hashCode(r0);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel.hashCode():int");
            }
        }

        @Immutable
        /* compiled from: remote_push_trigger */
        public class ProfilePicViewModel {
            public final ProfilePicState f2626a;
            public final ProfileEditIconState f2627b;
            public final ProfilePicContentState f2628c;
            public final String f2629d;
            public final String f2630e;

            /* compiled from: remote_push_trigger */
            public enum ProfileEditIconState {
                VISIBLE,
                NOT_VISIBLE
            }

            /* compiled from: remote_push_trigger */
            public enum ProfilePicContentState {
                HAS_DATA,
                NO_DATA
            }

            /* compiled from: remote_push_trigger */
            public enum ProfilePicState {
                VISIBLE,
                NOT_VISIBLE
            }

            public ProfilePicViewModel(com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicState r1, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfileEditIconState r2, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.ProfilePicContentState r3, java.lang.String r4, java.lang.String r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.f2626a = r1;
                r0.f2627b = r2;
                r0.f2628c = r3;
                r0.f2629d = r4;
                r0.f2630e = r5;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.<init>(com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$ProfilePicViewModel$ProfilePicState, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$ProfilePicViewModel$ProfileEditIconState, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$ProfilePicViewModel$ProfilePicContentState, java.lang.String, java.lang.String):void");
            }

            public boolean equals(java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = 1;
                r1 = 0;
                if (r4 != r5) goto L_0x0005;
            L_0x0004:
                return r0;
            L_0x0005:
                r2 = r5 instanceof com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel;
                if (r2 != 0) goto L_0x000b;
            L_0x0009:
                r0 = r1;
                goto L_0x0004;
            L_0x000b:
                r5 = (com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel) r5;
                r2 = r4.f2626a;
                r3 = r5.f2626a;
                r2 = com.google.common.base.Objects.equal(r2, r3);
                if (r2 == 0) goto L_0x003f;
            L_0x0017:
                r2 = r4.f2627b;
                r3 = r5.f2627b;
                r2 = com.google.common.base.Objects.equal(r2, r3);
                if (r2 == 0) goto L_0x003f;
            L_0x0021:
                r2 = r4.f2628c;
                r3 = r5.f2628c;
                r2 = com.google.common.base.Objects.equal(r2, r3);
                if (r2 == 0) goto L_0x003f;
            L_0x002b:
                r2 = r4.f2629d;
                r3 = r5.f2629d;
                r2 = com.google.common.base.Objects.equal(r2, r3);
                if (r2 == 0) goto L_0x003f;
            L_0x0035:
                r2 = r4.f2630e;
                r3 = r5.f2630e;
                r2 = com.google.common.base.Objects.equal(r2, r3);
                if (r2 != 0) goto L_0x0004;
            L_0x003f:
                r0 = r1;
                goto L_0x0004;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 5;
                r0 = new java.lang.Object[r0];
                r1 = 0;
                r2 = r3.f2626a;
                r0[r1] = r2;
                r1 = 1;
                r2 = r3.f2627b;
                r0[r1] = r2;
                r1 = 2;
                r2 = r3.f2628c;
                r0[r1] = r2;
                r1 = 3;
                r2 = r3.f2629d;
                r0[r1] = r2;
                r1 = 4;
                r2 = r3.f2630e;
                r0[r1] = r2;
                r0 = com.google.common.base.Objects.hashCode(r0);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel.hashCode():int");
            }
        }

        public BindModel(boolean r1, boolean r2, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.CoverPhotoViewModel r3, boolean r4, java.lang.String r5, long r6, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.ProfilePicViewModel r8, boolean r9) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r0 = this;
            r0.<init>();
            r0.f2631a = r1;
            r0.f2632b = r2;
            r0.f2633c = r3;
            r0.f2634d = r4;
            r0.f2635e = r5;
            r0.f2636f = r6;
            r0.f2637g = r8;
            r0.f2638h = r9;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.<init>(boolean, boolean, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$CoverPhotoViewModel, boolean, java.lang.String, long, com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel$BindModel$ProfilePicViewModel, boolean):void");
        }

        public boolean equals(java.lang.Object r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r6 = this;
            r0 = 1;
            r1 = 0;
            if (r6 != r7) goto L_0x0005;
        L_0x0004:
            return r0;
        L_0x0005:
            r2 = r7 instanceof com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel;
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            r0 = r1;
            goto L_0x0004;
        L_0x000b:
            r7 = (com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel) r7;
            r2 = r6.f2631a;
            r2 = java.lang.Boolean.valueOf(r2);
            r3 = r7.f2631a;
            r3 = java.lang.Boolean.valueOf(r3);
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x001f:
            r2 = r6.f2632b;
            r2 = java.lang.Boolean.valueOf(r2);
            r3 = r7.f2632b;
            r3 = java.lang.Boolean.valueOf(r3);
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x0031:
            r2 = r6.f2633c;
            r3 = r7.f2633c;
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x003b:
            r2 = r6.f2634d;
            r2 = java.lang.Boolean.valueOf(r2);
            r3 = r7.f2634d;
            r3 = java.lang.Boolean.valueOf(r3);
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x004d:
            r2 = r6.f2635e;
            r3 = r7.f2635e;
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x0057:
            r2 = r6.f2636f;
            r2 = java.lang.Long.valueOf(r2);
            r4 = r7.f2636f;
            r3 = java.lang.Long.valueOf(r4);
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x0069:
            r2 = r6.f2637g;
            r3 = r7.f2637g;
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 == 0) goto L_0x0085;
        L_0x0073:
            r2 = r6.f2638h;
            r2 = java.lang.Boolean.valueOf(r2);
            r3 = r7.f2638h;
            r3 = java.lang.Boolean.valueOf(r3);
            r2 = com.google.common.base.Objects.equal(r2, r3);
            if (r2 != 0) goto L_0x0004;
        L_0x0085:
            r0 = r1;
            goto L_0x0004;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r4 = this;
            r0 = 8;
            r0 = new java.lang.Object[r0];
            r1 = 0;
            r2 = r4.f2631a;
            r2 = java.lang.Boolean.valueOf(r2);
            r0[r1] = r2;
            r1 = 1;
            r2 = r4.f2632b;
            r2 = java.lang.Boolean.valueOf(r2);
            r0[r1] = r2;
            r1 = 2;
            r2 = r4.f2633c;
            r0[r1] = r2;
            r1 = 3;
            r2 = r4.f2634d;
            r2 = java.lang.Boolean.valueOf(r2);
            r0[r1] = r2;
            r1 = 4;
            r2 = r4.f2635e;
            r0[r1] = r2;
            r1 = 5;
            r2 = r4.f2636f;
            r2 = java.lang.Long.valueOf(r2);
            r0[r1] = r2;
            r1 = 6;
            r2 = r4.f2637g;
            r0[r1] = r2;
            r1 = 7;
            r2 = r4.f2638h;
            r2 = java.lang.Boolean.valueOf(r2);
            r0[r1] = r2;
            r0 = com.google.common.base.Objects.hashCode(r0);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel.hashCode():int");
        }
    }
}
