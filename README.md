# Automation-Testing

## Cài đặt
![image](https://user-images.githubusercontent.com/57594882/138935522-3ae9318e-c2f8-438f-8618-58cdc05eeaca.png)

**Appium Client**
- Java JDK (add environment path) 
- IntelliJ

**Appium Server**
- Nodejs
- [Appium Desktop](https://github.com/appium/appium-desktop/releases/tag/v1.22.0) Appium-Server-GUI-windows-1.22.0

**Device/Emulator**
- Android Studio 
- Change "emulatorName" in src/test/java/.env to your device name.

**Support Tools**
- [Appium Inspector](https://github.com/appium/appium-inspector/releases) to get element location or hint for function needed

(_có rùi thì cập nhật bản mới nhất nhá_)
## Docs

_Sử dụng mail vnu để truy cập_

Tạp nham notes tại [Quick Testing Notes](https://docs.google.com/document/d/1_2BRRXBZ4bJV-LO5Le-BS6_TfQ8TpMnfJ1oO6k8fExY/edit?usp=sharing)

Bản final docs (_đang cập nhật dần_) [Final Notes](https://docs.google.com/document/d/1EeG0P94uLDshJy74cbZ-JBpYiVxTSWykIhEAQld0LE0/edit?usp=sharing)

## Demo

**Đảm bảo thực hiện thành công được 2 file test Calculator và SwagLab**

- Bắt đầu Appium Server
- Kết nối tới thiết bị Android (or emulator), xem đã kết nối chưa hoặc xem tên thiết bị bằng lệnh ```adb devices
- Mở project trong IntelliJ, thay đổi đường dẫn tới app và tên thiết bị deviceName (các app được lưu trong AutomationTest//src//app//)
- Ctrl Shift F10 hoặc chuột phải vào file java để thực thi test

[**Selenium Project**](https://github.com/tuananhlai/qa_remind_clone)
