package com.example.xingzhi.holographicteaching.net;

import com.example.xingzhi.holographicteaching.bean.AuthResultBean;
import com.example.xingzhi.holographicteaching.bean.BaseResultBean;
import com.example.xingzhi.holographicteaching.bean.CenterResultBean;
import com.example.xingzhi.holographicteaching.bean.ChangeBindResultBean;
import com.example.xingzhi.holographicteaching.bean.HotKeyResultBean;
import com.example.xingzhi.holographicteaching.bean.LoginResultBean;
import com.example.xingzhi.holographicteaching.bean.MainModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @explain
 */
public interface ApiStores {

    //baseUrl
    String API_SERVER_URL = "https://www.weather.com.cn/";
    String API_SERVER = "http://dev.api-yeb.8688sdk.com/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<MainModel> loadDataByRetrofit(@Path("cityId") String cityId);

    //发送短信验证码
//    @POST("smsCode")
//    Observable<BaseResultBean> SendMsmRequest(@Body Map<String, String> map);
    //发送短信验证码
    @FormUrlEncoded
    @POST("smsCode")
    Observable<BaseResultBean> SendMsmRequest(@Field("mobile") String mobile, @Field("type") String type);

    //密码或短信验证码登录
    @FormUrlEncoded
    @POST("login")
    Observable<LoginResultBean> LoginRequest(@Field("user_name") String user_name, @Field("password") String password, @Field("code") String code);

    //短信验证码登录 user_name  code
    @FormUrlEncoded
    @POST("login")
    Observable<LoginResultBean> SmsLoginRequest(@Field("user_name") String user_name,  @Field("code") String code);

    //账号登录 user_name  pwd
    @FormUrlEncoded
    @POST("login")
    Observable<LoginResultBean> LoginRequest(@Field("user_name") String user_name,  @Field("password") String password);

    //用户注册
    @FormUrlEncoded
    @POST("register")
    Observable<LoginResultBean> RegistRequest(@Field("user_name") String user_name, @Field("code") String code, @Field("password") String password, @Field("invite_code") String invite_code);

    //忘记密码修改
    @FormUrlEncoded
    @POST("api/user/forgot")
    Observable<BaseResultBean> ForgotPwdRequest(@Field("mobile") String mobile, @Field("password") String password, @Field("code") String code);

    //修改密码 需要登录
    @FormUrlEncoded
    @POST("api/user/resetPwd")
    Observable<BaseResultBean> ResetPwdRequest( @Field("code") int code, @Field("password") String password);

    //个人中心用户基本信息
    @POST("api/user/center")
    Observable<CenterResultBean> CenterRequest();

    //用户换绑手机验证原手机 需要登录
    @FormUrlEncoded
    @POST("api/verify/change")
    Observable<ChangeBindResultBean> VerifyChangeRequest(@Field("code") int code);

    //换绑手机发送短信验证码
    @FormUrlEncoded
    @POST("smsCode")
    Observable<ChangeBindResultBean> SendBindMsmRequest(@Field("mobile") String mobile, @Field("type") String type);

    //用户换绑手机号，换绑成功记得更新本地缓存数据 需要登录
    @FormUrlEncoded
    @POST("api/change/mobile")
    Observable<ChangeBindResultBean> BindMobileRequest(@Field("mobile") String mobile, @Field("code") int code, @Field("token") String token);

    //用户实名认证 需要登录
    @FormUrlEncoded
    @POST("api/user/auth")
    Observable<AuthResultBean> AuthRequest(@Field("real_name") String real_name, @Field("idcard") String idcard);

    //用户实名认证 需要登录
    @FormUrlEncoded
    @POST("api/vip/index")
    Observable<AuthResultBean> VipIndexRequest(@Field("real_name") String real_name, @Field("idcard") String idcard);

    //用户实名认证 需要登录
    @POST("api/search/hotKeyword")
    Observable<HotKeyResultBean> HotKeywordRequest();




}
