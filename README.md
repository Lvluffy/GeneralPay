# GeneralPay
通用支付

## gradle使用：

一、Project下的build.gradle文件下添加

allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}

二、Module下的build.gradle文件下添加

dependencies {
          compile 'com.github.Lvluffy:GeneralPay:1.0.0'
}

或者

dependencies {
          implementation 'com.github.Lvluffy:GeneralPay:1.0.0'
}

## 录屏
![xlu44-w3qwd](https://user-images.githubusercontent.com/34730376/56400355-150faf80-6286-11e9-82a9-21126cd509dc.gif)

