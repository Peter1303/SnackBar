package com.widget.snackbar;

import java.util.List;
import android.graphics.Color;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Gallery.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import com.widget.snackbar.R;
import java.util.logging.*;
import java.util.*;

/*
*	Peter开发
*	Developed by Peter.
*/
public class SnackBar
{
    private Dialog snackbar;
    private Context mContext;
    
    private int defStyle;
	private int buttonColor=0;
	private int dismissTime=0;
    
	private String messageText="";
	private String buttonText="";
	
    private SnackBar.Builder mBuilder;
	//监听器
	private View.OnClickListener ButtonListener;
    //Show方法
    public SnackBar show(){
        mBuilder=new Builder();
        if(!snackbar.isShowing()){
			snackbar.show();
			SnackbarDismiss();
        }
		else{
			snackbar.dismiss();
		}
        return this;
    }
	//SnackBar消失方法
    public SnackBar dismiss(){
        snackbar.dismiss();
        return this;
    }
	
    public SnackBar(Context context){
        this.mContext=context;
        this.defStyle=R.style.CustomDialog;
    }
	//创建
    private class Builder {
        private Button button;
		private TextView mMessage;
        
        private Builder() {
            snackbar=new Dialog(mContext,defStyle);
			snackbar.setCanceledOnTouchOutside(false);
            snackbar.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND, 
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            snackbar.setContentView(R.layout.snackbar_layout);
            Window dialogWindow = snackbar.getWindow();
            DisplayMetrics d = mContext.getResources().getDisplayMetrics();
            WindowManager.LayoutParams p = dialogWindow.getAttributes(); 
            dialogWindow.setGravity(Gravity.CENTER|Gravity.BOTTOM);
            p.width =(int)(d.widthPixels*1.0);
            dialogWindow.setAttributes(p);
            setCustomView(snackbar);
        }
		//设置布局
        private void setCustomView(Dialog dialog){
			//控件实例化
			mMessage=(TextView)dialog.findViewById(R.id.snackbar_message);
            button=(Button)dialog.findViewById(R.id.snackbar_button);
			//设置Message文本
            if(messageText.isEmpty()){
				//当文本内容为空时隐藏
                mMessage.setVisibility(View.GONE);
            }
            else {
                mMessage.setText(messageText);
            }
			//设置按钮文本
			if(!buttonText.isEmpty()){
				button.setText(buttonText.toUpperCase());
				button.setVisibility(View.VISIBLE);
            }
			else{
				button.setVisibility(View.INVISIBLE);
			}
            //设置监听器
			if(ButtonListener!=null){
                button.setOnClickListener(ButtonListener);
				snackbar.dismiss();
            }
            else{
                snackbar.dismiss();
            }
			//设置按钮文本颜色
			if(buttonColor!=0){
				button.setTextColor(mContext.getResources().getColor(buttonColor));
			}
			
			
			
            
    	}
	}
	//提示消息内容方法
    public SnackBar makeText(String text,int time){
        this.messageText=text;
		this.dismissTime=time;
        return this;
    }
	//显示时间3秒
	public static int LENGTH_LONG(){
		return 3;
	}
	//显示时间2秒
	public static int LENGTH_SHORT(){
		return 2;
	}
	//设置按钮监听事件
	public SnackBar setAction(String text,final View.OnClickListener listener) {
		this.buttonText=text;
        this.ButtonListener=listener;
        return this;
    }
	//设置按钮文本颜色
	public SnackBar setActionColor(int colorId){
		this.buttonColor=colorId;
		return this;
	}
	//使文本内容大写
	public SnackBar toUpperCase(){
		messageText=messageText.toUpperCase();
		return this;
	}
	//使文本内容小写
	public SnackBar toLowerCase(){
		messageText=messageText.toLowerCase();
		return this;
	}
	//3秒后关闭
	public void SnackbarDismiss(){
		final Timer time = new Timer();
		time.schedule(new TimerTask() {
				public void run() {
					snackbar.dismiss();
					if(snackbar.isShowing()){//防止第一个即将消失时Show第二个不会关闭第二个
						time.cancel();
						snackbar.dismiss();
					}
				}
			}, dismissTime*1000); //After 2 second (or 2000 miliseconds), the task will be active.
	}
	
	
}

