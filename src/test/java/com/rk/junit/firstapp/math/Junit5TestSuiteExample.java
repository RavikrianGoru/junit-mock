package com.rk.junit.firstapp.math;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(CalculatorTest.class)
//@SelectPackages({ "com.rk.junit.firstapp.math" })
//@IncludePackages("")
//@IncludeClassNamePatterns("")
//@ExcludePackages("")
//@ExcludeClassNamePatterns("")
@ExcludeTags("PROD")
public class Junit5TestSuiteExample {

	//hi
}
