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


    public static ArrayList<MenuBean> getMenu(Context mContext,
                                              String whichCheck) {
        ArrayList<MenuBean> menuBeans = new ArrayList<MenuBean>();
        MenuBean menuBean = new MenuBean();
        //個人中心
        menuBean.setId("1");
        if (whichCheck.equals("1"))
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_1));
        menuBeans.add(menuBean);

        //首頁
        menuBean = new MenuBean();
        menuBean.setId("2");
        if (whichCheck.equals("2"))
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_2));
        menuBeans.add(menuBean);

        //圈子
        menuBean = new MenuBean();
        menuBean.setId("3");
        if (whichCheck.equals("3"))
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_3));
        menuBeans.add(menuBean);

        //好友
        menuBean = new MenuBean();
        menuBean.setId("4");
        if (whichCheck.equals("4"))
            menuBean.setCheck(true);
        else
            menuBean.setCheck(false);
        menuBean.setTitle(mContext.getResources().getString(
                R.string.menu_title_4));
        menuBeans.add(menuBean);

        //设置
        menuBean = new MenuBean();
        menuBean.setId("5");
        if (whichCheck.equals("5"))
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
                    R.string.menu_title_1));
            noteInfoBeans.add(noteInfoBean);
        }

        return  noteInfoBeans;
    }

}