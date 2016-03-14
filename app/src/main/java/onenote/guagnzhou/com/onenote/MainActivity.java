package onenote.guagnzhou.com.onenote;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import onenote.guagnzhou.com.onenote.adapter.MenuAdapter;
import onenote.guagnzhou.com.onenote.config.ConstantsConfig;
import onenote.guagnzhou.com.onenote.fragments.HomePageFragment;
import onenote.guagnzhou.com.onenote.fragments.LoginFragment;
import onenote.guagnzhou.com.onenote.model.MenuBean;
import onenote.guagnzhou.com.onenote.utils.CommonUtils;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.mFrameLayout)
    FrameLayout mFrameLayout;
    @Bind(R.id.mListvMenu)
    ListView mListvMenu;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.left_drawer)
    LinearLayout leftDrawer;
    @Bind(R.id.btn_home)
    ImageButton btnHome;
    @Bind(R.id.text_title_little)
    TextView textTitleLittle;
    @Bind(R.id.btn_back)
    ImageButton btnBack;
    @Bind(R.id.layout_top)
    LinearLayout layoutTop;
    @Bind(R.id.ll_all)
    LinearLayout llAll;

    private Context mContext;
    private MenuAdapter menuAdapter;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    private HomePageFragment homePageFragment;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationfragment_main);
        ButterKnife.bind(this);
        mContext = this;
        CommonUtils.initSystemBar((Activity) mContext);
        initMenu();
        initHomePageFragment();

    }

    private void initHomePageFragment() {
        fragmentManager = getSupportFragmentManager();
        setTabSelection(1);//首頁
    }

    private void initMenu() {

        drawerLayout.closeDrawer(leftDrawer);
        menuAdapter = new MenuAdapter(mContext, ConstantsConfig.getMenu(
                mContext, "1"), mListvMenu);
        mListvMenu.setAdapter(menuAdapter);
        ConstantsConfig.toClickContext = this;
        mListvMenu
                .setOnItemClickListener(new MenuListItemClickListener());

    }


    @OnClick(R.id.btn_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                drawerLayout.openDrawer(leftDrawer);
                break;
        }
    }

    /**
     *  侧边栏点击事件
     **/
    public  class MenuListItemClickListener implements
            AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View arg1,
                                int position, long arg3) {
            MenuBean menuBean = (MenuBean) adapterView
                    .getItemAtPosition(position);
            if (menuBean.getId().equals("1")) {
                setTabSelection(0);
            } else if (menuBean.getId().equals("2")) {
                setTabSelection(1);
            }

        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        drawerLayout.closeDrawer(leftDrawer);
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (loginFragment == null) {
                    loginFragment = new LoginFragment();
                    transaction.add(R.id.mFrameLayout, loginFragment);
                } else {
                    transaction.show(loginFragment);
                }
                break;

            case 1:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    transaction.add(R.id.mFrameLayout, homePageFragment);
                } else {
                    transaction.show(homePageFragment);
                }
                break;

        }
        transaction.commit();
    }

}
