package com.haoran.baseutils;

import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class ViewUtils {

    public static void makeRadioButtonWithGroup(@Nullable RadioButton defaultSelect, final SimpleListener<RadioButton> listener, final RadioButton... radioButtons) {
        if (radioButtons == null || radioButtons.length == 0) {
            return;
        }
        for (RadioButton radioButton : radioButtons) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (listener != null) {
                            listener.onAction((RadioButton) buttonView);
                        }
                        for (RadioButton button : radioButtons) {
                            if (button.getId() != buttonView.getId()) {
                                button.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
        for (RadioButton radioButton : radioButtons) {
            if (defaultSelect == null){
                radioButton.setChecked(false);
            } else {
                if (radioButton.getId() == defaultSelect.getId()) {
                    radioButton.setChecked(true);
                    break;
                }
            }
        }
    }

    public interface SimpleListener<E>{
        void onAction(E data);
    }
}
