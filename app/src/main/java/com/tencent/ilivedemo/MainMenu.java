package com.tencent.ilivedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tencent.customstream.CameraActivity;
import com.tencent.qcloud.suixinbo.adapters.LiveShowAdapter;
import com.tencent.qcloud.suixinbo.views.LoginActivity;
import com.tencent.tdemofm.channelActivity;
import com.tencent.tdemolive.LiveActivity;
import com.tencent.tdemovideocall.ContactActivity;

import java.util.ArrayList;

import cn.jx.tdemoliveshow.LiveshowActivity;

/**
 * 示例菜单
 */
public class MainMenu extends Activity {
    private ListView lvMenu;

    private LinearLayout llLogin, llMain;
    private EditText etId;
    private TextView tvId;
    private ArrayAdapter adapterDemo;
    private ArrayList<String> listDemo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainmenu);
        llLogin = (LinearLayout) findViewById(R.id.ll_login);
        llMain = (LinearLayout) findViewById(R.id.ll_main);
        etId = (EditText) findViewById(R.id.et_id);
        tvId = (TextView) findViewById(R.id.tv_id);
        lvMenu = (ListView) findViewById(R.id.lv_menu);

        listDemo.add("VideoCall: 双人视频");
        listDemo.add("Live: 直播");
        listDemo.add("Suixinbo:新随心播");
        //listDemo.add("FM: 广播电台");
        //listDemo.add("LiveShow: 播放特性展示");
        //listDemo.add("CustomStream: 自定义输入");
        adapterDemo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                listDemo);
        lvMenu.setAdapter(adapterDemo);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();

                switch (position) {
                    case 0:
                        intent.setClass(MainMenu.this, ContactActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainMenu.this, LiveActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainMenu.this, LoginActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainMenu.this, channelActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainMenu.this, LiveshowActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainMenu.this, CameraActivity.class);
                        break;
                }

                startActivity(intent);
            }
        });
    }

}
