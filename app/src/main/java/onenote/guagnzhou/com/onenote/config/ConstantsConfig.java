package onenote.guagnzhou.com.onenote.config;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import onenote.guagnzhou.com.onenote.R;
import onenote.guagnzhou.com.onenote.model.MenuBean;
import onenote.guagnzhou.com.onenote.model.NoteInfoBean;


public class ConstantsConfig {
    public static Context toClickContext;
    public static int FRAGMENT_PERSONAL = 1;
    public static int FRAGMENT_HOMEPAGE = 2;
    public static int FRAGMENT_CIRCLE = 3;
    public static int FRAGMENT_FRIEND = 4;
    public static int FRAGMENT_SETTING = 5;

    public static int FRAGMENT_LOGIN = 11;
    public static int FRAGMENT_REGISTER = 111;

    public static ArrayList<MenuBean> getMenu(Context mContext,
                                              int whichCheck) {
        ArrayList<MenuBean> menuBeans = new ArrayList<MenuBean>();
        MenuBean menuBean = new MenuBean();
        //個人中心
        menuBean.setId(FRAGMENT_PERSONAL);
        if (whichCheck==FRAGMENT_PERSONAL)
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_1));
        menuBeans.add(menuBean);

        //首頁
        menuBean = new MenuBean();
        menuBean.setId(FRAGMENT_HOMEPAGE);
        if (whichCheck==FRAGMENT_HOMEPAGE)
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_2));
        menuBeans.add(menuBean);

        //圈子
        menuBean = new MenuBean();
        menuBean.setId(FRAGMENT_CIRCLE);
        if (whichCheck==FRAGMENT_CIRCLE)
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_3));
        menuBeans.add(menuBean);

        //好友
        menuBean = new MenuBean();
        menuBean.setId(FRAGMENT_FRIEND);
        if (whichCheck==FRAGMENT_FRIEND)
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_4));
        menuBeans.add(menuBean);

        //设置
        menuBean = new MenuBean();
        menuBean.setId(FRAGMENT_SETTING);
        if (whichCheck==FRAGMENT_SETTING)
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_5));
        menuBeans.add(menuBean);

        return menuBeans;
    }

    public static ArrayList<NoteInfoBean> getNoteInfo(Context mContext) {
        ArrayList<NoteInfoBean> noteInfoBeans = new ArrayList<NoteInfoBean>();
        NoteInfoBean noteInfoBean = new NoteInfoBean();

        for(int i = 0;i<20;i++){
            noteInfoBean.setId(i+"");
            noteInfoBean.setType(i);
            noteInfoBean.setTitle(mContext.getResources().getString(
                    R.string.homeadapter_title));
            noteInfoBeans.add(noteInfoBean);
        }

        return  noteInfoBeans;
    }

}