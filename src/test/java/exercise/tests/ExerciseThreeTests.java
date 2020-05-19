package exercise.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exercices.abstractions.IExercise;
import exercices.models.ExerciseThree;


public class ExerciseThreeTests extends ExerciseTwoTests {
	private final String expectedResult = "1 2 good 4 systems CMAS 7 8 CMAS systems 11 CMAS good 14 CMASsystems 16 17 CMAS 19 systems\n" + 
			"CMAS: 4\n" + 
			"good: 2\n" + 
			"systems: 3\n" + 
			"CMASsystems: 1\n" + 
			"integer: 10";

	@Override
	@ParameterizedTest
	@CsvSource({"1,20"})
	public void ProcessRange_Should_Return_Expected_String(int startNumberIncluded, int endNumberExcluded) 
	{
		IExercise exercise = new ExerciseThree();
		String result = exercise.processRange(startNumberIncluded, endNumberExcluded);
		assertEquals(expectedResult, result);
	}
	



}
