package cimillo.kata.goosegame;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"cimillo.kata.goosegame"})
@SelectClasses( { AddPlayersScenarios.class})

@Suite
@SuiteDisplayName("A Test Suite")
public class AllScenariosSuite {

}