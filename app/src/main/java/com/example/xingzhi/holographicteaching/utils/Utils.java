package com.example.xingzhi.holographicteaching.utils;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.xingzhi.holographicteaching.R;

public class Utils {

    private static final String TAG = "Utils";

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





}
