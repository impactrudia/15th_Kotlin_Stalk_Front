package net.slipp.kotlin.stalk.popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.TextView;

import net.slipp.kotlin.stalk.R;
import net.slipp.kotlin.stalk.listener.JOnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JAlertPopup extends Dialog {

    @BindView(R.id.editMsg)
    TextInputEditText editMsg;
    @BindView(R.id.layout_id)
    TextInputLayout layoutId;
    @BindView(R.id.btnNegative)
    TextView btnNegative;
    @BindView(R.id.btnPositive)
    TextView btnPositive;

    JOnItemClickListener clickPositive;
    JOnItemClickListener clickNegative;

    String strPositive;
    String strNegative;
    String message;

    public JAlertPopup(Context context, String message, String strPositive, JOnItemClickListener clickPositive, String strNegative, JOnItemClickListener clickNegative) {
        super(context, R.style.AppPopupTheme);

        this.message = message;
        this.strPositive = strPositive;
        this.strNegative = strNegative;
        this.clickPositive = clickPositive;
        this.clickNegative = clickNegative;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);

        if (message != null) {
            editMsg.setText(message);
            editMsg.requestFocus(message.length());
        }

        if (strNegative == null) {
            btnNegative.setVisibility(View.GONE);
        } else {
            btnNegative.setText(strNegative);
            btnNegative.setVisibility(View.VISIBLE);
        }

        if (strPositive == null) {
            btnPositive.setVisibility(View.GONE);
        } else {
            btnPositive.setText(strPositive);
            btnPositive.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.btnPositive)
    void onClickPositive() {
        if (clickPositive != null) {
            clickPositive.onItemClickPosition(editMsg.getText().toString());
        }
        dismiss();
    }

    @OnClick(R.id.btnNegative)
    void onClickNegative() {
        if (clickNegative != null) {
            clickNegative.onItemClickPosition(editMsg.getText().toString());
        }
        dismiss();
    }

    public static void showPopup(Context context, String message, String btn, JOnItemClickListener listener, String negativeBtn, JOnItemClickListener negativeListener) {
        new JAlertPopup(context, message, btn, listener, negativeBtn, negativeListener).show();
    }

}
