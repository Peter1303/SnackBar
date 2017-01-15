# Material Snackbar
一个极简且仿Material Design Snackbar的库
![API](https://img.shields.io/badge/API-8%2B-brightgreen.svg?style=flat)

==========
<img src='https://github.com/Peter1303/SnackBar/blob/master/images/Screenshot_2016-08-01-12-00-47-972_com.snackbar.app.png' height='400'/> 
<img src='https://github.com/Peter1303/SnackBar/blob/master/images/Screenshot_2016-08-01-12-01-29-586_com.snackbar.app.png' height='400'/>
<img src='https://github.com/Peter1303/SnackBar/blob/master/images/Screenshot_2016-08-01-12-01-32-237_com.snackbar.app.png' height='400'/>

#[Demo下载](https://github.com/Peter1303/SnackBar/blob/master/demo/SnackBar.apk?raw=true)

##### 目前这个库还有一些问题，希望能有大神改进
- 在某些情况下Activity的界面可能不透明

##### 这个SnackBar有以下特点：
- 极简而且体积小
- 仿Material Design SnackBar
- 可更改按钮颜色

### Gradle
```groovy
compile 'com.widget.snackbar'
```

使用方法：
普通例子：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_LONG).show;
```
带有按钮事件方法：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_LONG).setAction(LISTENER).show;
```
自定义Show时间事件：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",5*1000).show;
```
2秒show：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_SHORT).show;
```
设置Action按钮颜色：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_LONG).setAction(LISTENER).setActionColor(R.id.COLOR).show;
```
您也可以使文本内容大写或者小写：
1.大写：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_LONG).toUpperCase.show;
```
2.小写：
```java
new SnackBar.makeText(YOURACTIVITY.this),"MESSAGE",SnackBar.LENGTH_LONG).toLowerCase.show;
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
