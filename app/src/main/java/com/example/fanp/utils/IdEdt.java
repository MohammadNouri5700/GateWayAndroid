package com.example.fanp.utils;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdEdt extends androidx.appcompat.widget.AppCompatEditText {

    public boolean valid = false;

    private Pattern pattern;
    private Matcher matcher;


    private static final String Name_PATTERN = "^[_A-Za-z0-9-]";


    @Override
    public void setTag(Object tag) {
        super.setTag(tag);
    }

    @Override
    public Object getTag() {
        return super.getTag();
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //YOUR CODE
            String ss= "";
            if (s.toString().equals("")){
                s = new autoIdEdt().gen();
            }
            //        setText(new autoIdEdt().gen(), TextView.BufferType.EDITABLE);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //YOUR CODE
            String ss= "";
            if (s.toString().equals("")){
                s = new autoIdEdt().gen();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().equals("")){
                setText(new autoIdEdt().gen());
                return;
            }
            String ss= "";
            String outputedText = s.toString();
            if (outputedText.length() < 64 && outputedText.length() > 2) {
                if (validate(outputedText))
                    valid = (true);
            } else {
                valid = false;
            }

        }
    };

    public IdEdt(@NonNull Context context) {
        super(context);
        addTextChangedListener(watcher);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setText(new autoIdEdt().gen(), TextView.BufferType.EDITABLE);
            }
        }, 10);

        setEnabled(false);
        setFocusable(false);
    }

    public IdEdt(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(watcher);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setText(new autoIdEdt().gen(), TextView.BufferType.EDITABLE);
            }
        }, 10);

        setEnabled(false);
        setFocusable(false);

    }

    public IdEdt(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTextChangedListener(watcher);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setText(new autoIdEdt().gen(), TextView.BufferType.EDITABLE);

            }
        }, 10);

        setEnabled(false);
        setFocusable(false);

    }

    public boolean validate(final String hex) {

        Pattern pattern = Pattern.compile(Name_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        if (matcher.find()) {
            return true;
        } else {
            return false;
            // TODO handle condition when input doesn't have an email address
        }

    }


}
