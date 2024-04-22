package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import test.Test01_HappyPath;
import test.Test02_InvalidBirthDate;
import test.Test03_NoCharactersAllowedInPhoneInputs;
import test.Test04_DisallowUnderAndOverAgeRegistration;
import test.Test05_SaveButtonEnabledAfterProvinceSelection;

import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteClasses({Test01_HappyPath.class, Test02_InvalidBirthDate.class, Test03_NoCharactersAllowedInPhoneInputs.class, Test04_DisallowUnderAndOverAgeRegistration.class, Test05_SaveButtonEnabledAfterProvinceSelection.class})
public class TestSuite {

}
