package com.snackbar.app;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import com.widget.snackbar.*;

public class MainActivity extends Activity implements OnClickListener
{
	Button EditTextShow,show,shortShow,withoutButton,BlueButton;
	EditText editText;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		setTheme(android.R.style.Theme_DeviceDefault_Light);
		
		editText=(EditText)findViewById(R.id.mainEditText);
		EditTextShow=(Button)findViewById(R.id.mainSHOW);
		show=(Button)findViewById(R.id.show);
		shortShow=(Button)findViewById(R.id.showLENGTH_SHORT);
		withoutButton=(Button)findViewById(R.id.showSnackBarWithoutButton);
		BlueButton=(Button)findViewById(R.id.showSnackBarWithBlueButton);
		
		EditTextShow.setOnClickListener(this);
		show.setOnClickListener(this);
		withoutButton.setOnClickListener(this);
		BlueButton.setOnClickListener(this);
		shortShow.setOnClickListener(this);
		
		
		
		
    }
	
	@Override
	public void onClick(View v)
	{
		switch(v.getId()){
			case R.id.mainSHOW:
				String text=editText.getText().toString();
				if(!text.isEmpty()){
					new SnackBar(MainActivity.this).makeText(text,SnackBar.LENGTH_LONG()).show();
				}
				else{
					new SnackBar(MainActivity.this).makeText("Empty :(",SnackBar.LENGTH_LONG()).show();
				}
				break;
			case R.id.show:
				new SnackBar(MainActivity.this).makeText("这是一个SnackBar :)",SnackBar.LENGTH_LONG()).setAction("事件",new OnClickListener(){

						@Override
						public void onClick(View p1)
						{
							new SnackBar(MainActivity.this).makeText("按下后的监听事件 :)",SnackBar.LENGTH_LONG()).show();
						}
					}).show();
				break;
			case R.id.showLENGTH_SHORT:
				new SnackBar(MainActivity.this).makeText("2秒后消失 :)",SnackBar.LENGTH_SHORT()).show();
				break;
			case R.id.showSnackBarWithoutButton:
				new SnackBar(MainActivity.this).makeText("没有按钮的SnackBar :)",SnackBar.LENGTH_LONG()).show();
				break;
			case R.id.showSnackBarWithBlueButton:
				new SnackBar(MainActivity.this).makeText("蓝色的按钮",SnackBar.LENGTH_LONG()).setAction("确定",new OnClickListener(){

						@Override
						public void onClick(View p1)
						{
							
						}
					}).setActionColor(R.color.textBlue).show();
				break;
			
		}
	}
	
}
