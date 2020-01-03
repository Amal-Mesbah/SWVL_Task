# SWVL_Task
Java-Appium-Android
##Steps To Run the automation project
1. Install Java Development Kit (JDK)-
The Java Software Development Kit (Java SDK or JDK) is an application created by Sun Microsystems to create and modify Java programs.To install that  go to THIS [LINK](https://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html). Download the latest version of java and install it.

2. Setup Java Environmental Variable Path  -
Go to to Start Menu and search for 'Environmental variable' and click on it. Then Click on Environmental variable and add New System Variable with variable name as JAVA_HOME and classpath as your jdk path

3. Install Eclipse
Download Eclipse from This [LINK](https://www.eclipse.org/downloads/) .
Click on .exe file.

4. Download and Install Appium sever
Download Appium Server from this [Link](https://github.com/appium/appium-desktop/releases/tag/v1.0.2-beta.2)
Click on .exe file.

5. Download android SDK tools from [Here](https://developer.android.com/studio/?gclid=Cj0KCQiAxrbwBRCoARIsABEc9sj94uiklKHCE_u9n7tJX6tTONHyw5FPC6nj5daY-3foRxmLahB9iwoaAjGVEALw_wcB) in the command line tools part at the bottom of screen, then using sdk manager download the required packages (Platform-tools, Platforms,Build-tools).
Then set invironment variables for ANDROID_HOME as the path of the sdk folder and Add in path vriable the following (%ANDROID_HOME%/platform-tools,%ANDROID_HOME%/tools,%ANDROID_HOME%/build-tools,%ANDROID_HOME%/tools/bin)

6. Connect a real device and from developer options mode select usb debugging as on then open CMD and type the command "adb devices" and it should detect the mobile UDID.

7. Start Appium server.

8. Clone the Project from the current Repository and import it into eclipse and run the project AppTest.java.

##Before you run the Project

Make sure you provide all input test data to main function :)



