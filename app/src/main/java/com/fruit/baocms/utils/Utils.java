package com.fruit.baocms.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.fruit.baocms.R;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import retrofit.client.Header;
import retrofit.client.Response;


/**
 * Created by Administrator on 2015/11/28.
 */
public class Utils {
    public static final DateFormat DATE_TIME_FORMATER = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static final DateFormat DATE_FORMATER = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.CHINA);
    private static String albumPath = "/DCIM/camera";

    private static final double EARTH_RADIUS = 6378137;

    private static final double DEF_PI = 3.14159265359; // PI
    private static final double DEF_2PI = 6.28318530712; // 2*PI
    private static final double DEF_PI180 = 0.01745329252; // PI/180.0
    private static final double DEF_R = 6370693.5; // radius of earth

    public static boolean isEmpty(String paramString) {
        return (paramString == null) || (paramString.trim().length() <= 0);
    }

    /**
     * @author chenzheng
     * @since 2015-4-9
     * @Description: 加载网络图片
     * @throws
     * @param imageUrl
     * @param imageView
     *            void
     */
    public static void displayImage(Activity activity,String imageUrl, ImageView imageView) {

        Glide.with(activity).load(imageUrl).error(R.mipmap.icon_defult).into(imageView);
//        if (TextUtils.isEmpty(imageUrl)) {
//            imageView.setImageResource(R.mipmap.icon_defult);
//        }
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.icon_defult)
//                .showImageForEmptyUri(R.mipmap.icon_defult)
//                .showImageOnFail(R.mipmap.icon_defult).cacheInMemory(true)
//                .cacheOnDisc(true).build();
//        ImageLoader.getInstance().displayImage(imageUrl, imageView, options);
         // imageUrl代表图片的URL地址，imageView代表承载图片的IMAGEVIEW控件
    }



    /**
     * 检查是否有可用网络
     *
     * @param context
     *            上下文环境
     * @return 有可用网络返回true 否则返回false
     */
    public static boolean isHasNet(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();// 获取联网状态网络
        if (info == null || !info.isAvailable()) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 判断手机号码的长度是否为11位
     *
     * @param number
     * @return
     */
    public static boolean isMobileNumber(String number) {
        number = number.trim();
        return Pattern.matches("^1\\d{10}$", number);
    }

    /**
     * 获取相册的路径
     *
     * @param context
     * @return
     */
    public static File getAlbumFile(Context context) {
        String path;
        if (hasSdcard(context)) {
            path = Environment.getExternalStorageDirectory() + albumPath;
        } else {
            path = Environment.getRootDirectory() + albumPath;
        }

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 判断Sd卡是否存在
     *
     * @param context
     * @return
     */
    public static boolean hasSdcard(Context context) {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

//    /**
//     * @author chenzheng
//     * @since 2015-4-17
//     * @Description: 加载本地图片
//     * @throws
//     * @param path
//     * @param imageView
//     *            void
//     */
//    public static void loadLocalImage(String imagePath, ImageView imageView) {
//        if (isEmpty(imagePath)) {
//            return;
//        }
//        // 显示图片的配置
////		DisplayImageOptions options = new DisplayImageOptions.Builder()
////				.showImageOnLoading(R.drawable.empty_photo)
////				.showImageForEmptyUri(R.drawable.empty_photo)
////				.showImageOnFail(R.drawable.empty_photo).cacheInMemory(true)
////				.cacheOnDisc(true).build();
//
//        String imageUrl = Scheme.FILE.wrap(imagePath);
//
//        //	ImageLoader.getInstance().displayImage(imageUrl, imageView, options);
//    }
//
//    /**
//     * @author chenzheng
//     * @since 2015-4-17
//     * @Description:加载本地图片
//     * @throws
//     * @param imagePath
//     * @param imageView
//     * @param options
//     *            void
//     */
//    public static void loadLocalImage(String imagePath, ImageView imageView,
//                                      DisplayImageOptions options) {
//        if (isEmpty(imagePath)) {
//            return;
//        }
//        String imageUrl = Scheme.FILE.wrap(imagePath);
//
//        ImageLoader.getInstance().displayImage(imageUrl, imageView, options);
//    }
//
//    public static String getAbsoluteImagePath(Context context, Uri uri) {
//        String[] proj = { MediaStore.Images.Media.DATA };
//        Cursor cursor = context.getContentResolver().query(uri, proj, null,
//                null, null);
//
//        int column_index = cursor
//                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//
//        return cursor.getString(column_index);
//    }

    /**
     * @author chenzheng
     * @since 2014-5-9
     * @Description: 获取屏幕宽度
     * @throws
     * @param context
     * @return int
     */
    public static int getScreenW(Context context) {
        return getScreenSize(context, true);
    }

    /**
     * @author chenzheng
     * @since 2014-5-9
     * @Description: 获取屏幕高度
     * @throws
     * @param context
     * @return int
     */
    public static int getScreenH(Context context) {
        return getScreenSize(context, false);
    }

    private static int getScreenSize(Context context, boolean isWidth) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return isWidth ? dm.widthPixels : dm.heightPixels;
    }

    public static String getCookieString(Response response) {
        String cook1 = "";
        boolean isFirst =false;
        for (Header header : response.getHeaders()) {
            if (null!= header.getName() && header.getName().equals("Set-Cookie")) {
                String[] split = header.getValue().split(";");
                if(!isFirst){
                    cook1 = split[0];
                    isFirst = true;
                }else{
                    cook1 = split[0]+";"+cook1;
                }
                Log.e("cook1", cook1);
            }
        }
        return cook1!=null?cook1:null;
    }


//    public static void setBaocmsCookis(String community_id,String ele,boolean isCommunity,boolean isEle){
//        MsgInfos msgInfos = UserInfos.getInstance().loadAccount();
//        if(UserInfos.getInstance().isExist()){
//            Log.e("++++cookie++++", "cookie==11111111111111");
//            if(UserInfos.getInstance().loadAccount().cookie == null){
//                if(!Utils.isEmpty(community_id)){
//                    Global.Dingwei_Cookie = Global.Dingwei_Cookie+";"+community_id.trim();
//                    Log.e("++++cookie++++", "cookie==dw" + Global.Dingwei_Cookie);
//                }
//                if(!Utils.isEmpty(ele)){
//                    Global.Dingwei_Cookie = Global.Dingwei_Cookie+";"+ele.trim();
//                }
//            }else{
//                String[] cookie_str = msgInfos.cookie.split(";");
//                for(int i=0;i<cookie_str.length;i++){
//                    if( cookie_str[i].trim().startsWith("community_id")){
//                        isCommunity = true;
//                    }else if(cookie_str[i].trim().startsWith("ele")){
//                        isEle = true;
//                    }
//                }
//                if(!isCommunity){
//                    Log.e("++++cookie000++++", "msgInfos.cookie==" + msgInfos.cookie);
//                    if(!Utils.isEmpty(community_id)){
//                        msgInfos.cookie = msgInfos.cookie+";"+community_id.trim();
//                        UserInfos.getInstance().saveAccount(msgInfos);
//                        Log.e("++++cookie000++++", "community_id==" + community_id);
//                        Log.e("++++cookie111++++", "cookie==" + UserInfos.getInstance().loadAccount().cookie);
//                    }
//
//
//
//                }
//                if(!isEle){
//                    if(!Utils.isEmpty(ele)){
//                        msgInfos.cookie = msgInfos.cookie+";"+ele.trim();
//                        UserInfos.getInstance().saveAccount(msgInfos);
//                        Log.e("++++cookie000++++", "community_id==" + community_id);
//                        Log.e("++++cookie111++++", "cookie==" + UserInfos.getInstance().loadAccount().cookie);
//                    }
//                }
//            }
//        }else{
//            Log.e("++++cookie++++", "cookie==22222222");
//            if(Global.Cookie==null){
//                if(!Utils.isEmpty(community_id)){
//                    Global.Dingwei_Cookie = Global.Dingwei_Cookie+";"+community_id.trim();
//                    Log.e("++++cookie++++", "cookie==dw1" + Global.Dingwei_Cookie);
//                }
//                if(!Utils.isEmpty(ele)){
//                    Global.Dingwei_Cookie = Global.Dingwei_Cookie+";"+ele.trim();
//                }
//            }else{
//                String[] cookie_str = Global.Cookie.split(";");
//                for(int i=0;i<cookie_str.length;i++){
//                    if( cookie_str[i].trim().startsWith("community_id")){
//                        isCommunity = true;
//                    }else if(cookie_str[i].trim().startsWith("ele")){
//                        isEle = true;
//                    }
//                }
//                if(!isCommunity){
//                    if(!Utils.isEmpty(community_id)){
//                        Global.Cookie = Global.Cookie+";"+community_id.trim();
//                        Log.e("++++cookie++++", "cookie==" + Global.Cookie);
//                    }
//                }
//                if(!isEle){
//                    if(!Utils.isEmpty(ele)){
//                        Global.Cookie = Global.Cookie+";"+ele.trim();
//                    }
//                }
//            }
//        }
//    }



//    public static String getLoginCookieString(Response response) {
//        String cook1 = "";
//        boolean isFirst =false;
//        for (Header header : response.getHeaders()) {
//            if (null!= header.getName() && header.getName().equals("Set-Cookie")) {
//                String[] split = header.getValue().split(";");
//                Global.token = split[0].split("=")[1];
//                if(!isFirst){
//                    cook1 =split[0]+";" +Global.Dingwei_Cookie ;
//                    Log.e("BaoCMSApplication", Global.Dingwei_Cookie + "");
//                    isFirst = true;
//                }else{
//                    Log.e("BaoCMS+split[0]", split[0]);
//                    cook1 = split[0]+";"+cook1;
//                }
//            }
//        }
//        return cook1!=null?cook1:null;
//    }


    public static void synCookies(Context context, String url,String cookies) {

        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
      //  cookieManager.removeSessionCookie();//移除
        String[] split = cookies.split(";");//返回:{"1","2.3","","4"}
        for (int i = 0; i < split.length; i++) {
            String cookie = split[i] + ";domain=www.baocms.cn;path=/;isSecure=FALSE";
      //   String cookie = split[i] + ";domain=2799860106.ijianghu.net;path=/;isSecure=FALSE";
        //    String cookie = split[i] + ";domain=lvshequ.net;path=/;isSecure=FALSE";
            cookieManager.setCookie(url, cookie);
        }
        CookieSyncManager.getInstance().sync();

    }

    public static void removeCookies(Context context) {

        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();//移除
        CookieSyncManager.getInstance().sync();
    }

    public static void delay(int ms){
        try {
            Thread.currentThread();
            Thread.sleep(ms);
    //        ProgressHUD.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将字符串转换成整形，如果格式错误，将转成0
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        if (Utils.isEmpty(str)) {
            return 0;
        }

        str = str.trim();
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {

        }
        return i;
    }

    /**
     * 将字符串转换成浮点型，如果格式错误，将转成0
     *
     * @param str
     * @return
     */
    public static float toFloat(String str) {
        if (Utils.isEmpty(str)) {
            return 0;
        }

        str = str.trim();
        float i = 0;
        try {
            i = Float.parseFloat(str);
        } catch (Exception e) {

        }
        return i;
    }

    /**
     * 格式化时间
     *
     * @param timeStamp
     * @param format
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String convertDate(long timeStamp, String format) {
        if (Utils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String newDate = sdf.format(new Date(timeStamp * 1000L));

        return newDate;
    }

    /**
     * @author chenzheng
     * @since 2014-5-26
     * @Description: 将时间戳转化为时间字符串
     * @throws
     * @param timeStamp
     * @param format
     *            yyyy-MM-dd HH:mm:ss
     * @return String
     */
    @SuppressLint("SimpleDateFormat")
    public static String convertDate(String timeStamp, String format) {
        if (Utils.isEmpty(timeStamp)) {
            return "";
        }
        if (Utils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long lcc_time = Long.valueOf(timeStamp);
        String newDate = sdf.format(new Date(lcc_time * 1000L));

        return newDate;
    }

    /**
     * @author liyong
     * @since 2015-11-11
     * @Description: 将时间字符串转化为时间戳
     * @throws
     * @param format
     *            yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String convertTime(String selectTime,String format){
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date day = null;
        try {
            day = sdf.parse(selectTime);
            long l = day.getTime();
            String time = String.valueOf(l);
            re_time = time.substring(0,10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }

    /**
     * @author liyong
     * @since 2015-11-11
     * @Description: 获取系统当前时间的日期等
     * @throws
     * @return String
     */
    public static String currentDate(String Time){

        Calendar c = Calendar.getInstance();
        if(Time.equals("year")){
            int year = c.get(Calendar.YEAR);
            String currentYear = String.valueOf(year);
            return currentYear;
        }else if(Time.equals("month")){
            int month = c.get(Calendar.MONTH)+1;
            String currentMonth = String.valueOf(month);
            return currentMonth;
        }else if(Time.equals("day2")){  //  一个月中的第几天
            int day2 = c.get(Calendar.DAY_OF_MONTH);
            String currentDay = String.valueOf(day2);
            return currentDay;
        }else if(Time.equals("hour")){  // 24小时制下的小时数，午夜表示为0
            int hour = c.get(Calendar.HOUR_OF_DAY);
            String currentHour = String.valueOf(hour);
            return currentHour;
        }else if(Time.equals("data")){  // 当前日期 ，返回0 为星期天
            int hour = c.get(Calendar.DAY_OF_WEEK)-1;
            String currentData = String.valueOf(hour);
            return currentData;
        }else {
            int minute = c.get(Calendar.MINUTE);
            String currentMinute = String.valueOf(minute);
            return currentMinute;
        }
    }

    /**
     * 输入框清除图标的处理
     *
     * @param text
     * @param icon
     */
    public static void inputClear(final EditText text, final ImageView icon) {

        text.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String str = text.getText().toString();
                icon.setVisibility(hasFocus && str.length() > 0 ? View.VISIBLE
                        : View.GONE);
            }
        });

        text.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                String str = text.getText().toString();
                icon.setVisibility(str.length() > 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });

        icon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离：单位为米
     */
    public static double DistanceOfTwoPoint(double lat1, double lng1,
                                             double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    /**
     * 根据List<points>集合经纬度坐标（double值），计算两点间距离List<int>集合</>，

     * @return 距离：单位为米
     */
//    public static Data minDistance(List<Data> datas,double lat, double lng) {
//        Data item = null;
//        List<Double> list = new ArrayList<Double>();
//        for(int i = 0 ; i< datas.size();i++){
//            Data  data = datas.get(i);
//            Double range = getDistance(data.lng, data.lat, lng, lat);
//            list.add(data.range);
//            if(data.range == Collections.min(list)){
//                item = data;
//            }
//        }
//        return item;
//    }

    public static double getDistance(double lat1,double lon1,
                                     double lat2, double lon2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;


    }




    // public static synchronized MapDistance getInstance(){
    // if(instance == null){
    // instance = new MapDistance();
    // }
    // return instance;
    // }
    /**
     * 返回为m，适合短距离测量
     *
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static String getShortDistance(double lon1, double lat1,
                                          double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return trans(distance);
    }

    /**
     * 返回为m,适合长距离测量
     *
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static String getLongDistance(double lon1, double lat1, double lon2,
                                         double lat2) {
        double ew1, ns1, ew2, ns2;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 求大圆劣弧与球心所夹的角(弧度)
        distance = Math.sin(ns1) * Math.sin(ns2) + Math.cos(ns1)
                * Math.cos(ns2) * Math.cos(ew1 - ew2);
        // 调整到[-1..1]范围内，避免溢出
        if (distance > 1.0)
            distance = 1.0;
        else if (distance < -1.0)
            distance = -1.0;
        // 求大圆劣弧长度
        distance = DEF_R * Math.acos(distance);
        return trans(distance);
    }

    public static String trans(double distance) {
        boolean isBig = false; // 是否为大于等于1000m
        if (distance >= 1000) {
            distance /= 1000;
            isBig = true;
        }
        return (new DecimalFormat(".00").format(distance))
                + (isBig ? "千米" : "米");
    }


}
