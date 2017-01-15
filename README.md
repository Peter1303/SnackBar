# MaterialDialog
一个极简且仿Material Design AlertDialog的库
![API](https://img.shields.io/badge/API-8%2B-brightgreen.svg?style=flat)

==========
<img src='https://github.com/Peter1303/MaterialDialog/blob/master/arts/Screenshot_2017-01-14-08-27-42-467_com.dialog.app.png' height='400'/> 
<img src='https://github.com/Peter1303/MaterialDialog/blob/master/arts/Screenshot_2017-01-14-08-27-45-730_com.dialog.app.png' height='400'/>
<img src='https://github.com/Peter1303/MaterialDialog/blob/master/arts/Screenshot_2017-01-14-08-27-38-856_com.dialog.app.png' height='400'/>

#[Demo下载](https://github.com/Peter1303/MaterialDialog/blob/master/app/build/bin/app.apk?raw=true)

##### 这个SnackBar有以下特点：
- 极简而且体积小
- 仿Material Design
- 可更改按钮颜色

### Gradle
```groovy
compile 'peter1303.material.MaterialDesignDialog'
```

使用方法：

```java
final MaterialDialog alert=new MaterialDialog(MainActivity.this);
					alert.setTitle("标题")
					.setMessage("消息")
					.setPositiveButton("确定", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								alert.dismiss();
							}
						})
                  .setNegativeButton("取消", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								alert.dismiss();
							}
						})
                  .setNeutralButton("第三个", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								
							}
						})
                  .show();
```
自定义List方法：
```java
List<String>list = new ArrayList<String>();
					for(int i=0;i<10;i++){
						list.add("item"+i);
					}
					MaterialDialog alert=new MaterialDialog(MainActivity.this);
					alert.setTitle("标题")
					.setItems(list, new ListView.OnItemClickListener(){

							@Override
							public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
							{
								Toast.makeText(MainActivity.this,""+p3,Toast.LENGTH_LONG).show();
							}
						})
					.setItemsLongClick(new ListView.OnItemLongClickListener(){

							@Override
							public boolean onItemLongClick(AdapterView<?> p1, View p2, int p3, long p4)
							{
								Toast.makeText(MainActivity.this,"long "+p3,Toast.LENGTH_LONG).show();
								return false;
							}
						})
					.setPositiveButton("确定", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
							}
						})
					.setNegativeButton("取消", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
							}
						});
```

设置第三个Action按钮方法：
```java
alert.setNeutralButton("第三", new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
							}
						})
					.show();
```

#### License
<pre>
Copyright 2016 Peter&DevelopTeam

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
