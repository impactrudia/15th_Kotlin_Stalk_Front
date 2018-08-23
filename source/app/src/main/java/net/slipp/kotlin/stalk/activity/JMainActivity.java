package net.slipp.kotlin.stalk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.slipp.kotlin.stalk.R;
import net.slipp.kotlin.stalk.listener.JOnItemClickListener;
import net.slipp.kotlin.stalk.popup.JAlertPopup;
import net.slipp.kotlin.stalk.utils.JConst;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JMainActivity extends AppCompatActivity {

    @BindView(R.id.tvMainTitle)
    TextView tvMainTitle;
    @BindView(R.id.tvCircleMainSide1)
    TextView tvCircleMainSide1;
    @BindView(R.id.tvCircleMainSide2)
    TextView tvCircleMainSide2;
    @BindView(R.id.tvCircleMainSide3)
    TextView tvCircleMainSide3;
    @BindView(R.id.tvCircleMainSide4)
    TextView tvCircleMainSide4;
    @BindView(R.id.tvCircleMainSide5)
    TextView tvCircleMainSide5;
    @BindView(R.id.tvCircleMainSide6)
    TextView tvCircleMainSide6;
    @BindView(R.id.tvCircleMainSide7)
    TextView tvCircleMainSide7;
    @BindView(R.id.tvCircleMainSide8)
    TextView tvCircleMainSide8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tvCircleMainSide2.setText("전화줘");
        tvCircleMainSide3.setVisibility(View.INVISIBLE);
        tvCircleMainSide4.setVisibility(View.INVISIBLE);
        tvCircleMainSide5.setVisibility(View.INVISIBLE);
        tvCircleMainSide6.setVisibility(View.INVISIBLE);
        tvCircleMainSide7.setVisibility(View.INVISIBLE);
        tvCircleMainSide8.setVisibility(View.INVISIBLE);

        tvCircleMainSide3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                JAlertPopup.showPopup(JMainActivity.this, tvCircleMainSide3.getText().toString(),
                        getString(R.string.delete),
                        new JOnItemClickListener() {
                            @Override
                            public void onItemClickPosition(Object object) {
                                tvCircleMainSide3.setVisibility(View.INVISIBLE);
                                Toast.makeText(JMainActivity.this, getString(R.string.msg_delete), Toast.LENGTH_SHORT).show();
                            }
                        },
                        getString(R.string.update),
                        new JOnItemClickListener() {
                            @Override
                            public void onItemClickPosition(Object object) {
                                tvCircleMainSide3.setText((String) object);
                            }
                        });
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            tvMainTitle.setText(data.getStringExtra(JConst.BUNDLE_MEMBER));
        }
    }

    @OnClick({R.id.layoutMainCenter, R.id.tvCircleMainSide1, R.id.tvCircleMainSide2, R.id.tvCircleMainSide3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutMainCenter:
                Intent i = new Intent(this, JFriendListActivity.class);
                startActivityForResult(i, 1);
                break;
            case R.id.tvCircleMainSide1:
                addMessage();
                break;
            case R.id.tvCircleMainSide2:
                Toast.makeText(this, getString(R.string.msg_success_send_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvCircleMainSide3:
                break;
        }
    }

    public void addMessage(){
        JAlertPopup.showPopup(JMainActivity.this, null, getString(R.string.register), new JOnItemClickListener() {
            @Override
            public void onItemClickPosition(Object object) {
                tvCircleMainSide3.setText((String)object);
                tvCircleMainSide3.setVisibility(View.VISIBLE);
            }
        }, null, null);
    }
}
