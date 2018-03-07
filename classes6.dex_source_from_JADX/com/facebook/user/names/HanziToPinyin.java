package com.facebook.user.names;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.google.common.annotations.VisibleForTesting;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: contributors[%d] */
public class HanziToPinyin {
    static final char[] f18463a = new char[]{'呵', '哎', '安', '肮', '凹', '八', '挀', '扳', '邦', '包', '卑', '奔', '伻', '屄', '边', '标', '憋', '邠', '槟', '癶', '峬', '嚓', '婇', '飡', '仓', '操', '冊', '嵾', '噌', '叉', '钗', '辿', '伥', '抄', '车', '抻', '柽', '吃', '充', '抽', '出', '欻', '揣', '川', '疮', '吹', '杶', '逴', '疵', '匆', '凑', '粗', '汆', '崔', '邨', '搓', '咑', '大', '疸', '当', '刀', '淂', '得', '扥', '灯', '氐', '嗲', '甸', '刁', '爹', '仃', '丟', '东', '唗', '嘟', '偳', '堆', '鐓', '多', '婀', '诶', '奀', '鞥', '而', '发', '帆', '方', '飞', '分', '丰', '覅', '仏', '紑', '伕', '旮', '该', '甘', '冈', '皋', '戈', '給', '根', '庚', '工', '勾', '估', '瓜', '罫', '关', '光', '归', '衮', '呙', '哈', '咳', '顸', '苀', '蒿', '诃', '黒', '拫', '亨', '噷', '吽', '齁', '匢', '花', '怀', '犿', '巟', '灰', '昏', '吙', '丌', '加', '戋', '江', '艽', '阶', '巾', '劤', '冂', '勼', '匊', '娟', '噘', '军', '咔', '开', '刊', '闶', '尻', '匼', '剋', '肯', '阬', '空', '抠', '刳', '夸', '蒯', '宽', '匡', '亏', '坤', '扩', '垃', '来', '兰', '啷', '捞', '仂', '勒', '塄', '刕', '倆', '奁', '良', '撩', '列', '拎', '〇', '溜', '龙', '瞜', '噜', '娈', '畧', '抡', '罗', '呣', '妈', '霾', '嫚', '邙', '猫', '麼', '沒', '门', '甿', '咪', '眠', '喵', '咩', '民', '名', '谬', '摸', '哞', '毪', '拏', '孻', '囡', '囊', '孬', '讷', '馁', '恁', '能', '妮', '拈', '嬢', '鸟', '捏', '您', '宁', '妞', '农', '羺', '奴', '奻', '虐', '挪', '喔', '讴', '趴', '拍', '眅', '乓', '抛', '呸', '喷', '匉', '丕', '偏', '剽', '氕', '姘', '乒', '钋', '剖', '仆', '七', '掐', '千', '呛', '悄', '癿', '侵', '靑', '邛', '丘', '曲', '弮', '缺', '夋', '呥', '穣', '娆', '惹', '人', '扔', '日', '茸', '厹', '如', '堧', '桵', '闰', '若', '仨', '毢', '三', '桒', '掻', '色', '森', '僧', '杀', '筛', '山', '伤', '弰', '奢', '申', '升', '尸', '収', '书', '刷', '摔', '闩', '双', '谁', '吮', '妁', '厶', '忪', '捜', '苏', '狻', '夊', '孙', '唆', '他', '苔', '坍', '铴', '夲', '忑', '熥', '剔', '天', '佻', '帖', '厅', '囲', '偷', '鋀', '湍', '推', '吞', '托', '挖', '歪', '弯', '尪', '危', '塭', '翁', '挝', '兀', '夕', '虾', '仚', '乡', '灱', '些', '心', '星', '凶', '休', '旴', '轩', '疶', '勋', '丫', '恹', '央', '幺', '耶', '一', '欭', '应', '哟', '佣', '优', '扜', '鸢', '曰', '晕', '匝', '災', '糌', '牂', '傮', '则', '贼', '怎', '増', '吒', '捚', '沾', '张', '钊', '蜇', '贞', '争', '之', '中', '州', '朱', '抓', '跩', '专', '妆', '隹', '宒', '卓', '孜', '宗', '邹', '租', '钻', '厜', '尊', '昨'};
    static final byte[][] f18464b = new byte[][]{new byte[]{(byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 82, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}};
    private static final Class<?> f18465c = HanziToPinyin.class;
    private static final Collator f18466d = Collator.getInstance(Locale.CHINA);
    private final AbstractFbErrorReporter f18467e;
    private final int f18468f;
    private boolean f18469g = false;
    public boolean f18470h;

    /* compiled from: contributors[%d] */
    public class Token {
        public int f18460a;
        public String f18461b;
        public String f18462c;

        public Token(int i, String str, String str2) {
            this.f18460a = i;
            this.f18461b = str;
            this.f18462c = str2;
        }
    }

    @Inject
    public HanziToPinyin(AbstractFbErrorReporter abstractFbErrorReporter) {
        int i;
        boolean z = true;
        this.f18467e = abstractFbErrorReporter;
        Object obj = null;
        Locale[] availableLocales = Collator.getAvailableLocales();
        for (Locale equals : availableLocales) {
            if (equals.equals(Locale.CHINA)) {
                obj = 1;
                break;
            }
        }
        if (obj == null) {
            i = 1;
        } else if (m27083b()) {
            i = 0;
        } else {
            i = 2;
        }
        if (i != 0) {
            z = false;
        }
        this.f18470h = z;
        this.f18468f = i;
    }

    private static boolean m27083b() {
        char c = f18463a[0];
        String ch = Character.toString(c);
        char[] cArr = f18463a;
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            String ch2;
            char c2 = cArr[i];
            if (c != c2) {
                ch2 = Character.toString(c2);
                if (f18466d.compare(ch, ch2) >= 0) {
                    BLog.b(f18465c, "Internal error in Unihan table. The last string \"" + ch + "\" is greater than current string \"" + ch2 + "\".");
                    return false;
                }
            } else {
                ch2 = ch;
            }
            i++;
            ch = ch2;
        }
        return true;
    }

