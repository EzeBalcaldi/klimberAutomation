package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteClasses({Test01_HappyPathTest.class, Test02_InvalidBirthDateTest.class, Test03_NoCharactersAllowedInPhoneInputs.class})
public class TestSuite {
	
	

}
