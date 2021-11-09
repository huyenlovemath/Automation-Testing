# Automation-Testing: Appium

## Quick Install
![image](https://user-images.githubusercontent.com/57594882/138935522-3ae9318e-c2f8-438f-8618-58cdc05eeaca.png)

**Appium Client**
- Java JDK (add environment path) 
- IntelliJ 

**Appium Server**
- Nodejs & npm for CLI appium
- Or you can download [Appium Desktop](https://github.com/appium/appium-desktop/releases/tag/v1.22.0) Appium-Server-GUI-windows-1.22.0 => you dont have to care about Nodejs and npm :V

**Other**
- Emulator and Android SDK Tools in Android Studio 

**Support Tools**
- [Appium Inspector](https://github.com/appium/appium-inspector/releases) to get element location or hint for function needed


## Demo

**Các bước**

- Bắt đầu Appium Server
- Kết nối tới thiết bị Android (or emulator), xem đã kết nối chưa hoặc xem tên thiết bị bằng lệnh ```adb devices```
- Mở project trong IntelliJ, tahy đổi emulatorName trong file /test/java/.env
- Ctrl Shift F10 hoặc chuột phải vào file java để thực thi test

**Project mẫu**

[**Selenium Project**](https://github.com/tuananhlai/qa_remind_clone)