    private Token m27080a(char c) {
        int i = 0;
        Token token = new Token();
        String ch = Character.toString(c);
        token.f18461b = ch;
        int i2 = -1;
        if (c < 'Ā') {
            token.f18460a = 1;
            token.f18462c = ch;
            return token;
        } else if (c < '㐀') {
            token.f18460a = 3;
            token.f18462c = ch;
            return token;
        } else {
            int compare = f18466d.compare(ch, "阿");
            if (compare < 0) {
                token.f18460a = 3;
                token.f18462c = ch;
                return token;
            }
            if (compare == 0) {
                token.f18460a = 2;
                i2 = 0;
            } else {
                compare = f18466d.compare(ch, "蓙");
                if (compare > 0) {
                    token.f18460a = 3;
                    token.f18462c = ch;
                    return token;
                } else if (compare == 0) {
                    token.f18460a = 2;
                    i2 = f18463a.length - 1;
                }
            }
            token.f18460a = 2;
            if (i2 < 0) {
                int length = f18463a.length - 1;
                int i3 = 0;
                while (i3 <= length) {
                    i2 = (i3 + length) / 2;
                    compare = f18466d.compare(ch, Character.toString(f18463a[i2]));
                    if (compare == 0) {
                        break;
                    } else if (compare > 0) {
                        i3 = i2 + 1;
                    } else {
                        length = i2 - 1;
                    }
                }
            }
            int i4 = compare;
            compare = i2;
            if (i4 < 0) {
                compare--;
            }
            if (compare < 0 || compare >= f18464b.length) {
                this.f18467e.a("HanziToPinyin", StringFormatUtil.formatStrLocaleSafe("No valid pinyin in map for %s, offset=%d, errorCode=%d", ch, Integer.valueOf(compare), Integer.valueOf(this.f18468f)));
                token.f18460a = 3;
                token.f18462c = ch;
                return token;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < f18464b[compare].length && f18464b[compare][i] != (byte) 0) {
                stringBuilder.append((char) f18464b[compare][i]);
                i++;
            }
            token.f18462c = stringBuilder.toString();
            return token;
        }
    }

    @VisibleForTesting
    private void m27082a(boolean z) {
        this.f18470h = z;
    }

    public final ArrayList<Token> m27085a(String str) {
        ArrayList<Token> arrayList = new ArrayList();
        if (!this.f18470h || TextUtils.isEmpty(str)) {
            m27084c();
            return arrayList;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == ' ') {
                if (stringBuilder.length() > 0) {
                    m27081a(stringBuilder, arrayList, i);
                }
            } else if (charAt < 'Ā') {
                if (i != 1 && stringBuilder.length() > 0) {
                    m27081a(stringBuilder, arrayList, i);
                }
                stringBuilder.append(charAt);
                i = 1;
            } else if (charAt < '㐀') {
                if (i != 3 && stringBuilder.length() > 0) {
                    m27081a(stringBuilder, arrayList, i);
                }
                stringBuilder.append(charAt);
                i = 3;
            } else {
                Token a = m27080a(charAt);
                if (a.f18460a == 2) {
                    if (stringBuilder.length() > 0) {
                        m27081a(stringBuilder, arrayList, i);
                    }
                    arrayList.add(a);
                    i = 2;
                } else {
                    if (i != a.f18460a && stringBuilder.length() > 0) {
                        m27081a(stringBuilder, arrayList, i);
                    }
                    i = a.f18460a;
                    stringBuilder.append(charAt);
                }
            }
        }
        if (stringBuilder.length() > 0) {
            m27081a(stringBuilder, arrayList, i);
        }
        return arrayList;
    }

    private static void m27081a(StringBuilder stringBuilder, ArrayList<Token> arrayList, int i) {
        String stringBuilder2 = stringBuilder.toString();
        arrayList.add(new Token(i, stringBuilder2, stringBuilder2));
        stringBuilder.setLength(0);
    }

    private synchronized void m27084c() {
        if (!(this.f18469g || this.f18470h)) {
            this.f18467e.a("HanziToPinyin", "No valid china collator. errorcode=" + this.f18468f);
            this.f18469g = true;
        }
    }
}
