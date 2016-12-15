Test suite for learnig Selenium with Java. It tests Wordld Bank site.

Information about test suite:
Test is written using Selenium version 2.53.1 
and should be launched with Firefox version 47.0.1

Plugins used - JUnit, OpenCSV.

Test is written using PageObject pattern.

Structure of the project:

src - source files for the WorldBankData testing
	--com.ok.WorldBankData.tests - Main class for our test
		--public void TC_1() - test case
	--com.ok.selenium.util - all helper classes
		--Logger.java - log file creation
		--WebUtil.java - page navigation
		--AssertUtil - my Assert
	--com.ok.WorldBankData.config
		--Browsers.java - enum, for selectiong browser to run
		--Config.java - test data, file pathes, etc.
		--Locators.java - I prefer to keep all my locators in one place, it is very convinient
	--com.ok.WorldBankData.pageobjects - all pageobjects stored here

helpers - source with general helping functions
testreports - test reports and script for clearing folder
testdata - test exports CVS with country data into this folder 
lib - all *.jar are stored here