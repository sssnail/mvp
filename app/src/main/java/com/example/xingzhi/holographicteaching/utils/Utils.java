package com.example.xingzhi.holographicteaching.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xingzhi.holographicteaching.R;
import com.example.xingzhi.holographicteaching.view.WarpLinearLayout;
import com.tencent.mmkv.MMKV;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String TAG = "Utils";
    public static String TOKEN = "";
    public static int SUCCESS_CODE = 200;
    public static String SMS_LOGIN = "login";
    public static String SMS_REG = "reg";
    public static String SMS_BIND = "SMS_BIND";
    public static String SMS_UNBIND = "SMS_UNBIND";
    public static String SMS_CHANGE = "SMS_CHANGE";
    public static String SMS_VERIFY = "SMS_VERIFY";
    public static String SMS_PWD = "pwd";
    public static String SMS_IFFORGOT = "iforgot";
    public static String time = "TIME";

    public static String getToken() {
        return TOKEN;
    }

    public static void setToken(String token) {
        TOKEN = token;
    }

    public static MMKV getMMKV(){
        return MMKV.defaultMMKV();
    }

    public static void startCodeTime(final Context context, final Button button, final Handler handler, int time) {
        button.setTag(time);
        if (time <= 0) {
            button.setText(StringUtils.getString(context, R.string.get_verifycode));
            button.setClickable(true);
            return;
        } else {
            button.setClickable(false);
            button.setText("重新获取("+time + "s)");
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // int delayTime = (int) yun_sdk_btn_mRegisterSendCode.getTag();
                int delayTime = Integer.parseInt(button.getTag().toString());
                startCodeTime(context, button,handler, --delayTime);
            }
        }, 1000);
    }

    public static void setInputEtShowIconListener(final EditText editText, final ImageView imageView){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText.getText().length() >0 ){
                    imageView.setVisibility(View.VISIBLE);
                }else {
                    imageView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    public static class TextChangedListener3 implements TextWatcher{
        private EditText et1, et2, et3;
        private Button button;
        private static boolean isChecked;
        public TextChangedListener3(EditText et1,EditText et2,EditText et3,Button button) {
            this.et1 = et1;
            this.et2 = et2;
            this.et3 = et3;
            this.button = button;
            et1.addTextChangedListener(this);
            et2.addTextChangedListener(this);
            et3.addTextChangedListener(this);
        }
        public static void setCheck(boolean flag){
            isChecked = flag;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            button.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if ( !( TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString()) || TextUtils.isEmpty(et3.getText().toString()) || !isChecked) ){
                button.setEnabled(true);
            }
        }
    }

    public static class TextChangedListener2 implements TextWatcher{
        private EditText et1, et2;
        private Button button;
        public TextChangedListener2(EditText et1,EditText et2,Button button) {
            this.et1 = et1;
            this.et2 = et2;
            this.button = button;
            et1.addTextChangedListener(this);
            et2.addTextChangedListener(this);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            button.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if ( !( TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString())  ) ){
                button.setEnabled(true);
            }
        }
    }
    public static class TextChangedListener4 implements TextWatcher{
        private EditText et1, et2, et3, et4;
        private Button button;
        private static boolean isChecked;
        public TextChangedListener4(EditText et1,EditText et2,EditText et3,EditText et4,Button button) {
            this.et1 = et1;
            this.et2 = et2;
            this.et3 = et3;
            this.et4 = et4;
            this.button = button;
            et1.addTextChangedListener(this);
            et2.addTextChangedListener(this);
            et3.addTextChangedListener(this);
            et4.addTextChangedListener(this);
        }
        public static void setCheck(boolean flag){
            isChecked = flag;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            button.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if ( !( TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString()) || TextUtils.isEmpty(et3.getText().toString()) ||  TextUtils.isEmpty(et4.getText().toString()) || !isChecked) ){
                button.setEnabled(true);
            }
        }
    }

    public static void setInputPwdStatus(boolean showPwd, EditText et, ImageView iv){
        if (!showPwd){
            et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            iv.setImageResource(R.drawable.ic_pwd_invisible);
        }else {
            et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            iv.setImageResource(R.drawable.ic_pwd_visible);
        }
    }

    public static String getImageUrl(){
        return "https://oimageb4.ydstatic.com/image?id=-2318081738758928284&product=adpublish&w=520&h=347";
    }

    public static void createTvLabels(Context context, LinearLayout layout, List<String> lists){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < lists.size(); i++) {
            TextView textView = new TextView(context);
            layoutParams.setMargins(0, 5, 10, 5);
            textView.setTextSize(12);
            textView.setBackgroundResource(R.drawable.bg_blue_item); //设置背景
            textView.setText(lists.get(i).toString());
            textView.setTextColor(context.getColor(R.color.colorWhite));
            textView.setTextSize(11);
            textView.setLayoutParams(layoutParams);
            layout.addView(textView);
        }
    }

    public static List<String> getLabels(){
        List<String> strings = new ArrayList<>();
        for (int i = 0; i<3; i++){
            strings.add("传奇");
        }
        return strings;
    }

    public static void ScrollViewLayout(final Context context, final List<String> list, WarpLinearLayout lay_gallery) {//List<LinkedTreeMap<String, Object>> list
        lay_gallery.removeAllViews();
        LayoutInflater mInflater = LayoutInflater.from(context);
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                final View view = mInflater.inflate(R.layout.item_hot_search, lay_gallery, false);//添加的view,这里很简单就是一个TextView
                final TextView tv_search_tag_name = (TextView) view.findViewById(R.id.tv);
                tv_search_tag_name.setText(list.get(i));
                final int finalI = i;
                tv_search_tag_name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //处理点击事件
                        Toast.makeText(context, list.get(finalI).toString(), Toast.LENGTH_SHORT).show();
                    }
                });


                lay_gallery.addView(view);
            }
        }
    }

    public static final String DefaultAccount = "a";





}
