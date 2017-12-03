# README #

### What is this repository for? ###

* This Document is to provide the Setup to Run the test automation for ebay Application
* Version 1.0

### How do I get set up? ###

* Summary of set up
Download eclispe and open the automation project.
Add selenium jars for java and Right click on project - Build Path- Configure Build Path.
Add all selenium jars to the build path.
Download junit.jar and add it to build path.

* Configuration
Download geckodriver.exe, chromedriver.exe  and IEDriverServer.exe
Specify these paths in the elements.properties file

Go to UIFunctiona.java and specify the filepath for propertiesLocation
Save all the changes.

* How to run tests
The test browser can be modified at elements.properties file
For now Chrome and Firefox are working as expected. Some issue with IE which needs to be debugged.

Right click on EbayShoppingTest.java and run as junit test.
Once the tests have completed the browser session closes and all test data are removed from browser.
Results can be viewed in junit results window.

--------------------------------------------------