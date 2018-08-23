package net.slipp.kotlin.stalk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.slipp.kotlin.stalk.R;
import net.slipp.kotlin.stalk.adapter.JMainUserAdapter;
import net.slipp.kotlin.stalk.listener.JOnItemClickListener;
import net.slipp.kotlin.stalk.utils.JConst;
import net.slipp.kotlin.stalk.vo.JMember;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JFriendListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    JMainUserAdapter mainUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        List<JMember> memberList = new ArrayList<>();
        memberList.add(new JMember("flower","엄마"));
        memberList.add(new JMember("pureYoon","절친"));
        memberList.add(new JMember("impactyoung","혜영이"));
        memberList.add(new JMember("minStar","남자친구"));
        memberList.add(new JMember("elel","과장님"));
        memberList.add(new JMember("rwylaskdf","사수"));
        memberList.add(new JMember("pjl","동기"));
        mainUserAdapter = new JMainUserAdapter(this, memberList, new JOnItemClickListener() {
            @Override
            public void onItemClickPosition(Object object) {
                Intent mainIntent = new Intent();
                JMember member = (JMember) object;
                mainIntent.putExtra(JConst.BUNDLE_MEMBER, member.getNickName());
                setResult(Activity.RESULT_OK, mainIntent);
                finish();
            }
        });
        recyclerView.setAdapter(mainUserAdapter);
    }
}
